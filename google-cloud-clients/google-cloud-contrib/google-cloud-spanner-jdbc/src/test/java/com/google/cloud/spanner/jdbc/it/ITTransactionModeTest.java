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

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.jdbc.ITAbstractSpannerTest;
import com.google.cloud.spanner.jdbc.SpannerExceptionMatcher;
import com.google.cloud.spanner.jdbc.SqlScriptVerifier;
import java.util.Arrays;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITTransactionModeTest extends ITAbstractSpannerTest {
  @Rule public ExpectedException exception = ExpectedException.none();

  @Override
  public void appendConnectionUri(StringBuilder uri) {
    uri.append("?autocommit=false");
  }

  @Override
  public boolean doCreateDefaultTestTable() {
    return true;
  }

  @Test
  public void testSqlScript() throws Exception {
    SqlScriptVerifier verifier = new SqlScriptVerifier(new ITConnectionProvider());
    verifier.verifyStatementsInFile("ITTransactionModeTest.sql", SqlScriptVerifier.class, true);
  }

  @Test
  public void testDoAllowBufferedWriteInReadWriteTransaction() {
    try (ITConnection connection = createConnection()) {
      assertThat(connection.isAutocommit(), is(false));
      connection.bufferedWrite(
          Mutation.newInsertBuilder("TEST").set("ID").to(1L).set("NAME").to("TEST").build());
      connection.commit();
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT NAME FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("NAME"), is(equalTo("TEST")));
        assertThat(rs.next(), is(false));
      }
      connection.bufferedWrite(
          Mutation.newUpdateBuilder("TEST").set("ID").to(1L).set("NAME").to("TEST2").build());
      connection.commit();
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT NAME FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("NAME"), is(equalTo("TEST2")));
        assertThat(rs.next(), is(false));
      }
      connection.bufferedWrite(Mutation.delete("TEST", Key.of(1L)));
      connection.commit();
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT NAME FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(false));
      }
    }
  }

  @Test
  public void testDoAllowBufferedWriteIterableInReadWriteTransaction() {
    try (ITConnection connection = createConnection()) {
      assertThat(connection.isAutocommit(), is(false));
      connection.bufferedWrite(
          Arrays.asList(
              Mutation.newInsertBuilder("TEST").set("ID").to(1L).set("NAME").to("TEST-1").build(),
              Mutation.newInsertBuilder("TEST").set("ID").to(2L).set("NAME").to("TEST-2").build()));
      connection.commit();
      try (ResultSet rs =
          connection.executeQuery(
              Statement.of("SELECT NAME FROM TEST WHERE ID IN (1,2) ORDER BY ID"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("NAME"), is(equalTo("TEST-1")));
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("NAME"), is(equalTo("TEST-2")));
        assertThat(rs.next(), is(false));
      }
      connection.bufferedWrite(
          Arrays.asList(
              Mutation.newUpdateBuilder("TEST").set("ID").to(1L).set("NAME").to("TEST-1-2").build(),
              Mutation.newUpdateBuilder("TEST")
                  .set("ID")
                  .to(2L)
                  .set("NAME")
                  .to("TEST-2-2")
                  .build()));
      connection.commit();
      try (ResultSet rs =
          connection.executeQuery(
              Statement.of("SELECT NAME FROM TEST WHERE ID IN (1,2) ORDER BY ID"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("NAME"), is(equalTo("TEST-1-2")));
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("NAME"), is(equalTo("TEST-2-2")));
        assertThat(rs.next(), is(false));
      }
      connection.bufferedWrite(
          Arrays.asList(Mutation.delete("TEST", Key.of(1L)), Mutation.delete("TEST", Key.of(2L))));
      connection.commit();
      try (ResultSet rs =
          connection.executeQuery(
              Statement.of("SELECT NAME FROM TEST WHERE ID IN (1,2) ORDER BY ID"))) {
        assertThat(rs.next(), is(false));
      }
    }
  }

  @Test
  public void testDoNotAllowBufferedWriteInReadOnlyTransaction() {
    try (ITConnection connection = createConnection()) {
      connection.execute(Statement.of("SET TRANSACTION READ ONLY"));
      assertThat(connection.isAutocommit(), is(false));
      exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
      connection.bufferedWrite(Mutation.newInsertBuilder("FOO").set("ID").to(1L).build());
    }
  }

  @Test
  public void testDoNotAllowBufferedWriteIterableInReadOnlyTransaction() {
    try (ITConnection connection = createConnection()) {
      connection.execute(Statement.of("SET TRANSACTION READ ONLY"));
      assertThat(connection.isAutocommit(), is(false));
      exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
      connection.bufferedWrite(
          Arrays.asList(
              Mutation.newInsertBuilder("FOO").set("ID").to(1L).build(),
              Mutation.newInsertBuilder("FOO").set("ID").to(2L).build()));
    }
  }

  @Test
  public void testDoNotAllowBufferedWriteInDdlBatch() {
    try (ITConnection connection = createConnection()) {
      connection.startBatchDdl();
      assertThat(connection.isAutocommit(), is(false));
      assertThat(connection.isDdlBatchActive(), is(true));
      exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
      connection.bufferedWrite(Mutation.newInsertBuilder("FOO").set("ID").to(1L).build());
    }
  }

  @Test
  public void testDoNotAllowBufferedWriteIterableInDdlBatch() {
    try (ITConnection connection = createConnection()) {
      connection.startBatchDdl();
      assertThat(connection.isAutocommit(), is(false));
      assertThat(connection.isDdlBatchActive(), is(true));
      exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
      connection.bufferedWrite(
          Arrays.asList(
              Mutation.newInsertBuilder("FOO").set("ID").to(1L).build(),
              Mutation.newInsertBuilder("FOO").set("ID").to(2L).build()));
    }
  }
}
