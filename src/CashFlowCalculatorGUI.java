import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Variables below are automatically generated as I make edits/additions to the GUI through the Swing UI Design form
public class CashFlowCalculatorGUI {
    private JTextField txtPurchasePrice;
    private JTextField txtMortgageRate;
    private JTextField txtPropertyTaxes;
    private JTextField txtInsurance;
    private JTextField txtRentalIncome;
    private JButton calculateCashFlowButton;
    private JLabel txtTitle;
    private JPanel Main;
    private JTextField txtCashFlow;
    private JTextField txtConclusion;
    private JTextField txtMortgagePayment;
    private JTextField txtDownPayment;
    private JButton clearButton;

    // Mains Method.
    public static void main(String[] args) {
        JFrame frame = new JFrame("CashFlowCalculatorGUI");
        frame.setContentPane(new CashFlowCalculatorGUI().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public CashFlowCalculatorGUI() {
        calculateCashFlowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double purchasePrice, downPayment, mortgageRate, propertyTaxes, insurance, rentalIncome, mortgagePayment, monthlyCashFlow;

                //declaring the variables and getting the input from the user
                purchasePrice = Double.parseDouble(txtPurchasePrice.getText());
                downPayment = Double.parseDouble(txtDownPayment.getText());
                mortgageRate = Double.parseDouble(txtMortgageRate.getText());
                propertyTaxes = Double.parseDouble(txtPropertyTaxes.getText());
                insurance = Double.parseDouble(txtInsurance.getText());
                rentalIncome = Double.parseDouble(txtRentalIncome.getText());

                // declaring variables to calculate the monthly mortgage payment. 30 year fixed loan.
                double principal = purchasePrice - downPayment;
                double monthlyInterestRate = mortgageRate / 12.0;
                int termInMonths = 360;
                mortgagePayment = Math.round((principal * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -termInMonths)));
                // displaying the mortgage payment
                txtMortgagePayment.setText(String.valueOf(mortgagePayment));

                //declaring variables to calculate the monthly cashFlow.
                double monthlyExpenses = propertyTaxes + insurance;
                double totalExpenses = monthlyExpenses + mortgagePayment;
                monthlyCashFlow = Math.round(rentalIncome - totalExpenses);
                //displaying the expected monthly cashFlow, after accounting for expenses.
                txtCashFlow.setText(String.valueOf(monthlyCashFlow));

                // Displaying the Conclusion: if the monthly cashFlow is >= $200, then it's a good investment opportunity.
                // Else it may not be.
                if(monthlyCashFlow >= 200) {
                    txtConclusion.setText("This property would cashflow $" + monthlyCashFlow + " every month.");
                } else {
                    txtConclusion.setText("This property would only cashflow $" + monthlyCashFlow + " every month.");
                }
            }
        });

        // Code for the Clear Button.
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPurchasePrice.setText("");
                txtDownPayment.setText("");
                txtMortgageRate.setText("");
                txtPropertyTaxes.setText("");
                txtInsurance.setText("");
                txtRentalIncome.setText("");
                txtMortgagePayment.setText("");
                txtCashFlow.setText("");
                txtConclusion.setText("");
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
