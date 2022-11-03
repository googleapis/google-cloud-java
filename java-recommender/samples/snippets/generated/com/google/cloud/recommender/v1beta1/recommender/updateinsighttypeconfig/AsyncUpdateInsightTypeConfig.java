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

// [START recommender_v1beta1_generated_Recommender_UpdateInsightTypeConfig_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.recommender.v1beta1.InsightTypeConfig;
import com.google.cloud.recommender.v1beta1.RecommenderClient;
import com.google.cloud.recommender.v1beta1.UpdateInsightTypeConfigRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateInsightTypeConfig {

  public static void main(String[] args) throws Exception {
    asyncUpdateInsightTypeConfig();
  }

  public static void asyncUpdateInsightTypeConfig() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (RecommenderClient recommenderClient = RecommenderClient.create()) {
      UpdateInsightTypeConfigRequest request =
          UpdateInsightTypeConfigRequest.newBuilder()
              .setInsightTypeConfig(InsightTypeConfig.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .setValidateOnly(true)
              .build();
      ApiFuture<InsightTypeConfig> future =
          recommenderClient.updateInsightTypeConfigCallable().futureCall(request);
      // Do something.
      InsightTypeConfig response = future.get();
    }
  }
}
// [END recommender_v1beta1_generated_Recommender_UpdateInsightTypeConfig_async]
