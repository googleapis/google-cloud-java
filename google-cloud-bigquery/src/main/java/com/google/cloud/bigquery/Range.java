/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.auto.value.AutoValue;
import com.google.cloud.bigquery.FieldValue.Attribute;
import java.io.Serializable;
import javax.annotation.Nullable;

@AutoValue
public abstract class Range implements Serializable {
  private static final long serialVersionUID = 1L;

  /** Returns the start value of the range. A null value represents an unbounded start. */
  public FieldValue getStart() {
    // The supported Range types [DATE, TIME, TIMESTAMP] are all Attribute.PRIMITIVE.
    return FieldValue.of(Attribute.PRIMITIVE, getStartInner());
  }

  @Nullable
  abstract String getStartInner();

  /** Returns the end value of the range. A null value represents an unbounded end. */
  public FieldValue getEnd() {
    // The supported Range types [DATE, TIME, TIMESTAMP] are all Attribute.PRIMITIVE.
    return FieldValue.of(Attribute.PRIMITIVE, getEndInner());
  }

  @Nullable
  abstract String getEndInner();

  /** Returns the type of the range. */
  @Nullable
  public abstract FieldElementType getType();

  public abstract Range.Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    public Range.Builder setStart(String start) {
      return setStartInner(start);
    }

    abstract Range.Builder setStartInner(String start);

    public Range.Builder setEnd(String end) {
      return setEndInner(end);
    }

    abstract Range.Builder setEndInner(String end);

    public abstract Range.Builder setType(FieldElementType type);

    public abstract Range build();
  }

  /** Creates a range builder. Supported StandardSQLTypeName are [DATE, DATETIME, TIMESTAMP] */
  public static Builder newBuilder() {
    return new AutoValue_Range.Builder();
  }

  public static Range of(String value) throws IllegalArgumentException {
    return of(value, null);
  }

  /**
   * Creates an instance of {@code Range} from a string representation.
   *
   * <p>The expected string format is: "[start, end)", where start and end are string format of
   * [DATE, TIME, TIMESTAMP].
   */
  public static Range of(String value, FieldElementType type) throws IllegalArgumentException {
    checkNotNull(value);
    Range.Builder builder = newBuilder();
    if (type != null) {
      builder.setType(type);
    }
    String[] startEnd = value.split(", ", 2); // Expect an extra space after ','.
    if (startEnd.length != 2) {
      throw new IllegalArgumentException(
          String.format("Expected Range value string to be [start, end) and got %s", value));
    }

    String start = startEnd[0].substring(1); // Ignore the [
    String end = startEnd[1].substring(0, startEnd[1].length() - 1); // Ignore the )
    if (start.equalsIgnoreCase("UNBOUNDED") || (start.equalsIgnoreCase("NULL"))) {
      builder.setStart(null);
    } else {
      builder.setStart(start);
    }
    if (end.equalsIgnoreCase("UNBOUNDED") || (end.equalsIgnoreCase("NULL"))) {
      builder.setEnd(null);
    } else {
      builder.setEnd(end);
    }
    return builder.build();
  }
}
