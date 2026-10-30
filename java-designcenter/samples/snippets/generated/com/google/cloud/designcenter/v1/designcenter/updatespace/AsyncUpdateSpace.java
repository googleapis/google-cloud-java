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

package com.google.cloud.designcenter.v1.samples;

// [START designcenter_v1_generated_DesignCenter_UpdateSpace_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.designcenter.v1.DesignCenterClient;
import com.google.cloud.designcenter.v1.Space;
import com.google.cloud.designcenter.v1.UpdateSpaceRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateSpace {

  public static void main(String[] args) throws Exception {
    asyncUpdateSpace();
  }

  public static void asyncUpdateSpace() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DesignCenterClient designCenterClient = DesignCenterClient.create()) {
      UpdateSpaceRequest request =
          UpdateSpaceRequest.newBuilder()
              .setUpdateMask(FieldMask.newBuilder().build())
              .setSpace(Space.newBuilder().build())
              .build();
      ApiFuture<Space> future = designCenterClient.updateSpaceCallable().futureCall(request);
      // Do something.
      Space response = future.get();
    }
  }
}
// [END designcenter_v1_generated_DesignCenter_UpdateSpace_async]
