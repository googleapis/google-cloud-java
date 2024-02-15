/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client to BigQuery Storage API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= BaseBigQueryReadClient =======================
 *
 * <p>Service Description: BigQuery Read API.
 *
 * <p>The Read API can be used to read data from BigQuery.
 *
 * <p>Sample for BaseBigQueryReadClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BaseBigQueryReadClient baseBigQueryReadClient = BaseBigQueryReadClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   ReadSession readSession = ReadSession.newBuilder().build();
 *   int maxStreamCount = 940837515;
 *   ReadSession response =
 *       baseBigQueryReadClient.createReadSession(parent, readSession, maxStreamCount);
 * }
 * }</pre>
 *
 * <p>======================= BigQueryWriteClient =======================
 *
 * <p>Service Description: BigQuery Write API.
 *
 * <p>The Write API can be used to write data to BigQuery.
 *
 * <p>For supplementary information about the Write API, see:
 * https://cloud.google.com/bigquery/docs/write-api
 *
 * <p>Sample for BigQueryWriteClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BigQueryWriteClient bigQueryWriteClient = BigQueryWriteClient.create()) {
 *   TableName parent = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]");
 *   WriteStream writeStream = WriteStream.newBuilder().build();
 *   WriteStream response = bigQueryWriteClient.createWriteStream(parent, writeStream);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.bigquery.storage.v1;

import javax.annotation.Generated;
