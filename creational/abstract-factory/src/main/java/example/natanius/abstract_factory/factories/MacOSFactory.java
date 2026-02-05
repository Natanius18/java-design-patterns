package example.natanius.abstract_factory.factories;


import example.natanius.abstract_factory.buttons.Button;
import example.natanius.abstract_factory.buttons.MacOSButton;
import example.natanius.abstract_factory.checkboxes.Checkbox;
import example.natanius.abstract_factory.checkboxes.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
