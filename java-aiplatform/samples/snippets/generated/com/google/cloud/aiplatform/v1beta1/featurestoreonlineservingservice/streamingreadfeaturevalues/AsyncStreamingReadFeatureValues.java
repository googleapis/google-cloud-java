/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.aiplatform.v1beta1.samples;

// [START aiplatform_v1beta1_generated_FeaturestoreOnlineServingService_StreamingReadFeatureValues_async]
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.aiplatform.v1beta1.EntityTypeName;
import com.google.cloud.aiplatform.v1beta1.FeatureSelector;
import com.google.cloud.aiplatform.v1beta1.FeaturestoreOnlineServingServiceClient;
import com.google.cloud.aiplatform.v1beta1.ReadFeatureValuesResponse;
import com.google.cloud.aiplatform.v1beta1.StreamingReadFeatureValuesRequest;
import java.util.ArrayList;

public class AsyncStreamingReadFeatureValues {

  public static void main(String[] args) throws Exception {
    asyncStreamingReadFeatureValues();
  }

  public static void asyncStreamingReadFeatureValues() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (FeaturestoreOnlineServingServiceClient featurestoreOnlineServingServiceClient =
        FeaturestoreOnlineServingServiceClient.create()) {
      StreamingReadFeatureValuesRequest request =
          StreamingReadFeatureValuesRequest.newBuilder()
              .setEntityType(
                  EntityTypeName.of("[PROJECT]", "[LOCATION]", "[FEATURESTORE]", "[ENTITY_TYPE]")
                      .toString())
              .addAllEntityIds(new ArrayList<String>())
              .setFeatureSelector(FeatureSelector.newBuilder().build())
              .build();
      ServerStream<ReadFeatureValuesResponse> stream =
          featurestoreOnlineServingServiceClient.streamingReadFeatureValuesCallable().call(request);
      for (ReadFeatureValuesResponse response : stream) {
        // Do something when a response is received.
      }
    }
  }
}
// [END aiplatform_v1beta1_generated_FeaturestoreOnlineServingService_StreamingReadFeatureValues_async]
