/*
 * Copyright 2015, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
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

package io.gapi.gax.internal;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executors;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.Lists;

import io.gapi.gax.grpc.ApiCallable;
import io.gapi.gax.grpc.ServiceApiSettings;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.auth.ClientAuthInterceptor;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;

public class ApiUtils {

  // TODO(wgg): make this configurable
  private static final int AUTH_THREADS = 4;

  public static <RequestT, ResponseT> ApiCallable<RequestT, ResponseT> prepareIdempotentCallable(
      ApiCallable<RequestT, ResponseT> callable, ServiceApiSettings settings) {
    ApiCallable<RequestT, ResponseT> theCallable = callable;
    if (settings.getIsIdempotentRetrying()) {
      theCallable = theCallable.retrying();
    }
    return theCallable;
  }

  /**
   * Creates a channel for the given path, address and port.
   */
  public static ManagedChannel createChannel(String address, int port, Collection<String> scopes)
      throws IOException {
    List<ClientInterceptor> interceptors = Lists.newArrayList();
    //TODO: MIGRATION interceptors.add(ChannelFactory.authorityInterceptor(address));

    GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
    if (credentials.createScopedRequired()) {
      credentials = credentials.createScoped(scopes);
    }
    interceptors.add(new ClientAuthInterceptor(credentials,
        Executors.newFixedThreadPool(AUTH_THREADS)));

    return NettyChannelBuilder
        .forAddress(address, port)
        .negotiationType(NegotiationType.TLS)
        .intercept(interceptors)
        .build();
  }

  public static ServiceApiSettings settingsWithChannels(ServiceApiSettings settings,
      String defaultServicePath, int defaultServicePort, String scopes[]) throws IOException {
    ManagedChannel channel = settings.getChannel();

    if (channel == null) {
      String servicePath = defaultServicePath;
      if (settings.getServicePath() != null) {
        servicePath = settings.getServicePath();
      }

      int port = defaultServicePort;
      if (settings.getPort() != 0) {
        port = settings.getPort();
      }

      List<String> scopeList = Arrays.asList(scopes);
      channel = ApiUtils.createChannel(servicePath, port, scopeList);
    }

    return new ServiceApiSettings()
        .setChannel(channel)
        .setIsIdempotentRetrying(settings.getIsIdempotentRetrying());
  }
}
