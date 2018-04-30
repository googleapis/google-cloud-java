/*
 * Copyright 2018 Google LLC
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

import com.google.api.services.bigquery.model.QueryTimelineSample;
import com.google.common.base.Function;
import com.google.auto.value.AutoValue;
import javax.annotation.Nullable;

/**
 * A specific timeline sample.  This instruments work progress at a given point in time, providing
 * information about work units active/pending/completed as well as cumulative slot-milliseconds.
 */
@AutoValue
public abstract class TimelineSample {

  private static final long serialVersionUID = 1L;

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder setElapsedMs(Long elapsedMs);

    public abstract Builder setActiveUnits(Long activeUnits);

    public abstract Builder setCompletedUnits(Long completedUnits);

    public abstract Builder setPendingUnits(Long pendingUnits);

    public abstract Builder setSlotMillis(Long slotMillis);

    public abstract TimelineSample build();

  }

  /**
   * Returns the sample time as milliseconds elapsed since the start of query execution.
   */
  @Nullable
  public abstract Long getElapsedMs();

  /**
   * Returns the total number of work units currently being processed.
   */
  @Nullable
  public abstract Long getActiveUnits();

  /**
   * Returns the total number of work units completed by this query.
   */
  @Nullable
  public abstract Long getCompletedUnits();

  /**
   * Returns the number of work units remaining for the currently active stages.
   */
  @Nullable
  public abstract Long getPendingUnits();

  /**
   * Returns the cumulative slot-milliseconds consumed by the query.
   */
  @Nullable
  public abstract Long getSlotMillis();

  /**
   * return a builder for the {@TimelineSample} object.
   */
  public abstract Builder toBuilder();

  static Builder newBuilder() {
    return new AutoValue_TimelineSample.Builder();
  }

  static TimelineSample fromPb(QueryTimelineSample sample) {
    Builder builder = newBuilder();
    builder.setElapsedMs(sample.getElapsedMs());
    builder.setActiveUnits(sample.getActiveUnits());
    builder.setCompletedUnits(sample.getCompletedUnits());
    builder.setPendingUnits(sample.getPendingUnits());
    builder.setSlotMillis(sample.getTotalSlotMs());
    return builder.build();
  }

  QueryTimelineSample toPb() {
    QueryTimelineSample sample = new QueryTimelineSample()
        .setElapsedMs(getElapsedMs())
        .setActiveUnits(getActiveUnits())
        .setCompletedUnits(getCompletedUnits())
        .setPendingUnits(getPendingUnits())
        .setTotalSlotMs(getSlotMillis());
    return sample;
  }

  static final Function<QueryTimelineSample, TimelineSample> FROM_PB_FUNCTION =
      new Function<QueryTimelineSample, TimelineSample>() {
        @Override
        public TimelineSample apply(QueryTimelineSample pb) {
          return TimelineSample.fromPb(pb);
        }
      };

  static final Function<TimelineSample, QueryTimelineSample> TO_PB_FUNCTION =
      new Function<TimelineSample, QueryTimelineSample>() {
        @Override
        public QueryTimelineSample apply(TimelineSample sample) {
          return sample.toPb();
        }
      };

}
