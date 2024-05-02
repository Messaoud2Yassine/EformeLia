package spring.security.jwt.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.security.jwt.models.InputField;
import spring.security.jwt.models.InputValue;
import spring.security.jwt.repository.InputFieldRepository;
import spring.security.jwt.repository.InputValueRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/inputValues")
public class InputValueController {

private final InputValueRepository inputValueRepository;
private final InputFieldRepository inputFieldRepository;
    public InputValueController(InputValueRepository inputValueRepository,InputFieldRepository inputFieldRepository) {
    this.inputValueRepository = inputValueRepository;
    this.inputFieldRepository = inputFieldRepository;
}

    @PostMapping("/create")
    public InputValue createInputValue(@RequestBody InputValue inputValue) {
         inputValueRepository.save(inputValue);
        List<InputField> inputFields = inputFieldRepository.findAll();
        for (InputField inputField : inputFields) {
           if (inputField.getInputValues().get(0).getInputValueId().equals(inputValue.getInputValueId())){
                inputField.getInputValues().add(inputValue);
                inputFieldRepository.save(inputField);
           }
        }
        return inputValue;
    }
    @GetMapping("/{iVId}/{uId}")
    public String getInputValueById(@PathVariable String iVId,@PathVariable String uId) {
        if (iVId == null || uId == null) {
            throw new IllegalArgumentException("Both iVId and uId must be provided");
            
        }
        else {        
        return inputValueRepository.findByInputValueIdIdInputValueAndInputValueIdIdUser(iVId, uId).getInputValue();
        }
    }
}
