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

import com.google.api.pathtemplate.PathTemplate;
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
public class FindingSecurityMarksName extends SecuritymarksName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/sources/{source}/findings/{finding}/securityMarks");

  private volatile Map<String, String> fieldValuesMap;

  private final String organization;
  private final String source;
  private final String finding;

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

  private FindingSecurityMarksName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    source = Preconditions.checkNotNull(builder.getSource());
    finding = Preconditions.checkNotNull(builder.getFinding());
  }

  public static FindingSecurityMarksName of(String organization, String source, String finding) {
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

  public static FindingSecurityMarksName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "FindingSecurityMarksName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("source"), matchMap.get("finding"));
  }

  public static List<FindingSecurityMarksName> parseList(List<String> formattedStrings) {
    List<FindingSecurityMarksName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FindingSecurityMarksName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (FindingSecurityMarksName value : values) {
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
          fieldMapBuilder.put("organization", organization);
          fieldMapBuilder.put("source", source);
          fieldMapBuilder.put("finding", finding);
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
    return PATH_TEMPLATE.instantiate(
        "organization", organization, "source", source, "finding", finding);
  }

  /** Builder for FindingSecurityMarksName. */
  public static class Builder {

    private String organization;
    private String source;
    private String finding;

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

    private Builder() {}

    private Builder(FindingSecurityMarksName findingSecurityMarksName) {
      organization = findingSecurityMarksName.organization;
      source = findingSecurityMarksName.source;
      finding = findingSecurityMarksName.finding;
    }

    public FindingSecurityMarksName build() {
      return new FindingSecurityMarksName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof FindingSecurityMarksName) {
      FindingSecurityMarksName that = (FindingSecurityMarksName) o;
      return (this.organization.equals(that.organization))
          && (this.source.equals(that.source))
          && (this.finding.equals(that.finding));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= organization.hashCode();
    h *= 1000003;
    h ^= source.hashCode();
    h *= 1000003;
    h ^= finding.hashCode();
    return h;
  }
}
