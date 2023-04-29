import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      BankAccount bank = new BankAccount("ABC", "BA001");
      bank.showMenu();
    }
}

class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid){
        customerName = cname;
        customerId = cid;
    }
    void deposit(int amount){
        if(amount > 0){
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if(amount > 0){
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Depositado: "+previousTransaction);
        }
        else if(previousTransaction < 0){
            System.out.println("Saque: "+Math.abs(previousTransaction));
        }
        else{
            System.out.println("Nenhuma transação realizada");
        }
    }

    void showMenu(){
        char option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo, " + customerName);
        System.out.println("Seu Id é: " + customerId);
        System.out.println("\n");

        do {
            System.out.println("=".repeat(15));
            System.out.println("Escolha uma opção");
            System.out.println("=".repeat(15));
            System.out.println("1 - Ver Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transação anterior");
            System.out.println("5 - Sair");
            System.out.println("-".repeat(15));
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case '1' -> {
                    System.out.println("-".repeat(15));
                    System.out.println("Saldo =" + balance);
                    System.out.println("-".repeat(15));
                    System.out.println("\n");
                }
                case '2' -> {
                    System.out.println("-".repeat(15));
                    System.out.println("Insira o valor a ser depositado =");
                    System.out.println("-".repeat(15));
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                }
                case '3' -> {
                    System.out.println("-".repeat(15));
                    System.out.println("Insira o valor a ser sacado =");
                    System.out.println("-".repeat(15));
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                }
                case '4' -> {
                    System.out.println("-".repeat(15));
                    getPreviousTransaction();
                    System.out.println("-".repeat(15));
                    System.out.println("\n");
                }
                case '5' -> System.out.println("*".repeat(15));
                default -> System.out.println("Insira uma opção válida");
            }
        } while(option != '5');
        System.out.println("Obrigado por usar nossos serviços!");
    }
}