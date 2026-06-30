/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage;

import org.checkerframework.checker.nullness.qual.Nullable;

final class Maths {

  private Maths() {}

  /**
   * Null aware subtraction.
   *
   * <ul>
   *   <li>If {@code l} is non-null while {@code r} is null, return {@code l}
   *   <li>If both {@code l} and {@code r} are non-null, return {@code l - r}
   *   <li>Otherwise, return {@code null}.
   * </ul>
   */
  @Nullable
  static Long sub(@Nullable Long l, @Nullable Long r) {
    if (l != null && r == null) {
      return l;
    } else if (l == null) {
      return null;
    } else {
      return l - r;
    }
  }

  /**
   * Null aware subtraction.
   *
   * <ul>
   *   <li>If {@code l} is non-null while {@code r} is null, return {@code l}
   *   <li>If both {@code l} and {@code r} are non-null, return {@code l - r}
   *   <li>Otherwise, return {@code null}.
   * </ul>
   */
  @Nullable
  static Integer sub(@Nullable Integer l, @Nullable Integer r) {
    if (l != null && r == null) {
      return l;
    } else if (l == null) {
      return null;
    } else {
      return l - r;
    }
  }

  /**
   * Increment some {@code base} {@link Long} by {@code factor}.
   *
   * <p>If {@code base} is null, {@code factor} will be returned
   */
  static long add(@Nullable Long base, long factor) {
    return base != null ? base + factor : factor;
  }
}
