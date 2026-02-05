package example.natanius;

import example.natanius.factory.Dialog;
import example.natanius.factory.HtmlDialog;
import example.natanius.factory.WindowsDialog;

public class DemoFactoryMethod {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
