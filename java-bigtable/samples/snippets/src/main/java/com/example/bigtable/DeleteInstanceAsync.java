/*
 * Copyright 2026 Google LLC
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

package com.example.bigtable;

// [START bigtable_async_delete_instance]

import com.google.api.core.ApiFuture;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClientV2;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class DeleteInstanceAsync {

  /** Asynchronously deletes the specified Cloud Bigtable instance. */
  public static void deleteInstanceAsync(String projectId, String instanceId)
      throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    // String projectId = "my-project-id";
    // String instanceId = "my-instance-id";

    try (BigtableInstanceAdminClientV2 adminClient = BigtableInstanceAdminClientV2.create()) {
      String name = "projects/" + projectId + "/instances/" + instanceId;
      DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();
      ApiFuture<Empty> future = adminClient.deleteInstanceCallable().futureCall(request);
      future.get();
      System.out.println("Instance deleted: " + instanceId);
    }
  }
}
// [END bigtable_async_delete_instance]
