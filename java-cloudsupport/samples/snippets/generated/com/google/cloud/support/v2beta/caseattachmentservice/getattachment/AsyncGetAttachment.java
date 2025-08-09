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

package com.google.cloud.support.v2beta.samples;

// [START cloudsupport_v2beta_generated_CaseAttachmentService_GetAttachment_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.support.v2beta.Attachment;
import com.google.cloud.support.v2beta.AttachmentName;
import com.google.cloud.support.v2beta.CaseAttachmentServiceClient;
import com.google.cloud.support.v2beta.GetAttachmentRequest;

public class AsyncGetAttachment {

  public static void main(String[] args) throws Exception {
    asyncGetAttachment();
  }

  public static void asyncGetAttachment() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CaseAttachmentServiceClient caseAttachmentServiceClient =
        CaseAttachmentServiceClient.create()) {
      GetAttachmentRequest request =
          GetAttachmentRequest.newBuilder()
              .setName(
                  AttachmentName.ofOrganizationCaseAttachmentIdName(
                          "[ORGANIZATION]", "[CASE]", "[ATTACHMENT_ID]")
                      .toString())
              .build();
      ApiFuture<Attachment> future =
          caseAttachmentServiceClient.getAttachmentCallable().futureCall(request);
      // Do something.
      Attachment response = future.get();
    }
  }
}
// [END cloudsupport_v2beta_generated_CaseAttachmentService_GetAttachment_async]
