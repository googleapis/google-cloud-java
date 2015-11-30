/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CsvOptionsTest {

  private static final Boolean ALLOW_JAGGED_ROWS = true;
  private static final Boolean ALLOW_QUOTED_NEWLINE = true;
  private static final String ENCODING = "UTF_8";
  private static final String FIELD_DELIMITER = ",";
  private static final String QUOTE = "\"";
  private static final Integer SKIP_LEADING_ROWS = 42;
  private static final CsvOptions CSV_OPTIONS = CsvOptions.builder()
      .allowJaggedRows(ALLOW_JAGGED_ROWS)
      .allowQuotedNewLines(ALLOW_QUOTED_NEWLINE)
      .encoding(ENCODING)
      .fieldDelimiter(FIELD_DELIMITER)
      .quote(QUOTE)
      .skipLeadingRows(SKIP_LEADING_ROWS)
      .build();

  @Test
  public void testToBuilder() {
    compareCsvOptions(CSV_OPTIONS, CSV_OPTIONS.toBuilder().build());
    CsvOptions csvOptions = CSV_OPTIONS.toBuilder()
        .fieldDelimiter(";")
        .build();
    assertEquals(";", csvOptions.fieldDelimiter());
    csvOptions = csvOptions.toBuilder().fieldDelimiter(",").build();
    compareCsvOptions(CSV_OPTIONS, csvOptions);
  }

  @Test
  public void testToBuilderIncomplete() {
    CsvOptions csvOptions = CsvOptions.builder().fieldDelimiter("|").build();
    assertEquals(csvOptions, csvOptions.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(ALLOW_JAGGED_ROWS, CSV_OPTIONS.allowJaggedRows());
    assertEquals(ALLOW_QUOTED_NEWLINE, CSV_OPTIONS.allowQuotedNewLines());
    assertEquals(ENCODING, CSV_OPTIONS.encoding());
    assertEquals(FIELD_DELIMITER, CSV_OPTIONS.fieldDelimiter());
    assertEquals(QUOTE, CSV_OPTIONS.quote());
    assertEquals(SKIP_LEADING_ROWS, CSV_OPTIONS.skipLeadingRows());
  }

  @Test
  public void testToAndFromPb() {
    compareCsvOptions(CSV_OPTIONS, CsvOptions.fromPb(CSV_OPTIONS.toPb()));
    CsvOptions csvOptions = CsvOptions.builder().allowJaggedRows(ALLOW_JAGGED_ROWS).build();
    compareCsvOptions(csvOptions, CsvOptions.fromPb(csvOptions.toPb()));
  }

  private void compareCsvOptions(CsvOptions expected, CsvOptions value) {
    assertEquals(expected, value);
    assertEquals(expected.allowJaggedRows(), value.allowJaggedRows());
    assertEquals(expected.allowQuotedNewLines(), value.allowQuotedNewLines());
    assertEquals(expected.encoding(), value.encoding());
    assertEquals(expected.fieldDelimiter(), value.fieldDelimiter());
    assertEquals(expected.quote(), value.quote());
    assertEquals(expected.skipLeadingRows(), value.skipLeadingRows());
  }
}
