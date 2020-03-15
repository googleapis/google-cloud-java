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
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import io.grpc.Status;
import java.util.*;

// A Converter class that turns a native protobuf::DescriptorProto to a self contained
// protobuf::DescriptorProto
// that can be reconstructed by the backend.
public class ProtoSchemaConverter {
  private static class StructName {
    public String getName() {
      return "__S" + (count++);
    }

    private int count = 0;
  }

  private static ProtoSchema convertInternal(
      Descriptor input, List<String> visitedTypes, StructName structName) {
    DescriptorProto.Builder resultProto = DescriptorProto.newBuilder();
    resultProto.setName(structName.getName());
    visitedTypes.add(input.getFullName());
    for (int i = 0; i < input.getFields().size(); i++) {
      FieldDescriptor inputField = input.getFields().get(i);
      FieldDescriptorProto.Builder resultField = inputField.toProto().toBuilder();
      if (inputField.getType() == FieldDescriptor.Type.GROUP
          || inputField.getType() == FieldDescriptor.Type.MESSAGE) {
        if (visitedTypes.contains(inputField.getMessageType().getFullName())) {
          throw new InvalidArgumentException(
              "Recursive type is not supported:" + inputField.getMessageType().getFullName(),
              null,
              GrpcStatusCode.of(Status.Code.INVALID_ARGUMENT),
              false);
        }
        resultProto.addNestedType(
            convertInternal(inputField.getMessageType(), visitedTypes, structName)
                .getProtoDescriptor());
        visitedTypes.remove(inputField.getMessageType().getFullName());
        resultField.setTypeName(
            resultProto.getNestedType(resultProto.getNestedTypeCount() - 1).getName());
      }
      if (inputField.getType() == FieldDescriptor.Type.ENUM) {
        resultProto.addEnumType(inputField.getEnumType().toProto());
        resultField.setTypeName(
            resultProto.getEnumType(resultProto.getEnumTypeCount() - 1).getName());
      }
      resultProto.addField(resultField);
    }
    return ProtoSchema.newBuilder().setProtoDescriptor(resultProto.build()).build();
  }

  public static ProtoSchema convert(Descriptor descriptor) {
    ArrayList<String> visitedTypes = new ArrayList<String>();
    return convertInternal(descriptor, visitedTypes, new StructName());
  }
}
