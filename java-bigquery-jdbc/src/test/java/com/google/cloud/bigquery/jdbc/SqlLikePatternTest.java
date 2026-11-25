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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import java.time.Duration;
import java.util.Collections;
import java.util.Locale;
import org.junit.jupiter.api.Test;

class SqlLikePatternTest {

  private static String repeatChar(char c, int count) {
    return String.join("", Collections.nCopies(count, String.valueOf(c)));
  }

  @Test
  void testCompileNullEmptyAndExact() throws BigQueryJdbcException {
    assertNull(SqlLikePattern.compile(null));

    SqlLikePattern empty = SqlLikePattern.compile("");
    assertNotNull(empty);
    assertFalse(empty.matches(null));
    assertTrue(empty.matches(""));
    assertFalse(empty.matches("a"));

    SqlLikePattern exact = SqlLikePattern.compile("tableName");
    assertNotNull(exact);
    assertTrue(exact.matches("tableName"));
    assertTrue(exact.matches("TABLENAME"));
    assertFalse(exact.matches("tableNameX"));
    assertFalse(exact.matches("XtableName"));
  }

  @Test
  void testMatchesNullInput() throws BigQueryJdbcException {
    SqlLikePattern matchAll = SqlLikePattern.compile("%");
    assertNotNull(matchAll);
    assertFalse(matchAll.matches(null));
    assertTrue(matchAll.matches(""));
    assertTrue(matchAll.matches("any_table_name"));
  }

  @Test
  void testPercentUnderscoreAndMixedWildcards() throws BigQueryJdbcException {
    SqlLikePattern prefixPercent = SqlLikePattern.compile("table%");
    assertTrue(prefixPercent.matches("table"));
    assertTrue(prefixPercent.matches("tableName"));
    assertTrue(prefixPercent.matches("TABLE_123"));
    assertFalse(prefixPercent.matches("myTable"));

    SqlLikePattern leadingPercent = SqlLikePattern.compile("%Name");
    assertTrue(leadingPercent.matches("Name"));
    assertTrue(leadingPercent.matches("tableName"));
    assertTrue(leadingPercent.matches("VIEW_NAME"));
    assertFalse(leadingPercent.matches("NameSuffix"));

    SqlLikePattern middlePercent = SqlLikePattern.compile("ta%le");
    assertTrue(middlePercent.matches("table"));
    assertTrue(middlePercent.matches("TALLE"));
    assertTrue(middlePercent.matches("tale"));
    assertFalse(middlePercent.matches("table123"));

    SqlLikePattern singleUnderscore = SqlLikePattern.compile("t_ble");
    assertTrue(singleUnderscore.matches("table"));
    assertTrue(singleUnderscore.matches("tAble"));
    assertTrue(singleUnderscore.matches("tXble"));
    assertFalse(singleUnderscore.matches("tble"));
    assertFalse(singleUnderscore.matches("taable"));

    SqlLikePattern mixedPattern = SqlLikePattern.compile("data_%_set%");
    assertTrue(mixedPattern.matches("data_1_set"));
    assertTrue(mixedPattern.matches("data_foo_set_bar"));
    assertTrue(mixedPattern.matches("DATA_X_SET"));
    assertFalse(mixedPattern.matches("dataset"));
    assertFalse(mixedPattern.matches("data_set"));

    SqlLikePattern consecutivePercents = SqlLikePattern.compile("a%%%%b%%%c");
    assertTrue(consecutivePercents.matches("abc"));
    assertTrue(consecutivePercents.matches("a_123_b_456_c"));
    assertFalse(consecutivePercents.matches("ab"));
    assertFalse(consecutivePercents.matches("abcd"));

    SqlLikePattern percentUnderscoreChain = SqlLikePattern.compile("%_%_%");
    assertFalse(percentUnderscoreChain.matches(""));
    assertFalse(percentUnderscoreChain.matches("a"));
    assertTrue(percentUnderscoreChain.matches("ab"));
    assertTrue(percentUnderscoreChain.matches("abcdef"));

    SqlLikePattern trailingWildcards = SqlLikePattern.compile("prefix%%%");
    assertTrue(trailingWildcards.matches("prefix"));
    assertTrue(trailingWildcards.matches("prefix_suffix"));
    assertFalse(trailingWildcards.matches("prefi"));

    SqlLikePattern exactUnderscores = SqlLikePattern.compile("___");
    assertFalse(exactUnderscores.matches("ab"));
    assertTrue(exactUnderscores.matches("abc"));
    assertFalse(exactUnderscores.matches("abcd"));
  }

  @Test
  void testEscapesRegexMetacharactersAndTrailingBackslash() throws BigQueryJdbcException {
    SqlLikePattern dotPattern = SqlLikePattern.compile("version_1.0");
    assertTrue(dotPattern.matches("version_1.0"));
    assertFalse(dotPattern.matches("version_1X0"));

    SqlLikePattern bracketPattern = SqlLikePattern.compile("array[0]");
    assertTrue(bracketPattern.matches("array[0]"));
    assertFalse(bracketPattern.matches("array_0_"));

    SqlLikePattern regexMetacharacters = SqlLikePattern.compile("v1.0+[0](a|b)^$");
    assertTrue(regexMetacharacters.matches("v1.0+[0](a|b)^$"));
    assertFalse(regexMetacharacters.matches("v1X0+[0](a|b)^$"));

    SqlLikePattern escapedUnderscore = SqlLikePattern.compile("test\\_table");
    assertTrue(escapedUnderscore.matches("test_table"));
    assertFalse(escapedUnderscore.matches("test1table"));

    SqlLikePattern escapedPercent = SqlLikePattern.compile("100\\%discount");
    assertTrue(escapedPercent.matches("100%discount"));
    assertFalse(escapedPercent.matches("100PERCENTdiscount"));

    SqlLikePattern escapedBackslashBeforeWildcard = SqlLikePattern.compile("dir\\\\_file");
    assertTrue(escapedBackslashBeforeWildcard.matches("dir\\Xfile"));
    assertTrue(escapedBackslashBeforeWildcard.matches("dir\\_file"));
    assertFalse(escapedBackslashBeforeWildcard.matches("dir\\file"));

    SqlLikePattern escapedBackslashAndEscapedPercent = SqlLikePattern.compile("a\\\\\\%b");
    assertTrue(escapedBackslashAndEscapedPercent.matches("a\\%b"));
    assertFalse(escapedBackslashAndEscapedPercent.matches("a\\XYZb"));

    SqlLikePattern escapedTrailingBackslash = SqlLikePattern.compile("test\\\\");
    assertTrue(escapedTrailingBackslash.matches("test\\"));
    assertFalse(escapedTrailingBackslash.matches("test"));

    assertThrows(BigQueryJdbcException.class, () -> SqlLikePattern.compile("\\"));
    assertThrows(BigQueryJdbcException.class, () -> SqlLikePattern.compile("test\\"));
    assertThrows(BigQueryJdbcException.class, () -> SqlLikePattern.compile("test\\\\\\"));
  }

  @Test
  void testAsciiOnlyCaseFoldingAndLocaleIndependence() throws BigQueryJdbcException {
    Locale previous = Locale.getDefault();
    try {
      Locale.setDefault(Locale.forLanguageTag("tr-TR"));
      SqlLikePattern turkishAscii = SqlLikePattern.compile("ID_COLUMN_%");
      assertTrue(turkishAscii.matches("id_column_1"));
      assertTrue(turkishAscii.matches("ID_COLUMN_1"));
    } finally {
      Locale.setDefault(previous);
    }

    SqlLikePattern nonAsciiExactCase = SqlLikePattern.compile("Übung_%");
    assertTrue(nonAsciiExactCase.matches("Übung_1"));
    assertFalse(nonAsciiExactCase.matches("übung_1"));
  }

  @Test
  void testSupplementaryUnicodeCodePoints() throws BigQueryJdbcException {
    String emoji = "\uD83D\uDE00"; // U+1F600 (1 Unicode code point, 2 UTF-16 chars)
    SqlLikePattern singleUnderscore = SqlLikePattern.compile("tbl_end");
    assertTrue(singleUnderscore.matches("tbl" + emoji + "end"));

    SqlLikePattern twoUnderscores = SqlLikePattern.compile("tbl__end");
    assertFalse(twoUnderscores.matches("tbl" + emoji + "end"));

    SqlLikePattern wildcardSkipSurrogate = SqlLikePattern.compile("%end");
    assertTrue(wildcardSkipSurrogate.matches(emoji + emoji + "end"));
    assertFalse(wildcardSkipSurrogate.matches(emoji + emoji + "en"));
  }

  @Test
  void testLiteralOrNull() throws BigQueryJdbcException {
    assertNull(SqlLikePattern.literalOrNull(null));
    assertNull(SqlLikePattern.literalOrNull("%"));
    assertNull(SqlLikePattern.literalOrNull("_"));
    assertNull(SqlLikePattern.literalOrNull("abc%def"));
    assertNull(SqlLikePattern.literalOrNull("abc_def"));
    assertNull(SqlLikePattern.literalOrNull("a%c_d%f"));
    assertNull(SqlLikePattern.literalOrNull("a\\\\_b"));
    assertNull(SqlLikePattern.literalOrNull("my\\_dataset%"));

    assertEquals("", SqlLikePattern.literalOrNull(""));
    String plain = "exactName";
    assertSame(plain, SqlLikePattern.literalOrNull(plain));
    assertEquals("my_dataset", SqlLikePattern.literalOrNull("my\\_dataset"));
    assertEquals("100%discount", SqlLikePattern.literalOrNull("100\\%discount"));
    assertEquals("abc%_", SqlLikePattern.literalOrNull("abc\\%\\_"));
    assertEquals("a\\%b", SqlLikePattern.literalOrNull("a\\\\\\%b"));
    assertEquals("a\\b", SqlLikePattern.literalOrNull("a\\\\b"));
    assertEquals("trailing\\", SqlLikePattern.literalOrNull("trailing\\\\"));

    assertThrows(BigQueryJdbcException.class, () -> SqlLikePattern.literalOrNull("\\"));
    assertThrows(BigQueryJdbcException.class, () -> SqlLikePattern.literalOrNull("trailing\\"));
    assertThrows(BigQueryJdbcException.class, () -> SqlLikePattern.literalOrNull("trailing\\\\\\"));
    assertThrows(BigQueryJdbcException.class, () -> SqlLikePattern.literalOrNull("%\\"));
    assertThrows(BigQueryJdbcException.class, () -> SqlLikePattern.literalOrNull("_\\"));
    assertThrows(BigQueryJdbcException.class, () -> SqlLikePattern.literalOrNull("%ds\\"));
  }

  @Test
  void testValidatePatternLength() throws BigQueryJdbcException {
    String atLimitLiteral = repeatChar('a', SqlLikePattern.MAX_SQL_LIKE_PATTERN_LENGTH);
    assertEquals(atLimitLiteral, SqlLikePattern.literalOrNull(atLimitLiteral));
    assertNotNull(SqlLikePattern.compile(atLimitLiteral));

    String overLimitLiteral = repeatChar('a', SqlLikePattern.MAX_SQL_LIKE_PATTERN_LENGTH + 1);
    assertThrows(BigQueryJdbcException.class, () -> SqlLikePattern.literalOrNull(overLimitLiteral));
    assertThrows(BigQueryJdbcException.class, () -> SqlLikePattern.compile(overLimitLiteral));

    String overLimitWildcard = repeatChar('%', SqlLikePattern.MAX_SQL_LIKE_PATTERN_LENGTH + 1);
    assertThrows(
        BigQueryJdbcException.class, () -> SqlLikePattern.literalOrNull(overLimitWildcard));
    assertThrows(BigQueryJdbcException.class, () -> SqlLikePattern.compile(overLimitWildcard));
  }

  @Test
  void testMultiWildcardPatternsAgainstMaxLengthIdentifiers() {
    String maxIdentifier = repeatChar('a', 1024);
    String[] multiWildcardPatterns = {
      repeatChar('%', 60) + "!",
      String.join("", Collections.nCopies(40, "%_")) + "!",
      String.join("", Collections.nCopies(40, "%a")) + "!",
      "%" + repeatChar('a', 512) + "b"
    };

    assertTimeoutPreemptively(
        Duration.ofSeconds(10),
        () -> {
          for (String rawPattern : multiWildcardPatterns) {
            SqlLikePattern pattern = SqlLikePattern.compile(rawPattern);
            assertFalse(pattern.matches(maxIdentifier));
          }
        });
  }
}
