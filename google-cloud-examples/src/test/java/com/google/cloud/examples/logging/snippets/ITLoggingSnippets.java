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

package com.google.cloud.examples.logging.snippets;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.MonitoredResourceDescriptor;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Metric;
import com.google.cloud.logging.Sink;
import com.google.cloud.logging.testing.RemoteLoggingHelper;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class ITLoggingSnippets {

  private static final String DATASET = "dataset";

  private static Logging logging;
  private static LoggingSnippets loggingSnippets;

  @Rule public Timeout globalTimeout = Timeout.seconds(300);

  @Rule public ExpectedException thrown = ExpectedException.none();

  @BeforeClass
  public static void beforeClass() {
    RemoteLoggingHelper helper = RemoteLoggingHelper.create();
    logging = helper.getOptions().getService();
    loggingSnippets = new LoggingSnippets(logging);
  }

  @AfterClass
  public static void afterClass() throws Exception {
    if (logging != null) {
      logging.close();
    }
  }

  @Test
  public void testSink() throws ExecutionException, InterruptedException {
    String sinkName1 = RemoteLoggingHelper.formatForTest("sink_name1");
    String sinkName2 = RemoteLoggingHelper.formatForTest("sink_name2");
    Sink sink1 = loggingSnippets.createSink(sinkName1, DATASET);
    Sink sink2 = loggingSnippets.createSinkAsync(sinkName2, DATASET);
    assertNotNull(sink1);
    assertNotNull(sink2);
    sink1 = loggingSnippets.getSink(sinkName1);
    sink2 = loggingSnippets.getSinkAsync(sinkName2);
    assertNotNull(sink1);
    assertNotNull(sink2);
    sink1 = loggingSnippets.updateSink(sinkName1, DATASET);
    sink2 = loggingSnippets.updateSinkAsync(sinkName2, DATASET);
    Set<Sink> sinks = Sets.newHashSet(loggingSnippets.listSinks().iterateAll());
    while (!sinks.contains(sink1) || !sinks.contains(sink2)) {
      Thread.sleep(500);
      sinks = Sets.newHashSet(loggingSnippets.listSinks().iterateAll());
    }
    sinks = Sets.newHashSet(loggingSnippets.listSinksAsync().iterateAll());
    while (!sinks.contains(sink1) || !sinks.contains(sink2)) {
      Thread.sleep(500);
      sinks = Sets.newHashSet(loggingSnippets.listSinksAsync().iterateAll());
    }
    assertTrue(loggingSnippets.deleteSink(sinkName1));
    assertTrue(loggingSnippets.deleteSinkAsync(sinkName2));
  }

  @Test
  public void testMetric() throws ExecutionException, InterruptedException {
    String metricName1 = RemoteLoggingHelper.formatForTest("metric_name1");
    String metricName2 = RemoteLoggingHelper.formatForTest("metric_name2");
    Metric metric1 = loggingSnippets.createMetric(metricName1);
    Metric metric2 = loggingSnippets.createMetricAsync(metricName2);
    assertNotNull(metric1);
    assertNotNull(metric2);
    metric1 = loggingSnippets.getMetric(metricName1);
    metric2 = loggingSnippets.getMetricAsync(metricName2);
    assertNotNull(metric1);
    assertNotNull(metric2);
    metric1 = loggingSnippets.updateMetric(metricName1);
    metric2 = loggingSnippets.updateMetricAsync(metricName2);
    Set<Metric> metrics = Sets.newHashSet(loggingSnippets.listMetrics().iterateAll());
    while (!metrics.contains(metric1) || !metrics.contains(metric2)) {
      Thread.sleep(500);
      metrics = Sets.newHashSet(loggingSnippets.listMetrics().iterateAll());
    }
    metrics = Sets.newHashSet(loggingSnippets.listMetricsAsync().iterateAll());
    while (!metrics.contains(metric1) || !metrics.contains(metric2)) {
      Thread.sleep(500);
      metrics = Sets.newHashSet(loggingSnippets.listMetricsAsync().iterateAll());
    }
    assertTrue(loggingSnippets.deleteMetric(metricName1));
    assertTrue(loggingSnippets.deleteMetricAsync(metricName2));
  }

  @Test
  public void testMonitoredResourceDescriptor() throws ExecutionException, InterruptedException {
    Iterator<MonitoredResourceDescriptor> iterator =
        loggingSnippets.listMonitoredResourceDescriptors().iterateAll().iterator();
    int count = 0;
    while (iterator.hasNext()) {
      assertNotNull(iterator.next().getType());
      count += 1;
    }
    assertTrue(count > 0);
    iterator = loggingSnippets.listMonitoredResourceDescriptorsAsync().iterateAll().iterator();
    count = 0;
    while (iterator.hasNext()) {
      assertNotNull(iterator.next().getType());
      count += 1;
    }
    assertTrue(count > 0);
  }

  @Test
  public void testWriteAndListLogEntries() throws InterruptedException {
    String logName = RemoteLoggingHelper.formatForTest("log_name");
    String filter = "logName=projects/" + logging.getOptions().getProjectId() + "/logs/" + logName;
    loggingSnippets.write(logName);
    Iterator<LogEntry> iterator = loggingSnippets.listLogEntries(filter).iterateAll().iterator();
    while (Iterators.size(iterator) < 2) {
      Thread.sleep(500);
      iterator = loggingSnippets.listLogEntries(filter).iterateAll().iterator();
    }
    assertTrue(loggingSnippets.deleteLog(logName));
  }

  @Test
  public void testWriteAndListLogEntriesAsync() throws ExecutionException, InterruptedException {
    String logName = RemoteLoggingHelper.formatForTest("log_name");
    String filter = "logName=projects/" + logging.getOptions().getProjectId() + "/logs/" + logName;
    loggingSnippets.write(logName);
    // flush all pending asynchronous writes
    logging.flush();
    Iterator<LogEntry> iterator =
        loggingSnippets.listLogEntriesAsync(filter).iterateAll().iterator();
    while (Iterators.size(iterator) < 2) {
      Thread.sleep(500);
      iterator = loggingSnippets.listLogEntriesAsync(filter).iterateAll().iterator();
    }
    assertTrue(loggingSnippets.deleteLogAsync(logName));
  }
}
