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
import com.google.privacy.dlp.v2.CloudStorageOptions;
import com.google.privacy.dlp.v2.CreateJobTriggerRequest;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectJobConfig;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.Likelihood;
import com.google.privacy.dlp.v2.ListJobTriggersRequest;
import com.google.privacy.dlp.v2.ProjectJobTriggerName;
import com.google.privacy.dlp.v2.ProjectName;
import com.google.privacy.dlp.v2.Schedule;
import com.google.privacy.dlp.v2.StorageConfig;
import com.google.privacy.dlp.v2.StorageConfig.TimespanConfig;
import com.google.protobuf.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Triggers {

  // [START dlp_create_trigger]
  /**
   * Schedule a DLP inspection trigger for a GCS location.
   *
   * @param triggerId (Optional) name of the trigger to be created
   * @param displayName (Optional) display name for the trigger to be created
   * @param description (Optional) description for the trigger to be created
   * @param autoPopulateTimespan If true, limits scans to new content only.
   * @param scanPeriod How often to wait between scans, in days (minimum = 1 day)
   * @param infoTypes infoTypes of information to match eg. InfoType.PHONE_NUMBER,
   *     InfoType.EMAIL_ADDRESS
   * @param minLikelihood minimum likelihood required before returning a match
   * @param maxFindings maximum number of findings to report per request (0 = server maximum)
   * @param projectId The project ID to run the API call under
   */
  private static void createTrigger(
      String triggerId,
      String displayName,
      String description,
      String bucketName,
      String fileName,
      boolean autoPopulateTimespan,
      int scanPeriod,
      List<InfoType> infoTypes,
      Likelihood minLikelihood,
      int maxFindings,
      String projectId)
      throws Exception {

    // instantiate a client
    DlpServiceClient dlpServiceClient = DlpServiceClient.create();
    try {

      CloudStorageOptions cloudStorageOptions =
          CloudStorageOptions.newBuilder()
              .setFileSet(
                  CloudStorageOptions.FileSet.newBuilder()
                      .setUrl("gs://" + bucketName + "/" + fileName))
              .build();

      TimespanConfig timespanConfig = TimespanConfig.newBuilder()
          .setEnableAutoPopulationOfTimespanConfig(autoPopulateTimespan).build();

      StorageConfig storageConfig =
          StorageConfig.newBuilder().setCloudStorageOptions(cloudStorageOptions)
              .setTimespanConfig(timespanConfig).build();

      InspectConfig.FindingLimits findingLimits =
          InspectConfig.FindingLimits.newBuilder().setMaxFindingsPerRequest(maxFindings).build();

      InspectConfig inspectConfig =
          InspectConfig.newBuilder()
              .addAllInfoTypes(infoTypes)
              .setMinLikelihood(minLikelihood)
              .setLimits(findingLimits)
              .build();

      InspectJobConfig inspectJobConfig =
          InspectJobConfig.newBuilder()
              .setInspectConfig(inspectConfig)
              .setStorageConfig(storageConfig)
              .build();

      // Schedule scan of GCS bucket every scanPeriod number of days (minimum = 1 day)
      Duration duration = Duration.newBuilder().setSeconds(scanPeriod * 24 * 3600).build();
      Schedule schedule = Schedule.newBuilder().setRecurrencePeriodDuration(duration).build();
      JobTrigger.Trigger trigger = JobTrigger.Trigger.newBuilder().setSchedule(schedule).build();
      JobTrigger jobTrigger =
          JobTrigger.newBuilder()
              .setInspectJob(inspectJobConfig)
              .setName(triggerId)
              .setDisplayName(displayName)
              .setDescription(description)
              .setStatus(JobTrigger.Status.HEALTHY)
              .addTriggers(trigger)
              .build();

      // Create scan request
      CreateJobTriggerRequest createJobTriggerRequest =
          CreateJobTriggerRequest.newBuilder()
              .setParent(ProjectName.of(projectId).toString())
              .setJobTrigger(jobTrigger)
              .build();

      JobTrigger createdJobTrigger = dlpServiceClient.createJobTrigger(createJobTriggerRequest);

      System.out.println("Created Trigger: " + createdJobTrigger.getName());
    } catch (Exception e) {
      System.out.println("Error creating trigger: " + e.getMessage());
    }
  }
  // [END dlp_create_trigger]

  // [START dlp_list_triggers]
  /**
   * List all DLP triggers for a given project.
   *
   * @param projectId The project ID to run the API call under.
   */
  private static void listTriggers(String projectId) {
    // Instantiates a client
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      ListJobTriggersRequest listJobTriggersRequest =
          ListJobTriggersRequest.newBuilder()
              .setParent(ProjectName.of(projectId).toString())
              .build();
      DlpServiceClient.ListJobTriggersPagedResponse response =
          dlpServiceClient.listJobTriggers(listJobTriggersRequest);
      response
          .getPage()
          .getValues()
          .forEach(
              trigger -> {
                System.out.println("Trigger: " + trigger.getName());
                System.out.println("\tCreated: " + trigger.getCreateTime());
                System.out.println("\tUpdated: " + trigger.getUpdateTime());
                if (trigger.getDisplayName() != null) {
                  System.out.println("\tDisplay name: " + trigger.getDisplayName());
                }
                if (trigger.getDescription() != null) {
                  System.out.println("\tDescription: " + trigger.getDescription());
                }
                System.out.println("\tStatus: " + trigger.getStatus());
                System.out.println("\tError count: " + trigger.getErrorsCount());
              });
    } catch (Exception e) {
      System.out.println("Error listing triggers :" + e.getMessage());
    }
  }
  // [END dlp_list_triggers]

  // [START dlp_delete_trigger]
  /**
   * Delete a DLP trigger in a project.
   *
   * @param projectId The project ID to run the API call under.
   * @param triggerId Trigger ID
   */
  private static void deleteTrigger(String projectId, String triggerId) {

    ProjectJobTriggerName triggerName = ProjectJobTriggerName.of(projectId, triggerId);
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      DeleteJobTriggerRequest deleteJobTriggerRequest =
          DeleteJobTriggerRequest.newBuilder().setName(triggerName.toString()).build();
      dlpServiceClient.deleteJobTrigger(deleteJobTriggerRequest);

      System.out.println("Trigger deleted: " + triggerName.toString());
    } catch (Exception e) {
      System.out.println("Error deleting trigger :" + e.getMessage());
    }
  }
  // [END dlp_delete_trigger]

  /** Command line application to crate, list and delete triggers. */
  public static void main(String[] args) throws Exception {

    OptionGroup optionsGroup = new OptionGroup();
    optionsGroup.setRequired(true);

    Option createTriggerOption =
        new Option("c", "create", false, "Create trigger to scan a GCS bucket");
    optionsGroup.addOption(createTriggerOption);

    Option listTriggersOption = new Option("l", "list", false, "List triggers");
    optionsGroup.addOption(listTriggersOption);

    Option deleteTriggerOption = new Option("d", "delete", false, "Delete trigger");
    optionsGroup.addOption(deleteTriggerOption);

    Options commandLineOptions = new Options();
    commandLineOptions.addOptionGroup(optionsGroup);

    Option bucketNameOption = Option.builder("bucketName").hasArg(true).required(false).build();
    commandLineOptions.addOption(bucketNameOption);

    Option gcsFileNameOption = Option.builder("fileName").hasArg(true).required(false).build();
    commandLineOptions.addOption(gcsFileNameOption);

    Option autoPopulateTimespanOption = Option.builder("autoPopulateTimespan").required(false)
        .build();
    commandLineOptions.addOption(autoPopulateTimespanOption);

    Option minLikelihoodOption =
        Option.builder("minLikelihood").hasArg(true).required(false).build();

    commandLineOptions.addOption(minLikelihoodOption);

    Option maxFindingsOption = Option.builder("maxFindings").hasArg(true).required(false).build();

    commandLineOptions.addOption(maxFindingsOption);

    Option infoTypesOption = Option.builder("infoTypes").hasArg(true).required(false).build();
    infoTypesOption.setArgs(Option.UNLIMITED_VALUES);
    commandLineOptions.addOption(infoTypesOption);

    Option projectIdOption = Option.builder("projectId").hasArg(true).required(false).build();
    commandLineOptions.addOption(projectIdOption);

    Option triggerIdOption = Option.builder("triggerId").hasArg(true).required(false).build();
    commandLineOptions.addOption(triggerIdOption);
    Option displayNameOption = Option.builder("displayName").hasArg(true).required(false).build();
    commandLineOptions.addOption(displayNameOption);
    Option descriptionOption = Option.builder("description").hasArg(true).required(false).build();
    commandLineOptions.addOption(descriptionOption);

    Option scanPeriodOption = Option.builder("scanPeriod").hasArg(true).required(false).build();
    commandLineOptions.addOption(scanPeriodOption);

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();
    CommandLine cmd;

    try {
      cmd = parser.parse(commandLineOptions, args);
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      formatter.printHelp(DeIdentification.class.getName(), commandLineOptions);
      System.exit(1);
      return;
    }

    String projectId =
        cmd.getOptionValue(projectIdOption.getOpt(), ServiceOptions.getDefaultProjectId());
    if (cmd.hasOption("c")) {
      Likelihood minLikelihood =
          Likelihood.valueOf(
              cmd.getOptionValue(
                  minLikelihoodOption.getOpt(), Likelihood.LIKELIHOOD_UNSPECIFIED.name()));
      int maxFindings = Integer.parseInt(cmd.getOptionValue(maxFindingsOption.getOpt(), "0"));
      String triggerId = cmd.getOptionValue(triggerIdOption.getOpt());
      String displayName = cmd.getOptionValue(displayNameOption.getOpt(), "");
      String description = cmd.getOptionValue(descriptionOption.getOpt(), "");
      String bucketName = cmd.getOptionValue(bucketNameOption.getOpt());
      String fileName = cmd.getOptionValue(gcsFileNameOption.getOpt());
      boolean autoPopulateTimespan = Boolean
          .valueOf(cmd.getOptionValue(autoPopulateTimespanOption.getOpt()));
      int scanPeriod = Integer.valueOf(cmd.getOptionValue(scanPeriodOption.getOpt()));
      List<InfoType> infoTypesList = new ArrayList<>();
      if (cmd.hasOption(infoTypesOption.getOpt())) {
        infoTypesList = new ArrayList<>();
        String[] infoTypes = cmd.getOptionValues(infoTypesOption.getOpt());
        for (String infoType : infoTypes) {
          infoTypesList.add(InfoType.newBuilder().setName(infoType).build());
        }
      }
      createTrigger(
          triggerId,
          displayName,
          description,
          bucketName,
          fileName,
          autoPopulateTimespan,
          scanPeriod,
          infoTypesList,
          minLikelihood,
          maxFindings,
          projectId);
    } else if (cmd.hasOption("l")) {
      // list triggers
      listTriggers(projectId);
    } else if (cmd.hasOption("d")) {
      String triggerId = cmd.getOptionValue(triggerIdOption.getOpt());
      deleteTrigger(projectId, triggerId);
    }
  }
}
