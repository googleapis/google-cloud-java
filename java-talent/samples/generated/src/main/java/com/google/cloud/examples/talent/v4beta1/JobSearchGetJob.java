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
// DO NOT EDIT! This is a generated sample ("Request",  "job_search_get_job")
// sample-metadata:
//   title:
//   description: Get Job
//   usage: gradle run -PmainClass=com.google.cloud.examples.talent.v4beta1.JobSearchGetJob
// [--args='[--project_id "Your Google Cloud Project ID"] [--tenant_id "Your Tenant ID (using
// tenancy is optional)"] [--job_id "Job ID"]']

package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.GetJobRequest;
import com.google.cloud.talent.v4beta1.Job;
import com.google.cloud.talent.v4beta1.JobName;
import com.google.cloud.talent.v4beta1.JobServiceClient;
import com.google.cloud.talent.v4beta1.JobWithTenantName;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JobSearchGetJob {
  // [START job_search_get_job]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.talent.v4beta1.GetJobRequest;
   * import com.google.cloud.talent.v4beta1.Job;
   * import com.google.cloud.talent.v4beta1.JobName;
   * import com.google.cloud.talent.v4beta1.JobServiceClient;
   * import com.google.cloud.talent.v4beta1.JobWithTenantName;
   */

  public static void sampleGetJob() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "Your Google Cloud Project ID";
    String tenantId = "Your Tenant ID (using tenancy is optional)";
    String jobId = "Job ID";
    sampleGetJob(projectId, tenantId, jobId);
  }

  /** Get Job */
  public static void sampleGetJob(String projectId, String tenantId, String jobId) {
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      JobName name = JobWithTenantName.of(projectId, tenantId, jobId);
      GetJobRequest request = GetJobRequest.newBuilder().setName(name.toString()).build();
      Job response = jobServiceClient.getJob(request);
      System.out.printf("Job name: %s\n", response.getName());
      System.out.printf("Requisition ID: %s\n", response.getRequisitionId());
      System.out.printf("Title: %s\n", response.getTitle());
      System.out.printf("Description: %s\n", response.getDescription());
      System.out.printf("Posting language: %s\n", response.getLanguageCode());
      for (String address : response.getAddressesList()) {
        System.out.printf("Address: %s\n", address);
      }
      for (String email : response.getApplicationInfo().getEmailsList()) {
        System.out.printf("Email: %s\n", email);
      }
      for (String websiteUri : response.getApplicationInfo().getUrisList()) {
        System.out.printf("Website: %s\n", websiteUri);
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END job_search_get_job]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("job_id").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String tenantId = cl.getOptionValue("tenant_id", "Your Tenant ID (using tenancy is optional)");
    String jobId = cl.getOptionValue("job_id", "Job ID");

    sampleGetJob(projectId, tenantId, jobId);
  }
}
