/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.spanner.connection.StatementHintParser.NO_HINTS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Dialect;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StatementHintParserTest {

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Parameter public Dialect dialect;

  StatementHintParser parserFor(String sql) {
    return new StatementHintParser(dialect, sql);
  }

  String getStartHint() {
    return dialect == Dialect.POSTGRESQL ? "/*@" : "@{";
  }

  String getEndHint() {
    return dialect == Dialect.POSTGRESQL ? "*/" : "}";
  }

  String encloseInHint(String sql) {
    return getStartHint() + sql + getEndHint();
  }

  @Test
  public void testNoHints() {
    assertFalse(parserFor("select foo from bar").hasStatementHints());
    assertFalse(parserFor("/* comment */ select foo from bar").hasStatementHints());
    assertFalse(parserFor("select foo from bar").hasStatementHints());
    assertFalse(parserFor("select foo from bar").hasStatementHints());
  }

  @Test
  public void testExtractHints() {
    StatementHintParser parser;

    parser = parserFor(encloseInHint("statement_tag=tag1") + " select 1");
    assertTrue(parser.hasStatementHints());
    assertEquals(ImmutableMap.of("statement_tag", "tag1"), parser.getClientSideStatementHints());
    assertEquals(" select 1", parser.getSqlWithoutClientSideHints());

    parser = parserFor(encloseInHint("statement_tag=tag1, other_hint=value") + " select 1");
    assertTrue(parser.hasStatementHints());
    assertEquals(ImmutableMap.of("statement_tag", "tag1"), parser.getClientSideStatementHints());
    assertEquals(
        encloseInHint(" other_hint=value") + " select 1", parser.getSqlWithoutClientSideHints());

    parser = parserFor(encloseInHint("other_hint=value") + " select 1");
    assertTrue(parser.hasStatementHints());
    assertEquals(NO_HINTS, parser.getClientSideStatementHints());
    assertEquals(
        encloseInHint("other_hint=value") + " select 1", parser.getSqlWithoutClientSideHints());

    parser = parserFor(encloseInHint("statement_tag=tag1, rpc_priority=high") + " select 1");
    assertTrue(parser.hasStatementHints());
    assertEquals(
        ImmutableMap.of("statement_tag", "tag1", "rpc_priority", "high"),
        parser.getClientSideStatementHints());
    assertEquals(" select 1", parser.getSqlWithoutClientSideHints());

    parser = parserFor(encloseInHint("rpc_priority=medium, statement_tag='value 2'") + " select 1");
    assertTrue(parser.hasStatementHints());
    assertEquals(
        ImmutableMap.of("rpc_priority", "medium", "statement_tag", "value 2"),
        parser.getClientSideStatementHints());
    assertEquals(" select 1", parser.getSqlWithoutClientSideHints());

    parser =
        parserFor(
            "/* comment */ "
                + encloseInHint(
                    "/*comment*/statement_tag--comment\n"
                        + "=--comment\nvalue1\n,rpc_priority=Low/*comment*/")
                + " /* yet another comment */ select 1");
    assertTrue(parser.hasStatementHints());
    assertEquals(
        ImmutableMap.of("statement_tag", "value1", "rpc_priority", "Low"),
        parser.getClientSideStatementHints());
    assertEquals(" /* yet another comment */ select 1", parser.getSqlWithoutClientSideHints());

    parser =
        parserFor(
            "/* comment */ "
                + encloseInHint(
                    "/*comment*/statement_tag--comment\n"
                        + "=--comment\nvalue1\n,"
                        + "/* other hint comment */ other_hint='some value',\n"
                        + "rpc_priority=Low/*comment*/")
                + " /* yet another comment */ select 1");
    assertTrue(parser.hasStatementHints());
    assertEquals(
        ImmutableMap.of("statement_tag", "value1", "rpc_priority", "Low"),
        parser.getClientSideStatementHints());
    assertEquals(
        "/* comment */ "
            + encloseInHint(
                "/*comment*//* other hint comment */ other_hint='some value',\n" + "/*comment*/")
            + " /* yet another comment */ select 1",
        parser.getSqlWithoutClientSideHints());

    parser =
        parserFor(
            encloseInHint(
                    "statement_tag=tag1,\n"
                        + "other_hint1='some value',\n"
                        + "rpc_priority=low,\n"
                        + "other_hint2=value")
                + "\nselect 1");
    assertTrue(parser.hasStatementHints());
    assertEquals(
        ImmutableMap.of("statement_tag", "tag1", "rpc_priority", "low"),
        parser.getClientSideStatementHints());
    assertEquals(
        encloseInHint("\nother_hint1='some value',\n" + "\n" + "other_hint2=value") + "\nselect 1",
        parser.getSqlWithoutClientSideHints());

    parser =
        parserFor(
            encloseInHint(
                    "hint1=value1,\n"
                        + "other_hint1='some value',\n"
                        + "rpc_priority=low,\n"
                        + "other_hint2=value")
                + "\nselect 1");
    assertTrue(parser.hasStatementHints());
    assertEquals(ImmutableMap.of("rpc_priority", "low"), parser.getClientSideStatementHints());
    assertEquals(
        encloseInHint(
                "hint1=value1,\n" + "other_hint1='some value',\n" + "\n" + "other_hint2=value")
            + "\nselect 1",
        parser.getSqlWithoutClientSideHints());

    parser =
        parserFor(
            encloseInHint(
                    "hint1=value1,\n"
                        + "hint2=value2,\n"
                        + "rpc_priority=low,\n"
                        + "statement_tag=tag")
                + "\nselect 1");
    assertTrue(parser.hasStatementHints());
    assertEquals(
        ImmutableMap.of("rpc_priority", "low", "statement_tag", "tag"),
        parser.getClientSideStatementHints());
    assertEquals(
        encloseInHint("hint1=value1,\nhint2=value2,\n\n") + "\nselect 1",
        parser.getSqlWithoutClientSideHints());
  }

  @Test
  public void testExtractInvalidHints() {
    assertInvalidHints("@{statement_tag=value value}");
    assertInvalidHints("@statement_tag=value");
    assertInvalidHints("{statement_tag=value}");
    assertInvalidHints("@{statement_tag=value");
    assertInvalidHints("@{statement_tag=value,");
    assertInvalidHints("@{statement_tag=value,}");
    assertInvalidHints("@statement_tag=value}");
    assertInvalidHints("@{statement_tag=}");
    assertInvalidHints("@{=value}");
    assertInvalidHints("@{}");
    assertInvalidHints("@{statement_tag=value,}");
    assertInvalidHints("@{statement_tag=value1,hint2=value2,}");
    assertInvalidHints("@{@statement_tag=value1}");
    assertInvalidHints("@{statement_tag=@value1}");
    assertInvalidHints("@{statement_tag value1}");
    assertInvalidHints("@{statement_tag='value1}");
    assertInvalidHints("@{statement_tag=value1'}");
  }

  private void assertInvalidHints(String sql) {
    StatementHintParser parser = parserFor(sql);
    assertEquals(NO_HINTS, parser.getClientSideStatementHints());
    assertSame(sql, parser.getSqlWithoutClientSideHints());
  }
}
