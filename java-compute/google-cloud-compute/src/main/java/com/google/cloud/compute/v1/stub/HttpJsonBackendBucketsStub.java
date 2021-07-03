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

import static com.google.cloud.compute.v1.BackendBucketsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AddSignedUrlKeyBackendBucketRequest;
import com.google.cloud.compute.v1.BackendBucket;
import com.google.cloud.compute.v1.BackendBucketList;
import com.google.cloud.compute.v1.DeleteBackendBucketRequest;
import com.google.cloud.compute.v1.DeleteSignedUrlKeyBackendBucketRequest;
import com.google.cloud.compute.v1.GetBackendBucketRequest;
import com.google.cloud.compute.v1.InsertBackendBucketRequest;
import com.google.cloud.compute.v1.ListBackendBucketsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchBackendBucketRequest;
import com.google.cloud.compute.v1.UpdateBackendBucketRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the BackendBuckets service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonBackendBucketsStub extends BackendBucketsStub {
  private static final ApiMethodDescriptor<AddSignedUrlKeyBackendBucketRequest, Operation>
      addSignedUrlKeyMethodDescriptor =
          ApiMethodDescriptor.<AddSignedUrlKeyBackendBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/AddSignedUrlKey")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddSignedUrlKeyBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets/{backendBucket}/addSignedUrlKey",
                          new FieldsExtractor<
                              AddSignedUrlKeyBackendBucketRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AddSignedUrlKeyBackendBucketRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AddSignedUrlKeyBackendBucketRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "backendBucket", request.getBackendBucket());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AddSignedUrlKeyBackendBucketRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AddSignedUrlKeyBackendBucketRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AddSignedUrlKeyBackendBucketRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AddSignedUrlKeyBackendBucketRequest, String>() {
                            @Override
                            public String extract(AddSignedUrlKeyBackendBucketRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "signedUrlKeyResource", request.getSignedUrlKeyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBackendBucketRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackendBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets/{backendBucket}",
                          new FieldsExtractor<DeleteBackendBucketRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteBackendBucketRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteBackendBucketRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "backendBucket", request.getBackendBucket());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteBackendBucketRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteBackendBucketRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteBackendBucketRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteBackendBucketRequest, String>() {
                            @Override
                            public String extract(DeleteBackendBucketRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSignedUrlKeyBackendBucketRequest, Operation>
      deleteSignedUrlKeyMethodDescriptor =
          ApiMethodDescriptor.<DeleteSignedUrlKeyBackendBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/DeleteSignedUrlKey")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSignedUrlKeyBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets/{backendBucket}/deleteSignedUrlKey",
                          new FieldsExtractor<
                              DeleteSignedUrlKeyBackendBucketRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteSignedUrlKeyBackendBucketRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteSignedUrlKeyBackendBucketRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "backendBucket", request.getBackendBucket());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteSignedUrlKeyBackendBucketRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteSignedUrlKeyBackendBucketRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteSignedUrlKeyBackendBucketRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putQueryParam(fields, "keyName", request.getKeyName());
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteSignedUrlKeyBackendBucketRequest, String>() {
                            @Override
                            public String extract(DeleteSignedUrlKeyBackendBucketRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBackendBucketRequest, BackendBucket>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetBackendBucketRequest, BackendBucket>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets/{backendBucket}",
                          new FieldsExtractor<GetBackendBucketRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetBackendBucketRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetBackendBucketRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "backendBucket", request.getBackendBucket());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetBackendBucketRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetBackendBucketRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetBackendBucketRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetBackendBucketRequest, String>() {
                            @Override
                            public String extract(GetBackendBucketRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackendBucket>newBuilder()
                      .setDefaultInstance(BackendBucket.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertBackendBucketRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertBackendBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets",
                          new FieldsExtractor<InsertBackendBucketRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(InsertBackendBucketRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertBackendBucketRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertBackendBucketRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertBackendBucketRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertBackendBucketRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertBackendBucketRequest, String>() {
                            @Override
                            public String extract(InsertBackendBucketRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "backendBucketResource", request.getBackendBucketResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListBackendBucketsRequest, BackendBucketList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListBackendBucketsRequest, BackendBucketList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackendBucketsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets",
                          new FieldsExtractor<ListBackendBucketsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListBackendBucketsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListBackendBucketsRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListBackendBucketsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListBackendBucketsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListBackendBucketsRequest> serializer =
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
                          new FieldsExtractor<ListBackendBucketsRequest, String>() {
                            @Override
                            public String extract(ListBackendBucketsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackendBucketList>newBuilder()
                      .setDefaultInstance(BackendBucketList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchBackendBucketRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchBackendBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets/{backendBucket}",
                          new FieldsExtractor<PatchBackendBucketRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(PatchBackendBucketRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchBackendBucketRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "backendBucket", request.getBackendBucket());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchBackendBucketRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchBackendBucketRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchBackendBucketRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchBackendBucketRequest, String>() {
                            @Override
                            public String extract(PatchBackendBucketRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "backendBucketResource", request.getBackendBucketResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBackendBucketRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateBackendBucketRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendBuckets/Update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBackendBucketRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendBuckets/{backendBucket}",
                          new FieldsExtractor<UpdateBackendBucketRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(UpdateBackendBucketRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateBackendBucketRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "backendBucket", request.getBackendBucket());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdateBackendBucketRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdateBackendBucketRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateBackendBucketRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<UpdateBackendBucketRequest, String>() {
                            @Override
                            public String extract(UpdateBackendBucketRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "backendBucketResource", request.getBackendBucketResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<AddSignedUrlKeyBackendBucketRequest, Operation>
      addSignedUrlKeyCallable;
  private final UnaryCallable<DeleteBackendBucketRequest, Operation> deleteCallable;
  private final UnaryCallable<DeleteSignedUrlKeyBackendBucketRequest, Operation>
      deleteSignedUrlKeyCallable;
  private final UnaryCallable<GetBackendBucketRequest, BackendBucket> getCallable;
  private final UnaryCallable<InsertBackendBucketRequest, Operation> insertCallable;
  private final UnaryCallable<ListBackendBucketsRequest, BackendBucketList> listCallable;
  private final UnaryCallable<ListBackendBucketsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchBackendBucketRequest, Operation> patchCallable;
  private final UnaryCallable<UpdateBackendBucketRequest, Operation> updateCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBackendBucketsStub create(BackendBucketsStubSettings settings)
      throws IOException {
    return new HttpJsonBackendBucketsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBackendBucketsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBackendBucketsStub(
        BackendBucketsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonBackendBucketsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBackendBucketsStub(
        BackendBucketsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBackendBucketsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBackendBucketsStub(
      BackendBucketsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBackendBucketsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBackendBucketsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBackendBucketsStub(
      BackendBucketsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddSignedUrlKeyBackendBucketRequest, Operation>
        addSignedUrlKeyTransportSettings =
            HttpJsonCallSettings.<AddSignedUrlKeyBackendBucketRequest, Operation>newBuilder()
                .setMethodDescriptor(addSignedUrlKeyMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteBackendBucketRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteBackendBucketRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<DeleteSignedUrlKeyBackendBucketRequest, Operation>
        deleteSignedUrlKeyTransportSettings =
            HttpJsonCallSettings.<DeleteSignedUrlKeyBackendBucketRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteSignedUrlKeyMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetBackendBucketRequest, BackendBucket> getTransportSettings =
        HttpJsonCallSettings.<GetBackendBucketRequest, BackendBucket>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertBackendBucketRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertBackendBucketRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListBackendBucketsRequest, BackendBucketList> listTransportSettings =
        HttpJsonCallSettings.<ListBackendBucketsRequest, BackendBucketList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchBackendBucketRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchBackendBucketRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateBackendBucketRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateBackendBucketRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .build();

    this.addSignedUrlKeyCallable =
        callableFactory.createUnaryCallable(
            addSignedUrlKeyTransportSettings, settings.addSignedUrlKeySettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deleteSignedUrlKeyCallable =
        callableFactory.createUnaryCallable(
            deleteSignedUrlKeyTransportSettings,
            settings.deleteSignedUrlKeySettings(),
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
    methodDescriptors.add(addSignedUrlKeyMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(deleteSignedUrlKeyMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(updateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddSignedUrlKeyBackendBucketRequest, Operation> addSignedUrlKeyCallable() {
    return addSignedUrlKeyCallable;
  }

  @Override
  public UnaryCallable<DeleteBackendBucketRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<DeleteSignedUrlKeyBackendBucketRequest, Operation>
      deleteSignedUrlKeyCallable() {
    return deleteSignedUrlKeyCallable;
  }

  @Override
  public UnaryCallable<GetBackendBucketRequest, BackendBucket> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertBackendBucketRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListBackendBucketsRequest, BackendBucketList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListBackendBucketsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchBackendBucketRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public UnaryCallable<UpdateBackendBucketRequest, Operation> updateCallable() {
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
