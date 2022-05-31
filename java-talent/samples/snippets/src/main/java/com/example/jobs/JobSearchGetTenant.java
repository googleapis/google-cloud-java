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

// [START job_search_get_tenant_beta]

import com.google.cloud.talent.v4.GetTenantRequest;
import com.google.cloud.talent.v4.Tenant;
import com.google.cloud.talent.v4.TenantName;
import com.google.cloud.talent.v4.TenantServiceClient;
import java.io.IOException;

public class JobSearchGetTenant {

  public static void getTenant() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String tenantId = "your-tenant-id";
    getTenant(projectId, tenantId);
  }

  // Get Tenant by name.
  public static void getTenant(String projectId, String tenantId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (TenantServiceClient tenantServiceClient = TenantServiceClient.create()) {
      TenantName name = TenantName.of(projectId, tenantId);

      GetTenantRequest request = GetTenantRequest.newBuilder().setName(name.toString()).build();

      Tenant response = tenantServiceClient.getTenant(request);
      System.out.format("Name: %s%n", response.getName());
      System.out.format("External ID: %s%n", response.getExternalId());
    }
  }
}
// [END job_search_get_tenant_beta]
