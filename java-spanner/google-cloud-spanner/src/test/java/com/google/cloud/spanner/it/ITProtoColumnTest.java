/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.spanner.it;

import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.ByteArray;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SingerProto.Genre;
import com.google.cloud.spanner.SingerProto.SingerInfo;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.testing.EmulatorSpannerHelper;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.spanner.admin.database.v1.Backup;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

// Integration Tests to test DDL, DML and DQL for Proto Columns and Enums
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITProtoColumnTest {

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static DatabaseId databaseID;
  private static DatabaseAdminClient dbAdminClient;
  private static DatabaseClient databaseClient;

  @BeforeClass
  public static void setUpDatabase() throws Exception {
    assumeFalse(
        "Proto Column is not supported in the emulator", EmulatorSpannerHelper.isUsingEmulator());
    RemoteSpannerHelper testHelper = env.getTestHelper();
    databaseID = DatabaseId.of(testHelper.getInstanceId(), testHelper.getUniqueDatabaseId());
    dbAdminClient = testHelper.getClient().getDatabaseAdminClient();
    createDatabase();
    databaseClient = testHelper.getClient().getDatabaseClient(databaseID);
  }

  public static void createDatabase() throws Exception {
    InputStream in =
        ITProtoColumnTest.class
            .getClassLoader()
            .getResourceAsStream("com/google/cloud/spanner/descriptors.pb");
    final Database databaseToCreate =
        dbAdminClient.newDatabaseBuilder(databaseID).setProtoDescriptors(in).build();
    final Database createdDatabase =
        dbAdminClient
            .createDatabase(
                databaseToCreate,
                Arrays.asList(
                    "CREATE PROTO BUNDLE ("
                        + "examples.spanner.music.SingerInfo,"
                        + "examples.spanner.music.Genre,"
                        + ")",
                    "CREATE TABLE Singers ("
                        + "  SingerId   INT64 NOT NULL,"
                        + "  FirstName  STRING(1024),"
                        + "  LastName   STRING(1024),"
                        + "  SingerInfo examples.spanner.music.SingerInfo,"
                        + "  SingerGenre examples.spanner.music.Genre,"
                        + "  SingerNationality STRING(1024) AS (SingerInfo.nationality) STORED,"
                        + "  ) PRIMARY KEY (SingerNationality, SingerGenre)",
                    "CREATE TABLE Types ("
                        + "  RowID INT64 NOT NULL,"
                        + "  Int64a INT64,"
                        + "  Bytes BYTES(MAX),"
                        + "  Int64Array ARRAY<INT64>,"
                        + "  BytesArray ARRAY<BYTES(MAX)>,"
                        + "  ProtoMessage    examples.spanner.music.SingerInfo,"
                        + "  ProtoEnum   examples.spanner.music.Genre,"
                        + "  ProtoMessageArray   ARRAY<examples.spanner.music.SingerInfo>,"
                        + "  ProtoEnumArray  ARRAY<examples.spanner.music.Genre>,"
                        + "  ) PRIMARY KEY (RowID)",
                    "CREATE INDEX SingerByNationalityAndGenre ON Singers(SingerNationality,"
                        + " SingerGenre)  STORING (SingerId, FirstName, LastName)"))
            .get(5, TimeUnit.MINUTES);

    assertEquals(databaseID.getDatabase(), createdDatabase.getId().getDatabase());

    GetDatabaseDdlResponse response =
        dbAdminClient.getDatabaseDdlResponse(
            databaseID.getInstanceId().getInstance(), databaseID.getDatabase());
    assertNotNull(response.getProtoDescriptors());
    in.close();
  }

  @AfterClass
  public static void afterClass() throws Exception {
    try {
      if (!isUsingEmulator()) {
        dbAdminClient.dropDatabase(
            databaseID.getInstanceId().getInstance(), databaseID.getDatabase());
      }
    } catch (Exception e) {
      System.err.println(
          "Failed to drop database "
              + dbAdminClient
                  .getDatabase(databaseID.getInstanceId().getInstance(), databaseID.getDatabase())
                  .getId()
              + ", skipping...: "
              + e.getMessage());
    }
  }

  @After
  public void after() throws Exception {
    databaseClient.write(ImmutableList.of(Mutation.delete("Types", KeySet.all())));
    databaseClient.write(ImmutableList.of(Mutation.delete("Singers", KeySet.all())));
  }

  /**
   * Test to check data update and read queries on Proto Messages, Proto Enums and their arrays.
   * Test also checks for compatability between following types: 1. Proto Messages and Bytes 2.
   * Proto Enums and Int64
   */
  @Test
  public void testProtoColumnsUpdateAndRead() {
    assumeFalse(
        "Proto Column is not supported in the emulator", EmulatorSpannerHelper.isUsingEmulator());
    SingerInfo singerInfo =
        SingerInfo.newBuilder().setSingerId(1).setNationality("Country1").build();
    ByteArray singerInfoBytes = ByteArray.copyFrom(singerInfo.toByteArray());

    Genre genre = Genre.JAZZ;
    long genreConst = genre.getNumber();

    List<AbstractMessage> singerInfoList =
        Arrays.asList(singerInfo, null, SingerInfo.getDefaultInstance());
    List<ByteArray> singerInfoBytesList =
        Arrays.asList(
            singerInfoBytes,
            null,
            ByteArray.copyFrom(SingerInfo.getDefaultInstance().toByteArray()));

    List<ProtocolMessageEnum> enumList = Arrays.asList(Genre.FOLK, null, Genre.ROCK);
    List<Long> enumConstList =
        Arrays.asList((long) Genre.FOLK_VALUE, null, (long) Genre.ROCK_VALUE);

    // Inserting two rows with same data except rowID as it's used as PK.
    databaseClient.write(
        ImmutableList.of(
            Mutation.newInsertOrUpdateBuilder("Types")
                .set("RowID")
                .to(1)
                .set("Int64a")
                .to(genreConst)
                .set("Bytes")
                .to(singerInfoBytes)
                .set("Int64Array")
                .toInt64Array(enumConstList)
                .set("BytesArray")
                .toBytesArray(singerInfoBytesList)
                .set("ProtoMessage")
                .to(singerInfo)
                .set("ProtoEnum")
                .to(genre)
                .set("ProtoMessageArray")
                .toProtoMessageArray(singerInfoList, SingerInfo.getDescriptor())
                .set("ProtoEnumArray")
                .toProtoEnumArray(enumList, Genre.getDescriptor())
                .build(),
            // Inter Compatability check between ProtoMessages/Bytes and Int64/Enum.
            Mutation.newInsertOrUpdateBuilder("Types")
                .set("RowID")
                .to(2)
                .set("Int64a")
                .to(genre)
                .set("Bytes")
                .to(singerInfo)
                .set("Int64Array")
                .toProtoEnumArray(enumList, Genre.getDescriptor())
                .set("BytesArray")
                .toProtoMessageArray(singerInfoList, SingerInfo.getDescriptor())
                .set("ProtoMessage")
                .to(singerInfoBytes)
                .set("ProtoEnum")
                .to(genreConst)
                .set("ProtoMessageArray")
                .toBytesArray(singerInfoBytesList)
                .set("ProtoEnumArray")
                .toInt64Array(enumConstList)
                .build()));

    try (ResultSet resultSet =
        databaseClient.singleUse().executeQuery(Statement.of("SELECT * FROM " + "Types"))) {

      for (int i = 0; i < 2; i++) {
        resultSet.next();
        assertEquals(i + 1, resultSet.getLong("RowID"));
        assertEquals(genreConst, resultSet.getLong("Int64a"));
        assertEquals(singerInfoBytes, resultSet.getBytes("Bytes"));
        assertEquals(enumConstList, resultSet.getLongList("Int64Array"));
        assertEquals(singerInfoBytesList, resultSet.getBytesList("BytesArray"));
        assertEquals(
            singerInfo, resultSet.getProtoMessage("ProtoMessage", SingerInfo.getDefaultInstance()));
        assertEquals(genre, resultSet.getProtoEnum("ProtoEnum", Genre::forNumber));
        assertEquals(
            singerInfoList,
            resultSet.getProtoMessageList("ProtoMessageArray", SingerInfo.getDefaultInstance()));
        assertEquals(enumList, resultSet.getProtoEnumList("ProtoEnumArray", Genre::forNumber));

        // Check compatability between Proto Messages and Bytes
        assertEquals(singerInfoBytes, resultSet.getBytes("ProtoMessage"));
        assertEquals(
            singerInfo, resultSet.getProtoMessage("Bytes", SingerInfo.getDefaultInstance()));

        assertEquals(singerInfoBytesList, resultSet.getBytesList("ProtoMessageArray"));
        assertEquals(
            singerInfoList,
            resultSet.getProtoMessageList("BytesArray", SingerInfo.getDefaultInstance()));

        // Check compatability between Proto Enum and Int64
        assertEquals(genreConst, resultSet.getLong("ProtoEnum"));
        assertEquals(genre, resultSet.getProtoEnum("Int64a", Genre::forNumber));

        assertEquals(enumConstList, resultSet.getLongList("ProtoEnumArray"));
        assertEquals(enumList, resultSet.getProtoEnumList("Int64Array", Genre::forNumber));
      }
    }
  }

  // Test to check Parameterized Queries, Primary Keys and Indexes.
  @Test
  public void testProtoColumnsDMLParameterizedQueriesPKAndIndexes() {
    assumeFalse(
        "Proto Column is not supported in the emulator", EmulatorSpannerHelper.isUsingEmulator());

    SingerInfo singerInfo1 =
        SingerInfo.newBuilder().setSingerId(1).setNationality("Country1").build();
    Genre genre1 = Genre.FOLK;

    SingerInfo singerInfo2 =
        SingerInfo.newBuilder().setSingerId(2).setNationality("Country2").build();
    Genre genre2 = Genre.JAZZ;

    databaseClient
        .readWriteTransaction()
        .run(
            transaction -> {
              Statement statement1 =
                  Statement.newBuilder(
                          "INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo,"
                              + " SingerGenre) VALUES (1, \"FirstName1\", \"LastName1\","
                              + " @singerInfo, @singerGenre)")
                      .bind("singerInfo")
                      .to(singerInfo1)
                      .bind("singerGenre")
                      .to(genre1)
                      .build();

              Statement statement2 =
                  Statement.newBuilder(
                          "INSERT INTO Singers (SingerId, FirstName, LastName, SingerInfo,"
                              + " SingerGenre) VALUES (2, \"FirstName2\", \"LastName2\","
                              + " @singerInfo, @singerGenre)")
                      .bind("singerInfo")
                      .to(singerInfo2)
                      .bind("singerGenre")
                      .to(genre2)
                      .build();

              transaction.batchUpdate(Arrays.asList(statement1, statement2));
              return null;
            });

    // Read all rows based on Proto Message field and Proto Enum Primary key column values
    try (ResultSet resultSet1 =
        databaseClient
            .singleUse()
            .read(
                "Singers",
                KeySet.newBuilder()
                    .addKey(Key.of("Country1", Genre.FOLK))
                    .addKey(Key.of("Country2", Genre.JAZZ))
                    .build(),
                Arrays.asList("SingerId", "FirstName", "LastName", "SingerInfo", "SingerGenre"))) {
      resultSet1.next();
      assertEquals(1, resultSet1.getLong("SingerId"));
      assertEquals("FirstName1", resultSet1.getString("FirstName"));
      assertEquals("LastName1", resultSet1.getString("LastName"));
      assertEquals(
          singerInfo1, resultSet1.getProtoMessage("SingerInfo", SingerInfo.getDefaultInstance()));
      assertEquals(genre1, resultSet1.getProtoEnum("SingerGenre", Genre::forNumber));

      resultSet1.next();
      assertEquals(2, resultSet1.getLong("SingerId"));
      assertEquals("FirstName2", resultSet1.getString("FirstName"));
      assertEquals("LastName2", resultSet1.getString("LastName"));
      assertEquals(
          singerInfo2, resultSet1.getProtoMessage("SingerInfo", SingerInfo.getDefaultInstance()));
      assertEquals(genre2, resultSet1.getProtoEnum("SingerGenre", Genre::forNumber));
    }

    // Read rows using Index on Proto Message field and Proto Enum column
    try (ResultSet resultSet2 =
        databaseClient
            .singleUse()
            .readUsingIndex(
                "Singers",
                "SingerByNationalityAndGenre",
                KeySet.singleKey(Key.of("Country2", Genre.JAZZ)),
                Arrays.asList("SingerId", "FirstName", "LastName"))) {

      resultSet2.next();
      assertEquals(2, resultSet2.getLong("SingerId"));
      assertEquals("FirstName2", resultSet2.getString("FirstName"));
      assertEquals("LastName2", resultSet2.getString("LastName"));
    }

    // Filter using Parameterized DQL
    try (ResultSet resultSet3 =
        databaseClient
            .singleUse()
            .executeQuery(
                Statement.newBuilder(
                        "SELECT SingerId, SingerInfo, SingerGenre FROM Singers WHERE"
                            + " SingerInfo.Nationality=@country AND SingerGenre=@genre")
                    .bind("country")
                    .to("Country2")
                    .bind("genre")
                    .to(Genre.JAZZ)
                    .build())) {
      resultSet3.next();
      assertEquals(2, resultSet3.getLong("SingerId"));
      assertEquals(
          singerInfo2, resultSet3.getProtoMessage("SingerInfo", SingerInfo.getDefaultInstance()));
      assertEquals(genre2, resultSet3.getProtoEnum("SingerGenre", Genre::forNumber));
    }
  }

  // Test the exception in case Invalid protocol message object is provided while deserializing the
  // data.
  @Test
  public void testProtoMessageDeserializationError() {
    assumeFalse(
        "Proto Column is not supported in the emulator", EmulatorSpannerHelper.isUsingEmulator());

    SingerInfo singerInfo =
        SingerInfo.newBuilder().setSingerId(1).setNationality("Country1").build();

    databaseClient.write(
        ImmutableList.of(
            Mutation.newInsertOrUpdateBuilder("Types")
                .set("RowID")
                .to(1)
                .set("ProtoMessage")
                .to(singerInfo)
                .build()));

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .read("Types", KeySet.all(), Collections.singletonList("ProtoMessage"))) {

      resultSet.next();

      SpannerException e =
          assertThrows(
              SpannerException.class,
              () -> resultSet.getProtoMessage("ProtoMessage", Backup.getDefaultInstance()));

      // Underlying cause is InvalidWireTypeException
      assertEquals(InvalidWireTypeException.class, e.getCause().getClass());
    }
  }
}
