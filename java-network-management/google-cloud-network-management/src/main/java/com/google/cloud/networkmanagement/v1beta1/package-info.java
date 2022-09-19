/*
 * Copyright 2022 Google LLC
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
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ReachabilityServiceClient =======================
 *
 * <p>Service Description: The Reachability service in the Google Cloud Network Management API
 * provides services that analyze the reachability within a single Google Virtual Private Cloud
 * (VPC) network, between peered VPC networks, between VPC and on-premises networks, or between VPC
 * networks and internet hosts. A reachability analysis is based on Google Cloud network
 * configurations.
 *
 * <p>You can use the analysis results to verify these configurations and to troubleshoot
 * connectivity issues.
 *
 * <p>Sample for ReachabilityServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ReachabilityServiceClient reachabilityServiceClient = ReachabilityServiceClient.create()) {
 *   GetConnectivityTestRequest request =
 *       GetConnectivityTestRequest.newBuilder().setName("name3373707").build();
 *   ConnectivityTest response = reachabilityServiceClient.getConnectivityTest(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.networkmanagement.v1beta1;

import javax.annotation.Generated;
