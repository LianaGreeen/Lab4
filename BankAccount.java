package p.labs.Lab04B;

public class BankAccount extends Client {
    String number;
    double balance;
    String status;

    public BankAccount(){ };

    public BankAccount(String id, String name, String email){
        super(id, name, email);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BankAccount account = (BankAccount) o;

        if (Double.compare(account.balance, balance) != 0) return false;
        if (number != null ? !number.equals(account.number) : account.number != null) return false;
        return status != null ? status.equals(account.status) : account.status == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Id: " + id + '\t' + "Имя: " + name + '\t' + "Email: " + email + '\t' +
                "Номер счета: " + number + '\t' + "Баланс: " + balance + '\t' + "Состояние: " + status;
    }

    public void changeStatus(){
        if(this.status =="bloсked")
            this.status = "unlocked";
        else
            this.status = "bloсked";
    }

}
