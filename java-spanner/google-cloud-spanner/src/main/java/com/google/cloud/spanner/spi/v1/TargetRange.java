/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import com.google.api.core.InternalApi;
import com.google.protobuf.ByteString;

/** Represents a key range with start and limit boundaries for routing. */
@InternalApi
public class TargetRange {
  public ByteString start;
  public ByteString limit;
  public boolean approximate;

  public TargetRange(ByteString start, ByteString limit, boolean approximate) {
    this.start = start;
    this.limit = limit;
    this.approximate = approximate;
  }

  public boolean isPoint() {
    return limit.isEmpty();
  }

  /**
   * Merges another TargetRange into this one. The resulting range will be the union of the two
   * ranges, taking the minimum start key and maximum limit key.
   */
  public void mergeFrom(TargetRange other) {
    if (ByteString.unsignedLexicographicalComparator().compare(other.start, this.start) < 0) {
      this.start = other.start;
    }
    if (other.isPoint()
        && ByteString.unsignedLexicographicalComparator().compare(other.start, this.limit) >= 0) {
      this.limit = SsFormat.makePrefixSuccessor(other.start);
    } else if (ByteString.unsignedLexicographicalComparator().compare(other.limit, this.limit)
        > 0) {
      this.limit = other.limit;
    }
    this.approximate |= other.approximate;
  }
}
