import p.labs.Lab04B.*;

import java.util.Scanner;
import java.io.*;

public class Lab04B {
    public static void main(String[] args) {
        program();
    }

    public static void program()  {
        Scanner in = new Scanner(System.in);
        int n = 16;
        int c = n/2;
        Client[] clients = new Client[c];
        BankAccount[] bankAccounts = new BankAccount[n];
        try { bankAccounts = readFile(clients,bankAccounts, n); } catch (FileNotFoundException e) { e.printStackTrace(); }
        boolean b = true;
        while (b) {
            switch (menu()) {
                case 1: {
                    printAccount(bankAccounts, n);
                    break;
                }
                case 2: {
                    BankAccount account = accountSearch(bankAccounts,n);
                    account.changeStatus();
                    System.out.println(account);
                    break;
                }
                case 3: {
                    switch (menuSearch()){
                        case 1:{
                            System.out.println("Введите id клиента: ");
                            String string = in.nextLine();
                            int client = clientSearchId(clients, string, c);
                            printClient(client, bankAccounts, n);
                            System.out.println();
                            break;
                        }
                        case 2:{
                            System.out.println("Введите имя клиента: ");
                            String string = in.nextLine();
                            int client = clientSearchName(clients, string, c);
                            printClient(client, bankAccounts, n);
                            System.out.println();
                            break;
                        }
                        case 3:{
                            BankAccount account = accountSearch(bankAccounts, n);
                            System.out.println(account);
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("Введите имя клиента: ");
                    String string = in.nextLine();
                    int client = clientSearchName(clients, string, c);
                    Sum(client, bankAccounts);
                    break;
                }
                case 5: {
                    SUM(bankAccounts, n);
                    break;
                }
                case 6: {
                    sort(bankAccounts, n);
                    break;
                }
                case 7: {
                    b = false;
                    break;
                }
            }
        }
    }

    public static int menu(){
        Scanner in = new Scanner(System.in);
        String[] menu = new String[] {"Меню: ", "1. Клиенты и счета",
                "2. Заблокировать/разблокировать счет клиента", "3. Поиск счета/клиента",
                "4. Вычисление общей суммы по счетам клиента", "5. Общая сумма счетов для всех клиентов",
                "6. Сортирровка счетов","7. Выход" };
        System.out.println();
        for(int i = 0; i < 8; i++)
            System.out.println(menu[i]);
        int choice = in.nextInt();
        return choice;
    }

    public static BankAccount[] readFile(Client[] clients,BankAccount[] bankAccounts, int n) throws FileNotFoundException{
        File file = new File("C:\\Users\\Лариса\\Desktop\\БГУ\\МИиИ\\IdeaProjects\\Labs\\text\\Client.txt");
        Scanner read = new Scanner(file);

        for(int i = 0, ba = 0; i < n/2 && read.hasNextLine(); i++) {
            clients[i] = new Client();
            clients[i].setName(read.nextLine());
            clients[i].setId(read.nextLine());
            clients[i].setEmail(read.nextLine());
            for(int j = 0; j < 2 && read.hasNextLine(); j++, ba++){
                bankAccounts[ba] = new BankAccount(clients[i].getId(), clients[i].getName(), clients[i].getEmail());
                bankAccounts[ba].setNumber(read.nextLine());
                String string = read.nextLine();
                Scanner readString = new Scanner(string);
                bankAccounts[ba].setBalance(readString.nextDouble());
                bankAccounts[ba].setStatus(read.nextLine());
            }
        }
        return bankAccounts;
    }

    public static void printAccount(BankAccount[] bankAccounts, int n){
        for(int i = 0; i < n; i++)
            System.out.println(bankAccounts[i]);
    }

    public static void printClient(int client, BankAccount[] bankAccounts, int n){
        client = client * 2;
        System.out.println(bankAccounts[client]);
        System.out.println(bankAccounts[client+1]);
    }

    public static int menuSearch(){
        Scanner in = new Scanner(System.in);
        String[] menu1 = new String[] {"Поиск счета/клиента ", "1. Поиск клиента по id", "2. Поиск клиента по имени",
                "3. Поиск счета по номеру"};
        System.out.println();
        for(int i = 0; i < 4; i++)
            System.out.println(menu1[i]);
        int choice = in.nextInt();
        return choice;
    }

    public static BankAccount accountSearch(BankAccount[] bankAccounts, int n){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер счета ");
        String string = in.nextLine();
        BankAccount account = new BankAccount();
        account.setNumber(string);
        for (int i = 0; i < n; i++){
            account.setId(bankAccounts[i].getId());
            account.setName(bankAccounts[i].getName());
            account.setEmail(bankAccounts[i].getEmail());
            account.setBalance(bankAccounts[i].getBalance());
            account.setStatus(bankAccounts[i].getStatus());
            if(bankAccounts[i].equals(account))
                return bankAccounts[i];
        }
        return null;
    }

    public static int clientSearchId(Client[] clients, String string, int c){
        Client client = new Client();
        client.setId(string);
        for (int i = 0; i < c; i++){
            client.setName(clients[i].getName());
            client.setEmail(clients[i].getEmail());
            if(clients[i].equals(client))
                return i;
        }
        return 0;
    }

    public static int clientSearchName(Client[] clients, String string, int c){
        Client client = new Client();
        client.setName(string);
        for (int i = 0; i < c; i++){
            client.setId(clients[i].getId());
            client.setEmail(clients[i].getEmail());
            if(clients[i].equals(client))
                return i;
        }
        return 0;
    }

    public static void Sum(int client, BankAccount[] bankAccounts){
        client = client * 2;
        double[] sum = new double[3];
        for(int i = client; i < client + 2; i++){
            sum[0] = sum[0] + bankAccounts[i].getBalance();
            if(bankAccounts[i].getBalance() > 0)
                sum[1] = sum[1] + bankAccounts[i].getBalance();
            else sum[2] = sum[2] + bankAccounts[i].getBalance();
        }
        System.out.println("Общая сумма по счету: " + sum[0]);
        System.out.println("Общая сумма по + счетам: " + sum[1]);
        System.out.println("Общая сумма по - счетам: " + sum[2]);
    }

    public static void SUM(BankAccount[] bankAccounts, int n){
        double[] sum = new double[3];
        for(int i = 0; i < n; i++){
            sum[0] = sum[0] + bankAccounts[i].getBalance();
            if(bankAccounts[i].getBalance() > 0)
                sum[1] = sum[1] + bankAccounts[i].getBalance();
            else sum[2] = sum[2] + bankAccounts[i].getBalance();
        }
        System.out.println("Общая сумма по счетам: " + sum[0]);
        System.out.println("Общая сумма по + счетам: " + sum[1]);
        System.out.println("Общая сумма по - счетам: " + sum[2]);
    }

    public static void sort(BankAccount[] bankAccounts, int n){
        double balance;
        double max;
        int maxj;
        BankAccount work = bankAccounts[0];
        for(int i = 0; i < n-1; i++){
            maxj = i;
            max = bankAccounts[i].getBalance();
            for(int j = i + 1; j < n; j++){
                balance = bankAccounts[j].getBalance();
                if(max < balance){
                    maxj = j;
                    max = balance;
                    work = bankAccounts[j];
                }
            }
            if(i != maxj){
                bankAccounts[maxj] = bankAccounts[i];
                bankAccounts[i] = work;
            }
        }
        printAccount(bankAccounts, n);
    }
}


