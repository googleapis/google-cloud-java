/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.eventarc.v1.stub;

import static com.google.cloud.eventarc.v1.EventarcClient.ListTriggersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.eventarc.v1.CreateTriggerRequest;
import com.google.cloud.eventarc.v1.DeleteTriggerRequest;
import com.google.cloud.eventarc.v1.GetTriggerRequest;
import com.google.cloud.eventarc.v1.ListTriggersRequest;
import com.google.cloud.eventarc.v1.ListTriggersResponse;
import com.google.cloud.eventarc.v1.OperationMetadata;
import com.google.cloud.eventarc.v1.Trigger;
import com.google.cloud.eventarc.v1.UpdateTriggerRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Eventarc service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcEventarcStub extends EventarcStub {
  private static final MethodDescriptor<GetTriggerRequest, Trigger> getTriggerMethodDescriptor =
      MethodDescriptor.<GetTriggerRequest, Trigger>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.eventarc.v1.Eventarc/GetTrigger")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTriggerRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Trigger.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListTriggersRequest, ListTriggersResponse>
      listTriggersMethodDescriptor =
          MethodDescriptor.<ListTriggersRequest, ListTriggersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/ListTriggers")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTriggersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTriggersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTriggerRequest, Operation>
      createTriggerMethodDescriptor =
          MethodDescriptor.<CreateTriggerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/CreateTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTriggerRequest, Operation>
      updateTriggerMethodDescriptor =
          MethodDescriptor.<UpdateTriggerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/UpdateTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTriggerRequest, Operation>
      deleteTriggerMethodDescriptor =
          MethodDescriptor.<DeleteTriggerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.v1.Eventarc/DeleteTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetTriggerRequest, Trigger> getTriggerCallable;
  private final UnaryCallable<ListTriggersRequest, ListTriggersResponse> listTriggersCallable;
  private final UnaryCallable<ListTriggersRequest, ListTriggersPagedResponse>
      listTriggersPagedCallable;
  private final UnaryCallable<CreateTriggerRequest, Operation> createTriggerCallable;
  private final OperationCallable<CreateTriggerRequest, Trigger, OperationMetadata>
      createTriggerOperationCallable;
  private final UnaryCallable<UpdateTriggerRequest, Operation> updateTriggerCallable;
  private final OperationCallable<UpdateTriggerRequest, Trigger, OperationMetadata>
      updateTriggerOperationCallable;
  private final UnaryCallable<DeleteTriggerRequest, Operation> deleteTriggerCallable;
  private final OperationCallable<DeleteTriggerRequest, Trigger, OperationMetadata>
      deleteTriggerOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEventarcStub create(EventarcStubSettings settings) throws IOException {
    return new GrpcEventarcStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEventarcStub create(ClientContext clientContext) throws IOException {
    return new GrpcEventarcStub(EventarcStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEventarcStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEventarcStub(
        EventarcStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEventarcStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcEventarcStub(EventarcStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcEventarcCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEventarcStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcEventarcStub(
      EventarcStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetTriggerRequest, Trigger> getTriggerTransportSettings =
        GrpcCallSettings.<GetTriggerRequest, Trigger>newBuilder()
            .setMethodDescriptor(getTriggerMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetTriggerRequest>() {
                  @Override
                  public Map<String, String> extract(GetTriggerRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListTriggersRequest, ListTriggersResponse> listTriggersTransportSettings =
        GrpcCallSettings.<ListTriggersRequest, ListTriggersResponse>newBuilder()
            .setMethodDescriptor(listTriggersMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListTriggersRequest>() {
                  @Override
                  public Map<String, String> extract(ListTriggersRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateTriggerRequest, Operation> createTriggerTransportSettings =
        GrpcCallSettings.<CreateTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(createTriggerMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateTriggerRequest>() {
                  @Override
                  public Map<String, String> extract(CreateTriggerRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateTriggerRequest, Operation> updateTriggerTransportSettings =
        GrpcCallSettings.<UpdateTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTriggerMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateTriggerRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateTriggerRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("trigger.name", String.valueOf(request.getTrigger().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteTriggerRequest, Operation> deleteTriggerTransportSettings =
        GrpcCallSettings.<DeleteTriggerRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTriggerMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteTriggerRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteTriggerRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();

    this.getTriggerCallable =
        callableFactory.createUnaryCallable(
            getTriggerTransportSettings, settings.getTriggerSettings(), clientContext);
    this.listTriggersCallable =
        callableFactory.createUnaryCallable(
            listTriggersTransportSettings, settings.listTriggersSettings(), clientContext);
    this.listTriggersPagedCallable =
        callableFactory.createPagedCallable(
            listTriggersTransportSettings, settings.listTriggersSettings(), clientContext);
    this.createTriggerCallable =
        callableFactory.createUnaryCallable(
            createTriggerTransportSettings, settings.createTriggerSettings(), clientContext);
    this.createTriggerOperationCallable =
        callableFactory.createOperationCallable(
            createTriggerTransportSettings,
            settings.createTriggerOperationSettings(),
            clientContext,
            operationsStub);
    this.updateTriggerCallable =
        callableFactory.createUnaryCallable(
            updateTriggerTransportSettings, settings.updateTriggerSettings(), clientContext);
    this.updateTriggerOperationCallable =
        callableFactory.createOperationCallable(
            updateTriggerTransportSettings,
            settings.updateTriggerOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTriggerCallable =
        callableFactory.createUnaryCallable(
            deleteTriggerTransportSettings, settings.deleteTriggerSettings(), clientContext);
    this.deleteTriggerOperationCallable =
        callableFactory.createOperationCallable(
            deleteTriggerTransportSettings,
            settings.deleteTriggerOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetTriggerRequest, Trigger> getTriggerCallable() {
    return getTriggerCallable;
  }

  @Override
  public UnaryCallable<ListTriggersRequest, ListTriggersResponse> listTriggersCallable() {
    return listTriggersCallable;
  }

  @Override
  public UnaryCallable<ListTriggersRequest, ListTriggersPagedResponse> listTriggersPagedCallable() {
    return listTriggersPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTriggerRequest, Operation> createTriggerCallable() {
    return createTriggerCallable;
  }

  @Override
  public OperationCallable<CreateTriggerRequest, Trigger, OperationMetadata>
      createTriggerOperationCallable() {
    return createTriggerOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTriggerRequest, Operation> updateTriggerCallable() {
    return updateTriggerCallable;
  }

  @Override
  public OperationCallable<UpdateTriggerRequest, Trigger, OperationMetadata>
      updateTriggerOperationCallable() {
    return updateTriggerOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTriggerRequest, Operation> deleteTriggerCallable() {
    return deleteTriggerCallable;
  }

  @Override
  public OperationCallable<DeleteTriggerRequest, Trigger, OperationMetadata>
      deleteTriggerOperationCallable() {
    return deleteTriggerOperationCallable;
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
