/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.notebooks.v1beta1.it;

import com.google.cloud.notebooks.v1beta1.DeleteInstanceRequest;
import com.google.cloud.notebooks.v1beta1.Instance;
import com.google.cloud.notebooks.v1beta1.ListInstancesRequest;
import com.google.cloud.notebooks.v1beta1.NotebookServiceClient;
import com.google.cloud.notebooks.v1beta1.NotebookServiceClient.ListInstancesPagedResponse;
import com.google.protobuf.util.Timestamps;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Util {

  // Cleans existing test resources if any.
  private static final int DELETION_THRESHOLD_TIME_HOURS = 24;

  /** Bring down any instances that are older than 24 hours */
  public static void cleanUpNotebookInstances(
      NotebookServiceClient client, String parent, String prefix) {
    ListInstancesPagedResponse listInstancesPagedResponse =
        client.listInstances(ListInstancesRequest.newBuilder().setParent(parent).build());
    for (Instance instance : listInstancesPagedResponse.iterateAll()) {
      if (isCreatedBeforeThresholdTime(
              Instant.ofEpochMilli(Timestamps.toMillis(instance.getCreateTime())))
          && instance.getName().startsWith(prefix)) {
        client.deleteInstanceAsync(
            DeleteInstanceRequest.newBuilder().setName(instance.getName()).build());
      }
    }
  }

  private static boolean isCreatedBeforeThresholdTime(Instant instant) {
    return instant.isBefore(Instant.now().minus(DELETION_THRESHOLD_TIME_HOURS, ChronoUnit.HOURS));
  }
}
