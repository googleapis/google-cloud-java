/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datalabeling.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class InstructionName implements ResourceName {
  private static final PathTemplate PROJECT_INSTRUCTION =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/instructions/{instruction}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String instruction;

  @Deprecated
  protected InstructionName() {
    project = null;
    instruction = null;
  }

  private InstructionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    instruction = Preconditions.checkNotNull(builder.getInstruction());
  }

  public String getProject() {
    return project;
  }

  public String getInstruction() {
    return instruction;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static InstructionName of(String project, String instruction) {
    return newBuilder().setProject(project).setInstruction(instruction).build();
  }

  public static String format(String project, String instruction) {
    return newBuilder().setProject(project).setInstruction(instruction).build().toString();
  }

  public static InstructionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_INSTRUCTION.validatedMatch(
            formattedString, "InstructionName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("instruction"));
  }

  public static List<InstructionName> parseList(List<String> formattedStrings) {
    List<InstructionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<InstructionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (InstructionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_INSTRUCTION.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (instruction != null) {
            fieldMapBuilder.put("instruction", instruction);
          }
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return PROJECT_INSTRUCTION.instantiate("project", project, "instruction", instruction);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      InstructionName that = ((InstructionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.instruction, that.instruction);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(instruction);
    return h;
  }

  /** Builder for projects/{project}/instructions/{instruction}. */
  public static class Builder {
    private String project;
    private String instruction;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getInstruction() {
      return instruction;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setInstruction(String instruction) {
      this.instruction = instruction;
      return this;
    }

    private Builder(InstructionName instructionName) {
      project = instructionName.project;
      instruction = instructionName.instruction;
    }

    public InstructionName build() {
      return new InstructionName(this);
    }
  }
}
