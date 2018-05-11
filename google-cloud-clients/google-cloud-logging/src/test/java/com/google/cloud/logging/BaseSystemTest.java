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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.paging.Page;
import com.google.cloud.MonitoredResource;
import com.google.cloud.MonitoredResourceDescriptor;
import com.google.cloud.logging.Logging.EntryListOption;
import com.google.cloud.logging.Logging.SortingField;
import com.google.cloud.logging.Logging.SortingOrder;
import com.google.cloud.logging.Payload.JsonPayload;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.cloud.logging.SinkInfo.Destination.DatasetDestination;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.logging.v2.LogName;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.logging.v2.ProjectLogName;
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

  /**
   * Creates an equality expression for logging filter.
   *
   * @see <a href="https://cloud.google.com/logging/docs/view/advanced_filters">Advanced Logs
   *     Filters Documentation</a>
   */
  static <V> String createEqualityFilter(String name, V value) {
    return name + " = " + "\"" + value.toString() + "\"";
  }

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
  public void testUpdateNonExistingSink() {
    String name = formatForTest("test-update-non-existing-sink");
    SinkInfo sinkInfo = SinkInfo.newBuilder(name, DatasetDestination.of("dataset"))
        .setFilter("severity>=ERROR")
        .setVersionFormat(SinkInfo.VersionFormat.V2)
        .build();
    assertNull(logging().getSink(name));
    thrown.expect(LoggingException.class);
    thrown.expectMessage("NOT_FOUND");
    logging().update(sinkInfo);
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
  public void testListMonitoredResourceDescriptors() {
    Iterator<MonitoredResourceDescriptor> iterator =
        logging().listMonitoredResourceDescriptors(Logging.ListOption.pageSize(100)).iterateAll().iterator();
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
  public void testWriteAndListLogEntries() throws InterruptedException {
    String logId = formatForTest("test-write-log-entries-log");
    LoggingOptions loggingOptions = logging().getOptions();
    LogName logName = ProjectLogName.of(loggingOptions.getProjectId(), logId);
    StringPayload firstPayload = StringPayload.of("stringPayload");
    LogEntry firstEntry = LogEntry.newBuilder(firstPayload)
        .addLabel("key1", "value1")
        .setLogName(logId)
        .setHttpRequest(HttpRequest.newBuilder().setStatus(500).build())
        .setResource(MonitoredResource.newBuilder("global").build())
        .build();
    JsonPayload secondPayload =
        JsonPayload.of(ImmutableMap.<String, Object>of("jsonKey", "jsonValue"));
    LogEntry secondEntry = LogEntry.newBuilder(secondPayload)
        .addLabel("key2", "value2")
        .setLogName(logId)
        .setOperation(Operation.of("operationId", "operationProducer"))
        .setResource(MonitoredResource.newBuilder("cloudsql_database").build())
        .build();
    logging().write(ImmutableList.of(firstEntry));
    logging().write(ImmutableList.of(secondEntry));
    String filter = createEqualityFilter("logName", logName);
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
    assertEquals(logId, entry.getLogName());
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
    assertEquals(logId, entry.getLogName());
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
    int deleteAttempts = 0;
    int allowedDeleteAttempts = 5;
    boolean deleted = false;
    while (!deleted && deleteAttempts < allowedDeleteAttempts) {
      Thread.sleep(1000);
      deleted = logging().deleteLog(logId);
      deleteAttempts++;
    }
    assertTrue(deleted);
  }

  @Test
  public void testDeleteNonExistingLog() {
    String logId = formatForTest("test-delete-non-existing-log");
    assertFalse(logging().deleteLog(logId));
  }

  @Test
  public void testLoggingHandler() throws InterruptedException {
    String logId = formatForTest("test-logging-handler");
    LoggingOptions options = logging().getOptions();
    LogName logName = ProjectLogName.of(options.getProjectId(), logId);
    LoggingHandler handler = new LoggingHandler(logId, options);
    handler.setLevel(Level.INFO);
    Logger logger = Logger.getLogger(getClass().getName());
    logger.addHandler(handler);
    logger.setLevel(Level.INFO);
    logger.info("Message");
    String filter = createEqualityFilter("logName", logName);
    Iterator<LogEntry> iterator =
        logging().listLogEntries(EntryListOption.filter(filter)).iterateAll().iterator();
    while (!iterator.hasNext()) {
      Thread.sleep(500L);
      iterator =
          logging().listLogEntries(EntryListOption.filter(filter)).iterateAll().iterator();
    }
    assertTrue(iterator.hasNext());
    LogEntry entry = iterator.next();
    assertTrue(entry.getPayload() instanceof StringPayload);
    assertTrue(entry.<StringPayload>getPayload().getData().contains("Message"));
    assertEquals(logId, entry.getLogName());
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
    logging().deleteLog(logId);
  }

  @Test
  public void testSyncLoggingHandler() throws InterruptedException {
    String logId = formatForTest("test-sync-logging-handler");
    LoggingOptions options = logging().getOptions();
    LogName logName = ProjectLogName.of(options.getProjectId(), logId);
    MonitoredResource resource = MonitoredResource.of("gce_instance",
        ImmutableMap.of("project_id", options.getProjectId(),
            "instance_id", "instance",
            "zone", "us-central1-a"));
    LoggingHandler handler = new LoggingHandler(logId, options, resource);
    handler.setLevel(Level.WARNING);
    handler.setSynchronicity(Synchronicity.SYNC);
    Logger logger = Logger.getLogger(getClass().getName());
    logger.addHandler(handler);
    logger.setLevel(Level.WARNING);
    logger.warning("Message");
    String filter = createEqualityFilter("logName", logName);
    Iterator<LogEntry> iterator =
        logging().listLogEntries(EntryListOption.filter(filter)).iterateAll().iterator();
    while (!iterator.hasNext()) {
      Thread.sleep(500L);
      iterator =
          logging().listLogEntries(EntryListOption.filter(filter)).iterateAll().iterator();
    }
    assertTrue(iterator.hasNext());
    LogEntry entry = iterator.next();
    assertTrue(entry.getPayload() instanceof StringPayload);
    assertTrue(entry.<StringPayload>getPayload().getData().contains("Message"));
    assertEquals(logId, entry.getLogName());
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
    logging().deleteLog(logId);
  }
}
