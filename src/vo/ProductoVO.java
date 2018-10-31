package vo;

public class ProductoVO {
	private String documento;
	private String nombre;
	private String descripcion;
	private double salario;
	private String tipo;
	private boolean editar;
	private String pass;
	
	
	public ProductoVO(){ 	}
	
	public ProductoVO(String documento,String nombre, String descripcion, double salario, String tipo, boolean editar) {
		super();
		this.documento=documento;
		this.nombre = nombre;
		this.descripcion=descripcion;
		this.salario = salario;
		this.tipo=tipo;
		this.editar=editar;
		
	}
	
	public String getDocumento() { return documento; }

	public void setDocumento(String documento) { this.documento = documento; }
	
	public boolean isEditar() { return editar;	}

	public void setEditar(boolean editar) {	this.editar = editar;}
		
	public String getNombre() { return nombre; }

	public void setNombre(String nombre) {	this.nombre = nombre;}
	
	public String getDescripcion(){ 	return descripcion;}
	
	public void setDescripcion(String descripcion){	  this.descripcion = descripcion;}

	public double getSalario() { return salario; }

	public void setSalario(double salario) {this.salario = salario;	}

	public String getTipo() { 	return tipo;	}

	public void setTipo(String tipo) {	this.tipo = tipo;	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	

	

}
