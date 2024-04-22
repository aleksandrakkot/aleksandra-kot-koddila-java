package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String text, PoemDecorator decorator) {
        String decoratedText = decorator.decorate(text);
        System.out.println(decoratedText);
    }
}
