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

package com.google.showcase.v1beta1.samples;

// [START localhost7469_v1beta1_generated_Testing_ListTests_Paged_async]
import com.google.common.base.Strings;
import com.google.showcase.v1beta1.ListTestsRequest;
import com.google.showcase.v1beta1.ListTestsResponse;
import com.google.showcase.v1beta1.SessionName;
import com.google.showcase.v1beta1.Test;
import com.google.showcase.v1beta1.TestingClient;

public class AsyncListTestsPaged {

  public static void main(String[] args) throws Exception {
    asyncListTestsPaged();
  }

  public static void asyncListTestsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TestingClient testingClient = TestingClient.create()) {
      ListTestsRequest request =
          ListTestsRequest.newBuilder()
              .setParent(SessionName.of("[SESSION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListTestsResponse response = testingClient.listTestsCallable().call(request);
        for (Test element : response.getTestsList()) {
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
// [END localhost7469_v1beta1_generated_Testing_ListTests_Paged_async]
