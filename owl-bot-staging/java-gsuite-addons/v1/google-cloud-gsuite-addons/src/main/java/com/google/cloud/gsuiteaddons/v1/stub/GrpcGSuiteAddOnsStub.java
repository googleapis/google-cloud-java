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

package com.google.cloud.gsuiteaddons.v1.stub;

import static com.google.cloud.gsuiteaddons.v1.GSuiteAddOnsClient.ListDeploymentsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gsuiteaddons.v1.Authorization;
import com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.Deployment;
import com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest;
import com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest;
import com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.InstallStatus;
import com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest;
import com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse;
import com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest;
import com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the GSuiteAddOns service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcGSuiteAddOnsStub extends GSuiteAddOnsStub {
  private static final MethodDescriptor<GetAuthorizationRequest, Authorization>
      getAuthorizationMethodDescriptor =
          MethodDescriptor.<GetAuthorizationRequest, Authorization>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/GetAuthorization")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAuthorizationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Authorization.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDeploymentRequest, Deployment>
      createDeploymentMethodDescriptor =
          MethodDescriptor.<CreateDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/CreateDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReplaceDeploymentRequest, Deployment>
      replaceDeploymentMethodDescriptor =
          MethodDescriptor.<ReplaceDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/ReplaceDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReplaceDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDeploymentRequest, Deployment>
      getDeploymentMethodDescriptor =
          MethodDescriptor.<GetDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/GetDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsMethodDescriptor =
          MethodDescriptor.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/ListDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDeploymentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDeploymentRequest, Empty>
      deleteDeploymentMethodDescriptor =
          MethodDescriptor.<DeleteDeploymentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/DeleteDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<InstallDeploymentRequest, Empty>
      installDeploymentMethodDescriptor =
          MethodDescriptor.<InstallDeploymentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/InstallDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InstallDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UninstallDeploymentRequest, Empty>
      uninstallDeploymentMethodDescriptor =
          MethodDescriptor.<UninstallDeploymentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/UninstallDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UninstallDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInstallStatusRequest, InstallStatus>
      getInstallStatusMethodDescriptor =
          MethodDescriptor.<GetInstallStatusRequest, InstallStatus>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gsuiteaddons.v1.GSuiteAddOns/GetInstallStatus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetInstallStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(InstallStatus.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetAuthorizationRequest, Authorization> getAuthorizationCallable;
  private final UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable;
  private final UnaryCallable<ReplaceDeploymentRequest, Deployment> replaceDeploymentCallable;
  private final UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable;
  private final UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable;
  private final UnaryCallable<InstallDeploymentRequest, Empty> installDeploymentCallable;
  private final UnaryCallable<UninstallDeploymentRequest, Empty> uninstallDeploymentCallable;
  private final UnaryCallable<GetInstallStatusRequest, InstallStatus> getInstallStatusCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGSuiteAddOnsStub create(GSuiteAddOnsStubSettings settings)
      throws IOException {
    return new GrpcGSuiteAddOnsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGSuiteAddOnsStub create(ClientContext clientContext) throws IOException {
    return new GrpcGSuiteAddOnsStub(GSuiteAddOnsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGSuiteAddOnsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGSuiteAddOnsStub(
        GSuiteAddOnsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGSuiteAddOnsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcGSuiteAddOnsStub(GSuiteAddOnsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcGSuiteAddOnsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGSuiteAddOnsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcGSuiteAddOnsStub(
      GSuiteAddOnsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetAuthorizationRequest, Authorization> getAuthorizationTransportSettings =
        GrpcCallSettings.<GetAuthorizationRequest, Authorization>newBuilder()
            .setMethodDescriptor(getAuthorizationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateDeploymentRequest, Deployment> createDeploymentTransportSettings =
        GrpcCallSettings.<CreateDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(createDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ReplaceDeploymentRequest, Deployment> replaceDeploymentTransportSettings =
        GrpcCallSettings.<ReplaceDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(replaceDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("deployment.name", String.valueOf(request.getDeployment().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetDeploymentRequest, Deployment> getDeploymentTransportSettings =
        GrpcCallSettings.<GetDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(getDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListDeploymentsRequest, ListDeploymentsResponse>
        listDeploymentsTransportSettings =
            GrpcCallSettings.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteDeploymentRequest, Empty> deleteDeploymentTransportSettings =
        GrpcCallSettings.<DeleteDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<InstallDeploymentRequest, Empty> installDeploymentTransportSettings =
        GrpcCallSettings.<InstallDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(installDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UninstallDeploymentRequest, Empty> uninstallDeploymentTransportSettings =
        GrpcCallSettings.<UninstallDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(uninstallDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetInstallStatusRequest, InstallStatus> getInstallStatusTransportSettings =
        GrpcCallSettings.<GetInstallStatusRequest, InstallStatus>newBuilder()
            .setMethodDescriptor(getInstallStatusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.getAuthorizationCallable =
        callableFactory.createUnaryCallable(
            getAuthorizationTransportSettings, settings.getAuthorizationSettings(), clientContext);
    this.createDeploymentCallable =
        callableFactory.createUnaryCallable(
            createDeploymentTransportSettings, settings.createDeploymentSettings(), clientContext);
    this.replaceDeploymentCallable =
        callableFactory.createUnaryCallable(
            replaceDeploymentTransportSettings,
            settings.replaceDeploymentSettings(),
            clientContext);
    this.getDeploymentCallable =
        callableFactory.createUnaryCallable(
            getDeploymentTransportSettings, settings.getDeploymentSettings(), clientContext);
    this.listDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.listDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.deleteDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteDeploymentTransportSettings, settings.deleteDeploymentSettings(), clientContext);
    this.installDeploymentCallable =
        callableFactory.createUnaryCallable(
            installDeploymentTransportSettings,
            settings.installDeploymentSettings(),
            clientContext);
    this.uninstallDeploymentCallable =
        callableFactory.createUnaryCallable(
            uninstallDeploymentTransportSettings,
            settings.uninstallDeploymentSettings(),
            clientContext);
    this.getInstallStatusCallable =
        callableFactory.createUnaryCallable(
            getInstallStatusTransportSettings, settings.getInstallStatusSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetAuthorizationRequest, Authorization> getAuthorizationCallable() {
    return getAuthorizationCallable;
  }

  @Override
  public UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    return createDeploymentCallable;
  }

  @Override
  public UnaryCallable<ReplaceDeploymentRequest, Deployment> replaceDeploymentCallable() {
    return replaceDeploymentCallable;
  }

  @Override
  public UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    return getDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> listDeploymentsCallable() {
    return listDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    return listDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable() {
    return deleteDeploymentCallable;
  }

  @Override
  public UnaryCallable<InstallDeploymentRequest, Empty> installDeploymentCallable() {
    return installDeploymentCallable;
  }

  @Override
  public UnaryCallable<UninstallDeploymentRequest, Empty> uninstallDeploymentCallable() {
    return uninstallDeploymentCallable;
  }

  @Override
  public UnaryCallable<GetInstallStatusRequest, InstallStatus> getInstallStatusCallable() {
    return getInstallStatusCallable;
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
