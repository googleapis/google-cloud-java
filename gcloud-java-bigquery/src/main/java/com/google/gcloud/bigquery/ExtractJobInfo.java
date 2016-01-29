/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.model.Job;
import com.google.api.services.bigquery.model.JobConfiguration;
import com.google.api.services.bigquery.model.JobConfigurationExtract;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import com.google.gcloud.bigquery.JobStatistics.ExtractStatistics;

import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Extract Jobs. An Extract Job exports a BigQuery table to Google Cloud Storage.
 * The extract destination provided as URIs that point to objects in Google Cloud Storage.
 */
public class ExtractJobInfo extends JobInfo<ExtractStatistics> {

  private static final long serialVersionUID = -9126951217071361576L;

  private final TableId sourceTable;
  private final List<String> destinationUris;
  private final Boolean printHeader;
  private final String fieldDelimiter;
  private final String format;
  private final String compression;

  public static final class Builder extends JobInfo.Builder<ExtractJobInfo, ExtractStatistics,
      Builder> {

    private TableId sourceTable;
    private List<String> destinationUris;
    private Boolean printHeader;
    private String fieldDelimiter;
    private String format;
    private String compression;

    private Builder() {}

    private Builder(ExtractJobInfo jobInfo) {
      super(jobInfo);
      this.sourceTable = jobInfo.sourceTable;
      this.destinationUris = jobInfo.destinationUris;
      this.printHeader = jobInfo.printHeader;
      this.fieldDelimiter = jobInfo.fieldDelimiter;
      this.format = jobInfo.format;
      this.compression = jobInfo.compression;
    }

    private Builder(Job jobPb) {
      super(jobPb);
      JobConfigurationExtract extractConfigurationPb = jobPb.getConfiguration().getExtract();
      this.sourceTable = TableId.fromPb(extractConfigurationPb.getSourceTable());
      this.destinationUris = extractConfigurationPb.getDestinationUris();
      this.printHeader = extractConfigurationPb.getPrintHeader();
      this.fieldDelimiter = extractConfigurationPb.getFieldDelimiter();
      this.format = extractConfigurationPb.getDestinationFormat();
      this.compression = extractConfigurationPb.getCompression();
    }

    /**
     * Sets the table to export.
     */
    public Builder sourceTable(TableId sourceTable) {
      this.sourceTable = sourceTable;
      return self();
    }

    /**
     * Sets the list of fully-qualified Google Cloud Storage URIs (e.g. gs://bucket/path) where the
     * extracted table should be written.
     */
    public Builder destinationUris(List<String> destinationUris) {
      this.destinationUris = destinationUris != null ? ImmutableList.copyOf(destinationUris) : null;
      return self();
    }

    /**
     * Sets whether to print out a header row in the results. By default an header is printed.
     */
    public Builder printHeader(Boolean printHeader) {
      this.printHeader = printHeader;
      return self();
    }

    /**
     * Sets the delimiter to use between fields in the exported data. By default "," is used.
     */
    public Builder fieldDelimiter(String fieldDelimiter) {
      this.fieldDelimiter = fieldDelimiter;
      return self();
    }

    /**
     * Sets the exported file format. If not set table is exported in CSV format.
     *
     * <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.extract.destinationFormat">
     *     Destination Format</a>
     */
    public Builder format(String format) {
      this.format = format;
      return self();
    }

    /**
     * Sets the compression value to use for exported files. If not set exported files are not
     * compressed.
     *
     * <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.extract.compression">
     *     Compression</a>
     */
    public Builder compression(String compression) {
      this.compression = compression;
      return self();
    }

    @Override
    public ExtractJobInfo build() {
      return new ExtractJobInfo(this);
    }
  }

  private ExtractJobInfo(Builder builder) {
    super(builder);
    this.sourceTable = checkNotNull(builder.sourceTable);
    this.destinationUris = checkNotNull(builder.destinationUris);
    this.printHeader = builder.printHeader;
    this.fieldDelimiter = builder.fieldDelimiter;
    this.format = builder.format;
    this.compression = builder.compression;
  }

  /**
   * Returns the table to export.
   */
  public TableId sourceTable() {
    return sourceTable;
  }

  /**
   * Returns the list of fully-qualified Google Cloud Storage URIs where the extracted table should
   * be written.
   *
   * @see <a href="https://cloud.google.com/bigquery/exporting-data-from-bigquery#exportingmultiple">
   *     Exporting Data Into One or More Files</a>
   */
  public List<String> destinationUris() {
    return destinationUris;
  }

  /**
   * Returns whether an header row is printed with the result.
   */
  public Boolean printHeader() {
    return printHeader;
  }

  /**
   * Returns the delimiter used between fields in the exported data.
   */
  public String fieldDelimiter() {
    return fieldDelimiter;
  }

  /**
   * Returns the exported files format.
   */
  public String format() {
    return format;
  }

  /**
   * Returns the compression value of exported files.
   */
  public String compression() {
    return compression;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("sourceTable", sourceTable)
        .add("destinationUris", destinationUris)
        .add("format", format)
        .add("printHeader", printHeader)
        .add("fieldDelimiter", fieldDelimiter)
        .add("compression", compression);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof ExtractJobInfo && baseEquals((ExtractJobInfo) obj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), sourceTable, destinationUris, printHeader, fieldDelimiter,
        format, compression);
  }

  @Override
  Job toPb() {
    JobConfigurationExtract extractConfigurationPb = new JobConfigurationExtract();
    extractConfigurationPb.setDestinationUris(destinationUris);
    extractConfigurationPb.setSourceTable(sourceTable.toPb());
    extractConfigurationPb.setPrintHeader(printHeader);
    extractConfigurationPb.setFieldDelimiter(fieldDelimiter);
    extractConfigurationPb.setDestinationFormat(format);
    extractConfigurationPb.setCompression(compression);
    return super.toPb().setConfiguration(new JobConfiguration().setExtract(extractConfigurationPb));
  }

  /**
   * Creates a builder for a BigQuery Extract Job given source table and destination URI.
   */
  public static Builder builder(TableId sourceTable, String destinationUri) {
    return builder(sourceTable, ImmutableList.of(checkNotNull(destinationUri)));
  }

  /**
   * Creates a builder for a BigQuery Extract Job given source table and destination URIs.
   */
  public static Builder builder(TableId sourceTable, List<String> destinationUris) {
    return new Builder().sourceTable(sourceTable).destinationUris(destinationUris);
  }

  /**
   * Returns a BigQuery Extract Job for the given source table and destination URI. Job's id is
   * chosen by the service.
   */
  public static ExtractJobInfo of(TableId sourceTable, String destinationUri) {
    return builder(sourceTable, destinationUri).build();
  }

  /**
   * Returns a BigQuery Extract Job for the given source table and destination URIs. Job's id is
   * chosen by the service.
   */
  public static ExtractJobInfo of(TableId sourceTable, List<String> destinationUris) {
    return builder(sourceTable, destinationUris).build();
  }

  /**
   * Returns a BigQuery Extract Job for the given source table, format and destination URI. Job's id
   * is chosen by the service.
   */
  public static ExtractJobInfo of(TableId sourceTable, String format, String destinationUri) {
    return builder(sourceTable, destinationUri).format(format).build();
  }

  /**
   * Returns a BigQuery Extract Job for the given source table, format and destination URIs. Job's
   * id is chosen by the service.
   */
  public static ExtractJobInfo of(TableId sourceTable, String format,
      List<String> destinationUris) {
    return builder(sourceTable, destinationUris).format(format).build();
  }

  /**
   * Returns a BigQuery Extract Job for the given source table and destination URI. Job's id is set
   * to the provided value.
   */
  public static ExtractJobInfo of(JobId jobId, TableId sourceTable, String destinationUri) {
    return builder(sourceTable, destinationUri).jobId(jobId).build();
  }

  /**
   * Returns a BigQuery Extract Job for the given source table and destination URIs. Job's id is set
   * to the provided value.
   */
  public static ExtractJobInfo of(JobId jobId, TableId sourceTable, List<String> destinationUris) {
    return builder(sourceTable, destinationUris).jobId(jobId).build();
  }

  /**
   * Returns a BigQuery Extract Job for the given source table, format and destination URI. Job's id
   * is set to the provided value.
   */
  public static ExtractJobInfo of(JobId jobId, TableId sourceTable, String format,
      String destinationUri) {
    return builder(sourceTable, destinationUri).format(format).jobId(jobId).build();
  }

  /**
   * Returns a BigQuery Extract Job for the given source table, format and destination URIs. Job's
   * id is set to the provided value.
   */
  public static ExtractJobInfo of(JobId jobId, TableId sourceTable, String format,
      List<String> destinationUris) {
    return builder(sourceTable, destinationUris).format(format).jobId(jobId).build();
  }

  @SuppressWarnings("unchecked")
  static ExtractJobInfo fromPb(Job jobPb) {
    return new Builder(jobPb).build();
  }
}
