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
 * A client to API hub API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ApiHubClient =======================
 *
 * <p>Service Description: This service provides all methods related to the API hub.
 *
 * <p>Sample for ApiHubClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ApiHubClient apiHubClient = ApiHubClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Api api = Api.newBuilder().build();
 *   String apiId = "apiId93021397";
 *   Api response = apiHubClient.createApi(parent, api, apiId);
 * }
 * }</pre>
 *
 * <p>======================= ApiHubDependenciesClient =======================
 *
 * <p>Service Description: This service provides methods for various operations related to a
 * [Dependency][google.cloud.apihub.v1.Dependency] in the API hub.
 *
 * <p>Sample for ApiHubDependenciesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Dependency dependency = Dependency.newBuilder().build();
 *   String dependencyId = "dependencyId503788998";
 *   Dependency response =
 *       apiHubDependenciesClient.createDependency(parent, dependency, dependencyId);
 * }
 * }</pre>
 *
 * <p>======================= ApiHubCollectClient =======================
 *
 * <p>Service Description: This service exposes methods used for collecting various types of data
 * from different first party and third party sources and push it to Hub's collect layer.
 *
 * <p>Sample for ApiHubCollectClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ApiHubCollectClient apiHubCollectClient = ApiHubCollectClient.create()) {
 *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
 *   Location response = apiHubCollectClient.getLocation(request);
 * }
 * }</pre>
 *
 * <p>======================= ApiHubCurateClient =======================
 *
 * <p>Service Description: This service is used for managing curations for processing API data
 * consumed from collect layer.
 *
 * <p>Sample for ApiHubCurateClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Curation curation = Curation.newBuilder().build();
 *   String curationId = "curationId1428017328";
 *   Curation response = apiHubCurateClient.createCuration(parent, curation, curationId);
 * }
 * }</pre>
 *
 * <p>======================= ApiHubDiscoveryClient =======================
 *
 * <p>Service Description: This service exposes methods used to manage DiscoveredApiObservations and
 * DiscoveredApiOperations.
 *
 * <p>Sample for ApiHubDiscoveryClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
 *   DiscoveredApiObservationName name =
 *       DiscoveredApiObservationName.of(
 *           "[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]");
 *   DiscoveredApiObservation response = apiHubDiscoveryClient.getDiscoveredApiObservation(name);
 * }
 * }</pre>
 *
 * <p>======================= HostProjectRegistrationServiceClient =======================
 *
 * <p>Service Description: This service is used for managing the host project registrations.
 *
 * <p>Sample for HostProjectRegistrationServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (HostProjectRegistrationServiceClient hostProjectRegistrationServiceClient =
 *     HostProjectRegistrationServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   HostProjectRegistration hostProjectRegistration =
 *       HostProjectRegistration.newBuilder().build();
 *   String hostProjectRegistrationId = "hostProjectRegistrationId1352651365";
 *   HostProjectRegistration response =
 *       hostProjectRegistrationServiceClient.createHostProjectRegistration(
 *           parent, hostProjectRegistration, hostProjectRegistrationId);
 * }
 * }</pre>
 *
 * <p>======================= LintingServiceClient =======================
 *
 * <p>Service Description: This service provides all methods related to the 1p Linter.
 *
 * <p>Sample for LintingServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (LintingServiceClient lintingServiceClient = LintingServiceClient.create()) {
 *   StyleGuideName name = StyleGuideName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
 *   StyleGuide response = lintingServiceClient.getStyleGuide(name);
 * }
 * }</pre>
 *
 * <p>======================= ApiHubPluginClient =======================
 *
 * <p>Service Description: This service is used for managing plugins inside the API Hub.
 *
 * <p>Sample for ApiHubPluginClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ApiHubPluginClient apiHubPluginClient = ApiHubPluginClient.create()) {
 *   PluginName name = PluginName.of("[PROJECT]", "[LOCATION]", "[PLUGIN]");
 *   Plugin response = apiHubPluginClient.getPlugin(name);
 * }
 * }</pre>
 *
 * <p>======================= ProvisioningClient =======================
 *
 * <p>Service Description: This service is used for managing the data plane provisioning of the API
 * hub.
 *
 * <p>Sample for ProvisioningClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
 *   ApiHubInstanceName name =
 *       ApiHubInstanceName.of("[PROJECT]", "[LOCATION]", "[API_HUB_INSTANCE]");
 *   ApiHubInstance response = provisioningClient.getApiHubInstance(name);
 * }
 * }</pre>
 *
 * <p>======================= RuntimeProjectAttachmentServiceClient =======================
 *
 * <p>Service Description: This service is used for managing the runtime project attachments.
 *
 * <p>Sample for RuntimeProjectAttachmentServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
 *     RuntimeProjectAttachmentServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   RuntimeProjectAttachment runtimeProjectAttachment =
 *       RuntimeProjectAttachment.newBuilder().build();
 *   String runtimeProjectAttachmentId = "runtimeProjectAttachmentId-753213345";
 *   RuntimeProjectAttachment response =
 *       runtimeProjectAttachmentServiceClient.createRuntimeProjectAttachment(
 *           parent, runtimeProjectAttachment, runtimeProjectAttachmentId);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.apihub.v1;

import javax.annotation.Generated;
