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
package com.google.cloud.bigtable.data.v2.internal.compat.ops;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.auth.Credentials;
import com.google.bigtable.v2.ClientConfiguration;
import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.bigtable.v2.TelemetryConfiguration;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DebugTagTracer;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import io.grpc.Deadline;
import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivertingUnaryCallableTest {

  private ClientConfigurationManager configManager;
  private RecordingCallable<String, String> classic;
  private RecordingShim<String, String> experimental;
  private RecordingDebugTagTracer tracer;

  @BeforeEach
  void setUp() {
    configManager = mock(ClientConfigurationManager.class);
    stubSessionLoad(1.0f);
    classic = new RecordingCallable<>(ApiFutures.immediateFuture("classic"));
    experimental = new RecordingShim<>();
    tracer = new RecordingDebugTagTracer();
  }

  @Test
  void perRpcCredentials_fallsBackToClassicAndRecordsTag() throws Exception {
    DivertingUnaryCallable<String, String> callable = callable();
    GrpcCallContext ctx = GrpcCallContext.createDefault().withCredentials(new FakeCredentials());

    ApiFuture<String> result = callable.futureCall("req", ctx);

    assertThat(result.get()).isEqualTo("classic");
    assertThat(classic.capturedContexts).hasSize(1);
    assertThat(classic.capturedContexts.get(0)).isSameInstanceAs(ctx);
    assertThat(experimental.callCount).isEqualTo(0);
    assertThat(tracer.tags).containsExactly("per_rpc_credentials_session_fallback");
  }

  @Test
  void noPerRpcCredentials_routesToExperimental() {
    DivertingUnaryCallable<String, String> callable = callable();
    GrpcCallContext ctx = GrpcCallContext.createDefault();

    @SuppressWarnings("unused")
    ApiFuture<?> ignored = callable.futureCall("req", ctx);

    assertThat(classic.capturedContexts).isEmpty();
    assertThat(experimental.callCount).isEqualTo(1);
    assertThat(tracer.tags).isEmpty();
  }

  @Test
  void nullContext_routesToExperimental() {
    DivertingUnaryCallable<String, String> callable = callable();

    @SuppressWarnings("unused")
    ApiFuture<?> ignored = callable.futureCall("req", null);

    assertThat(classic.capturedContexts).isEmpty();
    assertThat(experimental.callCount).isEqualTo(1);
    assertThat(tracer.tags).isEmpty();
  }

  @Test
  void sessionLoadZero_routesToClassicWithoutCredentialsCheck() throws Exception {
    stubSessionLoad(0.0f);
    DivertingUnaryCallable<String, String> callable = callable();
    GrpcCallContext ctx = GrpcCallContext.createDefault().withCredentials(mock(Credentials.class));

    ApiFuture<String> result = callable.futureCall("req", ctx);

    assertThat(result.get()).isEqualTo("classic");
    assertThat(classic.capturedContexts).hasSize(1);
    assertThat(experimental.callCount).isEqualTo(0);
    assertThat(tracer.tags).isEmpty();
  }

  // --- helpers ---

  private DivertingUnaryCallable<String, String> callable() {
    return new DivertingUnaryCallable<>(
        configManager, classic, experimental, Duration.ofSeconds(10), tracer);
  }

  private void stubSessionLoad(float load) {
    ClientConfiguration config =
        ClientConfiguration.newBuilder()
            .setSessionConfiguration(SessionClientConfiguration.newBuilder().setSessionLoad(load))
            .build();
    when(configManager.getClientConfiguration()).thenReturn(config);
  }

  private static class RecordingCallable<ReqT, RespT> extends UnaryCallable<ReqT, RespT> {
    final List<ApiCallContext> capturedContexts = new ArrayList<>();
    private final ApiFuture<RespT> response;

    RecordingCallable(ApiFuture<RespT> response) {
      this.response = response;
    }

    @Override
    public ApiFuture<RespT> futureCall(ReqT request, ApiCallContext context) {
      capturedContexts.add(context);
      return response;
    }
  }

  private static class RecordingShim<ReqT, RespT> implements UnaryShim<ReqT, RespT> {
    int callCount;

    @Override
    public CompletableFuture<RespT> call(ReqT request, Deadline deadline) {
      callCount++;
      return new CompletableFuture<>(); // never completes — test doesn't wait on it
    }

    @Override
    public void close() {}
  }

  private static class FakeCredentials extends Credentials {
    @Override
    public String getAuthenticationType() {
      return "fake";
    }

    @Override
    public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
      return Map.of();
    }

    @Override
    public boolean hasRequestMetadata() {
      return false;
    }

    @Override
    public boolean hasRequestMetadataOnly() {
      return false;
    }

    @Override
    public void refresh() {}
  }

  private static class RecordingDebugTagTracer extends DebugTagTracer {
    final List<String> tags = new ArrayList<>();

    @Override
    public void record(TelemetryConfiguration.Level level, String tag) {
      tags.add(tag);
    }

    @Override
    public void setClientConfigurationManager(ClientConfigurationManager manager) {}
  }
}
