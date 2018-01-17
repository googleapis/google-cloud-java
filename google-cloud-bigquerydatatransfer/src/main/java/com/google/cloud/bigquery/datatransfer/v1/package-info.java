/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client to BigQuery Data Transfer API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>========================= DataTransferServiceClient =========================
 *
 * <p>Service Description: The Google BigQuery Data Transfer Service API enables BigQuery users to
 * configure the transfer of their data from other Google Products into BigQuery. This service
 * contains methods that are end user exposed. It backs up the frontend.
 *
 * <p>Sample for DataTransferServiceClient:
 *
 * <pre>
 * <code>
 * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
 *   DataSourceNameOneof name = DataSourceNameOneof.from(LocationDataSourceName.of("[PROJECT]", "[LOCATION]", "[DATA_SOURCE]"));
 *   DataSource response = dataTransferServiceClient.getDataSource(name);
 * }
 * </code>
 * </pre>
 */
package com.google.cloud.bigquery.datatransfer.v1;
