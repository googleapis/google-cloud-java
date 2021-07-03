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

import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupsClient.ListNetworkEndpointsPagedResponse;
import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.DeleteGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.GetGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.InsertGlobalNetworkEndpointGroupRequest;
import com.google.cloud.compute.v1.ListGlobalNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupList;
import com.google.cloud.compute.v1.NetworkEndpointGroupsListNetworkEndpoints;
import com.google.cloud.compute.v1.Operation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the GlobalNetworkEndpointGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonGlobalNetworkEndpointGroupsStub extends GlobalNetworkEndpointGroupsStub {
  private static final ApiMethodDescriptor<
          AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsMethodDescriptor =
          ApiMethodDescriptor
              .<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.GlobalNetworkEndpointGroups/AttachNetworkEndpoints")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}/attachNetworkEndpoints",
                          new FieldsExtractor<
                              AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "networkEndpointGroup",
                                  request.getNetworkEndpointGroup());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, String>() {
                            @Override
                            public String extract(
                                AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "globalNetworkEndpointGroupsAttachEndpointsRequestResource",
                                      request
                                          .getGlobalNetworkEndpointGroupsAttachEndpointsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteGlobalNetworkEndpointGroupRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalNetworkEndpointGroups/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGlobalNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}",
                          new FieldsExtractor<
                              DeleteGlobalNetworkEndpointGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteGlobalNetworkEndpointGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteGlobalNetworkEndpointGroupRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "networkEndpointGroup",
                                  request.getNetworkEndpointGroup());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteGlobalNetworkEndpointGroupRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteGlobalNetworkEndpointGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteGlobalNetworkEndpointGroupRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteGlobalNetworkEndpointGroupRequest, String>() {
                            @Override
                            public String extract(DeleteGlobalNetworkEndpointGroupRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsMethodDescriptor =
          ApiMethodDescriptor
              .<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.GlobalNetworkEndpointGroups/DetachNetworkEndpoints")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}/detachNetworkEndpoints",
                          new FieldsExtractor<
                              DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "networkEndpointGroup",
                                  request.getNetworkEndpointGroup());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, String>() {
                            @Override
                            public String extract(
                                DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "globalNetworkEndpointGroupsDetachEndpointsRequestResource",
                                      request
                                          .getGlobalNetworkEndpointGroupsDetachEndpointsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalNetworkEndpointGroups/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlobalNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}",
                          new FieldsExtractor<
                              GetGlobalNetworkEndpointGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetGlobalNetworkEndpointGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetGlobalNetworkEndpointGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "networkEndpointGroup",
                                  request.getNetworkEndpointGroup());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetGlobalNetworkEndpointGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetGlobalNetworkEndpointGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetGlobalNetworkEndpointGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetGlobalNetworkEndpointGroupRequest, String>() {
                            @Override
                            public String extract(GetGlobalNetworkEndpointGroupRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NetworkEndpointGroup>newBuilder()
                      .setDefaultInstance(NetworkEndpointGroup.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertGlobalNetworkEndpointGroupRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalNetworkEndpointGroups/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertGlobalNetworkEndpointGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networkEndpointGroups",
                          new FieldsExtractor<
                              InsertGlobalNetworkEndpointGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertGlobalNetworkEndpointGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertGlobalNetworkEndpointGroupRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertGlobalNetworkEndpointGroupRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertGlobalNetworkEndpointGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertGlobalNetworkEndpointGroupRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertGlobalNetworkEndpointGroupRequest, String>() {
                            @Override
                            public String extract(InsertGlobalNetworkEndpointGroupRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "networkEndpointGroupResource",
                                      request.getNetworkEndpointGroupResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalNetworkEndpointGroups/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlobalNetworkEndpointGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networkEndpointGroups",
                          new FieldsExtractor<
                              ListGlobalNetworkEndpointGroupsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListGlobalNetworkEndpointGroupsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListGlobalNetworkEndpointGroupsRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListGlobalNetworkEndpointGroupsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListGlobalNetworkEndpointGroupsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListGlobalNetworkEndpointGroupsRequest>
                                  serializer = ProtoRestSerializer.create();
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
                          new FieldsExtractor<ListGlobalNetworkEndpointGroupsRequest, String>() {
                            @Override
                            public String extract(ListGlobalNetworkEndpointGroupsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NetworkEndpointGroupList>newBuilder()
                      .setDefaultInstance(NetworkEndpointGroupList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsMethodDescriptor =
          ApiMethodDescriptor
              .<ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
                  NetworkEndpointGroupsListNetworkEndpoints>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.GlobalNetworkEndpointGroups/ListNetworkEndpoints")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}/listNetworkEndpoints",
                          new FieldsExtractor<
                              ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "networkEndpointGroup",
                                  request.getNetworkEndpointGroup());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest>
                                  serializer = ProtoRestSerializer.create();
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
                          new FieldsExtractor<
                              ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest, String>() {
                            @Override
                            public String extract(
                                ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NetworkEndpointGroupsListNetworkEndpoints>newBuilder()
                      .setDefaultInstance(
                          NetworkEndpointGroupsListNetworkEndpoints.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsCallable;
  private final UnaryCallable<DeleteGlobalNetworkEndpointGroupRequest, Operation> deleteCallable;
  private final UnaryCallable<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsCallable;
  private final UnaryCallable<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>
      getCallable;
  private final UnaryCallable<InsertGlobalNetworkEndpointGroupRequest, Operation> insertCallable;
  private final UnaryCallable<ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listCallable;
  private final UnaryCallable<ListGlobalNetworkEndpointGroupsRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsCallable;
  private final UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest, ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGlobalNetworkEndpointGroupsStub create(
      GlobalNetworkEndpointGroupsStubSettings settings) throws IOException {
    return new HttpJsonGlobalNetworkEndpointGroupsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGlobalNetworkEndpointGroupsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGlobalNetworkEndpointGroupsStub(
        GlobalNetworkEndpointGroupsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGlobalNetworkEndpointGroupsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGlobalNetworkEndpointGroupsStub(
        GlobalNetworkEndpointGroupsStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGlobalNetworkEndpointGroupsStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGlobalNetworkEndpointGroupsStub(
      GlobalNetworkEndpointGroupsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGlobalNetworkEndpointGroupsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGlobalNetworkEndpointGroupsStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGlobalNetworkEndpointGroupsStub(
      GlobalNetworkEndpointGroupsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
        attachNetworkEndpointsTransportSettings =
            HttpJsonCallSettings
                .<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(attachNetworkEndpointsMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteGlobalNetworkEndpointGroupRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .build();
    HttpJsonCallSettings<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
        detachNetworkEndpointsTransportSettings =
            HttpJsonCallSettings
                .<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(detachNetworkEndpointsMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertGlobalNetworkEndpointGroupRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertGlobalNetworkEndpointGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
            NetworkEndpointGroupsListNetworkEndpoints>
        listNetworkEndpointsTransportSettings =
            HttpJsonCallSettings
                .<ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
                    NetworkEndpointGroupsListNetworkEndpoints>
                    newBuilder()
                .setMethodDescriptor(listNetworkEndpointsMethodDescriptor)
                .build();

    this.attachNetworkEndpointsCallable =
        callableFactory.createUnaryCallable(
            attachNetworkEndpointsTransportSettings,
            settings.attachNetworkEndpointsSettings(),
            clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.detachNetworkEndpointsCallable =
        callableFactory.createUnaryCallable(
            detachNetworkEndpointsTransportSettings,
            settings.detachNetworkEndpointsSettings(),
            clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listNetworkEndpointsCallable =
        callableFactory.createUnaryCallable(
            listNetworkEndpointsTransportSettings,
            settings.listNetworkEndpointsSettings(),
            clientContext);
    this.listNetworkEndpointsPagedCallable =
        callableFactory.createPagedCallable(
            listNetworkEndpointsTransportSettings,
            settings.listNetworkEndpointsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(attachNetworkEndpointsMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(detachNetworkEndpointsMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(listNetworkEndpointsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AttachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      attachNetworkEndpointsCallable() {
    return attachNetworkEndpointsCallable;
  }

  @Override
  public UnaryCallable<DeleteGlobalNetworkEndpointGroupRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<DetachNetworkEndpointsGlobalNetworkEndpointGroupRequest, Operation>
      detachNetworkEndpointsCallable() {
    return detachNetworkEndpointsCallable;
  }

  @Override
  public UnaryCallable<GetGlobalNetworkEndpointGroupRequest, NetworkEndpointGroup> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertGlobalNetworkEndpointGroupRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListGlobalNetworkEndpointGroupsRequest, NetworkEndpointGroupList>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListGlobalNetworkEndpointGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsCallable() {
    return listNetworkEndpointsCallable;
  }

  @Override
  public UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsRequest, ListNetworkEndpointsPagedResponse>
      listNetworkEndpointsPagedCallable() {
    return listNetworkEndpointsPagedCallable;
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
