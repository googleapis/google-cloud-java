/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.spanner;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Class which allows to mock {@link Clock} in unit tests and return custom time values within the
 * tests.
 */
class FakeClock extends Clock {
  final AtomicLong currentTimeMillis = new AtomicLong();

  @Override
  public Instant instant() {
    return Instant.ofEpochMilli(currentTimeMillis.get());
  }
}
