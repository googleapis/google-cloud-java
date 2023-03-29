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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest;
import com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest;
import com.google.cloud.contentwarehouse.v1.DocumentSchema;
import com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest;
import com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest;
import com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse;
import com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest;
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
 * gRPC stub implementation for the DocumentSchemaService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDocumentSchemaServiceStub extends DocumentSchemaServiceStub {
  private static final MethodDescriptor<CreateDocumentSchemaRequest, DocumentSchema>
      createDocumentSchemaMethodDescriptor =
          MethodDescriptor.<CreateDocumentSchemaRequest, DocumentSchema>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentSchemaService/CreateDocumentSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDocumentSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DocumentSchema.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDocumentSchemaRequest, DocumentSchema>
      updateDocumentSchemaMethodDescriptor =
          MethodDescriptor.<UpdateDocumentSchemaRequest, DocumentSchema>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentSchemaService/UpdateDocumentSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDocumentSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DocumentSchema.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDocumentSchemaRequest, DocumentSchema>
      getDocumentSchemaMethodDescriptor =
          MethodDescriptor.<GetDocumentSchemaRequest, DocumentSchema>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentSchemaService/GetDocumentSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDocumentSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DocumentSchema.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDocumentSchemaRequest, Empty>
      deleteDocumentSchemaMethodDescriptor =
          MethodDescriptor.<DeleteDocumentSchemaRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentSchemaService/DeleteDocumentSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDocumentSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDocumentSchemasRequest, ListDocumentSchemasResponse>
      listDocumentSchemasMethodDescriptor =
          MethodDescriptor.<ListDocumentSchemasRequest, ListDocumentSchemasResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentSchemaService/ListDocumentSchemas")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDocumentSchemasRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDocumentSchemasResponse.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDocumentSchemaServiceStub create(
      DocumentSchemaServiceStubSettings settings) throws IOException {
    return new GrpcDocumentSchemaServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDocumentSchemaServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDocumentSchemaServiceStub(
        DocumentSchemaServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDocumentSchemaServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDocumentSchemaServiceStub(
        DocumentSchemaServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDocumentSchemaServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDocumentSchemaServiceStub(
      DocumentSchemaServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDocumentSchemaServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDocumentSchemaServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDocumentSchemaServiceStub(
      DocumentSchemaServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDocumentSchemaRequest, DocumentSchema>
        createDocumentSchemaTransportSettings =
            GrpcCallSettings.<CreateDocumentSchemaRequest, DocumentSchema>newBuilder()
                .setMethodDescriptor(createDocumentSchemaMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateDocumentSchemaRequest, DocumentSchema>
        updateDocumentSchemaTransportSettings =
            GrpcCallSettings.<UpdateDocumentSchemaRequest, DocumentSchema>newBuilder()
                .setMethodDescriptor(updateDocumentSchemaMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetDocumentSchemaRequest, DocumentSchema> getDocumentSchemaTransportSettings =
        GrpcCallSettings.<GetDocumentSchemaRequest, DocumentSchema>newBuilder()
            .setMethodDescriptor(getDocumentSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteDocumentSchemaRequest, Empty> deleteDocumentSchemaTransportSettings =
        GrpcCallSettings.<DeleteDocumentSchemaRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDocumentSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListDocumentSchemasRequest, ListDocumentSchemasResponse>
        listDocumentSchemasTransportSettings =
            GrpcCallSettings.<ListDocumentSchemasRequest, ListDocumentSchemasResponse>newBuilder()
                .setMethodDescriptor(listDocumentSchemasMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
