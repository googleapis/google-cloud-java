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

import static com.google.cloud.spanner.connection.SimpleParser.Result.NOT_FOUND;
import static com.google.cloud.spanner.connection.SimpleParser.Result.found;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.spanner.Dialect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SimpleParserTest {

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Parameter public Dialect dialect;

  SimpleParser parserFor(String sql) {
    return new SimpleParser(dialect, sql);
  }

  @Test
  public void testResultHashCode() {
    assertEquals(0, NOT_FOUND.hashCode());
    assertEquals(found("foo").hashCode(), found("foo").hashCode());
    assertNotEquals(found("foo").hashCode(), found("bar").hashCode());
    assertNotEquals(NOT_FOUND.hashCode(), found("bar").hashCode());
  }

  @Test
  public void testResultEquals() {
    assertEquals(found("foo"), found("foo"));
    assertNotEquals(found("foo"), found("bar"));
    assertNotEquals(NOT_FOUND, found("bar"));
    assertNotEquals(found("foo"), new Object());
    assertNotEquals(NOT_FOUND, new Object());
  }

  @Test
  public void testResultToString() {
    assertEquals("foo", found("foo").toString());
    assertEquals("NOT FOUND", NOT_FOUND.toString());
  }

  @Test
  public void testResultGetValue() {
    assertEquals("foo", found("foo").getValue());
    assertNull(NOT_FOUND.getValue());
  }

  @Test
  public void testEatToken() {
    assertTrue(parserFor("(foo").eatToken('('));
    assertTrue(parserFor("(").eatToken('('));
    assertTrue(parserFor("( ").eatToken('('));
    assertTrue(parserFor("\t(   foo").eatToken('('));

    assertFalse(parserFor("foo(").eatToken('('));
    assertFalse(parserFor("").eatToken('('));
  }

  @Test
  public void testEatTokenAdvancesPosition() {
    SimpleParser parser = parserFor("@{test=value}");
    assertEquals(0, parser.getPos());
    assertTrue(parser.eatToken('@'));
    assertEquals(1, parser.getPos());

    assertFalse(parser.eatToken('('));
    assertEquals(1, parser.getPos());

    assertTrue(parser.eatToken('{'));
    assertEquals(2, parser.getPos());
  }

  @Test
  public void testEatTokensAdvancesPosition() {
    SimpleParser parser = parserFor("@{test=value}");
    assertEquals(0, parser.getPos());
    assertTrue(parser.eatTokens('@', '{'));
    assertEquals(2, parser.getPos());

    assertFalse(parser.eatTokens('@', '{'));
    assertEquals(2, parser.getPos());

    parser = parserFor("@ /* comment */ { test=value}");
    assertEquals(0, parser.getPos());
    assertTrue(parser.eatTokens('@', '{'));
    assertEquals("@ /* comment */ {".length(), parser.getPos());
  }

  @Test
  public void testPeekTokenKeepsPosition() {
    SimpleParser parser = parserFor("@{test=value}");
    assertEquals(0, parser.getPos());
    assertTrue(parser.peekToken('@'));
    assertEquals(0, parser.getPos());

    assertFalse(parser.peekToken('{'));
    assertEquals(0, parser.getPos());
  }

  @Test
  public void testPeekTokensKeepsPosition() {
    SimpleParser parser = parserFor("@{test=value}");
    assertEquals(0, parser.getPos());
    assertTrue(parser.peekTokens('@', '{'));
    assertEquals(0, parser.getPos());
  }

  @Test
  public void testEatIdentifier() {
    assertEquals(found("foo"), parserFor("foo").eatIdentifier());
    assertEquals(found("foo"), parserFor("foo(id)").eatIdentifier());
    assertEquals(found("foo"), parserFor("foo bar").eatIdentifier());

    assertEquals(found("foo"), parserFor(" foo bar").eatIdentifier());
    assertEquals(found("foo"), parserFor("\tfoo").eatIdentifier());
    assertEquals(found("bar"), parserFor("\n bar").eatIdentifier());
    assertEquals(found("foo"), parserFor("    foo").eatIdentifier());
    assertEquals(found("foo"), parserFor("foo\"bar\"").eatIdentifier());
    assertEquals(found("foo"), parserFor("foo.bar").eatIdentifier());

    assertEquals(found("foo"), parserFor("foo) bar").eatIdentifier());
    assertEquals(found("foo"), parserFor("foo- bar").eatIdentifier());
    assertEquals(found("foo"), parserFor("foo/ bar").eatIdentifier());
    assertEquals(found("foo$"), parserFor("foo$ bar").eatIdentifier());
    assertEquals(found("f$oo"), parserFor("f$oo bar").eatIdentifier());
    assertEquals(found("_foo"), parserFor("_foo bar").eatIdentifier());
    assertEquals(found("øfoo"), parserFor("øfoo bar").eatIdentifier());

    assertEquals(NOT_FOUND, parserFor("\"foo").eatIdentifier());
    assertEquals(NOT_FOUND, parserFor("\\foo").eatIdentifier());
    assertEquals(NOT_FOUND, parserFor("1foo").eatIdentifier());
    assertEquals(NOT_FOUND, parserFor("-foo").eatIdentifier());
    assertEquals(NOT_FOUND, parserFor("$foo").eatIdentifier());
    assertEquals(NOT_FOUND, parserFor("").eatIdentifier());
    assertEquals(NOT_FOUND, parserFor("   ").eatIdentifier());
    assertEquals(NOT_FOUND, parserFor("\n").eatIdentifier());
    assertEquals(NOT_FOUND, parserFor("/* comment */").eatIdentifier());
    assertEquals(NOT_FOUND, parserFor("-- comment").eatIdentifier());
    assertEquals(NOT_FOUND, parserFor("/* comment").eatIdentifier());

    String nestedCommentFollowedByIdentifier =
        "/* comment /* nested comment */ "
            + "still a comment if nested comments are supported, "
            + "and otherwise the start of an identifier. */ test";
    if (AbstractStatementParser.getInstance(dialect).supportsNestedComments()) {
      assertEquals(found("test"), parserFor(nestedCommentFollowedByIdentifier).eatIdentifier());
    } else {
      // The parser does not look ahead if the rest of the SQL string is malformed. It just reads
      // from the current position.
      assertEquals(found("still"), parserFor(nestedCommentFollowedByIdentifier).eatIdentifier());
    }

    if (AbstractStatementParser.getInstance(dialect).supportsHashSingleLineComments()) {
      assertEquals(found("test"), parserFor("# comment\ntest").eatIdentifier());
    } else {
      // '#' is not a valid start of an identifier.
      assertEquals(NOT_FOUND, parserFor("# not a comment\ntest").eatIdentifier());
    }
  }

  @Test
  public void testEatSingleQuotedString() {
    assertEquals(found("test"), parserFor("'test'").eatSingleQuotedString());
    assertEquals(found("test"), parserFor("  'test'   ").eatSingleQuotedString());
    assertEquals(found("test"), parserFor("\n'test'").eatSingleQuotedString());
    assertEquals(found("test"), parserFor("\t'test'").eatSingleQuotedString());
    assertEquals(found("test test"), parserFor("  'test test'   ").eatSingleQuotedString());
    assertEquals(found("test\t"), parserFor("'test\t'").eatSingleQuotedString());
    assertEquals(
        found("test"), parserFor("/* comment */'test'/*comment*/").eatSingleQuotedString());
    assertEquals(found("test"), parserFor("-- comment\n'test'--comment\n").eatSingleQuotedString());
    assertEquals(
        found("test /* not a comment */"),
        parserFor("'test /* not a comment */'").eatSingleQuotedString());

    assertEquals(NOT_FOUND, parserFor("test").eatSingleQuotedString());
    assertEquals(NOT_FOUND, parserFor("'test").eatSingleQuotedString());
    assertEquals(NOT_FOUND, parserFor("test'").eatSingleQuotedString());
    assertEquals(NOT_FOUND, parserFor("\"test\"").eatSingleQuotedString());
    assertEquals(NOT_FOUND, parserFor("'test\n'").eatSingleQuotedString());
    assertEquals(NOT_FOUND, parserFor("'\ntest'").eatSingleQuotedString());
    assertEquals(NOT_FOUND, parserFor("'te\nst'").eatSingleQuotedString());
  }

  @Test
  public void testEatSingleQuotedStringAdvancesPosition() {
    SimpleParser parser = parserFor("'test 1'  'test 2'  ");
    assertEquals(found("test 1"), parser.eatSingleQuotedString());
    assertEquals("'test 1'".length(), parser.getPos());
    assertEquals(found("test 2"), parser.eatSingleQuotedString());
    assertEquals("'test 1'  'test 2'".length(), parser.getPos());
    assertEquals(NOT_FOUND, parser.eatSingleQuotedString());
    assertEquals(parser.getSql().length(), parser.getPos());
  }

  @Test
  public void testSkipHint() {
    assumeTrue("Hints in PostgreSQL are comments", dialect == Dialect.GOOGLE_STANDARD_SQL);

    assertEquals("SELECT 1", skipHint("SELECT 1"));
    assertEquals("SELECT 1", skipHint("@{rpc_priority=HIGH}SELECT 1"));
    assertEquals("SELECT 1", skipHint("@{statement_tag='test'}SELECT 1"));
    assertEquals("  \nSELECT 1", skipHint("  @{statement_tag =  'test'}  \nSELECT 1"));
    assertEquals(
        " /* comment after */ SELECT 1",
        skipHint("/* comment before */ @{statement_tag='test'} /* comment after */ SELECT 1"));
    assertEquals(
        " -- comment after\nSELECT 1",
        skipHint("-- comment before\n @{statement_tag='test'} -- comment after\nSELECT 1"));
    assertEquals(
        "-- comment @{statement_tag='test'}\n -- also a comment\nSELECT 1",
        skipHint("-- comment @{statement_tag='test'}\n -- also a comment\nSELECT 1"));
  }

  static String skipHint(String sql) {
    SimpleParser parser = new SimpleParser(Dialect.GOOGLE_STANDARD_SQL, sql);
    parser.skipHint();
    return parser.getSql().substring(parser.getPos());
  }
}
