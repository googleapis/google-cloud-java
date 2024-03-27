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

package com.google.shopping.css.v1.stub;

import static com.google.shopping.css.v1.AccountsServiceClient.ListChildAccountsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.css.v1.Account;
import com.google.shopping.css.v1.GetAccountRequest;
import com.google.shopping.css.v1.ListChildAccountsRequest;
import com.google.shopping.css.v1.ListChildAccountsResponse;
import com.google.shopping.css.v1.UpdateAccountLabelsRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AccountsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAccountsServiceStub extends AccountsServiceStub {
  private static final MethodDescriptor<ListChildAccountsRequest, ListChildAccountsResponse>
      listChildAccountsMethodDescriptor =
          MethodDescriptor.<ListChildAccountsRequest, ListChildAccountsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.shopping.css.v1.AccountsService/ListChildAccounts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListChildAccountsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListChildAccountsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAccountRequest, Account> getAccountMethodDescriptor =
      MethodDescriptor.<GetAccountRequest, Account>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.shopping.css.v1.AccountsService/GetAccount")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAccountRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Account.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateAccountLabelsRequest, Account>
      updateLabelsMethodDescriptor =
          MethodDescriptor.<UpdateAccountLabelsRequest, Account>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.shopping.css.v1.AccountsService/UpdateLabels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAccountLabelsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Account.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListChildAccountsRequest, ListChildAccountsResponse>
      listChildAccountsCallable;
  private final UnaryCallable<ListChildAccountsRequest, ListChildAccountsPagedResponse>
      listChildAccountsPagedCallable;
  private final UnaryCallable<GetAccountRequest, Account> getAccountCallable;
  private final UnaryCallable<UpdateAccountLabelsRequest, Account> updateLabelsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAccountsServiceStub create(AccountsServiceStubSettings settings)
      throws IOException {
    return new GrpcAccountsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAccountsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAccountsServiceStub(
        AccountsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAccountsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAccountsServiceStub(
        AccountsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAccountsServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAccountsServiceStub(
      AccountsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAccountsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAccountsServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAccountsServiceStub(
      AccountsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListChildAccountsRequest, ListChildAccountsResponse>
        listChildAccountsTransportSettings =
            GrpcCallSettings.<ListChildAccountsRequest, ListChildAccountsResponse>newBuilder()
                .setMethodDescriptor(listChildAccountsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetAccountRequest, Account> getAccountTransportSettings =
        GrpcCallSettings.<GetAccountRequest, Account>newBuilder()
            .setMethodDescriptor(getAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAccountLabelsRequest, Account> updateLabelsTransportSettings =
        GrpcCallSettings.<UpdateAccountLabelsRequest, Account>newBuilder()
            .setMethodDescriptor(updateLabelsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listChildAccountsCallable =
        callableFactory.createUnaryCallable(
            listChildAccountsTransportSettings,
            settings.listChildAccountsSettings(),
            clientContext);
    this.listChildAccountsPagedCallable =
        callableFactory.createPagedCallable(
            listChildAccountsTransportSettings,
            settings.listChildAccountsSettings(),
            clientContext);
    this.getAccountCallable =
        callableFactory.createUnaryCallable(
            getAccountTransportSettings, settings.getAccountSettings(), clientContext);
    this.updateLabelsCallable =
        callableFactory.createUnaryCallable(
            updateLabelsTransportSettings, settings.updateLabelsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListChildAccountsRequest, ListChildAccountsResponse>
      listChildAccountsCallable() {
    return listChildAccountsCallable;
  }

  @Override
  public UnaryCallable<ListChildAccountsRequest, ListChildAccountsPagedResponse>
      listChildAccountsPagedCallable() {
    return listChildAccountsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAccountRequest, Account> getAccountCallable() {
    return getAccountCallable;
  }

  @Override
  public UnaryCallable<UpdateAccountLabelsRequest, Account> updateLabelsCallable() {
    return updateLabelsCallable;
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
