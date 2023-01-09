/*
 * Copyright 2022 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.billing.budgets.v1.Budget;
import com.google.cloud.billing.budgets.v1.CreateBudgetRequest;
import com.google.cloud.billing.budgets.v1.DeleteBudgetRequest;
import com.google.cloud.billing.budgets.v1.GetBudgetRequest;
import com.google.cloud.billing.budgets.v1.ListBudgetsRequest;
import com.google.cloud.billing.budgets.v1.ListBudgetsResponse;
import com.google.cloud.billing.budgets.v1.UpdateBudgetRequest;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the BudgetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonBudgetServiceStub extends BudgetServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateBudgetRequest, Budget>
      createBudgetMethodDescriptor =
          ApiMethodDescriptor.<CreateBudgetRequest, Budget>newBuilder()
              .setFullMethodName("google.cloud.billing.budgets.v1.BudgetService/CreateBudget")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBudgetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=billingAccounts/*}/budgets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBudgetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBudgetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("budget", request.getBudget(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Budget>newBuilder()
                      .setDefaultInstance(Budget.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBudgetRequest, Budget>
      updateBudgetMethodDescriptor =
          ApiMethodDescriptor.<UpdateBudgetRequest, Budget>newBuilder()
              .setFullMethodName("google.cloud.billing.budgets.v1.BudgetService/UpdateBudget")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBudgetRequest>newBuilder()
                      .setPath(
                          "/v1/{budget.name=billingAccounts/*/budgets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBudgetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "budget.name", request.getBudget().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBudgetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("budget", request.getBudget(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Budget>newBuilder()
                      .setDefaultInstance(Budget.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBudgetRequest, Budget> getBudgetMethodDescriptor =
      ApiMethodDescriptor.<GetBudgetRequest, Budget>newBuilder()
          .setFullMethodName("google.cloud.billing.budgets.v1.BudgetService/GetBudget")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetBudgetRequest>newBuilder()
                  .setPath(
                      "/v1/{name=billingAccounts/*/budgets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetBudgetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetBudgetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Budget>newBuilder()
                  .setDefaultInstance(Budget.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListBudgetsRequest, ListBudgetsResponse>
      listBudgetsMethodDescriptor =
          ApiMethodDescriptor.<ListBudgetsRequest, ListBudgetsResponse>newBuilder()
              .setFullMethodName("google.cloud.billing.budgets.v1.BudgetService/ListBudgets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBudgetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=billingAccounts/*}/budgets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBudgetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBudgetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBudgetsResponse>newBuilder()
                      .setDefaultInstance(ListBudgetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBudgetRequest, Empty>
      deleteBudgetMethodDescriptor =
          ApiMethodDescriptor.<DeleteBudgetRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.billing.budgets.v1.BudgetService/DeleteBudget")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBudgetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=billingAccounts/*/budgets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBudgetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBudgetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateBudgetRequest, Budget> createBudgetCallable;
  private final UnaryCallable<UpdateBudgetRequest, Budget> updateBudgetCallable;
  private final UnaryCallable<GetBudgetRequest, Budget> getBudgetCallable;
  private final UnaryCallable<ListBudgetsRequest, ListBudgetsResponse> listBudgetsCallable;
  private final UnaryCallable<ListBudgetsRequest, ListBudgetsPagedResponse>
      listBudgetsPagedCallable;
  private final UnaryCallable<DeleteBudgetRequest, Empty> deleteBudgetCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBudgetServiceStub create(BudgetServiceStubSettings settings)
      throws IOException {
    return new HttpJsonBudgetServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBudgetServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBudgetServiceStub(
        BudgetServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonBudgetServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBudgetServiceStub(
        BudgetServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBudgetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBudgetServiceStub(
      BudgetServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBudgetServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBudgetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBudgetServiceStub(
      BudgetServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateBudgetRequest, Budget> createBudgetTransportSettings =
        HttpJsonCallSettings.<CreateBudgetRequest, Budget>newBuilder()
            .setMethodDescriptor(createBudgetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateBudgetRequest, Budget> updateBudgetTransportSettings =
        HttpJsonCallSettings.<UpdateBudgetRequest, Budget>newBuilder()
            .setMethodDescriptor(updateBudgetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetBudgetRequest, Budget> getBudgetTransportSettings =
        HttpJsonCallSettings.<GetBudgetRequest, Budget>newBuilder()
            .setMethodDescriptor(getBudgetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListBudgetsRequest, ListBudgetsResponse> listBudgetsTransportSettings =
        HttpJsonCallSettings.<ListBudgetsRequest, ListBudgetsResponse>newBuilder()
            .setMethodDescriptor(listBudgetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteBudgetRequest, Empty> deleteBudgetTransportSettings =
        HttpJsonCallSettings.<DeleteBudgetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBudgetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createBudgetMethodDescriptor);
    methodDescriptors.add(updateBudgetMethodDescriptor);
    methodDescriptors.add(getBudgetMethodDescriptor);
    methodDescriptors.add(listBudgetsMethodDescriptor);
    methodDescriptors.add(deleteBudgetMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateBudgetRequest, Budget> createBudgetCallable() {
    return createBudgetCallable;
  }

  @Override
  public UnaryCallable<UpdateBudgetRequest, Budget> updateBudgetCallable() {
    return updateBudgetCallable;
  }

  @Override
  public UnaryCallable<GetBudgetRequest, Budget> getBudgetCallable() {
    return getBudgetCallable;
  }

  @Override
  public UnaryCallable<ListBudgetsRequest, ListBudgetsResponse> listBudgetsCallable() {
    return listBudgetsCallable;
  }

  @Override
  public UnaryCallable<ListBudgetsRequest, ListBudgetsPagedResponse> listBudgetsPagedCallable() {
    return listBudgetsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteBudgetRequest, Empty> deleteBudgetCallable() {
    return deleteBudgetCallable;
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
