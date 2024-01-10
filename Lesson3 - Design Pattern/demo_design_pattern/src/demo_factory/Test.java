package demo_factory;

public class Test {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("circle");
        shape.draw();
        shape = shapeFactory.getShape("square");
        shape.draw();
        shape = shapeFactory.getShape("rectangle");
        shape.draw();
    }
}
