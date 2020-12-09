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
package com.google.cloud.bigquery.storage.v1beta2;

import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.bigquery.storage.test.Test.*;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.Descriptors;
import org.junit.*;

public class ProtoSchemaConverterTest {
  @Test
  public void convertSimple() {
    AllSupportedTypes testProto = AllSupportedTypes.newBuilder().setStringValue("abc").build();
    ProtoSchema protoSchema = ProtoSchemaConverter.convert(testProto.getDescriptorForType());
    Assert.assertEquals(
        "name: \"com_google_cloud_bigquery_storage_test_AllSupportedTypes\"\n"
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
            + "  type_name: \"com_google_cloud_bigquery_storage_test_TestEnum_E.TestEnum\"\n"
            + "}\n"
            + "field {\n"
            + "  name: \"string_value\"\n"
            + "  number: 9\n"
            + "  label: LABEL_REQUIRED\n"
            + "  type: TYPE_STRING\n"
            + "}\n"
            + "nested_type {\n"
            + "  name: \"com_google_cloud_bigquery_storage_test_TestEnum_E\"\n"
            + "  enum_type {\n"
            + "    name: \"TestEnum\"\n"
            + "    value {\n"
            + "      name: \"TestEnum0\"\n"
            + "      number: 0\n"
            + "    }\n"
            + "    value {\n"
            + "      name: \"TestEnum1\"\n"
            + "      number: 1\n"
            + "    }\n"
            + "  }\n"
            + "}\n",
        protoSchema.getProtoDescriptor().toString());
  }

  @Test
  public void convertNested() {
    ComplicateType testProto = ComplicateType.newBuilder().build();
    ProtoSchema protoSchema = ProtoSchemaConverter.convert(testProto.getDescriptorForType());
    Assert.assertEquals(
        "name: \"com_google_cloud_bigquery_storage_test_ComplicateType\"\n"
            + "field {\n"
            + "  name: \"nested_repeated_type\"\n"
            + "  number: 1\n"
            + "  label: LABEL_REPEATED\n"
            + "  type: TYPE_MESSAGE\n"
            + "  type_name: \"com_google_cloud_bigquery_storage_test_NestedType\"\n"
            + "}\n"
            + "field {\n"
            + "  name: \"inner_type\"\n"
            + "  number: 2\n"
            + "  label: LABEL_OPTIONAL\n"
            + "  type: TYPE_MESSAGE\n"
            + "  type_name: \"com_google_cloud_bigquery_storage_test_InnerType\"\n"
            + "}\n"
            + "nested_type {\n"
            + "  name: \"com_google_cloud_bigquery_storage_test_InnerType\"\n"
            + "  field {\n"
            + "    name: \"value\"\n"
            + "    number: 1\n"
            + "    label: LABEL_REPEATED\n"
            + "    type: TYPE_STRING\n"
            + "  }\n"
            + "}\n"
            + "nested_type {\n"
            + "  name: \"com_google_cloud_bigquery_storage_test_NestedType\"\n"
            + "  field {\n"
            + "    name: \"inner_type\"\n"
            + "    number: 1\n"
            + "    label: LABEL_REPEATED\n"
            + "    type: TYPE_MESSAGE\n"
            + "    type_name: \"com_google_cloud_bigquery_storage_test_InnerType\"\n"
            + "  }\n"
            + "}\n",
        protoSchema.getProtoDescriptor().toString());
  }

  @Test
  public void convertRecursive() {
    try {
      RecursiveType testProto = RecursiveType.newBuilder().build();
      ProtoSchema protoSchema = ProtoSchemaConverter.convert(testProto.getDescriptorForType());
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      Assert.assertEquals(
          "Recursive type is not supported:com.google.cloud.bigquery.storage.test.RecursiveType",
          e.getMessage());
    }
  }

  @Test
  public void convertRecursiveTopMessage() {
    try {
      RecursiveTypeTopMessage testProto = RecursiveTypeTopMessage.newBuilder().build();
      ProtoSchema protoSchema = ProtoSchemaConverter.convert(testProto.getDescriptorForType());
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      Assert.assertEquals(
          "Recursive type is not supported:com.google.cloud.bigquery.storage.test.RecursiveTypeTopMessage",
          e.getMessage());
    }
  }

  @Test
  public void convertDuplicateType() {
    DuplicateType testProto = DuplicateType.newBuilder().build();
    ProtoSchema protoSchema = ProtoSchemaConverter.convert(testProto.getDescriptorForType());

    FileDescriptorProto fileDescriptorProto =
        FileDescriptorProto.newBuilder()
            .setName("foo.proto")
            .addMessageType(protoSchema.getProtoDescriptor())
            .build();
    try {
      Descriptors.FileDescriptor fs =
          Descriptors.FileDescriptor.buildFrom(
              fileDescriptorProto, new Descriptors.FileDescriptor[0]);
      Descriptors.Descriptor type =
          fs.findMessageTypeByName(protoSchema.getProtoDescriptor().getName());
      Assert.assertEquals(4, type.getFields().size());
    } catch (Descriptors.DescriptorValidationException ex) {
      Assert.fail("Got unexpected exception: " + ex.getMessage());
    }
  }
}
