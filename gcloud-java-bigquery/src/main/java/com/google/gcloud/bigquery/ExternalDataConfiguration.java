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

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery configuration for tables backed by external data. Objects of this class describe
 * the data format, location, and other properties of a table stored outside of BigQuery.
 * By defining these properties, the data source can then be queried as if it were a standard
 * BigQuery table. Support for external tables is experimental and might be subject to changes or
 * removed.
 *
 * @see <a href="https://cloud.google.com/bigquery/federated-data-sources">Federated Data Sources
 *     </a>
 */
public class ExternalDataConfiguration implements Serializable {

  static final Function<com.google.api.services.bigquery.model.ExternalDataConfiguration,
      ExternalDataConfiguration> FROM_PB_FUNCTION =
      new Function<com.google.api.services.bigquery.model.ExternalDataConfiguration,
          ExternalDataConfiguration>() {
        @Override
        public ExternalDataConfiguration apply(
            com.google.api.services.bigquery.model.ExternalDataConfiguration configurationPb) {
          return ExternalDataConfiguration.fromPb(configurationPb);
        }
      };
  static final Function<ExternalDataConfiguration,
      com.google.api.services.bigquery.model.ExternalDataConfiguration> TO_PB_FUNCTION =
      new Function<ExternalDataConfiguration,
          com.google.api.services.bigquery.model.ExternalDataConfiguration>() {
        @Override
        public com.google.api.services.bigquery.model.ExternalDataConfiguration apply(
            ExternalDataConfiguration configuration) {
          return configuration.toPb();
        }
      };

  private static final long serialVersionUID = -8004288831035566549L;

  private final List<String> sourceUris;
  private final Schema schema;
  private final FormatOptions formatOptions;
  private final Integer maxBadRecords;
  private final Boolean ignoreUnknownValues;
  private final String compression;

  public static final class Builder {

    private List<String> sourceUris;
    private Schema schema;
    private FormatOptions formatOptions;
    private Integer maxBadRecords;
    private Boolean ignoreUnknownValues;
    private String compression;

    private Builder() {}

    /**
     * Sets the fully-qualified URIs that point to your data in Google Cloud Storage (e.g.
     * gs://bucket/path). Each URI can contain one '*' wildcard character that must come after the
     * bucket's name. Size limits related to load jobs apply to external data sources, plus an
     * additional limit of 10 GB maximum size across all URIs.
     *
     * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
     */
    public Builder sourceUris(List<String> sourceUris) {
      this.sourceUris = ImmutableList.copyOf(checkNotNull(sourceUris));
      return this;
    }

    /**
     * Sets the schema for the external data.
     */
    public Builder schema(Schema schema) {
      this.schema = checkNotNull(schema);
      return this;
    }

    /**
     * Sets the source format, and possibly some parsing options, of the external data. Supported
     * formats are {@code CSV} and {@code NEWLINE_DELIMITED_JSON}.
     *
     * <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
     *     Source Format</a>
     */
    public Builder formatOptions(FormatOptions formatOptions) {
      this.formatOptions = checkNotNull(formatOptions);
      return this;
    }

    /**
     * Sets the maximum number of bad records that BigQuery can ignore when reading data. If the
     * number of bad records exceeds this value, an invalid error is returned in the job result.
     * The default value is 0, which requires that all records are valid.
     */
    public Builder maxBadRecords(Integer maxBadRecords) {
      this.maxBadRecords = maxBadRecords;
      return this;
    }

    /**
     * Sets whether BigQuery should allow extra values that are not represented in the table schema.
     * If true, the extra values are ignored. If false, records with extra columns are treated as
     * bad records, and if there are too many bad records, an invalid error is returned in the job
     * result. The default value is false. The value set with {@link #formatOptions(FormatOptions)}
     * property determines what BigQuery treats as an extra value.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.ignoreUnknownValues">
     *     Ignore Unknown Values</a>
     */
    public Builder ignoreUnknownValues(Boolean ignoreUnknownValues) {
      this.ignoreUnknownValues = ignoreUnknownValues;
      return this;
    }

    /**
     * Sets compression type of the data source. By default no compression is assumed.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.compression">
     *     Compression</a>
     */
    public Builder compression(String compression) {
      this.compression = compression;
      return this;
    }

    /**
     * Creates an {@code ExternalDataConfiguration} object.
     */
    public ExternalDataConfiguration build() {
      return new ExternalDataConfiguration(this);
    }
  }

  ExternalDataConfiguration(Builder builder) {
    this.compression = builder.compression;
    this.ignoreUnknownValues = builder.ignoreUnknownValues;
    this.maxBadRecords = builder.maxBadRecords;
    this.schema = builder.schema;
    this.formatOptions = builder.formatOptions;
    this.sourceUris = builder.sourceUris;
  }

  /**
   * Returns the compression type of the data source.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.compression">
   *     Compression</a>
   */
  public String compression() {
    return compression;
  }

  /**
   * Returns whether BigQuery should allow extra values that are not represented in the table
   * schema. If true, the extra values are ignored. If false, records with extra columns are treated
   * as bad records, and if there are too many bad records, an invalid error is returned in the job
   * result. The default value is false. The value of {@link #format()} determines what BigQuery
   * treats as an extra value.
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
  public Integer maxBadRecords() {
    return maxBadRecords;
  }

  /**
   * Returns the schema for the external data.
   */
  public Schema schema() {
    return schema;
  }

  /**
   * Returns the source format of the external data.
   *
   * <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public String format() {
    return formatOptions.type();
  }

  /**
   * Returns the fully-qualified URIs that point to your data in Google Cloud Storage. Each URI can
   * contain one '*' wildcard character that must come after the bucket's name. Size limits
   * related to load jobs apply to external data sources, plus an additional limit of 10 GB
   * maximum size across all URIs.
   *
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   */
  public List<String> sourceUris() {
    return sourceUris;
  }

  /**
   * Returns additional properties used to parse CSV data (used when {@link #format()} is set to
   * CSV). Returns {@code null} if not set.
   */
  public CsvOptions csvOptions() {
    return formatOptions instanceof CsvOptions ? (CsvOptions) formatOptions : null;
  }

  /**
   * Returns a builder for the {@code ExternalDataConfiguration} object.
   */
  public Builder toBuilder() {
    return new Builder()
        .compression(compression)
        .ignoreUnknownValues(ignoreUnknownValues)
        .maxBadRecords(maxBadRecords)
        .schema(schema)
        .formatOptions(formatOptions)
        .sourceUris(sourceUris);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("sourceUris", sourceUris)
        .add("formatOptions", formatOptions)
        .add("schema", schema)
        .add("compression", compression)
        .add("ignoreUnknownValues", ignoreUnknownValues)
        .add("maxBadRecords", maxBadRecords)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(compression, ignoreUnknownValues, maxBadRecords, schema, formatOptions,
        sourceUris);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof ExternalDataConfiguration
        && Objects.equals(toPb(), ((ExternalDataConfiguration) obj).toPb());
  }

  com.google.api.services.bigquery.model.ExternalDataConfiguration toPb() {
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
    if (schema != null) {
      externalConfigurationPb.setSchema(schema.toPb());
    }
    if (formatOptions != null) {
      externalConfigurationPb.setSourceFormat(formatOptions.type());
    }
    if (sourceUris != null) {
      externalConfigurationPb.setSourceUris(sourceUris);
    }
    if (csvOptions() != null) {
      externalConfigurationPb.setCsvOptions(csvOptions().toPb());
    }
    return externalConfigurationPb;
  }

  /**
   * Creates a builder for an ExternalDataConfiguration object.
   *
   * @param sourceUris the fully-qualified URIs that point to your data in Google Cloud Storage.
   *     Each URI can contain one '*' wildcard character that must come after the bucket's name.
   *     Size limits related to load jobs apply to external data sources, plus an additional limit
   *     of 10 GB maximum size across all URIs.
   * @param schema the schema for the external data
   * @param format the source format of the external data
   * @return a builder for an ExternalDataConfiguration object given source URIs, schema and format
   *
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public static Builder builder(List<String> sourceUris, Schema schema, FormatOptions format) {
    return new Builder().sourceUris(sourceUris).schema(schema).formatOptions(format);
  }

  /**
   * Creates a builder for an ExternalDataConfiguration object.
   *
   * @param sourceUri a fully-qualified URI that points to your data in Google Cloud Storage. The
   *     URI can contain one '*' wildcard character that must come after the bucket's name. Size
   *     limits related to load jobs apply to external data sources.
   * @param schema the schema for the external data
   * @param format the source format of the external data
   * @return a builder for an ExternalDataConfiguration object given source URI, schema and format
   *
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public static Builder builder(String sourceUri, Schema schema, FormatOptions format) {
    return new Builder()
        .sourceUris(ImmutableList.of(sourceUri))
        .schema(schema)
        .formatOptions(format);
  }

  /**
   * Creates an ExternalDataConfiguration object.
   *
   * @param sourceUris the fully-qualified URIs that point to your data in Google Cloud Storage.
   *     Each URI can contain one '*' wildcard character that must come after the bucket's name.
   *     Size limits related to load jobs apply to external data sources, plus an additional limit
   *     of 10 GB maximum size across all URIs.
   * @param schema the schema for the external data
   * @param format the source format of the external data
   * @return an ExternalDataConfiguration object given source URIs, schema and format
   *
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public static ExternalDataConfiguration of(List<String> sourceUris, Schema schema,
      FormatOptions format) {
    return builder(sourceUris, schema, format).build();
  }

  /**
   * Creates an ExternalDataConfiguration object.
   *
   * @param sourceUri a fully-qualified URI that points to your data in Google Cloud Storage. The
   *     URI can contain one '*' wildcard character that must come after the bucket's name. Size
   *     limits related to load jobs apply to external data sources.
   * @param schema the schema for the external data
   * @param format the source format of the external data
   * @return an ExternalDataConfiguration object given source URIs, schema and format
   *
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public static ExternalDataConfiguration of(String sourceUri, Schema schema,
      FormatOptions format) {
    return builder(sourceUri, schema, format).build();
  }

  static ExternalDataConfiguration fromPb(
      com.google.api.services.bigquery.model.ExternalDataConfiguration externalDataConfiguration) {
    Builder builder = new Builder();
    if (externalDataConfiguration.getSourceUris() != null) {
      builder.sourceUris(externalDataConfiguration.getSourceUris());
    }
    if (externalDataConfiguration.getSchema() != null) {
      builder.schema(Schema.fromPb(externalDataConfiguration.getSchema()));
    }
    if (externalDataConfiguration.getSourceFormat() != null) {
      builder.formatOptions(FormatOptions.of(externalDataConfiguration.getSourceFormat()));
    }
    if (externalDataConfiguration.getCompression() != null) {
      builder.compression(externalDataConfiguration.getCompression());
    }
    if (externalDataConfiguration.getIgnoreUnknownValues() != null) {
      builder.ignoreUnknownValues(externalDataConfiguration.getIgnoreUnknownValues());
    }
    if (externalDataConfiguration.getCsvOptions() != null) {
      builder.formatOptions(CsvOptions.fromPb(externalDataConfiguration.getCsvOptions()));
    }
    if (externalDataConfiguration.getMaxBadRecords() != null) {
      builder.maxBadRecords(externalDataConfiguration.getMaxBadRecords());
    }
    return builder.build();
  }
}
