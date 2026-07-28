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

// [START localhost7469_v1beta1_generated_Echo_Wait_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.WaitMetadata;
import com.google.showcase.v1beta1.WaitRequest;
import com.google.showcase.v1beta1.WaitResponse;

public class AsyncWaitLRO {

  public static void main(String[] args) throws Exception {
    asyncWaitLRO();
  }

  public static void asyncWaitLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EchoClient echoClient = EchoClient.create()) {
      WaitRequest request = WaitRequest.newBuilder().build();
      OperationFuture<WaitResponse, WaitMetadata> future =
          echoClient.waitOperationCallable().futureCall(request);
      // Do something.
      WaitResponse response = future.get();
    }
  }
}
// [END localhost7469_v1beta1_generated_Echo_Wait_LRO_async]
