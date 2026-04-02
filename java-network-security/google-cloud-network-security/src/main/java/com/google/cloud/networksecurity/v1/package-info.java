/*
 * Copyright 2026 Google LLC
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
 * A client to Network Security API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= AddressGroupServiceClient =======================
 *
 * <p>Service Description: AddressGroup is a resource that manages a collection of IP or Domain
 * Names, it can be used in Firewall Policy to represent allow or deny traffic from all the IP or
 * Domain Names from the Address Group.
 *
 * <p>Sample for AddressGroupServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AddressGroupServiceClient addressGroupServiceClient = AddressGroupServiceClient.create()) {
 *   AddressGroupName name =
 *       AddressGroupName.ofProjectLocationAddressGroupName(
 *           "[PROJECT]", "[LOCATION]", "[ADDRESS_GROUP]");
 *   AddressGroup response = addressGroupServiceClient.getAddressGroup(name);
 * }
 * }</pre>
 *
 * <p>======================= OrganizationAddressGroupServiceClient =======================
 *
 * <p>Service Description: Organization AddressGroup is created under organization. Requests against
 * Organization AddressGroup will use project from request credential for
 * activation/quota/visibility check.
 *
 * <p>Sample for OrganizationAddressGroupServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (OrganizationAddressGroupServiceClient organizationAddressGroupServiceClient =
 *     OrganizationAddressGroupServiceClient.create()) {
 *   AddressGroupName name =
 *       AddressGroupName.ofOrganizationLocationAddressGroupName(
 *           "[ORGANIZATION]", "[LOCATION]", "[ADDRESS_GROUP]");
 *   AddressGroup response = organizationAddressGroupServiceClient.getAddressGroup(name);
 * }
 * }</pre>
 *
 * <p>======================= DnsThreatDetectorServiceClient =======================
 *
 * <p>Service Description: The Network Security API for DNS Threat Detectors.
 *
 * <p>Sample for DnsThreatDetectorServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DnsThreatDetectorServiceClient dnsThreatDetectorServiceClient =
 *     DnsThreatDetectorServiceClient.create()) {
 *   DnsThreatDetectorName name =
 *       DnsThreatDetectorName.of("[PROJECT]", "[LOCATION]", "[DNS_THREAT_DETECTOR]");
 *   DnsThreatDetector response = dnsThreatDetectorServiceClient.getDnsThreatDetector(name);
 * }
 * }</pre>
 *
 * <p>======================= FirewallActivationClient =======================
 *
 * <p>Service Description: Service for managing Firewall Endpoints and Associations.
 *
 * <p>Sample for FirewallActivationClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (FirewallActivationClient firewallActivationClient = FirewallActivationClient.create()) {
 *   FirewallEndpointName name =
 *       FirewallEndpointName.ofOrganizationLocationFirewallEndpointName(
 *           "[ORGANIZATION]", "[LOCATION]", "[FIREWALL_ENDPOINT]");
 *   FirewallEndpoint response = firewallActivationClient.getFirewallEndpoint(name);
 * }
 * }</pre>
 *
 * <p>======================= InterceptClient =======================
 *
 * <p>Service Description: Service for Third-Party Packet Intercept (TPPI). TPPI is the "in-band"
 * flavor of the Network Security Integrations product.
 *
 * <p>Sample for InterceptClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (InterceptClient interceptClient = InterceptClient.create()) {
 *   InterceptEndpointGroupName name =
 *       InterceptEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[INTERCEPT_ENDPOINT_GROUP]");
 *   InterceptEndpointGroup response = interceptClient.getInterceptEndpointGroup(name);
 * }
 * }</pre>
 *
 * <p>======================= MirroringClient =======================
 *
 * <p>Service Description: PM2 is the "out-of-band" flavor of the Network Security Integrations
 * product.
 *
 * <p>Sample for MirroringClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MirroringClient mirroringClient = MirroringClient.create()) {
 *   MirroringEndpointGroupName name =
 *       MirroringEndpointGroupName.of("[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]");
 *   MirroringEndpointGroup response = mirroringClient.getMirroringEndpointGroup(name);
 * }
 * }</pre>
 *
 * <p>======================= NetworkSecurityClient =======================
 *
 * <p>Service Description: Network Security API provides resources to configure authentication and
 * authorization policies. Refer to per API resource documentation for more information.
 *
 * <p>Sample for NetworkSecurityClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (NetworkSecurityClient networkSecurityClient = NetworkSecurityClient.create()) {
 *   AuthorizationPolicyName name =
 *       AuthorizationPolicyName.of("[PROJECT]", "[LOCATION]", "[AUTHORIZATION_POLICY]");
 *   AuthorizationPolicy response = networkSecurityClient.getAuthorizationPolicy(name);
 * }
 * }</pre>
 *
 * <p>======================= OrganizationSecurityProfileGroupServiceClient =======================
 *
 * <p>Service Description: Organization SecurityProfileGroup is created under organization.
 *
 * <p>Sample for OrganizationSecurityProfileGroupServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (OrganizationSecurityProfileGroupServiceClient
 *     organizationSecurityProfileGroupServiceClient =
 *         OrganizationSecurityProfileGroupServiceClient.create()) {
 *   SecurityProfileGroupName name =
 *       SecurityProfileGroupName.ofOrganizationLocationSecurityProfileGroupName(
 *           "[ORGANIZATION]", "[LOCATION]", "[SECURITY_PROFILE_GROUP]");
 *   SecurityProfileGroup response =
 *       organizationSecurityProfileGroupServiceClient.getSecurityProfileGroup(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.networksecurity.v1;

import javax.annotation.Generated;
