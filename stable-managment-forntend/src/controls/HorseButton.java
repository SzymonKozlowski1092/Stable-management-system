package controls;

import javax.swing.*;
import java.awt.*;

public class HorseButton extends JButton {
    private JLabel photoLabel;
    private JLabel nameLabel;
    private JLabel ownerLabel;

    ImageIcon icon = new ImageIcon(getClass().getResource("/image/HorseIcon.png"));
    
    public HorseButton(String horseName, String ownerName) {
        super();
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);

        // ustaw układ: left = zdjęcie, right = etykiety
        setLayout(new BorderLayout(10, 0));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 1) lewa część: zdjęcie w JLabel, z własną obwódką
        photoLabel = new JLabel();
        photoLabel.setIcon(icon);
        photoLabel.setText("Brak zdjęcia");
        photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        photoLabel.setPreferredSize(new Dimension(80, 80));    
        photoLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        add(photoLabel, BorderLayout.WEST);

        // 2) prawa część: panel z dwiema etykietami
        JPanel info = new JPanel();
        info.setOpaque(false);
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

        nameLabel = new JLabel(horseName);
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD, 14f));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        ownerLabel = new JLabel(ownerName);
        ownerLabel.setFont(ownerLabel.getFont().deriveFont(Font.PLAIN, 12f));
        ownerLabel.setForeground(Color.WHITE);
        ownerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

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
        g2.setColor(new Color(30, 30, 30));  // ciemne tło
        g2.fillRoundRect(0, 0, w, h, 30, 30);

        // 2) biała obwódka
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(1, 1, w-2, h-2, 30, 30);

        g2.dispose();
        super.paintComponent(g);
    }
}

