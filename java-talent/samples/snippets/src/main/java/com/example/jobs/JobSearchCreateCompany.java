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

// [START job_search_create_company_beta]

import com.google.cloud.talent.v4.Company;
import com.google.cloud.talent.v4.CompanyServiceClient;
import com.google.cloud.talent.v4.CreateCompanyRequest;
import com.google.cloud.talent.v4.TenantName;
import java.io.IOException;

public class JobSearchCreateCompany {

  public static void createCompany() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String tenantId = "your-tenant-id";
    String displayName = "your-company-display-name";
    String externalId = "your-external-id";
    createCompany(projectId, tenantId, displayName, externalId);
  }

  // Create a company.
  public static void createCompany(
      String projectId, String tenantId, String displayName, String externalId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
      TenantName parent = TenantName.of(projectId, tenantId);
      Company company =
          Company.newBuilder().setDisplayName(displayName).setExternalId(externalId).build();

      CreateCompanyRequest request =
          CreateCompanyRequest.newBuilder()
              .setParent(parent.toString())
              .setCompany(company)
              .build();

      Company response = companyServiceClient.createCompany(request);
      System.out.println("Created Company");
      System.out.format("Name: %s%n", response.getName());
      System.out.format("Display Name: %s%n", response.getDisplayName());
      System.out.format("External ID: %s%n", response.getExternalId());
    }
  }
}
// [END job_search_create_company_beta]
