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

package com.google.cloud.secretmanager.v1.samples;

// [START secretmanager_v1_generated_secretmanagerserviceclient_addsecretversion_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.secretmanager.v1.AddSecretVersionRequest;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretName;
import com.google.cloud.secretmanager.v1.SecretPayload;
import com.google.cloud.secretmanager.v1.SecretVersion;

public class AsyncAddSecretVersion {

  public static void main(String[] args) throws Exception {
    asyncAddSecretVersion();
  }

  public static void asyncAddSecretVersion() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (SecretManagerServiceClient secretManagerServiceClient =
        SecretManagerServiceClient.create()) {
      AddSecretVersionRequest request =
          AddSecretVersionRequest.newBuilder()
              .setParent(SecretName.of("[PROJECT]", "[SECRET]").toString())
              .setPayload(SecretPayload.newBuilder().build())
              .build();
      ApiFuture<SecretVersion> future =
          secretManagerServiceClient.addSecretVersionCallable().futureCall(request);
      // Do something.
      SecretVersion response = future.get();
    }
  }
}
// [END secretmanager_v1_generated_secretmanagerserviceclient_addsecretversion_async]
