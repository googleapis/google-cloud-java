/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import com.google.api.core.ApiFuture;
import com.google.common.base.Function;
import com.google.logging.v2.LogMetric;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

/**
 * Stackdriver Logging metrics describe logs-based metric. The value of the metric is the number of
 * log entries that match a logs filter (see {@link #getFilter()}).
 *
 * <p>{@code Metric} adds a layer of service-related functionality over {@link MetricInfo}. Objects
 * of this class are immutable. To get a {@code Metric} object with the most recent information use
 * {@link #reload} or {@link #reloadAsync}.
 *
 * @see <a href="https://cloud.google.com/logging/docs/view/logs_based_metrics">Logs-based Metrics
 *     </a>
 */
public class Metric extends MetricInfo {

  private static final long serialVersionUID = -1549310461066853001L;

  private final LoggingOptions options;
  private transient Logging logging;

  /**
   * A builder for {@code Metric} objects.
   */
  public static final class Builder extends MetricInfo.Builder {

    private final Logging logging;
    private final BuilderImpl delegate;

    private Builder(Metric metric) {
      logging = metric.logging;
      delegate = new BuilderImpl(metric);
    }


    @Override
    public Builder setName(String name) {
      delegate.setName(name);
      return this;
    }


    @Override
    public Builder setDescription(String description) {
      delegate.setDescription(description);
      return this;
    }


    @Override
    public Builder setFilter(String filter) {
      delegate.setFilter(filter);
      return this;
    }

    @Override
    public Metric build() {
      return new Metric(this.logging, this.delegate);
    }
  }

  Metric(Logging logging, BuilderImpl builder) {
    super(builder);
    this.logging = checkNotNull(logging);
    options = logging.getOptions();
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(options, super.hashCode());
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Metric.class)) {
      return false;
    }
    Metric other = (Metric) obj;
    return baseEquals(other) && Objects.equals(options, other.options);
  }


  /**
   * Returns the metrics's {@code Logging} object used to issue requests.
   */
  public Logging getLogging() {
    return logging;
  }

  /**
   * Deletes this metric.
   *
   * <p>Example of deleting the metric.
   * <pre> {@code
   * boolean deleted = metric.delete();
   * if (deleted) {
   *   // the metric was deleted
   * } else {
   *   // the metric was not found
   * }
   * }</pre>
   *
   * @return {@code true} if the metric was deleted, {@code false} if it was not found
   * @throws LoggingException upon failure
   */
  public boolean delete() {
    return logging.deleteMetric(getName());
  }

  /**
   * Sends a request for deleting this metric. This method returns a {@code ApiFuture} object to
   * consume the result. {@link ApiFuture#get()} returns {@code true} if the metric was deleted,
   * {@code false} if it was not found.
   *
   * <p>Example of asynchronously deleting the metric.
   * <pre> {@code
   * ApiFuture<Boolean> future = metric.deleteAsync();
   * // ...
   * boolean deleted = future.get();
   * if (deleted) {
   *   // the metric was deleted
   * } else {
   *   // the metric was not found
   * }
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  public ApiFuture<Boolean> deleteAsync() {
    return logging.deleteMetricAsync(getName());
  }

  /**
   * Fetches current metric's latest information. Returns {@code null} if the metric does not exist.
   *
   * <p>Example of getting the metric's latest information.
   * <pre> {@code
   * Metric latestMetric = metric.reload();
   * if (latestMetric == null) {
   *   // the metric was not found
   * }
   * }</pre>
   *
   * @return a {@code Metric} object with latest information or {@code null} if not found
   * @throws LoggingException upon failure
   */
  public Metric reload() {
    return logging.getMetric(getName());
  }

  /**
   * Sends a request to fetch current metric's latest information. This method returns a
   * {@code ApiFuture} object to consume the result. {@link ApiFuture#get()} returns a {@code Metric}
   * object with latest information or {@code null} if not found.
   *
   * <p>Example of asynchronously getting the metric's latest information.
   * <pre> {@code
   * ApiFuture<Metric> future = metric.reloadAsync();
   * // ...
   * Metric latestMetric = future.get();
   * if (latestMetric == null) {
   *   // the metric was not found
   * }
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  public ApiFuture<Metric> reloadAsync() {
    return logging.getMetricAsync(getName());
  }

  /**
   * Updates current metric. If the metric does not exist, it is created.
   *
   * <p>Example of updating the metric's information.
   * <pre> {@code
   * Metric updatedMetric = metric.toBuilder()
   *     .setDescription("A more detailed description")
   *     .build()
   *     .update();
   * }</pre>
   *
   * @return a {@code Metric} object with updated information
   * @throws LoggingException upon failure
   */
  public Metric update() {
    return logging.update(this);
  }

  /**
   * Sends a request to update current metric. If the metric does not exist, it is created. This
   * method returns a {@code ApiFuture} object to consume the result. {@link ApiFuture#get()} returns a
   * {@code Metric} object with updated information.
   *
   * <p>Example of asynchronously updating the metric's information.
   * <pre> {@code
   * ApiFuture<Metric> future = metric.toBuilder()
   *     .setDescription("A more detailed description")
   *     .build()
   *     .updateAsync();
   * // ...
   * Metric updatedMetric = future.get();
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  public ApiFuture<Metric> updateAsync() {
    return logging.updateAsync(this);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    this.logging = options.getService();
  }

  static Metric fromPb(Logging logging, LogMetric metricPb) {
    MetricInfo metricInfo = MetricInfo.fromPb(metricPb);
    return new Metric(logging, new BuilderImpl(metricInfo));
  }

  static Function<LogMetric, Metric> fromPbFunction(final Logging logging) {
    return new Function<LogMetric, Metric>() {
      @Override
      public Metric apply(LogMetric metricPb) {
        return metricPb != null ? fromPb(logging, metricPb) : null;
      }
    };
  }
}
