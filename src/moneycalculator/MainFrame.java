package moneycalculator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator.model.ui.MoneyDialog;
import moneycalculator.model.ui.MoneyDisplay;
import moneycalculator.model.ui.swing.MoneyDialogSwing;
import moneycalculator.model.ui.swing.MoneyDisplaySwing;


public class MainFrame extends JFrame {
    
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;

    public MainFrame() {
        setTitle("Money Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(moneyDialog(), BorderLayout.NORTH);
        add(moneyDisplay());
        add(toolbar(), BorderLayout.SOUTH);
        setVisible(true);
    }

    private Component moneyDialog() {
        MoneyDialogSwing dialog = new MoneyDialogSwing();
        moneyDialog = dialog;
        return dialog;
    }

    private Component moneyDisplay() {
        MoneyDisplaySwing display = new MoneyDisplaySwing();
        moneyDisplay = display;
        return display;
    }

    private Component toolbar() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(calculateButton());
        return panel;
    }

    private Component calculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(calculate());
        return button;
    }

    private ActionListener calculate() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                moneyDisplay.display(moneyDialog.get());
            }
        };

}
    
    
    
}