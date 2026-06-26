import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField t1, t2, result;
    JButton add, sub, mul, div;

    Calculator() {
        setTitle("Simple Calculator");
        setSize(350, 250);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("First Number:"));
        t1 = new JTextField(15);
        add(t1);

        add(new JLabel("Second Number:"));
        t2 = new JTextField(15);
        add(t2);

        add = new JButton("Add");
        sub = new JButton("Subtract");
        mul = new JButton("Multiply");
        div = new JButton("Divide");

        add(add);
        add(sub);
        add(mul);
        add(div);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        add(new JLabel("Result:"));
        result = new JTextField(15);
        result.setEditable(false);
        add(result);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(t1.getText());
            double num2 = Double.parseDouble(t2.getText());
            double res = 0;

            if (e.getSource() == add)
                res = num1 + num2;
            else if (e.getSource() == sub)
                res = num1 - num2;
            else if (e.getSource() == mul)
                res = num1 * num2;
            else if (e.getSource() == div) {
                if (num2 == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                res = num1 / num2;
            }

            result.setText(String.valueOf(res));

        } catch (NumberFormatException ex) {
            result.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}