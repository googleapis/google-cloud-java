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
/** Time window specified for hourly operations. */
public final class ResourcePolicyHourlyCycle implements ApiMessage {
  private final String duration;
  private final Integer hoursInCycle;
  private final String startTime;

  private ResourcePolicyHourlyCycle() {
    this.duration = null;
    this.hoursInCycle = null;
    this.startTime = null;
  }

  private ResourcePolicyHourlyCycle(String duration, Integer hoursInCycle, String startTime) {
    this.duration = duration;
    this.hoursInCycle = hoursInCycle;
    this.startTime = startTime;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("duration".equals(fieldName)) {
      return duration;
    }
    if ("hoursInCycle".equals(fieldName)) {
      return hoursInCycle;
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

  /**
   * [Output only] Duration of the time window, automatically chosen to be smallest possible in the
   * given scenario.
   */
  public String getDuration() {
    return duration;
  }

  /** Allows to define schedule that runs every nth hour. */
  public Integer getHoursInCycle() {
    return hoursInCycle;
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

  public static Builder newBuilder(ResourcePolicyHourlyCycle prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ResourcePolicyHourlyCycle getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ResourcePolicyHourlyCycle DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ResourcePolicyHourlyCycle();
  }

  public static class Builder {
    private String duration;
    private Integer hoursInCycle;
    private String startTime;

    Builder() {}

    public Builder mergeFrom(ResourcePolicyHourlyCycle other) {
      if (other == ResourcePolicyHourlyCycle.getDefaultInstance()) return this;
      if (other.getDuration() != null) {
        this.duration = other.duration;
      }
      if (other.getHoursInCycle() != null) {
        this.hoursInCycle = other.hoursInCycle;
      }
      if (other.getStartTime() != null) {
        this.startTime = other.startTime;
      }
      return this;
    }

    Builder(ResourcePolicyHourlyCycle source) {
      this.duration = source.duration;
      this.hoursInCycle = source.hoursInCycle;
      this.startTime = source.startTime;
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

    /** Allows to define schedule that runs every nth hour. */
    public Integer getHoursInCycle() {
      return hoursInCycle;
    }

    /** Allows to define schedule that runs every nth hour. */
    public Builder setHoursInCycle(Integer hoursInCycle) {
      this.hoursInCycle = hoursInCycle;
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

    public ResourcePolicyHourlyCycle build() {

      return new ResourcePolicyHourlyCycle(duration, hoursInCycle, startTime);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDuration(this.duration);
      newBuilder.setHoursInCycle(this.hoursInCycle);
      newBuilder.setStartTime(this.startTime);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ResourcePolicyHourlyCycle{"
        + "duration="
        + duration
        + ", "
        + "hoursInCycle="
        + hoursInCycle
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
    if (o instanceof ResourcePolicyHourlyCycle) {
      ResourcePolicyHourlyCycle that = (ResourcePolicyHourlyCycle) o;
      return Objects.equals(this.duration, that.getDuration())
          && Objects.equals(this.hoursInCycle, that.getHoursInCycle())
          && Objects.equals(this.startTime, that.getStartTime());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(duration, hoursInCycle, startTime);
  }
}
