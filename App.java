import java.io.PrintStream;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {
        WindowPane windowPane = new WindowPane();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(windowPane);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Test");

        PrintStream standard = System.out;
        PrintStream newPrintStream = new PrintStream(new WindowOutputStream(windowPane));

        printToNewWindow(standard, "Hello world");
        printToNewWindow(newPrintStream, "Hello world in new window");
    }

    public static void printToNewWindow(PrintStream printStream, String content) {
        System.setOut(printStream);
        System.out.println(content);
    }
}
