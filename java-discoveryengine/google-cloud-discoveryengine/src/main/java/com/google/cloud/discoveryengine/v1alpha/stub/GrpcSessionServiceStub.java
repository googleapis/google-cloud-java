/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.SessionServiceClient.ListFilesPagedResponse;
import static com.google.cloud.discoveryengine.v1alpha.SessionServiceClient.ListSessionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.CreateSessionRequest;
import com.google.cloud.discoveryengine.v1alpha.DeleteSessionRequest;
import com.google.cloud.discoveryengine.v1alpha.GetSessionRequest;
import com.google.cloud.discoveryengine.v1alpha.ListFilesRequest;
import com.google.cloud.discoveryengine.v1alpha.ListFilesResponse;
import com.google.cloud.discoveryengine.v1alpha.ListSessionsRequest;
import com.google.cloud.discoveryengine.v1alpha.ListSessionsResponse;
import com.google.cloud.discoveryengine.v1alpha.Session;
import com.google.cloud.discoveryengine.v1alpha.UpdateSessionRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SessionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSessionServiceStub extends SessionServiceStub {
  private static final MethodDescriptor<CreateSessionRequest, Session>
      createSessionMethodDescriptor =
          MethodDescriptor.<CreateSessionRequest, Session>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SessionService/CreateSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Session.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteSessionRequest, Empty> deleteSessionMethodDescriptor =
      MethodDescriptor.<DeleteSessionRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.discoveryengine.v1alpha.SessionService/DeleteSession")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSessionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateSessionRequest, Session>
      updateSessionMethodDescriptor =
          MethodDescriptor.<UpdateSessionRequest, Session>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SessionService/UpdateSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Session.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSessionRequest, Session> getSessionMethodDescriptor =
      MethodDescriptor.<GetSessionRequest, Session>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.discoveryengine.v1alpha.SessionService/GetSession")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSessionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Session.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListSessionsRequest, ListSessionsResponse>
      listSessionsMethodDescriptor =
          MethodDescriptor.<ListSessionsRequest, ListSessionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.discoveryengine.v1alpha.SessionService/ListSessions")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSessionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSessionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListFilesRequest, ListFilesResponse>
      listFilesMethodDescriptor =
          MethodDescriptor.<ListFilesRequest, ListFilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.discoveryengine.v1alpha.SessionService/ListFiles")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListFilesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateSessionRequest, Session> createSessionCallable;
  private final UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable;
  private final UnaryCallable<UpdateSessionRequest, Session> updateSessionCallable;
  private final UnaryCallable<GetSessionRequest, Session> getSessionCallable;
  private final UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable;
  private final UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse>
      listSessionsPagedCallable;
  private final UnaryCallable<ListFilesRequest, ListFilesResponse> listFilesCallable;
  private final UnaryCallable<ListFilesRequest, ListFilesPagedResponse> listFilesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSessionServiceStub create(SessionServiceStubSettings settings)
      throws IOException {
    return new GrpcSessionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSessionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSessionServiceStub(
        SessionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSessionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSessionServiceStub(
        SessionServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSessionServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSessionServiceStub(SessionServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSessionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSessionServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSessionServiceStub(
      SessionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSessionRequest, Session> createSessionTransportSettings =
        GrpcCallSettings.<CreateSessionRequest, Session>newBuilder()
            .setMethodDescriptor(createSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSessionRequest, Empty> deleteSessionTransportSettings =
        GrpcCallSettings.<DeleteSessionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSessionRequest, Session> updateSessionTransportSettings =
        GrpcCallSettings.<UpdateSessionRequest, Session>newBuilder()
            .setMethodDescriptor(updateSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session.name", String.valueOf(request.getSession().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSessionRequest, Session> getSessionTransportSettings =
        GrpcCallSettings.<GetSessionRequest, Session>newBuilder()
            .setMethodDescriptor(getSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSessionsRequest, ListSessionsResponse> listSessionsTransportSettings =
        GrpcCallSettings.<ListSessionsRequest, ListSessionsResponse>newBuilder()
            .setMethodDescriptor(listSessionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListFilesRequest, ListFilesResponse> listFilesTransportSettings =
        GrpcCallSettings.<ListFilesRequest, ListFilesResponse>newBuilder()
            .setMethodDescriptor(listFilesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.createSessionCallable =
        callableFactory.createUnaryCallable(
            createSessionTransportSettings, settings.createSessionSettings(), clientContext);
    this.deleteSessionCallable =
        callableFactory.createUnaryCallable(
            deleteSessionTransportSettings, settings.deleteSessionSettings(), clientContext);
    this.updateSessionCallable =
        callableFactory.createUnaryCallable(
            updateSessionTransportSettings, settings.updateSessionSettings(), clientContext);
    this.getSessionCallable =
        callableFactory.createUnaryCallable(
            getSessionTransportSettings, settings.getSessionSettings(), clientContext);
    this.listSessionsCallable =
        callableFactory.createUnaryCallable(
            listSessionsTransportSettings, settings.listSessionsSettings(), clientContext);
    this.listSessionsPagedCallable =
        callableFactory.createPagedCallable(
            listSessionsTransportSettings, settings.listSessionsSettings(), clientContext);
    this.listFilesCallable =
        callableFactory.createUnaryCallable(
            listFilesTransportSettings, settings.listFilesSettings(), clientContext);
    this.listFilesPagedCallable =
        callableFactory.createPagedCallable(
            listFilesTransportSettings, settings.listFilesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateSessionRequest, Session> createSessionCallable() {
    return createSessionCallable;
  }

  @Override
  public UnaryCallable<DeleteSessionRequest, Empty> deleteSessionCallable() {
    return deleteSessionCallable;
  }

  @Override
  public UnaryCallable<UpdateSessionRequest, Session> updateSessionCallable() {
    return updateSessionCallable;
  }

  @Override
  public UnaryCallable<GetSessionRequest, Session> getSessionCallable() {
    return getSessionCallable;
  }

  @Override
  public UnaryCallable<ListSessionsRequest, ListSessionsResponse> listSessionsCallable() {
    return listSessionsCallable;
  }

  @Override
  public UnaryCallable<ListSessionsRequest, ListSessionsPagedResponse> listSessionsPagedCallable() {
    return listSessionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListFilesRequest, ListFilesResponse> listFilesCallable() {
    return listFilesCallable;
  }

  @Override
  public UnaryCallable<ListFilesRequest, ListFilesPagedResponse> listFilesPagedCallable() {
    return listFilesPagedCallable;
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
