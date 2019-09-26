/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * A Duration represents a fixed-length span of time represented as a count of seconds and fractions
 * of seconds at nanosecond resolution. It is independent of any calendar and concepts like "day" or
 * "month". Range is approximately 10,000 years.
 */
public final class Duration implements ApiMessage {
  private final Integer nanos;
  private final String seconds;

  private Duration() {
    this.nanos = null;
    this.seconds = null;
  }

  private Duration(Integer nanos, String seconds) {
    this.nanos = nanos;
    this.seconds = seconds;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("nanos".equals(fieldName)) {
      return nanos;
    }
    if ("seconds".equals(fieldName)) {
      return seconds;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /**
   * Span of time that's a fraction of a second at nanosecond resolution. Durations less than one
   * second are represented with a 0 `seconds` field and a positive `nanos` field. Must be from 0 to
   * 999,999,999 inclusive.
   */
  public Integer getNanos() {
    return nanos;
  }

  /**
   * Span of time at a resolution of a second. Must be from 0 to 315,576,000,000 inclusive. Note:
   * these bounds are computed from: 60 sec/min &#42; 60 min/hr &#42; 24 hr/day &#42; 365.25
   * days/year &#42; 10000 years
   */
  public String getSeconds() {
    return seconds;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Duration prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Duration getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Duration DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Duration();
  }

  public static class Builder {
    private Integer nanos;
    private String seconds;

    Builder() {}

    public Builder mergeFrom(Duration other) {
      if (other == Duration.getDefaultInstance()) return this;
      if (other.getNanos() != null) {
        this.nanos = other.nanos;
      }
      if (other.getSeconds() != null) {
        this.seconds = other.seconds;
      }
      return this;
    }

    Builder(Duration source) {
      this.nanos = source.nanos;
      this.seconds = source.seconds;
    }

    /**
     * Span of time that's a fraction of a second at nanosecond resolution. Durations less than one
     * second are represented with a 0 `seconds` field and a positive `nanos` field. Must be from 0
     * to 999,999,999 inclusive.
     */
    public Integer getNanos() {
      return nanos;
    }

    /**
     * Span of time that's a fraction of a second at nanosecond resolution. Durations less than one
     * second are represented with a 0 `seconds` field and a positive `nanos` field. Must be from 0
     * to 999,999,999 inclusive.
     */
    public Builder setNanos(Integer nanos) {
      this.nanos = nanos;
      return this;
    }

    /**
     * Span of time at a resolution of a second. Must be from 0 to 315,576,000,000 inclusive. Note:
     * these bounds are computed from: 60 sec/min &#42; 60 min/hr &#42; 24 hr/day &#42; 365.25
     * days/year &#42; 10000 years
     */
    public String getSeconds() {
      return seconds;
    }

    /**
     * Span of time at a resolution of a second. Must be from 0 to 315,576,000,000 inclusive. Note:
     * these bounds are computed from: 60 sec/min &#42; 60 min/hr &#42; 24 hr/day &#42; 365.25
     * days/year &#42; 10000 years
     */
    public Builder setSeconds(String seconds) {
      this.seconds = seconds;
      return this;
    }

    public Duration build() {

      return new Duration(nanos, seconds);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setNanos(this.nanos);
      newBuilder.setSeconds(this.seconds);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Duration{" + "nanos=" + nanos + ", " + "seconds=" + seconds + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Duration) {
      Duration that = (Duration) o;
      return Objects.equals(this.nanos, that.getNanos())
          && Objects.equals(this.seconds, that.getSeconds());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(nanos, seconds);
  }
}
