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

package com.google.cloud.ces.v1.samples;

// [START ces_v1_generated_ToolService_RetrieveTools_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.ces.v1.RetrieveToolsRequest;
import com.google.cloud.ces.v1.RetrieveToolsResponse;
import com.google.cloud.ces.v1.ToolServiceClient;
import com.google.cloud.ces.v1.ToolsetName;
import java.util.ArrayList;

public class AsyncRetrieveTools {

  public static void main(String[] args) throws Exception {
    asyncRetrieveTools();
  }

  public static void asyncRetrieveTools() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ToolServiceClient toolServiceClient = ToolServiceClient.create()) {
      RetrieveToolsRequest request =
          RetrieveToolsRequest.newBuilder()
              .setToolset(
                  ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString())
              .addAllToolIds(new ArrayList<String>())
              .build();
      ApiFuture<RetrieveToolsResponse> future =
          toolServiceClient.retrieveToolsCallable().futureCall(request);
      // Do something.
      RetrieveToolsResponse response = future.get();
    }
  }
}
// [END ces_v1_generated_ToolService_RetrieveTools_async]
