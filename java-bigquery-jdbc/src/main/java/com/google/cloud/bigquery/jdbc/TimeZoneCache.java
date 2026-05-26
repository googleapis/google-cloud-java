/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.api.core.InternalApi;
import java.util.TimeZone;

@InternalApi
public class TimeZoneCache {
  private static volatile TimeZone defaultTimeZone = TimeZone.getDefault();

  public static void reset() {
    defaultTimeZone = TimeZone.getDefault();
  }

  public static long getLocalMillis(long millisOfDay) {
    return millisOfDay - defaultTimeZone.getOffset(millisOfDay);
  }

  public static int getOffset(long millis) {
    return defaultTimeZone.getOffset(millis);
  }
}
