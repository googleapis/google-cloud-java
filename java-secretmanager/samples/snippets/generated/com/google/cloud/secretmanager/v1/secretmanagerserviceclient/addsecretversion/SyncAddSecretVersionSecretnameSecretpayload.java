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

// [START
// secretmanager_v1_generated_secretmanagerserviceclient_addsecretversion_secretnamesecretpayload_sync]
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretName;
import com.google.cloud.secretmanager.v1.SecretPayload;
import com.google.cloud.secretmanager.v1.SecretVersion;

public class SyncAddSecretVersionSecretnameSecretpayload {

  public static void main(String[] args) throws Exception {
    syncAddSecretVersionSecretnameSecretpayload();
  }

  public static void syncAddSecretVersionSecretnameSecretpayload() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (SecretManagerServiceClient secretManagerServiceClient =
        SecretManagerServiceClient.create()) {
      SecretName parent = SecretName.of("[PROJECT]", "[SECRET]");
      SecretPayload payload = SecretPayload.newBuilder().build();
      SecretVersion response = secretManagerServiceClient.addSecretVersion(parent, payload);
    }
  }
}
// [END
// secretmanager_v1_generated_secretmanagerserviceclient_addsecretversion_secretnamesecretpayload_sync]
