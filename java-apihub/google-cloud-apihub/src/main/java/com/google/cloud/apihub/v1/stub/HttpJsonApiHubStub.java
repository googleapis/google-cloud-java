/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.ApiHubClient.ListApiOperationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListApisPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListAttributesPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListDeploymentsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListExternalApisPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListSpecsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListVersionsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.SearchResourcesPagedResponse;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.Api;
import com.google.cloud.apihub.v1.ApiOperation;
import com.google.cloud.apihub.v1.Attribute;
import com.google.cloud.apihub.v1.CreateApiRequest;
import com.google.cloud.apihub.v1.CreateAttributeRequest;
import com.google.cloud.apihub.v1.CreateDeploymentRequest;
import com.google.cloud.apihub.v1.CreateExternalApiRequest;
import com.google.cloud.apihub.v1.CreateSpecRequest;
import com.google.cloud.apihub.v1.CreateVersionRequest;
import com.google.cloud.apihub.v1.Definition;
import com.google.cloud.apihub.v1.DeleteApiRequest;
import com.google.cloud.apihub.v1.DeleteAttributeRequest;
import com.google.cloud.apihub.v1.DeleteDeploymentRequest;
import com.google.cloud.apihub.v1.DeleteExternalApiRequest;
import com.google.cloud.apihub.v1.DeleteSpecRequest;
import com.google.cloud.apihub.v1.DeleteVersionRequest;
import com.google.cloud.apihub.v1.Deployment;
import com.google.cloud.apihub.v1.ExternalApi;
import com.google.cloud.apihub.v1.GetApiOperationRequest;
import com.google.cloud.apihub.v1.GetApiRequest;
import com.google.cloud.apihub.v1.GetAttributeRequest;
import com.google.cloud.apihub.v1.GetDefinitionRequest;
import com.google.cloud.apihub.v1.GetDeploymentRequest;
import com.google.cloud.apihub.v1.GetExternalApiRequest;
import com.google.cloud.apihub.v1.GetSpecContentsRequest;
import com.google.cloud.apihub.v1.GetSpecRequest;
import com.google.cloud.apihub.v1.GetVersionRequest;
import com.google.cloud.apihub.v1.ListApiOperationsRequest;
import com.google.cloud.apihub.v1.ListApiOperationsResponse;
import com.google.cloud.apihub.v1.ListApisRequest;
import com.google.cloud.apihub.v1.ListApisResponse;
import com.google.cloud.apihub.v1.ListAttributesRequest;
import com.google.cloud.apihub.v1.ListAttributesResponse;
import com.google.cloud.apihub.v1.ListDeploymentsRequest;
import com.google.cloud.apihub.v1.ListDeploymentsResponse;
import com.google.cloud.apihub.v1.ListExternalApisRequest;
import com.google.cloud.apihub.v1.ListExternalApisResponse;
import com.google.cloud.apihub.v1.ListSpecsRequest;
import com.google.cloud.apihub.v1.ListSpecsResponse;
import com.google.cloud.apihub.v1.ListVersionsRequest;
import com.google.cloud.apihub.v1.ListVersionsResponse;
import com.google.cloud.apihub.v1.SearchResourcesRequest;
import com.google.cloud.apihub.v1.SearchResourcesResponse;
import com.google.cloud.apihub.v1.Spec;
import com.google.cloud.apihub.v1.SpecContents;
import com.google.cloud.apihub.v1.UpdateApiRequest;
import com.google.cloud.apihub.v1.UpdateAttributeRequest;
import com.google.cloud.apihub.v1.UpdateDeploymentRequest;
import com.google.cloud.apihub.v1.UpdateExternalApiRequest;
import com.google.cloud.apihub.v1.UpdateSpecRequest;
import com.google.cloud.apihub.v1.UpdateVersionRequest;
import com.google.cloud.apihub.v1.Version;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the ApiHub service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonApiHubStub extends ApiHubStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateApiRequest, Api> createApiMethodDescriptor =
      ApiMethodDescriptor.<CreateApiRequest, Api>newBuilder()
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/CreateApi")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateApiRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*}/apis",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateApiRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateApiRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "apiId", request.getApiId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request -> ProtoRestSerializer.create().toBody("api", request.getApi(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Api>newBuilder()
                  .setDefaultInstance(Api.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetApiRequest, Api> getApiMethodDescriptor =
      ApiMethodDescriptor.<GetApiRequest, Api>newBuilder()
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetApi")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetApiRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apis/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetApiRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetApiRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Api>newBuilder()
                  .setDefaultInstance(Api.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListApisRequest, ListApisResponse>
      listApisMethodDescriptor =
          ApiMethodDescriptor.<ListApisRequest, ListApisResponse>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/ListApis")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApisRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/apis",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListApisResponse>newBuilder()
                      .setDefaultInstance(ListApisResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateApiRequest, Api> updateApiMethodDescriptor =
      ApiMethodDescriptor.<UpdateApiRequest, Api>newBuilder()
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/UpdateApi")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateApiRequest>newBuilder()
                  .setPath(
                      "/v1/{api.name=projects/*/locations/*/apis/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateApiRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "api.name", request.getApi().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateApiRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request -> ProtoRestSerializer.create().toBody("api", request.getApi(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Api>newBuilder()
                  .setDefaultInstance(Api.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteApiRequest, Empty> deleteApiMethodDescriptor =
      ApiMethodDescriptor.<DeleteApiRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/DeleteApi")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteApiRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apis/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteApiRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteApiRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "force", request.getForce());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateVersionRequest, Version>
      createVersionMethodDescriptor =
          ApiMethodDescriptor.<CreateVersionRequest, Version>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/CreateVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apis/*}/versions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "versionId", request.getVersionId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("version", request.getVersion(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Version>newBuilder()
                      .setDefaultInstance(Version.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetVersionRequest, Version> getVersionMethodDescriptor =
      ApiMethodDescriptor.<GetVersionRequest, Version>newBuilder()
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetVersion")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetVersionRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apis/*/versions/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetVersionRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetVersionRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Version>newBuilder()
                  .setDefaultInstance(Version.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListVersionsRequest, ListVersionsResponse>
      listVersionsMethodDescriptor =
          ApiMethodDescriptor.<ListVersionsRequest, ListVersionsResponse>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/ListVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apis/*}/versions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListVersionsResponse>newBuilder()
                      .setDefaultInstance(ListVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateVersionRequest, Version>
      updateVersionMethodDescriptor =
          ApiMethodDescriptor.<UpdateVersionRequest, Version>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/UpdateVersion")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{version.name=projects/*/locations/*/apis/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "version.name", request.getVersion().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("version", request.getVersion(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Version>newBuilder()
                      .setDefaultInstance(Version.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteVersionRequest, Empty>
      deleteVersionMethodDescriptor =
          ApiMethodDescriptor.<DeleteVersionRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/DeleteVersion")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSpecRequest, Spec> createSpecMethodDescriptor =
      ApiMethodDescriptor.<CreateSpecRequest, Spec>newBuilder()
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/CreateSpec")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateSpecRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*/apis/*/versions/*}/specs",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSpecRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSpecRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "specId", request.getSpecId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("spec", request.getSpec(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Spec>newBuilder()
                  .setDefaultInstance(Spec.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetSpecRequest, Spec> getSpecMethodDescriptor =
      ApiMethodDescriptor.<GetSpecRequest, Spec>newBuilder()
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetSpec")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSpecRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apis/*/versions/*/specs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSpecRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSpecRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Spec>newBuilder()
                  .setDefaultInstance(Spec.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetSpecContentsRequest, SpecContents>
      getSpecContentsMethodDescriptor =
          ApiMethodDescriptor.<GetSpecContentsRequest, SpecContents>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetSpecContents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSpecContentsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/specs/*}:contents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSpecContentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSpecContentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SpecContents>newBuilder()
                      .setDefaultInstance(SpecContents.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSpecsRequest, ListSpecsResponse>
      listSpecsMethodDescriptor =
          ApiMethodDescriptor.<ListSpecsRequest, ListSpecsResponse>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/ListSpecs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSpecsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apis/*/versions/*}/specs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSpecsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSpecsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSpecsResponse>newBuilder()
                      .setDefaultInstance(ListSpecsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSpecRequest, Spec> updateSpecMethodDescriptor =
      ApiMethodDescriptor.<UpdateSpecRequest, Spec>newBuilder()
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/UpdateSpec")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateSpecRequest>newBuilder()
                  .setPath(
                      "/v1/{spec.name=projects/*/locations/*/apis/*/versions/*/specs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSpecRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "spec.name", request.getSpec().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSpecRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("spec", request.getSpec(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Spec>newBuilder()
                  .setDefaultInstance(Spec.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteSpecRequest, Empty> deleteSpecMethodDescriptor =
      ApiMethodDescriptor.<DeleteSpecRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/DeleteSpec")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteSpecRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apis/*/versions/*/specs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteSpecRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteSpecRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetApiOperationRequest, ApiOperation>
      getApiOperationMethodDescriptor =
          ApiMethodDescriptor.<GetApiOperationRequest, ApiOperation>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetApiOperation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetApiOperationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/operations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetApiOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetApiOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiOperation>newBuilder()
                      .setDefaultInstance(ApiOperation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListApiOperationsRequest, ListApiOperationsResponse>
      listApiOperationsMethodDescriptor =
          ApiMethodDescriptor.<ListApiOperationsRequest, ListApiOperationsResponse>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/ListApiOperations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApiOperationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apis/*/versions/*}/operations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApiOperationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApiOperationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListApiOperationsResponse>newBuilder()
                      .setDefaultInstance(ListApiOperationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDefinitionRequest, Definition>
      getDefinitionMethodDescriptor =
          ApiMethodDescriptor.<GetDefinitionRequest, Definition>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetDefinition")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDefinitionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/definitions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDefinitionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDefinitionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Definition>newBuilder()
                      .setDefaultInstance(Definition.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDeploymentRequest, Deployment>
      createDeploymentMethodDescriptor =
          ApiMethodDescriptor.<CreateDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/CreateDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/deployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "deploymentId", request.getDeploymentId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deployment", request.getDeployment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDeploymentRequest, Deployment>
      getDeploymentMethodDescriptor =
          ApiMethodDescriptor.<GetDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetDeployment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsMethodDescriptor =
          ApiMethodDescriptor.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/ListDeployments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDeploymentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/deployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDeploymentsResponse>newBuilder()
                      .setDefaultInstance(ListDeploymentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDeploymentRequest, Deployment>
      updateDeploymentMethodDescriptor =
          ApiMethodDescriptor.<UpdateDeploymentRequest, Deployment>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/UpdateDeployment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{deployment.name=projects/*/locations/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "deployment.name", request.getDeployment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("deployment", request.getDeployment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Deployment>newBuilder()
                      .setDefaultInstance(Deployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDeploymentRequest, Empty>
      deleteDeploymentMethodDescriptor =
          ApiMethodDescriptor.<DeleteDeploymentRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/DeleteDeployment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAttributeRequest, Attribute>
      createAttributeMethodDescriptor =
          ApiMethodDescriptor.<CreateAttributeRequest, Attribute>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/CreateAttribute")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAttributeRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/attributes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "attributeId", request.getAttributeId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("attribute", request.getAttribute(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Attribute>newBuilder()
                      .setDefaultInstance(Attribute.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAttributeRequest, Attribute>
      getAttributeMethodDescriptor =
          ApiMethodDescriptor.<GetAttributeRequest, Attribute>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetAttribute")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAttributeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/attributes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Attribute>newBuilder()
                      .setDefaultInstance(Attribute.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAttributeRequest, Attribute>
      updateAttributeMethodDescriptor =
          ApiMethodDescriptor.<UpdateAttributeRequest, Attribute>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/UpdateAttribute")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAttributeRequest>newBuilder()
                      .setPath(
                          "/v1/{attribute.name=projects/*/locations/*/attributes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "attribute.name", request.getAttribute().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("attribute", request.getAttribute(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Attribute>newBuilder()
                      .setDefaultInstance(Attribute.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAttributeRequest, Empty>
      deleteAttributeMethodDescriptor =
          ApiMethodDescriptor.<DeleteAttributeRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/DeleteAttribute")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAttributeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/attributes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAttributeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAttributesRequest, ListAttributesResponse>
      listAttributesMethodDescriptor =
          ApiMethodDescriptor.<ListAttributesRequest, ListAttributesResponse>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/ListAttributes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAttributesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/attributes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAttributesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAttributesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAttributesResponse>newBuilder()
                      .setDefaultInstance(ListAttributesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchResourcesRequest, SearchResourcesResponse>
      searchResourcesMethodDescriptor =
          ApiMethodDescriptor.<SearchResourcesRequest, SearchResourcesResponse>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/SearchResources")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchResourcesRequest>newBuilder()
                      .setPath(
                          "/v1/{location=projects/*/locations/*}:searchResources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearLocation().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchResourcesResponse>newBuilder()
                      .setDefaultInstance(SearchResourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateExternalApiRequest, ExternalApi>
      createExternalApiMethodDescriptor =
          ApiMethodDescriptor.<CreateExternalApiRequest, ExternalApi>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/CreateExternalApi")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateExternalApiRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/externalApis",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExternalApiRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateExternalApiRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "externalApiId", request.getExternalApiId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("externalApi", request.getExternalApi(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExternalApi>newBuilder()
                      .setDefaultInstance(ExternalApi.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetExternalApiRequest, ExternalApi>
      getExternalApiMethodDescriptor =
          ApiMethodDescriptor.<GetExternalApiRequest, ExternalApi>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetExternalApi")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetExternalApiRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/externalApis/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetExternalApiRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetExternalApiRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExternalApi>newBuilder()
                      .setDefaultInstance(ExternalApi.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateExternalApiRequest, ExternalApi>
      updateExternalApiMethodDescriptor =
          ApiMethodDescriptor.<UpdateExternalApiRequest, ExternalApi>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/UpdateExternalApi")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateExternalApiRequest>newBuilder()
                      .setPath(
                          "/v1/{externalApi.name=projects/*/locations/*/externalApis/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExternalApiRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "externalApi.name", request.getExternalApi().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateExternalApiRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("externalApi", request.getExternalApi(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExternalApi>newBuilder()
                      .setDefaultInstance(ExternalApi.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteExternalApiRequest, Empty>
      deleteExternalApiMethodDescriptor =
          ApiMethodDescriptor.<DeleteExternalApiRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/DeleteExternalApi")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteExternalApiRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/externalApis/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExternalApiRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExternalApiRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListExternalApisRequest, ListExternalApisResponse>
      listExternalApisMethodDescriptor =
          ApiMethodDescriptor.<ListExternalApisRequest, ListExternalApisResponse>newBuilder()
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/ListExternalApis")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListExternalApisRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/externalApis",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListExternalApisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListExternalApisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListExternalApisResponse>newBuilder()
                      .setDefaultInstance(ListExternalApisResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateApiRequest, Api> createApiCallable;
  private final UnaryCallable<GetApiRequest, Api> getApiCallable;
  private final UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable;
  private final UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable;
  private final UnaryCallable<UpdateApiRequest, Api> updateApiCallable;
  private final UnaryCallable<DeleteApiRequest, Empty> deleteApiCallable;
  private final UnaryCallable<CreateVersionRequest, Version> createVersionCallable;
  private final UnaryCallable<GetVersionRequest, Version> getVersionCallable;
  private final UnaryCallable<ListVersionsRequest, ListVersionsResponse> listVersionsCallable;
  private final UnaryCallable<ListVersionsRequest, ListVersionsPagedResponse>
      listVersionsPagedCallable;
  private final UnaryCallable<UpdateVersionRequest, Version> updateVersionCallable;
  private final UnaryCallable<DeleteVersionRequest, Empty> deleteVersionCallable;
  private final UnaryCallable<CreateSpecRequest, Spec> createSpecCallable;
  private final UnaryCallable<GetSpecRequest, Spec> getSpecCallable;
  private final UnaryCallable<GetSpecContentsRequest, SpecContents> getSpecContentsCallable;
  private final UnaryCallable<ListSpecsRequest, ListSpecsResponse> listSpecsCallable;
  private final UnaryCallable<ListSpecsRequest, ListSpecsPagedResponse> listSpecsPagedCallable;
  private final UnaryCallable<UpdateSpecRequest, Spec> updateSpecCallable;
  private final UnaryCallable<DeleteSpecRequest, Empty> deleteSpecCallable;
  private final UnaryCallable<GetApiOperationRequest, ApiOperation> getApiOperationCallable;
  private final UnaryCallable<ListApiOperationsRequest, ListApiOperationsResponse>
      listApiOperationsCallable;
  private final UnaryCallable<ListApiOperationsRequest, ListApiOperationsPagedResponse>
      listApiOperationsPagedCallable;
  private final UnaryCallable<GetDefinitionRequest, Definition> getDefinitionCallable;
  private final UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable;
  private final UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable;
  private final UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable;
  private final UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable;
  private final UnaryCallable<CreateAttributeRequest, Attribute> createAttributeCallable;
  private final UnaryCallable<GetAttributeRequest, Attribute> getAttributeCallable;
  private final UnaryCallable<UpdateAttributeRequest, Attribute> updateAttributeCallable;
  private final UnaryCallable<DeleteAttributeRequest, Empty> deleteAttributeCallable;
  private final UnaryCallable<ListAttributesRequest, ListAttributesResponse> listAttributesCallable;
  private final UnaryCallable<ListAttributesRequest, ListAttributesPagedResponse>
      listAttributesPagedCallable;
  private final UnaryCallable<SearchResourcesRequest, SearchResourcesResponse>
      searchResourcesCallable;
  private final UnaryCallable<SearchResourcesRequest, SearchResourcesPagedResponse>
      searchResourcesPagedCallable;
  private final UnaryCallable<CreateExternalApiRequest, ExternalApi> createExternalApiCallable;
  private final UnaryCallable<GetExternalApiRequest, ExternalApi> getExternalApiCallable;
  private final UnaryCallable<UpdateExternalApiRequest, ExternalApi> updateExternalApiCallable;
  private final UnaryCallable<DeleteExternalApiRequest, Empty> deleteExternalApiCallable;
  private final UnaryCallable<ListExternalApisRequest, ListExternalApisResponse>
      listExternalApisCallable;
  private final UnaryCallable<ListExternalApisRequest, ListExternalApisPagedResponse>
      listExternalApisPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonApiHubStub create(ApiHubStubSettings settings) throws IOException {
    return new HttpJsonApiHubStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonApiHubStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonApiHubStub(ApiHubStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonApiHubStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonApiHubStub(
        ApiHubStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonApiHubStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonApiHubStub(ApiHubStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonApiHubCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonApiHubStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonApiHubStub(
      ApiHubStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateApiRequest, Api> createApiTransportSettings =
        HttpJsonCallSettings.<CreateApiRequest, Api>newBuilder()
            .setMethodDescriptor(createApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetApiRequest, Api> getApiTransportSettings =
        HttpJsonCallSettings.<GetApiRequest, Api>newBuilder()
            .setMethodDescriptor(getApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListApisRequest, ListApisResponse> listApisTransportSettings =
        HttpJsonCallSettings.<ListApisRequest, ListApisResponse>newBuilder()
            .setMethodDescriptor(listApisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateApiRequest, Api> updateApiTransportSettings =
        HttpJsonCallSettings.<UpdateApiRequest, Api>newBuilder()
            .setMethodDescriptor(updateApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("api.name", String.valueOf(request.getApi().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteApiRequest, Empty> deleteApiTransportSettings =
        HttpJsonCallSettings.<DeleteApiRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateVersionRequest, Version> createVersionTransportSettings =
        HttpJsonCallSettings.<CreateVersionRequest, Version>newBuilder()
            .setMethodDescriptor(createVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetVersionRequest, Version> getVersionTransportSettings =
        HttpJsonCallSettings.<GetVersionRequest, Version>newBuilder()
            .setMethodDescriptor(getVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListVersionsRequest, ListVersionsResponse> listVersionsTransportSettings =
        HttpJsonCallSettings.<ListVersionsRequest, ListVersionsResponse>newBuilder()
            .setMethodDescriptor(listVersionsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateVersionRequest, Version> updateVersionTransportSettings =
        HttpJsonCallSettings.<UpdateVersionRequest, Version>newBuilder()
            .setMethodDescriptor(updateVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("version.name", String.valueOf(request.getVersion().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteVersionRequest, Empty> deleteVersionTransportSettings =
        HttpJsonCallSettings.<DeleteVersionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSpecRequest, Spec> createSpecTransportSettings =
        HttpJsonCallSettings.<CreateSpecRequest, Spec>newBuilder()
            .setMethodDescriptor(createSpecMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSpecRequest, Spec> getSpecTransportSettings =
        HttpJsonCallSettings.<GetSpecRequest, Spec>newBuilder()
            .setMethodDescriptor(getSpecMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSpecContentsRequest, SpecContents> getSpecContentsTransportSettings =
        HttpJsonCallSettings.<GetSpecContentsRequest, SpecContents>newBuilder()
            .setMethodDescriptor(getSpecContentsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListSpecsRequest, ListSpecsResponse> listSpecsTransportSettings =
        HttpJsonCallSettings.<ListSpecsRequest, ListSpecsResponse>newBuilder()
            .setMethodDescriptor(listSpecsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSpecRequest, Spec> updateSpecTransportSettings =
        HttpJsonCallSettings.<UpdateSpecRequest, Spec>newBuilder()
            .setMethodDescriptor(updateSpecMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("spec.name", String.valueOf(request.getSpec().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSpecRequest, Empty> deleteSpecTransportSettings =
        HttpJsonCallSettings.<DeleteSpecRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSpecMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetApiOperationRequest, ApiOperation> getApiOperationTransportSettings =
        HttpJsonCallSettings.<GetApiOperationRequest, ApiOperation>newBuilder()
            .setMethodDescriptor(getApiOperationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListApiOperationsRequest, ListApiOperationsResponse>
        listApiOperationsTransportSettings =
            HttpJsonCallSettings.<ListApiOperationsRequest, ListApiOperationsResponse>newBuilder()
                .setMethodDescriptor(listApiOperationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetDefinitionRequest, Definition> getDefinitionTransportSettings =
        HttpJsonCallSettings.<GetDefinitionRequest, Definition>newBuilder()
            .setMethodDescriptor(getDefinitionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateDeploymentRequest, Deployment> createDeploymentTransportSettings =
        HttpJsonCallSettings.<CreateDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(createDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetDeploymentRequest, Deployment> getDeploymentTransportSettings =
        HttpJsonCallSettings.<GetDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(getDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListDeploymentsRequest, ListDeploymentsResponse>
        listDeploymentsTransportSettings =
            HttpJsonCallSettings.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listDeploymentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentTransportSettings =
        HttpJsonCallSettings.<UpdateDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(updateDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("deployment.name", String.valueOf(request.getDeployment().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDeploymentRequest, Empty> deleteDeploymentTransportSettings =
        HttpJsonCallSettings.<DeleteDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateAttributeRequest, Attribute> createAttributeTransportSettings =
        HttpJsonCallSettings.<CreateAttributeRequest, Attribute>newBuilder()
            .setMethodDescriptor(createAttributeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetAttributeRequest, Attribute> getAttributeTransportSettings =
        HttpJsonCallSettings.<GetAttributeRequest, Attribute>newBuilder()
            .setMethodDescriptor(getAttributeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAttributeRequest, Attribute> updateAttributeTransportSettings =
        HttpJsonCallSettings.<UpdateAttributeRequest, Attribute>newBuilder()
            .setMethodDescriptor(updateAttributeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("attribute.name", String.valueOf(request.getAttribute().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteAttributeRequest, Empty> deleteAttributeTransportSettings =
        HttpJsonCallSettings.<DeleteAttributeRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAttributeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAttributesRequest, ListAttributesResponse>
        listAttributesTransportSettings =
            HttpJsonCallSettings.<ListAttributesRequest, ListAttributesResponse>newBuilder()
                .setMethodDescriptor(listAttributesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SearchResourcesRequest, SearchResourcesResponse>
        searchResourcesTransportSettings =
            HttpJsonCallSettings.<SearchResourcesRequest, SearchResourcesResponse>newBuilder()
                .setMethodDescriptor(searchResourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("location", String.valueOf(request.getLocation()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateExternalApiRequest, ExternalApi> createExternalApiTransportSettings =
        HttpJsonCallSettings.<CreateExternalApiRequest, ExternalApi>newBuilder()
            .setMethodDescriptor(createExternalApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetExternalApiRequest, ExternalApi> getExternalApiTransportSettings =
        HttpJsonCallSettings.<GetExternalApiRequest, ExternalApi>newBuilder()
            .setMethodDescriptor(getExternalApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateExternalApiRequest, ExternalApi> updateExternalApiTransportSettings =
        HttpJsonCallSettings.<UpdateExternalApiRequest, ExternalApi>newBuilder()
            .setMethodDescriptor(updateExternalApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "external_api.name", String.valueOf(request.getExternalApi().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteExternalApiRequest, Empty> deleteExternalApiTransportSettings =
        HttpJsonCallSettings.<DeleteExternalApiRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteExternalApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListExternalApisRequest, ListExternalApisResponse>
        listExternalApisTransportSettings =
            HttpJsonCallSettings.<ListExternalApisRequest, ListExternalApisResponse>newBuilder()
                .setMethodDescriptor(listExternalApisMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createApiCallable =
        callableFactory.createUnaryCallable(
            createApiTransportSettings, settings.createApiSettings(), clientContext);
    this.getApiCallable =
        callableFactory.createUnaryCallable(
            getApiTransportSettings, settings.getApiSettings(), clientContext);
    this.listApisCallable =
        callableFactory.createUnaryCallable(
            listApisTransportSettings, settings.listApisSettings(), clientContext);
    this.listApisPagedCallable =
        callableFactory.createPagedCallable(
            listApisTransportSettings, settings.listApisSettings(), clientContext);
    this.updateApiCallable =
        callableFactory.createUnaryCallable(
            updateApiTransportSettings, settings.updateApiSettings(), clientContext);
    this.deleteApiCallable =
        callableFactory.createUnaryCallable(
            deleteApiTransportSettings, settings.deleteApiSettings(), clientContext);
    this.createVersionCallable =
        callableFactory.createUnaryCallable(
            createVersionTransportSettings, settings.createVersionSettings(), clientContext);
    this.getVersionCallable =
        callableFactory.createUnaryCallable(
            getVersionTransportSettings, settings.getVersionSettings(), clientContext);
    this.listVersionsCallable =
        callableFactory.createUnaryCallable(
            listVersionsTransportSettings, settings.listVersionsSettings(), clientContext);
    this.listVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listVersionsTransportSettings, settings.listVersionsSettings(), clientContext);
    this.updateVersionCallable =
        callableFactory.createUnaryCallable(
            updateVersionTransportSettings, settings.updateVersionSettings(), clientContext);
    this.deleteVersionCallable =
        callableFactory.createUnaryCallable(
            deleteVersionTransportSettings, settings.deleteVersionSettings(), clientContext);
    this.createSpecCallable =
        callableFactory.createUnaryCallable(
            createSpecTransportSettings, settings.createSpecSettings(), clientContext);
    this.getSpecCallable =
        callableFactory.createUnaryCallable(
            getSpecTransportSettings, settings.getSpecSettings(), clientContext);
    this.getSpecContentsCallable =
        callableFactory.createUnaryCallable(
            getSpecContentsTransportSettings, settings.getSpecContentsSettings(), clientContext);
    this.listSpecsCallable =
        callableFactory.createUnaryCallable(
            listSpecsTransportSettings, settings.listSpecsSettings(), clientContext);
    this.listSpecsPagedCallable =
        callableFactory.createPagedCallable(
            listSpecsTransportSettings, settings.listSpecsSettings(), clientContext);
    this.updateSpecCallable =
        callableFactory.createUnaryCallable(
            updateSpecTransportSettings, settings.updateSpecSettings(), clientContext);
    this.deleteSpecCallable =
        callableFactory.createUnaryCallable(
            deleteSpecTransportSettings, settings.deleteSpecSettings(), clientContext);
    this.getApiOperationCallable =
        callableFactory.createUnaryCallable(
            getApiOperationTransportSettings, settings.getApiOperationSettings(), clientContext);
    this.listApiOperationsCallable =
        callableFactory.createUnaryCallable(
            listApiOperationsTransportSettings,
            settings.listApiOperationsSettings(),
            clientContext);
    this.listApiOperationsPagedCallable =
        callableFactory.createPagedCallable(
            listApiOperationsTransportSettings,
            settings.listApiOperationsSettings(),
            clientContext);
    this.getDefinitionCallable =
        callableFactory.createUnaryCallable(
            getDefinitionTransportSettings, settings.getDefinitionSettings(), clientContext);
    this.createDeploymentCallable =
        callableFactory.createUnaryCallable(
            createDeploymentTransportSettings, settings.createDeploymentSettings(), clientContext);
    this.getDeploymentCallable =
        callableFactory.createUnaryCallable(
            getDeploymentTransportSettings, settings.getDeploymentSettings(), clientContext);
    this.listDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.listDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.updateDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateDeploymentTransportSettings, settings.updateDeploymentSettings(), clientContext);
    this.deleteDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteDeploymentTransportSettings, settings.deleteDeploymentSettings(), clientContext);
    this.createAttributeCallable =
        callableFactory.createUnaryCallable(
            createAttributeTransportSettings, settings.createAttributeSettings(), clientContext);
    this.getAttributeCallable =
        callableFactory.createUnaryCallable(
            getAttributeTransportSettings, settings.getAttributeSettings(), clientContext);
    this.updateAttributeCallable =
        callableFactory.createUnaryCallable(
            updateAttributeTransportSettings, settings.updateAttributeSettings(), clientContext);
    this.deleteAttributeCallable =
        callableFactory.createUnaryCallable(
            deleteAttributeTransportSettings, settings.deleteAttributeSettings(), clientContext);
    this.listAttributesCallable =
        callableFactory.createUnaryCallable(
            listAttributesTransportSettings, settings.listAttributesSettings(), clientContext);
    this.listAttributesPagedCallable =
        callableFactory.createPagedCallable(
            listAttributesTransportSettings, settings.listAttributesSettings(), clientContext);
    this.searchResourcesCallable =
        callableFactory.createUnaryCallable(
            searchResourcesTransportSettings, settings.searchResourcesSettings(), clientContext);
    this.searchResourcesPagedCallable =
        callableFactory.createPagedCallable(
            searchResourcesTransportSettings, settings.searchResourcesSettings(), clientContext);
    this.createExternalApiCallable =
        callableFactory.createUnaryCallable(
            createExternalApiTransportSettings,
            settings.createExternalApiSettings(),
            clientContext);
    this.getExternalApiCallable =
        callableFactory.createUnaryCallable(
            getExternalApiTransportSettings, settings.getExternalApiSettings(), clientContext);
    this.updateExternalApiCallable =
        callableFactory.createUnaryCallable(
            updateExternalApiTransportSettings,
            settings.updateExternalApiSettings(),
            clientContext);
    this.deleteExternalApiCallable =
        callableFactory.createUnaryCallable(
            deleteExternalApiTransportSettings,
            settings.deleteExternalApiSettings(),
            clientContext);
    this.listExternalApisCallable =
        callableFactory.createUnaryCallable(
            listExternalApisTransportSettings, settings.listExternalApisSettings(), clientContext);
    this.listExternalApisPagedCallable =
        callableFactory.createPagedCallable(
            listExternalApisTransportSettings, settings.listExternalApisSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createApiMethodDescriptor);
    methodDescriptors.add(getApiMethodDescriptor);
    methodDescriptors.add(listApisMethodDescriptor);
    methodDescriptors.add(updateApiMethodDescriptor);
    methodDescriptors.add(deleteApiMethodDescriptor);
    methodDescriptors.add(createVersionMethodDescriptor);
    methodDescriptors.add(getVersionMethodDescriptor);
    methodDescriptors.add(listVersionsMethodDescriptor);
    methodDescriptors.add(updateVersionMethodDescriptor);
    methodDescriptors.add(deleteVersionMethodDescriptor);
    methodDescriptors.add(createSpecMethodDescriptor);
    methodDescriptors.add(getSpecMethodDescriptor);
    methodDescriptors.add(getSpecContentsMethodDescriptor);
    methodDescriptors.add(listSpecsMethodDescriptor);
    methodDescriptors.add(updateSpecMethodDescriptor);
    methodDescriptors.add(deleteSpecMethodDescriptor);
    methodDescriptors.add(getApiOperationMethodDescriptor);
    methodDescriptors.add(listApiOperationsMethodDescriptor);
    methodDescriptors.add(getDefinitionMethodDescriptor);
    methodDescriptors.add(createDeploymentMethodDescriptor);
    methodDescriptors.add(getDeploymentMethodDescriptor);
    methodDescriptors.add(listDeploymentsMethodDescriptor);
    methodDescriptors.add(updateDeploymentMethodDescriptor);
    methodDescriptors.add(deleteDeploymentMethodDescriptor);
    methodDescriptors.add(createAttributeMethodDescriptor);
    methodDescriptors.add(getAttributeMethodDescriptor);
    methodDescriptors.add(updateAttributeMethodDescriptor);
    methodDescriptors.add(deleteAttributeMethodDescriptor);
    methodDescriptors.add(listAttributesMethodDescriptor);
    methodDescriptors.add(searchResourcesMethodDescriptor);
    methodDescriptors.add(createExternalApiMethodDescriptor);
    methodDescriptors.add(getExternalApiMethodDescriptor);
    methodDescriptors.add(updateExternalApiMethodDescriptor);
    methodDescriptors.add(deleteExternalApiMethodDescriptor);
    methodDescriptors.add(listExternalApisMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateApiRequest, Api> createApiCallable() {
    return createApiCallable;
  }

  @Override
  public UnaryCallable<GetApiRequest, Api> getApiCallable() {
    return getApiCallable;
  }

  @Override
  public UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable() {
    return listApisCallable;
  }

  @Override
  public UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable() {
    return listApisPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateApiRequest, Api> updateApiCallable() {
    return updateApiCallable;
  }

  @Override
  public UnaryCallable<DeleteApiRequest, Empty> deleteApiCallable() {
    return deleteApiCallable;
  }

  @Override
  public UnaryCallable<CreateVersionRequest, Version> createVersionCallable() {
    return createVersionCallable;
  }

  @Override
  public UnaryCallable<GetVersionRequest, Version> getVersionCallable() {
    return getVersionCallable;
  }

  @Override
  public UnaryCallable<ListVersionsRequest, ListVersionsResponse> listVersionsCallable() {
    return listVersionsCallable;
  }

  @Override
  public UnaryCallable<ListVersionsRequest, ListVersionsPagedResponse> listVersionsPagedCallable() {
    return listVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateVersionRequest, Version> updateVersionCallable() {
    return updateVersionCallable;
  }

  @Override
  public UnaryCallable<DeleteVersionRequest, Empty> deleteVersionCallable() {
    return deleteVersionCallable;
  }

  @Override
  public UnaryCallable<CreateSpecRequest, Spec> createSpecCallable() {
    return createSpecCallable;
  }

  @Override
  public UnaryCallable<GetSpecRequest, Spec> getSpecCallable() {
    return getSpecCallable;
  }

  @Override
  public UnaryCallable<GetSpecContentsRequest, SpecContents> getSpecContentsCallable() {
    return getSpecContentsCallable;
  }

  @Override
  public UnaryCallable<ListSpecsRequest, ListSpecsResponse> listSpecsCallable() {
    return listSpecsCallable;
  }

  @Override
  public UnaryCallable<ListSpecsRequest, ListSpecsPagedResponse> listSpecsPagedCallable() {
    return listSpecsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateSpecRequest, Spec> updateSpecCallable() {
    return updateSpecCallable;
  }

  @Override
  public UnaryCallable<DeleteSpecRequest, Empty> deleteSpecCallable() {
    return deleteSpecCallable;
  }

  @Override
  public UnaryCallable<GetApiOperationRequest, ApiOperation> getApiOperationCallable() {
    return getApiOperationCallable;
  }

  @Override
  public UnaryCallable<ListApiOperationsRequest, ListApiOperationsResponse>
      listApiOperationsCallable() {
    return listApiOperationsCallable;
  }

  @Override
  public UnaryCallable<ListApiOperationsRequest, ListApiOperationsPagedResponse>
      listApiOperationsPagedCallable() {
    return listApiOperationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDefinitionRequest, Definition> getDefinitionCallable() {
    return getDefinitionCallable;
  }

  @Override
  public UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    return createDeploymentCallable;
  }

  @Override
  public UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    return getDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> listDeploymentsCallable() {
    return listDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    return listDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable() {
    return updateDeploymentCallable;
  }

  @Override
  public UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable() {
    return deleteDeploymentCallable;
  }

  @Override
  public UnaryCallable<CreateAttributeRequest, Attribute> createAttributeCallable() {
    return createAttributeCallable;
  }

  @Override
  public UnaryCallable<GetAttributeRequest, Attribute> getAttributeCallable() {
    return getAttributeCallable;
  }

  @Override
  public UnaryCallable<UpdateAttributeRequest, Attribute> updateAttributeCallable() {
    return updateAttributeCallable;
  }

  @Override
  public UnaryCallable<DeleteAttributeRequest, Empty> deleteAttributeCallable() {
    return deleteAttributeCallable;
  }

  @Override
  public UnaryCallable<ListAttributesRequest, ListAttributesResponse> listAttributesCallable() {
    return listAttributesCallable;
  }

  @Override
  public UnaryCallable<ListAttributesRequest, ListAttributesPagedResponse>
      listAttributesPagedCallable() {
    return listAttributesPagedCallable;
  }

  @Override
  public UnaryCallable<SearchResourcesRequest, SearchResourcesResponse> searchResourcesCallable() {
    return searchResourcesCallable;
  }

  @Override
  public UnaryCallable<SearchResourcesRequest, SearchResourcesPagedResponse>
      searchResourcesPagedCallable() {
    return searchResourcesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateExternalApiRequest, ExternalApi> createExternalApiCallable() {
    return createExternalApiCallable;
  }

  @Override
  public UnaryCallable<GetExternalApiRequest, ExternalApi> getExternalApiCallable() {
    return getExternalApiCallable;
  }

  @Override
  public UnaryCallable<UpdateExternalApiRequest, ExternalApi> updateExternalApiCallable() {
    return updateExternalApiCallable;
  }

  @Override
  public UnaryCallable<DeleteExternalApiRequest, Empty> deleteExternalApiCallable() {
    return deleteExternalApiCallable;
  }

  @Override
  public UnaryCallable<ListExternalApisRequest, ListExternalApisResponse>
      listExternalApisCallable() {
    return listExternalApisCallable;
  }

  @Override
  public UnaryCallable<ListExternalApisRequest, ListExternalApisPagedResponse>
      listExternalApisPagedCallable() {
    return listExternalApisPagedCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
