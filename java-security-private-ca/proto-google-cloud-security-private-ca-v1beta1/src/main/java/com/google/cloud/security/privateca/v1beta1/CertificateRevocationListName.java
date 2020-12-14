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

package com.google.cloud.security.privateca.v1beta1;

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
public class CertificateRevocationListName implements ResourceName {
  private static final PathTemplate
      PROJECT_LOCATION_CERTIFICATE_AUTHORITY_CERTIFICATE_REVOCATION_LIST =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/certificateAuthorities/{certificate_authority}/certificateRevocationLists/{certificate_revocation_list}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String certificateAuthority;
  private final String certificateRevocationList;

  @Deprecated
  protected CertificateRevocationListName() {
    project = null;
    location = null;
    certificateAuthority = null;
    certificateRevocationList = null;
  }

  private CertificateRevocationListName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    certificateAuthority = Preconditions.checkNotNull(builder.getCertificateAuthority());
    certificateRevocationList = Preconditions.checkNotNull(builder.getCertificateRevocationList());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCertificateAuthority() {
    return certificateAuthority;
  }

  public String getCertificateRevocationList() {
    return certificateRevocationList;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CertificateRevocationListName of(
      String project,
      String location,
      String certificateAuthority,
      String certificateRevocationList) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCertificateAuthority(certificateAuthority)
        .setCertificateRevocationList(certificateRevocationList)
        .build();
  }

  public static String format(
      String project,
      String location,
      String certificateAuthority,
      String certificateRevocationList) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCertificateAuthority(certificateAuthority)
        .setCertificateRevocationList(certificateRevocationList)
        .build()
        .toString();
  }

  public static CertificateRevocationListName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CERTIFICATE_AUTHORITY_CERTIFICATE_REVOCATION_LIST.validatedMatch(
            formattedString,
            "CertificateRevocationListName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("certificate_authority"),
        matchMap.get("certificate_revocation_list"));
  }

  public static List<CertificateRevocationListName> parseList(List<String> formattedStrings) {
    List<CertificateRevocationListName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CertificateRevocationListName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CertificateRevocationListName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CERTIFICATE_AUTHORITY_CERTIFICATE_REVOCATION_LIST.matches(
        formattedString);
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
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (certificateAuthority != null) {
            fieldMapBuilder.put("certificate_authority", certificateAuthority);
          }
          if (certificateRevocationList != null) {
            fieldMapBuilder.put("certificate_revocation_list", certificateRevocationList);
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
    return PROJECT_LOCATION_CERTIFICATE_AUTHORITY_CERTIFICATE_REVOCATION_LIST.instantiate(
        "project",
        project,
        "location",
        location,
        "certificate_authority",
        certificateAuthority,
        "certificate_revocation_list",
        certificateRevocationList);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      CertificateRevocationListName that = ((CertificateRevocationListName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.certificateAuthority, that.certificateAuthority)
          && Objects.equals(this.certificateRevocationList, that.certificateRevocationList);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(certificateAuthority);
    h *= 1000003;
    h ^= Objects.hashCode(certificateRevocationList);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/certificateAuthorities/{certificate_authority}/certificateRevocationLists/{certificate_revocation_list}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String certificateAuthority;
    private String certificateRevocationList;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCertificateAuthority() {
      return certificateAuthority;
    }

    public String getCertificateRevocationList() {
      return certificateRevocationList;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCertificateAuthority(String certificateAuthority) {
      this.certificateAuthority = certificateAuthority;
      return this;
    }

    public Builder setCertificateRevocationList(String certificateRevocationList) {
      this.certificateRevocationList = certificateRevocationList;
      return this;
    }

    private Builder(CertificateRevocationListName certificateRevocationListName) {
      project = certificateRevocationListName.project;
      location = certificateRevocationListName.location;
      certificateAuthority = certificateRevocationListName.certificateAuthority;
      certificateRevocationList = certificateRevocationListName.certificateRevocationList;
    }

    public CertificateRevocationListName build() {
      return new CertificateRevocationListName(this);
    }
  }
}
