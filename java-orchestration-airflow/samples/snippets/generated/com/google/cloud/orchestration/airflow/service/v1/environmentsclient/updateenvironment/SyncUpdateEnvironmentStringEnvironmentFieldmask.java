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

package com.google.cloud.orchestration.airflow.service.v1.samples;

// [START service_v1_generated_environmentsclient_updateenvironment_stringenvironmentfieldmask_sync]
import com.google.cloud.orchestration.airflow.service.v1.Environment;
import com.google.cloud.orchestration.airflow.service.v1.EnvironmentsClient;
import com.google.protobuf.FieldMask;

public class SyncUpdateEnvironmentStringEnvironmentFieldmask {

  public static void main(String[] args) throws Exception {
    syncUpdateEnvironmentStringEnvironmentFieldmask();
  }

  public static void syncUpdateEnvironmentStringEnvironmentFieldmask() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (EnvironmentsClient environmentsClient = EnvironmentsClient.create()) {
      String name = "name3373707";
      Environment environment = Environment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      Environment response =
          environmentsClient.updateEnvironmentAsync(name, environment, updateMask).get();
    }
  }
}
// [END service_v1_generated_environmentsclient_updateenvironment_stringenvironmentfieldmask_sync]
