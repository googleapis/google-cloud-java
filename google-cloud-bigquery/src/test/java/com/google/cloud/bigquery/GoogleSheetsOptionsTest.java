/*
 * Copyright 2018 Google LLC
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

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class GoogleSheetsOptionsTest {

  private static final long SKIP_LEADING_ROWS = 42L;
  private static final GoogleSheetsOptions GOOGLE_SHEETS_OPTIONS = GoogleSheetsOptions.newBuilder()
      .setSkipLeadingRows(SKIP_LEADING_ROWS)
      .build();

  @Test
  public void testToBuilder() {
    compareGoogleSheetsOptions(GOOGLE_SHEETS_OPTIONS, GOOGLE_SHEETS_OPTIONS.toBuilder().build());
    GoogleSheetsOptions googleSheetsOptions = GOOGLE_SHEETS_OPTIONS.toBuilder()
        .setSkipLeadingRows(123)
        .build();
    assertThat(googleSheetsOptions.getSkipLeadingRows()).isEqualTo(123);
    googleSheetsOptions = googleSheetsOptions.toBuilder().setSkipLeadingRows(SKIP_LEADING_ROWS).build();
    compareGoogleSheetsOptions(GOOGLE_SHEETS_OPTIONS, googleSheetsOptions);
  }

  @Test
  public void testToBuilderIncomplete() {
    GoogleSheetsOptions googleSheetsOptions = GoogleSheetsOptions.newBuilder().build();
    assertThat(googleSheetsOptions.toBuilder().build()).isEqualTo(googleSheetsOptions);
  }

  @Test
  public void testBuilder() {
    assertThat(GOOGLE_SHEETS_OPTIONS.getType()).isEqualTo(FormatOptions.GOOGLE_SHEETS);
    assertThat(GOOGLE_SHEETS_OPTIONS.getSkipLeadingRows()).isEqualTo(SKIP_LEADING_ROWS);
  }


  @Test
  public void testToAndFromPb() {
    compareGoogleSheetsOptions(GOOGLE_SHEETS_OPTIONS, GoogleSheetsOptions.fromPb(GOOGLE_SHEETS_OPTIONS.toPb()));
    GoogleSheetsOptions googleSheetsOptions = GoogleSheetsOptions.newBuilder().build();
    compareGoogleSheetsOptions(googleSheetsOptions, GoogleSheetsOptions.fromPb(googleSheetsOptions.toPb()));
  }

  private void compareGoogleSheetsOptions(GoogleSheetsOptions expected, GoogleSheetsOptions value) {
    assertThat(value).isEqualTo(expected);
    assertThat(value.getSkipLeadingRows()).isEqualTo(expected.getSkipLeadingRows());
  }
}
