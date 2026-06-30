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

import static com.google.cloud.spanner.ErrorCode.INVALID_ARGUMENT;
import static com.google.cloud.spanner.connection.StatementParserTest.assertUnclosedLiteral;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.StatementParserTest.CommentInjector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SpannerStatementParserTest {

  static String skip(String sql) {
    return skip(sql, 0);
  }

  static String skip(String sql, int currentIndex) {
    int position =
        AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
            .skip(sql, currentIndex, null);
    return sql.substring(currentIndex, position);
  }

  @Test
  public void testRemoveCommentsAndTrim() {
    AbstractStatementParser parser =
        AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL);

    // Statements that should parse correctly
    String[] validStatements =
        new String[] {
          "SELECT '\\\\'", // SELECT '\\' (escaped backslash, followed by quote)
          "SELECT '\\''", // SELECT '\'' (escaped quote, followed by an actual closing quote)
          "SELECT '\\\\\\\\'" // SELECT '\\\\' (two escaped backslashes)
        };
    for (String sql : validStatements) {
      assertEquals(sql, parser.removeCommentsAndTrim(sql));
    }

    // Statements that contain an unclosed literal because the final quote is
    // escaped
    String[] invalidStatements =
        new String[] {
          "SELECT '\\'" // SELECT '\' (escaped closing quote)
        };

    for (String sql : invalidStatements) {
      try {
        parser.removeCommentsAndTrim(sql);
        fail("Expected SpannerException for unclosed literal: " + sql);
      } catch (SpannerException e) {
        assertEquals(INVALID_ARGUMENT, e.getErrorCode());
      }
    }
  }

  @Test
  public void testReturningClauseWithBackslashes() {
    AbstractStatementParser parser =
        AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL);

    // Valid returning clause, double backslash in string literal should be handled
    // correctly.
    String sqlWithReturning = "INSERT INTO my_table (value) VALUES ('foo \\\\ bar') THEN RETURN id";
    assertTrue(parser.parse(Statement.of(sqlWithReturning)).hasReturningClause());

    // No returning clause, `then return` is inside a string literal with a double
    // backslash.
    String sqlWithoutReturning = "INSERT INTO my_table (value) VALUES ('then \\\\ return')";
    assertFalse(parser.parse(Statement.of(sqlWithoutReturning)).hasReturningClause());
  }

  @Test
  public void testSkip() {
    assertEquals("", skip(""));
    assertEquals("1", skip("1 "));
    assertEquals("1", skip("12 "));
    assertEquals("2", skip("12 ", 1));
    assertEquals("", skip("12", 2));

    assertEquals("'foo'", skip("'foo'  ", 0));
    assertEquals("'foo'", skip("'foo''bar'  ", 0));
    assertEquals("'foo'", skip("'foo'  'bar'  ", 0));
    assertEquals("'bar'", skip("'foo''bar'  ", 5));
    assertEquals("'foo\"bar\"'", skip("'foo\"bar\"'  ", 0));
    assertEquals("\"foo'bar'\"", skip("\"foo'bar'\"  ", 0));
    assertEquals("`foo'bar'`", skip("`foo'bar'`  ", 0));
    assertEquals("'test\\\\'", skip("'test\\\\'", 0));

    assertEquals("'''foo'bar'''", skip("'''foo'bar'''  ", 0));
    assertEquals("'''foo\\'bar'''", skip("'''foo\\'bar'''  ", 0));
    assertEquals("'''foo\\'\\'bar'''", skip("'''foo\\'\\'bar'''  ", 0));
    assertEquals("'''foo\\'\\'\\'bar'''", skip("'''foo\\'\\'\\'bar'''  ", 0));
    assertEquals("\"\"\"foo'bar\"\"\"", skip("\"\"\"foo'bar\"\"\"", 0));
    assertEquals("```foo'bar```", skip("```foo'bar```", 0));

    assertEquals("-- comment\n", skip("-- comment\nselect * from foo", 0));
    assertEquals("# comment\n", skip("# comment\nselect * from foo", 0));
    assertEquals("/* comment */", skip("/* comment */ select * from foo", 0));
    assertEquals(
        "/* comment /* GoogleSQL does not support nested comments */",
        skip("/* comment /* GoogleSQL does not support nested comments */ select * from foo", 0));
    // GoogleSQL does not support dollar-quoted strings.
    assertEquals("$", skip("$tag$not a string$tag$ select * from foo", 0));

    assertEquals("/* 'test' */", skip("/* 'test' */ foo"));
    assertEquals("-- 'test' \n", skip("-- 'test' \n foo"));
    assertEquals("'/* test */'", skip("'/* test */' foo"));

    // Raw strings do not consider '\' as something that starts an escape sequence, but any
    // quote character following it is still preserved within the string, as the definition of a
    // raw string says that 'both characters are preserved'.
    assertEquals("'foo\\''", skip("'foo\\''  ", 0));
    assertEquals("'foo\\''", skip("r'foo\\''  ", 1));
    assertEquals("'''foo\\'\\'\\'bar'''", skip("'''foo\\'\\'\\'bar'''  ", 0));
  }

  @Test
  public void testConvertPositionalParametersToNamedParameters() {
    AbstractStatementParser parser =
        AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL);

    for (String comment :
        new String[] {
          "-- test comment\n",
          "/* another test comment */",
          "/* comment\nwith\nmultiple\nlines\n */",
          "/* comment /* with nested */ comment */"
        }) {
      for (CommentInjector injector : CommentInjector.values()) {
        assertEquals(
            injector.inject("select * %sfrom foo where name=@p1", comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?', injector.inject("select * %sfrom foo where name=?", comment))
                .sqlWithNamedParameters);
        assertEquals(
            injector.inject("@p1%s'?test?\"?test?\"?'@p2", comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?', injector.inject("?%s'?test?\"?test?\"?'?", comment))
                .sqlWithNamedParameters);
        assertEquals(
            injector.inject("@p1'?it\\'?s'%s@p2", comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?', injector.inject("?'?it\\'?s'%s?", comment))
                .sqlWithNamedParameters);
        assertEquals(
            injector.inject("@p1'?it\\\"?s'%s@p2", comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?', injector.inject("?'?it\\\"?s'%s?", comment))
                .sqlWithNamedParameters);
        assertEquals(
            injector.inject("@p1\"?it\\\"?s\"%s@p2", comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?', injector.inject("?\"?it\\\"?s\"%s?", comment))
                .sqlWithNamedParameters);
        assertEquals(
            injector.inject("@p1%s'''?it\\''?s'''@p2", comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?', injector.inject("?%s'''?it\\''?s'''?", comment))
                .sqlWithNamedParameters);
        assertEquals(
            injector.inject("@p1\"\"\"?it\\\"\"?s\"\"\"%s@p2", comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?', injector.inject("?\"\"\"?it\\\"\"?s\"\"\"%s?", comment))
                .sqlWithNamedParameters);

        // GoogleSQL does not support dollar-quoted strings, so these are all ignored.
        assertEquals(
            injector.inject("@p1$$@p2it$@p3s$$%s@p4", comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?', injector.inject("?$$?it$?s$$%s?", comment))
                .sqlWithNamedParameters);
        assertEquals(
            injector.inject("@p1$tag$@p2it$$@p3s$tag$%s@p4", comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?', injector.inject("?$tag$?it$$?s$tag$%s?", comment))
                .sqlWithNamedParameters);
        assertEquals(
            injector.inject("@p1%s$$@p2it\\'?s \t ?it\\'?s'$$@p3", comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?', injector.inject("?%s$$?it\\'?s \t ?it\\'?s'$$?", comment))
                .sqlWithNamedParameters);

        // Note: GoogleSQL does not allowa a single-quoted string literal to contain line feeds.
        assertUnclosedLiteral(parser, injector.inject("?'?it\\''?s \n ?it\\''?s'%s?", comment));
        assertEquals(
            "@p1'?it\\''@p2s \n @p3it\\''@p4s@p5",
            parser.convertPositionalParametersToNamedParameters('?', "?'?it\\''?s \n ?it\\''?s?")
                .sqlWithNamedParameters);
        assertEquals(
            injector.inject("@p1%s'''?it\\''?s \n ?it\\''?s'''@p2", comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?', injector.inject("?%s'''?it\\''?s \n ?it\\''?s'''?", comment))
                .sqlWithNamedParameters);

        assertEquals(
            injector.inject(
                "select 1, @p1, 'test?test', \"test?test\", %sfoo.* from `foo` where col1=@p2 and"
                    + " col2='test' and col3=@p3 and col4='?' and col5=\"?\" and col6='?''?''?'",
                comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?',
                    injector.inject(
                        "select 1, ?, 'test?test', \"test?test\", %sfoo.* from `foo` where col1=?"
                            + " and col2='test' and col3=? and col4='?' and col5=\"?\" and"
                            + " col6='?''?''?'",
                        comment))
                .sqlWithNamedParameters);

        assertEquals(
            injector.inject(
                "select * "
                    + "%sfrom foo "
                    + "where name=@p1 "
                    + "and col2 like @p2 "
                    + "and col3 > @p3",
                comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?',
                    injector.inject(
                        "select * "
                            + "%sfrom foo "
                            + "where name=? "
                            + "and col2 like ? "
                            + "and col3 > ?",
                        comment))
                .sqlWithNamedParameters);
        assertEquals(
            injector.inject("select * " + "from foo " + "where id between @p1%s and @p2", comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?',
                    injector.inject(
                        "select * " + "from foo " + "where id between ?%s and ?", comment))
                .sqlWithNamedParameters);
        assertEquals(
            injector.inject("select * " + "from foo " + "limit @p1 %s offset @p2", comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?',
                    injector.inject("select * " + "from foo " + "limit ? %s offset ?", comment))
                .sqlWithNamedParameters);
        assertEquals(
            injector.inject(
                "select * "
                    + "from foo "
                    + "where col1=@p1 "
                    + "and col2 like @p2 "
                    + " %s "
                    + "and col3 > @p3 "
                    + "and col4 < @p4 "
                    + "and col5 != @p5 "
                    + "and col6 not in (@p6, @p7, @p8) "
                    + "and col7 in (@p9, @p10, @p11) "
                    + "and col8 between @p12 and @p13",
                comment),
            parser.convertPositionalParametersToNamedParameters(
                    '?',
                    injector.inject(
                        "select * "
                            + "from foo "
                            + "where col1=? "
                            + "and col2 like ? "
                            + " %s "
                            + "and col3 > ? "
                            + "and col4 < ? "
                            + "and col5 != ? "
                            + "and col6 not in (?, ?, ?) "
                            + "and col7 in (?, ?, ?) "
                            + "and col8 between ? and ?",
                        comment))
                .sqlWithNamedParameters);
      }
    }
  }
}
