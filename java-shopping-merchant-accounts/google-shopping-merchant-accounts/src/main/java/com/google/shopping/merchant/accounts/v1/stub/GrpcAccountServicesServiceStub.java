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

package com.google.shopping.merchant.accounts.v1.stub;

import static com.google.shopping.merchant.accounts.v1.AccountServicesServiceClient.ListAccountServicesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.AccountService;
import com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest;
import com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest;
import com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest;
import com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse;
import com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest;
import com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AccountServicesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAccountServicesServiceStub extends AccountServicesServiceStub {
  private static final MethodDescriptor<GetAccountServiceRequest, AccountService>
      getAccountServiceMethodDescriptor =
          MethodDescriptor.<GetAccountServiceRequest, AccountService>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountServicesService/GetAccountService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAccountServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccountService.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAccountServicesRequest, ListAccountServicesResponse>
      listAccountServicesMethodDescriptor =
          MethodDescriptor.<ListAccountServicesRequest, ListAccountServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountServicesService/ListAccountServices")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccountServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccountServicesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ProposeAccountServiceRequest, AccountService>
      proposeAccountServiceMethodDescriptor =
          MethodDescriptor.<ProposeAccountServiceRequest, AccountService>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountServicesService/ProposeAccountService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ProposeAccountServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccountService.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ApproveAccountServiceRequest, AccountService>
      approveAccountServiceMethodDescriptor =
          MethodDescriptor.<ApproveAccountServiceRequest, AccountService>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountServicesService/ApproveAccountService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ApproveAccountServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccountService.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RejectAccountServiceRequest, Empty>
      rejectAccountServiceMethodDescriptor =
          MethodDescriptor.<RejectAccountServiceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountServicesService/RejectAccountService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RejectAccountServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetAccountServiceRequest, AccountService> getAccountServiceCallable;
  private final UnaryCallable<ListAccountServicesRequest, ListAccountServicesResponse>
      listAccountServicesCallable;
  private final UnaryCallable<ListAccountServicesRequest, ListAccountServicesPagedResponse>
      listAccountServicesPagedCallable;
  private final UnaryCallable<ProposeAccountServiceRequest, AccountService>
      proposeAccountServiceCallable;
  private final UnaryCallable<ApproveAccountServiceRequest, AccountService>
      approveAccountServiceCallable;
  private final UnaryCallable<RejectAccountServiceRequest, Empty> rejectAccountServiceCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAccountServicesServiceStub create(
      AccountServicesServiceStubSettings settings) throws IOException {
    return new GrpcAccountServicesServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAccountServicesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAccountServicesServiceStub(
        AccountServicesServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAccountServicesServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAccountServicesServiceStub(
        AccountServicesServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAccountServicesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAccountServicesServiceStub(
      AccountServicesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAccountServicesServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAccountServicesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAccountServicesServiceStub(
      AccountServicesServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetAccountServiceRequest, AccountService> getAccountServiceTransportSettings =
        GrpcCallSettings.<GetAccountServiceRequest, AccountService>newBuilder()
            .setMethodDescriptor(getAccountServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAccountServicesRequest, ListAccountServicesResponse>
        listAccountServicesTransportSettings =
            GrpcCallSettings.<ListAccountServicesRequest, ListAccountServicesResponse>newBuilder()
                .setMethodDescriptor(listAccountServicesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ProposeAccountServiceRequest, AccountService>
        proposeAccountServiceTransportSettings =
            GrpcCallSettings.<ProposeAccountServiceRequest, AccountService>newBuilder()
                .setMethodDescriptor(proposeAccountServiceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ApproveAccountServiceRequest, AccountService>
        approveAccountServiceTransportSettings =
            GrpcCallSettings.<ApproveAccountServiceRequest, AccountService>newBuilder()
                .setMethodDescriptor(approveAccountServiceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RejectAccountServiceRequest, Empty> rejectAccountServiceTransportSettings =
        GrpcCallSettings.<RejectAccountServiceRequest, Empty>newBuilder()
            .setMethodDescriptor(rejectAccountServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getAccountServiceCallable =
        callableFactory.createUnaryCallable(
            getAccountServiceTransportSettings,
            settings.getAccountServiceSettings(),
            clientContext);
    this.listAccountServicesCallable =
        callableFactory.createUnaryCallable(
            listAccountServicesTransportSettings,
            settings.listAccountServicesSettings(),
            clientContext);
    this.listAccountServicesPagedCallable =
        callableFactory.createPagedCallable(
            listAccountServicesTransportSettings,
            settings.listAccountServicesSettings(),
            clientContext);
    this.proposeAccountServiceCallable =
        callableFactory.createUnaryCallable(
            proposeAccountServiceTransportSettings,
            settings.proposeAccountServiceSettings(),
            clientContext);
    this.approveAccountServiceCallable =
        callableFactory.createUnaryCallable(
            approveAccountServiceTransportSettings,
            settings.approveAccountServiceSettings(),
            clientContext);
    this.rejectAccountServiceCallable =
        callableFactory.createUnaryCallable(
            rejectAccountServiceTransportSettings,
            settings.rejectAccountServiceSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetAccountServiceRequest, AccountService> getAccountServiceCallable() {
    return getAccountServiceCallable;
  }

  @Override
  public UnaryCallable<ListAccountServicesRequest, ListAccountServicesResponse>
      listAccountServicesCallable() {
    return listAccountServicesCallable;
  }

  @Override
  public UnaryCallable<ListAccountServicesRequest, ListAccountServicesPagedResponse>
      listAccountServicesPagedCallable() {
    return listAccountServicesPagedCallable;
  }

  @Override
  public UnaryCallable<ProposeAccountServiceRequest, AccountService>
      proposeAccountServiceCallable() {
    return proposeAccountServiceCallable;
  }

  @Override
  public UnaryCallable<ApproveAccountServiceRequest, AccountService>
      approveAccountServiceCallable() {
    return approveAccountServiceCallable;
  }

  @Override
  public UnaryCallable<RejectAccountServiceRequest, Empty> rejectAccountServiceCallable() {
    return rejectAccountServiceCallable;
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
