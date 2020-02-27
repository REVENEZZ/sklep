package sklep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//package sklep;
import java.sql.Statement;

public class sklep {

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:E:\\SQLiteDatabaseBrowserPortable\\sklep.db");
			
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			ResultSet resultSet = statement.executeQuery("SELECT * from Sklep");
			while(resultSet.next())
			{
				for(int i=0;i<30;i++) System.out.print('-');
				System.out.println('-');
				System.out.println("\t Przedmiot="+resultSet.getString("Przedmiot"));
				System.out.println("\t Iloœæ="+resultSet.getInt("iloœæ"));
				System.out.println("\t Numer Seryjny="+resultSet.getInt("Numer seryjny"));
				System.out.println("\t Data_Wydania="+resultSet.getString("Data_Wydania"));
				System.out.println("\t Kategoria="+resultSet.getString("Kategoria"));
				System.out.println("\t Waga="+resultSet.getInt("Waga"));
				
				
			}
			if(connection !=null)
				connection.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
}
