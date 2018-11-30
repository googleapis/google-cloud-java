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

import com.google.api.core.ApiFuture;
import com.google.api.gax.paging.AsyncPage;
import com.google.api.gax.paging.Page;
import com.google.cloud.MonitoredResource;
import com.google.cloud.MonitoredResourceDescriptor;
import com.google.cloud.Service;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public interface Logging extends AutoCloseable, Service<LoggingOptions> {

  /**
   * Class for specifying options for listing sinks, monitored resources and monitored resource
   * descriptors.
   */
  final class ListOption extends Option {

    private static final long serialVersionUID = -6857294816115909271L;

    enum OptionType implements Option.OptionType {
      PAGE_SIZE,
      PAGE_TOKEN;

      @SuppressWarnings("unchecked")
      <T> T get(Map<Option.OptionType, ?> options) {
        return (T) options.get(this);
      }
    }

    private ListOption(OptionType option, Object value) {
      super(option, value);
    }

    /** Returns an option to specify the maximum number of resources returned per page. */
    public static ListOption pageSize(int pageSize) {
      return new ListOption(OptionType.PAGE_SIZE, pageSize);
    }

    /** Returns an option to specify the page token from which to start listing resources. */
    public static ListOption pageToken(String pageToken) {
      return new ListOption(OptionType.PAGE_TOKEN, pageToken);
    }
  }

  /** Class for specifying options for writing log entries. */
  final class WriteOption extends Option {

    private static final long serialVersionUID = 715900132268584612L;

    enum OptionType implements Option.OptionType {
      LOG_NAME,
      RESOURCE,
      LABELS;

      @SuppressWarnings("unchecked")
      <T> T get(Map<Option.OptionType, ?> options) {
        return (T) options.get(this);
      }
    }

    private WriteOption(OptionType option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a default log name (see {@link LogEntry#getLogName()}) for those
     * log entries that do not specify their own log name. Example: {@code syslog}.
     */
    public static WriteOption logName(String logName) {
      return new WriteOption(OptionType.LOG_NAME, logName);
    }

    /**
     * Returns an option to specify a default monitored resource (see {@link
     * LogEntry#getResource()}) for those log entries that do not specify their own resource.
     */
    public static WriteOption resource(MonitoredResource resource) {
      return new WriteOption(OptionType.RESOURCE, resource);
    }

    /**
     * Sets an option to specify (key, value) pairs that are added to the {@link
     * LogEntry#getLabels()} of each log entry written, except when a log entry already has a value
     * associated to the same key.
     */
    public static WriteOption labels(Map<String, String> labels) {
      return new WriteOption(OptionType.LABELS, ImmutableMap.copyOf(labels));
    }
  }

  /** Fields according to which log entries can be sorted. */
  enum SortingField {
    TIMESTAMP;

    String selector() {
      return name().toLowerCase();
    }
  }

  /** Sorting orders available when listing log entries. */
  enum SortingOrder {
    DESCENDING("desc"),
    ASCENDING("asc");

    private final String selector;

    SortingOrder(String selector) {
      this.selector = selector;
    }

    String selector() {
      return selector;
    }
  }

  /** Class for specifying options for listing log entries. */
  final class EntryListOption extends Option {

    private static final long serialVersionUID = -1561159676386917050L;

    enum OptionType implements Option.OptionType {
      ORDER_BY,
      FILTER;

      @SuppressWarnings("unchecked")
      <T> T get(Map<Option.OptionType, ?> options) {
        return (T) options.get(this);
      }
    }

    private EntryListOption(Option.OptionType option, Object value) {
      super(option, value);
    }

    /** Returns an option to specify the maximum number of log entries returned per page. */
    public static EntryListOption pageSize(int pageSize) {
      return new EntryListOption(ListOption.OptionType.PAGE_SIZE, pageSize);
    }

    /** Returns an option to specify the page token from which to start listing log entries. */
    public static EntryListOption pageToken(String pageToken) {
      return new EntryListOption(ListOption.OptionType.PAGE_TOKEN, pageToken);
    }

    /**
     * Returns an option to sort log entries. If not specified, log entries are sorted in ascending
     * (most-recent last) order with respect to the {@link LogEntry#getTimestamp()} value.
     */
    public static EntryListOption sortOrder(SortingField field, SortingOrder order) {
      return new EntryListOption(OptionType.ORDER_BY, field.selector() + ' ' + order.selector());
    }

    /**
     * Returns an option to specify a filter to the log entries to be listed.
     *
     * @see <a href="https://cloud.google.com/logging/docs/view/advanced_filters">Advanced Logs
     *     Filters</a>
     */
    public static EntryListOption filter(String filter) {
      return new EntryListOption(OptionType.FILTER, filter);
    }
  }

  /* Sets synchronicity {@link Synchronicity} of logging writes, defaults to asynchronous. */
  void setWriteSynchronicity(Synchronicity synchronicity);

  /* Retrieves current set synchronicity {@link Synchronicity} of logging writes. */
  Synchronicity getWriteSynchronicity();

  /**
   * Sets flush severity for asynchronous logging writes. Default is ERROR. Logs will be immediately
   * written out for entries at or higher than flush severity.
   */
  void setFlushSeverity(Severity flushSeverity);

  /* Retrieves flush severity for asynchronous logging writes. */
  Severity getFlushSeverity();

  /**
   * Creates a new sink.
   *
   * <p>Example of creating a sink to export logs to a BigQuery dataset (in the {@link
   * LoggingOptions#getProjectId()} project).
   *
   * <pre>{@code
   * String sinkName = "my_sink_name";
   * String datasetName = "my_dataset";
   * SinkInfo sinkInfo = SinkInfo.of(sinkName, DatasetDestination.of(datasetName));
   * Sink sink = logging.create(sinkInfo);
   * }</pre>
   *
   * @return the created sink
   * @throws LoggingException upon failure
   */
  Sink create(SinkInfo sink);

  /**
   * Sends a request for creating a sink. This method returns a {@code ApiFuture} object to consume
   * the result. {@link ApiFuture#get()} returns the created sink.
   *
   * <p>Example of asynchronously creating a sink to export logs to a BigQuery dataset (in the
   * {@link LoggingOptions#getProjectId()} project).
   *
   * <pre>{@code
   * String sinkName = "my_sink_name";
   * String datasetName = "my_dataset";
   * SinkInfo sinkInfo = SinkInfo.of(sinkName, DatasetDestination.of(datasetName));
   * ApiFuture<Sink> future = logging.createAsync(sinkInfo);
   * // ...
   * Sink sink = future.get();
   * }</pre>
   */
  ApiFuture<Sink> createAsync(SinkInfo sink);

  /**
   * Updates a sink or creates one if it does not exist.
   *
   * <p>Example of updating a sink.
   *
   * <pre>{@code
   * String sinkName = "my_sink_name";
   * String datasetName = "my_dataset";
   * SinkInfo sinkInfo = SinkInfo.newBuilder(sinkName, DatasetDestination.of(datasetName))
   *     .setVersionFormat(SinkInfo.VersionFormat.V2)
   *     .setFilter("severity>=ERROR")
   *     .build();
   * Sink sink = logging.update(sinkInfo);
   * }</pre>
   *
   * @return the created sink
   * @throws LoggingException upon failure
   */
  Sink update(SinkInfo sink);

  /**
   * Sends a request for updating a sink (or creating it, if it does not exist). This method returns
   * a {@code ApiFuture} object to consume the result. {@link ApiFuture#get()} returns the
   * updated/created sink or {@code null} if not found.
   *
   * <p>Example of asynchronously updating a sink.
   *
   * <pre>{@code
   * String sinkName = "my_sink_name";
   * String datasetName = "my_dataset";
   * SinkInfo sinkInfo = SinkInfo.newBuilder(sinkName, DatasetDestination.of(datasetName))
   *     .setVersionFormat(SinkInfo.VersionFormat.V2)
   *     .setFilter("severity>=ERROR")
   *     .build();
   * ApiFuture<Sink> future = logging.updateAsync(sinkInfo);
   * // ...
   * Sink sink = future.get();
   * }</pre>
   */
  ApiFuture<Sink> updateAsync(SinkInfo sink);

  /**
   * Returns the requested sink or {@code null} if not found.
   *
   * <p>Example of getting a sink.
   *
   * <pre>{@code
   * String sinkName = "my_sink_name";
   * Sink sink = logging.getSink(sinkName);
   * if (sink == null) {
   *   // sink was not found
   * }
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  Sink getSink(String sink);

  /**
   * Sends a request for getting a sink. This method returns a {@code ApiFuture} object to consume
   * the result. {@link ApiFuture#get()} returns the requested sink or {@code null} if not found.
   *
   * <p>Example of asynchronously getting a sink.
   *
   * <pre>{@code
   * String sinkName = "my_sink_name";
   * ApiFuture<Sink> future = logging.getSinkAsync(sinkName);
   * // ...
   * Sink sink = future.get();
   * if (sink == null) {
   *   // sink was not found
   * }
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  ApiFuture<Sink> getSinkAsync(String sink);

  /**
   * Lists the sinks. This method returns a {@link Page} object that can be used to consume
   * paginated results. Use {@link ListOption} to specify the page size or the page token from which
   * to start listing sinks.
   *
   * <p>Example of listing sinks, specifying the page size.
   *
   * <pre>{@code
   * Page<Sink> sinks = logging.listSinks(ListOption.pageSize(100));
   * Iterator<Sink> sinkIterator = sinks.iterateAll();
   * while (sinkIterator.hasNext()) {
   *   Sink sink = sinkIterator.next();
   *   // do something with the sink
   * }
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  Page<Sink> listSinks(ListOption... options);

  /**
   * Sends a request for listing sinks. This method returns a {@code ApiFuture} object to consume
   * the result. {@link ApiFuture#get()} returns an {@link AsyncPage} object that can be used to
   * asynchronously handle paginated results. Use {@link ListOption} to specify the page size or the
   * page token from which to start listing sinks.
   *
   * <p>Example of asynchronously listing sinks, specifying the page size.
   *
   * <pre>{@code
   * ApiFuture<AsyncPage<Sink>> future = logging.listSinksAsync(ListOption.pageSize(100));
   * // ...
   * AsyncPage<Sink> sinks = future.get();
   * Iterator<Sink> sinkIterator = sinks.iterateAll();
   * while (sinkIterator.hasNext()) {
   *   Sink sink = sinkIterator.next();
   *   // do something with the sink
   * }
   * }</pre>
   */
  ApiFuture<AsyncPage<Sink>> listSinksAsync(ListOption... options);

  /**
   * Deletes the requested sink.
   *
   * <p>Example of deleting a sink.
   *
   * <pre>{@code
   * String sinkName = "my_sink_name";
   * boolean deleted = logging.deleteSink(sinkName);
   * if (deleted) {
   *   // the sink was deleted
   * } else {
   *   // the sink was not found
   * }
   * }</pre>
   *
   * @return {@code true} if the sink was deleted, {@code false} if it was not found
   */
  boolean deleteSink(String sink);

  /**
   * Sends a request for deleting a sink. This method returns a {@code ApiFuture} object to consume
   * the result. {@link ApiFuture#get()} returns {@code true} if the sink was deleted, {@code false}
   * if it was not found.
   *
   * <p>Example of asynchronously deleting a sink.
   *
   * <pre>{@code
   * String sinkName = "my_sink_name";
   * ApiFuture<Boolean> future = logging.deleteSinkAsync(sinkName);
   * // ...
   * boolean deleted = future.get();
   * if (deleted) {
   *   // the sink was deleted
   * } else {
   *   // the sink was not found
   * }
   * }</pre>
   */
  ApiFuture<Boolean> deleteSinkAsync(String sink);

  /**
   * Deletes a log and all its log entries. The log will reappear if new entries are written to it.
   *
   * <p>Example of deleting a log.
   *
   * <pre>{@code
   * String logName = "my_log_name";
   * boolean deleted = logging.deleteLog(logName);
   * if (deleted) {
   *   // the log was deleted
   * } else {
   *   // the log was not found
   * }
   * }</pre>
   *
   * @return {@code true} if the log was deleted, {@code false} if it was not found
   */
  boolean deleteLog(String log);

  /**
   * Sends a request for deleting a log and all its log entries. This method returns a {@code
   * ApiFuture} object to consume the result. {@link ApiFuture#get()} returns {@code true} if the
   * log was deleted, {@code false} if it was not found.
   *
   * <p>Example of asynchronously deleting a log.
   *
   * <pre>{@code
   * String logName = "my_log_name";
   * ApiFuture<Boolean> future = logging.deleteLogAsync(logName);
   * // ...
   * boolean deleted = future.get();
   * if (deleted) {
   *   // the log was deleted
   * } else {
   *   // the log was not found
   * }
   * }</pre>
   */
  ApiFuture<Boolean> deleteLogAsync(String log);

  /**
   * Lists the monitored resource descriptors used by Stackdriver Logging. This method returns a
   * {@link Page} object that can be used to consume paginated results. Use {@link ListOption} to
   * specify the page size or the page token from which to start listing resource descriptors.
   *
   * <p>Example of listing monitored resource descriptors, specifying the page size.
   *
   * <pre>{@code
   * Page<MonitoredResourceDescriptor> descriptors =
   *     logging.listMonitoredResourceDescriptors(ListOption.pageSize(100));
   * Iterator<MonitoredResourceDescriptor> descriptorIterator = descriptors.iterateAll();
   * while (descriptorIterator.hasNext()) {
   *   MonitoredResourceDescriptor descriptor = descriptorIterator.next();
   *   // do something with the descriptor
   * }
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  Page<MonitoredResourceDescriptor> listMonitoredResourceDescriptors(ListOption... options);

  /**
   * Sends a request for listing monitored resource descriptors used by Stackdriver Logging. This
   * method returns a {@code ApiFuture} object to consume the result. {@link ApiFuture#get()}
   * returns an {@link AsyncPage} object that can be used to asynchronously handle paginated
   * results. Use {@link ListOption} to specify the page size or the page token from which to start
   * listing resource descriptors.
   *
   * <p>Example of asynchronously listing monitored resource descriptors, specifying the page size.
   *
   * <pre>{@code
   * ApiFuture<AsyncPage<MonitoredResourceDescriptor>> future =
   *     logging.listMonitoredResourceDescriptorsAsync(ListOption.pageSize(100));
   * // ...
   * AsyncPage<MonitoredResourceDescriptor> descriptors = future.get();
   * Iterator<MonitoredResourceDescriptor> descriptorIterator = descriptors.iterateAll();
   * while (descriptorIterator.hasNext()) {
   *   MonitoredResourceDescriptor descriptor = descriptorIterator.next();
   *   // do something with the descriptor
   * }
   * }</pre>
   */
  ApiFuture<AsyncPage<MonitoredResourceDescriptor>> listMonitoredResourceDescriptorsAsync(
      ListOption... options);

  /**
   * Creates a new metric.
   *
   * <p>Example of creating a metric for logs with severity higher or equal to ERROR.
   *
   * <pre>{@code
   * String metricName = "my_metric_name";
   * MetricInfo metricInfo = MetricInfo.of(metricName, "severity>=ERROR");
   * Metric metric = logging.create(metricInfo);
   * }</pre>
   *
   * @return the created metric
   * @throws LoggingException upon failure
   */
  Metric create(MetricInfo metric);

  /**
   * Sends a request for creating a metric. This method returns a {@code ApiFuture} object to
   * consume the result. {@link ApiFuture#get()} returns the created metric.
   *
   * <p>Example of asynchronously creating a metric for logs with severity higher or equal to ERROR.
   *
   * <pre>{@code
   * String metricName = "my_metric_name";
   * MetricInfo metricInfo = MetricInfo.of(metricName, "severity>=ERROR");
   * ApiFuture<Metric> future = logging.createAsync(metricInfo);
   * // ...
   * Metric metric = future.get();
   * }</pre>
   */
  ApiFuture<Metric> createAsync(MetricInfo metric);

  /**
   * Updates a metric or creates one if it does not exist.
   *
   * <p>Example of updating a metric.
   *
   * <pre>{@code
   * String metricName = "my_metric_name";
   * MetricInfo metricInfo = MetricInfo.newBuilder(metricName, "severity>=ERROR")
   *     .setDescription("new description")
   *     .build();
   * Metric metric = logging.update(metricInfo);
   * }</pre>
   *
   * @return the created metric
   * @throws LoggingException upon failure
   */
  Metric update(MetricInfo metric);

  /**
   * Sends a request for updating a metric (or creating it, if it does not exist). This method
   * returns a {@code ApiFuture} object to consume the result. {@link ApiFuture#get()} returns the
   * updated/created metric or {@code null} if not found.
   *
   * <p>Example of asynchronously updating a metric.
   *
   * <pre>{@code
   * String metricName = "my_metric_name";
   * MetricInfo metricInfo = MetricInfo.newBuilder(metricName, "severity>=ERROR")
   *     .setDescription("new description")
   *     .build();
   * ApiFuture<Metric> future = logging.updateAsync(metricInfo);
   * // ...
   * Metric metric = future.get();
   * }</pre>
   */
  ApiFuture<Metric> updateAsync(MetricInfo metric);

  /**
   * Returns the requested metric or {@code null} if not found.
   *
   * <p>Example of getting a metric.
   *
   * <pre>{@code
   * String metricName = "my_metric_name";
   * Metric metric = logging.getMetric(metricName);
   * if (metric == null) {
   *   // metric was not found
   * }
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  Metric getMetric(String metric);

  /**
   * Sends a request for getting a metric. This method returns a {@code ApiFuture} object to consume
   * the result. {@link ApiFuture#get()} returns the requested metric or {@code null} if not found.
   *
   * <p>Example of asynchronously getting a metric.
   *
   * <pre>{@code
   * String metricName = "my_metric_name";
   * ApiFuture<Metric> future = logging.getMetricAsync(metricName);
   * // ...
   * Metric metric = future.get();
   * if (metric == null) {
   *   // metric was not found
   * }
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  ApiFuture<Metric> getMetricAsync(String metric);

  /**
   * Lists the metrics. This method returns a {@link Page} object that can be used to consume
   * paginated results. Use {@link ListOption} to specify the page size or the page token from which
   * to start listing metrics.
   *
   * <p>Example of listing metrics, specifying the page size.
   *
   * <pre>{@code
   * Page<Metric> metrics = logging.listMetrics(ListOption.pageSize(100));
   * Iterator<Metric> metricIterator = metrics.iterateAll();
   * while (metricIterator.hasNext()) {
   *   Metric metric = metricIterator.next();
   *   // do something with the metric
   * }
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  Page<Metric> listMetrics(ListOption... options);

  /**
   * Sends a request for listing metrics. This method returns a {@code ApiFuture} object to consume
   * the result. {@link ApiFuture#get()} returns an {@link AsyncPage} object that can be used to
   * asynchronously handle paginated results. Use {@link ListOption} to specify the page size or the
   * page token from which to start listing metrics.
   *
   * <p>Example of asynchronously listing metrics, specifying the page size.
   *
   * <pre>{@code
   * ApiFuture<AsyncPage<Metric>> future = logging.listMetricsAsync(ListOption.pageSize(100));
   * // ...
   * AsyncPage<Metric> metrics = future.get();
   * Iterator<Metric> metricIterator = metrics.iterateAll();
   * while (metricIterator.hasNext()) {
   *   Metric metric = metricIterator.next();
   *   // do something with the metric
   * }
   * }</pre>
   */
  ApiFuture<AsyncPage<Metric>> listMetricsAsync(ListOption... options);

  /**
   * Deletes the requested metric.
   *
   * <p>Example of deleting a metric.
   *
   * <pre>{@code
   * String metricName = "my_metric_name";
   * boolean deleted = logging.deleteMetric(metricName);
   * if (deleted) {
   *   // the metric was deleted
   * } else {
   *   // the metric was not found
   * }
   * }</pre>
   *
   * @return {@code true} if the metric was deleted, {@code false} if it was not found
   */
  boolean deleteMetric(String metric);

  /**
   * Sends a request for deleting a metric. This method returns a {@code ApiFuture} object to
   * consume the result. {@link ApiFuture#get()} returns {@code true} if the metric was deleted,
   * {@code false} if it was not found.
   *
   * <p>Example of asynchronously deleting a metric.
   *
   * <pre>{@code
   * String metricName = "my_metric_name";
   * ApiFuture<Boolean> future = logging.deleteMetricAsync(metricName);
   * // ...
   * boolean deleted = future.get();
   * if (deleted) {
   *   // the metric was deleted
   * } else {
   *   // the metric was not found
   * }
   * }</pre>
   */
  ApiFuture<Boolean> deleteMetricAsync(String metric);

  /**
   * Flushes any pending asynchronous logging writes. Logs are automatically flushed based on time
   * and message count that be configured via {@link com.google.api.gax.batching.BatchingSettings},
   * Logs are also flushed if at or above flush severity, see {@link #setFlushSeverity}. Logging
   * frameworks require support for an explicit flush. See usage in the java.util.logging
   * handler{@link LoggingHandler}.
   */
  void flush();

  /**
   * Sends a request to log entries to Stackdriver Logging. Use {@link WriteOption#logName(String)}
   * to provide a log name for those entries that do not specify one. Use {@link
   * WriteOption#resource(MonitoredResource)} to provide a monitored resource for those entries that
   * do not specify one. Use {@link WriteOption#labels(Map)} to provide some labels to be added to
   * every entry in {@code logEntries}.
   *
   * <p>Example of writing log entries and providing a default log name and monitored resource.
   *
   * <pre>{@code
   * String logName = "my_log_name";
   * List<LogEntry> entries = new ArrayList<>();
   * entries.add(LogEntry.of(StringPayload.of("Entry payload")));
   * Map<String, Object> jsonMap = new HashMap<>();
   * jsonMap.put("key", "value");
   * entries.add(LogEntry.of(JsonPayload.of(jsonMap)));
   * logging.write(
   *     entries,
   *     WriteOption.logName(logName),
   *     WriteOption.resource(MonitoredResource.newBuilder("global").build()));
   * }</pre>
   */
  void write(Iterable<LogEntry> logEntries, WriteOption... options);

  /**
   * Lists log entries. This method returns a {@link Page} object that can be used to consume
   * paginated results. Use {@link EntryListOption#pageSize(int)} to specify the page size. Use
   * {@link EntryListOption#pageToken(String)} to specify the page token from which to start listing
   * entries. Use {@link EntryListOption#sortOrder(SortingField, SortingOrder)} to sort log entries
   * according to your preferred order (default is most-recent last). Use {@link
   * EntryListOption#filter(String)} to filter listed log entries.
   *
   * <p>Example of listing log entries for a specific log.
   *
   * <pre>{@code
   * String filter = "logName=projects/my_project_id/logs/my_log_name";
   * Page<LogEntry> entries = logging.listLogEntries(EntryListOption.filter(filter));
   * Iterator<LogEntry> entryIterator = entries.iterateAll();
   * while (entryIterator.hasNext()) {
   *   LogEntry entry = entryIterator.next();
   *   // do something with the entry
   * }
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  Page<LogEntry> listLogEntries(EntryListOption... options);

  /**
   * Sends a request for listing log entries. This method returns a {@code ApiFuture} object to
   * consume the result. {@link ApiFuture#get()} returns an {@link AsyncPage} object that can be
   * used to asynchronously handle paginated results. Use {@link EntryListOption#pageSize(int)} to
   * specify the page size. Use {@link EntryListOption#pageToken(String)} to specify the page token
   * from which to start listing entries. Use {@link EntryListOption#sortOrder(SortingField,
   * SortingOrder)} to sort log entries according to your preferred order (default is most-recent
   * last). Use {@link EntryListOption#filter(String)} to filter listed log entries.
   *
   * <p>Example of asynchronously listing log entries for a specific log.
   *
   * <pre>{@code
   * String filter = "logName=projects/my_project_id/logs/my_log_name";
   * ApiFuture<AsyncPage<LogEntry>> future =
   *     logging.listLogEntriesAsync(EntryListOption.filter(filter));
   * // ...
   * AsyncPage<LogEntry> entries = future.get();
   * Iterator<LogEntry> entryIterator = entries.iterateAll();
   * while (entryIterator.hasNext()) {
   *   LogEntry entry = entryIterator.next();
   *   // do something with the entry
   * }
   * }</pre>
   *
   * @throws LoggingException upon failure
   */
  ApiFuture<AsyncPage<LogEntry>> listLogEntriesAsync(EntryListOption... options);
}
