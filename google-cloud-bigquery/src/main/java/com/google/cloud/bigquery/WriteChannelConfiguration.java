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
import com.google.cloud.bigquery.JobInfo.CreateDisposition;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.JobInfo.SchemaUpdateOption;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Configuration for a load operation. A load configuration can be used to load data
 * into a table with a {@link com.google.cloud.WriteChannel}
 * ({@link BigQuery#writer(WriteChannelConfiguration)}).
 */
public final class WriteChannelConfiguration implements LoadConfiguration, Serializable {

  private static final long serialVersionUID = 470267591917413578L;

  private final TableId destinationTable;
  private final CreateDisposition createDisposition;
  private final WriteDisposition writeDisposition;
  private final FormatOptions formatOptions;
  private final Integer maxBadRecords;
  private final Schema schema;
  private final Boolean ignoreUnknownValues;
  private final List<SchemaUpdateOption> schemaUpdateOptions;
  private final Boolean autodetect;

  public static final class Builder implements LoadConfiguration.Builder {

    private TableId destinationTable;
    private CreateDisposition createDisposition;
    private WriteDisposition writeDisposition;
    private FormatOptions formatOptions;
    private Integer maxBadRecords;
    private Schema schema;
    private Boolean ignoreUnknownValues;
    private List<SchemaUpdateOption> schemaUpdateOptions;
    private Boolean autodetect;

    private Builder() {}

    private Builder(WriteChannelConfiguration writeChannelConfiguration) {
      this.destinationTable = writeChannelConfiguration.destinationTable;
      this.createDisposition = writeChannelConfiguration.createDisposition;
      this.writeDisposition = writeChannelConfiguration.writeDisposition;
      this.formatOptions = writeChannelConfiguration.formatOptions;
      this.maxBadRecords = writeChannelConfiguration.maxBadRecords;
      this.schema = writeChannelConfiguration.schema;
      this.ignoreUnknownValues = writeChannelConfiguration.ignoreUnknownValues;
      this.schemaUpdateOptions = writeChannelConfiguration.schemaUpdateOptions;
      this.autodetect = writeChannelConfiguration.autodetect;
    }

    private Builder(com.google.api.services.bigquery.model.JobConfiguration configurationPb) {
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
      if (loadConfigurationPb.getProjectionFields() != null) {
        this.formatOptions = DatastoreBackupOptions.newBuilder()
            .setProjectionFields(loadConfigurationPb.getProjectionFields())
            .build();
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
    public Builder setCreateDisposition(CreateDisposition createDisposition) {
      this.createDisposition = createDisposition;
      return this;
    }


    @Override
    public Builder setWriteDisposition(WriteDisposition writeDisposition) {
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

    @Override
    public Builder setSchemaUpdateOptions(List<SchemaUpdateOption> schemaUpdateOptions) {
      this.schemaUpdateOptions =
              schemaUpdateOptions != null ? ImmutableList.copyOf(schemaUpdateOptions) : null;
      return this;
    }

    @Override
    public Builder setAutodetect(Boolean autodetect) {
      this.autodetect = autodetect;
      return this;
    }

    @Override
    public WriteChannelConfiguration build() {
      return new WriteChannelConfiguration(this);
    }
  }

  protected WriteChannelConfiguration(Builder builder) {
    this.destinationTable = checkNotNull(builder.destinationTable);
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
  public CreateDisposition getCreateDisposition() {
    return this.createDisposition;
  }


  @Override
  public WriteDisposition getWriteDisposition() {
    return writeDisposition;
  }


  @Override
  public CsvOptions getCsvOptions() {
    return formatOptions instanceof CsvOptions ? (CsvOptions) formatOptions : null;
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
  public String getFormat() {
    return formatOptions != null ? formatOptions.getType() : null;
  }

  @Override
  public Boolean ignoreUnknownValues() {
    return ignoreUnknownValues;
  }


  @Override
  public DatastoreBackupOptions getDatastoreBackupOptions() {
    return formatOptions instanceof DatastoreBackupOptions ?
        (DatastoreBackupOptions) formatOptions : null;
  }

  @Override
  public List<SchemaUpdateOption> getSchemaUpdateOptions() {
    return schemaUpdateOptions;
  }

  @Override
  public Boolean getAutodetect() {
    return autodetect;
  }

  @Override
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
        .add("schemaUpdateOptions", schemaUpdateOptions)
        .add("autodetect", autodetect);
  }

  @Override
  public String toString() {
    return toStringHelper().toString();
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof WriteChannelConfiguration
        && Objects.equals(toPb(), ((WriteChannelConfiguration) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(destinationTable, createDisposition, writeDisposition, formatOptions,
        maxBadRecords, schema, ignoreUnknownValues, schemaUpdateOptions, autodetect);
  }

  WriteChannelConfiguration setProjectId(String projectId) {
    return toBuilder().setDestinationTable(getDestinationTable().setProjectId(projectId)).build();
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
      DatastoreBackupOptions backupOptions = getDatastoreBackupOptions();
      loadConfigurationPb.setProjectionFields(backupOptions.getProjectionFields());
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

  static WriteChannelConfiguration fromPb(
      com.google.api.services.bigquery.model.JobConfiguration configurationPb) {
    return new Builder(configurationPb).build();
  }


  /**
   * Creates a builder for a BigQuery Load Configuration given the destination table.
   */
  public static Builder newBuilder(TableId destinationTable) {
    return new Builder().setDestinationTable(destinationTable);
  }


  /**
   * Creates a builder for a BigQuery Load Configuration given the destination table and format.
   */
  public static Builder newBuilder(TableId destinationTable, FormatOptions format) {
    return newBuilder(destinationTable).setFormatOptions(format);
  }

  /**
   * Returns a BigQuery Load Configuration for the given destination table.
   */
  public static WriteChannelConfiguration of(TableId destinationTable) {
    return newBuilder(destinationTable).build();
  }

  /**
   * Returns a BigQuery Load Configuration for the given destination table and format.
   */
  public static WriteChannelConfiguration of(TableId destinationTable, FormatOptions format) {
    return newBuilder(destinationTable).setFormatOptions(format).build();
  }
}
