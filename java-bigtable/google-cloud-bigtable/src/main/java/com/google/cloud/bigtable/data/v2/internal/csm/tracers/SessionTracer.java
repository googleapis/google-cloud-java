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

package com.google.cloud.bigtable.data.v2.internal.csm.tracers;

import com.google.bigtable.v2.CloseSessionRequest.CloseSessionReason;
import com.google.bigtable.v2.PeerInfo;
import io.grpc.Status;

public interface SessionTracer {

  void onStart();

  void onOpen(PeerInfo peerInfo);

  void onVRpcClose(Status.Code code);

  void onClose(PeerInfo peerInfo, CloseSessionReason reason, Status status);

  /**
   * Record any metrics outside of the normal flow (ie periodically recording how long a session has
   * been open).
   *
   * @return false if this tracker is done and will not have anymore metrics to record.
   */
  boolean recordAsyncMetrics();
}
