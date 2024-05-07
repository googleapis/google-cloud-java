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
 * A client to Vision AI API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= HealthCheckServiceClient =======================
 *
 * <p>Service Description: HealthCheckService provides an interface for Vertex AI Vision Cluster
 * Health Check.
 *
 * <p>Sample for HealthCheckServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (HealthCheckServiceClient healthCheckServiceClient = HealthCheckServiceClient.create()) {
 *   HealthCheckRequest request =
 *       HealthCheckRequest.newBuilder()
 *           .setCluster(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
 *           .build();
 *   HealthCheckResponse response = healthCheckServiceClient.healthCheck(request);
 * }
 * }</pre>
 *
 * <p>======================= LiveVideoAnalyticsClient =======================
 *
 * <p>Service Description: Service describing handlers for resources. The service enables clients to
 * run Live Video Analytics (LVA) on the streaming inputs.
 *
 * <p>Sample for LiveVideoAnalyticsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   List<OperatorQuery> queries = new ArrayList<>();
 *   ResolveOperatorInfoResponse response =
 *       liveVideoAnalyticsClient.resolveOperatorInfo(parent, queries);
 * }
 * }</pre>
 *
 * <p>======================= AppPlatformClient =======================
 *
 * <p>Service Description: Service describing handlers for resources
 *
 * <p>Sample for AppPlatformClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AppPlatformClient appPlatformClient = AppPlatformClient.create()) {
 *   ApplicationName name = ApplicationName.of("[PROJECT]", "[LOCATION]", "[APPLICATION]");
 *   Application response = appPlatformClient.getApplication(name);
 * }
 * }</pre>
 *
 * <p>======================= PredictionServiceClient =======================
 *
 * <p>Service Description: A service for online prediction.
 *
 * <p>Sample for PredictionServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {}
 * }</pre>
 *
 * <p>======================= StreamingServiceClient =======================
 *
 * <p>Service Description: Streaming service for receiving and sending packets.
 *
 * <p>Sample for StreamingServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (StreamingServiceClient streamingServiceClient = StreamingServiceClient.create()) {
 *   AcquireLeaseRequest request =
 *       AcquireLeaseRequest.newBuilder()
 *           .setSeries("series-905838985")
 *           .setOwner("owner106164915")
 *           .setTerm(Duration.newBuilder().build())
 *           .setLeaseType(LeaseType.forNumber(0))
 *           .build();
 *   Lease response = streamingServiceClient.acquireLease(request);
 * }
 * }</pre>
 *
 * <p>======================= StreamsServiceClient =======================
 *
 * <p>Service Description: Service describing handlers for resources. Vision API and Vision AI API
 * are two independent APIs developed by the same team. Vision API is for people to annotate their
 * image while Vision AI is an e2e solution for customer to build their own computer vision
 * application.
 *
 * <p>Sample for StreamsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
 *   ClusterName name = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]");
 *   Cluster response = streamsServiceClient.getCluster(name);
 * }
 * }</pre>
 *
 * <p>======================= WarehouseClient =======================
 *
 * <p>Service Description: Service that manages media content + metadata for streaming.
 *
 * <p>Sample for WarehouseClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (WarehouseClient warehouseClient = WarehouseClient.create()) {
 *   CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
 *   Asset asset = Asset.newBuilder().build();
 *   String assetId = "assetId-704776149";
 *   Asset response = warehouseClient.createAsset(parent, asset, assetId);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.visionai.v1;

import javax.annotation.Generated;
