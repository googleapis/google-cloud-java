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

package com.google.cloud.shell.v1.samples;

// [START shell_v1_generated_cloudshellserviceclient_removepublickey_sync]
import com.google.cloud.shell.v1.CloudShellServiceClient;
import com.google.cloud.shell.v1.RemovePublicKeyRequest;
import com.google.cloud.shell.v1.RemovePublicKeyResponse;

public class SyncRemovePublicKey {

  public static void main(String[] args) throws Exception {
    syncRemovePublicKey();
  }

  public static void syncRemovePublicKey() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CloudShellServiceClient cloudShellServiceClient = CloudShellServiceClient.create()) {
      RemovePublicKeyRequest request =
          RemovePublicKeyRequest.newBuilder()
              .setEnvironment("environment-85904877")
              .setKey("key106079")
              .build();
      RemovePublicKeyResponse response =
          cloudShellServiceClient.removePublicKeyAsync(request).get();
    }
  }
}
// [END shell_v1_generated_cloudshellserviceclient_removepublickey_sync]
