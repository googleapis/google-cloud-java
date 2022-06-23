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

package com.google.cloud.gkemulticloud.v1.samples;

// [START gkemulticloud_v1_generated_azureclustersclient_getazureserverconfig_azureserverconfigname_sync]
import com.google.cloud.gkemulticloud.v1.AzureClustersClient;
import com.google.cloud.gkemulticloud.v1.AzureServerConfig;
import com.google.cloud.gkemulticloud.v1.AzureServerConfigName;

public class SyncGetAzureServerConfigAzureserverconfigname {

  public static void main(String[] args) throws Exception {
    syncGetAzureServerConfigAzureserverconfigname();
  }

  public static void syncGetAzureServerConfigAzureserverconfigname() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
      AzureServerConfigName name = AzureServerConfigName.of("[PROJECT]", "[LOCATION]");
      AzureServerConfig response = azureClustersClient.getAzureServerConfig(name);
    }
  }
}
// [END gkemulticloud_v1_generated_azureclustersclient_getazureserverconfig_azureserverconfigname_sync]
