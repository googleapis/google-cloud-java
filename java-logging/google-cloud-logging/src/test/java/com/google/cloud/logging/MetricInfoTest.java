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
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MetricInfoTest {

  private static final String NAME = "name";
  private static final String FILTER = "logName=projects/my-projectid/logs/syslog";
  private static final String DESCRIPTION = "description";
  private static final String NEW_NAME = "newName";
  private static final String NEW_FILTER = "logName=projects/my-projectid/logs/newSyslog";
  private static final String NEW_DESCRIPTION = "newDescription";
  private static final MetricInfo METRIC_INFO =
      MetricInfo.newBuilder(NAME, FILTER).setDescription(DESCRIPTION).build();

  @Test
  public void testOf() {
    MetricInfo metricInfo = MetricInfo.of(NAME, FILTER);
    assertEquals(NAME, metricInfo.getName());
    assertEquals(FILTER, metricInfo.getFilter());
    assertNull(metricInfo.getDescription());
  }

  @Test
  public void testBuilder() {
    assertEquals(NAME, METRIC_INFO.getName());
    assertEquals(FILTER, METRIC_INFO.getFilter());
    assertEquals(DESCRIPTION, METRIC_INFO.getDescription());
  }

  @Test
  public void testToBuilder() {
    compareMetricInfo(METRIC_INFO, METRIC_INFO.toBuilder().build());
    MetricInfo metricInfo =
        METRIC_INFO.toBuilder()
            .setName(NEW_NAME)
            .setDescription(NEW_DESCRIPTION)
            .setFilter(NEW_FILTER)
            .build();
    assertEquals(NEW_NAME, metricInfo.getName());
    assertEquals(NEW_FILTER, metricInfo.getFilter());
    assertEquals(NEW_DESCRIPTION, metricInfo.getDescription());
    metricInfo =
        metricInfo.toBuilder().setName(NAME).setDescription(DESCRIPTION).setFilter(FILTER).build();
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
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getFilter(), value.getFilter());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
