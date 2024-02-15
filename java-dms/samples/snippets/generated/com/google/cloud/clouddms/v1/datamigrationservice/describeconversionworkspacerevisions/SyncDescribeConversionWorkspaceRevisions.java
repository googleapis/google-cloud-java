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

package com.google.cloud.clouddms.v1.samples;

// [START datamigration_v1_generated_DataMigrationService_DescribeConversionWorkspaceRevisions_sync]
import com.google.cloud.clouddms.v1.ConversionWorkspaceName;
import com.google.cloud.clouddms.v1.DataMigrationServiceClient;
import com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsRequest;
import com.google.cloud.clouddms.v1.DescribeConversionWorkspaceRevisionsResponse;

public class SyncDescribeConversionWorkspaceRevisions {

  public static void main(String[] args) throws Exception {
    syncDescribeConversionWorkspaceRevisions();
  }

  public static void syncDescribeConversionWorkspaceRevisions() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataMigrationServiceClient dataMigrationServiceClient =
        DataMigrationServiceClient.create()) {
      DescribeConversionWorkspaceRevisionsRequest request =
          DescribeConversionWorkspaceRevisionsRequest.newBuilder()
              .setConversionWorkspace(
                  ConversionWorkspaceName.of("[PROJECT]", "[LOCATION]", "[CONVERSION_WORKSPACE]")
                      .toString())
              .setCommitId("commitId-602292046")
              .build();
      DescribeConversionWorkspaceRevisionsResponse response =
          dataMigrationServiceClient.describeConversionWorkspaceRevisions(request);
    }
  }
}
// [END datamigration_v1_generated_DataMigrationService_DescribeConversionWorkspaceRevisions_sync]
