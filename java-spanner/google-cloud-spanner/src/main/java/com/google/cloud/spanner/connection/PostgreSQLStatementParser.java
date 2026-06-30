/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.spanner.connection.SimpleParser.isValidIdentifierFirstChar;

import com.google.api.core.InternalApi;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.ClientSideStatementImpl.CompileException;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

@InternalApi
public class PostgreSQLStatementParser extends AbstractStatementParser {
  private static final Pattern RETURNING_PATTERN = Pattern.compile("returning[ '(\"*]");
  private static final Pattern AS_RETURNING_PATTERN = Pattern.compile("[ ')\"]as returning[ '(\"]");
  private static final String RETURNING_STRING = "returning";

  PostgreSQLStatementParser() throws CompileException {
    super(
        Collections.unmodifiableSet(
            ClientSideStatements.getInstance(Dialect.POSTGRESQL).getCompiledStatements()));
  }

  @Override
  Dialect getDialect() {
    return Dialect.POSTGRESQL;
  }

  @Override
  boolean supportsNestedComments() {
    return true;
  }

  @Override
  boolean supportsDollarQuotedStrings() {
    return true;
  }

  @Override
  boolean supportsBacktickQuote() {
    return false;
  }

  @Override
  boolean supportsTripleQuotedStrings() {
    return false;
  }

  @Override
  boolean supportsEscapeQuoteWithQuote() {
    return true;
  }

  @Override
  boolean supportsBackslashEscape() {
    return false;
  }

  @Override
  boolean supportsHashSingleLineComments() {
    return false;
  }

  @Override
  boolean supportsLineFeedInQuotedString() {
    return true;
  }

  @Override
  String getQueryParameterPrefix() {
    return "$";
  }

  /**
   * Removes comments from and trims the given sql statement. PostgreSQL supports two types of
   * comments:
   *
   * <ul>
   *   <li>Single line comments starting with '--'
   *   <li>Multi line comments between '/&#42;' and '&#42;/'. Nested comments are supported and all
   *       comments, including the nested comments, must be terminated.
   * </ul>
   *
   * Reference: https://www.postgresql.org/docs/current/sql-syntax-lexical.html#SQL-SYNTAX-COMMENTS
   *
   * @param sql The sql statement to remove comments from and to trim.
   * @return the sql statement without the comments and leading and trailing spaces.
   */
  @InternalApi
  @Override
  String removeCommentsAndTrimInternal(String sql) {
    Preconditions.checkNotNull(sql);
    boolean isInSingleLineComment = false;
    int multiLineCommentLevel = 0;
    boolean whitespaceBeforeOrAfterMultiLineComment = false;
    int multiLineCommentStartIdx = -1;
    StringBuilder res = new StringBuilder(sql.length());
    int index = 0;
    int length = sql.length();
    while (index < length) {
      char c = sql.charAt(index);
      if (isInSingleLineComment) {
        if (c == '\n') {
          isInSingleLineComment = false;
          // Include the line feed in the result.
          res.append(c);
        }
      } else if (multiLineCommentLevel > 0) {
        if (length > index + 1 && c == ASTERISK && sql.charAt(index + 1) == SLASH) {
          multiLineCommentLevel--;
          if (multiLineCommentLevel == 0) {
            if (!whitespaceBeforeOrAfterMultiLineComment && (length > index + 2)) {
              whitespaceBeforeOrAfterMultiLineComment =
                  Character.isWhitespace(sql.charAt(index + 2));
            }
            // If the multiline comment does not have any whitespace before or after it, and it is
            // neither at the start nor at the end of SQL string, append an extra space.
            if (!whitespaceBeforeOrAfterMultiLineComment
                && (multiLineCommentStartIdx != 0)
                && (index != length - 2)) {
              res.append(' ');
            }
          }
          index++;
        } else if (length > index + 1 && c == SLASH && sql.charAt(index + 1) == ASTERISK) {
          multiLineCommentLevel++;
          index++;
        }
      } else {
        // Check for -- which indicates the start of a single-line comment.
        if (length > index + 1 && c == HYPHEN && sql.charAt(index + 1) == HYPHEN) {
          // This is a single line comment.
          isInSingleLineComment = true;
          index += 2;
          continue;
        } else if (length > index + 1 && c == SLASH && sql.charAt(index + 1) == ASTERISK) {
          multiLineCommentLevel++;
          if (index >= 1) {
            whitespaceBeforeOrAfterMultiLineComment = Character.isWhitespace(sql.charAt(index - 1));
          }
          multiLineCommentStartIdx = index;
          index += 2;
          continue;
        } else {
          index = skip(sql, index, res);
          continue;
        }
      }
      index++;
    }
    if (multiLineCommentLevel > 0) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT,
          "SQL statement contains an unterminated block comment: " + sql);
    }
    if (res.length() > 0 && res.charAt(res.length() - 1) == ';') {
      res.deleteCharAt(res.length() - 1);
    }
    return res.toString().trim();
  }

  /** PostgreSQL does not support statement hints. */
  @Override
  String removeStatementHint(String sql) {
    return sql;
  }

  /**
   * Note: This is an internal API and breaking changes can be made without prior notice.
   *
   * <p>Returns the PostgreSQL-style query parameters ($1, $2, ...) in the given SQL string. The
   * SQL-string is allowed to contain comments. Occurrences of query-parameter like strings inside
   * quoted identifiers or string literals are ignored.
   *
   * <p>The following example will return a set containing ("$1", "$2"). <code>
   * select col1, col2, "col$4"
   * from some_table
   * where col1=$1 and col2=$2
   * and not col3=$1 and col4='$3'
   * </code>
   *
   * @param sql the SQL-string to check for parameters.
   * @return A set containing all the parameters in the SQL-string.
   */
  @InternalApi
  public Set<String> getQueryParameters(String sql) {
    Preconditions.checkNotNull(sql);
    int maxCount = countOccurrencesOf('$', sql);
    Set<String> parameters = new HashSet<>(maxCount);
    int currentIndex = 0;
    while (currentIndex < sql.length() - 1) {
      char c = sql.charAt(currentIndex);
      if (c == '$' && Character.isDigit(sql.charAt(currentIndex + 1))) {
        // Look ahead for the first non-digit. That is the end of the query parameter.
        int endIndex = currentIndex + 2;
        while (endIndex < sql.length() && Character.isDigit(sql.charAt(endIndex))) {
          endIndex++;
        }
        parameters.add(sql.substring(currentIndex, endIndex));
        currentIndex = endIndex;
      } else {
        currentIndex = skip(sql, currentIndex, null);
      }
    }
    return parameters;
  }

  private boolean checkCharPrecedingReturning(char ch) {
    return (ch == SPACE)
        || (ch == SINGLE_QUOTE)
        || (ch == CLOSE_PARENTHESIS)
        || (ch == DOUBLE_QUOTE)
        || (ch == DOLLAR);
  }

  private boolean checkCharPrecedingSubstrWithReturning(char ch) {
    return (ch == SPACE)
        || (ch == SINGLE_QUOTE)
        || (ch == CLOSE_PARENTHESIS)
        || (ch == DOUBLE_QUOTE)
        || (ch == COMMA);
  }

  private boolean isReturning(String sql, int index) {
    // RETURNING is a reserved keyword in PG, but requires a
    // leading AS to be used as column label, to avoid ambiguity.
    // We thus check for cases which do not have a leading AS.
    // (https://www.postgresql.org/docs/current/sql-keywords-appendix.html)
    if (index >= 1) {
      if (((index + 10 <= sql.length())
          && RETURNING_PATTERN.matcher(sql.substring(index, index + 10)).matches()
          && !((index >= 4)
              && AS_RETURNING_PATTERN.matcher(sql.substring(index - 4, index + 10)).matches()))) {
        if (checkCharPrecedingReturning(sql.charAt(index - 1))) {
          return true;
        }
        // Check for cases where returning clause is part of a substring which starts with an
        // invalid first character of an identifier.
        // For example,
        // insert into t select 2returning *;
        int ind = index - 1;
        while ((ind >= 0) && !checkCharPrecedingSubstrWithReturning(sql.charAt(ind))) {
          ind--;
        }
        return !isValidIdentifierFirstChar(sql.charAt(ind + 1));
      }
    }
    return false;
  }

  @InternalApi
  @Override
  protected boolean checkReturningClauseInternal(String rawSql) {
    Preconditions.checkNotNull(rawSql);
    String sql = rawSql.toLowerCase();
    // Do a pre-check to check if the SQL string definitely does not have a returning clause.
    // If this check fails, do a more involved check to check for a returning clause.
    if (!sql.contains(RETURNING_STRING)) {
      return false;
    }
    sql = sql.replaceAll("\\s+", " ");
    int index = 0;
    while (index < sql.length()) {
      if (isReturning(sql, index)) {
        return true;
      } else {
        index = skip(sql, index, null);
      }
    }
    return false;
  }
}
