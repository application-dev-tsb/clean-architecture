package dev.codefactory.designpatterns.singleton

import spock.lang.Specification

class SingletonServiceSpec extends Specification {

    def 'it should create a single instance'() {

        when:
        SingletonService instance1 = SingletonService.getInstance()
        SingletonService instance2 = SingletonService.getInstance()

        then:
        instance1 === instance2
    }
}
