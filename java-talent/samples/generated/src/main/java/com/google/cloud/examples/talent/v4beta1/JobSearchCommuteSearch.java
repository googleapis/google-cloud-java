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
// DO NOT EDIT! This is a generated sample ("RequestPaged",  "job_search_commute_search")
// sample-metadata:
//   title:
//   description: Search Jobs using commute distance
//   usage: gradle run -PmainClass=com.google.cloud.examples.talent.v4beta1.JobSearchCommuteSearch [--args='[--project_id "Your Google Cloud Project ID"] [--tenant_id "Your Tenant ID (using tenancy is optional)"]']

package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.CommuteFilter;
import com.google.cloud.talent.v4beta1.CommuteMethod;
import com.google.cloud.talent.v4beta1.Job;
import com.google.cloud.talent.v4beta1.JobQuery;
import com.google.cloud.talent.v4beta1.JobServiceClient;
import com.google.cloud.talent.v4beta1.RequestMetadata;
import com.google.cloud.talent.v4beta1.SearchJobsRequest;
import com.google.cloud.talent.v4beta1.SearchJobsResponse.MatchingJob;
import com.google.cloud.talent.v4beta1.TenantName;
import com.google.cloud.talent.v4beta1.TenantOrProjectName;
import com.google.protobuf.Duration;
import com.google.type.LatLng;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JobSearchCommuteSearch {
  // [START job_search_commute_search]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.talent.v4beta1.CommuteFilter;
   * import com.google.cloud.talent.v4beta1.CommuteMethod;
   * import com.google.cloud.talent.v4beta1.Job;
   * import com.google.cloud.talent.v4beta1.JobQuery;
   * import com.google.cloud.talent.v4beta1.JobServiceClient;
   * import com.google.cloud.talent.v4beta1.RequestMetadata;
   * import com.google.cloud.talent.v4beta1.SearchJobsRequest;
   * import com.google.cloud.talent.v4beta1.SearchJobsResponse.MatchingJob;
   * import com.google.cloud.talent.v4beta1.TenantName;
   * import com.google.cloud.talent.v4beta1.TenantOrProjectName;
   * import com.google.protobuf.Duration;
   * import com.google.type.LatLng;
   */

  public static void sampleSearchJobs() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "Your Google Cloud Project ID";
    String tenantId = "Your Tenant ID (using tenancy is optional)";
    sampleSearchJobs(projectId, tenantId);
  }

  /** Search Jobs using commute distance */
  public static void sampleSearchJobs(String projectId, String tenantId) {
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      TenantOrProjectName parent = TenantName.of(projectId, tenantId);
      String domain = "www.example.com";
      String sessionId = "Hashed session identifier";
      String userId = "Hashed user identifier";
      RequestMetadata requestMetadata =
          RequestMetadata.newBuilder()
              .setDomain(domain)
              .setSessionId(sessionId)
              .setUserId(userId)
              .build();
      CommuteMethod commuteMethod = CommuteMethod.TRANSIT;
      long seconds = 1800L;
      Duration travelDuration = Duration.newBuilder().setSeconds(seconds).build();
      double latitude = 37.422408;
      double longitude = -122.084068;
      LatLng startCoordinates =
          LatLng.newBuilder().setLatitude(latitude).setLongitude(longitude).build();
      CommuteFilter commuteFilter =
          CommuteFilter.newBuilder()
              .setCommuteMethod(commuteMethod)
              .setTravelDuration(travelDuration)
              .setStartCoordinates(startCoordinates)
              .build();
      JobQuery jobQuery = JobQuery.newBuilder().setCommuteFilter(commuteFilter).build();
      SearchJobsRequest request =
          SearchJobsRequest.newBuilder()
              .setParent(parent.toString())
              .setRequestMetadata(requestMetadata)
              .setJobQuery(jobQuery)
              .build();
      for (SearchJobsResponse.MatchingJob responseItem :
          jobServiceClient.searchJobs(request).iterateAll()) {
        System.out.printf("Job summary: %s\n", responseItem.getJobSummary());
        System.out.printf("Job title snippet: %s\n", responseItem.getJobTitleSnippet());
        Job job = responseItem.getJob();
        System.out.printf("Job name: %s\n", job.getName());
        System.out.printf("Job title: %s\n", job.getTitle());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END job_search_commute_search]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String tenantId = cl.getOptionValue("tenant_id", "Your Tenant ID (using tenancy is optional)");

    sampleSearchJobs(projectId, tenantId);
  }
}
