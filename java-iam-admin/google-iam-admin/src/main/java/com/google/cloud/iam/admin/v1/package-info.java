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
 * <p>======================= IAMClient =======================
 *
 * <p>Service Description: Creates and manages Identity and Access Management (IAM) resources.
 *
 * <p>You can use this service to work with all of the following resources:
 *
 * <ul>
 *   <li>&#42;&#42;Service accounts&#42;&#42;, which identify an application or a virtual machine
 *       (VM) instance rather than a person
 *   <li>&#42;&#42;Service account keys&#42;&#42;, which service accounts use to authenticate with
 *       Google APIs
 *   <li>&#42;&#42;IAM policies for service accounts&#42;&#42;, which specify the roles that a
 *       member has for the service account
 *   <li>&#42;&#42;IAM custom roles&#42;&#42;, which help you limit the number of permissions that
 *       you grant to members
 * </ul>
 *
 * <p>In addition, you can use this service to complete the following tasks, among others:
 *
 * <ul>
 *   <li>Test whether a service account can use specific permissions
 *   <li>Check which roles you can grant for a specific resource
 *   <li>Lint, or validate, condition expressions in an IAM policy
 * </ul>
 *
 * <p>Sample for IAMClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (IAMClient iAMClient = IAMClient.create()) {
 *   ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
 *   ServiceAccount response = iAMClient.getServiceAccount(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.iam.admin.v1;

import javax.annotation.Generated;
