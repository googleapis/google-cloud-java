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
// DO NOT EDIT! This is a generated sample ("Request",  "job_search_get_company")
// sample-metadata:
//   title:
//   description: Get Company
//   usage: gradle run -PmainClass=com.google.cloud.examples.talent.v4beta1.JobSearchGetCompany [--args='[--project_id "Your Google Cloud Project ID"] [--tenant_id "Your Tenant ID (using tenancy is optional)"] [--company_id "Company ID"]']

package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.Company;
import com.google.cloud.talent.v4beta1.CompanyName;
import com.google.cloud.talent.v4beta1.CompanyServiceClient;
import com.google.cloud.talent.v4beta1.CompanyWithTenantName;
import com.google.cloud.talent.v4beta1.GetCompanyRequest;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JobSearchGetCompany {
  // [START job_search_get_company]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.talent.v4beta1.Company;
   * import com.google.cloud.talent.v4beta1.CompanyName;
   * import com.google.cloud.talent.v4beta1.CompanyServiceClient;
   * import com.google.cloud.talent.v4beta1.CompanyWithTenantName;
   * import com.google.cloud.talent.v4beta1.GetCompanyRequest;
   */

  public static void sampleGetCompany() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "Your Google Cloud Project ID";
    String tenantId = "Your Tenant ID (using tenancy is optional)";
    String companyId = "Company ID";
    sampleGetCompany(projectId, tenantId, companyId);
  }

  /** Get Company */
  public static void sampleGetCompany(String projectId, String tenantId, String companyId) {
    try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
      CompanyName name = CompanyWithTenantName.of(projectId, tenantId, companyId);
      GetCompanyRequest request = GetCompanyRequest.newBuilder().setName(name.toString()).build();
      Company response = companyServiceClient.getCompany(request);
      System.out.printf("Company name: %s\n", response.getName());
      System.out.printf("Display name: %s\n", response.getDisplayName());
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END job_search_get_company]

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
    String companyId = cl.getOptionValue("company_id", "Company ID");

    sampleGetCompany(projectId, tenantId, companyId);
  }
}
