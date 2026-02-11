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

import static java.time.ZoneOffset.UTC;
import static java.util.Locale.US;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampDefaultFilter implements ITimestampDefaultFilter {
  @Override
  public String createDefaultTimestampFilter() {
    DateTimeFormatter rfcDateFormat =
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", US);
    return "timestamp>=\"" + rfcDateFormat.format(yesterday()) + "\"";
  }

  private LocalDateTime yesterday() {
    return LocalDateTime.now(UTC).minus(Duration.ofDays(1));
  }
}
