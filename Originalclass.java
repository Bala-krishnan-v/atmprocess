package atmmachine;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Originalclass {
	static Originalclass atmOperations = new Originalclass();
    static LoadATM[] ATM = {
            new LoadATM(2000,20,40000),
            new LoadATM(500,10,5000),
            new LoadATM(100,100,10000)
    };
    static List<LoadATM> Atm_at = Arrays.asList(ATM);
    static Detailsofcus[] cD = {
            new Detailsofcus(101,"Suresh",2343,25234),
            new Detailsofcus(102,"Ganesh",5432,34123),
            new Detailsofcus(103,"Magesh",7854,26100),
            new Detailsofcus(104,"Naresh",2345,80000),
            new Detailsofcus(105,"Harish",1907,103400)
    };
    static List<Detailsofcus> CUS = Arrays.asList(cD);
    public int checkBalance(int accN,int pin)
    {
        for(Detailsofcus customer : CUS){
            if(customer.getAccNo() == accN && customer.getPin()==pin){
                return customer.getAccB();
            }
        }
        return 0;
    }

    public boolean withDrawPossible(int accN,int pin,int amt){
        for(Detailsofcus customer : CUS){
            if(customer.getAccNo() == accN && customer.getPin()==pin && customer.getAccB()>=amt){
                customer.setAccB(customer.getAccB()-amt);
                return true;
            }
        }
        return false;
    }

    public boolean transferPossible(int accN,int pin,int amt,int otherAccNo){
        for(Detailsofcus customer : CUS){
            if(customer.getAccNo() == accN && customer.getPin()==pin&&customer.getAccB()>=amt){
                customer.setAccB(customer.getAccB()-amt);
            }
        }
        for(Detailsofcus customer : CUS){
            if(customer.getAccNo() == otherAccNo){
                customer.setAccB(customer.getAccB()+amt);
                return true;
            }
        }

        return false;
    }

    public static boolean correctPinOrNot(int acc)
    {
        for(Detailsofcus customer : CUS){
            if(customer.getAccNo() == acc){
                return true;
            }
        }
        return false;
    }
    public static boolean correctPinOrNot(int acc,int pin)
    {
        for(Detailsofcus customer : CUS){
            if(customer.getAccNo() == acc && customer.getPin()==pin){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int amount;
        Scanner scanner = new Scanner(System.in);
        boolean condition = true;
        int otherAccNo;
        int accNo,pin;
        System.out.println("Welcome to Secure Bank ATM");
        while (condition) {
            System.out.println("____Why do you use our ATM?____");
            System.out.println("1 . Check Balance");
            System.out.println("2 . Withdraw Amount");
            System.out.println("3 . Transfer Amount");
            System.out.println("4 . AMT Balance");
            System.out.println("5 . Exit");
            System.out.println("_______________________________");
            System.out.println("Enter Your Choice: ");
            int ch = scanner.nextInt();
            switch (ch) {
                case 1-> {
                    System.out.println("You have to chosen Balance Checking Option\n");
                    System.out.println("Please Enter Account Number: ");
                    accNo = scanner.nextInt();
                    System.out.println("Enter Your Four Digit Pin: ");
                    pin = scanner.nextInt();
                    if (correctPinOrNot(accNo, pin)) {
                        int balance = atmOperations.checkBalance(accNo, pin);
                        System.out.println("\nYour Current Balance is " + balance);
                    }
                }
                case 2->{
                    System.out.println("You have to chosen Withdrawing Option\n");
                    System.out.println("Please Enter Account Number: ");
                    accNo = scanner.nextInt();
                    System.out.println("Enter Your Four Digit Pin: ");
                    pin = scanner.nextInt();
                    System.out.println("Enter Amount of Money to withdraw: ");
                    amount=scanner.nextInt();
                    if(correctPinOrNot(accNo,pin)){
                        if(amount>=2000){
                            if(atmOperations.withDrawPossible(accNo,pin,amount)){
                                int withdrawAmount=amount;
                                if(Atm_attributes.stream().filter(atm -> atm.getValue()>=withdrawAmount).count()>1){
                                    Atm_attributes.stream().filter(atm -> atm.getDenomination()==2000).forEach(atm->atm.setValue(atm.getValue()-withdrawAmount));
                                    Atm_attributes.stream().filter(atm -> atm.getDenomination()==2000).forEach(atm->atm.setNumber(atm.getNumber()-(withdrawAmount/2000)));
                                    System.out.println("AMUNT WITHDRWAN");
                                }
                            }
                        }
                        else if(amount>=500){
                            if(atmOperations.withDrawPossible(accNo,pin,amount)){
                                int withdrawAmount=amount;
                                if(Atm_attributes.stream().filter(atm -> atm.getValue()>=withdrawAmount).count()>1){
                                    Atm_attributes.stream().filter(atm -> atm.getDenomination()==500).forEach(atm->atm.setValue(atm.getValue()-withdrawAmount));
                                    Atm_attributes.stream().filter(atm -> atm.getDenomination()==500).forEach(atm->atm.setNumber(atm.getNumber()-(withdrawAmount/500)));
                                    System.out.println("AMUNT WITHDRWAN");
                                }
                            }
                        }
                        else if(amount>=100){
                            if(atmOperations.withDrawPossible(accNo,pin,amount)){
                                int withdrawAmount=amount;
                                if(Atm_attributes.stream().filter(atm -> atm.getValue()>=withdrawAmount).count()>1){
                                    Atm_attributes.stream().filter(atm -> atm.getDenomination()==100).forEach(atm->atm.setValue(atm.getValue()-withdrawAmount));
                                    Atm_attributes.stream().filter(atm -> atm.getDenomination()==100).forEach(atm->atm.setNumber(atm.getNumber()-(withdrawAmount/100)));
                                    System.out.println("AMUNT WITHDRWAN");
                                }
                            }
                        }
                    }
                }
                case 3->{
                    System.out.println("You have to chosen Transfer Option\n");
                    System.out.println("Please your Account Number: ");
                    accNo = scanner.nextInt();
                    System.out.println("Enter Your Four Digit Pin: ");
                    pin = scanner.nextInt();
                    System.out.println("Enter Amount of Money to transfer: ");
                    amount=scanner.nextInt();
                    if(correctPinOrNot(accNo,pin)){
                        if(amount<=10000){
                            System.out.println("Enter Account Number of Your Friend: ");
                            otherAccNo= scanner.nextInt();
                            if(correctPinOrNot(otherAccNo)){
                                if(amount>=2000){
                                    if(atmOperations.transferPossible(accNo,pin,amount,otherAccNo)){
                                        int transferAmount=amount;
                                        if(Atm_attributes.stream().filter(atm -> atm.getValue()>=transferAmount).count()>1){

                                            Atm_attributes.stream().filter(atm -> atm.getDenomination()==2000).forEach(atm->atm.setValue(atm.getValue()+transferAmount));
                                            Atm_attributes.stream().filter(atm -> atm.getDenomination()==2000).forEach(atm->atm.setNumber(atm.getNumber()+transferAmount/2000));
                                            System.out.println("AMUNT transferee");
                                        }
                                    }
                                }
                                else if(amount>=500){
                                    if(atmOperations.transferPossible(accNo,pin,amount,otherAccNo)){
                                        int transferAmount=amount;
                                        if(Atm_attributes.stream().filter(atm -> atm.getValue()>=transferAmount).count()>1){

                                            Atm_attributes.stream().filter(atm -> atm.getDenomination()==2000).forEach(atm->atm.setValue(atm.getValue()+transferAmount));
                                            Atm_attributes.stream().filter(atm -> atm.getDenomination()==2000).forEach(atm->atm.setNumber(atm.getNumber()+transferAmount/500));
                                            System.out.println("AMUNT transferee");
                                        }
                                    }
                                }
                                else if(amount>=100){
                                    if(atmOperations.transferPossible(accNo,pin,amount,otherAccNo)){
                                        int transferAmount=amount;
                                        if(Atm_attributes.stream().filter(atm -> atm.getValue()>=transferAmount).count()>1){

                                            Atm_attributes.stream().filter(atm -> atm.getDenomination()==2000).forEach(atm->atm.setValue(atm.getValue()+transferAmount));
                                            Atm_attributes.stream().filter(atm -> atm.getDenomination()==2000).forEach(atm->atm.setNumber(atm.getNumber()+transferAmount/100));
                                            System.out.println("AMUNT transferee");
                                        }
                                    }
                                }
                            }
                        }
                        else{
                            System.out.println("Amount Must be less than 10000");
                        }
                    }

                }
                case 4-> Atm_attributes.forEach(System.out::println);
                case 5-> condition=false;
                default -> System.out.println("Enter from 1,2,3,4,5");
            }
        }
    }
}
