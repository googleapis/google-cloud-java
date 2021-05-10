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

import static com.google.cloud.compute.v1.InstanceTemplatesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteInstanceTemplateRequest;
import com.google.cloud.compute.v1.GetIamPolicyInstanceTemplateRequest;
import com.google.cloud.compute.v1.GetInstanceTemplateRequest;
import com.google.cloud.compute.v1.InsertInstanceTemplateRequest;
import com.google.cloud.compute.v1.InstanceTemplate;
import com.google.cloud.compute.v1.InstanceTemplateList;
import com.google.cloud.compute.v1.ListInstanceTemplatesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyInstanceTemplateRequest;
import com.google.cloud.compute.v1.TestIamPermissionsInstanceTemplateRequest;
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
public class HttpJsonInstanceTemplatesStub extends InstanceTemplatesStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteInstanceTemplateRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceTemplateRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceTemplates.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInstanceTemplateRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/instanceTemplates/{instanceTemplate}",
                          new FieldsExtractor<
                              DeleteInstanceTemplateRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteInstanceTemplateRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteInstanceTemplateRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "instanceTemplate", request.getInstanceTemplate());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteInstanceTemplateRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteInstanceTemplateRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteInstanceTemplateRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteInstanceTemplateRequest, String>() {
                            @Override
                            public String extract(DeleteInstanceTemplateRequest request) {
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
  public static final ApiMethodDescriptor<GetInstanceTemplateRequest, InstanceTemplate>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceTemplateRequest, InstanceTemplate>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceTemplates.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstanceTemplateRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/instanceTemplates/{instanceTemplate}",
                          new FieldsExtractor<GetInstanceTemplateRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetInstanceTemplateRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetInstanceTemplateRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "instanceTemplate", request.getInstanceTemplate());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetInstanceTemplateRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetInstanceTemplateRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetInstanceTemplateRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetInstanceTemplateRequest, String>() {
                            @Override
                            public String extract(GetInstanceTemplateRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceTemplate>newBuilder()
                      .setDefaultInstance(InstanceTemplate.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetIamPolicyInstanceTemplateRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyInstanceTemplateRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceTemplates.GetIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyInstanceTemplateRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/instanceTemplates/{resource}/getIamPolicy",
                          new FieldsExtractor<
                              GetIamPolicyInstanceTemplateRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetIamPolicyInstanceTemplateRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyInstanceTemplateRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetIamPolicyInstanceTemplateRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetIamPolicyInstanceTemplateRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyInstanceTemplateRequest> serializer =
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
                          new FieldsExtractor<GetIamPolicyInstanceTemplateRequest, String>() {
                            @Override
                            public String extract(GetIamPolicyInstanceTemplateRequest request) {
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
  public static final ApiMethodDescriptor<InsertInstanceTemplateRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertInstanceTemplateRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceTemplates.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertInstanceTemplateRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/instanceTemplates",
                          new FieldsExtractor<
                              InsertInstanceTemplateRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertInstanceTemplateRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertInstanceTemplateRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertInstanceTemplateRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertInstanceTemplateRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertInstanceTemplateRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertInstanceTemplateRequest, String>() {
                            @Override
                            public String extract(InsertInstanceTemplateRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "instanceTemplateResource",
                                      request.getInstanceTemplateResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListInstanceTemplatesRequest, InstanceTemplateList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListInstanceTemplatesRequest, InstanceTemplateList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceTemplates.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstanceTemplatesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/instanceTemplates",
                          new FieldsExtractor<ListInstanceTemplatesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListInstanceTemplatesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListInstanceTemplatesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListInstanceTemplatesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListInstanceTemplatesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListInstanceTemplatesRequest> serializer =
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
                          new FieldsExtractor<ListInstanceTemplatesRequest, String>() {
                            @Override
                            public String extract(ListInstanceTemplatesRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceTemplateList>newBuilder()
                      .setDefaultInstance(InstanceTemplateList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetIamPolicyInstanceTemplateRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyInstanceTemplateRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceTemplates.SetIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyInstanceTemplateRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/instanceTemplates/{resource}/setIamPolicy",
                          new FieldsExtractor<
                              SetIamPolicyInstanceTemplateRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetIamPolicyInstanceTemplateRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyInstanceTemplateRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetIamPolicyInstanceTemplateRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetIamPolicyInstanceTemplateRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyInstanceTemplateRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetIamPolicyInstanceTemplateRequest, String>() {
                            @Override
                            public String extract(SetIamPolicyInstanceTemplateRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "globalSetPolicyRequestResource",
                                      request.getGlobalSetPolicyRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsInstanceTemplateRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsInstanceTemplateRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceTemplates.TestIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<TestIamPermissionsInstanceTemplateRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/instanceTemplates/{resource}/testIamPermissions",
                          new FieldsExtractor<
                              TestIamPermissionsInstanceTemplateRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                TestIamPermissionsInstanceTemplateRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsInstanceTemplateRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsInstanceTemplateRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                TestIamPermissionsInstanceTemplateRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsInstanceTemplateRequest>
                                  serializer = ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<TestIamPermissionsInstanceTemplateRequest, String>() {
                            @Override
                            public String extract(
                                TestIamPermissionsInstanceTemplateRequest request) {
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

  private final UnaryCallable<DeleteInstanceTemplateRequest, Operation> deleteCallable;
  private final UnaryCallable<GetInstanceTemplateRequest, InstanceTemplate> getCallable;
  private final UnaryCallable<GetIamPolicyInstanceTemplateRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertInstanceTemplateRequest, Operation> insertCallable;
  private final UnaryCallable<ListInstanceTemplatesRequest, InstanceTemplateList> listCallable;
  private final UnaryCallable<ListInstanceTemplatesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<SetIamPolicyInstanceTemplateRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsInstanceTemplateRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInstanceTemplatesStub create(InstanceTemplatesStubSettings settings)
      throws IOException {
    return new HttpJsonInstanceTemplatesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInstanceTemplatesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonInstanceTemplatesStub(
        InstanceTemplatesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInstanceTemplatesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInstanceTemplatesStub(
        InstanceTemplatesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInstanceTemplatesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceTemplatesStub(
      InstanceTemplatesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonInstanceTemplatesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInstanceTemplatesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceTemplatesStub(
      InstanceTemplatesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteInstanceTemplateRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteInstanceTemplateRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetInstanceTemplateRequest, InstanceTemplate> getTransportSettings =
        HttpJsonCallSettings.<GetInstanceTemplateRequest, InstanceTemplate>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetIamPolicyInstanceTemplateRequest, Policy>
        getIamPolicyTransportSettings =
            HttpJsonCallSettings.<GetIamPolicyInstanceTemplateRequest, Policy>newBuilder()
                .setMethodDescriptor(getIamPolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertInstanceTemplateRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertInstanceTemplateRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListInstanceTemplatesRequest, InstanceTemplateList> listTransportSettings =
        HttpJsonCallSettings.<ListInstanceTemplatesRequest, InstanceTemplateList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetIamPolicyInstanceTemplateRequest, Policy>
        setIamPolicyTransportSettings =
            HttpJsonCallSettings.<SetIamPolicyInstanceTemplateRequest, Policy>newBuilder()
                .setMethodDescriptor(setIamPolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsInstanceTemplateRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsInstanceTemplateRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
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
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DeleteInstanceTemplateRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetInstanceTemplateRequest, InstanceTemplate> getCallable() {
    return getCallable;
  }

  public UnaryCallable<GetIamPolicyInstanceTemplateRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<InsertInstanceTemplateRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListInstanceTemplatesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListInstanceTemplatesRequest, InstanceTemplateList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<SetIamPolicyInstanceTemplateRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<TestIamPermissionsInstanceTemplateRequest, TestPermissionsResponse>
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
