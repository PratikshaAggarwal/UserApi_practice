package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true)) ;
		
		BasicAuthScheme basicAuthScheme = new BasicAuthScheme();
		basicAuthScheme.setUserName(getGlobalValue("userName"));
		basicAuthScheme.setPassword(getGlobalValue("passWd"));
		
		if(req == null)
		{
		 req =	new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType(ContentType.JSON)
				 .setAuth(basicAuthScheme)
			.build();
		 return req;
		}
		 return req;
	}
	
	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop = new Properties() ;
		FileInputStream fis = new FileInputStream("C:\\Users\\darpa\\eclipse-workspace\\RestApi\\UserApi\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
		
	}
	
	
}
