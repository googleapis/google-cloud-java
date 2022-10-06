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
 * <p>======================= ManagedIdentitiesServiceClient =======================
 *
 * <p>Service Description: API Overview
 *
 * <p>The `managedidentites.googleapis.com` service implements the Google Cloud Managed Identites
 * API for identity services (e.g. Microsoft Active Directory).
 *
 * <p>The Managed Identities service provides methods to manage (create/read/update/delete) domains,
 * reset managed identities admin password, add/remove domain controllers in GCP regions and
 * add/remove VPC peering.
 *
 * <p>Data Model
 *
 * <p>The Managed Identities service exposes the following resources:
 *
 * <ul>
 *   <li>Locations as global, named as follows: `projects/{project_id}/locations/global`.
 * </ul>
 *
 * <ul>
 *   <li>Domains, named as follows: `/projects/{project_id}/locations/global/domain/{domain_name}`.
 * </ul>
 *
 * <p>The `{domain_name}` refers to fully qualified domain name in the customer project e.g.
 * mydomain.myorganization.com, with the following restrictions:
 *
 * <p>&#42; Must contain only lowercase letters, numbers, periods and hyphens. &#42; Must start with
 * a letter. &#42; Must contain between 2-64 characters. &#42; Must end with a number or a letter.
 * &#42; Must not start with period. &#42; First segement length (mydomain form example above)
 * shouldn't exceed 15 chars. &#42; The last segment cannot be fully numeric. &#42; Must be unique
 * within the customer project.
 *
 * <p>Sample for ManagedIdentitiesServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ManagedIdentitiesServiceClient managedIdentitiesServiceClient =
 *     ManagedIdentitiesServiceClient.create()) {
 *   DomainName name = DomainName.of("[PROJECT]", "[LOCATION]", "[DOMAIN]");
 *   ResetAdminPasswordResponse response = managedIdentitiesServiceClient.resetAdminPassword(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.managedidentities.v1;

import javax.annotation.Generated;
