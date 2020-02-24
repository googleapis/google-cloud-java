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
// DO NOT EDIT! This is a generated sample ("Request",  "job_search_create_tenant")
// sample-metadata:
//   title:
//   description: Create Tenant for scoping resources, e.g. companies and jobs
//   usage: gradle run -PmainClass=com.google.cloud.examples.talent.v4beta1.JobSearchCreateTenant [--args='[--project_id "Your Google Cloud Project ID"] [--external_id "Your Unique Identifier for Tenant"]']

package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.CreateTenantRequest;
import com.google.cloud.talent.v4beta1.ProjectName;
import com.google.cloud.talent.v4beta1.Tenant;
import com.google.cloud.talent.v4beta1.TenantServiceClient;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JobSearchCreateTenant {
  // [START job_search_create_tenant]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.talent.v4beta1.CreateTenantRequest;
   * import com.google.cloud.talent.v4beta1.ProjectName;
   * import com.google.cloud.talent.v4beta1.Tenant;
   * import com.google.cloud.talent.v4beta1.TenantServiceClient;
   */

  public static void sampleCreateTenant() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "Your Google Cloud Project ID";
    String externalId = "Your Unique Identifier for Tenant";
    sampleCreateTenant(projectId, externalId);
  }

  /** Create Tenant for scoping resources, e.g. companies and jobs */
  public static void sampleCreateTenant(String projectId, String externalId) {
    try (TenantServiceClient tenantServiceClient = TenantServiceClient.create()) {
      ProjectName parent = ProjectName.of(projectId);
      Tenant tenant = Tenant.newBuilder().setExternalId(externalId).build();
      CreateTenantRequest request =
          CreateTenantRequest.newBuilder().setParent(parent.toString()).setTenant(tenant).build();
      Tenant response = tenantServiceClient.createTenant(request);
      System.out.println("Created Tenant");
      System.out.printf("Name: %s\n", response.getName());
      System.out.printf("External ID: %s\n", response.getExternalId());
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END job_search_create_tenant]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("external_id").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String externalId = cl.getOptionValue("external_id", "Your Unique Identifier for Tenant");

    sampleCreateTenant(projectId, externalId);
  }
}
