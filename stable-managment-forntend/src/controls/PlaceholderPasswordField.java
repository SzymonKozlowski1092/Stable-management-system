package controls;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;

public class PlaceholderPasswordField extends JPasswordField {
    private static final long serialVersionUID = 1L;
    private final String placeholder;
    private final char defaultEchoChar;

    public PlaceholderPasswordField(String placeholder) {
        super(placeholder);
        this.placeholder = placeholder;
        this.defaultEchoChar = getEchoChar();
        
        setForeground(Color.GRAY);
        setEchoChar((char) 0); 
        setText(placeholder);

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                String current = new String(getPassword());
                if (current.equals(placeholder)) {
                    setText("");
                    setForeground(Color.BLACK);
                    setEchoChar(defaultEchoChar); 
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String current = new String(getPassword());
                if (current.isEmpty()) {
                    setForeground(Color.GRAY);
                    setEchoChar((char) 0);      
                    setText(placeholder);
                }
            }
        });
    }

    @Override
    public String getText() {
        // Aby nie zwracać placeholdera przy getText():
        String input = new String(getPassword());
        return input.equals(placeholder) ? "" : input;
    }
}
