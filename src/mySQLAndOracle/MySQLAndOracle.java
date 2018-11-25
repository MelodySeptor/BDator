package mySQLAndOracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Interface for setUp all methods to control dataBase with MySQL.
 * 
 * @author melody
 *
 */
public interface MySQLAndOracle {
	/**
	 * Create the connection for dataBase.
	 * 
	 * @param driver        String with driver for database.
	 * @param urlConnection String url with link to the database.
	 * @param user          String userName of database.
	 * @param password      String password of database.
	 * @return Connection with database. Null if something was wrong.
	 */
	public Connection createConnection(String urlConnection, String user, String password);
	// https://alvinalexander.com/java/java-mysql-select-query-example
	// https://www.javatpoint.com/example-to-connect-to-the-mysql-database

	/**
	 * Create Statement for database.
	 * 
	 * @param connection with database connection.
	 * @return Statement. Null if something was wrong.
	 */
	public Statement createStatement(Connection connection);

	/**
	 * Execute Query and return all data on ResultSet.
	 * 
	 * @param query     String.
	 * @param statement Statement from database.
	 * @return ResultSet with data, or null object if failed.
	 */
	public ResultSet executeQuery(String query, Statement statement);

	/**
	 * Process all data from query and return ArrayList of DataContainer. This can
	 * have: String, Blob, Integer, Long, Float, Double, BigDecimal, Date, Time,
	 * Timestamp, Boolean and default Object.
	 * 
	 * @param dataType   ArrayList<String> with all data sorted.
	 * @param dataFields ArrayList<String> with fields of Database.
	 * @param dataJava   Result of execute query.
	 * @return ArrayList<DataContainer> with all data sorted as input.
	 */
	public ArrayList<DataContainer> processData(ArrayList<String> dataType, ArrayList<String> dataFields,
			ResultSet dataJava);

	/**
	 * Close the statements after use it.
	 * 
	 * @param statement of database
	 * @return return True if its closed okay, False if something happens.
	 */
	public boolean closeStatement(Statement statement);

	/**
	 * Set up String for connection.
	 * 
	 * @param serverIP     String if its localhost, can put localhost.
	 * @param Port         String as number of port.
	 * @param nameDatabase String of name of database.
	 * @return String refactorized.
	 */
	public String refactorUrlConnection(String serverIP, String Port, String nameDatabase);
}
