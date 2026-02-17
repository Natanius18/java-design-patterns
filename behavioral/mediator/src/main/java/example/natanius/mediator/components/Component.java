package example.natanius.mediator.components;


import example.natanius.mediator.mediator.Mediator;

public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
