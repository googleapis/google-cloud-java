/*
 * Copyright 2021 Google LLC
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

package com.example.bigqueryreservation;

// [START bigqueryreservation_quickstart]
import com.google.cloud.bigquery.reservation.v1.ReservationServiceClient;
import java.io.IOException;

public class QuickstartSample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String location = "LOCATION";
    quickStartSample(projectId, location);
  }

  public static void quickStartSample(String projectId, String location) throws IOException {
    try (ReservationServiceClient client = ReservationServiceClient.create()) {
      // list reservations in the project
      String parent = String.format("projects/%s/locations/%s", projectId, location);
      client
          .listReservations(parent)
          .iterateAll()
          .forEach(res -> System.out.println("Reservation resource name: " + res.getName()));

      // list capacity commitments in the project
      client
          .listCapacityCommitments(parent)
          .iterateAll()
          .forEach(
              commitment ->
                  System.out.println("Capacity commitment resource name: " + commitment.getName()));
    }
  }
}
// [END bigqueryreservation_quickstart]
