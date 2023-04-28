public class Main {
    public static void main(String[] args) {

    }

    class BankAccount{
        int balance;
        int previousTransaction;
        String customerName;
        String customerId;

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

        }
    }
}