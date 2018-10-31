package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import dao.ProductoDao;
import vo.ProductoVO;

@ManagedBean
@ViewScoped
public class ProductoBean {
	
	private ProductoVO miProductoVo;
	ProductoDao miProductoDao;
	private String mensaje;
	private String navegacion;
	private String pass;
	
	public ProductoBean(){
		miProductoVo=new ProductoVO();
		miProductoDao=new ProductoDao();
	}
	
	
	public void registrarUsuario(){
		System.out.println("Registro de Usuario");
		
		if (miProductoVo.getPass().equals(pass)) {
			mensaje=miProductoDao.agregarPersona(miProductoVo);
			if (mensaje.equalsIgnoreCase("Registro Exitoso")) {
				mensaje="Se ha registrado exitosamente!";	
			}else{
				mensaje="Ocurrió un problema al registrar, verifique nuevamente";	
			}
		}else{
			mensaje="El password no es igual a la confirmación";
		}
		
	}
	
	public void consultarUsuario(){
		System.out.println("Consulta de Usuario: "+miProductoVo.getDocumento());
		miProductoVo=miProductoDao.consultarPersonaIndividual(miProductoVo.getDocumento());
		if (miProductoVo!=null) {
			setMensaje("");
		}else{
			setMensaje("No se encuentra la persona");
			miProductoVo=new ProductoVO();
		}
	}
	
	public void actualizarUsuario(){
		System.out.println("Actualizar Usuario");
		setMensaje(miProductoDao.editarPersona(miProductoVo));
	}
	
	public void eliminarUsuario(){
		System.out.println("Eliminar Usuario");
		setMensaje(miProductoDao.eliminarPersona(miProductoVo));
		miProductoVo=new ProductoVO();
	}

	public ProductoVO getMiProductoVo() {
		return miProductoVo;
	}

	public void setMiProductoVo(ProductoVO miProductoVo) {
		this.miProductoVo = miProductoVo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getNavegacion() {
		return navegacion;
	}

	public void setNavegacion(String navegacion) {
		this.navegacion = navegacion;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
