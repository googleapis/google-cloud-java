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

package com.google.storage.control.v2;

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
public class ManagedFolderName implements ResourceName {
  private static final PathTemplate PROJECT_BUCKET_MANAGED_FOLDER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/buckets/{bucket}/managedFolders/{managed_folder=**}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String bucket;
  private final String managedFolder;

  @Deprecated
  protected ManagedFolderName() {
    project = null;
    bucket = null;
    managedFolder = null;
  }

  private ManagedFolderName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    managedFolder = Preconditions.checkNotNull(builder.getManagedFolder());
  }

  public String getProject() {
    return project;
  }

  public String getBucket() {
    return bucket;
  }

  public String getManagedFolder() {
    return managedFolder;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ManagedFolderName of(String project, String bucket, String managedFolder) {
    return newBuilder()
        .setProject(project)
        .setBucket(bucket)
        .setManagedFolder(managedFolder)
        .build();
  }

  public static String format(String project, String bucket, String managedFolder) {
    return newBuilder()
        .setProject(project)
        .setBucket(bucket)
        .setManagedFolder(managedFolder)
        .build()
        .toString();
  }

  public static ManagedFolderName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_BUCKET_MANAGED_FOLDER.validatedMatch(
            formattedString, "ManagedFolderName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("bucket"), matchMap.get("managed_folder"));
  }

  public static List<ManagedFolderName> parseList(List<String> formattedStrings) {
    List<ManagedFolderName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ManagedFolderName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ManagedFolderName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_BUCKET_MANAGED_FOLDER.matches(formattedString);
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
          if (bucket != null) {
            fieldMapBuilder.put("bucket", bucket);
          }
          if (managedFolder != null) {
            fieldMapBuilder.put("managed_folder", managedFolder);
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
    return PROJECT_BUCKET_MANAGED_FOLDER.instantiate(
        "project", project, "bucket", bucket, "managed_folder", managedFolder);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ManagedFolderName that = ((ManagedFolderName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.bucket, that.bucket)
          && Objects.equals(this.managedFolder, that.managedFolder);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(bucket);
    h *= 1000003;
    h ^= Objects.hashCode(managedFolder);
    return h;
  }

  /** Builder for projects/{project}/buckets/{bucket}/managedFolders/{managed_folder=&#42;&#42;}. */
  public static class Builder {
    private String project;
    private String bucket;
    private String managedFolder;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getBucket() {
      return bucket;
    }

    public String getManagedFolder() {
      return managedFolder;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    public Builder setManagedFolder(String managedFolder) {
      this.managedFolder = managedFolder;
      return this;
    }

    private Builder(ManagedFolderName managedFolderName) {
      this.project = managedFolderName.project;
      this.bucket = managedFolderName.bucket;
      this.managedFolder = managedFolderName.managedFolder;
    }

    public ManagedFolderName build() {
      return new ManagedFolderName(this);
    }
  }
}
