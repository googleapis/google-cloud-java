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

package com.google.apps.meet.v2beta.stub;

import static com.google.apps.meet.v2beta.SpacesServiceClient.ListMembersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.apps.meet.v2beta.ConnectActiveConferenceRequest;
import com.google.apps.meet.v2beta.ConnectActiveConferenceResponse;
import com.google.apps.meet.v2beta.CreateMemberRequest;
import com.google.apps.meet.v2beta.CreateSpaceRequest;
import com.google.apps.meet.v2beta.DeleteMemberRequest;
import com.google.apps.meet.v2beta.EndActiveConferenceRequest;
import com.google.apps.meet.v2beta.GetMemberRequest;
import com.google.apps.meet.v2beta.GetSpaceRequest;
import com.google.apps.meet.v2beta.ListMembersRequest;
import com.google.apps.meet.v2beta.ListMembersResponse;
import com.google.apps.meet.v2beta.Member;
import com.google.apps.meet.v2beta.Space;
import com.google.apps.meet.v2beta.UpdateSpaceRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SpacesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSpacesServiceStub extends SpacesServiceStub {
  private static final MethodDescriptor<CreateSpaceRequest, Space> createSpaceMethodDescriptor =
      MethodDescriptor.<CreateSpaceRequest, Space>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.apps.meet.v2beta.SpacesService/CreateSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Space.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetSpaceRequest, Space> getSpaceMethodDescriptor =
      MethodDescriptor.<GetSpaceRequest, Space>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.apps.meet.v2beta.SpacesService/GetSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Space.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSpaceRequest, Space> updateSpaceMethodDescriptor =
      MethodDescriptor.<UpdateSpaceRequest, Space>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.apps.meet.v2beta.SpacesService/UpdateSpace")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSpaceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Space.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<
          ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>
      connectActiveConferenceMethodDescriptor =
          MethodDescriptor
              .<ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.apps.meet.v2beta.SpacesService/ConnectActiveConference")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ConnectActiveConferenceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ConnectActiveConferenceResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EndActiveConferenceRequest, Empty>
      endActiveConferenceMethodDescriptor =
          MethodDescriptor.<EndActiveConferenceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.apps.meet.v2beta.SpacesService/EndActiveConference")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EndActiveConferenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateMemberRequest, Member> createMemberMethodDescriptor =
      MethodDescriptor.<CreateMemberRequest, Member>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.apps.meet.v2beta.SpacesService/CreateMember")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateMemberRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Member.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetMemberRequest, Member> getMemberMethodDescriptor =
      MethodDescriptor.<GetMemberRequest, Member>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.apps.meet.v2beta.SpacesService/GetMember")
          .setRequestMarshaller(ProtoUtils.marshaller(GetMemberRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Member.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListMembersRequest, ListMembersResponse>
      listMembersMethodDescriptor =
          MethodDescriptor.<ListMembersRequest, ListMembersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.apps.meet.v2beta.SpacesService/ListMembers")
              .setRequestMarshaller(ProtoUtils.marshaller(ListMembersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMembersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMemberRequest, Empty> deleteMemberMethodDescriptor =
      MethodDescriptor.<DeleteMemberRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.apps.meet.v2beta.SpacesService/DeleteMember")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteMemberRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable;
  private final UnaryCallable<GetSpaceRequest, Space> getSpaceCallable;
  private final UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable;
  private final UnaryCallable<ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>
      connectActiveConferenceCallable;
  private final UnaryCallable<EndActiveConferenceRequest, Empty> endActiveConferenceCallable;
  private final UnaryCallable<CreateMemberRequest, Member> createMemberCallable;
  private final UnaryCallable<GetMemberRequest, Member> getMemberCallable;
  private final UnaryCallable<ListMembersRequest, ListMembersResponse> listMembersCallable;
  private final UnaryCallable<ListMembersRequest, ListMembersPagedResponse>
      listMembersPagedCallable;
  private final UnaryCallable<DeleteMemberRequest, Empty> deleteMemberCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSpacesServiceStub create(SpacesServiceStubSettings settings)
      throws IOException {
    return new GrpcSpacesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSpacesServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcSpacesServiceStub(SpacesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSpacesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSpacesServiceStub(
        SpacesServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSpacesServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSpacesServiceStub(SpacesServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSpacesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSpacesServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSpacesServiceStub(
      SpacesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSpaceRequest, Space> createSpaceTransportSettings =
        GrpcCallSettings.<CreateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(createSpaceMethodDescriptor)
            .build();
    GrpcCallSettings<GetSpaceRequest, Space> getSpaceTransportSettings =
        GrpcCallSettings.<GetSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(getSpaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSpaceRequest, Space> updateSpaceTransportSettings =
        GrpcCallSettings.<UpdateSpaceRequest, Space>newBuilder()
            .setMethodDescriptor(updateSpaceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("space.name", String.valueOf(request.getSpace().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>
        connectActiveConferenceTransportSettings =
            GrpcCallSettings
                .<ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>newBuilder()
                .setMethodDescriptor(connectActiveConferenceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<EndActiveConferenceRequest, Empty> endActiveConferenceTransportSettings =
        GrpcCallSettings.<EndActiveConferenceRequest, Empty>newBuilder()
            .setMethodDescriptor(endActiveConferenceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateMemberRequest, Member> createMemberTransportSettings =
        GrpcCallSettings.<CreateMemberRequest, Member>newBuilder()
            .setMethodDescriptor(createMemberMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetMemberRequest, Member> getMemberTransportSettings =
        GrpcCallSettings.<GetMemberRequest, Member>newBuilder()
            .setMethodDescriptor(getMemberMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListMembersRequest, ListMembersResponse> listMembersTransportSettings =
        GrpcCallSettings.<ListMembersRequest, ListMembersResponse>newBuilder()
            .setMethodDescriptor(listMembersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteMemberRequest, Empty> deleteMemberTransportSettings =
        GrpcCallSettings.<DeleteMemberRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteMemberMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createSpaceCallable =
        callableFactory.createUnaryCallable(
            createSpaceTransportSettings, settings.createSpaceSettings(), clientContext);
    this.getSpaceCallable =
        callableFactory.createUnaryCallable(
            getSpaceTransportSettings, settings.getSpaceSettings(), clientContext);
    this.updateSpaceCallable =
        callableFactory.createUnaryCallable(
            updateSpaceTransportSettings, settings.updateSpaceSettings(), clientContext);
    this.connectActiveConferenceCallable =
        callableFactory.createUnaryCallable(
            connectActiveConferenceTransportSettings,
            settings.connectActiveConferenceSettings(),
            clientContext);
    this.endActiveConferenceCallable =
        callableFactory.createUnaryCallable(
            endActiveConferenceTransportSettings,
            settings.endActiveConferenceSettings(),
            clientContext);
    this.createMemberCallable =
        callableFactory.createUnaryCallable(
            createMemberTransportSettings, settings.createMemberSettings(), clientContext);
    this.getMemberCallable =
        callableFactory.createUnaryCallable(
            getMemberTransportSettings, settings.getMemberSettings(), clientContext);
    this.listMembersCallable =
        callableFactory.createUnaryCallable(
            listMembersTransportSettings, settings.listMembersSettings(), clientContext);
    this.listMembersPagedCallable =
        callableFactory.createPagedCallable(
            listMembersTransportSettings, settings.listMembersSettings(), clientContext);
    this.deleteMemberCallable =
        callableFactory.createUnaryCallable(
            deleteMemberTransportSettings, settings.deleteMemberSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable() {
    return createSpaceCallable;
  }

  @Override
  public UnaryCallable<GetSpaceRequest, Space> getSpaceCallable() {
    return getSpaceCallable;
  }

  @Override
  public UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable() {
    return updateSpaceCallable;
  }

  @Override
  public UnaryCallable<ConnectActiveConferenceRequest, ConnectActiveConferenceResponse>
      connectActiveConferenceCallable() {
    return connectActiveConferenceCallable;
  }

  @Override
  public UnaryCallable<EndActiveConferenceRequest, Empty> endActiveConferenceCallable() {
    return endActiveConferenceCallable;
  }

  @Override
  public UnaryCallable<CreateMemberRequest, Member> createMemberCallable() {
    return createMemberCallable;
  }

  @Override
  public UnaryCallable<GetMemberRequest, Member> getMemberCallable() {
    return getMemberCallable;
  }

  @Override
  public UnaryCallable<ListMembersRequest, ListMembersResponse> listMembersCallable() {
    return listMembersCallable;
  }

  @Override
  public UnaryCallable<ListMembersRequest, ListMembersPagedResponse> listMembersPagedCallable() {
    return listMembersPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteMemberRequest, Empty> deleteMemberCallable() {
    return deleteMemberCallable;
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
