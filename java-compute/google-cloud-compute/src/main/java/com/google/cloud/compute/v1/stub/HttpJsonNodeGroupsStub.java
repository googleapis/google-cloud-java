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

import static com.google.cloud.compute.v1.NodeGroupsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.NodeGroupsClient.ListNodesPagedResponse;
import static com.google.cloud.compute.v1.NodeGroupsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AddNodesNodeGroupRequest;
import com.google.cloud.compute.v1.AggregatedListNodeGroupsRequest;
import com.google.cloud.compute.v1.DeleteNodeGroupRequest;
import com.google.cloud.compute.v1.DeleteNodesNodeGroupRequest;
import com.google.cloud.compute.v1.GetIamPolicyNodeGroupRequest;
import com.google.cloud.compute.v1.GetNodeGroupRequest;
import com.google.cloud.compute.v1.InsertNodeGroupRequest;
import com.google.cloud.compute.v1.ListNodeGroupsRequest;
import com.google.cloud.compute.v1.ListNodesNodeGroupsRequest;
import com.google.cloud.compute.v1.NodeGroup;
import com.google.cloud.compute.v1.NodeGroupAggregatedList;
import com.google.cloud.compute.v1.NodeGroupList;
import com.google.cloud.compute.v1.NodeGroupsListNodes;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchNodeGroupRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyNodeGroupRequest;
import com.google.cloud.compute.v1.SetNodeTemplateNodeGroupRequest;
import com.google.cloud.compute.v1.TestIamPermissionsNodeGroupRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
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
public class HttpJsonNodeGroupsStub extends NodeGroupsStub {

  @InternalApi
  public static final ApiMethodDescriptor<AddNodesNodeGroupRequest, Operation>
      addNodesMethodDescriptor =
          ApiMethodDescriptor.<AddNodesNodeGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups.AddNodes")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddNodesNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}/addNodes",
                          new FieldsExtractor<AddNodesNodeGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(AddNodesNodeGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AddNodesNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "nodeGroup", request.getNodeGroup());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AddNodesNodeGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AddNodesNodeGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AddNodesNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AddNodesNodeGroupRequest, String>() {
                            @Override
                            public String extract(AddNodesNodeGroupRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "nodeGroupsAddNodesRequestResource",
                                      request.getNodeGroupsAddNodesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<AggregatedListNodeGroupsRequest, NodeGroupAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor.<AggregatedListNodeGroupsRequest, NodeGroupAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups.AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListNodeGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/nodeGroups",
                          new FieldsExtractor<
                              AggregatedListNodeGroupsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListNodeGroupsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListNodeGroupsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListNodeGroupsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListNodeGroupsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListNodeGroupsRequest> serializer =
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
                          new FieldsExtractor<AggregatedListNodeGroupsRequest, String>() {
                            @Override
                            public String extract(AggregatedListNodeGroupsRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NodeGroupAggregatedList>newBuilder()
                      .setDefaultInstance(NodeGroupAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteNodeGroupRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteNodeGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}",
                          new FieldsExtractor<DeleteNodeGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteNodeGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "nodeGroup", request.getNodeGroup());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<DeleteNodeGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteNodeGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteNodeGroupRequest, String>() {
                            @Override
                            public String extract(DeleteNodeGroupRequest request) {
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
  public static final ApiMethodDescriptor<DeleteNodesNodeGroupRequest, Operation>
      deleteNodesMethodDescriptor =
          ApiMethodDescriptor.<DeleteNodesNodeGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups.DeleteNodes")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNodesNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}/deleteNodes",
                          new FieldsExtractor<DeleteNodesNodeGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteNodesNodeGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteNodesNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "nodeGroup", request.getNodeGroup());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteNodesNodeGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteNodesNodeGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteNodesNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteNodesNodeGroupRequest, String>() {
                            @Override
                            public String extract(DeleteNodesNodeGroupRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "nodeGroupsDeleteNodesRequestResource",
                                      request.getNodeGroupsDeleteNodesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetNodeGroupRequest, NodeGroup> getMethodDescriptor =
      ApiMethodDescriptor.<GetNodeGroupRequest, NodeGroup>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.NodeGroups.Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetNodeGroupRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}",
                      new FieldsExtractor<GetNodeGroupRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetNodeGroupRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetNodeGroupRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          serializer.putPathParam(fields, "nodeGroup", request.getNodeGroup());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetNodeGroupRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetNodeGroupRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetNodeGroupRequest> serializer =
                              ProtoRestSerializer.create();

                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetNodeGroupRequest, String>() {
                        @Override
                        public String extract(GetNodeGroupRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<NodeGroup>newBuilder()
                  .setDefaultInstance(NodeGroup.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetIamPolicyNodeGroupRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyNodeGroupRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups.GetIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{resource}/getIamPolicy",
                          new FieldsExtractor<GetIamPolicyNodeGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetIamPolicyNodeGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetIamPolicyNodeGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetIamPolicyNodeGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyNodeGroupRequest> serializer =
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
                          new FieldsExtractor<GetIamPolicyNodeGroupRequest, String>() {
                            @Override
                            public String extract(GetIamPolicyNodeGroupRequest request) {
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
  public static final ApiMethodDescriptor<InsertNodeGroupRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertNodeGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups",
                          new FieldsExtractor<InsertNodeGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(InsertNodeGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<InsertNodeGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertNodeGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putQueryParam(
                                  fields, "initialNodeCount", request.getInitialNodeCount());
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertNodeGroupRequest, String>() {
                            @Override
                            public String extract(InsertNodeGroupRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("nodeGroupResource", request.getNodeGroupResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListNodeGroupsRequest, NodeGroupList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListNodeGroupsRequest, NodeGroupList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNodeGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups",
                          new FieldsExtractor<ListNodeGroupsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListNodeGroupsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListNodeGroupsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<ListNodeGroupsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListNodeGroupsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListNodeGroupsRequest> serializer =
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
                          new FieldsExtractor<ListNodeGroupsRequest, String>() {
                            @Override
                            public String extract(ListNodeGroupsRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NodeGroupList>newBuilder()
                      .setDefaultInstance(NodeGroupList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListNodesNodeGroupsRequest, NodeGroupsListNodes>
      listNodesMethodDescriptor =
          ApiMethodDescriptor.<ListNodesNodeGroupsRequest, NodeGroupsListNodes>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups.ListNodes")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNodesNodeGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}/listNodes",
                          new FieldsExtractor<ListNodesNodeGroupsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListNodesNodeGroupsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListNodesNodeGroupsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "nodeGroup", request.getNodeGroup());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListNodesNodeGroupsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListNodesNodeGroupsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListNodesNodeGroupsRequest> serializer =
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
                          new FieldsExtractor<ListNodesNodeGroupsRequest, String>() {
                            @Override
                            public String extract(ListNodesNodeGroupsRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NodeGroupsListNodes>newBuilder()
                      .setDefaultInstance(NodeGroupsListNodes.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchNodeGroupRequest, Operation> patchMethodDescriptor =
      ApiMethodDescriptor.<PatchNodeGroupRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.NodeGroups.Patch")
          .setHttpMethod(HttpMethods.PATCH)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PatchNodeGroupRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}",
                      new FieldsExtractor<PatchNodeGroupRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(PatchNodeGroupRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<PatchNodeGroupRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "zone", request.getZone());
                          serializer.putPathParam(fields, "nodeGroup", request.getNodeGroup());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<PatchNodeGroupRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(PatchNodeGroupRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<PatchNodeGroupRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<PatchNodeGroupRequest, String>() {
                        @Override
                        public String extract(PatchNodeGroupRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("nodeGroupResource", request.getNodeGroupResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetIamPolicyNodeGroupRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyNodeGroupRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups.SetIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{resource}/setIamPolicy",
                          new FieldsExtractor<SetIamPolicyNodeGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetIamPolicyNodeGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetIamPolicyNodeGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetIamPolicyNodeGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetIamPolicyNodeGroupRequest, String>() {
                            @Override
                            public String extract(SetIamPolicyNodeGroupRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "zoneSetPolicyRequestResource",
                                      request.getZoneSetPolicyRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetNodeTemplateNodeGroupRequest, Operation>
      setNodeTemplateMethodDescriptor =
          ApiMethodDescriptor.<SetNodeTemplateNodeGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups.SetNodeTemplate")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetNodeTemplateNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}/setNodeTemplate",
                          new FieldsExtractor<
                              SetNodeTemplateNodeGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetNodeTemplateNodeGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetNodeTemplateNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "nodeGroup", request.getNodeGroup());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetNodeTemplateNodeGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetNodeTemplateNodeGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetNodeTemplateNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetNodeTemplateNodeGroupRequest, String>() {
                            @Override
                            public String extract(SetNodeTemplateNodeGroupRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "nodeGroupsSetNodeTemplateRequestResource",
                                      request.getNodeGroupsSetNodeTemplateRequestResource());
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
          TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NodeGroups.TestIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsNodeGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/nodeGroups/{resource}/testIamPermissions",
                          new FieldsExtractor<
                              TestIamPermissionsNodeGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                TestIamPermissionsNodeGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "zone", request.getZone());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsNodeGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                TestIamPermissionsNodeGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsNodeGroupRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<TestIamPermissionsNodeGroupRequest, String>() {
                            @Override
                            public String extract(TestIamPermissionsNodeGroupRequest request) {
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

  private final UnaryCallable<AddNodesNodeGroupRequest, Operation> addNodesCallable;
  private final UnaryCallable<AggregatedListNodeGroupsRequest, NodeGroupAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListNodeGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteNodeGroupRequest, Operation> deleteCallable;
  private final UnaryCallable<DeleteNodesNodeGroupRequest, Operation> deleteNodesCallable;
  private final UnaryCallable<GetNodeGroupRequest, NodeGroup> getCallable;
  private final UnaryCallable<GetIamPolicyNodeGroupRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertNodeGroupRequest, Operation> insertCallable;
  private final UnaryCallable<ListNodeGroupsRequest, NodeGroupList> listCallable;
  private final UnaryCallable<ListNodeGroupsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<ListNodesNodeGroupsRequest, NodeGroupsListNodes> listNodesCallable;
  private final UnaryCallable<ListNodesNodeGroupsRequest, ListNodesPagedResponse>
      listNodesPagedCallable;
  private final UnaryCallable<PatchNodeGroupRequest, Operation> patchCallable;
  private final UnaryCallable<SetIamPolicyNodeGroupRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetNodeTemplateNodeGroupRequest, Operation> setNodeTemplateCallable;
  private final UnaryCallable<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNodeGroupsStub create(NodeGroupsStubSettings settings)
      throws IOException {
    return new HttpJsonNodeGroupsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNodeGroupsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonNodeGroupsStub(NodeGroupsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonNodeGroupsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNodeGroupsStub(
        NodeGroupsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNodeGroupsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonNodeGroupsStub(NodeGroupsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonNodeGroupsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNodeGroupsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonNodeGroupsStub(
      NodeGroupsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddNodesNodeGroupRequest, Operation> addNodesTransportSettings =
        HttpJsonCallSettings.<AddNodesNodeGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(addNodesMethodDescriptor)
            .build();
    HttpJsonCallSettings<AggregatedListNodeGroupsRequest, NodeGroupAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListNodeGroupsRequest, NodeGroupAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteNodeGroupRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteNodeGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<DeleteNodesNodeGroupRequest, Operation> deleteNodesTransportSettings =
        HttpJsonCallSettings.<DeleteNodesNodeGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNodesMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetNodeGroupRequest, NodeGroup> getTransportSettings =
        HttpJsonCallSettings.<GetNodeGroupRequest, NodeGroup>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetIamPolicyNodeGroupRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyNodeGroupRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertNodeGroupRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertNodeGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListNodeGroupsRequest, NodeGroupList> listTransportSettings =
        HttpJsonCallSettings.<ListNodeGroupsRequest, NodeGroupList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListNodesNodeGroupsRequest, NodeGroupsListNodes>
        listNodesTransportSettings =
            HttpJsonCallSettings.<ListNodesNodeGroupsRequest, NodeGroupsListNodes>newBuilder()
                .setMethodDescriptor(listNodesMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchNodeGroupRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchNodeGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetIamPolicyNodeGroupRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyNodeGroupRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetNodeTemplateNodeGroupRequest, Operation>
        setNodeTemplateTransportSettings =
            HttpJsonCallSettings.<SetNodeTemplateNodeGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(setNodeTemplateMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .build();

    this.addNodesCallable =
        callableFactory.createUnaryCallable(
            addNodesTransportSettings, settings.addNodesSettings(), clientContext);
    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deleteNodesCallable =
        callableFactory.createUnaryCallable(
            deleteNodesTransportSettings, settings.deleteNodesSettings(), clientContext);
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
    this.listNodesCallable =
        callableFactory.createUnaryCallable(
            listNodesTransportSettings, settings.listNodesSettings(), clientContext);
    this.listNodesPagedCallable =
        callableFactory.createPagedCallable(
            listNodesTransportSettings, settings.listNodesSettings(), clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.setNodeTemplateCallable =
        callableFactory.createUnaryCallable(
            setNodeTemplateTransportSettings, settings.setNodeTemplateSettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<AddNodesNodeGroupRequest, Operation> addNodesCallable() {
    return addNodesCallable;
  }

  public UnaryCallable<AggregatedListNodeGroupsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  public UnaryCallable<AggregatedListNodeGroupsRequest, NodeGroupAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  public UnaryCallable<DeleteNodeGroupRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<DeleteNodesNodeGroupRequest, Operation> deleteNodesCallable() {
    return deleteNodesCallable;
  }

  public UnaryCallable<GetNodeGroupRequest, NodeGroup> getCallable() {
    return getCallable;
  }

  public UnaryCallable<GetIamPolicyNodeGroupRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<InsertNodeGroupRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListNodeGroupsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListNodeGroupsRequest, NodeGroupList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<ListNodesNodeGroupsRequest, ListNodesPagedResponse>
      listNodesPagedCallable() {
    return listNodesPagedCallable;
  }

  public UnaryCallable<ListNodesNodeGroupsRequest, NodeGroupsListNodes> listNodesCallable() {
    return listNodesCallable;
  }

  public UnaryCallable<PatchNodeGroupRequest, Operation> patchCallable() {
    return patchCallable;
  }

  public UnaryCallable<SetIamPolicyNodeGroupRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<SetNodeTemplateNodeGroupRequest, Operation> setNodeTemplateCallable() {
    return setNodeTemplateCallable;
  }

  public UnaryCallable<TestIamPermissionsNodeGroupRequest, TestPermissionsResponse>
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
