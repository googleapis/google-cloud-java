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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.SchemaServiceClient.ListSchemasPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.CreateSchemaMetadata;
import com.google.cloud.discoveryengine.v1beta.CreateSchemaRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteSchemaMetadata;
import com.google.cloud.discoveryengine.v1beta.DeleteSchemaRequest;
import com.google.cloud.discoveryengine.v1beta.GetSchemaRequest;
import com.google.cloud.discoveryengine.v1beta.ListSchemasRequest;
import com.google.cloud.discoveryengine.v1beta.ListSchemasResponse;
import com.google.cloud.discoveryengine.v1beta.Schema;
import com.google.cloud.discoveryengine.v1beta.UpdateSchemaMetadata;
import com.google.cloud.discoveryengine.v1beta.UpdateSchemaRequest;
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
 * gRPC stub implementation for the SchemaService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSchemaServiceStub extends SchemaServiceStub {
  private static final MethodDescriptor<GetSchemaRequest, Schema> getSchemaMethodDescriptor =
      MethodDescriptor.<GetSchemaRequest, Schema>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.discoveryengine.v1beta.SchemaService/GetSchema")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSchemaRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Schema.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListSchemasRequest, ListSchemasResponse>
      listSchemasMethodDescriptor =
          MethodDescriptor.<ListSchemasRequest, ListSchemasResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.discoveryengine.v1beta.SchemaService/ListSchemas")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSchemasRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSchemasResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSchemaRequest, Operation>
      createSchemaMethodDescriptor =
          MethodDescriptor.<CreateSchemaRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.discoveryengine.v1beta.SchemaService/CreateSchema")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSchemaRequest, Operation>
      updateSchemaMethodDescriptor =
          MethodDescriptor.<UpdateSchemaRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.discoveryengine.v1beta.SchemaService/UpdateSchema")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSchemaRequest, Operation>
      deleteSchemaMethodDescriptor =
          MethodDescriptor.<DeleteSchemaRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.discoveryengine.v1beta.SchemaService/DeleteSchema")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetSchemaRequest, Schema> getSchemaCallable;
  private final UnaryCallable<ListSchemasRequest, ListSchemasResponse> listSchemasCallable;
  private final UnaryCallable<ListSchemasRequest, ListSchemasPagedResponse>
      listSchemasPagedCallable;
  private final UnaryCallable<CreateSchemaRequest, Operation> createSchemaCallable;
  private final OperationCallable<CreateSchemaRequest, Schema, CreateSchemaMetadata>
      createSchemaOperationCallable;
  private final UnaryCallable<UpdateSchemaRequest, Operation> updateSchemaCallable;
  private final OperationCallable<UpdateSchemaRequest, Schema, UpdateSchemaMetadata>
      updateSchemaOperationCallable;
  private final UnaryCallable<DeleteSchemaRequest, Operation> deleteSchemaCallable;
  private final OperationCallable<DeleteSchemaRequest, Empty, DeleteSchemaMetadata>
      deleteSchemaOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSchemaServiceStub create(SchemaServiceStubSettings settings)
      throws IOException {
    return new GrpcSchemaServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSchemaServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcSchemaServiceStub(SchemaServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSchemaServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSchemaServiceStub(
        SchemaServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSchemaServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSchemaServiceStub(SchemaServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSchemaServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSchemaServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSchemaServiceStub(
      SchemaServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetSchemaRequest, Schema> getSchemaTransportSettings =
        GrpcCallSettings.<GetSchemaRequest, Schema>newBuilder()
            .setMethodDescriptor(getSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSchemasRequest, ListSchemasResponse> listSchemasTransportSettings =
        GrpcCallSettings.<ListSchemasRequest, ListSchemasResponse>newBuilder()
            .setMethodDescriptor(listSchemasMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSchemaRequest, Operation> createSchemaTransportSettings =
        GrpcCallSettings.<CreateSchemaRequest, Operation>newBuilder()
            .setMethodDescriptor(createSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSchemaRequest, Operation> updateSchemaTransportSettings =
        GrpcCallSettings.<UpdateSchemaRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("schema.name", String.valueOf(request.getSchema().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSchemaRequest, Operation> deleteSchemaTransportSettings =
        GrpcCallSettings.<DeleteSchemaRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getSchemaCallable =
        callableFactory.createUnaryCallable(
            getSchemaTransportSettings, settings.getSchemaSettings(), clientContext);
    this.listSchemasCallable =
        callableFactory.createUnaryCallable(
            listSchemasTransportSettings, settings.listSchemasSettings(), clientContext);
    this.listSchemasPagedCallable =
        callableFactory.createPagedCallable(
            listSchemasTransportSettings, settings.listSchemasSettings(), clientContext);
    this.createSchemaCallable =
        callableFactory.createUnaryCallable(
            createSchemaTransportSettings, settings.createSchemaSettings(), clientContext);
    this.createSchemaOperationCallable =
        callableFactory.createOperationCallable(
            createSchemaTransportSettings,
            settings.createSchemaOperationSettings(),
            clientContext,
            operationsStub);
    this.updateSchemaCallable =
        callableFactory.createUnaryCallable(
            updateSchemaTransportSettings, settings.updateSchemaSettings(), clientContext);
    this.updateSchemaOperationCallable =
        callableFactory.createOperationCallable(
            updateSchemaTransportSettings,
            settings.updateSchemaOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSchemaCallable =
        callableFactory.createUnaryCallable(
            deleteSchemaTransportSettings, settings.deleteSchemaSettings(), clientContext);
    this.deleteSchemaOperationCallable =
        callableFactory.createOperationCallable(
            deleteSchemaTransportSettings,
            settings.deleteSchemaOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetSchemaRequest, Schema> getSchemaCallable() {
    return getSchemaCallable;
  }

  @Override
  public UnaryCallable<ListSchemasRequest, ListSchemasResponse> listSchemasCallable() {
    return listSchemasCallable;
  }

  @Override
  public UnaryCallable<ListSchemasRequest, ListSchemasPagedResponse> listSchemasPagedCallable() {
    return listSchemasPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSchemaRequest, Operation> createSchemaCallable() {
    return createSchemaCallable;
  }

  @Override
  public OperationCallable<CreateSchemaRequest, Schema, CreateSchemaMetadata>
      createSchemaOperationCallable() {
    return createSchemaOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSchemaRequest, Operation> updateSchemaCallable() {
    return updateSchemaCallable;
  }

  @Override
  public OperationCallable<UpdateSchemaRequest, Schema, UpdateSchemaMetadata>
      updateSchemaOperationCallable() {
    return updateSchemaOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSchemaRequest, Operation> deleteSchemaCallable() {
    return deleteSchemaCallable;
  }

  @Override
  public OperationCallable<DeleteSchemaRequest, Empty, DeleteSchemaMetadata>
      deleteSchemaOperationCallable() {
    return deleteSchemaOperationCallable;
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
