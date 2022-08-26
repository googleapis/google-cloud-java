/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jobs;

// [START job_search_create_client_event]

import com.google.cloud.talent.v4.ClientEvent;
import com.google.cloud.talent.v4.CreateClientEventRequest;
import com.google.cloud.talent.v4.EventServiceClient;
import com.google.cloud.talent.v4.JobEvent;
import com.google.cloud.talent.v4.TenantName;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JobSearchCreateClientEvent {

  public static void createClientEvent() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String tenantId = "your-tenant-id";
    String requestId = "your-req-id-from-response-metadata";
    String eventId = "your-unique-identifier-id";
    createClientEvent(projectId, tenantId, requestId, eventId);
  }

  // Creates a client event.
  public static void createClientEvent(
      String projectId, String tenantId, String requestId, String eventId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (EventServiceClient eventServiceClient = EventServiceClient.create()) {
      TenantName parent = TenantName.of(projectId, tenantId);

      // The timestamp of the event as seconds of UTC time since Unix epoch
      // For more information on how to create google.protobuf.Timestamps
      // See:
      // https://github.com/protocolbuffers/protobuf/blob/master/src/google/protobuf/timestamp.proto
      long seconds = 3L;
      Timestamp createTime = Timestamp.newBuilder().setSeconds(seconds).build();

      // The type of event attributed to the behavior of the end user
      JobEvent.JobEventType type = JobEvent.JobEventType.VIEW;

      // List of job names associated with this event
      String jobsElement = "projects/[Project ID]/tenants/[Tenant ID]/jobs/[Job ID]";
      String jobsElement2 = "projects/[Project ID]/tenants/[Tenant ID]/jobs/[Job ID]";

      List<String> jobs = Arrays.asList(jobsElement, jobsElement2);
      JobEvent jobEvent = JobEvent.newBuilder().setType(type).addAllJobs(jobs).build();
      ClientEvent clientEvent =
          ClientEvent.newBuilder()
              .setRequestId(requestId)
              .setEventId(eventId)
              .setCreateTime(createTime)
              .setJobEvent(jobEvent)
              .build();
      CreateClientEventRequest request =
          CreateClientEventRequest.newBuilder()
              .setParent(parent.toString())
              .setClientEvent(clientEvent)
              .build();
      ClientEvent response = eventServiceClient.createClientEvent(request);
      System.out.println("Created client event. ");
      System.out.println(response.toString());
    }
  }
}
// [END job_search_create_client_event]
