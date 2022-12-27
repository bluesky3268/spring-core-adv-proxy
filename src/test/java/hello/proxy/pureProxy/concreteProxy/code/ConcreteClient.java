package hello.proxy.pureProxy.concreteProxy.code;

public class ConcreteClient{

    private ConcreteLogic concreteProxy;

    public ConcreteClient(ConcreteLogic concreteProxy) {
        this.concreteProxy = concreteProxy;
    }

    public void execute() {
        concreteProxy.operation();
    }

}
