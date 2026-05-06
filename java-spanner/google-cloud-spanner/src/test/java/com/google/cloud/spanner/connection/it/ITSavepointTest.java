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

package com.google.cloud.spanner.connection.it;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest;
import com.google.cloud.spanner.connection.SavepointSupport;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITSavepointTest extends ITAbstractSpannerTest {
  @Override
  public void appendConnectionUri(StringBuilder uri) {
    uri.append(";autocommit=false");
  }

  @Override
  public boolean doCreateDefaultTestTable() {
    return true;
  }

  @Before
  public void clearTestData() {
    try (ITConnection connection = createConnection()) {
      connection.bufferedWrite(Mutation.delete("TEST", KeySet.all()));
      connection.commit();
    }
  }

  @Test
  public void testRollbackDmlStatement() {
    try (ITConnection connection = createConnection()) {
      connection.setSavepointSupport(SavepointSupport.ENABLED);
      assertEquals(
          1L,
          connection.executeUpdate(
              Statement.newBuilder("insert into test (id, name) values (@id, @name)")
                  .bind("id")
                  .to(1L)
                  .bind("name")
                  .to("One")
                  .build()));
      connection.savepoint("s1");
      assertEquals(
          1L,
          connection.executeUpdate(
              Statement.newBuilder("insert into test (id, name) values (@id, @name)")
                  .bind("id")
                  .to(2L)
                  .bind("name")
                  .to("Two")
                  .build()));

      connection.rollbackToSavepoint("s1");
      connection.commit();

      try (ResultSet resultSet = connection.executeQuery(Statement.of("select * from test"))) {
        assertTrue(resultSet.next());
        assertEquals(1L, resultSet.getLong(0));
        assertEquals("One", resultSet.getString(1));
        assertFalse(resultSet.next());
      }
    }
  }

  @Test
  public void testRollbackMutations() {
    try (ITConnection connection = createConnection()) {
      connection.setSavepointSupport(SavepointSupport.ENABLED);
      connection.bufferedWrite(
          Mutation.newInsertBuilder("test").set("id").to(1L).set("name").to("One").build());
      connection.savepoint("s1");
      connection.bufferedWrite(
          Mutation.newInsertBuilder("test").set("id").to(2L).set("name").to("Two").build());
      connection.savepoint("s2");
      connection.bufferedWrite(
          Mutation.newInsertBuilder("test").set("id").to(3L).set("name").to("Three").build());
      connection.savepoint("s3");
      connection.bufferedWrite(
          Mutation.newInsertBuilder("test").set("id").to(4L).set("name").to("Four").build());
      connection.savepoint("s4");

      connection.rollbackToSavepoint("s2");
      connection.commit();

      try (ResultSet resultSet =
          connection.executeQuery(Statement.of("select * from test order by id"))) {
        assertTrue(resultSet.next());
        assertEquals(1L, resultSet.getLong(0));
        assertEquals("One", resultSet.getString(1));
        assertTrue(resultSet.next());
        assertEquals(2L, resultSet.getLong(0));
        assertEquals("Two", resultSet.getString(1));
        assertFalse(resultSet.next());
      }
    }
  }

  @Test
  public void testRollbackBatchDmlStatement() {
    try (ITConnection connection = createConnection()) {
      connection.setSavepointSupport(SavepointSupport.ENABLED);
      assertArrayEquals(
          new long[] {1L, 1L},
          connection.executeBatchUpdate(
              ImmutableList.of(
                  Statement.newBuilder("insert into test (id, name) values (@id, @name)")
                      .bind("id")
                      .to(1L)
                      .bind("name")
                      .to("One")
                      .build(),
                  Statement.newBuilder("insert into test (id, name) values (@id, @name)")
                      .bind("id")
                      .to(2L)
                      .bind("name")
                      .to("Two")
                      .build())));
      connection.savepoint("s1");
      assertArrayEquals(
          new long[] {1L, 1L},
          connection.executeBatchUpdate(
              ImmutableList.of(
                  Statement.newBuilder("insert into test (id, name) values (@id, @name)")
                      .bind("id")
                      .to(3L)
                      .bind("name")
                      .to("Three")
                      .build(),
                  Statement.newBuilder("insert into test (id, name) values (@id, @name)")
                      .bind("id")
                      .to(4L)
                      .bind("name")
                      .to("Four")
                      .build())));

      connection.rollbackToSavepoint("s1");
      connection.commit();

      try (ResultSet resultSet =
          connection.executeQuery(Statement.of("select * from test order by id"))) {
        assertTrue(resultSet.next());
        assertEquals(1L, resultSet.getLong(0));
        assertEquals("One", resultSet.getString(1));
        assertTrue(resultSet.next());
        assertEquals(2L, resultSet.getLong(0));
        assertEquals("Two", resultSet.getString(1));
        assertFalse(resultSet.next());
      }
    }
  }
}
