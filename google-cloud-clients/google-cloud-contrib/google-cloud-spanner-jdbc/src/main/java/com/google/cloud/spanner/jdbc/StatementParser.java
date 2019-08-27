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

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.jdbc.ClientSideStatementImpl.CompileException;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Collections;
import java.util.Set;

/**
 * Internal class for the Spanner Connection API.
 *
 * <p>Parses {@link ClientSideStatement}s and normal SQL statements. The parser is able to recognize
 * the type of statement, allowing the connection API to know which method on Spanner should be
 * called. The parser does not validate the validity of statements, except for {@link
 * ClientSideStatement}s. This means that an invalid DML statement could be accepted by the {@link
 * StatementParser} and sent to Spanner, and Spanner will then reject it with some error message.
 */
class StatementParser {
  /** Singleton instance of {@link StatementParser}. */
  public static final StatementParser INSTANCE = new StatementParser();

  /** The type of statement that has been recognized by the parser. */
  enum StatementType {
    CLIENT_SIDE,
    DDL,
    QUERY,
    UPDATE,
    UNKNOWN;
  }

  /** A statement that has been parsed */
  static class ParsedStatement {
    private final StatementType type;
    private final ClientSideStatementImpl clientSideStatement;
    private final Statement statement;
    private final String sqlWithoutComments;

    private static ParsedStatement clientSideStatement(
        ClientSideStatementImpl clientSideStatement,
        Statement statement,
        String sqlWithoutComments) {
      return new ParsedStatement(clientSideStatement, statement, sqlWithoutComments);
    }

    private static ParsedStatement ddl(Statement statement, String sqlWithoutComments) {
      return new ParsedStatement(StatementType.DDL, statement, sqlWithoutComments);
    }

    private static ParsedStatement query(Statement statement, String sqlWithoutComments) {
      return new ParsedStatement(StatementType.QUERY, statement, sqlWithoutComments);
    }

    private static ParsedStatement update(Statement statement, String sqlWithoutComments) {
      return new ParsedStatement(StatementType.UPDATE, statement, sqlWithoutComments);
    }

    private static ParsedStatement unknown(Statement statement, String sqlWithoutComments) {
      return new ParsedStatement(StatementType.UNKNOWN, statement, sqlWithoutComments);
    }

    private ParsedStatement(
        ClientSideStatementImpl clientSideStatement,
        Statement statement,
        String sqlWithoutComments) {
      Preconditions.checkNotNull(clientSideStatement);
      Preconditions.checkNotNull(statement);
      this.type = StatementType.CLIENT_SIDE;
      this.clientSideStatement = clientSideStatement;
      this.statement = statement;
      this.sqlWithoutComments = sqlWithoutComments;
    }

    private ParsedStatement(StatementType type, Statement statement, String sqlWithoutComments) {
      Preconditions.checkNotNull(type);
      Preconditions.checkNotNull(statement);
      this.type = type;
      this.clientSideStatement = null;
      this.statement = statement;
      this.sqlWithoutComments = sqlWithoutComments;
    }

    StatementType getType() {
      return type;
    }

    boolean isQuery() {
      switch (type) {
        case CLIENT_SIDE:
          return getClientSideStatement().isQuery();
        case QUERY:
          return true;
        case UPDATE:
        case DDL:
        case UNKNOWN:
        default:
      }
      return false;
    }

    boolean isUpdate() {
      switch (type) {
        case CLIENT_SIDE:
          return getClientSideStatement().isUpdate();
        case UPDATE:
          return true;
        case QUERY:
        case DDL:
        case UNKNOWN:
        default:
      }
      return false;
    }

    boolean isDdl() {
      switch (type) {
        case DDL:
          return true;
        case CLIENT_SIDE:
        case UPDATE:
        case QUERY:
        case UNKNOWN:
        default:
      }
      return false;
    }

    Statement getStatement() {
      return statement;
    }

    String getSqlWithoutComments() {
      return sqlWithoutComments;
    }

    ClientSideStatement getClientSideStatement() {
      Preconditions.checkState(
          clientSideStatement != null,
          "This ParsedStatement does not contain a ClientSideStatement");
      return clientSideStatement;
    }
  }

  private final Set<String> ddlStatements = ImmutableSet.of("CREATE", "DROP", "ALTER");
  private final Set<String> selectStatements = ImmutableSet.of("SELECT");
  private final Set<String> dmlStatements = ImmutableSet.of("INSERT", "UPDATE", "DELETE");
  private final Set<ClientSideStatementImpl> statements;

  /** Private constructor for singleton instance. */
  private StatementParser() {
    try {
      statements =
          Collections.unmodifiableSet(ClientSideStatements.INSTANCE.getCompiledStatements());
    } catch (CompileException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Parses the given statement and categorizes it as one of the possible {@link StatementType}s.
   * The validity of the statement is not checked, unless it is a client-side statement.
   *
   * @param statement The statement to parse.
   * @return the parsed and categorized statement.
   */
  ParsedStatement parse(Statement statement) {
    String sql = removeCommentsAndTrim(statement.getSql());
    ClientSideStatementImpl client = parseClientSideStatement(sql);
    if (client != null) {
      return ParsedStatement.clientSideStatement(client, statement, sql);
    } else if (isQuery(sql)) {
      return ParsedStatement.query(statement, sql);
    } else if (isUpdateStatement(sql)) {
      return ParsedStatement.update(statement, sql);
    } else if (isDdlStatement(sql)) {
      return ParsedStatement.ddl(statement, sql);
    }
    return ParsedStatement.unknown(statement, sql);
  }

  /**
   * Parses the given statement as a client-side statement. Client-side statements are statements
   * that are never sent to Cloud Spanner, but that are interpreted by the Connection API and then
   * translated into some action, such as for example starting a transaction or getting the last
   * commit timestamp.
   *
   * @param sql The statement to try to parse as a client-side statement (without any comments).
   * @return a valid {@link ClientSideStatement} or null if the statement is not a client-side
   *     statement.
   */
  @VisibleForTesting
  ClientSideStatementImpl parseClientSideStatement(String sql) {
    for (ClientSideStatementImpl css : statements) {
      if (css.matches(sql)) {
        return css;
      }
    }
    return null;
  }

  /**
   * Checks whether the given statement is (probably) a DDL statement. The method does not check the
   * validity of the statement, only if it is a DDL statement based on the first word in the
   * statement.
   *
   * @param sql The statement to check (without any comments).
   * @return <code>true</code> if the statement is a DDL statement (i.e. starts with 'CREATE',
   *     'ALTER' or 'DROP').
   */
  boolean isDdlStatement(String sql) {
    return statementStartsWith(sql, ddlStatements);
  }

  /**
   * Checks whether the given statement is (probably) a SELECT query. The method does not check the
   * validity of the statement, only if it is a SELECT statement based on the first word in the
   * statement.
   *
   * @param sql The statement to check (without any comments).
   * @return <code>true</code> if the statement is a SELECT statement (i.e. starts with 'SELECT').
   */
  boolean isQuery(String sql) {
    return statementStartsWith(sql, selectStatements);
  }

  /**
   * Checks whether the given statement is (probably) an update statement. The method does not check
   * the validity of the statement, only if it is an update statement based on the first word in the
   * statement.
   *
   * @param sql The statement to check (without any comments).
   * @return <code>true</code> if the statement is a DML update statement (i.e. starts with
   *     'INSERT', 'UPDATE' or 'DELETE').
   */
  boolean isUpdateStatement(String sql) {
    return statementStartsWith(sql, dmlStatements);
  }

  private boolean statementStartsWith(String sql, Iterable<String> checkStatements) {
    Preconditions.checkNotNull(sql);
    String[] tokens = sql.split("\\s+", 2);
    if (tokens.length > 0) {
      for (String check : checkStatements) {
        if (tokens[0].equalsIgnoreCase(check)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Removes comments from and trims the given sql statement. Spanner supports three types of
   * comments:
   *
   * <ul>
   *   <li>Single line comments starting with '--'
   *   <li>Single line comments starting with '#'
   *   <li>Multi line comments between '/&#42;' and '&#42;/'
   * </ul>
   *
   * Reference: https://cloud.google.com/spanner/docs/lexical#comments
   *
   * @param sql The sql statement to remove comments from and to trim.
   * @return the sql statement without the comments and leading and trailing spaces.
   */
  static String removeCommentsAndTrim(String sql) {
    Preconditions.checkNotNull(sql);
    final char SINGLE_QUOTE = '\'';
    final char DOUBLE_QUOTE = '"';
    final char BACKTICK_QUOTE = '`';
    final char HYPHEN = '-';
    final char DASH = '#';
    final char SLASH = '/';
    final char ASTERIKS = '*';
    boolean isInQuoted = false;
    boolean isInSingleLineComment = false;
    boolean isInMultiLineComment = false;
    char startQuote = 0;
    boolean lastCharWasEscapeChar = false;
    boolean isTripleQuoted = false;
    StringBuilder res = new StringBuilder(sql.length());
    int index = 0;
    while (index < sql.length()) {
      char c = sql.charAt(index);
      if (isInQuoted) {
        if ((c == '\n' || c == '\r') && !isTripleQuoted) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT, "SQL statement contains an unclosed literal: " + sql);
        } else if (c == startQuote) {
          if (lastCharWasEscapeChar) {
            lastCharWasEscapeChar = false;
          } else if (isTripleQuoted) {
            if (sql.length() > index + 2
                && sql.charAt(index + 1) == startQuote
                && sql.charAt(index + 2) == startQuote) {
              isInQuoted = false;
              startQuote = 0;
              isTripleQuoted = false;
              res.append(c).append(c);
              index += 2;
            }
          } else {
            isInQuoted = false;
            startQuote = 0;
          }
        } else if (c == '\\') {
          lastCharWasEscapeChar = true;
        } else {
          lastCharWasEscapeChar = false;
        }
        res.append(c);
      } else {
        // We are not in a quoted string.
        if (isInSingleLineComment) {
          if (c == '\n') {
            isInSingleLineComment = false;
            // Include the line feed in the result.
            res.append(c);
          }
        } else if (isInMultiLineComment) {
          if (sql.length() > index + 1 && c == ASTERIKS && sql.charAt(index + 1) == SLASH) {
            isInMultiLineComment = false;
            index++;
          }
        } else {
          if (c == DASH
              || (sql.length() > index + 1 && c == HYPHEN && sql.charAt(index + 1) == HYPHEN)) {
            // This is a single line comment.
            isInSingleLineComment = true;
          } else if (sql.length() > index + 1 && c == SLASH && sql.charAt(index + 1) == ASTERIKS) {
            isInMultiLineComment = true;
            index++;
          } else {
            if (c == SINGLE_QUOTE || c == DOUBLE_QUOTE || c == BACKTICK_QUOTE) {
              isInQuoted = true;
              startQuote = c;
              // Check whether it is a triple-quote.
              if (sql.length() > index + 2
                  && sql.charAt(index + 1) == startQuote
                  && sql.charAt(index + 2) == startQuote) {
                isTripleQuoted = true;
                res.append(c).append(c);
                index += 2;
              }
            }
            res.append(c);
          }
        }
      }
      index++;
    }
    if (isInQuoted) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT, "SQL statement contains an unclosed literal: " + sql);
    }
    if (res.length() > 0 && res.charAt(res.length() - 1) == ';') {
      res.deleteCharAt(res.length() - 1);
    }
    return res.toString().trim();
  }
}
