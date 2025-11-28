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

package com.google.shopping.merchant.quota.v1.stub;

import static com.google.shopping.merchant.quota.v1.AccountLimitsServiceClient.ListAccountLimitsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.quota.v1.AccountLimit;
import com.google.shopping.merchant.quota.v1.GetAccountLimitRequest;
import com.google.shopping.merchant.quota.v1.ListAccountLimitsRequest;
import com.google.shopping.merchant.quota.v1.ListAccountLimitsResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AccountLimitsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAccountLimitsServiceStub extends AccountLimitsServiceStub {
  private static final MethodDescriptor<GetAccountLimitRequest, AccountLimit>
      getAccountLimitMethodDescriptor =
          MethodDescriptor.<GetAccountLimitRequest, AccountLimit>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.quota.v1.AccountLimitsService/GetAccountLimit")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAccountLimitRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccountLimit.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListAccountLimitsRequest, ListAccountLimitsResponse>
      listAccountLimitsMethodDescriptor =
          MethodDescriptor.<ListAccountLimitsRequest, ListAccountLimitsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.quota.v1.AccountLimitsService/ListAccountLimits")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccountLimitsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccountLimitsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetAccountLimitRequest, AccountLimit> getAccountLimitCallable;
  private final UnaryCallable<ListAccountLimitsRequest, ListAccountLimitsResponse>
      listAccountLimitsCallable;
  private final UnaryCallable<ListAccountLimitsRequest, ListAccountLimitsPagedResponse>
      listAccountLimitsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAccountLimitsServiceStub create(AccountLimitsServiceStubSettings settings)
      throws IOException {
    return new GrpcAccountLimitsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAccountLimitsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAccountLimitsServiceStub(
        AccountLimitsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAccountLimitsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAccountLimitsServiceStub(
        AccountLimitsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAccountLimitsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAccountLimitsServiceStub(
      AccountLimitsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAccountLimitsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAccountLimitsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAccountLimitsServiceStub(
      AccountLimitsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetAccountLimitRequest, AccountLimit> getAccountLimitTransportSettings =
        GrpcCallSettings.<GetAccountLimitRequest, AccountLimit>newBuilder()
            .setMethodDescriptor(getAccountLimitMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAccountLimitsRequest, ListAccountLimitsResponse>
        listAccountLimitsTransportSettings =
            GrpcCallSettings.<ListAccountLimitsRequest, ListAccountLimitsResponse>newBuilder()
                .setMethodDescriptor(listAccountLimitsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getAccountLimitCallable =
        callableFactory.createUnaryCallable(
            getAccountLimitTransportSettings, settings.getAccountLimitSettings(), clientContext);
    this.listAccountLimitsCallable =
        callableFactory.createUnaryCallable(
            listAccountLimitsTransportSettings,
            settings.listAccountLimitsSettings(),
            clientContext);
    this.listAccountLimitsPagedCallable =
        callableFactory.createPagedCallable(
            listAccountLimitsTransportSettings,
            settings.listAccountLimitsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetAccountLimitRequest, AccountLimit> getAccountLimitCallable() {
    return getAccountLimitCallable;
  }

  @Override
  public UnaryCallable<ListAccountLimitsRequest, ListAccountLimitsResponse>
      listAccountLimitsCallable() {
    return listAccountLimitsCallable;
  }

  @Override
  public UnaryCallable<ListAccountLimitsRequest, ListAccountLimitsPagedResponse>
      listAccountLimitsPagedCallable() {
    return listAccountLimitsPagedCallable;
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
