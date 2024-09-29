package resources;

public enum ApiResources {
	CreateUserApi("/createusers"),
	getAllUsersApi("/users"),
	getUserById("/user/"),
	getUserByFirstNameApi("/users/username/"),
	UpdateUserApi("/updateuser/"),
	delUserByIdApi("/deleteuser/"),
	delUserByFirstNameApi("/deleteuser/username/");
	
	private String resource;
	ApiResources(String resource)
	{
		this.resource  = resource ;
	}
	
	public String getResource()
	{
		return resource;
	}
}
