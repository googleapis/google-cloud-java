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

package com.google.cloud.retail.v2alpha.samples;

// [START retail_v2alpha_generated_catalogserviceclient_updatecatalog_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.retail.v2alpha.Catalog;
import com.google.cloud.retail.v2alpha.CatalogServiceClient;
import com.google.cloud.retail.v2alpha.UpdateCatalogRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateCatalog {

  public static void main(String[] args) throws Exception {
    asyncUpdateCatalog();
  }

  public static void asyncUpdateCatalog() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
      UpdateCatalogRequest request =
          UpdateCatalogRequest.newBuilder()
              .setCatalog(Catalog.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      ApiFuture<Catalog> future = catalogServiceClient.updateCatalogCallable().futureCall(request);
      // Do something.
      Catalog response = future.get();
    }
  }
}
// [END retail_v2alpha_generated_catalogserviceclient_updatecatalog_async]
