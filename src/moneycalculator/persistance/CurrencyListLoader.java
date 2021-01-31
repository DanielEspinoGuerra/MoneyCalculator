
package moneycalculator.persistance;

import java.util.List;
import moneycalculator.model.Currency;


public interface CurrencyListLoader {
   public List<Currency> currencies();
}
