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

import static com.google.cloud.compute.v1.LicensesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteLicenseRequest;
import com.google.cloud.compute.v1.GetIamPolicyLicenseRequest;
import com.google.cloud.compute.v1.GetLicenseRequest;
import com.google.cloud.compute.v1.InsertLicenseRequest;
import com.google.cloud.compute.v1.License;
import com.google.cloud.compute.v1.LicensesListResponse;
import com.google.cloud.compute.v1.ListLicensesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyLicenseRequest;
import com.google.cloud.compute.v1.TestIamPermissionsLicenseRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Licenses service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonLicensesStub extends LicensesStub {
  private static final ApiMethodDescriptor<DeleteLicenseRequest, Operation> deleteMethodDescriptor =
      ApiMethodDescriptor.<DeleteLicenseRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Licenses/Delete")
          .setHttpMethod(HttpMethods.DELETE)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteLicenseRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/licenses/{license}",
                      new FieldsExtractor<DeleteLicenseRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(DeleteLicenseRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteLicenseRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "license", request.getLicense());
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<DeleteLicenseRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(DeleteLicenseRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteLicenseRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<DeleteLicenseRequest, String>() {
                        @Override
                        public String extract(DeleteLicenseRequest request) {
                          return null;
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetLicenseRequest, License> getMethodDescriptor =
      ApiMethodDescriptor.<GetLicenseRequest, License>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Licenses/Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetLicenseRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/licenses/{license}",
                      new FieldsExtractor<GetLicenseRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetLicenseRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetLicenseRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "license", request.getLicense());
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetLicenseRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetLicenseRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetLicenseRequest> serializer =
                              ProtoRestSerializer.create();
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetLicenseRequest, String>() {
                        @Override
                        public String extract(GetLicenseRequest request) {
                          return null;
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<License>newBuilder()
                  .setDefaultInstance(License.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetIamPolicyLicenseRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyLicenseRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Licenses/GetIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyLicenseRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/licenses/{resource}/getIamPolicy",
                          new FieldsExtractor<GetIamPolicyLicenseRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetIamPolicyLicenseRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyLicenseRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetIamPolicyLicenseRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetIamPolicyLicenseRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyLicenseRequest> serializer =
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
                          new FieldsExtractor<GetIamPolicyLicenseRequest, String>() {
                            @Override
                            public String extract(GetIamPolicyLicenseRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertLicenseRequest, Operation> insertMethodDescriptor =
      ApiMethodDescriptor.<InsertLicenseRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Licenses/Insert")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<InsertLicenseRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/licenses",
                      new FieldsExtractor<InsertLicenseRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(InsertLicenseRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<InsertLicenseRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<InsertLicenseRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(InsertLicenseRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<InsertLicenseRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<InsertLicenseRequest, String>() {
                        @Override
                        public String extract(InsertLicenseRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("licenseResource", request.getLicenseResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListLicensesRequest, LicensesListResponse>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListLicensesRequest, LicensesListResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Licenses/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLicensesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/licenses",
                          new FieldsExtractor<ListLicensesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListLicensesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListLicensesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<ListLicensesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(ListLicensesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListLicensesRequest> serializer =
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
                          new FieldsExtractor<ListLicensesRequest, String>() {
                            @Override
                            public String extract(ListLicensesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LicensesListResponse>newBuilder()
                      .setDefaultInstance(LicensesListResponse.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyLicenseRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyLicenseRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Licenses/SetIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyLicenseRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/licenses/{resource}/setIamPolicy",
                          new FieldsExtractor<SetIamPolicyLicenseRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(SetIamPolicyLicenseRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyLicenseRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetIamPolicyLicenseRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetIamPolicyLicenseRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyLicenseRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetIamPolicyLicenseRequest, String>() {
                            @Override
                            public String extract(SetIamPolicyLicenseRequest request) {
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

  private static final ApiMethodDescriptor<
          TestIamPermissionsLicenseRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsLicenseRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Licenses/TestIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsLicenseRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/licenses/{resource}/testIamPermissions",
                          new FieldsExtractor<
                              TestIamPermissionsLicenseRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                TestIamPermissionsLicenseRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsLicenseRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsLicenseRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                TestIamPermissionsLicenseRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsLicenseRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<TestIamPermissionsLicenseRequest, String>() {
                            @Override
                            public String extract(TestIamPermissionsLicenseRequest request) {
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

  private final UnaryCallable<DeleteLicenseRequest, Operation> deleteCallable;
  private final UnaryCallable<GetLicenseRequest, License> getCallable;
  private final UnaryCallable<GetIamPolicyLicenseRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertLicenseRequest, Operation> insertCallable;
  private final UnaryCallable<ListLicensesRequest, LicensesListResponse> listCallable;
  private final UnaryCallable<ListLicensesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<SetIamPolicyLicenseRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsLicenseRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLicensesStub create(LicensesStubSettings settings)
      throws IOException {
    return new HttpJsonLicensesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLicensesStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonLicensesStub(LicensesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonLicensesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLicensesStub(
        LicensesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLicensesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonLicensesStub(LicensesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonLicensesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLicensesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonLicensesStub(
      LicensesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteLicenseRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteLicenseRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetLicenseRequest, License> getTransportSettings =
        HttpJsonCallSettings.<GetLicenseRequest, License>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetIamPolicyLicenseRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyLicenseRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertLicenseRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertLicenseRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListLicensesRequest, LicensesListResponse> listTransportSettings =
        HttpJsonCallSettings.<ListLicensesRequest, LicensesListResponse>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetIamPolicyLicenseRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyLicenseRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<TestIamPermissionsLicenseRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsLicenseRequest, TestPermissionsResponse>newBuilder()
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteLicenseRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetLicenseRequest, License> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyLicenseRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<InsertLicenseRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListLicensesRequest, LicensesListResponse> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListLicensesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyLicenseRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsLicenseRequest, TestPermissionsResponse>
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
