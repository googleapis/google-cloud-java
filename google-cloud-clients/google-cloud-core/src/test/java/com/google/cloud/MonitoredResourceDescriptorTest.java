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
import static org.junit.Assert.assertNull;

import com.google.cloud.MonitoredResourceDescriptor.LabelDescriptor;
import com.google.cloud.MonitoredResourceDescriptor.LabelDescriptor.ValueType;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class MonitoredResourceDescriptorTest {

  private static final LabelDescriptor BOOLEAN_LABEL =
      new LabelDescriptor("booleanKey", ValueType.BOOL, "Boolean label");
  private static final LabelDescriptor STRING_LABEL =
      new LabelDescriptor("stringKey", ValueType.STRING, "String label");
  private static final LabelDescriptor INT_LABEL =
      new LabelDescriptor("intKey", ValueType.INT64, "Int label");
  private static final LabelDescriptor INT_LABEL_NO_DESCRIPTION =
      new LabelDescriptor("intKey", ValueType.INT64, null);
  private static final String TYPE = "resource_type";
  private static final String NAME = "resourceName";
  private static final String DISPLAY_NAME = "Display Name";
  private static final String DESCRIPTION = "Resource Descriptor";
  private static final List<LabelDescriptor> LABELS =
      ImmutableList.of(BOOLEAN_LABEL, STRING_LABEL, INT_LABEL);
  private static final MonitoredResourceDescriptor RESOURCE_DESCRIPTOR =
      MonitoredResourceDescriptor.newBuilder(TYPE)
          .setName(NAME)
          .setDisplayName(DISPLAY_NAME)
          .setDescription(DESCRIPTION)
          .setLabels(LABELS)
          .build();

  @Test
  public void testLabelDescriptor() {
    assertEquals("booleanKey", BOOLEAN_LABEL.getKey());
    assertEquals(ValueType.BOOL, BOOLEAN_LABEL.getValueType());
    assertEquals("Boolean label", BOOLEAN_LABEL.getDescription());
    assertEquals("stringKey", STRING_LABEL.getKey());
    assertEquals(ValueType.STRING, STRING_LABEL.getValueType());
    assertEquals("String label", STRING_LABEL.getDescription());
    assertEquals("intKey", INT_LABEL.getKey());
    assertEquals(ValueType.INT64, INT_LABEL.getValueType());
    assertEquals("Int label", INT_LABEL.getDescription());
    assertEquals("intKey", INT_LABEL_NO_DESCRIPTION.getKey());
    assertEquals(ValueType.INT64, INT_LABEL_NO_DESCRIPTION.getValueType());
    assertNull(INT_LABEL_NO_DESCRIPTION.getDescription());
  }

  @Test
  public void testBuilder() {
    assertEquals(TYPE, RESOURCE_DESCRIPTOR.getType());
    assertEquals(NAME, RESOURCE_DESCRIPTOR.getName());
    assertEquals(DISPLAY_NAME, RESOURCE_DESCRIPTOR.getDisplayName());
    assertEquals(DESCRIPTION, RESOURCE_DESCRIPTOR.getDescription());
    assertEquals(LABELS, RESOURCE_DESCRIPTOR.getLabels());
    MonitoredResourceDescriptor resourceDescriptor =
        MonitoredResourceDescriptor.newBuilder(TYPE).build();
    assertEquals(TYPE, resourceDescriptor.getType());
    assertNull(resourceDescriptor.getName());
    assertNull(resourceDescriptor.getDisplayName());
    assertNull(resourceDescriptor.getDescription());
    assertEquals(ImmutableList.of(), resourceDescriptor.getLabels());
  }

  @Test
  public void testToAndFromPbLabelDescriptor() {
    compareLabelDescriptor(BOOLEAN_LABEL, LabelDescriptor.fromPb(BOOLEAN_LABEL.toPb()));
    compareLabelDescriptor(STRING_LABEL, LabelDescriptor.fromPb(STRING_LABEL.toPb()));
    compareLabelDescriptor(INT_LABEL, LabelDescriptor.fromPb(INT_LABEL.toPb()));
    compareLabelDescriptor(
        INT_LABEL_NO_DESCRIPTION, LabelDescriptor.fromPb(INT_LABEL_NO_DESCRIPTION.toPb()));
  }

  @Test
  public void testToAndFromPb() {
    compareResourceDescriptor(
        RESOURCE_DESCRIPTOR, MonitoredResourceDescriptor.fromPb(RESOURCE_DESCRIPTOR.toPb()));
    MonitoredResourceDescriptor resourceDescriptor =
        MonitoredResourceDescriptor.newBuilder(TYPE).build();
    compareResourceDescriptor(
        resourceDescriptor, MonitoredResourceDescriptor.fromPb(resourceDescriptor.toPb()));
  }

  private void compareLabelDescriptor(LabelDescriptor expected, LabelDescriptor value) {
    assertEquals(expected, value);
    assertEquals(expected.getKey(), value.getKey());
    assertEquals(expected.getValueType(), value.getValueType());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }

  private void compareResourceDescriptor(
      MonitoredResourceDescriptor expected, MonitoredResourceDescriptor value) {
    assertEquals(expected, value);
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getDisplayName(), value.getDisplayName());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getLabels(), value.getLabels());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
