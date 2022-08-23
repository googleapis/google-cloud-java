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

package com.google.cloud.dataproc.v1.stub.samples;

// [START dataproc_v1_generated_batchcontrollerstubsettings_getbatch_sync]
import com.google.cloud.dataproc.v1.stub.BatchControllerStubSettings;
import java.time.Duration;

public class SyncGetBatch {

  public static void main(String[] args) throws Exception {
    syncGetBatch();
  }

  public static void syncGetBatch() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    BatchControllerStubSettings.Builder batchControllerSettingsBuilder =
        BatchControllerStubSettings.newBuilder();
    batchControllerSettingsBuilder
        .getBatchSettings()
        .setRetrySettings(
            batchControllerSettingsBuilder
                .getBatchSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    BatchControllerStubSettings batchControllerSettings = batchControllerSettingsBuilder.build();
  }
}
// [END dataproc_v1_generated_batchcontrollerstubsettings_getbatch_sync]
