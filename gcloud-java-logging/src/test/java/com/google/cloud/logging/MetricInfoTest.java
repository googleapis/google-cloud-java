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
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MetricInfoTest {

  private static final String NAME = "name";
  private static final String FILTER = "logName=projects/my-projectid/logs/syslog";
  private static final String DESCRIPTION = "description";
  private static final MetricInfo METRIC_INFO = MetricInfo.builder(NAME, FILTER)
      .description(DESCRIPTION)
      .build();

  @Test
  public void testOf() {
    MetricInfo metricInfo = MetricInfo.of(NAME, FILTER);
    assertEquals(NAME, metricInfo.name());
    assertEquals(FILTER, metricInfo.filter());
    assertNull(metricInfo.description());
  }

  @Test
  public void testBuilder() {
    assertEquals(NAME, METRIC_INFO.name());
    assertEquals(FILTER, METRIC_INFO.filter());
    assertEquals(DESCRIPTION, METRIC_INFO.description());
  }

  @Test
  public void testToBuilder() {
    compareMetricInfo(METRIC_INFO, METRIC_INFO.toBuilder().build());
    MetricInfo metricInfo = METRIC_INFO.toBuilder()
        .name("newName")
        .description("newDescription")
        .filter("logName=projects/my-projectid/logs/syslog")
        .build();
    assertEquals("newName", metricInfo.name());
    assertEquals("logName=projects/my-projectid/logs/syslog", metricInfo.filter());
    assertEquals("newDescription", metricInfo.description());
    metricInfo = metricInfo.toBuilder()
        .name(NAME)
        .description(DESCRIPTION)
        .filter(FILTER)
        .build();
    compareMetricInfo(METRIC_INFO, metricInfo);
  }

  @Test
  public void testToAndFromPb() {
    compareMetricInfo(METRIC_INFO, MetricInfo.fromPb(METRIC_INFO.toPb()));
    MetricInfo metricInfo = MetricInfo.of(NAME, FILTER);
    compareMetricInfo(metricInfo, MetricInfo.fromPb(metricInfo.toPb()));
  }

  private void compareMetricInfo(MetricInfo expected, MetricInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.name(), value.name());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.filter(), value.filter());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
