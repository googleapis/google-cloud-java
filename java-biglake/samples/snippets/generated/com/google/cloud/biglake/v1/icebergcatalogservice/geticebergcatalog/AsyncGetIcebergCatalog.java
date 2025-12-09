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

package com.google.cloud.biglake.v1.samples;

// [START biglake_v1_generated_IcebergCatalogService_GetIcebergCatalog_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.biglake.v1.CatalogName;
import com.google.cloud.biglake.v1.GetIcebergCatalogRequest;
import com.google.cloud.biglake.v1.IcebergCatalog;
import com.google.cloud.biglake.v1.IcebergCatalogServiceClient;

public class AsyncGetIcebergCatalog {

  public static void main(String[] args) throws Exception {
    asyncGetIcebergCatalog();
  }

  public static void asyncGetIcebergCatalog() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (IcebergCatalogServiceClient icebergCatalogServiceClient =
        IcebergCatalogServiceClient.create()) {
      GetIcebergCatalogRequest request =
          GetIcebergCatalogRequest.newBuilder()
              .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
              .build();
      ApiFuture<IcebergCatalog> future =
          icebergCatalogServiceClient.getIcebergCatalogCallable().futureCall(request);
      // Do something.
      IcebergCatalog response = future.get();
    }
  }
}
// [END biglake_v1_generated_IcebergCatalogService_GetIcebergCatalog_async]
