/*
 * Copyright 2024 Google LLC
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
public class LinkName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_BUCKET_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/buckets/{bucket}/links/{link}");
  private static final PathTemplate ORGANIZATION_LOCATION_BUCKET_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/buckets/{bucket}/links/{link}");
  private static final PathTemplate FOLDER_LOCATION_BUCKET_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/buckets/{bucket}/links/{link}");
  private static final PathTemplate BILLING_ACCOUNT_LOCATION_BUCKET_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "billingAccounts/{billing_account}/locations/{location}/buckets/{bucket}/links/{link}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String bucket;
  private final String link;
  private final String organization;
  private final String folder;
  private final String billingAccount;

  @Deprecated
  protected LinkName() {
    project = null;
    location = null;
    bucket = null;
    link = null;
    organization = null;
    folder = null;
    billingAccount = null;
  }

  private LinkName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    link = Preconditions.checkNotNull(builder.getLink());
    organization = null;
    folder = null;
    billingAccount = null;
    pathTemplate = PROJECT_LOCATION_BUCKET_LINK;
  }

  private LinkName(OrganizationLocationBucketLinkBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    link = Preconditions.checkNotNull(builder.getLink());
    project = null;
    folder = null;
    billingAccount = null;
    pathTemplate = ORGANIZATION_LOCATION_BUCKET_LINK;
  }

  private LinkName(FolderLocationBucketLinkBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    link = Preconditions.checkNotNull(builder.getLink());
    project = null;
    organization = null;
    billingAccount = null;
    pathTemplate = FOLDER_LOCATION_BUCKET_LINK;
  }

  private LinkName(BillingAccountLocationBucketLinkBuilder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    location = Preconditions.checkNotNull(builder.getLocation());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    link = Preconditions.checkNotNull(builder.getLink());
    project = null;
    organization = null;
    folder = null;
    pathTemplate = BILLING_ACCOUNT_LOCATION_BUCKET_LINK;
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

  public String getLink() {
    return link;
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

  public static Builder newProjectLocationBucketLinkBuilder() {
    return new Builder();
  }

  public static OrganizationLocationBucketLinkBuilder newOrganizationLocationBucketLinkBuilder() {
    return new OrganizationLocationBucketLinkBuilder();
  }

  public static FolderLocationBucketLinkBuilder newFolderLocationBucketLinkBuilder() {
    return new FolderLocationBucketLinkBuilder();
  }

  public static BillingAccountLocationBucketLinkBuilder
      newBillingAccountLocationBucketLinkBuilder() {
    return new BillingAccountLocationBucketLinkBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LinkName of(String project, String location, String bucket, String link) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBucket(bucket)
        .setLink(link)
        .build();
  }

  public static LinkName ofProjectLocationBucketLinkName(
      String project, String location, String bucket, String link) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBucket(bucket)
        .setLink(link)
        .build();
  }

  public static LinkName ofOrganizationLocationBucketLinkName(
      String organization, String location, String bucket, String link) {
    return newOrganizationLocationBucketLinkBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setBucket(bucket)
        .setLink(link)
        .build();
  }

  public static LinkName ofFolderLocationBucketLinkName(
      String folder, String location, String bucket, String link) {
    return newFolderLocationBucketLinkBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setBucket(bucket)
        .setLink(link)
        .build();
  }

  public static LinkName ofBillingAccountLocationBucketLinkName(
      String billingAccount, String location, String bucket, String link) {
    return newBillingAccountLocationBucketLinkBuilder()
        .setBillingAccount(billingAccount)
        .setLocation(location)
        .setBucket(bucket)
        .setLink(link)
        .build();
  }

  public static String format(String project, String location, String bucket, String link) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBucket(bucket)
        .setLink(link)
        .build()
        .toString();
  }

  public static String formatProjectLocationBucketLinkName(
      String project, String location, String bucket, String link) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBucket(bucket)
        .setLink(link)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationBucketLinkName(
      String organization, String location, String bucket, String link) {
    return newOrganizationLocationBucketLinkBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setBucket(bucket)
        .setLink(link)
        .build()
        .toString();
  }

  public static String formatFolderLocationBucketLinkName(
      String folder, String location, String bucket, String link) {
    return newFolderLocationBucketLinkBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setBucket(bucket)
        .setLink(link)
        .build()
        .toString();
  }

  public static String formatBillingAccountLocationBucketLinkName(
      String billingAccount, String location, String bucket, String link) {
    return newBillingAccountLocationBucketLinkBuilder()
        .setBillingAccount(billingAccount)
        .setLocation(location)
        .setBucket(bucket)
        .setLink(link)
        .build()
        .toString();
  }

  public static LinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_BUCKET_LINK.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_BUCKET_LINK.match(formattedString);
      return ofProjectLocationBucketLinkName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("bucket"),
          matchMap.get("link"));
    } else if (ORGANIZATION_LOCATION_BUCKET_LINK.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_BUCKET_LINK.match(formattedString);
      return ofOrganizationLocationBucketLinkName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("bucket"),
          matchMap.get("link"));
    } else if (FOLDER_LOCATION_BUCKET_LINK.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_BUCKET_LINK.match(formattedString);
      return ofFolderLocationBucketLinkName(
          matchMap.get("folder"),
          matchMap.get("location"),
          matchMap.get("bucket"),
          matchMap.get("link"));
    } else if (BILLING_ACCOUNT_LOCATION_BUCKET_LINK.matches(formattedString)) {
      Map<String, String> matchMap = BILLING_ACCOUNT_LOCATION_BUCKET_LINK.match(formattedString);
      return ofBillingAccountLocationBucketLinkName(
          matchMap.get("billing_account"),
          matchMap.get("location"),
          matchMap.get("bucket"),
          matchMap.get("link"));
    }
    throw new ValidationException("LinkName.parse: formattedString not in valid format");
  }

  public static List<LinkName> parseList(List<String> formattedStrings) {
    List<LinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_BUCKET_LINK.matches(formattedString)
        || ORGANIZATION_LOCATION_BUCKET_LINK.matches(formattedString)
        || FOLDER_LOCATION_BUCKET_LINK.matches(formattedString)
        || BILLING_ACCOUNT_LOCATION_BUCKET_LINK.matches(formattedString);
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
          if (link != null) {
            fieldMapBuilder.put("link", link);
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
    if (o != null && getClass() == o.getClass()) {
      LinkName that = ((LinkName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.bucket, that.bucket)
          && Objects.equals(this.link, that.link)
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
    h ^= Objects.hashCode(link);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(billingAccount);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/buckets/{bucket}/links/{link}. */
  public static class Builder {
    private String project;
    private String location;
    private String bucket;
    private String link;

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

    public String getLink() {
      return link;
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

    public Builder setLink(String link) {
      this.link = link;
      return this;
    }

    private Builder(LinkName linkName) {
      Preconditions.checkArgument(
          Objects.equals(linkName.pathTemplate, PROJECT_LOCATION_BUCKET_LINK),
          "toBuilder is only supported when LinkName has the pattern of projects/{project}/locations/{location}/buckets/{bucket}/links/{link}");
      this.project = linkName.project;
      this.location = linkName.location;
      this.bucket = linkName.bucket;
      this.link = linkName.link;
    }

    public LinkName build() {
      return new LinkName(this);
    }
  }

  /**
   * Builder for organizations/{organization}/locations/{location}/buckets/{bucket}/links/{link}.
   */
  public static class OrganizationLocationBucketLinkBuilder {
    private String organization;
    private String location;
    private String bucket;
    private String link;

    protected OrganizationLocationBucketLinkBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getBucket() {
      return bucket;
    }

    public String getLink() {
      return link;
    }

    public OrganizationLocationBucketLinkBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationBucketLinkBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationBucketLinkBuilder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    public OrganizationLocationBucketLinkBuilder setLink(String link) {
      this.link = link;
      return this;
    }

    public LinkName build() {
      return new LinkName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/buckets/{bucket}/links/{link}. */
  public static class FolderLocationBucketLinkBuilder {
    private String folder;
    private String location;
    private String bucket;
    private String link;

    protected FolderLocationBucketLinkBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getBucket() {
      return bucket;
    }

    public String getLink() {
      return link;
    }

    public FolderLocationBucketLinkBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationBucketLinkBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationBucketLinkBuilder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    public FolderLocationBucketLinkBuilder setLink(String link) {
      this.link = link;
      return this;
    }

    public LinkName build() {
      return new LinkName(this);
    }
  }

  /**
   * Builder for
   * billingAccounts/{billing_account}/locations/{location}/buckets/{bucket}/links/{link}.
   */
  public static class BillingAccountLocationBucketLinkBuilder {
    private String billingAccount;
    private String location;
    private String bucket;
    private String link;

    protected BillingAccountLocationBucketLinkBuilder() {}

    public String getBillingAccount() {
      return billingAccount;
    }

    public String getLocation() {
      return location;
    }

    public String getBucket() {
      return bucket;
    }

    public String getLink() {
      return link;
    }

    public BillingAccountLocationBucketLinkBuilder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public BillingAccountLocationBucketLinkBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public BillingAccountLocationBucketLinkBuilder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    public BillingAccountLocationBucketLinkBuilder setLink(String link) {
      this.link = link;
      return this;
    }

    public LinkName build() {
      return new LinkName(this);
    }
  }
}
