/*
 * Copyright 2015 Google LLC
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

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Base class for Google BigQuery format options. These class define the format of external data
 * used by BigQuery, for either federated tables or load jobs.
 */
public class FormatOptions implements Serializable {

  static final String CSV = "CSV";
  static final String JSON = "NEWLINE_DELIMITED_JSON";
  static final String DATASTORE_BACKUP = "DATASTORE_BACKUP";
  static final String AVRO = "AVRO";
  static final String GOOGLE_SHEETS = "GOOGLE_SHEETS";
  private static final long serialVersionUID = -443376052020423691L;

  private final String type;

  FormatOptions(String type) {
    this.type = type;
  }


  /**
   * Returns the external data format, as a string.
   */
  public String getType() {
    return type;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("format", type).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(type);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
        && obj.getClass().equals(FormatOptions.class)
        && Objects.equals(type, ((FormatOptions) obj).getType());
  }

  /**
   * Default options for CSV format.
   */
  public static CsvOptions csv() {
    return CsvOptions.newBuilder().build();
  }

  /**
   * Default options for NEWLINE_DELIMITED_JSON format.
   */
  public static FormatOptions json() {
    return new FormatOptions(JSON);
  }

  /**
   * Default options for DATASTORE_BACKUP format.
   */
  public static FormatOptions datastoreBackup() {
    return DatastoreBackupOptions.newBuilder().build();
  }

  /**
   * Default options for AVRO format.
   */
  public static FormatOptions avro() {
    return new FormatOptions(AVRO);
  }

  /**
   * Default options for GOOGLE_SHEETS format.
   */
  public static FormatOptions googleSheets() {
    return GoogleSheetsOptions.newBuilder().build();
  }

  /**
   * Default options for the provided format.
   */
  public static FormatOptions of(String format) {
    if (checkNotNull(format).equals(CSV)) {
      return csv();
    } else if (format.equals(DATASTORE_BACKUP)) {
      return datastoreBackup();
    } else if (format.equals(GOOGLE_SHEETS)) {
      return googleSheets();
    }
    return new FormatOptions(format);
  }
}
