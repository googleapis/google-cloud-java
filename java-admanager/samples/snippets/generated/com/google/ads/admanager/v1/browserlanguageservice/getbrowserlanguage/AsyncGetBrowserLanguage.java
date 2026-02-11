/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_BrowserLanguageService_GetBrowserLanguage_async]
import com.google.ads.admanager.v1.BrowserLanguage;
import com.google.ads.admanager.v1.BrowserLanguageName;
import com.google.ads.admanager.v1.BrowserLanguageServiceClient;
import com.google.ads.admanager.v1.GetBrowserLanguageRequest;
import com.google.api.core.ApiFuture;

public class AsyncGetBrowserLanguage {

  public static void main(String[] args) throws Exception {
    asyncGetBrowserLanguage();
  }

  public static void asyncGetBrowserLanguage() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BrowserLanguageServiceClient browserLanguageServiceClient =
        BrowserLanguageServiceClient.create()) {
      GetBrowserLanguageRequest request =
          GetBrowserLanguageRequest.newBuilder()
              .setName(BrowserLanguageName.of("[NETWORK_CODE]", "[BROWSER_LANGUAGE]").toString())
              .build();
      ApiFuture<BrowserLanguage> future =
          browserLanguageServiceClient.getBrowserLanguageCallable().futureCall(request);
      // Do something.
      BrowserLanguage response = future.get();
    }
  }
}
// [END admanager_v1_generated_BrowserLanguageService_GetBrowserLanguage_async]
