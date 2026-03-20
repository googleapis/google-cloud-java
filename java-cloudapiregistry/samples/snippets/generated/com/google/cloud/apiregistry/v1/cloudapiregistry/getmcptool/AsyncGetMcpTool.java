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

package com.google.cloud.apiregistry.v1.samples;

// [START cloudapiregistry_v1_generated_CloudApiRegistry_GetMcpTool_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.apiregistry.v1.CloudApiRegistryClient;
import com.google.cloud.apiregistry.v1.GetMcpToolRequest;
import com.google.cloud.apiregistry.v1.McpTool;
import com.google.cloud.apiregistry.v1.McpToolName;

public class AsyncGetMcpTool {

  public static void main(String[] args) throws Exception {
    asyncGetMcpTool();
  }

  public static void asyncGetMcpTool() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudApiRegistryClient cloudApiRegistryClient = CloudApiRegistryClient.create()) {
      GetMcpToolRequest request =
          GetMcpToolRequest.newBuilder()
              .setName(
                  McpToolName.ofProjectLocationMcpServerMcpToolName(
                          "[PROJECT]", "[LOCATION]", "[MCP_SERVER]", "[MCP_TOOL]")
                      .toString())
              .build();
      ApiFuture<McpTool> future = cloudApiRegistryClient.getMcpToolCallable().futureCall(request);
      // Do something.
      McpTool response = future.get();
    }
  }
}
// [END cloudapiregistry_v1_generated_CloudApiRegistry_GetMcpTool_async]
