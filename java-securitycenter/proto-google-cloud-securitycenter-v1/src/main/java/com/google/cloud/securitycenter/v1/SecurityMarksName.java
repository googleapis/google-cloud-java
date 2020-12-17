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

package com.google.cloud.securitycenter.v1;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
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
public class SecurityMarksName implements ResourceName {
  private static final PathTemplate ORGANIZATION_ASSET =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/assets/{asset}/securityMarks");
  private static final PathTemplate ORGANIZATION_SOURCE_FINDING =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/sources/{source}/findings/{finding}/securityMarks");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String asset;
  private final String source;
  private final String finding;

  @Deprecated
  protected SecurityMarksName() {
    organization = null;
    asset = null;
    source = null;
    finding = null;
  }

  private SecurityMarksName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    asset = Preconditions.checkNotNull(builder.getAsset());
    source = null;
    finding = null;
    pathTemplate = ORGANIZATION_ASSET;
  }

  private SecurityMarksName(OrganizationSourceFindingSecurityMarksBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    source = Preconditions.checkNotNull(builder.getSource());
    finding = Preconditions.checkNotNull(builder.getFinding());
    asset = null;
    pathTemplate = ORGANIZATION_SOURCE_FINDING;
  }

  public String getOrganization() {
    return organization;
  }

  public String getAsset() {
    return asset;
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

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newOrganizationAssetSecurityMarksBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationSourceFindingSecurityMarksBuilder
      newOrganizationSourceFindingSecurityMarksBuilder() {
    return new OrganizationSourceFindingSecurityMarksBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SecurityMarksName of(String organization, String asset) {
    return newBuilder().setOrganization(organization).setAsset(asset).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SecurityMarksName ofOrganizationAssetSecurityMarksName(
      String organization, String asset) {
    return newBuilder().setOrganization(organization).setAsset(asset).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SecurityMarksName ofOrganizationSourceFindingSecurityMarksName(
      String organization, String source, String finding) {
    return newOrganizationSourceFindingSecurityMarksBuilder()
        .setOrganization(organization)
        .setSource(source)
        .setFinding(finding)
        .build();
  }

  public static String format(String organization, String asset) {
    return newBuilder().setOrganization(organization).setAsset(asset).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationAssetSecurityMarksName(String organization, String asset) {
    return newBuilder().setOrganization(organization).setAsset(asset).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationSourceFindingSecurityMarksName(
      String organization, String source, String finding) {
    return newOrganizationSourceFindingSecurityMarksBuilder()
        .setOrganization(organization)
        .setSource(source)
        .setFinding(finding)
        .build()
        .toString();
  }

  public static SecurityMarksName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_ASSET.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_ASSET.match(formattedString);
      return ofOrganizationAssetSecurityMarksName(
          matchMap.get("organization"), matchMap.get("asset"));
    } else if (ORGANIZATION_SOURCE_FINDING.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_SOURCE_FINDING.match(formattedString);
      return ofOrganizationSourceFindingSecurityMarksName(
          matchMap.get("organization"), matchMap.get("source"), matchMap.get("finding"));
    }
    throw new ValidationException("SecurityMarksName.parse: formattedString not in valid format");
  }

  public static List<SecurityMarksName> parseList(List<String> formattedStrings) {
    List<SecurityMarksName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SecurityMarksName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SecurityMarksName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_ASSET.matches(formattedString)
        || ORGANIZATION_SOURCE_FINDING.matches(formattedString);
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
          if (asset != null) {
            fieldMapBuilder.put("asset", asset);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      SecurityMarksName that = ((SecurityMarksName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.asset, that.asset)
          && Objects.equals(this.source, that.source)
          && Objects.equals(this.finding, that.finding);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(asset);
    h *= 1000003;
    h ^= Objects.hashCode(source);
    h *= 1000003;
    h ^= Objects.hashCode(finding);
    return h;
  }

  /** Builder for organizations/{organization}/assets/{asset}/securityMarks. */
  public static class Builder {
    private String organization;
    private String asset;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getAsset() {
      return asset;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setAsset(String asset) {
      this.asset = asset;
      return this;
    }

    private Builder(SecurityMarksName securityMarksName) {
      Preconditions.checkArgument(
          Objects.equals(securityMarksName.pathTemplate, ORGANIZATION_ASSET),
          "toBuilder is only supported when SecurityMarksName has the pattern of organizations/{organization}/assets/{asset}/securityMarks");
      organization = securityMarksName.organization;
      asset = securityMarksName.asset;
    }

    public SecurityMarksName build() {
      return new SecurityMarksName(this);
    }
  }

  /** Builder for organizations/{organization}/sources/{source}/findings/{finding}/securityMarks. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationSourceFindingSecurityMarksBuilder {
    private String organization;
    private String source;
    private String finding;

    protected OrganizationSourceFindingSecurityMarksBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getSource() {
      return source;
    }

    public String getFinding() {
      return finding;
    }

    public OrganizationSourceFindingSecurityMarksBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationSourceFindingSecurityMarksBuilder setSource(String source) {
      this.source = source;
      return this;
    }

    public OrganizationSourceFindingSecurityMarksBuilder setFinding(String finding) {
      this.finding = finding;
      return this;
    }

    public SecurityMarksName build() {
      return new SecurityMarksName(this);
    }
  }
}
