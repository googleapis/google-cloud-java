/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.logging;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.logging.v2.LogMetric;
import java.io.Serializable;
import java.util.Objects;

/**
 * Stackdriver Logging metrics describe logs-based metric. The value of the metric is the number of
 * log entries that match a logs filter (see {@link #getFilter()}).
 *
 * @see <a href="https://cloud.google.com/logging/docs/view/logs_based_metrics">Logs-based Metrics
 *     </a>
 */
public class MetricInfo implements Serializable {

  private static final long serialVersionUID = 666208243838820325L;

  private final String name;
  private final String description;
  private final String filter;

  /** A builder for {@code MetricInfo} objects. */
  public abstract static class Builder {

    Builder() {}

    /**
     * Sets the name of the metric. Example: {@code severe-errors}. Metric identifiers are limited
     * to 1000 characters and can include only the following characters: {@code A-Z}, {@code a-z},
     * {@code 0-9}, and the special characters {@code _-.,+!*',()%/\}. The forward-slash character
     * ({@code /}) denotes a hierarchy of name pieces, and it cannot be the first character of the
     * name.
     */
    public abstract Builder setName(String name);

    /** Sets an optional description for this metric. Used for documentation purpose. */
    public abstract Builder setDescription(String description);

    /**
     * Sets an advanced logs filter. The value of the metric is the number of log entries that match
     * this filter. Example: {@code logName=projects/my-projectid/logs/syslog AND severity>=ERROR}.
     *
     * @see <a href="https://cloud.google.com/logging/docs/view/advanced_filters">Advanced Log
     *     Filters</a>
     */
    public abstract Builder setFilter(String filter);

    /** Creates a {@code MetricInfo} object for this builder. */
    public abstract MetricInfo build();
  }

  static final class BuilderImpl extends Builder {

    private String name;
    private String description;
    private String filter;

    BuilderImpl(String name, String filter) {
      this.name = name;
      this.filter = filter;
    }

    BuilderImpl(MetricInfo metric) {
      this.name = metric.name;
      this.description = metric.description;
      this.filter = metric.filter;
    }

    @Override
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    @Override
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    @Override
    public Builder setFilter(String filter) {
      this.filter = filter;
      return this;
    }

    @Override
    public MetricInfo build() {
      return new MetricInfo(this);
    }
  }

  MetricInfo(BuilderImpl builder) {
    this.name = checkNotNull(builder.name);
    this.filter = checkNotNull(builder.filter);
    this.description = builder.description;
  }

  /**
   * Returns the name of the metric. Example: {@code severe-errors}. Metric identifiers are limited
   * to 1000 characters and can include only the following characters: {@code A-Z}, {@code a-z},
   * {@code 0-9}, and the special characters {@code _-.,+!*',()%/\}. The forward-slash character
   * ({@code /}) denotes a hierarchy of name pieces, and it cannot be the first character of the
   * name.
   */
  public String getName() {
    return name;
  }

  /** Returns an optional description for this metric. Used for documentation purpose. */
  public String getDescription() {
    return description;
  }

  /**
   * Returns an advanced logs filter. The value of the metric is the number of log entries that
   * match this filter. Example: {@code logName=projects/my-projectid/logs/syslog AND
   * severity>=ERROR}.
   *
   * @see <a href="https://cloud.google.com/logging/docs/view/advanced_filters">Advanced Log
   *     Filters</a>
   */
  public String getFilter() {
    return filter;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .add("description", description)
        .add("filter", filter)
        .toString();
  }

  final boolean baseEquals(MetricInfo metricInfo) {
    return Objects.equals(name, metricInfo.name)
        && Objects.equals(description, metricInfo.description)
        && Objects.equals(filter, metricInfo.filter);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !(obj.getClass().equals(MetricInfo.class))) {
      return false;
    }
    return baseEquals((MetricInfo) obj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, filter);
  }

  /** Returns a builder for this {@code MetricInfo} object. */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  /**
   * Returns a builder for {@code MetricInfo} objects given the name of the metric and its filter.
   */
  public static Builder newBuilder(String name, String filter) {
    return new BuilderImpl(name, filter);
  }

  /** Creates a {@code MetricInfo} object given the name of the metric and its filter. */
  public static MetricInfo of(String name, String filter) {
    return new BuilderImpl(name, filter).build();
  }

  LogMetric toPb() {
    LogMetric.Builder builder = LogMetric.newBuilder().setName(name).setFilter(filter);
    if (description != null) {
      builder.setDescription(description);
    }
    return builder.build();
  }

  static MetricInfo fromPb(LogMetric metricPb) {
    Builder builder = newBuilder(metricPb.getName(), metricPb.getFilter());
    if (!metricPb.getDescription().equals("")) {
      builder.setDescription(metricPb.getDescription());
    }
    return builder.build();
  }
}
