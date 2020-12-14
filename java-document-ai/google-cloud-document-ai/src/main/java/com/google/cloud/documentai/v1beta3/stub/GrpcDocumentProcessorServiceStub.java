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

package com.google.cloud.documentai.v1beta3.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.documentai.v1beta3.BatchProcessMetadata;
import com.google.cloud.documentai.v1beta3.BatchProcessRequest;
import com.google.cloud.documentai.v1beta3.BatchProcessResponse;
import com.google.cloud.documentai.v1beta3.ProcessRequest;
import com.google.cloud.documentai.v1beta3.ProcessResponse;
import com.google.cloud.documentai.v1beta3.ReviewDocumentOperationMetadata;
import com.google.cloud.documentai.v1beta3.ReviewDocumentRequest;
import com.google.cloud.documentai.v1beta3.ReviewDocumentResponse;
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
 * gRPC stub implementation for the DocumentProcessorService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDocumentProcessorServiceStub extends DocumentProcessorServiceStub {
  private static final MethodDescriptor<ProcessRequest, ProcessResponse>
      processDocumentMethodDescriptor =
          MethodDescriptor.<ProcessRequest, ProcessResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/ProcessDocument")
              .setRequestMarshaller(ProtoUtils.marshaller(ProcessRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProcessResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchProcessRequest, Operation>
      batchProcessDocumentsMethodDescriptor =
          MethodDescriptor.<BatchProcessRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/BatchProcessDocuments")
              .setRequestMarshaller(ProtoUtils.marshaller(BatchProcessRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReviewDocumentRequest, Operation>
      reviewDocumentMethodDescriptor =
          MethodDescriptor.<ReviewDocumentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/ReviewDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReviewDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ProcessRequest, ProcessResponse> processDocumentCallable;
  private final UnaryCallable<BatchProcessRequest, Operation> batchProcessDocumentsCallable;
  private final OperationCallable<BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsOperationCallable;
  private final UnaryCallable<ReviewDocumentRequest, Operation> reviewDocumentCallable;
  private final OperationCallable<
          ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDocumentProcessorServiceStub create(
      DocumentProcessorServiceStubSettings settings) throws IOException {
    return new GrpcDocumentProcessorServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDocumentProcessorServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDocumentProcessorServiceStub(
        DocumentProcessorServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDocumentProcessorServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDocumentProcessorServiceStub(
        DocumentProcessorServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDocumentProcessorServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDocumentProcessorServiceStub(
      DocumentProcessorServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDocumentProcessorServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDocumentProcessorServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDocumentProcessorServiceStub(
      DocumentProcessorServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ProcessRequest, ProcessResponse> processDocumentTransportSettings =
        GrpcCallSettings.<ProcessRequest, ProcessResponse>newBuilder()
            .setMethodDescriptor(processDocumentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ProcessRequest>() {
                  @Override
                  public Map<String, String> extract(ProcessRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchProcessRequest, Operation> batchProcessDocumentsTransportSettings =
        GrpcCallSettings.<BatchProcessRequest, Operation>newBuilder()
            .setMethodDescriptor(batchProcessDocumentsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<BatchProcessRequest>() {
                  @Override
                  public Map<String, String> extract(BatchProcessRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ReviewDocumentRequest, Operation> reviewDocumentTransportSettings =
        GrpcCallSettings.<ReviewDocumentRequest, Operation>newBuilder()
            .setMethodDescriptor(reviewDocumentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ReviewDocumentRequest>() {
                  @Override
                  public Map<String, String> extract(ReviewDocumentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "human_review_config", String.valueOf(request.getHumanReviewConfig()));
                    return params.build();
                  }
                })
            .build();

    this.processDocumentCallable =
        callableFactory.createUnaryCallable(
            processDocumentTransportSettings, settings.processDocumentSettings(), clientContext);
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
    this.reviewDocumentCallable =
        callableFactory.createUnaryCallable(
            reviewDocumentTransportSettings, settings.reviewDocumentSettings(), clientContext);
    this.reviewDocumentOperationCallable =
        callableFactory.createOperationCallable(
            reviewDocumentTransportSettings,
            settings.reviewDocumentOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<ProcessRequest, ProcessResponse> processDocumentCallable() {
    return processDocumentCallable;
  }

  public UnaryCallable<BatchProcessRequest, Operation> batchProcessDocumentsCallable() {
    return batchProcessDocumentsCallable;
  }

  public OperationCallable<BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsOperationCallable() {
    return batchProcessDocumentsOperationCallable;
  }

  public UnaryCallable<ReviewDocumentRequest, Operation> reviewDocumentCallable() {
    return reviewDocumentCallable;
  }

  public OperationCallable<
          ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentOperationCallable() {
    return reviewDocumentOperationCallable;
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
