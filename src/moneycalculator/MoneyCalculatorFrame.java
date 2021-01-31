
package moneycalculator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator.control.Command;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyDisplay;
import moneycalculator.ui.swing.SwingMoneyDialog;
import moneycalculator.model.Currency;
import moneycalculator.ui.swing.SwingMoneyDisplay;

public class MoneyCalculatorFrame extends JFrame {
    private final List<Currency> currencies;
    private final Map<String,Command> commands = new HashMap<>();
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;
    
    public MoneyCalculatorFrame(List<Currency> currencies) {
        this.currencies = currencies;
        this.setTitle("MONEY CALCULATOR");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(moneyDialog(), BorderLayout.NORTH);
        this.add(toolbar(), BorderLayout.CENTER);
        this.add(moneyDisplay(), BorderLayout.SOUTH);      
        this.setVisible(true);        
    }
    
    public void add (Command command){
        commands.put(command.name(), command);
    }
    
    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }
    
    private Component moneyDialog() {
       SwingMoneyDialog swingMoneyDialog = new SwingMoneyDialog(currencies);
       this.moneyDialog = swingMoneyDialog;
       return swingMoneyDialog;
    }

    private Component toolbar() {
        JPanel toolBarPanel = new JPanel();
        toolBarPanel.add(calculateButton());
        return toolBarPanel;
    }

    private Component moneyDisplay() {
        SwingMoneyDisplay swingMoneyDisplay = new SwingMoneyDisplay();
        this.moneyDisplay = swingMoneyDisplay;
        return swingMoneyDisplay;
    }

    private JButton calculateButton() {
        JButton button = new JButton("calculate"); 
        button.addActionListener(calculate());       
        return button;        
    }

    private ActionListener calculate() {
        return new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent actionEvent) {
              commands.get("calculate").execute();
          }
        };
    }
    
    
}
