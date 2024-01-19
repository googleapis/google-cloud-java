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

package com.google.cloud.aiplatform.v1.samples;

// [START aiplatform_v1_generated_FeatureRegistryService_CreateFeature_EntitytypenameFeatureString_sync]
import com.google.cloud.aiplatform.v1.EntityTypeName;
import com.google.cloud.aiplatform.v1.Feature;
import com.google.cloud.aiplatform.v1.FeatureRegistryServiceClient;

public class SyncCreateFeatureEntitytypenameFeatureString {

  public static void main(String[] args) throws Exception {
    syncCreateFeatureEntitytypenameFeatureString();
  }

  public static void syncCreateFeatureEntitytypenameFeatureString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (FeatureRegistryServiceClient featureRegistryServiceClient =
        FeatureRegistryServiceClient.create()) {
      EntityTypeName parent =
          EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]");
      Feature feature = Feature.newBuilder().build();
      String featureId = "featureId-420503887";
      Feature response =
          featureRegistryServiceClient.createFeatureAsync(parent, feature, featureId).get();
    }
  }
}
// [END aiplatform_v1_generated_FeatureRegistryService_CreateFeature_EntitytypenameFeatureString_sync]
