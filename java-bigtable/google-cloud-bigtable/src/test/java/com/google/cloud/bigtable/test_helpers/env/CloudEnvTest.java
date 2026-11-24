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
package com.google.cloud.bigtable.test_helpers.env;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.ClientConfiguration;
import com.google.bigtable.v2.GetClientConfigurationRequest;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.RowSet;
import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.bigtable.v2.SessionDiversionConfiguration;
import com.google.bigtable.v2.SessionDiversionConfiguration.PerScopeDiversion;
import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.SessionResponse;
import com.google.bigtable.v2.SessionScopeDiversionConfiguration;
import com.google.bigtable.v2.TelemetryConfiguration;
import com.google.cloud.bigtable.data.v2.internal.compat.DisabledShim;
import com.google.cloud.bigtable.data.v2.internal.compat.ShimImpl;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import com.google.cloud.bigtable.data.v2.internal.util.SessionScope;
import com.google.cloud.bigtable.test_helpers.env.AbstractTestEnv.ExpectedProtocol;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.Grpc;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;

class CloudEnvTest {

  private static ShimImpl shimWithConfig(ClientConfiguration config) {
    ClientConfigurationManager configManager = mock(ClientConfigurationManager.class);
    when(configManager.getClientConfiguration()).thenReturn(config);
    ShimImpl shim = mock(ShimImpl.class);
    when(shim.getConfigManager()).thenReturn(configManager);
    return shim;
  }

  @Test
  void emulatorEnv_sessionsDisabled() {
    assertThat(EmulatorEnv.createBundled().isSessionsEnabled()).isFalse();
  }

  @Test
  void disabledShim_sessionsDisabled() {
    assertThat(CloudEnv.isSessionsEnabled(new DisabledShim())).isFalse();
  }

  @Test
  void defaultClientConfig_sessionsDisabled() {
    assertThat(CloudEnv.isSessionsEnabled(shimWithConfig(ClientConfiguration.getDefaultInstance())))
        .isFalse();
  }

  @Test
  void nonSessionConfigOverride_sessionsDisabled() {
    ClientConfiguration config =
        ClientConfiguration.newBuilder()
            .setTelemetryConfiguration(
                TelemetryConfiguration.newBuilder()
                    .setDebugTagLevel(TelemetryConfiguration.Level.INFO))
            .build();
    assertThat(CloudEnv.isSessionsEnabled(shimWithConfig(config))).isFalse();
  }

  @Test
  void zeroGlobalSessionLoad_sessionsDisabled() {
    ClientConfiguration config =
        ClientConfiguration.newBuilder()
            .setSessionConfiguration(
                SessionClientConfiguration.newBuilder()
                    .setSessionDiversionConfiguration(
                        SessionDiversionConfiguration.newBuilder()
                            .setGlobalDiversion(
                                SessionScopeDiversionConfiguration.newBuilder()
                                    .setSessionLoad(0.0f))))
            .build();
    assertThat(CloudEnv.isSessionsEnabled(shimWithConfig(config))).isFalse();
  }

  @Test
  void positiveGlobalSessionLoad_sessionsEnabled() {
    ClientConfiguration config =
        ClientConfiguration.newBuilder()
            .setSessionConfiguration(
                SessionClientConfiguration.newBuilder()
                    .setSessionDiversionConfiguration(
                        SessionDiversionConfiguration.newBuilder()
                            .setGlobalDiversion(
                                SessionScopeDiversionConfiguration.newBuilder()
                                    .setSessionLoad(1.0f))))
            .build();
    assertThat(CloudEnv.isSessionsEnabled(shimWithConfig(config))).isTrue();
  }

  @Test
  void perScopeServedMethod_sessionsEnabled() {
    ClientConfiguration config =
        ClientConfiguration.newBuilder()
            .setSessionConfiguration(
                SessionClientConfiguration.newBuilder()
                    .setSessionDiversionConfiguration(
                        SessionDiversionConfiguration.newBuilder()
                            .setPerScopeDiversion(
                                PerScopeDiversion.newBuilder()
                                    .putScopeDiversions(
                                        SessionScope.READ_ROW.getKey(),
                                        SessionScopeDiversionConfiguration.newBuilder()
                                            .setSessionLoad(0.5f)
                                            .build()))))
            .build();
    assertThat(CloudEnv.isSessionsEnabled(shimWithConfig(config))).isTrue();
  }

  @Test
  void perScopeUnservedMethod_sessionsDisabled() {
    ClientConfiguration config =
        ClientConfiguration.newBuilder()
            .setSessionConfiguration(
                SessionClientConfiguration.newBuilder()
                    .setSessionDiversionConfiguration(
                        SessionDiversionConfiguration.newBuilder()
                            .setPerScopeDiversion(
                                PerScopeDiversion.newBuilder()
                                    .putScopeDiversions(
                                        "method:Bigtable.UnknownMethod",
                                        SessionScopeDiversionConfiguration.newBuilder()
                                            .setSessionLoad(1.0f)
                                            .build()))))
            .build();
    assertThat(CloudEnv.isSessionsEnabled(shimWithConfig(config))).isFalse();
  }

  @Test
  void parseExpectedProtocol_defaultsToAnyWhenNullOrBlank() {
    assertThat(AbstractTestEnv.parseExpectedProtocol(null)).isEqualTo(ExpectedProtocol.ANY);
    assertThat(AbstractTestEnv.parseExpectedProtocol("")).isEqualTo(ExpectedProtocol.ANY);
    assertThat(AbstractTestEnv.parseExpectedProtocol("   ")).isEqualTo(ExpectedProtocol.ANY);
  }

  @Test
  void parseExpectedProtocol_parsesValidValues() {
    assertThat(AbstractTestEnv.parseExpectedProtocol("ANY")).isEqualTo(ExpectedProtocol.ANY);
    assertThat(AbstractTestEnv.parseExpectedProtocol("CLASSIC"))
        .isEqualTo(ExpectedProtocol.CLASSIC);
    assertThat(AbstractTestEnv.parseExpectedProtocol(" SESSION "))
        .isEqualTo(ExpectedProtocol.SESSION);
  }

  @Test
  void parseExpectedProtocol_rejectsUnknownValues() {
    assertThrows(
        IllegalArgumentException.class, () -> AbstractTestEnv.parseExpectedProtocol("SESSIONS"));
  }

  @Test
  void verifyExpectedProtocol_checksResolvedSessionState() {
    ShimImpl classicShim = shimWithConfig(ClientConfiguration.getDefaultInstance());
    ShimImpl sessionShim =
        shimWithConfig(
            ClientConfiguration.newBuilder()
                .setSessionConfiguration(
                    SessionClientConfiguration.newBuilder()
                        .setSessionDiversionConfiguration(
                            SessionDiversionConfiguration.newBuilder()
                                .setGlobalDiversion(
                                    SessionScopeDiversionConfiguration.newBuilder()
                                        .setSessionLoad(1.0f))))
                .build());

    CloudEnv.verifyExpectedProtocol(ExpectedProtocol.ANY, classicShim);
    CloudEnv.verifyExpectedProtocol(ExpectedProtocol.ANY, sessionShim);
    CloudEnv.verifyExpectedProtocol(ExpectedProtocol.CLASSIC, classicShim);
    CloudEnv.verifyExpectedProtocol(ExpectedProtocol.CLASSIC, new DisabledShim());
    CloudEnv.verifyExpectedProtocol(ExpectedProtocol.SESSION, sessionShim);

    assertThrows(
        IllegalStateException.class,
        () -> CloudEnv.verifyExpectedProtocol(ExpectedProtocol.CLASSIC, sessionShim));
    assertThrows(
        IllegalStateException.class,
        () -> CloudEnv.verifyExpectedProtocol(ExpectedProtocol.SESSION, classicShim));
    assertThrows(
        IllegalStateException.class,
        () -> CloudEnv.verifyExpectedProtocol(ExpectedProtocol.SESSION, new DisabledShim()));
  }

  @Test
  void remoteAddrInterceptor_skipsGetClientConfigurationWhenConfigured() {
    InetSocketAddress cfeAddr = InetSocketAddress.createUnresolved("142.250.0.1", 443);
    ClientInterceptor directPathInterceptor =
        CloudEnv.buildRemoteAddrInterceptor(
            "DirectPath IP", addr -> false, /* skipGetClientConfiguration= */ true);
    FakeChannel channel = new FakeChannel(cfeAddr);

    Status configStatus =
        invokeCall(
            directPathInterceptor,
            channel,
            BigtableGrpc.getGetClientConfigurationMethod(),
            GetClientConfigurationRequest.getDefaultInstance());
    assertThat(configStatus.getCode()).isEqualTo(Status.Code.OK);
    assertThat(channel.forwarded.get()).isTrue();

    RuntimeException error =
        assertThrows(
            RuntimeException.class,
            () ->
                invokeCall(
                    directPathInterceptor,
                    new FakeChannel(cfeAddr),
                    BigtableGrpc.getReadRowsMethod(),
                    ReadRowsRequest.getDefaultInstance()));
    assertThat(error).hasMessageThat().contains("DirectPath IP");
  }

  @Test
  void remoteAddrInterceptor_checksGetClientConfigurationUnderRequireCfe() {
    InetSocketAddress dpAddr = InetSocketAddress.createUnresolved("34.126.0.1", 443);
    ClientInterceptor cfeInterceptor =
        CloudEnv.buildRemoteAddrInterceptor(
            "a CFE ip", addr -> false, /* skipGetClientConfiguration= */ false);

    RuntimeException error =
        assertThrows(
            RuntimeException.class,
            () ->
                invokeCall(
                    cfeInterceptor,
                    new FakeChannel(dpAddr),
                    BigtableGrpc.getGetClientConfigurationMethod(),
                    GetClientConfigurationRequest.getDefaultInstance()));
    assertThat(error).hasMessageThat().contains("a CFE ip");
  }

  @Test
  void protocolEnforcementInterceptor_classicBlocksOpenRpcsAndAllowsClassic() {
    ClientInterceptor interceptor =
        CloudEnv.buildProtocolEnforcementInterceptor(ExpectedProtocol.CLASSIC);

    for (MethodDescriptor<SessionRequest, SessionResponse> openMethod :
        ImmutableList.of(
            BigtableGrpc.getOpenTableMethod(),
            BigtableGrpc.getOpenAuthorizedViewMethod(),
            BigtableGrpc.getOpenMaterializedViewMethod())) {
      FakeChannel channel = new FakeChannel(null);
      Status status =
          invokeCall(interceptor, channel, openMethod, SessionRequest.getDefaultInstance());
      assertThat(status.getCode()).isEqualTo(Status.Code.FAILED_PRECONDITION);
      assertThat(status.getDescription()).contains("Expected protocol CLASSIC");
      assertThat(channel.forwarded.get()).isFalse();
    }

    FakeChannel mutateChannel = new FakeChannel(null);
    assertThat(
            invokeCall(
                    interceptor,
                    mutateChannel,
                    BigtableGrpc.getMutateRowMethod(),
                    MutateRowRequest.getDefaultInstance())
                .getCode())
        .isEqualTo(Status.Code.OK);
    assertThat(mutateChannel.forwarded.get()).isTrue();

    FakeChannel readChannel = new FakeChannel(null);
    assertThat(
            invokeCall(
                    interceptor,
                    readChannel,
                    BigtableGrpc.getReadRowsMethod(),
                    ReadRowsRequest.getDefaultInstance())
                .getCode())
        .isEqualTo(Status.Code.OK);
    assertThat(readChannel.forwarded.get()).isTrue();
  }

  @Test
  void protocolEnforcementInterceptor_sessionBlocksClassicDivertedRpcs() {
    ClientInterceptor interceptor =
        CloudEnv.buildProtocolEnforcementInterceptor(ExpectedProtocol.SESSION);

    assertBlockedBySession(
        interceptor, BigtableGrpc.getMutateRowMethod(), MutateRowRequest.getDefaultInstance());
    assertBlockedBySession(
        interceptor,
        BigtableGrpc.getCheckAndMutateRowMethod(),
        CheckAndMutateRowRequest.getDefaultInstance());
    assertBlockedBySession(
        interceptor,
        BigtableGrpc.getReadModifyWriteRowMethod(),
        ReadModifyWriteRowRequest.getDefaultInstance());

    // Single-point ReadRows (rows_limit=1 + single row key or closed-closed equal range) blocked.
    ByteString key = ByteString.copyFromUtf8("row-1");
    assertBlockedBySession(
        interceptor,
        BigtableGrpc.getReadRowsMethod(),
        ReadRowsRequest.newBuilder()
            .setRowsLimit(1)
            .setRows(RowSet.newBuilder().addRowKeys(key))
            .build());
    assertBlockedBySession(
        interceptor,
        BigtableGrpc.getReadRowsMethod(),
        ReadRowsRequest.newBuilder()
            .setRowsLimit(1)
            .setRows(
                RowSet.newBuilder()
                    .addRowRanges(
                        RowRange.newBuilder().setStartKeyClosed(key).setEndKeyClosed(key)))
            .build());
  }

  @Test
  void protocolEnforcementInterceptor_sessionAllowsNonPointReadRowsBulkMutateAndSessions() {
    ClientInterceptor interceptor =
        CloudEnv.buildProtocolEnforcementInterceptor(ExpectedProtocol.SESSION);
    ByteString key1 = ByteString.copyFromUtf8("row-1");
    ByteString key2 = ByteString.copyFromUtf8("row-2");

    // Bulk read batcher single-key ReadRows leaves rows_limit=0.
    assertAllowed(
        interceptor,
        BigtableGrpc.getReadRowsMethod(),
        ReadRowsRequest.newBuilder().setRows(RowSet.newBuilder().addRowKeys(key1)).build());
    // Multi-key ReadRows with rows_limit=1.
    assertAllowed(
        interceptor,
        BigtableGrpc.getReadRowsMethod(),
        ReadRowsRequest.newBuilder()
            .setRowsLimit(1)
            .setRows(RowSet.newBuilder().addRowKeys(key1).addRowKeys(key2))
            .build());
    // Range ReadRows with rows_limit=1.
    assertAllowed(
        interceptor,
        BigtableGrpc.getReadRowsMethod(),
        ReadRowsRequest.newBuilder()
            .setRowsLimit(1)
            .setRows(
                RowSet.newBuilder()
                    .addRowRanges(
                        RowRange.newBuilder().setStartKeyClosed(key1).setEndKeyClosed(key2)))
            .build());
    // Single-key ReadRows with rows_limit=2.
    assertAllowed(
        interceptor,
        BigtableGrpc.getReadRowsMethod(),
        ReadRowsRequest.newBuilder()
            .setRowsLimit(2)
            .setRows(RowSet.newBuilder().addRowKeys(key1))
            .build());
    // Full scan ReadRows.
    assertAllowed(
        interceptor, BigtableGrpc.getReadRowsMethod(), ReadRowsRequest.getDefaultInstance());
    // MutateRows (used by batchers and partial retries).
    assertAllowed(
        interceptor, BigtableGrpc.getMutateRowsMethod(), MutateRowsRequest.getDefaultInstance());
    // Session OpenTable and GetClientConfiguration.
    assertAllowed(
        interceptor, BigtableGrpc.getOpenTableMethod(), SessionRequest.getDefaultInstance());
    assertAllowed(
        interceptor,
        BigtableGrpc.getGetClientConfigurationMethod(),
        GetClientConfigurationRequest.getDefaultInstance());
  }

  @Test
  void protocolEnforcementInterceptor_sessionCancelBeforeSendMessageDeliversCancelled() {
    ClientInterceptor interceptor =
        CloudEnv.buildProtocolEnforcementInterceptor(ExpectedProtocol.SESSION);
    FakeChannel channel = new FakeChannel(null);
    ClientCall<ReadRowsRequest, ReadRowsResponse> call =
        interceptor.interceptCall(BigtableGrpc.getReadRowsMethod(), CallOptions.DEFAULT, channel);
    AtomicReference<Status> closedStatus = new AtomicReference<>();
    call.start(
        new ClientCall.Listener<ReadRowsResponse>() {
          @Override
          public void onClose(Status status, Metadata trailers) {
            closedStatus.set(status);
          }
        },
        new Metadata());
    call.cancel("caller cancelled", null);

    assertThat(channel.forwarded.get()).isFalse();
    assertThat(closedStatus.get().getCode()).isEqualTo(Status.Code.CANCELLED);
    assertThat(closedStatus.get().getDescription()).isEqualTo("caller cancelled");
  }

  private static <ReqT, RespT> void assertBlockedBySession(
      ClientInterceptor interceptor, MethodDescriptor<ReqT, RespT> method, ReqT request) {
    FakeChannel channel = new FakeChannel(null);
    Status status = invokeCall(interceptor, channel, method, request);
    assertThat(status.getCode()).isEqualTo(Status.Code.FAILED_PRECONDITION);
    assertThat(status.getDescription()).contains("Expected protocol SESSION");
    assertThat(channel.forwarded.get()).isFalse();
  }

  private static <ReqT, RespT> void assertAllowed(
      ClientInterceptor interceptor, MethodDescriptor<ReqT, RespT> method, ReqT request) {
    FakeChannel channel = new FakeChannel(null);
    Status status = invokeCall(interceptor, channel, method, request);
    assertThat(status.getCode()).isEqualTo(Status.Code.OK);
    assertThat(channel.forwarded.get()).isTrue();
  }

  private static <ReqT, RespT> Status invokeCall(
      ClientInterceptor interceptor,
      Channel channel,
      MethodDescriptor<ReqT, RespT> method,
      ReqT request) {
    ClientCall<ReqT, RespT> call = interceptor.interceptCall(method, CallOptions.DEFAULT, channel);
    AtomicReference<Status> closedStatus = new AtomicReference<>();
    call.start(
        new ClientCall.Listener<RespT>() {
          @Override
          public void onClose(Status status, Metadata trailers) {
            closedStatus.set(status);
          }
        },
        new Metadata());
    call.request(1);
    call.sendMessage(request);
    call.halfClose();
    return closedStatus.get();
  }

  private static final class FakeChannel extends Channel {
    @Nullable private final InetSocketAddress remoteAddr;
    private final AtomicBoolean forwarded = new AtomicBoolean();

    FakeChannel(@Nullable InetSocketAddress remoteAddr) {
      this.remoteAddr = remoteAddr;
    }

    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
        MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
      return new ClientCall<RequestT, ResponseT>() {
        private Listener<ResponseT> responseListener;

        @Override
        public void start(Listener<ResponseT> responseListener, Metadata headers) {
          forwarded.set(true);
          this.responseListener = responseListener;
        }

        @Override
        public void request(int numMessages) {}

        @Override
        public void cancel(@Nullable String message, @Nullable Throwable cause) {}

        @Override
        public void halfClose() {
          responseListener.onHeaders(new Metadata());
          responseListener.onClose(Status.OK, new Metadata());
        }

        @Override
        public void sendMessage(RequestT message) {}

        @Override
        public Attributes getAttributes() {
          Attributes.Builder builder = Attributes.newBuilder();
          if (remoteAddr != null) {
            builder.set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, remoteAddr);
          }
          return builder.build();
        }
      };
    }

    @Override
    public String authority() {
      return "fake-authority";
    }
  }
}
