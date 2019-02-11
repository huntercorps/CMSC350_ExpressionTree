package smith;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * A Driver class that creates A GUI to allows users to
 * input a postfix expression and parses it to an infix expression.
 * and writes the TIA represntation of the expression to a file.
 *
 * @author Hunter Smith
 */
public class AppDriver extends JFrame{
    //Class Variables
    private JPanel inputPanel, buttonPanel, resultPanel;
    private JLabel inputLabel, resultLabel;
    private JTextField inputField, resultField;
    private JButton evaluateButton;

    /**
     * Instantiates a new App view controller.
     */
    private AppDriver() {
        super("Three Address Generator");
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        createView();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(445,155);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    /**
     * Create view. A helper method that setups the GUI frame components
     * and ActionListener.
     * @see #buttonPress().
     */
    private void createView() {

        //Setup Input panel
        add(inputPanel = new JPanel(), BorderLayout.NORTH);
        inputPanel.add(inputLabel = new JLabel("Enter Postfix Expression"));
        inputPanel.add(inputField = new JTextField(25));
        inputField.setPreferredSize(new Dimension(25,25));

        //Setup Button Panel and Button controller
        add(buttonPanel = new JPanel(),BorderLayout.CENTER);
        buttonPanel.setBorder(new EmptyBorder(10, 0, 5, 20));
        buttonPanel.add(evaluateButton = new JButton("Construct Tree"));
        evaluateButton.setPreferredSize(new Dimension(145,35));
        evaluateButton.addActionListener(e->buttonPress());

        //Setup Results panel
        add(resultPanel = new JPanel(),BorderLayout.SOUTH);
        resultPanel.setBorder(new EmptyBorder(0, 0, 7, 0));
        resultPanel.add(resultLabel = new JLabel("Infix Expression"));
        resultPanel.add(resultField = new JTextField(25));
        resultField.setPreferredSize(new Dimension(25,25));
        resultField.setEditable(false);
    }


    /**
     * Button press. Provides the controller aspect between
     * AppViewController and the Model. creates a instance of
     * of the model and passes in the input.
     *
     * provides handling of division by zero and incorrect infix
     * expressions.
     */
    private void buttonPress() {
            ExprTree tree = new ExprTree(inputField.getText());
            resultField.setText(tree.getRoot().infix());
            FileWriter.writeToFile(new ParseExprTreeToTIA().buildInstructionString(tree.getRoot()));
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        AppDriver app = new AppDriver();
    }
}

