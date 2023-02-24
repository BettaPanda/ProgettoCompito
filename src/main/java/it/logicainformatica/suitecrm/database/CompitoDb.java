package it.logicainformatica.suitecrm.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.logicainformatica.ProgettoSpringBean.AnagraficaCompito;
import it.logicainformatica.suitecrm.bean.AnagraficaUtente;




public class CompitoDb {
	
	Database db = new Database();
	
	// INSERISCI DATI UTENTI SUL DB
		public void inserisciUtente (AnagraficaCompito a) {

	Connection dbconn = null;
	try {

		
		dbconn = db.getConnessione();

		PreparedStatement statement = dbconn.prepareStatement(
				"Insert into anagrafica(nome,cognome,email,telefono,CF,indirizzo) values (?,?,?,?,?,?)");

		statement.setString(1, a.getNome());
		statement.setString(2, a.getCognome());
		statement.setString(3, a.getEmail());
		statement.setString(4, a.getTelefono());
		statement.setString(5, a.getCodiceFiscale());
		statement.setString(6, a.getIndirizzo());

		boolean f = statement.execute();

		if (f == false) {
			System.out.println("Inserimento eseguito correttamente!");
		}

		else {
			System.out.println("Inserimento non eseguito!");
		}

		System.out.println();

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			dbconn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



		}
	
	
		
		
		//SCRIVI DATI UTENTE SUL FILE DI TESTO
		
		public void AnagraficaWriter (AnagraficaCompito a) {
			
		
			
			Connection dbconn = null;
	
		try {
			
			dbconn = db.getConnessione();
			PreparedStatement statement = dbconn.prepareStatement("SELECT * FROM anagrafica");
			ResultSet rs = statement.executeQuery();

		
			while (rs.next()) {
			
			
            FileWriter writer = new FileWriter("AnagraficaCompito.txt");
            
			writer.write("Nome: " + a.getNome() + "\n");
            
			writer.write("Cognome: " + a.getCognome() + "\n");
           
			writer.write("Telefono: " + a.getTelefono() + "\n");
			writer.write("Email:" + a.getEmail() +"\n");
			writer.write("CodiceFiscale: " + a.getCodiceFiscale() + "\n");
			writer.write("Indirizzo:" + a.getIndirizzo()+"\n");
			
            writer.close();
			}
            System.out.println("Anagrafica scritta con successo.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante la scrittura del file.");
            e.printStackTrace();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		}
        
    	// LEGGI SUL DB 
    	public List<AnagraficaCompito> cercaPerNome(String nome) {

    		List<AnagraficaCompito> lista = new ArrayList<AnagraficaCompito>();
    		// CREOL'OGGETTOCONNECTION
    		Connection dbconn = null;

    		try {

    			// VALORIZZO L'OGGETTO CONNECTION
    			dbconn = db.getConnessione();

    			// PREPARO L' ISTRUZIONE SQL
    			PreparedStatement statement = dbconn.prepareStatement("SELECT * FROM anagrafica where nome = ?");

    			// SOSTITUISCO IL ? CON UN VALORE REALE
    			statement.setString(1, nome);

    			// LANCIO LA QUERY SUL DATA BASE E I RISULTATI ME LI RESTITUSCIE IN UN OGGETTO
    			// DI TIPO RESULTSET
    			ResultSet rs = statement.executeQuery();

    			// CICLO I VALORI CHE ARRIVANO DAL DB
    			while (rs.next()) {

    				AnagraficaCompito ana = new AnagraficaCompito();

    				// INSERENDO IL NOME DELLA COLONNA E MI PRENDO IL VALORE

    				ana.setNome(rs.getString("nome"));
    				ana.setCognome(rs.getString("cognome"));
    				ana.setId(rs.getInt("id"));
    				ana.setTelefono(rs.getString("telefono"));
    				ana.setIndirizzo(rs.getString("indirizzo"));
    				ana.setCodiceFiscale(rs.getString("cf"));
    				ana.setEmail(rs.getString("email"));

    				lista.add(ana);

    			}

    		} catch (SQLException e) {
    			e.printStackTrace();
    		} finally {
    			try {
    				dbconn.close();
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    		}
    		return lista;
    	}

    	
    	// LEGGI L'ANAGRAFICA DA UN FILE DI TESTO
         public void AnagraficaReader (AnagraficaCompito a) {
			
		
			
			Connection dbconn = null;
	
		try {
			
			dbconn = db.getConnessione();
			PreparedStatement statement = dbconn.prepareStatement("SELECT * FROM anagrafica");
			ResultSet rs = statement.executeQuery();

		
			while (rs.next()) {
			
			
            FileReader reader = new FileReader("AnagraficaCompito.txt");
            
			reader.reader("Nome: " + a.getNome() + "\n");
            
			reader.reader("Cognome: " + a.getCognome() + "\n");
           
			reader.reader("Telefono: " + a.getTelefono() + "\n");
			reader.write("Email:" + a.getEmail() +"\n");
			reader.write("CodiceFiscale: " + a.getCodiceFiscale() + "\n");
			reader.write("Indirizzo:" + a.getIndirizzo()+"\n");
			
            reader.close();
            
			}
            System.out.println("Anagrafica letta con successo.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante la lettura del file.");
            e.printStackTrace();
        }
        
         }   
    	
		}