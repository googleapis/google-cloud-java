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

// [START cloudsupport_v2beta_generated_CommentService_CreateComment_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.support.v2beta.CaseName;
import com.google.cloud.support.v2beta.Comment;
import com.google.cloud.support.v2beta.CommentServiceClient;
import com.google.cloud.support.v2beta.CreateCommentRequest;

public class AsyncCreateComment {

  public static void main(String[] args) throws Exception {
    asyncCreateComment();
  }

  public static void asyncCreateComment() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CommentServiceClient commentServiceClient = CommentServiceClient.create()) {
      CreateCommentRequest request =
          CreateCommentRequest.newBuilder()
              .setParent(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
              .setComment(Comment.newBuilder().build())
              .build();
      ApiFuture<Comment> future = commentServiceClient.createCommentCallable().futureCall(request);
      // Do something.
      Comment response = future.get();
    }
  }
}
// [END cloudsupport_v2beta_generated_CommentService_CreateComment_async]
