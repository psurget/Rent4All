package ca.qc.cgodin.model;

public class DBurl {
	
	private String servType;
	private String UrlSch;
	private String DBname;
	private String servAddr;
	private int port;
	private int CustPort;
	private Boolean SSL;
	

	public DBurl( String ServType, String ServAddr, String dbName, int custPort, boolean ssl ) 
	{	
			switch(ServType){
				case "mysql":
					UrlSch = "jdbc:mysql://";
					servAddr = ((ServAddr==null)?"localhost":ServAddr);
					port = ( (custPort==0)?3306:custPort); //int ne peut etre vide
					SSL = ssl;
					break;
			
				case "mssql":
					UrlSch = "jdbc:mssql://";
					servAddr = ((servAddr==null)?"localhost":servAddr);
					port = ( (CustPort==0)?1433:CustPort);
					SSL = ssl;
					break;
			}
	}	
	
	public String getUrlSch() {
		return UrlSch;
	}

	public void setUrlSch(String urlSch) {
		UrlSch = urlSch;
	}

	public String getDBname() {
		return DBname;
	}

	public void setDBname(String dBname) {
		DBname = dBname;
	}

	public String getServAddr() {
		return servAddr;
	}

	public void setServAddr(String servAddr) {
		this.servAddr = servAddr;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getCustPort() {
		return CustPort;
	}

	public void setCustPort(int custPort) {
		CustPort = custPort;
	}

	public Boolean getSSL() {
		return SSL;
	}

	public void setSSL(Boolean ssL) {
		SSL = ssL;
	}

	public String getServType() {
		return servType;
	}


	public void setServType(String servType) {
		this.servType = servType;
	}
	
	@Override
	public String toString(){
		return  UrlSch + servAddr + ":" + port + "/" + DBname + "?useSSL=" + SSL + "&serverTimezone=UTC";
	}
	
}

