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

package com.google.cloud.ces.v1beta.stub;

import static com.google.cloud.ces.v1beta.AssistantServiceClient.ListAssistantSessionsPagedResponse;
import static com.google.cloud.ces.v1beta.AssistantServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.ces.v1beta.AssistantSession;
import com.google.cloud.ces.v1beta.ChatAiAssistantRequest;
import com.google.cloud.ces.v1beta.ChatAiAssistantResponse;
import com.google.cloud.ces.v1beta.CreateAssistantSessionRequest;
import com.google.cloud.ces.v1beta.DeleteAssistantSessionRequest;
import com.google.cloud.ces.v1beta.GetAssistantSessionRequest;
import com.google.cloud.ces.v1beta.ListAssistantSessionsRequest;
import com.google.cloud.ces.v1beta.ListAssistantSessionsResponse;
import com.google.cloud.ces.v1beta.RunAssistantRequest;
import com.google.cloud.ces.v1beta.RunAssistantResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
  private static final MethodDescriptor<ListAssistantSessionsRequest, ListAssistantSessionsResponse>
      listAssistantSessionsMethodDescriptor =
          MethodDescriptor.<ListAssistantSessionsRequest, ListAssistantSessionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.AssistantService/ListAssistantSessions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAssistantSessionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAssistantSessionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAssistantSessionRequest, AssistantSession>
      getAssistantSessionMethodDescriptor =
          MethodDescriptor.<GetAssistantSessionRequest, AssistantSession>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.AssistantService/GetAssistantSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAssistantSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AssistantSession.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAssistantSessionRequest, AssistantSession>
      createAssistantSessionMethodDescriptor =
          MethodDescriptor.<CreateAssistantSessionRequest, AssistantSession>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.AssistantService/CreateAssistantSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAssistantSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AssistantSession.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAssistantSessionRequest, Empty>
      deleteAssistantSessionMethodDescriptor =
          MethodDescriptor.<DeleteAssistantSessionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.AssistantService/DeleteAssistantSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAssistantSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RunAssistantRequest, RunAssistantResponse>
      runAssistantMethodDescriptor =
          MethodDescriptor.<RunAssistantRequest, RunAssistantResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.AssistantService/RunAssistant")
              .setRequestMarshaller(ProtoUtils.marshaller(RunAssistantRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RunAssistantResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ChatAiAssistantRequest, ChatAiAssistantResponse>
      chatAiAssistantMethodDescriptor =
          MethodDescriptor.<ChatAiAssistantRequest, ChatAiAssistantResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.AssistantService/ChatAiAssistant")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ChatAiAssistantRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ChatAiAssistantResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<ListAssistantSessionsRequest, ListAssistantSessionsResponse>
      listAssistantSessionsCallable;
  private final UnaryCallable<ListAssistantSessionsRequest, ListAssistantSessionsPagedResponse>
      listAssistantSessionsPagedCallable;
  private final UnaryCallable<GetAssistantSessionRequest, AssistantSession>
      getAssistantSessionCallable;
  private final UnaryCallable<CreateAssistantSessionRequest, AssistantSession>
      createAssistantSessionCallable;
  private final UnaryCallable<DeleteAssistantSessionRequest, Empty> deleteAssistantSessionCallable;
  private final UnaryCallable<RunAssistantRequest, RunAssistantResponse> runAssistantCallable;
  private final UnaryCallable<ChatAiAssistantRequest, ChatAiAssistantResponse>
      chatAiAssistantCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

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

    GrpcCallSettings<ListAssistantSessionsRequest, ListAssistantSessionsResponse>
        listAssistantSessionsTransportSettings =
            GrpcCallSettings
                .<ListAssistantSessionsRequest, ListAssistantSessionsResponse>newBuilder()
                .setMethodDescriptor(listAssistantSessionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetAssistantSessionRequest, AssistantSession>
        getAssistantSessionTransportSettings =
            GrpcCallSettings.<GetAssistantSessionRequest, AssistantSession>newBuilder()
                .setMethodDescriptor(getAssistantSessionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateAssistantSessionRequest, AssistantSession>
        createAssistantSessionTransportSettings =
            GrpcCallSettings.<CreateAssistantSessionRequest, AssistantSession>newBuilder()
                .setMethodDescriptor(createAssistantSessionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<DeleteAssistantSessionRequest, Empty> deleteAssistantSessionTransportSettings =
        GrpcCallSettings.<DeleteAssistantSessionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAssistantSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<RunAssistantRequest, RunAssistantResponse> runAssistantTransportSettings =
        GrpcCallSettings.<RunAssistantRequest, RunAssistantResponse>newBuilder()
            .setMethodDescriptor(runAssistantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("app", String.valueOf(request.getApp()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getApp())
            .build();
    GrpcCallSettings<ChatAiAssistantRequest, ChatAiAssistantResponse>
        chatAiAssistantTransportSettings =
            GrpcCallSettings.<ChatAiAssistantRequest, ChatAiAssistantResponse>newBuilder()
                .setMethodDescriptor(chatAiAssistantMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("app", String.valueOf(request.getApp()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getApp())
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listAssistantSessionsCallable =
        callableFactory.createUnaryCallable(
            listAssistantSessionsTransportSettings,
            settings.listAssistantSessionsSettings(),
            clientContext);
    this.listAssistantSessionsPagedCallable =
        callableFactory.createPagedCallable(
            listAssistantSessionsTransportSettings,
            settings.listAssistantSessionsSettings(),
            clientContext);
    this.getAssistantSessionCallable =
        callableFactory.createUnaryCallable(
            getAssistantSessionTransportSettings,
            settings.getAssistantSessionSettings(),
            clientContext);
    this.createAssistantSessionCallable =
        callableFactory.createUnaryCallable(
            createAssistantSessionTransportSettings,
            settings.createAssistantSessionSettings(),
            clientContext);
    this.deleteAssistantSessionCallable =
        callableFactory.createUnaryCallable(
            deleteAssistantSessionTransportSettings,
            settings.deleteAssistantSessionSettings(),
            clientContext);
    this.runAssistantCallable =
        callableFactory.createUnaryCallable(
            runAssistantTransportSettings, settings.runAssistantSettings(), clientContext);
    this.chatAiAssistantCallable =
        callableFactory.createUnaryCallable(
            chatAiAssistantTransportSettings, settings.chatAiAssistantSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListAssistantSessionsRequest, ListAssistantSessionsResponse>
      listAssistantSessionsCallable() {
    return listAssistantSessionsCallable;
  }

  @Override
  public UnaryCallable<ListAssistantSessionsRequest, ListAssistantSessionsPagedResponse>
      listAssistantSessionsPagedCallable() {
    return listAssistantSessionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAssistantSessionRequest, AssistantSession> getAssistantSessionCallable() {
    return getAssistantSessionCallable;
  }

  @Override
  public UnaryCallable<CreateAssistantSessionRequest, AssistantSession>
      createAssistantSessionCallable() {
    return createAssistantSessionCallable;
  }

  @Override
  public UnaryCallable<DeleteAssistantSessionRequest, Empty> deleteAssistantSessionCallable() {
    return deleteAssistantSessionCallable;
  }

  @Override
  public UnaryCallable<RunAssistantRequest, RunAssistantResponse> runAssistantCallable() {
    return runAssistantCallable;
  }

  @Override
  public UnaryCallable<ChatAiAssistantRequest, ChatAiAssistantResponse> chatAiAssistantCallable() {
    return chatAiAssistantCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
