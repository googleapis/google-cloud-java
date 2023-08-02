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

package com.google.cloud.netapp.v1.samples;

// [START netapp_v1_generated_NetApp_DeleteActiveDirectory_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.netapp.v1.ActiveDirectoryName;
import com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest;
import com.google.cloud.netapp.v1.NetAppClient;
import com.google.longrunning.Operation;

public class AsyncDeleteActiveDirectory {

  public static void main(String[] args) throws Exception {
    asyncDeleteActiveDirectory();
  }

  public static void asyncDeleteActiveDirectory() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NetAppClient netAppClient = NetAppClient.create()) {
      DeleteActiveDirectoryRequest request =
          DeleteActiveDirectoryRequest.newBuilder()
              .setName(
                  ActiveDirectoryName.of("[PROJECT]", "[LOCATION]", "[ACTIVE_DIRECTORY]")
                      .toString())
              .build();
      ApiFuture<Operation> future =
          netAppClient.deleteActiveDirectoryCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END netapp_v1_generated_NetApp_DeleteActiveDirectory_async]
