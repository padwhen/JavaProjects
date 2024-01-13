package data_access;

public class ConnectionParameters {
	public static final String username = "";
	public static final String password = "";
	
	public static final String jdbcDriver = "org.sqlite.JDBC";
	public static final String projectName = "Examples";
	public static final String databaseFolder = "databases";
	public static final String databaseName = "StudentDatabase.sqlite3";
	public static final String databaseLocation = getDatabaseLocation();
	public static final String connectionString = "jdbc:sqlite:" + databaseLocation + databaseName;
	
	public static String getDatabaseLocation() {
		String path = System.getProperty("catalina.base");
		path = path.substring(0, path.indexOf(".metadata"));
		path += "/" + projectName + "/" + databaseFolder + "/";
		return path;
	}
}
