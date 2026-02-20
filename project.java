package fyp;

import java.util.Scanner;

public class Fyp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO ABC BANK ATM");
        double accountBalance = 0;

        System.out.println("Please Enter your four-digit pin:");
        int pin = sc.nextInt();

        sc.nextLine();

        System.out.println("Please Enter your User Name:");
        String user = sc.nextLine();

        if ((pin == 1234) && (user.equals("Burair") || user.equals("burair"))) {
            accountBalance = 100000;
            System.out.println("LOG in Successfully");

        } else if ((pin == 1111 && (user.equals("Hammad") || user.equals("hammad")))) {
            accountBalance = 50000;
            System.out.println("LOG in Successfully");

        } else if ((pin == 2222 && (user.equals("Afnan") || user.equals("afnan")))) {
            accountBalance = 65000;
            System.out.println("LOG in Successfully");
        } else if ((pin == 4444) && (user.equals("Anoosha") || user.equals("anoosha"))) {
            accountBalance = 80000;
            System.out.println("LOG in Successfully");
        } else {
            System.out.println("Invalid pin Or User Name. Try Again.");
            return;
        }

        String[] cato = {"Withdraw", "Deposit", "Check Balance", "Transfer", "Exit"};
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nEnter The Number You Want to Execute:");
            System.out.println("1: " + cato[0]);
            System.out.println("2: " + cato[1]);
            System.out.println("3: " + cato[2]);
            System.out.println("4: " + cato[3]);
            System.out.println("5: " + cato[4]);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected: " + cato[0]);
                    System.out.println("Enter a number to select an amount:");
                    double[] ammount = {500.0, 1000.0, 5000.0, 10000.0, 20000.0};

                    System.out.println("1: " + ammount[0]);
                    System.out.println("2: " + ammount[1]);
                    System.out.println("3: " + ammount[2]);
                    System.out.println("4: " + ammount[3]);
                    System.out.println("5: " + ammount[4]);
                    System.out.println("6: Other Amount");

                    int my = sc.nextInt();
                    double selectedAmount = 0.0;

                    switch (my) {
                        case 1:
                            selectedAmount = ammount[0];
                            break;
                        case 2:
                            selectedAmount = ammount[1];
                            break;
                        case 3:
                            selectedAmount = ammount[2];
                            break;
                        case 4:
                            selectedAmount = ammount[3];
                            break;
                        case 5:
                            selectedAmount = ammount[4];
                            break;
                        case 6:
                            System.out.println("Enter your custom amount:");
                            selectedAmount = sc.nextDouble();
                            break;
                        default:
                            System.out.println("Invalid choice:");
                            continue;
                    }

                    if (accountBalance < selectedAmount) {
                        System.out.println("Insufficient funds.");
                    } else {
                        accountBalance -= selectedAmount;
                        System.out.println("Transaction successful!");
                        System.out.println("Remaining Account Balance: " + accountBalance);
                    }
                    break;

                case 2: // Deposit
                    System.out.println("You selected: " + cato[1]);
                    System.out.println("How much amount do you want to deposit?");
                    double deposit = sc.nextDouble();
                    accountBalance += deposit;
                    System.out.println("You have deposited: " + deposit);
                    System.out.println("Updated Account Balance: " + accountBalance);
                    break;

                case 3: // Check Balance
                    System.out.println("You selected: " + cato[2]);
                    System.out.println("Your Current Account Balance: " + accountBalance);
                    break;

                case 4: // Transfer Funds
                    System.out.println("You selected " + cato[3]);

                    System.out.println("Select the reciptent:");
                    if (!user.equalsIgnoreCase("Burair")) {
                        System.out.println("1: Burair");
                    }
                    if (!user.equalsIgnoreCase("Hammad")) {
                        System.out.println("2: Hammad");
                    }
                    if (!user.equalsIgnoreCase("Afnan")) {
                        System.out.println("3: Afnan");
                    }
                    if (!user.equalsIgnoreCase("Anoosha")) {
                        System.out.println("4: Anoosha");
                    }

                    int recipientChoice = sc.nextInt();
                    String recipient = "";
                    double recipientBalance = 0;

                    switch (recipientChoice) {
                        case 1:
                            recipient = "Burair";
                            recipientBalance = 100000;
                            break;
                        case 2:
                            recipient = "Hammad";
                            recipientBalance = 50000;
                            break;
                        case 3:
                            recipient = "Afnan";
                            recipientBalance = 65000;
                            break;
                        case 4:
                            recipient = "Anoosha";
                            recipientBalance = 80000;
                            break;
                        default:
                            System.out.println("Invalid Recipient Selection, ");
                            continue;
                    }

                    System.out.println("Enter the amount to transfer:");
                    double transferAmount = sc.nextDouble();

                    if (transferAmount > accountBalance) {
                        System.out.println("Insufficent funds for this transfer.");
                    } else {
                        accountBalance -= transferAmount;
                        recipientBalance += transferAmount;
                        System.out.println("Successfully transferred " + transferAmount + " to " + recipient + ".");
                        System.out.println("Your updated balance: " + accountBalance);
                        System.out.println(recipient + "'s updated balance: " + recipientBalance);
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid number.");
                    break;
            }
        }

        sc.close();
    }
}