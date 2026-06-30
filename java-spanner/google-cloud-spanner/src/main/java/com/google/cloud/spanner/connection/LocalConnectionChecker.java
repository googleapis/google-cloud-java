/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.spanner.connection;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.UnavailableException;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.admin.instance.v1.stub.GrpcInstanceAdminStub;
import com.google.cloud.spanner.admin.instance.v1.stub.InstanceAdminStubSettings;
import com.google.common.base.Strings;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest;
import java.time.Duration;

/**
 * Util class for quickly checking whether a local emulator or test server can be found. A common
 * configuration error is to add 'localhost' to the connection string or to forget to unset the
 * SPANNER_EMULATOR_HOST environment variable. This can cause cryptic error messages. This util
 * checks for common configurations and errors and returns a more understandable error message for
 * known misconfigurations.
 */
class LocalConnectionChecker {

  /**
   * Executes a quick check to see if this connection can actually connect to a local emulator host
   * or other (mock) test server, if the options point to localhost instead of Cloud Spanner.
   */
  void checkLocalConnection(ConnectionOptions options) {
    final String emulatorHost = System.getenv("SPANNER_EMULATOR_HOST");
    String host = options.getHost() == null ? emulatorHost : options.getHost();
    if (Strings.isNullOrEmpty(host)) {
      return;
    }

    if (host.startsWith("https://")) {
      host = host.substring(8);
    }
    if (host.startsWith("http://")) {
      host = host.substring(7);
    }
    // Only do the check if the host has been set to localhost.
    if (host.startsWith("localhost") && options.isUsePlainText()) {
      // Do a quick check to see if anything is actually running on the host.
      try {
        InstanceAdminStubSettings.Builder testEmulatorSettings =
            InstanceAdminStubSettings.newBuilder()
                .setCredentialsProvider(NoCredentialsProvider.create())
                .setTransportChannelProvider(
                    InstantiatingGrpcChannelProvider.newBuilder()
                        .setEndpoint(host)
                        .setChannelConfigurator(
                            input -> {
                              input.usePlaintext();
                              return input;
                            })
                        .build());
        testEmulatorSettings
            .listInstanceConfigsSettings()
            .setSimpleTimeoutNoRetriesDuration(Duration.ofSeconds(10L));
        try (GrpcInstanceAdminStub stub =
            GrpcInstanceAdminStub.create(testEmulatorSettings.build())) {
          stub.listInstanceConfigsCallable()
              .call(
                  ListInstanceConfigsRequest.newBuilder()
                      .setParent(String.format("projects/%s", options.getProjectId()))
                      .build());
        }
      } catch (UnavailableException e) {
        String msg;
        if (options.getHost() != null) {
          msg =
              String.format(
                  "The connection string '%s' contains host '%s', but no running"
                      + " emulator or other server could be found at that address.\n"
                      + "Please check the connection string and/or that the emulator is running.",
                  options.getUri(), host);
        } else {
          msg =
              String.format(
                  "The environment variable SPANNER_EMULATOR_HOST has been set to '%s', but no"
                      + " running emulator or other server could be found at that address.\n"
                      + "Please check the environment variable and/or that the emulator is"
                      + " running.",
                  emulatorHost);
        }
        throw SpannerExceptionFactory.newSpannerException(ErrorCode.UNAVAILABLE, msg);
      } catch (Throwable t) {
        // Ignore, any other exceptions should also be thrown when connecting to the remote
        // server and should not be treated here.
      }
    }
  }
}
