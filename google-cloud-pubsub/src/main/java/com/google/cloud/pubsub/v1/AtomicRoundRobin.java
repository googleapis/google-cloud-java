/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.pubsub.v1;

import com.google.api.core.InternalApi;
import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicInteger;

/** Provides a simplistic round robin, guarding for overflow. */
class AtomicRoundRobin {
  private final int max;
  private final AtomicInteger current;

  AtomicRoundRobin(int max) {
    Preconditions.checkArgument(max > 0);
    this.max = max;
    current = new AtomicInteger(0);
  }

  int next() {
    int next = current.getAndIncrement() % max;
    if (next < 0) {
      next += max;
    }
    return next;
  }

  @InternalApi
  void set(int i) {
    current.set(i);
  }
}
