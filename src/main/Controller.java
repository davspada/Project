package main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.ConnectionFactory;
import frames.LoginFrame;
import frames.RegisterNewUserFrame;
import frames.MainFrame;
import dao.ItemDao;
import dao.EmployeesDao;

public class Controller {
	
	private ConnectionFactory conn;
	private ItemDao IDao;
	private EmployeesDao EDao;
	private LoginFrame LoginFrame;
	private MainFrame MFrame;
	private RegisterNewUserFrame RegisterFrame;
	
	
	//Constructor
	public Controller() {
		conn = new ConnectionFactory(this);
		IDao = new ItemDao(this);
		EDao = new EmployeesDao(this);
		LoginFrame = new LoginFrame(this);
		MFrame = new MainFrame(this);
		RegisterFrame = new RegisterNewUserFrame(this);
		LoginFrame.setVisible(true);
	}
	
		
	//open registernewuser frame from login frame
	public void RegisterFrameOpen() {
		RegisterFrame.setVisible(true);	
		LoginFrame.setVisible(false);
	}
	
	
	//open login frame from register frame
	public void LoginFrameOpen() {
		RegisterFrame.setVisible(false);	
		LoginFrame.setVisible(true);
	}
	
	
	
	//login check
	public void LoginCheck(String Username, String Password) {
		if(EDao.CheckLoginProps(Username, Password)==true){
				MFrame.setVisible(true);
		}else {
			LoginFrame.UnregisteredUser();
		}

	}
	
	//register a new user
	public void RegisterUser(String Username, String Password) {
		if(EDao.RegisterNewUser(Username, Password)==true){
			RegisterFrame.UserHasBeenRegistered();
			RegisterFrame.setVisible(false);
			LoginFrame.setVisible(true);
		}else {
			if (EDao.CheckLoginProps(Username, Password)==true)
				RegisterFrame.UserAlreadyRegistered();
		}						
	}
	
	
}
