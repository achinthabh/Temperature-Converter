import javax.swing.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame implements ActionListener {
    JTextField inputField;
    JRadioButton toCelsius, toKelvin;
    JButton showResult;
    JLabel resultLabel;

    public TemperatureConverter() {

        inputField = new JTextField(10);
        toCelsius = new JRadioButton("to Celsius");
        toKelvin = new JRadioButton("to Kelvin");
        showResult = new JButton("Show Result");
        resultLabel = new JLabel("Result: ");


        ButtonGroup group = new ButtonGroup();
        group.add(toCelsius);
        group.add(toKelvin);


        showResult.addActionListener(this);


        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter Fahrenheit:"));
        panel.add(inputField);
        panel.add(toCelsius);
        panel.add(toKelvin);
        panel.add(showResult);
        panel.add(resultLabel);


        add(panel);


        setTitle("Temperature Converter");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double fahrenheit = Double.parseDouble(inputField.getText());
            double result = 0;

            if (toCelsius.isSelected()) {
                result = (fahrenheit - 32) * 5 / 9;
                resultLabel.setText("Result: " + String.format("%.2f", result) + " °C");
            } else if (toKelvin.isSelected()) {
                result = (fahrenheit - 32) * 5 / 9 + 273.15;
                resultLabel.setText("Result: " + String.format("%.2f", result) + " K");
            } else {
                resultLabel.setText("Select a conversion option.");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new TemperatureConverter();
    }
}
