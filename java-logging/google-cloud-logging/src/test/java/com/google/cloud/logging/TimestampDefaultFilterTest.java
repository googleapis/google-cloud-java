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

package com.google.cloud.logging;

import static com.google.common.truth.Truth.assertThat;
import static java.time.ZoneOffset.UTC;
import static java.util.Locale.US;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TimestampDefaultFilterTest {

  @Test
  public void DefaultTimestampFilterTest() {
    ITimestampDefaultFilter filter = new TimestampDefaultFilter();

    // Timestamp filter exists
    String defaultFilter = filter.createDefaultTimestampFilter();
    assertThat(defaultFilter).contains("timestamp>=");

    // Time is last 24 hours
    DateTimeFormatter rfcDateFormat =
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", US);
    LocalDateTime actual =
        LocalDateTime.parse(defaultFilter.substring(12, defaultFilter.length() - 1), rfcDateFormat);
    assertThat(
            Duration.between(actual, LocalDateTime.now(UTC))
                .minus(Duration.ofDays(1))
                .abs()
                .compareTo(Duration.ofMinutes(1)))
        .isLessThan(0);
  }
}
