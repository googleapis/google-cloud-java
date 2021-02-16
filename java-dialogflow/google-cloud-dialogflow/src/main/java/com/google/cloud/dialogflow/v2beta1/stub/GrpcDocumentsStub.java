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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.DocumentsClient.ListDocumentsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.CreateDocumentRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteDocumentRequest;
import com.google.cloud.dialogflow.v2beta1.Document;
import com.google.cloud.dialogflow.v2beta1.GetDocumentRequest;
import com.google.cloud.dialogflow.v2beta1.KnowledgeOperationMetadata;
import com.google.cloud.dialogflow.v2beta1.ListDocumentsRequest;
import com.google.cloud.dialogflow.v2beta1.ListDocumentsResponse;
import com.google.cloud.dialogflow.v2beta1.ReloadDocumentRequest;
import com.google.cloud.dialogflow.v2beta1.UpdateDocumentRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Documents service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDocumentsStub extends DocumentsStub {
  private static final MethodDescriptor<ListDocumentsRequest, ListDocumentsResponse>
      listDocumentsMethodDescriptor =
          MethodDescriptor.<ListDocumentsRequest, ListDocumentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Documents/ListDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDocumentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDocumentRequest, Document> getDocumentMethodDescriptor =
      MethodDescriptor.<GetDocumentRequest, Document>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.v2beta1.Documents/GetDocument")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDocumentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Document.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateDocumentRequest, Operation>
      createDocumentMethodDescriptor =
          MethodDescriptor.<CreateDocumentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Documents/CreateDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDocumentRequest, Operation>
      deleteDocumentMethodDescriptor =
          MethodDescriptor.<DeleteDocumentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Documents/DeleteDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDocumentRequest, Operation>
      updateDocumentMethodDescriptor =
          MethodDescriptor.<UpdateDocumentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Documents/UpdateDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReloadDocumentRequest, Operation>
      reloadDocumentMethodDescriptor =
          MethodDescriptor.<ReloadDocumentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Documents/ReloadDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReloadDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable;
  private final UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable;
  private final UnaryCallable<GetDocumentRequest, Document> getDocumentCallable;
  private final UnaryCallable<CreateDocumentRequest, Operation> createDocumentCallable;
  private final OperationCallable<CreateDocumentRequest, Document, KnowledgeOperationMetadata>
      createDocumentOperationCallable;
  private final UnaryCallable<DeleteDocumentRequest, Operation> deleteDocumentCallable;
  private final OperationCallable<DeleteDocumentRequest, Empty, KnowledgeOperationMetadata>
      deleteDocumentOperationCallable;
  private final UnaryCallable<UpdateDocumentRequest, Operation> updateDocumentCallable;
  private final OperationCallable<UpdateDocumentRequest, Document, KnowledgeOperationMetadata>
      updateDocumentOperationCallable;
  private final UnaryCallable<ReloadDocumentRequest, Operation> reloadDocumentCallable;
  private final OperationCallable<ReloadDocumentRequest, Document, KnowledgeOperationMetadata>
      reloadDocumentOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDocumentsStub create(DocumentsStubSettings settings) throws IOException {
    return new GrpcDocumentsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDocumentsStub create(ClientContext clientContext) throws IOException {
    return new GrpcDocumentsStub(DocumentsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDocumentsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDocumentsStub(
        DocumentsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDocumentsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDocumentsStub(DocumentsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDocumentsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDocumentsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDocumentsStub(
      DocumentsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListDocumentsRequest, ListDocumentsResponse> listDocumentsTransportSettings =
        GrpcCallSettings.<ListDocumentsRequest, ListDocumentsResponse>newBuilder()
            .setMethodDescriptor(listDocumentsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListDocumentsRequest>() {
                  @Override
                  public Map<String, String> extract(ListDocumentsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetDocumentRequest, Document> getDocumentTransportSettings =
        GrpcCallSettings.<GetDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(getDocumentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetDocumentRequest>() {
                  @Override
                  public Map<String, String> extract(GetDocumentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateDocumentRequest, Operation> createDocumentTransportSettings =
        GrpcCallSettings.<CreateDocumentRequest, Operation>newBuilder()
            .setMethodDescriptor(createDocumentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateDocumentRequest>() {
                  @Override
                  public Map<String, String> extract(CreateDocumentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteDocumentRequest, Operation> deleteDocumentTransportSettings =
        GrpcCallSettings.<DeleteDocumentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDocumentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteDocumentRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteDocumentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateDocumentRequest, Operation> updateDocumentTransportSettings =
        GrpcCallSettings.<UpdateDocumentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDocumentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateDocumentRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateDocumentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("document.name", String.valueOf(request.getDocument().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ReloadDocumentRequest, Operation> reloadDocumentTransportSettings =
        GrpcCallSettings.<ReloadDocumentRequest, Operation>newBuilder()
            .setMethodDescriptor(reloadDocumentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ReloadDocumentRequest>() {
                  @Override
                  public Map<String, String> extract(ReloadDocumentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();

    this.listDocumentsCallable =
        callableFactory.createUnaryCallable(
            listDocumentsTransportSettings, settings.listDocumentsSettings(), clientContext);
    this.listDocumentsPagedCallable =
        callableFactory.createPagedCallable(
            listDocumentsTransportSettings, settings.listDocumentsSettings(), clientContext);
    this.getDocumentCallable =
        callableFactory.createUnaryCallable(
            getDocumentTransportSettings, settings.getDocumentSettings(), clientContext);
    this.createDocumentCallable =
        callableFactory.createUnaryCallable(
            createDocumentTransportSettings, settings.createDocumentSettings(), clientContext);
    this.createDocumentOperationCallable =
        callableFactory.createOperationCallable(
            createDocumentTransportSettings,
            settings.createDocumentOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDocumentCallable =
        callableFactory.createUnaryCallable(
            deleteDocumentTransportSettings, settings.deleteDocumentSettings(), clientContext);
    this.deleteDocumentOperationCallable =
        callableFactory.createOperationCallable(
            deleteDocumentTransportSettings,
            settings.deleteDocumentOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDocumentCallable =
        callableFactory.createUnaryCallable(
            updateDocumentTransportSettings, settings.updateDocumentSettings(), clientContext);
    this.updateDocumentOperationCallable =
        callableFactory.createOperationCallable(
            updateDocumentTransportSettings,
            settings.updateDocumentOperationSettings(),
            clientContext,
            operationsStub);
    this.reloadDocumentCallable =
        callableFactory.createUnaryCallable(
            reloadDocumentTransportSettings, settings.reloadDocumentSettings(), clientContext);
    this.reloadDocumentOperationCallable =
        callableFactory.createOperationCallable(
            reloadDocumentTransportSettings,
            settings.reloadDocumentOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable() {
    return listDocumentsCallable;
  }

  public UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable() {
    return listDocumentsPagedCallable;
  }

  public UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    return getDocumentCallable;
  }

  public UnaryCallable<CreateDocumentRequest, Operation> createDocumentCallable() {
    return createDocumentCallable;
  }

  public OperationCallable<CreateDocumentRequest, Document, KnowledgeOperationMetadata>
      createDocumentOperationCallable() {
    return createDocumentOperationCallable;
  }

  public UnaryCallable<DeleteDocumentRequest, Operation> deleteDocumentCallable() {
    return deleteDocumentCallable;
  }

  public OperationCallable<DeleteDocumentRequest, Empty, KnowledgeOperationMetadata>
      deleteDocumentOperationCallable() {
    return deleteDocumentOperationCallable;
  }

  public UnaryCallable<UpdateDocumentRequest, Operation> updateDocumentCallable() {
    return updateDocumentCallable;
  }

  public OperationCallable<UpdateDocumentRequest, Document, KnowledgeOperationMetadata>
      updateDocumentOperationCallable() {
    return updateDocumentOperationCallable;
  }

  public UnaryCallable<ReloadDocumentRequest, Operation> reloadDocumentCallable() {
    return reloadDocumentCallable;
  }

  public OperationCallable<ReloadDocumentRequest, Document, KnowledgeOperationMetadata>
      reloadDocumentOperationCallable() {
    return reloadDocumentOperationCallable;
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
