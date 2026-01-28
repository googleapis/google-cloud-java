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

package com.google.cloud.auditmanager.v1.samples;

// [START auditmanager_v1_generated_AuditManager_GenerateAuditScopeReport_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.auditmanager.v1.AuditManagerClient;
import com.google.cloud.auditmanager.v1.AuditScopeReport;
import com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest;

public class AsyncGenerateAuditScopeReport {

  public static void main(String[] args) throws Exception {
    asyncGenerateAuditScopeReport();
  }

  public static void asyncGenerateAuditScopeReport() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AuditManagerClient auditManagerClient = AuditManagerClient.create()) {
      GenerateAuditScopeReportRequest request =
          GenerateAuditScopeReportRequest.newBuilder()
              .setScope("scope109264468")
              .setComplianceStandard("complianceStandard-1534269448")
              .setComplianceFramework("complianceFramework-1808314333")
              .build();
      ApiFuture<AuditScopeReport> future =
          auditManagerClient.generateAuditScopeReportCallable().futureCall(request);
      // Do something.
      AuditScopeReport response = future.get();
    }
  }
}
// [END auditmanager_v1_generated_AuditManager_GenerateAuditScopeReport_async]
