/*
 * Copyright 2022 Google LLC
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
import java.net.BindException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class FakeServiceBuilder {
  private final List<ServerInterceptor> interceptors = new ArrayList<>();
  private final List<BindableService> services = new ArrayList<>();
  private final List<ServerTransportFilter> transportFilters = new ArrayList<>();

  public static FakeServiceBuilder create(BindableService... services) {
    return new FakeServiceBuilder(services);
  }

  private FakeServiceBuilder(BindableService[] services) {
    for (BindableService service : services) {
      this.addService(service);
    }
  }

  public FakeServiceBuilder intercept(ServerInterceptor interceptor) {
    interceptors.add(interceptor);
    return this;
  }

  public FakeServiceBuilder addService(BindableService service) {
    services.add(service);
    return this;
  }

  public FakeServiceBuilder addTransportFilter(ServerTransportFilter transportFilter) {
    transportFilters.add(transportFilter);
    return this;
  }

  public Server start() throws IOException {
    IOException lastError = null;

    for (int i = 0; i < 10; i++) {
      try {
        return startWithoutRetries();
      } catch (IOException e) {
        lastError = e;
        if (!(e.getCause() instanceof BindException)) {
          break;
        }
      }
    }

    throw lastError;
  }

  private Server startWithoutRetries() throws IOException {
    int port;
    try (ServerSocket ss = new ServerSocket(0)) {
      port = ss.getLocalPort();
    }
    ServerBuilder<?> builder = ServerBuilder.forPort(port);
    interceptors.forEach(builder::intercept);
    services.forEach(builder::addService);
    transportFilters.forEach(builder::addTransportFilter);

    return builder.build().start();
  }
}
