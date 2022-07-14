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

// [START asset_v1p4beta1_generated_assetserviceclient_exportiampolicyanalysis_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.asset.v1p4beta1.AssetServiceClient;
import com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest;
import com.google.cloud.asset.v1p4beta1.IamPolicyAnalysisOutputConfig;
import com.google.cloud.asset.v1p4beta1.IamPolicyAnalysisQuery;
import com.google.longrunning.Operation;

public class AsyncExportIamPolicyAnalysis {

  public static void main(String[] args) throws Exception {
    asyncExportIamPolicyAnalysis();
  }

  public static void asyncExportIamPolicyAnalysis() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
      ExportIamPolicyAnalysisRequest request =
          ExportIamPolicyAnalysisRequest.newBuilder()
              .setAnalysisQuery(IamPolicyAnalysisQuery.newBuilder().build())
              .setOptions(ExportIamPolicyAnalysisRequest.Options.newBuilder().build())
              .setOutputConfig(IamPolicyAnalysisOutputConfig.newBuilder().build())
              .build();
      ApiFuture<Operation> future =
          assetServiceClient.exportIamPolicyAnalysisCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END asset_v1p4beta1_generated_assetserviceclient_exportiampolicyanalysis_async]
