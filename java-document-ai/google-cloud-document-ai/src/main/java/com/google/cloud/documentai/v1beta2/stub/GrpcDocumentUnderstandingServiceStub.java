/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.documentai.v1beta2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest;
import com.google.cloud.documentai.v1beta2.BatchProcessDocumentsResponse;
import com.google.cloud.documentai.v1beta2.Document;
import com.google.cloud.documentai.v1beta2.OperationMetadata;
import com.google.cloud.documentai.v1beta2.ProcessDocumentRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DocumentUnderstandingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDocumentUnderstandingServiceStub extends DocumentUnderstandingServiceStub {
  private static final MethodDescriptor<BatchProcessDocumentsRequest, Operation>
      batchProcessDocumentsMethodDescriptor =
          MethodDescriptor.<BatchProcessDocumentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta2.DocumentUnderstandingService/BatchProcessDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchProcessDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ProcessDocumentRequest, Document>
      processDocumentMethodDescriptor =
          MethodDescriptor.<ProcessDocumentRequest, Document>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta2.DocumentUnderstandingService/ProcessDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ProcessDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Document.getDefaultInstance()))
              .build();

  private final UnaryCallable<BatchProcessDocumentsRequest, Operation>
      batchProcessDocumentsCallable;
  private final OperationCallable<
          BatchProcessDocumentsRequest, BatchProcessDocumentsResponse, OperationMetadata>
      batchProcessDocumentsOperationCallable;
  private final UnaryCallable<ProcessDocumentRequest, Document> processDocumentCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDocumentUnderstandingServiceStub create(
      DocumentUnderstandingServiceStubSettings settings) throws IOException {
    return new GrpcDocumentUnderstandingServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDocumentUnderstandingServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDocumentUnderstandingServiceStub(
        DocumentUnderstandingServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDocumentUnderstandingServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDocumentUnderstandingServiceStub(
        DocumentUnderstandingServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcDocumentUnderstandingServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDocumentUnderstandingServiceStub(
      DocumentUnderstandingServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDocumentUnderstandingServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDocumentUnderstandingServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDocumentUnderstandingServiceStub(
      DocumentUnderstandingServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<BatchProcessDocumentsRequest, Operation>
        batchProcessDocumentsTransportSettings =
            GrpcCallSettings.<BatchProcessDocumentsRequest, Operation>newBuilder()
                .setMethodDescriptor(batchProcessDocumentsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<BatchProcessDocumentsRequest>() {
                      @Override
                      public Map<String, String> extract(BatchProcessDocumentsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ProcessDocumentRequest, Document> processDocumentTransportSettings =
        GrpcCallSettings.<ProcessDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(processDocumentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ProcessDocumentRequest>() {
                  @Override
                  public Map<String, String> extract(ProcessDocumentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();

    this.batchProcessDocumentsCallable =
        callableFactory.createUnaryCallable(
            batchProcessDocumentsTransportSettings,
            settings.batchProcessDocumentsSettings(),
            clientContext);
    this.batchProcessDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            batchProcessDocumentsTransportSettings,
            settings.batchProcessDocumentsOperationSettings(),
            clientContext,
            operationsStub);
    this.processDocumentCallable =
        callableFactory.createUnaryCallable(
            processDocumentTransportSettings, settings.processDocumentSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<BatchProcessDocumentsRequest, Operation> batchProcessDocumentsCallable() {
    return batchProcessDocumentsCallable;
  }

  public OperationCallable<
          BatchProcessDocumentsRequest, BatchProcessDocumentsResponse, OperationMetadata>
      batchProcessDocumentsOperationCallable() {
    return batchProcessDocumentsOperationCallable;
  }

  public UnaryCallable<ProcessDocumentRequest, Document> processDocumentCallable() {
    return processDocumentCallable;
  }

  @Override
  public final void close() {
    shutdown();
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
