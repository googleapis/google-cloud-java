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

package com.google.shopping.merchant.datasources.v1.samples;

// [START merchantapi_v1_generated_DataSourcesService_CreateDataSource_async]
import com.google.api.core.ApiFuture;
import com.google.shopping.merchant.datasources.v1.AccountName;
import com.google.shopping.merchant.datasources.v1.CreateDataSourceRequest;
import com.google.shopping.merchant.datasources.v1.DataSource;
import com.google.shopping.merchant.datasources.v1.DataSourcesServiceClient;

public class AsyncCreateDataSource {

  public static void main(String[] args) throws Exception {
    asyncCreateDataSource();
  }

  public static void asyncCreateDataSource() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
      CreateDataSourceRequest request =
          CreateDataSourceRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .setDataSource(DataSource.newBuilder().build())
              .build();
      ApiFuture<DataSource> future =
          dataSourcesServiceClient.createDataSourceCallable().futureCall(request);
      // Do something.
      DataSource response = future.get();
    }
  }
}
// [END merchantapi_v1_generated_DataSourcesService_CreateDataSource_async]
