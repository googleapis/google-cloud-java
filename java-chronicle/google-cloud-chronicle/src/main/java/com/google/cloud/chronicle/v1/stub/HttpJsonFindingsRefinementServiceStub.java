/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.FindingsRefinementServiceClient.ListAllFindingsRefinementDeploymentsPagedResponse;
import static com.google.cloud.chronicle.v1.FindingsRefinementServiceClient.ListFindingsRefinementsPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest;
import com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse;
import com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest;
import com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse;
import com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest;
import com.google.cloud.chronicle.v1.FindingsRefinement;
import com.google.cloud.chronicle.v1.FindingsRefinementDeployment;
import com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest;
import com.google.cloud.chronicle.v1.GetFindingsRefinementRequest;
import com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest;
import com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse;
import com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest;
import com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse;
import com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest;
import com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest;
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
 * REST stub implementation for the FindingsRefinementService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonFindingsRefinementServiceStub extends FindingsRefinementServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetFindingsRefinementRequest, FindingsRefinement>
      getFindingsRefinementMethodDescriptor =
          ApiMethodDescriptor.<GetFindingsRefinementRequest, FindingsRefinement>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/GetFindingsRefinement")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFindingsRefinementRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/findingsRefinements/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFindingsRefinementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFindingsRefinementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FindingsRefinement>newBuilder()
                      .setDefaultInstance(FindingsRefinement.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>
      listFindingsRefinementsMethodDescriptor =
          ApiMethodDescriptor
              .<ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/ListFindingsRefinements")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFindingsRefinementsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/findingsRefinements",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFindingsRefinementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFindingsRefinementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFindingsRefinementsResponse>newBuilder()
                      .setDefaultInstance(ListFindingsRefinementsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateFindingsRefinementRequest, FindingsRefinement>
      createFindingsRefinementMethodDescriptor =
          ApiMethodDescriptor.<CreateFindingsRefinementRequest, FindingsRefinement>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/CreateFindingsRefinement")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFindingsRefinementRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/findingsRefinements",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFindingsRefinementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFindingsRefinementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "findingsRefinement", request.getFindingsRefinement(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FindingsRefinement>newBuilder()
                      .setDefaultInstance(FindingsRefinement.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateFindingsRefinementRequest, FindingsRefinement>
      updateFindingsRefinementMethodDescriptor =
          ApiMethodDescriptor.<UpdateFindingsRefinementRequest, FindingsRefinement>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/UpdateFindingsRefinement")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFindingsRefinementRequest>newBuilder()
                      .setPath(
                          "/v1/{findingsRefinement.name=projects/*/locations/*/instances/*/findingsRefinements/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFindingsRefinementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "findingsRefinement.name",
                                request.getFindingsRefinement().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFindingsRefinementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "findingsRefinement", request.getFindingsRefinement(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FindingsRefinement>newBuilder()
                      .setDefaultInstance(FindingsRefinement.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      getFindingsRefinementDeploymentMethodDescriptor =
          ApiMethodDescriptor
              .<GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/GetFindingsRefinementDeployment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFindingsRefinementDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/findingsRefinements/*/deployment}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFindingsRefinementDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFindingsRefinementDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FindingsRefinementDeployment>newBuilder()
                      .setDefaultInstance(FindingsRefinementDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      updateFindingsRefinementDeploymentMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/UpdateFindingsRefinementDeployment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdateFindingsRefinementDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{findingsRefinementDeployment.name=projects/*/locations/*/instances/*/findingsRefinements/*/deployment}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFindingsRefinementDeploymentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "findingsRefinementDeployment.name",
                                request.getFindingsRefinementDeployment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFindingsRefinementDeploymentRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "findingsRefinementDeployment",
                                      request.getFindingsRefinementDeployment(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FindingsRefinementDeployment>newBuilder()
                      .setDefaultInstance(FindingsRefinementDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAllFindingsRefinementDeploymentsRequest, ListAllFindingsRefinementDeploymentsResponse>
      listAllFindingsRefinementDeploymentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAllFindingsRefinementDeploymentsRequest,
                  ListAllFindingsRefinementDeploymentsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/ListAllFindingsRefinementDeployments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListAllFindingsRefinementDeploymentsRequest>newBuilder()
                      .setPath(
                          "/v1/{instance=projects/*/locations/*/instances/*}:listAllFindingsRefinementDeployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAllFindingsRefinementDeploymentsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAllFindingsRefinementDeploymentsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListAllFindingsRefinementDeploymentsResponse>newBuilder()
                      .setDefaultInstance(
                          ListAllFindingsRefinementDeploymentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
      computeFindingsRefinementActivityMethodDescriptor =
          ApiMethodDescriptor
              .<ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/ComputeFindingsRefinementActivity")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ComputeFindingsRefinementActivityRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/findingsRefinements/*}:computeFindingsRefinementActivity",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeFindingsRefinementActivityRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeFindingsRefinementActivityRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ComputeFindingsRefinementActivityResponse>newBuilder()
                      .setDefaultInstance(
                          ComputeFindingsRefinementActivityResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ComputeAllFindingsRefinementActivitiesRequest,
          ComputeAllFindingsRefinementActivitiesResponse>
      computeAllFindingsRefinementActivitiesMethodDescriptor =
          ApiMethodDescriptor
              .<ComputeAllFindingsRefinementActivitiesRequest,
                  ComputeAllFindingsRefinementActivitiesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FindingsRefinementService/ComputeAllFindingsRefinementActivities")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ComputeAllFindingsRefinementActivitiesRequest>newBuilder()
                      .setPath(
                          "/v1/{instance=projects/*/locations/*/instances/*}:computeAllFindingsRefinementActivities",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeAllFindingsRefinementActivitiesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeAllFindingsRefinementActivitiesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearInstance().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ComputeAllFindingsRefinementActivitiesResponse>newBuilder()
                      .setDefaultInstance(
                          ComputeAllFindingsRefinementActivitiesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetFindingsRefinementRequest, FindingsRefinement>
      getFindingsRefinementCallable;
  private final UnaryCallable<ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>
      listFindingsRefinementsCallable;
  private final UnaryCallable<ListFindingsRefinementsRequest, ListFindingsRefinementsPagedResponse>
      listFindingsRefinementsPagedCallable;
  private final UnaryCallable<CreateFindingsRefinementRequest, FindingsRefinement>
      createFindingsRefinementCallable;
  private final UnaryCallable<UpdateFindingsRefinementRequest, FindingsRefinement>
      updateFindingsRefinementCallable;
  private final UnaryCallable<GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      getFindingsRefinementDeploymentCallable;
  private final UnaryCallable<
          UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      updateFindingsRefinementDeploymentCallable;
  private final UnaryCallable<
          ListAllFindingsRefinementDeploymentsRequest, ListAllFindingsRefinementDeploymentsResponse>
      listAllFindingsRefinementDeploymentsCallable;
  private final UnaryCallable<
          ListAllFindingsRefinementDeploymentsRequest,
          ListAllFindingsRefinementDeploymentsPagedResponse>
      listAllFindingsRefinementDeploymentsPagedCallable;
  private final UnaryCallable<
          ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
      computeFindingsRefinementActivityCallable;
  private final UnaryCallable<
          ComputeAllFindingsRefinementActivitiesRequest,
          ComputeAllFindingsRefinementActivitiesResponse>
      computeAllFindingsRefinementActivitiesCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonFindingsRefinementServiceStub create(
      FindingsRefinementServiceStubSettings settings) throws IOException {
    return new HttpJsonFindingsRefinementServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonFindingsRefinementServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonFindingsRefinementServiceStub(
        FindingsRefinementServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonFindingsRefinementServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonFindingsRefinementServiceStub(
        FindingsRefinementServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonFindingsRefinementServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonFindingsRefinementServiceStub(
      FindingsRefinementServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonFindingsRefinementServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonFindingsRefinementServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonFindingsRefinementServiceStub(
      FindingsRefinementServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetFindingsRefinementRequest, FindingsRefinement>
        getFindingsRefinementTransportSettings =
            HttpJsonCallSettings.<GetFindingsRefinementRequest, FindingsRefinement>newBuilder()
                .setMethodDescriptor(getFindingsRefinementMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>
        listFindingsRefinementsTransportSettings =
            HttpJsonCallSettings
                .<ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>newBuilder()
                .setMethodDescriptor(listFindingsRefinementsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateFindingsRefinementRequest, FindingsRefinement>
        createFindingsRefinementTransportSettings =
            HttpJsonCallSettings.<CreateFindingsRefinementRequest, FindingsRefinement>newBuilder()
                .setMethodDescriptor(createFindingsRefinementMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateFindingsRefinementRequest, FindingsRefinement>
        updateFindingsRefinementTransportSettings =
            HttpJsonCallSettings.<UpdateFindingsRefinementRequest, FindingsRefinement>newBuilder()
                .setMethodDescriptor(updateFindingsRefinementMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "findings_refinement.name",
                          String.valueOf(request.getFindingsRefinement().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
        getFindingsRefinementDeploymentTransportSettings =
            HttpJsonCallSettings
                .<GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>newBuilder()
                .setMethodDescriptor(getFindingsRefinementDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
        updateFindingsRefinementDeploymentTransportSettings =
            HttpJsonCallSettings
                .<UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
                    newBuilder()
                .setMethodDescriptor(updateFindingsRefinementDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "findings_refinement_deployment.name",
                          String.valueOf(request.getFindingsRefinementDeployment().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListAllFindingsRefinementDeploymentsRequest,
            ListAllFindingsRefinementDeploymentsResponse>
        listAllFindingsRefinementDeploymentsTransportSettings =
            HttpJsonCallSettings
                .<ListAllFindingsRefinementDeploymentsRequest,
                    ListAllFindingsRefinementDeploymentsResponse>
                    newBuilder()
                .setMethodDescriptor(listAllFindingsRefinementDeploymentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getInstance())
                .build();
    HttpJsonCallSettings<
            ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
        computeFindingsRefinementActivityTransportSettings =
            HttpJsonCallSettings
                .<ComputeFindingsRefinementActivityRequest,
                    ComputeFindingsRefinementActivityResponse>
                    newBuilder()
                .setMethodDescriptor(computeFindingsRefinementActivityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<
            ComputeAllFindingsRefinementActivitiesRequest,
            ComputeAllFindingsRefinementActivitiesResponse>
        computeAllFindingsRefinementActivitiesTransportSettings =
            HttpJsonCallSettings
                .<ComputeAllFindingsRefinementActivitiesRequest,
                    ComputeAllFindingsRefinementActivitiesResponse>
                    newBuilder()
                .setMethodDescriptor(computeAllFindingsRefinementActivitiesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getInstance())
                .build();

    this.getFindingsRefinementCallable =
        callableFactory.createUnaryCallable(
            getFindingsRefinementTransportSettings,
            settings.getFindingsRefinementSettings(),
            clientContext);
    this.listFindingsRefinementsCallable =
        callableFactory.createUnaryCallable(
            listFindingsRefinementsTransportSettings,
            settings.listFindingsRefinementsSettings(),
            clientContext);
    this.listFindingsRefinementsPagedCallable =
        callableFactory.createPagedCallable(
            listFindingsRefinementsTransportSettings,
            settings.listFindingsRefinementsSettings(),
            clientContext);
    this.createFindingsRefinementCallable =
        callableFactory.createUnaryCallable(
            createFindingsRefinementTransportSettings,
            settings.createFindingsRefinementSettings(),
            clientContext);
    this.updateFindingsRefinementCallable =
        callableFactory.createUnaryCallable(
            updateFindingsRefinementTransportSettings,
            settings.updateFindingsRefinementSettings(),
            clientContext);
    this.getFindingsRefinementDeploymentCallable =
        callableFactory.createUnaryCallable(
            getFindingsRefinementDeploymentTransportSettings,
            settings.getFindingsRefinementDeploymentSettings(),
            clientContext);
    this.updateFindingsRefinementDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateFindingsRefinementDeploymentTransportSettings,
            settings.updateFindingsRefinementDeploymentSettings(),
            clientContext);
    this.listAllFindingsRefinementDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listAllFindingsRefinementDeploymentsTransportSettings,
            settings.listAllFindingsRefinementDeploymentsSettings(),
            clientContext);
    this.listAllFindingsRefinementDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listAllFindingsRefinementDeploymentsTransportSettings,
            settings.listAllFindingsRefinementDeploymentsSettings(),
            clientContext);
    this.computeFindingsRefinementActivityCallable =
        callableFactory.createUnaryCallable(
            computeFindingsRefinementActivityTransportSettings,
            settings.computeFindingsRefinementActivitySettings(),
            clientContext);
    this.computeAllFindingsRefinementActivitiesCallable =
        callableFactory.createUnaryCallable(
            computeAllFindingsRefinementActivitiesTransportSettings,
            settings.computeAllFindingsRefinementActivitiesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getFindingsRefinementMethodDescriptor);
    methodDescriptors.add(listFindingsRefinementsMethodDescriptor);
    methodDescriptors.add(createFindingsRefinementMethodDescriptor);
    methodDescriptors.add(updateFindingsRefinementMethodDescriptor);
    methodDescriptors.add(getFindingsRefinementDeploymentMethodDescriptor);
    methodDescriptors.add(updateFindingsRefinementDeploymentMethodDescriptor);
    methodDescriptors.add(listAllFindingsRefinementDeploymentsMethodDescriptor);
    methodDescriptors.add(computeFindingsRefinementActivityMethodDescriptor);
    methodDescriptors.add(computeAllFindingsRefinementActivitiesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetFindingsRefinementRequest, FindingsRefinement>
      getFindingsRefinementCallable() {
    return getFindingsRefinementCallable;
  }

  @Override
  public UnaryCallable<ListFindingsRefinementsRequest, ListFindingsRefinementsResponse>
      listFindingsRefinementsCallable() {
    return listFindingsRefinementsCallable;
  }

  @Override
  public UnaryCallable<ListFindingsRefinementsRequest, ListFindingsRefinementsPagedResponse>
      listFindingsRefinementsPagedCallable() {
    return listFindingsRefinementsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateFindingsRefinementRequest, FindingsRefinement>
      createFindingsRefinementCallable() {
    return createFindingsRefinementCallable;
  }

  @Override
  public UnaryCallable<UpdateFindingsRefinementRequest, FindingsRefinement>
      updateFindingsRefinementCallable() {
    return updateFindingsRefinementCallable;
  }

  @Override
  public UnaryCallable<GetFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      getFindingsRefinementDeploymentCallable() {
    return getFindingsRefinementDeploymentCallable;
  }

  @Override
  public UnaryCallable<UpdateFindingsRefinementDeploymentRequest, FindingsRefinementDeployment>
      updateFindingsRefinementDeploymentCallable() {
    return updateFindingsRefinementDeploymentCallable;
  }

  @Override
  public UnaryCallable<
          ListAllFindingsRefinementDeploymentsRequest, ListAllFindingsRefinementDeploymentsResponse>
      listAllFindingsRefinementDeploymentsCallable() {
    return listAllFindingsRefinementDeploymentsCallable;
  }

  @Override
  public UnaryCallable<
          ListAllFindingsRefinementDeploymentsRequest,
          ListAllFindingsRefinementDeploymentsPagedResponse>
      listAllFindingsRefinementDeploymentsPagedCallable() {
    return listAllFindingsRefinementDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<
          ComputeFindingsRefinementActivityRequest, ComputeFindingsRefinementActivityResponse>
      computeFindingsRefinementActivityCallable() {
    return computeFindingsRefinementActivityCallable;
  }

  @Override
  public UnaryCallable<
          ComputeAllFindingsRefinementActivitiesRequest,
          ComputeAllFindingsRefinementActivitiesResponse>
      computeAllFindingsRefinementActivitiesCallable() {
    return computeAllFindingsRefinementActivitiesCallable;
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
