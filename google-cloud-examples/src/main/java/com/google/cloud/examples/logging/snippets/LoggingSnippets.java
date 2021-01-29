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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in Logging's javadoc. Any change to this file should be reflected in
 * Logging's javadoc.
 */

package com.google.cloud.examples.logging.snippets;

import com.google.api.gax.paging.AsyncPage;
import com.google.api.gax.paging.Page;
import com.google.cloud.MonitoredResource;
import com.google.cloud.MonitoredResourceDescriptor;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Logging.EntryListOption;
import com.google.cloud.logging.Logging.ListOption;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Metric;
import com.google.cloud.logging.MetricInfo;
import com.google.cloud.logging.Payload.JsonPayload;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.cloud.logging.Sink;
import com.google.cloud.logging.SinkInfo;
import com.google.cloud.logging.SinkInfo.Destination.DatasetDestination;
import com.google.cloud.logging.Synchronicity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class LoggingSnippets {

  private final Logging logging;

  public LoggingSnippets(Logging logging) {
    this.logging = logging;
  }

  /**
   * Example of creating a sink to export logs to a BigQuery dataset (in the {@link
   * LoggingOptions#getProjectId()} project).
   */
  // [TARGET create(SinkInfo)]
  // [VARIABLE "my_sink_name"]
  // [VARIABLE "my_dataset"]
  public Sink createSink(String sinkName, String datasetName) {
    // [START logging_create_sink]
    SinkInfo sinkInfo = SinkInfo.of(sinkName, DatasetDestination.of(datasetName));
    Sink sink = logging.create(sinkInfo);
    // [END logging_create_sink]
    return sink;
  }

  /**
   * Example of asynchronously creating a sink to export logs to a BigQuery dataset (in the {@link
   * LoggingOptions#getProjectId()} project).
   */
  // [TARGET createAsync(SinkInfo)]
  // [VARIABLE "my_sink_name"]
  // [VARIABLE "my_dataset"]
  public Sink createSinkAsync(String sinkName, String datasetName)
      throws ExecutionException, InterruptedException {
    // [START createSinkAsync]
    SinkInfo sinkInfo = SinkInfo.of(sinkName, DatasetDestination.of(datasetName));
    Future<Sink> future = logging.createAsync(sinkInfo);
    // ...
    Sink sink = future.get();
    // [END createSinkAsync]
    return sink;
  }

  /** Example of updating a sink. */
  // [TARGET update(SinkInfo)]
  // [VARIABLE "my_sink_name"]
  // [VARIABLE "my_dataset"]
  public Sink updateSink(String sinkName, String datasetName) {
    // [START logging_update_sink]
    SinkInfo sinkInfo =
        SinkInfo.newBuilder(sinkName, DatasetDestination.of(datasetName))
            .setVersionFormat(SinkInfo.VersionFormat.V2)
            .setFilter("severity>=ERROR")
            .build();
    Sink sink = logging.update(sinkInfo);
    // [END logging_update_sink]
    return sink;
  }

  /** Example of asynchronously updating a sink. */
  // [TARGET updateAsync(SinkInfo)]
  // [VARIABLE "my_sink_name"]
  // [VARIABLE "my_dataset"]
  public Sink updateSinkAsync(String sinkName, String datasetName)
      throws ExecutionException, InterruptedException {
    // [START updateSinkAsync]
    SinkInfo sinkInfo =
        SinkInfo.newBuilder(sinkName, DatasetDestination.of(datasetName))
            .setVersionFormat(SinkInfo.VersionFormat.V2)
            .setFilter("severity>=ERROR")
            .build();
    Future<Sink> future = logging.updateAsync(sinkInfo);
    // ...
    Sink sink = future.get();
    // [END updateSinkAsync]
    return sink;
  }

  /** Example of getting a sink. */
  // [TARGET getSink(String)]
  // [VARIABLE "my_sink_name"]
  public Sink getSink(String sinkName) {
    // [START getSink]
    Sink sink = logging.getSink(sinkName);
    if (sink == null) {
      // sink was not found
    }
    // [END getSink]
    return sink;
  }

  /** Example of asynchronously getting a sink. */
  // [TARGET getSinkAsync(String)]
  // [VARIABLE "my_sink_name"]
  public Sink getSinkAsync(String sinkName) throws ExecutionException, InterruptedException {
    // [START getSinkAsync]
    Future<Sink> future = logging.getSinkAsync(sinkName);
    // ...
    Sink sink = future.get();
    if (sink == null) {
      // sink was not found
    }
    // [END getSinkAsync]
    return sink;
  }

  /** Example of listing sinks, specifying the page size. */
  // [TARGET listSinks(ListOption...)]
  public Page<Sink> listSinks() {
    // [START logging_list_sinks]
    Page<Sink> sinks = logging.listSinks(ListOption.pageSize(100));
    for (Sink sink : sinks.iterateAll()) {
      // do something with the sink
    }
    // [END logging_list_sinks]
    return sinks;
  }

  /** Example of asynchronously listing sinks, specifying the page size. */
  // [TARGET listSinksAsync(ListOption...)]
  public Page<Sink> listSinksAsync() throws ExecutionException, InterruptedException {
    // [START listSinksAsync]
    Future<AsyncPage<Sink>> future = logging.listSinksAsync(ListOption.pageSize(100));
    // ...
    AsyncPage<Sink> sinks = future.get();
    for (Sink sink : sinks.iterateAll()) {
      // do something with the sink
    }
    // [END listSinksAsync]
    return sinks;
  }

  /** Example of deleting a sink. */
  // [TARGET deleteSink(String)]
  // [VARIABLE "my_sink_name"]
  public boolean deleteSink(String sinkName) {
    // [START logging_delete_sink]
    boolean deleted = logging.deleteSink(sinkName);
    if (deleted) {
      // the sink was deleted
    } else {
      // the sink was not found
    }
    // [END logging_delete_sink]
    return deleted;
  }

  /** Example of asynchronously deleting a sink. */
  // [TARGET deleteSinkAsync(String)]
  // [VARIABLE "my_sink_name"]
  public boolean deleteSinkAsync(String sinkName) throws ExecutionException, InterruptedException {
    // [START deleteSinkAsync]
    Future<Boolean> future = logging.deleteSinkAsync(sinkName);
    // ...
    boolean deleted = future.get();
    if (deleted) {
      // the sink was deleted
    } else {
      // the sink was not found
    }
    // [END deleteSinkAsync]
    return deleted;
  }

  /** Example of deleting a log. */
  // [TARGET deleteLog(String)]
  // [VARIABLE "my_log_name"]
  public boolean deleteLog(String logName) {
    // [START logging_delete_log]
    boolean deleted = logging.deleteLog(logName);
    if (deleted) {
      // the log was deleted
    } else {
      // the log was not found
    }
    // [END logging_delete_log]
    return deleted;
  }

  /** Example of asynchronously deleting a log. */
  // [TARGET deleteLogAsync(String)]
  // [VARIABLE "my_log_name"]
  public boolean deleteLogAsync(String logName) throws ExecutionException, InterruptedException {
    // [START deleteLogAsync]
    Future<Boolean> future = logging.deleteLogAsync(logName);
    // ...
    boolean deleted = future.get();
    if (deleted) {
      // the log was deleted
    } else {
      // the log was not found
    }
    // [END deleteLogAsync]
    return deleted;
  }

  /** Example of listing monitored resource descriptors, specifying the page size. */
  // [TARGET listMonitoredResourceDescriptors(ListOption...)]
  public Page<MonitoredResourceDescriptor> listMonitoredResourceDescriptors() {
    // [START listMonitoredResourceDescriptors]
    Page<MonitoredResourceDescriptor> descriptors =
        logging.listMonitoredResourceDescriptors(ListOption.pageSize(100));
    for (MonitoredResourceDescriptor descriptor : descriptors.iterateAll()) {
      // do something with the descriptor
    }
    // [END listMonitoredResourceDescriptors]
    return descriptors;
  }

  /** Example of asynchronously listing monitored resource descriptors, specifying the page size. */
  // [TARGET listMonitoredResourceDescriptorsAsync(ListOption...)]
  public Page<MonitoredResourceDescriptor> listMonitoredResourceDescriptorsAsync()
      throws ExecutionException, InterruptedException {
    // [START listMonitoredResourceDescriptorsAsync]
    Future<AsyncPage<MonitoredResourceDescriptor>> future =
        logging.listMonitoredResourceDescriptorsAsync(ListOption.pageSize(100));
    // ...
    AsyncPage<MonitoredResourceDescriptor> descriptors = future.get();
    for (MonitoredResourceDescriptor descriptor : descriptors.iterateAll()) {
      // do something with the descriptor
    }
    // [END listMonitoredResourceDescriptorsAsync]
    return descriptors;
  }

  /** Example of creating a metric for logs with severity higher or equal to ERROR. */
  // [TARGET create(MetricInfo)]
  // [VARIABLE "my_metric_name"]
  public Metric createMetric(String metricName) {
    // [START createMetric]
    MetricInfo metricInfo = MetricInfo.of(metricName, "severity>=ERROR");
    Metric metric = logging.create(metricInfo);
    // [END createMetric]
    return metric;
  }

  /**
   * Example of asynchronously creating a metric for logs with severity higher or equal to ERROR.
   */
  // [TARGET createAsync(MetricInfo)]
  // [VARIABLE "my_metric_name"]
  public Metric createMetricAsync(String metricName)
      throws ExecutionException, InterruptedException {
    // [START createMetricAsync]
    MetricInfo metricInfo = MetricInfo.of(metricName, "severity>=ERROR");
    Future<Metric> future = logging.createAsync(metricInfo);
    // ...
    Metric metric = future.get();
    // [END createMetricAsync]
    return metric;
  }

  /** Example of updating a metric. */
  // [TARGET update(MetricInfo)]
  // [VARIABLE "my_metric_name"]
  public Metric updateMetric(String metricName) {
    // [START updateMetric]
    MetricInfo metricInfo =
        MetricInfo.newBuilder(metricName, "severity>=ERROR")
            .setDescription("new description")
            .build();
    Metric metric = logging.update(metricInfo);
    // [END updateMetric]
    return metric;
  }

  /** Example of asynchronously updating a metric. */
  // [TARGET updateAsync(MetricInfo)]
  // [VARIABLE "my_metric_name"]
  public Metric updateMetricAsync(String metricName)
      throws ExecutionException, InterruptedException {
    // [START updateMetricAsync]
    MetricInfo metricInfo =
        MetricInfo.newBuilder(metricName, "severity>=ERROR")
            .setDescription("new description")
            .build();
    Future<Metric> future = logging.updateAsync(metricInfo);
    // ...
    Metric metric = future.get();
    // [END updateMetricAsync]
    return metric;
  }

  /** Example of getting a metric. */
  // [TARGET getMetric(String)]
  // [VARIABLE "my_metric_name"]
  public Metric getMetric(String metricName) {
    // [START getMetric]
    Metric metric = logging.getMetric(metricName);
    if (metric == null) {
      // metric was not found
    }
    // [END getMetric]
    return metric;
  }

  /** Example of asynchronously getting a metric. */
  // [TARGET getMetricAsync(String)]
  // [VARIABLE "my_metric_name"]
  public Metric getMetricAsync(String metricName) throws ExecutionException, InterruptedException {
    // [START getMetricAsync]
    Future<Metric> future = logging.getMetricAsync(metricName);
    // ...
    Metric metric = future.get();
    if (metric == null) {
      // metric was not found
    }
    // [END getMetricAsync]
    return metric;
  }

  /** Example of listing metrics, specifying the page size. */
  // [TARGET listMetrics(ListOption...)]
  public Page<Metric> listMetrics() {
    // [START listMetrics]
    Page<Metric> metrics = logging.listMetrics(ListOption.pageSize(100));
    for (Metric metric : metrics.iterateAll()) {
      // do something with the metric
    }
    // [END listMetrics]
    return metrics;
  }

  /** Example of asynchronously listing metrics, specifying the page size. */
  // [TARGET listMetricsAsync(ListOption...)]
  public Page<Metric> listMetricsAsync() throws ExecutionException, InterruptedException {
    // [START listMetricsAsync]
    Future<AsyncPage<Metric>> future = logging.listMetricsAsync(ListOption.pageSize(100));
    // ...
    AsyncPage<Metric> metrics = future.get();
    for (Metric metric : metrics.iterateAll()) {
      // do something with the metric
    }
    // [END listMetricsAsync]
    return metrics;
  }

  /** Example of deleting a metric. */
  // [TARGET deleteMetric(String)]
  // [VARIABLE "my_metric_name"]
  public boolean deleteMetric(String metricName) {
    // [START deleteMetric]
    boolean deleted = logging.deleteMetric(metricName);
    if (deleted) {
      // the metric was deleted
    } else {
      // the metric was not found
    }
    // [END deleteMetric]
    return deleted;
  }

  /** Example of asynchronously deleting a metric. */
  // [TARGET deleteMetricAsync(String)]
  // [VARIABLE "my_metric_name"]
  public boolean deleteMetricAsync(String metricName)
      throws ExecutionException, InterruptedException {
    // [START deleteMetricAsync]
    Future<Boolean> future = logging.deleteMetricAsync(metricName);
    // ...
    boolean deleted = future.get();
    if (deleted) {
      // the metric was deleted
    } else {
      // the metric was not found
    }
    // [END deleteMetricAsync]
    return deleted;
  }

  /**
   * Example of writing log entries and providing a default log name and monitored resource. Logging
   * writes are asynchronous by default. {@link Logging#setWriteSynchronicity(Synchronicity)} can be
   * used to update the synchronicity.
   */
  // [TARGET write(Iterable, WriteOption...)]
  // [VARIABLE "my_log_name"]
  public void write(String logName) {
    // [START logging_write_log_entry]
    List<LogEntry> entries = new ArrayList<>();
    entries.add(LogEntry.of(StringPayload.of("Entry payload")));
    Map<String, Object> jsonMap = new HashMap<>();
    jsonMap.put("key", "value");
    entries.add(LogEntry.of(JsonPayload.of(jsonMap)));
    logging.write(
        entries,
        WriteOption.logName(logName),
        WriteOption.resource(MonitoredResource.newBuilder("global").build()));
    // [END logging_write_log_entry]
  }

  /** Example of listing log entries for a specific log. */
  // [TARGET listLogEntries(EntryListOption...)]
  // [VARIABLE "logName=projects/my_project_id/logs/my_log_name"]
  public Page<LogEntry> listLogEntries(String filter) {
    Page<LogEntry> entries = logging.listLogEntries(EntryListOption.filter(filter));
    for (LogEntry entry : entries.iterateAll()) {
      // do something with the entry
    }
    return entries;
  }

  /** Example of asynchronously listing log entries for a specific log. */
  // [TARGET listLogEntriesAsync(EntryListOption...)]
  // [VARIABLE "logName=projects/my_project_id/logs/my_log_name"]
  public Page<LogEntry> listLogEntriesAsync(String filter)
      throws ExecutionException, InterruptedException {
    // [START listLogEntriesAsync]
    Future<AsyncPage<LogEntry>> future =
        logging.listLogEntriesAsync(EntryListOption.filter(filter));
    // ...
    AsyncPage<LogEntry> entries = future.get();
    for (LogEntry entry : entries.iterateAll()) {
      // do something with the entry
    }
    // [END listLogEntriesAsync]
    return entries;
  }
}
