/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.datastore;

import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Map;

/**
 * Specifies options for read operations in Datastore, namely getting/fetching entities and running
 * queries.
 */
public abstract class ReadOption implements Serializable {

  private static final long serialVersionUID = -4406964829189800528L;

  /**
   * Specifies eventual consistency for reads from Datastore. Lookups and ancestor queries using
   * this option permit Datastore to return stale results.
   */
  public static final class EventualConsistency extends ReadOption {

    private static final long serialVersionUID = -6959530217724666172L;

    private final boolean eventualConsistency;

    private EventualConsistency(boolean eventualConsistency) {
      this.eventualConsistency = eventualConsistency;
    }

    public boolean isEventual() {
      return eventualConsistency;
    }
  }

  private ReadOption() {}

  /**
   * Returns a {@code ReadOption} that specifies eventual consistency, allowing Datastore to return
   * stale results from gets, fetches, and ancestor queries.
   */
  public static EventualConsistency eventualConsistency() {
    return new EventualConsistency(true);
  }

  static Map<Class<? extends ReadOption>, ReadOption> asImmutableMap(ReadOption... options) {
    ImmutableMap.Builder<Class<? extends ReadOption>, ReadOption> builder = ImmutableMap.builder();
    for (ReadOption option : options) {
      builder.put(option.getClass(), option);
    }
    return builder.build();
  }
}
