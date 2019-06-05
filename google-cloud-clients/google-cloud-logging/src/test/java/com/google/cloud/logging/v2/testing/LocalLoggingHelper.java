/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.logging.v2.testing;

import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import java.io.IOException;

/** LocalLoggingHelper runs an in-memory Logging server for use in tests. */
public class LocalLoggingHelper {
  private final String address;
  private final Server server;
  private final LocalLoggingImpl loggingImpl;

  /** Constructs a new LocalLoggingHelper. The method start() must be called before it is used. */
  public LocalLoggingHelper(String address) {
    this.address = address;
    this.loggingImpl = new LocalLoggingImpl();
    this.server =
        InProcessServerBuilder.forName(address).addService(loggingImpl.bindService()).build();
  }
  /** Starts the in-memory service. */
  public void start() {
    try {
      server.start();
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }
  /** Resets the state of the in-memory service. */
  public void reset() {
    loggingImpl.reset();
  }
  /** Returns the internal in-memory service. */
  public LocalLoggingImpl getLoggingImpl() {
    return loggingImpl;
  }
  /** Creates a channel for making requests to the in-memory service. */
  public ManagedChannel createChannel() {
    return InProcessChannelBuilder.forName(address).usePlaintext().build();
  }
  /** Shuts down the in-memory service. */
  public void shutdownNow() {
    server.shutdownNow();
  }
}
