/*
 * Copyright 2026 Google LLC
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

package com.google.developers.knowledge.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class DocumentName implements ResourceName {
  private static final PathTemplate DOCUMENT =
      PathTemplate.createWithoutUrlEncoding("documents/{document}");
  private volatile Map<String, String> fieldValuesMap;
  private final String document;

  @Deprecated
  protected DocumentName() {
    document = null;
  }

  private DocumentName(Builder builder) {
    document = Preconditions.checkNotNull(builder.getDocument());
  }

  public String getDocument() {
    return document;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DocumentName of(String document) {
    return newBuilder().setDocument(document).build();
  }

  public static String format(String document) {
    return newBuilder().setDocument(document).build().toString();
  }

  public static @Nullable DocumentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        DOCUMENT.validatedMatch(
            formattedString, "DocumentName.parse: formattedString not in valid format");
    return of(matchMap.get("document"));
  }

  public static List<DocumentName> parseList(List<String> formattedStrings) {
    List<DocumentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable DocumentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DocumentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return DOCUMENT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (document != null) {
            fieldMapBuilder.put("document", document);
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
    return DOCUMENT.instantiate("document", document);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DocumentName that = ((DocumentName) o);
      return Objects.equals(this.document, that.document);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(document);
    return h;
  }

  /** Builder for documents/{document}. */
  public static class Builder {
    private String document;

    protected Builder() {}

    public String getDocument() {
      return document;
    }

    public Builder setDocument(String document) {
      this.document = document;
      return this;
    }

    private Builder(DocumentName documentName) {
      this.document = documentName.document;
    }

    public DocumentName build() {
      return new DocumentName(this);
    }
  }
}
