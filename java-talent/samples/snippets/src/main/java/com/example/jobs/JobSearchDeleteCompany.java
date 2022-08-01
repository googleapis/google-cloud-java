/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jobs;

// [START job_search_delete_company_beta]

import com.google.cloud.talent.v4.CompanyName;
import com.google.cloud.talent.v4.CompanyServiceClient;
import com.google.cloud.talent.v4.DeleteCompanyRequest;
import java.io.IOException;

public class JobSearchDeleteCompany {

  public static void deleteCompany() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String tenantId = "your-tenant-id";
    String companyId = "your-company-id";
    deleteCompany(projectId, tenantId, companyId);
  }

  // Delete Company.
  public static void deleteCompany(String projectId, String tenantId, String companyId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
      CompanyName name = CompanyName.of(projectId, tenantId, companyId);

      DeleteCompanyRequest request =
          DeleteCompanyRequest.newBuilder().setName(name.toString()).build();

      companyServiceClient.deleteCompany(request);
      System.out.println("Deleted company");
    }
  }
}
// [END job_search_delete_company_beta]
