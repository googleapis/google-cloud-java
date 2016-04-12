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
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.cloud.bigquery.JobInfo.CreateDisposition;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Configuration for a load operation. A load configuration can be used to load data
 * into a table with a {@link com.google.cloud.WriteChannel}
 * ({@link BigQuery#writer(WriteChannelConfiguration)}).
 */
public class WriteChannelConfiguration implements LoadConfiguration, Serializable {

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

    @Override
    public Builder destinationTable(TableId destinationTable) {
      this.destinationTable = destinationTable;
      return this;
    }

    @Override
    public Builder createDisposition(CreateDisposition createDisposition) {
      this.createDisposition = createDisposition;
      return this;
    }

    @Override
    public Builder writeDisposition(WriteDisposition writeDisposition) {
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
  public TableId destinationTable() {
    return destinationTable;
  }

  @Override
  public CreateDisposition createDisposition() {
    return this.createDisposition;
  }

  @Override
  public WriteDisposition writeDisposition() {
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
    return obj instanceof WriteChannelConfiguration
        && Objects.equals(toPb(), ((WriteChannelConfiguration) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(destinationTable, createDisposition, writeDisposition, formatOptions,
        maxBadRecords, schema, ignoreUnknownValues, projectionFields);
  }

  WriteChannelConfiguration setProjectId(String projectId) {
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
  public static Builder builder(TableId destinationTable) {
    return new Builder().destinationTable(destinationTable);
  }

  /**
   * Creates a builder for a BigQuery Load Configuration given the destination table and format.
   */
  public static Builder builder(TableId destinationTable, FormatOptions format) {
    return builder(destinationTable).formatOptions(format);
  }

  /**
   * Returns a BigQuery Load Configuration for the given destination table.
   */
  public static WriteChannelConfiguration of(TableId destinationTable) {
    return builder(destinationTable).build();
  }

  /**
   * Returns a BigQuery Load Configuration for the given destination table and format.
   */
  public static WriteChannelConfiguration of(TableId destinationTable, FormatOptions format) {
    return builder(destinationTable).formatOptions(format).build();
  }
}
