/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal.session.fake;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public class FakeClock extends Clock {

  private Instant time;

  public FakeClock(Instant time) {
    this.time = time;
  }

  public void increment(Duration delta) {
    this.time = time.plus(delta);
  }

  @Override
  public ZoneId getZone() {
    return null;
  }

  @Override
  public Clock withZone(ZoneId zone) {
    return null;
  }

  @Override
  public Instant instant() {
    return time;
  }
}
