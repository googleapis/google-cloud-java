/*
 * Copyright 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.dlp;

import com.google.cloud.ServiceOptions;
import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.DlpJobName;
import com.google.privacy.dlp.v2.DlpJobType;
import com.google.privacy.dlp.v2.ListDlpJobsRequest;
import com.google.privacy.dlp.v2.ProjectName;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Jobs {

  // [START dlp_list_jobs]
  /*
   * List DLP jobs
   *
   * @param projectId The project ID to run the API call under
   * @param filter The filter expression to use, eg. state=DONE For more information on filter
   *     syntax see https://cloud.google.com/dlp/docs/reference/rest/v2/projects.dlpJobs/list
   * @param jobType The type of job to list (either 'INSPECT_JOB' or 'RISK_ANALYSIS_JOB')
   */
  private static void listJobs(String projectId, String filter, DlpJobType jobType)
      throws Exception {
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      ListDlpJobsRequest listDlpJobsRequest =
          ListDlpJobsRequest.newBuilder()
              .setParent(ProjectName.of(projectId).toString())
              .setFilter(filter)
              .setType(jobType)
              .build();
      DlpServiceClient.ListDlpJobsPagedResponse response =
          dlpServiceClient.listDlpJobs(listDlpJobsRequest);
      for (DlpJob dlpJob : response.getPage().getValues()) {
        System.out.println(dlpJob.getName() + " -- " + dlpJob.getState());
      }
    }
  }
  // [END dlp_list_jobs]

  /**
   * Delete a DLP Job
   *
   * @param projectId Google Cloud ProjectID
   * @param jobId DLP Job ID
   */
  // [START dlp_delete_job]
  private static void deleteJob(String projectId, String jobId) {

    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      // construct complete job name
      DlpJobName job = DlpJobName.of(projectId, jobId);

      DeleteDlpJobRequest deleteDlpJobRequest =
          DeleteDlpJobRequest.newBuilder().setName(job.toString()).build();

      // submit job deletion request
      dlpServiceClient.deleteDlpJob(deleteDlpJobRequest);

      System.out.println("Job deleted successfully.");
    } catch (Exception e) {
      System.err.println("Error deleting DLP job: " + e.getMessage());
    }
  }
  // [END dlp_delete_job]

  /** Command line application to list and delete DLP jobs the Data Loss Prevention API. */
  public static void main(String[] args) throws Exception {

    OptionGroup optionsGroup = new OptionGroup();
    optionsGroup.setRequired(true);
    Option listOption = new Option("l", "list", false, "List DLP Jobs");
    optionsGroup.addOption(listOption);

    Option deleteOption = new Option("d", "delete", false, "Delete DLP Jobs");
    optionsGroup.addOption(deleteOption);

    Options commandLineOptions = new Options();
    commandLineOptions.addOptionGroup(optionsGroup);

    Option projectIdOption = Option.builder("projectId").hasArg(true).required(false).build();
    commandLineOptions.addOption(projectIdOption);

    Option filterOption = Option.builder("filter").hasArg(true).required(false).build();
    commandLineOptions.addOption(filterOption);

    Option jobTypeOption = Option.builder("jobType").hasArg(true).required(false).build();
    commandLineOptions.addOption(jobTypeOption);

    Option jobIdOption = Option.builder("jobId").hasArg(true).required(false).build();
    commandLineOptions.addOption(jobIdOption);

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    CommandLine cmd;

    try {
      cmd = parser.parse(commandLineOptions, args);
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      formatter.printHelp(Inspect.class.getName(), commandLineOptions);
      System.exit(1);
      return;
    }

    String projectId =
        cmd.getOptionValue(projectIdOption.getOpt(), ServiceOptions.getDefaultProjectId());

    if (cmd.hasOption(listOption.getOpt())) {
      String filter = cmd.getOptionValue(filterOption.getOpt(), "");
      DlpJobType jobType =
          DlpJobType.valueOf(
              cmd.getOptionValue(
                  jobTypeOption.getOpt(), DlpJobType.DLP_JOB_TYPE_UNSPECIFIED.name()));
      listJobs(projectId, filter, jobType);
    }

    if (cmd.hasOption(deleteOption.getOpt())) {
      String jobId = cmd.getOptionValue(jobIdOption.getOpt());
      deleteJob(projectId, jobId);
    }
  }
}
