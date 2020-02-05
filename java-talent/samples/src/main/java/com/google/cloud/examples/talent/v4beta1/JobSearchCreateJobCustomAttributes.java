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
// DO NOT EDIT! This is a generated sample ("Request",  "job_search_create_job_custom_attributes")
// sample-metadata:
//   title:
//   description: Create Job with Custom Attributes
//   usage: gradle run
// -PmainClass=com.google.cloud.examples.talent.v4beta1.JobSearchCreateJobCustomAttributes
// [--args='[--project_id "Your Google Cloud Project ID"] [--tenant_id "Your Tenant ID (using
// tenancy is optional)"] [--company_name "Company name, e.g.
// projects/your-project/companies/company-id"] [--requisition_id "Job requisition ID, aka Posting
// ID. Unique per job."] [--language_code "en-US"]']

package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.CreateJobRequest;
import com.google.cloud.talent.v4beta1.Job;
import com.google.cloud.talent.v4beta1.JobServiceClient;
import com.google.cloud.talent.v4beta1.TenantName;
import com.google.cloud.talent.v4beta1.TenantOrProjectName;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JobSearchCreateJobCustomAttributes {
  // [START job_search_create_job_custom_attributes]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.talent.v4beta1.CreateJobRequest;
   * import com.google.cloud.talent.v4beta1.Job;
   * import com.google.cloud.talent.v4beta1.JobServiceClient;
   * import com.google.cloud.talent.v4beta1.TenantName;
   * import com.google.cloud.talent.v4beta1.TenantOrProjectName;
   */

  public static void sampleCreateJob() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "Your Google Cloud Project ID";
    String tenantId = "Your Tenant ID (using tenancy is optional)";
    String companyName = "Company name, e.g. projects/your-project/companies/company-id";
    String requisitionId = "Job requisition ID, aka Posting ID. Unique per job.";
    String languageCode = "en-US";
    sampleCreateJob(projectId, tenantId, companyName, requisitionId, languageCode);
  }

  /**
   * Create Job with Custom Attributes
   *
   * @param projectId Your Google Cloud Project ID
   * @param tenantId Identifier of the Tenantd
   */
  public static void sampleCreateJob(
      String projectId,
      String tenantId,
      String companyName,
      String requisitionId,
      String languageCode) {
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      TenantOrProjectName parent = TenantName.of(projectId, tenantId);
      Job job =
          Job.newBuilder()
              .setCompany(companyName)
              .setRequisitionId(requisitionId)
              .setLanguageCode(languageCode)
              .build();
      CreateJobRequest request =
          CreateJobRequest.newBuilder().setParent(parent.toString()).setJob(job).build();
      Job response = jobServiceClient.createJob(request);
      System.out.printf("Created job: %s\n", response.getName());
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END job_search_create_job_custom_attributes]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("company_name").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("requisition_id").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("language_code").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String tenantId = cl.getOptionValue("tenant_id", "Your Tenant ID (using tenancy is optional)");
    String companyName =
        cl.getOptionValue(
            "company_name", "Company name, e.g. projects/your-project/companies/company-id");
    String requisitionId =
        cl.getOptionValue("requisition_id", "Job requisition ID, aka Posting ID. Unique per job.");
    String languageCode = cl.getOptionValue("language_code", "en-US");

    sampleCreateJob(projectId, tenantId, companyName, requisitionId, languageCode);
  }
}
