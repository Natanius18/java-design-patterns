package example.natanius.abstract_factory.factories;


import example.natanius.abstract_factory.buttons.Button;
import example.natanius.abstract_factory.checkboxes.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
