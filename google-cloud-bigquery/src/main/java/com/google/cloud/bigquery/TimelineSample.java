package com.google.cloud.bigquery;

import com.google.cloud.bigquery.QueryStage.Builder;
import com.google.cloud.bigquery.QueryStage.QueryStep;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import com.google.api.services.bigquery.model.QueryTimelineSample;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import java.util.Objects;


public class TimelineSample implements Serializable {

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
        public QueryTimelineSample apply (TimelineSample sample) {
          return sample.toPb();
        }
      };





  /**
   * Returns the sample time as milliseconds elapsed since the start of query execution.
   */
  public long getElapsedMs() {
    return this.elapsedMs;
  }

  /**
   * Returns the total number of work units currently being processed.
   */
  public long getActiveUnits() {
    return this.activeUnits;
  }

  /**
   * Returns the total number of work units completed by this query.
   */
  public long getCompletedUnits() {
    return this.completedUnits;
  }

  /**
   * Returns the number of work units remaining for the currently active stages.
   */
  public long getPendingUnits() {
    return this.pendingUnits;
  }

  /**
   * Returns the cumulative slot-milliseconds consumed by the query.
   */
  public long getSlotMillis() {
    return this.slotMillis;
  }

  private final long elapsedMs;
  private final long activeUnits;
  private final long completedUnits;
  private final long pendingUnits;
  private final long slotMillis;

  static final class Builder {

    private long elapsedMs;
    private long activeUnits;
    private long completedUnits;
    private long pendingUnits;
    private long slotMillis;

    private Builder() {
    }

    Builder setElapsedMs(long elapsedMs) {
      this.elapsedMs = elapsedMs;
      return this;
    }

    Builder setActiveUnits(long activeUnits) {
      this.activeUnits = activeUnits;
      return this;
    }

    Builder setCompletedUnits(long completedUnits) {
      this.completedUnits = completedUnits;
      return this;
    }

    Builder setPendingUnits(long pendingUnits) {
      this.pendingUnits = pendingUnits;
      return this;
    }

    Builder setSlotMillis(long slotMillis) {
      this.slotMillis = slotMillis;
      return this;
    }

    TimelineSample build() {
      return new TimelineSample(this);
    }

  }

  TimelineSample(Builder builder) {
    elapsedMs = builder.elapsedMs;
    activeUnits = builder.activeUnits;
    completedUnits = builder.completedUnits;
    pendingUnits = builder.pendingUnits;
    slotMillis = builder.slotMillis;
  }

  static TimelineSample.Builder newBuilder() {
    return new TimelineSample.Builder();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("elapsedMs", elapsedMs)
        .add("activeUnits", activeUnits)
        .add("completedUnits", completedUnits)
        .add("pendingUnits", pendingUnits)
        .add("slotMillis", slotMillis)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(elapsedMs, activeUnits, completedUnits, pendingUnits, slotMillis);

  }

  @Override
  public final boolean equals (Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(TimelineSample.class)) {
      return false;
    }
    TimelineSample other = (TimelineSample) obj;
    return elapsedMs == other.elapsedMs
        && activeUnits == other.activeUnits
        && completedUnits == other.completedUnits
        && pendingUnits == other.pendingUnits
        && slotMillis == other.slotMillis;
  }
  static TimelineSample fromPb(com.google.api.services.bigquery.model.QueryTimelineSample sample) {
    Builder builder = new TimelineSample.Builder();
    builder.setElapsedMs(sample.getElapsedMs());
    builder.setActiveUnits(sample.getActiveInputs());
    builder.setCompletedUnits(sample.getCompletedInputs());
    builder.setPendingUnits(sample.getPendingInputs());
    builder.setSlotMillis(sample.getTotalSlotMs());
    return builder.build();
  }

  QueryTimelineSample toPb() {
    QueryTimelineSample sample = new QueryTimelineSample()
        .setElapsedMs(elapsedMs)
        .setActiveInputs(activeUnits)
        .setCompletedInputs(completedUnits)
        .setPendingInputs(pendingUnits)
        .setTotalSlotMs(slotMillis);
    return sample;
  }
}