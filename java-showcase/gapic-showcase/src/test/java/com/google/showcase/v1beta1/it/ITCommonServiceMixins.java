/*
 * Copyright 2023 Google LLC
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

package com.google.showcase.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.showcase.v1beta1.EchoClient;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ITCommonServiceMixins {

  // The showcase server always returns a fixed list of locations. See
  // https://github.com/googleapis/gapic-showcase/blob/main/server/services/locations_service.go
  private static final List<Location> EXPECTED_LOCATIONS =
      ImmutableList.of(
          Location.newBuilder()
              .setName("projects/showcase/locations/us-north")
              .setDisplayName("us-north")
              .build(),
          Location.newBuilder()
              .setName("projects/showcase/locations/us-south")
              .setDisplayName("us-south")
              .build(),
          Location.newBuilder()
              .setName("projects/showcase/locations/us-east")
              .setDisplayName("us-east")
              .build(),
          Location.newBuilder()
              .setName("projects/showcase/locations/us-west")
              .setDisplayName("us-west")
              .build());
  private static EchoClient grpcClient;
  private static EchoClient httpjsonClient;

  @BeforeAll
  static void createClients() throws Exception {
    // Create gRPC Echo Client
    grpcClient = TestClientInitializer.createGrpcEchoClient();

    // Create HttpJson Echo Client
    httpjsonClient = TestClientInitializer.createHttpJsonEchoClient();
  }

  @AfterAll
  static void destroyClients() throws InterruptedException {
    grpcClient.close();
    httpjsonClient.close();

    grpcClient.awaitTermination(TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
    httpjsonClient.awaitTermination(
        TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  @Test
  void testGrpc_getLocation() {
    GetLocationRequest request =
        GetLocationRequest.newBuilder().setName("projects/showcase/location/us-central1").build();
    Location location = grpcClient.getLocation(request);
    assertThat(location)
        .isEqualTo(
            Location.newBuilder()
                .setName("projects/showcase/location/us-central1")
                .setDisplayName("us-central1")
                .build());
  }

  @Test
  void testGrpc_listLocations() {
    ListLocationsRequest request =
        ListLocationsRequest.newBuilder().setName("projects/showcase").build();
    EchoClient.ListLocationsPagedResponse locationsPagedResponse =
        grpcClient.listLocations(request);

    List<Location> actualLocations = new ArrayList<>();
    for (Location location : locationsPagedResponse.iterateAll()) {
      actualLocations.add(location);
    }

    assertThat(actualLocations).containsExactlyElementsIn(EXPECTED_LOCATIONS).inOrder();
  }

  @Test
  void testHttpJson_getLocation() {
    GetLocationRequest request =
        GetLocationRequest.newBuilder().setName("projects/showcase/locations/us-central1").build();
    Location location = httpjsonClient.getLocation(request);
    assertThat(location)
        .isEqualTo(
            Location.newBuilder()
                .setName("projects/showcase/locations/us-central1")
                .setDisplayName("us-central1")
                .build());
  }

  @Test
  void testHttpJson_listLocations() {
    ListLocationsRequest request =
        ListLocationsRequest.newBuilder().setName("projects/showcase").build();
    EchoClient.ListLocationsPagedResponse locationsPagedResponse =
        httpjsonClient.listLocations(request);

    List<Location> actualLocations = new ArrayList<>();
    for (Location location : locationsPagedResponse.iterateAll()) {
      actualLocations.add(location);
    }

    assertThat(actualLocations).containsExactlyElementsIn(EXPECTED_LOCATIONS).inOrder();
  }
}
