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
 * HttpRouteRuleMatch criteria for field values that must stay within the specified integer range.
 */
public final class Int64RangeMatch implements ApiMessage {
  private final String rangeEnd;
  private final String rangeStart;

  private Int64RangeMatch() {
    this.rangeEnd = null;
    this.rangeStart = null;
  }

  private Int64RangeMatch(String rangeEnd, String rangeStart) {
    this.rangeEnd = rangeEnd;
    this.rangeStart = rangeStart;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("rangeEnd".equals(fieldName)) {
      return rangeEnd;
    }
    if ("rangeStart".equals(fieldName)) {
      return rangeStart;
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

  /** The end of the range (exclusive) in signed long integer format. */
  public String getRangeEnd() {
    return rangeEnd;
  }

  /** The start of the range (inclusive) in signed long integer format. */
  public String getRangeStart() {
    return rangeStart;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Int64RangeMatch prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Int64RangeMatch getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Int64RangeMatch DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Int64RangeMatch();
  }

  public static class Builder {
    private String rangeEnd;
    private String rangeStart;

    Builder() {}

    public Builder mergeFrom(Int64RangeMatch other) {
      if (other == Int64RangeMatch.getDefaultInstance()) return this;
      if (other.getRangeEnd() != null) {
        this.rangeEnd = other.rangeEnd;
      }
      if (other.getRangeStart() != null) {
        this.rangeStart = other.rangeStart;
      }
      return this;
    }

    Builder(Int64RangeMatch source) {
      this.rangeEnd = source.rangeEnd;
      this.rangeStart = source.rangeStart;
    }

    /** The end of the range (exclusive) in signed long integer format. */
    public String getRangeEnd() {
      return rangeEnd;
    }

    /** The end of the range (exclusive) in signed long integer format. */
    public Builder setRangeEnd(String rangeEnd) {
      this.rangeEnd = rangeEnd;
      return this;
    }

    /** The start of the range (inclusive) in signed long integer format. */
    public String getRangeStart() {
      return rangeStart;
    }

    /** The start of the range (inclusive) in signed long integer format. */
    public Builder setRangeStart(String rangeStart) {
      this.rangeStart = rangeStart;
      return this;
    }

    public Int64RangeMatch build() {

      return new Int64RangeMatch(rangeEnd, rangeStart);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setRangeEnd(this.rangeEnd);
      newBuilder.setRangeStart(this.rangeStart);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Int64RangeMatch{" + "rangeEnd=" + rangeEnd + ", " + "rangeStart=" + rangeStart + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Int64RangeMatch) {
      Int64RangeMatch that = (Int64RangeMatch) o;
      return Objects.equals(this.rangeEnd, that.getRangeEnd())
          && Objects.equals(this.rangeStart, that.getRangeStart());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(rangeEnd, rangeStart);
  }
}
