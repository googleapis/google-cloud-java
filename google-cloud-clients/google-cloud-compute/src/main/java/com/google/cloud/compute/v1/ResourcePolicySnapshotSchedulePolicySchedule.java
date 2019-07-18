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
/** A schedule for disks where the schedueled operations are performed. */
public final class ResourcePolicySnapshotSchedulePolicySchedule implements ApiMessage {
  private final ResourcePolicyDailyCycle dailySchedule;
  private final ResourcePolicyHourlyCycle hourlySchedule;
  private final ResourcePolicyWeeklyCycle weeklySchedule;

  private ResourcePolicySnapshotSchedulePolicySchedule() {
    this.dailySchedule = null;
    this.hourlySchedule = null;
    this.weeklySchedule = null;
  }

  private ResourcePolicySnapshotSchedulePolicySchedule(
      ResourcePolicyDailyCycle dailySchedule,
      ResourcePolicyHourlyCycle hourlySchedule,
      ResourcePolicyWeeklyCycle weeklySchedule) {
    this.dailySchedule = dailySchedule;
    this.hourlySchedule = hourlySchedule;
    this.weeklySchedule = weeklySchedule;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("dailySchedule".equals(fieldName)) {
      return dailySchedule;
    }
    if ("hourlySchedule".equals(fieldName)) {
      return hourlySchedule;
    }
    if ("weeklySchedule".equals(fieldName)) {
      return weeklySchedule;
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

  public ResourcePolicyDailyCycle getDailySchedule() {
    return dailySchedule;
  }

  public ResourcePolicyHourlyCycle getHourlySchedule() {
    return hourlySchedule;
  }

  public ResourcePolicyWeeklyCycle getWeeklySchedule() {
    return weeklySchedule;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ResourcePolicySnapshotSchedulePolicySchedule prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ResourcePolicySnapshotSchedulePolicySchedule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ResourcePolicySnapshotSchedulePolicySchedule DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ResourcePolicySnapshotSchedulePolicySchedule();
  }

  public static class Builder {
    private ResourcePolicyDailyCycle dailySchedule;
    private ResourcePolicyHourlyCycle hourlySchedule;
    private ResourcePolicyWeeklyCycle weeklySchedule;

    Builder() {}

    public Builder mergeFrom(ResourcePolicySnapshotSchedulePolicySchedule other) {
      if (other == ResourcePolicySnapshotSchedulePolicySchedule.getDefaultInstance()) return this;
      if (other.getDailySchedule() != null) {
        this.dailySchedule = other.dailySchedule;
      }
      if (other.getHourlySchedule() != null) {
        this.hourlySchedule = other.hourlySchedule;
      }
      if (other.getWeeklySchedule() != null) {
        this.weeklySchedule = other.weeklySchedule;
      }
      return this;
    }

    Builder(ResourcePolicySnapshotSchedulePolicySchedule source) {
      this.dailySchedule = source.dailySchedule;
      this.hourlySchedule = source.hourlySchedule;
      this.weeklySchedule = source.weeklySchedule;
    }

    public ResourcePolicyDailyCycle getDailySchedule() {
      return dailySchedule;
    }

    public Builder setDailySchedule(ResourcePolicyDailyCycle dailySchedule) {
      this.dailySchedule = dailySchedule;
      return this;
    }

    public ResourcePolicyHourlyCycle getHourlySchedule() {
      return hourlySchedule;
    }

    public Builder setHourlySchedule(ResourcePolicyHourlyCycle hourlySchedule) {
      this.hourlySchedule = hourlySchedule;
      return this;
    }

    public ResourcePolicyWeeklyCycle getWeeklySchedule() {
      return weeklySchedule;
    }

    public Builder setWeeklySchedule(ResourcePolicyWeeklyCycle weeklySchedule) {
      this.weeklySchedule = weeklySchedule;
      return this;
    }

    public ResourcePolicySnapshotSchedulePolicySchedule build() {

      return new ResourcePolicySnapshotSchedulePolicySchedule(
          dailySchedule, hourlySchedule, weeklySchedule);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDailySchedule(this.dailySchedule);
      newBuilder.setHourlySchedule(this.hourlySchedule);
      newBuilder.setWeeklySchedule(this.weeklySchedule);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ResourcePolicySnapshotSchedulePolicySchedule{"
        + "dailySchedule="
        + dailySchedule
        + ", "
        + "hourlySchedule="
        + hourlySchedule
        + ", "
        + "weeklySchedule="
        + weeklySchedule
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ResourcePolicySnapshotSchedulePolicySchedule) {
      ResourcePolicySnapshotSchedulePolicySchedule that =
          (ResourcePolicySnapshotSchedulePolicySchedule) o;
      return Objects.equals(this.dailySchedule, that.getDailySchedule())
          && Objects.equals(this.hourlySchedule, that.getHourlySchedule())
          && Objects.equals(this.weeklySchedule, that.getWeeklySchedule());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(dailySchedule, hourlySchedule, weeklySchedule);
  }
}
