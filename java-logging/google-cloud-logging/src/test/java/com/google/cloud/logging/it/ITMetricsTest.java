/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.logging.it;

import static com.google.cloud.logging.testing.RemoteLoggingHelper.formatForTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.paging.Page;
import com.google.cloud.MonitoredResourceDescriptor;
import com.google.cloud.logging.BaseSystemTest;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Metric;
import com.google.cloud.logging.MetricInfo;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("Preventing temporary RESOURCE_EXHAUSTED problems")
public class ITMetricsTest extends BaseSystemTest {

  @Test
  public void testListMonitoredResourceDescriptors() {
    Iterator<MonitoredResourceDescriptor> iterator =
        logging
            .listMonitoredResourceDescriptors(Logging.ListOption.pageSize(100))
            .iterateAll()
            .iterator();
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
    MetricInfo metricInfo =
        MetricInfo.newBuilder(name, "severity>=ERROR").setDescription("description").build();
    Metric metric = logging.create(metricInfo);
    assertEquals(name, metric.getName());
    assertEquals("severity>=ERROR", metric.getFilter());
    assertEquals("description", metric.getDescription());
    assertEquals(metric, logging.getMetric(name));
    metric =
        metric.toBuilder()
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
    MetricInfo metricInfo =
        MetricInfo.newBuilder(name, "severity>=ERROR").setDescription("description").build();
    assertNull(logging.getMetric(name));
    Metric metric = logging.update(metricInfo);
    assertEquals(name, metric.getName());
    assertEquals("severity>=ERROR", metric.getFilter());
    assertEquals("description", metric.getDescription());
    assertTrue(metric.delete());
  }

  @Test
  public void testListMetrics() throws InterruptedException {
    String firstName = formatForTest("test-list-metrics-1");
    String secondName = formatForTest("test-list-metrics-2");
    Metric firstMetric = logging.create(MetricInfo.of(firstName, "severity>=ERROR"));
    Metric secondMetric = logging.create(MetricInfo.of(secondName, "severity>=ERROR"));
    Logging.ListOption[] options = {Logging.ListOption.pageSize(1)};
    Page<Metric> metricPage = logging.listMetrics(options);
    Set<Metric> metrics = Sets.newHashSet(metricPage.iterateAll());
    while (!metrics.contains(firstMetric) || !metrics.contains(secondMetric)) {
      Thread.sleep(500);
      metrics = Sets.newHashSet(logging.listMetrics(options).iterateAll());
    }
    firstMetric.delete();
    secondMetric.delete();
  }
}
