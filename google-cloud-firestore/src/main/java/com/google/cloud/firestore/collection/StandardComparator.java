/*
 * Copyright 2017 Google LLC
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
import java.util.Comparator;

// Note: This package is copied from https://github.com/firebase/firebase-admin-java/tree/master/
// src/main/java/com/google/firebase/database/collection
@InternalApi
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
