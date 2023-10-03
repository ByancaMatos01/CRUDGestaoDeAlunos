package CRUD1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno {
	long id;
	String nome;
	Date nascimento;
	String ra;

	public  Aluno(long id, String nome, Date nascimento, String ra) {
		this.id=id;
		this.nome=nome;
		this.nascimento=nascimento;
		this.ra=ra;

	}
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "ID: " + id + "\nNome: " + nome + "\nNascimento: " + sdf.format(nascimento) + "\nRA: " + ra;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	
}


