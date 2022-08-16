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

package com.google.cloud.datacatalog.v1.samples;

// [START datacatalog_v1_generated_policytagmanagerserializationclient_replacetaxonomy_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.datacatalog.v1.PolicyTagManagerSerializationClient;
import com.google.cloud.datacatalog.v1.ReplaceTaxonomyRequest;
import com.google.cloud.datacatalog.v1.SerializedTaxonomy;
import com.google.cloud.datacatalog.v1.Taxonomy;
import com.google.cloud.datacatalog.v1.TaxonomyName;

public class AsyncReplaceTaxonomy {

  public static void main(String[] args) throws Exception {
    asyncReplaceTaxonomy();
  }

  public static void asyncReplaceTaxonomy() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
        PolicyTagManagerSerializationClient.create()) {
      ReplaceTaxonomyRequest request =
          ReplaceTaxonomyRequest.newBuilder()
              .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
              .setSerializedTaxonomy(SerializedTaxonomy.newBuilder().build())
              .build();
      ApiFuture<Taxonomy> future =
          policyTagManagerSerializationClient.replaceTaxonomyCallable().futureCall(request);
      // Do something.
      Taxonomy response = future.get();
    }
  }
}
// [END datacatalog_v1_generated_policytagmanagerserializationclient_replacetaxonomy_async]
