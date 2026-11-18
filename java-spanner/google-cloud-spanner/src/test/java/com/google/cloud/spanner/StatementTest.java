/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.testing.SerializableTester.reserializeAndAssert;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

import com.google.cloud.ByteArray;
import com.google.common.collect.ImmutableMap;
import com.google.common.testing.EqualsTester;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.Statement}. */
@RunWith(JUnit4.class)
public class StatementTest {

  @Test
  public void basic() {
    String sql = "SELECT 1";
    Statement stmt = Statement.of(sql);
    assertThat(stmt.getSql()).isEqualTo(sql);
    assertThat(stmt.getParameters()).isEmpty();
    assertThat(stmt.toString()).isEqualTo(sql);
    reserializeAndAssert(stmt);
  }

  @Test
  public void basicWithParameters() {
    String sql = "SELECT @name";
    Statement stmt = Statement.of(sql, ImmutableMap.of("name", Value.string("hello")));
    assertEquals(sql, stmt.getSql());
    assertFalse(stmt.getParameters().isEmpty());
    assertEquals(Value.string("hello"), stmt.getParameters().get("name"));
    assertEquals(sql + " {name: hello}", stmt.toString());
    reserializeAndAssert(stmt);
  }

  @Test
  public void serialization() {
    Statement stmt =
        Statement.newBuilder("SELECT * FROM table WHERE ")
            .append("bool_field = @bool_field ")
            .bind("bool_field")
            .to(true)
            .append("long_field = @long_field ")
            .bind("long_field")
            .to(1L)
            .append("float_field = @float_field ")
            .bind("float_field")
            .to(1.)
            .append("string_field = @string_field ")
            .bind("string_field")
            .to("abc")
            .append("bytes_field = @bytes_field ")
            .bind("bytes_field")
            .to(ByteArray.fromBase64("abcd"))
            .bind("untyped_null_field")
            .to((Value) null)
            .build();
    reserializeAndAssert(stmt);
  }

  @Test
  public void append() {
    Statement stmt =
        Statement.newBuilder("SELECT Name FROM Users")
            .append(" WHERE Id = @id")
            .bind("id")
            .to(1234)
            .append(" AND Status = @status")
            .bind("status")
            .to("ACTIVE")
            .build();
    String expectedSql = "SELECT Name FROM Users WHERE Id = @id AND Status = @status";
    assertThat(stmt.getSql()).isEqualTo(expectedSql);
    assertThat(stmt.hasBinding("id")).isTrue();
    assertThat(stmt.hasBinding("status")).isTrue();
    assertThat(stmt.getParameters())
        .containsExactlyEntriesIn(
            ImmutableMap.of("id", Value.int64(1234), "status", Value.string("ACTIVE")));
    assertThat(stmt.toString()).startsWith(expectedSql);
    assertThat(stmt.toString()).contains("id: 1234");
    assertThat(stmt.toString()).contains("status: ACTIVE");
  }

  @Test
  public void bindReplacement() {
    String sql = "SELECT Name FROM Users WHERE Id = @id";
    Statement stmt = Statement.newBuilder(sql).bind("id").to(1).bind("id").to(2).build();
    assertThat(stmt.hasBinding("id")).isTrue();
    assertThat(stmt.getSql()).isEqualTo(sql);
    assertThat(stmt.getParameters()).isEqualTo(ImmutableMap.of("id", Value.int64(2)));
    assertThat(stmt.toString()).isEqualTo(sql + " {id: 2}");
  }

  @Test
  public void incompleteBinding() {
    Statement.Builder builder = Statement.newBuilder("SELECT @v");
    builder.bind("v");
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> builder.build());
    assertNotNull(e.getMessage());
  }

  @Test
  public void bindingInProgress() {
    Statement.Builder builder = Statement.newBuilder("SELECT @v");
    builder.bind("v");
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> builder.bind("y"));
    assertNotNull(e.getMessage());
  }

  @Test
  public void alreadyBound() {
    ValueBinder<Statement.Builder> binder = Statement.newBuilder("SELECT @v").bind("v");
    binder.to("abc");
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> binder.to("xyz"));
    assertNotNull(e.getMessage());
  }

  @Test
  public void bindCommitTimestampFails() {
    ValueBinder<Statement.Builder> binder = Statement.newBuilder("SELECT @v").bind("v");
    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> binder.to(Value.COMMIT_TIMESTAMP));
    assertNotNull(e.getMessage());
  }

  @Test
  public void gettersAreSnapshot() {
    Statement stmt =
        Statement.newBuilder("SELECT Name FROM Users WHERE Id = @id")
            .append(" AND Status = @status")
            .bind("status")
            .to("ACTIVE")
            .bind("id")
            .to(1234)
            .bind("status")
            .to("ACTIVE")
            .build();
    assertThat(stmt.getSql())
        .isEqualTo("SELECT Name FROM Users WHERE Id = @id AND Status = @status");
    assertThat(stmt.getParameters())
        .isEqualTo(ImmutableMap.of("id", Value.int64(1234), "status", Value.string("ACTIVE")));
  }

  @Test
  public void equalsAndHashCode() {
    EqualsTester tester = new EqualsTester();
    tester.addEqualityGroup(
        Statement.of("SELECT 1"),
        Statement.of("SELECT 1"),
        Statement.newBuilder("SELECT ").append("1").build());
    tester.addEqualityGroup(Statement.of("SELECT 2"));
    // Note that some of the following are incomplete bindings: they would fail if executed.
    tester.addEqualityGroup(
        Statement.newBuilder("SELECT @x, @y").bind("x").to(1).build(),
        Statement.newBuilder("SELECT @x, @y").bind("x").to(1).build());
    tester.addEqualityGroup(Statement.newBuilder("SELECT @x, @y").bind("x").to("1").build());
    tester.addEqualityGroup(Statement.newBuilder("SELECT @x, @y").bind("x").to(2).build());
    tester.addEqualityGroup(Statement.newBuilder("SELECT @x, @y").bind("y").to(2).build());
    tester.addEqualityGroup(
        Statement.newBuilder("SELECT @x, @y").bind("x").to(1).bind("y").to(2).build());
    tester.addEqualityGroup(
        Statement.newBuilder("SELECT @x, @y").bind("x").to((Value) null).build(),
        Statement.newBuilder("SELECT @x, @y").bind("x").to((Value) null).build());
    tester.testEquals();
  }

  @Test
  public void testGetParameterName() {
    assertEquals("p1", Statement.getParameterName(1));
    assertEquals("p950", Statement.getParameterName(950));
    assertEquals("p951", Statement.getParameterName(951));
    assertEquals("p0", Statement.getParameterName(0));
    assertEquals("p-1", Statement.getParameterName(-1));

    // Verify instance caching for indices 1..950
    for (int i = 1; i <= 950; i++) {
      assertSame(Statement.getParameterName(i), Statement.getParameterName(i));
    }
  }

  @Test
  public void withUnnamedParametersMatchingCounts() {
    Statement.StatementFactory gsqlFactory =
        new Statement.StatementFactory(Dialect.GOOGLE_STANDARD_SQL);
    Statement.StatementFactory pgFactory = new Statement.StatementFactory(Dialect.POSTGRESQL);

    Statement rawOf = gsqlFactory.of("SELECT * FROM Users WHERE id = ?");
    assertThat(rawOf.getSql()).isEqualTo("SELECT * FROM Users WHERE id = ?");
    assertThat(rawOf.getParameters()).isEmpty();

    Statement gsqlZero = gsqlFactory.withUnnamedParameters("SELECT 1");
    assertThat(gsqlZero.getSql()).isEqualTo("SELECT 1");
    assertThat(gsqlZero.getParameters()).isEmpty();
    assertThrows(
        UnsupportedOperationException.class,
        () -> gsqlZero.getParameters().put("p1", Value.bool(true)));

    Statement pgZero = pgFactory.withUnnamedParameters("SELECT 1");
    assertThat(pgZero.getSql()).isEqualTo("SELECT 1");
    assertThat(pgZero.getParameters()).isEmpty();
    assertThrows(
        UnsupportedOperationException.class,
        () -> pgZero.getParameters().put("p1", Value.bool(true)));

    Statement gsqlOne = gsqlFactory.withUnnamedParameters("SELECT * FROM Users WHERE id = ?", 10L);
    assertThat(gsqlOne.getSql()).isEqualTo("SELECT * FROM Users WHERE id = @p1");
    assertThat(gsqlOne.getParameters()).containsExactly("p1", Value.toValue(10L));
    assertThrows(
        UnsupportedOperationException.class,
        () -> gsqlOne.getParameters().put("p2", Value.bool(true)));
    reserializeAndAssert(gsqlOne);

    Statement pgOne = pgFactory.withUnnamedParameters("SELECT * FROM users WHERE id = ?", 10L);
    assertThat(pgOne.getSql()).isEqualTo("SELECT * FROM users WHERE id = $1");
    assertThat(pgOne.getParameters()).containsExactly("p1", Value.toValue(10L));
    assertThrows(
        UnsupportedOperationException.class,
        () -> pgOne.getParameters().put("p2", Value.bool(true)));
    reserializeAndAssert(pgOne);

    Statement gsqlMulti =
        gsqlFactory.withUnnamedParameters(
            "INSERT INTO Users (id, name, active) VALUES (?, ?, ?)", 10L, "Alice", true);
    assertThat(gsqlMulti.getSql())
        .isEqualTo("INSERT INTO Users (id, name, active) VALUES (@p1, @p2, @p3)");
    assertThat(gsqlMulti.getParameters())
        .containsExactly(
            "p1", Value.toValue(10L), "p2", Value.toValue("Alice"), "p3", Value.bool(true));
    assertThrows(UnsupportedOperationException.class, () -> gsqlMulti.getParameters().clear());

    Statement pgMulti =
        pgFactory.withUnnamedParameters(
            "INSERT INTO users (id, name, active) VALUES (?, ?, ?)", 10L, "Alice", true);
    assertThat(pgMulti.getSql())
        .isEqualTo("INSERT INTO users (id, name, active) VALUES ($1, $2, $3)");
    assertThat(pgMulti.getParameters())
        .containsExactly(
            "p1", Value.toValue(10L), "p2", Value.toValue("Alice"), "p3", Value.bool(true));
    assertThrows(UnsupportedOperationException.class, () -> pgMulti.getParameters().clear());
  }

  @Test
  public void withUnnamedParametersNullHandling() {
    assertThrows(NullPointerException.class, () -> new Statement.StatementFactory(null));

    Statement.StatementFactory gsqlFactory =
        new Statement.StatementFactory(Dialect.GOOGLE_STANDARD_SQL);
    Statement.StatementFactory pgFactory = new Statement.StatementFactory(Dialect.POSTGRESQL);

    AtomicBoolean iteratorRequested = new AtomicBoolean(false);
    Iterable<Long> unconsumedIterable =
        () -> {
          iteratorRequested.set(true);
          throw new AssertionError("Iterator must not be consumed when sql is null");
        };

    assertThrows(NullPointerException.class, () -> gsqlFactory.withUnnamedParameters(null));
    assertThrows(
        NullPointerException.class,
        () -> gsqlFactory.withUnnamedParameters(null, unconsumedIterable));
    assertFalse(iteratorRequested.get());

    assertThrows(
        NullPointerException.class,
        () -> gsqlFactory.withUnnamedParameters("SELECT ?", (Object[]) null));
    assertThrows(
        NullPointerException.class,
        () -> pgFactory.withUnnamedParameters("SELECT 1", (Object[]) null));

    Statement gsqlNullElement =
        gsqlFactory.withUnnamedParameters("SELECT * FROM Users WHERE name = ?", (Object) null);
    assertThat(gsqlNullElement.getSql()).isEqualTo("SELECT * FROM Users WHERE name = @p1");
    assertThat(gsqlNullElement.hasBinding("p1")).isTrue();
    assertThat(gsqlNullElement.getParameters().get("p1").isNull()).isTrue();
    assertThat(gsqlNullElement.getParameters().get("p1")).isEqualTo(Value.toValue(null));

    Statement pgNullElement =
        pgFactory.withUnnamedParameters("SELECT * FROM users WHERE name = ?", (Object) null);
    assertThat(pgNullElement.getSql()).isEqualTo("SELECT * FROM users WHERE name = $1");
    assertThat(pgNullElement.getParameters().get("p1").isNull()).isTrue();
  }

  @Test
  public void withUnnamedParametersTooFewValues() {
    for (Dialect dialect : Dialect.values()) {
      Statement.StatementFactory factory = new Statement.StatementFactory(dialect);

      SpannerException zeroForOne =
          assertThrows(
              SpannerException.class,
              () -> factory.withUnnamedParameters("SELECT * FROM Users WHERE id = ?"));
      assertEquals(ErrorCode.INVALID_ARGUMENT, zeroForOne.getErrorCode());
      assertThat(zeroForOne.getMessage()).contains("1");
      assertThat(zeroForOne.getMessage()).contains("0");

      AtomicBoolean iteratorRequested = new AtomicBoolean(false);
      Iterable<Long> unconsumedIterable =
          () -> {
            iteratorRequested.set(true);
            throw new AssertionError("Iterator must not be consumed on parameter count mismatch");
          };

      SpannerException oneForTwo =
          assertThrows(
              SpannerException.class,
              () ->
                  factory.withUnnamedParameters(
                      "SELECT * FROM Users WHERE id = ? AND parent_id = ?", unconsumedIterable));
      assertEquals(ErrorCode.INVALID_ARGUMENT, oneForTwo.getErrorCode());
      assertThat(oneForTwo.getMessage()).contains("2");
      assertThat(oneForTwo.getMessage()).contains("1");
      assertFalse(iteratorRequested.get());
    }
  }

  @Test
  public void withUnnamedParametersTooManyValues() {
    for (Dialect dialect : Dialect.values()) {
      Statement.StatementFactory factory = new Statement.StatementFactory(dialect);

      SpannerException oneForZero =
          assertThrows(
              SpannerException.class, () -> factory.withUnnamedParameters("SELECT 1", 10L));
      assertEquals(ErrorCode.INVALID_ARGUMENT, oneForZero.getErrorCode());
      assertThat(oneForZero.getMessage()).contains("0");
      assertThat(oneForZero.getMessage()).contains("1");

      SpannerException nullElementForZero =
          assertThrows(
              SpannerException.class,
              () -> factory.withUnnamedParameters("SELECT 1", (Object) null));
      assertEquals(ErrorCode.INVALID_ARGUMENT, nullElementForZero.getErrorCode());

      AtomicBoolean iteratorRequested = new AtomicBoolean(false);
      Iterable<Long> unconsumedIterable =
          () -> {
            iteratorRequested.set(true);
            throw new AssertionError("Iterator must not be consumed on parameter count mismatch");
          };

      SpannerException threeForTwo =
          assertThrows(
              SpannerException.class,
              () ->
                  factory.withUnnamedParameters(
                      "SELECT * FROM Users WHERE id = ? AND name = ?",
                      10L,
                      "Alice",
                      unconsumedIterable));
      assertEquals(ErrorCode.INVALID_ARGUMENT, threeForTwo.getErrorCode());
      assertThat(threeForTwo.getMessage()).contains("2");
      assertThat(threeForTwo.getMessage()).contains("3");
      assertFalse(iteratorRequested.get());
    }

    Statement.StatementFactory gsqlFactory =
        new Statement.StatementFactory(Dialect.GOOGLE_STANDARD_SQL);
    SpannerException gsqlNativePlaceholder =
        assertThrows(
            SpannerException.class,
            () -> gsqlFactory.withUnnamedParameters("SELECT * FROM Users WHERE id = @p1", 10L));
    assertEquals(ErrorCode.INVALID_ARGUMENT, gsqlNativePlaceholder.getErrorCode());

    Statement.StatementFactory pgFactory = new Statement.StatementFactory(Dialect.POSTGRESQL);
    SpannerException pgNativePlaceholder =
        assertThrows(
            SpannerException.class,
            () -> pgFactory.withUnnamedParameters("SELECT * FROM users WHERE id = $1", 10L));
    assertEquals(ErrorCode.INVALID_ARGUMENT, pgNativePlaceholder.getErrorCode());
  }

  @Test
  public void withUnnamedParametersIgnoresLiteralsAndComments() {
    Statement.StatementFactory gsqlFactory =
        new Statement.StatementFactory(Dialect.GOOGLE_STANDARD_SQL);
    String gsql =
        "-- ? line comment\n"
            + "# ? hash comment\r"
            + "/* ? block comment */ "
            + "SELECT '?', \"?\", `?`, '''?''', 'it\\'s ?' FROM Users WHERE id = ?";
    Statement gsqlStmt = gsqlFactory.withUnnamedParameters(gsql, 42L);
    assertThat(gsqlStmt.getSql()).endsWith("WHERE id = @p1");
    assertThat(gsqlStmt.getParameters()).containsExactly("p1", Value.toValue(42L));
    assertEquals(
        ErrorCode.INVALID_ARGUMENT,
        assertThrows(SpannerException.class, () -> gsqlFactory.withUnnamedParameters(gsql))
            .getErrorCode());
    assertEquals(
        ErrorCode.INVALID_ARGUMENT,
        assertThrows(
                SpannerException.class, () -> gsqlFactory.withUnnamedParameters(gsql, 42L, 99L))
            .getErrorCode());

    Statement.StatementFactory pgFactory = new Statement.StatementFactory(Dialect.POSTGRESQL);
    String pgSql =
        "-- ? line comment\r"
            + "/* outer /* inner ? */ ? */ "
            + "SELECT '?', \"?\", $$?$$, $tag$?$tag$, E'it\\'s ?' FROM users WHERE id = ?";
    Statement pgStmt = pgFactory.withUnnamedParameters(pgSql, 42L);
    assertThat(pgStmt.getSql()).endsWith("WHERE id = $1");
    assertThat(pgStmt.getParameters()).containsExactly("p1", Value.toValue(42L));
    assertEquals(
        ErrorCode.INVALID_ARGUMENT,
        assertThrows(SpannerException.class, () -> pgFactory.withUnnamedParameters(pgSql))
            .getErrorCode());
    assertEquals(
        ErrorCode.INVALID_ARGUMENT,
        assertThrows(SpannerException.class, () -> pgFactory.withUnnamedParameters(pgSql, 42L, 99L))
            .getErrorCode());
  }
}
