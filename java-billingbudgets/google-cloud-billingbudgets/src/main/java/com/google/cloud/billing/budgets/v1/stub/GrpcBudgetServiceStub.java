/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.billing.budgets.v1.stub;

import static com.google.cloud.billing.budgets.v1.BudgetServiceClient.ListBudgetsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.billing.budgets.v1.Budget;
import com.google.cloud.billing.budgets.v1.CreateBudgetRequest;
import com.google.cloud.billing.budgets.v1.DeleteBudgetRequest;
import com.google.cloud.billing.budgets.v1.GetBudgetRequest;
import com.google.cloud.billing.budgets.v1.ListBudgetsRequest;
import com.google.cloud.billing.budgets.v1.ListBudgetsResponse;
import com.google.cloud.billing.budgets.v1.UpdateBudgetRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the BudgetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcBudgetServiceStub extends BudgetServiceStub {
  private static final MethodDescriptor<CreateBudgetRequest, Budget> createBudgetMethodDescriptor =
      MethodDescriptor.<CreateBudgetRequest, Budget>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.billing.budgets.v1.BudgetService/CreateBudget")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateBudgetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Budget.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateBudgetRequest, Budget> updateBudgetMethodDescriptor =
      MethodDescriptor.<UpdateBudgetRequest, Budget>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.billing.budgets.v1.BudgetService/UpdateBudget")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateBudgetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Budget.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetBudgetRequest, Budget> getBudgetMethodDescriptor =
      MethodDescriptor.<GetBudgetRequest, Budget>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.billing.budgets.v1.BudgetService/GetBudget")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBudgetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Budget.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListBudgetsRequest, ListBudgetsResponse>
      listBudgetsMethodDescriptor =
          MethodDescriptor.<ListBudgetsRequest, ListBudgetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.billing.budgets.v1.BudgetService/ListBudgets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBudgetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBudgetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBudgetRequest, Empty> deleteBudgetMethodDescriptor =
      MethodDescriptor.<DeleteBudgetRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.billing.budgets.v1.BudgetService/DeleteBudget")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteBudgetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateBudgetRequest, Budget> createBudgetCallable;
  private final UnaryCallable<UpdateBudgetRequest, Budget> updateBudgetCallable;
  private final UnaryCallable<GetBudgetRequest, Budget> getBudgetCallable;
  private final UnaryCallable<ListBudgetsRequest, ListBudgetsResponse> listBudgetsCallable;
  private final UnaryCallable<ListBudgetsRequest, ListBudgetsPagedResponse>
      listBudgetsPagedCallable;
  private final UnaryCallable<DeleteBudgetRequest, Empty> deleteBudgetCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBudgetServiceStub create(BudgetServiceStubSettings settings)
      throws IOException {
    return new GrpcBudgetServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBudgetServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcBudgetServiceStub(BudgetServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBudgetServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBudgetServiceStub(
        BudgetServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBudgetServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcBudgetServiceStub(BudgetServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcBudgetServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBudgetServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcBudgetServiceStub(
      BudgetServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateBudgetRequest, Budget> createBudgetTransportSettings =
        GrpcCallSettings.<CreateBudgetRequest, Budget>newBuilder()
            .setMethodDescriptor(createBudgetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateBudgetRequest>() {
                  @Override
                  public Map<String, String> extract(CreateBudgetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateBudgetRequest, Budget> updateBudgetTransportSettings =
        GrpcCallSettings.<UpdateBudgetRequest, Budget>newBuilder()
            .setMethodDescriptor(updateBudgetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateBudgetRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateBudgetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("budget.name", String.valueOf(request.getBudget().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetBudgetRequest, Budget> getBudgetTransportSettings =
        GrpcCallSettings.<GetBudgetRequest, Budget>newBuilder()
            .setMethodDescriptor(getBudgetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetBudgetRequest>() {
                  @Override
                  public Map<String, String> extract(GetBudgetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListBudgetsRequest, ListBudgetsResponse> listBudgetsTransportSettings =
        GrpcCallSettings.<ListBudgetsRequest, ListBudgetsResponse>newBuilder()
            .setMethodDescriptor(listBudgetsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListBudgetsRequest>() {
                  @Override
                  public Map<String, String> extract(ListBudgetsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteBudgetRequest, Empty> deleteBudgetTransportSettings =
        GrpcCallSettings.<DeleteBudgetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBudgetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteBudgetRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteBudgetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();

    this.createBudgetCallable =
        callableFactory.createUnaryCallable(
            createBudgetTransportSettings, settings.createBudgetSettings(), clientContext);
    this.updateBudgetCallable =
        callableFactory.createUnaryCallable(
            updateBudgetTransportSettings, settings.updateBudgetSettings(), clientContext);
    this.getBudgetCallable =
        callableFactory.createUnaryCallable(
            getBudgetTransportSettings, settings.getBudgetSettings(), clientContext);
    this.listBudgetsCallable =
        callableFactory.createUnaryCallable(
            listBudgetsTransportSettings, settings.listBudgetsSettings(), clientContext);
    this.listBudgetsPagedCallable =
        callableFactory.createPagedCallable(
            listBudgetsTransportSettings, settings.listBudgetsSettings(), clientContext);
    this.deleteBudgetCallable =
        callableFactory.createUnaryCallable(
            deleteBudgetTransportSettings, settings.deleteBudgetSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<CreateBudgetRequest, Budget> createBudgetCallable() {
    return createBudgetCallable;
  }

  public UnaryCallable<UpdateBudgetRequest, Budget> updateBudgetCallable() {
    return updateBudgetCallable;
  }

  public UnaryCallable<GetBudgetRequest, Budget> getBudgetCallable() {
    return getBudgetCallable;
  }

  public UnaryCallable<ListBudgetsRequest, ListBudgetsResponse> listBudgetsCallable() {
    return listBudgetsCallable;
  }

  public UnaryCallable<ListBudgetsRequest, ListBudgetsPagedResponse> listBudgetsPagedCallable() {
    return listBudgetsPagedCallable;
  }

  public UnaryCallable<DeleteBudgetRequest, Empty> deleteBudgetCallable() {
    return deleteBudgetCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
