package com.google.cloud.firestore.collection;

import java.util.Comparator;

/** User: greg Date: 5/17/13 Time: 8:48 AM */
public class LLRBEmptyNode<K, V> implements LLRBNode<K, V> {

  private static final LLRBEmptyNode INSTANCE = new LLRBEmptyNode();

  @SuppressWarnings("unchecked")
  public static <K, V> LLRBEmptyNode<K, V> getInstance() {
    return INSTANCE;
  }

  private LLRBEmptyNode() {}

  @Override
  public LLRBNode<K, V> copy(
      K key, V value, Color color, LLRBNode<K, V> left, LLRBNode<K, V> right) {
    return this;
  }

  @Override
  public LLRBNode<K, V> insert(K key, V value, Comparator<K> comparator) {
    return new LLRBRedValueNode<K, V>(key, value);
  }

  @Override
  public LLRBNode<K, V> remove(K key, Comparator<K> comparator) {
    return this;
  }

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public boolean isRed() {
    return false;
  }

  @Override
  public K getKey() {
    return null;
  }

  @Override
  public V getValue() {
    return null;
  }

  @Override
  public LLRBNode<K, V> getLeft() {
    return this;
  }

  @Override
  public LLRBNode<K, V> getRight() {
    return this;
  }

  @Override
  public LLRBNode<K, V> getMin() {
    return this;
  }

  @Override
  public LLRBNode<K, V> getMax() {
    return this;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public void inOrderTraversal(NodeVisitor<K, V> visitor) {
    // No-op
  }

  @Override
  public boolean shortCircuitingInOrderTraversal(ShortCircuitingNodeVisitor<K, V> visitor) {
    // No-op
    return true;
  }

  @Override
  public boolean shortCircuitingReverseOrderTraversal(ShortCircuitingNodeVisitor<K, V> visitor) {
    // No-op
    return true;
  }
}
