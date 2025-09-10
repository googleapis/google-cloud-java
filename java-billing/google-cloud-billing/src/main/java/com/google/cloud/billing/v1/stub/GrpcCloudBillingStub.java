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

package com.google.cloud.billing.v1.stub;

import static com.google.cloud.billing.v1.CloudBillingClient.ListBillingAccountsPagedResponse;
import static com.google.cloud.billing.v1.CloudBillingClient.ListProjectBillingInfoPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.billing.v1.BillingAccount;
import com.google.cloud.billing.v1.CreateBillingAccountRequest;
import com.google.cloud.billing.v1.GetBillingAccountRequest;
import com.google.cloud.billing.v1.GetProjectBillingInfoRequest;
import com.google.cloud.billing.v1.ListBillingAccountsRequest;
import com.google.cloud.billing.v1.ListBillingAccountsResponse;
import com.google.cloud.billing.v1.ListProjectBillingInfoRequest;
import com.google.cloud.billing.v1.ListProjectBillingInfoResponse;
import com.google.cloud.billing.v1.MoveBillingAccountRequest;
import com.google.cloud.billing.v1.ProjectBillingInfo;
import com.google.cloud.billing.v1.UpdateBillingAccountRequest;
import com.google.cloud.billing.v1.UpdateProjectBillingInfoRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CloudBilling service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCloudBillingStub extends CloudBillingStub {
  private static final MethodDescriptor<GetBillingAccountRequest, BillingAccount>
      getBillingAccountMethodDescriptor =
          MethodDescriptor.<GetBillingAccountRequest, BillingAccount>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/GetBillingAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBillingAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BillingAccount.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBillingAccountsRequest, ListBillingAccountsResponse>
      listBillingAccountsMethodDescriptor =
          MethodDescriptor.<ListBillingAccountsRequest, ListBillingAccountsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/ListBillingAccounts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBillingAccountsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBillingAccountsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBillingAccountRequest, BillingAccount>
      updateBillingAccountMethodDescriptor =
          MethodDescriptor.<UpdateBillingAccountRequest, BillingAccount>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/UpdateBillingAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBillingAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BillingAccount.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateBillingAccountRequest, BillingAccount>
      createBillingAccountMethodDescriptor =
          MethodDescriptor.<CreateBillingAccountRequest, BillingAccount>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/CreateBillingAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBillingAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BillingAccount.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>
      listProjectBillingInfoMethodDescriptor =
          MethodDescriptor
              .<ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/ListProjectBillingInfo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProjectBillingInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProjectBillingInfoResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetProjectBillingInfoRequest, ProjectBillingInfo>
      getProjectBillingInfoMethodDescriptor =
          MethodDescriptor.<GetProjectBillingInfoRequest, ProjectBillingInfo>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/GetProjectBillingInfo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetProjectBillingInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProjectBillingInfo.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
      updateProjectBillingInfoMethodDescriptor =
          MethodDescriptor.<UpdateProjectBillingInfoRequest, ProjectBillingInfo>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/UpdateProjectBillingInfo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateProjectBillingInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProjectBillingInfo.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.billing.v1.CloudBilling/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.billing.v1.CloudBilling/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<MoveBillingAccountRequest, BillingAccount>
      moveBillingAccountMethodDescriptor =
          MethodDescriptor.<MoveBillingAccountRequest, BillingAccount>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/MoveBillingAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(MoveBillingAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BillingAccount.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetBillingAccountRequest, BillingAccount> getBillingAccountCallable;
  private final UnaryCallable<ListBillingAccountsRequest, ListBillingAccountsResponse>
      listBillingAccountsCallable;
  private final UnaryCallable<ListBillingAccountsRequest, ListBillingAccountsPagedResponse>
      listBillingAccountsPagedCallable;
  private final UnaryCallable<UpdateBillingAccountRequest, BillingAccount>
      updateBillingAccountCallable;
  private final UnaryCallable<CreateBillingAccountRequest, BillingAccount>
      createBillingAccountCallable;
  private final UnaryCallable<ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>
      listProjectBillingInfoCallable;
  private final UnaryCallable<ListProjectBillingInfoRequest, ListProjectBillingInfoPagedResponse>
      listProjectBillingInfoPagedCallable;
  private final UnaryCallable<GetProjectBillingInfoRequest, ProjectBillingInfo>
      getProjectBillingInfoCallable;
  private final UnaryCallable<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
      updateProjectBillingInfoCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<MoveBillingAccountRequest, BillingAccount> moveBillingAccountCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudBillingStub create(CloudBillingStubSettings settings)
      throws IOException {
    return new GrpcCloudBillingStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudBillingStub create(ClientContext clientContext) throws IOException {
    return new GrpcCloudBillingStub(CloudBillingStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudBillingStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudBillingStub(
        CloudBillingStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudBillingStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCloudBillingStub(CloudBillingStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCloudBillingCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudBillingStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCloudBillingStub(
      CloudBillingStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetBillingAccountRequest, BillingAccount> getBillingAccountTransportSettings =
        GrpcCallSettings.<GetBillingAccountRequest, BillingAccount>newBuilder()
            .setMethodDescriptor(getBillingAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListBillingAccountsRequest, ListBillingAccountsResponse>
        listBillingAccountsTransportSettings =
            GrpcCallSettings.<ListBillingAccountsRequest, ListBillingAccountsResponse>newBuilder()
                .setMethodDescriptor(listBillingAccountsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateBillingAccountRequest, BillingAccount>
        updateBillingAccountTransportSettings =
            GrpcCallSettings.<UpdateBillingAccountRequest, BillingAccount>newBuilder()
                .setMethodDescriptor(updateBillingAccountMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateBillingAccountRequest, BillingAccount>
        createBillingAccountTransportSettings =
            GrpcCallSettings.<CreateBillingAccountRequest, BillingAccount>newBuilder()
                .setMethodDescriptor(createBillingAccountMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>
        listProjectBillingInfoTransportSettings =
            GrpcCallSettings
                .<ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>newBuilder()
                .setMethodDescriptor(listProjectBillingInfoMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetProjectBillingInfoRequest, ProjectBillingInfo>
        getProjectBillingInfoTransportSettings =
            GrpcCallSettings.<GetProjectBillingInfoRequest, ProjectBillingInfo>newBuilder()
                .setMethodDescriptor(getProjectBillingInfoMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
        updateProjectBillingInfoTransportSettings =
            GrpcCallSettings.<UpdateProjectBillingInfoRequest, ProjectBillingInfo>newBuilder()
                .setMethodDescriptor(updateProjectBillingInfoMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
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
    GrpcCallSettings<MoveBillingAccountRequest, BillingAccount>
        moveBillingAccountTransportSettings =
            GrpcCallSettings.<MoveBillingAccountRequest, BillingAccount>newBuilder()
                .setMethodDescriptor(moveBillingAccountMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "destination_parent", String.valueOf(request.getDestinationParent()));
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.getBillingAccountCallable =
        callableFactory.createUnaryCallable(
            getBillingAccountTransportSettings,
            settings.getBillingAccountSettings(),
            clientContext);
    this.listBillingAccountsCallable =
        callableFactory.createUnaryCallable(
            listBillingAccountsTransportSettings,
            settings.listBillingAccountsSettings(),
            clientContext);
    this.listBillingAccountsPagedCallable =
        callableFactory.createPagedCallable(
            listBillingAccountsTransportSettings,
            settings.listBillingAccountsSettings(),
            clientContext);
    this.updateBillingAccountCallable =
        callableFactory.createUnaryCallable(
            updateBillingAccountTransportSettings,
            settings.updateBillingAccountSettings(),
            clientContext);
    this.createBillingAccountCallable =
        callableFactory.createUnaryCallable(
            createBillingAccountTransportSettings,
            settings.createBillingAccountSettings(),
            clientContext);
    this.listProjectBillingInfoCallable =
        callableFactory.createUnaryCallable(
            listProjectBillingInfoTransportSettings,
            settings.listProjectBillingInfoSettings(),
            clientContext);
    this.listProjectBillingInfoPagedCallable =
        callableFactory.createPagedCallable(
            listProjectBillingInfoTransportSettings,
            settings.listProjectBillingInfoSettings(),
            clientContext);
    this.getProjectBillingInfoCallable =
        callableFactory.createUnaryCallable(
            getProjectBillingInfoTransportSettings,
            settings.getProjectBillingInfoSettings(),
            clientContext);
    this.updateProjectBillingInfoCallable =
        callableFactory.createUnaryCallable(
            updateProjectBillingInfoTransportSettings,
            settings.updateProjectBillingInfoSettings(),
            clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.moveBillingAccountCallable =
        callableFactory.createUnaryCallable(
            moveBillingAccountTransportSettings,
            settings.moveBillingAccountSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetBillingAccountRequest, BillingAccount> getBillingAccountCallable() {
    return getBillingAccountCallable;
  }

  @Override
  public UnaryCallable<ListBillingAccountsRequest, ListBillingAccountsResponse>
      listBillingAccountsCallable() {
    return listBillingAccountsCallable;
  }

  @Override
  public UnaryCallable<ListBillingAccountsRequest, ListBillingAccountsPagedResponse>
      listBillingAccountsPagedCallable() {
    return listBillingAccountsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateBillingAccountRequest, BillingAccount> updateBillingAccountCallable() {
    return updateBillingAccountCallable;
  }

  @Override
  public UnaryCallable<CreateBillingAccountRequest, BillingAccount> createBillingAccountCallable() {
    return createBillingAccountCallable;
  }

  @Override
  public UnaryCallable<ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>
      listProjectBillingInfoCallable() {
    return listProjectBillingInfoCallable;
  }

  @Override
  public UnaryCallable<ListProjectBillingInfoRequest, ListProjectBillingInfoPagedResponse>
      listProjectBillingInfoPagedCallable() {
    return listProjectBillingInfoPagedCallable;
  }

  @Override
  public UnaryCallable<GetProjectBillingInfoRequest, ProjectBillingInfo>
      getProjectBillingInfoCallable() {
    return getProjectBillingInfoCallable;
  }

  @Override
  public UnaryCallable<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
      updateProjectBillingInfoCallable() {
    return updateProjectBillingInfoCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<MoveBillingAccountRequest, BillingAccount> moveBillingAccountCallable() {
    return moveBillingAccountCallable;
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
