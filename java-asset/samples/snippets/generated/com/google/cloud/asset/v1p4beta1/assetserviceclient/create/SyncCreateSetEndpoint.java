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

package com.google.cloud.asset.v1p4beta1.samples;

// [START asset_v1p4beta1_generated_assetserviceclient_create_setendpoint_sync]
import com.google.cloud.asset.v1p4beta1.AssetServiceClient;
import com.google.cloud.asset.v1p4beta1.AssetServiceSettings;
import com.google.cloud.asset.v1p4beta1.myEndpoint;

public class SyncCreateSetEndpoint {

  public static void main(String[] args) throws Exception {
    syncCreateSetEndpoint();
  }

  public static void syncCreateSetEndpoint() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    AssetServiceSettings assetServiceSettings =
        AssetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
    AssetServiceClient assetServiceClient = AssetServiceClient.create(assetServiceSettings);
  }
}
// [END asset_v1p4beta1_generated_assetserviceclient_create_setendpoint_sync]
