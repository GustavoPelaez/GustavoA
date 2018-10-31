package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.PersonaDao;
import vo.PersonaVo;

@ManagedBean
@SessionScoped
public class LoginBean {
	

	private PersonaVo miPersonaVo;
	PersonaDao miPersonaDao;
	private String mensaje;
	private String navegacion;
	private boolean validado=false;
	
	public LoginBean(){
		miPersonaVo=new PersonaVo();
		miPersonaDao=new PersonaDao();
	}
	
	public String validarUsuario(){
		
		String resp="";
		
		System.out.println("*****************************************************");
		System.out.println("Documento: "+miPersonaVo.getDocumento());
		System.out.println("Nombre: "+miPersonaVo.getPass());
		
		PersonaVo persona=miPersonaDao.consultarUsuarioLogin(miPersonaVo.getDocumento(), miPersonaVo.getPass());
		
		if (persona!=null) {
			resp="bienvenido.jsf";
			mensaje="";
			miPersonaVo=persona;
			System.out.println("USUARIO VALIDO: "+miPersonaVo.getNombre());
		}else{
			resp="#";
			mensaje="El usuario no es Valido, Verifique nuevamente...";
			System.out.println("USUARIO NO VALIDO");
		}
		System.out.println("*****************************************************");
		return resp;
	}
	
	public void registrarUsuario(){
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<SE CONECTÓ>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<Desde Registrar usuario>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	public void OtroMetodoUsuario(){
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<Desde otro metodo usuario>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	public PersonaVo getMiPersonaVo() {
		return miPersonaVo;
	}

	public void setMiPersonaVo(PersonaVo miPersonaVo) {
		this.miPersonaVo = miPersonaVo;
	}

	public PersonaDao getMiPersonaDao() {
		return miPersonaDao;
	}

	public void setMiPersonaDao(PersonaDao miPersonaDao) {
		this.miPersonaDao = miPersonaDao;
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

	public boolean isValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
	}
	
}
