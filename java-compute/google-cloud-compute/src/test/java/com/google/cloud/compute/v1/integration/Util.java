/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.integration;

import com.google.cloud.compute.v1.Address;
import com.google.cloud.compute.v1.AddressesClient;
import com.google.cloud.compute.v1.DeleteInstanceRequest;
import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.InstancesClient;
import com.google.cloud.compute.v1.InstancesClient.ListPagedResponse;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Util {

  // Cleans existing test resources if any.
  private static final int DELETION_THRESHOLD_TIME_HOURS = 24;

  /** Bring down any instances that are older than 24 hours */
  public static void cleanUpComputeInstances(
      InstancesClient instancesClient, String project, String zone, String prefix) {
    ListPagedResponse listPagedResponse = instancesClient.list(project, zone);
    for (Instance instance : listPagedResponse.iterateAll()) {
      if (isCreatedBeforeThresholdTime(
              ZonedDateTime.parse(instance.getCreationTimestamp()).toInstant())
          && instance.getName().startsWith(prefix)) {
        instancesClient.deleteAsync(
            DeleteInstanceRequest.newBuilder()
                .setInstance(instance.getName())
                .setProject(project)
                .setZone(zone)
                .build());
      }
    }
  }

  /** Bring down any addresses that are older than 24 hours */
  public static void cleanUpComputeAddresses(
      AddressesClient addressesClient, String project, String region, String prefix) {
    AddressesClient.ListPagedResponse listPagedResponse = addressesClient.list(project, region);
    for (Address address : listPagedResponse.iterateAll()) {
      if (isCreatedBeforeThresholdTime(address.getCreationTimestamp())
          && address.getName().startsWith(prefix)) {
        addressesClient.deleteAsync(project, region, address.getName());
      }
    }
  }

  private static boolean isCreatedBeforeThresholdTime(Instant instant) {
    return instant.isBefore(Instant.now().minus(DELETION_THRESHOLD_TIME_HOURS, ChronoUnit.HOURS));
  }

  private static boolean isCreatedBeforeThresholdTime(String timestamp) {
    return OffsetDateTime.parse(timestamp)
        .toInstant()
        .isBefore(Instant.now().minus(DELETION_THRESHOLD_TIME_HOURS, ChronoUnit.HOURS));
  }
}
