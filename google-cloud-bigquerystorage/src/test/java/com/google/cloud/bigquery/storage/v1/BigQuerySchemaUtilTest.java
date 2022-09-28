/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.storage.v1;

import com.google.cloud.bigquery.storage.test.SchemaTest.TestNestedFlexibleFieldName;
import com.google.protobuf.Descriptors.Descriptor;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BigQuerySchemaUtilTest extends TestCase {

  @Test
  public void testIsProtoCompatible() {
    List<String> protoCompatibleNames = Arrays.asList("col_1", "name", "_0_");
    List<String> protoIncompatibleNames = Arrays.asList("0_col", "()", "列", "a-1");
    protoCompatibleNames.stream()
        .forEach(
            name -> {
              assertTrue(BigQuerySchemaUtil.isProtoCompatible(name));
            });
    protoIncompatibleNames.stream()
        .forEach(
            name -> {
              assertFalse(BigQuerySchemaUtil.isProtoCompatible(name));
            });
  }

  public void testGeneratePlaceholderFieldName() {
    assertEquals("col_c3RyLeWIlw", BigQuerySchemaUtil.generatePlaceholderFieldName("str-列"));
    // Base64 url encodes "~/~/" to "fi9-Lw", we replaced - with _ to be proto compatible.
    assertEquals("col_fi9_Lw", BigQuerySchemaUtil.generatePlaceholderFieldName("~/~/"));
  }

  public void testGetFieldName() {
    // Test get name from annotations.
    Descriptor flexibleDescriptor = TestNestedFlexibleFieldName.getDescriptor();
    assertEquals("str-列", BigQuerySchemaUtil.getFieldName(flexibleDescriptor.getFields().get(0)));
    assertEquals(
        "nested-列", BigQuerySchemaUtil.getFieldName(flexibleDescriptor.getFields().get(1)));

    // Test get name without annotations.
    Descriptor descriptor = TestNestedFlexibleFieldName.getDescriptor();
    assertEquals("int32_value", BigQuerySchemaUtil.getFieldName(descriptor.getFields().get(0)));
    assertEquals("int64_value", BigQuerySchemaUtil.getFieldName(descriptor.getFields().get(1)));
  }
}
