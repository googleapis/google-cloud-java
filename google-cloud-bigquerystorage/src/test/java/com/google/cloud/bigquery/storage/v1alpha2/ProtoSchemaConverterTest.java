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
package com.google.cloud.bigquery.storage.v1alpha2;

import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.bigquery.storage.test.Test.*;
import org.junit.*;

public class ProtoSchemaConverterTest {
  @Test
  public void convertSimple() {
    AllSupportedTypes testProto = AllSupportedTypes.newBuilder().setStringValue("abc").build();
    ProtoBufProto.ProtoSchema protoSchema =
        ProtoSchemaConverter.convert(testProto.getDescriptorForType());
    Assert.assertEquals(
        "name: \"__S0\"\n"
            + "field {\n"
            + "  name: \"int32_value\"\n"
            + "  number: 1\n"
            + "  label: LABEL_OPTIONAL\n"
            + "  type: TYPE_INT32\n"
            + "}\n"
            + "field {\n"
            + "  name: \"int64_value\"\n"
            + "  number: 2\n"
            + "  label: LABEL_OPTIONAL\n"
            + "  type: TYPE_INT64\n"
            + "}\n"
            + "field {\n"
            + "  name: \"uint32_value\"\n"
            + "  number: 3\n"
            + "  label: LABEL_OPTIONAL\n"
            + "  type: TYPE_UINT32\n"
            + "}\n"
            + "field {\n"
            + "  name: \"uint64_value\"\n"
            + "  number: 4\n"
            + "  label: LABEL_OPTIONAL\n"
            + "  type: TYPE_UINT64\n"
            + "}\n"
            + "field {\n"
            + "  name: \"float_value\"\n"
            + "  number: 5\n"
            + "  label: LABEL_OPTIONAL\n"
            + "  type: TYPE_FLOAT\n"
            + "}\n"
            + "field {\n"
            + "  name: \"double_value\"\n"
            + "  number: 6\n"
            + "  label: LABEL_OPTIONAL\n"
            + "  type: TYPE_DOUBLE\n"
            + "}\n"
            + "field {\n"
            + "  name: \"bool_value\"\n"
            + "  number: 7\n"
            + "  label: LABEL_OPTIONAL\n"
            + "  type: TYPE_BOOL\n"
            + "}\n"
            + "field {\n"
            + "  name: \"enum_value\"\n"
            + "  number: 8\n"
            + "  label: LABEL_OPTIONAL\n"
            + "  type: TYPE_ENUM\n"
            + "  type_name: \"TestEnum\"\n"
            + "}\n"
            + "field {\n"
            + "  name: \"string_value\"\n"
            + "  number: 9\n"
            + "  label: LABEL_REQUIRED\n"
            + "  type: TYPE_STRING\n"
            + "}\n"
            + "enum_type {\n"
            + "  name: \"TestEnum\"\n"
            + "  value {\n"
            + "    name: \"TestEnum0\"\n"
            + "    number: 0\n"
            + "  }\n"
            + "  value {\n"
            + "    name: \"TestEnum1\"\n"
            + "    number: 1\n"
            + "  }\n"
            + "}\n",
        protoSchema.getProtoDescriptor().toString());
  }

  @Test
  public void convertNested() {
    ComplicateType testProto = ComplicateType.newBuilder().build();
    ProtoBufProto.ProtoSchema protoSchema =
        ProtoSchemaConverter.convert(testProto.getDescriptorForType());
    Assert.assertEquals(
        "name: \"__S0\"\n"
            + "field {\n"
            + "  name: \"nested_repeated_type\"\n"
            + "  number: 1\n"
            + "  label: LABEL_REPEATED\n"
            + "  type: TYPE_MESSAGE\n"
            + "  type_name: \"__S1\"\n"
            + "}\n"
            + "field {\n"
            + "  name: \"inner_type\"\n"
            + "  number: 2\n"
            + "  label: LABEL_OPTIONAL\n"
            + "  type: TYPE_MESSAGE\n"
            + "  type_name: \"__S3\"\n"
            + "}\n"
            + "nested_type {\n"
            + "  name: \"__S1\"\n"
            + "  field {\n"
            + "    name: \"inner_type\"\n"
            + "    number: 1\n"
            + "    label: LABEL_REPEATED\n"
            + "    type: TYPE_MESSAGE\n"
            + "    type_name: \"__S2\"\n"
            + "  }\n"
            + "  nested_type {\n"
            + "    name: \"__S2\"\n"
            + "    field {\n"
            + "      name: \"value\"\n"
            + "      number: 1\n"
            + "      label: LABEL_REPEATED\n"
            + "      type: TYPE_STRING\n"
            + "    }\n"
            + "  }\n"
            + "}\n"
            + "nested_type {\n"
            + "  name: \"__S3\"\n"
            + "  field {\n"
            + "    name: \"value\"\n"
            + "    number: 1\n"
            + "    label: LABEL_REPEATED\n"
            + "    type: TYPE_STRING\n"
            + "  }\n"
            + "}\n",
        protoSchema.getProtoDescriptor().toString());
  }

  @Test
  public void convertRecursive() {
    try {
      RecursiveType testProto = RecursiveType.newBuilder().build();
      ProtoBufProto.ProtoSchema protoSchema =
          ProtoSchemaConverter.convert(testProto.getDescriptorForType());
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
