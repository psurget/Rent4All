package ca.qc.cgodin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// ===== DB MANAGER =======
public class DBManager {
	String UrlSch = "jdbc:mysql://";
	String servAdd = "localhost";
	String login = "student";
	String pswd = "cgodin2018";
	int port;
	Connection con = null;
	
	public DBManager() {
		//String dbUrl = UrlSch + servAdd +":3306/rent4all?useSSL=false&serverTimezone=UTC";
		String dbUrl = DBConn("mysql","", "rent4all", 0, false);
						    // servType, servAddr, DBName, CustmPort, bool SSL
		try {
			con = DriverManager.getConnection(dbUrl,login, pswd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			/*********************************************/
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			/*********************************************/
			con = DriverManager.getConnection(dbUrl, login, pswd);
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

	
	public String DBConn(String servType, String servAddr, String DBname, int CustPort, Boolean ssl ) {
		switch(servType){
			case "mysql":
				UrlSch = "jdbc:mysql://";
				servAddr = ((servAddr==null)?"localhost":servAddr);
				port = ( (CustPort==0)?3306:CustPort);
				break;
		
			case "mssql":
				UrlSch = "jdbc:mssql://";
				servAddr = ((servAddr==null)?"localhost":servAddr);
				port = ( (CustPort==0)?1433:CustPort);
				break;
		}
		
		return UrlSch + servAddr +":"+ port +"/"+ DBname +"?useSSL="+ssl+"&serverTimezone=UTC";
		
	}
	
// =========== GET ANNONCES LIST ============	
	public List<Annonce> getAnnonceList(){
		List<Annonce> Ann_list = null;
		
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT * FROM Annonce Where Statut='actif' Order By CreationTS Desc");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (res.next()) {
				if (Ann_list == null) {
					Ann_list = new ArrayList<Annonce>();
				}
				Annonce a = new Annonce();
				a.setUserID(res.getInt("userID"));
				a.setTitre(res.getString("titre"));
				a.setCategory(res.getString("category"));
				a.setAmount(res.getDouble("amount"));			
				Ann_list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Ann_list;
	}

// ======== ADD USER ========	
	public int addUser(String email, int userID, String fname, String lname, String pswd, String phone ) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String request = "INSERT INTO User (LastName, FirstName, Email, Phone, Password, Statut) VALUES"+
						"('"+ lname + "','" + fname + "','" + email + "','" + phone + "','" + pswd + "')";
		
		int affectedRows = 0;
		try {
			affectedRows =  stmt.executeUpdate(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

// ========== DELETE A USER ==========	
	public int deleteUser(int userID) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String request = "DELETE FROM User WHERE userID = "+ userID;
		
		int affectedRows = 0;
		try {
			affectedRows =  stmt.executeUpdate(request);
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
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String request = "UPDATE User SET Email='"+ email + "', FirstName='"+fname+"', LastName='" + lname + "', Password='"+pswd+"', Phone='"+phone+"' WHERE UserID="+ userID;
		
		int affectedRows = 0;
		try {
			affectedRows =  stmt.executeUpdate(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affectedRows;
	}
}
