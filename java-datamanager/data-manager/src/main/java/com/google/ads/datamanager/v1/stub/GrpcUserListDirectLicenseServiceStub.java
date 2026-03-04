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

import static com.google.ads.datamanager.v1.UserListDirectLicenseServiceClient.ListUserListDirectLicensesPagedResponse;

import com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest;
import com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest;
import com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest;
import com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse;
import com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest;
import com.google.ads.datamanager.v1.UserListDirectLicense;
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
 * gRPC stub implementation for the UserListDirectLicenseService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcUserListDirectLicenseServiceStub extends UserListDirectLicenseServiceStub {
  private static final MethodDescriptor<CreateUserListDirectLicenseRequest, UserListDirectLicense>
      createUserListDirectLicenseMethodDescriptor =
          MethodDescriptor.<CreateUserListDirectLicenseRequest, UserListDirectLicense>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListDirectLicenseService/CreateUserListDirectLicense")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateUserListDirectLicenseRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UserListDirectLicense.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetUserListDirectLicenseRequest, UserListDirectLicense>
      getUserListDirectLicenseMethodDescriptor =
          MethodDescriptor.<GetUserListDirectLicenseRequest, UserListDirectLicense>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListDirectLicenseService/GetUserListDirectLicense")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetUserListDirectLicenseRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UserListDirectLicense.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateUserListDirectLicenseRequest, UserListDirectLicense>
      updateUserListDirectLicenseMethodDescriptor =
          MethodDescriptor.<UpdateUserListDirectLicenseRequest, UserListDirectLicense>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListDirectLicenseService/UpdateUserListDirectLicense")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateUserListDirectLicenseRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UserListDirectLicense.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>
      listUserListDirectLicensesMethodDescriptor =
          MethodDescriptor
              .<ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListDirectLicenseService/ListUserListDirectLicenses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUserListDirectLicensesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUserListDirectLicensesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateUserListDirectLicenseRequest, UserListDirectLicense>
      createUserListDirectLicenseCallable;
  private final UnaryCallable<GetUserListDirectLicenseRequest, UserListDirectLicense>
      getUserListDirectLicenseCallable;
  private final UnaryCallable<UpdateUserListDirectLicenseRequest, UserListDirectLicense>
      updateUserListDirectLicenseCallable;
  private final UnaryCallable<ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>
      listUserListDirectLicensesCallable;
  private final UnaryCallable<
          ListUserListDirectLicensesRequest, ListUserListDirectLicensesPagedResponse>
      listUserListDirectLicensesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcUserListDirectLicenseServiceStub create(
      UserListDirectLicenseServiceStubSettings settings) throws IOException {
    return new GrpcUserListDirectLicenseServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcUserListDirectLicenseServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcUserListDirectLicenseServiceStub(
        UserListDirectLicenseServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcUserListDirectLicenseServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcUserListDirectLicenseServiceStub(
        UserListDirectLicenseServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcUserListDirectLicenseServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcUserListDirectLicenseServiceStub(
      UserListDirectLicenseServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcUserListDirectLicenseServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcUserListDirectLicenseServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcUserListDirectLicenseServiceStub(
      UserListDirectLicenseServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateUserListDirectLicenseRequest, UserListDirectLicense>
        createUserListDirectLicenseTransportSettings =
            GrpcCallSettings.<CreateUserListDirectLicenseRequest, UserListDirectLicense>newBuilder()
                .setMethodDescriptor(createUserListDirectLicenseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetUserListDirectLicenseRequest, UserListDirectLicense>
        getUserListDirectLicenseTransportSettings =
            GrpcCallSettings.<GetUserListDirectLicenseRequest, UserListDirectLicense>newBuilder()
                .setMethodDescriptor(getUserListDirectLicenseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateUserListDirectLicenseRequest, UserListDirectLicense>
        updateUserListDirectLicenseTransportSettings =
            GrpcCallSettings.<UpdateUserListDirectLicenseRequest, UserListDirectLicense>newBuilder()
                .setMethodDescriptor(updateUserListDirectLicenseMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "user_list_direct_license.name",
                          String.valueOf(request.getUserListDirectLicense().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>
        listUserListDirectLicensesTransportSettings =
            GrpcCallSettings
                .<ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>newBuilder()
                .setMethodDescriptor(listUserListDirectLicensesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createUserListDirectLicenseCallable =
        callableFactory.createUnaryCallable(
            createUserListDirectLicenseTransportSettings,
            settings.createUserListDirectLicenseSettings(),
            clientContext);
    this.getUserListDirectLicenseCallable =
        callableFactory.createUnaryCallable(
            getUserListDirectLicenseTransportSettings,
            settings.getUserListDirectLicenseSettings(),
            clientContext);
    this.updateUserListDirectLicenseCallable =
        callableFactory.createUnaryCallable(
            updateUserListDirectLicenseTransportSettings,
            settings.updateUserListDirectLicenseSettings(),
            clientContext);
    this.listUserListDirectLicensesCallable =
        callableFactory.createUnaryCallable(
            listUserListDirectLicensesTransportSettings,
            settings.listUserListDirectLicensesSettings(),
            clientContext);
    this.listUserListDirectLicensesPagedCallable =
        callableFactory.createPagedCallable(
            listUserListDirectLicensesTransportSettings,
            settings.listUserListDirectLicensesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateUserListDirectLicenseRequest, UserListDirectLicense>
      createUserListDirectLicenseCallable() {
    return createUserListDirectLicenseCallable;
  }

  @Override
  public UnaryCallable<GetUserListDirectLicenseRequest, UserListDirectLicense>
      getUserListDirectLicenseCallable() {
    return getUserListDirectLicenseCallable;
  }

  @Override
  public UnaryCallable<UpdateUserListDirectLicenseRequest, UserListDirectLicense>
      updateUserListDirectLicenseCallable() {
    return updateUserListDirectLicenseCallable;
  }

  @Override
  public UnaryCallable<ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>
      listUserListDirectLicensesCallable() {
    return listUserListDirectLicensesCallable;
  }

  @Override
  public UnaryCallable<ListUserListDirectLicensesRequest, ListUserListDirectLicensesPagedResponse>
      listUserListDirectLicensesPagedCallable() {
    return listUserListDirectLicensesPagedCallable;
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
