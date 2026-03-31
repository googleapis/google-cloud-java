/*
 * Copyright 2024 Google LLC
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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.spanner.SessionClient.SessionId;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import java.time.Instant;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * A {@code Session} can be used to perform transactions that read and/or modify data in a Cloud
 * Spanner database. Sessions are managed internally by the client library, and users need not be
 * aware of the actual session management, pooling and handling.
 */
class SessionReference {

  private final String name;
  private final DatabaseId databaseId;
  @Nullable private final String databaseRole;
  private final Map<SpannerRpc.Option, ?> options;
  private volatile Instant lastUseTime;
  @Nullable private final Instant createTime;
  private final boolean isMultiplexed;

  SessionReference(String name, @Nullable String databaseRole, Map<SpannerRpc.Option, ?> options) {
    this.options = options;
    this.name = checkNotNull(name);
    this.databaseId = SessionId.of(name).getDatabaseId();
    this.databaseRole = databaseRole;
    this.lastUseTime = Instant.now();
    this.createTime = null;
    this.isMultiplexed = false;
  }

  SessionReference(
      String name,
      @Nullable String databaseRole,
      com.google.protobuf.Timestamp createTime,
      boolean isMultiplexed,
      Map<SpannerRpc.Option, ?> options) {
    this.options = options;
    this.name = checkNotNull(name);
    this.databaseId = SessionId.of(name).getDatabaseId();
    this.databaseRole = databaseRole;
    this.lastUseTime = Instant.now();
    this.createTime = convert(createTime);
    this.isMultiplexed = isMultiplexed;
  }

  public String getName() {
    return name;
  }

  public String getDatabaseRole() {
    return databaseRole;
  }

  public DatabaseId getDatabaseId() {
    return databaseId;
  }

  Map<SpannerRpc.Option, ?> getOptions() {
    return options;
  }

  Instant getLastUseTime() {
    return lastUseTime;
  }

  Instant getCreateTime() {
    return createTime;
  }

  boolean getIsMultiplexed() {
    return isMultiplexed;
  }

  void markUsed(Instant instant) {
    lastUseTime = instant;
  }

  private Instant convert(com.google.protobuf.Timestamp timestamp) {
    if (timestamp == null) {
      return null;
    }
    return Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
  }
}
