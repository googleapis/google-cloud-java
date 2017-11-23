package com.google.cloud.firestore.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

/**
 * User: greg
 * Date: 5/17/13
 * Time: 8:48 AM
 */
public interface LLRBNode<K, V> {

    public interface ShortCircuitingNodeVisitor<K, V> {
        boolean shouldContinue(K key, V value);
    }

    public abstract class NodeVisitor<K, V> implements ShortCircuitingNodeVisitor<K, V> {

        @Override
        public boolean shouldContinue(K key, V value) {
            visitEntry(key, value);
            return true;
        }

        abstract public void visitEntry(K key, V value);
    }

    enum Color {RED, BLACK}

    LLRBNode<K, V> copy(K key, V value, Color color, LLRBNode<K, V> left, LLRBNode<K, V> right);

    LLRBNode<K, V> insert(K key, V value, Comparator<K> comparator);

    LLRBNode<K, V> remove(K key, Comparator<K> comparator);

    boolean isEmpty();

    boolean isRed();

    K getKey();

    V getValue();

    LLRBNode<K, V> getLeft();

    LLRBNode<K, V> getRight();

    LLRBNode<K, V> getMin();

    LLRBNode<K, V> getMax();

    int size();

    void inOrderTraversal(NodeVisitor<K, V> visitor);

    boolean shortCircuitingInOrderTraversal(ShortCircuitingNodeVisitor<K, V> visitor);

    boolean shortCircuitingReverseOrderTraversal(ShortCircuitingNodeVisitor<K, V> visitor);
}
