package javacodes;
import java.sql.*;

public class SignUpDao {

	public boolean addUser(LoginBean loginBean, UserBean uBean) throws Exception, SQLException {
		boolean status1 = false, status2 = false;
		int status;
		Connection connection;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Deepshi1302");
			System.out.println(connection.isClosed());
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into employees values(?,?,?,?,?,?,?)");
			preparedStatement.setString(1, uBean.getName());
			preparedStatement.setString(2, uBean.getAge());
			preparedStatement.setString(3, uBean.getDob());
			preparedStatement.setString(4, uBean.getDesg());
			preparedStatement.setString(5, uBean.getPhn());
			preparedStatement.setString(6, uBean.getEmail());
			preparedStatement.setString(7, uBean.getDoj());
			status = preparedStatement.executeUpdate();
			if (status != 0)
				status1 = true;
			
			if (status1) {
				PreparedStatement preparedStatement1 = connection.prepareStatement("insert into logincreds values(?,?,?,?,?)");
				preparedStatement1.setString(1, uBean.getName());
				preparedStatement1.setString(2, uBean.getDesg());
				preparedStatement1.setString(3, uBean.getPhn());
				preparedStatement1.setString(4, loginBean.getUsername());
				preparedStatement1.setString(5, loginBean.getPassword());
				status = preparedStatement1.executeUpdate();
				if (status != 0)
					status2 = true;
			}
				
			

			if (status2 == false) {
				PreparedStatement preparedStatement2 = connection.prepareStatement("delete from employees where name=? and Phone_No=?");
				preparedStatement2.setString(1, uBean.getName());
				preparedStatement2.setString(2, uBean.getPhn());
				status = preparedStatement2.executeUpdate();
				if(status != 0)
					status1 = false;
			}

			System.out.println(status1 + " " + status2);
			return (status1 && status2);
		}

		catch (Exception e) {
			System.out.println(e);
			if (status2 == false) {
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Deepshi1302");
				PreparedStatement preparedStatement2 = connection.prepareStatement("delete from employees where name=? and Email_Id=?");
				preparedStatement2.setString(1, uBean.getName());
				preparedStatement2.setString(2, uBean.getEmail());
				status = preparedStatement2.executeUpdate();
				if(status != 0)
					status1 = false;
				connection.close();
			}
		}		
		System.out.println(status1 + " " + status2);
		return false;
	}

}
