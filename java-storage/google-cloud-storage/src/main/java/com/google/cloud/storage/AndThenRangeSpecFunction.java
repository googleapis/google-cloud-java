/*
 * Copyright 2025 Google LLC
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

import com.google.common.base.MoreObjects;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

final class AndThenRangeSpecFunction extends RangeSpecFunction {

  private final RangeSpecFunction first;
  private final RangeSpecFunction second;

  AndThenRangeSpecFunction(RangeSpecFunction first, RangeSpecFunction second) {
    this.first = first;
    this.second = second;
  }

  @Override
  RangeSpec apply(long offset, @Nullable RangeSpec prev) {
    return second.apply(offset, first.apply(offset, prev));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AndThenRangeSpecFunction)) {
      return false;
    }
    AndThenRangeSpecFunction that = (AndThenRangeSpecFunction) o;
    return Objects.equals(first, that.first) && Objects.equals(second, that.second);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("first", first).add("second", second).toString();
  }
}
