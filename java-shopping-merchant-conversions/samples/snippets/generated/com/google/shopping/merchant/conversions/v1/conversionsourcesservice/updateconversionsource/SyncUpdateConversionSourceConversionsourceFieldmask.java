/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.conversions.v1.samples;

// [START merchantapi_v1_generated_ConversionSourcesService_UpdateConversionSource_ConversionsourceFieldmask_sync]
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.conversions.v1.ConversionSource;
import com.google.shopping.merchant.conversions.v1.ConversionSourcesServiceClient;

public class SyncUpdateConversionSourceConversionsourceFieldmask {

  public static void main(String[] args) throws Exception {
    syncUpdateConversionSourceConversionsourceFieldmask();
  }

  public static void syncUpdateConversionSourceConversionsourceFieldmask() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConversionSourcesServiceClient conversionSourcesServiceClient =
        ConversionSourcesServiceClient.create()) {
      ConversionSource conversionSource = ConversionSource.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      ConversionSource response =
          conversionSourcesServiceClient.updateConversionSource(conversionSource, updateMask);
    }
  }
}
// [END merchantapi_v1_generated_ConversionSourcesService_UpdateConversionSource_ConversionsourceFieldmask_sync]
