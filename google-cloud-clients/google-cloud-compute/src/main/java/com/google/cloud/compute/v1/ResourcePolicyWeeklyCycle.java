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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** Time window specified for weekly operations. */
public final class ResourcePolicyWeeklyCycle implements ApiMessage {
  private final List<ResourcePolicyWeeklyCycleDayOfWeek> dayOfWeeks;

  private ResourcePolicyWeeklyCycle() {
    this.dayOfWeeks = null;
  }

  private ResourcePolicyWeeklyCycle(List<ResourcePolicyWeeklyCycleDayOfWeek> dayOfWeeks) {
    this.dayOfWeeks = dayOfWeeks;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("dayOfWeeks".equals(fieldName)) {
      return dayOfWeeks;
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

  /** Up to 7 intervals/windows, one for each day of the week. */
  public List<ResourcePolicyWeeklyCycleDayOfWeek> getDayOfWeeksList() {
    return dayOfWeeks;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ResourcePolicyWeeklyCycle prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ResourcePolicyWeeklyCycle getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ResourcePolicyWeeklyCycle DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ResourcePolicyWeeklyCycle();
  }

  public static class Builder {
    private List<ResourcePolicyWeeklyCycleDayOfWeek> dayOfWeeks;

    Builder() {}

    public Builder mergeFrom(ResourcePolicyWeeklyCycle other) {
      if (other == ResourcePolicyWeeklyCycle.getDefaultInstance()) return this;
      if (other.getDayOfWeeksList() != null) {
        this.dayOfWeeks = other.dayOfWeeks;
      }
      return this;
    }

    Builder(ResourcePolicyWeeklyCycle source) {
      this.dayOfWeeks = source.dayOfWeeks;
    }

    /** Up to 7 intervals/windows, one for each day of the week. */
    public List<ResourcePolicyWeeklyCycleDayOfWeek> getDayOfWeeksList() {
      return dayOfWeeks;
    }

    /** Up to 7 intervals/windows, one for each day of the week. */
    public Builder addAllDayOfWeeks(List<ResourcePolicyWeeklyCycleDayOfWeek> dayOfWeeks) {
      if (this.dayOfWeeks == null) {
        this.dayOfWeeks = new LinkedList<>();
      }
      this.dayOfWeeks.addAll(dayOfWeeks);
      return this;
    }

    /** Up to 7 intervals/windows, one for each day of the week. */
    public Builder addDayOfWeeks(ResourcePolicyWeeklyCycleDayOfWeek dayOfWeeks) {
      if (this.dayOfWeeks == null) {
        this.dayOfWeeks = new LinkedList<>();
      }
      this.dayOfWeeks.add(dayOfWeeks);
      return this;
    }

    public ResourcePolicyWeeklyCycle build() {
      return new ResourcePolicyWeeklyCycle(dayOfWeeks);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllDayOfWeeks(this.dayOfWeeks);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ResourcePolicyWeeklyCycle{" + "dayOfWeeks=" + dayOfWeeks + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ResourcePolicyWeeklyCycle) {
      ResourcePolicyWeeklyCycle that = (ResourcePolicyWeeklyCycle) o;
      return Objects.equals(this.dayOfWeeks, that.getDayOfWeeksList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(dayOfWeeks);
  }
}
