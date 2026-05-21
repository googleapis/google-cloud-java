/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.internal.channels;

import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.SessionRequest;
import io.grpc.Metadata;
import io.grpc.Status;
import javax.annotation.Nullable;

class FailingSessionStream implements SessionStream {
  private final Status status;

  FailingSessionStream(Status status) {
    this.status = status;
  }

  @Override
  public PeerInfo getPeerInfo() {
    return DISCONNECTED_PEER_INFO;
  }

  @Override
  public void start(Listener responseListener, Metadata headers) {
    responseListener.onClose(status, new Metadata());
  }

  @Override
  public void sendMessage(SessionRequest request) {
    // noop
  }

  @Override
  public void halfClose() {
    // noop
  }

  @Override
  public void forceClose(@Nullable String message, @Nullable Throwable cause) {
    // noop
  }
}
