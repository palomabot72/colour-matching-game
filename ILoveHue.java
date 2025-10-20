public class ILoveHue {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new GameWindow(null, 7);
        });
    }
}