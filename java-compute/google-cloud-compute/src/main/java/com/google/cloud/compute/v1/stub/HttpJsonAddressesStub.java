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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.AddressesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.AddressesClient.ListPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.Address;
import com.google.cloud.compute.v1.AddressAggregatedList;
import com.google.cloud.compute.v1.AddressList;
import com.google.cloud.compute.v1.AggregatedListAddressesRequest;
import com.google.cloud.compute.v1.DeleteAddressRequest;
import com.google.cloud.compute.v1.GetAddressRequest;
import com.google.cloud.compute.v1.InsertAddressRequest;
import com.google.cloud.compute.v1.ListAddressesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.SetLabelsAddressRequest;
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
 * REST stub implementation for the Addresses service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAddressesStub extends AddressesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<AggregatedListAddressesRequest, AddressAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor.<AggregatedListAddressesRequest, AddressAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Addresses/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListAddressesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/addresses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListAddressesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListAddressesRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasFilter()) {
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                            }
                            if (request.hasIncludeAllScopes()) {
                              serializer.putQueryParam(
                                  fields, "includeAllScopes", request.getIncludeAllScopes());
                            }
                            if (request.hasMaxResults()) {
                              serializer.putQueryParam(
                                  fields, "maxResults", request.getMaxResults());
                            }
                            if (request.hasOrderBy()) {
                              serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            }
                            if (request.hasPageToken()) {
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AddressAggregatedList>newBuilder()
                      .setDefaultInstance(AddressAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAddressRequest, Operation> deleteMethodDescriptor =
      ApiMethodDescriptor.<DeleteAddressRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Addresses/Delete")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteAddressRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/addresses/{address}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteAddressRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "address", request.getAddress());
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteAddressRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (DeleteAddressRequest request, Operation response) -> {
                StringBuilder opName = new StringBuilder(response.getName());
                opName.append(":").append(request.getProject());
                opName.append(":").append(request.getRegion());
                return HttpJsonOperationSnapshot.newBuilder()
                    .setName(opName.toString())
                    .setMetadata(response)
                    .setDone(Status.DONE.equals(response.getStatus()))
                    .setResponse(response)
                    .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                    .build();
              })
          .build();

  private static final ApiMethodDescriptor<GetAddressRequest, Address> getMethodDescriptor =
      ApiMethodDescriptor.<GetAddressRequest, Address>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Addresses/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAddressRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/addresses/{address}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetAddressRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "address", request.getAddress());
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetAddressRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Address>newBuilder()
                  .setDefaultInstance(Address.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<InsertAddressRequest, Operation> insertMethodDescriptor =
      ApiMethodDescriptor.<InsertAddressRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Addresses/Insert")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<InsertAddressRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/addresses",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<InsertAddressRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<InsertAddressRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("addressResource", request.getAddressResource(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (InsertAddressRequest request, Operation response) -> {
                StringBuilder opName = new StringBuilder(response.getName());
                opName.append(":").append(request.getProject());
                opName.append(":").append(request.getRegion());
                return HttpJsonOperationSnapshot.newBuilder()
                    .setName(opName.toString())
                    .setMetadata(response)
                    .setDone(Status.DONE.equals(response.getStatus()))
                    .setResponse(response)
                    .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                    .build();
              })
          .build();

  private static final ApiMethodDescriptor<ListAddressesRequest, AddressList> listMethodDescriptor =
      ApiMethodDescriptor.<ListAddressesRequest, AddressList>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Addresses/List")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ListAddressesRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/addresses",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<ListAddressesRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<ListAddressesRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasFilter()) {
                          serializer.putQueryParam(fields, "filter", request.getFilter());
                        }
                        if (request.hasMaxResults()) {
                          serializer.putQueryParam(fields, "maxResults", request.getMaxResults());
                        }
                        if (request.hasOrderBy()) {
                          serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                        }
                        if (request.hasPageToken()) {
                          serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                        }
                        if (request.hasReturnPartialSuccess()) {
                          serializer.putQueryParam(
                              fields, "returnPartialSuccess", request.getReturnPartialSuccess());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<AddressList>newBuilder()
                  .setDefaultInstance(AddressList.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<SetLabelsAddressRequest, Operation>
      setLabelsMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsAddressRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Addresses/SetLabels")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLabelsAddressRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/addresses/{resource}/setLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetLabelsAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetLabelsAddressRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "regionSetLabelsRequestResource",
                                      request.getRegionSetLabelsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetLabelsAddressRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private final UnaryCallable<AggregatedListAddressesRequest, AddressAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListAddressesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteAddressRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteAddressRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetAddressRequest, Address> getCallable;
  private final UnaryCallable<InsertAddressRequest, Operation> insertCallable;
  private final OperationCallable<InsertAddressRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListAddressesRequest, AddressList> listCallable;
  private final UnaryCallable<ListAddressesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<SetLabelsAddressRequest, Operation> setLabelsCallable;
  private final OperationCallable<SetLabelsAddressRequest, Operation, Operation>
      setLabelsOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAddressesStub create(AddressesStubSettings settings)
      throws IOException {
    return new HttpJsonAddressesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAddressesStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonAddressesStub(AddressesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonAddressesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAddressesStub(
        AddressesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAddressesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAddressesStub(AddressesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAddressesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAddressesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAddressesStub(
      AddressesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AggregatedListAddressesRequest, AddressAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings.<AggregatedListAddressesRequest, AddressAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteAddressRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteAddressRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetAddressRequest, Address> getTransportSettings =
        HttpJsonCallSettings.<GetAddressRequest, Address>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertAddressRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertAddressRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListAddressesRequest, AddressList> listTransportSettings =
        HttpJsonCallSettings.<ListAddressesRequest, AddressList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetLabelsAddressRequest, Operation> setLabelsTransportSettings =
        HttpJsonCallSettings.<SetLabelsAddressRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deleteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTransportSettings,
            settings.deleteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.insertOperationCallable =
        callableFactory.createOperationCallable(
            insertTransportSettings,
            settings.insertOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.setLabelsCallable =
        callableFactory.createUnaryCallable(
            setLabelsTransportSettings, settings.setLabelsSettings(), clientContext);
    this.setLabelsOperationCallable =
        callableFactory.createOperationCallable(
            setLabelsTransportSettings,
            settings.setLabelsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(setLabelsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListAddressesRequest, AddressAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListAddressesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAddressRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteAddressRequest, Operation, Operation> deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetAddressRequest, Address> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertAddressRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertAddressRequest, Operation, Operation> insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListAddressesRequest, AddressList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListAddressesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<SetLabelsAddressRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  @Override
  public OperationCallable<SetLabelsAddressRequest, Operation, Operation>
      setLabelsOperationCallable() {
    return setLabelsOperationCallable;
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
