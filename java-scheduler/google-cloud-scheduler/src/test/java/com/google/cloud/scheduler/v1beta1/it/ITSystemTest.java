/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.scheduler.v1beta1.it;

import static org.junit.Assert.assertEquals;

import com.google.api.core.ApiFuture;
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.cloud.scheduler.v1beta1.CloudSchedulerClient;
import com.google.cloud.scheduler.v1beta1.Job;
import com.google.cloud.scheduler.v1beta1.JobName;
import com.google.cloud.scheduler.v1beta1.LocationName;
import com.google.cloud.scheduler.v1beta1.PubsubTarget;
import com.google.cloud.scheduler.v1beta1.RunJobRequest;
import com.google.cloud.scheduler.v1beta1.UpdateJobRequest;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectTopicName;
import java.util.List;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static CloudSchedulerClient client;
  private static TopicAdminClient publisherClient;

  private static final String PROJECT = ServiceOptions.getDefaultProjectId();
  private static final String LOCATION = "us-central1";
  private static final String ID = UUID.randomUUID().toString().substring(0, 8);
  private static final String JOB = "test-job-" + ID;
  private static final String TOPIC = "test-topic-" + ID;
  private static final String SCHEDULE = "* * * * *";
  private static final String TIME_ZONE = "UTC";
  private static final ProjectTopicName TOPIC_NAME = ProjectTopicName.of(PROJECT, TOPIC);
  private static final String JOB_NAME = JobName.of(PROJECT, LOCATION, JOB).toString().trim();
  private static final PubsubTarget PUB_SUB_TARGET =
      PubsubTarget.newBuilder()
          .setTopicName(TOPIC_NAME.toString())
          .setData(ByteString.copyFrom("test".getBytes()))
          .build();
  private static final LocationName PARENT = LocationName.of(PROJECT, LOCATION);

  @BeforeClass
  public static void setUp() throws Exception {

    /* The job will be delivered by publishing a message to the given Pub/Sub topic. */
    publisherClient = TopicAdminClient.create();
    publisherClient.createTopic(TOPIC_NAME);

    client = CloudSchedulerClient.create();
    Job createJob =
        Job.newBuilder()
            .setName(JOB_NAME)
            .setPubsubTarget(PUB_SUB_TARGET)
            .setSchedule(SCHEDULE)
            .setTimeZone(TIME_ZONE)
            .build();
    client.createJob(PARENT, createJob);
  }

  @AfterClass
  public static void tearDown() {
    client.deleteJob(JOB_NAME);
    publisherClient.deleteTopic(TOPIC_NAME);
    publisherClient.close();
    client.close();
  }

  private static void assertJobDetails(Job job) {
    assertEquals(JOB_NAME, job.getName());
    assertEquals(Job.State.ENABLED, job.getState());
    assertEquals(SCHEDULE, job.getSchedule());
    assertEquals(TIME_ZONE, job.getTimeZone());
    assertEquals(PUB_SUB_TARGET, job.getPubsubTarget());
  }

  @Test
  public void getJobTest() {
    Job job = client.getJob(JOB_NAME);
    assertJobDetails(job);
  }

  @Test
  public void listJobsTest() {
    List<Job> jobs = Lists.newArrayList(client.listJobs(PARENT).iterateAll());
    for (Job job : jobs) {
      if (JOB_NAME.equals(job.getName())) {
        assertJobDetails(job);
      }
    }
  }

  @Test
  public void pauseAndResumeJobTest() {
    /* pause Job */
    Job pauseJob = client.pauseJob(JOB_NAME);
    assertEquals(Job.State.PAUSED, pauseJob.getState());
    assertEquals(SCHEDULE, pauseJob.getSchedule());
    assertEquals(TIME_ZONE, pauseJob.getTimeZone());
    assertEquals(PUB_SUB_TARGET, pauseJob.getPubsubTarget());

    /* resume Job */
    Job resumeJob = client.resumeJob(JOB_NAME);
    assertJobDetails(resumeJob);
  }

  @Test
  public void updateJobTest() {
    String timeZone = "PST";
    String schedule = "25 8 * * *";
    Job updateJob =
        Job.newBuilder()
            .setName(JOB_NAME)
            .setPubsubTarget(PUB_SUB_TARGET)
            .setSchedule(schedule)
            .setTimeZone(timeZone)
            .build();
    UpdateJobRequest updateJobRequest = UpdateJobRequest.newBuilder().setJob(updateJob).build();
    Job job = client.updateJob(updateJobRequest);
    assertEquals(JOB_NAME, job.getName());
    assertEquals(PUB_SUB_TARGET, job.getPubsubTarget());
    assertEquals(Job.State.ENABLED, job.getState());
    assertEquals(timeZone, job.getTimeZone());
    assertEquals(schedule, job.getSchedule());
  }

  @Test
  public void runJobTest() throws Exception {
    RunJobRequest jobRequest = RunJobRequest.newBuilder().setName(JOB_NAME).build();
    ApiFuture<Job> job = client.runJobCallable().futureCall(jobRequest);
    while (true) {
      if (job.isDone()) {
        assertJobDetails(job.get());
        break;
      }
    }
  }
}
