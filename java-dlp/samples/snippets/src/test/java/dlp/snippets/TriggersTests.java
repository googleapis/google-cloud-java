/*
 * Copyright 2020 Google Inc.
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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.common.collect.ImmutableList;
import com.google.privacy.dlp.v2.CloudStorageOptions;
import com.google.privacy.dlp.v2.CreateJobTriggerRequest;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectJobConfig;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.LocationName;
import com.google.privacy.dlp.v2.Schedule;
import com.google.privacy.dlp.v2.StorageConfig;
import com.google.protobuf.Duration;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TriggersTests extends TestBase {

  @Override
  protected ImmutableList<String> requiredEnvVars() {
    return ImmutableList.of("GOOGLE_APPLICATION_CREDENTIALS", "GOOGLE_CLOUD_PROJECT", "GCS_PATH");
  }

  private static JobTrigger createTrigger() throws IOException {
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      CloudStorageOptions cloudStorageOptions =
          CloudStorageOptions.newBuilder()
              .setFileSet(CloudStorageOptions.FileSet.newBuilder().setUrl(GCS_PATH))
              .build();
      StorageConfig storageConfig =
          StorageConfig.newBuilder().setCloudStorageOptions(cloudStorageOptions).build();

      InspectJobConfig inspectJobConfig =
          InspectJobConfig.newBuilder()
              .setInspectConfig(InspectConfig.newBuilder().build())
              .setStorageConfig(storageConfig)
              .build();

      Duration duration = Duration.newBuilder().setSeconds(24 * 3600).build();
      Schedule schedule = Schedule.newBuilder().setRecurrencePeriodDuration(duration).build();
      JobTrigger.Trigger trigger = JobTrigger.Trigger.newBuilder().setSchedule(schedule).build();
      JobTrigger jobTrigger =
          JobTrigger.newBuilder()
              .setInspectJob(inspectJobConfig)
              .setStatus(JobTrigger.Status.HEALTHY)
              .addTriggers(trigger)
              .build();

      CreateJobTriggerRequest createJobTriggerRequest =
          CreateJobTriggerRequest.newBuilder()
              .setParent(LocationName.of(PROJECT_ID, "global").toString())
              .setJobTrigger(jobTrigger)
              .build();

      return dlpServiceClient.createJobTrigger(createJobTriggerRequest);
    }
  }

  @Test
  public void testCreateTrigger() throws Exception {
    TriggersCreate.createTrigger(PROJECT_ID, GCS_PATH);
    String output = bout.toString();
    assertThat(output).contains("Created Trigger:");

    // Delete the created trigger
    String triggerId = output.split("Created Trigger: ")[1].split("\n")[0];
    DeleteJobTriggerRequest deleteJobTriggerRequest =
        DeleteJobTriggerRequest.newBuilder().setName(triggerId).build();
    try (DlpServiceClient client = DlpServiceClient.create()) {
      client.deleteJobTrigger(deleteJobTriggerRequest);
    }
  }

  @Test
  public void testListTrigger() throws Exception {
    TriggersList.listTriggers(PROJECT_ID);
    String output = bout.toString();
    assertThat(output).contains("DLP triggers found:");
  }

  @Test
  public void testDeleteTrigger() throws Exception {
    JobTrigger trigger = createTrigger();
    String triggerName = trigger.getName();
    String triggerId;

    Matcher matcher = Pattern.compile("jobTriggers/").matcher(triggerName);
    if (matcher.find()) {
      triggerId = triggerName.substring(matcher.end());
    } else {
      throw new Exception("Could not extract triggerID");
    }

    // Delete the job with the specified ID
    TriggersDelete.deleteTrigger(PROJECT_ID, triggerId);
    String output = bout.toString();
    assertThat(output).contains("Trigger deleted:");
  }
}
