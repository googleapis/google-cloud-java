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

package com.google.cloud.retail.v2beta.samples;

// [START retail_v2beta_generated_ControlService_CreateControl_sync]
import com.google.cloud.retail.v2beta.CatalogName;
import com.google.cloud.retail.v2beta.Control;
import com.google.cloud.retail.v2beta.ControlServiceClient;
import com.google.cloud.retail.v2beta.CreateControlRequest;

public class SyncCreateControl {

  public static void main(String[] args) throws Exception {
    syncCreateControl();
  }

  public static void syncCreateControl() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
      CreateControlRequest request =
          CreateControlRequest.newBuilder()
              .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setControl(Control.newBuilder().build())
              .setControlId("controlId-395080872")
              .build();
      Control response = controlServiceClient.createControl(request);
    }
  }
}
// [END retail_v2beta_generated_ControlService_CreateControl_sync]
