// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A common-prefix trie. T represents the type of each "char" in a word (which is a T-typed list).
 */
public class Trie<T> {
  private static class Node<U> {
    final U chr;
    // Maintain insertion order to enable deterministic test output.
    Map<U, Node<U>> children = new LinkedHashMap<>();
    boolean isLeaf;

    Node() {
      chr = null;
    }

    Node(U chr) {
      this.chr = chr;
    }
  }

  private final Node<T> root;

  public Trie() {
    root = new Node<>();
  }

  public void insert(List<T> word) {
    Map<T, Node<T>> children = root.children;
    for (int i = 0; i < word.size(); i++) {
      T chr = word.get(i);
      Node<T> t;
      if (children.containsKey(chr)) {
        t = children.get(chr);
      } else {
        t = new Node<>(chr);
        children.put(chr, t);
      }
      children = t.children;
      if (i == word.size() - 1) {
        t.isLeaf = true;
      }
    }
  }

  /** Returns true if the word is in the trie. */
  public boolean search(List<T> word) {
    Node<T> node = searchNode(word);
    return node != null && node.isLeaf;
  }

  /** Returns true if some word in the trie begins with the given prefix. */
  public boolean hasPrefix(List<T> prefix) {
    return searchNode(prefix) != null;
  }

  /**
   * Reduces the trie to a single value, via a DFS traversal.
   *
   * @param parentPreprocFn Transforms a parent node into an R-typed base value for consumption by
   *     the child nodes. The rest of the children will compute their values using this as a base as
   *     well, so it accumulates computational results as the traversal progresses. Does not handle
   *     the root node (i.e. when {@code chr} is null).
   * @param leafReduceFn Transforms a child node into an R-typed value using the value computed by
   *     the parent nodes' preprocessing functions.
   * @param parentPostprocFn Transforms the post-traversal result (from the child nodes) into
   *     R-typed values, further building upon {@code baseValue}. Must handle the root node, i.e.
   *     when {@code chr} is null.
   * @param baseValue The base value upon which subsequent reductions will be performed. Ensure this
   *     is a type that can accumulate values, such as StringBuilder. An immutable type such as
   *     String will not work here.
   */
  public <R> R dfsTraverseAndReduce(
      Function<T, R> parentPreprocFn,
      TriFunction<T, R, R, R> parentPostprocFn,
      BiFunction<T, R, R> leafReduceFn,
      R baseValue) {
    return dfsTraverseAndReduce(root, parentPreprocFn, parentPostprocFn, leafReduceFn, baseValue);
  }

  /** Traverses the trie DFS-style, reducing all values into a single one on {@code baseValue}. */
  private <R> R dfsTraverseAndReduce(
      Node<T> node,
      Function<T, R> parentPreprocFn,
      TriFunction<T, R, R, R> parentPostprocFn,
      BiFunction<T, R, R> leafReduceFn,
      R baseValue) {
    if (node.isLeaf) {
      return leafReduceFn.apply(node.chr, baseValue);
    }

    R leafReducedValue = node.chr == null ? baseValue : parentPreprocFn.apply(node.chr);
    for (Map.Entry<T, Node<T>> e : node.children.entrySet()) {
      // Thread the parent value through each of the children, and accumulate it.
      leafReducedValue =
          dfsTraverseAndReduce(
              e.getValue(), parentPreprocFn, parentPostprocFn, leafReduceFn, leafReducedValue);
    }
    return parentPostprocFn.apply(node.chr, baseValue, leafReducedValue);
  }

  private Node<T> searchNode(List<T> word) {
    Map<T, Node<T>> children = root.children;
    Node<T> t = null;
    for (T chr : word) {
      if (children.containsKey(chr)) {
        t = children.get(chr);
        children = t.children;
      } else {
        return null;
      }
    }
    return t;
  }
}
