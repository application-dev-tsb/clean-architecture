package dev.codefactory.designpatterns.decorator

import spock.lang.Specification

import java.time.LocalDate
import java.util.function.Supplier

/**
 * Decorator Pattern
 * https://sourcemaking.com/design_patterns/decorator
 *
 * Decorator in Spring
 * https://www.youtube.com/watch?v=CzdCmHxWbOg
 */
class DecoratorSpec extends Specification {

    def 'it should recursively attach behavior'() {

        given: 'a class that assembles the basic message'
        MessageDecorator basic = new BasicMessageDecorator()

        and: 'another class that prepends the current time to the message'
        LocalDate testTime = LocalDate.now()
        Supplier<LocalDate> dateSupplier = () -> testTime
        MessageDecorator timeAppender = new DateAppenderMessageDecorator(basic, dateSupplier)

        and: 'another clas that appends a period if its not present'
        MessageDecorator periodDecorator = new PeriodMessageDecorator(timeAppender)

        and: 'a class that prints a message to the screen'
        LogPreparer preparer = new LogPreparer(periodDecorator)

        and: 'a plain message'
        def message = "Test Message"

        when:
        def result = preparer.prepare(message)

        then:
        result.startsWith("[")
        result.contains("]")
        result.endsWith(".")
        result.contains(message)
    }
}
