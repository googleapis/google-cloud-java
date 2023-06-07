/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.support.v2.samples;

// [START cloudsupport_v2_generated_CommentService_ListComments_Paged_async]
import com.google.cloud.support.v2.CaseName;
import com.google.cloud.support.v2.Comment;
import com.google.cloud.support.v2.CommentServiceClient;
import com.google.cloud.support.v2.ListCommentsRequest;
import com.google.cloud.support.v2.ListCommentsResponse;
import com.google.common.base.Strings;

public class AsyncListCommentsPaged {

  public static void main(String[] args) throws Exception {
    asyncListCommentsPaged();
  }

  public static void asyncListCommentsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CommentServiceClient commentServiceClient = CommentServiceClient.create()) {
      ListCommentsRequest request =
          ListCommentsRequest.newBuilder()
              .setParent(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListCommentsResponse response = commentServiceClient.listCommentsCallable().call(request);
        for (Comment element : response.getCommentsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END cloudsupport_v2_generated_CommentService_ListComments_Paged_async]
