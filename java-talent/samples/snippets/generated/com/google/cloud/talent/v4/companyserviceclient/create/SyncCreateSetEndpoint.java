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

package com.google.cloud.talent.v4.samples;

// [START talent_v4_generated_companyserviceclient_create_setendpoint_sync]
import com.google.cloud.talent.v4.CompanyServiceClient;
import com.google.cloud.talent.v4.CompanyServiceSettings;
import com.google.cloud.talent.v4.myEndpoint;

public class SyncCreateSetEndpoint {

  public static void main(String[] args) throws Exception {
    syncCreateSetEndpoint();
  }

  public static void syncCreateSetEndpoint() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    CompanyServiceSettings companyServiceSettings =
        CompanyServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
    CompanyServiceClient companyServiceClient = CompanyServiceClient.create(companyServiceSettings);
  }
}
// [END talent_v4_generated_companyserviceclient_create_setendpoint_sync]
