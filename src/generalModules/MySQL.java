package generalModules;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import mySQLAndOracle.DataContainer;
import mySQLAndOracle.MySQLAndOracle;

public class MySQL implements MySQLAndOracle {

	/**
	 * Constructor.
	 */
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
		ArrayList<DataContainer> dataProcessed;
		dataProcessed = new ArrayList<>();

		try {
			int i = 0;
			while (dataJava.next()) {
				switch (dataType.get(i)) {
				// String types
				case "Char":
				case "String":
					dataProcessed.add(new DataContainer<String>(dataJava.getString(dataFields.get(i))));
					break;
				case "Blob":
					dataProcessed.add(new DataContainer<Blob>(dataJava.getBlob(dataFields.get(i))));
					break;
				// Numeric types
				case "Integer":
					dataProcessed.add(new DataContainer<Integer>(dataJava.getInt(dataFields.get(i))));
					break;
				case "Long":
					dataProcessed.add(new DataContainer<Long>(dataJava.getLong(dataFields.get(i))));
					break;
				case "Float":
					dataProcessed.add(new DataContainer<Float>(dataJava.getFloat(dataFields.get(i))));
					break;
				case "Double":
					dataProcessed.add(new DataContainer<Double>(dataJava.getDouble(dataFields.get(i))));
					break;
				case "BigDecimal":
					dataProcessed.add(new DataContainer<BigDecimal>(dataJava.getBigDecimal(dataFields.get(i))));
					break;
				// Time types
				case "Date":
					dataProcessed.add(new DataContainer<Date>(dataJava.getDate(dataFields.get(i))));
					break;
				case "Time":
					dataProcessed.add(new DataContainer<Time>(dataJava.getTime(dataFields.get(i))));
					break;
				case "Timestamp":
					dataProcessed.add(new DataContainer<Timestamp>(dataJava.getTimestamp(dataFields.get(i))));
					break;
				case "Boolean":
					dataProcessed.add(new DataContainer<Boolean>(dataJava.getBoolean(dataFields.get(i))));
					break;
				default:
					dataProcessed.add(new DataContainer<Object>(dataJava.getObject(dataFields.get(i))));
					break;
				}
				i++;
			}
		} catch (Exception e) {
		}
		return dataProcessed;
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
