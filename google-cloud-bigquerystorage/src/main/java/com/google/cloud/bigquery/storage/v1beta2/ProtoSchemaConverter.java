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

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import io.grpc.Status;
import java.util.HashSet;
import java.util.Set;

// A Converter class that turns a native protobuf::DescriptorProto to a self contained
// protobuf::DescriptorProto
// that can be reconstructed by the backend.
public class ProtoSchemaConverter {
  private static String getNameFromFullName(String fullName) {
    return fullName.replace('.', '_');
  }

  private static ProtoSchema convertInternal(
      Descriptor input,
      Set<String> visitedTypes,
      Set<String> enumTypes,
      Set<String> structTypes,
      DescriptorProto.Builder rootProtoSchema) {
    DescriptorProto.Builder resultProto = DescriptorProto.newBuilder();
    if (rootProtoSchema == null) {
      rootProtoSchema = resultProto;
    }
    String protoFullName = input.getFullName();
    String protoName = getNameFromFullName(protoFullName);
    resultProto.setName(protoName);
    Set<String> localEnumTypes = new HashSet<String>();
    visitedTypes.add(input.getFullName());
    for (int i = 0; i < input.getFields().size(); i++) {
      FieldDescriptor inputField = input.getFields().get(i);
      FieldDescriptorProto.Builder resultField = inputField.toProto().toBuilder();
      if (inputField.getType() == FieldDescriptor.Type.GROUP
          || inputField.getType() == FieldDescriptor.Type.MESSAGE) {
        String msgFullName = inputField.getMessageType().getFullName();
        String msgName = getNameFromFullName(msgFullName);
        if (structTypes.contains(msgFullName)) {
          resultField.setTypeName(msgName);
        } else {
          if (visitedTypes.contains(msgFullName)) {
            throw new InvalidArgumentException(
                "Recursive type is not supported:" + inputField.getMessageType().getFullName(),
                null,
                GrpcStatusCode.of(Status.Code.INVALID_ARGUMENT),
                false);
          }
          visitedTypes.add(msgFullName);
          rootProtoSchema.addNestedType(
              convertInternal(
                      inputField.getMessageType(),
                      visitedTypes,
                      enumTypes,
                      structTypes,
                      rootProtoSchema)
                  .getProtoDescriptor());
          visitedTypes.remove(msgFullName);
          resultField.setTypeName(
              rootProtoSchema.getNestedType(rootProtoSchema.getNestedTypeCount() - 1).getName());
        }
      }

      if (inputField.getType() == FieldDescriptor.Type.ENUM) {
        // For enums, in order to avoid value conflict, we will always define
        // a enclosing struct called enum_full_name_E that includes the actual
        // enum.
        String enumFullName = inputField.getEnumType().getFullName();
        String enclosingTypeName = getNameFromFullName(enumFullName) + "_E";
        String enumName = inputField.getEnumType().getName();
        String actualEnumFullName = enclosingTypeName + "." + enumName;
        if (enumTypes.contains(enumFullName)) {
          resultField.setTypeName(actualEnumFullName);
        } else {
          EnumDescriptorProto enumType = inputField.getEnumType().toProto();
          resultProto.addNestedType(
              DescriptorProto.newBuilder()
                  .setName(enclosingTypeName)
                  .addEnumType(enumType.toBuilder().setName(enumName))
                  .build());
          resultField.setTypeName(actualEnumFullName);
          enumTypes.add(enumFullName);
        }
      }
      resultProto.addField(resultField);
    }
    structTypes.add(protoFullName);

    return ProtoSchema.newBuilder().setProtoDescriptor(resultProto.build()).build();
  }

  public static ProtoSchema convert(Descriptor descriptor) {
    Set<String> visitedTypes = new HashSet<String>();
    Set<String> enumTypes = new HashSet<String>();
    Set<String> structTypes = new HashSet<String>();
    return convertInternal(descriptor, visitedTypes, enumTypes, structTypes, null);
  }
}
