package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    //zwraca wartosc boolean -> true jesli usuwanie sie powiodlo, false -> jesli obkiekt nie zostal usuniety
    public boolean removeFigure(Shape shape) {
        return shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n >= 0 && n < shapes.size()) {
            return shapes.get(n);
        }
        return null;
    }

    public String showFigures() {
        StringBuilder result = new StringBuilder();
        //przechodzimy przez każda figurę w kolekcji i dodajemy jej nazwe do result oddzielając przecinkami
        for (Shape shape : shapes) {
            result.append(shape.getShapeName()).append(", ");
        }
        if (result.length() > 0) {
            // Ostatni przecinek i spacja jest usuwana
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }
}
