package dev.codefactory.designpatterns.decorator;

public class BasicMessageDecorator implements MessageDecorator {

    @Override
    public String decorate(String message) {
        return message;
    }
}
