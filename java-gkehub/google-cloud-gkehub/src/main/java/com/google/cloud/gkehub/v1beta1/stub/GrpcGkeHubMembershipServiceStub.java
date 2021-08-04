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

package com.google.cloud.gkehub.v1beta1.stub;

import static com.google.cloud.gkehub.v1beta1.GkeHubMembershipServiceClient.ListMembershipsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkehub.v1beta1.CreateMembershipRequest;
import com.google.cloud.gkehub.v1beta1.DeleteMembershipRequest;
import com.google.cloud.gkehub.v1beta1.GenerateConnectManifestRequest;
import com.google.cloud.gkehub.v1beta1.GenerateConnectManifestResponse;
import com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestRequest;
import com.google.cloud.gkehub.v1beta1.GenerateExclusivityManifestResponse;
import com.google.cloud.gkehub.v1beta1.GetMembershipRequest;
import com.google.cloud.gkehub.v1beta1.ListMembershipsRequest;
import com.google.cloud.gkehub.v1beta1.ListMembershipsResponse;
import com.google.cloud.gkehub.v1beta1.Membership;
import com.google.cloud.gkehub.v1beta1.OperationMetadata;
import com.google.cloud.gkehub.v1beta1.UpdateMembershipRequest;
import com.google.cloud.gkehub.v1beta1.ValidateExclusivityRequest;
import com.google.cloud.gkehub.v1beta1.ValidateExclusivityResponse;
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
 * gRPC stub implementation for the GkeHubMembershipService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcGkeHubMembershipServiceStub extends GkeHubMembershipServiceStub {
  private static final MethodDescriptor<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsMethodDescriptor =
          MethodDescriptor.<ListMembershipsRequest, ListMembershipsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/ListMemberships")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMembershipsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMembershipsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMembershipRequest, Membership>
      getMembershipMethodDescriptor =
          MethodDescriptor.<GetMembershipRequest, Membership>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/GetMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Membership.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateMembershipRequest, Operation>
      createMembershipMethodDescriptor =
          MethodDescriptor.<CreateMembershipRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/CreateMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMembershipRequest, Operation>
      deleteMembershipMethodDescriptor =
          MethodDescriptor.<DeleteMembershipRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/DeleteMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateMembershipRequest, Operation>
      updateMembershipMethodDescriptor =
          MethodDescriptor.<UpdateMembershipRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/UpdateMembership")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestMethodDescriptor =
          MethodDescriptor
              .<GenerateConnectManifestRequest, GenerateConnectManifestResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/GenerateConnectManifest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateConnectManifestRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateConnectManifestResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ValidateExclusivityRequest, ValidateExclusivityResponse>
      validateExclusivityMethodDescriptor =
          MethodDescriptor.<ValidateExclusivityRequest, ValidateExclusivityResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/ValidateExclusivity")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ValidateExclusivityRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ValidateExclusivityResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
      generateExclusivityManifestMethodDescriptor =
          MethodDescriptor
              .<GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkehub.v1beta1.GkeHubMembershipService/GenerateExclusivityManifest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateExclusivityManifestRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateExclusivityManifestResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListMembershipsRequest, ListMembershipsResponse>
      listMembershipsCallable;
  private final UnaryCallable<ListMembershipsRequest, ListMembershipsPagedResponse>
      listMembershipsPagedCallable;
  private final UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable;
  private final UnaryCallable<CreateMembershipRequest, Operation> createMembershipCallable;
  private final OperationCallable<CreateMembershipRequest, Membership, OperationMetadata>
      createMembershipOperationCallable;
  private final UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable;
  private final OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable;
  private final UnaryCallable<UpdateMembershipRequest, Operation> updateMembershipCallable;
  private final OperationCallable<UpdateMembershipRequest, Membership, OperationMetadata>
      updateMembershipOperationCallable;
  private final UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable;
  private final UnaryCallable<ValidateExclusivityRequest, ValidateExclusivityResponse>
      validateExclusivityCallable;
  private final UnaryCallable<
          GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
      generateExclusivityManifestCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGkeHubMembershipServiceStub create(
      GkeHubMembershipServiceStubSettings settings) throws IOException {
    return new GrpcGkeHubMembershipServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGkeHubMembershipServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcGkeHubMembershipServiceStub(
        GkeHubMembershipServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGkeHubMembershipServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGkeHubMembershipServiceStub(
        GkeHubMembershipServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGkeHubMembershipServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGkeHubMembershipServiceStub(
      GkeHubMembershipServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcGkeHubMembershipServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGkeHubMembershipServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGkeHubMembershipServiceStub(
      GkeHubMembershipServiceStubSettings settings,
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
                    new RequestParamsExtractor<ListMembershipsRequest>() {
                      @Override
                      public Map<String, String> extract(ListMembershipsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetMembershipRequest, Membership> getMembershipTransportSettings =
        GrpcCallSettings.<GetMembershipRequest, Membership>newBuilder()
            .setMethodDescriptor(getMembershipMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetMembershipRequest>() {
                  @Override
                  public Map<String, String> extract(GetMembershipRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateMembershipRequest, Operation> createMembershipTransportSettings =
        GrpcCallSettings.<CreateMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(createMembershipMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateMembershipRequest>() {
                  @Override
                  public Map<String, String> extract(CreateMembershipRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteMembershipRequest, Operation> deleteMembershipTransportSettings =
        GrpcCallSettings.<DeleteMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMembershipMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteMembershipRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteMembershipRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateMembershipRequest, Operation> updateMembershipTransportSettings =
        GrpcCallSettings.<UpdateMembershipRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMembershipMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateMembershipRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateMembershipRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
        generateConnectManifestTransportSettings =
            GrpcCallSettings
                .<GenerateConnectManifestRequest, GenerateConnectManifestResponse>newBuilder()
                .setMethodDescriptor(generateConnectManifestMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GenerateConnectManifestRequest>() {
                      @Override
                      public Map<String, String> extract(GenerateConnectManifestRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ValidateExclusivityRequest, ValidateExclusivityResponse>
        validateExclusivityTransportSettings =
            GrpcCallSettings.<ValidateExclusivityRequest, ValidateExclusivityResponse>newBuilder()
                .setMethodDescriptor(validateExclusivityMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ValidateExclusivityRequest>() {
                      @Override
                      public Map<String, String> extract(ValidateExclusivityRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
        generateExclusivityManifestTransportSettings =
            GrpcCallSettings
                .<GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
                    newBuilder()
                .setMethodDescriptor(generateExclusivityManifestMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GenerateExclusivityManifestRequest>() {
                      @Override
                      public Map<String, String> extract(
                          GenerateExclusivityManifestRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();

    this.listMembershipsCallable =
        callableFactory.createUnaryCallable(
            listMembershipsTransportSettings, settings.listMembershipsSettings(), clientContext);
    this.listMembershipsPagedCallable =
        callableFactory.createPagedCallable(
            listMembershipsTransportSettings, settings.listMembershipsSettings(), clientContext);
    this.getMembershipCallable =
        callableFactory.createUnaryCallable(
            getMembershipTransportSettings, settings.getMembershipSettings(), clientContext);
    this.createMembershipCallable =
        callableFactory.createUnaryCallable(
            createMembershipTransportSettings, settings.createMembershipSettings(), clientContext);
    this.createMembershipOperationCallable =
        callableFactory.createOperationCallable(
            createMembershipTransportSettings,
            settings.createMembershipOperationSettings(),
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
    this.updateMembershipCallable =
        callableFactory.createUnaryCallable(
            updateMembershipTransportSettings, settings.updateMembershipSettings(), clientContext);
    this.updateMembershipOperationCallable =
        callableFactory.createOperationCallable(
            updateMembershipTransportSettings,
            settings.updateMembershipOperationSettings(),
            clientContext,
            operationsStub);
    this.generateConnectManifestCallable =
        callableFactory.createUnaryCallable(
            generateConnectManifestTransportSettings,
            settings.generateConnectManifestSettings(),
            clientContext);
    this.validateExclusivityCallable =
        callableFactory.createUnaryCallable(
            validateExclusivityTransportSettings,
            settings.validateExclusivitySettings(),
            clientContext);
    this.generateExclusivityManifestCallable =
        callableFactory.createUnaryCallable(
            generateExclusivityManifestTransportSettings,
            settings.generateExclusivityManifestSettings(),
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
  public UnaryCallable<GetMembershipRequest, Membership> getMembershipCallable() {
    return getMembershipCallable;
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
  public UnaryCallable<DeleteMembershipRequest, Operation> deleteMembershipCallable() {
    return deleteMembershipCallable;
  }

  @Override
  public OperationCallable<DeleteMembershipRequest, Empty, OperationMetadata>
      deleteMembershipOperationCallable() {
    return deleteMembershipOperationCallable;
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
  public UnaryCallable<GenerateConnectManifestRequest, GenerateConnectManifestResponse>
      generateConnectManifestCallable() {
    return generateConnectManifestCallable;
  }

  @Override
  public UnaryCallable<ValidateExclusivityRequest, ValidateExclusivityResponse>
      validateExclusivityCallable() {
    return validateExclusivityCallable;
  }

  @Override
  public UnaryCallable<GenerateExclusivityManifestRequest, GenerateExclusivityManifestResponse>
      generateExclusivityManifestCallable() {
    return generateExclusivityManifestCallable;
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
