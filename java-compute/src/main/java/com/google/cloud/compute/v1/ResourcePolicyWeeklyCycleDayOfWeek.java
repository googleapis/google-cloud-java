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
public final class ResourcePolicyWeeklyCycleDayOfWeek implements ApiMessage {
  private final String day;
  private final String duration;
  private final String startTime;

  private ResourcePolicyWeeklyCycleDayOfWeek() {
    this.day = null;
    this.duration = null;
    this.startTime = null;
  }

  private ResourcePolicyWeeklyCycleDayOfWeek(String day, String duration, String startTime) {
    this.day = day;
    this.duration = duration;
    this.startTime = startTime;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("day".equals(fieldName)) {
      return day;
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

  /** Allows to define schedule that runs specified day of the week. */
  public String getDay() {
    return day;
  }

  /**
   * [Output only] Duration of the time window, automatically chosen to be smallest possible in the
   * given scenario.
   */
  public String getDuration() {
    return duration;
  }

  /**
   * Time within the window to start the operations. It must be in format "HH:MM", where HH :
   * [00-23] and MM : [00-00] GMT.
   */
  public String getStartTime() {
    return startTime;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ResourcePolicyWeeklyCycleDayOfWeek prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ResourcePolicyWeeklyCycleDayOfWeek getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ResourcePolicyWeeklyCycleDayOfWeek DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ResourcePolicyWeeklyCycleDayOfWeek();
  }

  public static class Builder {
    private String day;
    private String duration;
    private String startTime;

    Builder() {}

    public Builder mergeFrom(ResourcePolicyWeeklyCycleDayOfWeek other) {
      if (other == ResourcePolicyWeeklyCycleDayOfWeek.getDefaultInstance()) return this;
      if (other.getDay() != null) {
        this.day = other.day;
      }
      if (other.getDuration() != null) {
        this.duration = other.duration;
      }
      if (other.getStartTime() != null) {
        this.startTime = other.startTime;
      }
      return this;
    }

    Builder(ResourcePolicyWeeklyCycleDayOfWeek source) {
      this.day = source.day;
      this.duration = source.duration;
      this.startTime = source.startTime;
    }

    /** Allows to define schedule that runs specified day of the week. */
    public String getDay() {
      return day;
    }

    /** Allows to define schedule that runs specified day of the week. */
    public Builder setDay(String day) {
      this.day = day;
      return this;
    }

    /**
     * [Output only] Duration of the time window, automatically chosen to be smallest possible in
     * the given scenario.
     */
    public String getDuration() {
      return duration;
    }

    /**
     * [Output only] Duration of the time window, automatically chosen to be smallest possible in
     * the given scenario.
     */
    public Builder setDuration(String duration) {
      this.duration = duration;
      return this;
    }

    /**
     * Time within the window to start the operations. It must be in format "HH:MM", where HH :
     * [00-23] and MM : [00-00] GMT.
     */
    public String getStartTime() {
      return startTime;
    }

    /**
     * Time within the window to start the operations. It must be in format "HH:MM", where HH :
     * [00-23] and MM : [00-00] GMT.
     */
    public Builder setStartTime(String startTime) {
      this.startTime = startTime;
      return this;
    }

    public ResourcePolicyWeeklyCycleDayOfWeek build() {

      return new ResourcePolicyWeeklyCycleDayOfWeek(day, duration, startTime);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDay(this.day);
      newBuilder.setDuration(this.duration);
      newBuilder.setStartTime(this.startTime);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ResourcePolicyWeeklyCycleDayOfWeek{"
        + "day="
        + day
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
    if (o instanceof ResourcePolicyWeeklyCycleDayOfWeek) {
      ResourcePolicyWeeklyCycleDayOfWeek that = (ResourcePolicyWeeklyCycleDayOfWeek) o;
      return Objects.equals(this.day, that.getDay())
          && Objects.equals(this.duration, that.getDuration())
          && Objects.equals(this.startTime, that.getStartTime());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(day, duration, startTime);
  }
}
