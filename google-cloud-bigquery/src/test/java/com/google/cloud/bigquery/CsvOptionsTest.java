/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.junit.Test;

public class CsvOptionsTest {

  private static final Boolean ALLOW_JAGGED_ROWS = true;
  private static final Boolean ALLOW_QUOTED_NEWLINE = true;
  private static final Charset ENCODING = StandardCharsets.UTF_8;
  private static final String FIELD_DELIMITER = ",";
  private static final String QUOTE = "\"";
  private static final long SKIP_LEADING_ROWS = 42L;

  private static final boolean PRESERVE_ASCII_CONTROL_CHARACTERS = true;
  private static final CsvOptions CSV_OPTIONS =
      CsvOptions.newBuilder()
          .setAllowJaggedRows(ALLOW_JAGGED_ROWS)
          .setAllowQuotedNewLines(ALLOW_QUOTED_NEWLINE)
          .setEncoding(ENCODING)
          .setFieldDelimiter(FIELD_DELIMITER)
          .setQuote(QUOTE)
          .setSkipLeadingRows(SKIP_LEADING_ROWS)
          .setPreserveAsciiControlCharacters(PRESERVE_ASCII_CONTROL_CHARACTERS)
          .build();

  @Test
  public void testToBuilder() {
    compareCsvOptions(CSV_OPTIONS, CSV_OPTIONS.toBuilder().build());
    CsvOptions csvOptions = CSV_OPTIONS.toBuilder().setFieldDelimiter(";").build();
    assertEquals(";", csvOptions.getFieldDelimiter());
    csvOptions = csvOptions.toBuilder().setFieldDelimiter(",").build();
    compareCsvOptions(CSV_OPTIONS, csvOptions);
  }

  @Test
  public void testToBuilderIncomplete() {
    CsvOptions csvOptions = CsvOptions.newBuilder().setFieldDelimiter("|").build();
    assertEquals(csvOptions, csvOptions.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(FormatOptions.CSV, CSV_OPTIONS.getType());
    assertEquals(ALLOW_JAGGED_ROWS, CSV_OPTIONS.allowJaggedRows());
    assertEquals(ALLOW_QUOTED_NEWLINE, CSV_OPTIONS.allowQuotedNewLines());
    assertEquals(ENCODING.name(), CSV_OPTIONS.getEncoding());
    assertEquals(FIELD_DELIMITER, CSV_OPTIONS.getFieldDelimiter());
    assertEquals(QUOTE, CSV_OPTIONS.getQuote());
    assertEquals(SKIP_LEADING_ROWS, (long) CSV_OPTIONS.getSkipLeadingRows());
    assertEquals(
        PRESERVE_ASCII_CONTROL_CHARACTERS, CSV_OPTIONS.getPreserveAsciiControlCharacters());
  }

  @Test
  public void testToAndFromPb() {
    compareCsvOptions(CSV_OPTIONS, CsvOptions.fromPb(CSV_OPTIONS.toPb()));
    CsvOptions csvOptions = CsvOptions.newBuilder().setAllowJaggedRows(ALLOW_JAGGED_ROWS).build();
    compareCsvOptions(csvOptions, CsvOptions.fromPb(csvOptions.toPb()));
  }

  private void compareCsvOptions(CsvOptions expected, CsvOptions value) {
    assertEquals(expected, value);
    assertEquals(expected.allowJaggedRows(), value.allowJaggedRows());
    assertEquals(expected.allowQuotedNewLines(), value.allowQuotedNewLines());
    assertEquals(expected.getEncoding(), value.getEncoding());
    assertEquals(expected.getFieldDelimiter(), value.getFieldDelimiter());
    assertEquals(expected.getQuote(), value.getQuote());
    assertEquals(expected.getSkipLeadingRows(), value.getSkipLeadingRows());
  }
}
