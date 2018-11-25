package generalModules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import components.DataContainer;
import components.MySQLAndOracle;

public class MySQL implements MySQLAndOracle {

	public MySQL() {

	}

	@Override
	public Connection createConnection(String driver, String urlConnection, String user, String password) {
		Connection conn;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(urlConnection, user, password);
		} catch (Exception e) {
			conn = null;
		}
		return conn;
	}

	@Override
	public Statement createStatement(Connection connection) {
		Statement stat;
		try {
			stat = connection.createStatement();
		} catch (Exception e) {
			stat = null;
		}
		return stat;
	}

	@Override
	public ResultSet executeQuery(String query, Statement statement) {
		ResultSet res;
		try {
			res = statement.executeQuery(query);
		} catch (Exception e) {
			res = null;
		}
		return res;
	}

	@Override
	public ArrayList<DataContainer> processData(ArrayList<String> dataType, ArrayList<String> dataFields,
			ResultSet dataJava) {
		// TODO
		ArrayList<DataContainer> test;
		test = new ArrayList<>();
		test.add(new DataContainer<Integer>(3));
		test.add(new DataContainer<String>("Hola"));
		return test;
	}

	@Override
	public boolean closeStatement(Statement statement) {
		try {
			statement.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
