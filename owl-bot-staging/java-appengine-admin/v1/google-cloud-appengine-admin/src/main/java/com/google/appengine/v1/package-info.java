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
 * <p>======================= ApplicationsClient =======================
 *
 * <p>Service Description: Manages App Engine applications.
 *
 * <p>Sample for ApplicationsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ApplicationsClient applicationsClient = ApplicationsClient.create()) {
 *   String name = "name3373707";
 *   Application response = applicationsClient.getApplication(name);
 * }
 * }</pre>
 *
 * <p>======================= ServicesClient =======================
 *
 * <p>Service Description: Manages services of an application.
 *
 * <p>Sample for ServicesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ServicesClient servicesClient = ServicesClient.create()) {
 *   GetServiceRequest request = GetServiceRequest.newBuilder().setName("name3373707").build();
 *   Service response = servicesClient.getService(request);
 * }
 * }</pre>
 *
 * <p>======================= VersionsClient =======================
 *
 * <p>Service Description: Manages versions of a service.
 *
 * <p>Sample for VersionsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (VersionsClient versionsClient = VersionsClient.create()) {
 *   GetVersionRequest request =
 *       GetVersionRequest.newBuilder()
 *           .setName("name3373707")
 *           .setView(VersionView.forNumber(0))
 *           .build();
 *   Version response = versionsClient.getVersion(request);
 * }
 * }</pre>
 *
 * <p>======================= InstancesClient =======================
 *
 * <p>Service Description: Manages instances of a version.
 *
 * <p>Sample for InstancesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (InstancesClient instancesClient = InstancesClient.create()) {
 *   GetInstanceRequest request = GetInstanceRequest.newBuilder().setName("name3373707").build();
 *   Instance response = instancesClient.getInstance(request);
 * }
 * }</pre>
 *
 * <p>======================= FirewallClient =======================
 *
 * <p>Service Description: Firewall resources are used to define a collection of access control
 * rules for an Application. Each rule is defined with a position which specifies the rule's order
 * in the sequence of rules, an IP range to be matched against requests, and an action to take upon
 * matching requests.
 *
 * <p>Every request is evaluated against the Firewall rules in priority order. Processesing stops at
 * the first rule which matches the request's IP address. A final rule always specifies an action
 * that applies to all remaining IP addresses. The default final rule for a newly-created
 * application will be set to "allow" if not otherwise specified by the user.
 *
 * <p>Sample for FirewallClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (FirewallClient firewallClient = FirewallClient.create()) {
 *   BatchUpdateIngressRulesRequest request =
 *       BatchUpdateIngressRulesRequest.newBuilder()
 *           .setName("name3373707")
 *           .addAllIngressRules(new ArrayList<FirewallRule>())
 *           .build();
 *   BatchUpdateIngressRulesResponse response = firewallClient.batchUpdateIngressRules(request);
 * }
 * }</pre>
 *
 * <p>======================= AuthorizedDomainsClient =======================
 *
 * <p>Service Description: Manages domains a user is authorized to administer. To authorize use of a
 * domain, verify ownership via [Webmaster
 * Central](https://www.google.com/webmasters/verification/home).
 *
 * <p>Sample for AuthorizedDomainsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AuthorizedDomainsClient authorizedDomainsClient = AuthorizedDomainsClient.create()) {
 *   ListAuthorizedDomainsRequest request =
 *       ListAuthorizedDomainsRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setPageSize(883849137)
 *           .setPageToken("pageToken873572522")
 *           .build();
 *   for (AuthorizedDomain element :
 *       authorizedDomainsClient.listAuthorizedDomains(request).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>======================= AuthorizedCertificatesClient =======================
 *
 * <p>Service Description: Manages SSL certificates a user is authorized to administer. A user can
 * administer any SSL certificates applicable to their authorized domains.
 *
 * <p>Sample for AuthorizedCertificatesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AuthorizedCertificatesClient authorizedCertificatesClient =
 *     AuthorizedCertificatesClient.create()) {
 *   GetAuthorizedCertificateRequest request =
 *       GetAuthorizedCertificateRequest.newBuilder()
 *           .setName("name3373707")
 *           .setView(AuthorizedCertificateView.forNumber(0))
 *           .build();
 *   AuthorizedCertificate response =
 *       authorizedCertificatesClient.getAuthorizedCertificate(request);
 * }
 * }</pre>
 *
 * <p>======================= DomainMappingsClient =======================
 *
 * <p>Service Description: Manages domains serving an application.
 *
 * <p>Sample for DomainMappingsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DomainMappingsClient domainMappingsClient = DomainMappingsClient.create()) {
 *   GetDomainMappingRequest request =
 *       GetDomainMappingRequest.newBuilder().setName("name3373707").build();
 *   DomainMapping response = domainMappingsClient.getDomainMapping(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.appengine.v1;

import javax.annotation.Generated;
