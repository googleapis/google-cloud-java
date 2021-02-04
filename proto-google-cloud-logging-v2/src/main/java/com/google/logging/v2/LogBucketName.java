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

package com.google.logging.v2;

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
public class LogBucketName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_BUCKET =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/buckets/{bucket}");
  private static final PathTemplate ORGANIZATION_LOCATION_BUCKET =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/buckets/{bucket}");
  private static final PathTemplate FOLDER_LOCATION_BUCKET =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/buckets/{bucket}");
  private static final PathTemplate BILLING_ACCOUNT_LOCATION_BUCKET =
      PathTemplate.createWithoutUrlEncoding(
          "billingAccounts/{billing_account}/locations/{location}/buckets/{bucket}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String bucket;
  private final String organization;
  private final String folder;
  private final String billingAccount;

  @Deprecated
  protected LogBucketName() {
    project = null;
    location = null;
    bucket = null;
    organization = null;
    folder = null;
    billingAccount = null;
  }

  private LogBucketName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    organization = null;
    folder = null;
    billingAccount = null;
    pathTemplate = PROJECT_LOCATION_BUCKET;
  }

  private LogBucketName(OrganizationLocationBucketBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    project = null;
    folder = null;
    billingAccount = null;
    pathTemplate = ORGANIZATION_LOCATION_BUCKET;
  }

  private LogBucketName(FolderLocationBucketBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    project = null;
    organization = null;
    billingAccount = null;
    pathTemplate = FOLDER_LOCATION_BUCKET;
  }

  private LogBucketName(BillingAccountLocationBucketBuilder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    location = Preconditions.checkNotNull(builder.getLocation());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    project = null;
    organization = null;
    folder = null;
    pathTemplate = BILLING_ACCOUNT_LOCATION_BUCKET;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getBucket() {
    return bucket;
  }

  public String getOrganization() {
    return organization;
  }

  public String getFolder() {
    return folder;
  }

  public String getBillingAccount() {
    return billingAccount;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationBucketBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationLocationBucketBuilder newOrganizationLocationBucketBuilder() {
    return new OrganizationLocationBucketBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderLocationBucketBuilder newFolderLocationBucketBuilder() {
    return new FolderLocationBucketBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static BillingAccountLocationBucketBuilder newBillingAccountLocationBucketBuilder() {
    return new BillingAccountLocationBucketBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LogBucketName of(String project, String location, String bucket) {
    return newBuilder().setProject(project).setLocation(location).setBucket(bucket).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LogBucketName ofProjectLocationBucketName(
      String project, String location, String bucket) {
    return newBuilder().setProject(project).setLocation(location).setBucket(bucket).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LogBucketName ofOrganizationLocationBucketName(
      String organization, String location, String bucket) {
    return newOrganizationLocationBucketBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setBucket(bucket)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LogBucketName ofFolderLocationBucketName(
      String folder, String location, String bucket) {
    return newFolderLocationBucketBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setBucket(bucket)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LogBucketName ofBillingAccountLocationBucketName(
      String billingAccount, String location, String bucket) {
    return newBillingAccountLocationBucketBuilder()
        .setBillingAccount(billingAccount)
        .setLocation(location)
        .setBucket(bucket)
        .build();
  }

  public static String format(String project, String location, String bucket) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBucket(bucket)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationBucketName(
      String project, String location, String bucket) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBucket(bucket)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationBucketName(
      String organization, String location, String bucket) {
    return newOrganizationLocationBucketBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setBucket(bucket)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderLocationBucketName(
      String folder, String location, String bucket) {
    return newFolderLocationBucketBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setBucket(bucket)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatBillingAccountLocationBucketName(
      String billingAccount, String location, String bucket) {
    return newBillingAccountLocationBucketBuilder()
        .setBillingAccount(billingAccount)
        .setLocation(location)
        .setBucket(bucket)
        .build()
        .toString();
  }

  public static LogBucketName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_BUCKET.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_BUCKET.match(formattedString);
      return ofProjectLocationBucketName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("bucket"));
    } else if (ORGANIZATION_LOCATION_BUCKET.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_BUCKET.match(formattedString);
      return ofOrganizationLocationBucketName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("bucket"));
    } else if (FOLDER_LOCATION_BUCKET.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_BUCKET.match(formattedString);
      return ofFolderLocationBucketName(
          matchMap.get("folder"), matchMap.get("location"), matchMap.get("bucket"));
    } else if (BILLING_ACCOUNT_LOCATION_BUCKET.matches(formattedString)) {
      Map<String, String> matchMap = BILLING_ACCOUNT_LOCATION_BUCKET.match(formattedString);
      return ofBillingAccountLocationBucketName(
          matchMap.get("billing_account"), matchMap.get("location"), matchMap.get("bucket"));
    }
    throw new ValidationException("LogBucketName.parse: formattedString not in valid format");
  }

  public static List<LogBucketName> parseList(List<String> formattedStrings) {
    List<LogBucketName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LogBucketName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LogBucketName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_BUCKET.matches(formattedString)
        || ORGANIZATION_LOCATION_BUCKET.matches(formattedString)
        || FOLDER_LOCATION_BUCKET.matches(formattedString)
        || BILLING_ACCOUNT_LOCATION_BUCKET.matches(formattedString);
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
          if (bucket != null) {
            fieldMapBuilder.put("bucket", bucket);
          }
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
          }
          if (billingAccount != null) {
            fieldMapBuilder.put("billing_account", billingAccount);
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
      LogBucketName that = ((LogBucketName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.bucket, that.bucket)
          && Objects.equals(this.organization, that.organization)
          && Objects.equals(this.folder, that.folder)
          && Objects.equals(this.billingAccount, that.billingAccount);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(bucket);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(billingAccount);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/buckets/{bucket}. */
  public static class Builder {
    private String project;
    private String location;
    private String bucket;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getBucket() {
      return bucket;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    private Builder(LogBucketName logBucketName) {
      Preconditions.checkArgument(
          Objects.equals(logBucketName.pathTemplate, PROJECT_LOCATION_BUCKET),
          "toBuilder is only supported when LogBucketName has the pattern of projects/{project}/locations/{location}/buckets/{bucket}");
      project = logBucketName.project;
      location = logBucketName.location;
      bucket = logBucketName.bucket;
    }

    public LogBucketName build() {
      return new LogBucketName(this);
    }
  }

  /** Builder for organizations/{organization}/locations/{location}/buckets/{bucket}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationLocationBucketBuilder {
    private String organization;
    private String location;
    private String bucket;

    protected OrganizationLocationBucketBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getBucket() {
      return bucket;
    }

    public OrganizationLocationBucketBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationBucketBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationBucketBuilder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    public LogBucketName build() {
      return new LogBucketName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/buckets/{bucket}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderLocationBucketBuilder {
    private String folder;
    private String location;
    private String bucket;

    protected FolderLocationBucketBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getBucket() {
      return bucket;
    }

    public FolderLocationBucketBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationBucketBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationBucketBuilder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    public LogBucketName build() {
      return new LogBucketName(this);
    }
  }

  /** Builder for billingAccounts/{billing_account}/locations/{location}/buckets/{bucket}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class BillingAccountLocationBucketBuilder {
    private String billingAccount;
    private String location;
    private String bucket;

    protected BillingAccountLocationBucketBuilder() {}

    public String getBillingAccount() {
      return billingAccount;
    }

    public String getLocation() {
      return location;
    }

    public String getBucket() {
      return bucket;
    }

    public BillingAccountLocationBucketBuilder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public BillingAccountLocationBucketBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public BillingAccountLocationBucketBuilder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    public LogBucketName build() {
      return new LogBucketName(this);
    }
  }
}
