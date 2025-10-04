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

package com.google.cloud.configdelivery.v1beta.stub;

import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListFleetPackagesPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListLocationsPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListReleasesPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListResourceBundlesPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListRolloutsPagedResponse;
import static com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient.ListVariantsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.configdelivery.v1beta.AbortRolloutRequest;
import com.google.cloud.configdelivery.v1beta.CreateFleetPackageRequest;
import com.google.cloud.configdelivery.v1beta.CreateReleaseRequest;
import com.google.cloud.configdelivery.v1beta.CreateResourceBundleRequest;
import com.google.cloud.configdelivery.v1beta.CreateVariantRequest;
import com.google.cloud.configdelivery.v1beta.DeleteFleetPackageRequest;
import com.google.cloud.configdelivery.v1beta.DeleteReleaseRequest;
import com.google.cloud.configdelivery.v1beta.DeleteResourceBundleRequest;
import com.google.cloud.configdelivery.v1beta.DeleteVariantRequest;
import com.google.cloud.configdelivery.v1beta.FleetPackage;
import com.google.cloud.configdelivery.v1beta.GetFleetPackageRequest;
import com.google.cloud.configdelivery.v1beta.GetReleaseRequest;
import com.google.cloud.configdelivery.v1beta.GetResourceBundleRequest;
import com.google.cloud.configdelivery.v1beta.GetRolloutRequest;
import com.google.cloud.configdelivery.v1beta.GetVariantRequest;
import com.google.cloud.configdelivery.v1beta.ListFleetPackagesRequest;
import com.google.cloud.configdelivery.v1beta.ListFleetPackagesResponse;
import com.google.cloud.configdelivery.v1beta.ListReleasesRequest;
import com.google.cloud.configdelivery.v1beta.ListReleasesResponse;
import com.google.cloud.configdelivery.v1beta.ListResourceBundlesRequest;
import com.google.cloud.configdelivery.v1beta.ListResourceBundlesResponse;
import com.google.cloud.configdelivery.v1beta.ListRolloutsRequest;
import com.google.cloud.configdelivery.v1beta.ListRolloutsResponse;
import com.google.cloud.configdelivery.v1beta.ListVariantsRequest;
import com.google.cloud.configdelivery.v1beta.ListVariantsResponse;
import com.google.cloud.configdelivery.v1beta.OperationMetadata;
import com.google.cloud.configdelivery.v1beta.Release;
import com.google.cloud.configdelivery.v1beta.ResourceBundle;
import com.google.cloud.configdelivery.v1beta.ResumeRolloutRequest;
import com.google.cloud.configdelivery.v1beta.Rollout;
import com.google.cloud.configdelivery.v1beta.SuspendRolloutRequest;
import com.google.cloud.configdelivery.v1beta.UpdateFleetPackageRequest;
import com.google.cloud.configdelivery.v1beta.UpdateReleaseRequest;
import com.google.cloud.configdelivery.v1beta.UpdateResourceBundleRequest;
import com.google.cloud.configdelivery.v1beta.UpdateVariantRequest;
import com.google.cloud.configdelivery.v1beta.Variant;
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
 * REST stub implementation for the ConfigDelivery service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonConfigDeliveryStub extends ConfigDeliveryStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Rollout.getDescriptor())
          .add(Empty.getDescriptor())
          .add(FleetPackage.getDescriptor())
          .add(ResourceBundle.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Variant.getDescriptor())
          .add(Release.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListResourceBundlesRequest, ListResourceBundlesResponse>
      listResourceBundlesMethodDescriptor =
          ApiMethodDescriptor.<ListResourceBundlesRequest, ListResourceBundlesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.configdelivery.v1beta.ConfigDelivery/ListResourceBundles")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListResourceBundlesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/resourceBundles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListResourceBundlesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListResourceBundlesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListResourceBundlesResponse>newBuilder()
                      .setDefaultInstance(ListResourceBundlesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetResourceBundleRequest, ResourceBundle>
      getResourceBundleMethodDescriptor =
          ApiMethodDescriptor.<GetResourceBundleRequest, ResourceBundle>newBuilder()
              .setFullMethodName(
                  "google.cloud.configdelivery.v1beta.ConfigDelivery/GetResourceBundle")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetResourceBundleRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/resourceBundles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetResourceBundleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetResourceBundleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ResourceBundle>newBuilder()
                      .setDefaultInstance(ResourceBundle.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateResourceBundleRequest, Operation>
      createResourceBundleMethodDescriptor =
          ApiMethodDescriptor.<CreateResourceBundleRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.configdelivery.v1beta.ConfigDelivery/CreateResourceBundle")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateResourceBundleRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/resourceBundles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateResourceBundleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateResourceBundleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "resourceBundleId", request.getResourceBundleId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("resourceBundle", request.getResourceBundle(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateResourceBundleRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateResourceBundleRequest, Operation>
      updateResourceBundleMethodDescriptor =
          ApiMethodDescriptor.<UpdateResourceBundleRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.configdelivery.v1beta.ConfigDelivery/UpdateResourceBundle")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateResourceBundleRequest>newBuilder()
                      .setPath(
                          "/v1beta/{resourceBundle.name=projects/*/locations/*/resourceBundles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateResourceBundleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "resourceBundle.name",
                                request.getResourceBundle().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateResourceBundleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("resourceBundle", request.getResourceBundle(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateResourceBundleRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteResourceBundleRequest, Operation>
      deleteResourceBundleMethodDescriptor =
          ApiMethodDescriptor.<DeleteResourceBundleRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.configdelivery.v1beta.ConfigDelivery/DeleteResourceBundle")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteResourceBundleRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/resourceBundles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteResourceBundleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteResourceBundleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteResourceBundleRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListFleetPackagesRequest, ListFleetPackagesResponse>
      listFleetPackagesMethodDescriptor =
          ApiMethodDescriptor.<ListFleetPackagesRequest, ListFleetPackagesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.configdelivery.v1beta.ConfigDelivery/ListFleetPackages")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFleetPackagesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/fleetPackages",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFleetPackagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFleetPackagesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListFleetPackagesResponse>newBuilder()
                      .setDefaultInstance(ListFleetPackagesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFleetPackageRequest, FleetPackage>
      getFleetPackageMethodDescriptor =
          ApiMethodDescriptor.<GetFleetPackageRequest, FleetPackage>newBuilder()
              .setFullMethodName(
                  "google.cloud.configdelivery.v1beta.ConfigDelivery/GetFleetPackage")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFleetPackageRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/fleetPackages/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFleetPackageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFleetPackageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FleetPackage>newBuilder()
                      .setDefaultInstance(FleetPackage.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateFleetPackageRequest, Operation>
      createFleetPackageMethodDescriptor =
          ApiMethodDescriptor.<CreateFleetPackageRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.configdelivery.v1beta.ConfigDelivery/CreateFleetPackage")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFleetPackageRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/fleetPackages",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFleetPackageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFleetPackageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "fleetPackageId", request.getFleetPackageId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("fleetPackage", request.getFleetPackage(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateFleetPackageRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateFleetPackageRequest, Operation>
      updateFleetPackageMethodDescriptor =
          ApiMethodDescriptor.<UpdateFleetPackageRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.configdelivery.v1beta.ConfigDelivery/UpdateFleetPackage")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFleetPackageRequest>newBuilder()
                      .setPath(
                          "/v1beta/{fleetPackage.name=projects/*/locations/*/fleetPackages/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFleetPackageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "fleetPackage.name", request.getFleetPackage().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFleetPackageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("fleetPackage", request.getFleetPackage(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateFleetPackageRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteFleetPackageRequest, Operation>
      deleteFleetPackageMethodDescriptor =
          ApiMethodDescriptor.<DeleteFleetPackageRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.configdelivery.v1beta.ConfigDelivery/DeleteFleetPackage")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFleetPackageRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/fleetPackages/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFleetPackageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFleetPackageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteFleetPackageRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListReleasesRequest, ListReleasesResponse>
      listReleasesMethodDescriptor =
          ApiMethodDescriptor.<ListReleasesRequest, ListReleasesResponse>newBuilder()
              .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/ListReleases")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReleasesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/resourceBundles/*}/releases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReleasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReleasesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListReleasesResponse>newBuilder()
                      .setDefaultInstance(ListReleasesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReleaseRequest, Release> getReleaseMethodDescriptor =
      ApiMethodDescriptor.<GetReleaseRequest, Release>newBuilder()
          .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/GetRelease")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetReleaseRequest>newBuilder()
                  .setPath(
                      "/v1beta/{name=projects/*/locations/*/resourceBundles/*/releases/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetReleaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetReleaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Release>newBuilder()
                  .setDefaultInstance(Release.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateReleaseRequest, Operation>
      createReleaseMethodDescriptor =
          ApiMethodDescriptor.<CreateReleaseRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/CreateRelease")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReleaseRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/resourceBundles/*}/releases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "releaseId", request.getReleaseId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("release", request.getRelease(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateReleaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateReleaseRequest, Operation>
      updateReleaseMethodDescriptor =
          ApiMethodDescriptor.<UpdateReleaseRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/UpdateRelease")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateReleaseRequest>newBuilder()
                      .setPath(
                          "/v1beta/{release.name=projects/*/locations/*/resourceBundles/*/releases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "release.name", request.getRelease().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("release", request.getRelease(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateReleaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteReleaseRequest, Operation>
      deleteReleaseMethodDescriptor =
          ApiMethodDescriptor.<DeleteReleaseRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/DeleteRelease")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteReleaseRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/resourceBundles/*/releases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReleaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteReleaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListVariantsRequest, ListVariantsResponse>
      listVariantsMethodDescriptor =
          ApiMethodDescriptor.<ListVariantsRequest, ListVariantsResponse>newBuilder()
              .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/ListVariants")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListVariantsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/resourceBundles/*/releases/*}/variants",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListVariantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListVariantsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListVariantsResponse>newBuilder()
                      .setDefaultInstance(ListVariantsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetVariantRequest, Variant> getVariantMethodDescriptor =
      ApiMethodDescriptor.<GetVariantRequest, Variant>newBuilder()
          .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/GetVariant")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetVariantRequest>newBuilder()
                  .setPath(
                      "/v1beta/{name=projects/*/locations/*/resourceBundles/*/releases/*/variants/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetVariantRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetVariantRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Variant>newBuilder()
                  .setDefaultInstance(Variant.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateVariantRequest, Operation>
      createVariantMethodDescriptor =
          ApiMethodDescriptor.<CreateVariantRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/CreateVariant")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateVariantRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/resourceBundles/*/releases/*}/variants",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateVariantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateVariantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "variantId", request.getVariantId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("variant", request.getVariant(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateVariantRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateVariantRequest, Operation>
      updateVariantMethodDescriptor =
          ApiMethodDescriptor.<UpdateVariantRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/UpdateVariant")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateVariantRequest>newBuilder()
                      .setPath(
                          "/v1beta/{variant.name=projects/*/locations/*/resourceBundles/*/releases/*/variants/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateVariantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "variant.name", request.getVariant().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateVariantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("variant", request.getVariant(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateVariantRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteVariantRequest, Operation>
      deleteVariantMethodDescriptor =
          ApiMethodDescriptor.<DeleteVariantRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/DeleteVariant")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteVariantRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/resourceBundles/*/releases/*/variants/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteVariantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteVariantRequest> serializer =
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
                  (DeleteVariantRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListRolloutsRequest, ListRolloutsResponse>
      listRolloutsMethodDescriptor =
          ApiMethodDescriptor.<ListRolloutsRequest, ListRolloutsResponse>newBuilder()
              .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/ListRollouts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRolloutsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/fleetPackages/*}/rollouts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRolloutsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRolloutsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListRolloutsResponse>newBuilder()
                      .setDefaultInstance(ListRolloutsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRolloutRequest, Rollout> getRolloutMethodDescriptor =
      ApiMethodDescriptor.<GetRolloutRequest, Rollout>newBuilder()
          .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/GetRollout")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRolloutRequest>newBuilder()
                  .setPath(
                      "/v1beta/{name=projects/*/locations/*/fleetPackages/*/rollouts/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRolloutRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRolloutRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Rollout>newBuilder()
                  .setDefaultInstance(Rollout.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<SuspendRolloutRequest, Operation>
      suspendRolloutMethodDescriptor =
          ApiMethodDescriptor.<SuspendRolloutRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/SuspendRollout")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SuspendRolloutRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/fleetPackages/*/rollouts/*}:suspend",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SuspendRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SuspendRolloutRequest> serializer =
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
                  (SuspendRolloutRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ResumeRolloutRequest, Operation>
      resumeRolloutMethodDescriptor =
          ApiMethodDescriptor.<ResumeRolloutRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/ResumeRollout")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResumeRolloutRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/fleetPackages/*/rollouts/*}:resume",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResumeRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResumeRolloutRequest> serializer =
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
                  (ResumeRolloutRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<AbortRolloutRequest, Operation>
      abortRolloutMethodDescriptor =
          ApiMethodDescriptor.<AbortRolloutRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.configdelivery.v1beta.ConfigDelivery/AbortRollout")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AbortRolloutRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/fleetPackages/*/rollouts/*}:abort",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AbortRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AbortRolloutRequest> serializer =
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
                  (AbortRolloutRequest request, Operation response) ->
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
                          "/v1beta/{name=projects/*}/locations",
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
                          "/v1beta/{name=projects/*/locations/*}",
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

  private final UnaryCallable<ListResourceBundlesRequest, ListResourceBundlesResponse>
      listResourceBundlesCallable;
  private final UnaryCallable<ListResourceBundlesRequest, ListResourceBundlesPagedResponse>
      listResourceBundlesPagedCallable;
  private final UnaryCallable<GetResourceBundleRequest, ResourceBundle> getResourceBundleCallable;
  private final UnaryCallable<CreateResourceBundleRequest, Operation> createResourceBundleCallable;
  private final OperationCallable<CreateResourceBundleRequest, ResourceBundle, OperationMetadata>
      createResourceBundleOperationCallable;
  private final UnaryCallable<UpdateResourceBundleRequest, Operation> updateResourceBundleCallable;
  private final OperationCallable<UpdateResourceBundleRequest, ResourceBundle, OperationMetadata>
      updateResourceBundleOperationCallable;
  private final UnaryCallable<DeleteResourceBundleRequest, Operation> deleteResourceBundleCallable;
  private final OperationCallable<DeleteResourceBundleRequest, Empty, OperationMetadata>
      deleteResourceBundleOperationCallable;
  private final UnaryCallable<ListFleetPackagesRequest, ListFleetPackagesResponse>
      listFleetPackagesCallable;
  private final UnaryCallable<ListFleetPackagesRequest, ListFleetPackagesPagedResponse>
      listFleetPackagesPagedCallable;
  private final UnaryCallable<GetFleetPackageRequest, FleetPackage> getFleetPackageCallable;
  private final UnaryCallable<CreateFleetPackageRequest, Operation> createFleetPackageCallable;
  private final OperationCallable<CreateFleetPackageRequest, FleetPackage, OperationMetadata>
      createFleetPackageOperationCallable;
  private final UnaryCallable<UpdateFleetPackageRequest, Operation> updateFleetPackageCallable;
  private final OperationCallable<UpdateFleetPackageRequest, FleetPackage, OperationMetadata>
      updateFleetPackageOperationCallable;
  private final UnaryCallable<DeleteFleetPackageRequest, Operation> deleteFleetPackageCallable;
  private final OperationCallable<DeleteFleetPackageRequest, Empty, OperationMetadata>
      deleteFleetPackageOperationCallable;
  private final UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable;
  private final UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse>
      listReleasesPagedCallable;
  private final UnaryCallable<GetReleaseRequest, Release> getReleaseCallable;
  private final UnaryCallable<CreateReleaseRequest, Operation> createReleaseCallable;
  private final OperationCallable<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationCallable;
  private final UnaryCallable<UpdateReleaseRequest, Operation> updateReleaseCallable;
  private final OperationCallable<UpdateReleaseRequest, Release, OperationMetadata>
      updateReleaseOperationCallable;
  private final UnaryCallable<DeleteReleaseRequest, Operation> deleteReleaseCallable;
  private final OperationCallable<DeleteReleaseRequest, Empty, OperationMetadata>
      deleteReleaseOperationCallable;
  private final UnaryCallable<ListVariantsRequest, ListVariantsResponse> listVariantsCallable;
  private final UnaryCallable<ListVariantsRequest, ListVariantsPagedResponse>
      listVariantsPagedCallable;
  private final UnaryCallable<GetVariantRequest, Variant> getVariantCallable;
  private final UnaryCallable<CreateVariantRequest, Operation> createVariantCallable;
  private final OperationCallable<CreateVariantRequest, Variant, OperationMetadata>
      createVariantOperationCallable;
  private final UnaryCallable<UpdateVariantRequest, Operation> updateVariantCallable;
  private final OperationCallable<UpdateVariantRequest, Variant, OperationMetadata>
      updateVariantOperationCallable;
  private final UnaryCallable<DeleteVariantRequest, Operation> deleteVariantCallable;
  private final OperationCallable<DeleteVariantRequest, Empty, OperationMetadata>
      deleteVariantOperationCallable;
  private final UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable;
  private final UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse>
      listRolloutsPagedCallable;
  private final UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable;
  private final UnaryCallable<SuspendRolloutRequest, Operation> suspendRolloutCallable;
  private final OperationCallable<SuspendRolloutRequest, Rollout, OperationMetadata>
      suspendRolloutOperationCallable;
  private final UnaryCallable<ResumeRolloutRequest, Operation> resumeRolloutCallable;
  private final OperationCallable<ResumeRolloutRequest, Rollout, OperationMetadata>
      resumeRolloutOperationCallable;
  private final UnaryCallable<AbortRolloutRequest, Operation> abortRolloutCallable;
  private final OperationCallable<AbortRolloutRequest, Rollout, OperationMetadata>
      abortRolloutOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonConfigDeliveryStub create(ConfigDeliveryStubSettings settings)
      throws IOException {
    return new HttpJsonConfigDeliveryStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonConfigDeliveryStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonConfigDeliveryStub(
        ConfigDeliveryStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonConfigDeliveryStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonConfigDeliveryStub(
        ConfigDeliveryStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonConfigDeliveryStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConfigDeliveryStub(
      ConfigDeliveryStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonConfigDeliveryCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonConfigDeliveryStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConfigDeliveryStub(
      ConfigDeliveryStubSettings settings,
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
                        .setPost("/v1beta/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1beta/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1beta/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1beta/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListResourceBundlesRequest, ListResourceBundlesResponse>
        listResourceBundlesTransportSettings =
            HttpJsonCallSettings
                .<ListResourceBundlesRequest, ListResourceBundlesResponse>newBuilder()
                .setMethodDescriptor(listResourceBundlesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetResourceBundleRequest, ResourceBundle>
        getResourceBundleTransportSettings =
            HttpJsonCallSettings.<GetResourceBundleRequest, ResourceBundle>newBuilder()
                .setMethodDescriptor(getResourceBundleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateResourceBundleRequest, Operation>
        createResourceBundleTransportSettings =
            HttpJsonCallSettings.<CreateResourceBundleRequest, Operation>newBuilder()
                .setMethodDescriptor(createResourceBundleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateResourceBundleRequest, Operation>
        updateResourceBundleTransportSettings =
            HttpJsonCallSettings.<UpdateResourceBundleRequest, Operation>newBuilder()
                .setMethodDescriptor(updateResourceBundleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "resource_bundle.name",
                          String.valueOf(request.getResourceBundle().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteResourceBundleRequest, Operation>
        deleteResourceBundleTransportSettings =
            HttpJsonCallSettings.<DeleteResourceBundleRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteResourceBundleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListFleetPackagesRequest, ListFleetPackagesResponse>
        listFleetPackagesTransportSettings =
            HttpJsonCallSettings.<ListFleetPackagesRequest, ListFleetPackagesResponse>newBuilder()
                .setMethodDescriptor(listFleetPackagesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetFleetPackageRequest, FleetPackage> getFleetPackageTransportSettings =
        HttpJsonCallSettings.<GetFleetPackageRequest, FleetPackage>newBuilder()
            .setMethodDescriptor(getFleetPackageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateFleetPackageRequest, Operation> createFleetPackageTransportSettings =
        HttpJsonCallSettings.<CreateFleetPackageRequest, Operation>newBuilder()
            .setMethodDescriptor(createFleetPackageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateFleetPackageRequest, Operation> updateFleetPackageTransportSettings =
        HttpJsonCallSettings.<UpdateFleetPackageRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFleetPackageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "fleet_package.name", String.valueOf(request.getFleetPackage().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteFleetPackageRequest, Operation> deleteFleetPackageTransportSettings =
        HttpJsonCallSettings.<DeleteFleetPackageRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFleetPackageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListReleasesRequest, ListReleasesResponse> listReleasesTransportSettings =
        HttpJsonCallSettings.<ListReleasesRequest, ListReleasesResponse>newBuilder()
            .setMethodDescriptor(listReleasesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetReleaseRequest, Release> getReleaseTransportSettings =
        HttpJsonCallSettings.<GetReleaseRequest, Release>newBuilder()
            .setMethodDescriptor(getReleaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateReleaseRequest, Operation> createReleaseTransportSettings =
        HttpJsonCallSettings.<CreateReleaseRequest, Operation>newBuilder()
            .setMethodDescriptor(createReleaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateReleaseRequest, Operation> updateReleaseTransportSettings =
        HttpJsonCallSettings.<UpdateReleaseRequest, Operation>newBuilder()
            .setMethodDescriptor(updateReleaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("release.name", String.valueOf(request.getRelease().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteReleaseRequest, Operation> deleteReleaseTransportSettings =
        HttpJsonCallSettings.<DeleteReleaseRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteReleaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListVariantsRequest, ListVariantsResponse> listVariantsTransportSettings =
        HttpJsonCallSettings.<ListVariantsRequest, ListVariantsResponse>newBuilder()
            .setMethodDescriptor(listVariantsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetVariantRequest, Variant> getVariantTransportSettings =
        HttpJsonCallSettings.<GetVariantRequest, Variant>newBuilder()
            .setMethodDescriptor(getVariantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateVariantRequest, Operation> createVariantTransportSettings =
        HttpJsonCallSettings.<CreateVariantRequest, Operation>newBuilder()
            .setMethodDescriptor(createVariantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateVariantRequest, Operation> updateVariantTransportSettings =
        HttpJsonCallSettings.<UpdateVariantRequest, Operation>newBuilder()
            .setMethodDescriptor(updateVariantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("variant.name", String.valueOf(request.getVariant().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteVariantRequest, Operation> deleteVariantTransportSettings =
        HttpJsonCallSettings.<DeleteVariantRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteVariantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListRolloutsRequest, ListRolloutsResponse> listRolloutsTransportSettings =
        HttpJsonCallSettings.<ListRolloutsRequest, ListRolloutsResponse>newBuilder()
            .setMethodDescriptor(listRolloutsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetRolloutRequest, Rollout> getRolloutTransportSettings =
        HttpJsonCallSettings.<GetRolloutRequest, Rollout>newBuilder()
            .setMethodDescriptor(getRolloutMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SuspendRolloutRequest, Operation> suspendRolloutTransportSettings =
        HttpJsonCallSettings.<SuspendRolloutRequest, Operation>newBuilder()
            .setMethodDescriptor(suspendRolloutMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ResumeRolloutRequest, Operation> resumeRolloutTransportSettings =
        HttpJsonCallSettings.<ResumeRolloutRequest, Operation>newBuilder()
            .setMethodDescriptor(resumeRolloutMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<AbortRolloutRequest, Operation> abortRolloutTransportSettings =
        HttpJsonCallSettings.<AbortRolloutRequest, Operation>newBuilder()
            .setMethodDescriptor(abortRolloutMethodDescriptor)
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

    this.listResourceBundlesCallable =
        callableFactory.createUnaryCallable(
            listResourceBundlesTransportSettings,
            settings.listResourceBundlesSettings(),
            clientContext);
    this.listResourceBundlesPagedCallable =
        callableFactory.createPagedCallable(
            listResourceBundlesTransportSettings,
            settings.listResourceBundlesSettings(),
            clientContext);
    this.getResourceBundleCallable =
        callableFactory.createUnaryCallable(
            getResourceBundleTransportSettings,
            settings.getResourceBundleSettings(),
            clientContext);
    this.createResourceBundleCallable =
        callableFactory.createUnaryCallable(
            createResourceBundleTransportSettings,
            settings.createResourceBundleSettings(),
            clientContext);
    this.createResourceBundleOperationCallable =
        callableFactory.createOperationCallable(
            createResourceBundleTransportSettings,
            settings.createResourceBundleOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateResourceBundleCallable =
        callableFactory.createUnaryCallable(
            updateResourceBundleTransportSettings,
            settings.updateResourceBundleSettings(),
            clientContext);
    this.updateResourceBundleOperationCallable =
        callableFactory.createOperationCallable(
            updateResourceBundleTransportSettings,
            settings.updateResourceBundleOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteResourceBundleCallable =
        callableFactory.createUnaryCallable(
            deleteResourceBundleTransportSettings,
            settings.deleteResourceBundleSettings(),
            clientContext);
    this.deleteResourceBundleOperationCallable =
        callableFactory.createOperationCallable(
            deleteResourceBundleTransportSettings,
            settings.deleteResourceBundleOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listFleetPackagesCallable =
        callableFactory.createUnaryCallable(
            listFleetPackagesTransportSettings,
            settings.listFleetPackagesSettings(),
            clientContext);
    this.listFleetPackagesPagedCallable =
        callableFactory.createPagedCallable(
            listFleetPackagesTransportSettings,
            settings.listFleetPackagesSettings(),
            clientContext);
    this.getFleetPackageCallable =
        callableFactory.createUnaryCallable(
            getFleetPackageTransportSettings, settings.getFleetPackageSettings(), clientContext);
    this.createFleetPackageCallable =
        callableFactory.createUnaryCallable(
            createFleetPackageTransportSettings,
            settings.createFleetPackageSettings(),
            clientContext);
    this.createFleetPackageOperationCallable =
        callableFactory.createOperationCallable(
            createFleetPackageTransportSettings,
            settings.createFleetPackageOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateFleetPackageCallable =
        callableFactory.createUnaryCallable(
            updateFleetPackageTransportSettings,
            settings.updateFleetPackageSettings(),
            clientContext);
    this.updateFleetPackageOperationCallable =
        callableFactory.createOperationCallable(
            updateFleetPackageTransportSettings,
            settings.updateFleetPackageOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteFleetPackageCallable =
        callableFactory.createUnaryCallable(
            deleteFleetPackageTransportSettings,
            settings.deleteFleetPackageSettings(),
            clientContext);
    this.deleteFleetPackageOperationCallable =
        callableFactory.createOperationCallable(
            deleteFleetPackageTransportSettings,
            settings.deleteFleetPackageOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listReleasesCallable =
        callableFactory.createUnaryCallable(
            listReleasesTransportSettings, settings.listReleasesSettings(), clientContext);
    this.listReleasesPagedCallable =
        callableFactory.createPagedCallable(
            listReleasesTransportSettings, settings.listReleasesSettings(), clientContext);
    this.getReleaseCallable =
        callableFactory.createUnaryCallable(
            getReleaseTransportSettings, settings.getReleaseSettings(), clientContext);
    this.createReleaseCallable =
        callableFactory.createUnaryCallable(
            createReleaseTransportSettings, settings.createReleaseSettings(), clientContext);
    this.createReleaseOperationCallable =
        callableFactory.createOperationCallable(
            createReleaseTransportSettings,
            settings.createReleaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateReleaseCallable =
        callableFactory.createUnaryCallable(
            updateReleaseTransportSettings, settings.updateReleaseSettings(), clientContext);
    this.updateReleaseOperationCallable =
        callableFactory.createOperationCallable(
            updateReleaseTransportSettings,
            settings.updateReleaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteReleaseCallable =
        callableFactory.createUnaryCallable(
            deleteReleaseTransportSettings, settings.deleteReleaseSettings(), clientContext);
    this.deleteReleaseOperationCallable =
        callableFactory.createOperationCallable(
            deleteReleaseTransportSettings,
            settings.deleteReleaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listVariantsCallable =
        callableFactory.createUnaryCallable(
            listVariantsTransportSettings, settings.listVariantsSettings(), clientContext);
    this.listVariantsPagedCallable =
        callableFactory.createPagedCallable(
            listVariantsTransportSettings, settings.listVariantsSettings(), clientContext);
    this.getVariantCallable =
        callableFactory.createUnaryCallable(
            getVariantTransportSettings, settings.getVariantSettings(), clientContext);
    this.createVariantCallable =
        callableFactory.createUnaryCallable(
            createVariantTransportSettings, settings.createVariantSettings(), clientContext);
    this.createVariantOperationCallable =
        callableFactory.createOperationCallable(
            createVariantTransportSettings,
            settings.createVariantOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateVariantCallable =
        callableFactory.createUnaryCallable(
            updateVariantTransportSettings, settings.updateVariantSettings(), clientContext);
    this.updateVariantOperationCallable =
        callableFactory.createOperationCallable(
            updateVariantTransportSettings,
            settings.updateVariantOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteVariantCallable =
        callableFactory.createUnaryCallable(
            deleteVariantTransportSettings, settings.deleteVariantSettings(), clientContext);
    this.deleteVariantOperationCallable =
        callableFactory.createOperationCallable(
            deleteVariantTransportSettings,
            settings.deleteVariantOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listRolloutsCallable =
        callableFactory.createUnaryCallable(
            listRolloutsTransportSettings, settings.listRolloutsSettings(), clientContext);
    this.listRolloutsPagedCallable =
        callableFactory.createPagedCallable(
            listRolloutsTransportSettings, settings.listRolloutsSettings(), clientContext);
    this.getRolloutCallable =
        callableFactory.createUnaryCallable(
            getRolloutTransportSettings, settings.getRolloutSettings(), clientContext);
    this.suspendRolloutCallable =
        callableFactory.createUnaryCallable(
            suspendRolloutTransportSettings, settings.suspendRolloutSettings(), clientContext);
    this.suspendRolloutOperationCallable =
        callableFactory.createOperationCallable(
            suspendRolloutTransportSettings,
            settings.suspendRolloutOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.resumeRolloutCallable =
        callableFactory.createUnaryCallable(
            resumeRolloutTransportSettings, settings.resumeRolloutSettings(), clientContext);
    this.resumeRolloutOperationCallable =
        callableFactory.createOperationCallable(
            resumeRolloutTransportSettings,
            settings.resumeRolloutOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.abortRolloutCallable =
        callableFactory.createUnaryCallable(
            abortRolloutTransportSettings, settings.abortRolloutSettings(), clientContext);
    this.abortRolloutOperationCallable =
        callableFactory.createOperationCallable(
            abortRolloutTransportSettings,
            settings.abortRolloutOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    methodDescriptors.add(listResourceBundlesMethodDescriptor);
    methodDescriptors.add(getResourceBundleMethodDescriptor);
    methodDescriptors.add(createResourceBundleMethodDescriptor);
    methodDescriptors.add(updateResourceBundleMethodDescriptor);
    methodDescriptors.add(deleteResourceBundleMethodDescriptor);
    methodDescriptors.add(listFleetPackagesMethodDescriptor);
    methodDescriptors.add(getFleetPackageMethodDescriptor);
    methodDescriptors.add(createFleetPackageMethodDescriptor);
    methodDescriptors.add(updateFleetPackageMethodDescriptor);
    methodDescriptors.add(deleteFleetPackageMethodDescriptor);
    methodDescriptors.add(listReleasesMethodDescriptor);
    methodDescriptors.add(getReleaseMethodDescriptor);
    methodDescriptors.add(createReleaseMethodDescriptor);
    methodDescriptors.add(updateReleaseMethodDescriptor);
    methodDescriptors.add(deleteReleaseMethodDescriptor);
    methodDescriptors.add(listVariantsMethodDescriptor);
    methodDescriptors.add(getVariantMethodDescriptor);
    methodDescriptors.add(createVariantMethodDescriptor);
    methodDescriptors.add(updateVariantMethodDescriptor);
    methodDescriptors.add(deleteVariantMethodDescriptor);
    methodDescriptors.add(listRolloutsMethodDescriptor);
    methodDescriptors.add(getRolloutMethodDescriptor);
    methodDescriptors.add(suspendRolloutMethodDescriptor);
    methodDescriptors.add(resumeRolloutMethodDescriptor);
    methodDescriptors.add(abortRolloutMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListResourceBundlesRequest, ListResourceBundlesResponse>
      listResourceBundlesCallable() {
    return listResourceBundlesCallable;
  }

  @Override
  public UnaryCallable<ListResourceBundlesRequest, ListResourceBundlesPagedResponse>
      listResourceBundlesPagedCallable() {
    return listResourceBundlesPagedCallable;
  }

  @Override
  public UnaryCallable<GetResourceBundleRequest, ResourceBundle> getResourceBundleCallable() {
    return getResourceBundleCallable;
  }

  @Override
  public UnaryCallable<CreateResourceBundleRequest, Operation> createResourceBundleCallable() {
    return createResourceBundleCallable;
  }

  @Override
  public OperationCallable<CreateResourceBundleRequest, ResourceBundle, OperationMetadata>
      createResourceBundleOperationCallable() {
    return createResourceBundleOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateResourceBundleRequest, Operation> updateResourceBundleCallable() {
    return updateResourceBundleCallable;
  }

  @Override
  public OperationCallable<UpdateResourceBundleRequest, ResourceBundle, OperationMetadata>
      updateResourceBundleOperationCallable() {
    return updateResourceBundleOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteResourceBundleRequest, Operation> deleteResourceBundleCallable() {
    return deleteResourceBundleCallable;
  }

  @Override
  public OperationCallable<DeleteResourceBundleRequest, Empty, OperationMetadata>
      deleteResourceBundleOperationCallable() {
    return deleteResourceBundleOperationCallable;
  }

  @Override
  public UnaryCallable<ListFleetPackagesRequest, ListFleetPackagesResponse>
      listFleetPackagesCallable() {
    return listFleetPackagesCallable;
  }

  @Override
  public UnaryCallable<ListFleetPackagesRequest, ListFleetPackagesPagedResponse>
      listFleetPackagesPagedCallable() {
    return listFleetPackagesPagedCallable;
  }

  @Override
  public UnaryCallable<GetFleetPackageRequest, FleetPackage> getFleetPackageCallable() {
    return getFleetPackageCallable;
  }

  @Override
  public UnaryCallable<CreateFleetPackageRequest, Operation> createFleetPackageCallable() {
    return createFleetPackageCallable;
  }

  @Override
  public OperationCallable<CreateFleetPackageRequest, FleetPackage, OperationMetadata>
      createFleetPackageOperationCallable() {
    return createFleetPackageOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFleetPackageRequest, Operation> updateFleetPackageCallable() {
    return updateFleetPackageCallable;
  }

  @Override
  public OperationCallable<UpdateFleetPackageRequest, FleetPackage, OperationMetadata>
      updateFleetPackageOperationCallable() {
    return updateFleetPackageOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFleetPackageRequest, Operation> deleteFleetPackageCallable() {
    return deleteFleetPackageCallable;
  }

  @Override
  public OperationCallable<DeleteFleetPackageRequest, Empty, OperationMetadata>
      deleteFleetPackageOperationCallable() {
    return deleteFleetPackageOperationCallable;
  }

  @Override
  public UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable() {
    return listReleasesCallable;
  }

  @Override
  public UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse> listReleasesPagedCallable() {
    return listReleasesPagedCallable;
  }

  @Override
  public UnaryCallable<GetReleaseRequest, Release> getReleaseCallable() {
    return getReleaseCallable;
  }

  @Override
  public UnaryCallable<CreateReleaseRequest, Operation> createReleaseCallable() {
    return createReleaseCallable;
  }

  @Override
  public OperationCallable<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationCallable() {
    return createReleaseOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateReleaseRequest, Operation> updateReleaseCallable() {
    return updateReleaseCallable;
  }

  @Override
  public OperationCallable<UpdateReleaseRequest, Release, OperationMetadata>
      updateReleaseOperationCallable() {
    return updateReleaseOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteReleaseRequest, Operation> deleteReleaseCallable() {
    return deleteReleaseCallable;
  }

  @Override
  public OperationCallable<DeleteReleaseRequest, Empty, OperationMetadata>
      deleteReleaseOperationCallable() {
    return deleteReleaseOperationCallable;
  }

  @Override
  public UnaryCallable<ListVariantsRequest, ListVariantsResponse> listVariantsCallable() {
    return listVariantsCallable;
  }

  @Override
  public UnaryCallable<ListVariantsRequest, ListVariantsPagedResponse> listVariantsPagedCallable() {
    return listVariantsPagedCallable;
  }

  @Override
  public UnaryCallable<GetVariantRequest, Variant> getVariantCallable() {
    return getVariantCallable;
  }

  @Override
  public UnaryCallable<CreateVariantRequest, Operation> createVariantCallable() {
    return createVariantCallable;
  }

  @Override
  public OperationCallable<CreateVariantRequest, Variant, OperationMetadata>
      createVariantOperationCallable() {
    return createVariantOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateVariantRequest, Operation> updateVariantCallable() {
    return updateVariantCallable;
  }

  @Override
  public OperationCallable<UpdateVariantRequest, Variant, OperationMetadata>
      updateVariantOperationCallable() {
    return updateVariantOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteVariantRequest, Operation> deleteVariantCallable() {
    return deleteVariantCallable;
  }

  @Override
  public OperationCallable<DeleteVariantRequest, Empty, OperationMetadata>
      deleteVariantOperationCallable() {
    return deleteVariantOperationCallable;
  }

  @Override
  public UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable() {
    return listRolloutsCallable;
  }

  @Override
  public UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse> listRolloutsPagedCallable() {
    return listRolloutsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable() {
    return getRolloutCallable;
  }

  @Override
  public UnaryCallable<SuspendRolloutRequest, Operation> suspendRolloutCallable() {
    return suspendRolloutCallable;
  }

  @Override
  public OperationCallable<SuspendRolloutRequest, Rollout, OperationMetadata>
      suspendRolloutOperationCallable() {
    return suspendRolloutOperationCallable;
  }

  @Override
  public UnaryCallable<ResumeRolloutRequest, Operation> resumeRolloutCallable() {
    return resumeRolloutCallable;
  }

  @Override
  public OperationCallable<ResumeRolloutRequest, Rollout, OperationMetadata>
      resumeRolloutOperationCallable() {
    return resumeRolloutOperationCallable;
  }

  @Override
  public UnaryCallable<AbortRolloutRequest, Operation> abortRolloutCallable() {
    return abortRolloutCallable;
  }

  @Override
  public OperationCallable<AbortRolloutRequest, Rollout, OperationMetadata>
      abortRolloutOperationCallable() {
    return abortRolloutOperationCallable;
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
