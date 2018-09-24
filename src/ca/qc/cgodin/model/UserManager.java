package ca.qc.cgodin.model;

import java.sql.Connection;
import ca.qc.cgodin.model.User;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


// ===== DB MANAGER =======
public class UserManager {
	String UrlSch = "jdbc:mysql://";
	String servAdd = "localhost";
	String login = "student";
	String pswd = "cgodin2018";
	int port;
	Connection conn = null;

	public UserManager() {
		// String dbUrl = UrlSch + servAdd
		// +":3306/rent4all?useSSL=false&serverTimezone=UTC";
		String dbUrl = DBConn("mysql", "", "rent4all", 0, false);
		// servType, servAddr, DBName, CustmPort, boolean SSL
		try {
			conn = DriverManager.getConnection(dbUrl, login, pswd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			/*********************************************/
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			/*********************************************/
			conn = DriverManager.getConnection(dbUrl, login, pswd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String DBConn(String servType, String servAddr, String DBname, int CustPort, Boolean ssl) {
		switch (servType) {
		case "mysql":
			UrlSch = "jdbc:mysql://";
			servAddr = ((servAddr == null) ? "localhost" : servAddr);
			port = ((CustPort == 0) ? 3306 : CustPort);
			break;

		case "mssql":
			UrlSch = "jdbc:mssql://";
			servAddr = ((servAddr == null) ? "localhost" : servAddr);
			port = ((CustPort == 0) ? 1433 : CustPort);
			break;
		}

		return UrlSch + servAddr + ":" + port + "/" + DBname + "?useSSL=" + ssl + "&serverTimezone=UTC";

	}

// ======= GET USER INFOS =========
	public User getUserInfos(String email){
		Statement stmt = null;
		User u = new User();
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet res = null;
		String query = "SELECT * FROM users WHERE Email=" + sQuotes(email);
		try {
			res = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (res.next()) {
				u.setFirstName(res.getString("UserID"));
				u.setLastName(res.getString("LastName"));
				u.setLastName(res.getString("FirstName"));
				u.setEmail(res.getString("Email"));
				u.setPhone(res.getString("Phone"));
				u.setStatus(res.getString("Statut"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

// ======== LIST USERS ======
	public List<User> getAllUsers(){
		List<User> users_list = null;
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT * FROM users");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (res.next()) {
				if (users_list == null) {
					users_list = new ArrayList<User>();
				}
				User u = new User();
				u.setFirstName(res.getString("FirstName"));
				u.setLastName(res.getString("LastName"));
				u.setEmail(res.getString("Email"));
				u.setPhone(res.getString("Phone"));
				u.setStatus(res.getString("Statut"));

				users_list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users_list;
	}

// ======== ADD USER ========	
	public int addUser(String email, int userID, String fname, String lname, String pswd, String phone) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String request = "INSERT INTO Users (LastName, FirstName, Email, Phone, Password, Statut) "
						+ "VALUES ('" + lname + "','" + fname + "','" + email + "','" + phone + "','" + pswd + "')";

		int affectedRows = 0;
		try {
			affectedRows = stmt.executeUpdate(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

// ========== DELETE A USER ==========	
	public int deleteUser(int userID) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String request = "DELETE FROM Users WHERE userID = " + userID;

		int affectedRows = 0;
		try {
			affectedRows = stmt.executeUpdate(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affectedRows;
	}

//========== UPDATE A USER ===========	
	public int updateUser(String email, int userID, String fname, String lname, String pswd, String phone) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String request = "UPDATE Users SET Email='" + email + "', FirstName='" + fname + "', LastName='" + lname
				+ "', Password='" + pswd + "', Phone='" + phone + "' WHERE UserID=" + userID;

		int affectedRows = 0;
		try {
			affectedRows = stmt.executeUpdate(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affectedRows;
	}
	
// ========== LOGIN VALIDATION ==============
	public boolean IsValid(String email, String pswd) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet res = null;
		String query = "SELECT * from users Where Email=" + sQuotes(email) + " and Password=" + sQuotes(pswd);
		try {
			res = stmt.executeQuery(query);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return (res!=null);
	}
	
		
	public String sQuotes(String txt) {
		return "'" + txt + "'";
	}
	
}
