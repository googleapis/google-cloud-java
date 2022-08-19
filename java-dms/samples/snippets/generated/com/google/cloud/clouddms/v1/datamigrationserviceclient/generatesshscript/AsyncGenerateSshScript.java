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

package com.google.cloud.clouddms.v1.samples;

// [START clouddms_v1_generated_datamigrationserviceclient_generatesshscript_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.clouddms.v1.DataMigrationServiceClient;
import com.google.cloud.clouddms.v1.GenerateSshScriptRequest;
import com.google.cloud.clouddms.v1.MigrationJobName;
import com.google.cloud.clouddms.v1.SshScript;

public class AsyncGenerateSshScript {

  public static void main(String[] args) throws Exception {
    asyncGenerateSshScript();
  }

  public static void asyncGenerateSshScript() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (DataMigrationServiceClient dataMigrationServiceClient =
        DataMigrationServiceClient.create()) {
      GenerateSshScriptRequest request =
          GenerateSshScriptRequest.newBuilder()
              .setMigrationJob(
                  MigrationJobName.of("[PROJECT]", "[LOCATION]", "[MIGRATION_JOB]").toString())
              .setVm("vm3767")
              .setVmPort(563010825)
              .build();
      ApiFuture<SshScript> future =
          dataMigrationServiceClient.generateSshScriptCallable().futureCall(request);
      // Do something.
      SshScript response = future.get();
    }
  }
}
// [END clouddms_v1_generated_datamigrationserviceclient_generatesshscript_async]
