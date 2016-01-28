/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery load job configuration. A load job loads data from one of several formats into a
 * table. Data is provided as URIs that point to objects in Google Cloud Storage. Load job
 * configurations have {@link JobConfiguration.Type#LOAD} type.
 */
public class LoadJobConfiguration extends JobConfiguration implements LoadConfiguration {

  private static final long serialVersionUID = -2673554846792429829L;

  private final List<String> sourceUris;
  protected final TableId destinationTable;
  protected final JobInfo.CreateDisposition createDisposition;
  protected final JobInfo.WriteDisposition writeDisposition;
  protected final FormatOptions formatOptions;
  protected final Integer maxBadRecords;
  protected final Schema schema;
  protected final Boolean ignoreUnknownValues;
  protected final List<String> projectionFields;

  public static final class Builder
      extends JobConfiguration.Builder<LoadJobConfiguration, Builder>
      implements LoadConfiguration.Builder {

    private List<String> sourceUris;
    private TableId destinationTable;
    private JobInfo.CreateDisposition createDisposition;
    private JobInfo.WriteDisposition writeDisposition;
    private FormatOptions formatOptions;
    private Integer maxBadRecords;
    private Schema schema;
    private Boolean ignoreUnknownValues;
    private List<String> projectionFields;

    private Builder() {
      super(Type.LOAD);
    }

    private Builder(LoadJobConfiguration loadConfiguration) {
      super(Type.LOAD);
      this.destinationTable = loadConfiguration.destinationTable;
      this.createDisposition = loadConfiguration.createDisposition;
      this.writeDisposition = loadConfiguration.writeDisposition;
      this.formatOptions = loadConfiguration.formatOptions;
      this.maxBadRecords = loadConfiguration.maxBadRecords;
      this.schema = loadConfiguration.schema;
      this.ignoreUnknownValues = loadConfiguration.ignoreUnknownValues;
      this.projectionFields = loadConfiguration.projectionFields;
      this.sourceUris = loadConfiguration.sourceUris;
    }

    private Builder(com.google.api.services.bigquery.model.JobConfiguration configurationPb) {
      super(Type.LOAD);
      JobConfigurationLoad loadConfigurationPb = configurationPb.getLoad();
      this.destinationTable = TableId.fromPb(loadConfigurationPb.getDestinationTable());
      if (loadConfigurationPb.getCreateDisposition() != null) {
        this.createDisposition =
            JobInfo.CreateDisposition.valueOf(loadConfigurationPb.getCreateDisposition());
      }
      if (loadConfigurationPb.getWriteDisposition() != null) {
        this.writeDisposition =
            JobInfo.WriteDisposition.valueOf(loadConfigurationPb.getWriteDisposition());
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
      if (loadConfigurationPb.getSourceUris() != null) {
        this.sourceUris = ImmutableList.copyOf(configurationPb.getLoad().getSourceUris());
      }
    }

    @Override
    public Builder destinationTable(TableId destinationTable) {
      this.destinationTable = destinationTable;
      return this;
    }

    @Override
    public Builder createDisposition(JobInfo.CreateDisposition createDisposition) {
      this.createDisposition = createDisposition;
      return this;
    }

    @Override
    public Builder writeDisposition(JobInfo.WriteDisposition writeDisposition) {
      this.writeDisposition = writeDisposition;
      return this;
    }

   @Override
    public Builder formatOptions(FormatOptions formatOptions) {
      this.formatOptions = formatOptions;
      return this;
    }

    @Override
    public Builder maxBadRecords(Integer maxBadRecords) {
      this.maxBadRecords = maxBadRecords;
      return this;
    }

    @Override
    public Builder schema(Schema schema) {
      this.schema = schema;
      return this;
    }

    @Override
    public Builder ignoreUnknownValues(Boolean ignoreUnknownValues) {
      this.ignoreUnknownValues = ignoreUnknownValues;
      return this;
    }

    @Override
    public Builder projectionFields(List<String> projectionFields) {
      this.projectionFields =
          projectionFields != null ? ImmutableList.copyOf(projectionFields) : null;
      return this;
    }

    /**
     * Sets the fully-qualified URIs that point to source data in Google Cloud Storage (e.g.
     * gs://bucket/path). Each URI can contain one '*' wildcard character and it must come after the
     * 'bucket' name.
     */
    public Builder sourceUris(List<String> sourceUris) {
      this.sourceUris = ImmutableList.copyOf(checkNotNull(sourceUris));
      return this;
    }

    @Override
    public LoadJobConfiguration build() {
      return new LoadJobConfiguration(this);
    }
  }

  private LoadJobConfiguration(Builder builder) {
    super(builder);
    this.sourceUris = builder.sourceUris;
    this.destinationTable = builder.destinationTable;
    this.createDisposition = builder.createDisposition;
    this.writeDisposition = builder.writeDisposition;
    this.formatOptions = builder.formatOptions;
    this.maxBadRecords = builder.maxBadRecords;
    this.schema = builder.schema;
    this.ignoreUnknownValues = builder.ignoreUnknownValues;
    this.projectionFields = builder.projectionFields;
  }

  @Override
  public TableId destinationTable() {
    return destinationTable;
  }

  @Override
  public JobInfo.CreateDisposition createDisposition() {
    return this.createDisposition;
  }

  @Override
  public JobInfo.WriteDisposition writeDisposition() {
    return writeDisposition;
  }

  @Override
  public CsvOptions csvOptions() {
    return formatOptions instanceof CsvOptions ? (CsvOptions) formatOptions : null;
  }

  @Override
  public Integer maxBadRecords() {
    return maxBadRecords;
  }

  @Override
  public Schema schema() {
    return schema;
  }

  @Override
  public String format() {
    return formatOptions != null ? formatOptions.type() : null;
  }

  @Override
  public Boolean ignoreUnknownValues() {
    return ignoreUnknownValues;
  }

  @Override
  public List<String> projectionFields() {
    return projectionFields;
  }

  /**
   * Returns the fully-qualified URIs that point to source data in Google Cloud Storage (e.g.
   * gs://bucket/path). Each URI can contain one '*' wildcard character and it must come after the
   * 'bucket' name.
   */
  public List<String> sourceUris() {
    return sourceUris;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  protected ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("destinationTable", destinationTable)
        .add("createDisposition", createDisposition)
        .add("writeDisposition", writeDisposition)
        .add("formatOptions", formatOptions)
        .add("maxBadRecords", maxBadRecords)
        .add("schema", schema)
        .add("ignoreUnknownValue", ignoreUnknownValues)
        .add("projectionFields", projectionFields)
        .add("sourceUris", sourceUris);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof LoadJobConfiguration && baseEquals((LoadJobConfiguration) obj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), sourceUris);
  }

  @Override
  LoadJobConfiguration setProjectId(String projectId) {
    return toBuilder().destinationTable(destinationTable().setProjectId(projectId)).build();
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
    if (sourceUris != null) {
      loadConfigurationPb.setSourceUris(ImmutableList.copyOf(sourceUris));
    }
    return new com.google.api.services.bigquery.model.JobConfiguration()
        .setLoad(loadConfigurationPb);
  }

  /**
   * Creates a builder for a BigQuery Load Job configuration given the destination table and source
   * URIs.
   */
  public static Builder builder(TableId destinationTable, List<String> sourceUris) {
    return new Builder().destinationTable(destinationTable).sourceUris(sourceUris);
  }

  /**
   * Creates a builder for a BigQuery Load Job configuration given the destination table and source
   * URI.
   */
  public static Builder builder(TableId destinationTable, String sourceUri) {
    return builder(destinationTable, ImmutableList.of(sourceUri));
  }

  /**
   * Creates a builder for a BigQuery Load Job configuration given the destination table, format and
   * source URIs.
   */
  public static Builder builder(TableId destinationTable, List<String> sourceUris,
      FormatOptions format) {
    return builder(destinationTable, sourceUris).formatOptions(format);
  }

  /**
   * Creates a builder for a BigQuery Load Job configuration given the destination table, format and
   * source URI.
   */
  public static Builder builder(TableId destinationTable, String sourceUri, FormatOptions format) {
    return builder(destinationTable, ImmutableList.of(sourceUri), format);
  }

  /**
   * Returns a BigQuery Load Job Configuration for the given destination table and source URIs.
   */
  public static LoadJobConfiguration of(TableId destinationTable, List<String> sourceUris) {
    return builder(destinationTable, sourceUris).build();
  }

  /**
   * Returns a BigQuery Load Job Configuration for the given destination table and source URI.
   */
  public static LoadJobConfiguration of(TableId destinationTable, String sourceUri) {
    return of(destinationTable, ImmutableList.of(sourceUri));
  }

  /**
   * Returns a BigQuery Load Job Configuration for the given destination table, format and source
   * URI.
   */
  public static LoadJobConfiguration of(TableId destinationTable, List<String> sourceUris,
      FormatOptions format) {
    return builder(destinationTable, sourceUris, format).build();
  }

  /**
   * Returns a BigQuery Load Job Configuration for the given destination table, format and source
   * URI.
   */
  public static LoadJobConfiguration of(TableId destinationTable, String sourceUri,
      FormatOptions format) {
    return of(destinationTable, ImmutableList.of(sourceUri), format);
  }

  @SuppressWarnings("unchecked")
  static LoadJobConfiguration fromPb(
      com.google.api.services.bigquery.model.JobConfiguration confPb) {
    return new Builder(confPb).build();
  }
}
