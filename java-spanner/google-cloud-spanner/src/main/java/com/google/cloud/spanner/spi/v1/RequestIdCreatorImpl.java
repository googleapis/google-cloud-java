/*
 * Copyright 2025 Google LLC
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

import com.google.cloud.spanner.XGoogSpannerRequestId;
import com.google.cloud.spanner.XGoogSpannerRequestId.RequestIdCreator;
import java.util.concurrent.atomic.AtomicLong;

class RequestIdCreatorImpl implements RequestIdCreator {
  private static final AtomicLong NEXT_CLIENT_ID = new AtomicLong();

  private final long clientId = NEXT_CLIENT_ID.incrementAndGet();
  private final AtomicLong requestId = new AtomicLong();

  @Override
  public long getClientId() {
    return this.clientId;
  }

  @Override
  public XGoogSpannerRequestId nextRequestId(long channelId) {
    return XGoogSpannerRequestId.of(clientId, channelId, requestId.incrementAndGet(), 0);
  }

  @Override
  public void reset() {
    requestId.set(0);
  }
}
