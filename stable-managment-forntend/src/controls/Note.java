package controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Note extends JButton {
    private JLabel contentLabel;
    private JLabel authorLabel;

    public Note(String content, String author) {

        setBorderPainted(false);
        setContentAreaFilled(true);
        setFocusPainted(false);
        setOpaque(true);
        setBackground(new Color(0xFFEB99));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        setLayout(new BorderLayout(5, 5));

        contentLabel = new JLabel();
        contentLabel.setText("<html><body style='width: 200px;'>" + content + "</body></html>");
        contentLabel.setVerticalAlignment(SwingConstants.TOP);
        add(contentLabel, BorderLayout.CENTER);

        authorLabel = new JLabel(author);
        authorLabel.setFont(authorLabel.getFont().deriveFont(Font.ITALIC, authorLabel.getFont().getSize() - 2f));
        add(authorLabel, BorderLayout.SOUTH);

    }

    public void setContent(String content) {
        contentLabel.setText("<html><body style='width: 200px;'>" + content + "</body></html>");
    }

    public void setAuthor(String author) {
        authorLabel.setText(author);
    }

    public String getContent() {
        return contentLabel.getText();
    }

    public String getAuthor() {
        return authorLabel.getText();
    }
}
