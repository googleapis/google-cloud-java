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
 * <p>======================= AccessApprovalAdminClient =======================
 *
 * <p>Service Description: This API allows a customer to manage accesses to cloud resources by
 * Google personnel. It defines the following resource model:
 *
 * <p>- The API has a collection of
 * [ApprovalRequest][google.cloud.accessapproval.v1.ApprovalRequest] resources, named
 * `approvalRequests/{approval_request}` - The API has top-level settings per
 * Project/Folder/Organization, named `accessApprovalSettings`
 *
 * <p>The service also periodically emails a list of recipients, defined at the
 * Project/Folder/Organization level in the accessApprovalSettings, when there is a pending
 * ApprovalRequest for them to act on. The ApprovalRequests can also optionally be published to a
 * Pub/Sub topic owned by the customer (contact support if you would like to enable Pub/Sub
 * notifications).
 *
 * <p>ApprovalRequests can be approved or dismissed. Google personnel can only access the indicated
 * resource or resources if the request is approved (subject to some exclusions:
 * https://cloud.google.com/access-approval/docs/overview#exclusions).
 *
 * <p>Note: Using Access Approval functionality will mean that Google may not be able to meet the
 * SLAs for your chosen products, as any support response times may be dramatically increased. As
 * such the SLAs do not apply to any service disruption to the extent impacted by Customer's use of
 * Access Approval. Do not enable Access Approval for projects where you may require high service
 * availability and rapid response by Google Cloud Support.
 *
 * <p>After a request is approved or dismissed, no further action may be taken on it. Requests with
 * the requested_expiration in the past or with no activity for 14 days are considered dismissed.
 * When an approval expires, the request is considered dismissed.
 *
 * <p>If a request is not approved or dismissed, we call it pending.
 *
 * <p>Sample for AccessApprovalAdminClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AccessApprovalAdminClient accessApprovalAdminClient = AccessApprovalAdminClient.create()) {
 *   ApprovalRequestName name =
 *       ApprovalRequestName.ofProjectApprovalRequestName("[PROJECT]", "[APPROVAL_REQUEST]");
 *   ApprovalRequest response = accessApprovalAdminClient.getApprovalRequest(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.accessapproval.v1;

import javax.annotation.Generated;
