import javax.swing.*;
import java.awt.*;

public class LevelCreator extends JFrame {
    private JTextField[] colourFields = new JTextField[4];
    private JTextField sizeField;
    private JPanel colourPreviewPanel;
    
    public LevelCreator() {
        setTitle("Create Your Level");
        setSize(500, 400);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Color selection
        JPanel colourPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        colourPanel.add(new JLabel("Top-Left Color (R,G,B):"));
        colourFields[0] = new JTextField("255,0,0");
        colourPanel.add(colourFields[0]);
        
        colourPanel.add(new JLabel("Top-Right Color (R,G,B):"));
        colourFields[1] = new JTextField("0,255,0");
        colourPanel.add(colourFields[1]);
        
        colourPanel.add(new JLabel("Bottom-Left Color (R,G,B):"));
        colourFields[2] = new JTextField("0,0,255");
        colourPanel.add(colourFields[2]);
        
        colourPanel.add(new JLabel("Bottom-Right Color (R,G,B):"));
        colourFields[3] = new JTextField("255,255,0");
        colourPanel.add(colourFields[3]);
        
        colourPanel.add(new JLabel("Grid Size:"));
        sizeField = new JTextField("6");
        colourPanel.add(sizeField);
        
        // Color preview
        colourPreviewPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        colourPreviewPanel.setPreferredSize(new Dimension(100, 100));
        updateColorPreview();
        
        // Buttons
        JButton previewBtn = new JButton("Update Preview");
        JButton createBtn = new JButton("Create Level");
        JButton backBtn = new JButton("Back");
        
        previewBtn.addActionListener(e -> updateColorPreview());
        createBtn.addActionListener(e -> createLevel());
        backBtn.addActionListener(e -> { dispose(); new HomeScreen(); });
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(previewBtn);
        buttonPanel.add(createBtn);
        buttonPanel.add(backBtn);
        
        panel.add(colourPanel, BorderLayout.NORTH);
        panel.add(colourPreviewPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(panel);
        setVisible(true);
    }
    
    private void updateColorPreview() {
        colourPreviewPanel.removeAll();
        for (int i = 0; i < 4; i++) {
            try {
                String[] rgb = colourFields[i].getText().split(","); // Expecting format "R,G,B"
                int r = Integer.parseInt(rgb[0].trim());
                int g = Integer.parseInt(rgb[1].trim());
                int b = Integer.parseInt(rgb[2].trim());
                Color color = new Color(r, g, b);
                JPanel colorBox = new JPanel();
                colorBox.setBackground(color);
                colorBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                colourPreviewPanel.add(colorBox);
            } catch (Exception e) { // User entered invalid colour
                JPanel colorBox = new JPanel();
                colorBox.setBackground(Color.GRAY);
                colorBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                colourPreviewPanel.add(colorBox);
            }
        }
        colourPreviewPanel.revalidate();
        colourPreviewPanel.repaint();
    }
    
    private void createLevel() {
        try {
            // Parse user colour entries as RGB arrays
            int[][] colours = new int[4][3];
            for (int i = 0; i < 4; i++) {
                String[] rgb = colourFields[i].getText().split(",");
                colours[i][0] = Integer.parseInt(rgb[0].trim()); // Red
                colours[i][1] = Integer.parseInt(rgb[1].trim()); // Green
                colours[i][2] = Integer.parseInt(rgb[2].trim()); // Blue
            }
            
            // Parse size
            int size = Integer.parseInt(sizeField.getText());
            
            // Start game with custom settings
            dispose();
            new GameWindow(colours, size);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Invalid input! Use format: R,G,B (e.g., 255,0,0)", 
                "Error", JOptionPane.ERROR_MESSAGE);
            updateColorPreview();
        }
    }
}