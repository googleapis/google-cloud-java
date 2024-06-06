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

import static com.google.shopping.merchant.accounts.v1beta.AccountIssueServiceClient.ListAccountIssuesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesRequest;
import com.google.shopping.merchant.accounts.v1beta.ListAccountIssuesResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AccountIssueService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAccountIssueServiceStub extends AccountIssueServiceStub {
  private static final MethodDescriptor<ListAccountIssuesRequest, ListAccountIssuesResponse>
      listAccountIssuesMethodDescriptor =
          MethodDescriptor.<ListAccountIssuesRequest, ListAccountIssuesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AccountIssueService/ListAccountIssues")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccountIssuesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccountIssuesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListAccountIssuesRequest, ListAccountIssuesResponse>
      listAccountIssuesCallable;
  private final UnaryCallable<ListAccountIssuesRequest, ListAccountIssuesPagedResponse>
      listAccountIssuesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAccountIssueServiceStub create(AccountIssueServiceStubSettings settings)
      throws IOException {
    return new GrpcAccountIssueServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAccountIssueServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAccountIssueServiceStub(
        AccountIssueServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAccountIssueServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAccountIssueServiceStub(
        AccountIssueServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAccountIssueServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAccountIssueServiceStub(
      AccountIssueServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAccountIssueServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAccountIssueServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAccountIssueServiceStub(
      AccountIssueServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAccountIssuesRequest, ListAccountIssuesResponse>
        listAccountIssuesTransportSettings =
            GrpcCallSettings.<ListAccountIssuesRequest, ListAccountIssuesResponse>newBuilder()
                .setMethodDescriptor(listAccountIssuesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listAccountIssuesCallable =
        callableFactory.createUnaryCallable(
            listAccountIssuesTransportSettings,
            settings.listAccountIssuesSettings(),
            clientContext);
    this.listAccountIssuesPagedCallable =
        callableFactory.createPagedCallable(
            listAccountIssuesTransportSettings,
            settings.listAccountIssuesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListAccountIssuesRequest, ListAccountIssuesResponse>
      listAccountIssuesCallable() {
    return listAccountIssuesCallable;
  }

  @Override
  public UnaryCallable<ListAccountIssuesRequest, ListAccountIssuesPagedResponse>
      listAccountIssuesPagedCallable() {
    return listAccountIssuesPagedCallable;
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
