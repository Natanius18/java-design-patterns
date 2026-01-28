package example.natanius.factory;


import example.natanius.buttons.Button;


public abstract class Dialog {

    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}
