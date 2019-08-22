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
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.google.api.client.util.Base64;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.jdbc.ITAbstractJdbcTest;
import com.google.common.base.Strings;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

/** Integration tests for JDBC {@link PreparedStatement}s. */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ITJdbcPreparedStatementTest extends ITAbstractJdbcTest {
  private static final class Singer {
    private final long singerId;
    private final String firstName;
    private final String lastName;
    private final byte[] singerInfo;
    private final Date birthDate;

    private static Singer of(String values) {
      String[] array = values.split(",");
      if (array.length != 5) {
        throw new IllegalArgumentException(values);
      }
      return new Singer(
          Long.valueOf(array[0]), // singer id
          array[1].substring(1, array[1].length() - 1), // first name
          array[2].substring(1, array[2].length() - 1), // last name
          parseBytes(array[3].substring(13, array[3].length() - 2)), // singer info
          parseDate(array[4].substring(6, array[4].length() - 1)) // birth date
          );
    }

    private Singer(
        long singerId, String firstName, String lastName, byte[] singerInfo, Date birthDate) {
      this.singerId = singerId;
      this.firstName = firstName;
      this.lastName = lastName;
      this.singerInfo = singerInfo;
      this.birthDate = birthDate;
    }
  }

  private static final class Album {
    private final long singerId;
    private final long albumId;
    private final String albumTitle;
    private final long marketingBudget;

    private static Album of(String values) {
      String[] array = values.split(",");
      if (array.length != 4) {
        throw new IllegalArgumentException(values);
      }
      return new Album(
          Long.valueOf(array[0]), // singer id
          Long.valueOf(array[1]), // album id
          array[2].substring(1, array[2].length() - 1), // album title
          Long.valueOf(array[3]) // marketing budget
          );
    }

    private Album(long singerId, long albumId, String albumTitle, long marketingBudget) {
      this.singerId = singerId;
      this.albumId = albumId;
      this.albumTitle = albumTitle;
      this.marketingBudget = marketingBudget;
    }
  }

  private static final class Song {
    private final long singerId;
    private final long albumId;
    private final long songId;
    private final String songName;
    private final long duration;
    private final String songGenre;

    private static Song of(String values) {
      String[] array = values.split(",");
      if (array.length != 6) {
        throw new IllegalArgumentException(values);
      }
      return new Song(
          Long.valueOf(array[0]), // singer id
          Long.valueOf(array[1]), // album id
          Long.valueOf(array[2]), // song id
          array[3].substring(1, array[3].length() - 1), // song name
          Long.valueOf(array[4]), // duration
          array[5].substring(1, array[5].length() - 1));
    }

    private Song(
        long singerId,
        long albumId,
        long songId,
        String songName,
        long duration,
        String songGenre) {
      this.singerId = singerId;
      this.albumId = albumId;
      this.songId = songId;
      this.songName = songName;
      this.duration = duration;
      this.songGenre = songGenre;
    }
  }

  private static final class Concert {
    private final long venueId;
    private final long singerId;
    private final Date concertDate;
    private final Timestamp beginTime;
    private final Timestamp endTime;
    private final Long[] ticketPrices;

    private static Concert of(String values) {
      values = values.replaceAll("\\[(\\d+),(\\d+),(\\d+),(\\d+)\\]", "[$1;$2;$3;$4]");
      String[] array = values.split(",");
      if (array.length != 6) {
        throw new IllegalArgumentException(values);
      }
      return new Concert(
          Long.valueOf(array[0]), // venue id
          Long.valueOf(array[1]), // singer id
          parseDate(array[2].substring(6, array[2].length() - 1)), // concert date
          parseTimestamp(array[3].substring(11, array[3].length() - 1)), // begin time
          parseTimestamp(array[4].substring(11, array[4].length() - 1)), // end time
          parseLongArray(array[5]) // ticket prices
          );
    }

    private Concert(
        long venueId,
        long singerId,
        Date concertDate,
        Timestamp beginTime,
        Timestamp endTime,
        Long[] ticketPrices) {
      this.venueId = venueId;
      this.singerId = singerId;
      this.concertDate = concertDate;
      this.beginTime = beginTime;
      this.endTime = endTime;
      this.ticketPrices = ticketPrices;
    }
  }

  private static Date parseDate(String value) {
    try {
      return Date.valueOf(value);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(value);
    }
  }

  private static Timestamp parseTimestamp(String value) {
    try {
      return Timestamp.valueOf(value.replace('T', ' ').replace("Z", ""));
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(value);
    }
  }

  private static Long[] parseLongArray(String value) {
    String[] values = value.substring(1, value.length() - 1).split(";");
    Long[] res = new Long[values.length];
    for (int index = 0; index < values.length; index++) {
      res[index] = Long.valueOf(values[index]);
    }
    return res;
  }

  private static byte[] parseBytes(String value) {
    return Base64.decodeBase64(value);
  }

  private List<Singer> createSingers() {
    List<Singer> res = new ArrayList<>();
    for (String singerValue : readValuesFromFile("Singers.txt")) {
      res.add(Singer.of(singerValue));
    }
    return res;
  }

  private List<Album> createAlbums() {
    List<Album> res = new ArrayList<>();
    for (String albumValue : readValuesFromFile("Albums.txt")) {
      res.add(Album.of(albumValue));
    }
    return res;
  }

  private List<Song> createSongs() {
    List<Song> res = new ArrayList<>();
    for (String songValue : readValuesFromFile("Songs.txt")) {
      res.add(Song.of(songValue));
    }
    return res;
  }

  private List<Concert> createConcerts() {
    List<Concert> res = new ArrayList<>();
    for (String concertValue : readValuesFromFile("Concerts.txt")) {
      res.add(Concert.of(concertValue));
    }
    return res;
  }

  @Override
  protected boolean doCreateMusicTables() {
    return true;
  }

  @Test
  public void test01_InsertTestData() throws SQLException {
    try (Connection connection = createConnection()) {
      connection.setAutoCommit(false);
      try (PreparedStatement ps =
          connection.prepareStatement(
              "INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) values (?,?,?,?,?)")) {
        assertDefaultParameterMetaData(ps.getParameterMetaData(), 5);
        for (Singer singer : createSingers()) {
          ps.setByte(1, (byte) singer.singerId);
          ps.setString(2, singer.firstName);
          ps.setString(3, singer.lastName);
          ps.setBytes(4, singer.singerInfo);
          ps.setDate(5, singer.birthDate);

          assertInsertSingerParameterMetadata(ps.getParameterMetaData());
          ps.addBatch();
          // check that adding the current params to a batch will not reset the meta data
          assertInsertSingerParameterMetadata(ps.getParameterMetaData());
        }
        int[] results = ps.executeBatch();
        for (int res : results) {
          assertThat(res, is(equalTo(1)));
        }
      }
      try (PreparedStatement ps =
          connection.prepareStatement(
              "INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (?,?,?,?)")) {
        assertDefaultParameterMetaData(ps.getParameterMetaData(), 4);
        for (Album album : createAlbums()) {
          ps.setLong(1, album.singerId);
          ps.setLong(2, album.albumId);
          ps.setString(3, album.albumTitle);
          ps.setLong(4, album.marketingBudget);
          assertInsertAlbumParameterMetadata(ps.getParameterMetaData());
          assertThat(ps.executeUpdate(), is(equalTo(1)));
          // check that calling executeUpdate will not reset the meta data
          assertInsertAlbumParameterMetadata(ps.getParameterMetaData());
        }
      }
      try (PreparedStatement ps =
          connection.prepareStatement(
              "INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (?,?,?,?,?,?);")) {
        assertDefaultParameterMetaData(ps.getParameterMetaData(), 6);
        for (Song song : createSongs()) {
          ps.setByte(1, (byte) song.singerId);
          ps.setInt(2, (int) song.albumId);
          ps.setShort(3, (short) song.songId);
          ps.setNString(4, song.songName);
          ps.setLong(5, song.duration);
          ps.setCharacterStream(6, new StringReader(song.songGenre));
          assertInsertSongParameterMetadata(ps.getParameterMetaData());
          assertThat(ps.executeUpdate(), is(equalTo(1)));
          // check that calling executeUpdate will not reset the meta data
          assertInsertSongParameterMetadata(ps.getParameterMetaData());
        }
      }
      try (PreparedStatement ps =
          connection.prepareStatement(
              "INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (?,?,?,?,?,?);")) {
        assertDefaultParameterMetaData(ps.getParameterMetaData(), 6);
        for (Concert concert : createConcerts()) {
          ps.setLong(1, concert.venueId);
          ps.setLong(2, concert.singerId);
          ps.setDate(3, concert.concertDate);
          ps.setTimestamp(4, concert.beginTime);
          ps.setTimestamp(5, concert.endTime);
          ps.setArray(6, connection.createArrayOf("INT64", concert.ticketPrices));
          assertInsertConcertParameterMetadata(ps.getParameterMetaData());
          assertThat(ps.executeUpdate(), is(equalTo(1)));
          // check that calling executeUpdate will not reset the meta data
          assertInsertConcertParameterMetadata(ps.getParameterMetaData());
        }
      }
      connection.commit();
    }
  }

  @Test
  public void test02_VerifyTestData() throws SQLException {
    try (Connection connection = createConnection()) {
      try (ResultSet rs =
          connection.createStatement().executeQuery("SELECT COUNT(*) FROM Singers")) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getInt(1), is(equalTo(30)));
        assertThat(rs.next(), is(false));
      }
      try (ResultSet rs =
          connection.createStatement().executeQuery("SELECT COUNT(*) FROM Albums")) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getByte(1), is(equalTo((byte) 60)));
        assertThat(rs.next(), is(false));
      }
      try (ResultSet rs = connection.createStatement().executeQuery("SELECT COUNT(*) FROM Songs")) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getShort(1), is(equalTo((short) 149)));
        assertThat(rs.next(), is(false));
      }
      try (ResultSet rs =
          connection.createStatement().executeQuery("SELECT COUNT(*) FROM Concerts")) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong(1), is(equalTo(100L)));
        assertThat(rs.next(), is(false));
      }
      try (PreparedStatement ps =
          connection.prepareStatement("SELECT * FROM Concerts WHERE VenueId=? AND SingerId=?")) {
        ps.setLong(1, 1L);
        ps.setLong(2, 1L);
        // Expected:
        // (1,1,DATE '2003-06-19',TIMESTAMP '2003-06-19T12:30:05Z',TIMESTAMP
        // '2003-06-19T18:57:15Z',[11,93,140,923]);
        try (ResultSet rs = ps.executeQuery()) {
          assertThat(rs.next(), is(true));
          assertThat(rs.getLong(1), is(equalTo(1L)));
          assertThat(rs.getLong(2), is(equalTo(1L)));
          assertThat(rs.getDate(3), is(equalTo(Date.valueOf("2003-06-19"))));
          assertThat(rs.getTimestamp(4), is(equalTo(Timestamp.valueOf("2003-06-19 12:30:05"))));
          assertThat(rs.getTimestamp(5), is(equalTo(Timestamp.valueOf("2003-06-19 18:57:15"))));
          assertThat(((Long[]) rs.getArray(6).getArray())[0], is(equalTo(11L)));
        }
      }
    }
  }

  @SuppressWarnings("deprecation")
  @Test
  public void test03_Dates() throws SQLException {
    List<String> expectedValues = new ArrayList<>();
    expectedValues.add("2008-01-01");
    expectedValues.add("2000-01-01");
    expectedValues.add("1900-01-01");
    expectedValues.add("2000-02-29");
    expectedValues.add("2004-02-29");
    expectedValues.add("2018-12-31");
    expectedValues.add("2015-11-15");
    expectedValues.add("2015-11-15");
    expectedValues.add("2015-11-15");

    List<Date> testDates = new ArrayList<>();
    testDates.add(Date.valueOf("2008-01-01"));
    testDates.add(Date.valueOf("2000-01-01"));
    testDates.add(Date.valueOf("1900-01-01"));
    testDates.add(Date.valueOf("2000-02-29"));
    testDates.add(Date.valueOf("2004-02-29"));
    testDates.add(Date.valueOf("2018-12-31"));

    // Cloud Spanner does not store any timezone information, meaning that it shouldn't matter in
    // what timezone a date is sent to Cloud Spanner, the same date in the local timezone (or the
    // requested timezone) should be returned.
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    cal.clear();
    cal.set(2015, 10, 15, 10, 0, 0);
    testDates.add(new Date(cal.getTimeInMillis()));

    cal = Calendar.getInstance(TimeZone.getTimeZone("CET"));
    cal.clear();
    cal.set(2015, 10, 15, 10, 0, 0);
    testDates.add(new Date(cal.getTimeInMillis()));

    cal = Calendar.getInstance(TimeZone.getTimeZone("PST"));
    cal.clear();
    cal.set(2015, 10, 15, 10, 0, 0);
    testDates.add(new Date(cal.getTimeInMillis()));

    List<Calendar> calendars = new ArrayList<>();
    calendars.add(null);
    calendars.add(Calendar.getInstance());
    calendars.add(Calendar.getInstance(TimeZone.getTimeZone("UTC")));
    calendars.add(Calendar.getInstance(TimeZone.getTimeZone("CET")));
    calendars.add(Calendar.getInstance(TimeZone.getTimeZone("PST")));

    try (Connection connection = createConnection()) {
      for (Calendar testCalendar : calendars) {
        int index = 0;
        for (Date testDate : testDates) {
          try (PreparedStatement ps =
              connection.prepareStatement(
                  "INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (?,?,?,?,?,?);")) {
            assertDefaultParameterMetaData(ps.getParameterMetaData(), 6);
            ps.setLong(1, 100);
            ps.setLong(2, 19);
            ps.setDate(3, testDate);
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            ps.setArray(6, connection.createArrayOf("INT64", new Long[] {}));
            ps.executeUpdate();
          }

          try (PreparedStatement ps =
              connection.prepareStatement(
                  "SELECT * FROM Concerts WHERE VenueId=? AND SingerId=?")) {
            ps.setLong(1, 100L);
            ps.setLong(2, 19L);
            try (ResultSet rs = ps.executeQuery()) {
              assertThat(rs.next(), is(true));
              if (testCalendar == null) {
                assertThat(rs.getDate(3), is(equalTo(Date.valueOf(expectedValues.get(index)))));
              } else {
                // Parse the date in the local timezone.
                Date date = Date.valueOf(expectedValues.get(index));
                // Create a calendar in the test timezone with only the date part set.
                Calendar localCalendar = Calendar.getInstance(testCalendar.getTimeZone());
                localCalendar.clear();
                localCalendar.set(date.getYear() + 1900, date.getMonth(), date.getDate());
                // Check that the actual time of the date returned by the ResultSet is equal to the
                // local time in the timezone of the Calendar that is used.
                assertThat(
                    rs.getDate(3, testCalendar),
                    is(equalTo(new Date(localCalendar.getTimeInMillis()))));
              }
            }
          }
          connection
              .createStatement()
              .execute("DELETE FROM Concerts WHERE VenueId=100 AND SingerId=19");
          index++;
        }
      }
    }
  }

  @Test
  public void test04_Timestamps() throws SQLException {
    List<String> expectedValues = new ArrayList<>();
    expectedValues.add("2008-01-01 10:00:00");
    expectedValues.add("2000-01-01 00:00:00");
    expectedValues.add("1900-01-01 12:13:14");
    expectedValues.add("2000-02-29 02:00:00");
    expectedValues.add("2004-02-29 03:00:00");
    expectedValues.add("2018-12-31 23:59:59");
    expectedValues.add("2015-11-15 10:00:00");
    expectedValues.add("2015-11-15 10:00:00");
    expectedValues.add("2015-11-15 10:00:00");

    List<TimeZone> timezones = new ArrayList<>();
    timezones.add(TimeZone.getDefault());
    timezones.add(TimeZone.getDefault());
    timezones.add(TimeZone.getDefault());
    timezones.add(TimeZone.getDefault());
    timezones.add(TimeZone.getDefault());
    timezones.add(TimeZone.getDefault());
    timezones.add(TimeZone.getTimeZone("UTC"));
    timezones.add(TimeZone.getTimeZone("CET"));
    timezones.add(TimeZone.getTimeZone("PST"));

    List<Timestamp> testTimestamps = new ArrayList<>();
    testTimestamps.add(Timestamp.valueOf(expectedValues.get(0)));
    testTimestamps.add(Timestamp.valueOf(expectedValues.get(1)));
    testTimestamps.add(Timestamp.valueOf(expectedValues.get(2)));
    testTimestamps.add(Timestamp.valueOf(expectedValues.get(3)));
    testTimestamps.add(Timestamp.valueOf(expectedValues.get(4)));
    testTimestamps.add(Timestamp.valueOf(expectedValues.get(5)));

    // Cloud Spanner does not store any timezone information, but does store the timestamp in UTC
    // format.
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    cal.clear();
    cal.set(2015, 10, 15);
    testTimestamps.add(new Timestamp(cal.getTimeInMillis()));

    cal = Calendar.getInstance(TimeZone.getTimeZone("CET"));
    cal.clear();
    cal.set(2015, 10, 15);
    testTimestamps.add(new Timestamp(cal.getTimeInMillis()));

    cal = Calendar.getInstance(TimeZone.getTimeZone("PST"));
    cal.clear();
    cal.set(2015, 10, 15);
    testTimestamps.add(new Timestamp(cal.getTimeInMillis()));

    List<Calendar> calendars = new ArrayList<>();
    calendars.add(null);
    calendars.add(Calendar.getInstance());
    calendars.add(Calendar.getInstance(TimeZone.getTimeZone("UTC")));
    calendars.add(Calendar.getInstance(TimeZone.getTimeZone("CET")));
    calendars.add(Calendar.getInstance(TimeZone.getTimeZone("PST")));

    try (Connection connection = createConnection()) {
      for (Calendar testCalendar : calendars) {
        for (Timestamp testTimestamp : testTimestamps) {
          try (PreparedStatement ps =
              connection.prepareStatement(
                  "INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (?,?,?,?,?,?);")) {
            assertDefaultParameterMetaData(ps.getParameterMetaData(), 6);
            ps.setLong(1, 100);
            ps.setLong(2, 19);
            ps.setDate(3, new Date(System.currentTimeMillis()));
            // Cloud Spanner will store the timestamp in UTC and no other timezone information.
            ps.setTimestamp(4, testTimestamp);
            ps.setTimestamp(5, testTimestamp, testCalendar);
            ps.setArray(6, connection.createArrayOf("INT64", new Long[] {}));
            ps.executeUpdate();
          }

          try (PreparedStatement ps =
              connection.prepareStatement(
                  "SELECT * FROM Concerts WHERE VenueId=? AND SingerId=?")) {
            ps.setLong(1, 100L);
            ps.setLong(2, 19L);
            try (ResultSet rs = ps.executeQuery()) {
              assertThat(rs.next(), is(true));

              // First test the timestamp that was sent to Spanner using the default timezone.
              // Get the timestamp in the default timezone.
              Timestamp inDefaultTZ = rs.getTimestamp(4);
              assertThat(inDefaultTZ.getTime(), is(equalTo(testTimestamp.getTime())));
              // Then get it in the test timezone.
              if (testCalendar != null) {
                Timestamp inOtherTZ = rs.getTimestamp(4, testCalendar);
                assertThat(
                    inOtherTZ.getTime(),
                    is(
                        equalTo(
                            testTimestamp.getTime() + testCalendar.getTimeZone().getRawOffset())));
              }

              // Then test the timestamp that was sent to Spanner using a specific timezone.
              // Get the timestamp in the default timezone.
              inDefaultTZ = rs.getTimestamp(5);
              if (testCalendar == null) {
                assertThat(inDefaultTZ.getTime(), is(equalTo(testTimestamp.getTime())));
              } else {
                assertThat(
                    inDefaultTZ.getTime(),
                    is(
                        equalTo(
                            testTimestamp.getTime() - testCalendar.getTimeZone().getRawOffset())));
              }
              // Then get it in the test timezone.
              if (testCalendar != null) {
                Timestamp inOtherTZ = rs.getTimestamp(5, testCalendar);
                assertThat(inOtherTZ.getTime(), is(equalTo(testTimestamp.getTime())));
              }
            }
          }
          connection
              .createStatement()
              .execute("DELETE FROM Concerts WHERE VenueId=100 AND SingerId=19");
        }
      }
    }
  }

  @Test
  public void test05_BatchUpdates() throws SQLException {
    for (boolean autocommit : new boolean[] {true, false}) {
      try (Connection con1 = createConnection();
          Connection con2 = createConnection()) {
        con1.setAutoCommit(autocommit);
        int[] updateCounts;
        String[] params = new String[] {"A%", "B%", "C%"};
        try (PreparedStatement ps =
            con1.prepareStatement("UPDATE Singers SET FirstName=LastName WHERE LastName LIKE ?")) {
          for (String param : params) {
            ps.setString(1, param);
            ps.addBatch();
          }
          updateCounts = ps.executeBatch();
        }
        assertThat(updateCounts.length, is(equalTo(params.length)));
        long totalUpdated = 0;
        try (PreparedStatement ps =
            con1.prepareStatement("SELECT COUNT(*) FROM Singers WHERE LastName LIKE ?")) {
          for (int i = 0; i < updateCounts.length; i++) {
            ps.setString(1, params[i]);
            try (ResultSet rs = ps.executeQuery()) {
              assertThat(rs.next(), is(true));
              assertThat(updateCounts[i], is(equalTo(rs.getInt(1))));
              totalUpdated += updateCounts[i];
            }
          }
        }
        // Check whether the updated values are readable on the second connection.
        try (ResultSet rs =
            con2.createStatement()
                .executeQuery("SELECT COUNT(*) FROM Singers WHERE FirstName=LastName")) {
          assertThat(rs.next(), is(true));
          if (autocommit) {
            assertThat(rs.getLong(1), is(equalTo(totalUpdated)));
          } else {
            assertThat(rs.getLong(1), is(equalTo(0L)));
          }
        }
        // If not in autocommit mode --> commit and verify.
        if (!autocommit) {
          con1.commit();
          try (ResultSet rs =
              con2.createStatement()
                  .executeQuery("SELECT COUNT(*) FROM Singers WHERE FirstName=LastName")) {
            assertThat(rs.next(), is(true));
            assertThat(rs.getLong(1), is(equalTo(totalUpdated)));
          }
        }
        // Set first names to null for the updated records for the next test run.
        assertThat(
            con2.createStatement()
                .executeUpdate("UPDATE Singers SET FirstName=null WHERE FirstName=LastName"),
            is(equalTo((int) totalUpdated)));
      }
    }
  }

  @Test
  public void test06_BatchUpdatesWithException() throws SQLException {
    for (boolean autocommit : new boolean[] {true, false}) {
      try (Connection con1 = createConnection();
          Connection con2 = createConnection()) {
        con1.setAutoCommit(autocommit);
        String[] params = new String[] {"A%", "B%", "C%", "D%"};
        // Statement number three will fail because the value is too long for the column.
        int[] updateValues = new int[] {1, 1, 1024, 1};
        try (PreparedStatement ps =
            con1.prepareStatement("UPDATE Singers SET FirstName=? WHERE LastName LIKE ?")) {
          for (int i = 0; i < params.length; i++) {
            ps.setString(1, Strings.repeat("not too long", updateValues[i]));
            ps.setString(2, params[i]);
            ps.addBatch();
          }
          ps.executeBatch();
          fail("missing expected BatchUpdateException");
        } catch (BatchUpdateException e) {
          assertThat(e.getUpdateCounts().length, is(equalTo(2)));
        }
        // If not in autocommit mode --> rollback before the next run.
        if (!autocommit) {
          con1.rollback();
        }
        // Set first names to null for the updated records for the next test run.
        try (PreparedStatement ps =
            con2.prepareStatement("UPDATE Singers SET FirstName=null WHERE FirstName=?")) {
          ps.setString(1, "not too long");
        }
      }
    }
  }

  @Test
  public void test07_StatementBatchUpdateWithException() throws SQLException {
    try (Connection con = createConnection()) {
      // The following statements will fail because the value is too long.
      try (Statement statement = con.createStatement()) {
        statement.addBatch(
            String.format(
                "UPDATE Singers SET FirstName='%s' WHERE LastName LIKE 'A%%'",
                Strings.repeat("too long", 1024)));
        statement.addBatch(
            String.format(
                "UPDATE Singers SET FirstName='%s' WHERE LastName LIKE 'B%%'",
                Strings.repeat("too long", 1024)));
        statement.executeBatch();
        fail("missing expected BatchUpdateException");
      } catch (BatchUpdateException e) {
        assertThat(e.getUpdateCounts(), is(notNullValue()));
      }
      // The following statements will fail because the table does not exist.
      try (Statement statement = con.createStatement()) {
        statement.addBatch(
            String.format(
                "UPDATE Non_Existent_Table SET FirstName='%s' WHERE LastName LIKE 'A%%'",
                Strings.repeat("too long", 1024)));
        statement.addBatch(
            String.format(
                "UPDATE Non_Existent_Table SET FirstName='%s' WHERE LastName LIKE 'B%%'",
                Strings.repeat("too long", 1024)));
        statement.executeBatch();
        fail();
      } catch (BatchUpdateException e) {
        assertThat(e.getUpdateCounts(), is(notNullValue()));
      }
      // The following statements will fail because the primary key values conflict.
      try (Statement statement = con.createStatement()) {
        statement.addBatch(
            "INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (9999, 'Test', 'Test', NULL, NULL)");
        statement.addBatch(
            "INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) VALUES (9999, 'Test', 'Test', NULL, NULL)");
        statement.executeBatch();
        fail();
      } catch (BatchUpdateException e) {
        assertThat(e.getUpdateCounts(), is(notNullValue()));
      }
    }
  }

  private void assertDefaultParameterMetaData(ParameterMetaData pmd, int expectedParamCount)
      throws SQLException {
    assertThat(pmd.getParameterCount(), is(equalTo(expectedParamCount)));
    for (int param = 1; param <= expectedParamCount; param++) {
      assertThat(pmd.getParameterType(param), is(equalTo(Types.OTHER)));
      assertThat(pmd.getParameterTypeName(param), is(equalTo("OTHER")));
      assertThat(pmd.getPrecision(param), is(equalTo(0)));
      assertThat(pmd.getScale(param), is(equalTo(0)));
      assertThat(pmd.getParameterClassName(param), is(nullValue()));
      assertThat(pmd.getParameterMode(param), is(equalTo(ParameterMetaData.parameterModeIn)));
      assertThat(pmd.isNullable(param), is(equalTo(ParameterMetaData.parameterNullableUnknown)));
      assertThat(pmd.isSigned(param), is(false));
    }
  }

  private List<String> readValuesFromFile(String filename) {
    File file = new File(getClass().getResource(filename).getFile());
    StringBuilder builder = new StringBuilder();
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        builder.append(line).append("\n");
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    String[] array = builder.toString().split(";");
    List<String> res = new ArrayList<>(array.length);
    for (String statement : array) {
      if (statement != null && statement.trim().length() > 0) {
        // strip the ( and )
        res.add(statement.trim().substring(1, statement.trim().length() - 1));
      }
    }
    return res;
  }

  private void assertInsertSingerParameterMetadata(ParameterMetaData pmd) throws SQLException {
    assertThat(pmd.getParameterCount(), is(equalTo(5)));
    assertByteParam(pmd, 1);
    assertStringParam(pmd, 2);
    assertStringParam(pmd, 3);
    assertBytesParam(pmd, 4);
    assertDateParam(pmd, 5);
  }

  private void assertInsertAlbumParameterMetadata(ParameterMetaData pmd) throws SQLException {
    assertThat(pmd.getParameterCount(), is(equalTo(4)));
    assertLongParam(pmd, 1);
    assertLongParam(pmd, 2);
    assertStringParam(pmd, 3);
    assertLongParam(pmd, 4);
  }

  private void assertInsertSongParameterMetadata(ParameterMetaData pmd) throws SQLException {
    assertThat(pmd.getParameterCount(), is(equalTo(6)));
    assertByteParam(pmd, 1);
    assertIntParam(pmd, 2);
    assertShortParam(pmd, 3);
    assertNStringParam(pmd, 4);
    assertLongParam(pmd, 5);
    assertStringReaderParam(pmd, 6);
  }

  private void assertInsertConcertParameterMetadata(ParameterMetaData pmd) throws SQLException {
    assertThat(pmd.getParameterCount(), is(equalTo(6)));
    assertLongParam(pmd, 1);
    assertLongParam(pmd, 2);
    assertDateParam(pmd, 3);
    assertTimestampParam(pmd, 4);
    assertTimestampParam(pmd, 5);
    assertLongArrayParam(pmd, 6);
  }

  private void assertLongParam(ParameterMetaData pmd, int param) throws SQLException {
    assertThat(pmd.getParameterType(param), is(equalTo(Types.BIGINT)));
    assertThat(pmd.getParameterTypeName(param), is(equalTo("INT64")));
    assertThat(pmd.getPrecision(param), is(equalTo(0)));
    assertThat(pmd.getScale(param), is(equalTo(0)));
    assertThat(pmd.getParameterClassName(param), is(equalTo(Long.class.getName())));
    assertThat(pmd.getParameterMode(param), is(equalTo(ParameterMetaData.parameterModeIn)));
    assertThat(pmd.isNullable(param), is(equalTo(ParameterMetaData.parameterNullableUnknown)));
    assertThat(pmd.isSigned(param), is(true));
  }

  private void assertIntParam(ParameterMetaData pmd, int param) throws SQLException {
    assertThat(pmd.getParameterType(param), is(equalTo(Types.INTEGER)));
    assertThat(pmd.getParameterTypeName(param), is(equalTo("INT64")));
    assertThat(pmd.getPrecision(param), is(equalTo(0)));
    assertThat(pmd.getScale(param), is(equalTo(0)));
    assertThat(pmd.getParameterClassName(param), is(equalTo(Integer.class.getName())));
    assertThat(pmd.getParameterMode(param), is(equalTo(ParameterMetaData.parameterModeIn)));
    assertThat(pmd.isNullable(param), is(equalTo(ParameterMetaData.parameterNullableUnknown)));
    assertThat(pmd.isSigned(param), is(true));
  }

  private void assertShortParam(ParameterMetaData pmd, int param) throws SQLException {
    assertThat(pmd.getParameterType(param), is(equalTo(Types.SMALLINT)));
    assertThat(pmd.getParameterTypeName(param), is(equalTo("INT64")));
    assertThat(pmd.getPrecision(param), is(equalTo(0)));
    assertThat(pmd.getScale(param), is(equalTo(0)));
    assertThat(pmd.getParameterClassName(param), is(equalTo(Short.class.getName())));
    assertThat(pmd.getParameterMode(param), is(equalTo(ParameterMetaData.parameterModeIn)));
    assertThat(pmd.isNullable(param), is(equalTo(ParameterMetaData.parameterNullableUnknown)));
    assertThat(pmd.isSigned(param), is(true));
  }

  private void assertByteParam(ParameterMetaData pmd, int param) throws SQLException {
    assertThat(pmd.getParameterType(param), is(equalTo(Types.TINYINT)));
    assertThat(pmd.getParameterTypeName(param), is(equalTo("INT64")));
    assertThat(pmd.getPrecision(param), is(equalTo(0)));
    assertThat(pmd.getScale(param), is(equalTo(0)));
    assertThat(pmd.getParameterClassName(param), is(equalTo(Byte.class.getName())));
    assertThat(pmd.getParameterMode(param), is(equalTo(ParameterMetaData.parameterModeIn)));
    assertThat(pmd.isNullable(param), is(equalTo(ParameterMetaData.parameterNullableUnknown)));
    assertThat(pmd.isSigned(param), is(true));
  }

  private void assertStringParam(ParameterMetaData pmd, int param) throws SQLException {
    assertThat(pmd.getParameterType(param), is(equalTo(Types.NVARCHAR)));
    assertThat(pmd.getParameterTypeName(param), is(equalTo("STRING")));
    assertThat(pmd.getPrecision(param), is(equalTo(0)));
    assertThat(pmd.getScale(param), is(equalTo(0)));
    assertThat(pmd.getParameterClassName(param), is(equalTo(String.class.getName())));
    assertThat(pmd.getParameterMode(param), is(equalTo(ParameterMetaData.parameterModeIn)));
    assertThat(pmd.isNullable(param), is(equalTo(ParameterMetaData.parameterNullableUnknown)));
    assertThat(pmd.isSigned(param), is(false));
  }

  private void assertNStringParam(ParameterMetaData pmd, int param) throws SQLException {
    assertThat(pmd.getParameterType(param), is(equalTo(Types.NVARCHAR)));
    assertThat(pmd.getParameterTypeName(param), is(equalTo("STRING")));
    assertThat(pmd.getPrecision(param), is(equalTo(0)));
    assertThat(pmd.getScale(param), is(equalTo(0)));
    assertThat(pmd.getParameterClassName(param), is(equalTo(String.class.getName())));
    assertThat(pmd.getParameterMode(param), is(equalTo(ParameterMetaData.parameterModeIn)));
    assertThat(pmd.isNullable(param), is(equalTo(ParameterMetaData.parameterNullableUnknown)));
    assertThat(pmd.isSigned(param), is(false));
  }

  private void assertStringReaderParam(ParameterMetaData pmd, int param) throws SQLException {
    assertThat(pmd.getParameterType(param), is(equalTo(Types.NVARCHAR)));
    assertThat(pmd.getParameterTypeName(param), is(equalTo("STRING")));
    assertThat(pmd.getPrecision(param), is(equalTo(0)));
    assertThat(pmd.getScale(param), is(equalTo(0)));
    assertThat(pmd.getParameterClassName(param), is(equalTo(StringReader.class.getName())));
    assertThat(pmd.getParameterMode(param), is(equalTo(ParameterMetaData.parameterModeIn)));
    assertThat(pmd.isNullable(param), is(equalTo(ParameterMetaData.parameterNullableUnknown)));
    assertThat(pmd.isSigned(param), is(false));
  }

  private void assertBytesParam(ParameterMetaData pmd, int param) throws SQLException {
    assertThat(pmd.getParameterType(param), is(equalTo(Types.BINARY)));
    assertThat(pmd.getParameterTypeName(param), is(equalTo("BYTES")));
    assertThat(pmd.getPrecision(param), is(equalTo(0)));
    assertThat(pmd.getScale(param), is(equalTo(0)));
    assertThat(pmd.getParameterClassName(param), is(equalTo(byte[].class.getName())));
    assertThat(pmd.getParameterMode(param), is(equalTo(ParameterMetaData.parameterModeIn)));
    assertThat(pmd.isNullable(param), is(equalTo(ParameterMetaData.parameterNullableUnknown)));
    assertThat(pmd.isSigned(param), is(false));
  }

  private void assertDateParam(ParameterMetaData pmd, int param) throws SQLException {
    assertThat(pmd.getParameterType(param), is(equalTo(Types.DATE)));
    assertThat(pmd.getParameterTypeName(param), is(equalTo("DATE")));
    assertThat(pmd.getPrecision(param), is(equalTo(0)));
    assertThat(pmd.getScale(param), is(equalTo(0)));
    assertThat(pmd.getParameterClassName(param), is(equalTo(Date.class.getName())));
    assertThat(pmd.getParameterMode(param), is(equalTo(ParameterMetaData.parameterModeIn)));
    assertThat(pmd.isNullable(param), is(equalTo(ParameterMetaData.parameterNullableUnknown)));
    assertThat(pmd.isSigned(param), is(false));
  }

  private void assertTimestampParam(ParameterMetaData pmd, int param) throws SQLException {
    assertThat(pmd.getParameterType(param), is(equalTo(Types.TIMESTAMP)));
    assertThat(pmd.getParameterTypeName(param), is(equalTo("TIMESTAMP")));
    assertThat(pmd.getPrecision(param), is(equalTo(0)));
    assertThat(pmd.getScale(param), is(equalTo(0)));
    assertThat(pmd.getParameterClassName(param), is(equalTo(Timestamp.class.getName())));
    assertThat(pmd.getParameterMode(param), is(equalTo(ParameterMetaData.parameterModeIn)));
    assertThat(pmd.isNullable(param), is(equalTo(ParameterMetaData.parameterNullableUnknown)));
    assertThat(pmd.isSigned(param), is(false));
  }

  private void assertLongArrayParam(ParameterMetaData pmd, int param) throws SQLException {
    assertThat(pmd.getParameterType(param), is(equalTo(Types.ARRAY)));
    assertThat(pmd.getParameterTypeName(param), is(equalTo("ARRAY")));
    assertThat(pmd.getPrecision(param), is(equalTo(0)));
    assertThat(pmd.getScale(param), is(equalTo(0)));
    assertThat(
        pmd.getParameterClassName(param), is(equalTo("com.google.cloud.spanner.jdbc.JdbcArray")));
    assertThat(pmd.getParameterMode(param), is(equalTo(ParameterMetaData.parameterModeIn)));
    assertThat(pmd.isNullable(param), is(equalTo(ParameterMetaData.parameterNullableUnknown)));
    assertThat(pmd.isSigned(param), is(false));
  }
}
