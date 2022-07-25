/*
 * Copyright 2022 Google LLC
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

package com.google.analytics.admin.v1alpha;

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
public class FirebaseLinkName implements ResourceName {
  private static final PathTemplate PROPERTY_FIREBASE_LINK =
      PathTemplate.createWithoutUrlEncoding("properties/{property}/firebaseLinks/{firebase_link}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String firebaseLink;

  @Deprecated
  protected FirebaseLinkName() {
    property = null;
    firebaseLink = null;
  }

  private FirebaseLinkName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    firebaseLink = Preconditions.checkNotNull(builder.getFirebaseLink());
  }

  public String getProperty() {
    return property;
  }

  public String getFirebaseLink() {
    return firebaseLink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FirebaseLinkName of(String property, String firebaseLink) {
    return newBuilder().setProperty(property).setFirebaseLink(firebaseLink).build();
  }

  public static String format(String property, String firebaseLink) {
    return newBuilder().setProperty(property).setFirebaseLink(firebaseLink).build().toString();
  }

  public static FirebaseLinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_FIREBASE_LINK.validatedMatch(
            formattedString, "FirebaseLinkName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("firebase_link"));
  }

  public static List<FirebaseLinkName> parseList(List<String> formattedStrings) {
    List<FirebaseLinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FirebaseLinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FirebaseLinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_FIREBASE_LINK.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (property != null) {
            fieldMapBuilder.put("property", property);
          }
          if (firebaseLink != null) {
            fieldMapBuilder.put("firebase_link", firebaseLink);
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
    return PROPERTY_FIREBASE_LINK.instantiate("property", property, "firebase_link", firebaseLink);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      FirebaseLinkName that = ((FirebaseLinkName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.firebaseLink, that.firebaseLink);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(firebaseLink);
    return h;
  }

  /** Builder for properties/{property}/firebaseLinks/{firebase_link}. */
  public static class Builder {
    private String property;
    private String firebaseLink;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getFirebaseLink() {
      return firebaseLink;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setFirebaseLink(String firebaseLink) {
      this.firebaseLink = firebaseLink;
      return this;
    }

    private Builder(FirebaseLinkName firebaseLinkName) {
      this.property = firebaseLinkName.property;
      this.firebaseLink = firebaseLinkName.firebaseLink;
    }

    public FirebaseLinkName build() {
      return new FirebaseLinkName(this);
    }
  }
}
