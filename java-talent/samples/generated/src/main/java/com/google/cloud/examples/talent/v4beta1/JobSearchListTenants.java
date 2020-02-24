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
// DO NOT EDIT! This is a generated sample ("RequestPaged",  "job_search_list_tenants")
// sample-metadata:
//   title:
//   description: List Tenants
//   usage: gradle run -PmainClass=com.google.cloud.examples.talent.v4beta1.JobSearchListTenants [--args='[--project_id "Your Google Cloud Project ID"]']

package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.ListTenantsRequest;
import com.google.cloud.talent.v4beta1.ProjectName;
import com.google.cloud.talent.v4beta1.Tenant;
import com.google.cloud.talent.v4beta1.TenantServiceClient;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JobSearchListTenants {
  // [START job_search_list_tenants]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.talent.v4beta1.ListTenantsRequest;
   * import com.google.cloud.talent.v4beta1.ProjectName;
   * import com.google.cloud.talent.v4beta1.Tenant;
   * import com.google.cloud.talent.v4beta1.TenantServiceClient;
   */

  public static void sampleListTenants() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "Your Google Cloud Project ID";
    sampleListTenants(projectId);
  }

  /** List Tenants */
  public static void sampleListTenants(String projectId) {
    try (TenantServiceClient tenantServiceClient = TenantServiceClient.create()) {
      ProjectName parent = ProjectName.of(projectId);
      ListTenantsRequest request =
          ListTenantsRequest.newBuilder().setParent(parent.toString()).build();
      for (Tenant responseItem : tenantServiceClient.listTenants(request).iterateAll()) {
        System.out.printf("Tenant Name: %s\n", responseItem.getName());
        System.out.printf("External ID: %s\n", responseItem.getExternalId());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END job_search_list_tenants]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");

    sampleListTenants(projectId);
  }
}
