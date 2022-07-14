/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.resourcemanager.v3.samples;

// [START resourcemanager_v3_generated_tagbindingsclient_createtagbinding_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.resourcemanager.v3.CreateTagBindingRequest;
import com.google.cloud.resourcemanager.v3.TagBinding;
import com.google.cloud.resourcemanager.v3.TagBindingsClient;
import com.google.longrunning.Operation;

public class AsyncCreateTagBinding {

  public static void main(String[] args) throws Exception {
    asyncCreateTagBinding();
  }

  public static void asyncCreateTagBinding() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (TagBindingsClient tagBindingsClient = TagBindingsClient.create()) {
      CreateTagBindingRequest request =
          CreateTagBindingRequest.newBuilder()
              .setTagBinding(TagBinding.newBuilder().build())
              .setValidateOnly(true)
              .build();
      ApiFuture<Operation> future =
          tagBindingsClient.createTagBindingCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END resourcemanager_v3_generated_tagbindingsclient_createtagbinding_async]
