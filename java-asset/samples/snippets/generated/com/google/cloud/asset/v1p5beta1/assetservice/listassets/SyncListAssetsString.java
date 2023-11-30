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

package com.google.cloud.asset.v1p5beta1.samples;

// [START cloudasset_v1p5beta1_generated_AssetService_ListAssets_String_sync]
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.asset.v1p5beta1.Asset;
import com.google.cloud.asset.v1p5beta1.AssetServiceClient;
import java.util.HashMap;
import java.util.Map;

public class SyncListAssetsString {

  public static void main(String[] args) throws Exception {
    syncListAssetsString();
  }

  public static void syncListAssetsString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
      String parent =
          new ResourceName() {
            @Override
            public Map<String, String> getFieldValuesMap() {
              Map<String, String> fieldValuesMap = new HashMap<>();
              fieldValuesMap.put("parent", "parent-995424086");
              return fieldValuesMap;
            }

            @Override
            public String getFieldValue(String fieldName) {
              return getFieldValuesMap().get(fieldName);
            }

            @Override
            public String toString() {
              return "parent-995424086";
            }
          }.toString();
      for (Asset element : assetServiceClient.listAssets(parent).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END cloudasset_v1p5beta1_generated_AssetService_ListAssets_String_sync]
