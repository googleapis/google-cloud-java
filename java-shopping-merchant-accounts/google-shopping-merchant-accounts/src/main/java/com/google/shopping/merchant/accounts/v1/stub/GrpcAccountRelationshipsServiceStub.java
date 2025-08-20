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

import static com.google.shopping.merchant.accounts.v1.AccountRelationshipsServiceClient.ListAccountRelationshipsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.accounts.v1.AccountRelationship;
import com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest;
import com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest;
import com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse;
import com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AccountRelationshipsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAccountRelationshipsServiceStub extends AccountRelationshipsServiceStub {
  private static final MethodDescriptor<GetAccountRelationshipRequest, AccountRelationship>
      getAccountRelationshipMethodDescriptor =
          MethodDescriptor.<GetAccountRelationshipRequest, AccountRelationship>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountRelationshipsService/GetAccountRelationship")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAccountRelationshipRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AccountRelationship.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateAccountRelationshipRequest, AccountRelationship>
      updateAccountRelationshipMethodDescriptor =
          MethodDescriptor.<UpdateAccountRelationshipRequest, AccountRelationship>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountRelationshipsService/UpdateAccountRelationship")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAccountRelationshipRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AccountRelationship.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAccountRelationshipsRequest, ListAccountRelationshipsResponse>
      listAccountRelationshipsMethodDescriptor =
          MethodDescriptor
              .<ListAccountRelationshipsRequest, ListAccountRelationshipsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountRelationshipsService/ListAccountRelationships")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccountRelationshipsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccountRelationshipsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetAccountRelationshipRequest, AccountRelationship>
      getAccountRelationshipCallable;
  private final UnaryCallable<UpdateAccountRelationshipRequest, AccountRelationship>
      updateAccountRelationshipCallable;
  private final UnaryCallable<ListAccountRelationshipsRequest, ListAccountRelationshipsResponse>
      listAccountRelationshipsCallable;
  private final UnaryCallable<
          ListAccountRelationshipsRequest, ListAccountRelationshipsPagedResponse>
      listAccountRelationshipsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAccountRelationshipsServiceStub create(
      AccountRelationshipsServiceStubSettings settings) throws IOException {
    return new GrpcAccountRelationshipsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAccountRelationshipsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAccountRelationshipsServiceStub(
        AccountRelationshipsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAccountRelationshipsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAccountRelationshipsServiceStub(
        AccountRelationshipsServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcAccountRelationshipsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAccountRelationshipsServiceStub(
      AccountRelationshipsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAccountRelationshipsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAccountRelationshipsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAccountRelationshipsServiceStub(
      AccountRelationshipsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetAccountRelationshipRequest, AccountRelationship>
        getAccountRelationshipTransportSettings =
            GrpcCallSettings.<GetAccountRelationshipRequest, AccountRelationship>newBuilder()
                .setMethodDescriptor(getAccountRelationshipMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateAccountRelationshipRequest, AccountRelationship>
        updateAccountRelationshipTransportSettings =
            GrpcCallSettings.<UpdateAccountRelationshipRequest, AccountRelationship>newBuilder()
                .setMethodDescriptor(updateAccountRelationshipMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "account_relationship.name",
                          String.valueOf(request.getAccountRelationship().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListAccountRelationshipsRequest, ListAccountRelationshipsResponse>
        listAccountRelationshipsTransportSettings =
            GrpcCallSettings
                .<ListAccountRelationshipsRequest, ListAccountRelationshipsResponse>newBuilder()
                .setMethodDescriptor(listAccountRelationshipsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getAccountRelationshipCallable =
        callableFactory.createUnaryCallable(
            getAccountRelationshipTransportSettings,
            settings.getAccountRelationshipSettings(),
            clientContext);
    this.updateAccountRelationshipCallable =
        callableFactory.createUnaryCallable(
            updateAccountRelationshipTransportSettings,
            settings.updateAccountRelationshipSettings(),
            clientContext);
    this.listAccountRelationshipsCallable =
        callableFactory.createUnaryCallable(
            listAccountRelationshipsTransportSettings,
            settings.listAccountRelationshipsSettings(),
            clientContext);
    this.listAccountRelationshipsPagedCallable =
        callableFactory.createPagedCallable(
            listAccountRelationshipsTransportSettings,
            settings.listAccountRelationshipsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetAccountRelationshipRequest, AccountRelationship>
      getAccountRelationshipCallable() {
    return getAccountRelationshipCallable;
  }

  @Override
  public UnaryCallable<UpdateAccountRelationshipRequest, AccountRelationship>
      updateAccountRelationshipCallable() {
    return updateAccountRelationshipCallable;
  }

  @Override
  public UnaryCallable<ListAccountRelationshipsRequest, ListAccountRelationshipsResponse>
      listAccountRelationshipsCallable() {
    return listAccountRelationshipsCallable;
  }

  @Override
  public UnaryCallable<ListAccountRelationshipsRequest, ListAccountRelationshipsPagedResponse>
      listAccountRelationshipsPagedCallable() {
    return listAccountRelationshipsPagedCallable;
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
