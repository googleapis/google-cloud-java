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
public class LogViewName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_BUCKET_VIEW =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/buckets/{bucket}/views/{view}");
  private static final PathTemplate ORGANIZATION_LOCATION_BUCKET_VIEW =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/buckets/{bucket}/views/{view}");
  private static final PathTemplate FOLDER_LOCATION_BUCKET_VIEW =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/buckets/{bucket}/views/{view}");
  private static final PathTemplate BILLING_ACCOUNT_LOCATION_BUCKET_VIEW =
      PathTemplate.createWithoutUrlEncoding(
          "billingAccounts/{billing_account}/locations/{location}/buckets/{bucket}/views/{view}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String bucket;
  private final String view;
  private final String organization;
  private final String folder;
  private final String billingAccount;

  @Deprecated
  protected LogViewName() {
    project = null;
    location = null;
    bucket = null;
    view = null;
    organization = null;
    folder = null;
    billingAccount = null;
  }

  private LogViewName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    view = Preconditions.checkNotNull(builder.getView());
    organization = null;
    folder = null;
    billingAccount = null;
    pathTemplate = PROJECT_LOCATION_BUCKET_VIEW;
  }

  private LogViewName(OrganizationLocationBucketViewBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    view = Preconditions.checkNotNull(builder.getView());
    project = null;
    folder = null;
    billingAccount = null;
    pathTemplate = ORGANIZATION_LOCATION_BUCKET_VIEW;
  }

  private LogViewName(FolderLocationBucketViewBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    view = Preconditions.checkNotNull(builder.getView());
    project = null;
    organization = null;
    billingAccount = null;
    pathTemplate = FOLDER_LOCATION_BUCKET_VIEW;
  }

  private LogViewName(BillingAccountLocationBucketViewBuilder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    location = Preconditions.checkNotNull(builder.getLocation());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    view = Preconditions.checkNotNull(builder.getView());
    project = null;
    organization = null;
    folder = null;
    pathTemplate = BILLING_ACCOUNT_LOCATION_BUCKET_VIEW;
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

  public String getView() {
    return view;
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
  public static Builder newProjectLocationBucketViewBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationLocationBucketViewBuilder newOrganizationLocationBucketViewBuilder() {
    return new OrganizationLocationBucketViewBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderLocationBucketViewBuilder newFolderLocationBucketViewBuilder() {
    return new FolderLocationBucketViewBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static BillingAccountLocationBucketViewBuilder
      newBillingAccountLocationBucketViewBuilder() {
    return new BillingAccountLocationBucketViewBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LogViewName of(String project, String location, String bucket, String view) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBucket(bucket)
        .setView(view)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LogViewName ofProjectLocationBucketViewName(
      String project, String location, String bucket, String view) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBucket(bucket)
        .setView(view)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LogViewName ofOrganizationLocationBucketViewName(
      String organization, String location, String bucket, String view) {
    return newOrganizationLocationBucketViewBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setBucket(bucket)
        .setView(view)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LogViewName ofFolderLocationBucketViewName(
      String folder, String location, String bucket, String view) {
    return newFolderLocationBucketViewBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setBucket(bucket)
        .setView(view)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static LogViewName ofBillingAccountLocationBucketViewName(
      String billingAccount, String location, String bucket, String view) {
    return newBillingAccountLocationBucketViewBuilder()
        .setBillingAccount(billingAccount)
        .setLocation(location)
        .setBucket(bucket)
        .setView(view)
        .build();
  }

  public static String format(String project, String location, String bucket, String view) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBucket(bucket)
        .setView(view)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationBucketViewName(
      String project, String location, String bucket, String view) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBucket(bucket)
        .setView(view)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationBucketViewName(
      String organization, String location, String bucket, String view) {
    return newOrganizationLocationBucketViewBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setBucket(bucket)
        .setView(view)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderLocationBucketViewName(
      String folder, String location, String bucket, String view) {
    return newFolderLocationBucketViewBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setBucket(bucket)
        .setView(view)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatBillingAccountLocationBucketViewName(
      String billingAccount, String location, String bucket, String view) {
    return newBillingAccountLocationBucketViewBuilder()
        .setBillingAccount(billingAccount)
        .setLocation(location)
        .setBucket(bucket)
        .setView(view)
        .build()
        .toString();
  }

  public static LogViewName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_BUCKET_VIEW.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_BUCKET_VIEW.match(formattedString);
      return ofProjectLocationBucketViewName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("bucket"),
          matchMap.get("view"));
    } else if (ORGANIZATION_LOCATION_BUCKET_VIEW.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_BUCKET_VIEW.match(formattedString);
      return ofOrganizationLocationBucketViewName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("bucket"),
          matchMap.get("view"));
    } else if (FOLDER_LOCATION_BUCKET_VIEW.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_BUCKET_VIEW.match(formattedString);
      return ofFolderLocationBucketViewName(
          matchMap.get("folder"),
          matchMap.get("location"),
          matchMap.get("bucket"),
          matchMap.get("view"));
    } else if (BILLING_ACCOUNT_LOCATION_BUCKET_VIEW.matches(formattedString)) {
      Map<String, String> matchMap = BILLING_ACCOUNT_LOCATION_BUCKET_VIEW.match(formattedString);
      return ofBillingAccountLocationBucketViewName(
          matchMap.get("billing_account"),
          matchMap.get("location"),
          matchMap.get("bucket"),
          matchMap.get("view"));
    }
    throw new ValidationException("LogViewName.parse: formattedString not in valid format");
  }

  public static List<LogViewName> parseList(List<String> formattedStrings) {
    List<LogViewName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LogViewName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LogViewName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_BUCKET_VIEW.matches(formattedString)
        || ORGANIZATION_LOCATION_BUCKET_VIEW.matches(formattedString)
        || FOLDER_LOCATION_BUCKET_VIEW.matches(formattedString)
        || BILLING_ACCOUNT_LOCATION_BUCKET_VIEW.matches(formattedString);
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
          if (view != null) {
            fieldMapBuilder.put("view", view);
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
      LogViewName that = ((LogViewName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.bucket, that.bucket)
          && Objects.equals(this.view, that.view)
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
    h ^= Objects.hashCode(view);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(billingAccount);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/buckets/{bucket}/views/{view}. */
  public static class Builder {
    private String project;
    private String location;
    private String bucket;
    private String view;

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

    public String getView() {
      return view;
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

    public Builder setView(String view) {
      this.view = view;
      return this;
    }

    private Builder(LogViewName logViewName) {
      Preconditions.checkArgument(
          Objects.equals(logViewName.pathTemplate, PROJECT_LOCATION_BUCKET_VIEW),
          "toBuilder is only supported when LogViewName has the pattern of projects/{project}/locations/{location}/buckets/{bucket}/views/{view}");
      project = logViewName.project;
      location = logViewName.location;
      bucket = logViewName.bucket;
      view = logViewName.view;
    }

    public LogViewName build() {
      return new LogViewName(this);
    }
  }

  /**
   * Builder for organizations/{organization}/locations/{location}/buckets/{bucket}/views/{view}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationLocationBucketViewBuilder {
    private String organization;
    private String location;
    private String bucket;
    private String view;

    protected OrganizationLocationBucketViewBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getBucket() {
      return bucket;
    }

    public String getView() {
      return view;
    }

    public OrganizationLocationBucketViewBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationBucketViewBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationBucketViewBuilder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    public OrganizationLocationBucketViewBuilder setView(String view) {
      this.view = view;
      return this;
    }

    public LogViewName build() {
      return new LogViewName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/buckets/{bucket}/views/{view}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderLocationBucketViewBuilder {
    private String folder;
    private String location;
    private String bucket;
    private String view;

    protected FolderLocationBucketViewBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getBucket() {
      return bucket;
    }

    public String getView() {
      return view;
    }

    public FolderLocationBucketViewBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationBucketViewBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationBucketViewBuilder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    public FolderLocationBucketViewBuilder setView(String view) {
      this.view = view;
      return this;
    }

    public LogViewName build() {
      return new LogViewName(this);
    }
  }

  /**
   * Builder for
   * billingAccounts/{billing_account}/locations/{location}/buckets/{bucket}/views/{view}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class BillingAccountLocationBucketViewBuilder {
    private String billingAccount;
    private String location;
    private String bucket;
    private String view;

    protected BillingAccountLocationBucketViewBuilder() {}

    public String getBillingAccount() {
      return billingAccount;
    }

    public String getLocation() {
      return location;
    }

    public String getBucket() {
      return bucket;
    }

    public String getView() {
      return view;
    }

    public BillingAccountLocationBucketViewBuilder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public BillingAccountLocationBucketViewBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public BillingAccountLocationBucketViewBuilder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    public BillingAccountLocationBucketViewBuilder setView(String view) {
      this.view = view;
      return this;
    }

    public LogViewName build() {
      return new LogViewName(this);
    }
  }
}
