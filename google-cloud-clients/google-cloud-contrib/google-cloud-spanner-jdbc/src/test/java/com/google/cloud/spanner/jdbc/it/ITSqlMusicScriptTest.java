/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc.it;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.jdbc.AbstractSqlScriptVerifier.GenericConnection;
import com.google.cloud.spanner.jdbc.ITAbstractSpannerTest;
import com.google.cloud.spanner.jdbc.SqlScriptVerifier;
import com.google.cloud.spanner.jdbc.SqlScriptVerifier.SpannerGenericConnection;
import java.util.ArrayList;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

/**
 * Integration test that runs one long sql script using the default Singers/Albums/Songs/Concerts
 * data model
 */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ITSqlMusicScriptTest extends ITAbstractSpannerTest {
  private static final String SCRIPT_FILE = "ITSqlMusicScriptTest.sql";

  @Test
  public void test01_RunScript() throws Exception {
    SqlScriptVerifier verifier = new SqlScriptVerifier();
    try (GenericConnection connection = SpannerGenericConnection.of(createConnection())) {
      verifier.verifyStatementsInFile(connection, SCRIPT_FILE, SqlScriptVerifier.class, true);
    }
  }

  @Test
  public void test02_RunAbortedTest() {
    final long SINGER_ID = 2L;
    final long VENUE_ID = 68L;
    final long NUMBER_OF_SINGERS = 30L;
    final long NUMBER_OF_ALBUMS = 60L;
    final long NUMBER_OF_SONGS = 149L;
    final long NUMBER_OF_CONCERTS = 100L;
    long numberOfSongs = 0L;
    AbortInterceptor interceptor = new AbortInterceptor(0.0D);
    try (ITConnection connection = createConnection(interceptor)) {
      connection.setAutocommit(false);
      connection.setRetryAbortsInternally(true);
      // Read all data from the different music tables in the transaction
      // The previous test deleted the first two Singers records.
      long expectedId = 3L;
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT * FROM Singers ORDER BY SingerId"))) {
        while (rs.next()) {
          assertThat(rs.getLong("SingerId"), is(equalTo(expectedId)));
          expectedId++;
        }
      }
      assertThat(expectedId, is(equalTo(NUMBER_OF_SINGERS + 1L)));
      expectedId = 3L;
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT * FROM Albums ORDER BY AlbumId"))) {
        while (rs.next()) {
          assertThat(rs.getLong("AlbumId"), is(equalTo(expectedId)));
          expectedId++;
          // 31 and 32 were deleted by the first test script.
          if (expectedId == 31L || expectedId == 32L) {
            expectedId = 33L;
          }
        }
      }
      assertThat(expectedId, is(equalTo(NUMBER_OF_ALBUMS + 1L)));
      expectedId = 1L;
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT * FROM Songs ORDER BY TrackId"))) {
        while (rs.next()) {
          assertThat(rs.getLong("TrackId"), is(equalTo(expectedId)));
          expectedId++;
          numberOfSongs++;
          // 40, 64, 76, 86 and 96 were deleted by the first test script.
          if (expectedId == 40L
              || expectedId == 64L
              || expectedId == 76L
              || expectedId == 86L
              || expectedId == 96L) {
            expectedId++;
          }
        }
      }
      assertThat(expectedId, is(equalTo(NUMBER_OF_SONGS + 1L)));
      // Concerts are not in the table hierarchy, so no records have been deleted.
      expectedId = 1L;
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT * FROM Concerts ORDER BY VenueId"))) {
        while (rs.next()) {
          assertThat(rs.getLong("VenueId"), is(equalTo(expectedId)));
          expectedId++;
        }
      }
      assertThat(expectedId, is(equalTo(NUMBER_OF_CONCERTS + 1L)));

      // make one small concurrent change in a different transaction
      List<Long> originalPrices;
      List<Long> newPrices;
      try (ITConnection connection2 = createConnection()) {
        assertThat(connection2.isAutocommit(), is(true));
        try (ResultSet rs =
            connection2.executeQuery(
                Statement.newBuilder(
                        "SELECT TicketPrices FROM Concerts WHERE SingerId=@singer AND VenueId=@venue")
                    .bind("singer")
                    .to(SINGER_ID)
                    .bind("venue")
                    .to(VENUE_ID)
                    .build())) {
          assertThat(rs.next(), is(true));
          originalPrices = rs.getLongList(0);
          // increase one of the prices by 1
          newPrices = new ArrayList<>(originalPrices);
          newPrices.set(1, originalPrices.get(1) + 1);
          connection2.executeUpdate(
              Statement.newBuilder(
                      "UPDATE Concerts SET TicketPrices=@prices WHERE SingerId=@singer AND VenueId=@venue")
                  .bind("prices")
                  .toInt64Array(newPrices)
                  .bind("singer")
                  .to(SINGER_ID)
                  .bind("venue")
                  .to(VENUE_ID)
                  .build());
        }
      }

      // try to add a new song and then try to commit, but trigger an abort on commit
      connection.bufferedWrite(
          Mutation.newInsertBuilder("Songs")
              .set("SingerId")
              .to(3L)
              .set("AlbumId")
              .to(3L)
              .set("TrackId")
              .to(1L)
              .set("SongName")
              .to("Aborted")
              .set("Duration")
              .to(1L)
              .set("SongGenre")
              .to("Unknown")
              .build());
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      // the transaction retry should fail because of the concurrent modification
      boolean expectedException = false;
      try {
        connection.commit();
      } catch (AbortedDueToConcurrentModificationException e) {
        expectedException = true;
      }
      // verify that the commit aborted, an internal retry was started and then aborted because of
      // the concurrent modification
      assertThat(expectedException, is(true));
      // verify that the prices were changed
      try (ResultSet rs =
          connection.executeQuery(
              Statement.newBuilder(
                      "SELECT TicketPrices FROM Concerts WHERE SingerId=@singer AND VenueId=@venue")
                  .bind("singer")
                  .to(SINGER_ID)
                  .bind("venue")
                  .to(VENUE_ID)
                  .build())) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLongList(0), is(equalTo(newPrices)));
      }
      // verify that the new song was not written to the database
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT COUNT(*) FROM Songs"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong(0), is(equalTo(numberOfSongs)));
      }
    }
  }
}
