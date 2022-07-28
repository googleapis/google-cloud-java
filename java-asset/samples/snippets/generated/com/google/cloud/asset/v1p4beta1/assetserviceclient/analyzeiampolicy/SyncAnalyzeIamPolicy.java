/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.asset.v1p4beta1.samples;

// [START asset_v1p4beta1_generated_assetserviceclient_analyzeiampolicy_sync]
import com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest;
import com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse;
import com.google.cloud.asset.v1p4beta1.AssetServiceClient;
import com.google.cloud.asset.v1p4beta1.IamPolicyAnalysisQuery;

public class SyncAnalyzeIamPolicy {

  public static void main(String[] args) throws Exception {
    syncAnalyzeIamPolicy();
  }

  public static void syncAnalyzeIamPolicy() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
      AnalyzeIamPolicyRequest request =
          AnalyzeIamPolicyRequest.newBuilder()
              .setAnalysisQuery(IamPolicyAnalysisQuery.newBuilder().build())
              .setOptions(AnalyzeIamPolicyRequest.Options.newBuilder().build())
              .build();
      AnalyzeIamPolicyResponse response = assetServiceClient.analyzeIamPolicy(request);
    }
  }
}
// [END asset_v1p4beta1_generated_assetserviceclient_analyzeiampolicy_sync]
