/*
 * Copyright 2023 Google LLC
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

import com.google.auto.value.AutoValue;
import java.io.Serializable;

@AutoValue
public abstract class BigLakeConfiguration implements Serializable {

  private static final long serialVersionUID = -5951589238459622025L;

  /**
   * Credential reference for accessing external storage system. Normalized as
   * project_id.location_id.connection_id.
   *
   * @return value or {@code null} for none
   */
  public abstract String getConnectionId();

  /**
   * Open source file format that the table data is stored in. Currently only PARQUET is supported.
   *
   * @return value or {@code null} for none
   */
  public abstract String getFileFormat();

  /**
   * Fully qualified location prefix of the external folder where data is stored. Starts with
   * "gs://" ends with "/". Does not contain "*".
   *
   * @return value or {@code null} for none
   */
  public abstract String getStorageUri();

  /**
   * Open source file format that the table data is stored in. Currently only PARQUET is supported.
   *
   * @return value or {@code null} for none
   */
  public abstract String getTableFormat();

  public static Builder newBuilder() {
    return new AutoValue_BigLakeConfiguration.Builder();
  }

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * [Required] Required and immutable. Credential reference for accessing external storage
     * system. Normalized as project_id.location_id.connection_id.
     *
     * @param connectionId connectionId or {@code null} for none
     */
    public abstract Builder setConnectionId(String connectionId);

    /**
     * [Required] Required and immutable. Open source file format that the table data is stored in.
     * Currently only PARQUET is supported.
     *
     * @param fileFormat fileFormat or {@code null} for none
     */
    public abstract Builder setFileFormat(String fileFormat);

    /**
     * [Required] Required and immutable. Fully qualified location prefix of the external folder
     * where data is stored. Starts with "gs://" and ends with "/". Does not contain "*".
     *
     * @param storageUri storageUri or {@code null} for none
     */
    public abstract Builder setStorageUri(String storageUri);

    /**
     * [Required] Required and immutable. Open source file format that the table data is stored in.
     * Currently only PARQUET is supported.
     *
     * @param tableFormat tableFormat or {@code null} for none
     */
    public abstract Builder setTableFormat(String tableFormat);

    public abstract BigLakeConfiguration build();
  }

  com.google.api.services.bigquery.model.BigLakeConfiguration toPb() {
    com.google.api.services.bigquery.model.BigLakeConfiguration biglakeConfiguration =
        new com.google.api.services.bigquery.model.BigLakeConfiguration();
    biglakeConfiguration.setConnectionId(getConnectionId());
    biglakeConfiguration.setFileFormat(getFileFormat());
    biglakeConfiguration.setStorageUri(getStorageUri());
    biglakeConfiguration.setTableFormat(getTableFormat());

    return biglakeConfiguration;
  }

  static BigLakeConfiguration fromPb(
      com.google.api.services.bigquery.model.BigLakeConfiguration biglakeConfigurationPb) {
    return newBuilder()
        .setConnectionId(biglakeConfigurationPb.getConnectionId())
        .setFileFormat(biglakeConfigurationPb.getFileFormat())
        .setStorageUri(biglakeConfigurationPb.getStorageUri())
        .setTableFormat(biglakeConfigurationPb.getTableFormat())
        .build();
  }
}
