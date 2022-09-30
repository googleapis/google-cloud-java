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

// [START resourcemanager_v3_generated_tagvaluesclient_updatetagvalue_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.resourcemanager.v3.TagValue;
import com.google.cloud.resourcemanager.v3.TagValuesClient;
import com.google.cloud.resourcemanager.v3.UpdateTagValueMetadata;
import com.google.cloud.resourcemanager.v3.UpdateTagValueRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateTagValueLRO {

  public static void main(String[] args) throws Exception {
    asyncUpdateTagValueLRO();
  }

  public static void asyncUpdateTagValueLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TagValuesClient tagValuesClient = TagValuesClient.create()) {
      UpdateTagValueRequest request =
          UpdateTagValueRequest.newBuilder()
              .setTagValue(TagValue.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .setValidateOnly(true)
              .build();
      OperationFuture<TagValue, UpdateTagValueMetadata> future =
          tagValuesClient.updateTagValueOperationCallable().futureCall(request);
      // Do something.
      TagValue response = future.get();
    }
  }
}
// [END resourcemanager_v3_generated_tagvaluesclient_updatetagvalue_lro_async]
