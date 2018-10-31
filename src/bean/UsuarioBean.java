package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import dao.PersonaDao;
import vo.PersonaVo;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	
	private PersonaVo miPersonaVo;
	PersonaDao miPersonaDao;
	private String mensaje;
	private String navegacion;
	private String pass;
	
	public UsuarioBean(){
		miPersonaVo=new PersonaVo();
		miPersonaDao=new PersonaDao();
	}
	
	
	public void registrarUsuario(){
		System.out.println("Registro de Usuario");
		System.out.println("soy una verga");
		if (miPersonaVo.getPass().equals(pass)) {
			mensaje=miPersonaDao.agregarPersona(miPersonaVo);
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
		System.out.println("Consulta de Usuario: "+miPersonaVo.getDocumento());
		miPersonaVo=miPersonaDao.consultarPersonaIndividual(miPersonaVo.getDocumento());
		if (miPersonaVo!=null) {
			setMensaje("");
		}else{
			setMensaje("No se encuentra la persona");
			miPersonaVo=new PersonaVo();
		}
	}
	
	public void actualizarUsuario(){
		System.out.println("Actualizar Usuario");
		setMensaje(miPersonaDao.editarPersona(miPersonaVo));
	}
	
	public void eliminarUsuario(){
		System.out.println("Eliminar Usuario");
		setMensaje(miPersonaDao.eliminarPersona(miPersonaVo));
		miPersonaVo=new PersonaVo();
	}

	public PersonaVo getMiPersonaVo() {
		return miPersonaVo;
	}

	public void setMiPersonaVo(PersonaVo miPersonaVo) {
		this.miPersonaVo = miPersonaVo;
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
