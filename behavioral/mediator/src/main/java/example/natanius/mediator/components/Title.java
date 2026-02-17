package example.natanius.mediator.components;

import example.natanius.mediator.mediator.Mediator;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class Title extends JTextField implements Component {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        mediator.markNote();
    }

    @Override
    public String getName() {
        return "Title";
    }
}
