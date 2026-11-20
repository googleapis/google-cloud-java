/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import javax.annotation.Nullable;

/**
 * Compiled SQL {@code LIKE} search pattern for JDBC {@code DatabaseMetaData} identifier filtering.
 *
 * <p>Supports {@code %} (zero or more characters), {@code _} (any single Unicode code point), and
 * {@code \} escape sequences ({@code \%}, {@code \_}, {@code \\}), using an iterative two-pointer
 * matcher with US-ASCII case-insensitive comparison.
 */
final class SqlLikePattern {
  // 8x BigQuery's 1,024-character dataset and table ID limit.
  static final int MAX_SQL_LIKE_PATTERN_LENGTH = 8192;

  private enum TokenKind {
    LITERAL,
    ANY_ONE,
    ANY_SEQ
  }

  private final TokenKind[] kinds;
  private final int[] literals;
  private final int[] minRemaining;

  private SqlLikePattern(TokenKind[] kinds, int[] literals, int[] minRemaining) {
    this.kinds = kinds;
    this.literals = literals;
    this.minRemaining = minRemaining;
  }

  static void validatePatternLength(@Nullable String sqlLikePattern) throws BigQueryJdbcException {
    if (sqlLikePattern != null && sqlLikePattern.length() > MAX_SQL_LIKE_PATTERN_LENGTH) {
      throw new BigQueryJdbcException(
          String.format(
              "Search pattern length (%d) exceeds maximum allowed length (%d).",
              sqlLikePattern.length(), MAX_SQL_LIKE_PATTERN_LENGTH));
    }
  }

  @Nullable
  static SqlLikePattern compile(@Nullable String sqlLikePattern) {
    if (sqlLikePattern == null) {
      return null;
    }

    int maxTokens = sqlLikePattern.length();
    TokenKind[] tmpKinds = new TokenKind[maxTokens];
    int[] tmpLiterals = new int[maxTokens];
    int count = 0;
    boolean escaped = false;

    for (int i = 0; i < sqlLikePattern.length(); ) {
      int cp = sqlLikePattern.codePointAt(i);
      i += Character.charCount(cp);

      if (!escaped && cp == '\\') {
        escaped = true;
        continue;
      }
      if (!escaped && cp == '%') {
        if (count == 0 || tmpKinds[count - 1] != TokenKind.ANY_SEQ) {
          tmpKinds[count] = TokenKind.ANY_SEQ;
          count++;
        }
      } else if (!escaped && cp == '_') {
        if (count > 0 && tmpKinds[count - 1] == TokenKind.ANY_SEQ) {
          tmpKinds[count - 1] = TokenKind.ANY_ONE;
          tmpKinds[count] = TokenKind.ANY_SEQ;
        } else {
          tmpKinds[count] = TokenKind.ANY_ONE;
        }
        count++;
      } else {
        tmpKinds[count] = TokenKind.LITERAL;
        tmpLiterals[count] = foldAsciiLower(cp);
        count++;
        escaped = false;
      }
    }

    if (escaped) {
      tmpKinds[count] = TokenKind.LITERAL;
      tmpLiterals[count] = '\\';
      count++;
    }

    TokenKind[] normalizedKinds = new TokenKind[count];
    int[] normalizedLiterals = new int[count];
    System.arraycopy(tmpKinds, 0, normalizedKinds, 0, count);
    System.arraycopy(tmpLiterals, 0, normalizedLiterals, 0, count);

    int[] minRemaining = new int[count + 1];
    for (int idx = count - 1; idx >= 0; idx--) {
      minRemaining[idx] =
          minRemaining[idx + 1] + (normalizedKinds[idx] == TokenKind.ANY_SEQ ? 0 : 1);
    }

    return new SqlLikePattern(normalizedKinds, normalizedLiterals, minRemaining);
  }

  /**
   * Returns the unescaped literal identifier if {@code sqlLikePattern} is non-null and contains no
   * unescaped {@code %} or {@code _} wildcards; returns {@code null} when listing and wildcard
   * matching is required.
   */
  @Nullable
  static String literalOrNull(@Nullable String sqlLikePattern) {
    if (sqlLikePattern == null) {
      return null;
    }
    StringBuilder unescaped = null;
    boolean escaped = false;
    for (int i = 0; i < sqlLikePattern.length(); i++) {
      char c = sqlLikePattern.charAt(i);
      if (!escaped && c == '\\') {
        if (unescaped == null) {
          unescaped = new StringBuilder(sqlLikePattern.length());
          unescaped.append(sqlLikePattern, 0, i);
        }
        escaped = true;
      } else if (!escaped && (c == '%' || c == '_')) {
        return null;
      } else {
        if (unescaped != null) {
          unescaped.append(c);
        }
        escaped = false;
      }
    }
    if (escaped) {
      unescaped.append('\\');
    }
    return (unescaped == null) ? sqlLikePattern : unescaped.toString();
  }

  boolean matches(@Nullable String input) {
    if (input == null || input.length() < this.minRemaining[0]) {
      return false;
    }

    int t = 0;
    int p = 0;
    int textLen = input.length();
    int patLen = this.kinds.length;
    boolean hasStar = false;
    int starIdx = 0;
    int matchTextIdx = 0;

    while (t < textLen) {
      if (p < patLen && this.kinds[p] == TokenKind.ANY_SEQ) {
        if (p == patLen - 1) {
          return true;
        }
        hasStar = true;
        starIdx = p;
        matchTextIdx = t;
        p++;
        continue;
      }
      if (p < patLen) {
        int cp = input.codePointAt(t);
        if (this.kinds[p] == TokenKind.ANY_ONE || this.literals[p] == foldAsciiLower(cp)) {
          p++;
          t += Character.charCount(cp);
          continue;
        }
      }
      if (!hasStar) {
        return false;
      }
      p = starIdx + 1;
      int skippedCp = input.codePointAt(matchTextIdx);
      matchTextIdx += Character.charCount(skippedCp);
      if (textLen - matchTextIdx < this.minRemaining[p]) {
        return false;
      }
      t = matchTextIdx;
    }

    while (p < patLen && this.kinds[p] == TokenKind.ANY_SEQ) {
      p++;
    }
    return p == patLen;
  }

  private static int foldAsciiLower(int codePoint) {
    if (codePoint >= 'A' && codePoint <= 'Z') {
      return codePoint + ('a' - 'A');
    }
    return codePoint;
  }
}
