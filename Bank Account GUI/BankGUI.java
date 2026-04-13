import javax.swing.*;

public class BankGUI extends JFrame {

    static BankAccount account;

    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog("Please enter your name:");
        String deposit = JOptionPane.showInputDialog("Enter initial deposit:");
        double initialAmount = 0.0;

        try {
            initialAmount = Double.parseDouble(deposit);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Please enter valid number");
            System.exit(0);
        }

        String type = JOptionPane.showInputDialog("Enter '1' for Checking or '2' for Savings:");
        if (type.equals("1")) {
            account = new CheckingAccount(name, initialAmount);
        } else if (type.equals("2")) {
            account = new SavingsAccount(name, initialAmount);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid type.");
            System.exit(0);
        }

        JFrame window = new JFrame("Bank Account Manager");
        window.setSize(400, 400);
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel welcomeLabel = new JLabel("Welcome, " + account.getAccountHolder() + "!");
        JLabel balanceLabel = new JLabel("Current Balance: $" + account.getBalance());

        JLabel instructionLabel = new JLabel("Enter Amount:");
        JTextField amountInput = new JTextField();

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton exitButton = new JButton("Exit");

        depositButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountInput.getText());
                account.deposit(amount);
                balanceLabel.setText("Current Balance: $" + account.getBalance());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: Please enter valid number");
            }
        });

        withdrawButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountInput.getText());
                account.withdraw(amount);
                balanceLabel.setText("Current Balance: $" + account.getBalance());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: Please enter valid number");
            }
        });

        exitButton.addActionListener(e -> System.exit(0));

        window.add(welcomeLabel);
        window.add(balanceLabel);
        window.add(instructionLabel);
        window.add(amountInput);
        window.add(depositButton);
        window.add(withdrawButton);
        window.add(exitButton);

        window.setVisible(true);
    }
}
