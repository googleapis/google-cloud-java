/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.misc_utilities;

import com.google.common.truth.Correspondence;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * A {@link Correspondence} to compare methods names, parameters and return types in different
 * classes. An example usage is to make sure a child class is implementing all the methods in the
 * non-abstract parent class.
 */
public class MethodComparator {

  public static final Correspondence<Method, Method> METHOD_CORRESPONDENCE =
      Correspondence.from(
          MethodComparator::compareMethods, "compare method names, parameters and return types");

  private static boolean compareMethods(Method actual, Method expected) {
    return actual.getName().equals(expected.getName())
        && Arrays.equals(actual.getParameterTypes(), expected.getParameterTypes())
        && actual.getModifiers() == expected.getModifiers()
        && actual.getReturnType().equals(expected.getReturnType());
  }
}
