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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.CloudStorageOptions;
import com.google.privacy.dlp.v2.CreateJobTriggerRequest;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectJobConfig;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.ListJobTriggersRequest;
import com.google.privacy.dlp.v2.ProjectName;
import com.google.privacy.dlp.v2.Schedule;
import com.google.privacy.dlp.v2.StorageConfig;
import com.google.protobuf.Duration;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TriggersTests {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String GCS_PATH = System.getenv("GCS_PATH");

  private ByteArrayOutputStream bout;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        String.format("Environment variable '%s' must be set to perform these tests.", varName),
        System.getenv(varName));
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
              .setParent(ProjectName.of(PROJECT_ID).toString())
              .setJobTrigger(jobTrigger)
              .build();

      return dlpServiceClient.createJobTrigger(createJobTriggerRequest);
    }
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
    requireEnvVar("GCS_PATH");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
  }


  @After
  public void tearDown() {
    System.setOut(null);
    bout.reset();
  }


  @Test
  public void testCreateTrigger() throws Exception {
    TriggersCreate.createTrigger(PROJECT_ID, GCS_PATH);
    String output = bout.toString();
    assertThat(output, CoreMatchers.containsString("Created Trigger:"));

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
    assertThat(output, CoreMatchers.containsString("DLP triggers found:"));
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
    assertThat(output, CoreMatchers.containsString("Trigger deleted:"));
  }
}
