import java.io.PrintStream;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {
        WindowPane testOutput1 = createWindowPane("Test", 600, 600);
        WindowPane testOutput2 = createWindowPane("Test2", 600, 600);

        PrintStream standard = System.out;
        PrintStream newPrintStream = new PrintStream(new WindowOutputStream(testOutput1));
        PrintStream newPrintStream2 = new PrintStream(new WindowOutputStream(testOutput2));

        printToNewWindow(standard, "Hello world");
        printToNewWindow(newPrintStream, "Hello world in new window");
        printToNewWindow(newPrintStream2, "Hello world in another new window");
    }

    private static WindowPane createWindowPane(String title, int width, int height) {
        WindowPane windowPane = new WindowPane();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(windowPane);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle(title);
        return windowPane;
    }

    public static void printToNewWindow(PrintStream printStream, String content) {
        System.setOut(printStream);
        System.out.println(content);
    }
}
