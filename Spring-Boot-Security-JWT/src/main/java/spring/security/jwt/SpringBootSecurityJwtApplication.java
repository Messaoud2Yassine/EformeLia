package spring.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring.security.jwt.models.Bloc;
import spring.security.jwt.models.Form;
import spring.security.jwt.models.InputField;
import spring.security.jwt.models.InputValue;
import spring.security.jwt.models.InputValueId;
import spring.security.jwt.models.Line;
import spring.security.jwt.models.Tab;
import spring.security.jwt.repository.BlocRepository;
import spring.security.jwt.repository.FormRepository;
import spring.security.jwt.repository.InputFieldRepository;
import spring.security.jwt.repository.InputValueRepository;
import spring.security.jwt.repository.LineRepository;
import spring.security.jwt.repository.TabRepository;

@SpringBootApplication
public class SpringBootSecurityJwtApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}
	@Autowired
	private InputFieldRepository inputFieldRepository;
	@Autowired
	private LineRepository lineRepository;
	@Autowired
	private BlocRepository blocRepository;
	@Autowired
	private TabRepository tabRepository;
	@Autowired
	private FormRepository formRepository;
	@Autowired
	private InputValueRepository inputValueRepository;

	@Override
	public void run(String... args) throws Exception {
		InputValue inputValue = new InputValue(new InputValueId(),null);
		List <InputValue> ListInputValue = new ArrayList<InputValue>();
		ListInputValue.add(inputValue);
		InputValue inputValue2 = new InputValue(new InputValueId(),null);
		List <InputValue> ListInputValue2 = new ArrayList<InputValue>();
		ListInputValue2.add(inputValue2);
		InputField inputField = new InputField("1","nomOfficiel","Nom officiel","Nom", "text",ListInputValue );
		InputField inputField2 = new InputField("2","siret","numéro siret","exp : 0123456789", "number", ListInputValue2);
		List <InputField> ListinputField = new ArrayList<InputField>();
		ListinputField.add(inputField);
		ListinputField.add(inputField2);
		Line line = new Line("1","Line 1",ListinputField);
		List <Line> ListLine = new ArrayList<Line>();
		ListLine.add(line);
		Bloc bloc = new Bloc("1","Bloc 1",ListLine);
		List <Bloc> ListBloc = new ArrayList<Bloc>();
		ListBloc.add(bloc);
		Tab tab = new Tab("1","Tab 1",ListBloc);
		List <Tab> ListTab = new ArrayList<Tab>();
		ListTab.add(tab);
		Form form = new Form("1","Form 1",ListTab);
		inputValueRepository.save(inputValue);
		inputValueRepository.save(inputValue2);
		inputFieldRepository.save(inputField);
		inputFieldRepository.save(inputField2);
		lineRepository.save(line);
		blocRepository.save(bloc);
		tabRepository.save(tab);
		formRepository.save(form);
		System.out.println(form);
	}

}
