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

package com.google.cloud;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.util.Map;

public class MonitoredResourceTest {

  private static final String TYPE = "cloudsql_database";
  private static final Map<String, String> LABELS =
      ImmutableMap.of("dataset-id", "myDataset", "zone", "myZone");
  private static final MonitoredResource MONITORED_RESOURCE = MonitoredResource.builder(TYPE)
      .labels(LABELS)
      .build();

  @Test
  public void testBuilder() {
    assertEquals(TYPE, MONITORED_RESOURCE.type());
    assertEquals(LABELS, MONITORED_RESOURCE.labels());
    MonitoredResource monitoredResource = MonitoredResource.builder(TYPE)
        .addLabel("dataset-id", "myDataset")
        .addLabel("zone", "myZone")
        .build();
    assertEquals(TYPE, monitoredResource.type());
    assertEquals(LABELS, monitoredResource.labels());
    compareMonitoredResource(MONITORED_RESOURCE, monitoredResource);
    monitoredResource = MonitoredResource.builder(TYPE)
        .type("global")
        .addLabel("dataset-id", "myDataset")
        .addLabel("zone", "myZone")
        .clearLabels()
        .build();
    assertEquals("global", monitoredResource.type());
    assertEquals(ImmutableMap.of(), monitoredResource.labels());
  }

  @Test
  public void testToBuilder() {
    compareMonitoredResource(MONITORED_RESOURCE, MONITORED_RESOURCE.toBuilder().build());
    MonitoredResource monitoredResource = MONITORED_RESOURCE.toBuilder()
        .type("global")
        .clearLabels()
        .build();
    assertEquals("global", monitoredResource.type());
    assertEquals(ImmutableMap.of(), monitoredResource.labels());
    monitoredResource = monitoredResource.toBuilder()
        .type(TYPE)
        .labels(ImmutableMap.of("dataset-id", "myDataset"))
        .addLabel("zone", "myZone")
        .build();
    compareMonitoredResource(MONITORED_RESOURCE, monitoredResource);
  }

  @Test
  public void testOf() {
    MonitoredResource monitoredResource = MonitoredResource.of(TYPE, LABELS);
    assertEquals(TYPE, monitoredResource.type());
    assertEquals(LABELS, monitoredResource.labels());
    compareMonitoredResource(MONITORED_RESOURCE, monitoredResource);
  }

  @Test
  public void testToAndFromPb() {
    compareMonitoredResource(MONITORED_RESOURCE,
        MonitoredResource.fromPb(MONITORED_RESOURCE.toPb()));
    MonitoredResource monitoredResource =
        MonitoredResource.of(TYPE, ImmutableMap.<String, String>of());
    compareMonitoredResource(monitoredResource, MonitoredResource.fromPb(monitoredResource.toPb()));
  }

  private void compareMonitoredResource(MonitoredResource expected, MonitoredResource value) {
    assertEquals(expected, value);
    assertEquals(expected.type(), value.type());
    assertEquals(expected.labels(), value.labels());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
