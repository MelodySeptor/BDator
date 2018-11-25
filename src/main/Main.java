package main;

import java.util.ArrayList;

import generalModules.MySQL;
import mySQLAndOracle.DataContainer;

public class Main {

	public static void main(String[] args) {
		MySQL a = new MySQL();

		ArrayList<DataContainer> b = a.processData(null, null, null);

		for (DataContainer c : b) {
			System.out.println(c.getData());
		}
	}

}
