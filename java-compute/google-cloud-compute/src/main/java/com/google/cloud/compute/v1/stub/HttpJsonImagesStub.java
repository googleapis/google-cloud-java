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

import static com.google.cloud.compute.v1.ImagesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.PatchImageRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyImageRequest;
import com.google.cloud.compute.v1.SetLabelsImageRequest;
import com.google.cloud.compute.v1.TestIamPermissionsImageRequest;
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
public class HttpJsonImagesStub extends ImagesStub {

  @InternalApi
  public static final ApiMethodDescriptor<DeleteImageRequest, Operation> deleteMethodDescriptor =
      ApiMethodDescriptor.<DeleteImageRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Images.Delete")
          .setHttpMethod(HttpMethods.DELETE)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteImageRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/images/{image}",
                      new FieldsExtractor<DeleteImageRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(DeleteImageRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteImageRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "image", request.getImage());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<DeleteImageRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(DeleteImageRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<DeleteImageRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<DeleteImageRequest, String>() {
                        @Override
                        public String extract(DeleteImageRequest request) {
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
  public static final ApiMethodDescriptor<DeprecateImageRequest, Operation>
      deprecateMethodDescriptor =
          ApiMethodDescriptor.<DeprecateImageRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Images.Deprecate")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeprecateImageRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/images/{image}/deprecate",
                          new FieldsExtractor<DeprecateImageRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeprecateImageRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeprecateImageRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "image", request.getImage());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<DeprecateImageRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeprecateImageRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeprecateImageRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeprecateImageRequest, String>() {
                            @Override
                            public String extract(DeprecateImageRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "deprecationStatusResource",
                                      request.getDeprecationStatusResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetImageRequest, Image> getMethodDescriptor =
      ApiMethodDescriptor.<GetImageRequest, Image>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Images.Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetImageRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/images/{image}",
                      new FieldsExtractor<GetImageRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetImageRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetImageRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "image", request.getImage());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetImageRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetImageRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetImageRequest> serializer =
                              ProtoRestSerializer.create();

                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetImageRequest, String>() {
                        @Override
                        public String extract(GetImageRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Image>newBuilder()
                  .setDefaultInstance(Image.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetFromFamilyImageRequest, Image>
      getFromFamilyMethodDescriptor =
          ApiMethodDescriptor.<GetFromFamilyImageRequest, Image>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Images.GetFromFamily")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFromFamilyImageRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/images/family/{family}",
                          new FieldsExtractor<GetFromFamilyImageRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetFromFamilyImageRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetFromFamilyImageRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "family", request.getFamily());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetFromFamilyImageRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetFromFamilyImageRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetFromFamilyImageRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetFromFamilyImageRequest, String>() {
                            @Override
                            public String extract(GetFromFamilyImageRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Image>newBuilder()
                      .setDefaultInstance(Image.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetIamPolicyImageRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyImageRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Images.GetIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyImageRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/images/{resource}/getIamPolicy",
                          new FieldsExtractor<GetIamPolicyImageRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetIamPolicyImageRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyImageRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetIamPolicyImageRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetIamPolicyImageRequest request) {
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
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetIamPolicyImageRequest, String>() {
                            @Override
                            public String extract(GetIamPolicyImageRequest request) {
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
  public static final ApiMethodDescriptor<InsertImageRequest, Operation> insertMethodDescriptor =
      ApiMethodDescriptor.<InsertImageRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Images.Insert")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<InsertImageRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/images",
                      new FieldsExtractor<InsertImageRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(InsertImageRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<InsertImageRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<InsertImageRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(InsertImageRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<InsertImageRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasForceCreate()) {
                            serializer.putQueryParam(
                                fields, "forceCreate", request.getForceCreate());
                          }
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<InsertImageRequest, String>() {
                        @Override
                        public String extract(InsertImageRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("imageResource", request.getImageResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListImagesRequest, ImageList> listMethodDescriptor =
      ApiMethodDescriptor.<ListImagesRequest, ImageList>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Images.List")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ListImagesRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/images",
                      new FieldsExtractor<ListImagesRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(ListImagesRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<ListImagesRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<ListImagesRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(ListImagesRequest request) {
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
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<ListImagesRequest, String>() {
                        @Override
                        public String extract(ListImagesRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<ImageList>newBuilder()
                  .setDefaultInstance(ImageList.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchImageRequest, Operation> patchMethodDescriptor =
      ApiMethodDescriptor.<PatchImageRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Images.Patch")
          .setHttpMethod(HttpMethods.PATCH)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PatchImageRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/global/images/{image}",
                      new FieldsExtractor<PatchImageRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(PatchImageRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<PatchImageRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "image", request.getImage());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<PatchImageRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(PatchImageRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<PatchImageRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasRequestId()) {
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<PatchImageRequest, String>() {
                        @Override
                        public String extract(PatchImageRequest request) {
                          return ProtoRestSerializer.create()
                              .toBody("imageResource", request.getImageResource());
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetIamPolicyImageRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyImageRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Images.SetIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyImageRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/images/{resource}/setIamPolicy",
                          new FieldsExtractor<SetIamPolicyImageRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(SetIamPolicyImageRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyImageRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetIamPolicyImageRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetIamPolicyImageRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyImageRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetIamPolicyImageRequest, String>() {
                            @Override
                            public String extract(SetIamPolicyImageRequest request) {
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
  public static final ApiMethodDescriptor<SetLabelsImageRequest, Operation>
      setLabelsMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsImageRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Images.SetLabels")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLabelsImageRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/images/{resource}/setLabels",
                          new FieldsExtractor<SetLabelsImageRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(SetLabelsImageRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetLabelsImageRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<SetLabelsImageRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetLabelsImageRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetLabelsImageRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetLabelsImageRequest, String>() {
                            @Override
                            public String extract(SetLabelsImageRequest request) {
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

  @InternalApi
  public static final ApiMethodDescriptor<TestIamPermissionsImageRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsImageRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Images.TestIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsImageRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/images/{resource}/testIamPermissions",
                          new FieldsExtractor<
                              TestIamPermissionsImageRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                TestIamPermissionsImageRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsImageRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsImageRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                TestIamPermissionsImageRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsImageRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<TestIamPermissionsImageRequest, String>() {
                            @Override
                            public String extract(TestIamPermissionsImageRequest request) {
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

  private final UnaryCallable<DeleteImageRequest, Operation> deleteCallable;
  private final UnaryCallable<DeprecateImageRequest, Operation> deprecateCallable;
  private final UnaryCallable<GetImageRequest, Image> getCallable;
  private final UnaryCallable<GetFromFamilyImageRequest, Image> getFromFamilyCallable;
  private final UnaryCallable<GetIamPolicyImageRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertImageRequest, Operation> insertCallable;
  private final UnaryCallable<ListImagesRequest, ImageList> listCallable;
  private final UnaryCallable<ListImagesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchImageRequest, Operation> patchCallable;
  private final UnaryCallable<SetIamPolicyImageRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetLabelsImageRequest, Operation> setLabelsCallable;
  private final UnaryCallable<TestIamPermissionsImageRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

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

    HttpJsonCallSettings<DeleteImageRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteImageRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<DeprecateImageRequest, Operation> deprecateTransportSettings =
        HttpJsonCallSettings.<DeprecateImageRequest, Operation>newBuilder()
            .setMethodDescriptor(deprecateMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetImageRequest, Image> getTransportSettings =
        HttpJsonCallSettings.<GetImageRequest, Image>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetFromFamilyImageRequest, Image> getFromFamilyTransportSettings =
        HttpJsonCallSettings.<GetFromFamilyImageRequest, Image>newBuilder()
            .setMethodDescriptor(getFromFamilyMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetIamPolicyImageRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyImageRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertImageRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertImageRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListImagesRequest, ImageList> listTransportSettings =
        HttpJsonCallSettings.<ListImagesRequest, ImageList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchImageRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchImageRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetIamPolicyImageRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyImageRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetLabelsImageRequest, Operation> setLabelsTransportSettings =
        HttpJsonCallSettings.<SetLabelsImageRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .build();
    HttpJsonCallSettings<TestIamPermissionsImageRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsImageRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deprecateCallable =
        callableFactory.createUnaryCallable(
            deprecateTransportSettings, settings.deprecateSettings(), clientContext);
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
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
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

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DeleteImageRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<DeprecateImageRequest, Operation> deprecateCallable() {
    return deprecateCallable;
  }

  public UnaryCallable<GetImageRequest, Image> getCallable() {
    return getCallable;
  }

  public UnaryCallable<GetFromFamilyImageRequest, Image> getFromFamilyCallable() {
    return getFromFamilyCallable;
  }

  public UnaryCallable<GetIamPolicyImageRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<InsertImageRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListImagesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListImagesRequest, ImageList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<PatchImageRequest, Operation> patchCallable() {
    return patchCallable;
  }

  public UnaryCallable<SetIamPolicyImageRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<SetLabelsImageRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  public UnaryCallable<TestIamPermissionsImageRequest, TestPermissionsResponse>
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
