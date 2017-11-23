package com.google.cloud.firestore.collection;

import java.util.*;

/** User: greg Date: 5/21/13 Time: 10:31 AM */
public class ImmutableSortedMapIterator<K, V> implements Iterator<Map.Entry<K, V>> {

  private final Stack<LLRBValueNode<K, V>> nodeStack;

  private final boolean isReverse;

  ImmutableSortedMapIterator(
      LLRBNode<K, V> root, K startKey, Comparator<K> comparator, boolean isReverse) {
    this.nodeStack = new Stack<LLRBValueNode<K, V>>();
    this.isReverse = isReverse;

    LLRBNode<K, V> node = root;
    while (!node.isEmpty()) {
      int cmp;
      if (startKey != null) {
        cmp =
            isReverse
                ? comparator.compare(startKey, node.getKey())
                : comparator.compare(node.getKey(), startKey);
      } else {
        cmp = 1;
      }
      if (cmp < 0) {
        // This node is less than our start key. ignore it
        if (isReverse) {
          node = node.getLeft();
        } else {
          node = node.getRight();
        }
      } else if (cmp == 0) {
        // This node is exactly equal to our start key. Push it on the stack, but stop iterating;
        this.nodeStack.push((LLRBValueNode<K, V>) node);
        break;
      } else {
        this.nodeStack.push((LLRBValueNode<K, V>) node);
        if (isReverse) {
          node = node.getRight();
        } else {
          node = node.getLeft();
        }
      }
    }
  }

  @Override
  public boolean hasNext() {
    return nodeStack.size() > 0;
  }

  @Override
  public Map.Entry<K, V> next() {
    try {
      final LLRBValueNode<K, V> node = nodeStack.pop();
      Map.Entry<K, V> entry = new AbstractMap.SimpleEntry<K, V>(node.getKey(), node.getValue());
      if (this.isReverse) {
        LLRBNode<K, V> next = node.getLeft();
        while (!next.isEmpty()) {
          this.nodeStack.push((LLRBValueNode<K, V>) next);
          next = next.getRight();
        }
      } else {
        LLRBNode<K, V> next = node.getRight();
        while (!next.isEmpty()) {
          this.nodeStack.push((LLRBValueNode<K, V>) next);
          next = next.getLeft();
        }
      }
      return entry;
    } catch (EmptyStackException e) {
      // No more children
      throw new NoSuchElementException();
    }
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("remove called on immutable collection");
  }
}
