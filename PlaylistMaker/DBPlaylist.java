package PlaylistMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBPlaylist {
	    String connectionString;
	    Connection connection;

	    public DBPlaylist(String connectionString) {
	        this.connectionString = connectionString;
	    }


	    // Connect i disconnect su suvisne (za ovakav kod)
	    void connect() throws SQLException {
	        disconnect();
	        connection = DriverManager.getConnection(connectionString);
	    }

	    private void disconnect() throws SQLException {
	        if (connection != null && !connection.isClosed())
	            connection.close();

	    }

	    public void printCategory() throws SQLException {

	        try (Connection connection = DriverManager.getConnection(connectionString);
	             Statement statement = connection.createStatement()) {
	            final ResultSet resultSet = statement.executeQuery("SELECT k.IDKom,k.Naziv,r.IDRac, r.Stanje FROM Racun r, Komitent k WHERE k.IDKom=r.IDKom");
	            // statement.executeQuery koristiti samo za SELECT upite


	            while (resultSet.next()) {  // dok postoji red za citanje -> ucitaj

	                // Iz ucitanog reda preuzmi kolone
	                // Paznja: Indeksi kolona se broje od 1 (ne od 0)
	                int idkom = resultSet.getInt(1);
	                String nazivkom = resultSet.getString("Naziv");
	                int idrac = resultSet.getInt(3);
	                float stanje = resultSet.getFloat(4);
	                System.out.println(idkom + "\t" + nazivkom + "\t" + idrac + "\t" + stanje);
	            }

	        }

	    }

	    public void addCategory(int id, String name) throws SQLException {

	        try (Connection connection = DriverManager.getConnection(connectionString);
	             PreparedStatement statement = connection.prepareStatement("INSERT INTO Category (cat_id, cat_name)"+ "VALUES ("+ id+", " + name +")")
	        ) {

	            // postavljanje parametara - prvi argument predstavlja redni broj (broji se od 1)
	            // znak pitanja sa kojim se menja
	           // statement.setInt(1, id);
	           // statement.setString(2, name);

	            statement.execute();
	        }

	    }





	    public void makeTransfer(int fromIdRac, int toIdRac, float amount) throws Exception {
	        try (Connection connection = DriverManager.getConnection(connectionString);
	             PreparedStatement statement = connection.prepareStatement("UPDATE Racun SET Stanje=Stanje+? WHERE idrac=?")
	        ) {
	            // Potrebno je iskljuciti AutoCommit (da se nakon svakog upita izvrsi Commit)
	            connection.setAutoCommit(false);

	            statement.setFloat(1, -amount);
	            statement.setInt(2, fromIdRac);


	            statement.execute(); // Paznja: ovaj update nije Commit-ovan

	            if (true)           // Semanticki if(true) je suvisno, compiler se buni bez if-a
	                throw new Exception("Nestala struja");

	            statement.setFloat(1, amount);
	            statement.setInt(2, toIdRac);

	            statement.execute();


	            // Commit-ujemo prethodne update upite, cime ih smatramo kao jednu celinu za izvrsavanje
	            connection.commit();
	            // Vracamo AutoCommit na staro (podrazumevati da je uvek AutoCommit=true)
	            connection.setAutoCommit(true);
	        }
	    }

	    public void makeTransferFaultAnomaly(int fromIdRac, int toIdRac, float amount) throws Exception {
	        try (Connection connection = DriverManager.getConnection(connectionString);
	             PreparedStatement statement = connection.prepareStatement("UPDATE Racun SET Stanje=Stanje+? WHERE idrac=?")
	        ) {

	            statement.setFloat(1, -amount);
	            statement.setInt(2, fromIdRac);


	            statement.execute(); // Paznja: ovaj update izvrsen

	            if (true)           // Semanticki if(true) je suvisno, compiler se buni bez if-a
	                throw new Exception("Nestala struja");

	            // ovo se ne izvrsava, a trebalo je. Skinuli smo pare, a nismo ih perbacili!

	            statement.setFloat(1, amount);
	            statement.setInt(2, toIdRac);

	            statement.execute();

	        }
	    }
	}

