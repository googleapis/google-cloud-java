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
 * A client to Network Connectivity API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= CrossNetworkAutomationServiceClient =======================
 *
 * <p>Service Description: The service for CrossNetworkAutomation resources.
 *
 * <p>Sample for CrossNetworkAutomationServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CrossNetworkAutomationServiceClient crossNetworkAutomationServiceClient =
 *     CrossNetworkAutomationServiceClient.create()) {
 *   ServiceConnectionMapName name =
 *       ServiceConnectionMapName.of("[PROJECT]", "[LOCATION]", "[SERVICE_CONNECTION_MAP]");
 *   ServiceConnectionMap response =
 *       crossNetworkAutomationServiceClient.getServiceConnectionMap(name);
 * }
 * }</pre>
 *
 * <p>======================= DataTransferServiceClient =======================
 *
 * <p>Service Description: DataTransferService is the service for the Data Transfer API.
 *
 * <p>Sample for DataTransferServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataTransferServiceClient dataTransferServiceClient = DataTransferServiceClient.create()) {
 *   MulticloudDataTransferConfigName name =
 *       MulticloudDataTransferConfigName.of(
 *           "[PROJECT]", "[LOCATION]", "[MULTICLOUD_DATA_TRANSFER_CONFIG]");
 *   MulticloudDataTransferConfig response =
 *       dataTransferServiceClient.getMulticloudDataTransferConfig(name);
 * }
 * }</pre>
 *
 * <p>======================= HubServiceClient =======================
 *
 * <p>Service Description: Network Connectivity Center is a hub-and-spoke abstraction for network
 * connectivity management in Google Cloud. It reduces operational complexity through a simple,
 * centralized connectivity management model.
 *
 * <p>Sample for HubServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
 *   HubName name = HubName.of("[PROJECT]", "[HUB]");
 *   Hub response = hubServiceClient.getHub(name);
 * }
 * }</pre>
 *
 * <p>======================= InternalRangeServiceClient =======================
 *
 * <p>Service Description: The CLH-based service for internal range resources used to perform IPAM
 * operations within a VPC network.
 *
 * <p>Sample for InternalRangeServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (InternalRangeServiceClient internalRangeServiceClient =
 *     InternalRangeServiceClient.create()) {
 *   InternalRangeName name = InternalRangeName.of("[PROJECT]", "[LOCATION]", "[INTERNAL_RANGE]");
 *   InternalRange response = internalRangeServiceClient.getInternalRange(name);
 * }
 * }</pre>
 *
 * <p>======================= PolicyBasedRoutingServiceClient =======================
 *
 * <p>Service Description: Policy-Based Routing allows GCP customers to specify flexibile routing
 * policies for Layer 4 traffic traversing through the connected service.
 *
 * <p>Sample for PolicyBasedRoutingServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient =
 *     PolicyBasedRoutingServiceClient.create()) {
 *   PolicyBasedRouteName name = PolicyBasedRouteName.of("[PROJECT]", "[POLICY_BASED_ROUTE]");
 *   PolicyBasedRoute response = policyBasedRoutingServiceClient.getPolicyBasedRoute(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.networkconnectivity.v1;

import javax.annotation.Generated;
