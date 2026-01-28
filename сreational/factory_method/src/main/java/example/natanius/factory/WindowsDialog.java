package example.natanius.factory;

import example.natanius.buttons.Button;
import example.natanius.buttons.WindowsButton;

public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
