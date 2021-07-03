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

import static com.google.cloud.compute.v1.RegionInstanceGroupsClient.ListInstancesPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.GetRegionInstanceGroupRequest;
import com.google.cloud.compute.v1.InstanceGroup;
import com.google.cloud.compute.v1.ListInstancesRegionInstanceGroupsRequest;
import com.google.cloud.compute.v1.ListRegionInstanceGroupsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RegionInstanceGroupList;
import com.google.cloud.compute.v1.RegionInstanceGroupsListInstances;
import com.google.cloud.compute.v1.SetNamedPortsRegionInstanceGroupRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the RegionInstanceGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonRegionInstanceGroupsStub extends RegionInstanceGroupsStub {
  private static final ApiMethodDescriptor<GetRegionInstanceGroupRequest, InstanceGroup>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetRegionInstanceGroupRequest, InstanceGroup>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroups/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionInstanceGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroups/{instanceGroup}",
                          new FieldsExtractor<
                              GetRegionInstanceGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetRegionInstanceGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionInstanceGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "instanceGroup", request.getInstanceGroup());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRegionInstanceGroupRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRegionInstanceGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionInstanceGroupRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRegionInstanceGroupRequest, String>() {
                            @Override
                            public String extract(GetRegionInstanceGroupRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceGroup>newBuilder()
                      .setDefaultInstance(InstanceGroup.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListRegionInstanceGroupsRequest, RegionInstanceGroupList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListRegionInstanceGroupsRequest, RegionInstanceGroupList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroups/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionInstanceGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroups",
                          new FieldsExtractor<
                              ListRegionInstanceGroupsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListRegionInstanceGroupsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionInstanceGroupsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListRegionInstanceGroupsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListRegionInstanceGroupsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionInstanceGroupsRequest> serializer =
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
                          new FieldsExtractor<ListRegionInstanceGroupsRequest, String>() {
                            @Override
                            public String extract(ListRegionInstanceGroupsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RegionInstanceGroupList>newBuilder()
                      .setDefaultInstance(RegionInstanceGroupList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListInstancesRegionInstanceGroupsRequest, RegionInstanceGroupsListInstances>
      listInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<ListInstancesRegionInstanceGroupsRequest, RegionInstanceGroupsListInstances>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroups/ListInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListInstancesRegionInstanceGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroups/{instanceGroup}/listInstances",
                          new FieldsExtractor<
                              ListInstancesRegionInstanceGroupsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListInstancesRegionInstanceGroupsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListInstancesRegionInstanceGroupsRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "instanceGroup", request.getInstanceGroup());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListInstancesRegionInstanceGroupsRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListInstancesRegionInstanceGroupsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListInstancesRegionInstanceGroupsRequest>
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
                          new FieldsExtractor<ListInstancesRegionInstanceGroupsRequest, String>() {
                            @Override
                            public String extract(
                                ListInstancesRegionInstanceGroupsRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionInstanceGroupsListInstancesRequestResource",
                                      request
                                          .getRegionInstanceGroupsListInstancesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RegionInstanceGroupsListInstances>newBuilder()
                      .setDefaultInstance(RegionInstanceGroupsListInstances.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetNamedPortsRegionInstanceGroupRequest, Operation>
      setNamedPortsMethodDescriptor =
          ApiMethodDescriptor.<SetNamedPortsRegionInstanceGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstanceGroups/SetNamedPorts")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetNamedPortsRegionInstanceGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroups/{instanceGroup}/setNamedPorts",
                          new FieldsExtractor<
                              SetNamedPortsRegionInstanceGroupRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetNamedPortsRegionInstanceGroupRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetNamedPortsRegionInstanceGroupRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "instanceGroup", request.getInstanceGroup());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetNamedPortsRegionInstanceGroupRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetNamedPortsRegionInstanceGroupRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetNamedPortsRegionInstanceGroupRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetNamedPortsRegionInstanceGroupRequest, String>() {
                            @Override
                            public String extract(SetNamedPortsRegionInstanceGroupRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionInstanceGroupsSetNamedPortsRequestResource",
                                      request
                                          .getRegionInstanceGroupsSetNamedPortsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<GetRegionInstanceGroupRequest, InstanceGroup> getCallable;
  private final UnaryCallable<ListRegionInstanceGroupsRequest, RegionInstanceGroupList>
      listCallable;
  private final UnaryCallable<ListRegionInstanceGroupsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<
          ListInstancesRegionInstanceGroupsRequest, RegionInstanceGroupsListInstances>
      listInstancesCallable;
  private final UnaryCallable<ListInstancesRegionInstanceGroupsRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<SetNamedPortsRegionInstanceGroupRequest, Operation>
      setNamedPortsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionInstanceGroupsStub create(
      RegionInstanceGroupsStubSettings settings) throws IOException {
    return new HttpJsonRegionInstanceGroupsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionInstanceGroupsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionInstanceGroupsStub(
        RegionInstanceGroupsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionInstanceGroupsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionInstanceGroupsStub(
        RegionInstanceGroupsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionInstanceGroupsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionInstanceGroupsStub(
      RegionInstanceGroupsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionInstanceGroupsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionInstanceGroupsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionInstanceGroupsStub(
      RegionInstanceGroupsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetRegionInstanceGroupRequest, InstanceGroup> getTransportSettings =
        HttpJsonCallSettings.<GetRegionInstanceGroupRequest, InstanceGroup>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRegionInstanceGroupsRequest, RegionInstanceGroupList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListRegionInstanceGroupsRequest, RegionInstanceGroupList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            ListInstancesRegionInstanceGroupsRequest, RegionInstanceGroupsListInstances>
        listInstancesTransportSettings =
            HttpJsonCallSettings
                .<ListInstancesRegionInstanceGroupsRequest, RegionInstanceGroupsListInstances>
                    newBuilder()
                .setMethodDescriptor(listInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetNamedPortsRegionInstanceGroupRequest, Operation>
        setNamedPortsTransportSettings =
            HttpJsonCallSettings.<SetNamedPortsRegionInstanceGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(setNamedPortsMethodDescriptor)
                .build();

    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.setNamedPortsCallable =
        callableFactory.createUnaryCallable(
            setNamedPortsTransportSettings, settings.setNamedPortsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(listInstancesMethodDescriptor);
    methodDescriptors.add(setNamedPortsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetRegionInstanceGroupRequest, InstanceGroup> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<ListRegionInstanceGroupsRequest, RegionInstanceGroupList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionInstanceGroupsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRegionInstanceGroupsRequest, RegionInstanceGroupsListInstances>
      listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRegionInstanceGroupsRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<SetNamedPortsRegionInstanceGroupRequest, Operation> setNamedPortsCallable() {
    return setNamedPortsCallable;
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
