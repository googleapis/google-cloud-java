/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

import org.threeten.bp.Instant;

/**
 * This is just a stub class to prevent compile errors. This class will be replaced with the actual
 * class in a separate PR.
 */
class ConnectionImpl implements Connection {
  static class LeakedConnectionException extends RuntimeException {
    private static final long serialVersionUID = 7119433786832158700L;

    private LeakedConnectionException() {
      super("Connection was opened at " + Instant.now());
    }
  }

  private volatile LeakedConnectionException leakedException = new LeakedConnectionException();
  private final ConnectionOptions options;

  ConnectionImpl(ConnectionOptions options) {
    SpannerPool.INSTANCE.getSpanner(options, this);
    this.options = options;
  }

  RuntimeException getLeakedException() {
    return leakedException;
  }

  @Override
  public void close() {
    leakedException = null;
    SpannerPool.INSTANCE.removeConnection(options, this);
  }

  @Override
  public boolean isClosed() {
    return leakedException == null;
  }
}
