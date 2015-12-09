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
import com.google.api.services.bigquery.model.JobConfigurationLoad;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import com.google.gcloud.bigquery.JobStatistics.LoadStatistics;

import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Load Job. A Load Job loads data from one of several formats into a table. Data is
 * provided as URIs that point to objects in Google Cloud Storage.
 */
public class LoadJobInfo extends JobInfo<LoadStatistics> {

  private static final long serialVersionUID = 2515503817007974115L;

  private final List<String> sourceUris;
  private final TableId destinationTable;
  private final CreateDisposition createDisposition;
  private final WriteDisposition writeDisposition;
  private final FormatOptions formatOptions;
  private final Integer maxBadRecords;
  private final Schema schema;
  private final Boolean ignoreUnknownValues;
  private final List<String> projectionFields;

  public static final class Builder extends JobInfo.Builder<LoadJobInfo, LoadStatistics, Builder> {

    private List<String> sourceUris;
    private TableId destinationTable;
    private CreateDisposition createDisposition;
    private WriteDisposition writeDisposition;
    private FormatOptions formatOptions;
    private Integer maxBadRecords;
    private Schema schema;
    private Boolean ignoreUnknownValues;
    private List<String> projectionFields;

    private Builder() {}

    private Builder(LoadJobInfo jobInfo) {
      super(jobInfo);
      this.sourceUris = jobInfo.sourceUris;
      this.destinationTable = jobInfo.destinationTable;
      this.createDisposition = jobInfo.createDisposition;
      this.writeDisposition = jobInfo.writeDisposition;
      this.formatOptions = jobInfo.formatOptions;
      this.maxBadRecords = jobInfo.maxBadRecords;
      this.schema = jobInfo.schema;
      this.ignoreUnknownValues = jobInfo.ignoreUnknownValues;
      this.projectionFields = jobInfo.projectionFields;
    }

    private Builder(Job jobPb) {
      super(jobPb);
      JobConfigurationLoad loadConfigurationPb = jobPb.getConfiguration().getLoad();
      this.sourceUris = loadConfigurationPb.getSourceUris();
      this.destinationTable = TableId.fromPb(loadConfigurationPb.getDestinationTable());
      if (loadConfigurationPb.getCreateDisposition() != null) {
        this.createDisposition =
            CreateDisposition.valueOf(loadConfigurationPb.getCreateDisposition());
      }
      if (loadConfigurationPb.getWriteDisposition() != null) {
        this.writeDisposition = WriteDisposition.valueOf(loadConfigurationPb.getWriteDisposition());
      }
      if (loadConfigurationPb.getSourceFormat() != null) {
        this.formatOptions = FormatOptions.of(loadConfigurationPb.getSourceFormat());
      }
      if (loadConfigurationPb.getAllowJaggedRows() != null
          || loadConfigurationPb.getAllowQuotedNewlines() != null
          || loadConfigurationPb.getEncoding() != null
          || loadConfigurationPb.getFieldDelimiter() != null
          || loadConfigurationPb.getQuote() != null
          || loadConfigurationPb.getSkipLeadingRows() != null) {
        CsvOptions.Builder builder = CsvOptions.builder()
            .allowJaggedRows(loadConfigurationPb.getAllowJaggedRows())
            .allowQuotedNewLines(loadConfigurationPb.getAllowQuotedNewlines())
            .encoding(loadConfigurationPb.getEncoding())
            .fieldDelimiter(loadConfigurationPb.getFieldDelimiter())
            .quote(loadConfigurationPb.getQuote())
            .skipLeadingRows(loadConfigurationPb.getSkipLeadingRows());
        this.formatOptions = builder.build();
      }
      this.maxBadRecords = loadConfigurationPb.getMaxBadRecords();
      if (loadConfigurationPb.getSchema() != null) {
        this.schema = Schema.fromPb(loadConfigurationPb.getSchema());
      }
      this.ignoreUnknownValues = loadConfigurationPb.getIgnoreUnknownValues();
      this.projectionFields = loadConfigurationPb.getProjectionFields();
    }

    /**
     * Sets the fully-qualified URIs that point to source data in Google Cloud Storage (e.g.
     * gs://bucket/path). Each URI can contain one '*' wildcard character and it must come after the
     * 'bucket' name.
     */
    public Builder sourceUris(List<String> sourceUris) {
      this.sourceUris = sourceUris != null ? ImmutableList.copyOf(sourceUris) : null;
      return this;
    }

    /**
     * Sets the destination table to load the data into.
     */
    public Builder destinationTable(TableId destinationTable) {
      this.destinationTable = destinationTable;
      return this;
    }

    /**
     * Sets whether the job is allowed to create new tables.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.load">
     *     Jobs: Load Configuration</a>
     */
    public Builder createDisposition(CreateDisposition createDisposition) {
      this.createDisposition = createDisposition;
      return this;
    }

    /**
     * Sets the action that should occur if the destination table already exists.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.load">
     *     Jobs: Load Configuration</a>
     */
    public Builder writeDisposition(WriteDisposition writeDisposition) {
      this.writeDisposition = writeDisposition;
      return this;
    }

    /**
     * Sets the source format, and possibly some parsing options, of the external data. Supported
     * formats are {@code CSV}, {@code NEWLINE_DELIMITED_JSON} and {@code DATASTORE_BACKUP}. If not
     * specified, {@code CSV} format is assumed.
     *
     * <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
     *     Source Format</a>
     */
    public Builder formatOptions(FormatOptions formatOptions) {
      this.formatOptions = formatOptions;
      return this;
    }

    /**
     * Sets the maximum number of bad records that BigQuery can ignore when running the job. If the
     * number of bad records exceeds this value, an invalid error is returned in the job result.
     * By default no bad record is ignored.
     */
    public Builder maxBadRecords(Integer maxBadRecords) {
      this.maxBadRecords = maxBadRecords;
      return this;
    }

    /**
     * Sets the schema for the destination table. The schema can be omitted if the destination table
     * already exists, or if you're loading data from Google Cloud Datastore.
     */
    public Builder schema(Schema schema) {
      this.schema = schema;
      return this;
    }

    /**
     * Sets whether BigQuery should allow extra values that are not represented in the table schema.
     * If {@code true}, the extra values are ignored. If {@code true}, records with extra columns
     * are treated as bad records, and if there are too many bad records, an invalid error is
     * returned in the job result. By default unknown values are not allowed.
     */
    public Builder ignoreUnknownValues(Boolean ignoreUnknownValues) {
      this.ignoreUnknownValues = ignoreUnknownValues;
      return this;
    }

    /**
     * Sets which entity properties to load into BigQuery from a Cloud Datastore backup. This field
     * is only used if the source format is set to {@code DATASTORE_BACKUP}. Property names are case
     * sensitive and must be top-level properties. If no properties are specified, BigQuery loads
     * all properties. If any named property isn't found in the Cloud Datastore backup, an invalid
     * error is returned in the job result.
     */
    public Builder projectionFields(List<String> projectionFields) {
      this.projectionFields =
          projectionFields != null ? ImmutableList.copyOf(projectionFields) : null;
      return this;
    }

    @Override
    public LoadJobInfo build() {
      return new LoadJobInfo(this);
    }
  }

  private LoadJobInfo(Builder builder) {
    super(builder);
    this.sourceUris = builder.sourceUris;
    this.destinationTable = checkNotNull(builder.destinationTable);
    this.createDisposition = builder.createDisposition;
    this.writeDisposition = builder.writeDisposition;
    this.formatOptions = builder.formatOptions;
    this.maxBadRecords = builder.maxBadRecords;
    this.schema = builder.schema;
    this.ignoreUnknownValues = builder.ignoreUnknownValues;
    this.projectionFields = builder.projectionFields;
  }

  /**
   * Returns the fully-qualified URIs that point to source data in Google Cloud Storage (e.g.
   * gs://bucket/path). Each URI can contain one '*' wildcard character and it must come after the
   * 'bucket' name.
   */
  public List<String> sourceUris() {
    return sourceUris;
  }

  /**
   * Returns the destination table to load the data into.
   */
  public TableId destinationTable() {
    return destinationTable;
  }

  /**
   * Returns whether the job is allowed to create new tables.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.load">
   *     Jobs: Load Configuration</a>
   */
  public CreateDisposition createDisposition() {
    return this.createDisposition;
  }

  /**
   * Returns the action that should occur if the destination table already exists.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.load">
   *     Jobs: Load Configuration</a>
   */
  public WriteDisposition writeDisposition() {
    return writeDisposition;
  }

  /**
   * Returns additional properties used to parse CSV data (used when {@link #format()} is set
   * to CSV). Returns {@code null} if not set.
   */
  public CsvOptions csvOptions() {
    return formatOptions instanceof CsvOptions ? (CsvOptions) formatOptions : null;
  }

  /**
   * Returns the maximum number of bad records that BigQuery can ignore when running the job. If the
   * number of bad records exceeds this value, an invalid error is returned in the job result.
   * By default no bad record is ignored.
   */
  public Integer maxBadRecords() {
    return maxBadRecords;
  }

  /**
   * Returns the schema for the destination table, if set. Returns {@code null} otherwise.
   */
  public Schema schema() {
    return schema;
  }

  /**
   * Returns the format of the data files.
   */
  public String format() {
    return formatOptions != null ? formatOptions.type() : null;
  }

  /**
   * Returns whether BigQuery should allow extra values that are not represented in the table
   * schema. If {@code true}, the extra values are ignored. If {@code true}, records with extra
   * columns are treated as bad records, and if there are too many bad records, an invalid error is
   * returned in the job result. By default unknown values are not allowed.
   */
  public Boolean ignoreUnknownValues() {
    return ignoreUnknownValues;
  }

  /**
   * Returns which entity properties to load into BigQuery from a Cloud Datastore backup. This field
   * is only used if the source format is set to {@code DATASTORE_BACKUP}. Property names are case
   * sensitive and must be top-level properties. If no properties are specified, BigQuery loads
   * all properties. If any named property isn't found in the Cloud Datastore backup, an invalid
   * error is returned in the job result.
   */
  public List<String> projectionFields() {
    return projectionFields;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("destinationTable", destinationTable)
        .add("sourceUris", sourceUris)
        .add("createDisposition", createDisposition)
        .add("writeDisposition", writeDisposition)
        .add("formatOptions", formatOptions)
        .add("maxBadRecords", maxBadRecords)
        .add("schema", schema)
        .add("ignoreUnknownValue", ignoreUnknownValues)
        .add("projectionFields", projectionFields);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof LoadJobInfo && Objects.equals(toPb(), ((LoadJobInfo) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), sourceUris, destinationTable, createDisposition,
        writeDisposition, formatOptions, maxBadRecords, schema, ignoreUnknownValues,
        projectionFields);
  }

  @Override
  Job toPb() {
    JobConfigurationLoad loadConfigurationPb = new JobConfigurationLoad();
    loadConfigurationPb.setSourceUris(sourceUris);
    loadConfigurationPb.setDestinationTable(destinationTable.toPb());
    if (createDisposition != null) {
      loadConfigurationPb.setCreateDisposition(createDisposition.toString());
    }
    if (writeDisposition != null) {
      loadConfigurationPb.setWriteDisposition(writeDisposition.toString());
    }
    if (csvOptions() != null) {
      CsvOptions csvOptions = csvOptions();
      loadConfigurationPb.setFieldDelimiter(csvOptions.fieldDelimiter())
          .setAllowJaggedRows(csvOptions.allowJaggedRows())
          .setAllowQuotedNewlines(csvOptions.allowQuotedNewLines())
          .setEncoding(csvOptions.encoding())
          .setQuote(csvOptions.quote())
          .setSkipLeadingRows(csvOptions.skipLeadingRows());
    }
    if (schema != null) {
      loadConfigurationPb.setSchema(schema.toPb());
    }
    if (formatOptions != null) {
      loadConfigurationPb.setSourceFormat(formatOptions.type());
    }
    loadConfigurationPb.setMaxBadRecords(maxBadRecords);
    loadConfigurationPb.setIgnoreUnknownValues(ignoreUnknownValues);
    loadConfigurationPb.setProjectionFields(projectionFields);
    return super.toPb().setConfiguration(new JobConfiguration().setLoad(loadConfigurationPb));
  }

  /**
   * Creates a builder for a BigQuery Load Job given destination table and source URI.
   */
  public static Builder builder(TableId destinationTable, String sourceUri) {
    return builder(destinationTable, ImmutableList.of(checkNotNull(sourceUri)));
  }

  /**
   * Creates a builder for a BigQuery Load Job given destination table and source URIs.
   */
  public static Builder builder(TableId destinationTable, List<String> sourceUris) {
    return new Builder().destinationTable(destinationTable).sourceUris(sourceUris);
  }

  /**
   * Returns a BigQuery Load Job for the given destination table and source URI. Job's id is chosen
   * by the service.
   */
  public static LoadJobInfo of(TableId destinationTable, String sourceUri) {
    return builder(destinationTable, sourceUri).build();
  }

  /**
   * Returns a BigQuery Load Job for the given destination table and source URIs. Job's id is chosen
   * by the service.
   */
  public static LoadJobInfo of(TableId destinationTable, List<String> sourceUris) {
    return builder(destinationTable, sourceUris).build();
  }

  /**
   * Returns a BigQuery Load Job for the given destination table and source URI. Job's id is set to
   * the provided value.
   */
  public static LoadJobInfo of(JobId jobId, TableId destinationTable, String sourceUri) {
    return builder(destinationTable, sourceUri).jobId(jobId).build();
  }

  /**
   * Returns a BigQuery Load Job for the given destination table and source URIs. Job's id is set to
   * the provided value.
   */
  public static LoadJobInfo of(JobId jobId, TableId destinationTable, List<String> sourceUris) {
    return builder(destinationTable, sourceUris).jobId(jobId).build();
  }

  @SuppressWarnings("unchecked")
  static LoadJobInfo fromPb(Job jobPb) {
    return new Builder(jobPb).build();
  }
}
