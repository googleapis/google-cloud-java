/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.resourcemanager.v3.stub;

import static com.google.cloud.resourcemanager.v3.TagHoldsClient.ListTagHoldsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v3.CreateTagHoldMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagHoldRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagHoldMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest;
import com.google.cloud.resourcemanager.v3.ListTagHoldsRequest;
import com.google.cloud.resourcemanager.v3.ListTagHoldsResponse;
import com.google.cloud.resourcemanager.v3.TagHold;
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
 * gRPC stub implementation for the TagHolds service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcTagHoldsStub extends TagHoldsStub {
  private static final MethodDescriptor<CreateTagHoldRequest, Operation>
      createTagHoldMethodDescriptor =
          MethodDescriptor.<CreateTagHoldRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagHolds/CreateTagHold")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTagHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTagHoldRequest, Operation>
      deleteTagHoldMethodDescriptor =
          MethodDescriptor.<DeleteTagHoldRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagHolds/DeleteTagHold")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTagHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTagHoldsRequest, ListTagHoldsResponse>
      listTagHoldsMethodDescriptor =
          MethodDescriptor.<ListTagHoldsRequest, ListTagHoldsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagHolds/ListTagHolds")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTagHoldsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTagHoldsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateTagHoldRequest, Operation> createTagHoldCallable;
  private final OperationCallable<CreateTagHoldRequest, TagHold, CreateTagHoldMetadata>
      createTagHoldOperationCallable;
  private final UnaryCallable<DeleteTagHoldRequest, Operation> deleteTagHoldCallable;
  private final OperationCallable<DeleteTagHoldRequest, Empty, DeleteTagHoldMetadata>
      deleteTagHoldOperationCallable;
  private final UnaryCallable<ListTagHoldsRequest, ListTagHoldsResponse> listTagHoldsCallable;
  private final UnaryCallable<ListTagHoldsRequest, ListTagHoldsPagedResponse>
      listTagHoldsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTagHoldsStub create(TagHoldsStubSettings settings) throws IOException {
    return new GrpcTagHoldsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTagHoldsStub create(ClientContext clientContext) throws IOException {
    return new GrpcTagHoldsStub(TagHoldsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTagHoldsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTagHoldsStub(
        TagHoldsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTagHoldsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcTagHoldsStub(TagHoldsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcTagHoldsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTagHoldsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcTagHoldsStub(
      TagHoldsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateTagHoldRequest, Operation> createTagHoldTransportSettings =
        GrpcCallSettings.<CreateTagHoldRequest, Operation>newBuilder()
            .setMethodDescriptor(createTagHoldMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTagHoldRequest, Operation> deleteTagHoldTransportSettings =
        GrpcCallSettings.<DeleteTagHoldRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTagHoldMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTagHoldsRequest, ListTagHoldsResponse> listTagHoldsTransportSettings =
        GrpcCallSettings.<ListTagHoldsRequest, ListTagHoldsResponse>newBuilder()
            .setMethodDescriptor(listTagHoldsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.createTagHoldCallable =
        callableFactory.createUnaryCallable(
            createTagHoldTransportSettings, settings.createTagHoldSettings(), clientContext);
    this.createTagHoldOperationCallable =
        callableFactory.createOperationCallable(
            createTagHoldTransportSettings,
            settings.createTagHoldOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTagHoldCallable =
        callableFactory.createUnaryCallable(
            deleteTagHoldTransportSettings, settings.deleteTagHoldSettings(), clientContext);
    this.deleteTagHoldOperationCallable =
        callableFactory.createOperationCallable(
            deleteTagHoldTransportSettings,
            settings.deleteTagHoldOperationSettings(),
            clientContext,
            operationsStub);
    this.listTagHoldsCallable =
        callableFactory.createUnaryCallable(
            listTagHoldsTransportSettings, settings.listTagHoldsSettings(), clientContext);
    this.listTagHoldsPagedCallable =
        callableFactory.createPagedCallable(
            listTagHoldsTransportSettings, settings.listTagHoldsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateTagHoldRequest, Operation> createTagHoldCallable() {
    return createTagHoldCallable;
  }

  @Override
  public OperationCallable<CreateTagHoldRequest, TagHold, CreateTagHoldMetadata>
      createTagHoldOperationCallable() {
    return createTagHoldOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTagHoldRequest, Operation> deleteTagHoldCallable() {
    return deleteTagHoldCallable;
  }

  @Override
  public OperationCallable<DeleteTagHoldRequest, Empty, DeleteTagHoldMetadata>
      deleteTagHoldOperationCallable() {
    return deleteTagHoldOperationCallable;
  }

  @Override
  public UnaryCallable<ListTagHoldsRequest, ListTagHoldsResponse> listTagHoldsCallable() {
    return listTagHoldsCallable;
  }

  @Override
  public UnaryCallable<ListTagHoldsRequest, ListTagHoldsPagedResponse> listTagHoldsPagedCallable() {
    return listTagHoldsPagedCallable;
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
