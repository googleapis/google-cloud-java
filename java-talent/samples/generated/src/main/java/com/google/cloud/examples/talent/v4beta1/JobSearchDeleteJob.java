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
// DO NOT EDIT! This is a generated sample ("Request",  "job_search_delete_job")
// sample-metadata:
//   title:
//   description: Delete Job
//   usage: gradle run -PmainClass=com.google.cloud.examples.talent.v4beta1.JobSearchDeleteJob [--args='[--project_id "Your Google Cloud Project ID"] [--tenant_id "Your Tenant ID (using tenancy is optional)"] [--job_id "Company ID"]']

package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.DeleteJobRequest;
import com.google.cloud.talent.v4beta1.JobName;
import com.google.cloud.talent.v4beta1.JobServiceClient;
import com.google.cloud.talent.v4beta1.JobWithTenantName;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JobSearchDeleteJob {
  // [START job_search_delete_job]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.talent.v4beta1.DeleteJobRequest;
   * import com.google.cloud.talent.v4beta1.JobName;
   * import com.google.cloud.talent.v4beta1.JobServiceClient;
   * import com.google.cloud.talent.v4beta1.JobWithTenantName;
   */

  public static void sampleDeleteJob() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "Your Google Cloud Project ID";
    String tenantId = "Your Tenant ID (using tenancy is optional)";
    String jobId = "Company ID";
    sampleDeleteJob(projectId, tenantId, jobId);
  }

  /** Delete Job */
  public static void sampleDeleteJob(String projectId, String tenantId, String jobId) {
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      JobName name = JobWithTenantName.of(projectId, tenantId, jobId);
      DeleteJobRequest request = DeleteJobRequest.newBuilder().setName(name.toString()).build();
      jobServiceClient.deleteJob(request);
      System.out.println("Deleted job.");
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END job_search_delete_job]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("job_id").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String tenantId = cl.getOptionValue("tenant_id", "Your Tenant ID (using tenancy is optional)");
    String jobId = cl.getOptionValue("job_id", "Company ID");

    sampleDeleteJob(projectId, tenantId, jobId);
  }
}
