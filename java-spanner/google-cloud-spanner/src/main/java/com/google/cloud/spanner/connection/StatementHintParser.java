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

import com.google.cloud.Tuple;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Options.ReadQueryUpdateTransactionOption;
import com.google.cloud.spanner.Options.RpcPriority;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.SimpleParser.Result;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.spanner.v1.RequestOptions.Priority;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/** A simple parser for extracting statement hints from SQL strings. */
class StatementHintParser {
  private static final char[] GOOGLE_SQL_START_HINT_TOKENS = new char[] {'@', '{'};
  private static final char[] POSTGRESQL_START_HINT_TOKENS = new char[] {'/', '*', '@'};
  private static final char[] GOOGLE_SQL_END_HINT_TOKENS = new char[] {'}'};
  private static final char[] POSTGRESQL_END_HINT_TOKENS = new char[] {'*', '/'};
  private static final String STATEMENT_TAG_HINT_NAME = "STATEMENT_TAG";
  private static final String RPC_PRIORITY_HINT_NAME = "RPC_PRIORITY";
  private static final ImmutableSet<String> CLIENT_SIDE_STATEMENT_HINT_NAMES =
      ImmutableSet.of(STATEMENT_TAG_HINT_NAME, RPC_PRIORITY_HINT_NAME);

  static final Map<String, String> NO_HINTS = ImmutableMap.of();

  private final boolean hasStatementHints;

  private final Map<String, String> hints;

  private final String sqlWithoutClientSideHints;

  StatementHintParser(Dialect dialect, String sql) {
    this(CLIENT_SIDE_STATEMENT_HINT_NAMES, dialect, sql);
  }

  StatementHintParser(
      ImmutableSet<String> clientSideStatementHintNames, Dialect dialect, String sql) {
    SimpleParser parser =
        new SimpleParser(
            dialect,
            sql,
            /* pos= */ 0,
            /* treatHintCommentsAsTokens= */ dialect == Dialect.POSTGRESQL);
    this.hasStatementHints = parser.peekTokens(getStartHintTokens(dialect));
    if (this.hasStatementHints) {
      Tuple<String, Map<String, String>> hints = extract(parser, clientSideStatementHintNames);
      this.sqlWithoutClientSideHints = hints.x();
      this.hints = hints.y();
    } else {
      this.sqlWithoutClientSideHints = sql;
      this.hints = NO_HINTS;
    }
  }

  private static char[] getStartHintTokens(Dialect dialect) {
    switch (dialect) {
      case POSTGRESQL:
        return POSTGRESQL_START_HINT_TOKENS;
      case GOOGLE_STANDARD_SQL:
      default:
        return GOOGLE_SQL_START_HINT_TOKENS;
    }
  }

  private static char[] getEndHintTokens(Dialect dialect) {
    switch (dialect) {
      case POSTGRESQL:
        return POSTGRESQL_END_HINT_TOKENS;
      case GOOGLE_STANDARD_SQL:
      default:
        return GOOGLE_SQL_END_HINT_TOKENS;
    }
  }

  /**
   * Extracts any query/update options from client-side hints in the given statement. Currently,
   * this method supports following client-side hints:
   *
   * <ul>
   *   <li>STATEMENT_TAG
   *   <li>RPC_PRIORITY
   * </ul>
   */
  static ReadQueryUpdateTransactionOption[] convertHintsToOptions(Map<String, String> hints) {
    ReadQueryUpdateTransactionOption[] result = new ReadQueryUpdateTransactionOption[hints.size()];
    int index = 0;
    for (Entry<String, String> hint : hints.entrySet()) {
      result[index++] = convertHintToOption(hint.getKey(), hint.getValue());
    }
    return result;
  }

  private static ReadQueryUpdateTransactionOption convertHintToOption(String hint, String value) {
    Preconditions.checkNotNull(value);
    switch (Preconditions.checkNotNull(hint).toUpperCase(Locale.ENGLISH)) {
      case STATEMENT_TAG_HINT_NAME:
        return Options.tag(value);
      case RPC_PRIORITY_HINT_NAME:
        try {
          Priority priority = Priority.valueOf(value);
          return Options.priority(RpcPriority.fromProto(priority));
        } catch (IllegalArgumentException illegalArgumentException) {
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.INVALID_ARGUMENT,
              "Invalid RPC priority value: " + value,
              illegalArgumentException);
        }
      default:
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Invalid hint name: " + hint);
    }
  }

  boolean hasStatementHints() {
    return this.hasStatementHints;
  }

  String getSqlWithoutClientSideHints() {
    return this.sqlWithoutClientSideHints;
  }

  Map<String, String> getClientSideStatementHints() {
    return this.hints;
  }

  private static Tuple<String, Map<String, String>> extract(
      SimpleParser parser, ImmutableSet<String> clientSideStatementHintNames) {
    String updatedSql = parser.getSql();
    int posBeforeHintToken = parser.getPos();
    int removedHintsLength = 0;
    boolean allClientSideHints = true;
    // This method is only called if the parser has hints, so it is safe to ignore this result.
    parser.eatTokens(getStartHintTokens(parser.getDialect()));
    ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
    while (parser.hasMoreTokens()) {
      int posBeforeHint = parser.getPos();
      boolean foundClientSideHint = false;
      Result hintName = parser.eatIdentifier();
      if (!hintName.isValid()) {
        return Tuple.of(parser.getSql(), NO_HINTS);
      }
      if (!parser.eatToken('=')) {
        return Tuple.of(parser.getSql(), NO_HINTS);
      }
      Result hintValue = eatHintLiteral(parser);
      if (!hintValue.isValid()) {
        return Tuple.of(parser.getSql(), NO_HINTS);
      }
      if (clientSideStatementHintNames.contains(hintName.getValue().toUpperCase(Locale.ENGLISH))) {
        builder.put(hintName.getValue(), hintValue.getValue());
        foundClientSideHint = true;
      } else {
        allClientSideHints = false;
      }
      boolean endOfHints = parser.peekTokens(getEndHintTokens(parser.getDialect()));
      if (!endOfHints && !parser.eatToken(',')) {
        return Tuple.of(parser.getSql(), NO_HINTS);
      }
      if (foundClientSideHint) {
        // Remove the client-side hint from the SQL string that is sent to Spanner.
        updatedSql =
            updatedSql.substring(0, posBeforeHint - removedHintsLength)
                + parser.getSql().substring(parser.getPos());
        removedHintsLength += parser.getPos() - posBeforeHint;
      }
      if (endOfHints) {
        break;
      }
    }
    if (!parser.eatTokens(getEndHintTokens(parser.getDialect()))) {
      return Tuple.of(parser.getSql(), NO_HINTS);
    }
    if (allClientSideHints) {
      // Only client-side hints found. Remove the entire hint block.
      updatedSql =
          parser.getSql().substring(0, posBeforeHintToken)
              + parser.getSql().substring(parser.getPos());
    }
    return Tuple.of(updatedSql, builder.build());
  }

  /** Eats a hint literal. This is a literal that could be a quoted string, or an identifier. */
  private static Result eatHintLiteral(SimpleParser parser) {
    if (parser.peekToken('\'')) {
      return parser.eatSingleQuotedString();
    }
    return parser.eatIdentifier();
  }
}
