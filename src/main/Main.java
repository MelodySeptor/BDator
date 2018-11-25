package main;

import java.util.ArrayList;

import components.DataContainer;
import generalModules.MySQL;

public class Main {

	public static void main(String[] args) {
		MySQL a = new MySQL();

		ArrayList<DataContainer> b = a.processData(null, null, null);

		for (DataContainer c : b) {
			System.out.println(c.getData());
		}
	}

}
