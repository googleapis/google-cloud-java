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

import static com.google.cloud.compute.v1.ProjectsClient.GetXpnResourcesPagedResponse;
import static com.google.cloud.compute.v1.ProjectsClient.ListXpnHostsPagedResponse;

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
import com.google.cloud.compute.v1.DisableXpnHostProjectRequest;
import com.google.cloud.compute.v1.DisableXpnResourceProjectRequest;
import com.google.cloud.compute.v1.EnableXpnHostProjectRequest;
import com.google.cloud.compute.v1.EnableXpnResourceProjectRequest;
import com.google.cloud.compute.v1.GetProjectRequest;
import com.google.cloud.compute.v1.GetXpnHostProjectRequest;
import com.google.cloud.compute.v1.GetXpnResourcesProjectsRequest;
import com.google.cloud.compute.v1.ListXpnHostsProjectsRequest;
import com.google.cloud.compute.v1.MoveDiskProjectRequest;
import com.google.cloud.compute.v1.MoveInstanceProjectRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Project;
import com.google.cloud.compute.v1.ProjectsGetXpnResources;
import com.google.cloud.compute.v1.SetCommonInstanceMetadataProjectRequest;
import com.google.cloud.compute.v1.SetDefaultNetworkTierProjectRequest;
import com.google.cloud.compute.v1.SetUsageExportBucketProjectRequest;
import com.google.cloud.compute.v1.XpnHostList;
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
public class HttpJsonProjectsStub extends ProjectsStub {

  @InternalApi
  public static final ApiMethodDescriptor<DisableXpnHostProjectRequest, Operation>
      disableXpnHostMethodDescriptor =
          ApiMethodDescriptor.<DisableXpnHostProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Projects.DisableXpnHost")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisableXpnHostProjectRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/disableXpnHost",
                          new FieldsExtractor<DisableXpnHostProjectRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DisableXpnHostProjectRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DisableXpnHostProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DisableXpnHostProjectRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DisableXpnHostProjectRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DisableXpnHostProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DisableXpnHostProjectRequest, String>() {
                            @Override
                            public String extract(DisableXpnHostProjectRequest request) {
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
  public static final ApiMethodDescriptor<DisableXpnResourceProjectRequest, Operation>
      disableXpnResourceMethodDescriptor =
          ApiMethodDescriptor.<DisableXpnResourceProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Projects.DisableXpnResource")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisableXpnResourceProjectRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/disableXpnResource",
                          new FieldsExtractor<
                              DisableXpnResourceProjectRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DisableXpnResourceProjectRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DisableXpnResourceProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DisableXpnResourceProjectRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DisableXpnResourceProjectRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DisableXpnResourceProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DisableXpnResourceProjectRequest, String>() {
                            @Override
                            public String extract(DisableXpnResourceProjectRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "projectsDisableXpnResourceRequestResource",
                                      request.getProjectsDisableXpnResourceRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<EnableXpnHostProjectRequest, Operation>
      enableXpnHostMethodDescriptor =
          ApiMethodDescriptor.<EnableXpnHostProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Projects.EnableXpnHost")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnableXpnHostProjectRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/enableXpnHost",
                          new FieldsExtractor<EnableXpnHostProjectRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                EnableXpnHostProjectRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<EnableXpnHostProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              EnableXpnHostProjectRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                EnableXpnHostProjectRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<EnableXpnHostProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<EnableXpnHostProjectRequest, String>() {
                            @Override
                            public String extract(EnableXpnHostProjectRequest request) {
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
  public static final ApiMethodDescriptor<EnableXpnResourceProjectRequest, Operation>
      enableXpnResourceMethodDescriptor =
          ApiMethodDescriptor.<EnableXpnResourceProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Projects.EnableXpnResource")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnableXpnResourceProjectRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/enableXpnResource",
                          new FieldsExtractor<
                              EnableXpnResourceProjectRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                EnableXpnResourceProjectRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<EnableXpnResourceProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              EnableXpnResourceProjectRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                EnableXpnResourceProjectRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<EnableXpnResourceProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<EnableXpnResourceProjectRequest, String>() {
                            @Override
                            public String extract(EnableXpnResourceProjectRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "projectsEnableXpnResourceRequestResource",
                                      request.getProjectsEnableXpnResourceRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetProjectRequest, Project> getMethodDescriptor =
      ApiMethodDescriptor.<GetProjectRequest, Project>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Projects.Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetProjectRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}",
                      new FieldsExtractor<GetProjectRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetProjectRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetProjectRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetProjectRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetProjectRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetProjectRequest> serializer =
                              ProtoRestSerializer.create();

                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetProjectRequest, String>() {
                        @Override
                        public String extract(GetProjectRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Project>newBuilder()
                  .setDefaultInstance(Project.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetXpnHostProjectRequest, Project>
      getXpnHostMethodDescriptor =
          ApiMethodDescriptor.<GetXpnHostProjectRequest, Project>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Projects.GetXpnHost")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetXpnHostProjectRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/getXpnHost",
                          new FieldsExtractor<GetXpnHostProjectRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetXpnHostProjectRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetXpnHostProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetXpnHostProjectRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetXpnHostProjectRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetXpnHostProjectRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetXpnHostProjectRequest, String>() {
                            @Override
                            public String extract(GetXpnHostProjectRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Project>newBuilder()
                      .setDefaultInstance(Project.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources>
      getXpnResourcesMethodDescriptor =
          ApiMethodDescriptor.<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Projects.GetXpnResources")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetXpnResourcesProjectsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/getXpnResources",
                          new FieldsExtractor<
                              GetXpnResourcesProjectsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetXpnResourcesProjectsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetXpnResourcesProjectsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetXpnResourcesProjectsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetXpnResourcesProjectsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetXpnResourcesProjectsRequest> serializer =
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
                          new FieldsExtractor<GetXpnResourcesProjectsRequest, String>() {
                            @Override
                            public String extract(GetXpnResourcesProjectsRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProjectsGetXpnResources>newBuilder()
                      .setDefaultInstance(ProjectsGetXpnResources.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListXpnHostsProjectsRequest, XpnHostList>
      listXpnHostsMethodDescriptor =
          ApiMethodDescriptor.<ListXpnHostsProjectsRequest, XpnHostList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Projects.ListXpnHosts")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListXpnHostsProjectsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/listXpnHosts",
                          new FieldsExtractor<ListXpnHostsProjectsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListXpnHostsProjectsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListXpnHostsProjectsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListXpnHostsProjectsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListXpnHostsProjectsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListXpnHostsProjectsRequest> serializer =
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
                          new FieldsExtractor<ListXpnHostsProjectsRequest, String>() {
                            @Override
                            public String extract(ListXpnHostsProjectsRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "projectsListXpnHostsRequestResource",
                                      request.getProjectsListXpnHostsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<XpnHostList>newBuilder()
                      .setDefaultInstance(XpnHostList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<MoveDiskProjectRequest, Operation>
      moveDiskMethodDescriptor =
          ApiMethodDescriptor.<MoveDiskProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Projects.MoveDisk")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MoveDiskProjectRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/moveDisk",
                          new FieldsExtractor<MoveDiskProjectRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(MoveDiskProjectRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<MoveDiskProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<MoveDiskProjectRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                MoveDiskProjectRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<MoveDiskProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<MoveDiskProjectRequest, String>() {
                            @Override
                            public String extract(MoveDiskProjectRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "diskMoveRequestResource",
                                      request.getDiskMoveRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<MoveInstanceProjectRequest, Operation>
      moveInstanceMethodDescriptor =
          ApiMethodDescriptor.<MoveInstanceProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Projects.MoveInstance")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MoveInstanceProjectRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/moveInstance",
                          new FieldsExtractor<MoveInstanceProjectRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(MoveInstanceProjectRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<MoveInstanceProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              MoveInstanceProjectRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                MoveInstanceProjectRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<MoveInstanceProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<MoveInstanceProjectRequest, String>() {
                            @Override
                            public String extract(MoveInstanceProjectRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceMoveRequestResource",
                                      request.getInstanceMoveRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetCommonInstanceMetadataProjectRequest, Operation>
      setCommonInstanceMetadataMethodDescriptor =
          ApiMethodDescriptor.<SetCommonInstanceMetadataProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Projects.SetCommonInstanceMetadata")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetCommonInstanceMetadataProjectRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/setCommonInstanceMetadata",
                          new FieldsExtractor<
                              SetCommonInstanceMetadataProjectRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetCommonInstanceMetadataProjectRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetCommonInstanceMetadataProjectRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetCommonInstanceMetadataProjectRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetCommonInstanceMetadataProjectRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetCommonInstanceMetadataProjectRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetCommonInstanceMetadataProjectRequest, String>() {
                            @Override
                            public String extract(SetCommonInstanceMetadataProjectRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("metadataResource", request.getMetadataResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetDefaultNetworkTierProjectRequest, Operation>
      setDefaultNetworkTierMethodDescriptor =
          ApiMethodDescriptor.<SetDefaultNetworkTierProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Projects.SetDefaultNetworkTier")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetDefaultNetworkTierProjectRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/setDefaultNetworkTier",
                          new FieldsExtractor<
                              SetDefaultNetworkTierProjectRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetDefaultNetworkTierProjectRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetDefaultNetworkTierProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetDefaultNetworkTierProjectRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetDefaultNetworkTierProjectRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetDefaultNetworkTierProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetDefaultNetworkTierProjectRequest, String>() {
                            @Override
                            public String extract(SetDefaultNetworkTierProjectRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "projectsSetDefaultNetworkTierRequestResource",
                                      request.getProjectsSetDefaultNetworkTierRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetUsageExportBucketProjectRequest, Operation>
      setUsageExportBucketMethodDescriptor =
          ApiMethodDescriptor.<SetUsageExportBucketProjectRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Projects.SetUsageExportBucket")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetUsageExportBucketProjectRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/setUsageExportBucket",
                          new FieldsExtractor<
                              SetUsageExportBucketProjectRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetUsageExportBucketProjectRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetUsageExportBucketProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetUsageExportBucketProjectRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetUsageExportBucketProjectRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetUsageExportBucketProjectRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetUsageExportBucketProjectRequest, String>() {
                            @Override
                            public String extract(SetUsageExportBucketProjectRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "usageExportLocationResource",
                                      request.getUsageExportLocationResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DisableXpnHostProjectRequest, Operation> disableXpnHostCallable;
  private final UnaryCallable<DisableXpnResourceProjectRequest, Operation>
      disableXpnResourceCallable;
  private final UnaryCallable<EnableXpnHostProjectRequest, Operation> enableXpnHostCallable;
  private final UnaryCallable<EnableXpnResourceProjectRequest, Operation> enableXpnResourceCallable;
  private final UnaryCallable<GetProjectRequest, Project> getCallable;
  private final UnaryCallable<GetXpnHostProjectRequest, Project> getXpnHostCallable;
  private final UnaryCallable<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources>
      getXpnResourcesCallable;
  private final UnaryCallable<GetXpnResourcesProjectsRequest, GetXpnResourcesPagedResponse>
      getXpnResourcesPagedCallable;
  private final UnaryCallable<ListXpnHostsProjectsRequest, XpnHostList> listXpnHostsCallable;
  private final UnaryCallable<ListXpnHostsProjectsRequest, ListXpnHostsPagedResponse>
      listXpnHostsPagedCallable;
  private final UnaryCallable<MoveDiskProjectRequest, Operation> moveDiskCallable;
  private final UnaryCallable<MoveInstanceProjectRequest, Operation> moveInstanceCallable;
  private final UnaryCallable<SetCommonInstanceMetadataProjectRequest, Operation>
      setCommonInstanceMetadataCallable;
  private final UnaryCallable<SetDefaultNetworkTierProjectRequest, Operation>
      setDefaultNetworkTierCallable;
  private final UnaryCallable<SetUsageExportBucketProjectRequest, Operation>
      setUsageExportBucketCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonProjectsStub create(ProjectsStubSettings settings)
      throws IOException {
    return new HttpJsonProjectsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonProjectsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonProjectsStub(ProjectsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonProjectsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonProjectsStub(
        ProjectsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonProjectsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonProjectsStub(ProjectsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonProjectsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonProjectsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonProjectsStub(
      ProjectsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DisableXpnHostProjectRequest, Operation> disableXpnHostTransportSettings =
        HttpJsonCallSettings.<DisableXpnHostProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(disableXpnHostMethodDescriptor)
            .build();
    HttpJsonCallSettings<DisableXpnResourceProjectRequest, Operation>
        disableXpnResourceTransportSettings =
            HttpJsonCallSettings.<DisableXpnResourceProjectRequest, Operation>newBuilder()
                .setMethodDescriptor(disableXpnResourceMethodDescriptor)
                .build();
    HttpJsonCallSettings<EnableXpnHostProjectRequest, Operation> enableXpnHostTransportSettings =
        HttpJsonCallSettings.<EnableXpnHostProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(enableXpnHostMethodDescriptor)
            .build();
    HttpJsonCallSettings<EnableXpnResourceProjectRequest, Operation>
        enableXpnResourceTransportSettings =
            HttpJsonCallSettings.<EnableXpnResourceProjectRequest, Operation>newBuilder()
                .setMethodDescriptor(enableXpnResourceMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetProjectRequest, Project> getTransportSettings =
        HttpJsonCallSettings.<GetProjectRequest, Project>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetXpnHostProjectRequest, Project> getXpnHostTransportSettings =
        HttpJsonCallSettings.<GetXpnHostProjectRequest, Project>newBuilder()
            .setMethodDescriptor(getXpnHostMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources>
        getXpnResourcesTransportSettings =
            HttpJsonCallSettings
                .<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources>newBuilder()
                .setMethodDescriptor(getXpnResourcesMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListXpnHostsProjectsRequest, XpnHostList> listXpnHostsTransportSettings =
        HttpJsonCallSettings.<ListXpnHostsProjectsRequest, XpnHostList>newBuilder()
            .setMethodDescriptor(listXpnHostsMethodDescriptor)
            .build();
    HttpJsonCallSettings<MoveDiskProjectRequest, Operation> moveDiskTransportSettings =
        HttpJsonCallSettings.<MoveDiskProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(moveDiskMethodDescriptor)
            .build();
    HttpJsonCallSettings<MoveInstanceProjectRequest, Operation> moveInstanceTransportSettings =
        HttpJsonCallSettings.<MoveInstanceProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(moveInstanceMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetCommonInstanceMetadataProjectRequest, Operation>
        setCommonInstanceMetadataTransportSettings =
            HttpJsonCallSettings.<SetCommonInstanceMetadataProjectRequest, Operation>newBuilder()
                .setMethodDescriptor(setCommonInstanceMetadataMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetDefaultNetworkTierProjectRequest, Operation>
        setDefaultNetworkTierTransportSettings =
            HttpJsonCallSettings.<SetDefaultNetworkTierProjectRequest, Operation>newBuilder()
                .setMethodDescriptor(setDefaultNetworkTierMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetUsageExportBucketProjectRequest, Operation>
        setUsageExportBucketTransportSettings =
            HttpJsonCallSettings.<SetUsageExportBucketProjectRequest, Operation>newBuilder()
                .setMethodDescriptor(setUsageExportBucketMethodDescriptor)
                .build();

    this.disableXpnHostCallable =
        callableFactory.createUnaryCallable(
            disableXpnHostTransportSettings, settings.disableXpnHostSettings(), clientContext);
    this.disableXpnResourceCallable =
        callableFactory.createUnaryCallable(
            disableXpnResourceTransportSettings,
            settings.disableXpnResourceSettings(),
            clientContext);
    this.enableXpnHostCallable =
        callableFactory.createUnaryCallable(
            enableXpnHostTransportSettings, settings.enableXpnHostSettings(), clientContext);
    this.enableXpnResourceCallable =
        callableFactory.createUnaryCallable(
            enableXpnResourceTransportSettings,
            settings.enableXpnResourceSettings(),
            clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getXpnHostCallable =
        callableFactory.createUnaryCallable(
            getXpnHostTransportSettings, settings.getXpnHostSettings(), clientContext);
    this.getXpnResourcesCallable =
        callableFactory.createUnaryCallable(
            getXpnResourcesTransportSettings, settings.getXpnResourcesSettings(), clientContext);
    this.getXpnResourcesPagedCallable =
        callableFactory.createPagedCallable(
            getXpnResourcesTransportSettings, settings.getXpnResourcesSettings(), clientContext);
    this.listXpnHostsCallable =
        callableFactory.createUnaryCallable(
            listXpnHostsTransportSettings, settings.listXpnHostsSettings(), clientContext);
    this.listXpnHostsPagedCallable =
        callableFactory.createPagedCallable(
            listXpnHostsTransportSettings, settings.listXpnHostsSettings(), clientContext);
    this.moveDiskCallable =
        callableFactory.createUnaryCallable(
            moveDiskTransportSettings, settings.moveDiskSettings(), clientContext);
    this.moveInstanceCallable =
        callableFactory.createUnaryCallable(
            moveInstanceTransportSettings, settings.moveInstanceSettings(), clientContext);
    this.setCommonInstanceMetadataCallable =
        callableFactory.createUnaryCallable(
            setCommonInstanceMetadataTransportSettings,
            settings.setCommonInstanceMetadataSettings(),
            clientContext);
    this.setDefaultNetworkTierCallable =
        callableFactory.createUnaryCallable(
            setDefaultNetworkTierTransportSettings,
            settings.setDefaultNetworkTierSettings(),
            clientContext);
    this.setUsageExportBucketCallable =
        callableFactory.createUnaryCallable(
            setUsageExportBucketTransportSettings,
            settings.setUsageExportBucketSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DisableXpnHostProjectRequest, Operation> disableXpnHostCallable() {
    return disableXpnHostCallable;
  }

  public UnaryCallable<DisableXpnResourceProjectRequest, Operation> disableXpnResourceCallable() {
    return disableXpnResourceCallable;
  }

  public UnaryCallable<EnableXpnHostProjectRequest, Operation> enableXpnHostCallable() {
    return enableXpnHostCallable;
  }

  public UnaryCallable<EnableXpnResourceProjectRequest, Operation> enableXpnResourceCallable() {
    return enableXpnResourceCallable;
  }

  public UnaryCallable<GetProjectRequest, Project> getCallable() {
    return getCallable;
  }

  public UnaryCallable<GetXpnHostProjectRequest, Project> getXpnHostCallable() {
    return getXpnHostCallable;
  }

  public UnaryCallable<GetXpnResourcesProjectsRequest, GetXpnResourcesPagedResponse>
      getXpnResourcesPagedCallable() {
    return getXpnResourcesPagedCallable;
  }

  public UnaryCallable<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources>
      getXpnResourcesCallable() {
    return getXpnResourcesCallable;
  }

  public UnaryCallable<ListXpnHostsProjectsRequest, ListXpnHostsPagedResponse>
      listXpnHostsPagedCallable() {
    return listXpnHostsPagedCallable;
  }

  public UnaryCallable<ListXpnHostsProjectsRequest, XpnHostList> listXpnHostsCallable() {
    return listXpnHostsCallable;
  }

  public UnaryCallable<MoveDiskProjectRequest, Operation> moveDiskCallable() {
    return moveDiskCallable;
  }

  public UnaryCallable<MoveInstanceProjectRequest, Operation> moveInstanceCallable() {
    return moveInstanceCallable;
  }

  public UnaryCallable<SetCommonInstanceMetadataProjectRequest, Operation>
      setCommonInstanceMetadataCallable() {
    return setCommonInstanceMetadataCallable;
  }

  public UnaryCallable<SetDefaultNetworkTierProjectRequest, Operation>
      setDefaultNetworkTierCallable() {
    return setDefaultNetworkTierCallable;
  }

  public UnaryCallable<SetUsageExportBucketProjectRequest, Operation>
      setUsageExportBucketCallable() {
    return setUsageExportBucketCallable;
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
