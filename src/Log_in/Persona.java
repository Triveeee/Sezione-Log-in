package Log_in;
import java.io.Serializable;

public class Persona implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4290875890793780346L;
	private String n_corsi;
	private String nome;
	private String cognome;
	private String password;
	private String nome_utente;
	
	public Persona() {
		n_corsi = "";
		nome = "";
		cognome = "";
		password = "";
		nome_utente = "";
	}
	
	public Persona(String n_corsi , String nome , String cognome , String password , String nome_utente) {
		this.n_corsi = n_corsi;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.nome_utente = nome_utente;
	}


	public String getN_corsi() {
		return n_corsi;
	}

	public void setN_corsi(String n_corsi) {
		this.n_corsi = n_corsi;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setNomeUtente(String nome_utente) {
		this.nome_utente = nome_utente;
	}
	
	public String getNomeUtente() {
		return(nome_utente);
	}
	
	
	public String toString() {
		return this.n_corsi + ";" + this.nome + ";" + this.cognome + ";" + this.password + ";" + this.nome_utente;
	}
	
	

}
