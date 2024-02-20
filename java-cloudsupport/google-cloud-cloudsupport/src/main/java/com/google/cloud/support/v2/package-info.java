/*
 * Copyright 2024 Google LLC
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
 * A client to Google Cloud Support API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= CaseAttachmentServiceClient =======================
 *
 * <p>Service Description: A service to manage file attachment for Google Cloud support cases.
 *
 * <p>Sample for CaseAttachmentServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CaseAttachmentServiceClient caseAttachmentServiceClient =
 *     CaseAttachmentServiceClient.create()) {
 *   CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
 *   for (Attachment element : caseAttachmentServiceClient.listAttachments(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>======================= CaseServiceClient =======================
 *
 * <p>Service Description: A service to manage Google Cloud support cases.
 *
 * <p>Sample for CaseServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CaseServiceClient caseServiceClient = CaseServiceClient.create()) {
 *   CaseName name = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
 *   Case response = caseServiceClient.getCase(name);
 * }
 * }</pre>
 *
 * <p>======================= CommentServiceClient =======================
 *
 * <p>Service Description: A service to manage comments on cases.
 *
 * <p>Sample for CommentServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CommentServiceClient commentServiceClient = CommentServiceClient.create()) {
 *   CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
 *   Comment comment = Comment.newBuilder().build();
 *   Comment response = commentServiceClient.createComment(parent, comment);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.support.v2;

import javax.annotation.Generated;
