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

package com.google.cloud.bigtable.data.v2.internal.session;

import com.google.cloud.bigtable.data.v2.internal.session.SessionList.AfeHandle;
import com.google.cloud.bigtable.data.v2.internal.session.SessionList.SessionHandle;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/** Pick the AFE with the fewest in-flight requests. Experimental for now. */
class LeastInFlightPicker extends Picker {
  private final SessionList sessionList;

  public LeastInFlightPicker(SessionList sessionList) {
    this.sessionList = sessionList;
  }

  @Override
  Optional<SessionHandle> pickSession() {
    List<AfeHandle> readyAfes = sessionList.getAfesWithReadySessions();
    int size = readyAfes.size();

    if (size == 0) {
      return Optional.empty();
    }

    ThreadLocalRandom random = ThreadLocalRandom.current();
    AfeHandle selected = readyAfes.get(random.nextInt(size));

    // If we have options, pick a second candidate and keep the better one
    if (size > 1) {
      AfeHandle candidate2 = readyAfes.get(random.nextInt(size));
      if (candidate2.getNumOutstanding() < selected.getNumOutstanding()) {
        selected = candidate2;
      }
    }

    return sessionList.checkoutSession(selected);
  }
}
