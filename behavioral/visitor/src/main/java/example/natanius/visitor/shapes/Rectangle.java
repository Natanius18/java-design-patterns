package example.natanius.visitor.shapes;

import example.natanius.visitor.visitor.Visitor;
import lombok.Getter;

@Getter
public class Rectangle implements Shape {
    private final int id;
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public Rectangle(int id, int x, int y, int width, int height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitRectangle(this);
    }

    @Override
    public void move(int x, int y) {
        // move shape
    }

    @Override
    public void draw() {
        // draw shape
    }

}
