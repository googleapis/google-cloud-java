/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.SubnetworksClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.SubnetworksClient.ListPagedResponse;
import static com.google.cloud.compute.v1.SubnetworksClient.ListUsablePagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListSubnetworksRequest;
import com.google.cloud.compute.v1.DeleteSubnetworkRequest;
import com.google.cloud.compute.v1.ExpandIpCidrRangeSubnetworkRequest;
import com.google.cloud.compute.v1.GetIamPolicySubnetworkRequest;
import com.google.cloud.compute.v1.GetSubnetworkRequest;
import com.google.cloud.compute.v1.InsertSubnetworkRequest;
import com.google.cloud.compute.v1.ListSubnetworksRequest;
import com.google.cloud.compute.v1.ListUsableSubnetworksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchSubnetworkRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicySubnetworkRequest;
import com.google.cloud.compute.v1.SetPrivateIpGoogleAccessSubnetworkRequest;
import com.google.cloud.compute.v1.Subnetwork;
import com.google.cloud.compute.v1.SubnetworkAggregatedList;
import com.google.cloud.compute.v1.SubnetworkList;
import com.google.cloud.compute.v1.TestIamPermissionsSubnetworkRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.UsableSubnetworksAggregatedList;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * REST stub implementation for Google Compute Engine API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonSubnetworksStub extends SubnetworksStub {

  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListSubnetworksRequest, SubnetworkAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListSubnetworksRequest, SubnetworkAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks.AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListSubnetworksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/subnetworks",
                          new FieldsExtractor<
                              AggregatedListSubnetworksRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListSubnetworksRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListSubnetworksRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListSubnetworksRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListSubnetworksRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListSubnetworksRequest> serializer =
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
                          new FieldsExtractor<AggregatedListSubnetworksRequest, String>() {
                            @Override
                            public String extract(AggregatedListSubnetworksRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SubnetworkAggregatedList>newBuilder()
                      .setDefaultInstance(SubnetworkAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteSubnetworkRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteSubnetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks/{subnetwork}",
                          new FieldsExtractor<DeleteSubnetworkRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteSubnetworkRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteSubnetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "subnetwork", request.getSubnetwork());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteSubnetworkRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteSubnetworkRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteSubnetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteSubnetworkRequest, String>() {
                            @Override
                            public String extract(DeleteSubnetworkRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ExpandIpCidrRangeSubnetworkRequest, Operation>
      expandIpCidrRangeMethodDescriptor =
          ApiMethodDescriptor.<ExpandIpCidrRangeSubnetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks.ExpandIpCidrRange")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExpandIpCidrRangeSubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks/{subnetwork}/expandIpCidrRange",
                          new FieldsExtractor<
                              ExpandIpCidrRangeSubnetworkRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ExpandIpCidrRangeSubnetworkRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ExpandIpCidrRangeSubnetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "subnetwork", request.getSubnetwork());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ExpandIpCidrRangeSubnetworkRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ExpandIpCidrRangeSubnetworkRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ExpandIpCidrRangeSubnetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ExpandIpCidrRangeSubnetworkRequest, String>() {
                            @Override
                            public String extract(ExpandIpCidrRangeSubnetworkRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "subnetworksExpandIpCidrRangeRequestResource",
                                      request.getSubnetworksExpandIpCidrRangeRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetSubnetworkRequest, Subnetwork> getMethodDescriptor =
      ApiMethodDescriptor.<GetSubnetworkRequest, Subnetwork>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Subnetworks.Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSubnetworkRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/subnetworks/{subnetwork}",
                      new FieldsExtractor<GetSubnetworkRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetSubnetworkRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetSubnetworkRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "region", request.getRegion());
                          serializer.putPathParam(fields, "subnetwork", request.getSubnetwork());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetSubnetworkRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetSubnetworkRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetSubnetworkRequest> serializer =
                              ProtoRestSerializer.create();

                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetSubnetworkRequest, String>() {
                        @Override
                        public String extract(GetSubnetworkRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Subnetwork>newBuilder()
                  .setDefaultInstance(Subnetwork.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetIamPolicySubnetworkRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicySubnetworkRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks.GetIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicySubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks/{resource}/getIamPolicy",
                          new FieldsExtractor<
                              GetIamPolicySubnetworkRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetIamPolicySubnetworkRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicySubnetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetIamPolicySubnetworkRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetIamPolicySubnetworkRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicySubnetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasOptionsRequestedPolicyVersion()) {
                                serializer.putQueryParam(
                                    fields,
                                    "optionsRequestedPolicyVersion",
                                    request.getOptionsRequestedPolicyVersion());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetIamPolicySubnetworkRequest, String>() {
                            @Override
                            public String extract(GetIamPolicySubnetworkRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertSubnetworkRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertSubnetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertSubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks",
                          new FieldsExtractor<InsertSubnetworkRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(InsertSubnetworkRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertSubnetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertSubnetworkRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertSubnetworkRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertSubnetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertSubnetworkRequest, String>() {
                            @Override
                            public String extract(InsertSubnetworkRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("subnetworkResource", request.getSubnetworkResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListSubnetworksRequest, SubnetworkList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListSubnetworksRequest, SubnetworkList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSubnetworksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks",
                          new FieldsExtractor<ListSubnetworksRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListSubnetworksRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListSubnetworksRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<ListSubnetworksRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListSubnetworksRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListSubnetworksRequest> serializer =
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
                          new FieldsExtractor<ListSubnetworksRequest, String>() {
                            @Override
                            public String extract(ListSubnetworksRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SubnetworkList>newBuilder()
                      .setDefaultInstance(SubnetworkList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>
      listUsableMethodDescriptor =
          ApiMethodDescriptor
              .<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks.ListUsable")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUsableSubnetworksRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/subnetworks/listUsable",
                          new FieldsExtractor<ListUsableSubnetworksRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListUsableSubnetworksRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListUsableSubnetworksRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListUsableSubnetworksRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListUsableSubnetworksRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListUsableSubnetworksRequest> serializer =
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
                          new FieldsExtractor<ListUsableSubnetworksRequest, String>() {
                            @Override
                            public String extract(ListUsableSubnetworksRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UsableSubnetworksAggregatedList>newBuilder()
                      .setDefaultInstance(UsableSubnetworksAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchSubnetworkRequest, Operation> patchMethodDescriptor =
      ApiMethodDescriptor.<PatchSubnetworkRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Subnetworks.Patch")
          .setHttpMethod(HttpMethods.PATCH)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PatchSubnetworkRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/subnetworks/{subnetwork}",
                      new FieldsExtractor<PatchSubnetworkRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(PatchSubnetworkRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<PatchSubnetworkRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "region", request.getRegion());
                          serializer.putPathParam(fields, "subnetwork", request.getSubnetwork());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<PatchSubnetworkRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(PatchSubnetworkRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<PatchSubnetworkRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasDrainTimeoutSeconds()) {
                            serializer.putQueryParam(
                                fields, "drainTimeoutSeconds", request.getDrainTimeoutSeconds());
                          }
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<PatchSubnetworkRequest, String>() {
                        @Override
                        public String extract(PatchSubnetworkRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("subnetworkResource", request.getSubnetworkResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetIamPolicySubnetworkRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicySubnetworkRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks.SetIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicySubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks/{resource}/setIamPolicy",
                          new FieldsExtractor<
                              SetIamPolicySubnetworkRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetIamPolicySubnetworkRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicySubnetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetIamPolicySubnetworkRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetIamPolicySubnetworkRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicySubnetworkRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetIamPolicySubnetworkRequest, String>() {
                            @Override
                            public String extract(SetIamPolicySubnetworkRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionSetPolicyRequestResource",
                                      request.getRegionSetPolicyRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
      setPrivateIpGoogleAccessMethodDescriptor =
          ApiMethodDescriptor.<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks.SetPrivateIpGoogleAccess")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetPrivateIpGoogleAccessSubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks/{subnetwork}/setPrivateIpGoogleAccess",
                          new FieldsExtractor<
                              SetPrivateIpGoogleAccessSubnetworkRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetPrivateIpGoogleAccessSubnetworkRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetPrivateIpGoogleAccessSubnetworkRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(
                                  fields, "subnetwork", request.getSubnetwork());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetPrivateIpGoogleAccessSubnetworkRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetPrivateIpGoogleAccessSubnetworkRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetPrivateIpGoogleAccessSubnetworkRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetPrivateIpGoogleAccessSubnetworkRequest, String>() {
                            @Override
                            public String extract(
                                SetPrivateIpGoogleAccessSubnetworkRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "subnetworksSetPrivateIpGoogleAccessRequestResource",
                                      request
                                          .getSubnetworksSetPrivateIpGoogleAccessRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Subnetworks.TestIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsSubnetworkRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/subnetworks/{resource}/testIamPermissions",
                          new FieldsExtractor<
                              TestIamPermissionsSubnetworkRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                TestIamPermissionsSubnetworkRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsSubnetworkRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsSubnetworkRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                TestIamPermissionsSubnetworkRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsSubnetworkRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<TestIamPermissionsSubnetworkRequest, String>() {
                            @Override
                            public String extract(TestIamPermissionsSubnetworkRequest request) {
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

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListSubnetworksRequest, SubnetworkAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListSubnetworksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteSubnetworkRequest, Operation> deleteCallable;
  private final UnaryCallable<ExpandIpCidrRangeSubnetworkRequest, Operation>
      expandIpCidrRangeCallable;
  private final UnaryCallable<GetSubnetworkRequest, Subnetwork> getCallable;
  private final UnaryCallable<GetIamPolicySubnetworkRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertSubnetworkRequest, Operation> insertCallable;
  private final UnaryCallable<ListSubnetworksRequest, SubnetworkList> listCallable;
  private final UnaryCallable<ListSubnetworksRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>
      listUsableCallable;
  private final UnaryCallable<ListUsableSubnetworksRequest, ListUsablePagedResponse>
      listUsablePagedCallable;
  private final UnaryCallable<PatchSubnetworkRequest, Operation> patchCallable;
  private final UnaryCallable<SetIamPolicySubnetworkRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
      setPrivateIpGoogleAccessCallable;
  private final UnaryCallable<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSubnetworksStub create(SubnetworksStubSettings settings)
      throws IOException {
    return new HttpJsonSubnetworksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSubnetworksStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSubnetworksStub(SubnetworksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonSubnetworksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSubnetworksStub(
        SubnetworksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSubnetworksStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSubnetworksStub(SubnetworksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSubnetworksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSubnetworksStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSubnetworksStub(
      SubnetworksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListSubnetworksRequest, SubnetworkAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListSubnetworksRequest, SubnetworkAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteSubnetworkRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteSubnetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<ExpandIpCidrRangeSubnetworkRequest, Operation>
        expandIpCidrRangeTransportSettings =
            HttpJsonCallSettings.<ExpandIpCidrRangeSubnetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(expandIpCidrRangeMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetSubnetworkRequest, Subnetwork> getTransportSettings =
        HttpJsonCallSettings.<GetSubnetworkRequest, Subnetwork>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetIamPolicySubnetworkRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicySubnetworkRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertSubnetworkRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertSubnetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListSubnetworksRequest, SubnetworkList> listTransportSettings =
        HttpJsonCallSettings.<ListSubnetworksRequest, SubnetworkList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>
        listUsableTransportSettings =
            HttpJsonCallSettings
                .<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>newBuilder()
                .setMethodDescriptor(listUsableMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchSubnetworkRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchSubnetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetIamPolicySubnetworkRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicySubnetworkRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
        setPrivateIpGoogleAccessTransportSettings =
            HttpJsonCallSettings.<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>newBuilder()
                .setMethodDescriptor(setPrivateIpGoogleAccessMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>newBuilder()
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
    this.expandIpCidrRangeCallable =
        callableFactory.createUnaryCallable(
            expandIpCidrRangeTransportSettings,
            settings.expandIpCidrRangeSettings(),
            clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listUsableCallable =
        callableFactory.createUnaryCallable(
            listUsableTransportSettings, settings.listUsableSettings(), clientContext);
    this.listUsablePagedCallable =
        callableFactory.createPagedCallable(
            listUsableTransportSettings, settings.listUsableSettings(), clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.setPrivateIpGoogleAccessCallable =
        callableFactory.createUnaryCallable(
            setPrivateIpGoogleAccessTransportSettings,
            settings.setPrivateIpGoogleAccessSettings(),
            clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<AggregatedListSubnetworksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  public UnaryCallable<AggregatedListSubnetworksRequest, SubnetworkAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  public UnaryCallable<DeleteSubnetworkRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<ExpandIpCidrRangeSubnetworkRequest, Operation> expandIpCidrRangeCallable() {
    return expandIpCidrRangeCallable;
  }

  public UnaryCallable<GetSubnetworkRequest, Subnetwork> getCallable() {
    return getCallable;
  }

  public UnaryCallable<GetIamPolicySubnetworkRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<InsertSubnetworkRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListSubnetworksRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListSubnetworksRequest, SubnetworkList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<ListUsableSubnetworksRequest, ListUsablePagedResponse>
      listUsablePagedCallable() {
    return listUsablePagedCallable;
  }

  public UnaryCallable<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>
      listUsableCallable() {
    return listUsableCallable;
  }

  public UnaryCallable<PatchSubnetworkRequest, Operation> patchCallable() {
    return patchCallable;
  }

  public UnaryCallable<SetIamPolicySubnetworkRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
      setPrivateIpGoogleAccessCallable() {
    return setPrivateIpGoogleAccessCallable;
  }

  public UnaryCallable<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
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
