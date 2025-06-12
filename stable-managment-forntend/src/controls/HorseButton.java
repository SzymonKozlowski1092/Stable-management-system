package controls;

import javax.swing.*;
import java.awt.*;

public class HorseButton extends JButton {
    private JLabel photoLabel;
    private JLabel nameLabel;
    private JLabel ownerLabel;

    ImageIcon icon = new ImageIcon(getClass().getResource("/HorseIcon.png"));
    
    public HorseButton(String horseName, String ownerName) {
        super();
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        
        setLayout(new BorderLayout(10, 0));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        photoLabel = new JLabel();
        //photoLabel.setIcon(icon);
        photoLabel.setIcon(new ImageIcon(
                new ImageIcon(getClass().getResource("/HorseIcon.png"))
                    .getImage()
                    .getScaledInstance(100, 100, Image.SCALE_SMOOTH)
            ));
        photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        photoLabel.setPreferredSize(new Dimension(80, 80));    
        photoLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        add(photoLabel, BorderLayout.WEST);

        JPanel info = new JPanel();
        info.setOpaque(false);
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

        nameLabel = new JLabel(horseName);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ownerLabel = new JLabel(ownerName);
        ownerLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        ownerLabel.setForeground(Color.WHITE);
        ownerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.add(nameLabel);
        info.add(Box.createVerticalStrut(5));
        info.add(ownerLabel);
        add(info, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int w = getWidth();
        int h = getHeight();
        Graphics2D g2 = (Graphics2D) g.create();
        // antyaliasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1) tło (możesz tu użyć dowolnego koloru lub gradientu)
        g2.setColor(new Color(204, 153, 51));  // ciemne tło
        g2.fillRoundRect(0, 0, w, h, 30, 30);

        // 2) biała obwódka
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(1, 1, w-2, h-2, 30, 30);

        g2.dispose();
        super.paintComponent(g);
    }
}

