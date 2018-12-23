package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import generalModules.MySQL;

class MySQLTest {
	String urlConnection = "sql7.freemysqlhosting.net";
	String name = "sql7271262";
	String user = "sql7271262";
	String password = "7WmwbULtE9";
	String port = "3306";

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCreateConnection() {
		MySQL sql = new MySQL();
		// Falta
		fail("Not yep implemented");
	}

	@Test
	void testUnaPeticion() {
		MySQL sql = new MySQL();
		Connection connection = sql.createConnection(sql.refactorSQLUrlConnection(urlConnection, port, name), user,
				password);
		Statement statement = sql.createStatement(connection);
		String query = "Select * From test where 1";
		ResultSet resultSet = sql.executeQuery(query, statement);
		try {
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + ": " + resultSet.getString(2));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		resultSet = sql.executeQuery(query, statement);
		System.out.println("2nda Query seguida.");
		try {
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + ": " + resultSet.getString(2));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		sql.closeStatement(statement);
	}

	@Test
	void testCreateStatement() {
		fail("Not yet implemented");
	}

	@Test
	void testExecuteQuery() {
		fail("Not yet implemented");
	}

	@Test
	void testProcessData() {
		fail("Not yet implemented");
	}

	@Test
	void testCloseStatement() {
		fail("Not yet implemented");
	}

	@Test
	void testRefactorUrlConnection() {
		// Just one test because this isnt to much complicated.
		MySQL sql = new MySQL();

		String host = "localhost";
		String port = "1234";
		String nameDatabase = "potato";

		String result = "jdbc:mysql://localhost:1234/potato";

		String refactorized = sql.refactorSQLUrlConnection(host, port, nameDatabase);

		assertEquals(result, refactorized);
	}

}
