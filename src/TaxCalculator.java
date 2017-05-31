import java.util.LinkedList;

class TaxSlab {
    int min;
    int max;
    double percentage;

    TaxSlab(int min, int max, double percentage) {
        this.min = min;
        this.max  = max;
        this.percentage = percentage;
    }

    public double calculate(double amount) {
        if (min < amount) {
            if (max < amount) {
                return (max - min) * percentage;
            }
            return (amount - min) * percentage;
        }
        return 0;
    }
}
public class TaxCalculator {
    private LinkedList<TaxSlab> taxSlabs = new LinkedList<>();

    private void calculateTax(double salary) {
        double tax = 0;
        for(TaxSlab slab: taxSlabs) {
            tax += slab.calculate(salary);
        }
        System.out.println(tax);
    }

    public void addTaxSlab(int min, int max, double percentage) {
        TaxSlab taxSlab = new TaxSlab(min, max, percentage);
        taxSlabs.add(taxSlab);
    }

    private boolean merge(TaxSlab newSlab) {
        for (TaxSlab taxSlab : taxSlabs) {
            if (taxSlab.max > newSlab.min) {

            }
        }
        return false;
    }

    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator();
        calculator.addTaxSlab(0, 1000, 0.1);
        calculator.addTaxSlab(1000, 2000, 0.3);
        calculator.calculateTax(1500);
    }
}
