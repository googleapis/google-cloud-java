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

package com.google.cloud.spanner.jdbc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.jdbc.ClientSideStatementImpl.CompileException;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class StatementParserTest {
  public static final String COPYRIGHT_PATTERN =
      "\\/\\*\n"
          + " \\* Copyright \\d{4} Google LLC\n"
          + " \\*\n"
          + " \\* Licensed under the Apache License, Version 2.0 \\(the \"License\"\\);\n"
          + " \\* you may not use this file except in compliance with the License.\n"
          + " \\* You may obtain a copy of the License at\n"
          + " \\*\n"
          + " \\*       http://www.apache.org/licenses/LICENSE-2.0\n"
          + " \\*\n"
          + " \\* Unless required by applicable law or agreed to in writing, software\n"
          + " \\* distributed under the License is distributed on an \"AS IS\" BASIS,\n"
          + " \\* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
          + " \\* See the License for the specific language governing permissions and\n"
          + " \\* limitations under the License.\n"
          + " \\*\\/\n";
  private final StatementParser parser = StatementParser.INSTANCE;
  private static final Pattern EXPECT_PATTERN = Pattern.compile("(?is)\\s*(?:@EXPECT)\\s+'(.*)'");

  @Test
  public void testRemoveComments() {
    List<String> statements = readStatementsFromFile("CommentsTest.sql");
    String currentlyExpected = "";
    for (String statement : statements) {
      String sql = statement.trim();
      if (sql.startsWith("@EXPECT")) {
        Matcher matcher = EXPECT_PATTERN.matcher(sql);
        if (matcher.matches()) {
          currentlyExpected = matcher.group(1);
        } else {
          throw new IllegalArgumentException("Unknown @EXPECT statement: " + sql);
        }
      } else {
        assertThat(
            StatementParser.removeCommentsAndTrim(statement), is(equalTo(currentlyExpected)));
      }
    }

    assertThat(StatementParser.removeCommentsAndTrim(""), is(equalTo("")));
    assertThat(
        StatementParser.removeCommentsAndTrim("SELECT * FROM FOO"),
        is(equalTo("SELECT * FROM FOO")));
    assertThat(
        StatementParser.removeCommentsAndTrim("-- This is a one line comment\nSELECT * FROM FOO"),
        is(equalTo("SELECT * FROM FOO")));
    assertThat(
        StatementParser.removeCommentsAndTrim(
            "/* This is a simple multi line comment */\nSELECT * FROM FOO"),
        is(equalTo("SELECT * FROM FOO")));
    assertThat(
        StatementParser.removeCommentsAndTrim(
            "/* This is a \nmulti line comment */\nSELECT * FROM FOO"),
        is(equalTo("SELECT * FROM FOO")));
    assertThat(
        StatementParser.removeCommentsAndTrim(
            "/* This\nis\na\nmulti\nline\ncomment */\nSELECT * FROM FOO"),
        is(equalTo("SELECT * FROM FOO")));
  }

  @Test
  public void testStatementWithCommentContainingSlash() {
    String sql =
        "/*\n"
            + " * Script for testing invalid/unrecognized statements\n"
            + " */\n"
            + "\n"
            + "-- MERGE into test comment MERGE -- \n"
            + "@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown statement'\n"
            + "MERGE INTO Singers s\n"
            + "/*** test ****/"
            + "USING (VALUES (1, 'John', 'Doe')) v\n"
            + "ON v.column1 = s.SingerId\n"
            + "WHEN NOT MATCHED \n"
            + "  INSERT VALUES (v.column1, v.column2, v.column3)\n"
            + "WHEN MATCHED\n"
            + "  UPDATE SET FirstName = v.column2,\n"
            + "             LastName = v.column3;";
    String sqlWithoutComments =
        "@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown statement'\n"
            + "MERGE INTO Singers s\n"
            + "USING (VALUES (1, 'John', 'Doe')) v\n"
            + "ON v.column1 = s.SingerId\n"
            + "WHEN NOT MATCHED \n"
            + "  INSERT VALUES (v.column1, v.column2, v.column3)\n"
            + "WHEN MATCHED\n"
            + "  UPDATE SET FirstName = v.column2,\n"
            + "             LastName = v.column3";
    ParsedStatement statement = parser.parse(Statement.of(sql));
    assertThat(statement.getSqlWithoutComments(), is(equalTo(sqlWithoutComments)));
  }

  @Test
  public void testStatementWithCommentContainingSlashAndNoAsteriskOnNewLine() {
    String sql =
        "/*\n"
            + " * Script for testing invalid/unrecognized statements\n"
            + " foo bar baz"
            + " */\n"
            + "\n"
            + "-- MERGE INTO test comment MERGE\n"
            + "@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown statement'\n"
            + "MERGE INTO Singers s\n"
            + "USING (VALUES (1, 'John', 'Doe')) v\n"
            + "ON v.column1 = s.SingerId\n"
            + "-- test again --\n"
            + "WHEN NOT MATCHED \n"
            + "  INSERT VALUES (v.column1, v.column2, v.column3)\n"
            + "WHEN MATCHED\n"
            + "  UPDATE SET FirstName = v.column2,\n"
            + "             LastName = v.column3;";
    String sqlWithoutComments =
        "@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown statement'\n"
            + "MERGE INTO Singers s\n"
            + "USING (VALUES (1, 'John', 'Doe')) v\n"
            + "ON v.column1 = s.SingerId\n"
            + "\nWHEN NOT MATCHED \n"
            + "  INSERT VALUES (v.column1, v.column2, v.column3)\n"
            + "WHEN MATCHED\n"
            + "  UPDATE SET FirstName = v.column2,\n"
            + "             LastName = v.column3";
    ParsedStatement statement = parser.parse(Statement.of(sql));
    assertThat(statement.getSqlWithoutComments(), is(equalTo(sqlWithoutComments)));
  }

  @Test
  public void testStatementWithHashTagSingleLineComment() {
    assertThat(
        parser
            .parse(Statement.of("# this is a comment\nselect * from foo"))
            .getSqlWithoutComments(),
        is(equalTo("select * from foo")));
    assertThat(
        parser.parse(Statement.of("select * from foo\n#this is a comment")).getSqlWithoutComments(),
        is(equalTo("select * from foo")));
    assertThat(
        parser
            .parse(Statement.of("select *\nfrom foo # this is a comment\nwhere bar=1"))
            .getSqlWithoutComments(),
        is(equalTo("select *\nfrom foo \nwhere bar=1")));
  }

  @Test
  public void testIsDdlStatement() {
    assertFalse(parser.isDdlStatement(""));
    assertFalse(parser.isDdlStatement("random text"));
    assertFalse(parser.isDdlStatement("CREATETABLE"));
    assertFalse(parser.isDdlStatement("CCREATE TABLE"));
    assertFalse(parser.isDdlStatement("SELECT 1"));
    assertFalse(parser.isDdlStatement("SELECT FOO FROM BAR"));
    assertFalse(parser.isDdlStatement("INSERT INTO FOO (ID, NAME) VALUES (1, 'NAME')"));
    assertFalse(parser.isDdlStatement("UPDATE FOO SET NAME='NAME' WHERE ID=1"));
    assertFalse(parser.isDdlStatement("DELETE FROM FOO"));

    assertTrue(
        parser.isDdlStatement("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"));
    assertTrue(parser.isDdlStatement("alter table foo add Description string(100)"));
    assertTrue(parser.isDdlStatement("drop table foo"));
    assertTrue(parser.isDdlStatement("Create index BAR on foo (name)"));

    assertTrue(
        parser
            .parse(
                Statement.of(
                    "\t\tCREATE\n\t   TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "\n\n\nCREATE TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "-- this is a comment\nCREATE TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/* multi line comment\n* with more information on the next line\n*/\nCREATE TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/** java doc comment\n* with more information on the next line\n*/\nCREATE TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "-- SELECT in a single line comment \nCREATE TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/* SELECT in a multi line comment\n* with more information on the next line\n*/\nCREATE TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/** SELECT in a java doc comment\n* with more information on the next line\n*/\nCREATE TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl());
  }

  @Test
  public void testIsQuery() {
    assertFalse(parser.isQuery(""));
    assertFalse(parser.isQuery("random text"));
    assertFalse(parser.isQuery("SELECT1"));
    assertFalse(parser.isQuery("SSELECT 1"));
    assertTrue(parser.isQuery("SELECT 1"));
    assertTrue(parser.isQuery("select 1"));
    assertTrue(parser.isQuery("SELECT foo FROM bar WHERE id=@id"));
    assertFalse(parser.isQuery("INSERT INTO FOO (ID, NAME) VALUES (1, 'NAME')"));
    assertFalse(parser.isQuery("UPDATE FOO SET NAME='NAME' WHERE ID=1"));
    assertFalse(parser.isQuery("DELETE FROM FOO"));
    assertFalse(parser.isQuery("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"));
    assertFalse(parser.isQuery("alter table foo add Description string(100)"));
    assertFalse(parser.isQuery("drop table foo"));
    assertFalse(parser.isQuery("Create index BAR on foo (name)"));
    assertTrue(parser.isQuery("select * from foo"));
    assertFalse(parser.isQuery("INSERT INTO FOO (ID, NAME) SELECT ID+1, NAME FROM FOO"));

    assertTrue(parser.parse(Statement.of("-- this is a comment\nselect * from foo")).isQuery());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/* multi line comment\n* with more information on the next line\n*/\nSELECT ID, NAME\nFROM\tTEST\n\tWHERE ID=1"))
            .isQuery());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/** java doc comment\n* with more information on the next line\n*/\nselect max(id) from test"))
            .isQuery());
    assertTrue(
        parser.parse(Statement.of("-- INSERT in a single line comment \n    select 1")).isQuery());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/* UPDATE in a multi line comment\n* with more information on the next line\n*/\nSELECT 1"))
            .isQuery());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/** DELETE in a java doc comment\n* with more information on the next line\n*/\n\n\n\n -- UPDATE test\nSELECT 1"))
            .isQuery());
  }

  @Test
  public void testQueryHints() {
    // Valid query hints.
    assertTrue(parser.isQuery("@{JOIN_METHOD=HASH_JOIN} SELECT * FROM PersonsTable"));
    assertTrue(parser.isQuery("@ {JOIN_METHOD=HASH_JOIN} SELECT * FROM PersonsTable"));
    assertTrue(parser.isQuery("@{ JOIN_METHOD=HASH_JOIN} SELECT * FROM PersonsTable"));
    assertTrue(parser.isQuery("@{JOIN_METHOD=HASH_JOIN } SELECT * FROM PersonsTable"));
    assertTrue(parser.isQuery("@{JOIN_METHOD=HASH_JOIN}\nSELECT * FROM PersonsTable"));
    assertTrue(parser.isQuery("@{\nJOIN_METHOD =  HASH_JOIN   \t}\n\t SELECT * FROM PersonsTable"));
    assertTrue(
        parser.isQuery(
            "@{JOIN_METHOD=HASH_JOIN}\n -- Single line comment\nSELECT * FROM PersonsTable"));
    assertTrue(
        parser.isQuery(
            "@{JOIN_METHOD=HASH_JOIN}\n /* Multi line comment\n with more comments\n */SELECT * FROM PersonsTable"));

    // Invalid query hints.
    assertFalse(parser.isQuery("@{JOIN_METHOD=HASH_JOIN SELECT * FROM PersonsTable"));
    assertFalse(parser.isQuery("@JOIN_METHOD=HASH_JOIN} SELECT * FROM PersonsTable"));
    assertFalse(parser.isQuery("@JOIN_METHOD=HASH_JOIN SELECT * FROM PersonsTable"));
  }

  @Test
  public void testIsUpdate_InsertStatements() {
    assertFalse(parser.isUpdateStatement(""));
    assertFalse(parser.isUpdateStatement("random text"));
    assertFalse(parser.isUpdateStatement("INSERTINTO FOO (ID) VALUES (1)"));
    assertFalse(parser.isUpdateStatement("IINSERT INTO FOO (ID) VALUES (1)"));
    assertTrue(parser.isUpdateStatement("INSERT INTO FOO (ID) VALUES (1)"));
    assertTrue(parser.isUpdateStatement("insert into foo (id) values (1)"));
    assertTrue(parser.isUpdateStatement("INSERT into Foo (id)\nSELECT id FROM bar WHERE id=@id"));
    assertFalse(parser.isUpdateStatement("SELECT 1"));
    assertFalse(parser.isUpdateStatement("SELECT NAME FROM FOO WHERE ID=1"));
    assertFalse(
        parser.isUpdateStatement("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"));
    assertFalse(parser.isUpdateStatement("alter table foo add Description string(100)"));
    assertFalse(parser.isUpdateStatement("drop table foo"));
    assertFalse(parser.isUpdateStatement("Create index BAR on foo (name)"));
    assertFalse(parser.isUpdateStatement("select * from foo"));
    assertTrue(parser.isUpdateStatement("INSERT INTO FOO (ID, NAME) SELECT ID+1, NAME FROM FOO"));
    assertTrue(
        parser
            .parse(Statement.of("-- this is a comment\ninsert into foo (id) values (1)"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/* multi line comment\n* with more information on the next line\n*/\nINSERT INTO FOO\n(ID)\tVALUES\n\t(1)"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/** java doc comment\n* with more information on the next line\n*/\nInsert intO foo (id) select 1"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "-- SELECT in a single line comment \n    insert into foo (id) values (1)"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/* CREATE in a multi line comment\n* with more information on the next line\n*/\nINSERT INTO FOO (ID) VALUES (1)"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/** DROP in a java doc comment\n* with more information on the next line\n*/\n\n\n\n -- SELECT test\ninsert into foo (id) values (1)"))
            .isUpdate());
  }

  @Test
  public void testIsUpdate_UpdateStatements() {
    assertFalse(parser.isUpdateStatement(""));
    assertFalse(parser.isUpdateStatement("random text"));
    assertFalse(parser.isUpdateStatement("UPDATEFOO SET NAME='foo' WHERE ID=1"));
    assertFalse(parser.isUpdateStatement("UUPDATE FOO SET NAME='foo' WHERE ID=1"));
    assertTrue(parser.isUpdateStatement("UPDATE FOO SET NAME='foo' WHERE ID=1"));
    assertTrue(parser.isUpdateStatement("update foo set name='foo' where id=1"));
    assertTrue(
        parser.isUpdateStatement("update foo set name=\n(SELECT name FROM bar WHERE id=@id)"));
    assertFalse(parser.isUpdateStatement("SELECT 1"));
    assertFalse(parser.isUpdateStatement("SELECT NAME FROM FOO WHERE ID=1"));
    assertFalse(
        parser.isUpdateStatement("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"));
    assertFalse(parser.isUpdateStatement("alter table foo add Description string(100)"));
    assertFalse(parser.isUpdateStatement("drop table foo"));
    assertFalse(parser.isUpdateStatement("Create index BAR on foo (name)"));
    assertFalse(parser.isUpdateStatement("select * from foo"));
    assertTrue(
        parser.isUpdateStatement(
            "UPDATE FOO SET NAME=(SELECT NAME FROM FOO) WHERE ID=(SELECT ID+1 FROM FOO)"));

    assertTrue(
        parser
            .parse(Statement.of("-- this is a comment\nupdate foo set name='foo' where id=@id"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/* multi line comment\n* with more information on the next line\n*/\nUPDATE FOO\nSET NAME=\t'foo'\n\tWHERE ID=1"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/** java doc comment\n* with more information on the next line\n*/\nUPDATE FOO SET NAME=(select 'bar')"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of("-- SELECT in a single line comment \n    update foo set name='bar'"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/* CREATE in a multi line comment\n* with more information on the next line\n*/\nUPDATE FOO SET NAME='BAR'"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/** DROP in a java doc comment\n* with more information on the next line\n*/\n\n\n\n -- SELECT test\nupdate foo set bar='foo'"))
            .isUpdate());
  }

  @Test
  public void testIsUpdate_DeleteStatements() {
    assertFalse(parser.isUpdateStatement(""));
    assertFalse(parser.isUpdateStatement("random text"));
    assertFalse(parser.isUpdateStatement("DELETEFROM FOO WHERE ID=1"));
    assertFalse(parser.isUpdateStatement("DDELETE FROM FOO WHERE ID=1"));
    assertTrue(parser.isUpdateStatement("DELETE FROM FOO WHERE ID=1"));
    assertTrue(parser.isUpdateStatement("delete from foo where id=1"));
    assertTrue(
        parser.isUpdateStatement(
            "delete from foo where name=\n(SELECT name FROM bar WHERE id=@id)"));
    assertFalse(parser.isUpdateStatement("SELECT 1"));
    assertFalse(parser.isUpdateStatement("SELECT NAME FROM FOO WHERE ID=1"));
    assertFalse(
        parser.isUpdateStatement("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"));
    assertFalse(parser.isUpdateStatement("alter table foo add Description string(100)"));
    assertFalse(parser.isUpdateStatement("drop table foo"));
    assertFalse(parser.isUpdateStatement("Create index BAR on foo (name)"));
    assertFalse(parser.isUpdateStatement("select * from foo"));
    assertTrue(
        parser.isUpdateStatement(
            "UPDATE FOO SET NAME=(SELECT NAME FROM FOO) WHERE ID=(SELECT ID+1 FROM FOO)"));

    assertTrue(
        parser
            .parse(Statement.of("-- this is a comment\ndelete from foo  where id=@id"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/* multi line comment\n* with more information on the next line\n*/\nDELETE FROM FOO\n\n\tWHERE ID=1"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/** java doc comment\n* with more information on the next line\n*/\nDELETE FROM FOO WHERE NAME=(select 'bar')"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "-- SELECT in a single line comment \n    delete from foo where name='bar'"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/* CREATE in a multi line comment\n* with more information on the next line\n*/\nDELETE FROM FOO WHERE NAME='BAR'"))
            .isUpdate());
    assertTrue(
        parser
            .parse(
                Statement.of(
                    "/** DROP in a java doc comment\n* with more information on the next line\n*/\n\n\n\n -- SELECT test\ndelete from foo where bar='foo'"))
            .isUpdate());
  }

  @Test
  public void testParseStatementsWithNoParameters() throws CompileException {
    for (ClientSideStatementImpl statement : getAllStatements()) {
      if (statement.getSetStatement() == null) {
        for (String testStatement : statement.getExampleStatements()) {
          testParseStatement(testStatement, statement.getClass());
        }
      }
    }
  }

  @Test
  public void testParseStatementsWithOneParameterAtTheEnd() throws CompileException {
    for (ClientSideStatementImpl statement : getAllStatements()) {
      if (statement.getSetStatement() != null) {
        for (String testStatement : statement.getExampleStatements()) {
          testParseStatementWithOneParameterAtTheEnd(testStatement, statement.getClass());
        }
      }
    }
  }

  private Set<ClientSideStatementImpl> getAllStatements() throws CompileException {
    return ClientSideStatements.INSTANCE.getCompiledStatements();
  }

  private <T extends ClientSideStatementImpl> void assertParsing(
      String value, Class<T> statementClass) {
    assertThat(this.<T>parse(value), is(equalTo(statementClass)));
  }

  private <T extends ClientSideStatementImpl> void testParseStatement(
      String statement, Class<T> statementClass) {
    assertThat(
        "\"" + statement + "\" should be " + statementClass.getName(),
        this.<T>parse(statement),
        is(equalTo(statementClass)));
    assertParsing(upper(statement), statementClass);
    assertParsing(lower(statement), statementClass);
    assertParsing(withSpaces(statement), statementClass);
    assertParsing(withTabs(statement), statementClass);
    assertParsing(withLinefeeds(statement), statementClass);
    assertParsing(withLeadingSpaces(statement), statementClass);
    assertParsing(withLeadingTabs(statement), statementClass);
    assertParsing(withLeadingLinefeeds(statement), statementClass);
    assertParsing(withTrailingSpaces(statement), statementClass);
    assertParsing(withTrailingTabs(statement), statementClass);
    assertParsing(withTrailingLinefeeds(statement), statementClass);

    assertThat(parse(withInvalidPrefix(statement)), is(nullValue()));
    assertThat(parse(withInvalidSuffix(statement)), is(nullValue()));

    assertNull(parse(withPrefix("%", statement)));
    assertNull(parse(withPrefix("_", statement)));
    assertNull(parse(withPrefix("&", statement)));
    assertNull(parse(withPrefix("$", statement)));
    assertNull(parse(withPrefix("@", statement)));
    assertNull(parse(withPrefix("!", statement)));
    assertNull(parse(withPrefix("*", statement)));
    assertNull(parse(withPrefix("(", statement)));
    assertNull(parse(withPrefix(")", statement)));

    assertThat(
        withSuffix("%", statement) + " is not a valid statement",
        parse(withSuffix("%", statement)),
        is(nullValue()));
    assertNull(parse(withSuffix("_", statement)));
    assertNull(parse(withSuffix("&", statement)));
    assertNull(parse(withSuffix("$", statement)));
    assertNull(parse(withSuffix("@", statement)));
    assertNull(parse(withSuffix("!", statement)));
    assertNull(parse(withSuffix("*", statement)));
    assertNull(parse(withSuffix("(", statement)));
    assertNull(parse(withSuffix(")", statement)));
  }

  private <T extends ClientSideStatementImpl> void testParseStatementWithOneParameterAtTheEnd(
      String statement, Class<T> statementClass) {
    assertThat(
        "\"" + statement + "\" should be " + statementClass.getName(),
        this.<T>parse(statement),
        is(equalTo(statementClass)));
    assertParsing(upper(statement), statementClass);
    assertParsing(lower(statement), statementClass);
    assertParsing(withSpaces(statement), statementClass);
    assertParsing(withTabs(statement), statementClass);
    assertParsing(withLinefeeds(statement), statementClass);
    assertParsing(withLeadingSpaces(statement), statementClass);
    assertParsing(withLeadingTabs(statement), statementClass);
    assertParsing(withLeadingLinefeeds(statement), statementClass);
    assertParsing(withTrailingSpaces(statement), statementClass);
    assertParsing(withTrailingTabs(statement), statementClass);
    assertParsing(withTrailingLinefeeds(statement), statementClass);

    assertNull(parse(withInvalidPrefix(statement)));
    assertParsing(withInvalidSuffix(statement), statementClass);

    assertNull(parse(withPrefix("%", statement)));
    assertNull(parse(withPrefix("_", statement)));
    assertNull(parse(withPrefix("&", statement)));
    assertNull(parse(withPrefix("$", statement)));
    assertNull(parse(withPrefix("@", statement)));
    assertNull(parse(withPrefix("!", statement)));
    assertNull(parse(withPrefix("*", statement)));
    assertNull(parse(withPrefix("(", statement)));
    assertNull(parse(withPrefix(")", statement)));

    assertParsing(withSuffix("%", statement), statementClass);
    assertParsing(withSuffix("_", statement), statementClass);
    assertParsing(withSuffix("&", statement), statementClass);
    assertParsing(withSuffix("$", statement), statementClass);
    assertParsing(withSuffix("@", statement), statementClass);
    assertParsing(withSuffix("!", statement), statementClass);
    assertParsing(withSuffix("*", statement), statementClass);
    assertParsing(withSuffix("(", statement), statementClass);
    assertParsing(withSuffix(")", statement), statementClass);
  }

  @SuppressWarnings("unchecked")
  private <T extends ClientSideStatementImpl> Class<T> parse(String statement) {
    ClientSideStatementImpl optional = parser.parseClientSideStatement(statement);
    return optional != null ? (Class<T>) optional.getClass() : null;
  }

  private String upper(String statement) {
    return statement.toUpperCase();
  }

  private String lower(String statement) {
    return statement.toLowerCase();
  }

  private String withLeadingSpaces(String statement) {
    return "   " + statement;
  }

  private String withLeadingTabs(String statement) {
    return "\t\t\t" + statement;
  }

  private String withLeadingLinefeeds(String statement) {
    return "\n\n\n" + statement;
  }

  private String withTrailingSpaces(String statement) {
    return statement + "  ";
  }

  private String withTrailingTabs(String statement) {
    return statement + "\t\t";
  }

  private String withTrailingLinefeeds(String statement) {
    return statement + "\n\n";
  }

  private String withSpaces(String statement) {
    return statement.replaceAll(" ", "   ");
  }

  private String withTabs(String statement) {
    return statement.replaceAll(" ", "\t");
  }

  private String withLinefeeds(String statement) {
    return statement.replaceAll(" ", "\n");
  }

  private String withInvalidPrefix(String statement) {
    return "foo " + statement;
  }

  private String withInvalidSuffix(String statement) {
    return statement + " bar";
  }

  private String withPrefix(String prefix, String statement) {
    return prefix + statement;
  }

  private String withSuffix(String suffix, String statement) {
    return statement + suffix;
  }

  private List<String> readStatementsFromFile(String filename) {
    File file = new File(getClass().getResource(filename).getFile());
    StringBuilder builder = new StringBuilder();
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        builder.append(line).append("\n");
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    String script = builder.toString().replaceAll(COPYRIGHT_PATTERN, "");
    String[] array = script.split(";");
    List<String> res = new ArrayList<>(array.length);
    for (String statement : array) {
      if (statement != null && statement.trim().length() > 0) {
        res.add(statement);
      }
    }
    return res;
  }
}
