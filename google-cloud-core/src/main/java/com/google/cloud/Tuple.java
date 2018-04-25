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

package com.google.cloud;

public class Tuple<X, Y> {

  private final X x;
  private final Y y;

  private Tuple(X x, Y y) {
    this.x = x;
    this.y = y;
  }

  public static <X, Y> Tuple<X, Y> of(X x, Y y) {
    return new Tuple<>(x, y);
  }

  public X x() {
    return x;
  }

  public Y y() {
    return y;
  }
}
