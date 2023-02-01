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

package com.google.cloud;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import org.junit.Test;

public class MonitoredResourceTest {

  private static final String TYPE = "cloudsql_database";
  private static final Map<String, String> LABELS =
      ImmutableMap.of("dataset-id", "myDataset", "zone", "myZone");
  private static final MonitoredResource MONITORED_RESOURCE =
      MonitoredResource.newBuilder(TYPE).setLabels(LABELS).build();

  @Test
  public void testBuilder() {
    assertEquals(TYPE, MONITORED_RESOURCE.getType());
    assertEquals(LABELS, MONITORED_RESOURCE.getLabels());
    MonitoredResource monitoredResource =
        MonitoredResource.newBuilder(TYPE)
            .addLabel("dataset-id", "myDataset")
            .addLabel("zone", "myZone")
            .build();
    assertEquals(TYPE, monitoredResource.getType());
    assertEquals(LABELS, monitoredResource.getLabels());
    compareMonitoredResource(MONITORED_RESOURCE, monitoredResource);
    monitoredResource =
        MonitoredResource.newBuilder(TYPE)
            .setType("global")
            .addLabel("dataset-id", "myDataset")
            .addLabel("zone", "myZone")
            .clearLabels()
            .build();
    assertEquals("global", monitoredResource.getType());
    assertEquals(ImmutableMap.of(), monitoredResource.getLabels());
  }

  @Test
  public void testToBuilder() {
    compareMonitoredResource(MONITORED_RESOURCE, MONITORED_RESOURCE.toBuilder().build());
    MonitoredResource monitoredResource =
        MONITORED_RESOURCE.toBuilder().setType("global").clearLabels().build();
    assertEquals("global", monitoredResource.getType());
    assertEquals(ImmutableMap.of(), monitoredResource.getLabels());
    monitoredResource =
        monitoredResource
            .toBuilder()
            .setType(TYPE)
            .setLabels(ImmutableMap.of("dataset-id", "myDataset"))
            .addLabel("zone", "myZone")
            .build();
    compareMonitoredResource(MONITORED_RESOURCE, monitoredResource);
  }

  @Test
  public void testOf() {
    MonitoredResource monitoredResource = MonitoredResource.of(TYPE, LABELS);
    assertEquals(TYPE, monitoredResource.getType());
    assertEquals(LABELS, monitoredResource.getLabels());
    compareMonitoredResource(MONITORED_RESOURCE, monitoredResource);
  }

  @Test
  public void testToAndFromPb() {
    compareMonitoredResource(
        MONITORED_RESOURCE, MonitoredResource.fromPb(MONITORED_RESOURCE.toPb()));
    MonitoredResource monitoredResource =
        MonitoredResource.of(TYPE, ImmutableMap.<String, String>of());
    compareMonitoredResource(monitoredResource, MonitoredResource.fromPb(monitoredResource.toPb()));
  }

  private void compareMonitoredResource(MonitoredResource expected, MonitoredResource value) {
    assertEquals(expected, value);
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.getLabels(), value.getLabels());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
