package viewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginViewModel implements ActionListener
{
	public interface LoginCallback {
        void onLoginSuccess();
        void onLoginFailure();
        void onRegisterRequested();
    } //i use this to open window and messagebox in view
	
	private final LoginCallback callback;
	  
	public LoginViewModel(LoginCallback callback) 
	{
		this.callback = callback;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand()) 
		{
        case "LOGIN":
            //there will be logic to check login data
        	 callback.onLoginSuccess();
            break;
        case "REGISTER":
            callback.onRegisterRequested();
            break;
		}	
	}

}
