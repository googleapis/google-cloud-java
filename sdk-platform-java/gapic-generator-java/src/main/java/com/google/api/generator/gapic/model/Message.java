// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.model;

import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.annotation.Nullable;

@AutoValue
public abstract class Message {

  public abstract String name();

  // The fully-qualified proto name, which differs from the Java fully-qualified name.
  // For example, this would be google.showcase.v1beta1.EchoRequest for echo.proto (see testdata),
  // whereas that message's Java fully-qualified name is com.google.showcase.v1beta1.EchoRequest.
  public abstract String fullProtoName();

  // TODO(unsupported): oneof fields are parsed as separate ones because field flattening refers to
  // a specific field.
  public abstract ImmutableList<Field> fields();

  // TODO(unsupported): Consider making enums a separate POJO. However, that would require
  // passing in a map of Message and another map of Enum types, which is not needed for
  // 99.99% of protobuf generation.
  /**
   * This Message POJO is used to represent both proto-messages and proto-enums.
   *
   * @return an empty map if this instance represents a proto-message, otherwise the proto-enum's
   *     String-number value map.
   */
  public abstract ImmutableMap<String, Integer> enumValues();

  public abstract TypeNode type();

  public abstract ImmutableMap<String, Field> fieldMap();

  @Nullable
  public abstract OperationResponse operationResponse();

  public abstract Map<String, String> operationRequestFields();

  public abstract BiMap<String, String> operationResponseFields();

  // The resource name annotation (and definition) in this message. Optional.
  // Expected dto be empty for messages that have no such definition.
  @Nullable
  public abstract ResourceName resource();

  // The nested types in left-to-right order, if any.
  // Example: com.google.Foo.Bar.Car.ThisType will have the outer types listed in the order
  // [Foo, Bar, Car].
  public abstract ImmutableList<String> outerNestedTypes();

  /**
   * This Message POJO is used to represent both proto-messages and proto-enums.
   *
   * <p>If this instance represents a proto-enum (<code>this.isEnum() == true</code>), this method
   * will always return an empty list, since enums cannot contain nested enums.
   *
   * <p>If this instance represents a proto-message (<code>this.isEnum() == false</code>), this
   * method returns a list of any nested proto-enums defined in this proto-message.
   */
  public abstract ImmutableList<String> nestedEnums();

  public abstract Builder toBuilder();

  /**
   * This Message POJO is used to represent both proto-messages and proto-enums.
   *
   * @return true, when this instance represents a proto-enum.
   */
  public boolean isEnum() {
    return !enumValues().isEmpty();
  }

  public boolean hasResource() {
    return resource() != null;
  }

  /**
   * Validates if the field or fields exist in the message and the type of the leaf level field.
   *
   * @param fieldName The field name. For nested field, concatenate each field name with dot. For
   *     example: abc.def.ghi
   * @param messageTypes All messages configured in a rpc service.
   * @param type {@link TypeNode} The expected type for the leaf level field
   */
  public void validateField(String fieldName, Map<String, Message> messageTypes, TypeNode type) {
    List<String> subFields = Splitter.on(".").splitToList(fieldName);
    Message nestedMessage = this;
    for (int i = 0; i < subFields.size(); i++) {
      String subFieldName = subFields.get(i);
      Preconditions.checkState(
          !Strings.isNullOrEmpty(subFieldName),
          String.format("Null or empty field name found for message %s", nestedMessage.name()));
      Field field = nestedMessage.fieldMap().get(subFieldName);
      Preconditions.checkNotNull(
          field,
          String.format(
              "Expected message %s to contain field %s but none found",
              nestedMessage.name(), subFieldName));
      if (i < subFields.size() - 1) {
        nestedMessage = messageTypes.get(field.type().reference().fullName());
        Preconditions.checkNotNull(
            nestedMessage,
            String.format(
                "No containing message found for field %s with type %s",
                field.name(), field.type().reference().simpleName()));
      } else {
        Preconditions.checkState(
            !field.isRepeated() && field.type().equals(type),
            String.format("The type of field %s must be String and not repeated.", field.name()));
      }
    }
  }

  /** Returns the first list repeated field in a message, unwrapped from its list type. */
  @Nullable
  public Field findAndUnwrapPaginatedRepeatedField() {
    for (Field field : fields()) {
      if (field.isMap()) {
        List<Reference> repeatedGenericMapRefs = field.type().reference().generics();

        TypeNode paginatedType =
            TypeNode.withReference(
                ConcreteReference.builder()
                    .setClazz(Map.Entry.class)
                    .setGenerics(
                        Arrays.asList(repeatedGenericMapRefs.get(0), repeatedGenericMapRefs.get(1)))
                    .build());

        return field.toBuilder().setType(paginatedType).build();
      }
    }
    for (Field field : fields()) {
      if (field.isRepeated() && !field.isMap()) {
        Reference repeatedGenericRef = field.type().reference().generics().get(0);
        return field.toBuilder().setType(TypeNode.withReference(repeatedGenericRef)).build();
      }
    }
    return null;
  }

  public static Builder builder() {
    return new AutoValue_Message.Builder()
        .setNestedEnums(Collections.emptyList())
        .setOuterNestedTypes(Collections.emptyList())
        .setFields(Collections.emptyList())
        .setFieldMap(Collections.emptyMap())
        .setEnumValues(Collections.emptyMap())
        .setOperationResponseFields(HashBiMap.create())
        .setOperationRequestFields(Collections.emptyMap());
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setName(String name);

    public abstract Builder setFullProtoName(String fullProtoName);

    public abstract Builder setFields(List<Field> fields);

    public Builder setEnumValues(List<String> names, List<Integer> numbers) {
      return setEnumValues(
          IntStream.range(0, names.size())
              .boxed()
              .collect(Collectors.toMap(i -> names.get(i), i -> numbers.get(i))));
    }

    public abstract Builder setEnumValues(Map<String, Integer> enumValues);

    public abstract Builder setType(TypeNode type);

    public abstract Builder setResource(ResourceName resource);

    public abstract Builder setOuterNestedTypes(List<String> outerNestedTypes);

    public abstract Builder setOperationResponse(OperationResponse operationResponse);

    public abstract Builder setOperationRequestFields(Map<String, String> operationRequestFields);

    public abstract Builder setOperationResponseFields(
        BiMap<String, String> operationRequestFields);

    public abstract Builder setNestedEnums(List<String> nestedEnums);

    abstract Builder setFieldMap(Map<String, Field> fieldMap);

    abstract ImmutableList<Field> fields();

    abstract ImmutableMap<String, Integer> enumValues();

    abstract Message autoBuild();

    public Message build() {
      Message message = autoBuild();
      if (!message.fields().isEmpty()) {
        Map<String, Field> fieldMap =
            fields().stream().collect(Collectors.toMap(f -> f.name(), f -> f));
        // Handles string occurrences of a field's original name in a protobuf, such as
        // in the method signature annotaiton.
        fields().stream()
            .filter(f -> f.hasFieldNameConflict())
            .forEach(f -> fieldMap.put(f.originalName(), f));
        message = message.toBuilder().setFieldMap(fieldMap).autoBuild();
      }
      return message;
    }
  }
}
