/*
 * Copyright 2016 Google LLC
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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

import com.google.api.services.bigquery.model.ExternalDataConfiguration;
import com.google.api.services.bigquery.model.Table;
import com.google.auto.value.AutoValue;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Google BigQuery external table definition. BigQuery's external tables are tables whose data
 * reside outside of BigQuery but can be queried as normal BigQuery tables. External tables are
 * experimental and might be subject to change or removed.
 *
 * @see <a href="https://cloud.google.com/bigquery/federated-data-sources">Federated Data Sources
 *     </a>
 */
@AutoValue
public abstract class ExternalTableDefinition extends TableDefinition {

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

  @AutoValue.Builder
  public abstract static class Builder
      extends TableDefinition.Builder<ExternalTableDefinition, Builder> {

    /**
     * Sets the fully-qualified URIs that point to your data in Google Cloud Storage (e.g.
     * gs://bucket/path). Each URI can contain one '*' wildcard character that must come after the
     * bucket's name. Size limits related to load jobs apply to external data sources, plus an
     * additional limit of 10 GB maximum size across all URIs.
     *
     * <p>For Google Cloud Bigtable URIs: Exactly one URI can be specified and it has be a fully
     * specified and valid HTTPS URL for a Google Cloud Bigtable table.
     *
     * <p>For Google Cloud Datastore backup URIs: Exactly one URI can be specified. Also, the '*'
     * wildcard character is not allowed.
     *
     * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
     */
    public Builder setSourceUris(List<String> sourceUris) {
      return setSourceUrisImmut(ImmutableList.copyOf(sourceUris));
    }

    abstract Builder setFileSetSpecTypeInner(String spec);

    abstract Builder setSourceUrisImmut(ImmutableList<String> sourceUris);

    /**
     * Defines how to interpret files denoted by URIs. By default the files are assumed to be data
     * files (this can be specified explicitly via FILE_SET_SPEC_TYPE_FILE_SYSTEM_MATCH). A second
     * option is "FILE_SET_SPEC_TYPE_NEW_LINE_DELIMITED_MANIFEST" which interprets each file as a
     * manifest file, where each line is a reference to a file.
     */
    public Builder setFileSetSpecType(String fileSetSpecType) {
      return setFileSetSpecTypeInner(fileSetSpecType);
    }

    /**
     * Sets the source format, and possibly some parsing options, of the external data. Supported
     * formats are {@code CSV} and {@code NEWLINE_DELIMITED_JSON}.
     *
     * <p><a
     * href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
     * Source Format</a>
     */
    public Builder setFormatOptions(FormatOptions formatOptions) {
      return setFormatOptionsInner(formatOptions);
    }

    /**
     * Defines the list of possible SQL data types to which the source decimal values are converted.
     * This list and the precision and the scale parameters of the decimal field determine the
     * target type. In the order of NUMERIC, BIGNUMERIC, and STRING, a type is picked if it is in
     * the specified list and if it supports the precision and the scale. STRING supports all
     * precision and scale values.
     *
     * @param decimalTargetTypes decimalTargetType or {@code null} for none
     */
    public abstract Builder setDecimalTargetTypes(List<String> decimalTargetTypes);

    abstract Builder setFormatOptionsInner(FormatOptions formatOptions);

    /**
     * Sets the maximum number of bad records that BigQuery can ignore when reading data. If the
     * number of bad records exceeds this value, an invalid error is returned in the job result. The
     * default value is 0, which requires that all records are valid.
     */
    public abstract Builder setMaxBadRecords(Integer maxBadRecords);

    /**
     * Sets whether BigQuery should allow extra values that are not represented in the table schema.
     * If true, the extra values are ignored. If false, records with extra columns are treated as
     * bad records, and if there are too many bad records, an invalid error is returned in the job
     * result. The default value is false. The value set with {@link
     * #setFormatOptions(FormatOptions)} property determines what BigQuery treats as an extra value.
     *
     * @see <a
     *     href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.ignoreUnknownValues">
     *     Ignore Unknown Values</a>
     */
    public abstract Builder setIgnoreUnknownValues(Boolean ignoreUnknownValues);

    /**
     * Sets compression type of the data source. By default no compression is assumed.
     *
     * @see <a
     *     href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.compression">
     *     Compression</a>
     */
    public abstract Builder setCompression(String compression);

    /**
     * [Optional, Trusted Tester] connectionId for external data source. The value may be {@code
     * null}.
     */
    public abstract Builder setConnectionId(String connectionId);

    /**
     * [Experimental] Sets detection of schema and format options automatically. Any option
     * specified explicitly will be honored.
     */
    public abstract Builder setAutodetect(Boolean autodetect);

    public abstract Builder setType(Type type);

    /** Sets the table schema. */
    public abstract Builder setSchema(Schema schema);

    /** Sets the table Hive partitioning options. */
    public Builder setHivePartitioningOptions(HivePartitioningOptions hivePartitioningOptions) {
      return setHivePartitioningOptionsInner(hivePartitioningOptions);
    };

    /**
     * When creating an external table, the user can provide a reference file with the table schema.
     * This is enabled for the following formats: AVRO, PARQUET, ORC.
     *
     * @param referenceFileSchemaUri or {@code null} for none
     */
    public abstract Builder setReferenceFileSchemaUri(String referenceFileSchemaUri);

    abstract Builder setHivePartitioningOptionsInner(
        HivePartitioningOptions hivePartitioningOptions);

    /** Creates an {@code ExternalTableDefinition} object. */
    @Override
    public abstract ExternalTableDefinition build();
  }

  /**
   * Returns the compression type of the data source.
   *
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.compression">
   *     Compression</a>
   */
  @Nullable
  public abstract String getCompression();

  /**
   * Returns the connection ID used to connect to external data source.
   *
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration">
   *     ConnectionId</a>
   */
  @Nullable
  public abstract String getConnectionId();

  /**
   * Returns whether BigQuery should allow extra values that are not represented in the table
   * schema. If true, the extra values are ignored. If false, records with extra columns are treated
   * as bad records, and if there are too many bad records, an invalid error is returned in the job
   * result. The default value is false. The value of {@link #getFormatOptions()} determines what
   * BigQuery treats as an extra value.
   *
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.ignoreUnknownValues">
   *     Ignore Unknown Values</a>
   */
  @Nullable
  public Boolean ignoreUnknownValues() {
    return getIgnoreUnknownValues();
  };

  @Nullable
  public abstract Boolean getIgnoreUnknownValues();

  /**
   * Returns the maximum number of bad records that BigQuery can ignore when reading data. If the
   * number of bad records exceeds this value, an invalid error is returned in the job result.
   */
  @Nullable
  public abstract Integer getMaxBadRecords();

  /**
   * Returns the fully-qualified URIs that point to your data in Google Cloud Storage. Each URI can
   * contain one '*' wildcard character that must come after the bucket's name. Size limits related
   * to load jobs apply to external data sources, plus an additional limit of 10 GB maximum size
   * across all URIs.
   *
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   */
  @Nullable
  public List<String> getSourceUris() {
    return getSourceUrisImmut();
  }

  @Nullable
  public String getFileSetSpecType() {
    return getFileSetSpecTypeInner();
  }

  @Nullable
  abstract String getFileSetSpecTypeInner();

  @Nullable
  public abstract ImmutableList<String> getSourceUrisImmut();

  /**
   * Returns the source format, and possibly some parsing options, of the external data. Supported
   * formats are {@code CSV} and {@code NEWLINE_DELIMITED_JSON}.
   */
  @SuppressWarnings("unchecked")
  @Nullable
  public <F extends FormatOptions> F getFormatOptions() {
    return (F) getFormatOptionsInner();
  }

  @Nullable
  abstract FormatOptions getFormatOptionsInner();

  @Nullable
  public abstract ImmutableList<String> getDecimalTargetTypes();

  /**
   * [Experimental] Returns whether automatic detection of schema and format options should be
   * performed.
   */
  @Nullable
  public abstract Boolean getAutodetect();

  @Nullable
  public abstract String getReferenceFileSchemaUri();

  /**
   * [Experimental] Returns the HivePartitioningOptions when the data layout follows Hive
   * partitioning convention
   */
  @SuppressWarnings("unchecked")
  @Nullable
  public HivePartitioningOptions getHivePartitioningOptions() {
    return getHivePartitioningOptionsInner();
  }

  @Nullable
  abstract HivePartitioningOptions getHivePartitioningOptionsInner();

  /** Returns a builder for the {@code ExternalTableDefinition} object. */
  public abstract Builder toBuilder();

  @Override
  com.google.api.services.bigquery.model.Table toPb() {
    Table tablePb = super.toPb();
    tablePb.setExternalDataConfiguration(toExternalDataConfigurationPb());
    return tablePb;
  }

  com.google.api.services.bigquery.model.ExternalDataConfiguration toExternalDataConfigurationPb() {
    com.google.api.services.bigquery.model.ExternalDataConfiguration externalConfigurationPb =
        new com.google.api.services.bigquery.model.ExternalDataConfiguration();
    if (getCompression() != null) {
      externalConfigurationPb.setCompression(getCompression());
    }
    if (getConnectionId() != null) {
      externalConfigurationPb.setConnectionId(getConnectionId());
    }
    if (ignoreUnknownValues() != null) {
      externalConfigurationPb.setIgnoreUnknownValues(ignoreUnknownValues());
    }
    if (getMaxBadRecords() != null) {
      externalConfigurationPb.setMaxBadRecords(getMaxBadRecords());
    }
    if (getSchema() != null) {
      externalConfigurationPb.setSchema(getSchema().toPb());
    }
    if (getFormatOptions() != null) {
      externalConfigurationPb.setSourceFormat(getFormatOptions().getType());
    }
    if (getSourceUris() != null) {
      externalConfigurationPb.setSourceUris(getSourceUris());
    }
    if (getDecimalTargetTypes() != null) {
      externalConfigurationPb.setDecimalTargetTypes(getDecimalTargetTypes());
    }
    if (getFormatOptions() != null && FormatOptions.PARQUET.equals(getFormatOptions().getType())) {
      externalConfigurationPb.setParquetOptions(((ParquetOptions) getFormatOptions()).toPb());
    }
    if (getFormatOptions() != null && FormatOptions.AVRO.equals(getFormatOptions().getType())) {
      externalConfigurationPb.setAvroOptions(((AvroOptions) getFormatOptions()).toPb());
    }
    if (getFormatOptions() != null && FormatOptions.CSV.equals(getFormatOptions().getType())) {
      externalConfigurationPb.setCsvOptions(((CsvOptions) getFormatOptions()).toPb());
    }
    if (getFormatOptions() != null
        && FormatOptions.GOOGLE_SHEETS.equals(getFormatOptions().getType())) {
      externalConfigurationPb.setGoogleSheetsOptions(
          ((GoogleSheetsOptions) getFormatOptions()).toPb());
    }
    if (getFormatOptions() != null && FormatOptions.BIGTABLE.equals(getFormatOptions().getType())) {
      externalConfigurationPb.setBigtableOptions(((BigtableOptions) getFormatOptions()).toPb());
    }
    if (getAutodetect() != null) {
      externalConfigurationPb.setAutodetect(getAutodetect());
    }
    if (getReferenceFileSchemaUri() != null) {
      externalConfigurationPb.setReferenceFileSchemaUri(getReferenceFileSchemaUri());
    }

    if (getHivePartitioningOptions() != null) {
      externalConfigurationPb.setHivePartitioningOptions(getHivePartitioningOptions().toPb());
    }
    if (getFileSetSpecType() != null) {
      externalConfigurationPb.setFileSetSpecType(getFileSetSpecType());
    }

    return externalConfigurationPb;
  }

  static Builder newBuilder() {
    return new AutoValue_ExternalTableDefinition.Builder().setType(Type.EXTERNAL);
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
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public static Builder newBuilder(List<String> sourceUris, Schema schema, FormatOptions format) {
    return newBuilder().setSourceUris(sourceUris).setSchema(schema).setFormatOptions(format);
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
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public static Builder newBuilder(String sourceUri, Schema schema, FormatOptions format) {
    checkArgument(!isNullOrEmpty(sourceUri), "Provided sourceUri is null or empty");
    return newBuilder(ImmutableList.of(sourceUri), schema, format);
  }

  /**
   * Creates a builder for an ExternalTableDefinition object.
   *
   * @param sourceUri the fully-qualified URIs that point to your data in Google Cloud. For Google
   *     Cloud Bigtable URIs: Exactly one URI can be specified and it has be a fully specified and
   *     valid HTTPS URL for a Google Cloud Bigtable table. Size limits related to load jobs apply
   *     to external data sources, plus an additional limit of 10 GB maximum size across all URIs.
   * @param format the source format of the external data
   * @return a builder for an ExternalTableDefinition object given source URIs and format
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public static Builder newBuilder(String sourceUri, FormatOptions format) {
    checkArgument(!isNullOrEmpty(sourceUri), "Provided sourceUri is null or empty");
    return newBuilder().setSourceUris(ImmutableList.of(sourceUri)).setFormatOptions(format);
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
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public static ExternalTableDefinition of(
      List<String> sourceUris, Schema schema, FormatOptions format) {
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
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public static ExternalTableDefinition of(String sourceUri, Schema schema, FormatOptions format) {
    return newBuilder(sourceUri, schema, format).build();
  }

  /**
   * Creates a builder for an ExternalTableDefinition object.
   *
   * @param sourceUri the fully-qualified URIs that point to your data in Google Cloud. For Google
   *     Cloud Bigtable URIs: Exactly one URI can be specified and it has be a fully specified and
   *     valid HTTPS URL for a Google Cloud Bigtable table. Size limits related to load jobs apply
   *     to external data sources, plus an additional limit of 10 GB maximum size across all URIs.
   * @param format the source format of the external data
   * @return a builder for an ExternalTableDefinition object given source URIs and format
   * @see <a href="https://cloud.google.com/bigquery/loading-data-into-bigquery#quota">Quota</a>
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
   *     Source Format</a>
   */
  public static ExternalTableDefinition of(String sourceUri, FormatOptions format) {
    return newBuilder(sourceUri, format).build();
  }

  @SuppressWarnings("unchecked")
  static ExternalTableDefinition fromPb(Table tablePb) {
    Builder builder = newBuilder().table(tablePb);

    com.google.api.services.bigquery.model.ExternalDataConfiguration externalDataConfiguration =
        tablePb.getExternalDataConfiguration();
    if (externalDataConfiguration != null) {
      if (externalDataConfiguration.getSourceUris() != null) {
        builder.setSourceUris(ImmutableList.copyOf(externalDataConfiguration.getSourceUris()));
      }
      if (externalDataConfiguration.getDecimalTargetTypes() != null) {
        builder.setDecimalTargetTypes(
            ImmutableList.copyOf(externalDataConfiguration.getDecimalTargetTypes()));
      }
      if (externalDataConfiguration.getSourceFormat() != null) {
        builder.setFormatOptions(FormatOptions.of(externalDataConfiguration.getSourceFormat()));
      }
      builder.setCompression(externalDataConfiguration.getCompression());
      if (externalDataConfiguration.getConnectionId() != null) {
        builder.setConnectionId(externalDataConfiguration.getConnectionId());
      }
      builder.setIgnoreUnknownValues(externalDataConfiguration.getIgnoreUnknownValues());
      if (externalDataConfiguration.getAvroOptions() != null) {
        builder.setFormatOptions(AvroOptions.fromPb(externalDataConfiguration.getAvroOptions()));
      }
      if (externalDataConfiguration.getCsvOptions() != null) {
        builder.setFormatOptions(CsvOptions.fromPb(externalDataConfiguration.getCsvOptions()));
      }
      if (externalDataConfiguration.getGoogleSheetsOptions() != null) {
        builder.setFormatOptions(
            GoogleSheetsOptions.fromPb(externalDataConfiguration.getGoogleSheetsOptions()));
      }
      if (externalDataConfiguration.getBigtableOptions() != null) {
        builder.setFormatOptions(
            BigtableOptions.fromPb(externalDataConfiguration.getBigtableOptions()));
      }
      if (externalDataConfiguration.getParquetOptions() != null) {
        builder.setFormatOptions(
            ParquetOptions.fromPb(externalDataConfiguration.getParquetOptions()));
      }
      builder.setMaxBadRecords(externalDataConfiguration.getMaxBadRecords());
      builder.setAutodetect(externalDataConfiguration.getAutodetect());
      if (externalDataConfiguration.getHivePartitioningOptions() != null) {
        builder.setHivePartitioningOptions(
            HivePartitioningOptions.fromPb(externalDataConfiguration.getHivePartitioningOptions()));
      }
      if (externalDataConfiguration.getReferenceFileSchemaUri() != null) {
        builder.setReferenceFileSchemaUri(externalDataConfiguration.getReferenceFileSchemaUri());
      }
      if (externalDataConfiguration.getFileSetSpecType() != null) {
        builder.setFileSetSpecType(externalDataConfiguration.getFileSetSpecType());
      }
    }
    return builder.build();
  }

  static ExternalTableDefinition fromExternalDataConfiguration(
      ExternalDataConfiguration externalDataConfiguration) {
    Builder builder = newBuilder();
    if (externalDataConfiguration.getSourceUris() != null) {
      builder.setSourceUris(externalDataConfiguration.getSourceUris());
    }
    if (externalDataConfiguration.getDecimalTargetTypes() != null) {
      builder.setDecimalTargetTypes(externalDataConfiguration.getDecimalTargetTypes());
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
    if (externalDataConfiguration.getConnectionId() != null) {
      builder.setConnectionId(externalDataConfiguration.getConnectionId());
    }
    if (externalDataConfiguration.getIgnoreUnknownValues() != null) {
      builder.setIgnoreUnknownValues(externalDataConfiguration.getIgnoreUnknownValues());
    }
    if (externalDataConfiguration.getAvroOptions() != null) {
      builder.setFormatOptions(AvroOptions.fromPb(externalDataConfiguration.getAvroOptions()));
    }
    if (externalDataConfiguration.getCsvOptions() != null) {
      builder.setFormatOptions(CsvOptions.fromPb(externalDataConfiguration.getCsvOptions()));
    }
    if (externalDataConfiguration.getGoogleSheetsOptions() != null) {
      builder.setFormatOptions(
          GoogleSheetsOptions.fromPb(externalDataConfiguration.getGoogleSheetsOptions()));
    }
    if (externalDataConfiguration.getBigtableOptions() != null) {
      builder.setFormatOptions(
          BigtableOptions.fromPb(externalDataConfiguration.getBigtableOptions()));
    }
    if (externalDataConfiguration.getParquetOptions() != null) {
      builder.setFormatOptions(
          ParquetOptions.fromPb(externalDataConfiguration.getParquetOptions()));
    }
    if (externalDataConfiguration.getMaxBadRecords() != null) {
      builder.setMaxBadRecords(externalDataConfiguration.getMaxBadRecords());
    }
    if (externalDataConfiguration.getAutodetect() != null) {
      builder.setAutodetect(externalDataConfiguration.getAutodetect());
    }
    if (externalDataConfiguration.getReferenceFileSchemaUri() != null) {
      builder.setReferenceFileSchemaUri(externalDataConfiguration.getReferenceFileSchemaUri());
    }
    if (externalDataConfiguration.getHivePartitioningOptions() != null) {
      builder.setHivePartitioningOptions(
          HivePartitioningOptions.fromPb(externalDataConfiguration.getHivePartitioningOptions()));
    }
    if (externalDataConfiguration.getFileSetSpecType() != null) {
      builder.setFileSetSpecType(externalDataConfiguration.getFileSetSpecType());
    }

    return builder.build();
  }
}
