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

import static com.google.cloud.compute.v1.TargetSslProxiesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteTargetSslProxyRequest;
import com.google.cloud.compute.v1.GetTargetSslProxyRequest;
import com.google.cloud.compute.v1.InsertTargetSslProxyRequest;
import com.google.cloud.compute.v1.ListTargetSslProxiesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetBackendServiceTargetSslProxyRequest;
import com.google.cloud.compute.v1.SetProxyHeaderTargetSslProxyRequest;
import com.google.cloud.compute.v1.SetSslCertificatesTargetSslProxyRequest;
import com.google.cloud.compute.v1.SetSslPolicyTargetSslProxyRequest;
import com.google.cloud.compute.v1.TargetSslProxy;
import com.google.cloud.compute.v1.TargetSslProxyList;
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
public class HttpJsonTargetSslProxiesStub extends TargetSslProxiesStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteTargetSslProxyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetSslProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies/{targetSslProxy}",
                          new FieldsExtractor<DeleteTargetSslProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteTargetSslProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteTargetSslProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetSslProxy", request.getTargetSslProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteTargetSslProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteTargetSslProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteTargetSslProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteTargetSslProxyRequest, String>() {
                            @Override
                            public String extract(DeleteTargetSslProxyRequest request) {
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
  public static final ApiMethodDescriptor<GetTargetSslProxyRequest, TargetSslProxy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetTargetSslProxyRequest, TargetSslProxy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies/{targetSslProxy}",
                          new FieldsExtractor<GetTargetSslProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetTargetSslProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetTargetSslProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetSslProxy", request.getTargetSslProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetTargetSslProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetTargetSslProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetTargetSslProxyRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetTargetSslProxyRequest, String>() {
                            @Override
                            public String extract(GetTargetSslProxyRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetSslProxy>newBuilder()
                      .setDefaultInstance(TargetSslProxy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertTargetSslProxyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetSslProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies",
                          new FieldsExtractor<InsertTargetSslProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertTargetSslProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertTargetSslProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertTargetSslProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertTargetSslProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertTargetSslProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertTargetSslProxyRequest, String>() {
                            @Override
                            public String extract(InsertTargetSslProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetSslProxyResource",
                                      request.getTargetSslProxyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListTargetSslProxiesRequest, TargetSslProxyList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListTargetSslProxiesRequest, TargetSslProxyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTargetSslProxiesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies",
                          new FieldsExtractor<ListTargetSslProxiesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListTargetSslProxiesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListTargetSslProxiesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListTargetSslProxiesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListTargetSslProxiesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListTargetSslProxiesRequest> serializer =
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
                          new FieldsExtractor<ListTargetSslProxiesRequest, String>() {
                            @Override
                            public String extract(ListTargetSslProxiesRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetSslProxyList>newBuilder()
                      .setDefaultInstance(TargetSslProxyList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetBackendServiceTargetSslProxyRequest, Operation>
      setBackendServiceMethodDescriptor =
          ApiMethodDescriptor.<SetBackendServiceTargetSslProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies.SetBackendService")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetBackendServiceTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies/{targetSslProxy}/setBackendService",
                          new FieldsExtractor<
                              SetBackendServiceTargetSslProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetBackendServiceTargetSslProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetBackendServiceTargetSslProxyRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetSslProxy", request.getTargetSslProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetBackendServiceTargetSslProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetBackendServiceTargetSslProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetBackendServiceTargetSslProxyRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetBackendServiceTargetSslProxyRequest, String>() {
                            @Override
                            public String extract(SetBackendServiceTargetSslProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetSslProxiesSetBackendServiceRequestResource",
                                      request
                                          .getTargetSslProxiesSetBackendServiceRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetProxyHeaderTargetSslProxyRequest, Operation>
      setProxyHeaderMethodDescriptor =
          ApiMethodDescriptor.<SetProxyHeaderTargetSslProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies.SetProxyHeader")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetProxyHeaderTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies/{targetSslProxy}/setProxyHeader",
                          new FieldsExtractor<
                              SetProxyHeaderTargetSslProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetProxyHeaderTargetSslProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetProxyHeaderTargetSslProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetSslProxy", request.getTargetSslProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetProxyHeaderTargetSslProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetProxyHeaderTargetSslProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetProxyHeaderTargetSslProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetProxyHeaderTargetSslProxyRequest, String>() {
                            @Override
                            public String extract(SetProxyHeaderTargetSslProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetSslProxiesSetProxyHeaderRequestResource",
                                      request.getTargetSslProxiesSetProxyHeaderRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetSslCertificatesTargetSslProxyRequest, Operation>
      setSslCertificatesMethodDescriptor =
          ApiMethodDescriptor.<SetSslCertificatesTargetSslProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies.SetSslCertificates")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetSslCertificatesTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies/{targetSslProxy}/setSslCertificates",
                          new FieldsExtractor<
                              SetSslCertificatesTargetSslProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetSslCertificatesTargetSslProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetSslCertificatesTargetSslProxyRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetSslProxy", request.getTargetSslProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetSslCertificatesTargetSslProxyRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetSslCertificatesTargetSslProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetSslCertificatesTargetSslProxyRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetSslCertificatesTargetSslProxyRequest, String>() {
                            @Override
                            public String extract(SetSslCertificatesTargetSslProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "targetSslProxiesSetSslCertificatesRequestResource",
                                      request
                                          .getTargetSslProxiesSetSslCertificatesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetSslPolicyTargetSslProxyRequest, Operation>
      setSslPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetSslPolicyTargetSslProxyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.TargetSslProxies.SetSslPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetSslPolicyTargetSslProxyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/targetSslProxies/{targetSslProxy}/setSslPolicy",
                          new FieldsExtractor<
                              SetSslPolicyTargetSslProxyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetSslPolicyTargetSslProxyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetSslPolicyTargetSslProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "targetSslProxy", request.getTargetSslProxy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetSslPolicyTargetSslProxyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetSslPolicyTargetSslProxyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetSslPolicyTargetSslProxyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetSslPolicyTargetSslProxyRequest, String>() {
                            @Override
                            public String extract(SetSslPolicyTargetSslProxyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "sslPolicyReferenceResource",
                                      request.getSslPolicyReferenceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteTargetSslProxyRequest, Operation> deleteCallable;
  private final UnaryCallable<GetTargetSslProxyRequest, TargetSslProxy> getCallable;
  private final UnaryCallable<InsertTargetSslProxyRequest, Operation> insertCallable;
  private final UnaryCallable<ListTargetSslProxiesRequest, TargetSslProxyList> listCallable;
  private final UnaryCallable<ListTargetSslProxiesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<SetBackendServiceTargetSslProxyRequest, Operation>
      setBackendServiceCallable;
  private final UnaryCallable<SetProxyHeaderTargetSslProxyRequest, Operation>
      setProxyHeaderCallable;
  private final UnaryCallable<SetSslCertificatesTargetSslProxyRequest, Operation>
      setSslCertificatesCallable;
  private final UnaryCallable<SetSslPolicyTargetSslProxyRequest, Operation> setSslPolicyCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetSslProxiesStub create(TargetSslProxiesStubSettings settings)
      throws IOException {
    return new HttpJsonTargetSslProxiesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetSslProxiesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetSslProxiesStub(
        TargetSslProxiesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetSslProxiesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetSslProxiesStub(
        TargetSslProxiesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetSslProxiesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetSslProxiesStub(
      TargetSslProxiesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTargetSslProxiesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetSslProxiesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetSslProxiesStub(
      TargetSslProxiesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteTargetSslProxyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteTargetSslProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetTargetSslProxyRequest, TargetSslProxy> getTransportSettings =
        HttpJsonCallSettings.<GetTargetSslProxyRequest, TargetSslProxy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertTargetSslProxyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertTargetSslProxyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListTargetSslProxiesRequest, TargetSslProxyList> listTransportSettings =
        HttpJsonCallSettings.<ListTargetSslProxiesRequest, TargetSslProxyList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetBackendServiceTargetSslProxyRequest, Operation>
        setBackendServiceTransportSettings =
            HttpJsonCallSettings.<SetBackendServiceTargetSslProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setBackendServiceMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetProxyHeaderTargetSslProxyRequest, Operation>
        setProxyHeaderTransportSettings =
            HttpJsonCallSettings.<SetProxyHeaderTargetSslProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setProxyHeaderMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetSslCertificatesTargetSslProxyRequest, Operation>
        setSslCertificatesTransportSettings =
            HttpJsonCallSettings.<SetSslCertificatesTargetSslProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslCertificatesMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetSslPolicyTargetSslProxyRequest, Operation>
        setSslPolicyTransportSettings =
            HttpJsonCallSettings.<SetSslPolicyTargetSslProxyRequest, Operation>newBuilder()
                .setMethodDescriptor(setSslPolicyMethodDescriptor)
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
    this.setBackendServiceCallable =
        callableFactory.createUnaryCallable(
            setBackendServiceTransportSettings,
            settings.setBackendServiceSettings(),
            clientContext);
    this.setProxyHeaderCallable =
        callableFactory.createUnaryCallable(
            setProxyHeaderTransportSettings, settings.setProxyHeaderSettings(), clientContext);
    this.setSslCertificatesCallable =
        callableFactory.createUnaryCallable(
            setSslCertificatesTransportSettings,
            settings.setSslCertificatesSettings(),
            clientContext);
    this.setSslPolicyCallable =
        callableFactory.createUnaryCallable(
            setSslPolicyTransportSettings, settings.setSslPolicySettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DeleteTargetSslProxyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetTargetSslProxyRequest, TargetSslProxy> getCallable() {
    return getCallable;
  }

  public UnaryCallable<InsertTargetSslProxyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListTargetSslProxiesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListTargetSslProxiesRequest, TargetSslProxyList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<SetBackendServiceTargetSslProxyRequest, Operation>
      setBackendServiceCallable() {
    return setBackendServiceCallable;
  }

  public UnaryCallable<SetProxyHeaderTargetSslProxyRequest, Operation> setProxyHeaderCallable() {
    return setProxyHeaderCallable;
  }

  public UnaryCallable<SetSslCertificatesTargetSslProxyRequest, Operation>
      setSslCertificatesCallable() {
    return setSslCertificatesCallable;
  }

  public UnaryCallable<SetSslPolicyTargetSslProxyRequest, Operation> setSslPolicyCallable() {
    return setSslPolicyCallable;
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
