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

package com.google.cloud.run.v2.samples;

// [START run_v2_generated_servicessettings_getservice_sync]
import com.google.cloud.run.v2.ServicesSettings;
import java.time.Duration;

public class SyncGetService {

  public static void main(String[] args) throws Exception {
    syncGetService();
  }

  public static void syncGetService() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    ServicesSettings.Builder servicesSettingsBuilder = ServicesSettings.newBuilder();
    servicesSettingsBuilder
        .getServiceSettings()
        .setRetrySettings(
            servicesSettingsBuilder
                .getServiceSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(30))
                .build());
    ServicesSettings servicesSettings = servicesSettingsBuilder.build();
  }
}
// [END run_v2_generated_servicessettings_getservice_sync]
