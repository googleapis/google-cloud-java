/*
 * Copyright 2016 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.grpc.testing;

import com.google.api.core.BetaApi;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import io.grpc.Server;
import io.grpc.inprocess.InProcessServerBuilder;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/** A utility class to control a local service which is used by testing. */
@BetaApi
public class MockServiceHelper {
  private static final int FLOW_CONTROL_WINDOW = 65 * 1024;

  private final String addressString;
  private final Server server;
  private final List<MockGrpcService> mockServices;

  /** Constructs a new MockServiceHelper. The method start() must be called before it is used. */
  public MockServiceHelper(String addressString, MockGrpcService mockService) {
    this(addressString, Arrays.asList(mockService));
  }

  public MockServiceHelper(String addressString, List<MockGrpcService> mockServices) {
    this.addressString = addressString;
    this.mockServices = Lists.newArrayList(mockServices);
    InProcessServerBuilder builder = InProcessServerBuilder.forName(addressString);
    for (MockGrpcService mockService : mockServices) {
      builder.addService(mockService.getServiceDefinition());
    }
    this.server = builder.build();
  }

  @VisibleForTesting
  MockServiceHelper(Server server, String address, MockGrpcService mockService) {
    this(server, address, Arrays.asList(mockService));
  }

  @VisibleForTesting
  MockServiceHelper(Server server, String addressString, List<MockGrpcService> mockServices) {
    this.server = server;
    this.addressString = addressString;
    this.mockServices = mockServices;
  }

  /** Starts the local server. */
  public void start() {
    try {
      server.start();
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  /** Resets the state of the mock service. */
  public void reset() {
    for (MockGrpcService mockService : mockServices) {
      mockService.reset();
    }
  }

  /** Stops the local server. */
  public void stop() {
    server.shutdownNow();
  }

  /** Returns the mock grpc service. */
  public MockGrpcService getService() {
    if (mockServices.size() != 1) {
      throw new IllegalStateException(
          "MockServiceHelper.getService() can only be called if "
              + "there is one service, but there are "
              + mockServices.size());
    }
    return mockServices.get(0);
  }

  /** Returns all of the mocked grpc services. */
  public List<MockGrpcService> getServices() {
    return mockServices;
  }

  /** Creates a channel for making requests to the mock service. */
  public LocalChannelProvider createChannelProvider() {
    return LocalChannelProvider.create(addressString);
  }
}
