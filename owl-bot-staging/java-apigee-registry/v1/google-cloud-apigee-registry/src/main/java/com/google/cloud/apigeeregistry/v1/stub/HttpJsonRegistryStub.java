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

package com.google.cloud.apigeeregistry.v1.stub;

import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiDeploymentRevisionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiDeploymentsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiSpecRevisionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiSpecsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiVersionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApisPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListArtifactsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListLocationsPagedResponse;

import com.google.api.HttpBody;
import com.google.api.core.BetaApi;
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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apigeeregistry.v1.Api;
import com.google.cloud.apigeeregistry.v1.ApiDeployment;
import com.google.cloud.apigeeregistry.v1.ApiSpec;
import com.google.cloud.apigeeregistry.v1.ApiVersion;
import com.google.cloud.apigeeregistry.v1.Artifact;
import com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.CreateApiRequest;
import com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest;
import com.google.cloud.apigeeregistry.v1.CreateArtifactRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest;
import com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest;
import com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.GetApiRequest;
import com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest;
import com.google.cloud.apigeeregistry.v1.GetApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.GetApiVersionRequest;
import com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest;
import com.google.cloud.apigeeregistry.v1.GetArtifactRequest;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse;
import com.google.cloud.apigeeregistry.v1.ListApisRequest;
import com.google.cloud.apigeeregistry.v1.ListApisResponse;
import com.google.cloud.apigeeregistry.v1.ListArtifactsRequest;
import com.google.cloud.apigeeregistry.v1.ListArtifactsResponse;
import com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest;
import com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest;
import com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the Registry service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRegistryStub extends RegistryStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListApisRequest, ListApisResponse>
      listApisMethodDescriptor =
          ApiMethodDescriptor.<ListApisRequest, ListApisResponse>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/ListApis")
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

  private static final ApiMethodDescriptor<GetApiRequest, Api> getApiMethodDescriptor =
      ApiMethodDescriptor.<GetApiRequest, Api>newBuilder()
          .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/GetApi")
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

  private static final ApiMethodDescriptor<CreateApiRequest, Api> createApiMethodDescriptor =
      ApiMethodDescriptor.<CreateApiRequest, Api>newBuilder()
          .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/CreateApi")
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
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("api", request.getApi(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Api>newBuilder()
                  .setDefaultInstance(Api.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateApiRequest, Api> updateApiMethodDescriptor =
      ApiMethodDescriptor.<UpdateApiRequest, Api>newBuilder()
          .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/UpdateApi")
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
                        serializer.putQueryParam(fields, "allowMissing", request.getAllowMissing());
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("api", request.getApi(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Api>newBuilder()
                  .setDefaultInstance(Api.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteApiRequest, Empty> deleteApiMethodDescriptor =
      ApiMethodDescriptor.<DeleteApiRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/DeleteApi")
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

  private static final ApiMethodDescriptor<ListApiVersionsRequest, ListApiVersionsResponse>
      listApiVersionsMethodDescriptor =
          ApiMethodDescriptor.<ListApiVersionsRequest, ListApiVersionsResponse>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/ListApiVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApiVersionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apis/*}/versions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApiVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApiVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListApiVersionsResponse>newBuilder()
                      .setDefaultInstance(ListApiVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetApiVersionRequest, ApiVersion>
      getApiVersionMethodDescriptor =
          ApiMethodDescriptor.<GetApiVersionRequest, ApiVersion>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/GetApiVersion")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetApiVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetApiVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetApiVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiVersion>newBuilder()
                      .setDefaultInstance(ApiVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateApiVersionRequest, ApiVersion>
      createApiVersionMethodDescriptor =
          ApiMethodDescriptor.<CreateApiVersionRequest, ApiVersion>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/CreateApiVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateApiVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apis/*}/versions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApiVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApiVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "apiVersionId", request.getApiVersionId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("apiVersion", request.getApiVersion(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiVersion>newBuilder()
                      .setDefaultInstance(ApiVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateApiVersionRequest, ApiVersion>
      updateApiVersionMethodDescriptor =
          ApiMethodDescriptor.<UpdateApiVersionRequest, ApiVersion>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/UpdateApiVersion")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateApiVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{apiVersion.name=projects/*/locations/*/apis/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApiVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "apiVersion.name", request.getApiVersion().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApiVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("apiVersion", request.getApiVersion(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiVersion>newBuilder()
                      .setDefaultInstance(ApiVersion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteApiVersionRequest, Empty>
      deleteApiVersionMethodDescriptor =
          ApiMethodDescriptor.<DeleteApiVersionRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/DeleteApiVersion")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteApiVersionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApiVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApiVersionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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

  private static final ApiMethodDescriptor<ListApiSpecsRequest, ListApiSpecsResponse>
      listApiSpecsMethodDescriptor =
          ApiMethodDescriptor.<ListApiSpecsRequest, ListApiSpecsResponse>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/ListApiSpecs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApiSpecsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apis/*/versions/*}/specs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApiSpecsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApiSpecsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListApiSpecsResponse>newBuilder()
                      .setDefaultInstance(ListApiSpecsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetApiSpecRequest, ApiSpec> getApiSpecMethodDescriptor =
      ApiMethodDescriptor.<GetApiSpecRequest, ApiSpec>newBuilder()
          .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/GetApiSpec")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetApiSpecRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/apis/*/versions/*/specs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetApiSpecRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetApiSpecRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<ApiSpec>newBuilder()
                  .setDefaultInstance(ApiSpec.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetApiSpecContentsRequest, HttpBody>
      getApiSpecContentsMethodDescriptor =
          ApiMethodDescriptor.<GetApiSpecContentsRequest, HttpBody>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/GetApiSpecContents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetApiSpecContentsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/specs/*}:getContents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetApiSpecContentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetApiSpecContentsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HttpBody>newBuilder()
                      .setDefaultInstance(HttpBody.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateApiSpecRequest, ApiSpec>
      createApiSpecMethodDescriptor =
          ApiMethodDescriptor.<CreateApiSpecRequest, ApiSpec>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/CreateApiSpec")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateApiSpecRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apis/*/versions/*}/specs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApiSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApiSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "apiSpecId", request.getApiSpecId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("apiSpec", request.getApiSpec(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiSpec>newBuilder()
                      .setDefaultInstance(ApiSpec.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateApiSpecRequest, ApiSpec>
      updateApiSpecMethodDescriptor =
          ApiMethodDescriptor.<UpdateApiSpecRequest, ApiSpec>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/UpdateApiSpec")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateApiSpecRequest>newBuilder()
                      .setPath(
                          "/v1/{apiSpec.name=projects/*/locations/*/apis/*/versions/*/specs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApiSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "apiSpec.name", request.getApiSpec().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApiSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("apiSpec", request.getApiSpec(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiSpec>newBuilder()
                      .setDefaultInstance(ApiSpec.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteApiSpecRequest, Empty>
      deleteApiSpecMethodDescriptor =
          ApiMethodDescriptor.<DeleteApiSpecRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/DeleteApiSpec")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteApiSpecRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/specs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApiSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApiSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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

  private static final ApiMethodDescriptor<TagApiSpecRevisionRequest, ApiSpec>
      tagApiSpecRevisionMethodDescriptor =
          ApiMethodDescriptor.<TagApiSpecRevisionRequest, ApiSpec>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/TagApiSpecRevision")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TagApiSpecRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/specs/*}:tagRevision",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TagApiSpecRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TagApiSpecRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiSpec>newBuilder()
                      .setDefaultInstance(ApiSpec.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse>
      listApiSpecRevisionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/ListApiSpecRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApiSpecRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/specs/*}:listRevisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApiSpecRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApiSpecRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListApiSpecRevisionsResponse>newBuilder()
                      .setDefaultInstance(ListApiSpecRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RollbackApiSpecRequest, ApiSpec>
      rollbackApiSpecMethodDescriptor =
          ApiMethodDescriptor.<RollbackApiSpecRequest, ApiSpec>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/RollbackApiSpec")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RollbackApiSpecRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/specs/*}:rollback",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RollbackApiSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RollbackApiSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiSpec>newBuilder()
                      .setDefaultInstance(ApiSpec.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteApiSpecRevisionRequest, ApiSpec>
      deleteApiSpecRevisionMethodDescriptor =
          ApiMethodDescriptor.<DeleteApiSpecRevisionRequest, ApiSpec>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/DeleteApiSpecRevision")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteApiSpecRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/specs/*}:deleteRevision",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApiSpecRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApiSpecRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiSpec>newBuilder()
                      .setDefaultInstance(ApiSpec.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListApiDeploymentsRequest, ListApiDeploymentsResponse>
      listApiDeploymentsMethodDescriptor =
          ApiMethodDescriptor.<ListApiDeploymentsRequest, ListApiDeploymentsResponse>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/ListApiDeployments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApiDeploymentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apis/*}/deployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApiDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApiDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListApiDeploymentsResponse>newBuilder()
                      .setDefaultInstance(ListApiDeploymentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetApiDeploymentRequest, ApiDeployment>
      getApiDeploymentMethodDescriptor =
          ApiMethodDescriptor.<GetApiDeploymentRequest, ApiDeployment>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/GetApiDeployment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetApiDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetApiDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetApiDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiDeployment>newBuilder()
                      .setDefaultInstance(ApiDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateApiDeploymentRequest, ApiDeployment>
      createApiDeploymentMethodDescriptor =
          ApiMethodDescriptor.<CreateApiDeploymentRequest, ApiDeployment>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/CreateApiDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateApiDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/apis/*}/deployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApiDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApiDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "apiDeploymentId", request.getApiDeploymentId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("apiDeployment", request.getApiDeployment(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiDeployment>newBuilder()
                      .setDefaultInstance(ApiDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateApiDeploymentRequest, ApiDeployment>
      updateApiDeploymentMethodDescriptor =
          ApiMethodDescriptor.<UpdateApiDeploymentRequest, ApiDeployment>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/UpdateApiDeployment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateApiDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{apiDeployment.name=projects/*/locations/*/apis/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApiDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "apiDeployment.name", request.getApiDeployment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApiDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("apiDeployment", request.getApiDeployment(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiDeployment>newBuilder()
                      .setDefaultInstance(ApiDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteApiDeploymentRequest, Empty>
      deleteApiDeploymentMethodDescriptor =
          ApiMethodDescriptor.<DeleteApiDeploymentRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/DeleteApiDeployment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteApiDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/deployments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApiDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApiDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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

  private static final ApiMethodDescriptor<TagApiDeploymentRevisionRequest, ApiDeployment>
      tagApiDeploymentRevisionMethodDescriptor =
          ApiMethodDescriptor.<TagApiDeploymentRevisionRequest, ApiDeployment>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/TagApiDeploymentRevision")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TagApiDeploymentRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/deployments/*}:tagRevision",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TagApiDeploymentRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TagApiDeploymentRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiDeployment>newBuilder()
                      .setDefaultInstance(ApiDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>
      listApiDeploymentRevisionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.apigeeregistry.v1.Registry/ListApiDeploymentRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApiDeploymentRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/deployments/*}:listRevisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApiDeploymentRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApiDeploymentRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListApiDeploymentRevisionsResponse>newBuilder()
                      .setDefaultInstance(ListApiDeploymentRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RollbackApiDeploymentRequest, ApiDeployment>
      rollbackApiDeploymentMethodDescriptor =
          ApiMethodDescriptor.<RollbackApiDeploymentRequest, ApiDeployment>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/RollbackApiDeployment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RollbackApiDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/deployments/*}:rollback",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RollbackApiDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RollbackApiDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiDeployment>newBuilder()
                      .setDefaultInstance(ApiDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteApiDeploymentRevisionRequest, ApiDeployment>
      deleteApiDeploymentRevisionMethodDescriptor =
          ApiMethodDescriptor.<DeleteApiDeploymentRevisionRequest, ApiDeployment>newBuilder()
              .setFullMethodName(
                  "google.cloud.apigeeregistry.v1.Registry/DeleteApiDeploymentRevision")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteApiDeploymentRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/apis/*/deployments/*}:deleteRevision",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApiDeploymentRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteApiDeploymentRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApiDeployment>newBuilder()
                      .setDefaultInstance(ApiDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListArtifactsRequest, ListArtifactsResponse>
      listArtifactsMethodDescriptor =
          ApiMethodDescriptor.<ListArtifactsRequest, ListArtifactsResponse>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/ListArtifacts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListArtifactsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/artifacts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListArtifactsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/apis/*}/artifacts",
                          "/v1/{parent=projects/*/locations/*/apis/*/versions/*}/artifacts",
                          "/v1/{parent=projects/*/locations/*/apis/*/versions/*/specs/*}/artifacts",
                          "/v1/{parent=projects/*/locations/*/apis/*/deployments/*}/artifacts")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListArtifactsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListArtifactsResponse>newBuilder()
                      .setDefaultInstance(ListArtifactsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetArtifactRequest, Artifact>
      getArtifactMethodDescriptor =
          ApiMethodDescriptor.<GetArtifactRequest, Artifact>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/GetArtifact")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetArtifactRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/artifacts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetArtifactRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/apis/*/artifacts/*}",
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/artifacts/*}",
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/specs/*/artifacts/*}",
                          "/v1/{name=projects/*/locations/*/apis/*/deployments/*/artifacts/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetArtifactRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Artifact>newBuilder()
                      .setDefaultInstance(Artifact.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetArtifactContentsRequest, HttpBody>
      getArtifactContentsMethodDescriptor =
          ApiMethodDescriptor.<GetArtifactContentsRequest, HttpBody>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/GetArtifactContents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetArtifactContentsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/artifacts/*}:getContents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetArtifactContentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/apis/*/artifacts/*}:getContents",
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/artifacts/*}:getContents",
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/specs/*/artifacts/*}:getContents",
                          "/v1/{name=projects/*/locations/*/apis/*/deployments/*/artifacts/*}:getContents")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetArtifactContentsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HttpBody>newBuilder()
                      .setDefaultInstance(HttpBody.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateArtifactRequest, Artifact>
      createArtifactMethodDescriptor =
          ApiMethodDescriptor.<CreateArtifactRequest, Artifact>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/CreateArtifact")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateArtifactRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/artifacts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateArtifactRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=projects/*/locations/*/apis/*}/artifacts",
                          "/v1/{parent=projects/*/locations/*/apis/*/versions/*}/artifacts",
                          "/v1/{parent=projects/*/locations/*/apis/*/versions/*/specs/*}/artifacts",
                          "/v1/{parent=projects/*/locations/*/apis/*/deployments/*}/artifacts")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateArtifactRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "artifactId", request.getArtifactId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("artifact", request.getArtifact(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Artifact>newBuilder()
                      .setDefaultInstance(Artifact.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ReplaceArtifactRequest, Artifact>
      replaceArtifactMethodDescriptor =
          ApiMethodDescriptor.<ReplaceArtifactRequest, Artifact>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/ReplaceArtifact")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReplaceArtifactRequest>newBuilder()
                      .setPath(
                          "/v1/{artifact.name=projects/*/locations/*/artifacts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReplaceArtifactRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "artifact.name", request.getArtifact().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{artifact.name=projects/*/locations/*/apis/*/artifacts/*}",
                          "/v1/{artifact.name=projects/*/locations/*/apis/*/versions/*/artifacts/*}",
                          "/v1/{artifact.name=projects/*/locations/*/apis/*/versions/*/specs/*/artifacts/*}",
                          "/v1/{artifact.name=projects/*/locations/*/apis/*/deployments/*/artifacts/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReplaceArtifactRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("artifact", request.getArtifact(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Artifact>newBuilder()
                      .setDefaultInstance(Artifact.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteArtifactRequest, Empty>
      deleteArtifactMethodDescriptor =
          ApiMethodDescriptor.<DeleteArtifactRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/DeleteArtifact")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteArtifactRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/artifacts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteArtifactRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/apis/*/artifacts/*}",
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/artifacts/*}",
                          "/v1/{name=projects/*/locations/*/apis/*/versions/*/specs/*/artifacts/*}",
                          "/v1/{name=projects/*/locations/*/apis/*/deployments/*/artifacts/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteArtifactRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/apis/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/apis/*/deployments/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/apis/*/versions/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/apis/*/versions/*/specs/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/artifacts/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/apis/*/artifacts/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/apis/*/versions/*/artifacts/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/apis/*/versions/*/specs/*/artifacts/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/instances/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/runtime}:setIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/apis/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/apis/*/deployments/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/apis/*/versions/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/apis/*/versions/*/specs/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/artifacts/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/apis/*/artifacts/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/apis/*/versions/*/artifacts/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/apis/*/versions/*/specs/*/artifacts/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/instances/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/runtime}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/apis/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/apis/*/deployments/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/apis/*/versions/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/apis/*/versions/*/specs/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/artifacts/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/apis/*/artifacts/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/apis/*/versions/*/artifacts/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/apis/*/versions/*/specs/*/artifacts/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/instances/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/runtime}:testIamPermissions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable;
  private final UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable;
  private final UnaryCallable<GetApiRequest, Api> getApiCallable;
  private final UnaryCallable<CreateApiRequest, Api> createApiCallable;
  private final UnaryCallable<UpdateApiRequest, Api> updateApiCallable;
  private final UnaryCallable<DeleteApiRequest, Empty> deleteApiCallable;
  private final UnaryCallable<ListApiVersionsRequest, ListApiVersionsResponse>
      listApiVersionsCallable;
  private final UnaryCallable<ListApiVersionsRequest, ListApiVersionsPagedResponse>
      listApiVersionsPagedCallable;
  private final UnaryCallable<GetApiVersionRequest, ApiVersion> getApiVersionCallable;
  private final UnaryCallable<CreateApiVersionRequest, ApiVersion> createApiVersionCallable;
  private final UnaryCallable<UpdateApiVersionRequest, ApiVersion> updateApiVersionCallable;
  private final UnaryCallable<DeleteApiVersionRequest, Empty> deleteApiVersionCallable;
  private final UnaryCallable<ListApiSpecsRequest, ListApiSpecsResponse> listApiSpecsCallable;
  private final UnaryCallable<ListApiSpecsRequest, ListApiSpecsPagedResponse>
      listApiSpecsPagedCallable;
  private final UnaryCallable<GetApiSpecRequest, ApiSpec> getApiSpecCallable;
  private final UnaryCallable<GetApiSpecContentsRequest, HttpBody> getApiSpecContentsCallable;
  private final UnaryCallable<CreateApiSpecRequest, ApiSpec> createApiSpecCallable;
  private final UnaryCallable<UpdateApiSpecRequest, ApiSpec> updateApiSpecCallable;
  private final UnaryCallable<DeleteApiSpecRequest, Empty> deleteApiSpecCallable;
  private final UnaryCallable<TagApiSpecRevisionRequest, ApiSpec> tagApiSpecRevisionCallable;
  private final UnaryCallable<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse>
      listApiSpecRevisionsCallable;
  private final UnaryCallable<ListApiSpecRevisionsRequest, ListApiSpecRevisionsPagedResponse>
      listApiSpecRevisionsPagedCallable;
  private final UnaryCallable<RollbackApiSpecRequest, ApiSpec> rollbackApiSpecCallable;
  private final UnaryCallable<DeleteApiSpecRevisionRequest, ApiSpec> deleteApiSpecRevisionCallable;
  private final UnaryCallable<ListApiDeploymentsRequest, ListApiDeploymentsResponse>
      listApiDeploymentsCallable;
  private final UnaryCallable<ListApiDeploymentsRequest, ListApiDeploymentsPagedResponse>
      listApiDeploymentsPagedCallable;
  private final UnaryCallable<GetApiDeploymentRequest, ApiDeployment> getApiDeploymentCallable;
  private final UnaryCallable<CreateApiDeploymentRequest, ApiDeployment>
      createApiDeploymentCallable;
  private final UnaryCallable<UpdateApiDeploymentRequest, ApiDeployment>
      updateApiDeploymentCallable;
  private final UnaryCallable<DeleteApiDeploymentRequest, Empty> deleteApiDeploymentCallable;
  private final UnaryCallable<TagApiDeploymentRevisionRequest, ApiDeployment>
      tagApiDeploymentRevisionCallable;
  private final UnaryCallable<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>
      listApiDeploymentRevisionsCallable;
  private final UnaryCallable<
          ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsPagedResponse>
      listApiDeploymentRevisionsPagedCallable;
  private final UnaryCallable<RollbackApiDeploymentRequest, ApiDeployment>
      rollbackApiDeploymentCallable;
  private final UnaryCallable<DeleteApiDeploymentRevisionRequest, ApiDeployment>
      deleteApiDeploymentRevisionCallable;
  private final UnaryCallable<ListArtifactsRequest, ListArtifactsResponse> listArtifactsCallable;
  private final UnaryCallable<ListArtifactsRequest, ListArtifactsPagedResponse>
      listArtifactsPagedCallable;
  private final UnaryCallable<GetArtifactRequest, Artifact> getArtifactCallable;
  private final UnaryCallable<GetArtifactContentsRequest, HttpBody> getArtifactContentsCallable;
  private final UnaryCallable<CreateArtifactRequest, Artifact> createArtifactCallable;
  private final UnaryCallable<ReplaceArtifactRequest, Artifact> replaceArtifactCallable;
  private final UnaryCallable<DeleteArtifactRequest, Empty> deleteArtifactCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegistryStub create(RegistryStubSettings settings)
      throws IOException {
    return new HttpJsonRegistryStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegistryStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonRegistryStub(
        RegistryStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRegistryStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegistryStub(
        RegistryStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegistryStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRegistryStub(RegistryStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegistryCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegistryStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRegistryStub(
      RegistryStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListApisRequest, ListApisResponse> listApisTransportSettings =
        HttpJsonCallSettings.<ListApisRequest, ListApisResponse>newBuilder()
            .setMethodDescriptor(listApisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetApiRequest, Api> getApiTransportSettings =
        HttpJsonCallSettings.<GetApiRequest, Api>newBuilder()
            .setMethodDescriptor(getApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateApiRequest, Api> createApiTransportSettings =
        HttpJsonCallSettings.<CreateApiRequest, Api>newBuilder()
            .setMethodDescriptor(createApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateApiRequest, Api> updateApiTransportSettings =
        HttpJsonCallSettings.<UpdateApiRequest, Api>newBuilder()
            .setMethodDescriptor(updateApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteApiRequest, Empty> deleteApiTransportSettings =
        HttpJsonCallSettings.<DeleteApiRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteApiMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListApiVersionsRequest, ListApiVersionsResponse>
        listApiVersionsTransportSettings =
            HttpJsonCallSettings.<ListApiVersionsRequest, ListApiVersionsResponse>newBuilder()
                .setMethodDescriptor(listApiVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetApiVersionRequest, ApiVersion> getApiVersionTransportSettings =
        HttpJsonCallSettings.<GetApiVersionRequest, ApiVersion>newBuilder()
            .setMethodDescriptor(getApiVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateApiVersionRequest, ApiVersion> createApiVersionTransportSettings =
        HttpJsonCallSettings.<CreateApiVersionRequest, ApiVersion>newBuilder()
            .setMethodDescriptor(createApiVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateApiVersionRequest, ApiVersion> updateApiVersionTransportSettings =
        HttpJsonCallSettings.<UpdateApiVersionRequest, ApiVersion>newBuilder()
            .setMethodDescriptor(updateApiVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteApiVersionRequest, Empty> deleteApiVersionTransportSettings =
        HttpJsonCallSettings.<DeleteApiVersionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteApiVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListApiSpecsRequest, ListApiSpecsResponse> listApiSpecsTransportSettings =
        HttpJsonCallSettings.<ListApiSpecsRequest, ListApiSpecsResponse>newBuilder()
            .setMethodDescriptor(listApiSpecsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetApiSpecRequest, ApiSpec> getApiSpecTransportSettings =
        HttpJsonCallSettings.<GetApiSpecRequest, ApiSpec>newBuilder()
            .setMethodDescriptor(getApiSpecMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetApiSpecContentsRequest, HttpBody> getApiSpecContentsTransportSettings =
        HttpJsonCallSettings.<GetApiSpecContentsRequest, HttpBody>newBuilder()
            .setMethodDescriptor(getApiSpecContentsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateApiSpecRequest, ApiSpec> createApiSpecTransportSettings =
        HttpJsonCallSettings.<CreateApiSpecRequest, ApiSpec>newBuilder()
            .setMethodDescriptor(createApiSpecMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateApiSpecRequest, ApiSpec> updateApiSpecTransportSettings =
        HttpJsonCallSettings.<UpdateApiSpecRequest, ApiSpec>newBuilder()
            .setMethodDescriptor(updateApiSpecMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteApiSpecRequest, Empty> deleteApiSpecTransportSettings =
        HttpJsonCallSettings.<DeleteApiSpecRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteApiSpecMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TagApiSpecRevisionRequest, ApiSpec> tagApiSpecRevisionTransportSettings =
        HttpJsonCallSettings.<TagApiSpecRevisionRequest, ApiSpec>newBuilder()
            .setMethodDescriptor(tagApiSpecRevisionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse>
        listApiSpecRevisionsTransportSettings =
            HttpJsonCallSettings
                .<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse>newBuilder()
                .setMethodDescriptor(listApiSpecRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RollbackApiSpecRequest, ApiSpec> rollbackApiSpecTransportSettings =
        HttpJsonCallSettings.<RollbackApiSpecRequest, ApiSpec>newBuilder()
            .setMethodDescriptor(rollbackApiSpecMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteApiSpecRevisionRequest, ApiSpec>
        deleteApiSpecRevisionTransportSettings =
            HttpJsonCallSettings.<DeleteApiSpecRevisionRequest, ApiSpec>newBuilder()
                .setMethodDescriptor(deleteApiSpecRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListApiDeploymentsRequest, ListApiDeploymentsResponse>
        listApiDeploymentsTransportSettings =
            HttpJsonCallSettings.<ListApiDeploymentsRequest, ListApiDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listApiDeploymentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetApiDeploymentRequest, ApiDeployment> getApiDeploymentTransportSettings =
        HttpJsonCallSettings.<GetApiDeploymentRequest, ApiDeployment>newBuilder()
            .setMethodDescriptor(getApiDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateApiDeploymentRequest, ApiDeployment>
        createApiDeploymentTransportSettings =
            HttpJsonCallSettings.<CreateApiDeploymentRequest, ApiDeployment>newBuilder()
                .setMethodDescriptor(createApiDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateApiDeploymentRequest, ApiDeployment>
        updateApiDeploymentTransportSettings =
            HttpJsonCallSettings.<UpdateApiDeploymentRequest, ApiDeployment>newBuilder()
                .setMethodDescriptor(updateApiDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteApiDeploymentRequest, Empty> deleteApiDeploymentTransportSettings =
        HttpJsonCallSettings.<DeleteApiDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteApiDeploymentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TagApiDeploymentRevisionRequest, ApiDeployment>
        tagApiDeploymentRevisionTransportSettings =
            HttpJsonCallSettings.<TagApiDeploymentRevisionRequest, ApiDeployment>newBuilder()
                .setMethodDescriptor(tagApiDeploymentRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>
        listApiDeploymentRevisionsTransportSettings =
            HttpJsonCallSettings
                .<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>newBuilder()
                .setMethodDescriptor(listApiDeploymentRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RollbackApiDeploymentRequest, ApiDeployment>
        rollbackApiDeploymentTransportSettings =
            HttpJsonCallSettings.<RollbackApiDeploymentRequest, ApiDeployment>newBuilder()
                .setMethodDescriptor(rollbackApiDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteApiDeploymentRevisionRequest, ApiDeployment>
        deleteApiDeploymentRevisionTransportSettings =
            HttpJsonCallSettings.<DeleteApiDeploymentRevisionRequest, ApiDeployment>newBuilder()
                .setMethodDescriptor(deleteApiDeploymentRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListArtifactsRequest, ListArtifactsResponse>
        listArtifactsTransportSettings =
            HttpJsonCallSettings.<ListArtifactsRequest, ListArtifactsResponse>newBuilder()
                .setMethodDescriptor(listArtifactsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetArtifactRequest, Artifact> getArtifactTransportSettings =
        HttpJsonCallSettings.<GetArtifactRequest, Artifact>newBuilder()
            .setMethodDescriptor(getArtifactMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetArtifactContentsRequest, HttpBody>
        getArtifactContentsTransportSettings =
            HttpJsonCallSettings.<GetArtifactContentsRequest, HttpBody>newBuilder()
                .setMethodDescriptor(getArtifactContentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateArtifactRequest, Artifact> createArtifactTransportSettings =
        HttpJsonCallSettings.<CreateArtifactRequest, Artifact>newBuilder()
            .setMethodDescriptor(createArtifactMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ReplaceArtifactRequest, Artifact> replaceArtifactTransportSettings =
        HttpJsonCallSettings.<ReplaceArtifactRequest, Artifact>newBuilder()
            .setMethodDescriptor(replaceArtifactMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteArtifactRequest, Empty> deleteArtifactTransportSettings =
        HttpJsonCallSettings.<DeleteArtifactRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteArtifactMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listApisCallable =
        callableFactory.createUnaryCallable(
            listApisTransportSettings, settings.listApisSettings(), clientContext);
    this.listApisPagedCallable =
        callableFactory.createPagedCallable(
            listApisTransportSettings, settings.listApisSettings(), clientContext);
    this.getApiCallable =
        callableFactory.createUnaryCallable(
            getApiTransportSettings, settings.getApiSettings(), clientContext);
    this.createApiCallable =
        callableFactory.createUnaryCallable(
            createApiTransportSettings, settings.createApiSettings(), clientContext);
    this.updateApiCallable =
        callableFactory.createUnaryCallable(
            updateApiTransportSettings, settings.updateApiSettings(), clientContext);
    this.deleteApiCallable =
        callableFactory.createUnaryCallable(
            deleteApiTransportSettings, settings.deleteApiSettings(), clientContext);
    this.listApiVersionsCallable =
        callableFactory.createUnaryCallable(
            listApiVersionsTransportSettings, settings.listApiVersionsSettings(), clientContext);
    this.listApiVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listApiVersionsTransportSettings, settings.listApiVersionsSettings(), clientContext);
    this.getApiVersionCallable =
        callableFactory.createUnaryCallable(
            getApiVersionTransportSettings, settings.getApiVersionSettings(), clientContext);
    this.createApiVersionCallable =
        callableFactory.createUnaryCallable(
            createApiVersionTransportSettings, settings.createApiVersionSettings(), clientContext);
    this.updateApiVersionCallable =
        callableFactory.createUnaryCallable(
            updateApiVersionTransportSettings, settings.updateApiVersionSettings(), clientContext);
    this.deleteApiVersionCallable =
        callableFactory.createUnaryCallable(
            deleteApiVersionTransportSettings, settings.deleteApiVersionSettings(), clientContext);
    this.listApiSpecsCallable =
        callableFactory.createUnaryCallable(
            listApiSpecsTransportSettings, settings.listApiSpecsSettings(), clientContext);
    this.listApiSpecsPagedCallable =
        callableFactory.createPagedCallable(
            listApiSpecsTransportSettings, settings.listApiSpecsSettings(), clientContext);
    this.getApiSpecCallable =
        callableFactory.createUnaryCallable(
            getApiSpecTransportSettings, settings.getApiSpecSettings(), clientContext);
    this.getApiSpecContentsCallable =
        callableFactory.createUnaryCallable(
            getApiSpecContentsTransportSettings,
            settings.getApiSpecContentsSettings(),
            clientContext);
    this.createApiSpecCallable =
        callableFactory.createUnaryCallable(
            createApiSpecTransportSettings, settings.createApiSpecSettings(), clientContext);
    this.updateApiSpecCallable =
        callableFactory.createUnaryCallable(
            updateApiSpecTransportSettings, settings.updateApiSpecSettings(), clientContext);
    this.deleteApiSpecCallable =
        callableFactory.createUnaryCallable(
            deleteApiSpecTransportSettings, settings.deleteApiSpecSettings(), clientContext);
    this.tagApiSpecRevisionCallable =
        callableFactory.createUnaryCallable(
            tagApiSpecRevisionTransportSettings,
            settings.tagApiSpecRevisionSettings(),
            clientContext);
    this.listApiSpecRevisionsCallable =
        callableFactory.createUnaryCallable(
            listApiSpecRevisionsTransportSettings,
            settings.listApiSpecRevisionsSettings(),
            clientContext);
    this.listApiSpecRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listApiSpecRevisionsTransportSettings,
            settings.listApiSpecRevisionsSettings(),
            clientContext);
    this.rollbackApiSpecCallable =
        callableFactory.createUnaryCallable(
            rollbackApiSpecTransportSettings, settings.rollbackApiSpecSettings(), clientContext);
    this.deleteApiSpecRevisionCallable =
        callableFactory.createUnaryCallable(
            deleteApiSpecRevisionTransportSettings,
            settings.deleteApiSpecRevisionSettings(),
            clientContext);
    this.listApiDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listApiDeploymentsTransportSettings,
            settings.listApiDeploymentsSettings(),
            clientContext);
    this.listApiDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listApiDeploymentsTransportSettings,
            settings.listApiDeploymentsSettings(),
            clientContext);
    this.getApiDeploymentCallable =
        callableFactory.createUnaryCallable(
            getApiDeploymentTransportSettings, settings.getApiDeploymentSettings(), clientContext);
    this.createApiDeploymentCallable =
        callableFactory.createUnaryCallable(
            createApiDeploymentTransportSettings,
            settings.createApiDeploymentSettings(),
            clientContext);
    this.updateApiDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateApiDeploymentTransportSettings,
            settings.updateApiDeploymentSettings(),
            clientContext);
    this.deleteApiDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteApiDeploymentTransportSettings,
            settings.deleteApiDeploymentSettings(),
            clientContext);
    this.tagApiDeploymentRevisionCallable =
        callableFactory.createUnaryCallable(
            tagApiDeploymentRevisionTransportSettings,
            settings.tagApiDeploymentRevisionSettings(),
            clientContext);
    this.listApiDeploymentRevisionsCallable =
        callableFactory.createUnaryCallable(
            listApiDeploymentRevisionsTransportSettings,
            settings.listApiDeploymentRevisionsSettings(),
            clientContext);
    this.listApiDeploymentRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listApiDeploymentRevisionsTransportSettings,
            settings.listApiDeploymentRevisionsSettings(),
            clientContext);
    this.rollbackApiDeploymentCallable =
        callableFactory.createUnaryCallable(
            rollbackApiDeploymentTransportSettings,
            settings.rollbackApiDeploymentSettings(),
            clientContext);
    this.deleteApiDeploymentRevisionCallable =
        callableFactory.createUnaryCallable(
            deleteApiDeploymentRevisionTransportSettings,
            settings.deleteApiDeploymentRevisionSettings(),
            clientContext);
    this.listArtifactsCallable =
        callableFactory.createUnaryCallable(
            listArtifactsTransportSettings, settings.listArtifactsSettings(), clientContext);
    this.listArtifactsPagedCallable =
        callableFactory.createPagedCallable(
            listArtifactsTransportSettings, settings.listArtifactsSettings(), clientContext);
    this.getArtifactCallable =
        callableFactory.createUnaryCallable(
            getArtifactTransportSettings, settings.getArtifactSettings(), clientContext);
    this.getArtifactContentsCallable =
        callableFactory.createUnaryCallable(
            getArtifactContentsTransportSettings,
            settings.getArtifactContentsSettings(),
            clientContext);
    this.createArtifactCallable =
        callableFactory.createUnaryCallable(
            createArtifactTransportSettings, settings.createArtifactSettings(), clientContext);
    this.replaceArtifactCallable =
        callableFactory.createUnaryCallable(
            replaceArtifactTransportSettings, settings.replaceArtifactSettings(), clientContext);
    this.deleteArtifactCallable =
        callableFactory.createUnaryCallable(
            deleteArtifactTransportSettings, settings.deleteArtifactSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
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
    methodDescriptors.add(listApisMethodDescriptor);
    methodDescriptors.add(getApiMethodDescriptor);
    methodDescriptors.add(createApiMethodDescriptor);
    methodDescriptors.add(updateApiMethodDescriptor);
    methodDescriptors.add(deleteApiMethodDescriptor);
    methodDescriptors.add(listApiVersionsMethodDescriptor);
    methodDescriptors.add(getApiVersionMethodDescriptor);
    methodDescriptors.add(createApiVersionMethodDescriptor);
    methodDescriptors.add(updateApiVersionMethodDescriptor);
    methodDescriptors.add(deleteApiVersionMethodDescriptor);
    methodDescriptors.add(listApiSpecsMethodDescriptor);
    methodDescriptors.add(getApiSpecMethodDescriptor);
    methodDescriptors.add(getApiSpecContentsMethodDescriptor);
    methodDescriptors.add(createApiSpecMethodDescriptor);
    methodDescriptors.add(updateApiSpecMethodDescriptor);
    methodDescriptors.add(deleteApiSpecMethodDescriptor);
    methodDescriptors.add(tagApiSpecRevisionMethodDescriptor);
    methodDescriptors.add(listApiSpecRevisionsMethodDescriptor);
    methodDescriptors.add(rollbackApiSpecMethodDescriptor);
    methodDescriptors.add(deleteApiSpecRevisionMethodDescriptor);
    methodDescriptors.add(listApiDeploymentsMethodDescriptor);
    methodDescriptors.add(getApiDeploymentMethodDescriptor);
    methodDescriptors.add(createApiDeploymentMethodDescriptor);
    methodDescriptors.add(updateApiDeploymentMethodDescriptor);
    methodDescriptors.add(deleteApiDeploymentMethodDescriptor);
    methodDescriptors.add(tagApiDeploymentRevisionMethodDescriptor);
    methodDescriptors.add(listApiDeploymentRevisionsMethodDescriptor);
    methodDescriptors.add(rollbackApiDeploymentMethodDescriptor);
    methodDescriptors.add(deleteApiDeploymentRevisionMethodDescriptor);
    methodDescriptors.add(listArtifactsMethodDescriptor);
    methodDescriptors.add(getArtifactMethodDescriptor);
    methodDescriptors.add(getArtifactContentsMethodDescriptor);
    methodDescriptors.add(createArtifactMethodDescriptor);
    methodDescriptors.add(replaceArtifactMethodDescriptor);
    methodDescriptors.add(deleteArtifactMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
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
  public UnaryCallable<GetApiRequest, Api> getApiCallable() {
    return getApiCallable;
  }

  @Override
  public UnaryCallable<CreateApiRequest, Api> createApiCallable() {
    return createApiCallable;
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
  public UnaryCallable<ListApiVersionsRequest, ListApiVersionsResponse> listApiVersionsCallable() {
    return listApiVersionsCallable;
  }

  @Override
  public UnaryCallable<ListApiVersionsRequest, ListApiVersionsPagedResponse>
      listApiVersionsPagedCallable() {
    return listApiVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetApiVersionRequest, ApiVersion> getApiVersionCallable() {
    return getApiVersionCallable;
  }

  @Override
  public UnaryCallable<CreateApiVersionRequest, ApiVersion> createApiVersionCallable() {
    return createApiVersionCallable;
  }

  @Override
  public UnaryCallable<UpdateApiVersionRequest, ApiVersion> updateApiVersionCallable() {
    return updateApiVersionCallable;
  }

  @Override
  public UnaryCallable<DeleteApiVersionRequest, Empty> deleteApiVersionCallable() {
    return deleteApiVersionCallable;
  }

  @Override
  public UnaryCallable<ListApiSpecsRequest, ListApiSpecsResponse> listApiSpecsCallable() {
    return listApiSpecsCallable;
  }

  @Override
  public UnaryCallable<ListApiSpecsRequest, ListApiSpecsPagedResponse> listApiSpecsPagedCallable() {
    return listApiSpecsPagedCallable;
  }

  @Override
  public UnaryCallable<GetApiSpecRequest, ApiSpec> getApiSpecCallable() {
    return getApiSpecCallable;
  }

  @Override
  public UnaryCallable<GetApiSpecContentsRequest, HttpBody> getApiSpecContentsCallable() {
    return getApiSpecContentsCallable;
  }

  @Override
  public UnaryCallable<CreateApiSpecRequest, ApiSpec> createApiSpecCallable() {
    return createApiSpecCallable;
  }

  @Override
  public UnaryCallable<UpdateApiSpecRequest, ApiSpec> updateApiSpecCallable() {
    return updateApiSpecCallable;
  }

  @Override
  public UnaryCallable<DeleteApiSpecRequest, Empty> deleteApiSpecCallable() {
    return deleteApiSpecCallable;
  }

  @Override
  public UnaryCallable<TagApiSpecRevisionRequest, ApiSpec> tagApiSpecRevisionCallable() {
    return tagApiSpecRevisionCallable;
  }

  @Override
  public UnaryCallable<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse>
      listApiSpecRevisionsCallable() {
    return listApiSpecRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListApiSpecRevisionsRequest, ListApiSpecRevisionsPagedResponse>
      listApiSpecRevisionsPagedCallable() {
    return listApiSpecRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<RollbackApiSpecRequest, ApiSpec> rollbackApiSpecCallable() {
    return rollbackApiSpecCallable;
  }

  @Override
  public UnaryCallable<DeleteApiSpecRevisionRequest, ApiSpec> deleteApiSpecRevisionCallable() {
    return deleteApiSpecRevisionCallable;
  }

  @Override
  public UnaryCallable<ListApiDeploymentsRequest, ListApiDeploymentsResponse>
      listApiDeploymentsCallable() {
    return listApiDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListApiDeploymentsRequest, ListApiDeploymentsPagedResponse>
      listApiDeploymentsPagedCallable() {
    return listApiDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetApiDeploymentRequest, ApiDeployment> getApiDeploymentCallable() {
    return getApiDeploymentCallable;
  }

  @Override
  public UnaryCallable<CreateApiDeploymentRequest, ApiDeployment> createApiDeploymentCallable() {
    return createApiDeploymentCallable;
  }

  @Override
  public UnaryCallable<UpdateApiDeploymentRequest, ApiDeployment> updateApiDeploymentCallable() {
    return updateApiDeploymentCallable;
  }

  @Override
  public UnaryCallable<DeleteApiDeploymentRequest, Empty> deleteApiDeploymentCallable() {
    return deleteApiDeploymentCallable;
  }

  @Override
  public UnaryCallable<TagApiDeploymentRevisionRequest, ApiDeployment>
      tagApiDeploymentRevisionCallable() {
    return tagApiDeploymentRevisionCallable;
  }

  @Override
  public UnaryCallable<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>
      listApiDeploymentRevisionsCallable() {
    return listApiDeploymentRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsPagedResponse>
      listApiDeploymentRevisionsPagedCallable() {
    return listApiDeploymentRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<RollbackApiDeploymentRequest, ApiDeployment>
      rollbackApiDeploymentCallable() {
    return rollbackApiDeploymentCallable;
  }

  @Override
  public UnaryCallable<DeleteApiDeploymentRevisionRequest, ApiDeployment>
      deleteApiDeploymentRevisionCallable() {
    return deleteApiDeploymentRevisionCallable;
  }

  @Override
  public UnaryCallable<ListArtifactsRequest, ListArtifactsResponse> listArtifactsCallable() {
    return listArtifactsCallable;
  }

  @Override
  public UnaryCallable<ListArtifactsRequest, ListArtifactsPagedResponse>
      listArtifactsPagedCallable() {
    return listArtifactsPagedCallable;
  }

  @Override
  public UnaryCallable<GetArtifactRequest, Artifact> getArtifactCallable() {
    return getArtifactCallable;
  }

  @Override
  public UnaryCallable<GetArtifactContentsRequest, HttpBody> getArtifactContentsCallable() {
    return getArtifactContentsCallable;
  }

  @Override
  public UnaryCallable<CreateArtifactRequest, Artifact> createArtifactCallable() {
    return createArtifactCallable;
  }

  @Override
  public UnaryCallable<ReplaceArtifactRequest, Artifact> replaceArtifactCallable() {
    return replaceArtifactCallable;
  }

  @Override
  public UnaryCallable<DeleteArtifactRequest, Empty> deleteArtifactCallable() {
    return deleteArtifactCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
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
