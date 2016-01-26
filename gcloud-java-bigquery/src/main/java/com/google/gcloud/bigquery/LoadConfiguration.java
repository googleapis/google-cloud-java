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

import com.google.api.services.bigquery.model.JobConfigurationLoad;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.gcloud.bigquery.JobInfo.CreateDisposition;
import com.google.gcloud.bigquery.JobInfo.WriteDisposition;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Configuration for a load operation. A load configuration can be used to load data
 * into a table with a {@link com.google.gcloud.WriteChannel}
 * ({@link BigQuery#writer(LoadConfiguration)}).
 */
public class LoadConfiguration implements Serializable {

  private static final long serialVersionUID = 470267591917413578L;

  protected final TableId destinationTable;
  protected final CreateDisposition createDisposition;
  protected final WriteDisposition writeDisposition;
  protected final FormatOptions formatOptions;
  protected final Integer maxBadRecords;
  protected final Schema schema;
  protected final Boolean ignoreUnknownValues;
  protected final List<String> projectionFields;

  public static class Builder<T extends LoadConfiguration, B extends Builder> {

    private TableId destinationTable;
    private CreateDisposition createDisposition;
    private WriteDisposition writeDisposition;
    private FormatOptions formatOptions;
    private Integer maxBadRecords;
    private Schema schema;
    private Boolean ignoreUnknownValues;
    private List<String> projectionFields;

    protected Builder() {}

    protected Builder(LoadConfiguration loadConfiguration) {
      this.destinationTable = loadConfiguration.destinationTable;
      this.createDisposition = loadConfiguration.createDisposition;
      this.writeDisposition = loadConfiguration.writeDisposition;
      this.formatOptions = loadConfiguration.formatOptions;
      this.maxBadRecords = loadConfiguration.maxBadRecords;
      this.schema = loadConfiguration.schema;
      this.ignoreUnknownValues = loadConfiguration.ignoreUnknownValues;
      this.projectionFields = loadConfiguration.projectionFields;
    }

    protected Builder(com.google.api.services.bigquery.model.JobConfiguration configurationPb) {
      JobConfigurationLoad loadConfigurationPb = configurationPb.getLoad();
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

    @SuppressWarnings("unchecked")
    B self() {
      return (B) this;
    }

    /**
     * Sets the destination table to load the data into.
     */
    public B destinationTable(TableId destinationTable) {
      this.destinationTable = destinationTable;
      return self();
    }

    /**
     * Sets whether the job is allowed to create new tables.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.load.createDisposition">
     *     Create Disposition</a>
     */
    public B createDisposition(CreateDisposition createDisposition) {
      this.createDisposition = createDisposition;
      return self();
    }

    /**
     * Sets the action that should occur if the destination table already exists.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.load.writeDisposition">
     *     Write Disposition</a>
     */
    public B writeDisposition(WriteDisposition writeDisposition) {
      this.writeDisposition = writeDisposition;
      return self();
    }

    /**
     * Sets the source format, and possibly some parsing options, of the external data. Supported
     * formats are {@code CSV}, {@code NEWLINE_DELIMITED_JSON} and {@code DATASTORE_BACKUP}. If not
     * specified, {@code CSV} format is assumed.
     *
     * <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
     *     Source Format</a>
     */
    public B formatOptions(FormatOptions formatOptions) {
      this.formatOptions = formatOptions;
      return self();
    }

    /**
     * Sets the maximum number of bad records that BigQuery can ignore when running the job. If the
     * number of bad records exceeds this value, an invalid error is returned in the job result.
     * By default no bad record is ignored.
     */
    public B maxBadRecords(Integer maxBadRecords) {
      this.maxBadRecords = maxBadRecords;
      return self();
    }

    /**
     * Sets the schema for the destination table. The schema can be omitted if the destination table
     * already exists, or if you're loading data from a Google Cloud Datastore backup (i.e.
     * {@code DATASTORE_BACKUP} format option).
     */
    public B schema(Schema schema) {
      this.schema = schema;
      return self();
    }

    /**
     * Sets whether BigQuery should allow extra values that are not represented in the table schema.
     * If {@code true}, the extra values are ignored. If {@code false}, records with extra columns
     * are treated as bad records, and if there are too many bad records, an invalid error is
     * returned in the job result. By default unknown values are not allowed.
     */
    public B ignoreUnknownValues(Boolean ignoreUnknownValues) {
      this.ignoreUnknownValues = ignoreUnknownValues;
      return self();
    }

    /**
     * Sets which entity properties to load into BigQuery from a Cloud Datastore backup. This field
     * is only used if the source format is set to {@code DATASTORE_BACKUP}. Property names are case
     * sensitive and must be top-level properties. If no properties are specified, BigQuery loads
     * all properties. If any named property isn't found in the Cloud Datastore backup, an invalid
     * error is returned in the job result.
     */
    public B projectionFields(List<String> projectionFields) {
      this.projectionFields =
          projectionFields != null ? ImmutableList.copyOf(projectionFields) : null;
      return self();
    }

    @SuppressWarnings("unchecked")
    public T build() {
      return (T) new LoadConfiguration(this);
    }
  }

  @SuppressWarnings("unchecked")
  protected LoadConfiguration(Builder builder) {
    this.destinationTable = checkNotNull(builder.destinationTable);
    this.createDisposition = builder.createDisposition;
    this.writeDisposition = builder.writeDisposition;
    this.formatOptions = builder.formatOptions;
    this.maxBadRecords = builder.maxBadRecords;
    this.schema = builder.schema;
    this.ignoreUnknownValues = builder.ignoreUnknownValues;
    this.projectionFields = (List<String>) builder.projectionFields;
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
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.load.createDisposition">
   *     Create Disposition</a>
   */
  public CreateDisposition createDisposition() {
    return this.createDisposition;
  }

  /**
   * Returns the action that should occur if the destination table already exists.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.load.writeDisposition">
   *     Write Disposition</a>
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

  public Builder toBuilder() {
    return new Builder(this);
  }

  MoreObjects.ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this)
        .add("destinationTable", destinationTable)
        .add("createDisposition", createDisposition)
        .add("writeDisposition", writeDisposition)
        .add("formatOptions", formatOptions)
        .add("maxBadRecords", maxBadRecords)
        .add("schema", schema)
        .add("ignoreUnknownValue", ignoreUnknownValues)
        .add("projectionFields", projectionFields);
  }

  @Override
  public String toString() {
    return toStringHelper().toString();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof LoadConfiguration
        && Objects.equals(toPb(), ((LoadConfiguration) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(destinationTable, createDisposition, writeDisposition, formatOptions,
        maxBadRecords, schema, ignoreUnknownValues, projectionFields);
  }

  com.google.api.services.bigquery.model.JobConfiguration toPb() {
    JobConfigurationLoad loadConfigurationPb = new JobConfigurationLoad();
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
    return new com.google.api.services.bigquery.model.JobConfiguration()
        .setLoad(loadConfigurationPb);
  }

  static LoadConfiguration fromPb(
      com.google.api.services.bigquery.model.JobConfiguration configurationPb) {
    return new Builder<>(configurationPb).build();
  }

  /**
   * Creates a builder for a BigQuery Load Configuration given the destination table.
   */
  public static Builder builder(TableId destinationTable) {
    return new Builder<>().destinationTable(destinationTable);
  }

  /**
   * Creates a builder for a BigQuery Load Configuration given the destination table and format.
   */
  public static Builder builder(TableId destinationTable, FormatOptions format) {
    return new Builder<>().destinationTable(destinationTable).formatOptions(format);
  }

  /**
   * Returns a BigQuery Load Configuration for the given destination table.
   */
  public static LoadConfiguration of(TableId destinationTable) {
    return builder(destinationTable).build();
  }

  /**
   * Returns a BigQuery Load Configuration for the given destination table and format.
   */
  public static LoadConfiguration of(TableId destinationTable, FormatOptions format) {
    return builder(destinationTable).formatOptions(format).build();
  }
}
