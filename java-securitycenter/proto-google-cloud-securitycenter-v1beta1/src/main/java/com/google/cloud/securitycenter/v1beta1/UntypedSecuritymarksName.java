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

package com.google.cloud.securitycenter.v1beta1;

import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * AUTO-GENERATED DOCUMENTATION AND CLASS
 *
 * @deprecated This resource name class will be removed in the next major version.
 */
@javax.annotation.Generated("by GAPIC protoc plugin")
@Deprecated
public class UntypedSecuritymarksName extends SecuritymarksName {

  private final String rawValue;
  private Map<String, String> valueMap;

  private UntypedSecuritymarksName(String rawValue) {
    this.rawValue = Preconditions.checkNotNull(rawValue);
    this.valueMap = ImmutableMap.of("", rawValue);
  }

  public static UntypedSecuritymarksName from(ResourceName resourceName) {
    return new UntypedSecuritymarksName(resourceName.toString());
  }

  public static UntypedSecuritymarksName parse(String formattedString) {
    return new UntypedSecuritymarksName(formattedString);
  }

  public static List<UntypedSecuritymarksName> parseList(List<String> formattedStrings) {
    List<UntypedSecuritymarksName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<UntypedSecuritymarksName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (UntypedSecuritymarksName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return true;
  }

  /** Return a map with a single value rawValue keyed on an empty String "". */
  public Map<String, String> getFieldValuesMap() {
    return valueMap;
  }

  /** Return the initial rawValue if @param fieldName is an empty String, else return null. */
  public String getFieldValue(String fieldName) {
    return valueMap.get(fieldName);
  }

  @Override
  public String toString() {
    return rawValue;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UntypedSecuritymarksName) {
      UntypedSecuritymarksName that = (UntypedSecuritymarksName) o;
      return this.rawValue.equals(that.rawValue);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return rawValue.hashCode();
  }
}
