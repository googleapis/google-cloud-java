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

import static com.google.cloud.compute.v1.SnapshotsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteSnapshotRequest;
import com.google.cloud.compute.v1.GetIamPolicySnapshotRequest;
import com.google.cloud.compute.v1.GetSnapshotRequest;
import com.google.cloud.compute.v1.ListSnapshotsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicySnapshotRequest;
import com.google.cloud.compute.v1.SetLabelsSnapshotRequest;
import com.google.cloud.compute.v1.Snapshot;
import com.google.cloud.compute.v1.SnapshotList;
import com.google.cloud.compute.v1.TestIamPermissionsSnapshotRequest;
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
 * REST stub implementation for the Snapshots service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonSnapshotsStub extends SnapshotsStub {
  private static final ApiMethodDescriptor<DeleteSnapshotRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteSnapshotRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Snapshots/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSnapshotRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/snapshots/{snapshot}",
                          new FieldsExtractor<DeleteSnapshotRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteSnapshotRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteSnapshotRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "snapshot", request.getSnapshot());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<DeleteSnapshotRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteSnapshotRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteSnapshotRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteSnapshotRequest, String>() {
                            @Override
                            public String extract(DeleteSnapshotRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSnapshotRequest, Snapshot> getMethodDescriptor =
      ApiMethodDescriptor.<GetSnapshotRequest, Snapshot>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Snapshots/Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSnapshotRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/snapshots/{snapshot}",
                      new FieldsExtractor<GetSnapshotRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetSnapshotRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetSnapshotRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "snapshot", request.getSnapshot());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetSnapshotRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetSnapshotRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetSnapshotRequest> serializer =
                              ProtoRestSerializer.create();
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetSnapshotRequest, String>() {
                        @Override
                        public String extract(GetSnapshotRequest request) {
                          return null;
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Snapshot>newBuilder()
                  .setDefaultInstance(Snapshot.getDefaultInstance())
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetIamPolicySnapshotRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicySnapshotRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Snapshots/GetIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicySnapshotRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/snapshots/{resource}/getIamPolicy",
                          new FieldsExtractor<GetIamPolicySnapshotRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetIamPolicySnapshotRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicySnapshotRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetIamPolicySnapshotRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetIamPolicySnapshotRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicySnapshotRequest> serializer =
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
                          new FieldsExtractor<GetIamPolicySnapshotRequest, String>() {
                            @Override
                            public String extract(GetIamPolicySnapshotRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSnapshotsRequest, SnapshotList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListSnapshotsRequest, SnapshotList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Snapshots/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSnapshotsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/snapshots",
                          new FieldsExtractor<ListSnapshotsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListSnapshotsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListSnapshotsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<ListSnapshotsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(ListSnapshotsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListSnapshotsRequest> serializer =
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
                          new FieldsExtractor<ListSnapshotsRequest, String>() {
                            @Override
                            public String extract(ListSnapshotsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SnapshotList>newBuilder()
                      .setDefaultInstance(SnapshotList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicySnapshotRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicySnapshotRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Snapshots/SetIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicySnapshotRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/snapshots/{resource}/setIamPolicy",
                          new FieldsExtractor<SetIamPolicySnapshotRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetIamPolicySnapshotRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicySnapshotRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetIamPolicySnapshotRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetIamPolicySnapshotRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicySnapshotRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetIamPolicySnapshotRequest, String>() {
                            @Override
                            public String extract(SetIamPolicySnapshotRequest request) {
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

  private static final ApiMethodDescriptor<SetLabelsSnapshotRequest, Operation>
      setLabelsMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsSnapshotRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Snapshots/SetLabels")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLabelsSnapshotRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/snapshots/{resource}/setLabels",
                          new FieldsExtractor<SetLabelsSnapshotRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(SetLabelsSnapshotRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetLabelsSnapshotRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetLabelsSnapshotRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetLabelsSnapshotRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetLabelsSnapshotRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetLabelsSnapshotRequest, String>() {
                            @Override
                            public String extract(SetLabelsSnapshotRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "globalSetLabelsRequestResource",
                                      request.getGlobalSetLabelsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TestIamPermissionsSnapshotRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsSnapshotRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Snapshots/TestIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsSnapshotRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/snapshots/{resource}/testIamPermissions",
                          new FieldsExtractor<
                              TestIamPermissionsSnapshotRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                TestIamPermissionsSnapshotRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsSnapshotRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsSnapshotRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                TestIamPermissionsSnapshotRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsSnapshotRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<TestIamPermissionsSnapshotRequest, String>() {
                            @Override
                            public String extract(TestIamPermissionsSnapshotRequest request) {
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

  private final UnaryCallable<DeleteSnapshotRequest, Operation> deleteCallable;
  private final UnaryCallable<GetSnapshotRequest, Snapshot> getCallable;
  private final UnaryCallable<GetIamPolicySnapshotRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<ListSnapshotsRequest, SnapshotList> listCallable;
  private final UnaryCallable<ListSnapshotsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<SetIamPolicySnapshotRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetLabelsSnapshotRequest, Operation> setLabelsCallable;
  private final UnaryCallable<TestIamPermissionsSnapshotRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSnapshotsStub create(SnapshotsStubSettings settings)
      throws IOException {
    return new HttpJsonSnapshotsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSnapshotsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonSnapshotsStub(SnapshotsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonSnapshotsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSnapshotsStub(
        SnapshotsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSnapshotsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSnapshotsStub(SnapshotsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSnapshotsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSnapshotsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSnapshotsStub(
      SnapshotsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteSnapshotRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteSnapshotRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetSnapshotRequest, Snapshot> getTransportSettings =
        HttpJsonCallSettings.<GetSnapshotRequest, Snapshot>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetIamPolicySnapshotRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicySnapshotRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListSnapshotsRequest, SnapshotList> listTransportSettings =
        HttpJsonCallSettings.<ListSnapshotsRequest, SnapshotList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetIamPolicySnapshotRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicySnapshotRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetLabelsSnapshotRequest, Operation> setLabelsTransportSettings =
        HttpJsonCallSettings.<SetLabelsSnapshotRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .build();
    HttpJsonCallSettings<TestIamPermissionsSnapshotRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsSnapshotRequest, TestPermissionsResponse>newBuilder()
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
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
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
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(setLabelsMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteSnapshotRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetSnapshotRequest, Snapshot> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicySnapshotRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<ListSnapshotsRequest, SnapshotList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListSnapshotsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicySnapshotRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetLabelsSnapshotRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsSnapshotRequest, TestPermissionsResponse>
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
