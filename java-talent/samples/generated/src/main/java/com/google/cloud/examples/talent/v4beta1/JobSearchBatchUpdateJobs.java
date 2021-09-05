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
// DO NOT EDIT! This is a generated sample ("LongRunningRequestAsync",
// "job_search_batch_update_jobs")
// sample-metadata:
//   title:
//   description: Batch Update Jobs
//   usage: gradle run -PmainClass=com.google.cloud.examples.talent.v4beta1.JobSearchBatchUpdateJobs
// [--args='[--project_id "Your Google Cloud Project ID"] [--tenant_id "Your Tenant ID (using
// tenancy is optional)"] [--job_name_one "job name, e.g.
// projects/your-project/tenants/tenant-id/jobs/job-id"] [--company_name_one "Company name, e.g.
// projects/your-project/companies/company-id"] [--requisition_id_one "Job requisition ID, aka
// Posting ID. Unique per job."] [--title_one "Software Engineer"] [--description_one "This is a
// description of this <i>wonderful</i> job!"] [--job_application_url_one
// "https://www.example.org/job-posting/123"] [--address_one "1600 Amphitheatre Parkway, Mountain
// View, CA 94043"] [--language_code_one "en-US"] [--job_name_two "job name, e.g.
// projects/your-project/tenants/tenant-id/jobs/job-id"] [--company_name_two "Company name, e.g.
// projects/your-project/companies/company-id"] [--requisition_id_two "Job requisition ID, aka
// Posting ID. Unique per job."] [--title_two "Quality Assurance"] [--description_two "This is a
// description of this <i>wonderful</i> job!"] [--job_application_url_two
// "https://www.example.org/job-posting/123"] [--address_two "111 8th Avenue, New York, NY 10011"]
// [--language_code_two "en-US"]']

package com.google.cloud.examples.talent.v4beta1;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.talent.v4beta1.BatchOperationMetadata;
import com.google.cloud.talent.v4beta1.BatchUpdateJobsRequest;
import com.google.cloud.talent.v4beta1.Job;
import com.google.cloud.talent.v4beta1.JobOperationResult;
import com.google.cloud.talent.v4beta1.JobServiceClient;
import com.google.cloud.talent.v4beta1.TenantName;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JobSearchBatchUpdateJobs {
  // [START job_search_batch_update_jobs]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.api.gax.longrunning.OperationFuture;
   * import com.google.cloud.talent.v4beta1.BatchOperationMetadata;
   * import com.google.cloud.talent.v4beta1.BatchUpdateJobsRequest;
   * import com.google.cloud.talent.v4beta1.Job;
   * import com.google.cloud.talent.v4beta1.Job.ApplicationInfo;
   * import com.google.cloud.talent.v4beta1.JobOperationResult;
   * import com.google.cloud.talent.v4beta1.JobServiceClient;
   * import com.google.cloud.talent.v4beta1.TenantName;
   * import java.util.Arrays;
   * import java.util.List;
   */

  public static void sampleBatchUpdateJobs() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "Your Google Cloud Project ID";
    String tenantId = "Your Tenant ID (using tenancy is optional)";
    String jobNameOne = "job name, e.g. projects/your-project/tenants/tenant-id/jobs/job-id";
    String companyNameOne = "Company name, e.g. projects/your-project/companies/company-id";
    String requisitionIdOne = "Job requisition ID, aka Posting ID. Unique per job.";
    String titleOne = "Software Engineer";
    String descriptionOne = "This is a description of this <i>wonderful</i> job!";
    String jobApplicationUrlOne = "https://www.example.org/job-posting/123";
    String addressOne = "1600 Amphitheatre Parkway, Mountain View, CA 94043";
    String languageCodeOne = "en-US";
    String jobNameTwo = "job name, e.g. projects/your-project/tenants/tenant-id/jobs/job-id";
    String companyNameTwo = "Company name, e.g. projects/your-project/companies/company-id";
    String requisitionIdTwo = "Job requisition ID, aka Posting ID. Unique per job.";
    String titleTwo = "Quality Assurance";
    String descriptionTwo = "This is a description of this <i>wonderful</i> job!";
    String jobApplicationUrlTwo = "https://www.example.org/job-posting/123";
    String addressTwo = "111 8th Avenue, New York, NY 10011";
    String languageCodeTwo = "en-US";
    sampleBatchUpdateJobs(
        projectId,
        tenantId,
        jobNameOne,
        companyNameOne,
        requisitionIdOne,
        titleOne,
        descriptionOne,
        jobApplicationUrlOne,
        addressOne,
        languageCodeOne,
        jobNameTwo,
        companyNameTwo,
        requisitionIdTwo,
        titleTwo,
        descriptionTwo,
        jobApplicationUrlTwo,
        addressTwo,
        languageCodeTwo);
  }

  /**
   * Batch Update Jobs
   *
   * @param projectId Your Google Cloud Project ID
   * @param tenantId Identifier of the Tenant
   */
  public static void sampleBatchUpdateJobs(
      String projectId,
      String tenantId,
      String jobNameOne,
      String companyNameOne,
      String requisitionIdOne,
      String titleOne,
      String descriptionOne,
      String jobApplicationUrlOne,
      String addressOne,
      String languageCodeOne,
      String jobNameTwo,
      String companyNameTwo,
      String requisitionIdTwo,
      String titleTwo,
      String descriptionTwo,
      String jobApplicationUrlTwo,
      String addressTwo,
      String languageCodeTwo) {
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      String formattedParent = TenantName.format(projectId, tenantId);
      List<String> uris = Arrays.asList(jobApplicationUrlOne);
      Job.ApplicationInfo applicationInfo =
          Job.ApplicationInfo.newBuilder().addAllUris(uris).build();
      List<String> addresses = Arrays.asList(addressOne);
      Job jobsElement =
          Job.newBuilder()
              .setName(jobNameOne)
              .setCompany(companyNameOne)
              .setRequisitionId(requisitionIdOne)
              .setTitle(titleOne)
              .setDescription(descriptionOne)
              .setApplicationInfo(applicationInfo)
              .addAllAddresses(addresses)
              .setLanguageCode(languageCodeOne)
              .build();
      List<String> uris2 = Arrays.asList(jobApplicationUrlTwo);
      Job.ApplicationInfo applicationInfo2 =
          Job.ApplicationInfo.newBuilder().addAllUris(uris2).build();
      List<String> addresses2 = Arrays.asList(addressTwo);
      Job jobsElement2 =
          Job.newBuilder()
              .setName(jobNameTwo)
              .setCompany(companyNameTwo)
              .setRequisitionId(requisitionIdTwo)
              .setTitle(titleTwo)
              .setDescription(descriptionTwo)
              .setApplicationInfo(applicationInfo2)
              .addAllAddresses(addresses2)
              .setLanguageCode(languageCodeTwo)
              .build();
      List<Job> jobs = Arrays.asList(jobsElement, jobsElement2);
      BatchUpdateJobsRequest request =
          BatchUpdateJobsRequest.newBuilder().setParent(formattedParent).addAllJobs(jobs).build();
      OperationFuture<JobOperationResult, BatchOperationMetadata> future =
          jobServiceClient.batchUpdateJobsAsync(request);

      System.out.println("Waiting for operation to complete...");
      JobOperationResult response = future.get();
      System.out.printf("Batch response: %s\n", response);
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END job_search_batch_update_jobs]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("job_name_one").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("company_name_one").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("requisition_id_one").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("title_one").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("description_one").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("job_application_url_one").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("address_one").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("language_code_one").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("job_name_two").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("company_name_two").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("requisition_id_two").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("title_two").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("description_two").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("job_application_url_two").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("address_two").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("language_code_two").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String tenantId = cl.getOptionValue("tenant_id", "Your Tenant ID (using tenancy is optional)");
    String jobNameOne =
        cl.getOptionValue(
            "job_name_one", "job name, e.g. projects/your-project/tenants/tenant-id/jobs/job-id");
    String companyNameOne =
        cl.getOptionValue(
            "company_name_one", "Company name, e.g. projects/your-project/companies/company-id");
    String requisitionIdOne =
        cl.getOptionValue(
            "requisition_id_one", "Job requisition ID, aka Posting ID. Unique per job.");
    String titleOne = cl.getOptionValue("title_one", "Software Engineer");
    String descriptionOne =
        cl.getOptionValue("description_one", "This is a description of this <i>wonderful</i> job!");
    String jobApplicationUrlOne =
        cl.getOptionValue("job_application_url_one", "https://www.example.org/job-posting/123");
    String addressOne =
        cl.getOptionValue("address_one", "1600 Amphitheatre Parkway, Mountain View, CA 94043");
    String languageCodeOne = cl.getOptionValue("language_code_one", "en-US");
    String jobNameTwo =
        cl.getOptionValue(
            "job_name_two", "job name, e.g. projects/your-project/tenants/tenant-id/jobs/job-id");
    String companyNameTwo =
        cl.getOptionValue(
            "company_name_two", "Company name, e.g. projects/your-project/companies/company-id");
    String requisitionIdTwo =
        cl.getOptionValue(
            "requisition_id_two", "Job requisition ID, aka Posting ID. Unique per job.");
    String titleTwo = cl.getOptionValue("title_two", "Quality Assurance");
    String descriptionTwo =
        cl.getOptionValue("description_two", "This is a description of this <i>wonderful</i> job!");
    String jobApplicationUrlTwo =
        cl.getOptionValue("job_application_url_two", "https://www.example.org/job-posting/123");
    String addressTwo = cl.getOptionValue("address_two", "111 8th Avenue, New York, NY 10011");
    String languageCodeTwo = cl.getOptionValue("language_code_two", "en-US");

    sampleBatchUpdateJobs(
        projectId,
        tenantId,
        jobNameOne,
        companyNameOne,
        requisitionIdOne,
        titleOne,
        descriptionOne,
        jobApplicationUrlOne,
        addressOne,
        languageCodeOne,
        jobNameTwo,
        companyNameTwo,
        requisitionIdTwo,
        titleTwo,
        descriptionTwo,
        jobApplicationUrlTwo,
        addressTwo,
        languageCodeTwo);
  }
}
