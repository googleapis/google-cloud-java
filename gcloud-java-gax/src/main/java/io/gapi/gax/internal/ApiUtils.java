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

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.Lists;

import io.gapi.gax.grpc.ApiCallable;
import io.gapi.gax.grpc.ServiceApiSettings;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.auth.ClientAuthInterceptor;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

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
   * Acquires application-default credentials, applying the given scopes if the
   * credentials require scopes.
   */
  public static Credentials credentialsWithScopes(String scopes[]) throws IOException {
    List<String> scopeList = Arrays.asList(scopes);
    GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
    if (credentials.createScopedRequired()) {
      credentials = credentials.createScoped(scopeList);
    }
    return credentials;
  }

  /**
   * Creates a channel for the given address, port, and credentials.
   */
  public static ManagedChannel createChannel(String address, int port, Credentials credentials)
      throws IOException {
    List<ClientInterceptor> interceptors = Lists.newArrayList();
    //TODO: MIGRATION interceptors.add(ChannelFactory.authorityInterceptor(address));

    interceptors.add(new ClientAuthInterceptor(credentials,
        Executors.newFixedThreadPool(AUTH_THREADS)));

    return NettyChannelBuilder
        .forAddress(address, port)
        .negotiationType(NegotiationType.TLS)
        .intercept(interceptors)
        .build();
  }

  /**
   * Creates a new instance of ServiceApiSettings with all fields populated, using
   * the given defaults if the corresponding values are not set on ServiceApiSettings.
   */
  public static ServiceApiSettings populateSettings(ServiceApiSettings settings,
      String defaultServiceAddress, int defaultServicePort, String scopes[]) throws IOException {
    ManagedChannel channel = settings.getChannel();

    if (channel == null) {
      String servicePath = settings.getServiceAddress();
      if (servicePath == null) {
        servicePath = defaultServiceAddress;
      }

      int port = settings.getPort();
      if (port == 0) {
        port = defaultServicePort;
      }

      Credentials credentials = settings.getCredentials();
      if (credentials == null) {
        credentials = credentialsWithScopes(scopes);
      }

      channel = ApiUtils.createChannel(servicePath, port, credentials);
    }

    return new ServiceApiSettings()
        .setChannel(channel)
        .setIsIdempotentRetrying(settings.getIsIdempotentRetrying());
  }
}
