import java.awt.Color;


public class Tile {
    private Color color;
    private boolean isLocked;

    public Tile(Color color, boolean isLocked) {
        this.color = color;
        this.isLocked = isLocked;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }
}




