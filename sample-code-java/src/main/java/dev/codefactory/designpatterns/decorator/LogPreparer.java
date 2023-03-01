package dev.codefactory.designpatterns.decorator;

public class LogPreparer {

    private final MessageDecorator messageDecorator;

    public LogPreparer(MessageDecorator messageDecorator) {
        this.messageDecorator = messageDecorator;
    }

    public String prepare(String logMessage) {
        return messageDecorator.decorate(logMessage);
    }
}
