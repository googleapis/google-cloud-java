/*
 * Copyright 2020 Google LLC
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

package dlp.snippets;

// [START dlp_create_trigger]

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.CloudStorageOptions;
import com.google.privacy.dlp.v2.CreateJobTriggerRequest;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectJobConfig;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.LocationName;
import com.google.privacy.dlp.v2.Schedule;
import com.google.privacy.dlp.v2.StorageConfig;
import com.google.privacy.dlp.v2.StorageConfig.TimespanConfig;
import com.google.protobuf.Duration;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriggersCreate {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String gcsPath = "gs://" + "your-bucket-name" + "path/to/file.txt";
    createTrigger(projectId, gcsPath);
  }

  public static void createTrigger(String projectId, String gcsPath) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {

      // Set autoPopulateTimespan to true to scan only new content
      boolean autoPopulateTimespan = true;
      TimespanConfig timespanConfig =
          TimespanConfig.newBuilder()
              .setEnableAutoPopulationOfTimespanConfig(autoPopulateTimespan)
              .build();

      // Specify the GCS file to be inspected.
      CloudStorageOptions cloudStorageOptions =
          CloudStorageOptions.newBuilder()
              .setFileSet(CloudStorageOptions.FileSet.newBuilder().setUrl(gcsPath))
              .build();
      StorageConfig storageConfig =
          StorageConfig.newBuilder()
              .setCloudStorageOptions(cloudStorageOptions)
              .setTimespanConfig(timespanConfig)
              .build();

      // Specify the type of info the inspection will look for.
      // See https://cloud.google.com/dlp/docs/infotypes-reference for complete list of info types
      List<InfoType> infoTypes =
          Stream.of("PHONE_NUMBER", "EMAIL_ADDRESS", "CREDIT_CARD_NUMBER")
              .map(it -> InfoType.newBuilder().setName(it).build())
              .collect(Collectors.toList());

      InspectConfig inspectConfig = InspectConfig.newBuilder().addAllInfoTypes(infoTypes).build();

      // Configure the inspection job we want the service to perform.
      InspectJobConfig inspectJobConfig =
          InspectJobConfig.newBuilder()
              .setInspectConfig(inspectConfig)
              .setStorageConfig(storageConfig)
              .build();

      // Set scanPeriod to the number of days between scans (minimum: 1 day)
      int scanPeriod = 1;

      // Optionally set a display name of max 100 chars and a description of max 250 chars
      String displayName = "Daily Scan";
      String description = "A daily inspection for personally identifiable information.";

      // Schedule scan of GCS bucket every scanPeriod number of days (minimum = 1 day)
      Duration duration = Duration.newBuilder().setSeconds(scanPeriod * 24 * 3600).build();
      Schedule schedule = Schedule.newBuilder().setRecurrencePeriodDuration(duration).build();
      JobTrigger.Trigger trigger = JobTrigger.Trigger.newBuilder().setSchedule(schedule).build();
      JobTrigger jobTrigger =
          JobTrigger.newBuilder()
              .setInspectJob(inspectJobConfig)
              .setDisplayName(displayName)
              .setDescription(description)
              .setStatus(JobTrigger.Status.HEALTHY)
              .addTriggers(trigger)
              .build();

      // Create scan request to be sent by client
      CreateJobTriggerRequest createJobTriggerRequest =
          CreateJobTriggerRequest.newBuilder()
              .setParent(LocationName.of(projectId, "global").toString())
              .setJobTrigger(jobTrigger)
              .build();

      // Send the scan request and process the response
      JobTrigger createdJobTrigger = dlpServiceClient.createJobTrigger(createJobTriggerRequest);

      System.out.println("Created Trigger: " + createdJobTrigger.getName());
      System.out.println("Display Name: " + createdJobTrigger.getDisplayName());
      System.out.println("Description: " + createdJobTrigger.getDescription());
    }
  }
}
// [END dlp_create_trigger]
