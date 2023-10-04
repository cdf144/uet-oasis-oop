package Week11.Banking_System;

import java.util.Comparator;

public class IdComparator implements Comparator<Customer> {
  @Override
  public int compare(Customer a, Customer b) {
    return Long.compare(a.getIdNumber(), b.getIdNumber());
  }
}
