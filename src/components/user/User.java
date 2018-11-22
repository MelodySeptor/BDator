package components.user;

public interface User {
	/**
	 * Create the connection for dataBase.
	 * 
	 * @param driver        String with driver for database.
	 * @param urlConnection String url with link to the database.
	 * @param user          String userName of database.
	 * @param password      String password of database.
	 * @return True if connection its successfully or False if failed.
	 */
	public boolean createConnection(String driver, String urlConnection, String user, String password);
	// https://alvinalexander.com/java/java-mysql-select-query-example
}
