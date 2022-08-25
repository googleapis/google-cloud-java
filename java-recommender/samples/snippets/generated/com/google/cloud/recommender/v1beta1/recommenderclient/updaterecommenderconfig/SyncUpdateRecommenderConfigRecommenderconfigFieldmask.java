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

package com.google.cloud.recommender.v1beta1.samples;

// [START
// recommender_v1beta1_generated_recommenderclient_updaterecommenderconfig_recommenderconfigfieldmask_sync]
import com.google.cloud.recommender.v1beta1.RecommenderClient;
import com.google.cloud.recommender.v1beta1.RecommenderConfig;
import com.google.protobuf.FieldMask;

public class SyncUpdateRecommenderConfigRecommenderconfigFieldmask {

  public static void main(String[] args) throws Exception {
    syncUpdateRecommenderConfigRecommenderconfigFieldmask();
  }

  public static void syncUpdateRecommenderConfigRecommenderconfigFieldmask() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (RecommenderClient recommenderClient = RecommenderClient.create()) {
      RecommenderConfig recommenderConfig = RecommenderConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      RecommenderConfig response =
          recommenderClient.updateRecommenderConfig(recommenderConfig, updateMask);
    }
  }
}
// [END
// recommender_v1beta1_generated_recommenderclient_updaterecommenderconfig_recommenderconfigfieldmask_sync]
