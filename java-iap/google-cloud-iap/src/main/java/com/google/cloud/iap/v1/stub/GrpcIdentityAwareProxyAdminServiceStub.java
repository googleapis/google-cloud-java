/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.iap.v1.stub;

import static com.google.cloud.iap.v1.IdentityAwareProxyAdminServiceClient.ListTunnelDestGroupsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.iap.v1.CreateTunnelDestGroupRequest;
import com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest;
import com.google.cloud.iap.v1.GetIapSettingsRequest;
import com.google.cloud.iap.v1.GetTunnelDestGroupRequest;
import com.google.cloud.iap.v1.IapSettings;
import com.google.cloud.iap.v1.ListTunnelDestGroupsRequest;
import com.google.cloud.iap.v1.ListTunnelDestGroupsResponse;
import com.google.cloud.iap.v1.TunnelDestGroup;
import com.google.cloud.iap.v1.UpdateIapSettingsRequest;
import com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the IdentityAwareProxyAdminService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcIdentityAwareProxyAdminServiceStub extends IdentityAwareProxyAdminServiceStub {
  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.iap.v1.IdentityAwareProxyAdminService/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.iap.v1.IdentityAwareProxyAdminService/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIapSettingsRequest, IapSettings>
      getIapSettingsMethodDescriptor =
          MethodDescriptor.<GetIapSettingsRequest, IapSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/GetIapSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetIapSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IapSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateIapSettingsRequest, IapSettings>
      updateIapSettingsMethodDescriptor =
          MethodDescriptor.<UpdateIapSettingsRequest, IapSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/UpdateIapSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateIapSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IapSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse>
      listTunnelDestGroupsMethodDescriptor =
          MethodDescriptor.<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/ListTunnelDestGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTunnelDestGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTunnelDestGroupsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTunnelDestGroupRequest, TunnelDestGroup>
      createTunnelDestGroupMethodDescriptor =
          MethodDescriptor.<CreateTunnelDestGroupRequest, TunnelDestGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/CreateTunnelDestGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTunnelDestGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TunnelDestGroup.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTunnelDestGroupRequest, TunnelDestGroup>
      getTunnelDestGroupMethodDescriptor =
          MethodDescriptor.<GetTunnelDestGroupRequest, TunnelDestGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/GetTunnelDestGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTunnelDestGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TunnelDestGroup.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTunnelDestGroupRequest, Empty>
      deleteTunnelDestGroupMethodDescriptor =
          MethodDescriptor.<DeleteTunnelDestGroupRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/DeleteTunnelDestGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTunnelDestGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTunnelDestGroupRequest, TunnelDestGroup>
      updateTunnelDestGroupMethodDescriptor =
          MethodDescriptor.<UpdateTunnelDestGroupRequest, TunnelDestGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyAdminService/UpdateTunnelDestGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTunnelDestGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TunnelDestGroup.getDefaultInstance()))
              .build();

  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<GetIapSettingsRequest, IapSettings> getIapSettingsCallable;
  private final UnaryCallable<UpdateIapSettingsRequest, IapSettings> updateIapSettingsCallable;
  private final UnaryCallable<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse>
      listTunnelDestGroupsCallable;
  private final UnaryCallable<ListTunnelDestGroupsRequest, ListTunnelDestGroupsPagedResponse>
      listTunnelDestGroupsPagedCallable;
  private final UnaryCallable<CreateTunnelDestGroupRequest, TunnelDestGroup>
      createTunnelDestGroupCallable;
  private final UnaryCallable<GetTunnelDestGroupRequest, TunnelDestGroup>
      getTunnelDestGroupCallable;
  private final UnaryCallable<DeleteTunnelDestGroupRequest, Empty> deleteTunnelDestGroupCallable;
  private final UnaryCallable<UpdateTunnelDestGroupRequest, TunnelDestGroup>
      updateTunnelDestGroupCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcIdentityAwareProxyAdminServiceStub create(
      IdentityAwareProxyAdminServiceStubSettings settings) throws IOException {
    return new GrpcIdentityAwareProxyAdminServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcIdentityAwareProxyAdminServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcIdentityAwareProxyAdminServiceStub(
        IdentityAwareProxyAdminServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcIdentityAwareProxyAdminServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcIdentityAwareProxyAdminServiceStub(
        IdentityAwareProxyAdminServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcIdentityAwareProxyAdminServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcIdentityAwareProxyAdminServiceStub(
      IdentityAwareProxyAdminServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcIdentityAwareProxyAdminServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcIdentityAwareProxyAdminServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcIdentityAwareProxyAdminServiceStub(
      IdentityAwareProxyAdminServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetIapSettingsRequest, IapSettings> getIapSettingsTransportSettings =
        GrpcCallSettings.<GetIapSettingsRequest, IapSettings>newBuilder()
            .setMethodDescriptor(getIapSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateIapSettingsRequest, IapSettings> updateIapSettingsTransportSettings =
        GrpcCallSettings.<UpdateIapSettingsRequest, IapSettings>newBuilder()
            .setMethodDescriptor(updateIapSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "iap_settings.name", String.valueOf(request.getIapSettings().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse>
        listTunnelDestGroupsTransportSettings =
            GrpcCallSettings.<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse>newBuilder()
                .setMethodDescriptor(listTunnelDestGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateTunnelDestGroupRequest, TunnelDestGroup>
        createTunnelDestGroupTransportSettings =
            GrpcCallSettings.<CreateTunnelDestGroupRequest, TunnelDestGroup>newBuilder()
                .setMethodDescriptor(createTunnelDestGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetTunnelDestGroupRequest, TunnelDestGroup>
        getTunnelDestGroupTransportSettings =
            GrpcCallSettings.<GetTunnelDestGroupRequest, TunnelDestGroup>newBuilder()
                .setMethodDescriptor(getTunnelDestGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteTunnelDestGroupRequest, Empty> deleteTunnelDestGroupTransportSettings =
        GrpcCallSettings.<DeleteTunnelDestGroupRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTunnelDestGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateTunnelDestGroupRequest, TunnelDestGroup>
        updateTunnelDestGroupTransportSettings =
            GrpcCallSettings.<UpdateTunnelDestGroupRequest, TunnelDestGroup>newBuilder()
                .setMethodDescriptor(updateTunnelDestGroupMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "tunnel_dest_group.name",
                          String.valueOf(request.getTunnelDestGroup().getName()));
                      return builder.build();
                    })
                .build();

    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.getIapSettingsCallable =
        callableFactory.createUnaryCallable(
            getIapSettingsTransportSettings, settings.getIapSettingsSettings(), clientContext);
    this.updateIapSettingsCallable =
        callableFactory.createUnaryCallable(
            updateIapSettingsTransportSettings,
            settings.updateIapSettingsSettings(),
            clientContext);
    this.listTunnelDestGroupsCallable =
        callableFactory.createUnaryCallable(
            listTunnelDestGroupsTransportSettings,
            settings.listTunnelDestGroupsSettings(),
            clientContext);
    this.listTunnelDestGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listTunnelDestGroupsTransportSettings,
            settings.listTunnelDestGroupsSettings(),
            clientContext);
    this.createTunnelDestGroupCallable =
        callableFactory.createUnaryCallable(
            createTunnelDestGroupTransportSettings,
            settings.createTunnelDestGroupSettings(),
            clientContext);
    this.getTunnelDestGroupCallable =
        callableFactory.createUnaryCallable(
            getTunnelDestGroupTransportSettings,
            settings.getTunnelDestGroupSettings(),
            clientContext);
    this.deleteTunnelDestGroupCallable =
        callableFactory.createUnaryCallable(
            deleteTunnelDestGroupTransportSettings,
            settings.deleteTunnelDestGroupSettings(),
            clientContext);
    this.updateTunnelDestGroupCallable =
        callableFactory.createUnaryCallable(
            updateTunnelDestGroupTransportSettings,
            settings.updateTunnelDestGroupSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<GetIapSettingsRequest, IapSettings> getIapSettingsCallable() {
    return getIapSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateIapSettingsRequest, IapSettings> updateIapSettingsCallable() {
    return updateIapSettingsCallable;
  }

  @Override
  public UnaryCallable<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse>
      listTunnelDestGroupsCallable() {
    return listTunnelDestGroupsCallable;
  }

  @Override
  public UnaryCallable<ListTunnelDestGroupsRequest, ListTunnelDestGroupsPagedResponse>
      listTunnelDestGroupsPagedCallable() {
    return listTunnelDestGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTunnelDestGroupRequest, TunnelDestGroup>
      createTunnelDestGroupCallable() {
    return createTunnelDestGroupCallable;
  }

  @Override
  public UnaryCallable<GetTunnelDestGroupRequest, TunnelDestGroup> getTunnelDestGroupCallable() {
    return getTunnelDestGroupCallable;
  }

  @Override
  public UnaryCallable<DeleteTunnelDestGroupRequest, Empty> deleteTunnelDestGroupCallable() {
    return deleteTunnelDestGroupCallable;
  }

  @Override
  public UnaryCallable<UpdateTunnelDestGroupRequest, TunnelDestGroup>
      updateTunnelDestGroupCallable() {
    return updateTunnelDestGroupCallable;
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
