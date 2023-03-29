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

package com.google.cloud.resourcemanager.v3.stub;

import static com.google.cloud.resourcemanager.v3.TagBindingsClient.ListTagBindingsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v3.CreateTagBindingMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagBindingRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagBindingMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest;
import com.google.cloud.resourcemanager.v3.ListTagBindingsRequest;
import com.google.cloud.resourcemanager.v3.ListTagBindingsResponse;
import com.google.cloud.resourcemanager.v3.TagBinding;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the TagBindings service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcTagBindingsStub extends TagBindingsStub {
  private static final MethodDescriptor<ListTagBindingsRequest, ListTagBindingsResponse>
      listTagBindingsMethodDescriptor =
          MethodDescriptor.<ListTagBindingsRequest, ListTagBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagBindings/ListTagBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTagBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTagBindingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTagBindingRequest, Operation>
      createTagBindingMethodDescriptor =
          MethodDescriptor.<CreateTagBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagBindings/CreateTagBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTagBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTagBindingRequest, Operation>
      deleteTagBindingMethodDescriptor =
          MethodDescriptor.<DeleteTagBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.resourcemanager.v3.TagBindings/DeleteTagBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTagBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListTagBindingsRequest, ListTagBindingsResponse>
      listTagBindingsCallable;
  private final UnaryCallable<ListTagBindingsRequest, ListTagBindingsPagedResponse>
      listTagBindingsPagedCallable;
  private final UnaryCallable<CreateTagBindingRequest, Operation> createTagBindingCallable;
  private final OperationCallable<CreateTagBindingRequest, TagBinding, CreateTagBindingMetadata>
      createTagBindingOperationCallable;
  private final UnaryCallable<DeleteTagBindingRequest, Operation> deleteTagBindingCallable;
  private final OperationCallable<DeleteTagBindingRequest, Empty, DeleteTagBindingMetadata>
      deleteTagBindingOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTagBindingsStub create(TagBindingsStubSettings settings)
      throws IOException {
    return new GrpcTagBindingsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTagBindingsStub create(ClientContext clientContext) throws IOException {
    return new GrpcTagBindingsStub(TagBindingsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTagBindingsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTagBindingsStub(
        TagBindingsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTagBindingsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTagBindingsStub(TagBindingsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcTagBindingsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTagBindingsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTagBindingsStub(
      TagBindingsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListTagBindingsRequest, ListTagBindingsResponse>
        listTagBindingsTransportSettings =
            GrpcCallSettings.<ListTagBindingsRequest, ListTagBindingsResponse>newBuilder()
                .setMethodDescriptor(listTagBindingsMethodDescriptor)
                .build();
    GrpcCallSettings<CreateTagBindingRequest, Operation> createTagBindingTransportSettings =
        GrpcCallSettings.<CreateTagBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(createTagBindingMethodDescriptor)
            .build();
    GrpcCallSettings<DeleteTagBindingRequest, Operation> deleteTagBindingTransportSettings =
        GrpcCallSettings.<DeleteTagBindingRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTagBindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listTagBindingsCallable =
        callableFactory.createUnaryCallable(
            listTagBindingsTransportSettings, settings.listTagBindingsSettings(), clientContext);
    this.listTagBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listTagBindingsTransportSettings, settings.listTagBindingsSettings(), clientContext);
    this.createTagBindingCallable =
        callableFactory.createUnaryCallable(
            createTagBindingTransportSettings, settings.createTagBindingSettings(), clientContext);
    this.createTagBindingOperationCallable =
        callableFactory.createOperationCallable(
            createTagBindingTransportSettings,
            settings.createTagBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTagBindingCallable =
        callableFactory.createUnaryCallable(
            deleteTagBindingTransportSettings, settings.deleteTagBindingSettings(), clientContext);
    this.deleteTagBindingOperationCallable =
        callableFactory.createOperationCallable(
            deleteTagBindingTransportSettings,
            settings.deleteTagBindingOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListTagBindingsRequest, ListTagBindingsResponse> listTagBindingsCallable() {
    return listTagBindingsCallable;
  }

  @Override
  public UnaryCallable<ListTagBindingsRequest, ListTagBindingsPagedResponse>
      listTagBindingsPagedCallable() {
    return listTagBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTagBindingRequest, Operation> createTagBindingCallable() {
    return createTagBindingCallable;
  }

  @Override
  public OperationCallable<CreateTagBindingRequest, TagBinding, CreateTagBindingMetadata>
      createTagBindingOperationCallable() {
    return createTagBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTagBindingRequest, Operation> deleteTagBindingCallable() {
    return deleteTagBindingCallable;
  }

  @Override
  public OperationCallable<DeleteTagBindingRequest, Empty, DeleteTagBindingMetadata>
      deleteTagBindingOperationCallable() {
    return deleteTagBindingOperationCallable;
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
