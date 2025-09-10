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

package com.google.cloud.licensemanager.v1.stub;

import static com.google.cloud.licensemanager.v1.LicenseManagerClient.AggregateUsagePagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListConfigurationsPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListInstancesPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListProductsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.licensemanager.v1.AggregateUsageRequest;
import com.google.cloud.licensemanager.v1.AggregateUsageResponse;
import com.google.cloud.licensemanager.v1.Configuration;
import com.google.cloud.licensemanager.v1.CreateConfigurationRequest;
import com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest;
import com.google.cloud.licensemanager.v1.DeleteConfigurationRequest;
import com.google.cloud.licensemanager.v1.GetConfigurationRequest;
import com.google.cloud.licensemanager.v1.GetInstanceRequest;
import com.google.cloud.licensemanager.v1.GetProductRequest;
import com.google.cloud.licensemanager.v1.Instance;
import com.google.cloud.licensemanager.v1.ListConfigurationsRequest;
import com.google.cloud.licensemanager.v1.ListConfigurationsResponse;
import com.google.cloud.licensemanager.v1.ListInstancesRequest;
import com.google.cloud.licensemanager.v1.ListInstancesResponse;
import com.google.cloud.licensemanager.v1.ListProductsRequest;
import com.google.cloud.licensemanager.v1.ListProductsResponse;
import com.google.cloud.licensemanager.v1.OperationMetadata;
import com.google.cloud.licensemanager.v1.Product;
import com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest;
import com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse;
import com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest;
import com.google.cloud.licensemanager.v1.UpdateConfigurationRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
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
 * REST stub implementation for the LicenseManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonLicenseManagerStub extends LicenseManagerStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Configuration.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListConfigurationsRequest, ListConfigurationsResponse>
      listConfigurationsMethodDescriptor =
          ApiMethodDescriptor.<ListConfigurationsRequest, ListConfigurationsResponse>newBuilder()
              .setFullMethodName("google.cloud.licensemanager.v1.LicenseManager/ListConfigurations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConfigurationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/configurations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConfigurationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConfigurationsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListConfigurationsResponse>newBuilder()
                      .setDefaultInstance(ListConfigurationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConfigurationRequest, Configuration>
      getConfigurationMethodDescriptor =
          ApiMethodDescriptor.<GetConfigurationRequest, Configuration>newBuilder()
              .setFullMethodName("google.cloud.licensemanager.v1.LicenseManager/GetConfiguration")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConfigurationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/configurations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConfigurationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConfigurationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Configuration>newBuilder()
                      .setDefaultInstance(Configuration.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateConfigurationRequest, Operation>
      createConfigurationMethodDescriptor =
          ApiMethodDescriptor.<CreateConfigurationRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.licensemanager.v1.LicenseManager/CreateConfiguration")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConfigurationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/configurations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConfigurationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConfigurationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "configurationId", request.getConfigurationId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("configuration", request.getConfiguration(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateConfigurationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateConfigurationRequest, Operation>
      updateConfigurationMethodDescriptor =
          ApiMethodDescriptor.<UpdateConfigurationRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.licensemanager.v1.LicenseManager/UpdateConfiguration")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConfigurationRequest>newBuilder()
                      .setPath(
                          "/v1/{configuration.name=projects/*/locations/*/configurations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConfigurationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "configuration.name", request.getConfiguration().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConfigurationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("configuration", request.getConfiguration(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateConfigurationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteConfigurationRequest, Operation>
      deleteConfigurationMethodDescriptor =
          ApiMethodDescriptor.<DeleteConfigurationRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.licensemanager.v1.LicenseManager/DeleteConfiguration")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConfigurationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/configurations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConfigurationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConfigurationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteConfigurationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          ApiMethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setFullMethodName("google.cloud.licensemanager.v1.LicenseManager/ListInstances")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstancesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListInstancesResponse>newBuilder()
                      .setDefaultInstance(ListInstancesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInstanceRequest, Instance>
      getInstanceMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
              .setFullMethodName("google.cloud.licensemanager.v1.LicenseManager/GetInstance")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Instance>newBuilder()
                      .setDefaultInstance(Instance.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeactivateConfigurationRequest, Operation>
      deactivateConfigurationMethodDescriptor =
          ApiMethodDescriptor.<DeactivateConfigurationRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.licensemanager.v1.LicenseManager/DeactivateConfiguration")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeactivateConfigurationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/configurations/*}:deactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeactivateConfigurationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeactivateConfigurationRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeactivateConfigurationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ReactivateConfigurationRequest, Operation>
      reactivateConfigurationMethodDescriptor =
          ApiMethodDescriptor.<ReactivateConfigurationRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.licensemanager.v1.LicenseManager/ReactivateConfiguration")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReactivateConfigurationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/configurations/*}:reactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReactivateConfigurationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReactivateConfigurationRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ReactivateConfigurationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
      queryConfigurationLicenseUsageMethodDescriptor =
          ApiMethodDescriptor
              .<QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.licensemanager.v1.LicenseManager/QueryConfigurationLicenseUsage")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryConfigurationLicenseUsageRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/configurations/*}:queryLicenseUsage",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryConfigurationLicenseUsageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryConfigurationLicenseUsageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "endTime", request.getEndTime());
                            serializer.putQueryParam(fields, "startTime", request.getStartTime());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QueryConfigurationLicenseUsageResponse>newBuilder()
                      .setDefaultInstance(
                          QueryConfigurationLicenseUsageResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AggregateUsageRequest, AggregateUsageResponse>
      aggregateUsageMethodDescriptor =
          ApiMethodDescriptor.<AggregateUsageRequest, AggregateUsageResponse>newBuilder()
              .setFullMethodName("google.cloud.licensemanager.v1.LicenseManager/AggregateUsage")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregateUsageRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/configurations/*}:aggregateUsage",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregateUsageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregateUsageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "endTime", request.getEndTime());
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "startTime", request.getStartTime());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AggregateUsageResponse>newBuilder()
                      .setDefaultInstance(AggregateUsageResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListProductsRequest, ListProductsResponse>
      listProductsMethodDescriptor =
          ApiMethodDescriptor.<ListProductsRequest, ListProductsResponse>newBuilder()
              .setFullMethodName("google.cloud.licensemanager.v1.LicenseManager/ListProducts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProductsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/products",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProductsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListProductsResponse>newBuilder()
                      .setDefaultInstance(ListProductsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetProductRequest, Product> getProductMethodDescriptor =
      ApiMethodDescriptor.<GetProductRequest, Product>newBuilder()
          .setFullMethodName("google.cloud.licensemanager.v1.LicenseManager/GetProduct")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetProductRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/products/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetProductRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetProductRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Product>newBuilder()
                  .setDefaultInstance(Product.getDefaultInstance())
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

  private final UnaryCallable<ListConfigurationsRequest, ListConfigurationsResponse>
      listConfigurationsCallable;
  private final UnaryCallable<ListConfigurationsRequest, ListConfigurationsPagedResponse>
      listConfigurationsPagedCallable;
  private final UnaryCallable<GetConfigurationRequest, Configuration> getConfigurationCallable;
  private final UnaryCallable<CreateConfigurationRequest, Operation> createConfigurationCallable;
  private final OperationCallable<CreateConfigurationRequest, Configuration, OperationMetadata>
      createConfigurationOperationCallable;
  private final UnaryCallable<UpdateConfigurationRequest, Operation> updateConfigurationCallable;
  private final OperationCallable<UpdateConfigurationRequest, Configuration, OperationMetadata>
      updateConfigurationOperationCallable;
  private final UnaryCallable<DeleteConfigurationRequest, Operation> deleteConfigurationCallable;
  private final OperationCallable<DeleteConfigurationRequest, Empty, OperationMetadata>
      deleteConfigurationOperationCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<DeactivateConfigurationRequest, Operation>
      deactivateConfigurationCallable;
  private final OperationCallable<DeactivateConfigurationRequest, Configuration, OperationMetadata>
      deactivateConfigurationOperationCallable;
  private final UnaryCallable<ReactivateConfigurationRequest, Operation>
      reactivateConfigurationCallable;
  private final OperationCallable<ReactivateConfigurationRequest, Configuration, OperationMetadata>
      reactivateConfigurationOperationCallable;
  private final UnaryCallable<
          QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
      queryConfigurationLicenseUsageCallable;
  private final UnaryCallable<AggregateUsageRequest, AggregateUsageResponse> aggregateUsageCallable;
  private final UnaryCallable<AggregateUsageRequest, AggregateUsagePagedResponse>
      aggregateUsagePagedCallable;
  private final UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable;
  private final UnaryCallable<ListProductsRequest, ListProductsPagedResponse>
      listProductsPagedCallable;
  private final UnaryCallable<GetProductRequest, Product> getProductCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLicenseManagerStub create(LicenseManagerStubSettings settings)
      throws IOException {
    return new HttpJsonLicenseManagerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLicenseManagerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLicenseManagerStub(
        LicenseManagerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonLicenseManagerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLicenseManagerStub(
        LicenseManagerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLicenseManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLicenseManagerStub(
      LicenseManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonLicenseManagerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLicenseManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLicenseManagerStub(
      LicenseManagerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListConfigurationsRequest, ListConfigurationsResponse>
        listConfigurationsTransportSettings =
            HttpJsonCallSettings.<ListConfigurationsRequest, ListConfigurationsResponse>newBuilder()
                .setMethodDescriptor(listConfigurationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetConfigurationRequest, Configuration> getConfigurationTransportSettings =
        HttpJsonCallSettings.<GetConfigurationRequest, Configuration>newBuilder()
            .setMethodDescriptor(getConfigurationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateConfigurationRequest, Operation>
        createConfigurationTransportSettings =
            HttpJsonCallSettings.<CreateConfigurationRequest, Operation>newBuilder()
                .setMethodDescriptor(createConfigurationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateConfigurationRequest, Operation>
        updateConfigurationTransportSettings =
            HttpJsonCallSettings.<UpdateConfigurationRequest, Operation>newBuilder()
                .setMethodDescriptor(updateConfigurationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "configuration.name",
                          String.valueOf(request.getConfiguration().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteConfigurationRequest, Operation>
        deleteConfigurationTransportSettings =
            HttpJsonCallSettings.<DeleteConfigurationRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConfigurationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListInstancesRequest, ListInstancesResponse>
        listInstancesTransportSettings =
            HttpJsonCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
                .setMethodDescriptor(listInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        HttpJsonCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeactivateConfigurationRequest, Operation>
        deactivateConfigurationTransportSettings =
            HttpJsonCallSettings.<DeactivateConfigurationRequest, Operation>newBuilder()
                .setMethodDescriptor(deactivateConfigurationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ReactivateConfigurationRequest, Operation>
        reactivateConfigurationTransportSettings =
            HttpJsonCallSettings.<ReactivateConfigurationRequest, Operation>newBuilder()
                .setMethodDescriptor(reactivateConfigurationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
        queryConfigurationLicenseUsageTransportSettings =
            HttpJsonCallSettings
                .<QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
                    newBuilder()
                .setMethodDescriptor(queryConfigurationLicenseUsageMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<AggregateUsageRequest, AggregateUsageResponse>
        aggregateUsageTransportSettings =
            HttpJsonCallSettings.<AggregateUsageRequest, AggregateUsageResponse>newBuilder()
                .setMethodDescriptor(aggregateUsageMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListProductsRequest, ListProductsResponse> listProductsTransportSettings =
        HttpJsonCallSettings.<ListProductsRequest, ListProductsResponse>newBuilder()
            .setMethodDescriptor(listProductsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetProductRequest, Product> getProductTransportSettings =
        HttpJsonCallSettings.<GetProductRequest, Product>newBuilder()
            .setMethodDescriptor(getProductMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listConfigurationsCallable =
        callableFactory.createUnaryCallable(
            listConfigurationsTransportSettings,
            settings.listConfigurationsSettings(),
            clientContext);
    this.listConfigurationsPagedCallable =
        callableFactory.createPagedCallable(
            listConfigurationsTransportSettings,
            settings.listConfigurationsSettings(),
            clientContext);
    this.getConfigurationCallable =
        callableFactory.createUnaryCallable(
            getConfigurationTransportSettings, settings.getConfigurationSettings(), clientContext);
    this.createConfigurationCallable =
        callableFactory.createUnaryCallable(
            createConfigurationTransportSettings,
            settings.createConfigurationSettings(),
            clientContext);
    this.createConfigurationOperationCallable =
        callableFactory.createOperationCallable(
            createConfigurationTransportSettings,
            settings.createConfigurationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateConfigurationCallable =
        callableFactory.createUnaryCallable(
            updateConfigurationTransportSettings,
            settings.updateConfigurationSettings(),
            clientContext);
    this.updateConfigurationOperationCallable =
        callableFactory.createOperationCallable(
            updateConfigurationTransportSettings,
            settings.updateConfigurationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteConfigurationCallable =
        callableFactory.createUnaryCallable(
            deleteConfigurationTransportSettings,
            settings.deleteConfigurationSettings(),
            clientContext);
    this.deleteConfigurationOperationCallable =
        callableFactory.createOperationCallable(
            deleteConfigurationTransportSettings,
            settings.deleteConfigurationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.deactivateConfigurationCallable =
        callableFactory.createUnaryCallable(
            deactivateConfigurationTransportSettings,
            settings.deactivateConfigurationSettings(),
            clientContext);
    this.deactivateConfigurationOperationCallable =
        callableFactory.createOperationCallable(
            deactivateConfigurationTransportSettings,
            settings.deactivateConfigurationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.reactivateConfigurationCallable =
        callableFactory.createUnaryCallable(
            reactivateConfigurationTransportSettings,
            settings.reactivateConfigurationSettings(),
            clientContext);
    this.reactivateConfigurationOperationCallable =
        callableFactory.createOperationCallable(
            reactivateConfigurationTransportSettings,
            settings.reactivateConfigurationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.queryConfigurationLicenseUsageCallable =
        callableFactory.createUnaryCallable(
            queryConfigurationLicenseUsageTransportSettings,
            settings.queryConfigurationLicenseUsageSettings(),
            clientContext);
    this.aggregateUsageCallable =
        callableFactory.createUnaryCallable(
            aggregateUsageTransportSettings, settings.aggregateUsageSettings(), clientContext);
    this.aggregateUsagePagedCallable =
        callableFactory.createPagedCallable(
            aggregateUsageTransportSettings, settings.aggregateUsageSettings(), clientContext);
    this.listProductsCallable =
        callableFactory.createUnaryCallable(
            listProductsTransportSettings, settings.listProductsSettings(), clientContext);
    this.listProductsPagedCallable =
        callableFactory.createPagedCallable(
            listProductsTransportSettings, settings.listProductsSettings(), clientContext);
    this.getProductCallable =
        callableFactory.createUnaryCallable(
            getProductTransportSettings, settings.getProductSettings(), clientContext);
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
    methodDescriptors.add(listConfigurationsMethodDescriptor);
    methodDescriptors.add(getConfigurationMethodDescriptor);
    methodDescriptors.add(createConfigurationMethodDescriptor);
    methodDescriptors.add(updateConfigurationMethodDescriptor);
    methodDescriptors.add(deleteConfigurationMethodDescriptor);
    methodDescriptors.add(listInstancesMethodDescriptor);
    methodDescriptors.add(getInstanceMethodDescriptor);
    methodDescriptors.add(deactivateConfigurationMethodDescriptor);
    methodDescriptors.add(reactivateConfigurationMethodDescriptor);
    methodDescriptors.add(queryConfigurationLicenseUsageMethodDescriptor);
    methodDescriptors.add(aggregateUsageMethodDescriptor);
    methodDescriptors.add(listProductsMethodDescriptor);
    methodDescriptors.add(getProductMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListConfigurationsRequest, ListConfigurationsResponse>
      listConfigurationsCallable() {
    return listConfigurationsCallable;
  }

  @Override
  public UnaryCallable<ListConfigurationsRequest, ListConfigurationsPagedResponse>
      listConfigurationsPagedCallable() {
    return listConfigurationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConfigurationRequest, Configuration> getConfigurationCallable() {
    return getConfigurationCallable;
  }

  @Override
  public UnaryCallable<CreateConfigurationRequest, Operation> createConfigurationCallable() {
    return createConfigurationCallable;
  }

  @Override
  public OperationCallable<CreateConfigurationRequest, Configuration, OperationMetadata>
      createConfigurationOperationCallable() {
    return createConfigurationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConfigurationRequest, Operation> updateConfigurationCallable() {
    return updateConfigurationCallable;
  }

  @Override
  public OperationCallable<UpdateConfigurationRequest, Configuration, OperationMetadata>
      updateConfigurationOperationCallable() {
    return updateConfigurationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConfigurationRequest, Operation> deleteConfigurationCallable() {
    return deleteConfigurationCallable;
  }

  @Override
  public OperationCallable<DeleteConfigurationRequest, Empty, OperationMetadata>
      deleteConfigurationOperationCallable() {
    return deleteConfigurationOperationCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<DeactivateConfigurationRequest, Operation>
      deactivateConfigurationCallable() {
    return deactivateConfigurationCallable;
  }

  @Override
  public OperationCallable<DeactivateConfigurationRequest, Configuration, OperationMetadata>
      deactivateConfigurationOperationCallable() {
    return deactivateConfigurationOperationCallable;
  }

  @Override
  public UnaryCallable<ReactivateConfigurationRequest, Operation>
      reactivateConfigurationCallable() {
    return reactivateConfigurationCallable;
  }

  @Override
  public OperationCallable<ReactivateConfigurationRequest, Configuration, OperationMetadata>
      reactivateConfigurationOperationCallable() {
    return reactivateConfigurationOperationCallable;
  }

  @Override
  public UnaryCallable<
          QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
      queryConfigurationLicenseUsageCallable() {
    return queryConfigurationLicenseUsageCallable;
  }

  @Override
  public UnaryCallable<AggregateUsageRequest, AggregateUsageResponse> aggregateUsageCallable() {
    return aggregateUsageCallable;
  }

  @Override
  public UnaryCallable<AggregateUsageRequest, AggregateUsagePagedResponse>
      aggregateUsagePagedCallable() {
    return aggregateUsagePagedCallable;
  }

  @Override
  public UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable() {
    return listProductsCallable;
  }

  @Override
  public UnaryCallable<ListProductsRequest, ListProductsPagedResponse> listProductsPagedCallable() {
    return listProductsPagedCallable;
  }

  @Override
  public UnaryCallable<GetProductRequest, Product> getProductCallable() {
    return getProductCallable;
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
