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
package com.google.cloud.bigquery.storage.v1beta1.stub;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession;
import com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Enhanced stub class for BigQuery Storage API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
public class EnhancedBigQueryStorageStub implements BackgroundResource {

  private final GrpcBigQueryStorageStub stub;

  public static EnhancedBigQueryStorageStub create(EnhancedBigQueryStorageStubSettings settings)
      throws IOException {
    // Configure the base settings.
    BigQueryStorageStubSettings.Builder baseSettingsBuilder =
        BigQueryStorageStubSettings.newBuilder()
            .setTransportChannelProvider(settings.getTransportChannelProvider())
            .setEndpoint(settings.getEndpoint())
            .setHeaderProvider(settings.getHeaderProvider())
            .setCredentialsProvider(settings.getCredentialsProvider())
            .setStreamWatchdogCheckInterval(settings.getStreamWatchdogCheckInterval())
            .setStreamWatchdogProvider(settings.getStreamWatchdogProvider());

    // CreateReadSession is a simple pass-through.
    baseSettingsBuilder
        .createReadSessionSettings()
        .setRetryableCodes(settings.createReadSessionSettings().getRetryableCodes())
        .setRetrySettings(settings.createReadSessionSettings().getRetrySettings());

    // ReadRows is a simple pass-through.
    baseSettingsBuilder
        .readRowsSettings()
        .setRetryableCodes(settings.readRowsSettings().getRetryableCodes())
        .setRetrySettings(settings.readRowsSettings().getRetrySettings())
        .setResumptionStrategy(settings.readRowsSettings().getResumptionStrategy())
        .setIdleTimeout(settings.readRowsSettings().getIdleTimeout());

    // BatchCreateReadSessionStreams is a simple pass-through.
    baseSettingsBuilder
        .batchCreateReadSessionStreamsSettings()
        .setRetryableCodes(settings.batchCreateReadSessionStreamsSettings().getRetryableCodes())
        .setRetrySettings(settings.batchCreateReadSessionStreamsSettings().getRetrySettings());

    // FinalizeStream is a simple pass-through.
    baseSettingsBuilder
        .finalizeStreamSettings()
        .setRetryableCodes(settings.finalizeStreamSettings().getRetryableCodes())
        .setRetrySettings(settings.finalizeStreamSettings().getRetrySettings());

    // SplitReadStream is a simple pass-through.
    baseSettingsBuilder
        .splitReadStreamSettings()
        .setRetryableCodes(settings.splitReadStreamSettings().getRetryableCodes())
        .setRetrySettings(settings.splitReadStreamSettings().getRetrySettings());

    BigQueryStorageStubSettings baseSettings = baseSettingsBuilder.build();
    ClientContext clientContext = ClientContext.create(baseSettings);
    GrpcBigQueryStorageStub stub = new GrpcBigQueryStorageStub(baseSettings, clientContext);
    return new EnhancedBigQueryStorageStub(stub);
  }

  @InternalApi("Visible for testing")
  EnhancedBigQueryStorageStub(GrpcBigQueryStorageStub stub) {
    this.stub = stub;
  }

  public UnaryCallable<CreateReadSessionRequest, ReadSession> createReadSessionCallable() {
    return stub.createReadSessionCallable();
  }

  public ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> readRowsCallable() {
    return stub.readRowsCallable();
  }

  public UnaryCallable<BatchCreateReadSessionStreamsRequest, BatchCreateReadSessionStreamsResponse>
      batchCreateReadSessionStreamsCallable() {
    return stub.batchCreateReadSessionStreamsCallable();
  }

  public UnaryCallable<FinalizeStreamRequest, Empty> finalizeStreamCallable() {
    return stub.finalizeStreamCallable();
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
