/*
 * Copyright 2022 Google LLC
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

import static com.google.cloud.compute.v1.ImagesClient.ListPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteImageRequest;
import com.google.cloud.compute.v1.DeprecateImageRequest;
import com.google.cloud.compute.v1.GetFromFamilyImageRequest;
import com.google.cloud.compute.v1.GetIamPolicyImageRequest;
import com.google.cloud.compute.v1.GetImageRequest;
import com.google.cloud.compute.v1.Image;
import com.google.cloud.compute.v1.ImageList;
import com.google.cloud.compute.v1.InsertImageRequest;
import com.google.cloud.compute.v1.ListImagesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchImageRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyImageRequest;
import com.google.cloud.compute.v1.SetLabelsImageRequest;
import com.google.cloud.compute.v1.TestIamPermissionsImageRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Images service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonImagesStub extends ImagesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<DeleteImageRequest, Operation> deleteMethodDescriptor =
      ApiMethodDescriptor.<DeleteImageRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Images/Delete")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteImageRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/images/{image}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteImageRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "image", request.getImage());
                        serializer.putPathParam(fields, "project", request.getProject());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteImageRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (DeleteImageRequest request, Operation response) -> {
                StringBuilder opName = new StringBuilder(response.getName());
                opName.append(":").append(request.getProject());
                return HttpJsonOperationSnapshot.newBuilder()
                    .setName(opName.toString())
                    .setMetadata(response)
                    .setDone(Status.DONE.equals(response.getStatus()))
                    .setResponse(response)
                    .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                    .build();
              })
          .build();

  private static final ApiMethodDescriptor<DeprecateImageRequest, Operation>
      deprecateMethodDescriptor =
          ApiMethodDescriptor.<DeprecateImageRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Images/Deprecate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeprecateImageRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/images/{image}/deprecate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeprecateImageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "image", request.getImage());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeprecateImageRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "deprecationStatusResource",
                                      request.getDeprecationStatusResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeprecateImageRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<GetImageRequest, Image> getMethodDescriptor =
      ApiMethodDescriptor.<GetImageRequest, Image>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Images/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetImageRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/images/{image}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetImageRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "image", request.getImage());
                        serializer.putPathParam(fields, "project", request.getProject());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetImageRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Image>newBuilder()
                  .setDefaultInstance(Image.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetFromFamilyImageRequest, Image>
      getFromFamilyMethodDescriptor =
          ApiMethodDescriptor.<GetFromFamilyImageRequest, Image>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Images/GetFromFamily")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFromFamilyImageRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/images/family/{family}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFromFamilyImageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "family", request.getFamily());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFromFamilyImageRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Image>newBuilder()
                      .setDefaultInstance(Image.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyImageRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyImageRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Images/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyImageRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/images/{resource}/getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyImageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyImageRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasOptionsRequestedPolicyVersion()) {
                              serializer.putQueryParam(
                                  fields,
                                  "optionsRequestedPolicyVersion",
                                  request.getOptionsRequestedPolicyVersion());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertImageRequest, Operation> insertMethodDescriptor =
      ApiMethodDescriptor.<InsertImageRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Images/Insert")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<InsertImageRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/images",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<InsertImageRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<InsertImageRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasForceCreate()) {
                          serializer.putQueryParam(fields, "forceCreate", request.getForceCreate());
                        }
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("imageResource", request.getImageResource(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (InsertImageRequest request, Operation response) -> {
                StringBuilder opName = new StringBuilder(response.getName());
                opName.append(":").append(request.getProject());
                return HttpJsonOperationSnapshot.newBuilder()
                    .setName(opName.toString())
                    .setMetadata(response)
                    .setDone(Status.DONE.equals(response.getStatus()))
                    .setResponse(response)
                    .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                    .build();
              })
          .build();

  private static final ApiMethodDescriptor<ListImagesRequest, ImageList> listMethodDescriptor =
      ApiMethodDescriptor.<ListImagesRequest, ImageList>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Images/List")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ListImagesRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/images",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<ListImagesRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "project", request.getProject());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<ListImagesRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasFilter()) {
                          serializer.putQueryParam(fields, "filter", request.getFilter());
                        }
                        if (request.hasMaxResults()) {
                          serializer.putQueryParam(fields, "maxResults", request.getMaxResults());
                        }
                        if (request.hasOrderBy()) {
                          serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                        }
                        if (request.hasPageToken()) {
                          serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                        }
                        if (request.hasReturnPartialSuccess()) {
                          serializer.putQueryParam(
                              fields, "returnPartialSuccess", request.getReturnPartialSuccess());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<ImageList>newBuilder()
                  .setDefaultInstance(ImageList.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<PatchImageRequest, Operation> patchMethodDescriptor =
      ApiMethodDescriptor.<PatchImageRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Images/Patch")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PatchImageRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/images/{image}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<PatchImageRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "image", request.getImage());
                        serializer.putPathParam(fields, "project", request.getProject());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<PatchImageRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasRequestId()) {
                          serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        }
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("imageResource", request.getImageResource(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (PatchImageRequest request, Operation response) -> {
                StringBuilder opName = new StringBuilder(response.getName());
                opName.append(":").append(request.getProject());
                return HttpJsonOperationSnapshot.newBuilder()
                    .setName(opName.toString())
                    .setMetadata(response)
                    .setDone(Status.DONE.equals(response.getStatus()))
                    .setResponse(response)
                    .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                    .build();
              })
          .build();

  private static final ApiMethodDescriptor<SetIamPolicyImageRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyImageRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Images/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyImageRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/images/{resource}/setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyImageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyImageRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "globalSetPolicyRequestResource",
                                      request.getGlobalSetPolicyRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetLabelsImageRequest, Operation>
      setLabelsMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsImageRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Images/SetLabels")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLabelsImageRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/images/{resource}/setLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetLabelsImageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetLabelsImageRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "globalSetLabelsRequestResource",
                                      request.getGlobalSetLabelsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SetLabelsImageRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsImageRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsImageRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Images/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsImageRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/images/{resource}/testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsImageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsImageRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "testPermissionsRequestResource",
                                      request.getTestPermissionsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<DeleteImageRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteImageRequest, Operation, Operation> deleteOperationCallable;
  private final UnaryCallable<DeprecateImageRequest, Operation> deprecateCallable;
  private final OperationCallable<DeprecateImageRequest, Operation, Operation>
      deprecateOperationCallable;
  private final UnaryCallable<GetImageRequest, Image> getCallable;
  private final UnaryCallable<GetFromFamilyImageRequest, Image> getFromFamilyCallable;
  private final UnaryCallable<GetIamPolicyImageRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertImageRequest, Operation> insertCallable;
  private final OperationCallable<InsertImageRequest, Operation, Operation> insertOperationCallable;
  private final UnaryCallable<ListImagesRequest, ImageList> listCallable;
  private final UnaryCallable<ListImagesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchImageRequest, Operation> patchCallable;
  private final OperationCallable<PatchImageRequest, Operation, Operation> patchOperationCallable;
  private final UnaryCallable<SetIamPolicyImageRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetLabelsImageRequest, Operation> setLabelsCallable;
  private final OperationCallable<SetLabelsImageRequest, Operation, Operation>
      setLabelsOperationCallable;
  private final UnaryCallable<TestIamPermissionsImageRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonImagesStub create(ImagesStubSettings settings) throws IOException {
    return new HttpJsonImagesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonImagesStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonImagesStub(ImagesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonImagesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonImagesStub(
        ImagesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonImagesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonImagesStub(ImagesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonImagesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonImagesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonImagesStub(
      ImagesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<DeleteImageRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteImageRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeprecateImageRequest, Operation> deprecateTransportSettings =
        HttpJsonCallSettings.<DeprecateImageRequest, Operation>newBuilder()
            .setMethodDescriptor(deprecateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetImageRequest, Image> getTransportSettings =
        HttpJsonCallSettings.<GetImageRequest, Image>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetFromFamilyImageRequest, Image> getFromFamilyTransportSettings =
        HttpJsonCallSettings.<GetFromFamilyImageRequest, Image>newBuilder()
            .setMethodDescriptor(getFromFamilyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyImageRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyImageRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<InsertImageRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertImageRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListImagesRequest, ImageList> listTransportSettings =
        HttpJsonCallSettings.<ListImagesRequest, ImageList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PatchImageRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchImageRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyImageRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyImageRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetLabelsImageRequest, Operation> setLabelsTransportSettings =
        HttpJsonCallSettings.<SetLabelsImageRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsImageRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsImageRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deleteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTransportSettings,
            settings.deleteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deprecateCallable =
        callableFactory.createUnaryCallable(
            deprecateTransportSettings, settings.deprecateSettings(), clientContext);
    this.deprecateOperationCallable =
        callableFactory.createOperationCallable(
            deprecateTransportSettings,
            settings.deprecateOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getFromFamilyCallable =
        callableFactory.createUnaryCallable(
            getFromFamilyTransportSettings, settings.getFromFamilySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.insertOperationCallable =
        callableFactory.createOperationCallable(
            insertTransportSettings,
            settings.insertOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.patchOperationCallable =
        callableFactory.createOperationCallable(
            patchTransportSettings,
            settings.patchOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.setLabelsCallable =
        callableFactory.createUnaryCallable(
            setLabelsTransportSettings, settings.setLabelsSettings(), clientContext);
    this.setLabelsOperationCallable =
        callableFactory.createOperationCallable(
            setLabelsTransportSettings,
            settings.setLabelsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    methodDescriptors.add(deprecateMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getFromFamilyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(setLabelsMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteImageRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteImageRequest, Operation, Operation> deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<DeprecateImageRequest, Operation> deprecateCallable() {
    return deprecateCallable;
  }

  @Override
  public OperationCallable<DeprecateImageRequest, Operation, Operation>
      deprecateOperationCallable() {
    return deprecateOperationCallable;
  }

  @Override
  public UnaryCallable<GetImageRequest, Image> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetFromFamilyImageRequest, Image> getFromFamilyCallable() {
    return getFromFamilyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyImageRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<InsertImageRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertImageRequest, Operation, Operation> insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListImagesRequest, ImageList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListImagesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchImageRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchImageRequest, Operation, Operation> patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyImageRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetLabelsImageRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  @Override
  public OperationCallable<SetLabelsImageRequest, Operation, Operation>
      setLabelsOperationCallable() {
    return setLabelsOperationCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsImageRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
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
