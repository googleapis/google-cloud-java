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
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= IAMPolicyClient =======================
 *
 * <p>Service Description: API Overview
 *
 * <p>Manages Identity and Access Management (IAM) policies.
 *
 * <p>Any implementation of an API that offers access control features implements the
 * google.iam.v1.IAMPolicy interface.
 *
 * <p>## Data model
 *
 * <p>Access control is applied when a principal (user or service account), takes some action on a
 * resource exposed by a service. Resources, identified by URI-like names, are the unit of access
 * control specification. Service implementations can choose the granularity of access control and
 * the supported permissions for their resources. For example one database service may allow access
 * control to be specified only at the Table level, whereas another might allow access control to
 * also be specified at the Column level.
 *
 * <p>## Policy Structure
 *
 * <p>See google.iam.v1.Policy
 *
 * <p>This is intentionally not a CRUD style API because access control policies are created and
 * deleted implicitly with the resources to which they are attached.
 *
 * <p>Sample for IAMPolicyClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (IAMPolicyClient iAMPolicyClient = IAMPolicyClient.create()) {
 *   SetIamPolicyRequest request =
 *       SetIamPolicyRequest.newBuilder()
 *           .setResource("resource-341064690")
 *           .setPolicy(Policy.newBuilder().build())
 *           .setUpdateMask(FieldMask.newBuilder().build())
 *           .build();
 *   Policy response = iAMPolicyClient.setIamPolicy(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.iam.v1;

import javax.annotation.Generated;
