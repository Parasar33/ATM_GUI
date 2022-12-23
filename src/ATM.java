import javax.swing.*;
import java.util.*;

public class ATM
{
    //login page ->done
    //online login credentials -> done
    //administration to login -> done
    //Operations page after successfull login -> done
    static void LoginPage(int PIN)
    {
        PIN = Integer.parseInt(JOptionPane.showInputDialog("Enter PIN"));
        if(PIN!=1234)
        {
            JOptionPane.showMessageDialog(null,":::: ERROR ::::\n\n You have been blocked from access \n\n Try using Online Banking Credentials");
        }
        else Operations();
    }

    static void Administrator()
    {
        String username = JOptionPane.showInputDialog("Enter username");
        if(Objects.equals(username, "rishav"))
        {
            int passowrd = Integer.parseInt(JOptionPane.showInputDialog("Enter password"));
            if (passowrd != 78725)
            {
                JOptionPane.showMessageDialog(null,":::: ERROR ::::\n\n FAKE LOGIN DETECTED\n");
                System.exit(0);
            }
            else {
                String choice = JOptionPane.showInputDialog("WELCOME TO AUTHORITY\n\nProceed to Bank Operations\n(yes/no)");
                if (Objects.equals(choice, "yes" ))
                {
                    Operations();
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,":::: ERROR ::::\n\n FAKE LOGIN DETECTED");
            System.exit(0);
        }
    }

    static void LoginWay2()
    {
        String banking_username = JOptionPane.showInputDialog("Enter Online Banking Username");
        if(Objects.equals(banking_username, "rishav33"))
        {
            int password = Integer.parseInt(JOptionPane.showInputDialog("Enter password"));
            if (password != 123456)
            {
                JOptionPane.showMessageDialog(null,":::: ERROR ::::\n\n FAKE LOGIN DETECTED\nTry contacting administrator if you think it's a mistake");
                System.exit(0);
            }
            else {
                    Operations();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,":::: ERROR ::::\n\n FAKE LOGIN DETECTED\nTry contacting administrator if you think it's a mistake");
            System.exit(0);
        }

    }
    static void Operations() {
        int balance = 69069, operations;
        do {
            operations = Integer.parseInt(JOptionPane.showInputDialog("Proceed in one of these\n1.Check Balance\n2.Withdraw Money\n3.Deposit Money\n4.Exit"));
//            Scanner sc = new Scanner(System.in);
//            operations = sc.nextInt();
            switch (operations) {
                case 1: {
                    Balance(balance);
                    break;
                }
                case 2: {
                    int WidAmount = Integer.parseInt(JOptionPane.showInputDialog("Enter The Amount To Withdraw\n<amount must be a multiple of 500>"));
                    if (WidAmount > balance) {
                        JOptionPane.showMessageDialog(null, "Amount to Withdraw Can't be More than Balance\nExit Balance: ₹" + balance);
                    } else if (WidAmount < 500) {
                        JOptionPane.showMessageDialog(null, "Amount to Withdraw Can't be Less than 500\nExit Balance: ₹" + balance);
                    } else {
                        balance -= WidAmount;
                        JOptionPane.showMessageDialog(null, "Withdrawal Done\nExit Balance: ₹"+balance);
                    }
                    break;
                }

                case 3 : {
                    int DepAmount = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount to Deposit"));
                    if(DepAmount < 500){
                        JOptionPane.showMessageDialog(null, "Amount to Deposit Must be more than 500\nExit Balance: ₹"+balance);
                    }
                    else {
                        balance +=DepAmount;
                        JOptionPane.showMessageDialog(null, "Deposit Done\nExit Balance: ₹"+balance);
                    }
                }
                case 4: {
                    JOptionPane.showMessageDialog(null, "Thanks for Using Our ATM Service");
                    System.exit(0);
                    break;
                }
            }
        } while (operations != 4);

    }

    static void Balance(int bal)
    {
        JOptionPane.showMessageDialog(null,"Total Balance : ₹"+bal);
    }
    public static void main(String[] args) {
       int option = Integer.parseInt(JOptionPane.showInputDialog("Choose one of the operations to proceed\n1.Login\n2.Login Using Banking Credentials\n3.Administrator Login"));
        switch (option)
        {
            case 1 -> {LoginPage(1234);}
            case 2 -> {LoginWay2();}
            case 3 -> {Administrator();}
        }

    }

}
