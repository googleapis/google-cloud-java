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

package com.google.cloud.vpcaccess.v1.stub;

import static com.google.cloud.vpcaccess.v1.VpcAccessServiceClient.ListConnectorsPagedResponse;
import static com.google.cloud.vpcaccess.v1.VpcAccessServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.vpcaccess.v1.Connector;
import com.google.cloud.vpcaccess.v1.CreateConnectorRequest;
import com.google.cloud.vpcaccess.v1.DeleteConnectorRequest;
import com.google.cloud.vpcaccess.v1.GetConnectorRequest;
import com.google.cloud.vpcaccess.v1.ListConnectorsRequest;
import com.google.cloud.vpcaccess.v1.ListConnectorsResponse;
import com.google.cloud.vpcaccess.v1.OperationMetadata;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the VpcAccessService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonVpcAccessServiceStub extends VpcAccessServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Connector.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateConnectorRequest, Operation>
      createConnectorMethodDescriptor =
          ApiMethodDescriptor.<CreateConnectorRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vpcaccess.v1.VpcAccessService/CreateConnector")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConnectorRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/connectors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "connectorId", request.getConnectorId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("connector", request.getConnector(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateConnectorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetConnectorRequest, Connector>
      getConnectorMethodDescriptor =
          ApiMethodDescriptor.<GetConnectorRequest, Connector>newBuilder()
              .setFullMethodName("google.cloud.vpcaccess.v1.VpcAccessService/GetConnector")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConnectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/connectors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Connector>newBuilder()
                      .setDefaultInstance(Connector.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListConnectorsRequest, ListConnectorsResponse>
      listConnectorsMethodDescriptor =
          ApiMethodDescriptor.<ListConnectorsRequest, ListConnectorsResponse>newBuilder()
              .setFullMethodName("google.cloud.vpcaccess.v1.VpcAccessService/ListConnectors")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConnectorsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/connectors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConnectorsResponse>newBuilder()
                      .setDefaultInstance(ListConnectorsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteConnectorRequest, Operation>
      deleteConnectorMethodDescriptor =
          ApiMethodDescriptor.<DeleteConnectorRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.vpcaccess.v1.VpcAccessService/DeleteConnector")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConnectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/connectors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                  (DeleteConnectorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateConnectorRequest, Operation> createConnectorCallable;
  private final OperationCallable<CreateConnectorRequest, Connector, OperationMetadata>
      createConnectorOperationCallable;
  private final UnaryCallable<GetConnectorRequest, Connector> getConnectorCallable;
  private final UnaryCallable<ListConnectorsRequest, ListConnectorsResponse> listConnectorsCallable;
  private final UnaryCallable<ListConnectorsRequest, ListConnectorsPagedResponse>
      listConnectorsPagedCallable;
  private final UnaryCallable<DeleteConnectorRequest, Operation> deleteConnectorCallable;
  private final OperationCallable<DeleteConnectorRequest, Empty, OperationMetadata>
      deleteConnectorOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonVpcAccessServiceStub create(VpcAccessServiceStubSettings settings)
      throws IOException {
    return new HttpJsonVpcAccessServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonVpcAccessServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonVpcAccessServiceStub(
        VpcAccessServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonVpcAccessServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonVpcAccessServiceStub(
        VpcAccessServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonVpcAccessServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonVpcAccessServiceStub(
      VpcAccessServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonVpcAccessServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonVpcAccessServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonVpcAccessServiceStub(
      VpcAccessServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateConnectorRequest, Operation> createConnectorTransportSettings =
        HttpJsonCallSettings.<CreateConnectorRequest, Operation>newBuilder()
            .setMethodDescriptor(createConnectorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetConnectorRequest, Connector> getConnectorTransportSettings =
        HttpJsonCallSettings.<GetConnectorRequest, Connector>newBuilder()
            .setMethodDescriptor(getConnectorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListConnectorsRequest, ListConnectorsResponse>
        listConnectorsTransportSettings =
            HttpJsonCallSettings.<ListConnectorsRequest, ListConnectorsResponse>newBuilder()
                .setMethodDescriptor(listConnectorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteConnectorRequest, Operation> deleteConnectorTransportSettings =
        HttpJsonCallSettings.<DeleteConnectorRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteConnectorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createConnectorCallable =
        callableFactory.createUnaryCallable(
            createConnectorTransportSettings, settings.createConnectorSettings(), clientContext);
    this.createConnectorOperationCallable =
        callableFactory.createOperationCallable(
            createConnectorTransportSettings,
            settings.createConnectorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getConnectorCallable =
        callableFactory.createUnaryCallable(
            getConnectorTransportSettings, settings.getConnectorSettings(), clientContext);
    this.listConnectorsCallable =
        callableFactory.createUnaryCallable(
            listConnectorsTransportSettings, settings.listConnectorsSettings(), clientContext);
    this.listConnectorsPagedCallable =
        callableFactory.createPagedCallable(
            listConnectorsTransportSettings, settings.listConnectorsSettings(), clientContext);
    this.deleteConnectorCallable =
        callableFactory.createUnaryCallable(
            deleteConnectorTransportSettings, settings.deleteConnectorSettings(), clientContext);
    this.deleteConnectorOperationCallable =
        callableFactory.createOperationCallable(
            deleteConnectorTransportSettings,
            settings.deleteConnectorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createConnectorMethodDescriptor);
    methodDescriptors.add(getConnectorMethodDescriptor);
    methodDescriptors.add(listConnectorsMethodDescriptor);
    methodDescriptors.add(deleteConnectorMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateConnectorRequest, Operation> createConnectorCallable() {
    return createConnectorCallable;
  }

  @Override
  public OperationCallable<CreateConnectorRequest, Connector, OperationMetadata>
      createConnectorOperationCallable() {
    return createConnectorOperationCallable;
  }

  @Override
  public UnaryCallable<GetConnectorRequest, Connector> getConnectorCallable() {
    return getConnectorCallable;
  }

  @Override
  public UnaryCallable<ListConnectorsRequest, ListConnectorsResponse> listConnectorsCallable() {
    return listConnectorsCallable;
  }

  @Override
  public UnaryCallable<ListConnectorsRequest, ListConnectorsPagedResponse>
      listConnectorsPagedCallable() {
    return listConnectorsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectorRequest, Operation> deleteConnectorCallable() {
    return deleteConnectorCallable;
  }

  @Override
  public OperationCallable<DeleteConnectorRequest, Empty, OperationMetadata>
      deleteConnectorOperationCallable() {
    return deleteConnectorOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
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
