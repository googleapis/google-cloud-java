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

package com.google.shopping.merchant.accounts.v1beta.samples;

// [START merchantapi_v1beta_generated_HomepageService_GetHomepage_async]
import com.google.api.core.ApiFuture;
import com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest;
import com.google.shopping.merchant.accounts.v1beta.Homepage;
import com.google.shopping.merchant.accounts.v1beta.HomepageName;
import com.google.shopping.merchant.accounts.v1beta.HomepageServiceClient;

public class AsyncGetHomepage {

  public static void main(String[] args) throws Exception {
    asyncGetHomepage();
  }

  public static void asyncGetHomepage() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (HomepageServiceClient homepageServiceClient = HomepageServiceClient.create()) {
      GetHomepageRequest request =
          GetHomepageRequest.newBuilder().setName(HomepageName.of("[ACCOUNT]").toString()).build();
      ApiFuture<Homepage> future = homepageServiceClient.getHomepageCallable().futureCall(request);
      // Do something.
      Homepage response = future.get();
    }
  }
}
// [END merchantapi_v1beta_generated_HomepageService_GetHomepage_async]
