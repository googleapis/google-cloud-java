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

import static com.google.cloud.compute.v1.BackendServicesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.BackendServicesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AddSignedUrlKeyBackendServiceRequest;
import com.google.cloud.compute.v1.AggregatedListBackendServicesRequest;
import com.google.cloud.compute.v1.BackendService;
import com.google.cloud.compute.v1.BackendServiceAggregatedList;
import com.google.cloud.compute.v1.BackendServiceGroupHealth;
import com.google.cloud.compute.v1.BackendServiceList;
import com.google.cloud.compute.v1.DeleteBackendServiceRequest;
import com.google.cloud.compute.v1.DeleteSignedUrlKeyBackendServiceRequest;
import com.google.cloud.compute.v1.GetBackendServiceRequest;
import com.google.cloud.compute.v1.GetHealthBackendServiceRequest;
import com.google.cloud.compute.v1.InsertBackendServiceRequest;
import com.google.cloud.compute.v1.ListBackendServicesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchBackendServiceRequest;
import com.google.cloud.compute.v1.SetSecurityPolicyBackendServiceRequest;
import com.google.cloud.compute.v1.UpdateBackendServiceRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the BackendServices service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonBackendServicesStub extends BackendServicesStub {
  private static final ApiMethodDescriptor<AddSignedUrlKeyBackendServiceRequest, Operation>
      addSignedUrlKeyMethodDescriptor =
          ApiMethodDescriptor.<AddSignedUrlKeyBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/AddSignedUrlKey")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddSignedUrlKeyBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}/addSignedUrlKey",
                          new FieldsExtractor<
                              AddSignedUrlKeyBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AddSignedUrlKeyBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AddSignedUrlKeyBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "backendService", request.getBackendService());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AddSignedUrlKeyBackendServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AddSignedUrlKeyBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AddSignedUrlKeyBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AddSignedUrlKeyBackendServiceRequest, String>() {
                            @Override
                            public String extract(AddSignedUrlKeyBackendServiceRequest request) {
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

  private static final ApiMethodDescriptor<
          AggregatedListBackendServicesRequest, BackendServiceAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/AggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListBackendServicesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/backendServices",
                          new FieldsExtractor<
                              AggregatedListBackendServicesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AggregatedListBackendServicesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListBackendServicesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AggregatedListBackendServicesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AggregatedListBackendServicesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AggregatedListBackendServicesRequest> serializer =
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
                          new FieldsExtractor<AggregatedListBackendServicesRequest, String>() {
                            @Override
                            public String extract(AggregatedListBackendServicesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackendServiceAggregatedList>newBuilder()
                      .setDefaultInstance(BackendServiceAggregatedList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBackendServiceRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}",
                          new FieldsExtractor<DeleteBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "backendService", request.getBackendService());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteBackendServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteBackendServiceRequest, String>() {
                            @Override
                            public String extract(DeleteBackendServiceRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSignedUrlKeyBackendServiceRequest, Operation>
      deleteSignedUrlKeyMethodDescriptor =
          ApiMethodDescriptor.<DeleteSignedUrlKeyBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/DeleteSignedUrlKey")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSignedUrlKeyBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}/deleteSignedUrlKey",
                          new FieldsExtractor<
                              DeleteSignedUrlKeyBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteSignedUrlKeyBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteSignedUrlKeyBackendServiceRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "backendService", request.getBackendService());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteSignedUrlKeyBackendServiceRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteSignedUrlKeyBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteSignedUrlKeyBackendServiceRequest>
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
                          new FieldsExtractor<DeleteSignedUrlKeyBackendServiceRequest, String>() {
                            @Override
                            public String extract(DeleteSignedUrlKeyBackendServiceRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBackendServiceRequest, BackendService>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetBackendServiceRequest, BackendService>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}",
                          new FieldsExtractor<GetBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "backendService", request.getBackendService());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetBackendServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetBackendServiceRequest, String>() {
                            @Override
                            public String extract(GetBackendServiceRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackendService>newBuilder()
                      .setDefaultInstance(BackendService.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetHealthBackendServiceRequest, BackendServiceGroupHealth>
      getHealthMethodDescriptor =
          ApiMethodDescriptor
              .<GetHealthBackendServiceRequest, BackendServiceGroupHealth>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/GetHealth")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHealthBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}/getHealth",
                          new FieldsExtractor<
                              GetHealthBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetHealthBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetHealthBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "backendService", request.getBackendService());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetHealthBackendServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetHealthBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetHealthBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetHealthBackendServiceRequest, String>() {
                            @Override
                            public String extract(GetHealthBackendServiceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "resourceGroupReferenceResource",
                                      request.getResourceGroupReferenceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackendServiceGroupHealth>newBuilder()
                      .setDefaultInstance(BackendServiceGroupHealth.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertBackendServiceRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices",
                          new FieldsExtractor<InsertBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertBackendServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertBackendServiceRequest, String>() {
                            @Override
                            public String extract(InsertBackendServiceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "backendServiceResource",
                                      request.getBackendServiceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListBackendServicesRequest, BackendServiceList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListBackendServicesRequest, BackendServiceList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackendServicesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices",
                          new FieldsExtractor<ListBackendServicesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ListBackendServicesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListBackendServicesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListBackendServicesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListBackendServicesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListBackendServicesRequest> serializer =
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
                          new FieldsExtractor<ListBackendServicesRequest, String>() {
                            @Override
                            public String extract(ListBackendServicesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackendServiceList>newBuilder()
                      .setDefaultInstance(BackendServiceList.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchBackendServiceRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}",
                          new FieldsExtractor<PatchBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(PatchBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "backendService", request.getBackendService());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchBackendServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchBackendServiceRequest, String>() {
                            @Override
                            public String extract(PatchBackendServiceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "backendServiceResource",
                                      request.getBackendServiceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetSecurityPolicyBackendServiceRequest, Operation>
      setSecurityPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetSecurityPolicyBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/SetSecurityPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetSecurityPolicyBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}/setSecurityPolicy",
                          new FieldsExtractor<
                              SetSecurityPolicyBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetSecurityPolicyBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetSecurityPolicyBackendServiceRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "backendService", request.getBackendService());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetSecurityPolicyBackendServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetSecurityPolicyBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetSecurityPolicyBackendServiceRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetSecurityPolicyBackendServiceRequest, String>() {
                            @Override
                            public String extract(SetSecurityPolicyBackendServiceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "securityPolicyReferenceResource",
                                      request.getSecurityPolicyReferenceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBackendServiceRequest, Operation>
      updateMethodDescriptor =
          ApiMethodDescriptor.<UpdateBackendServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.BackendServices/Update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBackendServiceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/backendServices/{backendService}",
                          new FieldsExtractor<UpdateBackendServiceRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                UpdateBackendServiceRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "backendService", request.getBackendService());
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              UpdateBackendServiceRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                UpdateBackendServiceRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<UpdateBackendServiceRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<UpdateBackendServiceRequest, String>() {
                            @Override
                            public String extract(UpdateBackendServiceRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "backendServiceResource",
                                      request.getBackendServiceResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<AddSignedUrlKeyBackendServiceRequest, Operation>
      addSignedUrlKeyCallable;
  private final UnaryCallable<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListBackendServicesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteBackendServiceRequest, Operation> deleteCallable;
  private final UnaryCallable<DeleteSignedUrlKeyBackendServiceRequest, Operation>
      deleteSignedUrlKeyCallable;
  private final UnaryCallable<GetBackendServiceRequest, BackendService> getCallable;
  private final UnaryCallable<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
      getHealthCallable;
  private final UnaryCallable<InsertBackendServiceRequest, Operation> insertCallable;
  private final UnaryCallable<ListBackendServicesRequest, BackendServiceList> listCallable;
  private final UnaryCallable<ListBackendServicesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchBackendServiceRequest, Operation> patchCallable;
  private final UnaryCallable<SetSecurityPolicyBackendServiceRequest, Operation>
      setSecurityPolicyCallable;
  private final UnaryCallable<UpdateBackendServiceRequest, Operation> updateCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBackendServicesStub create(BackendServicesStubSettings settings)
      throws IOException {
    return new HttpJsonBackendServicesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBackendServicesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBackendServicesStub(
        BackendServicesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonBackendServicesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBackendServicesStub(
        BackendServicesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBackendServicesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBackendServicesStub(
      BackendServicesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBackendServicesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBackendServicesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBackendServicesStub(
      BackendServicesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddSignedUrlKeyBackendServiceRequest, Operation>
        addSignedUrlKeyTransportSettings =
            HttpJsonCallSettings.<AddSignedUrlKeyBackendServiceRequest, Operation>newBuilder()
                .setMethodDescriptor(addSignedUrlKeyMethodDescriptor)
                .build();
    HttpJsonCallSettings<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteBackendServiceRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteBackendServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<DeleteSignedUrlKeyBackendServiceRequest, Operation>
        deleteSignedUrlKeyTransportSettings =
            HttpJsonCallSettings.<DeleteSignedUrlKeyBackendServiceRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteSignedUrlKeyMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetBackendServiceRequest, BackendService> getTransportSettings =
        HttpJsonCallSettings.<GetBackendServiceRequest, BackendService>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
        getHealthTransportSettings =
            HttpJsonCallSettings
                .<GetHealthBackendServiceRequest, BackendServiceGroupHealth>newBuilder()
                .setMethodDescriptor(getHealthMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertBackendServiceRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertBackendServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListBackendServicesRequest, BackendServiceList> listTransportSettings =
        HttpJsonCallSettings.<ListBackendServicesRequest, BackendServiceList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchBackendServiceRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchBackendServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetSecurityPolicyBackendServiceRequest, Operation>
        setSecurityPolicyTransportSettings =
            HttpJsonCallSettings.<SetSecurityPolicyBackendServiceRequest, Operation>newBuilder()
                .setMethodDescriptor(setSecurityPolicyMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdateBackendServiceRequest, Operation> updateTransportSettings =
        HttpJsonCallSettings.<UpdateBackendServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMethodDescriptor)
            .build();

    this.addSignedUrlKeyCallable =
        callableFactory.createUnaryCallable(
            addSignedUrlKeyTransportSettings, settings.addSignedUrlKeySettings(), clientContext);
    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
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
    this.getHealthCallable =
        callableFactory.createUnaryCallable(
            getHealthTransportSettings, settings.getHealthSettings(), clientContext);
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
    this.setSecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            setSecurityPolicyTransportSettings,
            settings.setSecurityPolicySettings(),
            clientContext);
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
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(deleteSignedUrlKeyMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getHealthMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(setSecurityPolicyMethodDescriptor);
    methodDescriptors.add(updateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddSignedUrlKeyBackendServiceRequest, Operation> addSignedUrlKeyCallable() {
    return addSignedUrlKeyCallable;
  }

  @Override
  public UnaryCallable<AggregatedListBackendServicesRequest, BackendServiceAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListBackendServicesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteBackendServiceRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<DeleteSignedUrlKeyBackendServiceRequest, Operation>
      deleteSignedUrlKeyCallable() {
    return deleteSignedUrlKeyCallable;
  }

  @Override
  public UnaryCallable<GetBackendServiceRequest, BackendService> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetHealthBackendServiceRequest, BackendServiceGroupHealth>
      getHealthCallable() {
    return getHealthCallable;
  }

  @Override
  public UnaryCallable<InsertBackendServiceRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public UnaryCallable<ListBackendServicesRequest, BackendServiceList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListBackendServicesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchBackendServiceRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public UnaryCallable<SetSecurityPolicyBackendServiceRequest, Operation>
      setSecurityPolicyCallable() {
    return setSecurityPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdateBackendServiceRequest, Operation> updateCallable() {
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
