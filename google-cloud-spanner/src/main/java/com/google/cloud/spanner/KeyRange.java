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

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.util.Objects;

/**
 * Represents a range of rows in a table or index.
 *
 * <p>A range has a start key and an end key. These keys can be open or closed, indicating if the
 * range includes rows with that key.
 *
 * <p>For example, consider the following table definition:
 *
 * <pre>
 *     CREATE TABLE UserEvents (
 *       UserName STRING(MAX),
 *       EventDate STRING(10),
 *     ) PRIMARY KEY(UserName, EventDate);
 * </pre>
 *
 * The following keys name rows in this table:
 *
 * <ul>
 *   <li>{@code Key.of("Bob", "2014-09-23")}
 *   <li>{@code Key.of("Alfred", "2015-06-12")}
 * </ul>
 *
 * Since the {@code UserEvents} table's {@code PRIMARY KEY} clause names two columns, each {@code
 * UserEvents} key has two elements; the first is the {@code UserName}, and the second is the {@code
 * EventDate}.
 *
 * <p>Key ranges with multiple components are interpreted lexicographically by component using the
 * table or index key's declared sort order. For example, the following range returns all events for
 * user "Bob" that occurred in the year 2015:
 *
 * <pre>
 *     KeyRange.closedClosed(
 *         Key.of("Bob", "2015-01-01"),
 *         Key.of("Bob", "2015-12-31"))
 * </pre>
 *
 * Start and end keys can omit trailing key components. This affects the inclusion and exclusion of
 * rows that exactly match the provided key components: if the key is closed, then rows that exactly
 * match the provided components are included; if the key is open, then rows that exactly match are
 * not included.
 *
 * <p>For example, the following range includes all events for "Bob" that occurred during and after
 * the year 2000:
 *
 * <pre>
 *     KeyRange.closedClosed(
 *         Key.of("Bob", "2000-01-01"),
 *         Key.of("Bob"))
 * </pre>
 *
 * The next example retrieves all events for "Bob":
 *
 * <pre>
 *     KeyRange.prefix(Key.of("Bob"))
 * </pre>
 *
 * To retrieve events before the year 2000:
 *
 * <pre>
 *     KeyRange.closedOpen(
 *         Key.of("Bob"),
 *         Key.of("Bob", "2000-01-01"))
 * </pre>
 *
 * The following range includes all rows in the table:
 *
 * <pre>
 *     KeyRange.all()
 * </pre>
 *
 * This range returns all users whose {@code UserName} begins with any character from A to C:
 *
 * <pre>
 *     KeyRange.closedOpen(Key.of("A"), Key.of("D"))
 * </pre>
 *
 * This range returns all users whose {@code UserName} begins with B:
 *
 * <pre>
 *     KeyRange.closedOpen(Key.of("B"), Key.of("C"))
 * </pre>
 *
 * Key ranges honor column sort order. For example, suppose a table is defined as follows:
 *
 * <pre>
 *     CREATE TABLE DescendingSortedTable {
 *       Key INT64,
 *       ...
 *     ) PRIMARY KEY(Key DESC);
 * </pre>
 *
 * The following range retrieves all rows with key values between 1 and 100 inclusive:
 *
 * <pre>
 *     KeyRange.closedClosed(Key.of(100), Key.of(1))
 * </pre>
 *
 * Note that 100 is passed as the start, and 1 is passed as the end, because {@code Key} is a
 * descending column in the schema.
 *
 * <p>{@code KeyRange} instances are immutable.
 */
public final class KeyRange {
  /** Defines whether a range includes or excludes its endpoint keys. */
  public enum Endpoint {
    /** Ranges include the endpoint key. */
    CLOSED,

    /** Ranges exclude the endpoint key. */
    OPEN
  }

  private final Key start;
  private final Endpoint startType;
  private final Key end;
  private final Endpoint endType;

  private KeyRange(Key start, Endpoint startType, Key end, Endpoint endType) {
    this.start = start;
    this.startType = startType;
    this.end = end;
    this.endType = endType;
  }

  /** Returns a key range from {@code start} inclusive to {@code end} exclusive. */
  public static KeyRange closedOpen(Key start, Key end) {
    return new KeyRange(checkNotNull(start), Endpoint.CLOSED, checkNotNull(end), Endpoint.OPEN);
  }

  /** Returns a key range from {@code start} inclusive to {@code end} inclusive. */
  public static KeyRange closedClosed(Key start, Key end) {
    return new KeyRange(checkNotNull(start), Endpoint.CLOSED, checkNotNull(end), Endpoint.CLOSED);
  }

  /** Returns a key range from {@code start} exclusive to {@code end} exclusive. */
  public static KeyRange openOpen(Key start, Key end) {
    return new KeyRange(checkNotNull(start), Endpoint.OPEN, checkNotNull(end), Endpoint.OPEN);
  }

  /** Returns a key range from {@code start} exclusive to {@code end} inclusive. */
  public static KeyRange openClosed(Key start, Key end) {
    return new KeyRange(checkNotNull(start), Endpoint.OPEN, checkNotNull(end), Endpoint.CLOSED);
  }

  /**
   * Returns a key range that covers all keys where the first {@code prefix.size()} components match
   * {@code prefix} exactly.
   */
  public static KeyRange prefix(Key prefix) {
    return closedClosed(prefix, prefix);
  }

  /** Returns a new builder for constructing a range. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Builder for {@link KeyRange} instances. */
  public static class Builder {
    private Key start;
    private Endpoint startType = Endpoint.CLOSED;
    private Key end;
    private Endpoint endType = Endpoint.OPEN;

    private Builder() {}

    private Builder(KeyRange r) {
      start = r.start;
      startType = r.startType;
      end = r.end;
      endType = r.endType;
    }

    /** Sets the start key of the range. This must be set before {@link #build()} is called. */
    public Builder setStart(Key key) {
      start = checkNotNull(key);
      return this;
    }

    /**
     * Sets whether the start key is inclusive ({@code CLOSED}) or exclusive ({@code OPEN}). The
     * default is {@code CLOSED}.
     */
    public Builder setStartType(Endpoint type) {
      startType = checkNotNull(type);
      return this;
    }

    /** Sets the end key of the range. This must be set before {@link #build()} is called. */
    public Builder setEnd(Key key) {
      end = checkNotNull(key);
      return this;
    }

    /**
     * Sets whether the end key is inclusive ({@code CLOSED}) or exclusive ({@code OPEN}). The
     * default is {@code OPEN}.
     */
    public Builder setEndType(Endpoint type) {
      endType = checkNotNull(type);
      return this;
    }

    public KeyRange build() {
      checkState(start != null, "Missing required call to start(Key)");
      checkState(end != null, "Missing required call to end(Key)");
      return new KeyRange(start, startType, end, endType);
    }
  }

  /** Returns the start key of the range. */
  public Key getStart() {
    return start;
  }

  /** Indicates whether the start key is inclusive ({@code CLOSED}) or exclusive ({@code OPEN}). */
  public Endpoint getStartType() {
    return startType;
  }

  /** Returns the end key of the range. */
  public Key getEnd() {
    return end;
  }

  /** Indicates whether the end key is inclusive ({@code CLOSED}) or exclusive ({@code OPEN}). */
  public Endpoint geEndType() {
    return endType;
  }

  /** Returns a builder initialized with the value of this range. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  void toString(StringBuilder b) {
    b.append(startType == Endpoint.CLOSED ? '[' : '(');
    start.toString(b);
    b.append(',');
    end.toString(b);
    b.append(endType == Endpoint.CLOSED ? ']' : ')');
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
    KeyRange that = (KeyRange) o;
    return startType == that.startType
        && endType == that.endType
        && start.equals(that.start)
        && end.equals(that.end);
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, startType, end, endType);
  }

  com.google.spanner.v1.KeyRange toProto() {
    com.google.spanner.v1.KeyRange.Builder builder = com.google.spanner.v1.KeyRange.newBuilder();
    if (startType == Endpoint.CLOSED) {
      builder.setStartClosed(start.toProto());
    } else {
      builder.setStartOpen(start.toProto());
    }
    if (endType == Endpoint.CLOSED) {
      builder.setEndClosed(end.toProto());
    } else {
      builder.setEndOpen(end.toProto());
    }
    return builder.build();
  }
}
