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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.ByteArray;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.jdbc.JsonType;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.io.BaseEncoding;
import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.UUID;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/** Integration tests for JDBC {@link PreparedStatement}s. */
@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ITJdbcPreparedStatementTest extends ITAbstractJdbcTest {
  @ClassRule public static JdbcIntegrationTestEnv env = new JdbcIntegrationTestEnv();

  @Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    List<DialectTestParameter> params = new ArrayList<>();
    params.add(new DialectTestParameter(Dialect.GOOGLE_STANDARD_SQL));
    params.add(new DialectTestParameter(Dialect.POSTGRESQL));
    return params;
  }

  @Parameter public DialectTestParameter dialect;

  private Database database;

  @Before
  public void setup() {
    database = env.getOrCreateDatabase(getDialect(), getMusicTablesDdl(getDialect()));
  }

  @Override
  public Dialect getDialect() {
    return dialect.dialect;
  }

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
          Long.parseLong(array[0]), // singer id
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

    private void setPreparedStatement(PreparedStatement ps, Dialect dialect) throws SQLException {
      ps.setByte(1, (byte) this.singerId);
      ps.setString(2, this.firstName);
      ps.setString(3, this.lastName);
      ps.setBytes(4, this.singerInfo);
      ps.setDate(5, this.birthDate);
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
          Long.parseLong(array[0]), // singer id
          Long.parseLong(array[1]), // album id
          array[2].substring(1, array[2].length() - 1), // album title
          Long.parseLong(array[3]) // marketing budget
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
          Long.parseLong(array[0]), // singer id
          Long.parseLong(array[1]), // album id
          Long.parseLong(array[2]), // song id
          array[3].substring(1, array[3].length() - 1), // song name
          Long.parseLong(array[4]), // duration
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
      values = values.replaceAll("\\[(\\d+),(\\d+),(\\d+),(\\d+)]", "[$1;$2;$3;$4]");
      String[] array = values.split(",");
      if (array.length != 6) {
        throw new IllegalArgumentException(values);
      }
      return new Concert(
          Long.parseLong(array[0]), // venue id
          Long.parseLong(array[1]), // singer id
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

    private void setPreparedStatement(Connection connection, PreparedStatement ps, Dialect dialect)
        throws SQLException {
      ps.setLong(1, this.venueId);
      ps.setLong(2, this.singerId);
      ps.setDate(3, this.concertDate);
      ps.setTimestamp(4, this.beginTime);
      ps.setTimestamp(5, this.endTime);
      ps.setArray(6, connection.createArrayOf("INT64", this.ticketPrices));
    }

    private void assertEqualsFields(Connection connection, ResultSet rs, Dialect dialect)
        throws SQLException {
      assertEquals(rs.getLong(1), this.venueId);
      assertEquals(rs.getLong(2), this.singerId);
      assertEquals(rs.getDate(3), this.concertDate);
      assertEquals(rs.getTimestamp(4), this.beginTime);
      assertEquals(rs.getTimestamp(5), this.endTime);
      assertArrayEquals(
          (Object[]) rs.getArray(6).getArray(),
          (Object[]) connection.createArrayOf("INT64", this.ticketPrices).getArray());
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
    return BaseEncoding.base64().decode(value);
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

  private String getConcertsInsertQuery(Dialect dialect) {
    return "INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (?,?,?,?,?,?);";
  }

  private String getConcertsInsertReturningQuery(Dialect dialect) {
    if (dialect == Dialect.POSTGRESQL) {
      return "INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (?,?,?,?,?,?) RETURNING *;";
    }
    return "INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (?,?,?,?,?,?) THEN RETURN *;";
  }

  private String getSingersInsertReturningQuery(Dialect dialect) {
    if (dialect == Dialect.POSTGRESQL) {
      return "INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) values (?,?,?,?,?) RETURNING *";
    }
    return "INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) values (?,?,?,?,?) THEN RETURN *";
  }

  private String getAlbumsInsertReturningQuery(Dialect dialect) {
    if (dialect == Dialect.POSTGRESQL) {
      return "INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (?,?,?,?) RETURNING *";
    }
    return "INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (?,?,?,?) THEN RETURN *";
  }

  private String getSongsInsertReturningQuery(Dialect dialect) {
    if (dialect == Dialect.POSTGRESQL) {
      return "INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (?,?,?,?,?,?) RETURNING *;";
    }
    return "INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (?,?,?,?,?,?) THEN RETURN *;";
  }

  @Test
  public void test01_InsertTestData() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      connection.setAutoCommit(false);
      try (PreparedStatement ps =
          connection.prepareStatement(
              "INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo, BirthDate) values (?,?,?,?,?)")) {
        assertParameterMetaData(
            ps.getParameterMetaData(),
            ImmutableList.of(
                Types.BIGINT, Types.NVARCHAR, Types.NVARCHAR, Types.BINARY, Types.DATE),
            dialect.dialect == Dialect.POSTGRESQL
                ? ImmutableList.of(
                    "bigint", "character varying", "character varying", "bytea", "date")
                : ImmutableList.of("INT64", "STRING", "STRING", "BYTES", "DATE"),
            ImmutableList.of(Long.class, String.class, String.class, byte[].class, Date.class));
        for (Singer singer : createSingers()) {
          singer.setPreparedStatement(ps, getDialect());
          assertInsertSingerParameterMetadata(ps.getParameterMetaData());
          ps.addBatch();
          // check that adding the current params to a batch will not reset the meta data
          assertInsertSingerParameterMetadata(ps.getParameterMetaData());
        }
        int[] results = ps.executeBatch();
        for (int res : results) {
          assertEquals(1, res);
        }
      }
      try (PreparedStatement ps =
          connection.prepareStatement(
              "INSERT INTO Albums (SingerId, AlbumId, AlbumTitle, MarketingBudget) VALUES (?,?,?,?)")) {
        assertParameterMetaData(
            ps.getParameterMetaData(),
            ImmutableList.of(Types.BIGINT, Types.BIGINT, Types.NVARCHAR, Types.BIGINT),
            dialect.dialect == Dialect.POSTGRESQL
                ? ImmutableList.of("bigint", "bigint", "character varying", "bigint")
                : ImmutableList.of("INT64", "INT64", "STRING", "INT64"),
            ImmutableList.of(Long.class, Long.class, String.class, Long.class));
        for (Album album : createAlbums()) {
          ps.setLong(1, album.singerId);
          ps.setLong(2, album.albumId);
          ps.setString(3, album.albumTitle);
          ps.setLong(4, album.marketingBudget);
          assertInsertAlbumParameterMetadata(ps.getParameterMetaData());
          assertEquals(1, ps.executeUpdate());
          // check that calling executeUpdate will not reset the meta data
          assertInsertAlbumParameterMetadata(ps.getParameterMetaData());
        }
      }
      try (PreparedStatement ps =
          connection.prepareStatement(
              "INSERT INTO Songs (SingerId, AlbumId, TrackId, SongName, Duration, SongGenre) VALUES (?,?,?,?,?,?);")) {
        assertParameterMetaData(
            ps.getParameterMetaData(),
            ImmutableList.of(
                Types.BIGINT,
                Types.BIGINT,
                Types.BIGINT,
                Types.NVARCHAR,
                Types.BIGINT,
                Types.NVARCHAR),
            dialect.dialect == Dialect.POSTGRESQL
                ? ImmutableList.of(
                    "bigint",
                    "bigint",
                    "bigint",
                    "character varying",
                    "bigint",
                    "character varying")
                : ImmutableList.of("INT64", "INT64", "INT64", "STRING", "INT64", "STRING"),
            ImmutableList.of(
                Long.class, Long.class, Long.class, String.class, Long.class, String.class));
        for (Song song : createSongs()) {
          ps.setByte(1, (byte) song.singerId);
          ps.setInt(2, (int) song.albumId);
          ps.setShort(3, (short) song.songId);
          ps.setNString(4, song.songName);
          ps.setLong(5, song.duration);
          ps.setCharacterStream(6, new StringReader(song.songGenre));
          assertInsertSongParameterMetadata(ps.getParameterMetaData());
          assertEquals(1, ps.executeUpdate());
          // check that calling executeUpdate will not reset the meta data
          assertInsertSongParameterMetadata(ps.getParameterMetaData());
        }
      }
      try (PreparedStatement ps =
          connection.prepareStatement(getConcertsInsertQuery(dialect.dialect))) {
        assertParameterMetaData(
            ps.getParameterMetaData(),
            ImmutableList.of(
                Types.BIGINT,
                Types.BIGINT,
                Types.DATE,
                Types.TIMESTAMP,
                Types.TIMESTAMP,
                Types.ARRAY),
            dialect.dialect == Dialect.POSTGRESQL
                ? ImmutableList.of(
                    "bigint",
                    "bigint",
                    "date",
                    "timestamp with time zone",
                    "timestamp with time zone",
                    "bigint[]")
                : ImmutableList.of(
                    "INT64", "INT64", "DATE", "TIMESTAMP", "TIMESTAMP", "ARRAY<INT64>"),
            ImmutableList.of(
                Long.class,
                Long.class,
                Date.class,
                Timestamp.class,
                Timestamp.class,
                Long[].class));
        for (Concert concert : createConcerts()) {
          concert.setPreparedStatement(connection, ps, getDialect());
          assertInsertConcertParameterMetadata(ps.getParameterMetaData());
          assertEquals(1, ps.executeUpdate());
          // check that calling executeUpdate will not reset the metadata.
          assertInsertConcertParameterMetadata(ps.getParameterMetaData());
        }
      }
      connection.commit();
    }
  }

  @Test
  public void test02_VerifyTestData() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      try (ResultSet rs =
          connection.createStatement().executeQuery("SELECT COUNT(*) FROM Singers")) {
        assertTrue(rs.next());
        assertEquals(30, rs.getInt(1));
        assertFalse(rs.next());
      }
      try (ResultSet rs =
          connection.createStatement().executeQuery("SELECT COUNT(*) FROM Albums")) {
        assertTrue(rs.next());
        assertEquals(60, rs.getByte(1));
        assertFalse(rs.next());
      }
      try (ResultSet rs = connection.createStatement().executeQuery("SELECT COUNT(*) FROM Songs")) {
        assertTrue(rs.next());
        assertEquals(149, rs.getShort(1));
        assertFalse(rs.next());
      }
      try (ResultSet rs =
          connection.createStatement().executeQuery("SELECT COUNT(*) FROM Concerts")) {
        assertTrue(rs.next());
        assertEquals(100L, rs.getLong(1));
        assertFalse(rs.next());
      }
      try (PreparedStatement ps =
          connection.prepareStatement("SELECT * FROM Concerts WHERE VenueId=? AND SingerId=?")) {
        ps.setLong(1, 1L);
        ps.setLong(2, 1L);
        // Expected:
        // (1,1,DATE '2003-06-19',TIMESTAMP '2003-06-19T12:30:05Z',TIMESTAMP
        // '2003-06-19T18:57:15Z',[11,93,140,923]);
        try (ResultSet rs = ps.executeQuery()) {
          assertTrue(rs.next());
          assertEquals(1L, rs.getLong(1));
          assertEquals(1L, rs.getLong(2));
          assertEquals(Date.valueOf("2003-06-19"), rs.getDate(3));
          assertEquals(Timestamp.valueOf("2003-06-19 12:30:05"), rs.getTimestamp(4));
          assertEquals(Timestamp.valueOf("2003-06-19 18:57:15"), rs.getTimestamp(5));
          assertArrayEquals(new Long[] {11L, 93L, 140L, 923L}, (Long[]) rs.getArray(6).getArray());
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
    cal.set(2015, Calendar.NOVEMBER, 15, 10, 0, 0);
    testDates.add(new Date(cal.getTimeInMillis()));

    cal = Calendar.getInstance(TimeZone.getTimeZone("CET"));
    cal.clear();
    cal.set(2015, Calendar.NOVEMBER, 15, 10, 0, 0);
    testDates.add(new Date(cal.getTimeInMillis()));

    cal = Calendar.getInstance(TimeZone.getTimeZone("PST"));
    cal.clear();
    cal.set(2015, Calendar.NOVEMBER, 15, 10, 0, 0);
    testDates.add(new Date(cal.getTimeInMillis()));

    List<Calendar> calendars = new ArrayList<>();
    calendars.add(null);
    calendars.add(Calendar.getInstance());
    calendars.add(Calendar.getInstance(TimeZone.getTimeZone("UTC")));
    calendars.add(Calendar.getInstance(TimeZone.getTimeZone("CET")));
    calendars.add(Calendar.getInstance(TimeZone.getTimeZone("PST")));

    try (Connection connection = createConnection(env, database)) {
      for (Calendar testCalendar : calendars) {
        int index = 0;
        for (Date testDate : testDates) {
          try (PreparedStatement ps =
              connection.prepareStatement(
                  "INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (?,?,?,?,?,?);")) {
            assertParameterMetaData(
                ps.getParameterMetaData(),
                ImmutableList.of(
                    Types.BIGINT,
                    Types.BIGINT,
                    Types.DATE,
                    Types.TIMESTAMP,
                    Types.TIMESTAMP,
                    Types.ARRAY),
                dialect.dialect == Dialect.POSTGRESQL
                    ? ImmutableList.of(
                        "bigint",
                        "bigint",
                        "date",
                        "timestamp with time zone",
                        "timestamp with time zone",
                        "bigint[]")
                    : ImmutableList.of(
                        "INT64", "INT64", "DATE", "TIMESTAMP", "TIMESTAMP", "ARRAY<INT64>"),
                ImmutableList.of(
                    Long.class,
                    Long.class,
                    Date.class,
                    Timestamp.class,
                    Timestamp.class,
                    Long[].class));
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
              assertTrue(rs.next());
              if (testCalendar == null) {
                assertEquals(Date.valueOf(expectedValues.get(index)), rs.getDate(3));
              } else {
                // Parse the date in the local timezone.
                Date date = Date.valueOf(expectedValues.get(index));
                // Create a calendar in the test timezone with only the date part set.
                Calendar localCalendar = Calendar.getInstance(testCalendar.getTimeZone());
                localCalendar.clear();
                localCalendar.set(date.getYear() + 1900, date.getMonth(), date.getDate());
                // Check that the actual time of the date returned by the ResultSet is equal to the
                // local time in the timezone of the Calendar that is used.
                assertEquals(
                    new Date(localCalendar.getTimeInMillis()), rs.getDate(3, testCalendar));
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
    cal.set(2015, Calendar.NOVEMBER, 15);
    testTimestamps.add(new Timestamp(cal.getTimeInMillis()));

    cal = Calendar.getInstance(TimeZone.getTimeZone("CET"));
    cal.clear();
    cal.set(2015, Calendar.NOVEMBER, 15);
    testTimestamps.add(new Timestamp(cal.getTimeInMillis()));

    cal = Calendar.getInstance(TimeZone.getTimeZone("PST"));
    cal.clear();
    cal.set(2015, Calendar.NOVEMBER, 15);
    testTimestamps.add(new Timestamp(cal.getTimeInMillis()));

    List<Calendar> calendars = new ArrayList<>();
    calendars.add(null);
    calendars.add(Calendar.getInstance());
    calendars.add(Calendar.getInstance(TimeZone.getTimeZone("UTC")));
    calendars.add(Calendar.getInstance(TimeZone.getTimeZone("CET")));
    calendars.add(Calendar.getInstance(TimeZone.getTimeZone("PST")));

    try (Connection connection = createConnection(env, database)) {
      for (Calendar testCalendar : calendars) {
        for (Timestamp testTimestamp : testTimestamps) {
          try (PreparedStatement ps =
              connection.prepareStatement(
                  "INSERT INTO Concerts (VenueId, SingerId, ConcertDate, BeginTime, EndTime, TicketPrices) VALUES (?,?,?,?,?,?);")) {
            assertParameterMetaData(
                ps.getParameterMetaData(),
                ImmutableList.of(
                    Types.BIGINT,
                    Types.BIGINT,
                    Types.DATE,
                    Types.TIMESTAMP,
                    Types.TIMESTAMP,
                    Types.ARRAY),
                dialect.dialect == Dialect.POSTGRESQL
                    ? ImmutableList.of(
                        "bigint",
                        "bigint",
                        "date",
                        "timestamp with time zone",
                        "timestamp with time zone",
                        "bigint[]")
                    : ImmutableList.of(
                        "INT64", "INT64", "DATE", "TIMESTAMP", "TIMESTAMP", "ARRAY<INT64>"),
                ImmutableList.of(
                    Long.class,
                    Long.class,
                    Date.class,
                    Timestamp.class,
                    Timestamp.class,
                    Long[].class));
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
              assertTrue(rs.next());

              // First test the timestamp that was sent to Spanner using the default timezone.
              // Get the timestamp in the default timezone.
              Timestamp inDefaultTZ = rs.getTimestamp(4);
              assertEquals(testTimestamp.getTime(), inDefaultTZ.getTime());
              // Then get it in the test timezone.
              if (testCalendar != null) {
                Timestamp inOtherTZ = rs.getTimestamp(4, testCalendar);
                assertEquals(
                    "Timezone: "
                        + testCalendar
                        + ", rawOffset="
                        + testCalendar.getTimeZone().getRawOffset()
                        + ", os="
                        + System.getProperty("os.name")
                        + ", vm="
                        + System.getProperty("java.vm.name")
                        + ", vendor="
                        + System.getProperty("java.vendor"),
                    testTimestamp.getTime()
                        + testCalendar.getTimeZone().getOffset(inDefaultTZ.getTime()),
                    inOtherTZ.getTime());
              }

              // Then test the timestamp that was sent to Spanner using a specific timezone.
              // Get the timestamp in the default timezone.
              inDefaultTZ = rs.getTimestamp(5);
              if (testCalendar == null) {
                assertEquals(testTimestamp.getTime(), inDefaultTZ.getTime());
              } else {
                assertEquals(
                    "Timezone: "
                        + testCalendar
                        + ", rawOffset="
                        + testCalendar.getTimeZone().getRawOffset()
                        + ", os="
                        + System.getProperty("os.name")
                        + ", vm="
                        + System.getProperty("java.vm.name")
                        + ", vendor="
                        + System.getProperty("java.vendor"),
                    testTimestamp.getTime()
                        - testCalendar.getTimeZone().getOffset(inDefaultTZ.getTime()),
                    inDefaultTZ.getTime());
              }
              // Then get it in the test timezone.
              if (testCalendar != null) {
                Timestamp inOtherTZ = rs.getTimestamp(5, testCalendar);
                assertEquals(testTimestamp.getTime(), inOtherTZ.getTime());
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
      try (Connection con1 = createConnection(env, database);
          Connection con2 = createConnection(env, database)) {
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
        assertEquals(params.length, updateCounts.length);
        long totalUpdated = 0;
        try (PreparedStatement ps =
            con1.prepareStatement("SELECT COUNT(*) FROM Singers WHERE LastName LIKE ?")) {
          for (int i = 0; i < updateCounts.length; i++) {
            ps.setString(1, params[i]);
            try (ResultSet rs = ps.executeQuery()) {
              assertTrue(rs.next());
              assertEquals(rs.getInt(1), updateCounts[i]);
              totalUpdated += updateCounts[i];
            }
          }
        }
        // Check whether the updated values are readable on the second connection.
        try (ResultSet rs =
            con2.createStatement()
                .executeQuery("SELECT COUNT(*) FROM Singers WHERE FirstName=LastName")) {
          assertTrue(rs.next());
          if (autocommit) {
            assertEquals(totalUpdated, rs.getLong(1));
          } else {
            assertEquals(0, rs.getLong(1));
          }
        }
        // If not in autocommit mode --> commit and verify.
        if (!autocommit) {
          con1.commit();
          try (ResultSet rs =
              con2.createStatement()
                  .executeQuery("SELECT COUNT(*) FROM Singers WHERE FirstName=LastName")) {
            assertTrue(rs.next());
            assertEquals(totalUpdated, rs.getLong(1));
          }
        }
        // Set first names to null for the updated records for the next test run.
        int updateCount =
            con2.createStatement()
                .executeUpdate("UPDATE Singers SET FirstName=null WHERE FirstName=LastName");
        assertEquals(totalUpdated, updateCount);
      }
    }
  }

  @Test
  public void test06_BatchUpdatesWithException() throws SQLException {
    for (boolean autocommit : new boolean[] {true, false}) {
      try (Connection con1 = createConnection(env, database);
          Connection con2 = createConnection(env, database)) {
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
          assertEquals(2, e.getUpdateCounts().length);
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
    try (Connection con = createConnection(env, database)) {
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
        assertNotNull(e.getUpdateCounts());
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
        assertNotNull(e.getUpdateCounts());
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
        assertNotNull(e.getUpdateCounts());
      }
    }
  }

  @Test
  public void test08_InsertAllColumnTypes() throws SQLException {
    assumeFalse(
        "TableWithAllColumnTypes type is not supported on POSTGRESQL dialect",
        dialect.dialect == Dialect.POSTGRESQL);
    String sql =
        "INSERT INTO TableWithAllColumnTypes ("
            + "ColInt64, ColFloat64, ColFloat32, ColBool, ColString, ColStringMax, ColBytes, ColBytesMax, ColDate, ColTimestamp, ColCommitTS, ColNumeric, ColJson, "
            + "ColInt64Array, ColFloat64Array, ColFloat32Array, ColBoolArray, ColStringArray, ColStringMaxArray, ColBytesArray, ColBytesMaxArray, ColDateArray, ColTimestampArray, ColNumericArray, ColJsonArray"
            + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, PENDING_COMMIT_TIMESTAMP(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection con = createConnection(env, database)) {
      try (PreparedStatement ps = con.prepareStatement(sql)) {
        ParameterMetaData metadata = ps.getParameterMetaData();
        assertEquals(24, metadata.getParameterCount());
        int index = 0;
        assertEquals(Types.BIGINT, metadata.getParameterType(++index));
        assertEquals(Types.DOUBLE, metadata.getParameterType(++index));
        assertEquals(Types.REAL, metadata.getParameterType(++index));
        assertEquals(Types.BOOLEAN, metadata.getParameterType(++index));
        assertEquals(Types.NVARCHAR, metadata.getParameterType(++index));
        assertEquals(Types.NVARCHAR, metadata.getParameterType(++index));
        assertEquals(Types.BINARY, metadata.getParameterType(++index));
        assertEquals(Types.BINARY, metadata.getParameterType(++index));
        assertEquals(Types.DATE, metadata.getParameterType(++index));
        assertEquals(Types.TIMESTAMP, metadata.getParameterType(++index));
        assertEquals(Types.NUMERIC, metadata.getParameterType(++index));
        assertEquals(JsonType.VENDOR_TYPE_NUMBER, metadata.getParameterType(++index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));
        assertEquals(Types.ARRAY, metadata.getParameterType(++index));

        index = 0;
        ps.setLong(++index, 1L);
        ps.setDouble(++index, 2D);
        ps.setFloat(++index, 3.14f);
        ps.setBoolean(++index, true);
        ps.setString(++index, "test");
        ps.setObject(++index, UUID.fromString("2d37f522-e0a5-4f22-8e09-4d77d299c967"));
        ps.setBytes(++index, "test".getBytes());
        ps.setBytes(++index, "testtest".getBytes());
        ps.setDate(++index, new Date(System.currentTimeMillis()));
        ps.setTimestamp(++index, new Timestamp(System.currentTimeMillis()));
        ps.setBigDecimal(++index, BigDecimal.TEN);
        ps.setObject(++index, "{\"test_value\": \"foo\"}", JsonType.INSTANCE);

        ps.setArray(++index, con.createArrayOf("INT64", new Long[] {1L, 2L, 3L}));
        ps.setArray(++index, con.createArrayOf("FLOAT64", new Double[] {1.1D, 2.2D, 3.3D}));
        ps.setArray(++index, con.createArrayOf("FLOAT32", new Float[] {1.1f, 2.2f, 3.3f}));
        ps.setArray(
            ++index, con.createArrayOf("BOOL", new Boolean[] {Boolean.TRUE, null, Boolean.FALSE}));
        ps.setArray(++index, con.createArrayOf("STRING", new String[] {"1", "2", "3"}));
        ps.setArray(++index, con.createArrayOf("STRING", new String[] {"3", "2", "1"}));
        ps.setArray(
            ++index,
            con.createArrayOf(
                "BYTES", new byte[][] {"1".getBytes(), "2".getBytes(), "3".getBytes()}));
        ps.setArray(
            ++index,
            con.createArrayOf(
                "BYTES", new byte[][] {"333".getBytes(), "222".getBytes(), "111".getBytes()}));
        ps.setArray(
            ++index,
            con.createArrayOf(
                "DATE", new Date[] {new Date(System.currentTimeMillis()), null, new Date(0)}));
        ps.setArray(
            ++index,
            con.createArrayOf(
                "TIMESTAMP",
                new Timestamp[] {
                  new Timestamp(System.currentTimeMillis()), null, new Timestamp(0)
                }));
        ps.setArray(
            ++index,
            con.createArrayOf("NUMERIC", new BigDecimal[] {BigDecimal.ONE, null, BigDecimal.TEN}));
        ps.setArray(
            ++index,
            con.createArrayOf(
                "JSON", new String[] {"{\"test_value\": \"foo\"}", "{}", "[]", null}));
        assertEquals(1, ps.executeUpdate());
      }
      try (ResultSet rs =
          con.createStatement().executeQuery("SELECT * FROM TableWithAllColumnTypes")) {
        int index = 0;
        assertTrue(rs.next());
        assertEquals(1L, rs.getLong(++index));
        assertEquals(2d, rs.getDouble(++index), 0.0d);
        assertEquals(3.14f, rs.getFloat(++index), 0.0f);
        assertTrue(rs.getBoolean(++index));
        assertEquals("test", rs.getString(++index));
        assertEquals("2d37f522-e0a5-4f22-8e09-4d77d299c967", rs.getString(++index));
        assertArrayEquals("test".getBytes(), rs.getBytes(++index));
        assertArrayEquals("testtest".getBytes(), rs.getBytes(++index));
        assertNotNull(rs.getDate(++index));
        assertNotNull(rs.getTimestamp(++index));
        assertNotNull(rs.getTime(++index)); // Commit timestamp
        assertEquals(BigDecimal.TEN, rs.getBigDecimal(++index));
        assertEquals("{\"test_value\":\"foo\"}", rs.getString(++index));

        assertArrayEquals(new Long[] {1L, 2L, 3L}, (Long[]) rs.getArray(++index).getArray());
        assertArrayEquals(
            new Double[] {1.1D, 2.2D, 3.3D}, (Double[]) rs.getArray(++index).getArray());
        assertArrayEquals(
            new Float[] {1.1f, 2.2f, 3.3f}, (Float[]) rs.getArray(++index).getArray());
        assertArrayEquals(
            new Boolean[] {true, null, false}, (Boolean[]) rs.getArray(++index).getArray());
        assertArrayEquals(new String[] {"1", "2", "3"}, (String[]) rs.getArray(++index).getArray());
        assertArrayEquals(new String[] {"3", "2", "1"}, (String[]) rs.getArray(++index).getArray());
        assertArrayEquals(
            new byte[][] {"1".getBytes(), "2".getBytes(), "3".getBytes()},
            (byte[][]) rs.getArray(++index).getArray());
        assertArrayEquals(
            new byte[][] {"333".getBytes(), "222".getBytes(), "111".getBytes()},
            (byte[][]) rs.getArray(++index).getArray());
        assertEquals(3, ((Date[]) rs.getArray(++index).getArray()).length);
        assertEquals(3, ((Timestamp[]) rs.getArray(++index).getArray()).length);
        assertArrayEquals(
            new BigDecimal[] {BigDecimal.ONE, null, BigDecimal.TEN},
            (BigDecimal[]) rs.getArray(++index).getArray());
        assertArrayEquals(
            new String[] {"{\"test_value\":\"foo\"}", "{}", "[]", null},
            (String[]) rs.getArray(++index).getArray());
        assertFalse(rs.next());
      }
    }
  }

  @Test
  public void test08_PGInsertAllColumnTypes() throws SQLException {
    assumeTrue(dialect.dialect == Dialect.POSTGRESQL);

    String sql =
        "INSERT INTO TableWithAllColumnTypes ("
            + "ColInt64, ColFloat64, ColFloat32, ColBool, ColString, ColStringMax, ColBytes, ColDate, ColTimestamp, ColNumeric, ColJson"
            + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection con = createConnection(env, database)) {
      try (PreparedStatement ps = con.prepareStatement(sql)) {
        int index = 0;
        ps.setLong(++index, 1L);
        ps.setDouble(++index, 2D);
        ps.setFloat(++index, 3.14f);
        ps.setBoolean(++index, true);
        ps.setString(++index, "test");
        ps.setObject(++index, UUID.fromString("2d37f522-e0a5-4f22-8e09-4d77d299c967"));
        ps.setBytes(++index, "test".getBytes());
        ps.setDate(++index, new Date(System.currentTimeMillis()));
        ps.setTimestamp(++index, new Timestamp(System.currentTimeMillis()));
        ps.setBigDecimal(++index, BigDecimal.TEN);
        // TODO: This test currently uses string/varchar. This should be updated to JSONB.
        ps.setObject(++index, "{\"test_value\": \"foo\"}", Types.VARCHAR);

        assertEquals(1, ps.executeUpdate());
      }
      try (ResultSet rs =
          con.createStatement().executeQuery("SELECT * FROM TableWithAllColumnTypes")) {
        int index = 0;
        assertTrue(rs.next());
        assertEquals(1L, rs.getLong(++index));
        assertEquals(2d, rs.getDouble(++index), 0.0d);
        assertEquals(3.14f, rs.getFloat(++index), 0.0f);
        assertTrue(rs.getBoolean(++index));
        assertEquals("test", rs.getString(++index));
        assertEquals("2d37f522-e0a5-4f22-8e09-4d77d299c967", rs.getString(++index));
        assertArrayEquals("test".getBytes(), rs.getBytes(++index));
        assertNotNull(rs.getDate(++index));
        assertNotNull(rs.getTimestamp(++index));
        assertEquals(BigDecimal.TEN, rs.getBigDecimal(++index));
        assertEquals("{\"test_value\": \"foo\"}", rs.getString(++index));

        assertFalse(rs.next());
      }
    }
  }

  @Test
  public void test09_MetaData_FromQuery() throws SQLException {
    assumeFalse(
        "TableWithAllColumnTypes type is not supported on POSTGRESQL dialect",
        dialect.dialect == Dialect.POSTGRESQL);
    try (Connection con = createConnection(env, database)) {
      try (PreparedStatement ps =
          con.prepareStatement("SELECT * FROM TableWithAllColumnTypes WHERE ColInt64=?")) {
        ResultSetMetaData metadata = ps.getMetaData();
        assertEquals(27, metadata.getColumnCount());
        int index = 0;
        assertEquals("ColInt64", metadata.getColumnLabel(++index));
        assertEquals("ColFloat64", metadata.getColumnLabel(++index));
        assertEquals("ColFloat32", metadata.getColumnLabel(++index));
        assertEquals("ColBool", metadata.getColumnLabel(++index));
        assertEquals("ColString", metadata.getColumnLabel(++index));
        assertEquals("ColStringMax", metadata.getColumnLabel(++index));
        assertEquals("ColBytes", metadata.getColumnLabel(++index));
        assertEquals("ColBytesMax", metadata.getColumnLabel(++index));
        assertEquals("ColDate", metadata.getColumnLabel(++index));
        assertEquals("ColTimestamp", metadata.getColumnLabel(++index));
        assertEquals("ColCommitTS", metadata.getColumnLabel(++index));
        assertEquals("ColNumeric", metadata.getColumnLabel(++index));
        assertEquals("ColJson", metadata.getColumnLabel(++index));
        assertEquals("ColInt64Array", metadata.getColumnLabel(++index));
        assertEquals("ColFloat64Array", metadata.getColumnLabel(++index));
        assertEquals("ColFloat32Array", metadata.getColumnLabel(++index));
        assertEquals("ColBoolArray", metadata.getColumnLabel(++index));
        assertEquals("ColStringArray", metadata.getColumnLabel(++index));
        assertEquals("ColStringMaxArray", metadata.getColumnLabel(++index));
        assertEquals("ColBytesArray", metadata.getColumnLabel(++index));
        assertEquals("ColBytesMaxArray", metadata.getColumnLabel(++index));
        assertEquals("ColDateArray", metadata.getColumnLabel(++index));
        assertEquals("ColTimestampArray", metadata.getColumnLabel(++index));
        assertEquals("ColNumericArray", metadata.getColumnLabel(++index));
        assertEquals("ColJsonArray", metadata.getColumnLabel(++index));
        assertEquals("ColComputed", metadata.getColumnLabel(++index));
        assertEquals("ColIdentity", metadata.getColumnLabel(++index));
      }
    }
  }

  @Test
  public void test10_MetaData_FromDML() throws SQLException {
    assumeFalse(
        "TableWithAllColumnTypes type is not supported on POSTGRESQL dialect",
        dialect.dialect == Dialect.POSTGRESQL);
    try (Connection con = createConnection(env, database)) {
      try (PreparedStatement ps =
          con.prepareStatement(
              "UPDATE TableWithAllColumnTypes SET ColBool=FALSE WHERE ColInt64=?")) {
        ResultSetMetaData metadata = ps.getMetaData();
        assertEquals(0, metadata.getColumnCount());
      }
    }
  }

  @Test
  public void test11_InsertDataUsingSpannerValue() throws SQLException {
    assumeFalse(
        "TableWithAllColumnTypes type is not supported on POSTGRESQL dialect",
        dialect.dialect == Dialect.POSTGRESQL);
    String sql =
        "INSERT INTO TableWithAllColumnTypes ("
            + "ColInt64, ColFloat64, ColFloat32, ColBool, ColString, ColStringMax, ColBytes, ColBytesMax, ColDate, ColTimestamp, ColCommitTS, ColNumeric, ColJson, "
            + "ColInt64Array, ColFloat64Array, ColFloat32Array, ColBoolArray, ColStringArray, ColStringMaxArray, ColBytesArray, ColBytesMaxArray, ColDateArray, ColTimestampArray, ColNumericArray, ColJsonArray"
            + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, PENDING_COMMIT_TIMESTAMP(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection con = createConnection(env, database)) {
      try (PreparedStatement ps = con.prepareStatement(sql)) {
        int index = 1;
        ps.setObject(index++, Value.int64(2L));
        ps.setObject(index++, Value.float64(2D));
        ps.setObject(index++, Value.float32(3.14f));
        ps.setObject(index++, Value.bool(true));
        ps.setObject(index++, Value.string("testvalues"));
        ps.setObject(index++, Value.string("2d37f522-e0a5-4f22-8e09-4d77d299c967"));
        ps.setObject(index++, Value.bytes(ByteArray.copyFrom("test".getBytes())));
        ps.setObject(index++, Value.bytes(ByteArray.copyFrom("testtest".getBytes())));
        ps.setObject(index++, Value.date(com.google.cloud.Date.fromYearMonthDay(2021, 5, 3)));
        ps.setObject(
            index++, Value.timestamp(com.google.cloud.Timestamp.ofTimeSecondsAndNanos(99999L, 99)));
        ps.setObject(index++, Value.numeric(BigDecimal.TEN));
        ps.setObject(index++, Value.json("{\"test_value\": \"foo\"}"));

        ps.setObject(index++, Value.int64Array(new long[] {1L, 2L, 3L}));
        ps.setObject(index++, Value.float64Array(new double[] {1.1D, 2.2D, 3.3D}));
        ps.setObject(index++, Value.float32Array(new float[] {1.1f, 2.2f, 3.3f}));
        ps.setObject(index++, Value.boolArray(Arrays.asList(Boolean.TRUE, null, Boolean.FALSE)));
        ps.setObject(index++, Value.stringArray(Arrays.asList("1", "2", "3")));
        ps.setObject(index++, Value.stringArray(Arrays.asList("3", "2", "1")));
        ps.setObject(
            index++,
            Value.bytesArray(
                Arrays.asList(
                    ByteArray.copyFrom("1"), ByteArray.copyFrom("2"), ByteArray.copyFrom("3"))));
        ps.setObject(
            index++,
            Value.bytesArray(
                Arrays.asList(
                    ByteArray.copyFrom("333"),
                    ByteArray.copyFrom("222"),
                    ByteArray.copyFrom("111"))));
        ps.setObject(
            index++,
            Value.dateArray(
                Arrays.asList(com.google.cloud.Date.fromYearMonthDay(2021, 5, 3), null)));
        ps.setObject(
            index++,
            Value.timestampArray(
                Arrays.asList(com.google.cloud.Timestamp.ofTimeSecondsAndNanos(99999L, 99), null)));
        ps.setObject(
            index++, Value.numericArray(Arrays.asList(BigDecimal.ONE, null, BigDecimal.TEN)));
        ps.setObject(
            index++,
            Value.jsonArray(Arrays.asList("{\"key1\": \"val1\"}", null, "{\"key2\": \"val2\"}")));
        assertEquals(1, ps.executeUpdate());
      }
      try (ResultSet rs =
          con.createStatement()
              .executeQuery("SELECT * FROM TableWithAllColumnTypes WHERE ColInt64=2")) {
        assertTrue(rs.next());
        int index = 1;
        assertEquals(Value.int64(2L), rs.getObject(index++, Value.class));
        assertEquals(Value.float64(2d), rs.getObject(index++, Value.class));
        assertEquals(Value.float32(3.14f), rs.getObject(index++, Value.class));
        assertEquals(Value.bool(true), rs.getObject(index++, Value.class));
        assertEquals(Value.string("testvalues"), rs.getObject(index++, Value.class));
        assertEquals(
            Value.string("2d37f522-e0a5-4f22-8e09-4d77d299c967"),
            rs.getObject(index++, Value.class));
        assertEquals(Value.bytes(ByteArray.copyFrom("test")), rs.getObject(index++, Value.class));
        assertEquals(
            Value.bytes(ByteArray.copyFrom("testtest")), rs.getObject(index++, Value.class));
        assertEquals(
            Value.date(com.google.cloud.Date.fromYearMonthDay(2021, 5, 3)),
            rs.getObject(index++, Value.class));
        assertEquals(
            Value.timestamp(com.google.cloud.Timestamp.ofTimeSecondsAndNanos(99999L, 99)),
            rs.getObject(index++, Value.class));
        assertNotNull(rs.getObject(index++, Value.class)); // Commit timestamp
        assertEquals(Value.numeric(BigDecimal.TEN), rs.getObject(index++, Value.class));
        assertEquals(Value.json("{\"test_value\":\"foo\"}"), rs.getObject(index++, Value.class));

        assertEquals(Value.int64Array(new long[] {1L, 2L, 3L}), rs.getObject(index++, Value.class));
        assertEquals(
            Value.float64Array(new double[] {1.1D, 2.2D, 3.3D}),
            rs.getObject(index++, Value.class));
        assertEquals(
            Value.float32Array(new float[] {1.1f, 2.2f, 3.3f}), rs.getObject(index++, Value.class));
        assertEquals(
            Value.boolArray(Arrays.asList(true, null, false)), rs.getObject(index++, Value.class));
        assertEquals(
            Value.stringArray(Arrays.asList("1", "2", "3")), rs.getObject(index++, Value.class));
        assertEquals(
            Value.stringArray(Arrays.asList("3", "2", "1")), rs.getObject(index++, Value.class));
        assertEquals(
            Value.bytesArray(
                Arrays.asList(
                    ByteArray.copyFrom("1"), ByteArray.copyFrom("2"), ByteArray.copyFrom("3"))),
            rs.getObject(index++, Value.class));
        assertEquals(
            Value.bytesArray(
                Arrays.asList(
                    ByteArray.copyFrom("333"),
                    ByteArray.copyFrom("222"),
                    ByteArray.copyFrom("111"))),
            rs.getObject(index++, Value.class));
        assertEquals(
            Value.dateArray(
                Arrays.asList(com.google.cloud.Date.fromYearMonthDay(2021, 5, 3), null)),
            rs.getObject(index++, Value.class));
        assertEquals(
            Value.timestampArray(
                Arrays.asList(com.google.cloud.Timestamp.ofTimeSecondsAndNanos(99999L, 99), null)),
            rs.getObject(index++, Value.class));
        assertEquals(
            Value.numericArray(Arrays.asList(BigDecimal.ONE, null, BigDecimal.TEN)),
            rs.getObject(index++, Value.class));
        assertEquals(
            Value.jsonArray(Arrays.asList("{\"key1\":\"val1\"}", null, "{\"key2\":\"val2\"}")),
            rs.getObject(index++, Value.class));
        assertFalse(rs.next());
      }
    }
  }

  private void assertParameterMetaData(
      ParameterMetaData pmd,
      ImmutableList<Integer> sqlTypes,
      ImmutableList<String> typeNames,
      ImmutableList<Class<?>> classNames)
      throws SQLException {
    assertEquals(sqlTypes.size(), typeNames.size());
    assertEquals(sqlTypes.size(), classNames.size());

    ImmutableList<Integer> signedTypes =
        ImmutableList.of(Types.BIGINT, Types.NUMERIC, Types.DOUBLE);
    assertEquals(sqlTypes.size(), pmd.getParameterCount());
    for (int param = 1; param <= sqlTypes.size(); param++) {
      String msg = "Param " + param;
      assertEquals(msg, sqlTypes.get(param - 1).intValue(), pmd.getParameterType(param));
      assertEquals(msg, typeNames.get(param - 1), pmd.getParameterTypeName(param));
      assertEquals(0, pmd.getPrecision(param));
      assertEquals(0, pmd.getScale(param));
      assertEquals(msg, classNames.get(param - 1).getName(), pmd.getParameterClassName(param));
      assertEquals(ParameterMetaData.parameterModeIn, pmd.getParameterMode(param));
      assertEquals(ParameterMetaData.parameterNullableUnknown, pmd.isNullable(param));
      assertEquals(msg, signedTypes.contains(sqlTypes.get(param - 1)), pmd.isSigned(param));
    }
  }

  @Test
  public void test12_InsertReturningTestData() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      connection.setAutoCommit(false);
      // Delete existing rows from tables populated by other tests,
      // so that this test can populate rows from scratch.
      Statement deleteStatements = connection.createStatement();
      deleteStatements.addBatch("DELETE FROM Concerts WHERE TRUE");
      deleteStatements.addBatch("DELETE FROM Songs WHERE TRUE");
      deleteStatements.addBatch("DELETE FROM Albums WHERE TRUE");
      deleteStatements.addBatch("DELETE FROM Singers WHERE TRUE");
      deleteStatements.executeBatch();
      try (PreparedStatement ps =
          connection.prepareStatement(getSingersInsertReturningQuery(dialect.dialect))) {
        assertParameterMetaData(
            ps.getParameterMetaData(),
            ImmutableList.of(
                Types.BIGINT, Types.NVARCHAR, Types.NVARCHAR, Types.BINARY, Types.DATE),
            dialect.dialect == Dialect.POSTGRESQL
                ? ImmutableList.of(
                    "bigint", "character varying", "character varying", "bytea", "date")
                : ImmutableList.of("INT64", "STRING", "STRING", "BYTES", "DATE"),
            ImmutableList.of(Long.class, String.class, String.class, byte[].class, Date.class));
        for (Singer singer : createSingers()) {
          singer.setPreparedStatement(ps, getDialect());
          assertInsertSingerParameterMetadata(ps.getParameterMetaData());
          ps.addBatch();
          // check that adding the current params to a batch will not reset the metadata
          assertInsertSingerParameterMetadata(ps.getParameterMetaData());
        }
        int[] results = ps.executeBatch();
        for (int res : results) {
          assertEquals(1, res);
        }
      }
      try (PreparedStatement ps =
          connection.prepareStatement(getAlbumsInsertReturningQuery(dialect.dialect))) {
        assertParameterMetaData(
            ps.getParameterMetaData(),
            ImmutableList.of(Types.BIGINT, Types.BIGINT, Types.NVARCHAR, Types.BIGINT),
            dialect.dialect == Dialect.POSTGRESQL
                ? ImmutableList.of("bigint", "bigint", "character varying", "bigint")
                : ImmutableList.of("INT64", "INT64", "STRING", "INT64"),
            ImmutableList.of(Long.class, Long.class, String.class, Long.class));
        for (Album album : createAlbums()) {
          ps.setLong(1, album.singerId);
          ps.setLong(2, album.albumId);
          ps.setString(3, album.albumTitle);
          ps.setLong(4, album.marketingBudget);
          assertInsertAlbumParameterMetadata(ps.getParameterMetaData());
          try (ResultSet rs = ps.executeQuery()) {
            rs.next();
            assertEquals(rs.getLong(1), album.singerId);
            assertEquals(rs.getLong(2), album.albumId);
            assertEquals(rs.getString(3), album.albumTitle);
            assertEquals(rs.getLong(4), album.marketingBudget);
          }
          // check that calling executeQuery will not reset the metadata
          assertInsertAlbumParameterMetadata(ps.getParameterMetaData());
        }
      }
      try (PreparedStatement ps =
          connection.prepareStatement(getSongsInsertReturningQuery(dialect.dialect))) {
        assertParameterMetaData(
            ps.getParameterMetaData(),
            ImmutableList.of(
                Types.BIGINT,
                Types.BIGINT,
                Types.BIGINT,
                Types.NVARCHAR,
                Types.BIGINT,
                Types.NVARCHAR),
            dialect.dialect == Dialect.POSTGRESQL
                ? ImmutableList.of(
                    "bigint",
                    "bigint",
                    "bigint",
                    "character varying",
                    "bigint",
                    "character varying")
                : ImmutableList.of("INT64", "INT64", "INT64", "STRING", "INT64", "STRING"),
            ImmutableList.of(
                Long.class, Long.class, Long.class, String.class, Long.class, String.class));
        for (Song song : createSongs()) {
          ps.setByte(1, (byte) song.singerId);
          ps.setInt(2, (int) song.albumId);
          ps.setShort(3, (short) song.songId);
          ps.setNString(4, song.songName);
          ps.setLong(5, song.duration);
          ps.setCharacterStream(6, new StringReader(song.songGenre));
          assertInsertSongParameterMetadata(ps.getParameterMetaData());
          try (ResultSet rs = ps.executeQuery()) {
            rs.next();
            assertEquals(rs.getByte(1), (byte) song.singerId);
            assertEquals(rs.getInt(2), (int) song.albumId);
            assertEquals(rs.getShort(3), (short) song.songId);
            assertEquals(rs.getNString(4), song.songName);
            assertEquals(rs.getLong(5), song.duration);
            assertEquals(
                CharStreams.toString(rs.getCharacterStream(6)),
                CharStreams.toString(new StringReader(song.songGenre)));
          }
          // check that calling executeQuery will not reset the metadata
          assertInsertSongParameterMetadata(ps.getParameterMetaData());
        }
      } catch (IOException e) {
        // ignore exception.
      }
      try (PreparedStatement ps =
          connection.prepareStatement(getConcertsInsertReturningQuery(dialect.dialect))) {
        assertParameterMetaData(
            ps.getParameterMetaData(),
            ImmutableList.of(
                Types.BIGINT,
                Types.BIGINT,
                Types.DATE,
                Types.TIMESTAMP,
                Types.TIMESTAMP,
                Types.ARRAY),
            dialect.dialect == Dialect.POSTGRESQL
                ? ImmutableList.of(
                    "bigint",
                    "bigint",
                    "date",
                    "timestamp with time zone",
                    "timestamp with time zone",
                    "bigint[]")
                : ImmutableList.of(
                    "INT64", "INT64", "DATE", "TIMESTAMP", "TIMESTAMP", "ARRAY<INT64>"),
            ImmutableList.of(
                Long.class,
                Long.class,
                Date.class,
                Timestamp.class,
                Timestamp.class,
                Long[].class));
        for (Concert concert : createConcerts()) {
          concert.setPreparedStatement(connection, ps, getDialect());
          assertInsertConcertParameterMetadata(ps.getParameterMetaData());
          try (ResultSet rs = ps.executeQuery()) {
            rs.next();
            concert.assertEqualsFields(connection, rs, dialect.dialect);
          }
          // check that calling executeQuery will not reset the metadata.
          assertInsertConcertParameterMetadata(ps.getParameterMetaData());
        }
      }
      connection.commit();
    }
  }

  @Test
  public void test13_InsertUntypedNullValues() throws SQLException {
    try (Connection connection = createConnection(env, database)) {
      try (PreparedStatement preparedStatement =
          connection.prepareStatement(
              "insert into all_nullable_types ("
                  + "ColInt64, ColFloat64, ColFloat32, ColBool, ColString, ColBytes, ColDate, ColTimestamp, ColNumeric, ColJson, "
                  + "ColInt64Array, ColFloat64Array, ColBoolArray, ColStringArray, ColBytesArray, ColDateArray, ColTimestampArray, ColNumericArray, ColJsonArray) "
                  + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
        for (int param = 1;
            param <= preparedStatement.getParameterMetaData().getParameterCount();
            param++) {
          preparedStatement.setNull(param, Types.OTHER);
        }
        if (getDialect() == Dialect.POSTGRESQL) {
          // PostgreSQL-dialect databases do not allow NULLs in primary keys.
          preparedStatement.setLong(1, 1L);
        }
        assertEquals(1, preparedStatement.executeUpdate());

        // Verify that calling preparedStatement.setObject(index, null) works.
        for (int param = 1;
            param <= preparedStatement.getParameterMetaData().getParameterCount();
            param++) {
          preparedStatement.setObject(param, null);
        }
        // We need a different primary key value to insert another row.
        preparedStatement.setLong(1, 2L);
        assertEquals(1, preparedStatement.executeUpdate());
      }
    }
  }

  private List<String> readValuesFromFile(String filename) {
    StringBuilder builder = new StringBuilder();
    try (InputStream stream = ITJdbcPreparedStatementTest.class.getResourceAsStream(filename)) {
      Scanner scanner = new Scanner(stream);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        builder.append(line).append("\n");
      }
    } catch (IOException e) {
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
    assertEquals(5, pmd.getParameterCount());
    assertByteParam(pmd, 1);
    assertStringParam(pmd, 2);
    assertStringParam(pmd, 3);
    assertBytesParam(pmd, 4);
    assertDateParam(pmd, 5);
  }

  private void assertInsertAlbumParameterMetadata(ParameterMetaData pmd) throws SQLException {
    assertEquals(4, pmd.getParameterCount());
    assertLongParam(pmd, 1);
    assertLongParam(pmd, 2);
    assertStringParam(pmd, 3);
    assertLongParam(pmd, 4);
  }

  private void assertInsertSongParameterMetadata(ParameterMetaData pmd) throws SQLException {
    assertEquals(6, pmd.getParameterCount());
    assertByteParam(pmd, 1);
    assertIntParam(pmd, 2);
    assertShortParam(pmd, 3);
    assertNStringParam(pmd, 4);
    assertLongParam(pmd, 5);
    assertStringReaderParam(pmd, 6);
  }

  private void assertInsertConcertParameterMetadata(ParameterMetaData pmd) throws SQLException {
    assertEquals(6, pmd.getParameterCount());
    assertLongParam(pmd, 1);
    assertLongParam(pmd, 2);
    assertDateParam(pmd, 3);
    assertTimestampParam(pmd, 4);
    assertTimestampParam(pmd, 5);
    assertLongArrayParam(pmd, 6);
  }

  private void assertLongParam(ParameterMetaData pmd, int param) throws SQLException {
    assertEquals(Types.BIGINT, pmd.getParameterType(param));
    assertInt64Param(pmd, param, Long.class);
  }

  private void assertIntParam(ParameterMetaData pmd, int param) throws SQLException {
    assertEquals(Types.INTEGER, pmd.getParameterType(param));
    assertInt64Param(pmd, param, Integer.class);
  }

  private void assertShortParam(ParameterMetaData pmd, int param) throws SQLException {
    assertEquals(Types.SMALLINT, pmd.getParameterType(param));
    assertInt64Param(pmd, param, Short.class);
  }

  private void assertByteParam(ParameterMetaData pmd, int param) throws SQLException {
    assertEquals(Types.TINYINT, pmd.getParameterType(param));
    assertInt64Param(pmd, param, Byte.class);
  }

  private void assertInt64Param(ParameterMetaData pmd, int param, Class<?> paramClass)
      throws SQLException {
    assertEquals("INT64", pmd.getParameterTypeName(param));
    assertEquals(0, pmd.getPrecision(param));
    assertEquals(0, pmd.getScale(param));
    assertEquals(paramClass.getName(), pmd.getParameterClassName(param));
    assertEquals(ParameterMetaData.parameterModeIn, pmd.getParameterMode(param));
    assertEquals(ParameterMetaData.parameterNullableUnknown, pmd.isNullable(param));
    assertTrue(pmd.isSigned(param));
  }

  private void assertStringParam(ParameterMetaData pmd, int param) throws SQLException {
    assertStringParam(pmd, param, String.class);
  }

  private void assertStringParam(ParameterMetaData pmd, int param, Class<?> paramClass)
      throws SQLException {
    assertEquals(Types.NVARCHAR, pmd.getParameterType(param));
    assertEquals("STRING", pmd.getParameterTypeName(param));
    assertEquals(0, pmd.getPrecision(param));
    assertEquals(0, pmd.getScale(param));
    assertEquals(paramClass.getName(), pmd.getParameterClassName(param));
    assertEquals(ParameterMetaData.parameterModeIn, pmd.getParameterMode(param));
    assertEquals(ParameterMetaData.parameterNullableUnknown, pmd.isNullable(param));
    assertFalse(pmd.isSigned(param));
  }

  private void assertNStringParam(ParameterMetaData pmd, int param) throws SQLException {
    assertStringParam(pmd, param);
  }

  private void assertStringReaderParam(ParameterMetaData pmd, int param) throws SQLException {
    assertStringParam(pmd, param, StringReader.class);
  }

  private void assertBytesParam(ParameterMetaData pmd, int param) throws SQLException {
    assertEquals(Types.BINARY, pmd.getParameterType(param));
    assertEquals("BYTES", pmd.getParameterTypeName(param));
    assertEquals(0, pmd.getPrecision(param));
    assertEquals(0, pmd.getScale(param));
    assertEquals(byte[].class.getName(), pmd.getParameterClassName(param));
    assertEquals(ParameterMetaData.parameterModeIn, pmd.getParameterMode(param));
    assertEquals(ParameterMetaData.parameterNullableUnknown, pmd.isNullable(param));
    assertFalse(pmd.isSigned(param));
  }

  private void assertDateParam(ParameterMetaData pmd, int param) throws SQLException {
    assertEquals(Types.DATE, pmd.getParameterType(param));
    assertEquals("DATE", pmd.getParameterTypeName(param));
    assertEquals(0, pmd.getPrecision(param));
    assertEquals(0, pmd.getScale(param));
    assertEquals(Date.class.getName(), pmd.getParameterClassName(param));
    assertEquals(ParameterMetaData.parameterModeIn, pmd.getParameterMode(param));
    assertEquals(ParameterMetaData.parameterNullableUnknown, pmd.isNullable(param));
    assertFalse(pmd.isSigned(param));
  }

  private void assertTimestampParam(ParameterMetaData pmd, int param) throws SQLException {
    assertEquals(Types.TIMESTAMP, pmd.getParameterType(param));
    assertEquals("TIMESTAMP", pmd.getParameterTypeName(param));
    assertEquals(0, pmd.getPrecision(param));
    assertEquals(0, pmd.getScale(param));
    assertEquals(Timestamp.class.getName(), pmd.getParameterClassName(param));
    assertEquals(ParameterMetaData.parameterModeIn, pmd.getParameterMode(param));
    assertEquals(ParameterMetaData.parameterNullableUnknown, pmd.isNullable(param));
    assertFalse(pmd.isSigned(param));
  }

  private void assertLongArrayParam(ParameterMetaData pmd, int param) throws SQLException {
    assertEquals(Types.ARRAY, pmd.getParameterType(param));
    assertEquals("ARRAY", pmd.getParameterTypeName(param));
    assertEquals(0, pmd.getPrecision(param));
    assertEquals(0, pmd.getScale(param));
    assertEquals("com.google.cloud.spanner.jdbc.JdbcArray", pmd.getParameterClassName(param));
    assertEquals(ParameterMetaData.parameterModeIn, pmd.getParameterMode(param));
    assertEquals(ParameterMetaData.parameterNullableUnknown, pmd.isNullable(param));
    assertFalse(pmd.isSigned(param));
  }
}
