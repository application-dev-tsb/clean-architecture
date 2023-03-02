package dev.codefactory.designpatterns.decorator

import spock.lang.Specification

import java.time.LocalDate
import java.util.function.Supplier

/**
 * Description:
 * - dynamically extend behavior without inheritance
 * - client-specified composition by recursive wrapping
 *
 * Decorator Pattern
 * https://sourcemaking.com/design_patterns/decorator
 *
 * Decorator in Spring
 * https://www.youtube.com/watch?v=CzdCmHxWbOg
 *
 * Personal Comments:
 *
 * E = n/a
 * A = we abstracted away the code that prepares the string from the code that assembles it for logging
 * I = n/a
 * P = at runtime, the decorator could be anything
 *
 * S = one reason for change
 * O = open for extension - by adding a new decorator, no need to modify existing code to add func
 * L = you can substitute any decorator
 * I = interfaces were kept simple, we didnt force unrelated implementation
 * D = the lower level of abstraction was handled by the Message Decorator
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
