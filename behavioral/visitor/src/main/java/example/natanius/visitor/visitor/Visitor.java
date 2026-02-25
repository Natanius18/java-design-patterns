package example.natanius.visitor.visitor;

import example.natanius.visitor.shapes.Circle;
import example.natanius.visitor.shapes.CompoundShape;
import example.natanius.visitor.shapes.Dot;
import example.natanius.visitor.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
