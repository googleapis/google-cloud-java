/*
 * Copyright 2025 Google LLC
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

package com.google.showcase.v1beta1;

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
public class SequenceName implements ResourceName {
  private static final PathTemplate SEQUENCE =
      PathTemplate.createWithoutUrlEncoding("sequences/{sequence}");
  private volatile Map<String, String> fieldValuesMap;
  private final String sequence;

  @Deprecated
  protected SequenceName() {
    sequence = null;
  }

  private SequenceName(Builder builder) {
    sequence = Preconditions.checkNotNull(builder.getSequence());
  }

  public String getSequence() {
    return sequence;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SequenceName of(String sequence) {
    return newBuilder().setSequence(sequence).build();
  }

  public static String format(String sequence) {
    return newBuilder().setSequence(sequence).build().toString();
  }

  public static SequenceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        SEQUENCE.validatedMatch(
            formattedString, "SequenceName.parse: formattedString not in valid format");
    return of(matchMap.get("sequence"));
  }

  public static List<SequenceName> parseList(List<String> formattedStrings) {
    List<SequenceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SequenceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SequenceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return SEQUENCE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (sequence != null) {
            fieldMapBuilder.put("sequence", sequence);
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
    return SEQUENCE.instantiate("sequence", sequence);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SequenceName that = ((SequenceName) o);
      return Objects.equals(this.sequence, that.sequence);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(sequence);
    return h;
  }

  /** Builder for sequences/{sequence}. */
  public static class Builder {
    private String sequence;

    protected Builder() {}

    public String getSequence() {
      return sequence;
    }

    public Builder setSequence(String sequence) {
      this.sequence = sequence;
      return this;
    }

    private Builder(SequenceName sequenceName) {
      this.sequence = sequenceName.sequence;
    }

    public SequenceName build() {
      return new SequenceName(this);
    }
  }
}
