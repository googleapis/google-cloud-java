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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
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
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the DocumentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonDocumentServiceStub extends DocumentServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateDocumentRequest, CreateDocumentResponse>
      createDocumentMethodDescriptor =
          ApiMethodDescriptor.<CreateDocumentRequest, CreateDocumentResponse>newBuilder()
              .setFullMethodName("google.cloud.contentwarehouse.v1.DocumentService/CreateDocument")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDocumentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/documents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CreateDocumentResponse>newBuilder()
                      .setDefaultInstance(CreateDocumentResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDocumentRequest, Document>
      getDocumentMethodDescriptor =
          ApiMethodDescriptor.<GetDocumentRequest, Document>newBuilder()
              .setFullMethodName("google.cloud.contentwarehouse.v1.DocumentService/GetDocument")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDocumentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/documents/*}:get",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/documents/referenceId/*}:get")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Document>newBuilder()
                      .setDefaultInstance(Document.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDocumentRequest, UpdateDocumentResponse>
      updateDocumentMethodDescriptor =
          ApiMethodDescriptor.<UpdateDocumentRequest, UpdateDocumentResponse>newBuilder()
              .setFullMethodName("google.cloud.contentwarehouse.v1.DocumentService/UpdateDocument")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDocumentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/documents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/documents/referenceId/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UpdateDocumentResponse>newBuilder()
                      .setDefaultInstance(UpdateDocumentResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDocumentRequest, Empty>
      deleteDocumentMethodDescriptor =
          ApiMethodDescriptor.<DeleteDocumentRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.contentwarehouse.v1.DocumentService/DeleteDocument")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDocumentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/documents/*}:delete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/documents/referenceId/*}:delete")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchDocumentsRequest, SearchDocumentsResponse>
      searchDocumentsMethodDescriptor =
          ApiMethodDescriptor.<SearchDocumentsRequest, SearchDocumentsResponse>newBuilder()
              .setFullMethodName("google.cloud.contentwarehouse.v1.DocumentService/SearchDocuments")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchDocumentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/documents:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchDocumentsResponse>newBuilder()
                      .setDefaultInstance(SearchDocumentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FetchAclRequest, FetchAclResponse>
      fetchAclMethodDescriptor =
          ApiMethodDescriptor.<FetchAclRequest, FetchAclResponse>newBuilder()
              .setFullMethodName("google.cloud.contentwarehouse.v1.DocumentService/FetchAcl")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchAclRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/documents/*}:fetchAcl",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchAclRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{resource=projects/*}:fetchAcl")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchAclRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchAclResponse>newBuilder()
                      .setDefaultInstance(FetchAclResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetAclRequest, SetAclResponse> setAclMethodDescriptor =
      ApiMethodDescriptor.<SetAclRequest, SetAclResponse>newBuilder()
          .setFullMethodName("google.cloud.contentwarehouse.v1.DocumentService/SetAcl")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<SetAclRequest>newBuilder()
                  .setPath(
                      "/v1/{resource=projects/*/locations/*/documents/*}:setAcl",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<SetAclRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "resource", request.getResource());
                        return fields;
                      })
                  .setAdditionalPaths("/v1/{resource=projects/*}:setAcl")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<SetAclRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearResource().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<SetAclResponse>newBuilder()
                  .setDefaultInstance(SetAclResponse.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
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
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDocumentServiceStub create(DocumentServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDocumentServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDocumentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDocumentServiceStub(
        DocumentServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDocumentServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDocumentServiceStub(
        DocumentServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDocumentServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDocumentServiceStub(
      DocumentServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDocumentServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDocumentServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDocumentServiceStub(
      DocumentServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateDocumentRequest, CreateDocumentResponse>
        createDocumentTransportSettings =
            HttpJsonCallSettings.<CreateDocumentRequest, CreateDocumentResponse>newBuilder()
                .setMethodDescriptor(createDocumentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetDocumentRequest, Document> getDocumentTransportSettings =
        HttpJsonCallSettings.<GetDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(getDocumentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateDocumentRequest, UpdateDocumentResponse>
        updateDocumentTransportSettings =
            HttpJsonCallSettings.<UpdateDocumentRequest, UpdateDocumentResponse>newBuilder()
                .setMethodDescriptor(updateDocumentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteDocumentRequest, Empty> deleteDocumentTransportSettings =
        HttpJsonCallSettings.<DeleteDocumentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDocumentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SearchDocumentsRequest, SearchDocumentsResponse>
        searchDocumentsTransportSettings =
            HttpJsonCallSettings.<SearchDocumentsRequest, SearchDocumentsResponse>newBuilder()
                .setMethodDescriptor(searchDocumentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<FetchAclRequest, FetchAclResponse> fetchAclTransportSettings =
        HttpJsonCallSettings.<FetchAclRequest, FetchAclResponse>newBuilder()
            .setMethodDescriptor(fetchAclMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetAclRequest, SetAclResponse> setAclTransportSettings =
        HttpJsonCallSettings.<SetAclRequest, SetAclResponse>newBuilder()
            .setMethodDescriptor(setAclMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createDocumentMethodDescriptor);
    methodDescriptors.add(getDocumentMethodDescriptor);
    methodDescriptors.add(updateDocumentMethodDescriptor);
    methodDescriptors.add(deleteDocumentMethodDescriptor);
    methodDescriptors.add(searchDocumentsMethodDescriptor);
    methodDescriptors.add(fetchAclMethodDescriptor);
    methodDescriptors.add(setAclMethodDescriptor);
    return methodDescriptors;
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
