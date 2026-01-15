/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.it;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.TruthJUnit.assume;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.Date;
import com.google.cloud.bigtable.admin.v2.models.CreateSchemaBundleRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.models.sql.BoundStatement;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatement;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSet;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.models.sql.Struct;
import com.google.cloud.bigtable.data.v2.test.AlbumProto.Album;
import com.google.cloud.bigtable.data.v2.test.SingerProto.Genre;
import com.google.cloud.bigtable.data.v2.test.SingerProto.Singer;
import com.google.cloud.bigtable.test_helpers.env.AbstractTestEnv;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos.FileDescriptorSet;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExecuteQueryIT {

  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();
  private static BigtableDataClient dataClient;
  private static String tableId;
  private static String schemaBundleId;
  private static String cf;
  private static String uniquePrefix;
  private static final Logger logger = Logger.getLogger(ExecuteQueryIT.class.getName());

  @BeforeClass
  public static void setUpAll() throws IOException {
    assume()
        .withMessage("ExecuteQuery is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);
    assume()
        .withMessage("ExecuteQuery only works over CloudPath")
        .that(testEnvRule.env().getConnectionMode())
        .isNoneOf(
            AbstractTestEnv.ConnectionMode.REQUIRE_DIRECT_PATH,
            AbstractTestEnv.ConnectionMode.REQUIRE_DIRECT_PATH_IPV4);

    tableId = testEnvRule.env().getTableId();
    dataClient = testEnvRule.env().getDataClient();
    cf = testEnvRule.env().getFamilyId();
    uniquePrefix = UUID.randomUUID() + "-execute-query-it-";
    schemaBundleId = UUID.randomUUID() + "-bundle";

    dataClient.mutateRow(
        RowMutation.create(TableId.of(tableId), uniquePrefix + "a")
            .setCell(cf, ByteString.copyFromUtf8("qual"), 1000, ByteString.copyFromUtf8("old"))
            .setCell(cf, ByteString.copyFromUtf8("qual2"), 1000, ByteString.copyFromUtf8("old2")));
    // Overwrite the previous values. Used for testing with_history
    dataClient.mutateRow(
        RowMutation.create(TableId.of(tableId), uniquePrefix + "a")
            .setCell(cf, ByteString.copyFromUtf8("qual"), 10000, ByteString.copyFromUtf8("val"))
            .setCell(cf, ByteString.copyFromUtf8("qual2"), 10000, ByteString.copyFromUtf8("val2"))
            .setCell(cf, ByteString.copyFromUtf8("qual3"), 10000, ByteString.copyFromUtf8("val3")));
    dataClient.mutateRow(
        RowMutation.create(TableId.of(tableId), uniquePrefix + "b")
            .setCell(cf, ByteString.copyFromUtf8("qual"), 10000, ByteString.copyFromUtf8("bval"))
            .setCell(
                cf, ByteString.copyFromUtf8("qual2"), 10000, ByteString.copyFromUtf8("bval2")));
  }

  @Test
  public void selectStar() {
    PreparedStatement preparedStatement =
        dataClient.prepareStatement(
            "SELECT * FROM " + tableId + " WHERE _key LIKE '" + uniquePrefix + "%'",
            new HashMap<>());
    BoundStatement statement = preparedStatement.bind().build();
    try (ResultSet rs = dataClient.executeQuery(statement)) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getBytes("_key")).isEqualTo(ByteString.copyFromUtf8(uniquePrefix + "a"));
      assertThat(
              rs.getMap(cf, SqlType.mapOf(SqlType.bytes(), SqlType.bytes()))
                  .get(ByteString.copyFromUtf8("qual")))
          .isEqualTo(ByteString.copyFromUtf8("val"));

      assertThat(rs.next()).isTrue();
      assertThat(rs.getBytes("_key")).isEqualTo(ByteString.copyFromUtf8(uniquePrefix + "b"));
      assertThat(
              rs.getMap(cf, SqlType.mapOf(SqlType.bytes(), SqlType.bytes()))
                  .get(ByteString.copyFromUtf8("qual")))
          .isEqualTo(ByteString.copyFromUtf8("bval"));

      assertThat(rs.next()).isFalse();
    }
  }

  @Test
  public void withHistoryQuery() {
    PreparedStatement preparedStatement =
        dataClient.prepareStatement(
            "SELECT * FROM `"
                + tableId
                + "`(with_history => true) WHERE _key LIKE '"
                + uniquePrefix
                + "%'",
            new HashMap<>());
    BoundStatement statement = preparedStatement.bind().build();
    try (ResultSet rs = dataClient.executeQuery(statement)) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getBytes("_key")).isEqualTo(ByteString.copyFromUtf8(uniquePrefix + "a"));
      Map<ByteString, List<Struct>> rowACf = rs.getMap(cf, SqlType.historicalMap());
      List<Struct> rowAQual = rowACf.get(ByteString.copyFromUtf8("qual"));
      assertThat(rowAQual.size()).isEqualTo(2);
      Struct rowAQual_0 = rowAQual.get(0);
      assertThat(rowAQual_0.getBytes("value")).isEqualTo(ByteString.copyFromUtf8("val"));
      // timestamp in micros above so we divide by 1000
      assertThat(rowAQual_0.getTimestamp("timestamp")).isEqualTo(Instant.ofEpochMilli(10));
      Struct rowAQual_1 = rowAQual.get(1);
      assertThat(rowAQual_1.getBytes("value")).isEqualTo(ByteString.copyFromUtf8("old"));
      assertThat(rowAQual_1.getTimestamp("timestamp")).isEqualTo(Instant.ofEpochMilli(1));

      assertThat(rs.next()).isTrue();
      assertThat(rs.getBytes("_key")).isEqualTo(ByteString.copyFromUtf8(uniquePrefix + "b"));
      Map<ByteString, List<Struct>> rowBCf = rs.getMap(cf, SqlType.historicalMap());
      List<Struct> rowBQual = rowBCf.get(ByteString.copyFromUtf8("qual"));
      assertThat(rowBQual.size()).isEqualTo(1);
      Struct rowBQual_0 = rowBQual.get(0);
      assertThat(rowBQual_0.getBytes("value")).isEqualTo(ByteString.copyFromUtf8("bval"));

      assertThat(rs.next()).isFalse();
    }
  }

  @SuppressWarnings("DoubleBraceInitialization")
  @Test
  public void allTypes() throws Exception {
    createTestSchemaBundle();
    Album album = Album.newBuilder().setTitle("Lover").build();

    // For some reason the ExecuteQuery data path sometimes cannot resolve a newly-created schema
    // bundle immediately after its creation. To avoid test flakiness, we wrap query preparation
    // with a retry loop.
    PreparedStatement preparedStatement;
    int retryCount = 0;
    int maxRetries = 10;
    while (true) {
      try {
        preparedStatement =
            dataClient.prepareStatement(
                "SELECT 'stringVal' AS strCol, b'foo' as bytesCol, 1 AS intCol, CAST(1.2 AS"
                    + " FLOAT32) as f32Col, CAST(1.3 AS FLOAT64) as f64Col, true as boolCol,"
                    + " TIMESTAMP_FROM_UNIX_MILLIS(1000) AS tsCol, DATE(2024, 06, 01) as dateCol,"
                    + " STRUCT(1 as a, \"foo\" as b) AS structCol, [1,2,3] AS arrCol, "
                    + cf
                    + " as mapCol, "
                    + " CAST(b'\022\005Lover' AS `"
                    + schemaBundleId
                    + ".com.google.cloud.bigtable.data.v2.test.Album`) as protoCol, CAST('JAZZ' AS"
                    + " `"
                    + schemaBundleId
                    + ".com.google.cloud.bigtable.data.v2.test.Genre`) as enumCol FROM `"
                    + tableId
                    + "` WHERE _key='"
                    + uniquePrefix
                    + "a' LIMIT 1",
                new HashMap<>());
        break;
      } catch (InvalidArgumentException e) {
        if (++retryCount == maxRetries) {
          throw e;
        }
        logger.log(Level.INFO, "Retrying prepareStatement, retryCount: " + retryCount);
        Thread.sleep(5000);
      }
    }

    BoundStatement statement = preparedStatement.bind().build();
    try (ResultSet rs = dataClient.executeQuery(statement)) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getString("strCol")).isEqualTo("stringVal");
      assertThat(rs.getString(0)).isEqualTo("stringVal");
      assertThat(rs.getBytes("bytesCol")).isEqualTo(ByteString.copyFromUtf8("foo"));
      assertThat(rs.getBytes(1)).isEqualTo(ByteString.copyFromUtf8("foo"));
      assertThat(rs.getLong("intCol")).isEqualTo(1L);
      assertThat(rs.getLong(2)).isEqualTo(1L);
      assertThat(rs.getFloat("f32Col")).isEqualTo(1.2f);
      assertThat(rs.getFloat(3)).isEqualTo(1.2f);
      assertThat(rs.getDouble("f64Col")).isEqualTo(1.3d);
      assertThat(rs.getDouble(4)).isEqualTo(1.3d);
      assertThat(rs.getBoolean("boolCol")).isTrue();
      assertThat(rs.getBoolean(5)).isTrue();
      assertThat(rs.getTimestamp("tsCol")).isEqualTo(Instant.ofEpochMilli(1000));
      assertThat(rs.getTimestamp(6)).isEqualTo(Instant.ofEpochMilli(1000));
      assertThat(rs.getDate("dateCol")).isEqualTo(Date.fromYearMonthDay(2024, 6, 1));
      assertThat(rs.getDate(7)).isEqualTo(Date.fromYearMonthDay(2024, 6, 1));
      assertThat(rs.getStruct("structCol").getLong("a")).isEqualTo(1);
      assertThat(rs.getStruct("structCol").getString("b")).isEqualTo("foo");
      assertThat(rs.getStruct(8).getLong("a")).isEqualTo(1);
      assertThat(rs.getStruct(8).getString("b")).isEqualTo("foo");
      assertThat(rs.getList("arrCol", SqlType.arrayOf(SqlType.int64())))
          .isEqualTo(Arrays.asList(1L, 2L, 3L));
      assertThat(rs.getList(9, SqlType.arrayOf(SqlType.int64())))
          .isEqualTo(Arrays.asList(1L, 2L, 3L));
      assertThat(rs.getMap("mapCol", SqlType.mapOf(SqlType.bytes(), SqlType.bytes())))
          .isEqualTo(
              new HashMap<ByteString, ByteString>() {
                {
                  put(ByteString.copyFromUtf8("qual"), ByteString.copyFromUtf8("val"));
                  put(ByteString.copyFromUtf8("qual2"), ByteString.copyFromUtf8("val2"));
                  put(ByteString.copyFromUtf8("qual3"), ByteString.copyFromUtf8("val3"));
                }
              });
      assertThat(rs.getMap(10, SqlType.mapOf(SqlType.bytes(), SqlType.bytes())))
          .isEqualTo(
              new HashMap<ByteString, ByteString>() {
                {
                  put(ByteString.copyFromUtf8("qual"), ByteString.copyFromUtf8("val"));
                  put(ByteString.copyFromUtf8("qual2"), ByteString.copyFromUtf8("val2"));
                  put(ByteString.copyFromUtf8("qual3"), ByteString.copyFromUtf8("val3"));
                }
              });
      assertThat(rs.getProtoMessage("protoCol", Album.getDefaultInstance())).isEqualTo(album);
      assertThat(rs.getProtoMessage(11, Album.getDefaultInstance())).isEqualTo(album);
      assertThat(rs.getProtoEnum("enumCol", Genre::forNumber)).isEqualTo(Genre.JAZZ);
      assertThat(rs.getProtoEnum(12, Genre::forNumber)).isEqualTo(Genre.JAZZ);
      assertThat(rs.next()).isFalse();
    } catch (AssertionError e) {
      throw e;
    } finally {
      deleteTestSchemaBundle();
    }
  }

  @Test
  public void allQueryParamsTypes() {
    Map<String, SqlType<?>> paramTypes = new HashMap<>();
    paramTypes.put("stringParam", SqlType.string());
    paramTypes.put("bytesParam", SqlType.bytes());
    paramTypes.put("int64Param", SqlType.int64());
    paramTypes.put("doubleParam", SqlType.float64());
    paramTypes.put("floatParam", SqlType.float32());
    paramTypes.put("boolParam", SqlType.bool());
    paramTypes.put("tsParam", SqlType.timestamp());
    paramTypes.put("dateParam", SqlType.date());
    paramTypes.put("stringArrayParam", SqlType.arrayOf(SqlType.string()));
    paramTypes.put("byteArrayParam", SqlType.arrayOf(SqlType.bytes()));
    paramTypes.put("intArrayParam", SqlType.arrayOf(SqlType.int64()));
    paramTypes.put("doubleArrayParam", SqlType.arrayOf(SqlType.float64()));
    paramTypes.put("floatArrayParam", SqlType.arrayOf(SqlType.float32()));
    paramTypes.put("boolArrayParam", SqlType.arrayOf(SqlType.bool()));
    paramTypes.put("tsArrayParam", SqlType.arrayOf(SqlType.timestamp()));
    paramTypes.put("dateArrayParam", SqlType.arrayOf(SqlType.date()));

    PreparedStatement preparedStatement =
        dataClient.prepareStatement(
            "SELECT @stringParam AS strCol, @bytesParam as bytesCol, @int64Param AS intCol, "
                + "@doubleParam AS doubleCol, @floatParam AS floatCol, @boolParam AS boolCol, "
                + "@tsParam AS tsCol, @dateParam AS dateCol, @byteArrayParam AS byteArrayCol, "
                + "@stringArrayParam AS stringArrayCol, @intArrayParam AS intArrayCol, "
                + "@floatArrayParam AS floatArrayCol, @doubleArrayParam AS doubleArrayCol, "
                + "@boolArrayParam AS boolArrayCol, @tsArrayParam AS tsArrayCol, "
                + "@dateArrayParam AS dateArrayCol",
            paramTypes);
    BoundStatement boundStatement =
        preparedStatement
            .bind()
            .setStringParam("stringParam", "stringVal")
            .setBytesParam("bytesParam", ByteString.copyFromUtf8("foo"))
            .setLongParam("int64Param", 1L)
            .setDoubleParam("doubleParam", 1.3d)
            .setFloatParam("floatParam", 1.4f)
            .setBooleanParam("boolParam", true)
            .setTimestampParam("tsParam", Instant.ofEpochMilli(1000))
            .setDateParam("dateParam", Date.fromYearMonthDay(2024, 6, 1))
            .setListParam(
                "byteArrayParam",
                Arrays.asList(ByteString.copyFromUtf8("foo"), null, ByteString.copyFromUtf8("bar")),
                SqlType.arrayOf(SqlType.bytes()))
            .setListParam(
                "stringArrayParam",
                Arrays.asList("foo", null, "bar"),
                SqlType.arrayOf(SqlType.string()))
            .setListParam(
                "intArrayParam", Arrays.asList(1L, null, 2L), SqlType.arrayOf(SqlType.int64()))
            .setListParam(
                "floatArrayParam",
                Arrays.asList(1.2f, null, 1.3f),
                SqlType.arrayOf(SqlType.float32()))
            .setListParam(
                "doubleArrayParam",
                Arrays.asList(1.4d, null, 1.5d),
                SqlType.arrayOf(SqlType.float64()))
            .setListParam(
                "boolArrayParam", Arrays.asList(true, null, false), SqlType.arrayOf(SqlType.bool()))
            .setListParam(
                "tsArrayParam",
                Arrays.asList(
                    Instant.ofEpochSecond(1000, 1000), null, Instant.ofEpochSecond(2000, 2000)),
                SqlType.arrayOf(SqlType.timestamp()))
            .setListParam(
                "dateArrayParam",
                Arrays.asList(
                    Date.fromYearMonthDay(2024, 8, 1), null, Date.fromYearMonthDay(2024, 8, 2)),
                SqlType.arrayOf(SqlType.date()))
            .build();

    ResultSet rs = dataClient.executeQuery(boundStatement);
    assertThat(rs.next()).isTrue();
    assertThat(rs.getString("strCol")).isEqualTo("stringVal");
    assertThat(rs.getString(0)).isEqualTo("stringVal");
    assertThat(rs.getBytes("bytesCol")).isEqualTo(ByteString.copyFromUtf8("foo"));
    assertThat(rs.getBytes(1)).isEqualTo(ByteString.copyFromUtf8("foo"));
    assertThat(rs.getLong("intCol")).isEqualTo(1L);
    assertThat(rs.getLong(2)).isEqualTo(1L);
    assertThat(rs.getDouble("doubleCol")).isEqualTo(1.3d);
    assertThat(rs.getDouble(3)).isEqualTo(1.3d);
    assertThat(rs.getFloat("floatCol")).isEqualTo(1.4f);
    assertThat(rs.getFloat(4)).isEqualTo(1.4f);
    assertThat(rs.getBoolean("boolCol")).isTrue();
    assertThat(rs.getBoolean(5)).isTrue();
    assertThat(rs.getTimestamp("tsCol")).isEqualTo(Instant.ofEpochMilli(1000));
    assertThat(rs.getTimestamp(6)).isEqualTo(Instant.ofEpochMilli(1000));
    assertThat(rs.getDate("dateCol")).isEqualTo(Date.fromYearMonthDay(2024, 6, 1));
    assertThat(rs.getDate(7)).isEqualTo(Date.fromYearMonthDay(2024, 6, 1));
    assertThat(rs.getList("byteArrayCol", SqlType.arrayOf(SqlType.bytes())))
        .isEqualTo(
            Arrays.asList(ByteString.copyFromUtf8("foo"), null, ByteString.copyFromUtf8("bar")));
    assertThat(rs.getList(8, SqlType.arrayOf(SqlType.bytes())))
        .isEqualTo(
            Arrays.asList(ByteString.copyFromUtf8("foo"), null, ByteString.copyFromUtf8("bar")));
    assertThat(rs.getList("stringArrayCol", SqlType.arrayOf(SqlType.string())))
        .isEqualTo(Arrays.asList("foo", null, "bar"));
    assertThat(rs.getList(9, SqlType.arrayOf(SqlType.string())))
        .isEqualTo(Arrays.asList("foo", null, "bar"));
    assertThat(rs.getList("intArrayCol", SqlType.arrayOf(SqlType.int64())))
        .isEqualTo(Arrays.asList(1L, null, 2L));
    assertThat(rs.getList(10, SqlType.arrayOf(SqlType.int64())))
        .isEqualTo(Arrays.asList(1L, null, 2L));
    assertThat(rs.getList("floatArrayCol", SqlType.arrayOf(SqlType.float32())))
        .isEqualTo(Arrays.asList(1.2f, null, 1.3f));
    assertThat(rs.getList(11, SqlType.arrayOf(SqlType.float32())))
        .isEqualTo(Arrays.asList(1.2f, null, 1.3f));
    assertThat(rs.getList("doubleArrayCol", SqlType.arrayOf(SqlType.float64())))
        .isEqualTo(Arrays.asList(1.4d, null, 1.5d));
    assertThat(rs.getList(12, SqlType.arrayOf(SqlType.float64())))
        .isEqualTo(Arrays.asList(1.4d, null, 1.5d));
    assertThat(rs.getList("boolArrayCol", SqlType.arrayOf(SqlType.bool())))
        .isEqualTo(Arrays.asList(true, null, false));
    assertThat(rs.getList(13, SqlType.arrayOf(SqlType.bool())))
        .isEqualTo(Arrays.asList(true, null, false));
    assertThat(rs.getList("tsArrayCol", SqlType.arrayOf(SqlType.timestamp())))
        .isEqualTo(
            Arrays.asList(
                Instant.ofEpochSecond(1000, 1000), null, Instant.ofEpochSecond(2000, 2000)));
    assertThat(rs.getList(14, SqlType.arrayOf(SqlType.timestamp())))
        .isEqualTo(
            Arrays.asList(
                Instant.ofEpochSecond(1000, 1000), null, Instant.ofEpochSecond(2000, 2000)));
    assertThat(rs.getList("dateArrayCol", SqlType.arrayOf(SqlType.date())))
        .isEqualTo(
            Arrays.asList(
                Date.fromYearMonthDay(2024, 8, 1), null, Date.fromYearMonthDay(2024, 8, 2)));
    assertThat(rs.getList(15, SqlType.arrayOf(SqlType.date())))
        .isEqualTo(
            Arrays.asList(
                Date.fromYearMonthDay(2024, 8, 1), null, Date.fromYearMonthDay(2024, 8, 2)));
  }

  @Test
  public void testNullColumns() {
    PreparedStatement preparedStatement =
        dataClient.prepareStatement(
            "SELECT cf['qual'] AS neverNull, cf['qual3'] AS maybeNull FROM "
                + tableId
                + " WHERE _key LIKE '"
                + uniquePrefix
                + "%'",
            new HashMap<>());
    BoundStatement statement = preparedStatement.bind().build();
    try (ResultSet rs = dataClient.executeQuery(statement)) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getBytes("neverNull")).isEqualTo(ByteString.copyFromUtf8("val"));
      // qual3 is set in row A but not row B
      assertThat(rs.isNull("maybeNull")).isFalse();
      assertThat(rs.isNull(1)).isFalse();
      assertThat(rs.getBytes("maybeNull")).isEqualTo(ByteString.copyFromUtf8("val3"));
      assertThat(rs.next()).isTrue();
      assertThat(rs.getBytes("neverNull")).isEqualTo(ByteString.copyFromUtf8("bval"));
      assertThat(rs.isNull("maybeNull")).isTrue();
      assertThat(rs.isNull(1)).isTrue();
      assertThrows(NullPointerException.class, () -> rs.getBytes("maybeNull"));
      assertThrows(NullPointerException.class, () -> rs.getBytes(1));
      assertThat(rs.next()).isFalse();
    }
  }

  private static void deleteTestSchemaBundle() {
    testEnvRule.env().getTableAdminClient().deleteSchemaBundle(tableId, schemaBundleId);
  }

  private static void createTestSchemaBundle() throws Exception {
    FileDescriptorSet fileDescriptorSet =
        FileDescriptorSet.newBuilder()
            .addFile(Singer.getDescriptor().getFile().toProto())
            .addFile(Album.getDescriptor().getFile().toProto())
            .build();
    CreateSchemaBundleRequest request =
        CreateSchemaBundleRequest.of(tableId, schemaBundleId)
            .setProtoSchema(fileDescriptorSet.toByteString());
    testEnvRule.env().getTableAdminClient().createSchemaBundle(request);
  }
}
