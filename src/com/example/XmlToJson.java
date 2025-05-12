package com.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;
import org.json.XML;



public class XmlToJson {
	public static void main(String[] args) {
		File xmlFile = new File("C:\\Users\\DT-BSIT-005\\eclipse-workspace\\XmlToJson\\src\\com\\example\\xmlFile.xml");
		File jsonFile = new File(
				"C:\\Users\\DT-BSIT-005\\eclipse-workspace\\XmlToJson\\src\\com\\example\\jsonFile.json");

		boolean present = xmlFile.exists();
		boolean jsonPresent = jsonFile.exists();
		if (present == false) {
			try {
				boolean created = xmlFile.createNewFile();
				System.out.println(created);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (jsonPresent == false) {
			try {
				boolean created = jsonFile.createNewFile();
				System.out.println("Json file created" + created);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (FileReader reader = new FileReader(xmlFile); 
			FileWriter writer = new FileWriter(jsonFile)) {
			StringBuilder xmlContent = new StringBuilder();
			int ch;
			while ((ch = reader.read()) != -1) {
				xmlContent.append((char) ch);
			}
			JSONObject jsonObject = XML.toJSONObject(xmlContent.toString());
			writer.write(jsonObject.toString(4));
			System.out.println("Converted XML to JSON successfully.");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}