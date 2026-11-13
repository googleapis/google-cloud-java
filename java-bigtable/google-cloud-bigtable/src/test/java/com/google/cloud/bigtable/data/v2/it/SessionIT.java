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
package com.google.cloud.bigtable.data.v2.it;

import static com.google.common.truth.Truth.assertWithMessage;
import static com.google.common.truth.TruthJUnit.assume;

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.PeerInfo.TransportType;
import com.google.bigtable.v2.SessionRequest;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.cloud.bigtable.test_helpers.env.AbstractTestEnv.ConnectionMode;
import com.google.cloud.bigtable.test_helpers.env.CloudEnv;
import com.google.cloud.bigtable.test_helpers.env.PrefixGenerator;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import com.google.common.collect.ImmutableSet;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Verifies that the Bigtable client routes traffic through the session path when sessions are
 * enabled.
 *
 * <p>This test runs when the {@code bigtable-session-it} Maven profile is active (composed with
 * {@code bigtable-cfe-it}, {@code bigtable-directpath-it}, or {@code bigtable-prod-it}), which sets
 * {@code bigtable.internal.client-config-override} to force {@code global_diversion { session_load:
 * 1.0 }}.
 *
 * <p>Session path activity is verified by observing:
 *
 * <ul>
 *   <li>The {@code bigtable-peer-info} response header on the {@code OpenTable} session stream
 *       matches the expected session transport type ({@code TRANSPORT_TYPE_SESSION_DIRECT_ACCESS}
 *       for DirectPath, {@code TRANSPORT_TYPE_SESSION_CLOUD_PATH} for CFE).
 *   <li>Operations actually send {@link SessionRequest#getVirtualRpc()} messages over the session
 *       stream rather than falling back to classic unary/streaming gRPC methods.
 * </ul>
 */
@RunWith(JUnit4.class)
public class SessionIT {

  private static final Metadata.Key<String> PEER_INFO_KEY =
      Metadata.Key.of("bigtable-peer-info", Metadata.ASCII_STRING_MARSHALLER);

  private static final Set<String> CLASSIC_DATA_METHODS =
      ImmutableSet.of(
          "ReadRows", "MutateRow", "MutateRows", "CheckAndMutateRow", "ReadModifyWriteRow");

  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

  private final List<TransportType> observedTypes = new CopyOnWriteArrayList<>();
  private final AtomicInteger virtualRpcCount = new AtomicInteger();
  private final List<String> classicDataRpcs = new CopyOnWriteArrayList<>();
  private EnhancedBigtableStub stub;

  @Before
  @SuppressWarnings({"rawtypes", "unchecked"})
  public void setUp() throws IOException {
    assume()
        .withMessage(
            "SessionIT requires the session path to be enabled. "
                + "Run with the bigtable-session-it Maven profile.")
        .that(System.getProperty("bigtable.internal.client-config-override", ""))
        .isNotEmpty();

    assume()
        .withMessage("SessionIT requires a cloud environment, not the emulator")
        .that(testEnvRule.env())
        .isInstanceOf(CloudEnv.class);

    ClientInterceptor interceptor = new PeerInfoCapturingInterceptor();

    InstantiatingGrpcChannelProvider defaultTransportProvider =
        (InstantiatingGrpcChannelProvider)
            testEnvRule
                .env()
                .getDataClientSettings()
                .getStubSettings()
                .getTransportChannelProvider();
    InstantiatingGrpcChannelProvider.Builder transportBuilder =
        defaultTransportProvider.toBuilder();
    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> oldConfigurator =
        transportBuilder.getChannelConfigurator();
    InstantiatingGrpcChannelProvider instrumentedTransportProvider =
        transportBuilder
            .setChannelConfigurator(
                b -> {
                  if (oldConfigurator != null) {
                    b = oldConfigurator.apply(b);
                  }
                  return b.intercept(interceptor);
                })
            .build();

    stub =
        EnhancedBigtableStub.create(
            testEnvRule.env().getDataClientSettings().getStubSettings().toBuilder()
                .setTransportChannelProvider(instrumentedTransportProvider)
                .build());
  }

  @After
  public void tearDown() {
    if (stub != null) {
      stub.close();
    }
  }

  @Test
  public void testReadAndWriteOverSession() {
    TableId tableId = testEnvRule.env().getTableId();
    String rowKey = PrefixGenerator.newPrefix("SessionIT#readWrite");

    stub.mutateRowCallable()
        .call(
            RowMutation.create(tableId, rowKey)
                .setCell(testEnvRule.env().getFamilyId(), "q", "value"));

    Row row = stub.readRowCallable().call(Query.create(tableId).rowKey(rowKey));
    assertWithMessage("Written row should be readable through the session path")
        .that(row)
        .isNotNull();

    assertWithMessage(
            "Expected mutateRow and readRow to execute as session VirtualRpcs without falling back"
                + " to classic RPCs, but classic RPCs were: %s",
            classicDataRpcs)
        .that(classicDataRpcs)
        .isEmpty();

    assertWithMessage("Expected at least 2 session VirtualRpcs (mutateRow + readRow)")
        .that(virtualRpcCount.get())
        .isAtLeast(2);

    assertWithMessage(
            "Sessions should have a known transport type, not SESSION_UNKNOWN. Observed: %s",
            observedTypes)
        .that(observedTypes)
        .doesNotContain(TransportType.TRANSPORT_TYPE_SESSION_UNKNOWN);

    ConnectionMode mode = testEnvRule.env().getConnectionMode();
    if (mode == ConnectionMode.REQUIRE_DIRECT_PATH
        || mode == ConnectionMode.REQUIRE_DIRECT_PATH_IPV4) {
      assertWithMessage(
              "Expected DirectAccess session transport type under %s, but observed: %s",
              mode, observedTypes)
          .that(observedTypes)
          .contains(TransportType.TRANSPORT_TYPE_SESSION_DIRECT_ACCESS);
    } else if (mode == ConnectionMode.REQUIRE_CFE) {
      assertWithMessage(
              "Expected CloudPath session transport type under %s, but observed: %s",
              mode, observedTypes)
          .that(observedTypes)
          .contains(TransportType.TRANSPORT_TYPE_SESSION_CLOUD_PATH);
    } else {
      assertWithMessage(
              "Expected a session transport type (TRANSPORT_TYPE_SESSION_*), but observed: %s",
              observedTypes)
          .that(
              observedTypes.stream().anyMatch(t -> t.name().startsWith("TRANSPORT_TYPE_SESSION_")))
          .isTrue();
    }
  }

  private class PeerInfoCapturingInterceptor implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
      String bareMethod = method.getBareMethodName();
      if (bareMethod != null && CLASSIC_DATA_METHODS.contains(bareMethod)) {
        classicDataRpcs.add(bareMethod);
      }
      return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
          next.newCall(method, callOptions)) {
        @Override
        public void sendMessage(ReqT message) {
          if (message instanceof SessionRequest && ((SessionRequest) message).hasVirtualRpc()) {
            virtualRpcCount.incrementAndGet();
          }
          super.sendMessage(message);
        }

        @Override
        public void start(Listener<RespT> responseListener, Metadata headers) {
          super.start(
              new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(
                  responseListener) {
                @Override
                public void onHeaders(Metadata headers) {
                  String encoded = headers.get(PEER_INFO_KEY);
                  if (encoded != null) {
                    try {
                      PeerInfo peerInfo =
                          PeerInfo.parseFrom(Base64.getUrlDecoder().decode(encoded));
                      observedTypes.add(peerInfo.getTransportType());
                    } catch (Exception e) {
                      // ignore malformed headers
                    }
                  }
                  super.onHeaders(headers);
                }
              },
              headers);
        }
      };
    }
  }
}
