/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.storage.v1.stub;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1.ReadSession;
import com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest;
import com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Enhanced stub class for BigQuery Storage API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
public class EnhancedBigQueryReadStub implements BackgroundResource {
  private final GrpcBigQueryReadStub stub;

  public static EnhancedBigQueryReadStub create(EnhancedBigQueryReadStubSettings settings)
      throws IOException {
    // Configure the base settings.
    BigQueryReadStubSettings.Builder baseSettingsBuilder =
        BigQueryReadStubSettings.newBuilder()
            .setTransportChannelProvider(settings.getTransportChannelProvider())
            .setEndpoint(settings.getEndpoint())
            .setHeaderProvider(settings.getHeaderProvider())
            .setCredentialsProvider(settings.getCredentialsProvider())
            .setStreamWatchdogCheckInterval(settings.getStreamWatchdogCheckInterval())
            .setStreamWatchdogProvider(settings.getStreamWatchdogProvider());

    baseSettingsBuilder
        .createReadSessionSettings()
        .setRetryableCodes(settings.createReadSessionSettings().getRetryableCodes())
        .setRetrySettings(settings.createReadSessionSettings().getRetrySettings());

    baseSettingsBuilder
        .readRowsSettings()
        .setRetryableCodes(settings.readRowsSettings().getRetryableCodes())
        .setRetrySettings(settings.readRowsSettings().getRetrySettings())
        .setResumptionStrategy(settings.readRowsSettings().getResumptionStrategy())
        .setIdleTimeout(settings.readRowsSettings().getIdleTimeout());

    baseSettingsBuilder
        .splitReadStreamSettings()
        .setRetryableCodes(settings.splitReadStreamSettings().getRetryableCodes())
        .setRetrySettings(settings.splitReadStreamSettings().getRetrySettings());

    BigQueryReadStubSettings baseSettings = baseSettingsBuilder.build();
    ClientContext clientContext = ClientContext.create(baseSettings);
    GrpcBigQueryReadStub stub = new GrpcBigQueryReadStub(baseSettings, clientContext);
    return new EnhancedBigQueryReadStub(stub);
  }

  @InternalApi("Visible for testing")
  EnhancedBigQueryReadStub(GrpcBigQueryReadStub stub) {
    this.stub = stub;
  }

  public UnaryCallable<CreateReadSessionRequest, ReadSession> createReadSessionCallable() {
    return stub.createReadSessionCallable();
  }

  public ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> readRowsCallable() {
    return stub.readRowsCallable();
  }

  public UnaryCallable<SplitReadStreamRequest, SplitReadStreamResponse> splitReadStreamCallable() {
    return stub.splitReadStreamCallable();
  }

  @Override
  public void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }
}
