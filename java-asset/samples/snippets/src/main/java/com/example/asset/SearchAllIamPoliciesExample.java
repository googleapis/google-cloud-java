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

// [START asset_quickstart_search_all_iam_policies]
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.asset.v1.AssetServiceClient;
import com.google.cloud.asset.v1.AssetServiceClient.SearchAllIamPoliciesPagedResponse;
import com.google.cloud.asset.v1.SearchAllIamPoliciesRequest;
import java.io.IOException;

public class SearchAllIamPoliciesExample {

  // Searches for all the iam policies within the given scope.
  public static void searchAllIamPolicies(String scope, String query) {
    // TODO(developer): Replace these variables before running the sample.
    int pageSize = 0;
    String pageToken = "";

    SearchAllIamPoliciesRequest request =
        SearchAllIamPoliciesRequest.newBuilder()
            .setScope(scope)
            .setQuery(query)
            .setPageSize(pageSize)
            .setPageToken(pageToken)
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AssetServiceClient client = AssetServiceClient.create()) {
      SearchAllIamPoliciesPagedResponse response = client.searchAllIamPolicies(request);
      System.out.println("Search completed successfully:\n" + response.getPage().getValues());
    } catch (IOException e) {
      System.out.println(String.format("Failed to create client:%n%s", e.toString()));
    } catch (InvalidArgumentException e) {
      System.out.println(String.format("Invalid request:%n%s", e.toString()));
    } catch (ApiException e) {
      System.out.println(String.format("Error during SearchAllIamPolicies:%n%s", e.toString()));
    }
  }
}
// [END asset_quickstart_search_all_iam_policies]
