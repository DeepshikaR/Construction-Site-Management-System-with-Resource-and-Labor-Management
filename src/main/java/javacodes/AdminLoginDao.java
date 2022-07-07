package javacodes;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class AdminLoginDao extends LoginDao{
	
	public boolean validateAdmin(LoginBean lBean) throws Exception{
		boolean status = false;
		
		if(lBean.getUsername().equals("admin") && lBean.getPassword().equals("admin123"))
			status = true;		
		
		return status;
		
	}
	
	public static ArrayList<String> getLoggedInTime() {
		ArrayList<String> listEmps = new ArrayList<String>();
		for (Map.Entry<LoginBean, String> e : LoggedInEmpsTime.entrySet()) {
			String s = "Employee " + e.getKey().getUsername() + " who works as " +
					LoggedInEmpsDesg.get(e.getKey()) +" logged in at " + e.getValue();
			//System.out.println(s);
			listEmps.add(s);
		}
		return listEmps;
	}
	
	public static ArrayList<String> getLoggedInTimeAlpha() {
		ArrayList<String> listEmps = new ArrayList<String>();
		
		TreeMap<LoginBean, String> sorted = new TreeMap<>();
		sorted.putAll(LoggedInEmpsTime);
				System.out.println(sorted.toString());
		for (Map.Entry<LoginBean, String> e : sorted.entrySet()) {
			String s = "Employee " + e.getKey().getUsername() + " who works as " +
					LoggedInEmpsDesg.get(e.getKey()) +" logged in at " + e.getValue();
			//System.out.println(s);
			listEmps.add(s);
		}
		return listEmps;
	}

}
