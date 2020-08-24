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
package com.google.cloud.osconfig.v1.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.api.core.ApiFuture;
import com.google.cloud.ServiceOptions;
import com.google.cloud.osconfig.v1.OsConfigServiceClient;
import com.google.cloud.osconfig.v1.PatchDeploymentName;
import com.google.cloud.osconfig.v1.PatchDeployments;
import com.google.cloud.osconfig.v1.PatchJobs;
import com.google.cloud.osconfig.v1.ProjectName;
import com.google.common.collect.Lists;
import com.google.type.TimeOfDay;
import com.google.type.TimeZone;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.ZoneId;

public class ITSystemTest {

  private static OsConfigServiceClient client;

  private static final String PROJECT = ServiceOptions.getDefaultProjectId();
  private static final String ID = UUID.randomUUID().toString();
  private static final String DESCRIPTION = "description";
  private static final String PATCH_DEPLOYMENT_ID = "pd" + ID.substring(0, 3);
  private static final PatchDeploymentName PATCH_DEPLOYMENT_NAME =
      PatchDeploymentName.of(PROJECT, PATCH_DEPLOYMENT_ID);
  private static final ProjectName PARENT = ProjectName.of(PROJECT);
  private static final PatchJobs.PatchInstanceFilter PATCH_INSTANCE_FILTER =
      PatchJobs.PatchInstanceFilter.newBuilder().setAll(true).build();
  private static final TimeZone TIME_ZONE =
      TimeZone.newBuilder().setId(ZoneId.systemDefault().getId()).build();
  private static final PatchDeployments.RecurringSchedule.Frequency FREQUENCY =
      PatchDeployments.RecurringSchedule.Frequency.MONTHLY;
  private static final PatchDeployments.MonthlySchedule MONTHLY_SCHEDULE =
      PatchDeployments.MonthlySchedule.newBuilder().setMonthDay(1).build();
  private static final TimeOfDay TIME_OF_DAY = TimeOfDay.newBuilder().setHours(1).build();
  private static final PatchDeployments.RecurringSchedule RECURRING_SCHEDULE =
      PatchDeployments.RecurringSchedule.newBuilder()
          .setFrequency(FREQUENCY)
          .setTimeOfDay(TIME_OF_DAY)
          .setTimeZone(TIME_ZONE)
          .setMonthly(MONTHLY_SCHEDULE)
          .build();

  @BeforeClass
  public static void setUp() throws IOException {
    client = OsConfigServiceClient.create();
    PatchDeployments.PatchDeployment patchDeployment =
        PatchDeployments.PatchDeployment.newBuilder()
            .setName(PATCH_DEPLOYMENT_NAME.toString())
            .setInstanceFilter(PATCH_INSTANCE_FILTER)
            .setRecurringSchedule(RECURRING_SCHEDULE)
            .setDescription(DESCRIPTION)
            .build();
    PatchDeployments.CreatePatchDeploymentRequest request =
        PatchDeployments.CreatePatchDeploymentRequest.newBuilder()
            .setParent(PARENT.toString())
            .setPatchDeployment(patchDeployment)
            .setPatchDeploymentId(PATCH_DEPLOYMENT_ID)
            .build();
    client.createPatchDeployment(request);
  }

  @AfterClass
  public static void tearDown() {
    PatchDeployments.DeletePatchDeploymentRequest request =
        PatchDeployments.DeletePatchDeploymentRequest.newBuilder()
            .setName(PATCH_DEPLOYMENT_NAME.toString())
            .build();
    client.deletePatchDeployment(request);
    client.close();
  }

  @Test
  public void getPatchDeploymentTest() {
    PatchDeployments.GetPatchDeploymentRequest getPatchDeploymentRequest =
        PatchDeployments.GetPatchDeploymentRequest.newBuilder()
            .setName(PATCH_DEPLOYMENT_NAME.toString())
            .build();
    PatchDeployments.PatchDeployment response =
        client.getPatchDeployment(getPatchDeploymentRequest);
    assertEquals(PATCH_INSTANCE_FILTER, response.getInstanceFilter());
    assertEquals(DESCRIPTION, response.getDescription());
    assertNotNull(response.getRecurringSchedule());
    assertEquals(TIME_ZONE, response.getRecurringSchedule().getTimeZone());
    assertEquals(TIME_OF_DAY, response.getRecurringSchedule().getTimeOfDay());
    assertEquals(FREQUENCY, response.getRecurringSchedule().getFrequency());
    assertEquals(MONTHLY_SCHEDULE, response.getRecurringSchedule().getMonthly());
    assertNotNull(response.getCreateTime());
  }

  @Test
  public void listPatchDeploymentsTest() {
    PatchDeployments.ListPatchDeploymentsRequest request =
        PatchDeployments.ListPatchDeploymentsRequest.newBuilder()
            .setParent(PARENT.toString())
            .build();
    ArrayList<PatchDeployments.PatchDeployment> patchDeployments =
        Lists.newArrayList(client.listPatchDeployments(request).iterateAll());
    assertEquals(1, patchDeployments.size());
    assertEquals(PATCH_INSTANCE_FILTER, patchDeployments.get(0).getInstanceFilter());
    assertEquals(DESCRIPTION, patchDeployments.get(0).getDescription());
    assertNotNull(patchDeployments.get(0).getRecurringSchedule());
    assertEquals(TIME_ZONE, patchDeployments.get(0).getRecurringSchedule().getTimeZone());
    assertEquals(TIME_OF_DAY, patchDeployments.get(0).getRecurringSchedule().getTimeOfDay());
    assertEquals(FREQUENCY, patchDeployments.get(0).getRecurringSchedule().getFrequency());
    assertEquals(MONTHLY_SCHEDULE, patchDeployments.get(0).getRecurringSchedule().getMonthly());
    assertNotNull(patchDeployments.get(0).getCreateTime());
  }

  @Test
  public void patchJobTest() throws ExecutionException, InterruptedException {
    String patchJobDisplayName = "patch-job-test-" + ID;
    PatchJobs.ExecutePatchJobRequest request =
        PatchJobs.ExecutePatchJobRequest.newBuilder()
            .setDisplayName(patchJobDisplayName)
            .setParent(PARENT.toString())
            .setInstanceFilter(PATCH_INSTANCE_FILTER)
            .build();
    ApiFuture<PatchJobs.PatchJob> future = client.executePatchJobCallable().futureCall(request);
    PatchJobs.PatchJob response = future.get();
    assertNotNull(response);
    assertNotNull(response.getCreateTime());
    assertNotNull(response.getUpdateTime());
    assertEquals(PatchJobs.PatchJob.State.STARTED, response.getState());
    assertEquals(PATCH_INSTANCE_FILTER, response.getInstanceFilter());
    assertEquals(patchJobDisplayName, response.getDisplayName());

    // Get PatchJob
    PatchJobs.GetPatchJobRequest getPatchJobRequest =
        PatchJobs.GetPatchJobRequest.newBuilder().setName(response.getName()).build();
    PatchJobs.PatchJob patchJob = client.getPatchJob(getPatchJobRequest);
    comparePatchJob(response, patchJob);

    // List PatchJob
    PatchJobs.ListPatchJobsRequest listPatchJobsRequest =
        PatchJobs.ListPatchJobsRequest.newBuilder().setParent(PARENT.toString()).build();
    List<PatchJobs.PatchJob> patchJobs =
        Lists.newArrayList(client.listPatchJobs(listPatchJobsRequest).iterateAll());
    for (PatchJobs.PatchJob job : patchJobs) {
      if (job.getName().equals(response.getName())) comparePatchJob(job, response);
    }

    // CancelPatchJob
    PatchJobs.CancelPatchJobRequest cancelPatchJobRequest =
        PatchJobs.CancelPatchJobRequest.newBuilder().setName(response.getName()).build();
    PatchJobs.PatchJob cancelPatchJob = client.cancelPatchJob(cancelPatchJobRequest);
    assertEquals(PatchJobs.PatchJob.State.CANCELED, cancelPatchJob.getState());
  }

  private void comparePatchJob(PatchJobs.PatchJob expected, PatchJobs.PatchJob value) {
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getCreateTime(), value.getCreateTime());
    assertEquals(expected.getUpdateTime(), value.getUpdateTime());
    assertEquals(expected.getState(), value.getState());
    assertEquals(expected.getPatchConfig(), value.getPatchConfig());
    assertEquals(expected.getInstanceFilter(), value.getInstanceFilter());
    assertEquals(expected.getPatchDeployment(), value.getPatchDeployment());
    assertEquals(expected.getDisplayName(), value.getDisplayName());
  }
}
