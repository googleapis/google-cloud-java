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

package com.example.asset;

// [START asset_quickstart_analyze_iam_policy]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.asset.v1.AnalyzeIamPolicyRequest;
import com.google.cloud.asset.v1.AnalyzeIamPolicyResponse;
import com.google.cloud.asset.v1.AssetServiceClient;
import com.google.cloud.asset.v1.IamPolicyAnalysisQuery;
import com.google.cloud.asset.v1.IamPolicyAnalysisQuery.Options;
import com.google.cloud.asset.v1.IamPolicyAnalysisQuery.ResourceSelector;
import java.io.IOException;

public class AnalyzeIamPolicyExample {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String scope = "organizations/ORG_ID";
    String fullResourceName = "//cloudresourcemanager.googleapis.com/projects/PROJ_ID";
    analyzeIamPolicy(scope, fullResourceName);
  }

  // Analyzes accessible IAM policies that match a request.
  public static void analyzeIamPolicy(String scope, String fullResourceName) {
    ResourceSelector resourceSelector =
        ResourceSelector.newBuilder().setFullResourceName(fullResourceName).build();
    Options options = Options.newBuilder().setExpandGroups(true).setOutputGroupEdges(true).build();
    IamPolicyAnalysisQuery query =
        IamPolicyAnalysisQuery.newBuilder()
            .setScope(scope)
            .setResourceSelector(resourceSelector)
            .setOptions(options)
            .build();
    AnalyzeIamPolicyRequest request =
        AnalyzeIamPolicyRequest.newBuilder().setAnalysisQuery(query).build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AssetServiceClient client = AssetServiceClient.create()) {
      AnalyzeIamPolicyResponse response = client.analyzeIamPolicy(request);
      System.out.println("Analyze completed successfully:\n" + response);
    } catch (IOException e) {
      System.out.println("Failed to create client:\n" + e.toString());
    } catch (ApiException e) {
      System.out.println("Error during AnalyzeIamPolicy:\n" + e.toString());
    }
  }
}
// [END asset_quickstart_analyze_iam_policy]
