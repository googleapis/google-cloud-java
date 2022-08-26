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

// [START talent_v4_generated_companyserviceclient_updatecompany_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.talent.v4.Company;
import com.google.cloud.talent.v4.CompanyServiceClient;
import com.google.cloud.talent.v4.UpdateCompanyRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateCompany {

  public static void main(String[] args) throws Exception {
    asyncUpdateCompany();
  }

  public static void asyncUpdateCompany() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
      UpdateCompanyRequest request =
          UpdateCompanyRequest.newBuilder()
              .setCompany(Company.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      ApiFuture<Company> future = companyServiceClient.updateCompanyCallable().futureCall(request);
      // Do something.
      Company response = future.get();
    }
  }
}
// [END talent_v4_generated_companyserviceclient_updatecompany_async]
