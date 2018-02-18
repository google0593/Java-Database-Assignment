import java.sql.*;
import javax.swing.*;
public class sqlConnection {
	Connection conn=null;
	public static Connection dbConnector()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");/*https://bitbucket.org/xerial/sqlite-jdbc/downloads*/
			Connection conn=DriverManager.getConnection("jdbc:sqlite:Resources/AucklandHRM.sqlite");
			System.out.println("SQL CONNECTED");
			return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}