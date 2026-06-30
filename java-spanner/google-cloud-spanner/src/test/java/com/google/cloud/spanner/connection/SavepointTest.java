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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.connection.AbstractMultiUseTransaction.Savepoint;
import com.google.common.collect.ImmutableList;
import io.opentelemetry.api.trace.Span;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SavepointTest {
  static class TestTransaction extends ReadOnlyTransaction {
    TestTransaction() {
      super(
          ReadOnlyTransaction.newBuilder()
              .setSpan(Span.getInvalid())
              .withStatementExecutor(mock(StatementExecutor.class)));
    }
  }

  @Test
  public void testCreateSavepoint_GoogleSql() {
    Dialect dialect = Dialect.GOOGLE_STANDARD_SQL;
    TestTransaction transaction = new TestTransaction();

    transaction.savepoint("s1", dialect);
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());

    transaction.savepoint("s2", dialect);
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2")), transaction.getSavepoints());

    // GoogleSql does not allow duplicate savepoint names.
    assertThrows(SpannerException.class, () -> transaction.savepoint("s1", dialect));
    assertThrows(SpannerException.class, () -> transaction.savepoint("s2", dialect));
  }

  @Test
  public void testCreateSavepoint_PostgreSQL() {
    Dialect dialect = Dialect.POSTGRESQL;
    TestTransaction transaction = new TestTransaction();

    transaction.savepoint("s1", dialect);
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());

    transaction.savepoint("s2", dialect);
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2")), transaction.getSavepoints());

    // PostgreSQL allows duplicate savepoint names.
    transaction.savepoint("s2", dialect);
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2"), Savepoint.of("s2")),
        transaction.getSavepoints());
    transaction.savepoint("s1", dialect);
    assertEquals(
        ImmutableList.of(
            Savepoint.of("s1"), Savepoint.of("s2"), Savepoint.of("s2"), Savepoint.of("s1")),
        transaction.getSavepoints());
  }

  @Test
  public void testReleaseSavepoint_GoogleSql() {
    Dialect dialect = Dialect.GOOGLE_STANDARD_SQL;
    TestTransaction transaction = new TestTransaction();

    transaction.savepoint("s1", dialect);
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());
    transaction.releaseSavepoint("s1");
    assertEquals(ImmutableList.of(), transaction.getSavepoints());

    transaction.savepoint("s1", dialect);
    transaction.savepoint("s2", dialect);
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2")), transaction.getSavepoints());
    transaction.releaseSavepoint("s2");
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());

    transaction.savepoint("s2", dialect);
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2")), transaction.getSavepoints());
    transaction.releaseSavepoint("s1");
    assertEquals(ImmutableList.of(), transaction.getSavepoints());

    assertThrows(SpannerException.class, () -> transaction.releaseSavepoint("s1"));

    transaction.savepoint("s1", dialect);
    assertThrows(SpannerException.class, () -> transaction.releaseSavepoint("s2"));
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());
  }

  @Test
  public void testReleaseSavepoint_PostgreSQL() {
    Dialect dialect = Dialect.POSTGRESQL;
    TestTransaction transaction = new TestTransaction();

    transaction.savepoint("s1", dialect);
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());
    transaction.releaseSavepoint("s1");
    assertEquals(ImmutableList.of(), transaction.getSavepoints());

    transaction.savepoint("s1", dialect);
    transaction.savepoint("s2", dialect);
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2")), transaction.getSavepoints());
    transaction.releaseSavepoint("s2");
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());

    transaction.savepoint("s2", dialect);
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2")), transaction.getSavepoints());
    transaction.releaseSavepoint("s1");
    assertEquals(ImmutableList.of(), transaction.getSavepoints());

    assertThrows(SpannerException.class, () -> transaction.releaseSavepoint("s1"));

    transaction.savepoint("s1", dialect);
    assertThrows(SpannerException.class, () -> transaction.releaseSavepoint("s2"));
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());

    transaction.savepoint("s2", dialect);
    transaction.savepoint("s1", dialect);
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2"), Savepoint.of("s1")),
        transaction.getSavepoints());
    transaction.releaseSavepoint("s1");
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2")), transaction.getSavepoints());
  }

  @Test
  public void testRollbackToSavepoint_GoogleSql() {
    Dialect dialect = Dialect.GOOGLE_STANDARD_SQL;
    TestTransaction transaction = new TestTransaction();

    transaction.savepoint("s1", dialect);
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());
    transaction.rollbackToSavepoint("s1", SavepointSupport.ENABLED);
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());

    transaction.savepoint("s2", dialect);
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2")), transaction.getSavepoints());
    transaction.rollbackToSavepoint("s2", SavepointSupport.ENABLED);
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2")), transaction.getSavepoints());

    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2")), transaction.getSavepoints());
    transaction.rollbackToSavepoint("s1", SavepointSupport.ENABLED);
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());

    assertThrows(
        SpannerException.class,
        () -> transaction.rollbackToSavepoint("s2", SavepointSupport.ENABLED));
  }

  @Test
  public void testRollbackToSavepoint_PostgreSQL() {
    Dialect dialect = Dialect.POSTGRESQL;
    TestTransaction transaction = new TestTransaction();

    transaction.savepoint("s1", dialect);
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());
    transaction.rollbackToSavepoint("s1", SavepointSupport.ENABLED);
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());

    transaction.savepoint("s2", dialect);
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2")), transaction.getSavepoints());
    transaction.rollbackToSavepoint("s2", SavepointSupport.ENABLED);
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2")), transaction.getSavepoints());

    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2")), transaction.getSavepoints());
    transaction.rollbackToSavepoint("s1", SavepointSupport.ENABLED);
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());

    assertThrows(
        SpannerException.class,
        () -> transaction.rollbackToSavepoint("s2", SavepointSupport.ENABLED));
    assertEquals(ImmutableList.of(Savepoint.of("s1")), transaction.getSavepoints());

    transaction.savepoint("s2", dialect);
    transaction.savepoint("s1", dialect);
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2"), Savepoint.of("s1")),
        transaction.getSavepoints());
    transaction.rollbackToSavepoint("s1", SavepointSupport.ENABLED);
    assertEquals(
        ImmutableList.of(Savepoint.of("s1"), Savepoint.of("s2"), Savepoint.of("s1")),
        transaction.getSavepoints());
  }
}
