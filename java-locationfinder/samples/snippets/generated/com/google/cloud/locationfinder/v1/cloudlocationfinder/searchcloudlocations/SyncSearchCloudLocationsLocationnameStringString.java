/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.locationfinder.v1.samples;

// [START cloudlocationfinder_v1_generated_CloudLocationFinder_SearchCloudLocations_LocationnameStringString_sync]
import com.google.cloud.locationfinder.v1.CloudLocation;
import com.google.cloud.locationfinder.v1.CloudLocationFinderClient;
import com.google.cloud.locationfinder.v1.CloudLocationName;
import com.google.cloud.locationfinder.v1.LocationName;

public class SyncSearchCloudLocationsLocationnameStringString {

  public static void main(String[] args) throws Exception {
    syncSearchCloudLocationsLocationnameStringString();
  }

  public static void syncSearchCloudLocationsLocationnameStringString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String sourceCloudLocation =
          CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]").toString();
      String query = "query107944136";
      for (CloudLocation element :
          cloudLocationFinderClient
              .searchCloudLocations(parent, sourceCloudLocation, query)
              .iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END cloudlocationfinder_v1_generated_CloudLocationFinder_SearchCloudLocations_LocationnameStringString_sync]
