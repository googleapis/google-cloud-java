/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// DO NOT EDIT! This is a generated sample ("Request",  "job_search_delete_tenant")
// sample-metadata:
//   title:
//   description: Delete Tenant
//   usage: gradle run -PmainClass=com.google.cloud.examples.talent.v4beta1.JobSearchDeleteTenant [--args='[--project_id "Your Google Cloud Project ID"] [--tenant_id "Your Tenant ID)"]']

package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.DeleteTenantRequest;
import com.google.cloud.talent.v4beta1.TenantName;
import com.google.cloud.talent.v4beta1.TenantServiceClient;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JobSearchDeleteTenant {
  // [START job_search_delete_tenant]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.talent.v4beta1.DeleteTenantRequest;
   * import com.google.cloud.talent.v4beta1.TenantName;
   * import com.google.cloud.talent.v4beta1.TenantServiceClient;
   */

  public static void sampleDeleteTenant() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "Your Google Cloud Project ID";
    String tenantId = "Your Tenant ID)";
    sampleDeleteTenant(projectId, tenantId);
  }

  /** Delete Tenant */
  public static void sampleDeleteTenant(String projectId, String tenantId) {
    try (TenantServiceClient tenantServiceClient = TenantServiceClient.create()) {
      TenantName name = TenantName.of(projectId, tenantId);
      DeleteTenantRequest request =
          DeleteTenantRequest.newBuilder().setName(name.toString()).build();
      tenantServiceClient.deleteTenant(request);
      System.out.println("Deleted Tenant.");
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END job_search_delete_tenant]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String tenantId = cl.getOptionValue("tenant_id", "Your Tenant ID)");

    sampleDeleteTenant(projectId, tenantId);
  }
}
