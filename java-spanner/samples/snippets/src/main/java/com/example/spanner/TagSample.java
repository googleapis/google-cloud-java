/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;

/**
 * Sample showing how to add transaction and query tags to Cloud Spanner operations.
 */
public class TagSample {

  // [START spanner_set_transaction_tag]
  static void setTransactionTag(DatabaseClient databaseClient) {
    // Sets the transaction tag to "app=concert,env=dev".
    // This transaction tag will be applied to all the individual operations inside this
    // transaction.
    databaseClient
        .readWriteTransaction(Options.tag("app=concert,env=dev"))
        .run(transaction -> {
          // Sets the request tag to "app=concert,env=dev,action=update".
          // This request tag will only be set on this request.
          transaction.executeUpdate(
              Statement.of("UPDATE Venues"
                  + " SET Capacity = CAST(Capacity/4 AS INT64)"
                  + " WHERE OutdoorVenue = false"),
              Options.tag("app=concert,env=dev,action=update"));
          System.out.println("Venue capacities updated.");

          Statement insertStatement = Statement.newBuilder(
              "INSERT INTO Venues"
                  + " (VenueId, VenueName, Capacity, OutdoorVenue, LastUpdateTime)"
                  + " VALUES ("
                  + " @venueId, @venueName, @capacity, @outdoorVenue, PENDING_COMMIT_TIMESTAMP()"
                  + " )")
              .bind("venueId")
              .to(81)
              .bind("venueName")
              .to("Venue 81")
              .bind("capacity")
              .to(1440)
              .bind("outdoorVenue")
              .to(true)
              .build();

          // Sets the request tag to "app=concert,env=dev,action=insert".
          // This request tag will only be set on this request.
          transaction.executeUpdate(
              insertStatement,
              Options.tag("app=concert,env=dev,action=insert"));
          System.out.println("New venue inserted.");

          return null;
        });
  }
  // [END spanner_set_transaction_tag]

  // [START spanner_set_request_tag]
  static void setRequestTag(DatabaseClient databaseClient) {
    // Sets the request tag to "app=concert,env=dev,action=select".
    // This request tag will only be set on this request.
    try (ResultSet resultSet = databaseClient
        .singleUse()
        .executeQuery(
            Statement.of("SELECT SingerId, AlbumId, AlbumTitle FROM Albums"),
            Options.tag("app=concert,env=dev,action=select"))) {
      while (resultSet.next()) {
        System.out.printf(
            "SingerId: %d, AlbumId: %d, AlbumTitle: %s\n",
            resultSet.getLong(0),
            resultSet.getLong(1),
            resultSet.getString(2));
      }
    }
  }
  // [END spanner_set_request_tag]
}
