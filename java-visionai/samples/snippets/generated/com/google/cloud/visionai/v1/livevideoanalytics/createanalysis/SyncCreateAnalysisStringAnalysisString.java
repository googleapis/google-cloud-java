/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.visionai.v1.samples;

// [START visionai_v1_generated_LiveVideoAnalytics_CreateAnalysis_StringAnalysisString_sync]
import com.google.cloud.visionai.v1.Analysis;
import com.google.cloud.visionai.v1.ClusterName;
import com.google.cloud.visionai.v1.LiveVideoAnalyticsClient;

public class SyncCreateAnalysisStringAnalysisString {

  public static void main(String[] args) throws Exception {
    syncCreateAnalysisStringAnalysisString();
  }

  public static void syncCreateAnalysisStringAnalysisString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LiveVideoAnalyticsClient liveVideoAnalyticsClient = LiveVideoAnalyticsClient.create()) {
      String parent = ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString();
      Analysis analysis = Analysis.newBuilder().build();
      String analysisId = "analysisId-944835305";
      Analysis response =
          liveVideoAnalyticsClient.createAnalysisAsync(parent, analysis, analysisId).get();
    }
  }
}
// [END visionai_v1_generated_LiveVideoAnalytics_CreateAnalysis_StringAnalysisString_sync]
