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

package com.google.cloud.spanner;

import com.google.common.collect.ImmutableList;
import java.util.Objects;

/**
 * Defines a collection of Cloud Spanner keys and/or key ranges. All the keys are expected to be in
 * the same table or index. The keys need not be sorted in any particular way.
 *
 * <p>If the same key is specified multiple times in the set (for example if two ranges, two keys,
 * or a key and a range overlap), the Cloud Spanner backend behaves as if the key were only
 * specified once. However, the {@code KeySet} object itself does not perform any de-duplication.
 *
 * <p>{@code KeySet} instances are immutable.
 */
public final class KeySet {
  private final boolean all;
  private final ImmutableList<Key> keys;
  private final ImmutableList<KeyRange> ranges;

  private KeySet(boolean all, ImmutableList<Key> keys, ImmutableList<KeyRange> ranges) {
    this.all = all;
    this.keys = keys;
    this.ranges = ranges;
  }

  /**
   * Creates a key set containing a single key. {@code key} should contain exactly as many elements
   * as there are columns in the primary or index key with this this key set is used.
   */
  public static KeySet singleKey(Key key) {
    return new KeySet(false, ImmutableList.of(key), ImmutableList.<KeyRange>of());
  }

  /**
   * Creates a key set containing a single range. See {@link KeyRange} for details of how to specify
   * ranges.
   */
  public static KeySet range(KeyRange range) {
    return new KeySet(false, ImmutableList.<Key>of(), ImmutableList.of(range));
  }

  /**
   * Creates a key set that covers all keys where the first {@code prefix.size()} components match
   * {@code prefix} exactly.
   */
  public static KeySet prefixRange(Key prefix) {
    return range(KeyRange.prefix(prefix));
  }

  /** Creates a key set that will retrieve all rows of a table or index. */
  public static KeySet all() {
    return new KeySet(true, ImmutableList.<Key>of(), ImmutableList.<KeyRange>of());
  }

  /** Returns a new builder that can be used to construct a key set. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Builder for {@link KeySet} instances. */
  public static class Builder {
    private boolean all;
    private ImmutableList.Builder<Key> keys;
    private ImmutableList.Builder<KeyRange> ranges;

    private Builder() {}

    private Builder(KeySet set) {
      all = set.all;
      if (!set.keys.isEmpty()) {
        keys = ImmutableList.<Key>builder().addAll(set.keys);
      }
      if (!set.ranges.isEmpty()) {
        ranges = ImmutableList.<KeyRange>builder().addAll(set.ranges);
      }
    }

    /**
     * Adds a key to the key set. {@code key} should contain exactly as many elements as there are
     * columns in the primary or index key with this this key set is used.
     */
    public Builder addKey(Key key) {
      if (keys == null) {
        keys = ImmutableList.builder();
      }
      keys.add(key);
      return this;
    }

    /** Adds a range to the key set. See {@link KeyRange} for details of how to specify ranges. */
    public Builder addRange(KeyRange range) {
      if (ranges == null) {
        ranges = ImmutableList.builder();
      }
      ranges.add(range);
      return this;
    }

    /** Makes the key set retrieve all rows of a table or index. */
    public Builder setAll() {
      all = true;
      return this;
    }

    public KeySet build() {
      return new KeySet(
          all,
          keys != null ? keys.build() : ImmutableList.<Key>of(),
          ranges != null ? ranges.build() : ImmutableList.<KeyRange>of());
    }
  }

  /** Returns the keys in this set. */
  public Iterable<Key> getKeys() {
    // Design note: returns Iterable<> rather than List<> since future internal representations
    // may not maintain a List<Key> internally, but rather decode the rep and reconstruct Keys on
    // the fly.
    return keys;
  }

  /** Returns the ranges in this set. */
  public Iterable<KeyRange> getRanges() {
    return ranges;
  }

  /** Indicates whether the set will retrieve all rows in a table or index. */
  public boolean isAll() {
    return all;
  }

  /** Returns a builder initialized with the contents of this set. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  void toString(StringBuilder b) {
    b.append('{');
    int size = 0;
    if (all) {
      ++size;
      b.append("<all>");
    }
    for (Key key : keys) {
      if (size++ > 0) {
        b.append(',');
      }
      key.toString(b);
    }
    for (KeyRange range : ranges) {
      if (size++ > 0) {
        b.append(',');
      }
      range.toString(b);
    }
    b.append('}');
  }

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    toString(b);
    return b.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeySet that = (KeySet) o;
    return all == that.all && keys.equals(that.keys) && ranges.equals(that.ranges);
  }

  @Override
  public int hashCode() {
    return Objects.hash(all, keys, ranges);
  }

  void appendToProto(com.google.spanner.v1.KeySet.Builder proto) {
    for (Key key : keys) {
      proto.addKeys(key.toProto());
    }
    for (KeyRange range : ranges) {
      proto.addRanges(range.toProto());
    }
    if (all) {
      proto.setAll(true);
    }
  }
}
