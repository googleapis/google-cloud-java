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

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.PeerInfo.TransportType;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.cloud.bigtable.test_helpers.env.CloudEnv;
import com.google.cloud.bigtable.test_helpers.env.PrefixGenerator;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import com.google.common.base.Stopwatch;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
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
 * <p>This test only runs under the {@code bigtable-session-it} Maven profile, which sets {@code
 * bigtable.internal.client-config-override} to force {@code session_load: 1.0} and points the
 * client at a session-allowlisted instance.
 *
 * <p>Session path activity is verified by observing the {@code bigtable-peer-info} response header
 * on the {@code OpenTable} session stream. When sessions are active, this header contains a {@link
 * PeerInfo} proto whose transport type starts with {@code TRANSPORT_TYPE_SESSION_} (and should not
 * be {@code SESSION_UNKNOWN}, indicating a known session routing path).
 */
@RunWith(JUnit4.class)
public class SessionIT {

  private static final Metadata.Key<String> PEER_INFO_KEY =
      Metadata.Key.of("bigtable-peer-info", Metadata.ASCII_STRING_MARSHALLER);

  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

  private final List<TransportType> observedTypes = new CopyOnWriteArrayList<>();
  private EnhancedBigtableStub stub;

  @Before
  public void setUp() throws IOException {
    assume()
        .withMessage(
            "SessionIT requires the session path to be enabled. "
                + "Run with the bigtable-session-it Maven profile.")
        .that(System.getProperty("bigtable.internal.client-config-override"))
        .isNotNull();

    assume()
        .withMessage("SessionIT requires a cloud environment, not the emulator")
        .that(testEnvRule.env())
        .isInstanceOf(CloudEnv.class);

    ClientInterceptor interceptor = new PeerInfoCapturingInterceptor();

    InstantiatingGrpcChannelProvider defaultTransportProvider =
        (InstantiatingGrpcChannelProvider)
            testEnvRule.env().getDataClientSettings().getStubSettings().getTransportChannelProvider();
    InstantiatingGrpcChannelProvider instrumentedTransportProvider =
        defaultTransportProvider.toBuilder()
            .setChannelConfigurator(
                b -> {
                  b.intercept(interceptor);
                  return b;
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
  public void testReadAndWriteSucceed() {
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
  }

  @Test
  public void testSessionsAreEstablished() throws InterruptedException {
    // The session pool opens sessions asynchronously in the background. Poll until the
    // bigtable-peer-info header (from the OpenTable session stream) reports a session-type
    // transport, or until we time out.
    Stopwatch stopwatch = Stopwatch.createStarted();
    boolean sessionObserved = false;
    while (!sessionObserved && stopwatch.elapsed(TimeUnit.SECONDS) < 60) {
      stub.readRowCallable()
          .call(Query.create(testEnvRule.env().getTableId()).rowKey("probe-key"));
      Thread.sleep(2_000);
      sessionObserved =
          observedTypes.stream()
              .anyMatch(t -> t.name().startsWith("TRANSPORT_TYPE_SESSION_"));
    }

    assertWithMessage(
            "Expected a session-type transport in bigtable-peer-info (TRANSPORT_TYPE_SESSION_*)"
                + " within 60s, but observed: "
                + observedTypes)
        .that(sessionObserved)
        .isTrue();

    assertWithMessage(
            "Sessions should have a known transport type, not SESSION_UNKNOWN."
                + " Observed: "
                + observedTypes)
        .that(observedTypes)
        .doesNotContain(TransportType.TRANSPORT_TYPE_SESSION_UNKNOWN);
  }

  private class PeerInfoCapturingInterceptor implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
      return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
          next.newCall(method, callOptions)) {
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
