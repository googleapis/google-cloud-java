/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * The location in Cloud Storage and naming method of the daily usage report. Contains bucket_name
 * and report_name prefix.
 */
public final class UsageExportLocation implements ApiMessage {
  private final String bucketName;
  private final String reportNamePrefix;

  private UsageExportLocation() {
    this.bucketName = null;
    this.reportNamePrefix = null;
  }

  private UsageExportLocation(String bucketName, String reportNamePrefix) {
    this.bucketName = bucketName;
    this.reportNamePrefix = reportNamePrefix;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("bucketName".equals(fieldName)) {
      return bucketName;
    }
    if ("reportNamePrefix".equals(fieldName)) {
      return reportNamePrefix;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  public List<String> getFieldMask() {
    return null;
  }

  /**
   * The name of an existing bucket in Cloud Storage where the usage report object is stored. The
   * Google Service Account is granted write access to this bucket. This can either be the bucket
   * name by itself, such as example-bucket, or the bucket name with gs:// or
   * https://storage.googleapis.com/ in front of it, such as gs://example-bucket.
   */
  public String getBucketName() {
    return bucketName;
  }

  /**
   * An optional prefix for the name of the usage report object stored in bucketName. If not
   * supplied, defaults to usage. The report is stored as a CSV file named
   * report_name_prefix_gce_YYYYMMDD.csv where YYYYMMDD is the day of the usage according to Pacific
   * Time. If you supply a prefix, it should conform to Cloud Storage object naming conventions.
   */
  public String getReportNamePrefix() {
    return reportNamePrefix;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(UsageExportLocation prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static UsageExportLocation getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final UsageExportLocation DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new UsageExportLocation();
  }

  public static class Builder {
    private String bucketName;
    private String reportNamePrefix;

    Builder() {}

    public Builder mergeFrom(UsageExportLocation other) {
      if (other == UsageExportLocation.getDefaultInstance()) return this;
      if (other.getBucketName() != null) {
        this.bucketName = other.bucketName;
      }
      if (other.getReportNamePrefix() != null) {
        this.reportNamePrefix = other.reportNamePrefix;
      }
      return this;
    }

    Builder(UsageExportLocation source) {
      this.bucketName = source.bucketName;
      this.reportNamePrefix = source.reportNamePrefix;
    }

    /**
     * The name of an existing bucket in Cloud Storage where the usage report object is stored. The
     * Google Service Account is granted write access to this bucket. This can either be the bucket
     * name by itself, such as example-bucket, or the bucket name with gs:// or
     * https://storage.googleapis.com/ in front of it, such as gs://example-bucket.
     */
    public String getBucketName() {
      return bucketName;
    }

    /**
     * The name of an existing bucket in Cloud Storage where the usage report object is stored. The
     * Google Service Account is granted write access to this bucket. This can either be the bucket
     * name by itself, such as example-bucket, or the bucket name with gs:// or
     * https://storage.googleapis.com/ in front of it, such as gs://example-bucket.
     */
    public Builder setBucketName(String bucketName) {
      this.bucketName = bucketName;
      return this;
    }

    /**
     * An optional prefix for the name of the usage report object stored in bucketName. If not
     * supplied, defaults to usage. The report is stored as a CSV file named
     * report_name_prefix_gce_YYYYMMDD.csv where YYYYMMDD is the day of the usage according to
     * Pacific Time. If you supply a prefix, it should conform to Cloud Storage object naming
     * conventions.
     */
    public String getReportNamePrefix() {
      return reportNamePrefix;
    }

    /**
     * An optional prefix for the name of the usage report object stored in bucketName. If not
     * supplied, defaults to usage. The report is stored as a CSV file named
     * report_name_prefix_gce_YYYYMMDD.csv where YYYYMMDD is the day of the usage according to
     * Pacific Time. If you supply a prefix, it should conform to Cloud Storage object naming
     * conventions.
     */
    public Builder setReportNamePrefix(String reportNamePrefix) {
      this.reportNamePrefix = reportNamePrefix;
      return this;
    }

    public UsageExportLocation build() {

      return new UsageExportLocation(bucketName, reportNamePrefix);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setBucketName(this.bucketName);
      newBuilder.setReportNamePrefix(this.reportNamePrefix);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "UsageExportLocation{"
        + "bucketName="
        + bucketName
        + ", "
        + "reportNamePrefix="
        + reportNamePrefix
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UsageExportLocation) {
      UsageExportLocation that = (UsageExportLocation) o;
      return Objects.equals(this.bucketName, that.getBucketName())
          && Objects.equals(this.reportNamePrefix, that.getReportNamePrefix());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucketName, reportNamePrefix);
  }
}
