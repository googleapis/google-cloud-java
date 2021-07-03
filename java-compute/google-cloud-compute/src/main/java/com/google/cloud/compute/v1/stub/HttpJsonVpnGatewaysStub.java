/*
 * Copyright 2021 Google LLC
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

import static com.google.cloud.compute.v1.VpnGatewaysClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.VpnGatewaysClient.ListPagedResponse;

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.FieldsExtractor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListVpnGatewaysRequest;
import com.google.cloud.compute.v1.DeleteVpnGatewayRequest;
import com.google.cloud.compute.v1.GetStatusVpnGatewayRequest;
import com.google.cloud.compute.v1.GetVpnGatewayRequest;
import com.google.cloud.compute.v1.InsertVpnGatewayRequest;
import com.google.cloud.compute.v1.ListVpnGatewaysRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetLabelsVpnGatewayRequest;
import com.google.cloud.compute.v1.TestIamPermissionsVpnGatewayRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.VpnGateway;
import com.google.cloud.compute.v1.VpnGatewayAggregatedList;
import com.google.cloud.compute.v1.VpnGatewayList;
import com.google.cloud.compute.v1.VpnGatewaysGetStatusResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the VpnGateways service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonVpnGatewaysStub extends VpnGatewaysStub {
  private static final ApiMethodDescriptor<
          AggregatedListVpnGatewaysRequest, VpnGatewayAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListVpnGatewaysRequest, VpnGatewayAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.VpnGateways/AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListVpnGatewaysRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/vpnGateways",
                          new FieldsExtractor<
                              AggregatedListVpnGatewaysRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListVpnGatewaysRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListVpnGatewaysRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListVpnGatewaysRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListVpnGatewaysRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListVpnGatewaysRequest> serializer =
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
                                serializer.putQueryParam(
                                    fields, "pageToken", request.getPageToken());
                              }
                              if (request.hasReturnPartialSuccess()) {
                                serializer.putQueryParam(
                                    fields,
                                    "returnPartialSuccess",
                                    request.getReturnPartialSuccess());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AggregatedListVpnGatewaysRequest, String>() {
                            @Override
                            public String extract(AggregatedListVpnGatewaysRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VpnGatewayAggregatedList>newBuilder()
                      .setDefaultInstance(VpnGatewayAggregatedList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteVpnGatewayRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteVpnGatewayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.VpnGateways/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteVpnGatewayRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/vpnGateways/{vpnGateway}",
                          new FieldsExtractor<DeleteVpnGatewayRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteVpnGatewayRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "vpnGateway", request.getVpnGateway());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteVpnGatewayRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteVpnGatewayRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteVpnGatewayRequest, String>() {
                            @Override
                            public String extract(DeleteVpnGatewayRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetVpnGatewayRequest, VpnGateway> getMethodDescriptor =
      ApiMethodDescriptor.<GetVpnGatewayRequest, VpnGateway>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.VpnGateways/Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetVpnGatewayRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/vpnGateways/{vpnGateway}",
                      new FieldsExtractor<GetVpnGatewayRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetVpnGatewayRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetVpnGatewayRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "region", request.getRegion());
                          serializer.putPathParam(fields, "vpnGateway", request.getVpnGateway());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetVpnGatewayRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetVpnGatewayRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetVpnGatewayRequest> serializer =
                              ProtoRestSerializer.create();
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetVpnGatewayRequest, String>() {
                        @Override
                        public String extract(GetVpnGatewayRequest request) {
                          return null;
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<VpnGateway>newBuilder()
                  .setDefaultInstance(VpnGateway.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetStatusVpnGatewayRequest, VpnGatewaysGetStatusResponse>
      getStatusMethodDescriptor =
          ApiMethodDescriptor.<GetStatusVpnGatewayRequest, VpnGatewaysGetStatusResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.VpnGateways/GetStatus")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetStatusVpnGatewayRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/vpnGateways/{vpnGateway}/getStatus",
                          new FieldsExtractor<GetStatusVpnGatewayRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetStatusVpnGatewayRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetStatusVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "vpnGateway", request.getVpnGateway());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetStatusVpnGatewayRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetStatusVpnGatewayRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetStatusVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetStatusVpnGatewayRequest, String>() {
                            @Override
                            public String extract(GetStatusVpnGatewayRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VpnGatewaysGetStatusResponse>newBuilder()
                      .setDefaultInstance(VpnGatewaysGetStatusResponse.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertVpnGatewayRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertVpnGatewayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.VpnGateways/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertVpnGatewayRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/vpnGateways",
                          new FieldsExtractor<InsertVpnGatewayRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(InsertVpnGatewayRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertVpnGatewayRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertVpnGatewayRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertVpnGatewayRequest, String>() {
                            @Override
                            public String extract(InsertVpnGatewayRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("vpnGatewayResource", request.getVpnGatewayResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListVpnGatewaysRequest, VpnGatewayList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListVpnGatewaysRequest, VpnGatewayList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.VpnGateways/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListVpnGatewaysRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/vpnGateways",
                          new FieldsExtractor<ListVpnGatewaysRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListVpnGatewaysRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListVpnGatewaysRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<ListVpnGatewaysRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListVpnGatewaysRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListVpnGatewaysRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasFilter()) {
                                serializer.putQueryParam(fields, "filter", request.getFilter());
                              }
                              if (request.hasMaxResults()) {
                                serializer.putQueryParam(
                                    fields, "maxResults", request.getMaxResults());
                              }
                              if (request.hasOrderBy()) {
                                serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                              }
                              if (request.hasPageToken()) {
                                serializer.putQueryParam(
                                    fields, "pageToken", request.getPageToken());
                              }
                              if (request.hasReturnPartialSuccess()) {
                                serializer.putQueryParam(
                                    fields,
                                    "returnPartialSuccess",
                                    request.getReturnPartialSuccess());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ListVpnGatewaysRequest, String>() {
                            @Override
                            public String extract(ListVpnGatewaysRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VpnGatewayList>newBuilder()
                      .setDefaultInstance(VpnGatewayList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetLabelsVpnGatewayRequest, Operation>
      setLabelsMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsVpnGatewayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.VpnGateways/SetLabels")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLabelsVpnGatewayRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/vpnGateways/{resource}/setLabels",
                          new FieldsExtractor<SetLabelsVpnGatewayRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(SetLabelsVpnGatewayRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetLabelsVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetLabelsVpnGatewayRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetLabelsVpnGatewayRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetLabelsVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetLabelsVpnGatewayRequest, String>() {
                            @Override
                            public String extract(SetLabelsVpnGatewayRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionSetLabelsRequestResource",
                                      request.getRegionSetLabelsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TestIamPermissionsVpnGatewayRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsVpnGatewayRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.VpnGateways/TestIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsVpnGatewayRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/vpnGateways/{resource}/testIamPermissions",
                          new FieldsExtractor<
                              TestIamPermissionsVpnGatewayRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                TestIamPermissionsVpnGatewayRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsVpnGatewayRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                TestIamPermissionsVpnGatewayRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsVpnGatewayRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<TestIamPermissionsVpnGatewayRequest, String>() {
                            @Override
                            public String extract(TestIamPermissionsVpnGatewayRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "testPermissionsRequestResource",
                                      request.getTestPermissionsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<AggregatedListVpnGatewaysRequest, VpnGatewayAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListVpnGatewaysRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteVpnGatewayRequest, Operation> deleteCallable;
  private final UnaryCallable<GetVpnGatewayRequest, VpnGateway> getCallable;
  private final UnaryCallable<GetStatusVpnGatewayRequest, VpnGatewaysGetStatusResponse>
      getStatusCallable;
  private final UnaryCallable<InsertVpnGatewayRequest, Operation> insertCallable;
  private final UnaryCallable<ListVpnGatewaysRequest, VpnGatewayList> listCallable;
  private final UnaryCallable<ListVpnGatewaysRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<SetLabelsVpnGatewayRequest, Operation> setLabelsCallable;
  private final UnaryCallable<TestIamPermissionsVpnGatewayRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonVpnGatewaysStub create(VpnGatewaysStubSettings settings)
      throws IOException {
    return new HttpJsonVpnGatewaysStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonVpnGatewaysStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonVpnGatewaysStub(VpnGatewaysStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonVpnGatewaysStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonVpnGatewaysStub(
        VpnGatewaysStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonVpnGatewaysStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonVpnGatewaysStub(VpnGatewaysStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonVpnGatewaysCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonVpnGatewaysStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonVpnGatewaysStub(
      VpnGatewaysStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListVpnGatewaysRequest, VpnGatewayAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListVpnGatewaysRequest, VpnGatewayAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteVpnGatewayRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteVpnGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetVpnGatewayRequest, VpnGateway> getTransportSettings =
        HttpJsonCallSettings.<GetVpnGatewayRequest, VpnGateway>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetStatusVpnGatewayRequest, VpnGatewaysGetStatusResponse>
        getStatusTransportSettings =
            HttpJsonCallSettings
                .<GetStatusVpnGatewayRequest, VpnGatewaysGetStatusResponse>newBuilder()
                .setMethodDescriptor(getStatusMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertVpnGatewayRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertVpnGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListVpnGatewaysRequest, VpnGatewayList> listTransportSettings =
        HttpJsonCallSettings.<ListVpnGatewaysRequest, VpnGatewayList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetLabelsVpnGatewayRequest, Operation> setLabelsTransportSettings =
        HttpJsonCallSettings.<SetLabelsVpnGatewayRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .build();
    HttpJsonCallSettings<TestIamPermissionsVpnGatewayRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsVpnGatewayRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
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
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getStatusCallable =
        callableFactory.createUnaryCallable(
            getStatusTransportSettings, settings.getStatusSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.setLabelsCallable =
        callableFactory.createUnaryCallable(
            setLabelsTransportSettings, settings.setLabelsSettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getStatusMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(setLabelsMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AggregatedListVpnGatewaysRequest, VpnGatewayAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListVpnGatewaysRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteVpnGatewayRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetVpnGatewayRequest, VpnGateway> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetStatusVpnGatewayRequest, VpnGatewaysGetStatusResponse>
      getStatusCallable() {
    return getStatusCallable;
  }

  @Override
  public UnaryCallable<InsertVpnGatewayRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListVpnGatewaysRequest, VpnGatewayList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListVpnGatewaysRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<SetLabelsVpnGatewayRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsVpnGatewayRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
