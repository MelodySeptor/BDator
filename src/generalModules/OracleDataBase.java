package generalModules;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import mySQLAndOracle.DataContainer;
import mySQLAndOracle.MySQLAndOracle;

public class OracleDataBase implements MySQLAndOracle {

	@Override
	public Connection createConnection(String urlConnection, String user, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement createStatement(Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet executeQuery(String query, Statement statement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DataContainer> processData(ArrayList<String> dataType, ArrayList<String> dataFields,
			ResultSet dataJava) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean closeStatement(Statement statement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String refactorUrlConnection(String serverIP, String Port, String nameDatabase) {
		// TODO Auto-generated method stub
		return null;
	}

}
