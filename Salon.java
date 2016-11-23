import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Assignment
 * Done by John Ha
 */

public class Salon {
    static Scanner kb = new Scanner(System.in);
    static boolean endProgram = false;

    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException {
    int person = 1;

        Worker Michelle = new Worker();
        Worker Mai = new Worker();
        Worker Son = new Worker();
        Worker Thuy = new Worker();
        Worker Yen = new Worker();
        Worker GiftCard = new Worker();
        ArrayList<Worker> array = new ArrayList<>();
            array.add(Mai);
            array.add(Michelle);
            array.add(Son);
            array.add(Thuy);
            array.add(Yen);
            array.add(GiftCard);

        System.out.println("Beginning Salon work");
        /*Comparator<Worker> comparator = new PriorityComparator();
        PriorityQueue<Worker> queue = new PriorityQueue<>(comparator);*/

        while(!endProgram) {
            System.out.println("What would you like to do?");
            System.out.println("1. Update someone's info");
            System.out.println("2. Fix an error");
            System.out.println("3. End the program");

            int choice = kb.nextInt();

            if(choice!=3) {
                System.out.println("For who?");
                System.out.println("1. Mai");
                System.out.println("2. Michelle");
                System.out.println("3. Son");
                System.out.println("4. Thuy");
                System.out.println("5. Yen");
                System.out.println("6. Gift Card");
                person = kb.nextInt();
            }
            switch(choice) {
                case 1:
                    switch(person){
                        case 1:
                            update(Mai);
                            break;
                        case 2:
                            update(Michelle);
                            break;
                        case 3:
                            update(Son);
                            break;
                        case 4:
                            update(Thuy);
                            break;
                        case 5:
                            update(Yen);
                            break;
                        case 6:
                            update(GiftCard);
                            break;
                    }
                    break;
                case 2:
                    switch(person){
                        case 1:
                            fix(Mai);
                            break;
                        case 2:
                            fix(Michelle);
                            break;
                        case 3:
                            fix(Son);
                            break;
                        case 4:
                            fix(Thuy);
                            break;
                        case 5:
                            fix(Yen);
                            break;
                        case 6:
                            fix(GiftCard);
                            break;
                    }
                    break;
                case 3:
                    end(array);
                    endProgram = true;
                    break;
            }
        }

    }
    public static void update(Worker person){
        boolean truth;
        System.out.println("Please enter the money made");
        int money = kb.nextInt();
        System.out.println("1. Credit or 2. Cash?");
        int determine = kb.nextInt();
        while(determine!=1 && determine !=2){
            System.out.println("Not valid value. Please reenter.");
            System.out.println("1. Credit or 2. Cash?");
            determine = kb.nextInt();
        }
        if(determine==1)
            truth = true;
        else
            truth = false;

        System.out.println("How much tip?");
        int tip = kb.nextInt();

        boolean cost = true;
        if(money<17)
            cost = false;


        person.addMoney(money);
        person.updateJob(cost);
        person.updatePriority();
        person.moneyType(truth);
        person.updateTip(tip);

    }
    public static void fix(Worker person){
        int newVal;
        person.info();
        System.out.println("What would you like to change?");
        int choice = kb.nextInt();
        switch(choice){
            case 1:
                System.out.println("Change money made to: ");
                newVal = kb.nextInt();
                person.moneyMade = newVal;
                break;
            case 2:
                System.out.println("Change priority to: ");
                newVal = kb.nextInt();
                person.priority = newVal;
                break;
            case 3:
                System.out.println("Change job count to: ");
                newVal = kb.nextInt();
                person.jobCount = newVal;
                break;
            case 4:
                System.out.println("Change cheap job count to: ");
                newVal = kb.nextInt();
                person.cheapJobCount = newVal;
                break;
            case 5:
                System.out.println("Change credit transactions to: ");
                newVal = kb.nextInt();
                person.credit = newVal;
                break;
            case 6:
                System.out.println("Change cash transactions to: ");
                newVal = kb.nextInt();
                person.cash = newVal;
                break;
        }
    }
    public static void end(ArrayList<Worker> array) throws FileNotFoundException, UnsupportedEncodingException {
        String names[] = {"Mai", "Michelle", "Son", "Thuy", "Yen", "Gift Card"};
        int i;
        PrintWriter writer = new PrintWriter("Salon.txt", "UTF-8");

        for(i=0;i<array.size();i++){
            Worker person = array.get(i);
            System.out.println(names[i] + " made $" + person.moneyMade + " with " + person.jobCount + " jobs and " + person.cheapJobCount + " cheap jobs and " + person.credit + " credit transactions and " + person.cash + " cash transactions.");
            writer.println(names[i] + " made $" + person.moneyMade + " with " + person.jobCount + " jobs and " + person.cheapJobCount + " cheap jobs and " + person.credit + " credit transactions and " + person.cash + " cash transactions.");
        }
        endProgram = true;
        writer.close();
    }
}
