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
  private final List<String> projectionFields;

  public static final class Builder implements LoadConfiguration.Builder {

    private TableId destinationTable;
    private CreateDisposition createDisposition;
    private WriteDisposition writeDisposition;
    private FormatOptions formatOptions;
    private Integer maxBadRecords;
    private Schema schema;
    private Boolean ignoreUnknownValues;
    private List<String> projectionFields;

    private Builder() {}

    private Builder(WriteChannelConfiguration writeChannelConfiguration) {
      this.destinationTable = writeChannelConfiguration.destinationTable;
      this.createDisposition = writeChannelConfiguration.createDisposition;
      this.writeDisposition = writeChannelConfiguration.writeDisposition;
      this.formatOptions = writeChannelConfiguration.formatOptions;
      this.maxBadRecords = writeChannelConfiguration.maxBadRecords;
      this.schema = writeChannelConfiguration.schema;
      this.ignoreUnknownValues = writeChannelConfiguration.ignoreUnknownValues;
      this.projectionFields = writeChannelConfiguration.projectionFields;
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
      this.projectionFields = loadConfigurationPb.getProjectionFields();
    }

    @Override
    @Deprecated
    public Builder destinationTable(TableId destinationTable) {
      return setDestinationTable(destinationTable);
    }

    @Override
    public Builder setDestinationTable(TableId destinationTable) {
      this.destinationTable = destinationTable;
      return this;
    }

    @Override
    @Deprecated
    public Builder createDisposition(CreateDisposition createDisposition) {
      return setCreateDisposition(createDisposition);
    }

    @Override
    public Builder setCreateDisposition(CreateDisposition createDisposition) {
      this.createDisposition = createDisposition;
      return this;
    }

    @Override
    @Deprecated
    public Builder writeDisposition(WriteDisposition writeDisposition) {
      return setWriteDisposition(writeDisposition);
    }

    @Override
    public Builder setWriteDisposition(WriteDisposition writeDisposition) {
      this.writeDisposition = writeDisposition;
      return this;
    }

    @Override
    @Deprecated
    public Builder formatOptions(FormatOptions formatOptions) {
      return setFormatOptions(formatOptions);
    }

    @Override
    public Builder setFormatOptions(FormatOptions formatOptions) {
      this.formatOptions = formatOptions;
      return this;
    }

    @Override
    @Deprecated
    public Builder maxBadRecords(Integer maxBadRecords) {
      return setMaxBadRecords(maxBadRecords);
    }

    @Override
    public Builder setMaxBadRecords(Integer maxBadRecords) {
      this.maxBadRecords = maxBadRecords;
      return this;
    }

    @Override
    @Deprecated
    public Builder schema(Schema schema) {
      return setSchema(schema);
    }

    @Override
    public Builder setSchema(Schema schema) {
      this.schema = schema;
      return this;
    }

    @Override
    @Deprecated
    public Builder ignoreUnknownValues(Boolean ignoreUnknownValues) {
      return setIgnoreUnknownValues(ignoreUnknownValues);
    }

    @Override
    public Builder setIgnoreUnknownValues(Boolean ignoreUnknownValues) {
      this.ignoreUnknownValues = ignoreUnknownValues;
      return this;
    }

    @Override
    @Deprecated
    public Builder projectionFields(List<String> projectionFields) {
      return setProjectionFields(projectionFields);
    }

    @Override
    public Builder setProjectionFields(List<String> projectionFields) {
      this.projectionFields =
          projectionFields != null ? ImmutableList.copyOf(projectionFields) : null;
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
    this.projectionFields = builder.projectionFields;
  }

  @Override
  @Deprecated
  public TableId destinationTable() {
    return getDestinationTable();
  }

  @Override
  public TableId getDestinationTable() {
    return destinationTable;
  }

  @Override
  @Deprecated
  public CreateDisposition createDisposition() {
    return this.getCreateDisposition();
  }

  @Override
  public CreateDisposition getCreateDisposition() {
    return this.createDisposition;
  }

  @Override
  @Deprecated
  public WriteDisposition writeDisposition() {
    return getWriteDisposition();
  }

  @Override
  public WriteDisposition getWriteDisposition() {
    return writeDisposition;
  }

  @Override
  @Deprecated
  public CsvOptions csvOptions() {
    return getCsvOptions();
  }

  @Override
  public CsvOptions getCsvOptions() {
    return formatOptions instanceof CsvOptions ? (CsvOptions) formatOptions : null;
  }

  @Override
  @Deprecated
  public Integer maxBadRecords() {
    return getMaxBadRecords();
  }

  @Override
  public Integer getMaxBadRecords() {
    return maxBadRecords;
  }

  @Override
  @Deprecated
  public Schema schema() {
    return getSchema();
  }

  @Override
  public Schema getSchema() {
    return schema;
  }

  @Override
  @Deprecated
  public String format() {
    return getFormat();
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
  @Deprecated
  public List<String> projectionFields() {
    return getProjectionFields();
  }

  @Override
  public List<String> getProjectionFields() {
    return projectionFields;
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
        .add("projectionFields", projectionFields);
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
        maxBadRecords, schema, ignoreUnknownValues, projectionFields);
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
    loadConfigurationPb.setProjectionFields(projectionFields);
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
  @Deprecated
  public static Builder builder(TableId destinationTable) {
    return newBuilder(destinationTable);
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
  @Deprecated
  public static Builder builder(TableId destinationTable, FormatOptions format) {
    return newBuilder(destinationTable, format);
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
