package CRUD2fun;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Funcionario {
	long id;
	String nome;
	String matricula;
	Date admissao;
	Date demissao;
	float salario;
	String horario;


	public Funcionario( long id, String nome, String matricula, Date admissao, Date demissao, float salario,String horario) {

		this.id=id;
		this.nome=nome;
		this.matricula=matricula;
		this.admissao=admissao;
		this.demissao=demissao;
		this.salario=salario;
		this.horario=horario;
	}

	public String toString () {
		SimpleDateFormat sdf= new SimpleDateFormat("dd/mm/yyyy");
		return "ID: "+id +"\nNome: "+ nome+ "\nMatricula: "+matricula+ "\nAdmissao "+sdf.format(admissao)+"\nDemissao "+sdf.format(demissao)+"\nSalario "+salario+"\nHorario "+horario;

	}

	public long getid() {
		return id;
	}
	public void setid(long id) {
		this.id=id;
	}

	public String getnome() {
		return nome;
	}
	public void setnome(String nome) {
		this.nome=nome;
	}

	public String getmatricula() {
		return matricula;
	}
	public void Setmatricula(String matricula) {
		this.matricula=matricula;
	}
	public Date getadmissao() {
		return admissao;
	}
	public void Setadmissao(Date admissao) {
		this.admissao=admissao;
	}
	public Date getdemissao() {
		return demissao;
	}
	public void Setdemissao(Date demissao) {
		this.demissao=demissao;
	}
	public float salario() {
		return salario;
	}
	public void Setsalario(float salario) {
		this.salario=salario;
	}
	public String gethorario() {
		return horario;
	}
	 public void sethorario(String horario) {
		 this.horario=horario;
	 }

}
