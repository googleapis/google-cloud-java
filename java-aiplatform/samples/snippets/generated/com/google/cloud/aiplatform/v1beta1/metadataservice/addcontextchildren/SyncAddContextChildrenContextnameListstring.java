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

package com.google.cloud.aiplatform.v1beta1.samples;

// [START aiplatform_v1beta1_generated_MetadataService_AddContextChildren_ContextnameListstring_sync]
import com.google.cloud.aiplatform.v1beta1.AddContextChildrenResponse;
import com.google.cloud.aiplatform.v1beta1.ContextName;
import com.google.cloud.aiplatform.v1beta1.MetadataServiceClient;
import java.util.ArrayList;
import java.util.List;

public class SyncAddContextChildrenContextnameListstring {

  public static void main(String[] args) throws Exception {
    syncAddContextChildrenContextnameListstring();
  }

  public static void syncAddContextChildrenContextnameListstring() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MetadataServiceClient metadataServiceClient = MetadataServiceClient.create()) {
      ContextName context =
          ContextName.of("[PROJECT]", "[LOCATION]", "[METADATA_STORE]", "[CONTEXT]");
      List<String> childContexts = new ArrayList<>();
      AddContextChildrenResponse response =
          metadataServiceClient.addContextChildren(context, childContexts);
    }
  }
}
// [END aiplatform_v1beta1_generated_MetadataService_AddContextChildren_ContextnameListstring_sync]
