/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.storage.v1beta2;

import com.google.api.core.ApiClock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/** A Clock to help with testing time-based logic. */
public class FakeClock implements ApiClock {

  private final AtomicLong millis = new AtomicLong();

  // Advances the clock value by {@code time} in {@code timeUnit}.
  public void advance(long time, TimeUnit timeUnit) {
    millis.addAndGet(timeUnit.toMillis(time));
  }

  @Override
  public long nanoTime() {
    return millisTime() * 1000_000L;
  }

  @Override
  public long millisTime() {
    return millis.get();
  }
}
