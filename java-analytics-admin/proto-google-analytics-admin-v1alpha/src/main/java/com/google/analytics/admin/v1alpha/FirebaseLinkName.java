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

package com.google.analytics.admin.v1alpha;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class FirebaseLinkName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("properties/{property}/firebaseLinks/{firebase_link}");

  private volatile Map<String, String> fieldValuesMap;

  private final String property;
  private final String firebaseLink;

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

  private FirebaseLinkName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    firebaseLink = Preconditions.checkNotNull(builder.getFirebaseLink());
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
        PATH_TEMPLATE.validatedMatch(
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
    List<String> list = new ArrayList<String>(values.size());
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
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("property", property);
          fieldMapBuilder.put("firebaseLink", firebaseLink);
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
    return PATH_TEMPLATE.instantiate("property", property, "firebase_link", firebaseLink);
  }

  /** Builder for FirebaseLinkName. */
  public static class Builder {

    private String property;
    private String firebaseLink;

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

    private Builder() {}

    private Builder(FirebaseLinkName firebaseLinkName) {
      property = firebaseLinkName.property;
      firebaseLink = firebaseLinkName.firebaseLink;
    }

    public FirebaseLinkName build() {
      return new FirebaseLinkName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof FirebaseLinkName) {
      FirebaseLinkName that = (FirebaseLinkName) o;
      return (this.property.equals(that.property)) && (this.firebaseLink.equals(that.firebaseLink));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= property.hashCode();
    h *= 1000003;
    h ^= firebaseLink.hashCode();
    return h;
  }
}
