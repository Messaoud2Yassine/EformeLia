package spring.security.jwt.controllers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import spring.security.jwt.models.Bloc;
import spring.security.jwt.models.Form;
import spring.security.jwt.models.InputField;
import spring.security.jwt.models.Line;
import spring.security.jwt.models.Tab;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping("/api/flux")
public class FluxController {
     @PostMapping("/update-xml")
    public ResponseEntity<String> updateXml(@RequestBody Form formData) {
        try {
            // Load XML file
            File xmlFile = new File("C:/dev-pfe/fluxtest.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Update XML elements based on formData
            for (Tab tab : formData.getTabs()){
                for (Bloc bloc : tab.getBlocs()){
                    for (Line line : bloc.getLines()){
            for (InputField field : line.getInputFields()) {
                NodeList nodeList = doc.getElementsByTagName(field.getName());
                if (nodeList.getLength() > 0) {
                    Element element = (Element) nodeList.item(0);
                    element.setTextContent(field.getInputValues().get(0).getInputValue());
                }
            } }
        }
    }

            // Write the updated XML back to the file system
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);

            return ResponseEntity.ok("XML updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error updating XML: " + e.getMessage());
        }
    }

    
}
