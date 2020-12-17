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

package com.google.cloud.securitycenter.v1beta1;

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
public class FindingName implements ResourceName {
  private static final PathTemplate ORGANIZATION_SOURCE_FINDING =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/sources/{source}/findings/{finding}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String source;
  private final String finding;

  @Deprecated
  protected FindingName() {
    organization = null;
    source = null;
    finding = null;
  }

  private FindingName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    source = Preconditions.checkNotNull(builder.getSource());
    finding = Preconditions.checkNotNull(builder.getFinding());
  }

  public String getOrganization() {
    return organization;
  }

  public String getSource() {
    return source;
  }

  public String getFinding() {
    return finding;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FindingName of(String organization, String source, String finding) {
    return newBuilder().setOrganization(organization).setSource(source).setFinding(finding).build();
  }

  public static String format(String organization, String source, String finding) {
    return newBuilder()
        .setOrganization(organization)
        .setSource(source)
        .setFinding(finding)
        .build()
        .toString();
  }

  public static FindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_SOURCE_FINDING.validatedMatch(
            formattedString, "FindingName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("source"), matchMap.get("finding"));
  }

  public static List<FindingName> parseList(List<String> formattedStrings) {
    List<FindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_SOURCE_FINDING.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (source != null) {
            fieldMapBuilder.put("source", source);
          }
          if (finding != null) {
            fieldMapBuilder.put("finding", finding);
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
    return ORGANIZATION_SOURCE_FINDING.instantiate(
        "organization", organization, "source", source, "finding", finding);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      FindingName that = ((FindingName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.source, that.source)
          && Objects.equals(this.finding, that.finding);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(source);
    h *= 1000003;
    h ^= Objects.hashCode(finding);
    return h;
  }

  /** Builder for organizations/{organization}/sources/{source}/findings/{finding}. */
  public static class Builder {
    private String organization;
    private String source;
    private String finding;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getSource() {
      return source;
    }

    public String getFinding() {
      return finding;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setSource(String source) {
      this.source = source;
      return this;
    }

    public Builder setFinding(String finding) {
      this.finding = finding;
      return this;
    }

    private Builder(FindingName findingName) {
      organization = findingName.organization;
      source = findingName.source;
      finding = findingName.finding;
    }

    public FindingName build() {
      return new FindingName(this);
    }
  }
}
