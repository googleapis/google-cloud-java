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
/** Time window specified for daily operations. */
public final class ResourcePolicyDailyCycle implements ApiMessage {
  private final Integer daysInCycle;
  private final String duration;
  private final String startTime;

  private ResourcePolicyDailyCycle() {
    this.daysInCycle = null;
    this.duration = null;
    this.startTime = null;
  }

  private ResourcePolicyDailyCycle(Integer daysInCycle, String duration, String startTime) {
    this.daysInCycle = daysInCycle;
    this.duration = duration;
    this.startTime = startTime;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("daysInCycle".equals(fieldName)) {
      return daysInCycle;
    }
    if ("duration".equals(fieldName)) {
      return duration;
    }
    if ("startTime".equals(fieldName)) {
      return startTime;
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

  /** Defines a schedule that runs every nth day of the month. */
  public Integer getDaysInCycle() {
    return daysInCycle;
  }

  /**
   * [Output only] A predetermined duration for the window, automatically chosen to be the smallest
   * possible in the given scenario.
   */
  public String getDuration() {
    return duration;
  }

  /**
   * Start time of the window. This must be in UTC format that resolves to one of 00:00, 04:00,
   * 08:00, 12:00, 16:00, or 20:00. For example, both 13:00-5 and 08:00 are valid.
   */
  public String getStartTime() {
    return startTime;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ResourcePolicyDailyCycle prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ResourcePolicyDailyCycle getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ResourcePolicyDailyCycle DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ResourcePolicyDailyCycle();
  }

  public static class Builder {
    private Integer daysInCycle;
    private String duration;
    private String startTime;

    Builder() {}

    public Builder mergeFrom(ResourcePolicyDailyCycle other) {
      if (other == ResourcePolicyDailyCycle.getDefaultInstance()) return this;
      if (other.getDaysInCycle() != null) {
        this.daysInCycle = other.daysInCycle;
      }
      if (other.getDuration() != null) {
        this.duration = other.duration;
      }
      if (other.getStartTime() != null) {
        this.startTime = other.startTime;
      }
      return this;
    }

    Builder(ResourcePolicyDailyCycle source) {
      this.daysInCycle = source.daysInCycle;
      this.duration = source.duration;
      this.startTime = source.startTime;
    }

    /** Defines a schedule that runs every nth day of the month. */
    public Integer getDaysInCycle() {
      return daysInCycle;
    }

    /** Defines a schedule that runs every nth day of the month. */
    public Builder setDaysInCycle(Integer daysInCycle) {
      this.daysInCycle = daysInCycle;
      return this;
    }

    /**
     * [Output only] A predetermined duration for the window, automatically chosen to be the
     * smallest possible in the given scenario.
     */
    public String getDuration() {
      return duration;
    }

    /**
     * [Output only] A predetermined duration for the window, automatically chosen to be the
     * smallest possible in the given scenario.
     */
    public Builder setDuration(String duration) {
      this.duration = duration;
      return this;
    }

    /**
     * Start time of the window. This must be in UTC format that resolves to one of 00:00, 04:00,
     * 08:00, 12:00, 16:00, or 20:00. For example, both 13:00-5 and 08:00 are valid.
     */
    public String getStartTime() {
      return startTime;
    }

    /**
     * Start time of the window. This must be in UTC format that resolves to one of 00:00, 04:00,
     * 08:00, 12:00, 16:00, or 20:00. For example, both 13:00-5 and 08:00 are valid.
     */
    public Builder setStartTime(String startTime) {
      this.startTime = startTime;
      return this;
    }

    public ResourcePolicyDailyCycle build() {

      return new ResourcePolicyDailyCycle(daysInCycle, duration, startTime);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDaysInCycle(this.daysInCycle);
      newBuilder.setDuration(this.duration);
      newBuilder.setStartTime(this.startTime);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ResourcePolicyDailyCycle{"
        + "daysInCycle="
        + daysInCycle
        + ", "
        + "duration="
        + duration
        + ", "
        + "startTime="
        + startTime
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ResourcePolicyDailyCycle) {
      ResourcePolicyDailyCycle that = (ResourcePolicyDailyCycle) o;
      return Objects.equals(this.daysInCycle, that.getDaysInCycle())
          && Objects.equals(this.duration, that.getDuration())
          && Objects.equals(this.startTime, that.getStartTime());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(daysInCycle, duration, startTime);
  }
}
