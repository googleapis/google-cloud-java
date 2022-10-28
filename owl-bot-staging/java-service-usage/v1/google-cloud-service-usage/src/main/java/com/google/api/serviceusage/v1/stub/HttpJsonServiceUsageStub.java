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

package com.google.api.serviceusage.v1.stub;

import static com.google.api.serviceusage.v1.ServiceUsageClient.ListServicesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.serviceusage.v1.BatchEnableServicesRequest;
import com.google.api.serviceusage.v1.BatchEnableServicesResponse;
import com.google.api.serviceusage.v1.BatchGetServicesRequest;
import com.google.api.serviceusage.v1.BatchGetServicesResponse;
import com.google.api.serviceusage.v1.DisableServiceRequest;
import com.google.api.serviceusage.v1.DisableServiceResponse;
import com.google.api.serviceusage.v1.EnableServiceRequest;
import com.google.api.serviceusage.v1.EnableServiceResponse;
import com.google.api.serviceusage.v1.GetServiceRequest;
import com.google.api.serviceusage.v1.ListServicesRequest;
import com.google.api.serviceusage.v1.ListServicesResponse;
import com.google.api.serviceusage.v1.OperationMetadata;
import com.google.api.serviceusage.v1.Service;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the ServiceUsage service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonServiceUsageStub extends ServiceUsageStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(BatchEnableServicesResponse.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(DisableServiceResponse.getDescriptor())
          .add(EnableServiceResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<EnableServiceRequest, Operation>
      enableServiceMethodDescriptor =
          ApiMethodDescriptor.<EnableServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.api.serviceusage.v1.ServiceUsage/EnableService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnableServiceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=*/*/services/*}:enable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnableServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnableServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (EnableServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DisableServiceRequest, Operation>
      disableServiceMethodDescriptor =
          ApiMethodDescriptor.<DisableServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.api.serviceusage.v1.ServiceUsage/DisableService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisableServiceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=*/*/services/*}:disable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DisableServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DisableServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DisableServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      ApiMethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setFullMethodName("google.api.serviceusage.v1.ServiceUsage/GetService")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetServiceRequest>newBuilder()
                  .setPath(
                      "/v1/{name=*/*/services/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetServiceRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetServiceRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Service>newBuilder()
                  .setDefaultInstance(Service.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          ApiMethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setFullMethodName("google.api.serviceusage.v1.ServiceUsage/ListServices")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServicesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=*/*}/services",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListServicesResponse>newBuilder()
                      .setDefaultInstance(ListServicesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchEnableServicesRequest, Operation>
      batchEnableServicesMethodDescriptor =
          ApiMethodDescriptor.<BatchEnableServicesRequest, Operation>newBuilder()
              .setFullMethodName("google.api.serviceusage.v1.ServiceUsage/BatchEnableServices")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchEnableServicesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=*/*}/services:batchEnable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchEnableServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchEnableServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchEnableServicesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<BatchGetServicesRequest, BatchGetServicesResponse>
      batchGetServicesMethodDescriptor =
          ApiMethodDescriptor.<BatchGetServicesRequest, BatchGetServicesResponse>newBuilder()
              .setFullMethodName("google.api.serviceusage.v1.ServiceUsage/BatchGetServices")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchGetServicesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=*/*}/services:batchGet",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "names", request.getNamesList());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchGetServicesResponse>newBuilder()
                      .setDefaultInstance(BatchGetServicesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<EnableServiceRequest, Operation> enableServiceCallable;
  private final OperationCallable<EnableServiceRequest, EnableServiceResponse, OperationMetadata>
      enableServiceOperationCallable;
  private final UnaryCallable<DisableServiceRequest, Operation> disableServiceCallable;
  private final OperationCallable<DisableServiceRequest, DisableServiceResponse, OperationMetadata>
      disableServiceOperationCallable;
  private final UnaryCallable<GetServiceRequest, Service> getServiceCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<BatchEnableServicesRequest, Operation> batchEnableServicesCallable;
  private final OperationCallable<
          BatchEnableServicesRequest, BatchEnableServicesResponse, OperationMetadata>
      batchEnableServicesOperationCallable;
  private final UnaryCallable<BatchGetServicesRequest, BatchGetServicesResponse>
      batchGetServicesCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonServiceUsageStub create(ServiceUsageStubSettings settings)
      throws IOException {
    return new HttpJsonServiceUsageStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonServiceUsageStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonServiceUsageStub(
        ServiceUsageStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonServiceUsageStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonServiceUsageStub(
        ServiceUsageStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonServiceUsageStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonServiceUsageStub(ServiceUsageStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonServiceUsageCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonServiceUsageStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonServiceUsageStub(
      ServiceUsageStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<EnableServiceRequest, Operation> enableServiceTransportSettings =
        HttpJsonCallSettings.<EnableServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(enableServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DisableServiceRequest, Operation> disableServiceTransportSettings =
        HttpJsonCallSettings.<DisableServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(disableServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetServiceRequest, Service> getServiceTransportSettings =
        HttpJsonCallSettings.<GetServiceRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        HttpJsonCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchEnableServicesRequest, Operation>
        batchEnableServicesTransportSettings =
            HttpJsonCallSettings.<BatchEnableServicesRequest, Operation>newBuilder()
                .setMethodDescriptor(batchEnableServicesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<BatchGetServicesRequest, BatchGetServicesResponse>
        batchGetServicesTransportSettings =
            HttpJsonCallSettings.<BatchGetServicesRequest, BatchGetServicesResponse>newBuilder()
                .setMethodDescriptor(batchGetServicesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.enableServiceCallable =
        callableFactory.createUnaryCallable(
            enableServiceTransportSettings, settings.enableServiceSettings(), clientContext);
    this.enableServiceOperationCallable =
        callableFactory.createOperationCallable(
            enableServiceTransportSettings,
            settings.enableServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.disableServiceCallable =
        callableFactory.createUnaryCallable(
            disableServiceTransportSettings, settings.disableServiceSettings(), clientContext);
    this.disableServiceOperationCallable =
        callableFactory.createOperationCallable(
            disableServiceTransportSettings,
            settings.disableServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getServiceCallable =
        callableFactory.createUnaryCallable(
            getServiceTransportSettings, settings.getServiceSettings(), clientContext);
    this.listServicesCallable =
        callableFactory.createUnaryCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listServicesPagedCallable =
        callableFactory.createPagedCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.batchEnableServicesCallable =
        callableFactory.createUnaryCallable(
            batchEnableServicesTransportSettings,
            settings.batchEnableServicesSettings(),
            clientContext);
    this.batchEnableServicesOperationCallable =
        callableFactory.createOperationCallable(
            batchEnableServicesTransportSettings,
            settings.batchEnableServicesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.batchGetServicesCallable =
        callableFactory.createUnaryCallable(
            batchGetServicesTransportSettings, settings.batchGetServicesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(enableServiceMethodDescriptor);
    methodDescriptors.add(disableServiceMethodDescriptor);
    methodDescriptors.add(getServiceMethodDescriptor);
    methodDescriptors.add(listServicesMethodDescriptor);
    methodDescriptors.add(batchEnableServicesMethodDescriptor);
    methodDescriptors.add(batchGetServicesMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<EnableServiceRequest, Operation> enableServiceCallable() {
    return enableServiceCallable;
  }

  @Override
  public OperationCallable<EnableServiceRequest, EnableServiceResponse, OperationMetadata>
      enableServiceOperationCallable() {
    return enableServiceOperationCallable;
  }

  @Override
  public UnaryCallable<DisableServiceRequest, Operation> disableServiceCallable() {
    return disableServiceCallable;
  }

  @Override
  public OperationCallable<DisableServiceRequest, DisableServiceResponse, OperationMetadata>
      disableServiceOperationCallable() {
    return disableServiceOperationCallable;
  }

  @Override
  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return getServiceCallable;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return listServicesCallable;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    return listServicesPagedCallable;
  }

  @Override
  public UnaryCallable<BatchEnableServicesRequest, Operation> batchEnableServicesCallable() {
    return batchEnableServicesCallable;
  }

  @Override
  public OperationCallable<
          BatchEnableServicesRequest, BatchEnableServicesResponse, OperationMetadata>
      batchEnableServicesOperationCallable() {
    return batchEnableServicesOperationCallable;
  }

  @Override
  public UnaryCallable<BatchGetServicesRequest, BatchGetServicesResponse>
      batchGetServicesCallable() {
    return batchGetServicesCallable;
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
