// render the GUI Components (frontend)
// this class will inherit from the JFrame class
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PasswordGeneratorGUI extends JFrame {
    private PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI() {
        super("Password Generator"); //render frame, add title
        setSize(540,570);
        setResizable(false);
        setLayout(null); //set layout to be null to have control over the position and size
                                // of the components in the app
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        passwordGenerator = new PasswordGenerator();
        // RENDER GUI COMPONENTS
        addGuiComponents();
    }

    private void addGuiComponents() {
        // Create title text
        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0,10,540,39);
        add(titleLabel); // add to GUI

        JTextArea passwordOutput = new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        // -> add scrollability in case output becomes too big
        passwordOutputPane.setBounds(25,97,479,70);
        // create a black border around the text area
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);

        // create password length label
        JLabel passwordLabelLength = new JLabel("Password length: ");
        passwordLabelLength.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLabelLength.setBounds(25,215,272,39);
        add(passwordLabelLength);

        // create password length input
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310,215,192,39);
        add(passwordLengthInputArea);

        // create toggle buttons
            // uppercase letter toggle
            JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
            uppercaseToggle.setFont(new Font("Dialog",Font.PLAIN, 26));
            uppercaseToggle.setBounds(25,302,225,56);
            add(uppercaseToggle);
            // lowercase letter toggle
            JToggleButton lowerToggle = new JToggleButton("Lowercase");
            lowerToggle.setFont(new Font("Dialog",Font.PLAIN, 26));
            lowerToggle.setBounds(282,302,225,56);
            add(lowerToggle);
            // Numbers toggle
            JToggleButton numbersToggle = new JToggleButton("Numbers");
            numbersToggle.setFont(new Font("Dialog",Font.PLAIN, 26));
            numbersToggle.setBounds(25,373,225,56);
            add(numbersToggle);
            // Symbols toggle
            JToggleButton symbolsToggle = new JToggleButton("Symbols");
            symbolsToggle.setFont(new Font("Dialog",Font.PLAIN, 26));
            symbolsToggle.setBounds(282,373,225,56);
            add(symbolsToggle);

        // Create generate button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155,477,222,41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // validation: length > 0, one of the toggles is pressed
                if (passwordLengthInputArea.getText().length() <= 0) return;
                boolean anyToggleSelected = lowerToggle.isSelected() 
                                            || uppercaseToggle.isSelected() 
                                            || symbolsToggle.isSelected() 
                                            || numbersToggle.isSelected();
                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                if (anyToggleSelected) {
                    String generatedPassword = passwordGenerator.generatorPassword(passwordLength, 
                    uppercaseToggle.isSelected(), lowerToggle.isSelected(), 
                    numbersToggle.isSelected(), symbolsToggle.isSelected());
                    passwordOutput.setText(generatedPassword);
                }
            }
        }); 
        add(generateButton);
    }
}
