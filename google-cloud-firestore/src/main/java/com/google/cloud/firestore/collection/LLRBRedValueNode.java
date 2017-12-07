/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.firestore.collection;

import com.google.api.core.InternalApi;

// Note: This package is copied from https://github.com/firebase/firebase-admin-java/tree/master/
// src/main/java/com/google/firebase/database/collection
@InternalApi
public class LLRBRedValueNode<K, V> extends LLRBValueNode<K, V> {

  LLRBRedValueNode(K key, V value) {
    super(key, value, LLRBEmptyNode.<K, V>getInstance(), LLRBEmptyNode.<K, V>getInstance());
  }

  LLRBRedValueNode(K key, V value, LLRBNode<K, V> left, LLRBNode<K, V> right) {
    super(key, value, left, right);
  }

  @Override
  protected Color getColor() {
    return LLRBNode.Color.RED;
  }

  @Override
  public boolean isRed() {
    return true;
  }

  @Override
  public int size() {
    return this.getLeft().size() + 1 + this.getRight().size();
  }

  @Override
  protected LLRBValueNode<K, V> copy(K key, V value, LLRBNode<K, V> left, LLRBNode<K, V> right) {
    K newKey = key == null ? this.getKey() : key;
    V newValue = value == null ? this.getValue() : value;
    LLRBNode<K, V> newLeft = left == null ? this.getLeft() : left;
    LLRBNode<K, V> newRight = right == null ? this.getRight() : right;
    return new LLRBRedValueNode<K, V>(newKey, newValue, newLeft, newRight);
  }
}
