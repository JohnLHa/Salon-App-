/**
 * Assignment
 * Done by John Ha
 */
public class Worker {
    public int moneyMade;
    public int priority;
    public int jobCount;
    public int cheapJobCount;
    public int credit;
    public int cash;
    public int tip;

    public Worker(int priority, int jobCount, int cheapJobCount, int moneyMade){
        this.priority = priority;
        this.jobCount = jobCount;
        this.cheapJobCount = cheapJobCount;
        this.moneyMade = moneyMade;
    }
    public Worker(){
        moneyMade = 0;
        priority = 0;
        jobCount = 0;
        cheapJobCount = 0;
    }

    public void addMoney(int moneyMade){
        this.moneyMade += moneyMade;
    }

    public void updatePriority(){
        priority++;
    }
    public void updateJob(boolean aboveMinCost){
        if(aboveMinCost)
            jobCount++;
        else
            cheapJobCount++;
    }
    public void info(){
        System.out.println("1. Money Earned: " + moneyMade);
        System.out.println("2. Priority: " + priority);
        System.out.println("3. Job Count: " + jobCount);
        System.out.println("4. Cheap Job Count: " + cheapJobCount);
    }
    public void moneyType(boolean truth){
        if(truth)
            credit++;
        else
            cash++;
    }
    public void updateTip(int tip){
        this.tip += tip;
    }


}
