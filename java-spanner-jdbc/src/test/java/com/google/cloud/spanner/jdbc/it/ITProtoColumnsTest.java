/*
 * Copyright 2023 Google LLC
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

import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.SPANNER_EMULATOR_HOST;
import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.jdbc.ProtoEnumType;
import com.google.cloud.spanner.jdbc.ProtoMessageType;
import com.google.cloud.spanner.jdbc.it.SingerProto.Genre;
import com.google.cloud.spanner.jdbc.it.SingerProto.SingerInfo;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITProtoColumnsTest {
  @ClassRule public static JdbcIntegrationTestEnv env = new JdbcIntegrationTestEnv();
  private static final Duration OPERATION_TIMEOUT = Duration.ofMinutes(10);
  private static Database database;
  private static String url;

  public static boolean isUsingGraalVm() {
    String jobType = System.getenv("JOB_TYPE");
    return jobType != null && jobType.contains("graalvm");
  }

  @BeforeClass
  public static void setup() throws Exception {
    assumeFalse("Skipping tests on GraalVM", isUsingGraalVm());
    RemoteSpannerHelper testHelper = env.getTestHelper();
    final String projectId = testHelper.getInstanceId().getProject();
    final String instanceId = testHelper.getInstanceId().getInstance();
    final String databaseId = testHelper.getUniqueDatabaseId();
    final DatabaseAdminClient databaseAdminClient = testHelper.getClient().getDatabaseAdminClient();
    InputStream in =
        ITProtoColumnsTest.class
            .getClassLoader()
            .getResourceAsStream("com/google/cloud/spanner/jdbc/it/descriptors.pb");
    assertNotNull(in);
    final Database databaseToCreate =
        databaseAdminClient
            .newDatabaseBuilder(DatabaseId.of(projectId, instanceId, databaseId))
            .setDialect(Dialect.GOOGLE_STANDARD_SQL)
            .setProtoDescriptors(in)
            .build();
    final String host;
    if (isUsingEmulator()) {
      host = System.getenv(SPANNER_EMULATOR_HOST);
    } else {
      host = SpannerTestHost.getHost();
    }

    database =
        databaseAdminClient
            .createDatabase(
                databaseToCreate,
                Arrays.asList(
                    "CREATE PROTO BUNDLE ("
                        + "examples.spanner.music.SingerInfo,"
                        + "examples.spanner.music.Genre,"
                        + ")",
                    "CREATE TABLE Types ("
                        + "  RowID INT64 NOT NULL,"
                        + "  ProtoMessage    examples.spanner.music.SingerInfo,"
                        + "  ProtoEnum   examples.spanner.music.Genre,"
                        + "  ProtoMessageArray   ARRAY<examples.spanner.music.SingerInfo>,"
                        + "  ProtoEnumArray  ARRAY<examples.spanner.music.Genre>,"
                        + "  ) PRIMARY KEY (RowID)"))
            .get(OPERATION_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS);

    in.close();
    url = "jdbc:cloudspanner://" + host + "/" + database.getId();
    if (isUsingEmulator()) {
      url += "?autoConfigEmulator=true";
    }
  }

  @AfterClass
  public static void teardown() {
    if (database != null) {
      database.drop();
    }
    ConnectionOptions.closeSpanner();
  }

  @Test
  public void testNonNullElements() throws Exception {
    assumeFalse("Skipping tests on GraalVM", isUsingGraalVm());
    SingerInfo singerInfo =
        SingerInfo.newBuilder()
            .setSingerId(1)
            .setNationality("Country1")
            .setGenre(Genre.ROCK)
            .build();
    Genre singerGenre = Genre.ROCK;
    SingerInfo[] singerInfoArray = new SingerInfo[] {singerInfo, null};
    Genre[] singerGenreArray = new Genre[] {Genre.ROCK, null};
    try (Connection connection = DriverManager.getConnection(url);
        PreparedStatement ps =
            connection.prepareStatement(
                "INSERT INTO Types"
                    + " (RowID, ProtoMessage, ProtoEnum, ProtoMessageArray, ProtoEnumArray) VALUES (?, ?, ?, ?, ?)")) {
      ps.setInt(1, 1);
      ps.setObject(2, singerInfo, ProtoMessageType.INSTANCE);
      ps.setObject(3, singerGenre, ProtoEnumType.INSTANCE);
      ps.setArray(4, connection.createArrayOf("PROTO", singerInfoArray));
      ps.setArray(5, connection.createArrayOf("ENUM", singerGenreArray));

      final int updateCount = ps.executeUpdate();
      assertEquals(1, updateCount);
    }

    try (Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Types WHERE RowID = 1")) {

      assertTrue(resultSet.next());
      assertEquals(1, resultSet.getInt("RowID"));
      assertEquals(singerInfo, resultSet.getObject("ProtoMessage", SingerInfo.class));
      assertEquals(singerGenre, resultSet.getObject("ProtoEnum", Genre.class));
      assertArrayEquals(
          singerInfoArray, resultSet.getObject("ProtoMessageArray", SingerInfo[].class));
      assertArrayEquals(singerGenreArray, resultSet.getObject("ProtoEnumArray", Genre[].class));

      assertFalse(resultSet.next());
    }
  }

  @Test
  public void testNullElements() throws Exception {
    assumeFalse("Skipping tests on GraalVM", isUsingGraalVm());
    try (Connection connection = DriverManager.getConnection(url);
        PreparedStatement ps =
            connection.prepareStatement(
                "INSERT INTO Types"
                    + " (RowID, ProtoMessage, ProtoEnum, ProtoMessageArray, ProtoEnumArray) VALUES (?, ?, ?, ?, ?)")) {
      ps.setInt(1, 2);
      ps.setObject(2, null, ProtoMessageType.INSTANCE);
      ps.setObject(3, null, ProtoEnumType.INSTANCE);
      ps.setArray(4, connection.createArrayOf("PROTO", null));
      ps.setArray(5, connection.createArrayOf("ENUM", null));

      final int updateCount = ps.executeUpdate();
      assertEquals(1, updateCount);
    }

    try (Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Types WHERE RowID = 2")) {

      assertTrue(resultSet.next());
      assertEquals(2, resultSet.getInt("RowID"));
      assertNull(resultSet.getObject("ProtoMessage", SingerInfo.class));
      assertNull(resultSet.getObject("ProtoEnum", Genre.class));
      assertNull(resultSet.getObject("ProtoMessageArray", SingerInfo[].class));
      assertNull(resultSet.getObject("ProtoEnumArray", Genre[].class));

      assertFalse(resultSet.next());
    }
  }

  @Test
  public void testUntypedNullElements() throws Exception {
    assumeFalse("Skipping tests on GraalVM", isUsingGraalVm());
    try (Connection connection = DriverManager.getConnection(url);
        PreparedStatement ps =
            connection.prepareStatement(
                "INSERT INTO Types" + " (RowID, ProtoMessage, ProtoEnum) VALUES (?, ?, ?)")) {
      ps.setInt(1, 3);
      ps.setObject(2, null);
      ps.setObject(3, null);

      final int updateCount = ps.executeUpdate();
      assertEquals(1, updateCount);
    }

    try (Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Types WHERE RowID = 3")) {

      resultSet.next();
      assertEquals(3, resultSet.getInt("RowID"));
      assertNull(resultSet.getObject("ProtoMessage", SingerInfo.class));
      assertNull(resultSet.getObject("ProtoEnum", Genre.class));

      assertFalse(resultSet.next());
    }
  }

  @Test
  public void testInterCompatibility() throws Exception {
    assumeFalse("Skipping tests on GraalVM", isUsingGraalVm());
    SingerInfo singerInfo =
        SingerInfo.newBuilder()
            .setSingerId(1)
            .setNationality("Country1")
            .setGenre(Genre.ROCK)
            .build();
    Genre singerGenre = Genre.ROCK;
    byte[] singerInfoBytes = singerInfo.toByteArray();
    long singerGenreConst = singerGenre.getNumber();
    try (Connection connection = DriverManager.getConnection(url);
        PreparedStatement ps =
            connection.prepareStatement(
                "INSERT INTO Types" + " (RowID, ProtoMessage, ProtoEnum) VALUES (?, ?, ?)")) {
      ps.setInt(1, 4);
      ps.setObject(2, singerInfoBytes);
      ps.setObject(3, singerGenreConst);

      final int updateCount = ps.executeUpdate();
      assertEquals(1, updateCount);
    }

    try (Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Types WHERE RowID = 4")) {

      resultSet.next();
      assertEquals(4, resultSet.getInt("RowID"));
      assertEquals(singerInfo, resultSet.getObject("ProtoMessage", SingerInfo.class));
      assertEquals(singerGenre, resultSet.getObject("ProtoEnum", Genre.class));
      assertArrayEquals(singerInfoBytes, resultSet.getBytes("ProtoMessage"));
      assertEquals(singerGenreConst, resultSet.getInt("ProtoEnum"));

      assertFalse(resultSet.next());
    }
  }
}
