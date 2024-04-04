/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.DocumentServiceClient.ListDocumentsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.CreateDocumentRequest;
import com.google.cloud.discoveryengine.v1alpha.DeleteDocumentRequest;
import com.google.cloud.discoveryengine.v1alpha.Document;
import com.google.cloud.discoveryengine.v1alpha.GetDocumentRequest;
import com.google.cloud.discoveryengine.v1alpha.GetProcessedDocumentRequest;
import com.google.cloud.discoveryengine.v1alpha.ImportDocumentsMetadata;
import com.google.cloud.discoveryengine.v1alpha.ImportDocumentsRequest;
import com.google.cloud.discoveryengine.v1alpha.ImportDocumentsResponse;
import com.google.cloud.discoveryengine.v1alpha.ListDocumentsRequest;
import com.google.cloud.discoveryengine.v1alpha.ListDocumentsResponse;
import com.google.cloud.discoveryengine.v1alpha.ProcessedDocument;
import com.google.cloud.discoveryengine.v1alpha.PurgeDocumentsMetadata;
import com.google.cloud.discoveryengine.v1alpha.PurgeDocumentsRequest;
import com.google.cloud.discoveryengine.v1alpha.PurgeDocumentsResponse;
import com.google.cloud.discoveryengine.v1alpha.UpdateDocumentRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DocumentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDocumentServiceStub extends DocumentServiceStub {
  private static final MethodDescriptor<GetDocumentRequest, Document> getDocumentMethodDescriptor =
      MethodDescriptor.<GetDocumentRequest, Document>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.discoveryengine.v1alpha.DocumentService/GetDocument")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDocumentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Document.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListDocumentsRequest, ListDocumentsResponse>
      listDocumentsMethodDescriptor =
          MethodDescriptor.<ListDocumentsRequest, ListDocumentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.DocumentService/ListDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDocumentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDocumentRequest, Document>
      createDocumentMethodDescriptor =
          MethodDescriptor.<CreateDocumentRequest, Document>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.DocumentService/CreateDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Document.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDocumentRequest, Document>
      updateDocumentMethodDescriptor =
          MethodDescriptor.<UpdateDocumentRequest, Document>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.DocumentService/UpdateDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Document.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDocumentRequest, Empty>
      deleteDocumentMethodDescriptor =
          MethodDescriptor.<DeleteDocumentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.DocumentService/DeleteDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportDocumentsRequest, Operation>
      importDocumentsMethodDescriptor =
          MethodDescriptor.<ImportDocumentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.DocumentService/ImportDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PurgeDocumentsRequest, Operation>
      purgeDocumentsMethodDescriptor =
          MethodDescriptor.<PurgeDocumentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.DocumentService/PurgeDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PurgeDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProcessedDocumentRequest, ProcessedDocument>
      getProcessedDocumentMethodDescriptor =
          MethodDescriptor.<GetProcessedDocumentRequest, ProcessedDocument>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.DocumentService/GetProcessedDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetProcessedDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProcessedDocument.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetDocumentRequest, Document> getDocumentCallable;
  private final UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable;
  private final UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable;
  private final UnaryCallable<CreateDocumentRequest, Document> createDocumentCallable;
  private final UnaryCallable<UpdateDocumentRequest, Document> updateDocumentCallable;
  private final UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable;
  private final UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable;
  private final OperationCallable<
          ImportDocumentsRequest, ImportDocumentsResponse, ImportDocumentsMetadata>
      importDocumentsOperationCallable;
  private final UnaryCallable<PurgeDocumentsRequest, Operation> purgeDocumentsCallable;
  private final OperationCallable<
          PurgeDocumentsRequest, PurgeDocumentsResponse, PurgeDocumentsMetadata>
      purgeDocumentsOperationCallable;
  private final UnaryCallable<GetProcessedDocumentRequest, ProcessedDocument>
      getProcessedDocumentCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDocumentServiceStub create(DocumentServiceStubSettings settings)
      throws IOException {
    return new GrpcDocumentServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDocumentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDocumentServiceStub(
        DocumentServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDocumentServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDocumentServiceStub(
        DocumentServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDocumentServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDocumentServiceStub(
      DocumentServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDocumentServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDocumentServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDocumentServiceStub(
      DocumentServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetDocumentRequest, Document> getDocumentTransportSettings =
        GrpcCallSettings.<GetDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(getDocumentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDocumentsRequest, ListDocumentsResponse> listDocumentsTransportSettings =
        GrpcCallSettings.<ListDocumentsRequest, ListDocumentsResponse>newBuilder()
            .setMethodDescriptor(listDocumentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDocumentRequest, Document> createDocumentTransportSettings =
        GrpcCallSettings.<CreateDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(createDocumentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDocumentRequest, Document> updateDocumentTransportSettings =
        GrpcCallSettings.<UpdateDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(updateDocumentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("document.name", String.valueOf(request.getDocument().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDocumentRequest, Empty> deleteDocumentTransportSettings =
        GrpcCallSettings.<DeleteDocumentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDocumentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportDocumentsRequest, Operation> importDocumentsTransportSettings =
        GrpcCallSettings.<ImportDocumentsRequest, Operation>newBuilder()
            .setMethodDescriptor(importDocumentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<PurgeDocumentsRequest, Operation> purgeDocumentsTransportSettings =
        GrpcCallSettings.<PurgeDocumentsRequest, Operation>newBuilder()
            .setMethodDescriptor(purgeDocumentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetProcessedDocumentRequest, ProcessedDocument>
        getProcessedDocumentTransportSettings =
            GrpcCallSettings.<GetProcessedDocumentRequest, ProcessedDocument>newBuilder()
                .setMethodDescriptor(getProcessedDocumentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.getDocumentCallable =
        callableFactory.createUnaryCallable(
            getDocumentTransportSettings, settings.getDocumentSettings(), clientContext);
    this.listDocumentsCallable =
        callableFactory.createUnaryCallable(
            listDocumentsTransportSettings, settings.listDocumentsSettings(), clientContext);
    this.listDocumentsPagedCallable =
        callableFactory.createPagedCallable(
            listDocumentsTransportSettings, settings.listDocumentsSettings(), clientContext);
    this.createDocumentCallable =
        callableFactory.createUnaryCallable(
            createDocumentTransportSettings, settings.createDocumentSettings(), clientContext);
    this.updateDocumentCallable =
        callableFactory.createUnaryCallable(
            updateDocumentTransportSettings, settings.updateDocumentSettings(), clientContext);
    this.deleteDocumentCallable =
        callableFactory.createUnaryCallable(
            deleteDocumentTransportSettings, settings.deleteDocumentSettings(), clientContext);
    this.importDocumentsCallable =
        callableFactory.createUnaryCallable(
            importDocumentsTransportSettings, settings.importDocumentsSettings(), clientContext);
    this.importDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            importDocumentsTransportSettings,
            settings.importDocumentsOperationSettings(),
            clientContext,
            operationsStub);
    this.purgeDocumentsCallable =
        callableFactory.createUnaryCallable(
            purgeDocumentsTransportSettings, settings.purgeDocumentsSettings(), clientContext);
    this.purgeDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            purgeDocumentsTransportSettings,
            settings.purgeDocumentsOperationSettings(),
            clientContext,
            operationsStub);
    this.getProcessedDocumentCallable =
        callableFactory.createUnaryCallable(
            getProcessedDocumentTransportSettings,
            settings.getProcessedDocumentSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    return getDocumentCallable;
  }

  @Override
  public UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable() {
    return listDocumentsCallable;
  }

  @Override
  public UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable() {
    return listDocumentsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDocumentRequest, Document> createDocumentCallable() {
    return createDocumentCallable;
  }

  @Override
  public UnaryCallable<UpdateDocumentRequest, Document> updateDocumentCallable() {
    return updateDocumentCallable;
  }

  @Override
  public UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable() {
    return deleteDocumentCallable;
  }

  @Override
  public UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable() {
    return importDocumentsCallable;
  }

  @Override
  public OperationCallable<ImportDocumentsRequest, ImportDocumentsResponse, ImportDocumentsMetadata>
      importDocumentsOperationCallable() {
    return importDocumentsOperationCallable;
  }

  @Override
  public UnaryCallable<PurgeDocumentsRequest, Operation> purgeDocumentsCallable() {
    return purgeDocumentsCallable;
  }

  @Override
  public OperationCallable<PurgeDocumentsRequest, PurgeDocumentsResponse, PurgeDocumentsMetadata>
      purgeDocumentsOperationCallable() {
    return purgeDocumentsOperationCallable;
  }

  @Override
  public UnaryCallable<GetProcessedDocumentRequest, ProcessedDocument>
      getProcessedDocumentCallable() {
    return getProcessedDocumentCallable;
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
