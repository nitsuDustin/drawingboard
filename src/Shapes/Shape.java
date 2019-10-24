package Shapes;

public class Shape {
    private int x;
    private int y;
    private String color;

    public Shape() {
        this.x = 0;
        this.y = 0;
        this.color = "Red";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}