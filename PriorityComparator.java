import java.util.Comparator;

/**
 * Home Assignment
 * Done by John Ha
 */
public class PriorityComparator implements Comparator<Worker> {

    @Override
    public int compare(Worker one, Worker two){
        if(one.priority < two.priority)
            return -1;
        if(one.priority > two.priority)
            return 1;
        return 0;
    }
}
