/*
 * Copyright 2019 Google LLC
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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.io.Serializable;

public final class RangePartitioning implements Serializable {

  private static final long serialVersionUID = 2011646901758026886L;
  private final String field;
  private final Range range;

  public static final class Range implements Serializable {

    private static final long serialVersionUID = -7603436109151103007L;
    private final Long end;
    private final Long interval;
    private final Long start;

    private Range(Builder builder) {
      this.end = builder.end;
      this.interval = builder.interval;
      this.start = builder.start;
    }

    private Range(com.google.api.services.bigquery.model.RangePartitioning.Range range) {
      this.end = range.getEnd();
      this.interval = range.getInterval();
      this.start = range.getStart();
    }

    /** A builder for {@code Range} objects. */
    public static final class Builder {

      private Long end;
      private Long interval;
      private Long start;

      private Builder() {}

      /** [Required] The end of range partitioning, exclusive. The value may be {@code null}. */
      public Builder setEnd(Long end) {
        this.end = end;
        return this;
      }

      /** [Required] The width of each interval. The value may be {@code null}. */
      public Builder setInterval(Long interval) {
        this.interval = interval;
        return this;
      }

      /** [Required] The start of range partitioning, inclusive. The value may be {@code null}. */
      public Builder setStart(Long start) {
        this.start = start;
        return this;
      }

      /** Creates a {@code Range} object. */
      public Range build() {
        return new Range(this);
      }
    }

    /** Returns the end of range partitioning. */
    public Long getEnd() {
      return end;
    }

    /** Returns the width of each interval. */
    public Long getInterval() {
      return interval;
    }

    /** Returns the start of range partitioning. */
    public Long getStart() {
      return start;
    }

    /** Returns a builder for a Range object. */
    public static Builder newBuilder() {
      return new Builder();
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("end", end)
          .add("interval", interval)
          .add("start", start)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(end, interval, start);
    }

    @Override
    public boolean equals(Object obj) {
      return obj == this
          || obj != null
              && obj.getClass().equals(Range.class)
              && java.util.Objects.equals(toPb(), ((Range) obj).toPb());
    }

    com.google.api.services.bigquery.model.RangePartitioning.Range toPb() {
      com.google.api.services.bigquery.model.RangePartitioning.Range range =
          new com.google.api.services.bigquery.model.RangePartitioning.Range();
      range.setEnd(end);
      range.setInterval(interval);
      range.setStart(start);
      return range;
    }

    static Range fromPb(com.google.api.services.bigquery.model.RangePartitioning.Range range) {
      return new Range(range);
    }
  }

  /** A builder for {@code RangePartitioning} objects. */
  public static final class Builder {

    private String field;
    private Range range;

    private Builder() {}

    private Builder(RangePartitioning rangePartitioning) {
      this.field = rangePartitioning.field;
      this.range = rangePartitioning.range;
    }

    /**
     * [Required] The table is partitioned by this field. The field must be a top- level
     * NULLABLE/REQUIRED field. The only supported type is INTEGER/INT64.
     *
     * @param field field or {@code null} for none
     */
    public Builder setField(String field) {
      checkArgument(!isNullOrEmpty(field), "Provided field is null or empty");
      this.field = field;
      return this;
    }

    /**
     * [Required] Defines the ranges for range partitioning.
     *
     * @param range range or {@code null} for none
     */
    public Builder setRange(Range range) {
      this.range = range;
      return this;
    }

    /** Creates a {@code RangePartitioning} object. */
    public RangePartitioning build() {
      return new RangePartitioning(this);
    }
  }

  private RangePartitioning(Builder builder) {
    this.field = builder.field;
    this.range = builder.range;
  }

  private RangePartitioning(
      com.google.api.services.bigquery.model.RangePartitioning rangePartitioning) {
    this.field = rangePartitioning.getField();
    this.range = Range.fromPb(rangePartitioning.getRange());
  }

  /** Returns the range partitioning field. */
  public String getField() {
    return field;
  }

  /** Returns the range of range partitioning. */
  public Range getRange() {
    return range;
  }

  /** Returns a builder for a RangePartitioning object */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a builder for the {@code RangePartitioning} object. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("field", field).add("range", range).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(field, range);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(RangePartitioning.class)
            && java.util.Objects.equals(toPb(), ((RangePartitioning) obj).toPb());
  }

  com.google.api.services.bigquery.model.RangePartitioning toPb() {
    com.google.api.services.bigquery.model.RangePartitioning rangePartitioning =
        new com.google.api.services.bigquery.model.RangePartitioning();
    rangePartitioning.setField(field);
    rangePartitioning.setRange(range.toPb());
    return rangePartitioning;
  }

  static RangePartitioning fromPb(
      com.google.api.services.bigquery.model.RangePartitioning rangePartitioning) {
    return new RangePartitioning(rangePartitioning);
  }
}
