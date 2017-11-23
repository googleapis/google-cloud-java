package com.google.cloud.firestore.collection;

import java.util.Comparator;

public class StandardComparator<A extends Comparable<A>> implements Comparator<A> {

  private static StandardComparator INSTANCE = new StandardComparator();

  private StandardComparator() {}

  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> StandardComparator<T> getComparator(Class<T> clazz) {
    return INSTANCE;
  }

  @Override
  public int compare(A o1, A o2) {
    return o1.compareTo(o2);
  }
}
