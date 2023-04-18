// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
// Import the necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
public class Main {

    // Method that is called when an AWT event is detected

    public static void main(String[] args) throws InterruptedException, AWTException {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        StartForm startForm = new StartForm();
        int work_min = startForm.getWork_min();
        int rest_min = startForm.getRest_min();
        System.out.println(work_min);
        System.out.println(rest_min);
        startForm.setVisible(true);
    }

}