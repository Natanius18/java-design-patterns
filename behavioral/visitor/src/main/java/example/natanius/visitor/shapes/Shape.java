package example.natanius.visitor.shapes;

import example.natanius.visitor.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
