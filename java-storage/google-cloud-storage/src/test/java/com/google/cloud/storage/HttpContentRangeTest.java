/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storage;

import static com.google.cloud.storage.HttpContentRange.parse;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import java.util.Locale;
import java.util.Locale.Category;
import org.junit.Test;

public final class HttpContentRangeTest {

  @Test
  public void localeDoesNotImpactThings() throws Exception {
    // can fail on java11+
    // https://docs.oracle.com/javase/tutorial/i18n/locale/scope.html
    Locale before = Locale.getDefault(Category.FORMAT);
    try {
      // arabic local, also RTL instead of LTR
      Locale ar = Locale.forLanguageTag("ar");
      Locale.setDefault(Category.FORMAT, ar);
      assertAll(
          () -> assertThat(parse("bytes 0-9/9").getHeaderValue()).isEqualTo("bytes 0-9/9"),
          () -> assertThat(parse("bytes 0-9/*").getHeaderValue()).isEqualTo("bytes 0-9/*"),
          () -> assertThat(parse("bytes */9").getHeaderValue()).isEqualTo("bytes */9"),
          () -> assertThat(parse("bytes */*").getHeaderValue()).isEqualTo("bytes */*"));
    } finally {
      Locale.setDefault(Category.FORMAT, before);
      assertThat(Locale.getDefault(Category.FORMAT)).isEqualTo(before);
    }
  }
}
