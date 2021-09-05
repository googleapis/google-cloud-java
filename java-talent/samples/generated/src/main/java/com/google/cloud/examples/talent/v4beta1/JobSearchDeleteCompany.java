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
// DO NOT EDIT! This is a generated sample ("Request",  "job_search_delete_company")
// sample-metadata:
//   title:
//   description: Delete Company
//   usage: gradle run -PmainClass=com.google.cloud.examples.talent.v4beta1.JobSearchDeleteCompany
// [--args='[--project_id "Your Google Cloud Project ID"] [--tenant_id "Your Tenant ID (using
// tenancy is optional)"] [--company_id "ID of the company to delete"]']

package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.CompanyName;
import com.google.cloud.talent.v4beta1.CompanyServiceClient;
import com.google.cloud.talent.v4beta1.CompanyWithTenantName;
import com.google.cloud.talent.v4beta1.DeleteCompanyRequest;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JobSearchDeleteCompany {
  // [START job_search_delete_company]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.talent.v4beta1.CompanyName;
   * import com.google.cloud.talent.v4beta1.CompanyServiceClient;
   * import com.google.cloud.talent.v4beta1.CompanyWithTenantName;
   * import com.google.cloud.talent.v4beta1.DeleteCompanyRequest;
   */

  public static void sampleDeleteCompany() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "Your Google Cloud Project ID";
    String tenantId = "Your Tenant ID (using tenancy is optional)";
    String companyId = "ID of the company to delete";
    sampleDeleteCompany(projectId, tenantId, companyId);
  }

  /** Delete Company */
  public static void sampleDeleteCompany(String projectId, String tenantId, String companyId) {
    try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
      CompanyName name = CompanyWithTenantName.of(projectId, tenantId, companyId);
      DeleteCompanyRequest request =
          DeleteCompanyRequest.newBuilder().setName(name.toString()).build();
      companyServiceClient.deleteCompany(request);
      System.out.println("Deleted company");
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END job_search_delete_company]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("company_id").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String tenantId = cl.getOptionValue("tenant_id", "Your Tenant ID (using tenancy is optional)");
    String companyId = cl.getOptionValue("company_id", "ID of the company to delete");

    sampleDeleteCompany(projectId, tenantId, companyId);
  }
}
