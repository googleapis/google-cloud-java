/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.test_helpers.env;

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminSettings;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.Grpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import javax.annotation.Nullable;

/**
 * Test environment that uses an existing bigtable table. The table must have a pre-existing family
 * {@code cf}. The target table is configured via the system properties:
 *
 * <ul>
 *   <li>{@code bigtable.project}
 *   <li>{@code bigtable.instance}
 *   <li>{@code bigtable.table}
 * </ul>
 */
class CloudEnv extends AbstractTestEnv {
  // IP address prefixes allocated for DirectPath backends.
  public static final String DP_IPV6_PREFIX = "2001:4860:8040";
  public static final String DP_IPV4_PREFIX = "34.126";

  private static final String DATA_ENDPOINT_PROPERTY_NAME = "bigtable.data-endpoint";
  private static final String ADMIN_ENDPOINT_PROPERTY_NAME = "bigtable.admin-endpoint";

  private static final String PROJECT_PROPERTY_NAME = "bigtable.project";
  private static final String INSTANCE_PROPERTY_NAME = "bigtable.instance";
  private static final String TABLE_PROPERTY_NAME = "bigtable.table";

  private final String projectId;
  private final String instanceId;
  private final String tableId;

  private final BigtableDataSettings.Builder dataSettings;
  private final BigtableTableAdminSettings.Builder tableAdminSettings;
  private final BigtableInstanceAdminSettings.Builder instanceAdminSettings;

  private BigtableDataClient dataClient;
  private BigtableTableAdminClient tableAdminClient;
  private BigtableInstanceAdminClient instanceAdminClient;

  static CloudEnv fromSystemProperties() {
    return new CloudEnv(
        getOptionalProperty(DATA_ENDPOINT_PROPERTY_NAME, ""),
        getOptionalProperty(ADMIN_ENDPOINT_PROPERTY_NAME, ""),
        getRequiredProperty(PROJECT_PROPERTY_NAME),
        getRequiredProperty(INSTANCE_PROPERTY_NAME),
        getRequiredProperty(TABLE_PROPERTY_NAME));
  }

  private CloudEnv(
      @Nullable String dataEndpoint,
      @Nullable String adminEndpoint,
      String projectId,
      String instanceId,
      String tableId) {
    this.projectId = projectId;
    this.instanceId = instanceId;
    this.tableId = tableId;

    this.dataSettings =
        BigtableDataSettings.newBuilder().setProjectId(projectId).setInstanceId(instanceId);
    if (!Strings.isNullOrEmpty(dataEndpoint)) {
      dataSettings.stubSettings().setEndpoint(dataEndpoint);
    }

    if (isDirectPathEnabled()) {
      TransportChannelProvider channelProvider =
          dataSettings.stubSettings().getTransportChannelProvider();
      InstantiatingGrpcChannelProvider defaultTransportProvider =
          (InstantiatingGrpcChannelProvider) channelProvider;
      InstantiatingGrpcChannelProvider instrumentedTransportChannelProvider =
          defaultTransportProvider
              .toBuilder()
              .setChannelConfigurator(
                  new ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder>() {
                    @Override
                    public ManagedChannelBuilder apply(ManagedChannelBuilder builder) {
                      builder.intercept(directPathAddressCheckInterceptor());
                      return builder;
                    }
                  })
              .build();
      dataSettings.stubSettings().setTransportChannelProvider(instrumentedTransportChannelProvider);
    }

    this.tableAdminSettings =
        BigtableTableAdminSettings.newBuilder().setProjectId(projectId).setInstanceId(instanceId);
    if (!Strings.isNullOrEmpty(adminEndpoint)) {
      this.tableAdminSettings.stubSettings().setEndpoint(adminEndpoint);
    }

    this.instanceAdminSettings = BigtableInstanceAdminSettings.newBuilder().setProjectId(projectId);
    if (!Strings.isNullOrEmpty(adminEndpoint)) {
      this.instanceAdminSettings.stubSettings().setEndpoint(adminEndpoint);
    }
  }

  @Override
  void start() throws IOException {
    dataClient = BigtableDataClient.create(dataSettings.build());
    tableAdminClient = BigtableTableAdminClient.create(tableAdminSettings.build());
    instanceAdminClient = BigtableInstanceAdminClient.create(instanceAdminSettings.build());
  }

  @Override
  void stop() {
    dataClient.close();
    tableAdminClient.close();
    instanceAdminClient.close();
  }

  @Override
  public BigtableDataClient getDataClient() {
    return dataClient;
  }

  @Override
  public BigtableTableAdminClient getTableAdminClient() {
    return tableAdminClient;
  }

  @Override
  public BigtableInstanceAdminClient getInstanceAdminClient() {
    return instanceAdminClient;
  }

  @Override
  public BigtableDataSettings getDataClientSettings() {
    return dataSettings.build();
  }

  @Override
  public String getProjectId() {
    return projectId;
  }

  @Override
  public String getInstanceId() {
    return instanceId;
  }

  @Override
  public String getTableId() {
    return tableId;
  }

  private static String getOptionalProperty(String prop, String defaultValue) {
    return MoreObjects.firstNonNull(System.getProperty(prop), defaultValue);
  }

  private static String getRequiredProperty(String prop) {
    String value = System.getProperty(prop);
    if (value == null || value.isEmpty()) {
      throw new RuntimeException("Missing system property: " + prop);
    }
    return value;
  }

  /**
   * Captures the request attributes "Grpc.TRANSPORT_ATTR_REMOTE_ADDR" when connection is
   * established and verifies if the remote address is a DirectPath address. This is only used for
   * DirectPath testing. {@link ClientCall#getAttributes()}
   */
  private ClientInterceptor directPathAddressCheckInterceptor() {
    return new ClientInterceptor() {
      @Override
      public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
          MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        final ClientCall<ReqT, RespT> clientCall = next.newCall(method, callOptions);
        return new SimpleForwardingClientCall<ReqT, RespT>(clientCall) {
          @Override
          public void start(Listener<RespT> responseListener, Metadata headers) {
            super.start(
                new SimpleForwardingClientCallListener<RespT>(responseListener) {
                  @Override
                  public void onHeaders(Metadata headers) {
                    // Check peer IP after connection is established.
                    SocketAddress remoteAddr =
                        clientCall.getAttributes().get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR);
                    if (!verifyRemoteAddress(remoteAddr)) {
                      throw new RuntimeException(
                          String.format(
                              "Synthetically aborting the current request because it did not adhere"
                                  + " to the test environment's requirement for DirectPath."
                                  + " Expected test to access DirectPath via %s,"
                                  + " but RPC was destined for %s",
                              isDirectPathIpv4() ? "ipv4" : "ipv6", remoteAddr.toString()));
                    }
                    super.onHeaders(headers);
                  }
                },
                headers);
          }
        };
      }
    };
  }

  private boolean verifyRemoteAddress(SocketAddress remoteAddr) {
    if (remoteAddr instanceof InetSocketAddress) {
      InetAddress inetAddress = ((InetSocketAddress) remoteAddr).getAddress();
      String addr = inetAddress.getHostAddress();
      if (isDirectPathIpv4()) {
        return addr.startsWith(DP_IPV4_PREFIX);
      } else {
        return addr.startsWith(DP_IPV6_PREFIX);
      }
    }
    return true;
  }
}
