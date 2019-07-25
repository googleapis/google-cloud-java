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
import static org.junit.Assert.assertThat;

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

  private List<String> readStatementsFromFile(String filename) {
    File file = new File(getClass().getResource(filename).getFile());
    StringBuilder builder = new StringBuilder();
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        builder.append(line).append("\n");
      }
      scanner.close();
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

  @Test
  public void testStatementWithCommentContainingSlash() {
    // @formatter:off
    String sql =
        "/*\n"
            + " * Script for testing invalid/unrecognized statements\n"
            + " */\n"
            + "\n"
            + "-- PostgreSQL MERGE statement\n"
            + "@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown statement'\n"
            + "MERGE INTO wines w\n"
            + "USING (VALUES('Chateau Lafite 2003', '24')) v\n"
            + "ON v.column1 = w.winename\n"
            + "WHEN NOT MATCHED \n"
            + "  INSERT VALUES(v.column1, v.column2)\n"
            + "WHEN MATCHED\n"
            + "  UPDATE SET stock = stock + v.column2;\n";
    String sqlWithoutComments =
        "@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown statement'\n"
            + "MERGE INTO wines w\n"
            + "USING (VALUES('Chateau Lafite 2003', '24')) v\n"
            + "ON v.column1 = w.winename\n"
            + "WHEN NOT MATCHED \n"
            + "  INSERT VALUES(v.column1, v.column2)\n"
            + "WHEN MATCHED\n"
            + "  UPDATE SET stock = stock + v.column2;";
    // @formatter:on
    ParsedStatement statement = parser.parse(Statement.of(sql));
    assertThat(statement.getSqlWithoutComments(), is(equalTo(sqlWithoutComments)));
  }

  @Test
  public void testStatementWithCommentContainingSlashAndNoAsteriskOnNewLine() {
    // @formatter:off
    String sql =
        "/*\n"
            + " * Script for testing invalid/unrecognized statements\n"
            + " foo bar baz"
            + " */\n"
            + "\n"
            + "-- PostgreSQL MERGE statement\n"
            + "@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown statement'\n"
            + "MERGE INTO wines w\n"
            + "USING (VALUES('Chateau Lafite 2003', '24')) v\n"
            + "ON v.column1 = w.winename\n"
            + "WHEN NOT MATCHED \n"
            + "  INSERT VALUES(v.column1, v.column2)\n"
            + "WHEN MATCHED\n"
            + "  UPDATE SET stock = stock + v.column2;\n";
    String sqlWithoutComments =
        "@EXPECT EXCEPTION INVALID_ARGUMENT 'INVALID_ARGUMENT: Unknown statement'\n"
            + "MERGE INTO wines w\n"
            + "USING (VALUES('Chateau Lafite 2003', '24')) v\n"
            + "ON v.column1 = w.winename\n"
            + "WHEN NOT MATCHED \n"
            + "  INSERT VALUES(v.column1, v.column2)\n"
            + "WHEN MATCHED\n"
            + "  UPDATE SET stock = stock + v.column2;";
    // @formatter:on
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
    assertThat(parser.isDdlStatement(""), is(false));
    assertThat(parser.isDdlStatement("random text"), is(false));
    assertThat(parser.isDdlStatement("CREATETABLE"), is(false));
    assertThat(parser.isDdlStatement("CCREATE TABLE"), is(false));
    assertThat(parser.isDdlStatement("SELECT 1"), is(false));
    assertThat(parser.isDdlStatement("SELECT FOO FROM BAR"), is(false));
    assertThat(parser.isDdlStatement("INSERT INTO FOO (ID, NAME) VALUES (1, 'NAME')"), is(false));
    assertThat(parser.isDdlStatement("UPDATE FOO SET NAME='NAME' WHERE ID=1"), is(false));
    assertThat(parser.isDdlStatement("DELETE FROM FOO"), is(false));

    assertThat(
        parser.isDdlStatement("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"),
        is(true));
    assertThat(parser.isDdlStatement("alter table foo add Description string(100)"), is(true));
    assertThat(parser.isDdlStatement("drop table foo"), is(true));
    assertThat(parser.isDdlStatement("Create index BAR on foo (name)"), is(true));

    assertThat(
        parser
            .parse(
                Statement.of(
                    "\t\tCREATE\n\t   TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "\n\n\nCREATE TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "-- this is a comment\nCREATE TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/* multi line comment\n* with more information on the next line\n*/\nCREATE TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/** java doc comment\n* with more information on the next line\n*/\nCREATE TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "-- SELECT in a single line comment \nCREATE TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/* SELECT in a multi line comment\n* with more information on the next line\n*/\nCREATE TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/** SELECT in a java doc comment\n* with more information on the next line\n*/\nCREATE TABLE   FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"))
            .isDdl(),
        is(true));
  }

  @Test
  public void testIsQuery() {
    assertThat(parser.isQuery(""), is(false));
    assertThat(parser.isQuery("random text"), is(false));
    assertThat(parser.isQuery("SELECT1"), is(false));
    assertThat(parser.isQuery("SSELECT 1"), is(false));
    assertThat(parser.isQuery("SELECT 1"), is(true));
    assertThat(parser.isQuery("select 1"), is(true));
    assertThat(parser.isQuery("SELECT foo FROM bar WHERE id=@id"), is(true));
    assertThat(parser.isQuery("INSERT INTO FOO (ID, NAME) VALUES (1, 'NAME')"), is(false));
    assertThat(parser.isQuery("UPDATE FOO SET NAME='NAME' WHERE ID=1"), is(false));
    assertThat(parser.isQuery("DELETE FROM FOO"), is(false));
    assertThat(
        parser.isQuery("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"),
        is(false));
    assertThat(parser.isQuery("alter table foo add Description string(100)"), is(false));
    assertThat(parser.isQuery("drop table foo"), is(false));
    assertThat(parser.isQuery("Create index BAR on foo (name)"), is(false));
    assertThat(parser.isQuery("select * from foo"), is(true));
    assertThat(parser.isQuery("INSERT INTO FOO (ID, NAME) SELECT ID+1, NAME FROM FOO"), is(false));

    assertThat(
        parser.parse(Statement.of("-- this is a comment\nselect * from foo")).isQuery(), is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/* multi line comment\n* with more information on the next line\n*/\nSELECT ID, NAME\nFROM\tTEST\n\tWHERE ID=1"))
            .isQuery(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/** java doc comment\n* with more information on the next line\n*/\nselect max(id) from test"))
            .isQuery(),
        is(true));
    assertThat(
        parser.parse(Statement.of("-- INSERT in a single line comment \n    select 1")).isQuery(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/* UPDATE in a multi line comment\n* with more information on the next line\n*/\nSELECT 1"))
            .isQuery(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/** DELETE in a java doc comment\n* with more information on the next line\n*/\n\n\n\n -- UPDATE test\nSELECT 1"))
            .isQuery(),
        is(true));
  }

  @Test
  public void testIsUpdate_InsertStatements() {
    assertThat(parser.isUpdateStatement(""), is(false));
    assertThat(parser.isUpdateStatement("random text"), is(false));
    assertThat(parser.isUpdateStatement("INSERTINTO FOO (ID) VALUES (1)"), is(false));
    assertThat(parser.isUpdateStatement("IINSERT INTO FOO (ID) VALUES (1)"), is(false));
    assertThat(parser.isUpdateStatement("INSERT INTO FOO (ID) VALUES (1)"), is(true));
    assertThat(parser.isUpdateStatement("insert into foo (id) values (1)"), is(true));
    assertThat(
        parser.isUpdateStatement("INSERT into Foo (id)\nSELECT id FROM bar WHERE id=@id"),
        is(true));
    assertThat(parser.isUpdateStatement("SELECT 1"), is(false));
    assertThat(parser.isUpdateStatement("SELECT NAME FROM FOO WHERE ID=1"), is(false));
    assertThat(
        parser.isUpdateStatement("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"),
        is(false));
    assertThat(parser.isUpdateStatement("alter table foo add Description string(100)"), is(false));
    assertThat(parser.isUpdateStatement("drop table foo"), is(false));
    assertThat(parser.isUpdateStatement("Create index BAR on foo (name)"), is(false));
    assertThat(parser.isUpdateStatement("select * from foo"), is(false));
    assertThat(
        parser.isUpdateStatement("INSERT INTO FOO (ID, NAME) SELECT ID+1, NAME FROM FOO"),
        is(true));

    assertThat(
        parser
            .parse(Statement.of("-- this is a comment\ninsert into foo (id) values (1)"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/* multi line comment\n* with more information on the next line\n*/\nINSERT INTO FOO\n(ID)\tVALUES\n\t(1)"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/** java doc comment\n* with more information on the next line\n*/\nInsert intO foo (id) select 1"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "-- SELECT in a single line comment \n    insert into foo (id) values (1)"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/* CREATE in a multi line comment\n* with more information on the next line\n*/\nINSERT INTO FOO (ID) VALUES (1)"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/** DROP in a java doc comment\n* with more information on the next line\n*/\n\n\n\n -- SELECT test\ninsert into foo (id) values (1)"))
            .isUpdate(),
        is(true));
  }

  @Test
  public void testIsUpdate_UpdateStatements() {
    assertThat(parser.isUpdateStatement(""), is(false));
    assertThat(parser.isUpdateStatement("random text"), is(false));
    assertThat(parser.isUpdateStatement("UPDATEFOO SET NAME='foo' WHERE ID=1"), is(false));
    assertThat(parser.isUpdateStatement("UUPDATE FOO SET NAME='foo' WHERE ID=1"), is(false));
    assertThat(parser.isUpdateStatement("UPDATE FOO SET NAME='foo' WHERE ID=1"), is(true));
    assertThat(parser.isUpdateStatement("update foo set name='foo' where id=1"), is(true));
    assertThat(
        parser.isUpdateStatement("update foo set name=\n(SELECT name FROM bar WHERE id=@id)"),
        is(true));
    assertThat(parser.isUpdateStatement("SELECT 1"), is(false));
    assertThat(parser.isUpdateStatement("SELECT NAME FROM FOO WHERE ID=1"), is(false));
    assertThat(
        parser.isUpdateStatement("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"),
        is(false));
    assertThat(parser.isUpdateStatement("alter table foo add Description string(100)"), is(false));
    assertThat(parser.isUpdateStatement("drop table foo"), is(false));
    assertThat(parser.isUpdateStatement("Create index BAR on foo (name)"), is(false));
    assertThat(parser.isUpdateStatement("select * from foo"), is(false));
    assertThat(
        parser.isUpdateStatement(
            "UPDATE FOO SET NAME=(SELECT NAME FROM FOO) WHERE ID=(SELECT ID+1 FROM FOO)"),
        is(true));

    assertThat(
        parser
            .parse(Statement.of("-- this is a comment\nupdate foo set name='foo' where id=@id"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/* multi line comment\n* with more information on the next line\n*/\nUPDATE FOO\nSET NAME=\t'foo'\n\tWHERE ID=1"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/** java doc comment\n* with more information on the next line\n*/\nUPDATE FOO SET NAME=(select 'bar')"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of("-- SELECT in a single line comment \n    update foo set name='bar'"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/* CREATE in a multi line comment\n* with more information on the next line\n*/\nUPDATE FOO SET NAME='BAR'"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/** DROP in a java doc comment\n* with more information on the next line\n*/\n\n\n\n -- SELECT test\nupdate foo set bar='foo'"))
            .isUpdate(),
        is(true));
  }

  @Test
  public void testIsUpdate_DeleteStatements() {
    assertThat(parser.isUpdateStatement(""), is(false));
    assertThat(parser.isUpdateStatement("random text"), is(false));
    assertThat(parser.isUpdateStatement("DELETEFROM FOO WHERE ID=1"), is(false));
    assertThat(parser.isUpdateStatement("DDELETE FROM FOO WHERE ID=1"), is(false));
    assertThat(parser.isUpdateStatement("DELETE FROM FOO WHERE ID=1"), is(true));
    assertThat(parser.isUpdateStatement("delete from foo where id=1"), is(true));
    assertThat(
        parser.isUpdateStatement(
            "delete from foo where name=\n(SELECT name FROM bar WHERE id=@id)"),
        is(true));
    assertThat(parser.isUpdateStatement("SELECT 1"), is(false));
    assertThat(parser.isUpdateStatement("SELECT NAME FROM FOO WHERE ID=1"), is(false));
    assertThat(
        parser.isUpdateStatement("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"),
        is(false));
    assertThat(parser.isUpdateStatement("alter table foo add Description string(100)"), is(false));
    assertThat(parser.isUpdateStatement("drop table foo"), is(false));
    assertThat(parser.isUpdateStatement("Create index BAR on foo (name)"), is(false));
    assertThat(parser.isUpdateStatement("select * from foo"), is(false));
    assertThat(
        parser.isUpdateStatement(
            "UPDATE FOO SET NAME=(SELECT NAME FROM FOO) WHERE ID=(SELECT ID+1 FROM FOO)"),
        is(true));

    assertThat(
        parser
            .parse(Statement.of("-- this is a comment\ndelete from foo  where id=@id"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/* multi line comment\n* with more information on the next line\n*/\nDELETE FROM FOO\n\n\tWHERE ID=1"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/** java doc comment\n* with more information on the next line\n*/\nDELETE FROM FOO WHERE NAME=(select 'bar')"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "-- SELECT in a single line comment \n    delete from foo where name='bar'"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/* CREATE in a multi line comment\n* with more information on the next line\n*/\nDELETE FROM FOO WHERE NAME='BAR'"))
            .isUpdate(),
        is(true));
    assertThat(
        parser
            .parse(
                Statement.of(
                    "/** DROP in a java doc comment\n* with more information on the next line\n*/\n\n\n\n -- SELECT test\ndelete from foo where bar='foo'"))
            .isUpdate(),
        is(true));
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

  private <T extends ClientSideStatementImpl> void testParseStatement(
      String statement, Class<T> statementClass) {
    assertThat(
        "\"" + statement + "\" should be " + statementClass.getName(),
        this.<T>parse(statement),
        is(equalTo(statementClass)));
    assertThat(this.<T>parse(upper(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(lower(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withSpaces(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withTabs(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withLinefeeds(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withLeadingSpaces(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withLeadingTabs(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withLeadingLinefeeds(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withTrailingSpaces(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withTrailingTabs(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withTrailingLinefeeds(statement)), is(equalTo(statementClass)));

    assertThat(parse(withInvalidPrefix(statement)), is(nullValue()));
    assertThat(parse(withInvalidSuffix(statement)), is(nullValue()));

    assertThat(parse(withPrefix("%", statement)), is(nullValue()));
    assertThat(parse(withPrefix("_", statement)), is(nullValue()));
    assertThat(parse(withPrefix("&", statement)), is(nullValue()));
    assertThat(parse(withPrefix("$", statement)), is(nullValue()));
    assertThat(parse(withPrefix("@", statement)), is(nullValue()));
    assertThat(parse(withPrefix("!", statement)), is(nullValue()));
    assertThat(parse(withPrefix("*", statement)), is(nullValue()));
    assertThat(parse(withPrefix("(", statement)), is(nullValue()));
    assertThat(parse(withPrefix(")", statement)), is(nullValue()));

    assertThat(
        withSuffix("%", statement) + " is not a valid statement",
        parse(withSuffix("%", statement)),
        is(nullValue()));
    assertThat(parse(withSuffix("_", statement)), is(nullValue()));
    assertThat(parse(withSuffix("&", statement)), is(nullValue()));
    assertThat(parse(withSuffix("$", statement)), is(nullValue()));
    assertThat(parse(withSuffix("@", statement)), is(nullValue()));
    assertThat(parse(withSuffix("!", statement)), is(nullValue()));
    assertThat(parse(withSuffix("*", statement)), is(nullValue()));
    assertThat(parse(withSuffix("(", statement)), is(nullValue()));
    assertThat(parse(withSuffix(")", statement)), is(nullValue()));
  }

  private <T extends ClientSideStatementImpl> void testParseStatementWithOneParameterAtTheEnd(
      String statement, Class<T> statementClass) {
    assertThat(
        "\"" + statement + "\" should be " + statementClass.getName(),
        this.<T>parse(statement),
        is(equalTo(statementClass)));
    assertThat(this.<T>parse(upper(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(lower(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withSpaces(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withTabs(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withLinefeeds(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withLeadingSpaces(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withLeadingTabs(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withLeadingLinefeeds(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withTrailingSpaces(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withTrailingTabs(statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withTrailingLinefeeds(statement)), is(equalTo(statementClass)));

    assertThat(parse(withInvalidPrefix(statement)), is(nullValue()));
    assertThat(this.<T>parse(withInvalidSuffix(statement)), is(equalTo(statementClass)));

    assertThat(parse(withPrefix("%", statement)), is(nullValue()));
    assertThat(parse(withPrefix("_", statement)), is(nullValue()));
    assertThat(parse(withPrefix("&", statement)), is(nullValue()));
    assertThat(parse(withPrefix("$", statement)), is(nullValue()));
    assertThat(parse(withPrefix("@", statement)), is(nullValue()));
    assertThat(parse(withPrefix("!", statement)), is(nullValue()));
    assertThat(parse(withPrefix("*", statement)), is(nullValue()));
    assertThat(parse(withPrefix("(", statement)), is(nullValue()));
    assertThat(parse(withPrefix(")", statement)), is(nullValue()));

    assertThat(this.<T>parse(withSuffix("%", statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withSuffix("_", statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withSuffix("&", statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withSuffix("$", statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withSuffix("@", statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withSuffix("!", statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withSuffix("*", statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withSuffix("(", statement)), is(equalTo(statementClass)));
    assertThat(this.<T>parse(withSuffix(")", statement)), is(equalTo(statementClass)));
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
}
