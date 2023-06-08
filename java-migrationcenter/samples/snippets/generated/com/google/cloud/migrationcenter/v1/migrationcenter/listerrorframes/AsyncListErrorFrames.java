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

package com.google.cloud.migrationcenter.v1.samples;

// [START migrationcenter_v1_generated_MigrationCenter_ListErrorFrames_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.migrationcenter.v1.ErrorFrame;
import com.google.cloud.migrationcenter.v1.ErrorFrameView;
import com.google.cloud.migrationcenter.v1.ListErrorFramesRequest;
import com.google.cloud.migrationcenter.v1.MigrationCenterClient;
import com.google.cloud.migrationcenter.v1.SourceName;

public class AsyncListErrorFrames {

  public static void main(String[] args) throws Exception {
    asyncListErrorFrames();
  }

  public static void asyncListErrorFrames() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MigrationCenterClient migrationCenterClient = MigrationCenterClient.create()) {
      ListErrorFramesRequest request =
          ListErrorFramesRequest.newBuilder()
              .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setView(ErrorFrameView.forNumber(0))
              .build();
      ApiFuture<ErrorFrame> future =
          migrationCenterClient.listErrorFramesPagedCallable().futureCall(request);
      // Do something.
      for (ErrorFrame element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END migrationcenter_v1_generated_MigrationCenter_ListErrorFrames_async]
