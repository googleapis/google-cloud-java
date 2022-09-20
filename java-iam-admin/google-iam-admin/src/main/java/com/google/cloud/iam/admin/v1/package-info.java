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
 * A client to Identity and Access Management (IAM) API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
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
 *       principal has for the service account
 *   <li>&#42;&#42;IAM custom roles&#42;&#42;, which help you limit the number of permissions that
 *       you grant to principals
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
 * <p>When you read data from the IAM API, each read is eventually consistent. In other words, if
 * you write data with the IAM API, then immediately read that data, the read operation might return
 * an older version of the data. To deal with this behavior, your application can retry the request
 * with truncated exponential backoff.
 *
 * <p>In contrast, writing data to the IAM API is sequentially consistent. In other words, write
 * operations are always processed in the order in which they were received.
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
