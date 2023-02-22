package dev.codefactory.designpatterns.singleton;

public class SingletonService {

    private static final SingletonService INSTANCE = new SingletonService();
    public static SingletonService getInstance() {
        return INSTANCE;
    }
}
