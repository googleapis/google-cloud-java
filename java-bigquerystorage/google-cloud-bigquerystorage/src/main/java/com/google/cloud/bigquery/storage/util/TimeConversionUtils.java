/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.storage.util;

import com.google.api.core.InternalApi;

/**
 * Convenience methods for conversions between {@link java.time} and {@link org.threeten.bp}
 * objects. This will be kept until <a
 * href="https://github.com/googleapis/sdk-platform-java/issues/3412">this issue</a> is solved.
 */
@InternalApi("https://github.com/googleapis/sdk-platform-java/issues/3412")
public class TimeConversionUtils {
  public static java.time.LocalDateTime toJavaTimeLocalDateTime(
      org.threeten.bp.LocalDateTime result) {
    return java.time.LocalDateTime.of(
        result.getYear(),
        java.time.Month.of(result.getMonth().getValue()),
        result.getDayOfMonth(),
        result.getHour(),
        result.getMinute(),
        result.getSecond(),
        result.getNano());
  }

  public static org.threeten.bp.LocalDateTime toThreetenLocalDateTime(
      java.time.LocalDateTime result) {
    return org.threeten.bp.LocalDateTime.of(
        result.getYear(),
        org.threeten.bp.Month.of(result.getMonth().getValue()),
        result.getDayOfMonth(),
        result.getHour(),
        result.getMinute(),
        result.getSecond(),
        result.getNano());
  }

  public static java.time.LocalTime toJavaTimeLocalTime(org.threeten.bp.LocalTime result) {
    return java.time.LocalTime.of(
        result.getHour(), result.getMinute(), result.getSecond(), result.getNano());
  }

  public static org.threeten.bp.LocalTime toThreetenLocalTime(java.time.LocalTime result) {
    return org.threeten.bp.LocalTime.of(
        result.getHour(), result.getMinute(), result.getSecond(), result.getNano());
  }
}
