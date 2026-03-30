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

package com.google.cloud.dataform.v1.samples;

// [START dataform_v1_generated_Dataform_DeleteFolderTree_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.dataform.v1.DataformClient;
import com.google.cloud.dataform.v1.DeleteFolderTreeMetadata;
import com.google.cloud.dataform.v1.DeleteFolderTreeRequest;
import com.google.cloud.dataform.v1.FolderName;
import com.google.protobuf.Empty;

public class AsyncDeleteFolderTreeLRO {

  public static void main(String[] args) throws Exception {
    asyncDeleteFolderTreeLRO();
  }

  public static void asyncDeleteFolderTreeLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataformClient dataformClient = DataformClient.create()) {
      DeleteFolderTreeRequest request =
          DeleteFolderTreeRequest.newBuilder()
              .setName(FolderName.of("[PROJECT]", "[LOCATION]", "[FOLDER]").toString())
              .setForce(true)
              .build();
      OperationFuture<Empty, DeleteFolderTreeMetadata> future =
          dataformClient.deleteFolderTreeOperationCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END dataform_v1_generated_Dataform_DeleteFolderTree_LRO_async]
