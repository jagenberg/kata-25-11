package moneycalculator.model.ui.swing;

import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moneycalculator.model.Money;
import moneycalculator.model.ui.MoneyDisplay;

public class MoneyDisplaySwing extends JPanel implements MoneyDisplay{

    private Money money;

    public MoneyDisplaySwing(Money money) {
           setLayout(new FlowLayout());
    }

    @Override
    public void display(Money money) {
        this.money = money;
        this.removeAll();
        this.add(amount());
        this.add(currency());
        this.updateUI();
    }

    private Component amount() {
        return new JLabel(String.valueOf(money.getAmount()));
    }

    private Component currency() {
        return new JLabel(money.getCurrency().getCode());
    }
    
    
    
}
