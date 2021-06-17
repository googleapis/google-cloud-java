/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigtable.data.v2;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptor;
import io.grpc.ServerTransportFilter;
import java.io.IOException;
import java.net.ServerSocket;

/** Utility class to setup a fake grpc server on a random port. */
public class FakeServiceHelper {
  private final int port;
  private final Server server;

  public FakeServiceHelper(BindableService... services) throws IOException {
    this(null, services);
  }

  public FakeServiceHelper(ServerInterceptor interceptor, BindableService... services)
      throws IOException {
    this(interceptor, null, services);
  }

  public FakeServiceHelper(
      ServerInterceptor interceptor,
      ServerTransportFilter transportFilter,
      BindableService... services)
      throws IOException {
    try (ServerSocket ss = new ServerSocket(0)) {
      port = ss.getLocalPort();
    }
    ServerBuilder builder = ServerBuilder.forPort(port);
    if (interceptor != null) {
      builder = builder.intercept(interceptor);
    }
    if (transportFilter != null) {
      builder = builder.addTransportFilter(transportFilter);
    }
    for (BindableService service : services) {
      builder = builder.addService(service);
    }
    server = builder.build();
  }

  public int getPort() {
    return port;
  }

  public void start() throws IOException {
    server.start();
  }

  public void shutdown() {
    server.shutdown();
  }
}
