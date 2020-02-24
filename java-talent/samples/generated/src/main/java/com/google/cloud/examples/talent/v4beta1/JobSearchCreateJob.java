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
// DO NOT EDIT! This is a generated sample ("Request",  "job_search_create_job")
// sample-metadata:
//   title:
//   description: Create Job
//   usage: gradle run -PmainClass=com.google.cloud.examples.talent.v4beta1.JobSearchCreateJob [--args='[--project_id "Your Google Cloud Project ID"] [--tenant_id "Your Tenant ID (using tenancy is optional)"] [--company_name "Company name, e.g. projects/your-project/companies/company-id"] [--requisition_id "Job requisition ID, aka Posting ID. Unique per job."] [--title "Software Engineer"] [--description "This is a description of this <i>wonderful</i> job!"] [--job_application_url "https://www.example.org/job-posting/123"] [--address_one "1600 Amphitheatre Parkway, Mountain View, CA 94043"] [--address_two "111 8th Avenue, New York, NY 10011"] [--language_code "en-US"]']

package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.CreateJobRequest;
import com.google.cloud.talent.v4beta1.Job;
import com.google.cloud.talent.v4beta1.Job.ApplicationInfo;
import com.google.cloud.talent.v4beta1.JobServiceClient;
import com.google.cloud.talent.v4beta1.TenantName;
import com.google.cloud.talent.v4beta1.TenantOrProjectName;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JobSearchCreateJob {
  // [START job_search_create_job]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.talent.v4beta1.CreateJobRequest;
   * import com.google.cloud.talent.v4beta1.Job;
   * import com.google.cloud.talent.v4beta1.Job.ApplicationInfo;
   * import com.google.cloud.talent.v4beta1.JobServiceClient;
   * import com.google.cloud.talent.v4beta1.TenantName;
   * import com.google.cloud.talent.v4beta1.TenantOrProjectName;
   * import java.util.Arrays;
   * import java.util.List;
   */

  public static void sampleCreateJob() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "Your Google Cloud Project ID";
    String tenantId = "Your Tenant ID (using tenancy is optional)";
    String companyName = "Company name, e.g. projects/your-project/companies/company-id";
    String requisitionId = "Job requisition ID, aka Posting ID. Unique per job.";
    String title = "Software Engineer";
    String description = "This is a description of this <i>wonderful</i> job!";
    String jobApplicationUrl = "https://www.example.org/job-posting/123";
    String addressOne = "1600 Amphitheatre Parkway, Mountain View, CA 94043";
    String addressTwo = "111 8th Avenue, New York, NY 10011";
    String languageCode = "en-US";
    sampleCreateJob(
        projectId,
        tenantId,
        companyName,
        requisitionId,
        title,
        description,
        jobApplicationUrl,
        addressOne,
        addressTwo,
        languageCode);
  }

  /**
   * Create Job
   *
   * @param projectId Your Google Cloud Project ID
   * @param tenantId Identifier of the Tenant
   */
  public static void sampleCreateJob(
      String projectId,
      String tenantId,
      String companyName,
      String requisitionId,
      String title,
      String description,
      String jobApplicationUrl,
      String addressOne,
      String addressTwo,
      String languageCode) {
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      TenantOrProjectName parent = TenantName.of(projectId, tenantId);
      List<String> uris = Arrays.asList(jobApplicationUrl);
      Job.ApplicationInfo applicationInfo =
          Job.ApplicationInfo.newBuilder().addAllUris(uris).build();
      List<String> addresses = Arrays.asList(addressOne, addressTwo);
      Job job =
          Job.newBuilder()
              .setCompany(companyName)
              .setRequisitionId(requisitionId)
              .setTitle(title)
              .setDescription(description)
              .setApplicationInfo(applicationInfo)
              .addAllAddresses(addresses)
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
  // [END job_search_create_job]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("company_name").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("requisition_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("title").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("description").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("job_application_url").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("address_one").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("address_two").build());
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
    String title = cl.getOptionValue("title", "Software Engineer");
    String description =
        cl.getOptionValue("description", "This is a description of this <i>wonderful</i> job!");
    String jobApplicationUrl =
        cl.getOptionValue("job_application_url", "https://www.example.org/job-posting/123");
    String addressOne =
        cl.getOptionValue("address_one", "1600 Amphitheatre Parkway, Mountain View, CA 94043");
    String addressTwo = cl.getOptionValue("address_two", "111 8th Avenue, New York, NY 10011");
    String languageCode = cl.getOptionValue("language_code", "en-US");

    sampleCreateJob(
        projectId,
        tenantId,
        companyName,
        requisitionId,
        title,
        description,
        jobApplicationUrl,
        addressOne,
        addressTwo,
        languageCode);
  }
}
