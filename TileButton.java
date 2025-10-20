import javax.swing.*;

public class TileButton extends JButton {
    private Tile tile; // link to Tile
    private int row, col, rightRow, rightCol;

    public TileButton(Tile tile, int row, int col, int rightRow, int rightCol) {
        this.tile = tile;
        this.row = row;
        this.col = col;
        this.rightRow = rightRow;
        this.rightCol = rightCol;

        setBackground(tile.getColor());
        setOpaque(true);
        setBorderPainted(false);
    }

    public Tile getTile() {
        return tile;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public int getRightRow() {
        return rightRow;
    }
    public int getRightCol() {
        return rightCol;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public void setRightRow(int rightRow) {
        this.rightRow = rightRow;
    }
    public void setRightCol(int rightCol) {
        this.rightCol = rightCol;
    }
    public void setTile(Tile tile) {
        this.tile = tile;
    }
    public boolean inRightSpot() {
        return (rightRow == row && rightCol == col);
    }

}