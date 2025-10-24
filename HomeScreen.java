
import javax.swing.*;

import java.awt.*;
import java.awt.event.*; 

public class HomeScreen extends JFrame {

    public static void main(String[] args) {
        new HomeScreen();
    } 

    public HomeScreen() {
        setTitle("Hue Hopper 5000");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(220, 225, 255));
        panel.setOpaque(true);
        
        JLabel title = new JLabel("Hue Hopper 5000", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        
        // Create level button
        JButton createLevelBtn = new JButton("Create Your Own Level!!");
        createLevelBtn.setOpaque(true);
        createLevelBtn.setContentAreaFilled(true);
        createLevelBtn.setBorderPainted(false);
        createLevelBtn.setBackground(new Color(179, 155, 255));
        createLevelBtn.setFocusPainted(false); 

        // Play preset levels button
        JButton playLevelsBtn = new JButton("Play Predefined Levels");
        playLevelsBtn.setOpaque(true);
        playLevelsBtn.setContentAreaFilled(true);
        playLevelsBtn.setBorderPainted(false);
        playLevelsBtn.setBackground(new Color(142, 205, 253));
        panel.add(title);
        panel.add(createLevelBtn);
        panel.add(playLevelsBtn);
        
        add(panel);

        // Button actions
        createLevelBtn.addActionListener(e -> {
            dispose();
            new LevelCreator();
        });

        playLevelsBtn.addActionListener(e -> {
            dispose();
            showLevelSelection();
        });

        createLevelBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                createLevelBtn.setBackground(new Color(154, 128, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                createLevelBtn.setBackground(new Color(179, 155, 255));
            }
        });

         playLevelsBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                playLevelsBtn.setBackground(new Color(115, 195, 253));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                playLevelsBtn.setBackground(new Color(142, 205, 253));
            }
        });
        
        setVisible(true);
    }
    
    private void showLevelSelection() {
        // Still need to define levels
        JFrame levelFrame = new JFrame("Level Selection");

        levelFrame.setSize(300, 400);
        levelFrame.setLocationRelativeTo(null);
        levelFrame.getContentPane().setBackground(new Color(220, 225, 255));
        levelFrame.setLayout(new BorderLayout(10, 10));

        // Title
        JLabel title = new JLabel("Choose a Level", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 16f));
        levelFrame.add(title, BorderLayout.NORTH);

        // List of levels
        String[] levels = {"Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6"};
        JPanel buttonPanel = new JPanel(new GridLayout(levels.length, 1, 5, 5));
        buttonPanel.setBackground(new Color(220, 225, 255));

        for (String lvl : levels) {
            JButton btn = new JButton(lvl);
            btn.setBackground(Color.WHITE);
            btn.addActionListener(e -> {
                int levelNum = Integer.parseInt(lvl.split(" ")[1]);
                //startPredefinedLevel(levelNum); impliment that
                levelFrame.dispose(); // close the window
            });
            buttonPanel.add(btn);
        }

        levelFrame.add(buttonPanel);
        levelFrame.setVisible(true);
    }
}

