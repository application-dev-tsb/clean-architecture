package dev.codefactory.designpatterns.decorator;

import java.time.LocalDate;
import java.util.function.Supplier;

public class DateAppenderMessageDecorator implements MessageDecorator {

    private final MessageDecorator messageDecorator;
    private final Supplier<LocalDate> dateSupplier;

    public DateAppenderMessageDecorator(MessageDecorator messageDecorator, Supplier<LocalDate> dateSupplier) {
        this.messageDecorator = messageDecorator;
        this.dateSupplier = dateSupplier;
    }

    @Override
    public String decorate(String message) {
        return "[" + dateSupplier.get() + "] " + messageDecorator.decorate(message);
    }
}
