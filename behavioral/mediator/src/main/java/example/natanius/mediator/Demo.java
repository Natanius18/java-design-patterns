package example.natanius.mediator;

import example.natanius.mediator.components.AddButton;
import example.natanius.mediator.components.DeleteButton;
import example.natanius.mediator.components.Filter;
import example.natanius.mediator.components.List;
import example.natanius.mediator.components.SaveButton;
import example.natanius.mediator.components.TextBox;
import example.natanius.mediator.components.Title;
import example.natanius.mediator.mediator.Editor;
import example.natanius.mediator.mediator.Mediator;
import javax.swing.DefaultListModel;

public class Demo {
    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}
