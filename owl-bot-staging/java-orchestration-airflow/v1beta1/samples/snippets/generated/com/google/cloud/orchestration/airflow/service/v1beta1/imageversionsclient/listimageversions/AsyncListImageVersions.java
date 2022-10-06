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

package com.google.cloud.orchestration.airflow.service.v1beta1.samples;

// [START service_v1beta1_generated_imageversionsclient_listimageversions_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.orchestration.airflow.service.v1beta1.ImageVersion;
import com.google.cloud.orchestration.airflow.service.v1beta1.ImageVersionsClient;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsRequest;

public class AsyncListImageVersions {

  public static void main(String[] args) throws Exception {
    asyncListImageVersions();
  }

  public static void asyncListImageVersions() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ImageVersionsClient imageVersionsClient = ImageVersionsClient.create()) {
      ListImageVersionsRequest request =
          ListImageVersionsRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setIncludePastReleases(true)
              .build();
      ApiFuture<ImageVersion> future =
          imageVersionsClient.listImageVersionsPagedCallable().futureCall(request);
      // Do something.
      for (ImageVersion element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END service_v1beta1_generated_imageversionsclient_listimageversions_async]
