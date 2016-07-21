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

import com.google.cloud.AsyncPage;
import com.google.cloud.MonitoredResource;
import com.google.cloud.MonitoredResourceDescriptor;
import com.google.cloud.Page;
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
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.protobuf.Any;
import com.google.protobuf.StringValue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A base class for system tests. This class can be extended to run system tests in different
 * environments (e.g. local emulator or remote Logging service).
 */
public abstract class BaseSystemTest {

  private static final Set<String> DESCRIPTOR_TYPES = ImmutableSet.of("gce_instance", "gae_app",
      "cloudsql_database", "api", "gcs_bucket", "global", "dataflow_step", "build",
      "app_script_function", "dataproc_cluster", "ml_job", "bigquery_resource",
      "crm_iam_policy_check", "container", "gke_cluster", "cloud_debugger_resource",
      "http_load_balancer", "aws_ec2_instance", "client_auth_config_brand",
      "client_auth_config_client", "logging_log", "logging_sink", "metric", "project",
      "testservice_matrix", "service_account", "deployment", "dns_managed_zone");

  @Rule
  public ExpectedException thrown = ExpectedException.none();

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
    SinkInfo sinkInfo = SinkInfo.builder(name, DatasetDestination.of("dataset"))
        .filter("severity>=ERROR")
        .versionFormat(SinkInfo.VersionFormat.V2)
        .build();
    Sink sink = logging().create(sinkInfo);
    assertEquals(name, sink.name());
    assertEquals(SinkInfo.VersionFormat.V2, sink.versionFormat());
    assertEquals("severity>=ERROR", sink.filter());
    DatasetDestination datasetDestination = sink.destination();
    assertEquals(logging().options().projectId(), datasetDestination.project());
    assertEquals("dataset", datasetDestination.dataset());
    assertEquals(sink, logging().getSink(name));
    sink = sink.update(sink.toBuilder()
        .versionFormat(SinkInfo.VersionFormat.V1)
        .filter("metadata.serviceName=appengine.googleapis.com")
        .build());
    assertEquals(name, sink.name());
    assertEquals(SinkInfo.VersionFormat.V1, sink.versionFormat());
    assertEquals("metadata.serviceName=appengine.googleapis.com", sink.filter());
    assertTrue(sink.delete());
  }

  @Test
  public void testCreateGetUpdateAndDeleteSinkAsync()
      throws ExecutionException, InterruptedException {
    String name = formatForTest("test-create-get-update-sink-async");
    SinkInfo sinkInfo = SinkInfo.builder(name, DatasetDestination.of("dataset"))
        .filter("severity>=ERROR")
        .versionFormat(SinkInfo.VersionFormat.V2)
        .build();
    Sink sink = logging().createAsync(sinkInfo).get();
    assertEquals(name, sink.name());
    assertEquals(SinkInfo.VersionFormat.V2, sink.versionFormat());
    assertEquals("severity>=ERROR", sink.filter());
    DatasetDestination datasetDestination = sink.destination();
    assertEquals(logging().options().projectId(), datasetDestination.project());
    assertEquals("dataset", datasetDestination.dataset());
    assertEquals(sink, logging().getSinkAsync(name).get());
    sink = sink.updateAsync(sink.toBuilder()
        .versionFormat(SinkInfo.VersionFormat.V1)
        .filter("metadata.serviceName=appengine.googleapis.com")
        .build()).get();
    assertEquals(name, sink.name());
    assertEquals(SinkInfo.VersionFormat.V1, sink.versionFormat());
    assertEquals("metadata.serviceName=appengine.googleapis.com", sink.filter());
    assertTrue(sink.deleteAsync().get());
  }

  @Test
  public void testUpdateNonExistingSink() {
    String name = formatForTest("test-update-non-existing-sink");
    SinkInfo sinkInfo = SinkInfo.builder(name, DatasetDestination.of("dataset"))
        .filter("severity>=ERROR")
        .versionFormat(SinkInfo.VersionFormat.V2)
        .build();
    assertNull(logging().getSink(name));
    Sink sink = logging().update(sinkInfo);
    assertEquals(name, sink.name());
    assertEquals(SinkInfo.VersionFormat.V2, sink.versionFormat());
    assertEquals("severity>=ERROR", sink.filter());
    DatasetDestination datasetDestination = sink.destination();
    assertEquals(logging().options().projectId(), datasetDestination.project());
    assertEquals("dataset", datasetDestination.dataset());
    assertTrue(logging().deleteSink(name));
  }

  @Test
  public void testUpdateNonExistingSinkAsync() throws ExecutionException, InterruptedException {
    String name = formatForTest("test-update-non-existing-sink-async");
    SinkInfo sinkInfo = SinkInfo.builder(name, DatasetDestination.of("dataset"))
        .filter("severity>=ERROR")
        .versionFormat(SinkInfo.VersionFormat.V2)
        .build();
    assertNull(logging().getSinkAsync(name).get());
    Sink sink = logging().updateAsync(sinkInfo).get();
    assertEquals(name, sink.name());
    assertEquals(SinkInfo.VersionFormat.V2, sink.versionFormat());
    assertEquals("severity>=ERROR", sink.filter());
    DatasetDestination datasetDestination = sink.destination();
    assertEquals(logging().options().projectId(), datasetDestination.project());
    assertEquals("dataset", datasetDestination.dataset());
    assertTrue(logging().deleteSinkAsync(name).get());
  }

  @Test
  public void testListSinks() {
    String firstName = formatForTest("test-list-sinks-1");
    String secondName = formatForTest("test-list-sinks-2");
    Sink firstSink = logging().create(SinkInfo.of(firstName, DatasetDestination.of("dataset")));
    Sink secondSink = logging().create(SinkInfo.of(secondName, DatasetDestination.of("dataset")));
    Set<String> sinkNames = new HashSet<>();
    Iterator<Sink> sinkIterator = logging().listSinks(Logging.ListOption.pageSize(1)).iterateAll();
    while (sinkIterator.hasNext()) {
      sinkNames.add(sinkIterator.next().name());
    }
    assertTrue(sinkNames.contains(firstName));
    assertTrue(sinkNames.contains(secondName));
    firstSink.delete();
    secondSink.delete();
  }

  @Test
  public void testListSinksAsync() throws ExecutionException, InterruptedException {
    String firstName = formatForTest("test-list-sinks-async-1");
    String secondName = formatForTest("test-list-sinks-async-2");
    Sink firstSink = logging().create(SinkInfo.of(firstName, DatasetDestination.of("dataset")));
    Sink secondSink = logging().create(SinkInfo.of(secondName, DatasetDestination.of("dataset")));
    Set<String> sinkNames = new HashSet<>();
    Iterator<Sink> sinkIterator =
        logging().listSinksAsync(Logging.ListOption.pageSize(1)).get().iterateAll();
    while (sinkIterator.hasNext()) {
      sinkNames.add(sinkIterator.next().name());
    }
    assertTrue(sinkNames.contains(firstName));
    assertTrue(sinkNames.contains(secondName));
    firstSink.delete();
    secondSink.delete();
  }

  @Test
  public void testListMonitoredResourceDescriptors() {
    Iterator<MonitoredResourceDescriptor> iterator =
        logging().listMonitoredResourceDescriptors(Logging.ListOption.pageSize(1)).iterateAll();
    Set<String> descriptorTypes = new HashSet<>();
    while (iterator.hasNext()) {
      descriptorTypes.add(iterator.next().type());
    }
    for (String type : DESCRIPTOR_TYPES) {
      assertTrue(descriptorTypes.contains(type));
    }
  }

  @Test
  public void testListMonitoredResourceDescriptorsAsync()
      throws ExecutionException, InterruptedException {
    Iterator<MonitoredResourceDescriptor> iterator = logging()
        .listMonitoredResourceDescriptorsAsync(Logging.ListOption.pageSize(1)).get().iterateAll();
    Set<String> descriptorTypes = new HashSet<>();
    while (iterator.hasNext()) {
      descriptorTypes.add(iterator.next().type());
    }
    for (String type : DESCRIPTOR_TYPES) {
      assertTrue(descriptorTypes.contains(type));
    }
  }

  @Test
  public void testCreateGetUpdateAndDeleteMetric() {
    String name = formatForTest("test-create-get-update-metric");
    MetricInfo metricInfo = MetricInfo.builder(name, "severity>=ERROR")
        .description("description")
        .build();
    Metric metric = logging().create(metricInfo);
    assertEquals(name, metric.name());
    assertEquals("severity>=ERROR", metric.filter());
    assertEquals("description", metric.description());
    assertEquals(metric, logging().getMetric(name));
    metric = metric.update(metric.toBuilder()
        .description("newDescription")
        .filter("severity>=WARNING")
        .build());
    assertEquals(name, metric.name());
    assertEquals("severity>=WARNING", metric.filter());
    assertEquals("newDescription", metric.description());
    assertTrue(metric.delete());
  }

  @Test
  public void testCreateGetUpdateAndDeleteMetricAsync()
      throws ExecutionException, InterruptedException {
    String name = formatForTest("test-create-get-update-metric-async");
    MetricInfo metricInfo = MetricInfo.builder(name, "severity>=ERROR")
        .description("description")
        .build();
    Metric metric = logging().createAsync(metricInfo).get();
    assertEquals(name, metric.name());
    assertEquals("severity>=ERROR", metric.filter());
    assertEquals("description", metric.description());
    assertEquals(metric, logging().getMetricAsync(name).get());
    metric = metric.updateAsync(metric.toBuilder()
        .description("newDescription")
        .filter("severity>=WARNING")
        .build()).get();
    assertEquals(name, metric.name());
    assertEquals("severity>=WARNING", metric.filter());
    assertEquals("newDescription", metric.description());
    assertTrue(metric.deleteAsync().get());
  }

  @Test
  public void testUpdateNonExistingMetric() {
    String name = formatForTest("test-update-non-existing-metric");
    MetricInfo metricInfo = MetricInfo.builder(name, "severity>=ERROR")
        .description("description")
        .build();
    assertNull(logging().getMetric(name));
    Metric metric = logging().update(metricInfo);
    assertEquals(name, metric.name());
    assertEquals("severity>=ERROR", metric.filter());
    assertEquals("description", metric.description());
    assertTrue(metric.delete());
  }

  @Test
  public void testUpdateNonExistingMetricAsync() throws ExecutionException, InterruptedException {
    String name = formatForTest("test-update-non-existing-metric-async");
    MetricInfo metricInfo = MetricInfo.builder(name, "severity>=ERROR")
        .description("description")
        .build();
    assertNull(logging().getMetricAsync(name).get());
    Metric metric = logging().updateAsync(metricInfo).get();
    assertEquals(name, metric.name());
    assertEquals("severity>=ERROR", metric.filter());
    assertEquals("description", metric.description());
    assertTrue(metric.deleteAsync().get());
  }

  @Test
  public void testListMetrics() {
    String firstName = formatForTest("test-list-metrics-1");
    String secondName = formatForTest("test-list-metrics-2");
    Metric firstMetric = logging().create(MetricInfo.of(firstName, "severity>=ERROR"));
    Metric secondMetric = logging().create(MetricInfo.of(secondName, "severity>=ERROR"));
    Set<String> metricNames = new HashSet<>();
    Iterator<Metric> metricIterator =
        logging().listMetrics(Logging.ListOption.pageSize(1)).iterateAll();
    while (metricIterator.hasNext()) {
      metricNames.add(metricIterator.next().name());
    }
    assertTrue(metricNames.contains(firstName));
    assertTrue(metricNames.contains(secondName));
    firstMetric.delete();
    secondMetric.delete();
  }

  @Test
  public void testListMetricsAsync() {
    String firstName = formatForTest("test-list-metrics-async-1");
    String secondName = formatForTest("test-list-metrics-async-2");
    Metric firstMetric = logging().create(MetricInfo.of(firstName, "severity>=ERROR"));
    Metric secondMetric = logging().create(MetricInfo.of(secondName, "severity>=ERROR"));
    Set<String> metricNames = new HashSet<>();
    Iterator<Metric> metricIterator =
        logging().listMetrics(Logging.ListOption.pageSize(1)).iterateAll();
    while (metricIterator.hasNext()) {
      metricNames.add(metricIterator.next().name());
    }
    assertTrue(metricNames.contains(firstName));
    assertTrue(metricNames.contains(secondName));
    firstMetric.delete();
    secondMetric.delete();
  }

  @Test
  public void testWriteAndListLogEntries() throws InterruptedException {
    String logName = formatForTest("test-write-log-entries-log");
    String filter = "logName = projects/" + logging().options().projectId() + "/logs/" + logName;
    StringPayload firstPayload = StringPayload.of("stringPayload");
    LogEntry firstEntry = LogEntry.builder(firstPayload)
        .addLabel("key1", "value1")
        .logName(logName)
        .httpRequest(HttpRequest.builder().status(500).build())
        .resource(MonitoredResource.builder("global").build())
        .build();
    JsonPayload secondPayload =
        JsonPayload.of(ImmutableMap.<String, Object>of("jsonKey", "jsonValue"));
    LogEntry secondEntry = LogEntry.builder(secondPayload)
        .addLabel("key2", "value2")
        .logName(logName)
        .operation(Operation.of("operationId", "operationProducer"))
        .resource(MonitoredResource.builder("cloudsql_database").build())
        .build();
    logging().write(ImmutableList.of(firstEntry));
    logging().write(ImmutableList.of(secondEntry));
    EntryListOption[] options = {EntryListOption.filter(filter), EntryListOption.pageSize(1)};
    Page<LogEntry> page = logging().listLogEntries(options);
    while (Iterators.size(page.iterateAll()) < 2) {
      Thread.sleep(500);
      page = logging().listLogEntries(options);
    }
    Iterator<LogEntry> iterator = page.iterateAll();
    assertTrue(iterator.hasNext());
    LogEntry entry = iterator.next();
    assertEquals(firstPayload, entry.payload());
    assertEquals(logName, entry.logName());
    assertEquals(ImmutableMap.of("key1", "value1"), entry.labels());
    assertEquals("global", entry.resource().type());
    assertEquals(HttpRequest.builder().status(500).build(), entry.httpRequest());
    assertEquals(Severity.DEFAULT, entry.severity());
    assertNull(entry.operation());
    assertNotNull(entry.insertId());
    assertNotNull(entry.timestamp());
    assertTrue(iterator.hasNext());
    entry = iterator.next();
    assertEquals(secondPayload, entry.payload());
    assertEquals(logName, entry.logName());
    assertEquals(ImmutableMap.of("key2", "value2"), entry.labels());
    assertEquals("cloudsql_database", entry.resource().type());
    assertEquals(Operation.of("operationId", "operationProducer"), entry.operation());
    assertEquals(Severity.DEFAULT, entry.severity());
    assertNull(entry.httpRequest());
    assertNotNull(entry.insertId());
    assertNotNull(entry.timestamp());
    page = logging().listLogEntries(EntryListOption.filter(filter),
        EntryListOption.sortOrder(SortingField.TIMESTAMP, SortingOrder.DESCENDING));
    iterator = page.iterateAll();
    Long lastTimestamp = iterator.next().timestamp();
    while (iterator.hasNext()) {
      assertTrue(iterator.next().timestamp() <= lastTimestamp);
    }
    logging().deleteLog(logName);
  }

  @Test
  public void testWriteAndListLogEntriesAsync() throws InterruptedException, ExecutionException {
    String logName = formatForTest("test-write-log-entries-async-log");
    String filter = "logName = projects/" + logging().options().projectId() + "/logs/" + logName;
    StringPayload firstPayload = StringPayload.of("stringPayload");
    LogEntry firstEntry = LogEntry.builder(firstPayload).severity(Severity.ALERT).build();
    ProtoPayload secondPayload =
        ProtoPayload.of(Any.pack(StringValue.newBuilder().setValue("protoPayload").build()));
    LogEntry secondEntry = LogEntry.builder(secondPayload).severity(Severity.DEBUG).build();
    logging().writeAsync(ImmutableList.of(firstEntry, secondEntry),
        WriteOption.labels(ImmutableMap.of("key1", "value1")),
        WriteOption.resource(MonitoredResource.builder("global").build()),
        WriteOption.logName(logName)).get();
    EntryListOption[] options = {EntryListOption.filter(filter), EntryListOption.pageSize(1)};
    AsyncPage<LogEntry> page = logging().listLogEntriesAsync(options).get();
    while (Iterators.size(page.iterateAll()) < 2) {
      Thread.sleep(500);
      page = logging().listLogEntriesAsync(options).get();
    }
    Iterator<LogEntry> iterator = page.iterateAll();
    assertTrue(iterator.hasNext());
    LogEntry entry = iterator.next();
    assertEquals(firstPayload, entry.payload());
    assertEquals(logName, entry.logName());
    assertEquals(ImmutableMap.of("key1", "value1"), entry.labels());
    assertEquals("global", entry.resource().type());
    assertNull(entry.httpRequest());
    assertEquals(Severity.ALERT, entry.severity());
    assertNull(entry.operation());
    assertNotNull(entry.insertId());
    assertNotNull(entry.timestamp());
    assertTrue(iterator.hasNext());
    entry = iterator.next();
    assertEquals(secondPayload, entry.payload());
    assertEquals(logName, entry.logName());
    assertEquals(ImmutableMap.of("key1", "value1"), entry.labels());
    assertEquals("global", entry.resource().type());
    assertNull(entry.operation());
    assertEquals(Severity.DEBUG, entry.severity());
    assertNull(entry.httpRequest());
    assertNotNull(entry.insertId());
    assertNotNull(entry.timestamp());
    logging().deleteLogAsync(logName).get();
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
    LoggingOptions options = logging().options();
    LoggingHandler handler = new LoggingHandler(logName, options);
    handler.setLevel(Level.INFO);
    Logger logger = Logger.getLogger(getClass().getName());
    logger.addHandler(handler);
    logger.setLevel(Level.INFO);
    logger.info("Message");
    Iterator<LogEntry> iterator =
        logging().listLogEntries(EntryListOption.filter("logName:" + logName)).iterateAll();
    while (!iterator.hasNext()) {
      Thread.sleep(500L);
      iterator =
          logging().listLogEntries(EntryListOption.filter("logName:" + logName)).iterateAll();
    }
    assertTrue(iterator.hasNext());
    LogEntry entry = iterator.next();
    assertTrue(entry.payload() instanceof StringPayload);
    assertTrue(entry.<StringPayload>payload().data().contains("Message"));
    assertEquals(logName, entry.logName());
    assertEquals(ImmutableMap.of("levelName", "INFO",
        "levelValue", String.valueOf(Level.INFO.intValue())), entry.labels());
    assertEquals("global", entry.resource().type());
    assertEquals(ImmutableMap.of("project_id", options.projectId()), entry.resource().labels());
    assertNull(entry.httpRequest());
    assertEquals(Severity.INFO, entry.severity());
    assertNull(entry.operation());
    assertNotNull(entry.insertId());
    assertNotNull(entry.timestamp());
    assertFalse(iterator.hasNext());
    logger.removeHandler(handler);
    logging().deleteLog(logName);
  }

  @Test
  public void testAsyncLoggingHandler() throws InterruptedException {
    String logName = formatForTest("test-async-logging-handler");
    LoggingOptions options = logging().options();
    MonitoredResource resource = MonitoredResource.of("gce_instance",
        ImmutableMap.of("project_id", options.projectId(),
            "instance_id", "instance",
            "zone", "us-central1-a"));
    LoggingHandler handler = new AsyncLoggingHandler(logName, options, resource);
    handler.setLevel(Level.WARNING);
    Logger logger = Logger.getLogger(getClass().getName());
    logger.addHandler(handler);
    logger.setLevel(Level.WARNING);
    logger.warning("Message");
    Iterator<LogEntry> iterator =
        logging().listLogEntries(EntryListOption.filter("logName:" + logName)).iterateAll();
    while (!iterator.hasNext()) {
      Thread.sleep(500L);
      iterator =
          logging().listLogEntries(EntryListOption.filter("logName:" + logName)).iterateAll();
    }
    assertTrue(iterator.hasNext());
    LogEntry entry = iterator.next();
    assertTrue(entry.payload() instanceof StringPayload);
    assertTrue(entry.<StringPayload>payload().data().contains("Message"));
    assertEquals(logName, entry.logName());
    assertEquals(ImmutableMap.of("levelName", "WARNING",
        "levelValue", String.valueOf(Level.WARNING.intValue())), entry.labels());
    assertEquals(resource, entry.resource());
    assertNull(entry.httpRequest());
    assertEquals(Severity.WARNING, entry.severity());
    assertNull(entry.operation());
    assertNotNull(entry.insertId());
    assertNotNull(entry.timestamp());
    assertFalse(iterator.hasNext());
    logger.removeHandler(handler);
    logging().deleteLog(logName);
  }
}
