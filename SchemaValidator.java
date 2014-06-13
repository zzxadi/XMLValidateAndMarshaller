package com.cqfc.access.util;

import java.io.InputStream;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class SchemaValidator {

	public static boolean validate(InputStream xsd, String xmlstr) {
		try {
			SchemaFactory factory = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new StreamSource(xsd));
			Validator validator = schema.newValidator();
			StringReader reader = new StringReader(xmlstr);
			validator.validate(new StreamSource(reader));
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
