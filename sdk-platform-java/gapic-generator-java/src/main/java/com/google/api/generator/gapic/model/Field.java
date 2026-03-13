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

import com.google.api.FieldInfo.Format;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.auto.value.AutoValue;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@AutoValue
public abstract class Field {
  // The field's canonical name, potentially post-processed by conflict resolution logic.
  public abstract String name();

  // The field's name as it appeared in the protobuf.
  // Not equal to name() only when there is a field name conflict, as per protoc's conflict
  // resolution behavior. For more context, please see the invocation site of the setter method.
  public abstract String originalName();

  public abstract TypeNode type();

  // If the field is annotated with google.api.field_behavior = REQUIRED, then this is true. This is
  // currently only used to check if a field should be auto-populated. If it is true, then the field
  // should
  // *not* be autopopulated.
  public abstract boolean isRequired();

  @Nullable
  public abstract Format fieldInfoFormat();

  public abstract boolean isMessage();

  public abstract boolean isEnum();

  public abstract boolean isRepeated();

  public abstract boolean isMap();

  public abstract boolean isContainedInOneof();

  public abstract boolean isProto3Optional();

  @Nullable
  public abstract ResourceReference resourceReference();

  @Nullable
  public abstract String description();

  public boolean hasFieldNameConflict() {
    return !name().equals(originalName());
  }

  public boolean hasDescription() {
    return description() != null;
  }

  public boolean hasResourceReference() {
    return type().equals(TypeNode.STRING) && resourceReference() != null;
  }

  // Check that the field format is of UUID, it is not annotated as required, and is of type String.
  // Unless
  // those three conditions are met, do not autopopulate the field.
  // In the future, if additional formats are supported for autopopulation, this will need to be
  // refactored to support those formats.
  public boolean canBeAutoPopulated() {
    return Format.UUID4.equals(fieldInfoFormat())
        && !isRequired()
        && TypeNode.STRING.equals(type());
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Field)) {
      return false;
    }

    Field other = (Field) o;
    return name().equals(other.name())
        && originalName().equals(other.originalName())
        && type().equals(other.type())
        && isRequired() == other.isRequired()
        && fieldInfoFormat() == other.fieldInfoFormat()
        && isMessage() == other.isMessage()
        && isEnum() == other.isEnum()
        && isRepeated() == other.isRepeated()
        && isMap() == other.isMap()
        && isContainedInOneof() == other.isContainedInOneof()
        && isProto3Optional() == other.isProto3Optional()
        && Objects.equals(resourceReference(), other.resourceReference())
        && Objects.equals(description(), other.description());
  }

  @Override
  public int hashCode() {
    return 17 * name().hashCode()
        + 31 * originalName().hashCode()
        + 19 * type().hashCode()
        + (isMessage() ? 1 : 0) * 23
        + (isEnum() ? 1 : 0) * 29
        + (isRequired() ? 1 : 0) * 31
        + (fieldInfoFormat() == null ? 0 : fieldInfoFormat().hashCode())
        + (isRepeated() ? 1 : 0) * 31
        + (isMap() ? 1 : 0) * 37
        + (isContainedInOneof() ? 1 : 0) * 41
        + (isProto3Optional() ? 1 : 0) * 43
        + (resourceReference() == null ? 0 : resourceReference().hashCode())
        + (description() == null ? 0 : description().hashCode());
  }

  public abstract Builder toBuilder();

  public static Builder builder() {
    return new AutoValue_Field.Builder()
        .setIsRequired(false)
        .setIsMessage(false)
        .setIsEnum(false)
        .setIsRepeated(false)
        .setIsMap(false)
        .setIsContainedInOneof(false)
        .setIsProto3Optional(false);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setName(String name);

    public abstract Builder setOriginalName(String originalName);

    public abstract Builder setType(TypeNode type);

    public abstract Builder setIsRequired(boolean isRequired);

    public abstract Builder setFieldInfoFormat(Format fieldInfoFormat);

    public abstract Builder setIsMessage(boolean isMessage);

    public abstract Builder setIsEnum(boolean isEnum);

    public abstract Builder setIsRepeated(boolean isRepeated);

    public abstract Builder setIsMap(boolean isMap);

    public abstract Builder setIsContainedInOneof(boolean isContainedInOneof);

    public abstract Builder setIsProto3Optional(boolean isProto3Optional);

    public abstract Builder setResourceReference(ResourceReference resourceReference);

    public abstract Builder setDescription(String description);

    // Private accessors.
    abstract String name();

    abstract Optional<String> originalName();

    abstract Field autoBuild();

    public Field build() {
      if (!originalName().isPresent()) {
        setOriginalName(name());
      }
      return autoBuild();
    }
  }
}
