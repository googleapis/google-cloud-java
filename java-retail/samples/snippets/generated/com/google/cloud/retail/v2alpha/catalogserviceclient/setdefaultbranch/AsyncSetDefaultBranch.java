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

// [START retail_v2alpha_generated_catalogserviceclient_setdefaultbranch_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.retail.v2alpha.BranchName;
import com.google.cloud.retail.v2alpha.CatalogName;
import com.google.cloud.retail.v2alpha.CatalogServiceClient;
import com.google.cloud.retail.v2alpha.SetDefaultBranchRequest;
import com.google.protobuf.Empty;

public class AsyncSetDefaultBranch {

  public static void main(String[] args) throws Exception {
    asyncSetDefaultBranch();
  }

  public static void asyncSetDefaultBranch() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
      SetDefaultBranchRequest request =
          SetDefaultBranchRequest.newBuilder()
              .setCatalog(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setBranchId(
                  BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
              .setNote("note3387378")
              .setForce(true)
              .build();
      ApiFuture<Empty> future = catalogServiceClient.setDefaultBranchCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END retail_v2alpha_generated_catalogserviceclient_setdefaultbranch_async]
