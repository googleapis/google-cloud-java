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

package com.google.cloud.gkehub.v1beta1.samples;

// [START gkehub_v1beta1_generated_gkehubmembershipserviceclient_createmembership_stringmembershipstring_sync]
import com.google.cloud.gkehub.v1beta1.GkeHubMembershipServiceClient;
import com.google.cloud.gkehub.v1beta1.LocationName;
import com.google.cloud.gkehub.v1beta1.Membership;

public class SyncCreateMembershipStringMembershipString {

  public static void main(String[] args) throws Exception {
    syncCreateMembershipStringMembershipString();
  }

  public static void syncCreateMembershipStringMembershipString() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (GkeHubMembershipServiceClient gkeHubMembershipServiceClient =
        GkeHubMembershipServiceClient.create()) {
      String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
      Membership resource = Membership.newBuilder().build();
      String membershipId = "membershipId517665681";
      Membership response =
          gkeHubMembershipServiceClient.createMembershipAsync(parent, resource, membershipId).get();
    }
  }
}
// [END gkehub_v1beta1_generated_gkehubmembershipserviceclient_createmembership_stringmembershipstring_sync]
