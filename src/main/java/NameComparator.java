import java.util.Comparator;

public class NameComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer a, Customer b) {
        return a.getFullName().compareTo(b.getFullName());
    }
}