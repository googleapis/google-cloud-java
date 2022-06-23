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

package com.google.cloud.lifesciences.v2beta.samples;

// [START
// lifesciences_v2beta_generated_workflowsservicev2betaclient_create_setcredentialsprovider_sync]
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.cloud.lifesciences.v2beta.WorkflowsServiceV2BetaClient;
import com.google.cloud.lifesciences.v2beta.WorkflowsServiceV2BetaSettings;
import com.google.cloud.lifesciences.v2beta.myCredentials;

public class SyncCreateSetCredentialsProvider {

  public static void main(String[] args) throws Exception {
    syncCreateSetCredentialsProvider();
  }

  public static void syncCreateSetCredentialsProvider() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    WorkflowsServiceV2BetaSettings workflowsServiceV2BetaSettings =
        WorkflowsServiceV2BetaSettings.newBuilder()
            .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
            .build();
    WorkflowsServiceV2BetaClient workflowsServiceV2BetaClient =
        WorkflowsServiceV2BetaClient.create(workflowsServiceV2BetaSettings);
  }
}
// [END
// lifesciences_v2beta_generated_workflowsservicev2betaclient_create_setcredentialsprovider_sync]
