package moneycalculator;

import moneycalculator.control.CalculateCommand;
import moneycalculator.persistance.CurrencyListLoader;
import moneycalculator.persistance.ExchangeRateLoader;
import moneycalculator.persistance.file.FileCurrencyListLoader;
import moneycalculator.persistance.rest.RestExchangeRateLoader;



public class MoneyCalculator {
    public static void main(String[] args) throws Exception {
        CurrencyListLoader currencyLoader = new FileCurrencyListLoader("currencies.txt");
        ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        
        MoneyCalculatorFrame moneyCalculatorFrame = new MoneyCalculatorFrame(currencyLoader.currencies());  
        moneyCalculatorFrame.add(new CalculateCommand(moneyCalculatorFrame.getMoneyDialog(), moneyCalculatorFrame.getMoneyDisplay(), exchangeRateLoader));    
    }
}
