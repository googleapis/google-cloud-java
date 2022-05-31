/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.gameservices.realms;

// [START cloud_game_servers_realm_update]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.gaming.v1.OperationMetadata;
import com.google.cloud.gaming.v1.Realm;
import com.google.cloud.gaming.v1.RealmsServiceClient;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UpdateRealm {
  public static void updateRealm(String projectId, String regionId, String realmId)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // String projectId = "your-project-id";
    // String regionId = "us-central1-f";
    // String realmId = "your-realm-id";
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (RealmsServiceClient client = RealmsServiceClient.create()) {
      String parent = String.format("projects/%s/locations/%s", projectId, regionId);
      String realmName = String.format("%s/realms/%s", parent, realmId);

      Realm realm = Realm.newBuilder().setName(realmName).setTimeZone("America/New_York").build();

      FieldMask fieldMask = FieldMask.newBuilder().addPaths("time_zone").build();

      OperationFuture<Realm, OperationMetadata> call = client.updateRealmAsync(realm, fieldMask);

      Realm updated = call.get(1, TimeUnit.MINUTES);
      System.out.println("Realm updated: " + updated.getName());
    }
  }
}
// [END cloud_game_servers_realm_update]
