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

package com.google.cloud.securitycenter.v1p1beta1;

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
public class AssetName implements ResourceName {
  private static final PathTemplate ORGANIZATION_ASSET =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/assets/{asset}");
  private static final PathTemplate FOLDER_ASSET =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/assets/{asset}");
  private static final PathTemplate PROJECT_ASSET =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/assets/{asset}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String asset;
  private final String folder;
  private final String project;

  @Deprecated
  protected AssetName() {
    organization = null;
    asset = null;
    folder = null;
    project = null;
  }

  private AssetName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    asset = Preconditions.checkNotNull(builder.getAsset());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_ASSET;
  }

  private AssetName(FolderAssetBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    asset = Preconditions.checkNotNull(builder.getAsset());
    organization = null;
    project = null;
    pathTemplate = FOLDER_ASSET;
  }

  private AssetName(ProjectAssetBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    asset = Preconditions.checkNotNull(builder.getAsset());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_ASSET;
  }

  public String getOrganization() {
    return organization;
  }

  public String getAsset() {
    return asset;
  }

  public String getFolder() {
    return folder;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newOrganizationAssetBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderAssetBuilder newFolderAssetBuilder() {
    return new FolderAssetBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectAssetBuilder newProjectAssetBuilder() {
    return new ProjectAssetBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AssetName of(String organization, String asset) {
    return newBuilder().setOrganization(organization).setAsset(asset).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AssetName ofOrganizationAssetName(String organization, String asset) {
    return newBuilder().setOrganization(organization).setAsset(asset).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AssetName ofFolderAssetName(String folder, String asset) {
    return newFolderAssetBuilder().setFolder(folder).setAsset(asset).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AssetName ofProjectAssetName(String project, String asset) {
    return newProjectAssetBuilder().setProject(project).setAsset(asset).build();
  }

  public static String format(String organization, String asset) {
    return newBuilder().setOrganization(organization).setAsset(asset).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationAssetName(String organization, String asset) {
    return newBuilder().setOrganization(organization).setAsset(asset).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderAssetName(String folder, String asset) {
    return newFolderAssetBuilder().setFolder(folder).setAsset(asset).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectAssetName(String project, String asset) {
    return newProjectAssetBuilder().setProject(project).setAsset(asset).build().toString();
  }

  public static AssetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_ASSET.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_ASSET.match(formattedString);
      return ofOrganizationAssetName(matchMap.get("organization"), matchMap.get("asset"));
    } else if (FOLDER_ASSET.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_ASSET.match(formattedString);
      return ofFolderAssetName(matchMap.get("folder"), matchMap.get("asset"));
    } else if (PROJECT_ASSET.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_ASSET.match(formattedString);
      return ofProjectAssetName(matchMap.get("project"), matchMap.get("asset"));
    }
    throw new ValidationException("AssetName.parse: formattedString not in valid format");
  }

  public static List<AssetName> parseList(List<String> formattedStrings) {
    List<AssetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AssetName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AssetName value : values) {
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
        || FOLDER_ASSET.matches(formattedString)
        || PROJECT_ASSET.matches(formattedString);
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
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
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
      AssetName that = ((AssetName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.asset, that.asset)
          && Objects.equals(this.folder, that.folder)
          && Objects.equals(this.project, that.project);
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
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/assets/{asset}. */
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

    private Builder(AssetName assetName) {
      Preconditions.checkArgument(
          Objects.equals(assetName.pathTemplate, ORGANIZATION_ASSET),
          "toBuilder is only supported when AssetName has the pattern of organizations/{organization}/assets/{asset}");
      this.organization = assetName.organization;
      this.asset = assetName.asset;
    }

    public AssetName build() {
      return new AssetName(this);
    }
  }

  /** Builder for folders/{folder}/assets/{asset}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderAssetBuilder {
    private String folder;
    private String asset;

    protected FolderAssetBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getAsset() {
      return asset;
    }

    public FolderAssetBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderAssetBuilder setAsset(String asset) {
      this.asset = asset;
      return this;
    }

    public AssetName build() {
      return new AssetName(this);
    }
  }

  /** Builder for projects/{project}/assets/{asset}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectAssetBuilder {
    private String project;
    private String asset;

    protected ProjectAssetBuilder() {}

    public String getProject() {
      return project;
    }

    public String getAsset() {
      return asset;
    }

    public ProjectAssetBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectAssetBuilder setAsset(String asset) {
      this.asset = asset;
      return this;
    }

    public AssetName build() {
      return new AssetName(this);
    }
  }
}
