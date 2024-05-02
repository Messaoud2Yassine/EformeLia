package spring.security.jwt.controllers;
import spring.security.jwt.models.Form;
import spring.security.jwt.repository.FormRepository;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/forms")
public class FormController {

    private final FormRepository formRepository;

    
    public FormController(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    @PostMapping("/create")
    public Form createForm(@RequestBody Form form) {
        return formRepository.save(form);
    }

    @GetMapping("/{id}")
    public Form getFormById(@PathVariable("id") String id) {
        return formRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Form updateForm(@PathVariable("id") String id, @RequestBody Form form) {
        Form existingForm = formRepository.findById(id).orElse(null);
        if (existingForm != null) {
            existingForm.setName(form.getName());
            // Update other properties as needed
            return formRepository.save(existingForm);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable("id") String id) {
        formRepository.deleteById(id);
    }
    @GetMapping("/all")
    public List<Form> getAllForms() {
        return formRepository.findAll();
    }
}
