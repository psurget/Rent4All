package ca.qc.cgodin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// ===== DB MANAGER =======
public class AnnonceManager {
	String UrlSch = "jdbc:mysql://";
	String servAdd = "localhost";
	String login = "student";
	String pswd = "cgodin2018";
	int port;
	Connection conn = null;
	
	public AnnonceManager() {
		//String dbUrl = UrlSch + servAdd +":3306/rent4all?useSSL=false&serverTimezone=UTC";
		String dbUrl = DBConn("mysql","", "rent4all", 0, false);
						    // servType, servAddr, DBName, CustmPort, boolean SSL
		try {
			conn = DriverManager.getConnection(dbUrl,login, pswd);
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
	public List<Annonce> getAnnonceList() throws SQLException{
		
		List<Annonce> Ann_list = null;
		Statement stmt = null;
		String query="SELECT * FROM Annonce "
				+ 	" Where Statut='actif' "
				+ 	" Order By CreationTS Desc";
		
		try {
			stmt=conn.createStatement();
			ResultSet res=stmt.executeQuery(query);
			
			while (res.next()) {
				if(Ann_list == null)
					Ann_list = new ArrayList<Annonce>();

				Annonce a = new Annonce();
				a.setUserID(res.getInt("UserID"));
				a.setTitre(res.getString("Title"));
				a.setCategory(res.getString("Category"));
				a.setAmount(res.getDouble("Amount"));
				a.setDescription(res.getString("Description"));
				a.setCreationTS(res.getTimestamp("CreationTS"));
				a.setModifTS(res.getTimestamp("ModificationTS"));
				Ann_list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Ann_list;
	}


}
