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

import static com.google.cloud.contentwarehouse.v1.DocumentSchemaServiceClient.ListDocumentSchemasPagedResponse;

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
import com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest;
import com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest;
import com.google.cloud.contentwarehouse.v1.DocumentSchema;
import com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest;
import com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest;
import com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse;
import com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest;
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
 * REST stub implementation for the DocumentSchemaService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonDocumentSchemaServiceStub extends DocumentSchemaServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateDocumentSchemaRequest, DocumentSchema>
      createDocumentSchemaMethodDescriptor =
          ApiMethodDescriptor.<CreateDocumentSchemaRequest, DocumentSchema>newBuilder()
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentSchemaService/CreateDocumentSchema")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDocumentSchemaRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/documentSchemas",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDocumentSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDocumentSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("documentSchema", request.getDocumentSchema(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DocumentSchema>newBuilder()
                      .setDefaultInstance(DocumentSchema.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDocumentSchemaRequest, DocumentSchema>
      updateDocumentSchemaMethodDescriptor =
          ApiMethodDescriptor.<UpdateDocumentSchemaRequest, DocumentSchema>newBuilder()
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentSchemaService/UpdateDocumentSchema")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDocumentSchemaRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/documentSchemas/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDocumentSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDocumentSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DocumentSchema>newBuilder()
                      .setDefaultInstance(DocumentSchema.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDocumentSchemaRequest, DocumentSchema>
      getDocumentSchemaMethodDescriptor =
          ApiMethodDescriptor.<GetDocumentSchemaRequest, DocumentSchema>newBuilder()
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentSchemaService/GetDocumentSchema")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDocumentSchemaRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/documentSchemas/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDocumentSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDocumentSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DocumentSchema>newBuilder()
                      .setDefaultInstance(DocumentSchema.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDocumentSchemaRequest, Empty>
      deleteDocumentSchemaMethodDescriptor =
          ApiMethodDescriptor.<DeleteDocumentSchemaRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentSchemaService/DeleteDocumentSchema")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDocumentSchemaRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/documentSchemas/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDocumentSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDocumentSchemaRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDocumentSchemasRequest, ListDocumentSchemasResponse>
      listDocumentSchemasMethodDescriptor =
          ApiMethodDescriptor.<ListDocumentSchemasRequest, ListDocumentSchemasResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentSchemaService/ListDocumentSchemas")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDocumentSchemasRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/documentSchemas",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDocumentSchemasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDocumentSchemasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDocumentSchemasResponse>newBuilder()
                      .setDefaultInstance(ListDocumentSchemasResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateDocumentSchemaRequest, DocumentSchema>
      createDocumentSchemaCallable;
  private final UnaryCallable<UpdateDocumentSchemaRequest, DocumentSchema>
      updateDocumentSchemaCallable;
  private final UnaryCallable<GetDocumentSchemaRequest, DocumentSchema> getDocumentSchemaCallable;
  private final UnaryCallable<DeleteDocumentSchemaRequest, Empty> deleteDocumentSchemaCallable;
  private final UnaryCallable<ListDocumentSchemasRequest, ListDocumentSchemasResponse>
      listDocumentSchemasCallable;
  private final UnaryCallable<ListDocumentSchemasRequest, ListDocumentSchemasPagedResponse>
      listDocumentSchemasPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDocumentSchemaServiceStub create(
      DocumentSchemaServiceStubSettings settings) throws IOException {
    return new HttpJsonDocumentSchemaServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDocumentSchemaServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDocumentSchemaServiceStub(
        DocumentSchemaServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDocumentSchemaServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDocumentSchemaServiceStub(
        DocumentSchemaServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDocumentSchemaServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDocumentSchemaServiceStub(
      DocumentSchemaServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDocumentSchemaServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDocumentSchemaServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDocumentSchemaServiceStub(
      DocumentSchemaServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateDocumentSchemaRequest, DocumentSchema>
        createDocumentSchemaTransportSettings =
            HttpJsonCallSettings.<CreateDocumentSchemaRequest, DocumentSchema>newBuilder()
                .setMethodDescriptor(createDocumentSchemaMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateDocumentSchemaRequest, DocumentSchema>
        updateDocumentSchemaTransportSettings =
            HttpJsonCallSettings.<UpdateDocumentSchemaRequest, DocumentSchema>newBuilder()
                .setMethodDescriptor(updateDocumentSchemaMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetDocumentSchemaRequest, DocumentSchema>
        getDocumentSchemaTransportSettings =
            HttpJsonCallSettings.<GetDocumentSchemaRequest, DocumentSchema>newBuilder()
                .setMethodDescriptor(getDocumentSchemaMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteDocumentSchemaRequest, Empty> deleteDocumentSchemaTransportSettings =
        HttpJsonCallSettings.<DeleteDocumentSchemaRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDocumentSchemaMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListDocumentSchemasRequest, ListDocumentSchemasResponse>
        listDocumentSchemasTransportSettings =
            HttpJsonCallSettings
                .<ListDocumentSchemasRequest, ListDocumentSchemasResponse>newBuilder()
                .setMethodDescriptor(listDocumentSchemasMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createDocumentSchemaCallable =
        callableFactory.createUnaryCallable(
            createDocumentSchemaTransportSettings,
            settings.createDocumentSchemaSettings(),
            clientContext);
    this.updateDocumentSchemaCallable =
        callableFactory.createUnaryCallable(
            updateDocumentSchemaTransportSettings,
            settings.updateDocumentSchemaSettings(),
            clientContext);
    this.getDocumentSchemaCallable =
        callableFactory.createUnaryCallable(
            getDocumentSchemaTransportSettings,
            settings.getDocumentSchemaSettings(),
            clientContext);
    this.deleteDocumentSchemaCallable =
        callableFactory.createUnaryCallable(
            deleteDocumentSchemaTransportSettings,
            settings.deleteDocumentSchemaSettings(),
            clientContext);
    this.listDocumentSchemasCallable =
        callableFactory.createUnaryCallable(
            listDocumentSchemasTransportSettings,
            settings.listDocumentSchemasSettings(),
            clientContext);
    this.listDocumentSchemasPagedCallable =
        callableFactory.createPagedCallable(
            listDocumentSchemasTransportSettings,
            settings.listDocumentSchemasSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createDocumentSchemaMethodDescriptor);
    methodDescriptors.add(updateDocumentSchemaMethodDescriptor);
    methodDescriptors.add(getDocumentSchemaMethodDescriptor);
    methodDescriptors.add(deleteDocumentSchemaMethodDescriptor);
    methodDescriptors.add(listDocumentSchemasMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateDocumentSchemaRequest, DocumentSchema> createDocumentSchemaCallable() {
    return createDocumentSchemaCallable;
  }

  @Override
  public UnaryCallable<UpdateDocumentSchemaRequest, DocumentSchema> updateDocumentSchemaCallable() {
    return updateDocumentSchemaCallable;
  }

  @Override
  public UnaryCallable<GetDocumentSchemaRequest, DocumentSchema> getDocumentSchemaCallable() {
    return getDocumentSchemaCallable;
  }

  @Override
  public UnaryCallable<DeleteDocumentSchemaRequest, Empty> deleteDocumentSchemaCallable() {
    return deleteDocumentSchemaCallable;
  }

  @Override
  public UnaryCallable<ListDocumentSchemasRequest, ListDocumentSchemasResponse>
      listDocumentSchemasCallable() {
    return listDocumentSchemasCallable;
  }

  @Override
  public UnaryCallable<ListDocumentSchemasRequest, ListDocumentSchemasPagedResponse>
      listDocumentSchemasPagedCallable() {
    return listDocumentSchemasPagedCallable;
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
