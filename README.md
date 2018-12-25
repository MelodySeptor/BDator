# BDator
## Table of contents
- [BDator](#bdator)
  * [External libs](#external-libs)
  * [Propose](#propose)
  * [How use it](#how-use-it)
    + [MySQL](#mysql)

## External libs
 - JDBC
 
## Propose
API to get database data more easy. Actually supports this database:
 - MySQL.
 - OracleDB
 - MongoDB
 - TBD

## How use it
There is some examples so how use this API in every case.

### MySQL
If some object its NULL, something was failed.

```java
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import generalModules.MySQL;

public class test {

	public static void main(String[] args) {
		String urlConnection = "sql7.freemysqlhosting.net";
		String name = "sql7271262";
		String user = "sql7271262";
		String password = "7WmwbULtE9";
		String port = "3306";
		
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
		sql.closeStatement(statement);
	}

}

```