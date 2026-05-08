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

import com.google.bigtable.v2.PeerInfo;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompositeVRpcTracer implements VRpcTracer {

  private static final Logger logger = Logger.getLogger(CompositeVRpcTracer.class.getName());

  private final List<VRpcTracer> children;

  public CompositeVRpcTracer(List<VRpcTracer> children) {
    this.children = children;
  }

  @Override
  public void onOperationStart() {
    children.forEach(
        c -> {
          try {
            c.onOperationStart();
          } catch (Throwable e) {
            logger.log(
                Level.WARNING,
                "Failed to log operation start on tracer {0}",
                c.getClass().getName());
          }
        });
  }

  @Override
  public void onAttemptStart(Object req) {
    children.forEach(
        c -> {
          try {
            c.onAttemptStart(req);
          } catch (Throwable e) {
            logger.log(
                Level.WARNING, "Failed to log attempt start on tracer {0}", c.getClass().getName());
          }
        });
  }

  @Override
  public void onRequestSent(PeerInfo peerInfo) {
    children.forEach(
        c -> {
          try {
            c.onRequestSent(peerInfo);
          } catch (Throwable e) {
            logger.log(
                Level.WARNING,
                "Failed to log request sent on tracer {0} for peer {1}",
                new Object[] {c.getClass().getName(), peerInfo});
          }
        });
  }

  @Override
  public void onResponseReceived() {
    children.forEach(
        c -> {
          try {
            c.onResponseReceived();
          } catch (Throwable e) {
            logger.log(
                Level.WARNING,
                "Failed to log response received on tracer {0}",
                c.getClass().getName());
          }
        });
  }

  @Override
  public void recordApplicationBlockingLatencies(Duration elapsed) {
    children.forEach(
        c -> {
          try {
            c.recordApplicationBlockingLatencies(elapsed);
          } catch (Throwable e) {
            logger.log(
                Level.WARNING,
                "Failed to log application latencies on tracer {0} with duration {1}",
                new Object[] {c.getClass().getName(), elapsed});
          }
        });
  }

  @Override
  public void onAttemptFinish(VRpc.VRpcResult result) {
    children.forEach(
        c -> {
          try {
            c.onAttemptFinish(result);
          } catch (Throwable e) {
            logger.log(
                Level.WARNING,
                "Failed to log attempt finish on tracer {0} with result {1}",
                new Object[] {c.getClass().getName(), result});
          }
        });
  }

  @Override
  public void onOperationFinish(VRpc.VRpcResult result) {
    children.forEach(
        c -> {
          try {
            c.onOperationFinish(result);
          } catch (Throwable e) {
            logger.log(
                Level.WARNING,
                "Failed to log operation finish on tracer {0} with result {1}",
                new Object[] {c.getClass().getName(), result});
          }
        });
  }
}
