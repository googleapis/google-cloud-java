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

package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.model.JobConfigurationLoad;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;

import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery load job configuration. A load job loads data from one of several formats into a
 * table. Data is provided as URIs that point to objects in Google Cloud Storage. Load job
 * configurations have {@link JobConfiguration.Type#LOAD} type.
 */
public final class LoadJobConfiguration extends JobConfiguration implements LoadConfiguration {

  private static final long serialVersionUID = -2673554846792429829L;

  private final List<String> sourceUris;
  private final TableId destinationTable;
  private final JobInfo.CreateDisposition createDisposition;
  private final JobInfo.WriteDisposition writeDisposition;
  private final FormatOptions formatOptions;
  private final Integer maxBadRecords;
  private final Schema schema;
  private final Boolean ignoreUnknownValues;
  private final List<JobInfo.SchemaUpdateOption> schemaUpdateOptions;
  private final Boolean autodetect;

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
    private List<JobInfo.SchemaUpdateOption> schemaUpdateOptions;
    private Boolean autodetect;

    private Builder() {
      super(Type.LOAD);
    }

    private Builder(LoadJobConfiguration loadConfiguration) {
      this();
      this.destinationTable = loadConfiguration.destinationTable;
      this.createDisposition = loadConfiguration.createDisposition;
      this.writeDisposition = loadConfiguration.writeDisposition;
      this.formatOptions = loadConfiguration.formatOptions;
      this.maxBadRecords = loadConfiguration.maxBadRecords;
      this.schema = loadConfiguration.schema;
      this.ignoreUnknownValues = loadConfiguration.ignoreUnknownValues;
      this.sourceUris = loadConfiguration.sourceUris;
      this.schemaUpdateOptions = loadConfiguration.schemaUpdateOptions;
      this.autodetect = loadConfiguration.autodetect;
    }

    private Builder(com.google.api.services.bigquery.model.JobConfiguration configurationPb) {
      this();
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
        CsvOptions.Builder builder = CsvOptions.newBuilder()
            .setEncoding(loadConfigurationPb.getEncoding())
            .setFieldDelimiter(loadConfigurationPb.getFieldDelimiter())
            .setQuote(loadConfigurationPb.getQuote());
        if (loadConfigurationPb.getAllowJaggedRows() != null) {
          builder.setAllowJaggedRows(loadConfigurationPb.getAllowJaggedRows());
        }
        if (loadConfigurationPb.getAllowQuotedNewlines() != null) {
          builder.setAllowQuotedNewLines(loadConfigurationPb.getAllowQuotedNewlines());
        }
        if (loadConfigurationPb.getSkipLeadingRows() != null) {
          builder.setSkipLeadingRows(loadConfigurationPb.getSkipLeadingRows());
        }
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
      if (loadConfigurationPb.getSchemaUpdateOptions() != null) {
        ImmutableList.Builder<JobInfo.SchemaUpdateOption> schemaUpdateOptionsBuilder = new ImmutableList.Builder<>();
        for (String rawSchemaUpdateOption : loadConfigurationPb.getSchemaUpdateOptions()) {
          schemaUpdateOptionsBuilder.add(JobInfo.SchemaUpdateOption.valueOf(rawSchemaUpdateOption));
        }
        this.schemaUpdateOptions = schemaUpdateOptionsBuilder.build();
      }
      this.autodetect = loadConfigurationPb.getAutodetect();
    }


    @Override
    public Builder setDestinationTable(TableId destinationTable) {
      this.destinationTable = destinationTable;
      return this;
    }


    @Override
    public Builder setCreateDisposition(JobInfo.CreateDisposition createDisposition) {
      this.createDisposition = createDisposition;
      return this;
    }


    @Override
    public Builder setWriteDisposition(JobInfo.WriteDisposition writeDisposition) {
      this.writeDisposition = writeDisposition;
      return this;
    }


    @Override
    public Builder setFormatOptions(FormatOptions formatOptions) {
      this.formatOptions = formatOptions;
      return this;
    }


    @Override
    public Builder setMaxBadRecords(Integer maxBadRecords) {
      this.maxBadRecords = maxBadRecords;
      return this;
    }


    @Override
    public Builder setSchema(Schema schema) {
      this.schema = schema;
      return this;
    }


    @Override
    public Builder setIgnoreUnknownValues(Boolean ignoreUnknownValues) {
      this.ignoreUnknownValues = ignoreUnknownValues;
      return this;
    }

    /**
     * Sets the fully-qualified URIs that point to source data in Google Cloud Storage (e.g.
     * gs://bucket/path). Each URI can contain one '*' wildcard character and it must come after the
     * 'bucket' name.
     */
    public Builder setSourceUris(List<String> sourceUris) {
      this.sourceUris = ImmutableList.copyOf(checkNotNull(sourceUris));
      return this;
    }

    public Builder setAutodetect(Boolean autodetect) {
      this.autodetect = autodetect;
      return this;
    }

    @Override
    public Builder setSchemaUpdateOptions(List<JobInfo.SchemaUpdateOption> schemaUpdateOptions) {
      this.schemaUpdateOptions =
              schemaUpdateOptions != null ? ImmutableList.copyOf(schemaUpdateOptions) : null;
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
    this.schemaUpdateOptions = builder.schemaUpdateOptions;
    this.autodetect = builder.autodetect;
  }


  @Override
  public TableId getDestinationTable() {
    return destinationTable;
  }


  @Override
  public JobInfo.CreateDisposition getCreateDisposition() {
    return this.createDisposition;
  }


  @Override
  public JobInfo.WriteDisposition getWriteDisposition() {
    return writeDisposition;
  }


  @Override
  public CsvOptions getCsvOptions() {
    return formatOptions instanceof CsvOptions ? (CsvOptions) formatOptions : null;
  }

  @Override
  public DatastoreBackupOptions getDatastoreBackupOptions() {
    return formatOptions instanceof DatastoreBackupOptions ?
        (DatastoreBackupOptions) formatOptions : null;
  }


  @Override
  public String getFormat() {
    return formatOptions != null ? formatOptions.getType() : null;
  }


  @Override
  public Integer getMaxBadRecords() {
    return maxBadRecords;
  }


  @Override
  public Schema getSchema() {
    return schema;
  }

  @Override
  public Boolean ignoreUnknownValues() {
    return ignoreUnknownValues;
  }

  /**
   * Returns the fully-qualified URIs that point to source data in Google Cloud Storage (e.g.
   * gs://bucket/path). Each URI can contain one '*' wildcard character and it must come after the
   * 'bucket' name.
   */
  public List<String> getSourceUris() {
    return sourceUris;
  }

  public Boolean getAutodetect() {
    return autodetect;
  }

  @Override
  public List<JobInfo.SchemaUpdateOption> getSchemaUpdateOptions() {
    return schemaUpdateOptions;
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("destinationTable", destinationTable)
        .add("createDisposition", createDisposition)
        .add("writeDisposition", writeDisposition)
        .add("formatOptions", formatOptions)
        .add("maxBadRecords", maxBadRecords)
        .add("schema", schema)
        .add("ignoreUnknownValue", ignoreUnknownValues)
        .add("sourceUris", sourceUris)
        .add("schemaUpdateOptions", schemaUpdateOptions)
        .add("autodetect", autodetect);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof LoadJobConfiguration
        && baseEquals((LoadJobConfiguration) obj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), sourceUris);
  }

  @Override
  LoadJobConfiguration setProjectId(String projectId) {
    return toBuilder().setDestinationTable(getDestinationTable().setProjectId(projectId)).build();
  }

  @Override
  com.google.api.services.bigquery.model.JobConfiguration toPb() {
    JobConfigurationLoad loadConfigurationPb = new JobConfigurationLoad();
    loadConfigurationPb.setDestinationTable(destinationTable.toPb());
    if (createDisposition != null) {
      loadConfigurationPb.setCreateDisposition(createDisposition.toString());
    }
    if (writeDisposition != null) {
      loadConfigurationPb.setWriteDisposition(writeDisposition.toString());
    }
    if (getCsvOptions() != null) {
      CsvOptions csvOptions = getCsvOptions();
      loadConfigurationPb.setFieldDelimiter(csvOptions.getFieldDelimiter())
          .setAllowJaggedRows(csvOptions.allowJaggedRows())
          .setAllowQuotedNewlines(csvOptions.allowQuotedNewLines())
          .setEncoding(csvOptions.getEncoding())
          .setQuote(csvOptions.getQuote());
      if (csvOptions.getSkipLeadingRows() != null) {
        // todo(mziccard) remove checked cast or comment when #1044 is closed
        loadConfigurationPb.setSkipLeadingRows(Ints.checkedCast(csvOptions.getSkipLeadingRows()));
      }
    }
    if (schema != null) {
      loadConfigurationPb.setSchema(schema.toPb());
    }
    if (formatOptions != null) {
      loadConfigurationPb.setSourceFormat(formatOptions.getType());
    }
    loadConfigurationPb.setMaxBadRecords(maxBadRecords);
    loadConfigurationPb.setIgnoreUnknownValues(ignoreUnknownValues);
    if (getDatastoreBackupOptions() != null) {
      DatastoreBackupOptions backOptions = getDatastoreBackupOptions();
      loadConfigurationPb.setProjectionFields(backOptions.getProjectionFields());
    }
    if (sourceUris != null) {
      loadConfigurationPb.setSourceUris(ImmutableList.copyOf(sourceUris));
    }
    if (schemaUpdateOptions != null) {
      ImmutableList.Builder<String> schemaUpdateOptionsBuilder = new ImmutableList.Builder<>();
      for (JobInfo.SchemaUpdateOption schemaUpdateOption : schemaUpdateOptions) {
        schemaUpdateOptionsBuilder.add(schemaUpdateOption.name());
      }
      loadConfigurationPb.setSchemaUpdateOptions(schemaUpdateOptionsBuilder.build());
    }
    loadConfigurationPb.setAutodetect(autodetect);
    return new com.google.api.services.bigquery.model.JobConfiguration()
        .setLoad(loadConfigurationPb);
  }


  /**
   * Creates a builder for a BigQuery Load Job configuration given the destination table and source
   * URIs.
   */
  public static Builder newBuilder(TableId destinationTable, List<String> sourceUris) {
    return new Builder().setDestinationTable(destinationTable).setSourceUris(sourceUris);
  }

  /**
   * Creates a builder for a BigQuery Load Job configuration given the destination table and source
   * URI.
   */
  public static Builder builder(TableId destinationTable, String sourceUri) {
    return newBuilder(destinationTable, ImmutableList.of(sourceUri));
  }

  /**
   * Creates a builder for a BigQuery Load Job configuration given the destination table and source
   * URI.
   */
  public static Builder newBuilder(TableId destinationTable, String sourceUri) {
    return newBuilder(destinationTable, ImmutableList.of(sourceUri));
  }


  /**
   * Creates a builder for a BigQuery Load Job configuration given the destination table, format and
   * source URIs.
   */
  public static Builder newBuilder(TableId destinationTable, List<String> sourceUris,
      FormatOptions format) {
    return newBuilder(destinationTable, sourceUris).setFormatOptions(format);
  }


  /**
   * Creates a builder for a BigQuery Load Job configuration given the destination table, format and
   * source URI.
   */
  public static Builder newBuilder(TableId destinationTable, String sourceUri,
      FormatOptions format) {
    return newBuilder(destinationTable, ImmutableList.of(sourceUri), format);
  }

  /**
   * Returns a BigQuery Load Job Configuration for the given destination table and source URIs.
   */
  public static LoadJobConfiguration of(TableId destinationTable, List<String> sourceUris) {
    return newBuilder(destinationTable, sourceUris).build();
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
    return newBuilder(destinationTable, sourceUris, format).build();
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
