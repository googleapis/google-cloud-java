/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.contentwarehouse.v1.stub;

import static com.google.cloud.contentwarehouse.v1.DocumentServiceClient.SearchDocumentsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contentwarehouse.v1.CreateDocumentRequest;
import com.google.cloud.contentwarehouse.v1.CreateDocumentResponse;
import com.google.cloud.contentwarehouse.v1.DeleteDocumentRequest;
import com.google.cloud.contentwarehouse.v1.Document;
import com.google.cloud.contentwarehouse.v1.FetchAclRequest;
import com.google.cloud.contentwarehouse.v1.FetchAclResponse;
import com.google.cloud.contentwarehouse.v1.GetDocumentRequest;
import com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest;
import com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse;
import com.google.cloud.contentwarehouse.v1.SetAclRequest;
import com.google.cloud.contentwarehouse.v1.SetAclResponse;
import com.google.cloud.contentwarehouse.v1.UpdateDocumentRequest;
import com.google.cloud.contentwarehouse.v1.UpdateDocumentResponse;
import com.google.common.collect.ImmutableMap;
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
@Generated("by gapic-generator-java")
public class GrpcDocumentServiceStub extends DocumentServiceStub {
  private static final MethodDescriptor<CreateDocumentRequest, CreateDocumentResponse>
      createDocumentMethodDescriptor =
          MethodDescriptor.<CreateDocumentRequest, CreateDocumentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.contentwarehouse.v1.DocumentService/CreateDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CreateDocumentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDocumentRequest, Document> getDocumentMethodDescriptor =
      MethodDescriptor.<GetDocumentRequest, Document>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.contentwarehouse.v1.DocumentService/GetDocument")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDocumentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Document.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateDocumentRequest, UpdateDocumentResponse>
      updateDocumentMethodDescriptor =
          MethodDescriptor.<UpdateDocumentRequest, UpdateDocumentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.contentwarehouse.v1.DocumentService/UpdateDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UpdateDocumentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDocumentRequest, Empty>
      deleteDocumentMethodDescriptor =
          MethodDescriptor.<DeleteDocumentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.contentwarehouse.v1.DocumentService/DeleteDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchDocumentsRequest, SearchDocumentsResponse>
      searchDocumentsMethodDescriptor =
          MethodDescriptor.<SearchDocumentsRequest, SearchDocumentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.contentwarehouse.v1.DocumentService/SearchDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchDocumentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchAclRequest, FetchAclResponse>
      fetchAclMethodDescriptor =
          MethodDescriptor.<FetchAclRequest, FetchAclResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.contentwarehouse.v1.DocumentService/FetchAcl")
              .setRequestMarshaller(ProtoUtils.marshaller(FetchAclRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FetchAclResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetAclRequest, SetAclResponse> setAclMethodDescriptor =
      MethodDescriptor.<SetAclRequest, SetAclResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.contentwarehouse.v1.DocumentService/SetAcl")
          .setRequestMarshaller(ProtoUtils.marshaller(SetAclRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(SetAclResponse.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateDocumentRequest, CreateDocumentResponse> createDocumentCallable;
  private final UnaryCallable<GetDocumentRequest, Document> getDocumentCallable;
  private final UnaryCallable<UpdateDocumentRequest, UpdateDocumentResponse> updateDocumentCallable;
  private final UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable;
  private final UnaryCallable<SearchDocumentsRequest, SearchDocumentsResponse>
      searchDocumentsCallable;
  private final UnaryCallable<SearchDocumentsRequest, SearchDocumentsPagedResponse>
      searchDocumentsPagedCallable;
  private final UnaryCallable<FetchAclRequest, FetchAclResponse> fetchAclCallable;
  private final UnaryCallable<SetAclRequest, SetAclResponse> setAclCallable;

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

    GrpcCallSettings<CreateDocumentRequest, CreateDocumentResponse>
        createDocumentTransportSettings =
            GrpcCallSettings.<CreateDocumentRequest, CreateDocumentResponse>newBuilder()
                .setMethodDescriptor(createDocumentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetDocumentRequest, Document> getDocumentTransportSettings =
        GrpcCallSettings.<GetDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(getDocumentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateDocumentRequest, UpdateDocumentResponse>
        updateDocumentTransportSettings =
            GrpcCallSettings.<UpdateDocumentRequest, UpdateDocumentResponse>newBuilder()
                .setMethodDescriptor(updateDocumentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteDocumentRequest, Empty> deleteDocumentTransportSettings =
        GrpcCallSettings.<DeleteDocumentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDocumentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SearchDocumentsRequest, SearchDocumentsResponse>
        searchDocumentsTransportSettings =
            GrpcCallSettings.<SearchDocumentsRequest, SearchDocumentsResponse>newBuilder()
                .setMethodDescriptor(searchDocumentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<FetchAclRequest, FetchAclResponse> fetchAclTransportSettings =
        GrpcCallSettings.<FetchAclRequest, FetchAclResponse>newBuilder()
            .setMethodDescriptor(fetchAclMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetAclRequest, SetAclResponse> setAclTransportSettings =
        GrpcCallSettings.<SetAclRequest, SetAclResponse>newBuilder()
            .setMethodDescriptor(setAclMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();

    this.createDocumentCallable =
        callableFactory.createUnaryCallable(
            createDocumentTransportSettings, settings.createDocumentSettings(), clientContext);
    this.getDocumentCallable =
        callableFactory.createUnaryCallable(
            getDocumentTransportSettings, settings.getDocumentSettings(), clientContext);
    this.updateDocumentCallable =
        callableFactory.createUnaryCallable(
            updateDocumentTransportSettings, settings.updateDocumentSettings(), clientContext);
    this.deleteDocumentCallable =
        callableFactory.createUnaryCallable(
            deleteDocumentTransportSettings, settings.deleteDocumentSettings(), clientContext);
    this.searchDocumentsCallable =
        callableFactory.createUnaryCallable(
            searchDocumentsTransportSettings, settings.searchDocumentsSettings(), clientContext);
    this.searchDocumentsPagedCallable =
        callableFactory.createPagedCallable(
            searchDocumentsTransportSettings, settings.searchDocumentsSettings(), clientContext);
    this.fetchAclCallable =
        callableFactory.createUnaryCallable(
            fetchAclTransportSettings, settings.fetchAclSettings(), clientContext);
    this.setAclCallable =
        callableFactory.createUnaryCallable(
            setAclTransportSettings, settings.setAclSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateDocumentRequest, CreateDocumentResponse> createDocumentCallable() {
    return createDocumentCallable;
  }

  @Override
  public UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    return getDocumentCallable;
  }

  @Override
  public UnaryCallable<UpdateDocumentRequest, UpdateDocumentResponse> updateDocumentCallable() {
    return updateDocumentCallable;
  }

  @Override
  public UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable() {
    return deleteDocumentCallable;
  }

  @Override
  public UnaryCallable<SearchDocumentsRequest, SearchDocumentsResponse> searchDocumentsCallable() {
    return searchDocumentsCallable;
  }

  @Override
  public UnaryCallable<SearchDocumentsRequest, SearchDocumentsPagedResponse>
      searchDocumentsPagedCallable() {
    return searchDocumentsPagedCallable;
  }

  @Override
  public UnaryCallable<FetchAclRequest, FetchAclResponse> fetchAclCallable() {
    return fetchAclCallable;
  }

  @Override
  public UnaryCallable<SetAclRequest, SetAclResponse> setAclCallable() {
    return setAclCallable;
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
