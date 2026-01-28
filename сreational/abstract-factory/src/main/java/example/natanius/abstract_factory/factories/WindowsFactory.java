package example.natanius.abstract_factory.factories;


import example.natanius.abstract_factory.buttons.Button;
import example.natanius.abstract_factory.buttons.WindowsButton;
import example.natanius.abstract_factory.checkboxes.Checkbox;
import example.natanius.abstract_factory.checkboxes.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
