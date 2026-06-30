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

package com.google.cloud.storage;

import com.google.common.base.MoreObjects;
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A simple moving window implementation which will keep a {@code window}s worth of Throughput
 * values and allow querying for the aggregate avg over that time window.
 */
final class ThroughputMovingWindow {

  private final Duration window;

  private final PriorityQueue<Entry> values;

  private ThroughputMovingWindow(Duration window) {
    this.window = window;
    this.values = new PriorityQueue<>(Entry.COMP);
  }

  void add(Instant now, Throughput value) {
    removeExpiredEntries(now);
    values.add(new Entry(now, value));
  }

  Throughput avg(Instant now) {
    removeExpiredEntries(now);
    return values.stream()
        .map(Entry::getValue)
        .reduce(
            Throughput.zero(),
            (tp1, tp2) -> Throughput.of(tp1.getNumBytes() + tp2.getNumBytes(), window));
  }

  private void removeExpiredEntries(Instant now) {
    Instant newMin = now.minus(window);
    values.removeIf(e -> lteq(e.getAt(), newMin));
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("window", window)
        .add("values.size()", values.size())
        .toString();
  }

  static ThroughputMovingWindow of(Duration window) {
    return new ThroughputMovingWindow(window);
  }

  private static boolean lteq(Instant a, Instant b) {
    return a.equals(b) || a.isBefore(b);
  }

  private static final class Entry {
    private static final Comparator<Entry> COMP = Comparator.comparing(e -> e.at);
    private final Instant at;
    private final Throughput value;

    private Entry(Instant at, Throughput value) {
      this.at = at;
      this.value = value;
    }

    public Instant getAt() {
      return at;
    }

    public Throughput getValue() {
      return value;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("at", at).add("value", value).toString();
    }
  }
}
