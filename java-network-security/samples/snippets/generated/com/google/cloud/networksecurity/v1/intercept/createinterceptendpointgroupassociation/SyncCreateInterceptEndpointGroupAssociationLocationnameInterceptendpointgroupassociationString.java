/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networksecurity.v1.samples;

// [START networksecurity_v1_generated_Intercept_CreateInterceptEndpointGroupAssociation_LocationnameInterceptendpointgroupassociationString_sync]
import com.google.cloud.networksecurity.v1.InterceptClient;
import com.google.cloud.networksecurity.v1.InterceptEndpointGroupAssociation;
import com.google.cloud.networksecurity.v1.LocationName;

public
class SyncCreateInterceptEndpointGroupAssociationLocationnameInterceptendpointgroupassociationString {

  public static void main(String[] args) throws Exception {
    syncCreateInterceptEndpointGroupAssociationLocationnameInterceptendpointgroupassociationString();
  }

  public static void
      syncCreateInterceptEndpointGroupAssociationLocationnameInterceptendpointgroupassociationString()
          throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (InterceptClient interceptClient = InterceptClient.create()) {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      InterceptEndpointGroupAssociation interceptEndpointGroupAssociation =
          InterceptEndpointGroupAssociation.newBuilder().build();
      String interceptEndpointGroupAssociationId = "interceptEndpointGroupAssociationId-1931364844";
      InterceptEndpointGroupAssociation response =
          interceptClient
              .createInterceptEndpointGroupAssociationAsync(
                  parent, interceptEndpointGroupAssociation, interceptEndpointGroupAssociationId)
              .get();
    }
  }
}
// [END networksecurity_v1_generated_Intercept_CreateInterceptEndpointGroupAssociation_LocationnameInterceptendpointgroupassociationString_sync]
