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

package com.google.api.generator.gapic.protoparser;

import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Descriptors.FileDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

public class TypeParser {
  private static Reference REFERENCE_BYTE_STRING = ConcreteReference.withClazz(ByteString.class);
  private static TypeNode TYPE_NODE_BYTE_STRING = TypeNode.withReference(REFERENCE_BYTE_STRING);

  private static Map<JavaType, TypeNode> SIMPLE_TYPE_MAP =
      ImmutableMap.<JavaType, TypeNode>builder()
          .put(JavaType.INT, TypeNode.INT)
          .put(JavaType.LONG, TypeNode.LONG)
          .put(JavaType.FLOAT, TypeNode.FLOAT)
          .put(JavaType.DOUBLE, TypeNode.DOUBLE)
          .put(JavaType.STRING, TypeNode.STRING)
          .put(JavaType.BOOLEAN, TypeNode.BOOLEAN)
          .put(JavaType.BYTE_STRING, TYPE_NODE_BYTE_STRING)
          .build();

  private static Map<JavaType, Reference> SIMPLE_REFERENCE_MAP =
      ImmutableMap.<JavaType, Reference>builder()
          .put(JavaType.INT, ConcreteReference.withClazz(Integer.class))
          .put(JavaType.LONG, ConcreteReference.withClazz(Long.class))
          .put(JavaType.FLOAT, ConcreteReference.withClazz(Float.class))
          .put(JavaType.DOUBLE, ConcreteReference.withClazz(Double.class))
          .put(JavaType.STRING, ConcreteReference.withClazz(String.class))
          .put(JavaType.BOOLEAN, ConcreteReference.withClazz(Boolean.class))
          .put(JavaType.BYTE_STRING, REFERENCE_BYTE_STRING)
          .build();

  public static TypeNode parseType(@Nonnull FieldDescriptor field) {
    if (field.isMapField()) {
      return createMapType(field);
    }

    if (field.isRepeated()) {
      return createListType(field);
    }

    // Parse basic type.
    JavaType protoFieldType = field.getJavaType();
    boolean isEnum = protoFieldType.equals(JavaType.ENUM);
    boolean isMessage = protoFieldType.equals(JavaType.MESSAGE);
    if (!isEnum && !isMessage) {
      // Primitive types.
      return SIMPLE_TYPE_MAP.get(protoFieldType);
    }

    return TypeNode.withReference(parseFieldReference(field));
  }

  public static TypeNode parseType(@Nonnull Descriptor messageDescriptor) {
    return TypeNode.withReference(parseMessageReference(messageDescriptor));
  }

  public static TypeNode parseType(@Nonnull EnumDescriptor enumDescriptor) {
    return TypeNode.withReference(parseEnumReference(enumDescriptor));
  }

  public static String getPackage(FileDescriptor fileDescriptor) {
    String pakkage = fileDescriptor.getOptions().getJavaPackage();
    if (Strings.isNullOrEmpty(pakkage)) {
      pakkage = fileDescriptor.getPackage();
    }
    Preconditions.checkNotNull(
        pakkage, String.format("Java package in file %s was null", fileDescriptor.getName()));
    return pakkage;
  }

  @VisibleForTesting
  static Reference parseFieldReference(FieldDescriptor field) {
    JavaType protoFieldType = field.getJavaType();
    boolean isEnum = protoFieldType.equals(JavaType.ENUM);
    boolean isMessage = protoFieldType.equals(JavaType.MESSAGE);
    if (!isEnum && !isMessage) {
      // Boxed primitive types.
      return SIMPLE_REFERENCE_MAP.get(protoFieldType);
    }

    // Handles enum or messages.
    if (isMessage) {
      return parseMessageReference(field.getMessageType());
    }
    return parseEnumReference(field.getEnumType());
  }

  @VisibleForTesting
  static Reference parseMessageReference(@Nonnull Descriptor messageDescriptor) {
    List<String> outerNestedTypeNames = new ArrayList<>();
    FileOptions fileOptions = messageDescriptor.getFile().getOptions();
    String javaOuterClassname =
        fileOptions.hasJavaOuterClassname() ? fileOptions.getJavaOuterClassname() : null;

    // Some older protos don't have java_multiple_files option set, and don't have the outer
    // classname option set either.
    if (!fileOptions.getJavaMultipleFiles() && !fileOptions.hasJavaOuterClassname()) {
      String fullFilePath = JavaStyle.toUpperCamelCase(messageDescriptor.getFile().getName());
      javaOuterClassname =
          JavaStyle.toUpperCamelCase(
              fullFilePath.substring(
                  fullFilePath.lastIndexOf("/") + 1, fullFilePath.lastIndexOf(".")));
    }

    boolean hasJavaOuterClass =
        !Strings.isNullOrEmpty(javaOuterClassname) && !fileOptions.getJavaMultipleFiles();
    if (hasJavaOuterClass) {
      outerNestedTypeNames.add(javaOuterClassname);
    }
    Descriptor containingType = messageDescriptor.getContainingType();

    // Handles nesting.
    while (containingType != null) {
      // Outermost type in the nested type hierarchy lies at index 0.
      // If the Java outer proto class has already been set, apapend after it at index 1.
      outerNestedTypeNames.add(hasJavaOuterClass ? 1 : 0, containingType.getName());
      containingType = containingType.getContainingType();
    }

    String pakkage = getPackage(messageDescriptor.getFile());
    Reference messageReference =
        VaporReference.builder()
            .setName(messageDescriptor.getName())
            .setPakkage(pakkage)
            .setEnclosingClassNames(outerNestedTypeNames)
            .build();

    String protoPackage = messageDescriptor.getFile().getPackage();
    String messageFullName = messageDescriptor.getFullName();
    if (hasJavaOuterClass) {
      int packageIndex = protoPackage.length();
      messageFullName =
          String.format(
              "%s.%s.%s",
              messageFullName.substring(0, packageIndex),
              javaOuterClassname,
              messageFullName.substring(packageIndex + 1));
    }
    Preconditions.checkState(
        messageReference.fullName().replace(pakkage, protoPackage).equals(messageFullName),
        String.format(
            "Parsed message name %s does not match actual name %s",
            messageReference.fullName().replace(pakkage, ""),
            messageFullName.replace(protoPackage, "")));
    return messageReference;
  }

  @VisibleForTesting
  static Reference parseEnumReference(@Nonnull EnumDescriptor enumDescriptor) {
    // This is similar to parseMessageReference, but we make it a separate method because
    // EnumDescriptor and Descriptor are sibling types.
    FileOptions fileOptions = enumDescriptor.getFile().getOptions();
    String javaOuterClassname =
        fileOptions.hasJavaOuterClassname() ? fileOptions.getJavaOuterClassname() : null;

    // Some older protos don't have java_multiple_files option set, and don't have the outer
    // classname option set either.
    if (!fileOptions.getJavaMultipleFiles() && !fileOptions.hasJavaOuterClassname()) {
      String fullFilePath = JavaStyle.toUpperCamelCase(enumDescriptor.getFile().getName());
      javaOuterClassname =
          JavaStyle.toUpperCamelCase(
              fullFilePath.substring(
                  fullFilePath.lastIndexOf("/") + 1, fullFilePath.lastIndexOf(".")));
    }

    boolean hasJavaOuterClass =
        !Strings.isNullOrEmpty(javaOuterClassname) && !fileOptions.getJavaMultipleFiles();
    List<String> outerNestedTypeNames = new ArrayList<>();
    if (hasJavaOuterClass) {
      outerNestedTypeNames.add(javaOuterClassname);
    }

    Descriptor containingType = enumDescriptor.getContainingType();

    // Handles nesting.
    while (containingType != null) {
      // Outermost type in the nested type hierarchy lies at index 0.
      // If the Java outer proto class has already been set, apapend after it at index 1.
      outerNestedTypeNames.add(hasJavaOuterClass ? 1 : 0, containingType.getName());
      containingType = containingType.getContainingType();
    }

    String pakkage = getPackage(enumDescriptor.getFile());
    Reference enumReference =
        VaporReference.builder()
            .setName(enumDescriptor.getName())
            .setPakkage(pakkage)
            .setEnclosingClassNames(outerNestedTypeNames)
            .build();
    String protoPackage = enumDescriptor.getFile().getPackage();
    String enumFullName = enumDescriptor.getFullName();
    if (hasJavaOuterClass) {
      int packageIndex = protoPackage.length();
      enumFullName =
          String.format(
              "%s.%s.%s",
              enumFullName.substring(0, packageIndex),
              javaOuterClassname,
              enumFullName.substring(packageIndex + 1));
    }

    Preconditions.checkState(
        enumReference.fullName().replace(pakkage, protoPackage).equals(enumFullName),
        String.format(
            "Parsed enum name %s does not match actual name %s",
            enumReference.fullName().replace(pakkage, ""),
            enumDescriptor.getFullName().replace(protoPackage, "")));
    return enumReference;
  }

  @VisibleForTesting
  static TypeNode createListType(FieldDescriptor field) {
    Reference listReference =
        ConcreteReference.builder()
            .setClazz(List.class)
            .setGenerics(Arrays.asList(parseFieldReference(field)))
            .build();
    return TypeNode.withReference(listReference);
  }

  @VisibleForTesting
  static TypeNode createMapType(FieldDescriptor field) {
    Preconditions.checkState(
        field.isMapField(), "createMapType can only be called on map-type fields");

    Descriptor type = field.getMessageType();
    FieldDescriptor keyField = type.findFieldByName("key");
    FieldDescriptor valueField = type.findFieldByName("value");

    Reference keyReference = parseFieldReference(keyField);
    Reference valueReference = parseFieldReference(valueField);

    Reference mapReference =
        ConcreteReference.builder()
            .setClazz(Map.class)
            .setGenerics(Arrays.asList(keyReference, valueReference))
            .build();
    return TypeNode.withReference(mapReference);
  }
}
