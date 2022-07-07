package javacodes;
import java.io.Serializable;
import java.util.Comparator;

public class LoginBean implements Serializable, Comparable<LoginBean>{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int compareTo(LoginBean L1)  
	{	
		 return this.username.compareTo(L1.getUsername());
	}

}
