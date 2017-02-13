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

import static com.google.cloud.spanner.ByteArrays.toBase64;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.ByteArray;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.protobuf.Value;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Represents a row key in a Cloud Spanner table or index. A key is a tuple of values constrained to
 * the scalar Cloud Spanner types: currently these are {@code BOOLEAN}, {@code INT64}, {@code
 * FLOAT64}, {@code STRING}, {@code BYTES} and {@code TIMESTAMP}. Values may be null where the table
 * definition permits it.
 *
 * <p>{@code Key} is used to define the row, or endpoints of a range of rows, to retrieve in read
 * operations or to delete in a mutation.
 *
 * <p>{@code Key} instances are immutable.
 */
public final class Key {
  private static final Joiner joiner = Joiner.on(',').useForNull("<null>");
  private static final com.google.protobuf.Value NULL_PROTO =
      Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();

  private final List<Object> parts;

  private Key(List<Object> parts) {
    this.parts = Collections.unmodifiableList(parts);
  }

  /**
   * Construct a key with parts specified by {@code values}. Each object in {@code values} must be
   * either {@code null} or one of the following supported types:
   *
   * <ul>
   *   <li>{@code Boolean} for the {@code BOOL} Cloud Spanner type
   *   <li>{@code Integer}, {@code Long} for {@code INT64}
   *   <li>{@code Float}, {@code Double} for {@code FLOAT64}
   *   <li>{@code String} for {@code STRING}
   *   <li>{@link ByteArray} for {@code BYTES}
   * </ul>
   *
   * @throws IllegalArgumentException if any member of {@code values} is not a supported type
   */
  public static Key of(Object... values) {
    // A literal Key.of(null) results in a null array being passed.  Provide a clearer error.
    checkNotNull(
        values,
        "'values' cannot be null.  For a literal key containing a single null value, "
            + "call Key.of((Object) null).");
    Builder b = new Builder(false /* builder never leaves this scope */);
    for (Object value : values) {
      b.appendObject(value);
    }
    return b.build();
  }

  /** Returns a new builder for constructing a key. */
  public static Builder newBuilder() {
    return new Builder(true /* escaped */);
  }

  /** Builder for {@link Key} instances. */
  public static class Builder {
    /**
     * Indicates whether this builder can escape the scope of this class. If so, we must assume that
     * the builder can be modified after {@code build()} is called and so we perform a defensive
     * copy.
     */
    private final boolean canEscape;

    private final ArrayList<Object> buffer = new ArrayList<>();

    private Builder(boolean canEscape) {
      this.canEscape = canEscape;
    }

    private Builder(Key key) {
      canEscape = true;
      buffer.addAll(key.parts);
    }

    /** Appends a {@code BOOL} value to the key. */
    public Builder append(@Nullable Boolean value) {
      buffer.add(value);
      return this;
    }
    /** Appends an {@code INT64} value to the key. */
    public Builder append(long value) {
      buffer.add(value);
      return this;
    }
    /** Appends an {@code INT64} value to the key. */
    public Builder append(@Nullable Long value) {
      buffer.add(value);
      return this;
    }
    /** Appends a {@code FLOAT64} value to the key. */
    public Builder append(double value) {
      buffer.add(value);
      return this;
    }
    /** Appends a {@code FLOAT64} value to the key. */
    public Builder append(@Nullable Double value) {
      buffer.add(value);
      return this;
    }
    /** Appends a {@code STRING} value to the key. */
    public Builder append(@Nullable String value) {
      buffer.add(value);
      return this;
    }
    /** Appends a {@code BYTES} value to the key. */
    public Builder append(@Nullable ByteArray value) {
      buffer.add(value);
      return this;
    }

    /** Appends a {@code TIMESTAMP} value to the key */
    public Builder append(@Nullable Timestamp value) {
      buffer.add(value);
      return this;
    }

    /** Appends a {@code DATE} value to the key */
    public Builder append(@Nullable Date value) {
      buffer.add(value);
      return this;
    }

    /**
     * Appends an object following the same conversion rules as {@link Key#of(Object...)}. When
     * using the {@code Builder}, most code should prefer using the strongly typed {@code
     * append(...)} methods, for both performance and the benefit of compile-time checking.
     */
    public Builder appendObject(@Nullable Object value) {
      if (value == null) {
        append((Boolean) null);
      } else if (value instanceof Boolean) {
        append((Boolean) value);
      } else if (value instanceof Integer) {
        append((Integer) value);
      } else if (value instanceof Long) {
        append((Long) value);
      } else if (value instanceof Float) {
        append((Float) value);
      } else if (value instanceof Double) {
        append((Double) value);
      } else if (value instanceof String) {
        append((String) value);
      } else if (value instanceof ByteArray) {
        append((ByteArray) value);
      } else if (value instanceof Timestamp) {
        append((Timestamp) value);
      } else if (value instanceof Date) {
        append((Date) value);
      } else {
        throw new IllegalArgumentException(
            "Unsupported type ["
                + value.getClass().getCanonicalName()
                + "] for argument: "
                + value);
      }
      return this;
    }

    public Key build() {
      if (canEscape) {
        // Copy buffer to preserve immutability contract.
        return new Key(new ArrayList<>(buffer));
      } else {
        // Internal use of builder that does not escape; no need for defensive copy.
        return new Key(buffer);
      }
    }
  }

  /** Returns the number of parts in this key, including {@code null} values. */
  public int size() {
    return parts.size();
  }

  /**
   * Returns the parts in this key. Each part is represented by the corresponding Cloud Spanner
   * type's canonical Java type, as listed below. Note that other types supported by {@link
   * #of(Object...)} are converted to one of the canonical types.
   *
   * <ul>
   *   <li>{@code BOOL} is represented by {@code Boolean}
   *   <li>{@code INT64} is represented by {@code Long}
   *   <li>{@code FLOAT64} is represented by {@code Double}
   *   <li>{@code STRING} is represented by {@code String}
   *   <li>{@code BYTES} is represented by {@link ByteArray}
   *   <li>{@code TIMESTAMP} is represented by {@link Timestamp}
   *   <li>{@code DATE} is represented by {@link Date}
   * </ul>
   *
   * @return an unmodifiable list containing the key parts
   */
  public Iterable<Object> getParts() {
    return parts;
  }

  /** Returns a builder initialized with the value of this key. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  void toString(StringBuilder b) {
    // ByteArray#toString() doesn't produce nice output, so handle that ourselves.
    Iterable<Object> prettyParts =
        Iterables.transform(
            parts,
            new Function<Object, Object>() {
              @Nullable
              @Override
              public Object apply(@Nullable Object input) {
                return input instanceof ByteArray ? ByteArrays.toString((ByteArray) input) : input;
              }
            });

    // TODO(user): Consider limiting the length of string output.
    // Note: the format produced should match that used for keys in error messages yielded by the
    // backend.
    b.append('[');
    joiner.appendTo(b, prettyParts);
    b.append(']');
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
    Key that = (Key) o;
    return parts.equals(that.parts);
  }

  @Override
  public int hashCode() {
    return parts.hashCode();
  }

  ListValue toProto() {
    ListValue.Builder builder = ListValue.newBuilder();
    for (Object part : parts) {
      if (part == null) {
        builder.addValues(NULL_PROTO);
      } else if (part instanceof Boolean) {
        builder.addValuesBuilder().setBoolValue((Boolean) part);
      } else if (part instanceof Long) {
        builder.addValuesBuilder().setStringValue(part.toString());
      } else if (part instanceof Double) {
        builder.addValuesBuilder().setNumberValue((Double) part);
      } else if (part instanceof String) {
        builder.addValuesBuilder().setStringValue((String) part);
      } else if (part instanceof ByteArray) {
        builder.addValuesBuilder().setStringValue(toBase64((ByteArray) part));
      } else if (part instanceof Timestamp) {
        builder.addValuesBuilder().setStringValue(((Timestamp) part).toString());
      } else {
        throw new AssertionError("Illegal key part: " + part.getClass());
      }
    }
    return builder.build();
  }
}
