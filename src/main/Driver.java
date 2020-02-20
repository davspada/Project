package main;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class Driver {
	
	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available
		}
		Controller MainController = new Controller();
	}
	

}
