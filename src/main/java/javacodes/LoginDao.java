package javacodes;
import java.sql.*;
import java.util.*;



public class LoginDao{
	
	public static Map<LoginBean, String> LoggedInEmpsTime = new LinkedHashMap<LoginBean, String>();
	public static Map<LoginBean, String> LoggedInEmpsDesg = new LinkedHashMap<LoginBean, String>();
	public static List<String> LoggedIn = new ArrayList<String>();
		
	public int validate(LoginBean loginBean) throws Exception 
	{	boolean status = false; 
		 
		
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver"); 
			 Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Deepshi1302");  
			 //System.out.println(connection.isClosed());
			 PreparedStatement preparedStatement = connection.prepareStatement ("select * from logincreds where username = ? and password = ?");  
			 preparedStatement.setString(1, loginBean.getUsername()); 
			 preparedStatement.setString(2, loginBean.getPassword()); 
			 //System.out.println(preparedStatement.toString()); 
			 ResultSet rs = preparedStatement.executeQuery(); 
			 //System.out.println(rs.toString());
			 status = rs.next(); 
			//System.out.println(status);
			 String desg = rs.getString("Designation");
			 String name = rs.getString("Name");
			 if(LoggedIn.contains(name)) {
				 System.out.println("true");				 
				 return 2;   //already logged in				 
			 }			 
			 else if (status){
			 addLoggedIn(loginBean, desg, name);
			 displayLoggedIn();			 
			 return 1;  //login success
			 }
		 } 
		 catch (Exception e) 
		 { System.out.println(e); } 
		 return 0;  //login failure
	} 
	
	public void addLoggedIn(LoginBean lBean, String desg, String name)
	{	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		LoggedInEmpsTime.put(lBean, timestamp.toString());	
		LoggedInEmpsDesg.put(lBean,desg);
		LoggedIn.add(name);
	}
	
	public void displayLoggedIn() {
		System.out.println("\t\tLOGGED IN EMPLOYEES");
		for (Map.Entry<LoginBean, String> e : LoggedInEmpsTime.entrySet()) {
			System.out.println("Employee " + e.getKey().getUsername() + " who works as " +
					LoggedInEmpsDesg.get(e.getKey()) +" logged in at " + e.getValue());
		}
		System.out.println("\n" + LoggedIn.toString());
	}
	
	

}
