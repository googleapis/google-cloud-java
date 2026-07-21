/*
 * Copyright 2026 Google LLC
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

import static com.google.cloud.discoveryengine.v1beta.AssistantServiceClient.ListAssistantsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.Assistant;
import com.google.cloud.discoveryengine.v1beta.CreateAssistantRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteAssistantRequest;
import com.google.cloud.discoveryengine.v1beta.GetAssistantRequest;
import com.google.cloud.discoveryengine.v1beta.ListAssistantsRequest;
import com.google.cloud.discoveryengine.v1beta.ListAssistantsResponse;
import com.google.cloud.discoveryengine.v1beta.StreamAssistRequest;
import com.google.cloud.discoveryengine.v1beta.StreamAssistResponse;
import com.google.cloud.discoveryengine.v1beta.UpdateAssistantRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AssistantService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAssistantServiceStub extends AssistantServiceStub {
  private static final MethodDescriptor<StreamAssistRequest, StreamAssistResponse>
      streamAssistMethodDescriptor =
          MethodDescriptor.<StreamAssistRequest, StreamAssistResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.AssistantService/StreamAssist")
              .setRequestMarshaller(ProtoUtils.marshaller(StreamAssistRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamAssistResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAssistantRequest, Assistant>
      createAssistantMethodDescriptor =
          MethodDescriptor.<CreateAssistantRequest, Assistant>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.AssistantService/CreateAssistant")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAssistantRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Assistant.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAssistantRequest, Empty>
      deleteAssistantMethodDescriptor =
          MethodDescriptor.<DeleteAssistantRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.AssistantService/DeleteAssistant")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAssistantRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateAssistantRequest, Assistant>
      updateAssistantMethodDescriptor =
          MethodDescriptor.<UpdateAssistantRequest, Assistant>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.AssistantService/UpdateAssistant")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAssistantRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Assistant.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAssistantRequest, Assistant>
      getAssistantMethodDescriptor =
          MethodDescriptor.<GetAssistantRequest, Assistant>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.AssistantService/GetAssistant")
              .setRequestMarshaller(ProtoUtils.marshaller(GetAssistantRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Assistant.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListAssistantsRequest, ListAssistantsResponse>
      listAssistantsMethodDescriptor =
          MethodDescriptor.<ListAssistantsRequest, ListAssistantsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.AssistantService/ListAssistants")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAssistantsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAssistantsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final ServerStreamingCallable<StreamAssistRequest, StreamAssistResponse>
      streamAssistCallable;
  private final UnaryCallable<CreateAssistantRequest, Assistant> createAssistantCallable;
  private final UnaryCallable<DeleteAssistantRequest, Empty> deleteAssistantCallable;
  private final UnaryCallable<UpdateAssistantRequest, Assistant> updateAssistantCallable;
  private final UnaryCallable<GetAssistantRequest, Assistant> getAssistantCallable;
  private final UnaryCallable<ListAssistantsRequest, ListAssistantsResponse> listAssistantsCallable;
  private final UnaryCallable<ListAssistantsRequest, ListAssistantsPagedResponse>
      listAssistantsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAssistantServiceStub create(AssistantServiceStubSettings settings)
      throws IOException {
    return new GrpcAssistantServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAssistantServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAssistantServiceStub(
        AssistantServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAssistantServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAssistantServiceStub(
        AssistantServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAssistantServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAssistantServiceStub(
      AssistantServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAssistantServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAssistantServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAssistantServiceStub(
      AssistantServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<StreamAssistRequest, StreamAssistResponse> streamAssistTransportSettings =
        GrpcCallSettings.<StreamAssistRequest, StreamAssistResponse>newBuilder()
            .setMethodDescriptor(streamAssistMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateAssistantRequest, Assistant> createAssistantTransportSettings =
        GrpcCallSettings.<CreateAssistantRequest, Assistant>newBuilder()
            .setMethodDescriptor(createAssistantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<DeleteAssistantRequest, Empty> deleteAssistantTransportSettings =
        GrpcCallSettings.<DeleteAssistantRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAssistantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateAssistantRequest, Assistant> updateAssistantTransportSettings =
        GrpcCallSettings.<UpdateAssistantRequest, Assistant>newBuilder()
            .setMethodDescriptor(updateAssistantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("assistant.name", String.valueOf(request.getAssistant().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAssistantRequest, Assistant> getAssistantTransportSettings =
        GrpcCallSettings.<GetAssistantRequest, Assistant>newBuilder()
            .setMethodDescriptor(getAssistantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListAssistantsRequest, ListAssistantsResponse>
        listAssistantsTransportSettings =
            GrpcCallSettings.<ListAssistantsRequest, ListAssistantsResponse>newBuilder()
                .setMethodDescriptor(listAssistantsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.streamAssistCallable =
        callableFactory.createServerStreamingCallable(
            streamAssistTransportSettings, settings.streamAssistSettings(), clientContext);
    this.createAssistantCallable =
        callableFactory.createUnaryCallable(
            createAssistantTransportSettings, settings.createAssistantSettings(), clientContext);
    this.deleteAssistantCallable =
        callableFactory.createUnaryCallable(
            deleteAssistantTransportSettings, settings.deleteAssistantSettings(), clientContext);
    this.updateAssistantCallable =
        callableFactory.createUnaryCallable(
            updateAssistantTransportSettings, settings.updateAssistantSettings(), clientContext);
    this.getAssistantCallable =
        callableFactory.createUnaryCallable(
            getAssistantTransportSettings, settings.getAssistantSettings(), clientContext);
    this.listAssistantsCallable =
        callableFactory.createUnaryCallable(
            listAssistantsTransportSettings, settings.listAssistantsSettings(), clientContext);
    this.listAssistantsPagedCallable =
        callableFactory.createPagedCallable(
            listAssistantsTransportSettings, settings.listAssistantsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public ServerStreamingCallable<StreamAssistRequest, StreamAssistResponse> streamAssistCallable() {
    return streamAssistCallable;
  }

  @Override
  public UnaryCallable<CreateAssistantRequest, Assistant> createAssistantCallable() {
    return createAssistantCallable;
  }

  @Override
  public UnaryCallable<DeleteAssistantRequest, Empty> deleteAssistantCallable() {
    return deleteAssistantCallable;
  }

  @Override
  public UnaryCallable<UpdateAssistantRequest, Assistant> updateAssistantCallable() {
    return updateAssistantCallable;
  }

  @Override
  public UnaryCallable<GetAssistantRequest, Assistant> getAssistantCallable() {
    return getAssistantCallable;
  }

  @Override
  public UnaryCallable<ListAssistantsRequest, ListAssistantsResponse> listAssistantsCallable() {
    return listAssistantsCallable;
  }

  @Override
  public UnaryCallable<ListAssistantsRequest, ListAssistantsPagedResponse>
      listAssistantsPagedCallable() {
    return listAssistantsPagedCallable;
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
