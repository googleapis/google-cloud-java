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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.bigquery.storage.test.Test.*;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos.EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.Descriptors;
import org.junit.jupiter.api.Test;

public class ProtoSchemaConverterTest {
  @Test
  void convertSimple() {
    AllSupportedTypes testProto = AllSupportedTypes.newBuilder().setStringValue("abc").build();
    ProtoSchema protoSchema = ProtoSchemaConverter.convert(testProto.getDescriptorForType());
    assertEquals(
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
  void convertNested() {
    ComplicateType testProto = ComplicateType.newBuilder().build();
    ProtoSchema protoSchema = ProtoSchemaConverter.convert(testProto.getDescriptorForType());
    assertEquals(
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
  void convertRecursive() {
    RecursiveType testProto = RecursiveType.newBuilder().build();
    InvalidArgumentException e =
        assertThrows(
            InvalidArgumentException.class,
            () -> ProtoSchemaConverter.convert(testProto.getDescriptorForType()));
    assertEquals(
        "Recursive type is not supported:com.google.cloud.bigquery.storage.test.RecursiveType",
        e.getMessage());
  }

  @Test
  void convertRecursiveTopMessage() {
    RecursiveTypeTopMessage testProto = RecursiveTypeTopMessage.newBuilder().build();
    InvalidArgumentException e =
        assertThrows(
            InvalidArgumentException.class,
            () -> ProtoSchemaConverter.convert(testProto.getDescriptorForType()));
    assertEquals(
        "Recursive type is not"
            + " supported:com.google.cloud.bigquery.storage.test.RecursiveTypeTopMessage",
        e.getMessage());
  }

  @Test
  void convertSharedEnums() throws Descriptors.DescriptorValidationException {
    // Exercise sibling order, a deeper first reference, and root references in either order.
    for (int layout = 0; layout < 5; layout++) {
      EnumDescriptorProto sharedEnum =
          EnumDescriptorProto.newBuilder()
              .setName("Shared")
              .addValue(EnumValueDescriptorProto.newBuilder().setName("ZERO").setNumber(0))
              .addValue(EnumValueDescriptorProto.newBuilder().setName("ONE").setNumber(1))
              .build();
      FieldDescriptorProto enumField =
          FieldDescriptorProto.newBuilder()
              .setName("value")
              .setNumber(1)
              .setLabel(Label.LABEL_OPTIONAL)
              .setType(Type.TYPE_ENUM)
              .setTypeName(".Shared")
              .build();
      DescriptorProto first =
          DescriptorProto.newBuilder()
              .setName("First")
              .addField(enumField)
              .addField(enumField.toBuilder().setName("duplicate").setNumber(2))
              .build();
      DescriptorProto second = first.toBuilder().setName("Second").build();
      FieldDescriptorProto firstField =
          enumField.toBuilder()
              .setName("first")
              .setType(Type.TYPE_MESSAGE)
              .setTypeName(layout == 2 ? ".Deep" : ".First")
              .build();
      FieldDescriptorProto secondField =
          firstField.toBuilder().setName("second").setNumber(2).setTypeName(".Second").build();
      DescriptorProto.Builder root = DescriptorProto.newBuilder().setName("Root");
      FieldDescriptorProto rootEnumField = enumField.toBuilder().setNumber(3).build();
      if (layout == 3) {
        root.addField(rootEnumField);
      }
      root.addField(layout == 1 ? secondField : firstField);
      root.addField(layout == 1 ? firstField : secondField);
      if (layout == 4) {
        root.addField(rootEnumField);
      }
      // Equal value names in distinct enums must remain isolated by their wrappers.
      root.addField(enumField.toBuilder().setName("other").setNumber(4).setTypeName(".Other"));
      FileDescriptorProto source =
          FileDescriptorProto.newBuilder()
              .setName("source.proto")
              .addEnumType(sharedEnum)
              .addEnumType(sharedEnum.toBuilder().setName("Other"))
              .addMessageType(root)
              .addMessageType(first)
              .addMessageType(second)
              .addMessageType(
                  DescriptorProto.newBuilder()
                      .setName("Deep")
                      .addField(firstField.toBuilder().setTypeName(".First")))
              .build();
      Descriptors.Descriptor input =
          Descriptors.FileDescriptor.buildFrom(source, new Descriptors.FileDescriptor[0])
              .findMessageTypeByName("Root");
      ProtoSchema converted = ProtoSchemaConverter.convert(input);
      Descriptors.Descriptor result =
          Descriptors.FileDescriptor.buildFrom(
                  FileDescriptorProto.newBuilder()
                      .setName("converted.proto")
                      .addMessageType(converted.getProtoDescriptor())
                      .build(),
                  new Descriptors.FileDescriptor[0])
              .findMessageTypeByName("Root");
      Descriptors.EnumDescriptor resolved =
          result.findNestedTypeByName("Shared_E").findEnumTypeByName("Shared");
      assertEquals(sharedEnum.getValueList(), resolved.toProto().getValueList());
      assertEquals(
          2,
          result.getNestedTypes().stream().filter(type -> !type.getEnumTypes().isEmpty()).count());
      for (String childName : new String[] {"First", "Second"}) {
        Descriptors.Descriptor child = result.findNestedTypeByName(childName);
        assertEquals(0, child.getNestedTypes().size());
        for (Descriptors.FieldDescriptor field : child.getFields()) {
          assertSame(resolved, field.getEnumType());
        }
      }
      if (layout >= 3) {
        assertSame(resolved, result.findFieldByName("value").getEnumType());
      }
      Descriptors.EnumDescriptor other = result.findFieldByName("other").getEnumType();
      assertSame(result.findNestedTypeByName("Other_E"), other.getContainingType());
      assertEquals(sharedEnum.getValueList(), other.toProto().getValueList());
    }
  }

  @Test
  void convertDuplicateType() throws Descriptors.DescriptorValidationException {
    DuplicateType testProto = DuplicateType.newBuilder().build();
    ProtoSchema protoSchema = ProtoSchemaConverter.convert(testProto.getDescriptorForType());

    FileDescriptorProto fileDescriptorProto =
        FileDescriptorProto.newBuilder()
            .setName("foo.proto")
            .addMessageType(protoSchema.getProtoDescriptor())
            .build();
    Descriptors.FileDescriptor fs =
        Descriptors.FileDescriptor.buildFrom(
            fileDescriptorProto, new Descriptors.FileDescriptor[0]);
    Descriptors.Descriptor type =
        fs.findMessageTypeByName(protoSchema.getProtoDescriptor().getName());
    assertEquals(4, type.getFields().size());
  }
}
