package ca.qc.cgodin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


// ===== DB MANAGER =======
public class AnnManager {

	String login = "student";
	String pswd = "cgodin2018";
	Connection conn = null;
	
	public AnnManager() {	
	 String finalURL="";
	 String UrlSch="";
	 int Port=0;
	 int CustPort=0;
	 
		 try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(finalURL, login, pswd);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public String DBurl(String servType, String servAddr, String DBname, int CustPort, Boolean ssl ) {
		
			String finalURL="";
			String UrlSch = "jdbc:mysql://";
			servAddr = ((servAddr==null)?"localhost":servAddr);
			int Port = ( (CustPort==0)?3306:CustPort);
		
		return UrlSch + servAddr +":"+ Port +"/"+ DBname +"?useSSL="+ssl+"&serverTimezone=UTC";
		
	}
	
// =========== GET ANNONCES LIST ============	
	public List<Annonce> getAnnonceList() throws SQLException
	{		
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

	public int addAnnonce(Annonce ann){
		Statement stmt = null;
		int result=0;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			String UserID = ""+ann.getUserID();
			String title= ann.getTitre();
			String desc = ann.getDescription();
			String cat = ann.getCategory();
			Double amnt = ann.getAmount();
			Timestamp ts = ann.getCreationTS();
			
			String query = "INSERT INTO Annonce ( UserID, Title, Description, Category, Amount, CreationTS)" + 
							"VALUES ("+ sQuotes(UserID) + "," + sQuotes(title) + "," + sQuotes(desc) + "," + sQuotes(cat) + "," + amnt + "," + sQuotes(ts)+")";
			result=stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String arrayToSQL(String ann[]) {
		String sql="";
		int i=0;
		do {
			sql+= sQuotes(ann[i]) + ", ";
		} while(i < ann.length);
		
		return sql;
	}
	
	public String sQuotes(String txt) {
		return "'" + txt + "'";
	}


	public void addAnnonce(int userId, String titre, String desc, String cat, Double amnt) {
		// TODO Auto-generated method stub
		
	}
	
	
}

