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
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.jdbc.ITAbstractSpannerTest;
import com.google.cloud.spanner.jdbc.SqlScriptVerifier;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ITReadWriteAutocommitSpannerTest extends ITAbstractSpannerTest {

  @Rule public ExpectedException exception = ExpectedException.none();

  @Override
  protected void appendConnectionUri(StringBuilder uri) {
    uri.append(";autocommit=true");
  }

  @Override
  public boolean doCreateDefaultTestTable() {
    return true;
  }

  @Test
  public void test01_SqlScript() throws Exception {
    SqlScriptVerifier verifier = new SqlScriptVerifier(new ITConnectionProvider());
    verifier.verifyStatementsInFile(
        "ITReadWriteAutocommitSpannerTest.sql", SqlScriptVerifier.class, true);
  }

  @Test
  public void test02_WriteMutation() throws Exception {
    try (ITConnection connection = createConnection()) {
      connection.write(
          Mutation.newInsertBuilder("TEST").set("ID").to(9999L).set("NAME").to("FOO").build());
      assertThat(connection.getCommitTimestamp(), is(notNullValue()));
    }
  }

  @Test
  public void test03_MultipleStatements_WithTimeouts() throws InterruptedException {
    try (ITConnection connection = createConnection()) {
      // do an insert that should succeed
      assertThat(
          connection.executeUpdate(
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1000, 'test')")),
          is(equalTo(1L)));
      // check that the insert succeeded
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT * FROM TEST WHERE ID=1000"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("NAME"), is(equalTo("test")));
        assertThat(rs.next(), is(false));
      }

      // do an update that should time out
      connection.setStatementTimeout(1L, TimeUnit.MILLISECONDS);
      try {
        connection.executeUpdate(Statement.of("UPDATE TEST SET NAME='test18' WHERE ID=1000"));
      } catch (SpannerException e) {
        if (e.getErrorCode() != ErrorCode.DEADLINE_EXCEEDED) {
          throw e;
        }
      }
      // remove the timeout setting
      connection.clearStatementTimeout();

      // do a delete that should succeed
      connection.executeUpdate(Statement.of("DELETE FROM TEST WHERE ID=1000"));
      // verify that the delete did succeed
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT * FROM TEST WHERE ID=1000"))) {
        assertThat(rs.next(), is(false));
      }
    }
  }

  @Test
  public void test04_BatchUpdate() {
    try (ITConnection connection = createConnection()) {
      long[] updateCounts =
          connection.executeBatchUpdate(
              Arrays.asList(
                  Statement.of("INSERT INTO TEST (ID, NAME) VALUES (10, 'Batch value 1')"),
                  Statement.of("INSERT INTO TEST (ID, NAME) VALUES (11, 'Batch value 2')"),
                  Statement.of("INSERT INTO TEST (ID, NAME) VALUES (12, 'Batch value 3')"),
                  Statement.of("INSERT INTO TEST (ID, NAME) VALUES (13, 'Batch value 4')"),
                  Statement.of("INSERT INTO TEST (ID, NAME) VALUES (14, 'Batch value 5')"),
                  Statement.of("INSERT INTO TEST (ID, NAME) VALUES (15, 'Batch value 6')"),
                  Statement.of("INSERT INTO TEST (ID, NAME) VALUES (16, 'Batch value 7')"),
                  Statement.of("INSERT INTO TEST (ID, NAME) VALUES (17, 'Batch value 8')"),
                  Statement.of("INSERT INTO TEST (ID, NAME) VALUES (18, 'Batch value 9')"),
                  Statement.of("INSERT INTO TEST (ID, NAME) VALUES (19, 'Batch value 10')"),
                  Statement.of("INSERT INTO TEST (ID, NAME) VALUES (20, 'Batch value 11')")));
      assertThat(
          updateCounts, is(equalTo(new long[] {1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L})));
      try (ResultSet rs =
          connection.executeQuery(
              Statement.of("SELECT COUNT(*) FROM TEST WHERE ID>=10 AND ID<=20"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong(0), is(equalTo(11L)));
      }
    }
  }

  @Test
  public void test05_BatchUpdateWithException() {
    try (ITConnection con1 = createConnection();
        ITConnection con2 = createConnection()) {
      try {
        con1.executeBatchUpdate(
            Arrays.asList(
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (21, 'Batch value 1')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (22, 'Batch value 2')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (23, 'Batch value 3')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (24, 'Batch value 4')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (25, 'Batch value 5')"),
                Statement.of("INSERT INTO TEST_NOT_FOUND (ID, NAME) VALUES (26, 'Batch value 6')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (27, 'Batch value 7')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (28, 'Batch value 8')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (29, 'Batch value 9')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (30, 'Batch value 10')")));
        fail("Missing batch update exception");
      } catch (SpannerBatchUpdateException e) {
        assertThat(e.getUpdateCounts(), is(equalTo(new long[] {1L, 1L, 1L, 1L, 1L})));
      }
      // Verify that the values cannot be read on the connection that did the insert.
      try (ResultSet rs =
          con1.executeQuery(Statement.of("SELECT COUNT(*) FROM TEST WHERE ID>=21 AND ID<=30"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong(0), is(equalTo(0L)));
      }
      // Verify that the values can also not be read on another connection.
      try (ResultSet rs =
          con2.executeQuery(Statement.of("SELECT COUNT(*) FROM TEST WHERE ID>=21 AND ID<=30"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong(0), is(equalTo(0L)));
      }
    }
  }
}
