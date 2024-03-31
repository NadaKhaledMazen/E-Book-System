/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

/**
 *
 * @author nadam
 */
public abstract class User implements BooKMangment 
{
    	private String UserName;
	private String Password;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public User()
	{
		
	}
	public User(String userName, String password) {
		UserName = userName;
		Password = password;
	}
	public User(User U) {
		super();
		UserName = U.UserName;
		Password = U.Password;
	}

}
