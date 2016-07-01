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

import com.google.cloud.AsyncPage;
import com.google.cloud.Page;
import com.google.cloud.Service;

import java.util.Map;
import java.util.concurrent.Future;

public interface Logging extends AutoCloseable, Service<LoggingOptions> {

  /**
   * Class for specifying options for listing sinks, monitored resources and monitored resource
   * descriptors.
   */
  final class ListOption extends Option {

    private static final long serialVersionUID = -6857294816115909271L;

    enum OptionType implements Option.OptionType {
      PAGE_SIZE, PAGE_TOKEN;

      @SuppressWarnings("unchecked")
      <T> T get(Map<Option.OptionType, ?> options) {
        return (T) options.get(this);
      }
    }

    private ListOption(OptionType option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the maximum number of resources returned per page.
     */
    public static ListOption pageSize(int pageSize) {
      return new ListOption(OptionType.PAGE_SIZE, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing resources.
     */
    public static ListOption pageToken(String pageToken) {
      return new ListOption(OptionType.PAGE_TOKEN, pageToken);
    }
  }

  /**
   * Creates a new sink.
   *
   * @return the created sink
   * @throws LoggingException upon failure
   */
  Sink create(SinkInfo sink);

  /**
   * Sends a request for creating a sink. This method returns a {@code Future} object to consume the
   * result. {@link Future#get()} returns the created sink.
   */
  Future<Sink> createAsync(SinkInfo sink);

  /**
   * Updates a sink or creates one if it does not exist.
   *
   * @return the created sink
   * @throws LoggingException upon failure
   */
  Sink update(SinkInfo sink);

  /**
   * Sends a request for updating a sink (or creating it, if it does not exist). This method returns
   * a {@code Future} object to consume the result. {@link Future#get()} returns the
   * updated/created sink or {@code null} if not found.
   */
  Future<Sink> updateAsync(SinkInfo sink);

  /**
   * Returns the requested sink or {@code null} if not found.
   *
   * @throws LoggingException upon failure
   */
  Sink getSink(String sink);

  /**
   * Sends a request for getting a sink. This method returns a {@code Future} object to consume the
   * result. {@link Future#get()} returns the requested sink or {@code null} if not found.
   *
   * @throws LoggingException upon failure
   */
  Future<Sink> getSinkAsync(String sink);

  /**
   * Lists the sinks. This method returns a {@link Page} object that can be used to consume
   * paginated results. Use {@link ListOption} to specify the page size or the page token from which
   * to start listing sinks.
   *
   * @throws LoggingException upon failure
   */
  Page<Sink> listSinks(ListOption... options);

  /**
   * Sends a request for listing sinks. This method returns a {@code Future} object to consume
   * the result. {@link Future#get()} returns an {@link AsyncPage} object that can be used to
   * asynchronously handle paginated results. Use {@link ListOption} to specify the page size or the
   * page token from which to start listing sinks.
   */
  Future<AsyncPage<Sink>> listSinksAsync(ListOption... options);

  /**
   * Deletes the requested sink.
   *
   * @return {@code true} if the sink was deleted, {@code false} if it was not found
   */
  boolean deleteSink(String sink);

  /**
   * Sends a request for deleting a sink. This method returns a {@code Future} object to consume the
   * result. {@link Future#get()} returns {@code true} if the sink was deleted, {@code false} if it
   * was not found.
   */
  Future<Boolean> deleteSinkAsync(String sink);

  /**
   * Creates a new metric.
   *
   * @return the created metric
   * @throws LoggingException upon failure
   */
  Metric create(MetricInfo metric);

  /**
   * Sends a request for creating a metric. This method returns a {@code Future} object to consume
   * the result. {@link Future#get()} returns the created metric.
   */
  Future<Metric> createAsync(MetricInfo metric);

  /**
   * Updates a metric or creates one if it does not exist.
   *
   * @return the created metric
   * @throws LoggingException upon failure
   */
  Metric update(MetricInfo metric);

  /**
   * Sends a request for updating a metric (or creating it, if it does not exist). This method
   * returns a {@code Future} object to consume the result. {@link Future#get()} returns the
   * updated/created metric or {@code null} if not found.
   */
  Future<Metric> updateAsync(MetricInfo metric);

  /**
   * Returns the requested metric or {@code null} if not found.
   *
   * @throws LoggingException upon failure
   */
  Metric getMetric(String metric);

  /**
   * Sends a request for getting a metric. This method returns a {@code Future} object to consume
   * the result. {@link Future#get()} returns the requested metric or {@code null} if not found.
   *
   * @throws LoggingException upon failure
   */
  Future<Metric> getMetricAsync(String metric);

  /**
   * Lists the metrics. This method returns a {@link Page} object that can be used to consume
   * paginated results. Use {@link ListOption} to specify the page size or the page token from which
   * to start listing metrics.
   *
   * @throws LoggingException upon failure
   */
  Page<Metric> listMetrics(ListOption... options);

  /**
   * Sends a request for listing metrics. This method returns a {@code Future} object to consume
   * the result. {@link Future#get()} returns an {@link AsyncPage} object that can be used to
   * asynchronously handle paginated results. Use {@link ListOption} to specify the page size or the
   * page token from which to start listing metrics.
   */
  Future<AsyncPage<Metric>> listMetricsAsync(ListOption... options);

  /**
   * Deletes the requested metric.
   *
   * @return {@code true} if the metric was deleted, {@code false} if it was not found
   */
  boolean deleteMetric(String metric);

  /**
   * Sends a request for deleting a metric. This method returns a {@code Future} object to consume
   * the result. {@link Future#get()} returns {@code true} if the metric was deleted, {@code false}
   * if it was not found.
   */
  Future<Boolean> deleteMetricAsync(String metric);
}
