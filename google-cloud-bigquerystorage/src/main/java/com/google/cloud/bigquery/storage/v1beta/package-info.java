/*
 * Copyright 2025 Google LLC
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
 * <p>======================= MetastorePartitionServiceClient =======================
 *
 * <p>Service Description: BigQuery Metastore Partition Service API. This service is used for
 * managing metastore partitions in BigQuery metastore. The service supports only batch operations
 * for write.
 *
 * <p>Sample for MetastorePartitionServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MetastorePartitionServiceClient metastorePartitionServiceClient =
 *     MetastorePartitionServiceClient.create()) {
 *   BatchCreateMetastorePartitionsRequest request =
 *       BatchCreateMetastorePartitionsRequest.newBuilder()
 *           .setParent(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
 *           .addAllRequests(new ArrayList<CreateMetastorePartitionRequest>())
 *           .setSkipExistingPartitions(true)
 *           .setTraceId("traceId-1067401920")
 *           .build();
 *   BatchCreateMetastorePartitionsResponse response =
 *       metastorePartitionServiceClient.batchCreateMetastorePartitions(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.bigquery.storage.v1beta;

import javax.annotation.Generated;
