package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for ShapeCollector class")
public class ShapeCollectorTestSuite {
    @Nested
    @DisplayName("Tests for adding and removing figures")
    class AddingAndRemovingFigures {
        @Test
        @DisplayName("Test for adding figure to collection")
        void testAddFigure() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(5);

            // When
            shapeCollector.addFigure(square);

            // Then
            //Sprawdzamy czy figura dodana do kolekcji jest na pozycji 0
            assertEquals(square, shapeCollector.getFigure(0));
        }

        @Test
        @DisplayName("Test for removing figure from collection")
        void testRemoveFigure() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(3);
            shapeCollector.addFigure(circle);

            // When
            boolean result = shapeCollector.removeFigure(circle);

            // Then
            // Sprawdzamy czy nie można uzyskać figury z kolekcji po jej usunięciu
            assertNull(shapeCollector.getFigure(0));
            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Tests for getting figures from collection")
    class GettingFigures {

        @Test
        @DisplayName("Test for getting figure from collection by index")
        void testGetFigure() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle(4, 5, 6);
            shapeCollector.addFigure(triangle);

            // When
            Shape result = shapeCollector.getFigure(0);

            // Then
            assertEquals(triangle, result);
        }

        @Test
        @DisplayName("Test for getting figure from empty collection by index")
        void testGetFigureFromEmptyCollection() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();

            // When
            Shape result = shapeCollector.getFigure(0);

            // Then
            assertNull(result);
        }
    }

    @Nested
    @DisplayName("Tests for showing figures")
    class ShowingFigures {
        @Test
        @DisplayName("Test for showing figures in collection")
        void testShowFigures() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Square(5));
            shapeCollector.addFigure(new Circle(3));
            shapeCollector.addFigure(new Triangle(4, 5, 6));

            // When
            String result = shapeCollector.showFigures();

            // Then
            assertEquals("Square, Circle, Triangle", result);
        }

        @Test
        @DisplayName("Test for showing figures in empty collection")
        void testShowFiguresEmptyCollection() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();

            // When
            String result = shapeCollector.showFigures();

            // Then
            assertEquals("", result);
        }
    }
}
