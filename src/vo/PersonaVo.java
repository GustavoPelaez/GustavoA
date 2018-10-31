package vo;

public class PersonaVo {

	private String documento;
	private String nombre;
	private String Apellido;
	private int edad;
	private String profesion;
	private double salario;
	private String sexo;
	private boolean editar;
	private String pass;
	
	public PersonaVo(){ 	}
	
	public PersonaVo(String documento,String nombre, String apellido, int edad, 
			String profesion, double salario, String sexo, boolean editar) {
		super();
		this.documento=documento;
		this.nombre = nombre;
		Apellido = apellido;
		this.edad = edad;
		this.profesion = profesion;
		this.salario = salario;
		this.sexo=sexo;
		this.editar=editar;
	}
	
	public String getDocumento() { return documento; }

	public void setDocumento(String documento) { this.documento = documento; }
	
	public boolean isEditar() { return editar;	}

	public void setEditar(boolean editar) {	this.editar = editar;}
		
	public String getNombre() { return nombre; }

	public void setNombre(String nombre) {	this.nombre = nombre;}

	public String getApellido() {	return Apellido;	}

	public void setApellido(String apellido) {	Apellido = apellido;	}

	public int getEdad() {	return edad; }

	public void setEdad(int edad) {	this.edad = edad;	}

	public String getProfesion() {	return profesion;	}

	public void setProfesion(String profesion) { this.profesion = profesion;}

	public double getSalario() { return salario; }

	public void setSalario(double salario) {this.salario = salario;	}

	public String getSexo() { 	return sexo;	}

	public void setSexo(String sexo) {	this.sexo = sexo;	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
}
