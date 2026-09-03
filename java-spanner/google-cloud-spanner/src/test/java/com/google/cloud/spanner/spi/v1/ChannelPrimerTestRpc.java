/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.spi.v1.DynamicChannelPoolPrimer.PrimeSession;
import com.google.spanner.v1.Session;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/**
 * A {@link GapicSpannerRpc} for tests outside this package that need to observe the prime sessions
 * and prime owners of the dynamic channel pool primer and to hook into the retirement of a database
 * client.
 */
public class ChannelPrimerTestRpc extends GapicSpannerRpc {
  private final AtomicInteger completedMultiplexedCreateSessions = new AtomicInteger();
  private volatile Runnable afterUnregisterHook = () -> {};

  public ChannelPrimerTestRpc(SpannerOptions options) {
    super(options);
  }

  /** Sets a hook that runs right after a database client has been unregistered as prime owner. */
  public void setAfterUnregisterHook(Runnable hook) {
    this.afterUnregisterHook = hook;
  }

  /** Returns the number of multiplexed CreateSession calls that have returned, with any outcome. */
  public int getCompletedMultiplexedCreateSessions() {
    return completedMultiplexedCreateSessions.get();
  }

  /** Returns the session that the next priming attempt uses, or {@code null}. */
  @Nullable
  public String getPrimeSessionName() {
    DynamicChannelPoolPrimer primer = getChannelPrimer();
    return primer == null ? null : primer.getPrimeSessionName();
  }

  /** Returns the names of all registered prime sessions, most recently created first. */
  public List<String> getPrimeSessionNames() {
    List<String> names = new ArrayList<>();
    DynamicChannelPoolPrimer primer = getChannelPrimer();
    if (primer != null) {
      for (PrimeSession entry : primer.getPrimeSessions()) {
        names.add(entry.getSessionName());
      }
    }
    return names;
  }

  @Override
  public Session createSession(
      String databaseName,
      @Nullable String databaseRole,
      @Nullable Map<String, String> labels,
      @Nullable Map<Option, ?> options,
      boolean isMultiplexed) {
    try {
      return super.createSession(databaseName, databaseRole, labels, options, isMultiplexed);
    } finally {
      if (isMultiplexed) {
        completedMultiplexedCreateSessions.incrementAndGet();
      }
    }
  }

  /** Returns the names of the databases that currently have a registered prime owner. */
  public Set<String> getPrimeOwnerDatabases() {
    DynamicChannelPoolPrimer primer = getChannelPrimer();
    return primer == null ? Collections.emptySet() : primer.getPrimeOwners().keySet();
  }

  @Override
  public void unregisterChannelPrimeOwner(String databaseName, long ownerTicket) {
    super.unregisterChannelPrimeOwner(databaseName, ownerTicket);
    afterUnregisterHook.run();
  }
}
