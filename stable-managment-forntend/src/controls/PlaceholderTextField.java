package controls;


import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

public class PlaceholderTextField extends JTextField
{
	private static final long serialVersionUID = 1L;
	public String placeholder;
	
	public PlaceholderTextField(String placeholder) 
	{
        this.placeholder = placeholder;
        setForeground(Color.GRAY);
        setText(placeholder);

        addFocusListener(new FocusAdapter() 
        {
            @Override
            public void focusGained(FocusEvent e) 
            {
                if (getText().equals(placeholder)) 
                {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) 
            {
                if (getText().isEmpty()) 
                {
                    setForeground(Color.GRAY);
                    setText(placeholder);
                }
            }
        });
    }

}
