/*
 * Copyright 2023 Google LLC
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
 * A client to Vertex AI API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= EndpointServiceClient =======================
 *
 * <p>Service Description: A service for managing Vertex AI's Endpoints.
 *
 * <p>Sample for EndpointServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (EndpointServiceClient endpointServiceClient = EndpointServiceClient.create()) {
 *   EndpointName name =
 *       EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
 *   Endpoint response = endpointServiceClient.getEndpoint(name);
 * }
 * }</pre>
 *
 * <p>======================= PredictionServiceClient =======================
 *
 * <p>Service Description: A service for online predictions and explanations.
 *
 * <p>Sample for PredictionServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
 *   EndpointName endpoint =
 *       EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
 *   List<Value> instances = new ArrayList<>();
 *   Value parameters = Value.newBuilder().setBoolValue(true).build();
 *   PredictResponse response = predictionServiceClient.predict(endpoint, instances, parameters);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.vertexai.v1;

import javax.annotation.Generated;
