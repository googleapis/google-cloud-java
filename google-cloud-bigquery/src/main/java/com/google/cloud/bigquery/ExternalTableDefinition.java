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

import com.google.api.services.bigquery.model.ExternalDataConfiguration;
import com.google.api.services.bigquery.model.Table;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery external table definition. BigQuery's external tables are tables whose data
 * reside outside of BigQuery but can be queried as normal BigQuery tables. External tables are
 * experimental and might be subject to change or removed.
 *
 * @see <a href="https://cloud.google.com/bigquery/federated-data-sources">Federated Data Sources
 *     </a>
 */
public class ExternalTableDefinition extends TableDefinition {

  static final Function<ExternalDataConfiguration, ExternalTableDefinition>
      FROM_EXTERNAL_DATA_FUNCTION =
      new Function<ExternalDataConfiguration, ExternalTableDefinition>() {
        @Override
        public ExternalTableDefinition apply(ExternalDataConfiguration pb) {
          return ExternalTableDefinition.fromExternalDataConfiguration(pb);
        }
      };
  static final Function<ExternalTableDefinition, ExternalDataConfiguration>
      TO_EXTERNAL_DATA_FUNCTION =
      new Function<ExternalTableDefinition, ExternalDataConfiguration>() {
        @Override
        public ExternalDataConfiguration apply(ExternalTableDefinition tableInfo) {
          return tableInfo.toExternalDataConfigurationPb();
        }
      };

  private static final long serialVersionUID = -5951580238459622025L;

  private final List<String> sourceUris;
  private final FormatOptions formatOptions;
  private final Integer maxBadRecords;
  private final Boolean ignoreUnknownValues;
  private final String compression;
  private final Boolean autodetect;

  public static final class Builder
      extends TableDefinition.Builder<ExternalTableDefinition, Builder> {

    private List<String> sourceUris;
    private FormatOptions formatOptions;
    private Integer maxBadRecords;
    private Boolean ignoreUnknownValues;
    private String compression;
    private Boolean autodetect;

    private Builder() {
      super(Type.EXTERNAL);
    }

    private Builder(ExternalTableDefinition tableDefinition) {
      super(tableDefinition);
      this.sourceUris = tableDefinition.sourceUris;
      this.formatOptions = tableDefinition.formatOptions;
      this.maxBadRecords = tableDefinition.maxBadRecords;
      this.ignoreUnknownValues = tableDefinition.ignoreUnknownValues;
      this.compression = tableDefinition.compression;
      this.autodetect = tableDefinition.autodetect;
    }

    private Builder(Table tablePb) {
      super(tablePb);
      com.google.api.services.bigquery.model.ExternalDataConfiguration externalDataConfiguration =
          tablePb.getExternalDataConfiguration();
      if (externalDataConfiguration != null) {
        if (externalDataConfiguration.getSourceUris() != null) {
          this.sourceUris = ImmutableList.copyOf(externalDataConfiguration.getSourceUris());
        }
        if (externalDataConfiguration.getSourceFormat() != null) {
          this.formatOptions = FormatOptions.of(externalDataConfiguration.getSourceFormat());
        }
        this.compression = externalDataConfiguration.getCompression();
        this.ignoreUnknownValues = externalDataConfiguration.getIgnoreUnknownValues();
        if (externalDataConfiguration.getCsvOptions() != null) {
          this.formatOptions = CsvOptions.fromPb(externalDataConfiguration.getCsvOptions());
        }
        this.maxBadRecords = externalDataConfiguration.getMaxBadRecords();
        this.autodetect = externalDataConfiguration.getAutodetect();
      }
    }


    /**
     * Sets the fully-qualified URIs that point to your data in Google Cloud Storage (e.g.
     * gs://bucket/path). Each URI can contain one '*' wildcard character that must come after the
     * bucket's name. Size limits related to load jobs apply to external data sources, plus an
     * additional limit of 10 GB maximum size across all URIs.
     *
     * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
     */
    public Builder setSourceUris(List<String> sourceUris) {
      this.sourceUris = ImmutableList.copyOf(checkNotNull(sourceUris));
      return this;
    }


    /**
     * Sets the source format, and possibly some parsing options, of the external data. Supported
     * formats are {@code CSV} and {@code NEWLINE_DELIMITED_JSON}.
     *
     * <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
     *     Source Format</a>
     */
    public Builder setFormatOptions(FormatOptions formatOptions) {
      this.formatOptions = checkNotNull(formatOptions);
      return this;
    }


    /**
     * Sets the maximum number of bad records that BigQuery can ignore when reading data. If the
     * number of bad records exceeds this value, an invalid error is returned in the job result.
     * The default value is 0, which requires that all records are valid.
     */
    public Builder setMaxBadRecords(Integer maxBadRecords) {
      this.maxBadRecords = maxBadRecords;
      return this;
    }


    /**
     * Sets whether BigQuery should allow extra values that are not represented in the table schema.
     * If true, the extra values are ignored. If false, records with extra columns are treated as
     * bad records, and if there are too many bad records, an invalid error is returned in the job
     * result. The default value is false. The value set with {@link #setFormatOptions(FormatOptions)}
     * property determines what BigQuery treats as an extra value.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.ignoreUnknownValues">
     *     Ignore Unknown Values</a>
     */
    public Builder setIgnoreUnknownValues(Boolean ignoreUnknownValues) {
      this.ignoreUnknownValues = ignoreUnknownValues;
      return this;
    }


    /**
     * Sets compression type of the data source. By default no compression is assumed.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.compression">
     *     Compression</a>
     */
    public Builder setCompression(String compression) {
      this.compression = compression;
      return this;
    }

    /**
     * [Experimental] Sets detection of schema and format options automatically. Any option specified explicitly will
     * be honored.
     */
    public Builder setAutodetect(Boolean autodetect) {
      this.autodetect = autodetect;
      return this;
    }

    /**
     * Creates an {@code ExternalTableDefinition} object.
     */
    @Override
    public ExternalTableDefinition build() {
      return new ExternalTableDefinition(this);
    }
  }

  private ExternalTableDefinition(Builder builder) {
    super(builder);
    this.compression = builder.compression;
    this.ignoreUnknownValues = builder.ignoreUnknownValues;
    this.maxBadRecords = builder.maxBadRecords;
    this.formatOptions = builder.formatOptions;
    this.sourceUris = builder.sourceUris;
    this.autodetect = builder.autodetect;
  }


  /**
   * Returns the compression type of the data source.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.compression">
   *     Compression</a>
   */
  public String getCompression() {
    return compression;
  }

  /**
   * Returns whether BigQuery should allow extra values that are not represented in the table
   * schema. If true, the extra values are ignored. If false, records with extra columns are treated
   * as bad records, and if there are too many bad records, an invalid error is returned in the job
   * result. The default value is false. The value of {@link #getFormatOptions()} determines what
   * BigQuery treats as an extra value.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.ignoreUnknownValues">
   *     Ignore Unknown Values</a>
   */
  public Boolean ignoreUnknownValues() {
    return ignoreUnknownValues;
  }


  /**
   * Returns the maximum number of bad records that BigQuery can ignore when reading data. If the
   * number of bad records exceeds this value, an invalid error is returned in the job result.
   */
  public Integer getMaxBadRecords() {
    return maxBadRecords;
  }


  /**
   * Returns the fully-qualified URIs that point to your data in Google Cloud Storage. Each URI can
   * contain one '*' wildcard character that must come after the bucket's name. Size limits
   * related to load jobs apply to external data sources, plus an additional limit of 10 GB
   * maximum size across all URIs.
   *
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   */
  public List<String> getSourceUris() {
    return sourceUris;
  }


  /**
   * Returns the source format, and possibly some parsing options, of the external data. Supported
   * formats are {@code CSV} and {@code NEWLINE_DELIMITED_JSON}.
   */
  @SuppressWarnings("unchecked")
  public <F extends FormatOptions> F getFormatOptions() {
    return (F) formatOptions;
  }

  /**
   * [Experimental] Returns whether automatic detection of schema and format options should be performed.
   */
  public Boolean getAutodetect() {
    return autodetect;
  }

  /**
   * Returns a builder for the {@code ExternalTableDefinition} object.
   */
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("sourceUris", sourceUris)
        .add("formatOptions", formatOptions)
        .add("compression", compression)
        .add("ignoreUnknownValues", ignoreUnknownValues)
        .add("maxBadRecords", maxBadRecords)
        .add("autodetect", autodetect);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
        && obj.getClass().equals(ExternalTableDefinition.class)
        && baseEquals((ExternalTableDefinition) obj);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(baseHashCode(), compression, ignoreUnknownValues, maxBadRecords,
        formatOptions, sourceUris, autodetect);
  }

  @Override
  com.google.api.services.bigquery.model.Table toPb() {
    Table tablePb = super.toPb();
    tablePb.setExternalDataConfiguration(toExternalDataConfigurationPb());
    return tablePb;
  }

  com.google.api.services.bigquery.model.ExternalDataConfiguration toExternalDataConfigurationPb() {
    com.google.api.services.bigquery.model.ExternalDataConfiguration externalConfigurationPb =
        new com.google.api.services.bigquery.model.ExternalDataConfiguration();
    if (compression != null) {
      externalConfigurationPb.setCompression(compression);
    }
    if (ignoreUnknownValues != null) {
      externalConfigurationPb.setIgnoreUnknownValues(ignoreUnknownValues);
    }
    if (maxBadRecords != null) {
      externalConfigurationPb.setMaxBadRecords(maxBadRecords);
    }
    if (getSchema() != null) {
      externalConfigurationPb.setSchema(getSchema().toPb());
    }
    if (formatOptions != null) {
      externalConfigurationPb.setSourceFormat(formatOptions.getType());
    }
    if (sourceUris != null) {
      externalConfigurationPb.setSourceUris(sourceUris);
    }
    if (formatOptions != null && FormatOptions.CSV.equals(formatOptions.getType())) {
      externalConfigurationPb.setCsvOptions(((CsvOptions) formatOptions).toPb());
    }
    if (autodetect != null) {
      externalConfigurationPb.setAutodetect(autodetect);
    }
    return externalConfigurationPb;
  }


  /**
   * Creates a builder for an ExternalTableDefinition object.
   *
   * @param sourceUris the fully-qualified URIs that point to your data in Google Cloud Storage.
   *     Each URI can contain one '*' wildcard character that must come after the bucket's name.
   *     Size limits related to load jobs apply to external data sources, plus an additional limit
   *     of 10 GB maximum size across all URIs.
   * @param schema the schema for the external data
   * @param format the source format of the external data
   * @return a builder for an ExternalTableDefinition object given source URIs, schema and format
   *
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public static Builder newBuilder(List<String> sourceUris, Schema schema, FormatOptions format) {
    return new Builder().setSourceUris(sourceUris).setSchema(schema).setFormatOptions(format);
  }


  /**
   * Creates a builder for an ExternalTableDefinition object.
   *
   * @param sourceUri a fully-qualified URI that points to your data in Google Cloud Storage. The
   *     URI can contain one '*' wildcard character that must come after the bucket's name. Size
   *     limits related to load jobs apply to external data sources.
   * @param schema the schema for the external data
   * @param format the source format of the external data
   * @return a builder for an ExternalTableDefinition object given source URI, schema and format
   *
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public static Builder newBuilder(String sourceUri, Schema schema, FormatOptions format) {
    return newBuilder(ImmutableList.of(sourceUri), schema, format);
  }

  /**
   * Creates an ExternalTableDefinition object.
   *
   * @param sourceUris the fully-qualified URIs that point to your data in Google Cloud Storage.
   *     Each URI can contain one '*' wildcard character that must come after the bucket's name.
   *     Size limits related to load jobs apply to external data sources, plus an additional limit
   *     of 10 GB maximum size across all URIs.
   * @param schema the schema for the external data
   * @param format the source format of the external data
   * @return an ExternalTableDefinition object given source URIs, schema and format
   *
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public static ExternalTableDefinition of(List<String> sourceUris, Schema schema,
      FormatOptions format) {
    return newBuilder(sourceUris, schema, format).build();
  }

  /**
   * Creates an ExternalTableDefinition object.
   *
   * @param sourceUri a fully-qualified URI that points to your data in Google Cloud Storage. The
   *     URI can contain one '*' wildcard character that must come after the bucket's name. Size
   *     limits related to load jobs apply to external data sources.
   * @param schema the schema for the external data
   * @param format the source format of the external data
   * @return an ExternalTableDefinition object given source URIs, schema and format
   *
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public static ExternalTableDefinition of(String sourceUri, Schema schema, FormatOptions format) {
    return newBuilder(sourceUri, schema, format).build();
  }

  @SuppressWarnings("unchecked")
  static ExternalTableDefinition fromPb(Table tablePb) {
    return new Builder(tablePb).build();
  }

  static ExternalTableDefinition fromExternalDataConfiguration(
      ExternalDataConfiguration externalDataConfiguration) {
    Builder builder = new Builder();
    if (externalDataConfiguration.getSourceUris() != null) {
      builder.setSourceUris(externalDataConfiguration.getSourceUris());
    }
    if (externalDataConfiguration.getSchema() != null) {
      builder.setSchema(Schema.fromPb(externalDataConfiguration.getSchema()));
    }
    if (externalDataConfiguration.getSourceFormat() != null) {
      builder.setFormatOptions(FormatOptions.of(externalDataConfiguration.getSourceFormat()));
    }
    if (externalDataConfiguration.getCompression() != null) {
      builder.setCompression(externalDataConfiguration.getCompression());
    }
    if (externalDataConfiguration.getIgnoreUnknownValues() != null) {
      builder.setIgnoreUnknownValues(externalDataConfiguration.getIgnoreUnknownValues());
    }
    if (externalDataConfiguration.getCsvOptions() != null) {
      builder.setFormatOptions(CsvOptions.fromPb(externalDataConfiguration.getCsvOptions()));
    }
    if (externalDataConfiguration.getMaxBadRecords() != null) {
      builder.setMaxBadRecords(externalDataConfiguration.getMaxBadRecords());
    }
    if (externalDataConfiguration.getAutodetect() != null) {
      builder.setAutodetect(externalDataConfiguration.getAutodetect());
    }
    return builder.build();
  }
}
