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

package com.google.shopping.merchant.accounts.v1beta.stub;

import static com.google.shopping.merchant.accounts.v1beta.AccountTaxServiceClient.ListAccountTaxPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.accounts.v1beta.AccountTax;
import com.google.shopping.merchant.accounts.v1beta.GetAccountTaxRequest;
import com.google.shopping.merchant.accounts.v1beta.ListAccountTaxRequest;
import com.google.shopping.merchant.accounts.v1beta.ListAccountTaxResponse;
import com.google.shopping.merchant.accounts.v1beta.UpdateAccountTaxRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AccountTaxService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAccountTaxServiceStub extends AccountTaxServiceStub {
  private static final MethodDescriptor<GetAccountTaxRequest, AccountTax>
      getAccountTaxMethodDescriptor =
          MethodDescriptor.<GetAccountTaxRequest, AccountTax>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountTaxService/GetAccountTax")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAccountTaxRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccountTax.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAccountTaxRequest, ListAccountTaxResponse>
      listAccountTaxMethodDescriptor =
          MethodDescriptor.<ListAccountTaxRequest, ListAccountTaxResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountTaxService/ListAccountTax")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccountTaxRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccountTaxResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAccountTaxRequest, AccountTax>
      updateAccountTaxMethodDescriptor =
          MethodDescriptor.<UpdateAccountTaxRequest, AccountTax>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountTaxService/UpdateAccountTax")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAccountTaxRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccountTax.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetAccountTaxRequest, AccountTax> getAccountTaxCallable;
  private final UnaryCallable<ListAccountTaxRequest, ListAccountTaxResponse> listAccountTaxCallable;
  private final UnaryCallable<ListAccountTaxRequest, ListAccountTaxPagedResponse>
      listAccountTaxPagedCallable;
  private final UnaryCallable<UpdateAccountTaxRequest, AccountTax> updateAccountTaxCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAccountTaxServiceStub create(AccountTaxServiceStubSettings settings)
      throws IOException {
    return new GrpcAccountTaxServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAccountTaxServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAccountTaxServiceStub(
        AccountTaxServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAccountTaxServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAccountTaxServiceStub(
        AccountTaxServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAccountTaxServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAccountTaxServiceStub(
      AccountTaxServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAccountTaxServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAccountTaxServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAccountTaxServiceStub(
      AccountTaxServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetAccountTaxRequest, AccountTax> getAccountTaxTransportSettings =
        GrpcCallSettings.<GetAccountTaxRequest, AccountTax>newBuilder()
            .setMethodDescriptor(getAccountTaxMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAccountTaxRequest, ListAccountTaxResponse>
        listAccountTaxTransportSettings =
            GrpcCallSettings.<ListAccountTaxRequest, ListAccountTaxResponse>newBuilder()
                .setMethodDescriptor(listAccountTaxMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateAccountTaxRequest, AccountTax> updateAccountTaxTransportSettings =
        GrpcCallSettings.<UpdateAccountTaxRequest, AccountTax>newBuilder()
            .setMethodDescriptor(updateAccountTaxMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "account_tax.name", String.valueOf(request.getAccountTax().getName()));
                  return builder.build();
                })
            .build();

    this.getAccountTaxCallable =
        callableFactory.createUnaryCallable(
            getAccountTaxTransportSettings, settings.getAccountTaxSettings(), clientContext);
    this.listAccountTaxCallable =
        callableFactory.createUnaryCallable(
            listAccountTaxTransportSettings, settings.listAccountTaxSettings(), clientContext);
    this.listAccountTaxPagedCallable =
        callableFactory.createPagedCallable(
            listAccountTaxTransportSettings, settings.listAccountTaxSettings(), clientContext);
    this.updateAccountTaxCallable =
        callableFactory.createUnaryCallable(
            updateAccountTaxTransportSettings, settings.updateAccountTaxSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetAccountTaxRequest, AccountTax> getAccountTaxCallable() {
    return getAccountTaxCallable;
  }

  @Override
  public UnaryCallable<ListAccountTaxRequest, ListAccountTaxResponse> listAccountTaxCallable() {
    return listAccountTaxCallable;
  }

  @Override
  public UnaryCallable<ListAccountTaxRequest, ListAccountTaxPagedResponse>
      listAccountTaxPagedCallable() {
    return listAccountTaxPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateAccountTaxRequest, AccountTax> updateAccountTaxCallable() {
    return updateAccountTaxCallable;
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
