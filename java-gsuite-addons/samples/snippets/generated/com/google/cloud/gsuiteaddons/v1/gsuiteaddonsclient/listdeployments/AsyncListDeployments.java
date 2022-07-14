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

package com.google.cloud.gsuiteaddons.v1.samples;

// [START gsuiteaddons_v1_generated_gsuiteaddonsclient_listdeployments_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.gsuiteaddons.v1.Deployment;
import com.google.cloud.gsuiteaddons.v1.GSuiteAddOnsClient;
import com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest;
import com.google.cloud.gsuiteaddons.v1.ProjectName;

public class AsyncListDeployments {

  public static void main(String[] args) throws Exception {
    asyncListDeployments();
  }

  public static void asyncListDeployments() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (GSuiteAddOnsClient gSuiteAddOnsClient = GSuiteAddOnsClient.create()) {
      ListDeploymentsRequest request =
          ListDeploymentsRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<Deployment> future =
          gSuiteAddOnsClient.listDeploymentsPagedCallable().futureCall(request);
      // Do something.
      for (Deployment element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END gsuiteaddons_v1_generated_gsuiteaddonsclient_listdeployments_async]
