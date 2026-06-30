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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MissingDefaultSequenceKindException;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.StatementResult.ResultType;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.rpc.Code;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import com.google.spanner.v1.CommitRequest;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DdlTest extends AbstractMockServerTest {

  @After
  public void reset() {
    mockDatabaseAdmin.reset();
  }

  @Override
  protected String getBaseUrl() {
    return String.format(
        "cloudspanner://localhost:%d/projects/proj/instances/inst/databases/db?usePlainText=true",
        getPort());
  }

  private void addUpdateDdlResponse() {
    mockDatabaseAdmin.addResponse(
        Operation.newBuilder()
            .setMetadata(
                Any.pack(
                    UpdateDatabaseDdlMetadata.newBuilder()
                        .setDatabase("projects/proj/instances/inst/databases/db")
                        .build()))
            .setName("projects/proj/instances/inst/databases/db/operations/1")
            .setDone(true)
            .setResponse(Any.pack(Empty.getDefaultInstance()))
            .build());
  }

  private void addUpdateDdlResponse(com.google.rpc.Status error) {
    mockDatabaseAdmin.addResponse(
        Operation.newBuilder()
            .setMetadata(
                Any.pack(
                    UpdateDatabaseDdlMetadata.newBuilder()
                        .setDatabase("projects/proj/instances/inst/databases/db")
                        .build()))
            .setName("projects/proj/instances/inst/databases/db/operations/1")
            .setDone(true)
            // .setResponse(Any.pack(Empty.getDefaultInstance()))
            .setError(error)
            .build());
  }

  @Test
  public void testSingleAnalyzeStatement() {
    addUpdateDdlResponse();

    try (Connection connection = createConnection()) {
      StatementResult result = connection.execute(Statement.of("analyze"));
      assertEquals(ResultType.NO_RESULT, result.getResultType());
    }

    List<UpdateDatabaseDdlRequest> requests =
        mockDatabaseAdmin.getRequests().stream()
            .filter(request -> request instanceof UpdateDatabaseDdlRequest)
            .map(request -> (UpdateDatabaseDdlRequest) request)
            .collect(Collectors.toList());
    assertEquals(1, requests.size());
    assertEquals(1, requests.get(0).getStatementsCount());
    assertEquals("analyze", requests.get(0).getStatements(0));
  }

  @Test
  public void testBatchedAnalyzeStatement() {
    addUpdateDdlResponse();

    try (Connection connection = createConnection()) {
      connection.startBatchDdl();
      assertEquals(
          ResultType.NO_RESULT,
          connection
              .execute(Statement.of("create table foo (id int64) primary key (id)"))
              .getResultType());
      assertEquals(
          ResultType.NO_RESULT, connection.execute(Statement.of("analyze")).getResultType());
      connection.runBatch();
    }

    List<UpdateDatabaseDdlRequest> requests =
        mockDatabaseAdmin.getRequests().stream()
            .filter(request -> request instanceof UpdateDatabaseDdlRequest)
            .map(request -> (UpdateDatabaseDdlRequest) request)
            .collect(Collectors.toList());
    assertEquals(1, requests.size());
    assertEquals(2, requests.get(0).getStatementsCount());
    assertEquals("create table foo (id int64) primary key (id)", requests.get(0).getStatements(0));
    assertEquals("analyze", requests.get(0).getStatements(1));
  }

  @Test
  public void testDdlAtStartOfTransaction() {
    Statement statement = Statement.of("create table foo (id int64) primary key (id)");
    for (DdlInTransactionMode mode : DdlInTransactionMode.values()) {
      mockDatabaseAdmin.getRequests().clear();
      if (mode != DdlInTransactionMode.FAIL) {
        addUpdateDdlResponse();
      }

      try (Connection connection = createConnection()) {
        connection.setAutocommit(false);
        connection.setDdlInTransactionMode(mode);

        if (mode == DdlInTransactionMode.FAIL) {
          SpannerException exception =
              assertThrows(SpannerException.class, () -> connection.execute(statement));
          assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
        } else {
          assertEquals(ResultType.NO_RESULT, connection.execute(statement).getResultType());
          assertEquals(1, mockDatabaseAdmin.getRequests().size());
        }
      }
    }
  }

  @Test
  public void testDdlBatchAtStartOfTransaction() {
    for (DdlInTransactionMode mode : DdlInTransactionMode.values()) {
      mockDatabaseAdmin.getRequests().clear();
      if (mode != DdlInTransactionMode.FAIL) {
        addUpdateDdlResponse();
      }

      try (Connection connection = createConnection()) {
        connection.setAutocommit(false);
        connection.setDdlInTransactionMode(mode);

        if (mode == DdlInTransactionMode.FAIL) {
          SpannerException exception =
              assertThrows(
                  SpannerException.class,
                  () -> connection.execute(Statement.of("start batch ddl")));
          assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
        } else {
          connection.execute(Statement.of("start batch ddl"));
          connection.execute(Statement.of("create table foo"));
          connection.execute(Statement.of("alter table bar"));
          connection.execute(Statement.of("run batch"));
          assertEquals(1, mockDatabaseAdmin.getRequests().size());
          UpdateDatabaseDdlRequest request =
              (UpdateDatabaseDdlRequest) mockDatabaseAdmin.getRequests().get(0);
          assertEquals(2, request.getStatementsCount());
        }
      }
    }
  }

  @Test
  public void testDdlInTransaction() {
    Statement statement = Statement.of("create table foo (id int64) primary key (id)");
    for (DdlInTransactionMode mode : DdlInTransactionMode.values()) {
      mockDatabaseAdmin.getRequests().clear();
      if (mode == DdlInTransactionMode.AUTO_COMMIT_TRANSACTION) {
        addUpdateDdlResponse();
      }

      try (Connection connection = createConnection()) {
        connection.setAutocommit(false);
        connection.setDdlInTransactionMode(mode);

        connection.execute(INSERT_STATEMENT);

        if (mode != DdlInTransactionMode.AUTO_COMMIT_TRANSACTION) {
          SpannerException exception =
              assertThrows(SpannerException.class, () -> connection.execute(statement));
          assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
        } else {
          assertEquals(ResultType.NO_RESULT, connection.execute(statement).getResultType());
          assertEquals(1, mockDatabaseAdmin.getRequests().size());
          assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
        }
      }
    }
  }

  @Test
  public void testDdlBatchInTransaction() {
    for (DdlInTransactionMode mode : DdlInTransactionMode.values()) {
      mockDatabaseAdmin.getRequests().clear();
      if (mode == DdlInTransactionMode.AUTO_COMMIT_TRANSACTION) {
        addUpdateDdlResponse();
      }

      try (Connection connection = createConnection()) {
        connection.setAutocommit(false);
        connection.setDdlInTransactionMode(mode);

        connection.execute(INSERT_STATEMENT);

        if (mode != DdlInTransactionMode.AUTO_COMMIT_TRANSACTION) {
          SpannerException exception =
              assertThrows(
                  SpannerException.class,
                  () -> connection.execute(Statement.of("start batch ddl")));
          assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
        } else {
          connection.execute(Statement.of("start batch ddl"));
          connection.execute(Statement.of("create table foo"));
          connection.execute(Statement.of("alter table bar"));
          connection.execute(Statement.of("run batch"));
          assertEquals(1, mockDatabaseAdmin.getRequests().size());
          UpdateDatabaseDdlRequest request =
              (UpdateDatabaseDdlRequest) mockDatabaseAdmin.getRequests().get(0);
          assertEquals(2, request.getStatementsCount());
          assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
        }
      }
    }
  }

  @Test
  public void testMissingDefaultSequenceKindException() {
    addUpdateDdlResponse(
        com.google.rpc.Status.newBuilder()
            .setCode(Code.INVALID_ARGUMENT_VALUE)
            .setMessage(
                "The sequence kind of an identity column id2 is not specified. Please specify the"
                    + " sequence kind explicitly or set the database option"
                    + " `default_sequence_kind`.")
            .build());
    try (Connection connection = createConnection()) {
      assertNull(connection.getDefaultSequenceKind());
      assertThrows(
          MissingDefaultSequenceKindException.class,
          () ->
              connection.execute(
                  Statement.of("create table foo (id2 int64 auto_increment primary key")));
    }
    // The request should not be retried.
    assertEquals(1, mockDatabaseAdmin.getRequests().size());
  }

  @Test
  public void testSetsDefaultSequenceKindAndRetriesStatement() {
    addUpdateDdlResponse(
        com.google.rpc.Status.newBuilder()
            .setCode(Code.INVALID_ARGUMENT_VALUE)
            .setMessage(
                "The sequence kind of an identity column id2 is not specified. Please specify the"
                    + " sequence kind explicitly or set the database option"
                    + " `default_sequence_kind`.")
            .build());
    // This will be the response for the 'alter database' statement.
    addUpdateDdlResponse();
    // This will be the response for the 'create table' statement after the retry.
    addUpdateDdlResponse();
    try (Connection connection = createConnection()) {
      connection.setDefaultSequenceKind("bit_reversed_positive");
      connection.execute(Statement.of("create table foo (id2 int64 auto_increment primary key"));
    }
    List<AbstractMessage> requests = mockDatabaseAdmin.getRequests();
    assertEquals(3, requests.size());
    assertEquals(
        "create table foo (id2 int64 auto_increment primary key",
        ((UpdateDatabaseDdlRequest) requests.get(0)).getStatements(0));
    assertEquals(
        "alter database `db` set options (default_sequence_kind='bit_reversed_positive')",
        ((UpdateDatabaseDdlRequest) requests.get(1)).getStatements(0));
    assertEquals(
        "create table foo (id2 int64 auto_increment primary key",
        ((UpdateDatabaseDdlRequest) requests.get(2)).getStatements(0));
  }

  @Test
  public void testMissingDefaultSequenceKindExceptionInBatch() {
    addUpdateDdlResponse(
        com.google.rpc.Status.newBuilder()
            .setCode(Code.INVALID_ARGUMENT_VALUE)
            .setMessage(
                "The sequence kind of an identity column id2 is not specified. Please specify the"
                    + " sequence kind explicitly or set the database option"
                    + " `default_sequence_kind`.")
            .build());
    try (Connection connection = createConnection()) {
      assertNull(connection.getDefaultSequenceKind());
      connection.startBatchDdl();
      connection.execute(Statement.of("create table foo (id2 int64 auto_increment primary key"));
      SpannerBatchUpdateException exception =
          assertThrows(SpannerBatchUpdateException.class, connection::runBatch);
    }
    // The request should not be retried.
    assertEquals(1, mockDatabaseAdmin.getRequests().size());
  }

  @Test
  public void testSetsDefaultSequenceKindAndRetriesBatch() {
    addUpdateDdlResponse(
        com.google.rpc.Status.newBuilder()
            .setCode(Code.INVALID_ARGUMENT_VALUE)
            .setMessage(
                "The sequence kind of an identity column id2 is not specified. Please specify the"
                    + " sequence kind explicitly or set the database option"
                    + " `default_sequence_kind`.")
            .build());
    // This will be the response for the 'alter database' statement.
    addUpdateDdlResponse();
    // This will be the response for the 'create table' statements after the retry.
    addUpdateDdlResponse();
    try (Connection connection = createConnection()) {
      connection.setDefaultSequenceKind("bit_reversed_positive");
      connection.startBatchDdl();
      connection.execute(Statement.of("create table foo (id1 int64 auto_increment primary key"));
      connection.execute(Statement.of("create table bar (id2 int64 auto_increment primary key"));
      connection.runBatch();
    }
    List<AbstractMessage> requests = mockDatabaseAdmin.getRequests();
    assertEquals(3, requests.size());
    assertEquals(
        "create table foo (id1 int64 auto_increment primary key",
        ((UpdateDatabaseDdlRequest) requests.get(0)).getStatements(0));
    assertEquals(
        "create table bar (id2 int64 auto_increment primary key",
        ((UpdateDatabaseDdlRequest) requests.get(0)).getStatements(1));
    assertEquals(
        "alter database `db` set options (default_sequence_kind='bit_reversed_positive')",
        ((UpdateDatabaseDdlRequest) requests.get(1)).getStatements(0));
    assertEquals(
        "create table foo (id1 int64 auto_increment primary key",
        ((UpdateDatabaseDdlRequest) requests.get(0)).getStatements(0));
    assertEquals(
        "create table bar (id2 int64 auto_increment primary key",
        ((UpdateDatabaseDdlRequest) requests.get(0)).getStatements(1));
  }

  @Test
  public void testStripTrailingSemicolon() {
    addUpdateDdlResponse();
    addUpdateDdlResponse();
    addUpdateDdlResponse();
    addUpdateDdlResponse();
    try (Connection connection = createConnection()) {
      connection.execute(Statement.of("drop table foo;"));
      connection.execute(Statement.of("drop table foo  \n\t;\n\t   "));
      connection.execute(Statement.of("drop table foo"));

      connection.startBatchDdl();
      connection.execute(Statement.of("create table foo (id1 int64 auto_increment primary key;"));
      connection.execute(
          Statement.of("create table foo (id1 int64 auto_increment primary key  \n\t;\n\t  "));
      connection.execute(Statement.of("create table foo (id2 int64 auto_increment primary key"));
      connection.runBatch();
    }
    assertEquals(4, mockDatabaseAdmin.getRequests().size());
    assertEquals(
        "drop table foo",
        ((UpdateDatabaseDdlRequest) mockDatabaseAdmin.getRequests().get(0)).getStatements(0));
    assertEquals(
        "drop table foo  \n\t",
        ((UpdateDatabaseDdlRequest) mockDatabaseAdmin.getRequests().get(1)).getStatements(0));
    assertEquals(
        "drop table foo",
        ((UpdateDatabaseDdlRequest) mockDatabaseAdmin.getRequests().get(2)).getStatements(0));

    assertEquals(
        3,
        ((UpdateDatabaseDdlRequest) mockDatabaseAdmin.getRequests().get(3)).getStatementsCount());
    assertEquals(
        "create table foo (id1 int64 auto_increment primary key",
        ((UpdateDatabaseDdlRequest) mockDatabaseAdmin.getRequests().get(3)).getStatements(0));
    assertEquals(
        "create table foo (id1 int64 auto_increment primary key  \n\t",
        ((UpdateDatabaseDdlRequest) mockDatabaseAdmin.getRequests().get(3)).getStatements(1));
    assertEquals(
        "create table foo (id2 int64 auto_increment primary key",
        ((UpdateDatabaseDdlRequest) mockDatabaseAdmin.getRequests().get(3)).getStatements(2));
  }
}
