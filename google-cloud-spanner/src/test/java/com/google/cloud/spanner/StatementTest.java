/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableMap;
import com.google.common.testing.EqualsTester;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.Statement}. */
@RunWith(JUnit4.class)
public class StatementTest {
  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void basic() {
    String sql = "SELECT 1";
    Statement stmt = Statement.of(sql);
    assertThat(stmt.getSql()).isEqualTo(sql);
    assertThat(stmt.getParameters()).isEmpty();
    assertThat(stmt.toString()).isEqualTo(sql);
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
        .isEqualTo(ImmutableMap.of("id", Value.int64(1234), "status", Value.string("ACTIVE")));
    assertThat(stmt.toString()).isEqualTo(expectedSql + " {id: 1234, status: ACTIVE}");
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
    expectedException.expect(IllegalStateException.class);
    builder.build();
  }

  @Test
  public void bindingInProgress() {
    Statement.Builder builder = Statement.newBuilder("SELECT @v");
    builder.bind("v");

    expectedException.expect(IllegalStateException.class);
    builder.bind("y");
  }

  @Test
  public void alreadyBound() {
    ValueBinder<Statement.Builder> binder = Statement.newBuilder("SELECT @v").bind("v");
    binder.to("abc");

    expectedException.expect(IllegalStateException.class);
    binder.to("xyz");
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
    tester.testEquals();
  }
}
