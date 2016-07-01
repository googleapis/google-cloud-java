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
import static org.junit.Assert.assertNull;

import com.google.cloud.MonitoredResourceDescriptor.LabelDescriptor;
import com.google.cloud.MonitoredResourceDescriptor.LabelDescriptor.ValueType;
import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

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
      MonitoredResourceDescriptor.builder(TYPE)
          .name(NAME)
          .displayName(DISPLAY_NAME)
          .description(DESCRIPTION)
          .labels(LABELS)
          .build();

  @Test
  public void testLabelDescriptor() {
    assertEquals("booleanKey", BOOLEAN_LABEL.key());
    assertEquals(ValueType.BOOL, BOOLEAN_LABEL.valueType());
    assertEquals("Boolean label", BOOLEAN_LABEL.description());
    assertEquals("stringKey", STRING_LABEL.key());
    assertEquals(ValueType.STRING, STRING_LABEL.valueType());
    assertEquals("String label", STRING_LABEL.description());
    assertEquals("intKey", INT_LABEL.key());
    assertEquals(ValueType.INT64, INT_LABEL.valueType());
    assertEquals("Int label", INT_LABEL.description());
    assertEquals("intKey", INT_LABEL_NO_DESCRIPTION.key());
    assertEquals(ValueType.INT64, INT_LABEL_NO_DESCRIPTION.valueType());
    assertNull(INT_LABEL_NO_DESCRIPTION.description());
  }

  @Test
  public void testBuilder() {
    assertEquals(TYPE, RESOURCE_DESCRIPTOR.type());
    assertEquals(NAME, RESOURCE_DESCRIPTOR.name());
    assertEquals(DISPLAY_NAME, RESOURCE_DESCRIPTOR.displayName());
    assertEquals(DESCRIPTION, RESOURCE_DESCRIPTOR.description());
    assertEquals(LABELS, RESOURCE_DESCRIPTOR.labels());
    MonitoredResourceDescriptor resourceDescriptor =
        MonitoredResourceDescriptor.builder(TYPE).build();
    assertEquals(TYPE, resourceDescriptor.type());
    assertNull(resourceDescriptor.name());
    assertNull(resourceDescriptor.displayName());
    assertNull(resourceDescriptor.description());
    assertEquals(ImmutableList.of(), resourceDescriptor.labels());
  }


  @Test
  public void testToAndFromPbLabelDescriptor() {
    compareLabelDescriptor(BOOLEAN_LABEL, LabelDescriptor.fromPb(BOOLEAN_LABEL.toPb()));
    compareLabelDescriptor(STRING_LABEL, LabelDescriptor.fromPb(STRING_LABEL.toPb()));
    compareLabelDescriptor(INT_LABEL, LabelDescriptor.fromPb(INT_LABEL.toPb()));
    compareLabelDescriptor(INT_LABEL_NO_DESCRIPTION,
        LabelDescriptor.fromPb(INT_LABEL_NO_DESCRIPTION.toPb()));
  }

  @Test
  public void testToAndFromPb() {
    compareResourceDescriptor(RESOURCE_DESCRIPTOR,
        MonitoredResourceDescriptor.fromPb(RESOURCE_DESCRIPTOR.toPb()));
    MonitoredResourceDescriptor resourceDescriptor =
        MonitoredResourceDescriptor.builder(TYPE).build();
    compareResourceDescriptor(resourceDescriptor,
        MonitoredResourceDescriptor.fromPb(resourceDescriptor.toPb()));
  }

  private void compareLabelDescriptor(LabelDescriptor expected, LabelDescriptor value) {
    assertEquals(expected, value);
    assertEquals(expected.key(), value.key());
    assertEquals(expected.valueType(), value.valueType());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }

  private void compareResourceDescriptor(MonitoredResourceDescriptor expected,
      MonitoredResourceDescriptor value) {
    assertEquals(expected, value);
    assertEquals(expected.type(), value.type());
    assertEquals(expected.name(), value.name());
    assertEquals(expected.displayName(), value.displayName());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.labels(), value.labels());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
