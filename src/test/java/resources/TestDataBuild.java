package resources;

import pojo.createUser;
import pojo.userAddress;

public class TestDataBuild {

	public createUser createUserPayload(String user_first_name, String user_last_name, String user_contact_number, String  user_email_id, String plotNumber, String Street, String state, String Country, String zipCode )
	{
		createUser user = new createUser();
		user.setuser_first_name(user_first_name);
		user.setUser_last_name(user_last_name);
		user.setUser_contact_number(user_contact_number);
		user.setUser_email_id(user_email_id);
		userAddress userAddr = new userAddress();
		
		userAddr.setPlotNumber(plotNumber);
		userAddr.setStreet(Street);
		userAddr.setState(state);
		userAddr.setCountry(Country);
		userAddr.setZipCode(zipCode);
		
		user.setUserAddress(userAddr);
		return user;
	}
}
