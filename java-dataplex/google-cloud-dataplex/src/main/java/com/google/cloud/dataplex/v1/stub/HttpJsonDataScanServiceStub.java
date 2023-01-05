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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListDataScanJobsPagedResponse;
import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListDataScansPagedResponse;
import static com.google.cloud.dataplex.v1.DataScanServiceClient.ListLocationsPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.CreateDataScanRequest;
import com.google.cloud.dataplex.v1.DataScan;
import com.google.cloud.dataplex.v1.DataScanJob;
import com.google.cloud.dataplex.v1.DeleteDataScanRequest;
import com.google.cloud.dataplex.v1.GetDataScanJobRequest;
import com.google.cloud.dataplex.v1.GetDataScanRequest;
import com.google.cloud.dataplex.v1.ListDataScanJobsRequest;
import com.google.cloud.dataplex.v1.ListDataScanJobsResponse;
import com.google.cloud.dataplex.v1.ListDataScansRequest;
import com.google.cloud.dataplex.v1.ListDataScansResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.RunDataScanRequest;
import com.google.cloud.dataplex.v1.RunDataScanResponse;
import com.google.cloud.dataplex.v1.UpdateDataScanRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the DataScanService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonDataScanServiceStub extends DataScanServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(DataScan.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateDataScanRequest, Operation>
      createDataScanMethodDescriptor =
          ApiMethodDescriptor.<CreateDataScanRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/CreateDataScan")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataScanRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dataScans",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataScanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataScanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "dataScanId", request.getDataScanId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataScan", request.getDataScan(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDataScanRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateDataScanRequest, Operation>
      updateDataScanMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataScanRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/UpdateDataScan")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataScanRequest>newBuilder()
                      .setPath(
                          "/v1/{dataScan.name=projects/*/locations/*/dataScans/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataScanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataScan.name", request.getDataScan().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataScanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataScan", request.getDataScan(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDataScanRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDataScanRequest, Operation>
      deleteDataScanMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataScanRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/DeleteDataScan")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataScanRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataScans/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataScanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataScanRequest> serializer =
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
                  (DeleteDataScanRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetDataScanRequest, DataScan>
      getDataScanMethodDescriptor =
          ApiMethodDescriptor.<GetDataScanRequest, DataScan>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/GetDataScan")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataScanRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataScans/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataScanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataScanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataScan>newBuilder()
                      .setDefaultInstance(DataScan.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDataScansRequest, ListDataScansResponse>
      listDataScansMethodDescriptor =
          ApiMethodDescriptor.<ListDataScansRequest, ListDataScansResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/ListDataScans")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataScansRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dataScans",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataScansRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataScansRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDataScansResponse>newBuilder()
                      .setDefaultInstance(ListDataScansResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RunDataScanRequest, RunDataScanResponse>
      runDataScanMethodDescriptor =
          ApiMethodDescriptor.<RunDataScanRequest, RunDataScanResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/RunDataScan")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunDataScanRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataScans/*}:run",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunDataScanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunDataScanRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RunDataScanResponse>newBuilder()
                      .setDefaultInstance(RunDataScanResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataScanJobRequest, DataScanJob>
      getDataScanJobMethodDescriptor =
          ApiMethodDescriptor.<GetDataScanJobRequest, DataScanJob>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/GetDataScanJob")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataScanJobRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataScans/*/jobs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataScanJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataScanJobRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataScanJob>newBuilder()
                      .setDefaultInstance(DataScanJob.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDataScanJobsRequest, ListDataScanJobsResponse>
      listDataScanJobsMethodDescriptor =
          ApiMethodDescriptor.<ListDataScanJobsRequest, ListDataScanJobsResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataScanService/ListDataScanJobs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataScanJobsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/dataScans/*}/jobs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataScanJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataScanJobsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDataScanJobsResponse>newBuilder()
                      .setDefaultInstance(ListDataScanJobsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateDataScanRequest, Operation> createDataScanCallable;
  private final OperationCallable<CreateDataScanRequest, DataScan, OperationMetadata>
      createDataScanOperationCallable;
  private final UnaryCallable<UpdateDataScanRequest, Operation> updateDataScanCallable;
  private final OperationCallable<UpdateDataScanRequest, DataScan, OperationMetadata>
      updateDataScanOperationCallable;
  private final UnaryCallable<DeleteDataScanRequest, Operation> deleteDataScanCallable;
  private final OperationCallable<DeleteDataScanRequest, Empty, OperationMetadata>
      deleteDataScanOperationCallable;
  private final UnaryCallable<GetDataScanRequest, DataScan> getDataScanCallable;
  private final UnaryCallable<ListDataScansRequest, ListDataScansResponse> listDataScansCallable;
  private final UnaryCallable<ListDataScansRequest, ListDataScansPagedResponse>
      listDataScansPagedCallable;
  private final UnaryCallable<RunDataScanRequest, RunDataScanResponse> runDataScanCallable;
  private final UnaryCallable<GetDataScanJobRequest, DataScanJob> getDataScanJobCallable;
  private final UnaryCallable<ListDataScanJobsRequest, ListDataScanJobsResponse>
      listDataScanJobsCallable;
  private final UnaryCallable<ListDataScanJobsRequest, ListDataScanJobsPagedResponse>
      listDataScanJobsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataScanServiceStub create(DataScanServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDataScanServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataScanServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataScanServiceStub(
        DataScanServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataScanServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataScanServiceStub(
        DataScanServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataScanServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataScanServiceStub(
      DataScanServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDataScanServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataScanServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataScanServiceStub(
      DataScanServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateDataScanRequest, Operation> createDataScanTransportSettings =
        HttpJsonCallSettings.<CreateDataScanRequest, Operation>newBuilder()
            .setMethodDescriptor(createDataScanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateDataScanRequest, Operation> updateDataScanTransportSettings =
        HttpJsonCallSettings.<UpdateDataScanRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDataScanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteDataScanRequest, Operation> deleteDataScanTransportSettings =
        HttpJsonCallSettings.<DeleteDataScanRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDataScanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetDataScanRequest, DataScan> getDataScanTransportSettings =
        HttpJsonCallSettings.<GetDataScanRequest, DataScan>newBuilder()
            .setMethodDescriptor(getDataScanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListDataScansRequest, ListDataScansResponse>
        listDataScansTransportSettings =
            HttpJsonCallSettings.<ListDataScansRequest, ListDataScansResponse>newBuilder()
                .setMethodDescriptor(listDataScansMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RunDataScanRequest, RunDataScanResponse> runDataScanTransportSettings =
        HttpJsonCallSettings.<RunDataScanRequest, RunDataScanResponse>newBuilder()
            .setMethodDescriptor(runDataScanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetDataScanJobRequest, DataScanJob> getDataScanJobTransportSettings =
        HttpJsonCallSettings.<GetDataScanJobRequest, DataScanJob>newBuilder()
            .setMethodDescriptor(getDataScanJobMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListDataScanJobsRequest, ListDataScanJobsResponse>
        listDataScanJobsTransportSettings =
            HttpJsonCallSettings.<ListDataScanJobsRequest, ListDataScanJobsResponse>newBuilder()
                .setMethodDescriptor(listDataScanJobsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createDataScanCallable =
        callableFactory.createUnaryCallable(
            createDataScanTransportSettings, settings.createDataScanSettings(), clientContext);
    this.createDataScanOperationCallable =
        callableFactory.createOperationCallable(
            createDataScanTransportSettings,
            settings.createDataScanOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateDataScanCallable =
        callableFactory.createUnaryCallable(
            updateDataScanTransportSettings, settings.updateDataScanSettings(), clientContext);
    this.updateDataScanOperationCallable =
        callableFactory.createOperationCallable(
            updateDataScanTransportSettings,
            settings.updateDataScanOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDataScanCallable =
        callableFactory.createUnaryCallable(
            deleteDataScanTransportSettings, settings.deleteDataScanSettings(), clientContext);
    this.deleteDataScanOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataScanTransportSettings,
            settings.deleteDataScanOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getDataScanCallable =
        callableFactory.createUnaryCallable(
            getDataScanTransportSettings, settings.getDataScanSettings(), clientContext);
    this.listDataScansCallable =
        callableFactory.createUnaryCallable(
            listDataScansTransportSettings, settings.listDataScansSettings(), clientContext);
    this.listDataScansPagedCallable =
        callableFactory.createPagedCallable(
            listDataScansTransportSettings, settings.listDataScansSettings(), clientContext);
    this.runDataScanCallable =
        callableFactory.createUnaryCallable(
            runDataScanTransportSettings, settings.runDataScanSettings(), clientContext);
    this.getDataScanJobCallable =
        callableFactory.createUnaryCallable(
            getDataScanJobTransportSettings, settings.getDataScanJobSettings(), clientContext);
    this.listDataScanJobsCallable =
        callableFactory.createUnaryCallable(
            listDataScanJobsTransportSettings, settings.listDataScanJobsSettings(), clientContext);
    this.listDataScanJobsPagedCallable =
        callableFactory.createPagedCallable(
            listDataScanJobsTransportSettings, settings.listDataScanJobsSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createDataScanMethodDescriptor);
    methodDescriptors.add(updateDataScanMethodDescriptor);
    methodDescriptors.add(deleteDataScanMethodDescriptor);
    methodDescriptors.add(getDataScanMethodDescriptor);
    methodDescriptors.add(listDataScansMethodDescriptor);
    methodDescriptors.add(runDataScanMethodDescriptor);
    methodDescriptors.add(getDataScanJobMethodDescriptor);
    methodDescriptors.add(listDataScanJobsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateDataScanRequest, Operation> createDataScanCallable() {
    return createDataScanCallable;
  }

  @Override
  public OperationCallable<CreateDataScanRequest, DataScan, OperationMetadata>
      createDataScanOperationCallable() {
    return createDataScanOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataScanRequest, Operation> updateDataScanCallable() {
    return updateDataScanCallable;
  }

  @Override
  public OperationCallable<UpdateDataScanRequest, DataScan, OperationMetadata>
      updateDataScanOperationCallable() {
    return updateDataScanOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDataScanRequest, Operation> deleteDataScanCallable() {
    return deleteDataScanCallable;
  }

  @Override
  public OperationCallable<DeleteDataScanRequest, Empty, OperationMetadata>
      deleteDataScanOperationCallable() {
    return deleteDataScanOperationCallable;
  }

  @Override
  public UnaryCallable<GetDataScanRequest, DataScan> getDataScanCallable() {
    return getDataScanCallable;
  }

  @Override
  public UnaryCallable<ListDataScansRequest, ListDataScansResponse> listDataScansCallable() {
    return listDataScansCallable;
  }

  @Override
  public UnaryCallable<ListDataScansRequest, ListDataScansPagedResponse>
      listDataScansPagedCallable() {
    return listDataScansPagedCallable;
  }

  @Override
  public UnaryCallable<RunDataScanRequest, RunDataScanResponse> runDataScanCallable() {
    return runDataScanCallable;
  }

  @Override
  public UnaryCallable<GetDataScanJobRequest, DataScanJob> getDataScanJobCallable() {
    return getDataScanJobCallable;
  }

  @Override
  public UnaryCallable<ListDataScanJobsRequest, ListDataScanJobsResponse>
      listDataScanJobsCallable() {
    return listDataScanJobsCallable;
  }

  @Override
  public UnaryCallable<ListDataScanJobsRequest, ListDataScanJobsPagedResponse>
      listDataScanJobsPagedCallable() {
    return listDataScanJobsPagedCallable;
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
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
