package example.natanius.factory;


import example.natanius.buttons.Button;
import example.natanius.buttons.HtmlButton;

public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
