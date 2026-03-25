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

package com.google.cloud.spanner.sample;

import static com.google.cloud.spanner.sample.DatabaseSeeder.INITIAL_SINGERS;
import static com.google.cloud.spanner.sample.DatabaseSeeder.randomDate;
import static com.google.cloud.spanner.sample.DatabaseSeeder.randomTitle;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.sample.entities.Singer;
import com.google.common.collect.Streams;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.protobuf.Value;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeAnnotationCode;
import com.google.spanner.v1.TypeCode;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ApplicationTest extends AbstractMockServerTest {

  @BeforeClass
  public static void setupQueryResults() {
    // Set the database dialect.
    mockSpanner.putStatementResult(StatementResult.detectDialectResult(Dialect.POSTGRESQL));
    // Set up a result for the dialect check that is executed by the JdbcConfiguration class.
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of(
                "select 1 "
                    + "from information_schema.database_options "
                    + "where schema_name='public' "
                    + "and option_name='database_dialect' "
                    + "and option_value='POSTGRESQL'"),
            ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setName("c")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .build())
                        .build())
                .addRows(
                    ListValue.newBuilder()
                        .addValues(Value.newBuilder().setStringValue("1").build())
                        .build())
                .build()));
    // Add a DDL response to the server.
    addDdlResponseToSpannerAdmin();

    // Set up results for the 'delete all test data' operations.
    mockSpanner.putStatementResult(
        StatementResult.update(Statement.of("delete from concerts"), 0L));
    mockSpanner.putStatementResult(StatementResult.update(Statement.of("delete from venues"), 0L));
    mockSpanner.putStatementResult(StatementResult.update(Statement.of("delete from tracks"), 0L));
    mockSpanner.putStatementResult(StatementResult.update(Statement.of("delete from albums"), 0L));
    mockSpanner.putStatementResult(StatementResult.update(Statement.of("delete from singers"), 0L));

    // Set up results for inserting test data.
    for (Singer singer : INITIAL_SINGERS) {
      mockSpanner.putStatementResult(
          StatementResult.update(
              Statement.newBuilder("insert into singers (first_name, last_name) values ($1, $2)")
                  .bind("p1")
                  .to(singer.getFirstName())
                  .bind("p2")
                  .to(singer.getLastName())
                  .build(),
              1L));
    }
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of("select id from singers"),
            ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setName("id")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .build())
                        .build())
                .addAllRows(
                    LongStream.rangeClosed(1L, INITIAL_SINGERS.size())
                        .mapToObj(
                            id ->
                                ListValue.newBuilder()
                                    .addValues(
                                        Value.newBuilder()
                                            .setStringValue(String.valueOf(Long.reverse(id)))
                                            .build())
                                    .build())
                        .collect(Collectors.toList()))
                .build()));
    mockSpanner.putPartialStatementResult(
        StatementResult.update(
            Statement.of(
                "insert into albums (title, marketing_budget, release_date, cover_picture, singer_id) values ($1, $2, $3, $4, $5)"),
            1L));

    // Set up results for the queries that the application runs.
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of("SELECT * FROM singers ORDER BY last_name, first_name, id"),
            ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setName("id")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("active")
                                        .setType(Type.newBuilder().setCode(TypeCode.BOOL).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("last_name")
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("full_name")
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("updated_at")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("created_at")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("first_name")
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .build())
                                .build())
                        .build())
                .addAllRows(
                    Streams.mapWithIndex(
                            INITIAL_SINGERS.stream(),
                            (singer, index) ->
                                ListValue.newBuilder()
                                    .addValues(
                                        Value.newBuilder()
                                            .setStringValue(String.valueOf(Long.reverse(index + 1)))
                                            .build())
                                    .addValues(Value.newBuilder().setBoolValue(true).build())
                                    .addValues(
                                        Value.newBuilder()
                                            .setStringValue(singer.getLastName())
                                            .build())
                                    .addValues(
                                        Value.newBuilder()
                                            .setStringValue(
                                                singer.getFirstName() + " " + singer.getLastName())
                                            .build())
                                    .addValues(
                                        Value.newBuilder()
                                            .setNullValue(NullValue.NULL_VALUE)
                                            .build())
                                    .addValues(
                                        Value.newBuilder()
                                            .setNullValue(NullValue.NULL_VALUE)
                                            .build())
                                    .addValues(
                                        Value.newBuilder()
                                            .setStringValue(singer.getFirstName())
                                            .build())
                                    .build())
                        .collect(Collectors.toList()))
                .build()));
    mockSpanner.putPartialStatementResult(
        StatementResult.query(
            Statement.of("SELECT COUNT(1) FROM albums WHERE singer_id = $1"),
            ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setName("c")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .build())
                        .build())
                .addRows(
                    ListValue.newBuilder()
                        .addValues(Value.newBuilder().setStringValue("10").build())
                        .build())
                .build()));
    for (long singerId : LongStream.rangeClosed(1L, INITIAL_SINGERS.size()).toArray()) {
      mockSpanner.putStatementResult(
          StatementResult.query(
              Statement.newBuilder("SELECT * FROM albums WHERE singer_id = $1")
                  .bind("p1")
                  .to(Long.reverse(singerId))
                  .build(),
              ResultSet.newBuilder()
                  .setMetadata(
                      ResultSetMetadata.newBuilder()
                          .setRowType(
                              StructType.newBuilder()
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("id")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.INT64).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("title")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.STRING).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("singer_id")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.INT64).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("updated_at")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("created_at")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("release_date")
                                          .setType(Type.newBuilder().setCode(TypeCode.DATE).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("cover_picture")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.BYTES).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("marketing_budget")
                                          .setType(
                                              Type.newBuilder()
                                                  .setCode(TypeCode.NUMERIC)
                                                  .setTypeAnnotation(TypeAnnotationCode.PG_NUMERIC)
                                                  .build())
                                          .build())
                                  .build())
                          .build())
                  .addAllRows(
                      IntStream.rangeClosed(1, 10)
                          .mapToObj(
                              albumId ->
                                  ListValue.newBuilder()
                                      .addValues(
                                          Value.newBuilder()
                                              .setStringValue(
                                                  String.valueOf(Long.reverse(albumId * singerId)))
                                              .build())
                                      .addValues(Value.newBuilder().setStringValue(randomTitle()))
                                      .addValues(
                                          Value.newBuilder()
                                              .setStringValue(
                                                  String.valueOf(Long.reverse(singerId))))
                                      .addValues(
                                          Value.newBuilder()
                                              .setNullValue(NullValue.NULL_VALUE)
                                              .build())
                                      .addValues(
                                          Value.newBuilder()
                                              .setNullValue(NullValue.NULL_VALUE)
                                              .build())
                                      .addValues(
                                          Value.newBuilder()
                                              .setStringValue(randomDate().toString())
                                              .build())
                                      .addValues(
                                          Value.newBuilder()
                                              .setNullValue(NullValue.NULL_VALUE)
                                              .build())
                                      .addValues(
                                          Value.newBuilder()
                                              .setNullValue(NullValue.NULL_VALUE)
                                              .build())
                                      .build())
                          .collect(Collectors.toList()))
                  .build()));
    }
    int singerIndex = ThreadLocalRandom.current().nextInt(INITIAL_SINGERS.size());
    Singer randomSinger = INITIAL_SINGERS.get(singerIndex);
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of("SELECT * FROM singers ORDER BY sha256(last_name::bytea) LIMIT 1"),
            ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setName("id")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("active")
                                        .setType(Type.newBuilder().setCode(TypeCode.BOOL).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("last_name")
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("full_name")
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("updated_at")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("created_at")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("first_name")
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .build())
                                .build())
                        .build())
                .addRows(
                    ListValue.newBuilder()
                        .addValues(
                            Value.newBuilder()
                                .setStringValue(String.valueOf(Long.reverse(singerIndex + 1)))
                                .build())
                        .addValues(Value.newBuilder().setBoolValue(true).build())
                        .addValues(
                            Value.newBuilder().setStringValue(randomSinger.getLastName()).build())
                        .addValues(
                            Value.newBuilder()
                                .setStringValue(
                                    randomSinger.getFirstName() + " " + randomSinger.getLastName())
                                .build())
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .addValues(
                            Value.newBuilder().setStringValue(randomSinger.getFirstName()).build())
                        .build())
                .build()));

    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.newBuilder(
                    "INSERT INTO singers (first_name, last_name, active) VALUES ($1, $2, $3)\n"
                        + "RETURNING *")
                .bind("p1")
                .to("Amethyst")
                .bind("p2")
                .to("Jiang")
                .bind("p3")
                .to((com.google.cloud.spanner.Value) null)
                .build(),
            ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setName("id")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("active")
                                        .setType(Type.newBuilder().setCode(TypeCode.BOOL).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("last_name")
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("full_name")
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("updated_at")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("created_at")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("first_name")
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .build())
                                .build())
                        .build())
                .addRows(
                    ListValue.newBuilder()
                        .addValues(
                            Value.newBuilder()
                                .setStringValue(
                                    String.valueOf(Long.reverse(INITIAL_SINGERS.size() + 2)))
                                .build())
                        .addValues(Value.newBuilder().setBoolValue(true).build())
                        .addValues(Value.newBuilder().setStringValue("Amethyst").build())
                        .addValues(Value.newBuilder().setStringValue("Amethyst Jiang").build())
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .addValues(Value.newBuilder().setStringValue("Jiang").build())
                        .build())
                .setStats(ResultSetStats.newBuilder().setRowCountExact(1L).build())
                .build()));
    mockSpanner.putPartialStatementResult(
        StatementResult.query(
            Statement.of(
                "INSERT INTO albums (title, marketing_budget, release_date, cover_picture, singer_id) VALUES ($1, $2, $3, $4, $5)\n"
                    + "RETURNING *"),
            ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setName("id")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("title")
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("singer_id")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("updated_at")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("created_at")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("release_date")
                                        .setType(Type.newBuilder().setCode(TypeCode.DATE).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("cover_picture")
                                        .setType(Type.newBuilder().setCode(TypeCode.BYTES).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("marketing_budget")
                                        .setType(
                                            Type.newBuilder()
                                                .setCode(TypeCode.NUMERIC)
                                                .setTypeAnnotation(TypeAnnotationCode.PG_NUMERIC)
                                                .build())
                                        .build())
                                .build())
                        .build())
                .addRows(
                    ListValue.newBuilder()
                        .addValues(
                            Value.newBuilder()
                                .setStringValue(String.valueOf(Long.reverse(1L)))
                                .build())
                        .addValues(Value.newBuilder().setStringValue(randomTitle()))
                        .addValues(Value.newBuilder().setStringValue(String.valueOf(1L)))
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .addValues(
                            Value.newBuilder().setStringValue(randomDate().toString()).build())
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .build())
                .setStats(ResultSetStats.newBuilder().setRowCountExact(1L).build())
                .build()));
    mockSpanner.putPartialStatementResult(
        StatementResult.query(
            Statement.of(
                "INSERT INTO tracks (id, track_number, title, sample_rate) VALUES ($1, $2, $3, $4)\n"
                    + "RETURNING *"),
            ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setName("id")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("track_number")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("title")
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("sample_rate")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.FLOAT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("updated_at")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("created_at")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .build())
                        .build())
                .addRows(
                    ListValue.newBuilder()
                        .addValues(
                            Value.newBuilder()
                                .setStringValue(String.valueOf(Long.reverse(1L)))
                                .build())
                        .addValues(Value.newBuilder().setStringValue("1").build())
                        .addValues(Value.newBuilder().setStringValue(randomTitle()))
                        .addValues(Value.newBuilder().setNumberValue(3.14d))
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .build())
                .setStats(ResultSetStats.newBuilder().setRowCountExact(1L).build())
                .build()));
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of("select * from albums limit 1"),
            ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setName("id")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("title")
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("singer_id")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("updated_at")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("created_at")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("release_date")
                                        .setType(Type.newBuilder().setCode(TypeCode.DATE).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("cover_picture")
                                        .setType(Type.newBuilder().setCode(TypeCode.BYTES).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("marketing_budget")
                                        .setType(
                                            Type.newBuilder()
                                                .setCode(TypeCode.NUMERIC)
                                                .setTypeAnnotation(TypeAnnotationCode.PG_NUMERIC)
                                                .build())
                                        .build())
                                .build())
                        .build())
                .addRows(
                    ListValue.newBuilder()
                        .addValues(
                            Value.newBuilder()
                                .setStringValue(String.valueOf(Long.reverse(1L)))
                                .build())
                        .addValues(Value.newBuilder().setStringValue(randomTitle()))
                        .addValues(Value.newBuilder().setStringValue(String.valueOf(1L)))
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .addValues(
                            Value.newBuilder().setStringValue(randomDate().toString()).build())
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .build())
                .setStats(ResultSetStats.newBuilder().setRowCountExact(1L).build())
                .build()));
    for (String prefix : new String[] {"J", "A", "B", "C"}) {
      mockSpanner.putStatementResult(
          StatementResult.query(
              Statement.newBuilder("SELECT * FROM singers WHERE starts_with(last_name, $1)")
                  .bind("p1")
                  .to(prefix)
                  .build(),
              ResultSet.newBuilder()
                  .setMetadata(
                      ResultSetMetadata.newBuilder()
                          .setRowType(
                              StructType.newBuilder()
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("id")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.INT64).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("active")
                                          .setType(Type.newBuilder().setCode(TypeCode.BOOL).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("last_name")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.STRING).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("full_name")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.STRING).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("updated_at")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("created_at")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("first_name")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.STRING).build())
                                          .build())
                                  .build())
                          .build())
                  .addAllRows(
                      Streams.mapWithIndex(
                              INITIAL_SINGERS.stream()
                                  .filter(
                                      singer ->
                                          singer.getLastName().startsWith(prefix.substring(0, 1))),
                              (singer, index) ->
                                  ListValue.newBuilder()
                                      .addValues(
                                          Value.newBuilder()
                                              .setStringValue(
                                                  String.valueOf(Long.reverse(index + 1)))
                                              .build())
                                      .addValues(Value.newBuilder().setBoolValue(true).build())
                                      .addValues(
                                          Value.newBuilder()
                                              .setStringValue(singer.getLastName())
                                              .build())
                                      .addValues(
                                          Value.newBuilder()
                                              .setStringValue(
                                                  singer.getFirstName()
                                                      + " "
                                                      + singer.getLastName())
                                              .build())
                                      .addValues(
                                          Value.newBuilder()
                                              .setNullValue(NullValue.NULL_VALUE)
                                              .build())
                                      .addValues(
                                          Value.newBuilder()
                                              .setNullValue(NullValue.NULL_VALUE)
                                              .build())
                                      .addValues(
                                          Value.newBuilder()
                                              .setStringValue(singer.getFirstName())
                                              .build())
                                      .build())
                          .collect(Collectors.toList()))
                  .build()));
      mockSpanner.putPartialStatementResult(
          StatementResult.query(
              Statement.of(
                  "INSERT INTO singers (id, first_name, last_name, active) VALUES ($1, $2, $3, $4) ON CONFLICT (id) DO UPDATE SET id=excluded.id, first_name=excluded.first_name, last_name=excluded.last_name, active=excluded.active\n"
                      + "RETURNING *"),
              ResultSet.newBuilder()
                  .setMetadata(
                      ResultSetMetadata.newBuilder()
                          .setRowType(
                              StructType.newBuilder()
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("id")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.INT64).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("active")
                                          .setType(Type.newBuilder().setCode(TypeCode.BOOL).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("last_name")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.STRING).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("full_name")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.STRING).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("updated_at")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("created_at")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                          .build())
                                  .addFields(
                                      Field.newBuilder()
                                          .setName("first_name")
                                          .setType(
                                              Type.newBuilder().setCode(TypeCode.STRING).build())
                                          .build())
                                  .build())
                          .build())
                  .addRows(
                      ListValue.newBuilder()
                          .addValues(
                              Value.newBuilder()
                                  .setStringValue(
                                      String.valueOf(ThreadLocalRandom.current().nextLong()))
                                  .build())
                          .addValues(Value.newBuilder().setBoolValue(true).build())
                          .addValues(Value.newBuilder().setStringValue("Russel").build())
                          .addValues(Value.newBuilder().setStringValue("Beatriz Russel").build())
                          .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                          .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                          .addValues(Value.newBuilder().setStringValue("Beatriz").build())
                          .build())
                  .setStats(ResultSetStats.newBuilder().setRowCountExact(1L).build())
                  .build()));
    }
  }

  @Test
  public void testRunApplication() {
    System.setProperty("spanner.emulator", "false");
    System.setProperty("spanner.endpoint", "//localhost:" + getPort());
    System.setProperty("spanner.additional_properties", "usePlainText=true");
    Application.main(new String[] {});

    assertEquals(
        39,
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
            .filter(
                request ->
                    !request.getSql().equals("SELECT 1")
                        && !request
                            .getSql()
                            .equals(
                                "SELECT * FROM singers ORDER BY sha256(last_name::bytea) LIMIT 1"))
            .count());
    assertEquals(3, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(6, mockSpanner.countRequestsOfType(CommitRequest.class));

    // Verify that the service methods use transactions.
    String insertSingerSql =
        "INSERT INTO singers (first_name, last_name, active) VALUES ($1, $2, $3)\nRETURNING *";
    assertEquals(
        1,
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
            .filter(request -> request.getSql().equals(insertSingerSql))
            .count());
    ExecuteSqlRequest insertSingerRequest =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
            .filter(request -> request.getSql().equals(insertSingerSql))
            .findFirst()
            .orElseThrow();
    assertTrue(insertSingerRequest.hasTransaction());
    assertTrue(insertSingerRequest.getTransaction().hasBegin());
    assertTrue(insertSingerRequest.getTransaction().getBegin().hasReadWrite());
    String insertAlbumSql =
        "INSERT INTO albums (title, marketing_budget, release_date, cover_picture, singer_id) "
            + "VALUES ($1, $2, $3, $4, $5)\nRETURNING *";
    assertEquals(
        4,
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
            .filter(request -> request.getSql().equals(insertAlbumSql))
            .count());
    // The first 3 requests belong to the transaction that is executed together with the 'INSERT
    // INTO singers' statement.
    List<ExecuteSqlRequest> insertAlbumRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
            .filter(request -> request.getSql().equals(insertAlbumSql))
            .toList()
            .subList(0, 3);
    ExecuteSqlRequest firstInsertAlbumRequest = insertAlbumRequests.get(0);
    for (ExecuteSqlRequest request : insertAlbumRequests) {
      assertTrue(request.hasTransaction());
      assertTrue(request.getTransaction().hasId());
      assertEquals(
          firstInsertAlbumRequest.getTransaction().getId(), request.getTransaction().getId());
    }
    // Verify that the transaction is committed.
    assertEquals(
        1,
        mockSpanner.getRequestsOfType(CommitRequest.class).stream()
            .filter(
                request ->
                    request
                        .getTransactionId()
                        .equals(firstInsertAlbumRequest.getTransaction().getId()))
            .count());

    // The last 'INSERT INTO albums' request belong in a transaction with 8 'INSERT INTO tracks'
    // requests.
    ExecuteSqlRequest lastInsertAlbumRequest =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
            .filter(request -> request.getSql().equals(insertAlbumSql))
            .toList()
            .get(3);
    assertNotEquals(
        lastInsertAlbumRequest.getTransaction().getId(),
        firstInsertAlbumRequest.getTransaction().getId());
    assertTrue(lastInsertAlbumRequest.hasTransaction());
    assertTrue(lastInsertAlbumRequest.getTransaction().hasBegin());
    assertTrue(lastInsertAlbumRequest.getTransaction().getBegin().hasReadWrite());
    String insertTrackSql =
        "INSERT INTO tracks (id, track_number, title, sample_rate) "
            + "VALUES ($1, $2, $3, $4)\nRETURNING *";
    assertEquals(
        7,
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
            .filter(request -> request.getSql().equals(insertTrackSql))
            .count());
    List<ExecuteSqlRequest> insertTrackRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
            .filter(request -> request.getSql().equals(insertTrackSql))
            .toList();
    for (ExecuteSqlRequest request : insertTrackRequests) {
      assertTrue(request.hasTransaction());
      assertTrue(request.getTransaction().hasId());
      assertEquals(
          insertTrackRequests.get(0).getTransaction().getId(), request.getTransaction().getId());
    }
    // Verify that the transaction is committed.
    assertEquals(
        1,
        mockSpanner.getRequestsOfType(CommitRequest.class).stream()
            .filter(
                request ->
                    request
                        .getTransactionId()
                        .equals(insertTrackRequests.get(0).getTransaction().getId()))
            .count());

    // Verify that the SingerService#listSingersWithLastNameStartingWith(..) method uses a read-only
    // transaction.
    assertEquals(
        1,
        mockSpanner.getRequestsOfType(BeginTransactionRequest.class).stream()
            .filter(request -> request.getOptions().hasReadOnly())
            .count());
    String selectSingersSql = "SELECT * FROM singers WHERE starts_with(last_name, $1)";
    assertEquals(
        4,
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
            .filter(request -> request.getSql().equals(selectSingersSql))
            .count());
    List<ExecuteSqlRequest> selectSingersRequests =
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
            .filter(request -> request.getSql().equals(selectSingersSql))
            .toList()
            .subList(1, 4);
    ExecuteSqlRequest firstSelectSingersRequest = selectSingersRequests.get(0);
    for (ExecuteSqlRequest request : selectSingersRequests) {
      assertTrue(request.hasTransaction());
      assertTrue(request.getTransaction().hasId());
    }
    // Verify that the read-only transaction is not committed.
    assertEquals(
        0,
        mockSpanner.getRequestsOfType(CommitRequest.class).stream()
            .filter(
                request ->
                    request
                        .getTransactionId()
                        .equals(firstSelectSingersRequest.getTransaction().getId()))
            .count());
  }

  private static void addDdlResponseToSpannerAdmin() {
    mockDatabaseAdmin.addResponse(
        Operation.newBuilder()
            .setDone(true)
            .setResponse(Any.pack(Empty.getDefaultInstance()))
            .setMetadata(Any.pack(UpdateDatabaseDdlMetadata.getDefaultInstance()))
            .build());
  }
}
