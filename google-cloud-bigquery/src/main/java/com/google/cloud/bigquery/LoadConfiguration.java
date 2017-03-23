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

package com.google.cloud.bigquery;

import com.google.cloud.bigquery.JobInfo.CreateDisposition;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.JobInfo.SchemaUpdateOption;

import java.util.List;

/**
 * Common interface for a load configuration. A load configuration
 * ({@link WriteChannelConfiguration}) can be used to load data into a table with a
 * {@link com.google.cloud.WriteChannel} ({@link BigQuery#writer(WriteChannelConfiguration)}).
 * A load configuration ({@link LoadJobConfiguration}) can also be used to create a load job
 * ({@link JobInfo#of(JobConfiguration)}).
 */
public interface LoadConfiguration {

  interface Builder {


    /**
     * Sets the destination table to load the data into.
     */
    Builder setDestinationTable(TableId destinationTable);


    /**
     * Sets whether the job is allowed to create new tables.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.load.createDisposition">
     *     Create Disposition</a>
     */
    Builder setCreateDisposition(CreateDisposition createDisposition);


    /**
     * Sets the action that should occur if the destination table already exists.
     *
     * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.load.writeDisposition">
     *     Write Disposition</a>
     */
    Builder setWriteDisposition(WriteDisposition writeDisposition);


    /**
     * Sets the source format, and possibly some parsing options, of the external data. Supported
     * formats are {@code CSV}, {@code NEWLINE_DELIMITED_JSON} and {@code DATASTORE_BACKUP}. If not
     * specified, {@code CSV} format is assumed.
     *
     * <a href="https://cloud.google.com/bigquery/docs/reference/v2/tables#externalDataConfiguration.sourceFormat">
     *     Source Format</a>
     */
    Builder setFormatOptions(FormatOptions formatOptions);


    /**
     * Sets the maximum number of bad records that BigQuery can ignore when running the job. If the
     * number of bad records exceeds this value, an invalid error is returned in the job result.
     * By default no bad record is ignored.
     */
    Builder setMaxBadRecords(Integer maxBadRecords);


    /**
     * Sets the schema for the destination table. The schema can be omitted if the destination table
     * already exists, or if you're loading data from a Google Cloud Datastore backup (i.e.
     * {@code DATASTORE_BACKUP} format option).
     */
    Builder setSchema(Schema schema);


    /**
     * Sets whether BigQuery should allow extra values that are not represented in the table schema.
     * If {@code true}, the extra values are ignored. If {@code false}, records with extra columns
     * are treated as bad records, and if there are too many bad records, an invalid error is
     * returned in the job result. By default unknown values are not allowed.
     */
    Builder setIgnoreUnknownValues(Boolean ignoreUnknownValues);

    /**
     * [Experimental] Sets options allowing the schema of the destination table to be updated as a side effect of the
     * load job. Schema update options are supported in two cases: when writeDisposition is WRITE_APPEND; when
     * writeDisposition is WRITE_TRUNCATE and the destination table is a partition of a table, specified by partition
     * decorators. For normal tables, WRITE_TRUNCATE will always overwrite the schema.
     */
    Builder setSchemaUpdateOptions(List<SchemaUpdateOption> schemaUpdateOptions);

    /**
     * [Experimental] Sets automatic inference of the options and schema for CSV and JSON sources.
     */
    Builder setAutodetect(Boolean autodetect);

    LoadConfiguration build();
  }


  /**
   * Returns the destination table to load the data into.
   */
  TableId getDestinationTable();


  /**
   * Returns whether the job is allowed to create new tables.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.load.createDisposition">
   *     Create Disposition</a>
   */
  CreateDisposition getCreateDisposition();


  /**
   * Returns the action that should occur if the destination table already exists.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/reference/v2/jobs#configuration.load.writeDisposition">
   *     Write Disposition</a>
   */
  WriteDisposition getWriteDisposition();


  /**
   * Returns additional properties used to parse CSV data (used when {@link #getFormat()} is set
   * to CSV). Returns {@code null} if not set.
   */
  CsvOptions getCsvOptions();


  /**
   * Returns the maximum number of bad records that BigQuery can ignore when running the job. If the
   * number of bad records exceeds this value, an invalid error is returned in the job result.
   * By default no bad record is ignored.
   */
  Integer getMaxBadRecords();


  /**
   * Returns the schema for the destination table, if set. Returns {@code null} otherwise.
   */
  Schema getSchema();


  /**
   * Returns the format of the data files.
   */
  String getFormat();

  /**
   * Returns whether BigQuery should allow extra values that are not represented in the table
   * schema. If {@code true}, the extra values are ignored. If {@code true}, records with extra
   * columns are treated as bad records, and if there are too many bad records, an invalid error is
   * returned in the job result. By default unknown values are not allowed.
   */
  Boolean ignoreUnknownValues();


  /**
   * Returns additional options used to load from a Cloud datastore backup.
   */
  DatastoreBackupOptions getDatastoreBackupOptions();

  /**
   * [Experimental] Returns options allowing the schema of the destination table to be updated as a side effect of the
   * load job. Schema update options are supported in two cases: when writeDisposition is WRITE_APPEND; when
   * writeDisposition is WRITE_TRUNCATE and the destination table is a partition of a table, specified by partition
   * decorators. For normal tables, WRITE_TRUNCATE will always overwrite the schema.
   */
  List<SchemaUpdateOption> getSchemaUpdateOptions();

  /**
   * [Experimental] Returns whether automatic inference of the options and schema for CSV and JSON sources is set.
   */
  Boolean getAutodetect();

  /**
   * Returns a builder for the load configuration object.
   */
  Builder toBuilder();
}
