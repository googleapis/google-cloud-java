/*
 * Copyright 2026 Google LLC
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

package com.google.developers.knowledge.v1.stub;

import static com.google.developers.knowledge.v1.DeveloperKnowledgeClient.SearchDocumentChunksPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.developers.knowledge.v1.BatchGetDocumentsRequest;
import com.google.developers.knowledge.v1.BatchGetDocumentsResponse;
import com.google.developers.knowledge.v1.Document;
import com.google.developers.knowledge.v1.GetDocumentRequest;
import com.google.developers.knowledge.v1.SearchDocumentChunksRequest;
import com.google.developers.knowledge.v1.SearchDocumentChunksResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DeveloperKnowledge service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDeveloperKnowledgeStub extends DeveloperKnowledgeStub {
  private static final MethodDescriptor<SearchDocumentChunksRequest, SearchDocumentChunksResponse>
      searchDocumentChunksMethodDescriptor =
          MethodDescriptor.<SearchDocumentChunksRequest, SearchDocumentChunksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.developers.knowledge.v1.DeveloperKnowledge/SearchDocumentChunks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchDocumentChunksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchDocumentChunksResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDocumentRequest, Document> getDocumentMethodDescriptor =
      MethodDescriptor.<GetDocumentRequest, Document>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.developers.knowledge.v1.DeveloperKnowledge/GetDocument")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDocumentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Document.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsMethodDescriptor =
          MethodDescriptor.<BatchGetDocumentsRequest, BatchGetDocumentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.developers.knowledge.v1.DeveloperKnowledge/BatchGetDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchGetDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchGetDocumentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<SearchDocumentChunksRequest, SearchDocumentChunksResponse>
      searchDocumentChunksCallable;
  private final UnaryCallable<SearchDocumentChunksRequest, SearchDocumentChunksPagedResponse>
      searchDocumentChunksPagedCallable;
  private final UnaryCallable<GetDocumentRequest, Document> getDocumentCallable;
  private final UnaryCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDeveloperKnowledgeStub create(DeveloperKnowledgeStubSettings settings)
      throws IOException {
    return new GrpcDeveloperKnowledgeStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDeveloperKnowledgeStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDeveloperKnowledgeStub(
        DeveloperKnowledgeStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDeveloperKnowledgeStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDeveloperKnowledgeStub(
        DeveloperKnowledgeStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDeveloperKnowledgeStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDeveloperKnowledgeStub(
      DeveloperKnowledgeStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDeveloperKnowledgeCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDeveloperKnowledgeStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDeveloperKnowledgeStub(
      DeveloperKnowledgeStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SearchDocumentChunksRequest, SearchDocumentChunksResponse>
        searchDocumentChunksTransportSettings =
            GrpcCallSettings.<SearchDocumentChunksRequest, SearchDocumentChunksResponse>newBuilder()
                .setMethodDescriptor(searchDocumentChunksMethodDescriptor)
                .build();
    GrpcCallSettings<GetDocumentRequest, Document> getDocumentTransportSettings =
        GrpcCallSettings.<GetDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(getDocumentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
        batchGetDocumentsTransportSettings =
            GrpcCallSettings.<BatchGetDocumentsRequest, BatchGetDocumentsResponse>newBuilder()
                .setMethodDescriptor(batchGetDocumentsMethodDescriptor)
                .build();

    this.searchDocumentChunksCallable =
        callableFactory.createUnaryCallable(
            searchDocumentChunksTransportSettings,
            settings.searchDocumentChunksSettings(),
            clientContext);
    this.searchDocumentChunksPagedCallable =
        callableFactory.createPagedCallable(
            searchDocumentChunksTransportSettings,
            settings.searchDocumentChunksSettings(),
            clientContext);
    this.getDocumentCallable =
        callableFactory.createUnaryCallable(
            getDocumentTransportSettings, settings.getDocumentSettings(), clientContext);
    this.batchGetDocumentsCallable =
        callableFactory.createUnaryCallable(
            batchGetDocumentsTransportSettings,
            settings.batchGetDocumentsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SearchDocumentChunksRequest, SearchDocumentChunksResponse>
      searchDocumentChunksCallable() {
    return searchDocumentChunksCallable;
  }

  @Override
  public UnaryCallable<SearchDocumentChunksRequest, SearchDocumentChunksPagedResponse>
      searchDocumentChunksPagedCallable() {
    return searchDocumentChunksPagedCallable;
  }

  @Override
  public UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    return getDocumentCallable;
  }

  @Override
  public UnaryCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable() {
    return batchGetDocumentsCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
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
