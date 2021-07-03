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

import static com.google.cloud.compute.v1.FirewallsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteFirewallRequest;
import com.google.cloud.compute.v1.Firewall;
import com.google.cloud.compute.v1.FirewallList;
import com.google.cloud.compute.v1.GetFirewallRequest;
import com.google.cloud.compute.v1.InsertFirewallRequest;
import com.google.cloud.compute.v1.ListFirewallsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchFirewallRequest;
import com.google.cloud.compute.v1.UpdateFirewallRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Firewalls service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonFirewallsStub extends FirewallsStub {
  private static final ApiMethodDescriptor<DeleteFirewallRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteFirewallRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Firewalls/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFirewallRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewalls/{firewall}",
                          new FieldsExtractor<DeleteFirewallRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteFirewallRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteFirewallRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "firewall", request.getFirewall());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<DeleteFirewallRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteFirewallRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteFirewallRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteFirewallRequest, String>() {
                            @Override
                            public String extract(DeleteFirewallRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFirewallRequest, Firewall> getMethodDescriptor =
      ApiMethodDescriptor.<GetFirewallRequest, Firewall>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Firewalls/Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetFirewallRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/firewalls/{firewall}",
                      new FieldsExtractor<GetFirewallRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetFirewallRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetFirewallRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "firewall", request.getFirewall());
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetFirewallRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetFirewallRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetFirewallRequest> serializer =
                              ProtoRestSerializer.create();
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetFirewallRequest, String>() {
                        @Override
                        public String extract(GetFirewallRequest request) {
                          return null;
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Firewall>newBuilder()
                  .setDefaultInstance(Firewall.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<InsertFirewallRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertFirewallRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Firewalls/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertFirewallRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewalls",
                          new FieldsExtractor<InsertFirewallRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(InsertFirewallRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertFirewallRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<InsertFirewallRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertFirewallRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertFirewallRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertFirewallRequest, String>() {
                            @Override
                            public String extract(InsertFirewallRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("firewallResource", request.getFirewallResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListFirewallsRequest, FirewallList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListFirewallsRequest, FirewallList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Firewalls/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFirewallsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewalls",
                          new FieldsExtractor<ListFirewallsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListFirewallsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListFirewallsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<ListFirewallsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(ListFirewallsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListFirewallsRequest> serializer =
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
                          new FieldsExtractor<ListFirewallsRequest, String>() {
                            @Override
                            public String extract(ListFirewallsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FirewallList>newBuilder()
                      .setDefaultInstance(FirewallList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchFirewallRequest, Operation> patchMethodDescriptor =
      ApiMethodDescriptor.<PatchFirewallRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Firewalls/Patch")
          .setHttpMethod(HttpMethods.PATCH)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PatchFirewallRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/firewalls/{firewall}",
                      new FieldsExtractor<PatchFirewallRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(PatchFirewallRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<PatchFirewallRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "firewall", request.getFirewall());
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<PatchFirewallRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(PatchFirewallRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<PatchFirewallRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<PatchFirewallRequest, String>() {
                        @Override
                        public String extract(PatchFirewallRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("firewallResource", request.getFirewallResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateFirewallRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateFirewallRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Firewalls/Update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFirewallRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewalls/{firewall}",
                          new FieldsExtractor<UpdateFirewallRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(UpdateFirewallRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateFirewallRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "firewall", request.getFirewall());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<UpdateFirewallRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdateFirewallRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateFirewallRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<UpdateFirewallRequest, String>() {
                            @Override
                            public String extract(UpdateFirewallRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("firewallResource", request.getFirewallResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<DeleteFirewallRequest, Operation> deleteCallable;
  private final UnaryCallable<GetFirewallRequest, Firewall> getCallable;
  private final UnaryCallable<InsertFirewallRequest, Operation> insertCallable;
  private final UnaryCallable<ListFirewallsRequest, FirewallList> listCallable;
  private final UnaryCallable<ListFirewallsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchFirewallRequest, Operation> patchCallable;
  private final UnaryCallable<UpdateFirewallRequest, Operation> updateCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonFirewallsStub create(FirewallsStubSettings settings)
      throws IOException {
    return new HttpJsonFirewallsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonFirewallsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonFirewallsStub(FirewallsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonFirewallsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonFirewallsStub(
        FirewallsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonFirewallsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFirewallsStub(FirewallsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonFirewallsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonFirewallsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFirewallsStub(
      FirewallsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteFirewallRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteFirewallRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetFirewallRequest, Firewall> getTransportSettings =
        HttpJsonCallSettings.<GetFirewallRequest, Firewall>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertFirewallRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertFirewallRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListFirewallsRequest, FirewallList> listTransportSettings =
        HttpJsonCallSettings.<ListFirewallsRequest, FirewallList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchFirewallRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchFirewallRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateFirewallRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateFirewallRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
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
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.updateCallable =
        callableFactory.createUnaryCallable(
            updateTransportSettings, settings.updateSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(updateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteFirewallRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetFirewallRequest, Firewall> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertFirewallRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListFirewallsRequest, FirewallList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListFirewallsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchFirewallRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public UnaryCallable<UpdateFirewallRequest, Operation> updateCallable() {
    return updateCallable;
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
