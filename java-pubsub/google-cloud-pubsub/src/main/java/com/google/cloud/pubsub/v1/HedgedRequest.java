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

package com.google.cloud.pubsub.v1;

/**
 * Represents a pending hedging check in the publisher's queue.
 */
class HedgedRequest {
  private final CancellationSharer coordinator;
  private final int attemptNumber;
  private final long sendAfterMs;

  HedgedRequest(CancellationSharer coordinator, int attemptNumber, long sendAfterMs) {
    this.coordinator = coordinator;
    this.attemptNumber = attemptNumber;
    this.sendAfterMs = sendAfterMs;
  }

  CancellationSharer getCoordinator() {
    return coordinator;
  }

  int getAttemptNumber() {
    return attemptNumber;
  }

  long getSendAfterMs() {
    return sendAfterMs;
  }
}
