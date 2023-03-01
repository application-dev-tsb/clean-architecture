package dev.codefactory.designpatterns.decorator;

public class PeriodMessageDecorator implements MessageDecorator {

    private final MessageDecorator messageDecorator;

    PeriodMessageDecorator(MessageDecorator messageDecorator) {
        this.messageDecorator = messageDecorator;
    }

    @Override
    public String decorate(String message) {
        return messageDecorator.decorate(message) + ".";
    }
}
