/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.storage.v1alpha2;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.bigquery.storage.v1alpha2.ProtoBufProto.ProtoSchema;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import io.grpc.Status;
import java.util.*;

// A Converter class that turns a native protobuf::DescriptorProto to a self contained
// protobuf::DescriptorProto
// that can be reconstructed by the backend.
public class ProtoSchemaConverter {
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
    String protoName = input.getFullName();
    protoName = protoName.replace('.', '_');
    resultProto.setName(protoName);
    Set<String> localEnumTypes = new HashSet<String>();
    visitedTypes.add(input.getFullName());
    for (int i = 0; i < input.getFields().size(); i++) {
      FieldDescriptor inputField = input.getFields().get(i);
      FieldDescriptorProto.Builder resultField = inputField.toProto().toBuilder();
      if (inputField.getType() == FieldDescriptor.Type.GROUP
          || inputField.getType() == FieldDescriptor.Type.MESSAGE) {
        String msgFullName = inputField.getMessageType().getFullName();
        msgFullName = msgFullName.replace('.', '_');
        if (structTypes.contains(msgFullName)) {
          resultField.setTypeName(msgFullName);
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
        String enumFullName = inputField.getEnumType().getFullName();
        // If the enum is defined within the current message, we don't want to
        // pull it out to the top since then the same enum values will not be
        // allowed if the value collides with other enums.
        if (enumFullName.startsWith(input.getFullName())) {
          String enumName = inputField.getEnumType().getName();
          if (localEnumTypes.contains(enumName)) {
            resultField.setTypeName(enumName);
          } else {
            resultProto.addEnumType(inputField.getEnumType().toProto());
            resultField.setTypeName(enumName);
            localEnumTypes.add(enumName);
          }
        } else {
          // If the enum is defined elsewhere, then redefine it at the top
          // message scope. There is a problem that different enum values might
          // be OK when living under its original scope, but when they all live
          // in top scope, their values cannot collide. Say if thers A.Color with
          // RED and B.Color with RED, if they are redefined here, the RED will
          // collide with each other and thus not allowed.
          enumFullName = enumFullName.replace('.', '_');
          if (enumTypes.contains(enumFullName)) {
            resultField.setTypeName(enumFullName);
          } else {
            EnumDescriptorProto enumType =
                inputField.getEnumType().toProto().toBuilder().setName(enumFullName).build();
            resultProto.addEnumType(enumType);
            resultField.setTypeName(enumFullName);
            enumTypes.add(enumFullName);
          }
        }
      }
      resultProto.addField(resultField);
    }
    structTypes.add(protoName);
    return ProtoSchema.newBuilder().setProtoDescriptor(resultProto.build()).build();
  }

  public static ProtoSchema convert(Descriptor descriptor) {
    Set<String> visitedTypes = new HashSet<String>();
    Set<String> enumTypes = new HashSet<String>();
    Set<String> structTypes = new HashSet<String>();
    return convertInternal(descriptor, visitedTypes, enumTypes, structTypes, null);
  }
}
