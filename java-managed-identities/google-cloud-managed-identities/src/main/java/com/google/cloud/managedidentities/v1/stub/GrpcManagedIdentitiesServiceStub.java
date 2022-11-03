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

package com.google.cloud.managedidentities.v1.stub;

import static com.google.cloud.managedidentities.v1.ManagedIdentitiesServiceClient.ListDomainsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.managedidentities.v1.AttachTrustRequest;
import com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest;
import com.google.cloud.managedidentities.v1.DeleteDomainRequest;
import com.google.cloud.managedidentities.v1.DetachTrustRequest;
import com.google.cloud.managedidentities.v1.Domain;
import com.google.cloud.managedidentities.v1.GetDomainRequest;
import com.google.cloud.managedidentities.v1.ListDomainsRequest;
import com.google.cloud.managedidentities.v1.ListDomainsResponse;
import com.google.cloud.managedidentities.v1.OpMetadata;
import com.google.cloud.managedidentities.v1.ReconfigureTrustRequest;
import com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest;
import com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse;
import com.google.cloud.managedidentities.v1.UpdateDomainRequest;
import com.google.cloud.managedidentities.v1.ValidateTrustRequest;
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
 * gRPC stub implementation for the ManagedIdentitiesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcManagedIdentitiesServiceStub extends ManagedIdentitiesServiceStub {
  private static final MethodDescriptor<CreateMicrosoftAdDomainRequest, Operation>
      createMicrosoftAdDomainMethodDescriptor =
          MethodDescriptor.<CreateMicrosoftAdDomainRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.managedidentities.v1.ManagedIdentitiesService/CreateMicrosoftAdDomain")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMicrosoftAdDomainRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResetAdminPasswordRequest, ResetAdminPasswordResponse>
      resetAdminPasswordMethodDescriptor =
          MethodDescriptor.<ResetAdminPasswordRequest, ResetAdminPasswordResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.managedidentities.v1.ManagedIdentitiesService/ResetAdminPassword")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResetAdminPasswordRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ResetAdminPasswordResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDomainsRequest, ListDomainsResponse>
      listDomainsMethodDescriptor =
          MethodDescriptor.<ListDomainsRequest, ListDomainsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.managedidentities.v1.ManagedIdentitiesService/ListDomains")
              .setRequestMarshaller(ProtoUtils.marshaller(ListDomainsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDomainsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDomainRequest, Domain> getDomainMethodDescriptor =
      MethodDescriptor.<GetDomainRequest, Domain>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.managedidentities.v1.ManagedIdentitiesService/GetDomain")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDomainRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Domain.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateDomainRequest, Operation>
      updateDomainMethodDescriptor =
          MethodDescriptor.<UpdateDomainRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.managedidentities.v1.ManagedIdentitiesService/UpdateDomain")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateDomainRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDomainRequest, Operation>
      deleteDomainMethodDescriptor =
          MethodDescriptor.<DeleteDomainRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.managedidentities.v1.ManagedIdentitiesService/DeleteDomain")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteDomainRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AttachTrustRequest, Operation> attachTrustMethodDescriptor =
      MethodDescriptor.<AttachTrustRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.managedidentities.v1.ManagedIdentitiesService/AttachTrust")
          .setRequestMarshaller(ProtoUtils.marshaller(AttachTrustRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ReconfigureTrustRequest, Operation>
      reconfigureTrustMethodDescriptor =
          MethodDescriptor.<ReconfigureTrustRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.managedidentities.v1.ManagedIdentitiesService/ReconfigureTrust")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReconfigureTrustRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DetachTrustRequest, Operation> detachTrustMethodDescriptor =
      MethodDescriptor.<DetachTrustRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.managedidentities.v1.ManagedIdentitiesService/DetachTrust")
          .setRequestMarshaller(ProtoUtils.marshaller(DetachTrustRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ValidateTrustRequest, Operation>
      validateTrustMethodDescriptor =
          MethodDescriptor.<ValidateTrustRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.managedidentities.v1.ManagedIdentitiesService/ValidateTrust")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ValidateTrustRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateMicrosoftAdDomainRequest, Operation>
      createMicrosoftAdDomainCallable;
  private final OperationCallable<CreateMicrosoftAdDomainRequest, Domain, OpMetadata>
      createMicrosoftAdDomainOperationCallable;
  private final UnaryCallable<ResetAdminPasswordRequest, ResetAdminPasswordResponse>
      resetAdminPasswordCallable;
  private final UnaryCallable<ListDomainsRequest, ListDomainsResponse> listDomainsCallable;
  private final UnaryCallable<ListDomainsRequest, ListDomainsPagedResponse>
      listDomainsPagedCallable;
  private final UnaryCallable<GetDomainRequest, Domain> getDomainCallable;
  private final UnaryCallable<UpdateDomainRequest, Operation> updateDomainCallable;
  private final OperationCallable<UpdateDomainRequest, Domain, OpMetadata>
      updateDomainOperationCallable;
  private final UnaryCallable<DeleteDomainRequest, Operation> deleteDomainCallable;
  private final OperationCallable<DeleteDomainRequest, Empty, OpMetadata>
      deleteDomainOperationCallable;
  private final UnaryCallable<AttachTrustRequest, Operation> attachTrustCallable;
  private final OperationCallable<AttachTrustRequest, Domain, OpMetadata>
      attachTrustOperationCallable;
  private final UnaryCallable<ReconfigureTrustRequest, Operation> reconfigureTrustCallable;
  private final OperationCallable<ReconfigureTrustRequest, Domain, OpMetadata>
      reconfigureTrustOperationCallable;
  private final UnaryCallable<DetachTrustRequest, Operation> detachTrustCallable;
  private final OperationCallable<DetachTrustRequest, Domain, OpMetadata>
      detachTrustOperationCallable;
  private final UnaryCallable<ValidateTrustRequest, Operation> validateTrustCallable;
  private final OperationCallable<ValidateTrustRequest, Domain, OpMetadata>
      validateTrustOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcManagedIdentitiesServiceStub create(
      ManagedIdentitiesServiceStubSettings settings) throws IOException {
    return new GrpcManagedIdentitiesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcManagedIdentitiesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcManagedIdentitiesServiceStub(
        ManagedIdentitiesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcManagedIdentitiesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcManagedIdentitiesServiceStub(
        ManagedIdentitiesServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcManagedIdentitiesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcManagedIdentitiesServiceStub(
      ManagedIdentitiesServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcManagedIdentitiesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcManagedIdentitiesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcManagedIdentitiesServiceStub(
      ManagedIdentitiesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateMicrosoftAdDomainRequest, Operation>
        createMicrosoftAdDomainTransportSettings =
            GrpcCallSettings.<CreateMicrosoftAdDomainRequest, Operation>newBuilder()
                .setMethodDescriptor(createMicrosoftAdDomainMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ResetAdminPasswordRequest, ResetAdminPasswordResponse>
        resetAdminPasswordTransportSettings =
            GrpcCallSettings.<ResetAdminPasswordRequest, ResetAdminPasswordResponse>newBuilder()
                .setMethodDescriptor(resetAdminPasswordMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListDomainsRequest, ListDomainsResponse> listDomainsTransportSettings =
        GrpcCallSettings.<ListDomainsRequest, ListDomainsResponse>newBuilder()
            .setMethodDescriptor(listDomainsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetDomainRequest, Domain> getDomainTransportSettings =
        GrpcCallSettings.<GetDomainRequest, Domain>newBuilder()
            .setMethodDescriptor(getDomainMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateDomainRequest, Operation> updateDomainTransportSettings =
        GrpcCallSettings.<UpdateDomainRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDomainMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("domain.name", String.valueOf(request.getDomain().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteDomainRequest, Operation> deleteDomainTransportSettings =
        GrpcCallSettings.<DeleteDomainRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDomainMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<AttachTrustRequest, Operation> attachTrustTransportSettings =
        GrpcCallSettings.<AttachTrustRequest, Operation>newBuilder()
            .setMethodDescriptor(attachTrustMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ReconfigureTrustRequest, Operation> reconfigureTrustTransportSettings =
        GrpcCallSettings.<ReconfigureTrustRequest, Operation>newBuilder()
            .setMethodDescriptor(reconfigureTrustMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DetachTrustRequest, Operation> detachTrustTransportSettings =
        GrpcCallSettings.<DetachTrustRequest, Operation>newBuilder()
            .setMethodDescriptor(detachTrustMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ValidateTrustRequest, Operation> validateTrustTransportSettings =
        GrpcCallSettings.<ValidateTrustRequest, Operation>newBuilder()
            .setMethodDescriptor(validateTrustMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.createMicrosoftAdDomainCallable =
        callableFactory.createUnaryCallable(
            createMicrosoftAdDomainTransportSettings,
            settings.createMicrosoftAdDomainSettings(),
            clientContext);
    this.createMicrosoftAdDomainOperationCallable =
        callableFactory.createOperationCallable(
            createMicrosoftAdDomainTransportSettings,
            settings.createMicrosoftAdDomainOperationSettings(),
            clientContext,
            operationsStub);
    this.resetAdminPasswordCallable =
        callableFactory.createUnaryCallable(
            resetAdminPasswordTransportSettings,
            settings.resetAdminPasswordSettings(),
            clientContext);
    this.listDomainsCallable =
        callableFactory.createUnaryCallable(
            listDomainsTransportSettings, settings.listDomainsSettings(), clientContext);
    this.listDomainsPagedCallable =
        callableFactory.createPagedCallable(
            listDomainsTransportSettings, settings.listDomainsSettings(), clientContext);
    this.getDomainCallable =
        callableFactory.createUnaryCallable(
            getDomainTransportSettings, settings.getDomainSettings(), clientContext);
    this.updateDomainCallable =
        callableFactory.createUnaryCallable(
            updateDomainTransportSettings, settings.updateDomainSettings(), clientContext);
    this.updateDomainOperationCallable =
        callableFactory.createOperationCallable(
            updateDomainTransportSettings,
            settings.updateDomainOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDomainCallable =
        callableFactory.createUnaryCallable(
            deleteDomainTransportSettings, settings.deleteDomainSettings(), clientContext);
    this.deleteDomainOperationCallable =
        callableFactory.createOperationCallable(
            deleteDomainTransportSettings,
            settings.deleteDomainOperationSettings(),
            clientContext,
            operationsStub);
    this.attachTrustCallable =
        callableFactory.createUnaryCallable(
            attachTrustTransportSettings, settings.attachTrustSettings(), clientContext);
    this.attachTrustOperationCallable =
        callableFactory.createOperationCallable(
            attachTrustTransportSettings,
            settings.attachTrustOperationSettings(),
            clientContext,
            operationsStub);
    this.reconfigureTrustCallable =
        callableFactory.createUnaryCallable(
            reconfigureTrustTransportSettings, settings.reconfigureTrustSettings(), clientContext);
    this.reconfigureTrustOperationCallable =
        callableFactory.createOperationCallable(
            reconfigureTrustTransportSettings,
            settings.reconfigureTrustOperationSettings(),
            clientContext,
            operationsStub);
    this.detachTrustCallable =
        callableFactory.createUnaryCallable(
            detachTrustTransportSettings, settings.detachTrustSettings(), clientContext);
    this.detachTrustOperationCallable =
        callableFactory.createOperationCallable(
            detachTrustTransportSettings,
            settings.detachTrustOperationSettings(),
            clientContext,
            operationsStub);
    this.validateTrustCallable =
        callableFactory.createUnaryCallable(
            validateTrustTransportSettings, settings.validateTrustSettings(), clientContext);
    this.validateTrustOperationCallable =
        callableFactory.createOperationCallable(
            validateTrustTransportSettings,
            settings.validateTrustOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateMicrosoftAdDomainRequest, Operation>
      createMicrosoftAdDomainCallable() {
    return createMicrosoftAdDomainCallable;
  }

  @Override
  public OperationCallable<CreateMicrosoftAdDomainRequest, Domain, OpMetadata>
      createMicrosoftAdDomainOperationCallable() {
    return createMicrosoftAdDomainOperationCallable;
  }

  @Override
  public UnaryCallable<ResetAdminPasswordRequest, ResetAdminPasswordResponse>
      resetAdminPasswordCallable() {
    return resetAdminPasswordCallable;
  }

  @Override
  public UnaryCallable<ListDomainsRequest, ListDomainsResponse> listDomainsCallable() {
    return listDomainsCallable;
  }

  @Override
  public UnaryCallable<ListDomainsRequest, ListDomainsPagedResponse> listDomainsPagedCallable() {
    return listDomainsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDomainRequest, Domain> getDomainCallable() {
    return getDomainCallable;
  }

  @Override
  public UnaryCallable<UpdateDomainRequest, Operation> updateDomainCallable() {
    return updateDomainCallable;
  }

  @Override
  public OperationCallable<UpdateDomainRequest, Domain, OpMetadata>
      updateDomainOperationCallable() {
    return updateDomainOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDomainRequest, Operation> deleteDomainCallable() {
    return deleteDomainCallable;
  }

  @Override
  public OperationCallable<DeleteDomainRequest, Empty, OpMetadata> deleteDomainOperationCallable() {
    return deleteDomainOperationCallable;
  }

  @Override
  public UnaryCallable<AttachTrustRequest, Operation> attachTrustCallable() {
    return attachTrustCallable;
  }

  @Override
  public OperationCallable<AttachTrustRequest, Domain, OpMetadata> attachTrustOperationCallable() {
    return attachTrustOperationCallable;
  }

  @Override
  public UnaryCallable<ReconfigureTrustRequest, Operation> reconfigureTrustCallable() {
    return reconfigureTrustCallable;
  }

  @Override
  public OperationCallable<ReconfigureTrustRequest, Domain, OpMetadata>
      reconfigureTrustOperationCallable() {
    return reconfigureTrustOperationCallable;
  }

  @Override
  public UnaryCallable<DetachTrustRequest, Operation> detachTrustCallable() {
    return detachTrustCallable;
  }

  @Override
  public OperationCallable<DetachTrustRequest, Domain, OpMetadata> detachTrustOperationCallable() {
    return detachTrustOperationCallable;
  }

  @Override
  public UnaryCallable<ValidateTrustRequest, Operation> validateTrustCallable() {
    return validateTrustCallable;
  }

  @Override
  public OperationCallable<ValidateTrustRequest, Domain, OpMetadata>
      validateTrustOperationCallable() {
    return validateTrustOperationCallable;
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
