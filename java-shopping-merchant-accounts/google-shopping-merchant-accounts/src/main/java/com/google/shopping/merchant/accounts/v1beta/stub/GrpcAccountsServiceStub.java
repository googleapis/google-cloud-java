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

import static com.google.shopping.merchant.accounts.v1beta.AccountsServiceClient.ListAccountsPagedResponse;
import static com.google.shopping.merchant.accounts.v1beta.AccountsServiceClient.ListSubAccountsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1beta.Account;
import com.google.shopping.merchant.accounts.v1beta.CreateAndConfigureAccountRequest;
import com.google.shopping.merchant.accounts.v1beta.DeleteAccountRequest;
import com.google.shopping.merchant.accounts.v1beta.GetAccountRequest;
import com.google.shopping.merchant.accounts.v1beta.ListAccountsRequest;
import com.google.shopping.merchant.accounts.v1beta.ListAccountsResponse;
import com.google.shopping.merchant.accounts.v1beta.ListSubAccountsRequest;
import com.google.shopping.merchant.accounts.v1beta.ListSubAccountsResponse;
import com.google.shopping.merchant.accounts.v1beta.UpdateAccountRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AccountsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAccountsServiceStub extends AccountsServiceStub {
  private static final MethodDescriptor<GetAccountRequest, Account> getAccountMethodDescriptor =
      MethodDescriptor.<GetAccountRequest, Account>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.shopping.merchant.accounts.v1beta.AccountsService/GetAccount")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAccountRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Account.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateAndConfigureAccountRequest, Account>
      createAndConfigureAccountMethodDescriptor =
          MethodDescriptor.<CreateAndConfigureAccountRequest, Account>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountsService/CreateAndConfigureAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAndConfigureAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Account.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAccountRequest, Empty> deleteAccountMethodDescriptor =
      MethodDescriptor.<DeleteAccountRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.shopping.merchant.accounts.v1beta.AccountsService/DeleteAccount")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteAccountRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateAccountRequest, Account>
      updateAccountMethodDescriptor =
          MethodDescriptor.<UpdateAccountRequest, Account>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountsService/UpdateAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Account.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAccountsRequest, ListAccountsResponse>
      listAccountsMethodDescriptor =
          MethodDescriptor.<ListAccountsRequest, ListAccountsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountsService/ListAccounts")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAccountsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccountsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSubAccountsRequest, ListSubAccountsResponse>
      listSubAccountsMethodDescriptor =
          MethodDescriptor.<ListSubAccountsRequest, ListSubAccountsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountsService/ListSubAccounts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSubAccountsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSubAccountsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetAccountRequest, Account> getAccountCallable;
  private final UnaryCallable<CreateAndConfigureAccountRequest, Account>
      createAndConfigureAccountCallable;
  private final UnaryCallable<DeleteAccountRequest, Empty> deleteAccountCallable;
  private final UnaryCallable<UpdateAccountRequest, Account> updateAccountCallable;
  private final UnaryCallable<ListAccountsRequest, ListAccountsResponse> listAccountsCallable;
  private final UnaryCallable<ListAccountsRequest, ListAccountsPagedResponse>
      listAccountsPagedCallable;
  private final UnaryCallable<ListSubAccountsRequest, ListSubAccountsResponse>
      listSubAccountsCallable;
  private final UnaryCallable<ListSubAccountsRequest, ListSubAccountsPagedResponse>
      listSubAccountsPagedCallable;

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
    GrpcCallSettings<CreateAndConfigureAccountRequest, Account>
        createAndConfigureAccountTransportSettings =
            GrpcCallSettings.<CreateAndConfigureAccountRequest, Account>newBuilder()
                .setMethodDescriptor(createAndConfigureAccountMethodDescriptor)
                .build();
    GrpcCallSettings<DeleteAccountRequest, Empty> deleteAccountTransportSettings =
        GrpcCallSettings.<DeleteAccountRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAccountRequest, Account> updateAccountTransportSettings =
        GrpcCallSettings.<UpdateAccountRequest, Account>newBuilder()
            .setMethodDescriptor(updateAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("account.name", String.valueOf(request.getAccount().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAccountsRequest, ListAccountsResponse> listAccountsTransportSettings =
        GrpcCallSettings.<ListAccountsRequest, ListAccountsResponse>newBuilder()
            .setMethodDescriptor(listAccountsMethodDescriptor)
            .build();
    GrpcCallSettings<ListSubAccountsRequest, ListSubAccountsResponse>
        listSubAccountsTransportSettings =
            GrpcCallSettings.<ListSubAccountsRequest, ListSubAccountsResponse>newBuilder()
                .setMethodDescriptor(listSubAccountsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("provider", String.valueOf(request.getProvider()));
                      return builder.build();
                    })
                .build();

    this.getAccountCallable =
        callableFactory.createUnaryCallable(
            getAccountTransportSettings, settings.getAccountSettings(), clientContext);
    this.createAndConfigureAccountCallable =
        callableFactory.createUnaryCallable(
            createAndConfigureAccountTransportSettings,
            settings.createAndConfigureAccountSettings(),
            clientContext);
    this.deleteAccountCallable =
        callableFactory.createUnaryCallable(
            deleteAccountTransportSettings, settings.deleteAccountSettings(), clientContext);
    this.updateAccountCallable =
        callableFactory.createUnaryCallable(
            updateAccountTransportSettings, settings.updateAccountSettings(), clientContext);
    this.listAccountsCallable =
        callableFactory.createUnaryCallable(
            listAccountsTransportSettings, settings.listAccountsSettings(), clientContext);
    this.listAccountsPagedCallable =
        callableFactory.createPagedCallable(
            listAccountsTransportSettings, settings.listAccountsSettings(), clientContext);
    this.listSubAccountsCallable =
        callableFactory.createUnaryCallable(
            listSubAccountsTransportSettings, settings.listSubAccountsSettings(), clientContext);
    this.listSubAccountsPagedCallable =
        callableFactory.createPagedCallable(
            listSubAccountsTransportSettings, settings.listSubAccountsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetAccountRequest, Account> getAccountCallable() {
    return getAccountCallable;
  }

  @Override
  public UnaryCallable<CreateAndConfigureAccountRequest, Account>
      createAndConfigureAccountCallable() {
    return createAndConfigureAccountCallable;
  }

  @Override
  public UnaryCallable<DeleteAccountRequest, Empty> deleteAccountCallable() {
    return deleteAccountCallable;
  }

  @Override
  public UnaryCallable<UpdateAccountRequest, Account> updateAccountCallable() {
    return updateAccountCallable;
  }

  @Override
  public UnaryCallable<ListAccountsRequest, ListAccountsResponse> listAccountsCallable() {
    return listAccountsCallable;
  }

  @Override
  public UnaryCallable<ListAccountsRequest, ListAccountsPagedResponse> listAccountsPagedCallable() {
    return listAccountsPagedCallable;
  }

  @Override
  public UnaryCallable<ListSubAccountsRequest, ListSubAccountsResponse> listSubAccountsCallable() {
    return listSubAccountsCallable;
  }

  @Override
  public UnaryCallable<ListSubAccountsRequest, ListSubAccountsPagedResponse>
      listSubAccountsPagedCallable() {
    return listSubAccountsPagedCallable;
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
