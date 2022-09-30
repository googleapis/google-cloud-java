/*
 * Copyright 2022 Google LLC
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

// [START asset_quickstart_batch_get_effective_iam_policy]
// Imports the Google Cloud client library

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.asset.v1.AssetServiceClient;
import com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesRequest;
import com.google.cloud.asset.v1.BatchGetEffectiveIamPoliciesResponse;
import java.io.IOException;
import java.util.Arrays;

/** Batch get effective iam policy example. */
public class BatchGetEffectiveIamPolicyExample {

  /**
   * Batch get effective iam policies specified list of resources within accessible scope, such as a
   * project, folder or organization.
   *
   * @param resourceNames a string array denoting full resource names.
   * @param scope a string denoting scope, which can be a Project, Folder or Organization.
   */
  public static void batchGetEffectiveIamPolicies(String[] resourceNames, String scope) {
    BatchGetEffectiveIamPoliciesRequest request =
        BatchGetEffectiveIamPoliciesRequest.newBuilder()
            .setScope(scope)
            .addAllNames(Arrays.asList(resourceNames))
            .build();
    try (AssetServiceClient client = AssetServiceClient.create()) {
      BatchGetEffectiveIamPoliciesResponse response = client.batchGetEffectiveIamPolicies(request);
      System.out.println("BatchGetEffectiveIamPolicies completed successfully:\n" + response);
    } catch (IOException e) {
      System.out.println("Failed to create client:\n" + e);
    } catch (ApiException e) {
      System.out.println("Error during BatchGetEffectiveIamPolicies:\n" + e);
    }
  }
}
// [END asset_quickstart_batch_get_effective_iam_policy]
