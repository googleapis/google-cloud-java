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

package com.google.cloud.gkehub.v1.stub;

import static com.google.cloud.gkehub.v1.GkeHubClient.ListFeaturesPagedResponse;
import static com.google.cloud.gkehub.v1.GkeHubClient.ListMembershipsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkehub.v1.CreateFeatureRequest;
import com.google.cloud.gkehub.v1.CreateMembershipRequest;
import com.google.cloud.gkehub.v1.DeleteFeatureRequest;
import com.google.cloud.gkehub.v1.DeleteMembershipRequest;
import com.google.cloud.gkehub.v1.Feature;
import com.google.cloud.gkehub.v1.GenerateConnectManifestRequest;
import com.google.cloud.gkehub.v1.GenerateConnectManifestResponse;
import com.google.cloud.gkehub.v1.GetFeatureRequest;
import com.google.cloud.gkehub.v1.GetMembershipRequest;
import com.google.cloud.gkehub.v1.ListFeaturesRequest;
import com.google.cloud.gkehub.v1.ListFeaturesResponse;
import com.google.cloud.gkehub.v1.ListMembershipsRequest;
import com.google.cloud.gkehub.v1.ListMembershipsResponse;
import com.google.cloud.gkehub.v1.Membership;
import com.google.cloud.gkehub.v1.OperationMetadata;
import com.google.cloud.gkehub.v1.UpdateFeatureRequest;
import com.google.cloud.gkehub.v1.UpdateMembershipRequest;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the GkeHub service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcGkeHubStub extends GkeHubStub {
  private static final MethodDescriptor<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsMethodDescriptor =
          MethodDescriptor.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListMemberships")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMembershipsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMembershipsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListFeaturesRequest, ListFeaturesResponse>
      listFeaturesMethodDescriptor =
          MethodDescriptor.<ListFeaturesRequest, ListFeaturesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/ListFeatures")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFeaturesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFeaturesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMembershipRequest, Membership>
      getMembershipMethodDescriptor =
          MethodDescriptor.<GetMembershipRequest, Membership>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Membership.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFeatureRequest, Feature> getFeatureMethodDescriptor =
      MethodDescriptor.<GetFeatureRequest, Feature>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GetFeature")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFeatureRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Feature.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateMembershipRequest, Operation>
      createMembershipMethodDescriptor =
          MethodDescriptor.<CreateMembershipRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateFeatureRequest, Operation>
      createFeatureMethodDescriptor =
          MethodDescriptor.<CreateFeatureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/CreateFeature")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMembershipRequest, Operation>
      deleteMembershipMethodDescriptor =
          MethodDescriptor.<DeleteMembershipRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteFeatureRequest, Operation>
      deleteFeatureMethodDescriptor =
          MethodDescriptor.<DeleteFeatureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/DeleteFeature")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateMembershipRequest, Operation>
      updateMembershipMethodDescriptor =
          MethodDescriptor.<UpdateMembershipRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFeatureRequest, Operation>
      updateFeatureMethodDescriptor =
          MethodDescriptor.<UpdateFeatureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/UpdateFeature")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestMethodDescriptor =
          MethodDescriptor
              .<GenerateConnectManifestRequest, GenerateConnectManifestResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkehub.v1.GkeHub/GenerateConnectManifest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateConnectManifestRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateConnectManifestResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsCallable;
  private final UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable;
  private final UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> listFeaturesCallable;
  private final UnaryCallable<ListFeaturesRequest, ListFeaturesPagedResponse>
      listFeaturesPagedCallable;
  private final UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable;
  private final UnaryCallable<GetFeatureRequest, Feature> getFeatureCallable;
  private final UnaryCallable<CreateMembershipRequest, Operation> createMembershipCallable;
  private final OperationCallable<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationCallable;
  private final UnaryCallable<CreateFeatureRequest, Operation> createFeatureCallable;
  private final OperationCallable<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationCallable;
  private final UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable;
  private final OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable;
  private final UnaryCallable<DeleteFeatureRequest, Operation> deleteFeatureCallable;
  private final OperationCallable<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationCallable;
  private final UnaryCallable<UpdateMembershipRequest, Operation> updateMembershipCallable;
  private final OperationCallable<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationCallable;
  private final UnaryCallable<UpdateFeatureRequest, Operation> updateFeatureCallable;
  private final OperationCallable<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationCallable;
  private final UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGkeHubStub create(GkeHubStubSettings settings) throws IOException {
    return new GrpcGkeHubStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGkeHubStub create(ClientContext clientContext) throws IOException {
    return new GrpcGkeHubStub(GkeHubStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGkeHubStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGkeHubStub(
        GkeHubStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGkeHubStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcGkeHubStub(GkeHubStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcGkeHubCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGkeHubStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcGkeHubStub(
      GkeHubStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListMembershipsRequest, ListMembershipsResponse>
        listMembershipsTransportSettings =
            GrpcCallSettings.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
                .setMethodDescriptor(listMembershipsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListFeaturesRequest, ListFeaturesResponse> listFeaturesTransportSettings =
        GrpcCallSettings.<ListFeaturesRequest, ListFeaturesResponse>newBuilder()
            .setMethodDescriptor(listFeaturesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetMembershipRequest, Membership> getMembershipTransportSettings =
        GrpcCallSettings.<GetMembershipRequest, Membership>newBuilder()
            .setMethodDescriptor(getMembershipMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetFeatureRequest, Feature> getFeatureTransportSettings =
        GrpcCallSettings.<GetFeatureRequest, Feature>newBuilder()
            .setMethodDescriptor(getFeatureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateMembershipRequest, Operation> createMembershipTransportSettings =
        GrpcCallSettings.<CreateMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(createMembershipMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateFeatureRequest, Operation> createFeatureTransportSettings =
        GrpcCallSettings.<CreateFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(createFeatureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteMembershipRequest, Operation> deleteMembershipTransportSettings =
        GrpcCallSettings.<DeleteMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMembershipMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteFeatureRequest, Operation> deleteFeatureTransportSettings =
        GrpcCallSettings.<DeleteFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFeatureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateMembershipRequest, Operation> updateMembershipTransportSettings =
        GrpcCallSettings.<UpdateMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMembershipMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateFeatureRequest, Operation> updateFeatureTransportSettings =
        GrpcCallSettings.<UpdateFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFeatureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
        generateConnectManifestTransportSettings =
            GrpcCallSettings
                .<GenerateConnectManifestRequest, GenerateConnectManifestResponse>newBuilder()
                .setMethodDescriptor(generateConnectManifestMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();

    this.listMembershipsCallable =
        callableFactory.createUnaryCallable(
            listMembershipsTransportSettings, settings.listMembershipsSettings(), clientContext);
    this.listMembershipsPagedCallable =
        callableFactory.createPagedCallable(
            listMembershipsTransportSettings, settings.listMembershipsSettings(), clientContext);
    this.listFeaturesCallable =
        callableFactory.createUnaryCallable(
            listFeaturesTransportSettings, settings.listFeaturesSettings(), clientContext);
    this.listFeaturesPagedCallable =
        callableFactory.createPagedCallable(
            listFeaturesTransportSettings, settings.listFeaturesSettings(), clientContext);
    this.getMembershipCallable =
        callableFactory.createUnaryCallable(
            getMembershipTransportSettings, settings.getMembershipSettings(), clientContext);
    this.getFeatureCallable =
        callableFactory.createUnaryCallable(
            getFeatureTransportSettings, settings.getFeatureSettings(), clientContext);
    this.createMembershipCallable =
        callableFactory.createUnaryCallable(
            createMembershipTransportSettings, settings.createMembershipSettings(), clientContext);
    this.createMembershipOperationCallable =
        callableFactory.createOperationCallable(
            createMembershipTransportSettings,
            settings.createMembershipOperationSettings(),
            clientContext,
            operationsStub);
    this.createFeatureCallable =
        callableFactory.createUnaryCallable(
            createFeatureTransportSettings, settings.createFeatureSettings(), clientContext);
    this.createFeatureOperationCallable =
        callableFactory.createOperationCallable(
            createFeatureTransportSettings,
            settings.createFeatureOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMembershipCallable =
        callableFactory.createUnaryCallable(
            deleteMembershipTransportSettings, settings.deleteMembershipSettings(), clientContext);
    this.deleteMembershipOperationCallable =
        callableFactory.createOperationCallable(
            deleteMembershipTransportSettings,
            settings.deleteMembershipOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFeatureCallable =
        callableFactory.createUnaryCallable(
            deleteFeatureTransportSettings, settings.deleteFeatureSettings(), clientContext);
    this.deleteFeatureOperationCallable =
        callableFactory.createOperationCallable(
            deleteFeatureTransportSettings,
            settings.deleteFeatureOperationSettings(),
            clientContext,
            operationsStub);
    this.updateMembershipCallable =
        callableFactory.createUnaryCallable(
            updateMembershipTransportSettings, settings.updateMembershipSettings(), clientContext);
    this.updateMembershipOperationCallable =
        callableFactory.createOperationCallable(
            updateMembershipTransportSettings,
            settings.updateMembershipOperationSettings(),
            clientContext,
            operationsStub);
    this.updateFeatureCallable =
        callableFactory.createUnaryCallable(
            updateFeatureTransportSettings, settings.updateFeatureSettings(), clientContext);
    this.updateFeatureOperationCallable =
        callableFactory.createOperationCallable(
            updateFeatureTransportSettings,
            settings.updateFeatureOperationSettings(),
            clientContext,
            operationsStub);
    this.generateConnectManifestCallable =
        callableFactory.createUnaryCallable(
            generateConnectManifestTransportSettings,
            settings.generateConnectManifestSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListMembershipsRequest, ListMembershipsResponse> listMembershipsCallable() {
    return listMembershipsCallable;
  }

  @Override
  public UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable() {
    return listMembershipsPagedCallable;
  }

  @Override
  public UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> listFeaturesCallable() {
    return listFeaturesCallable;
  }

  @Override
  public UnaryCallable<ListFeaturesRequest, ListFeaturesPagedResponse> listFeaturesPagedCallable() {
    return listFeaturesPagedCallable;
  }

  @Override
  public UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable() {
    return getMembershipCallable;
  }

  @Override
  public UnaryCallable<GetFeatureRequest, Feature> getFeatureCallable() {
    return getFeatureCallable;
  }

  @Override
  public UnaryCallable<CreateMembershipRequest, Operation> createMembershipCallable() {
    return createMembershipCallable;
  }

  @Override
  public OperationCallable<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationCallable() {
    return createMembershipOperationCallable;
  }

  @Override
  public UnaryCallable<CreateFeatureRequest, Operation> createFeatureCallable() {
    return createFeatureCallable;
  }

  @Override
  public OperationCallable<CreateFeatureRequest, Feature, OperationMetadata>
      createFeatureOperationCallable() {
    return createFeatureOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable() {
    return deleteMembershipCallable;
  }

  @Override
  public OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable() {
    return deleteMembershipOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFeatureRequest, Operation> deleteFeatureCallable() {
    return deleteFeatureCallable;
  }

  @Override
  public OperationCallable<DeleteFeatureRequest, Empty, OperationMetadata>
      deleteFeatureOperationCallable() {
    return deleteFeatureOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMembershipRequest, Operation> updateMembershipCallable() {
    return updateMembershipCallable;
  }

  @Override
  public OperationCallable<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationCallable() {
    return updateMembershipOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFeatureRequest, Operation> updateFeatureCallable() {
    return updateFeatureCallable;
  }

  @Override
  public OperationCallable<UpdateFeatureRequest, Feature, OperationMetadata>
      updateFeatureOperationCallable() {
    return updateFeatureOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable() {
    return generateConnectManifestCallable;
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
