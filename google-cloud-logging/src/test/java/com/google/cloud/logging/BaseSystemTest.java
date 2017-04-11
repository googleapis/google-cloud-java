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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.core.AsyncPage;
import com.google.api.gax.core.Page;
import com.google.cloud.MonitoredResource;
import com.google.cloud.MonitoredResourceDescriptor;
import com.google.cloud.logging.Logging.EntryListOption;
import com.google.cloud.logging.Logging.SortingField;
import com.google.cloud.logging.Logging.SortingOrder;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.Payload.JsonPayload;
import com.google.cloud.logging.Payload.ProtoPayload;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.cloud.logging.SinkInfo.Destination.DatasetDestination;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.protobuf.Any;
import com.google.protobuf.StringValue;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

/**
 * A base class for system tests. This class can be extended to run system tests in different
 * environments (e.g. local emulator or remote Logging service).
 */
public abstract class BaseSystemTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  /**
   * Returns the Logging service used to issue requests. This service can be such that it interacts
   * with the remote Logging service (for integration tests) or with an emulator (for local
   * testing).
   */
  protected abstract Logging logging();

  /**
   * Formats a resource name for testing purpose. For instance, for tests against the remote
   * service, it is recommended to append to the name a random or time-based seed to prevent name
   * clashes.
   */
  protected abstract String formatForTest(String resourceName);

  @Test
  public void testCreateGetUpdateAndDeleteSink() {
    String name = formatForTest("test-create-get-update-sink");
    SinkInfo sinkInfo = SinkInfo.newBuilder(name, DatasetDestination.of("dataset"))
        .setFilter("severity>=ERROR")
        .setVersionFormat(SinkInfo.VersionFormat.V2)
        .build();
    Sink sink = logging().create(sinkInfo);
    assertEquals(name, sink.getName());
    assertEquals(SinkInfo.VersionFormat.V2, sink.getVersionFormat());
    assertEquals("severity>=ERROR", sink.getFilter());
    DatasetDestination datasetDestination = sink.getDestination();
    assertEquals(logging().getOptions().getProjectId(), datasetDestination.getProject());
    assertEquals("dataset", datasetDestination.getDataset());
    assertEquals(sink, logging().getSink(name));
    sink = sink.toBuilder()
        .setFilter("severity<=ERROR")
        .build()
        .update();
    assertEquals(name, sink.getName());
    assertEquals(SinkInfo.VersionFormat.V2, sink.getVersionFormat());
    assertEquals("severity<=ERROR", sink.getFilter());
    assertTrue(sink.delete());
    assertFalse(sink.delete());
  }

  @Test
  public void testCreateGetUpdateAndDeleteSinkAsync()
      throws ExecutionException, InterruptedException {
    String name = formatForTest("test-create-get-update-sink-async");
    SinkInfo sinkInfo = SinkInfo.newBuilder(name, DatasetDestination.of("dataset"))
        .setFilter("severity>=ERROR")
        .setVersionFormat(SinkInfo.VersionFormat.V2)
        .build();
    Sink sink = logging().createAsync(sinkInfo).get();
    assertEquals(name, sink.getName());
    assertEquals(SinkInfo.VersionFormat.V2, sink.getVersionFormat());
    assertEquals("severity>=ERROR", sink.getFilter());
    DatasetDestination datasetDestination = sink.getDestination();
    assertEquals(logging().getOptions().getProjectId(), datasetDestination.getProject());
    assertEquals("dataset", datasetDestination.getDataset());
    assertEquals(sink, logging().getSinkAsync(name).get());
    sink = sink.toBuilder()
        .setFilter("severity<=ERROR")
        .build()
        .updateAsync().get();
    assertEquals(name, sink.getName());
    assertEquals(SinkInfo.VersionFormat.V2, sink.getVersionFormat());
    assertEquals("severity<=ERROR", sink.getFilter());
    assertTrue(sink.deleteAsync().get());
    assertFalse(sink.deleteAsync().get());
  }

  @Test
  public void testUpdateNonExistingSink() {
    String name = formatForTest("test-update-non-existing-sink");
    SinkInfo sinkInfo = SinkInfo.newBuilder(name, DatasetDestination.of("dataset"))
        .setFilter("severity>=ERROR")
        .setVersionFormat(SinkInfo.VersionFormat.V2)
        .build();
    assertNull(logging().getSink(name));
    Sink sink = logging().update(sinkInfo);
    assertEquals(name, sink.getName());
    assertEquals(SinkInfo.VersionFormat.V2, sink.getVersionFormat());
    assertEquals("severity>=ERROR", sink.getFilter());
    DatasetDestination datasetDestination = sink.getDestination();
    assertEquals(logging().getOptions().getProjectId(), datasetDestination.getProject());
    assertEquals("dataset", datasetDestination.getDataset());
    assertTrue(logging().deleteSink(name));
  }

  @Test
  public void testUpdateNonExistingSinkAsync() throws ExecutionException, InterruptedException {
    String name = formatForTest("test-update-non-existing-sink-async");
    SinkInfo sinkInfo = SinkInfo.newBuilder(name, DatasetDestination.of("dataset"))
        .setFilter("severity>=ERROR")
        .setVersionFormat(SinkInfo.VersionFormat.V2)
        .build();
    assertNull(logging().getSinkAsync(name).get());
    Sink sink = logging().updateAsync(sinkInfo).get();
    assertEquals(name, sink.getName());
    assertEquals(SinkInfo.VersionFormat.V2, sink.getVersionFormat());
    assertEquals("severity>=ERROR", sink.getFilter());
    DatasetDestination datasetDestination = sink.getDestination();
    assertEquals(logging().getOptions().getProjectId(), datasetDestination.getProject());
    assertEquals("dataset", datasetDestination.getDataset());
    assertTrue(logging().deleteSinkAsync(name).get());
  }

  @Test
  public void testListSinks() throws InterruptedException {
    String firstName = formatForTest("test-list-sinks-1");
    String secondName = formatForTest("test-list-sinks-2");
    Sink firstSink = logging().create(SinkInfo.of(firstName, DatasetDestination.of("dataset")));
    Sink secondSink = logging().create(SinkInfo.of(secondName, DatasetDestination.of("dataset")));
    Logging.ListOption[] options = {Logging.ListOption.pageSize(1)};
    Page<Sink> sinkPage = logging().listSinks(options);
    Set<Sink> sinks = Sets.newHashSet(sinkPage.iterateAll());
    while (!sinks.contains(firstSink) || !sinks.contains(secondSink)) {
      Thread.sleep(500);
      sinks = Sets.newHashSet(logging().listSinks(options).iterateAll());
    }
    firstSink.delete();
    secondSink.delete();
  }

  @Test
  public void testListSinksAsync() throws ExecutionException, InterruptedException {
    String firstName = formatForTest("test-list-sinks-async-1");
    String secondName = formatForTest("test-list-sinks-async-2");
    Sink firstSink = logging().create(SinkInfo.of(firstName, DatasetDestination.of("dataset")));
    Sink secondSink = logging().create(SinkInfo.of(secondName, DatasetDestination.of("dataset")));
    Logging.ListOption[] options = {Logging.ListOption.pageSize(1)};
    AsyncPage<Sink> sinkPage = logging().listSinksAsync(options).get();
    Set<Sink> sinks = Sets.newHashSet(sinkPage.iterateAll());
    while (!sinks.contains(firstSink) || !sinks.contains(secondSink)) {
      Thread.sleep(500);
      sinks = Sets.newHashSet(logging().listSinksAsync(options).get().iterateAll());
    }
    firstSink.delete();
    secondSink.delete();
  }

  @Test
  public void testListMonitoredResourceDescriptors() {
    Iterator<MonitoredResourceDescriptor> iterator =
        logging().listMonitoredResourceDescriptors(Logging.ListOption.pageSize(1)).iterateAll().iterator();
    int count = 0;
    while (iterator.hasNext()) {
      assertNotNull(iterator.next().getType());
      count += 1;
    }
    assertTrue(count > 0);
  }

  @Test
  public void testListMonitoredResourceDescriptorsAsync()
      throws ExecutionException, InterruptedException {
    Iterator<MonitoredResourceDescriptor> iterator = logging()
        .listMonitoredResourceDescriptorsAsync(Logging.ListOption.pageSize(1)).get().iterateAll().iterator();
    int count = 0;
    while (iterator.hasNext()) {
      assertNotNull(iterator.next().getType());
      count += 1;
    }
    assertTrue(count > 0);
  }

  @Test
  public void testCreateGetUpdateAndDeleteMetric() {
    String name = formatForTest("test-create-get-update-metric");
    MetricInfo metricInfo = MetricInfo.newBuilder(name, "severity>=ERROR")
        .setDescription("description")
        .build();
    Metric metric = logging().create(metricInfo);
    assertEquals(name, metric.getName());
    assertEquals("severity>=ERROR", metric.getFilter());
    assertEquals("description", metric.getDescription());
    assertEquals(metric, logging().getMetric(name));
    metric = metric.toBuilder()
        .setDescription("newDescription")
        .setFilter("severity>=WARNING")
        .build()
        .update();
    assertEquals(name, metric.getName());
    assertEquals("severity>=WARNING", metric.getFilter());
    assertEquals("newDescription", metric.getDescription());
    assertTrue(metric.delete());
    assertFalse(metric.delete());
  }

  @Test
  public void testCreateGetUpdateAndDeleteMetricAsync()
      throws ExecutionException, InterruptedException {
    String name = formatForTest("test-create-get-update-metric-async");
    MetricInfo metricInfo = MetricInfo.newBuilder(name, "severity>=ERROR")
        .setDescription("description")
        .build();
    Metric metric = logging().createAsync(metricInfo).get();
    assertEquals(name, metric.getName());
    assertEquals("severity>=ERROR", metric.getFilter());
    assertEquals("description", metric.getDescription());
    assertEquals(metric, logging().getMetricAsync(name).get());
    metric = metric.toBuilder()
        .setDescription("newDescription")
        .setFilter("severity>=WARNING")
        .build()
        .updateAsync().get();
    assertEquals(name, metric.getName());
    assertEquals("severity>=WARNING", metric.getFilter());
    assertEquals("newDescription", metric.getDescription());
    assertTrue(metric.deleteAsync().get());
    assertFalse(metric.deleteAsync().get());
  }

  @Test
  public void testUpdateNonExistingMetric() {
    String name = formatForTest("test-update-non-existing-metric");
    MetricInfo metricInfo = MetricInfo.newBuilder(name, "severity>=ERROR")
        .setDescription("description")
        .build();
    assertNull(logging().getMetric(name));
    Metric metric = logging().update(metricInfo);
    assertEquals(name, metric.getName());
    assertEquals("severity>=ERROR", metric.getFilter());
    assertEquals("description", metric.getDescription());
    assertTrue(metric.delete());
  }

  @Test
  public void testUpdateNonExistingMetricAsync() throws ExecutionException, InterruptedException {
    String name = formatForTest("test-update-non-existing-metric-async");
    MetricInfo metricInfo = MetricInfo.newBuilder(name, "severity>=ERROR")
        .setDescription("description")
        .build();
    assertNull(logging().getMetricAsync(name).get());
    Metric metric = logging().updateAsync(metricInfo).get();
    assertEquals(name, metric.getName());
    assertEquals("severity>=ERROR", metric.getFilter());
    assertEquals("description", metric.getDescription());
    assertTrue(metric.deleteAsync().get());
  }

  @Test
  public void testListMetrics() throws InterruptedException {
    String firstName = formatForTest("test-list-metrics-1");
    String secondName = formatForTest("test-list-metrics-2");
    Metric firstMetric = logging().create(MetricInfo.of(firstName, "severity>=ERROR"));
    Metric secondMetric = logging().create(MetricInfo.of(secondName, "severity>=ERROR"));
    Logging.ListOption[] options = {Logging.ListOption.pageSize(1)};
    Page<Metric> metricPage = logging().listMetrics(options);
    Set<Metric> metrics = Sets.newHashSet(metricPage.iterateAll());
    while (!metrics.contains(firstMetric) || !metrics.contains(secondMetric)) {
      Thread.sleep(500);
      metrics = Sets.newHashSet(logging().listMetrics(options).iterateAll());
    }
    firstMetric.delete();
    secondMetric.delete();
  }

  @Test
  public void testListMetricsAsync() throws ExecutionException, InterruptedException {
    String firstName = formatForTest("test-list-metrics-async-1");
    String secondName = formatForTest("test-list-metrics-async-2");
    Metric firstMetric = logging().create(MetricInfo.of(firstName, "severity>=ERROR"));
    Metric secondMetric = logging().create(MetricInfo.of(secondName, "severity>=ERROR"));
    Logging.ListOption[] options = {Logging.ListOption.pageSize(1)};
    AsyncPage<Metric> metricPage = logging().listMetricsAsync(options).get();
    Set<Metric> metrics = Sets.newHashSet(metricPage.iterateAll());
    while (!metrics.contains(firstMetric) || !metrics.contains(secondMetric)) {
      Thread.sleep(500);
      metrics = Sets.newHashSet(logging().listMetricsAsync(options).get().iterateAll());
    }
    firstMetric.delete();
    secondMetric.delete();
  }

  @Test
  public void testWriteAndListLogEntries() throws InterruptedException {
    String logName = formatForTest("test-write-log-entries-log");
    String filter =
        "logName = projects/" + logging().getOptions().getProjectId() + "/logs/" + logName;
    StringPayload firstPayload = StringPayload.of("stringPayload");
    LogEntry firstEntry = LogEntry.newBuilder(firstPayload)
        .addLabel("key1", "value1")
        .setLogName(logName)
        .setHttpRequest(HttpRequest.newBuilder().setStatus(500).build())
        .setResource(MonitoredResource.newBuilder("global").build())
        .build();
    JsonPayload secondPayload =
        JsonPayload.of(ImmutableMap.<String, Object>of("jsonKey", "jsonValue"));
    LogEntry secondEntry = LogEntry.newBuilder(secondPayload)
        .addLabel("key2", "value2")
        .setLogName(logName)
        .setOperation(Operation.of("operationId", "operationProducer"))
        .setResource(MonitoredResource.newBuilder("cloudsql_database").build())
        .build();
    logging().write(ImmutableList.of(firstEntry));
    logging().write(ImmutableList.of(secondEntry));
    EntryListOption[] options = {EntryListOption.filter(filter), EntryListOption.pageSize(1)};
    Page<LogEntry> page = logging().listLogEntries(options);
    while (Iterators.size(page.iterateAll().iterator()) < 2) {
      Thread.sleep(500);
      page = logging().listLogEntries(options);
    }
    Iterator<LogEntry> iterator = page.iterateAll().iterator();
    assertTrue(iterator.hasNext());
    LogEntry entry = iterator.next();
    assertEquals(firstPayload, entry.getPayload());
    assertEquals(logName, entry.getLogName());
    assertEquals(ImmutableMap.of("key1", "value1"), entry.getLabels());
    assertEquals("global", entry.getResource().getType());
    assertEquals(HttpRequest.newBuilder().setStatus(500).build(), entry.getHttpRequest());
    assertEquals(Severity.DEFAULT, entry.getSeverity());
    assertNull(entry.getOperation());
    assertNotNull(entry.getInsertId());
    assertNotNull(entry.getTimestamp());
    assertTrue(iterator.hasNext());
    entry = iterator.next();
    assertEquals(secondPayload, entry.getPayload());
    assertEquals(logName, entry.getLogName());
    assertEquals(ImmutableMap.of("key2", "value2"), entry.getLabels());
    assertEquals("cloudsql_database", entry.getResource().getType());
    assertEquals(Operation.of("operationId", "operationProducer"), entry.getOperation());
    assertEquals(Severity.DEFAULT, entry.getSeverity());
    assertNull(entry.getHttpRequest());
    assertNotNull(entry.getInsertId());
    assertNotNull(entry.getTimestamp());
    options = new EntryListOption[]{EntryListOption.filter(filter),
        EntryListOption.sortOrder(SortingField.TIMESTAMP, SortingOrder.DESCENDING)};
    page = logging().listLogEntries(options);
    while (Iterators.size(page.iterateAll().iterator()) < 2) {
      Thread.sleep(500);
      page = logging().listLogEntries(options);
    }
    iterator = page.iterateAll().iterator();
    Long lastTimestamp = iterator.next().getTimestamp();
    while (iterator.hasNext()) {
      assertTrue(iterator.next().getTimestamp() <= lastTimestamp);
    }
    assertTrue(logging().deleteLog(logName));
  }

  @Test
  public void testWriteAndListLogEntriesAsync() throws InterruptedException, ExecutionException {
    String logName = formatForTest("test-write-log-entries-async-log");
    String filter =
        "logName = projects/" + logging().getOptions().getProjectId() + "/logs/" + logName;
    StringPayload firstPayload = StringPayload.of("stringPayload");
    LogEntry firstEntry = LogEntry.newBuilder(firstPayload).setSeverity(Severity.ALERT).build();
    ProtoPayload secondPayload =
        ProtoPayload.of(Any.pack(StringValue.newBuilder().setValue("protoPayload").build()));
    LogEntry secondEntry = LogEntry.newBuilder(secondPayload).setSeverity(Severity.DEBUG).build();
    logging().writeAsync(ImmutableList.of(firstEntry, secondEntry),
        WriteOption.labels(ImmutableMap.of("key1", "value1")),
        WriteOption.resource(MonitoredResource.newBuilder("global").build()),
        WriteOption.logName(logName)).get();
    EntryListOption[] options = {EntryListOption.filter(filter), EntryListOption.pageSize(1)};
    AsyncPage<LogEntry> page = logging().listLogEntriesAsync(options).get();
    while (Iterators.size(page.iterateAll().iterator()) < 2) {
      Thread.sleep(500);
      page = logging().listLogEntriesAsync(options).get();
    }
    Iterator<LogEntry> iterator = page.iterateAll().iterator();
    assertTrue(iterator.hasNext());
    LogEntry entry = iterator.next();
    assertEquals(firstPayload, entry.getPayload());
    assertEquals(logName, entry.getLogName());
    assertEquals(ImmutableMap.of("key1", "value1"), entry.getLabels());
    assertEquals("global", entry.getResource().getType());
    assertNull(entry.getHttpRequest());
    assertEquals(Severity.ALERT, entry.getSeverity());
    assertNull(entry.getOperation());
    assertNotNull(entry.getInsertId());
    assertNotNull(entry.getTimestamp());
    assertTrue(iterator.hasNext());
    entry = iterator.next();
    assertEquals(secondPayload, entry.getPayload());
    assertEquals(logName, entry.getLogName());
    assertEquals(ImmutableMap.of("key1", "value1"), entry.getLabels());
    assertEquals("global", entry.getResource().getType());
    assertNull(entry.getOperation());
    assertEquals(Severity.DEBUG, entry.getSeverity());
    assertNull(entry.getHttpRequest());
    assertNotNull(entry.getInsertId());
    assertNotNull(entry.getTimestamp());
    assertTrue(logging().deleteLogAsync(logName).get());
  }

  @Test
  public void testDeleteNonExistingLog() {
    String logName = formatForTest("test-delete-non-existing-log");
    assertFalse(logging().deleteLog(logName));
  }

  @Test
  public void testDeleteNonExistingLogAsync() throws ExecutionException, InterruptedException {
    String logName = formatForTest("test-delete-non-existing-log-async");
    assertFalse(logging().deleteLogAsync(logName).get());
  }

  @Test
  public void testLoggingHandler() throws InterruptedException {
    String logName = formatForTest("test-logging-handler");
    LoggingOptions options = logging().getOptions();
    LoggingHandler handler = new LoggingHandler(logName, options);
    handler.setLevel(Level.INFO);
    Logger logger = Logger.getLogger(getClass().getName());
    logger.addHandler(handler);
    logger.setLevel(Level.INFO);
    logger.info("Message");
    Iterator<LogEntry> iterator =
        logging().listLogEntries(EntryListOption.filter("logName:" + logName)).iterateAll().iterator();
    while (!iterator.hasNext()) {
      Thread.sleep(500L);
      iterator =
          logging().listLogEntries(EntryListOption.filter("logName:" + logName)).iterateAll().iterator();
    }
    assertTrue(iterator.hasNext());
    LogEntry entry = iterator.next();
    assertTrue(entry.getPayload() instanceof StringPayload);
    assertTrue(entry.<StringPayload>getPayload().getData().contains("Message"));
    assertEquals(logName, entry.getLogName());
    assertEquals(ImmutableMap.of("levelName", "INFO",
        "levelValue", String.valueOf(Level.INFO.intValue())), entry.getLabels());
    assertEquals("global", entry.getResource().getType());
    assertEquals(ImmutableMap.of("project_id", options.getProjectId()),
        entry.getResource().getLabels());
    assertNull(entry.getHttpRequest());
    assertEquals(Severity.INFO, entry.getSeverity());
    assertNull(entry.getOperation());
    assertNotNull(entry.getInsertId());
    assertNotNull(entry.getTimestamp());
    assertFalse(iterator.hasNext());
    logger.removeHandler(handler);
    logging().deleteLog(logName);
  }

  @Test
  public void testSyncLoggingHandler() throws InterruptedException {
    String logName = formatForTest("test-sync-logging-handler");
    LoggingOptions options = logging().getOptions();
    MonitoredResource resource = MonitoredResource.of("gce_instance",
        ImmutableMap.of("project_id", options.getProjectId(),
            "instance_id", "instance",
            "zone", "us-central1-a"));
    LoggingHandler handler = new LoggingHandler(logName, options, resource);
    handler.setLevel(Level.WARNING);
    handler.setSynchronicity(Synchronicity.SYNC);
    Logger logger = Logger.getLogger(getClass().getName());
    logger.addHandler(handler);
    logger.setLevel(Level.WARNING);
    logger.warning("Message");
    Iterator<LogEntry> iterator =
        logging().listLogEntries(EntryListOption.filter("logName:" + logName)).iterateAll().iterator();
    while (!iterator.hasNext()) {
      Thread.sleep(500L);
      iterator =
          logging().listLogEntries(EntryListOption.filter("logName:" + logName)).iterateAll().iterator();
    }
    assertTrue(iterator.hasNext());
    LogEntry entry = iterator.next();
    assertTrue(entry.getPayload() instanceof StringPayload);
    assertTrue(entry.<StringPayload>getPayload().getData().contains("Message"));
    assertEquals(logName, entry.getLogName());
    assertEquals(ImmutableMap.of("levelName", "WARNING",
        "levelValue", String.valueOf(Level.WARNING.intValue())), entry.getLabels());
    assertEquals(resource, entry.getResource());
    assertNull(entry.getHttpRequest());
    assertEquals(Severity.WARNING, entry.getSeverity());
    assertNull(entry.getOperation());
    assertNotNull(entry.getInsertId());
    assertNotNull(entry.getTimestamp());
    assertFalse(iterator.hasNext());
    logger.removeHandler(handler);
    logging().deleteLog(logName);
  }
}
