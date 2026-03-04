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

package com.google.ads.datamanager.v1.stub;

import static com.google.ads.datamanager.v1.UserListGlobalLicenseServiceClient.ListUserListGlobalLicenseCustomerInfosPagedResponse;
import static com.google.ads.datamanager.v1.UserListGlobalLicenseServiceClient.ListUserListGlobalLicensesPagedResponse;

import com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest;
import com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest;
import com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest;
import com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse;
import com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest;
import com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse;
import com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest;
import com.google.ads.datamanager.v1.UserListGlobalLicense;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the UserListGlobalLicenseService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcUserListGlobalLicenseServiceStub extends UserListGlobalLicenseServiceStub {
  private static final MethodDescriptor<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>
      createUserListGlobalLicenseMethodDescriptor =
          MethodDescriptor.<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListGlobalLicenseService/CreateUserListGlobalLicense")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateUserListGlobalLicenseRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UserListGlobalLicense.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>
      updateUserListGlobalLicenseMethodDescriptor =
          MethodDescriptor.<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListGlobalLicenseService/UpdateUserListGlobalLicense")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateUserListGlobalLicenseRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UserListGlobalLicense.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetUserListGlobalLicenseRequest, UserListGlobalLicense>
      getUserListGlobalLicenseMethodDescriptor =
          MethodDescriptor.<GetUserListGlobalLicenseRequest, UserListGlobalLicense>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListGlobalLicenseService/GetUserListGlobalLicense")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetUserListGlobalLicenseRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UserListGlobalLicense.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>
      listUserListGlobalLicensesMethodDescriptor =
          MethodDescriptor
              .<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListGlobalLicenseService/ListUserListGlobalLicenses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUserListGlobalLicensesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUserListGlobalLicensesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse>
      listUserListGlobalLicenseCustomerInfosMethodDescriptor =
          MethodDescriptor
              .<ListUserListGlobalLicenseCustomerInfosRequest,
                  ListUserListGlobalLicenseCustomerInfosResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListGlobalLicenseService/ListUserListGlobalLicenseCustomerInfos")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListUserListGlobalLicenseCustomerInfosRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListUserListGlobalLicenseCustomerInfosResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>
      createUserListGlobalLicenseCallable;
  private final UnaryCallable<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>
      updateUserListGlobalLicenseCallable;
  private final UnaryCallable<GetUserListGlobalLicenseRequest, UserListGlobalLicense>
      getUserListGlobalLicenseCallable;
  private final UnaryCallable<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>
      listUserListGlobalLicensesCallable;
  private final UnaryCallable<
          ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesPagedResponse>
      listUserListGlobalLicensesPagedCallable;
  private final UnaryCallable<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse>
      listUserListGlobalLicenseCustomerInfosCallable;
  private final UnaryCallable<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosPagedResponse>
      listUserListGlobalLicenseCustomerInfosPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcUserListGlobalLicenseServiceStub create(
      UserListGlobalLicenseServiceStubSettings settings) throws IOException {
    return new GrpcUserListGlobalLicenseServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcUserListGlobalLicenseServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcUserListGlobalLicenseServiceStub(
        UserListGlobalLicenseServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcUserListGlobalLicenseServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcUserListGlobalLicenseServiceStub(
        UserListGlobalLicenseServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcUserListGlobalLicenseServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcUserListGlobalLicenseServiceStub(
      UserListGlobalLicenseServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcUserListGlobalLicenseServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcUserListGlobalLicenseServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcUserListGlobalLicenseServiceStub(
      UserListGlobalLicenseServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>
        createUserListGlobalLicenseTransportSettings =
            GrpcCallSettings.<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>newBuilder()
                .setMethodDescriptor(createUserListGlobalLicenseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>
        updateUserListGlobalLicenseTransportSettings =
            GrpcCallSettings.<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>newBuilder()
                .setMethodDescriptor(updateUserListGlobalLicenseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "user_list_global_license.name",
                          String.valueOf(request.getUserListGlobalLicense().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetUserListGlobalLicenseRequest, UserListGlobalLicense>
        getUserListGlobalLicenseTransportSettings =
            GrpcCallSettings.<GetUserListGlobalLicenseRequest, UserListGlobalLicense>newBuilder()
                .setMethodDescriptor(getUserListGlobalLicenseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>
        listUserListGlobalLicensesTransportSettings =
            GrpcCallSettings
                .<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>newBuilder()
                .setMethodDescriptor(listUserListGlobalLicensesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListUserListGlobalLicenseCustomerInfosRequest,
            ListUserListGlobalLicenseCustomerInfosResponse>
        listUserListGlobalLicenseCustomerInfosTransportSettings =
            GrpcCallSettings
                .<ListUserListGlobalLicenseCustomerInfosRequest,
                    ListUserListGlobalLicenseCustomerInfosResponse>
                    newBuilder()
                .setMethodDescriptor(listUserListGlobalLicenseCustomerInfosMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createUserListGlobalLicenseCallable =
        callableFactory.createUnaryCallable(
            createUserListGlobalLicenseTransportSettings,
            settings.createUserListGlobalLicenseSettings(),
            clientContext);
    this.updateUserListGlobalLicenseCallable =
        callableFactory.createUnaryCallable(
            updateUserListGlobalLicenseTransportSettings,
            settings.updateUserListGlobalLicenseSettings(),
            clientContext);
    this.getUserListGlobalLicenseCallable =
        callableFactory.createUnaryCallable(
            getUserListGlobalLicenseTransportSettings,
            settings.getUserListGlobalLicenseSettings(),
            clientContext);
    this.listUserListGlobalLicensesCallable =
        callableFactory.createUnaryCallable(
            listUserListGlobalLicensesTransportSettings,
            settings.listUserListGlobalLicensesSettings(),
            clientContext);
    this.listUserListGlobalLicensesPagedCallable =
        callableFactory.createPagedCallable(
            listUserListGlobalLicensesTransportSettings,
            settings.listUserListGlobalLicensesSettings(),
            clientContext);
    this.listUserListGlobalLicenseCustomerInfosCallable =
        callableFactory.createUnaryCallable(
            listUserListGlobalLicenseCustomerInfosTransportSettings,
            settings.listUserListGlobalLicenseCustomerInfosSettings(),
            clientContext);
    this.listUserListGlobalLicenseCustomerInfosPagedCallable =
        callableFactory.createPagedCallable(
            listUserListGlobalLicenseCustomerInfosTransportSettings,
            settings.listUserListGlobalLicenseCustomerInfosSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>
      createUserListGlobalLicenseCallable() {
    return createUserListGlobalLicenseCallable;
  }

  @Override
  public UnaryCallable<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>
      updateUserListGlobalLicenseCallable() {
    return updateUserListGlobalLicenseCallable;
  }

  @Override
  public UnaryCallable<GetUserListGlobalLicenseRequest, UserListGlobalLicense>
      getUserListGlobalLicenseCallable() {
    return getUserListGlobalLicenseCallable;
  }

  @Override
  public UnaryCallable<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>
      listUserListGlobalLicensesCallable() {
    return listUserListGlobalLicensesCallable;
  }

  @Override
  public UnaryCallable<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesPagedResponse>
      listUserListGlobalLicensesPagedCallable() {
    return listUserListGlobalLicensesPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse>
      listUserListGlobalLicenseCustomerInfosCallable() {
    return listUserListGlobalLicenseCustomerInfosCallable;
  }

  @Override
  public UnaryCallable<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosPagedResponse>
      listUserListGlobalLicenseCustomerInfosPagedCallable() {
    return listUserListGlobalLicenseCustomerInfosPagedCallable;
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
