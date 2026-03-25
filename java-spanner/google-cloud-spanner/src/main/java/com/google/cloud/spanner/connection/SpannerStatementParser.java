/*
 * Copyright 2022 Google LLC
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

import com.google.api.core.InternalApi;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.ClientSideStatementImpl.CompileException;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Set;
import java.util.regex.Pattern;

@InternalApi
public class SpannerStatementParser extends AbstractStatementParser {

  private static final Pattern THEN_RETURN_PATTERN =
      Pattern.compile("[ `')\"]then return[ *`'(\"]");
  private static final String THEN_STRING = "then";
  private static final String RETURN_STRING = "return";

  public SpannerStatementParser() throws CompileException {
    super(
        Collections.unmodifiableSet(
            ClientSideStatements.getInstance(Dialect.GOOGLE_STANDARD_SQL).getCompiledStatements()));
  }

  @Override
  Dialect getDialect() {
    return Dialect.GOOGLE_STANDARD_SQL;
  }

  @Override
  boolean supportsNestedComments() {
    return false;
  }

  @Override
  boolean supportsDollarQuotedStrings() {
    return false;
  }

  @Override
  boolean supportsBacktickQuote() {
    return true;
  }

  @Override
  boolean supportsTripleQuotedStrings() {
    return true;
  }

  @Override
  boolean supportsEscapeQuoteWithQuote() {
    return false;
  }

  @Override
  boolean supportsBackslashEscape() {
    return true;
  }

  @Override
  boolean supportsHashSingleLineComments() {
    return true;
  }

  @Override
  boolean supportsLineFeedInQuotedString() {
    return false;
  }

  @Override
  String getQueryParameterPrefix() {
    return "@p";
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
  @InternalApi
  @Override
  String removeCommentsAndTrimInternal(String sql) {
    Preconditions.checkNotNull(sql);
    boolean isInQuoted = false;
    boolean isInSingleLineComment = false;
    boolean isInMultiLineComment = false;
    char startQuote = 0;
    boolean lastCharWasEscapeChar = false;
    boolean isTripleQuoted = false;
    boolean whitespaceBeforeOrAfterMultiLineComment = false;
    int multiLineCommentStartIdx = -1;
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
            // TODO: Is this correct inside of a triple-quoted string?
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
          lastCharWasEscapeChar = !lastCharWasEscapeChar;
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
          if (sql.length() > index + 1 && c == ASTERISK && sql.charAt(index + 1) == SLASH) {
            isInMultiLineComment = false;
            if (!whitespaceBeforeOrAfterMultiLineComment && (sql.length() > index + 2)) {
              whitespaceBeforeOrAfterMultiLineComment =
                  Character.isWhitespace(sql.charAt(index + 2));
            }
            // If the multiline comment does not have any whitespace before or after it, and it is
            // neither at the start nor at the end of SQL string, append an extra space.
            if (!whitespaceBeforeOrAfterMultiLineComment
                && (multiLineCommentStartIdx != 0)
                && (index != sql.length() - 2)) {
              res.append(' ');
            }
            index++;
          }
        } else {
          if (c == DASH
              || (sql.length() > index + 1 && c == HYPHEN && sql.charAt(index + 1) == HYPHEN)) {
            // This is a single line comment.
            isInSingleLineComment = true;
          } else if (sql.length() > index + 1 && c == SLASH && sql.charAt(index + 1) == ASTERISK) {
            isInMultiLineComment = true;
            if (index >= 1) {
              whitespaceBeforeOrAfterMultiLineComment =
                  Character.isWhitespace(sql.charAt(index - 1));
            }
            multiLineCommentStartIdx = index;
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

  /** Removes any statement hints at the beginning of the statement. */
  @Override
  String removeStatementHint(String sql) {
    // Valid statement hints at the beginning of a query statement can only contain a fixed set of
    // possible values. Although it is possible to add a @{FORCE_INDEX=...} as a statement hint, the
    // only allowed value is _BASE_TABLE. This means that we can safely assume that the statement
    // hint will not contain any special characters, for example a closing curly brace or one of the
    // keywords SELECT, UPDATE, DELETE, WITH, and that we can keep the check simple by just
    // searching for the first occurrence of a keyword that should be preceded by a closing curly
    // brace at the end of the statement hint.
    int startStatementHintIndex = sql.indexOf('{');
    // Statement hints are allowed for both queries and DML statements.
    int startQueryIndex = -1;
    String upperCaseSql = sql.toUpperCase();
    Set<String> selectAndDmlStatements =
        Sets.union(selectStatements, dmlStatements).immutableCopy();
    for (String keyword : selectAndDmlStatements) {
      startQueryIndex = upperCaseSql.indexOf(keyword);
      if (startQueryIndex > -1) {
        break;
      }
    }
    if (startQueryIndex > -1) {
      int endStatementHintIndex = sql.substring(0, startQueryIndex).lastIndexOf('}');
      if (startStatementHintIndex == -1 || startStatementHintIndex > endStatementHintIndex) {
        // Looks like an invalid statement hint. Just ignore at this point and let the caller handle
        // the invalid query.
        return sql;
      }
      return removeCommentsAndTrim(sql.substring(endStatementHintIndex + 1));
    }
    // Seems invalid, just return the original statement.
    return sql;
  }

  private boolean isReturning(String sql, int index) {
    return (index >= 1)
        && (index + 12 <= sql.length())
        && THEN_RETURN_PATTERN.matcher(sql.substring(index - 1, index + 12)).matches();
  }

  @InternalApi
  @Override
  protected boolean checkReturningClauseInternal(String rawSql) {
    Preconditions.checkNotNull(rawSql);
    String sql = rawSql.toLowerCase();
    // Do a pre-check to check if the SQL string definitely does not have a returning clause.
    // If this check fails, do a more involved check to check for a returning clause.
    if (!(sql.contains(THEN_STRING) && sql.contains(RETURN_STRING))) {
      return false;
    }
    sql = sql.replaceAll("\\s+", " ");
    final char SINGLE_QUOTE = '\'';
    final char DOUBLE_QUOTE = '"';
    final char BACKTICK_QUOTE = '`';
    boolean isInQuoted = false;
    char startQuote = 0;
    boolean lastCharWasEscapeChar = false;
    boolean isTripleQuoted = false;
    for (int index = 0; index < sql.length(); index++) {
      char c = sql.charAt(index);
      if (isInQuoted) {
        if (c == startQuote) {
          if (lastCharWasEscapeChar) {
            lastCharWasEscapeChar = false;
          } else if (isTripleQuoted) {
            if (sql.length() > index + 2
                && sql.charAt(index + 1) == startQuote
                && sql.charAt(index + 2) == startQuote) {
              isInQuoted = false;
              startQuote = 0;
              isTripleQuoted = false;
            }
          } else {
            isInQuoted = false;
            startQuote = 0;
          }
        } else if (c == '\\') {
          lastCharWasEscapeChar = !lastCharWasEscapeChar;
        } else {
          lastCharWasEscapeChar = false;
        }
      } else {
        if (isReturning(sql, index)) {
          return true;
        } else {
          if (c == SINGLE_QUOTE || c == DOUBLE_QUOTE || c == BACKTICK_QUOTE) {
            isInQuoted = true;
            startQuote = c;
            // check whether it is a triple-quote
            if (sql.length() > index + 2
                && sql.charAt(index + 1) == startQuote
                && sql.charAt(index + 2) == startQuote) {
              isTripleQuoted = true;
            }
          }
        }
      }
    }
    return false;
  }
}
