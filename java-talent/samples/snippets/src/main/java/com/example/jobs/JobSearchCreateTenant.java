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

// [START job_search_create_tenant_beta]

import com.google.cloud.talent.v4.CreateTenantRequest;
import com.google.cloud.talent.v4.ProjectName;
import com.google.cloud.talent.v4.Tenant;
import com.google.cloud.talent.v4.TenantServiceClient;
import java.io.IOException;

public class JobSearchCreateTenant {

  public static void createTenant() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String externalId = "your-external-id";
    createTenant(projectId, externalId);
  }

  // Create Tenant for scoping resources, e.g. companies and jobs.
  public static void createTenant(String projectId, String externalId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (TenantServiceClient tenantServiceClient = TenantServiceClient.create()) {
      ProjectName parent = ProjectName.of(projectId);
      Tenant tenant = Tenant.newBuilder().setExternalId(externalId).build();

      CreateTenantRequest request =
          CreateTenantRequest.newBuilder().setParent(parent.toString()).setTenant(tenant).build();

      Tenant response = tenantServiceClient.createTenant(request);
      System.out.println("Created Tenant");
      System.out.format("Name: %s%n", response.getName());
      System.out.format("External ID: %s%n", response.getExternalId());
    }
  }
}
// [END job_search_create_tenant_beta]
