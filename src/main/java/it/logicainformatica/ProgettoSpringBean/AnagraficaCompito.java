package it.logicainformatica.ProgettoSpringBean;

import it.logicainformatica.suitecrm.bean.Base;

public class AnagraficaCompito {
	
	
		
		int id;
		String nome;
		String cognome;
		String telefono;
		String paese;
		String codiceFiscale;
		String email;
		String indirizzo;
		
		
		public String getIndirizzo() {
			return indirizzo;
		}



		public void setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getCodiceFiscale() {
			return codiceFiscale;
		}



		public void setCodiceFiscale(String codiceFiscale) {
			this.codiceFiscale = codiceFiscale;
		}



		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public String getPaese() {
			return paese;
		}



		public void setPaese(String paese) {
			this.paese = paese;
		}
		
		public String getNome() {
			return nome;
		}



		public void setNome(String nome) {
			this.nome = nome;
		}



		public String getCognome() {
			return cognome;
		}



		public void setCognome(String cognome) {
			this.cognome = cognome;
		}



		public String getTelefono() {
			return telefono;
		}



		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}


	}


