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

import com.google.cloud.Timestamp;
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
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.SpringApplication;

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
                "INSERT INTO \"albums\" (\"cover_picture\", \"created_at\", \"marketing_budget\", \"release_date\", \"singer_id\", \"title\", \"updated_at\") VALUES ($1, $2, $3, $4, $5, $6, $7)"),
            1L));
    mockSpanner.putPartialStatementResult(
        StatementResult.update(
            Statement.of(
                "insert into albums (title, marketing_budget, release_date, cover_picture, singer_id) values ($1, $2, $3, $4, $5)"),
            1L));

    // Set up results for the queries that the application runs.
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of(
                "SELECT \"singers\".\"id\" AS \"id\", \"singers\".\"active\" AS \"active\", "
                    + "\"singers\".\"last_name\" AS \"last_name\", \"singers\".\"full_name\" AS \"full_name\", "
                    + "\"singers\".\"updated_at\" AS \"updated_at\", \"singers\".\"created_at\" AS \"created_at\", "
                    + "\"singers\".\"first_name\" AS \"first_name\" FROM \"singers\""),
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
            Statement.of("SELECT COUNT(*) FROM \"albums\" WHERE \"albums\".\"singer_id\" = $1"),
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
              Statement.newBuilder(
                      "SELECT \"albums\".\"id\" AS \"id\", \"albums\".\"title\" AS \"title\", "
                          + "\"albums\".\"singer_id\" AS \"singer_id\", \"albums\".\"updated_at\" AS \"updated_at\", "
                          + "\"albums\".\"created_at\" AS \"created_at\", \"albums\".\"release_date\" AS \"release_date\", "
                          + "\"albums\".\"cover_picture\" AS \"cover_picture\", \"albums\".\"marketing_budget\" AS \"marketing_budget\" "
                          + "FROM \"albums\" WHERE \"albums\".\"singer_id\" = $1")
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
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.newBuilder(
                    "INSERT INTO \"singers\" (\"active\", \"created_at\", \"first_name\", \"last_name\", \"updated_at\") VALUES ($1, $2, $3, $4, $5)\n"
                        + "RETURNING *")
                .bind("p1")
                .to((Boolean) null)
                .bind("p2")
                .to((Timestamp) null)
                .bind("p3")
                .to("Amethyst")
                .bind("p4")
                .to("Jiang")
                .bind("p5")
                .to((Timestamp) null)
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
                "INSERT INTO \"albums\" (\"cover_picture\", \"created_at\", \"marketing_budget\", \"release_date\", \"singer_id\", \"title\", \"updated_at\") VALUES ($1, $2, $3, $4, $5, $6, $7)\n"
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
    mockSpanner.putPartialStatementResult(
        StatementResult.query(
            Statement.of(
                "INSERT INTO \"tracks\" (\"created_at\", \"id\", \"sample_rate\", \"title\", \"track_number\", \"updated_at\") VALUES ($1, $2, $3, $4, $5, $6)\n"
                    + "RETURNING *"),
            ResultSet.newBuilder()
                .setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setRowType(
                            StructType.newBuilder()
                                .addFields(
                                    Field.newBuilder()
                                        .setName("created_at")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("id")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("sample_rate")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.FLOAT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("title")
                                        .setType(Type.newBuilder().setCode(TypeCode.STRING).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("track_number")
                                        .setType(Type.newBuilder().setCode(TypeCode.INT64).build())
                                        .build())
                                .addFields(
                                    Field.newBuilder()
                                        .setName("updated_at")
                                        .setType(
                                            Type.newBuilder().setCode(TypeCode.TIMESTAMP).build())
                                        .build())
                                .build())
                        .build())
                .addRows(
                    ListValue.newBuilder()
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .addValues(Value.newBuilder().setStringValue("1").build())
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .addValues(Value.newBuilder().setStringValue(randomTitle()).build())
                        .addValues(Value.newBuilder().setStringValue("1").build())
                        .addValues(Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
                        .build())
                .setStats(ResultSetStats.newBuilder().setRowCountExact(1L).build())
                .build()));
    for (String prefix : new String[] {"J%", "A%", "B%", "C%"}) {
      mockSpanner.putStatementResult(
          StatementResult.query(
              Statement.newBuilder(
                      "SELECT \"singers\".\"id\" AS \"id\", \"singers\".\"active\" AS \"active\", "
                          + "\"singers\".\"last_name\" AS \"last_name\", \"singers\".\"full_name\" AS \"full_name\", "
                          + "\"singers\".\"updated_at\" AS \"updated_at\", \"singers\".\"created_at\" AS \"created_at\", "
                          + "\"singers\".\"first_name\" AS \"first_name\" "
                          + "FROM \"singers\" WHERE \"singers\".\"last_name\" LIKE $1")
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
    }
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of("select id from singers limit 1"),
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
                .addRows(
                    ListValue.newBuilder()
                        .addValues(Value.newBuilder().setStringValue("1").build())
                        .build())
                .build()));
    mockSpanner.putStatementResult(
        StatementResult.update(
            Statement.newBuilder("update singers set active=not active where id=$1")
                .bind("p1")
                .to(1L)
                .build(),
            1L));
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of(" select id from albums limit 1"),
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
                .addRows(
                    ListValue.newBuilder()
                        .addValues(Value.newBuilder().setStringValue("1").build())
                        .build())
                .build()));
    mockSpanner.putStatementResult(
        StatementResult.update(
            Statement.newBuilder(
                    " update albums set marketing_budget=marketing_budget * 1.1 where id=$1")
                .bind("p1")
                .to(1L)
                .build(),
            1L));
    mockSpanner.putStatementResult(
        StatementResult.update(
            Statement.newBuilder(
                    " update albums set marketing_budget=marketing_budget * 1.2 where id=$1")
                .bind("p1")
                .to(1L)
                .build(),
            1L));
  }

  @Test
  public void testRunApplication() {
    System.setProperty("open_telemetry.project", "test-project");
    System.setProperty("port", String.valueOf(getPort()));
    System.setProperty("emulator", "false");
    SpringApplication.run(Application.class).close();

    assertEquals(
        42,
        mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
            .filter(request -> !request.getSql().equals("SELECT 1"))
            .count());
    assertEquals(3, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(7, mockSpanner.countRequestsOfType(CommitRequest.class));
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
