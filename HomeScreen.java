
import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JFrame{

    public static void main(String[] args) {
        new HomeScreen();
    } 

    public HomeScreen() {
        setTitle("Color Sorting Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel title = new JLabel("Color Sorting Game", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        
        JButton createLevelBtn = new JButton("Create Your Own Level!!");
        JButton playLevelsBtn = new JButton("Play Predefined Levels");
        
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
        
        setVisible(true);
    }
    
    private void showLevelSelection() {
        // Simple level picker - you can make this fancier
        String[] levels = {"Level 1", "Level 2", "Level 3", "Level 4", "Level 5", 
                          "Level 6", "Level 7", "Level 8", "Level 9", "Level 10"};
        
        String choice = (String) JOptionPane.showInputDialog(this, 
            "Choose a level:", "Level Selection", 
            JOptionPane.QUESTION_MESSAGE, null, levels, levels[0]);
        
        if (choice != null) {
            int levelNum = Integer.parseInt(choice.split(" ")[1]);
            startPredefinedLevel(levelNum);
        } else {
            new HomeScreen(); // Back to home if cancelled
        }
    }
    
    private void startPredefinedLevel(int level) {
        // Your existing GameWindow code with predefined settings
        // You can store level configurations in an array
        new GameWindow(null, 7); // Modify your GameWindow to accept level parameter
    }
}
