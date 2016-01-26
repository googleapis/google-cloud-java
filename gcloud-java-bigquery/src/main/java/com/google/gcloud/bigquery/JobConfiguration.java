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

/**
 * Common interface for a BigQuery Job configuration.
 */
public interface JobConfiguration {

  /**
   * Type of a BigQuery Job.
   */
  enum Type {
    /**
     * A Copy Job copies an existing table to another new or existing table.
     */
    COPY,
    /**
     * An Extract Job exports a BigQuery table to Google Cloud Storage.
     */
    EXTRACT,
    /**
     * A Load Job loads data from one of several formats into a table.
     */
    LOAD,
    /**
     * A Query Job runs a query against BigQuery data.
     */
    QUERY
  }

  /**
   * Returns the type of the job configuration.
   */
  Type type();
}
