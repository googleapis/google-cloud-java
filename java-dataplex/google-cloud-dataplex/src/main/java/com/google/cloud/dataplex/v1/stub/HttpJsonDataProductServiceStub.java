/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListDataAssetsPagedResponse;
import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListDataProductsPagedResponse;
import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListLocationsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.CreateDataAssetRequest;
import com.google.cloud.dataplex.v1.CreateDataProductRequest;
import com.google.cloud.dataplex.v1.DataAsset;
import com.google.cloud.dataplex.v1.DataProduct;
import com.google.cloud.dataplex.v1.DeleteDataAssetRequest;
import com.google.cloud.dataplex.v1.DeleteDataProductRequest;
import com.google.cloud.dataplex.v1.GetDataAssetRequest;
import com.google.cloud.dataplex.v1.GetDataProductRequest;
import com.google.cloud.dataplex.v1.ListDataAssetsRequest;
import com.google.cloud.dataplex.v1.ListDataAssetsResponse;
import com.google.cloud.dataplex.v1.ListDataProductsRequest;
import com.google.cloud.dataplex.v1.ListDataProductsResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateDataAssetRequest;
import com.google.cloud.dataplex.v1.UpdateDataProductRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the DataProductService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDataProductServiceStub extends DataProductServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(DataAsset.getDescriptor())
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(DataProduct.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateDataProductRequest, Operation>
      createDataProductMethodDescriptor =
          ApiMethodDescriptor.<CreateDataProductRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/CreateDataProduct")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataProductRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dataProducts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "dataProductId", request.getDataProductId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataProduct", request.getDataProduct(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDataProductRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDataProductRequest, Operation>
      deleteDataProductMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataProductRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/DeleteDataProduct")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataProductRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataProducts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                  (DeleteDataProductRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetDataProductRequest, DataProduct>
      getDataProductMethodDescriptor =
          ApiMethodDescriptor.<GetDataProductRequest, DataProduct>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/GetDataProduct")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataProductRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataProducts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataProduct>newBuilder()
                      .setDefaultInstance(DataProduct.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDataProductsRequest, ListDataProductsResponse>
      listDataProductsMethodDescriptor =
          ApiMethodDescriptor.<ListDataProductsRequest, ListDataProductsResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/ListDataProducts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataProductsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dataProducts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDataProductsResponse>newBuilder()
                      .setDefaultInstance(ListDataProductsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDataProductRequest, Operation>
      updateDataProductMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataProductRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/UpdateDataProduct")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataProductRequest>newBuilder()
                      .setPath(
                          "/v1/{dataProduct.name=projects/*/locations/*/dataProducts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataProduct.name", request.getDataProduct().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataProductRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataProduct", request.getDataProduct(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDataProductRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateDataAssetRequest, Operation>
      createDataAssetMethodDescriptor =
          ApiMethodDescriptor.<CreateDataAssetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/CreateDataAsset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataAssetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/dataProducts/*}/dataAssets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "dataAssetId", request.getDataAssetId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataAsset", request.getDataAsset(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDataAssetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateDataAssetRequest, Operation>
      updateDataAssetMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataAssetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/UpdateDataAsset")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataAssetRequest>newBuilder()
                      .setPath(
                          "/v1/{dataAsset.name=projects/*/locations/*/dataProducts/*/dataAssets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataAsset.name", request.getDataAsset().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataAsset", request.getDataAsset(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateDataAssetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDataAssetRequest, Operation>
      deleteDataAssetMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataAssetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/DeleteDataAsset")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataAssetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataProducts/*/dataAssets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                  (DeleteDataAssetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetDataAssetRequest, DataAsset>
      getDataAssetMethodDescriptor =
          ApiMethodDescriptor.<GetDataAssetRequest, DataAsset>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/GetDataAsset")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataAssetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataProducts/*/dataAssets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataAssetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataAsset>newBuilder()
                      .setDefaultInstance(DataAsset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDataAssetsRequest, ListDataAssetsResponse>
      listDataAssetsMethodDescriptor =
          ApiMethodDescriptor.<ListDataAssetsRequest, ListDataAssetsResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/ListDataAssets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataAssetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/dataProducts/*}/dataAssets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataAssetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDataAssetsResponse>newBuilder()
                      .setDefaultInstance(ListDataAssetsResponse.getDefaultInstance())
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/lakes/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/lakes/*/zones/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/lakes/*/zones/*/assets/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/lakes/*/tasks/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/lakes/*/environments/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/dataScans/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/dataTaxonomies/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/dataTaxonomies/*/attributes/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/dataAttributeBindings/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/entryTypes/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/entryLinkTypes/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/aspectTypes/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/entryGroups/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/governanceRules/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/glossaries/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/glossaries/*/categories/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/glossaries/*/terms/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/changeRequests/*}:setIamPolicy",
                          "/v1/{resource=organizations/*/locations/*/encryptionConfigs/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/dataProducts/*}:setIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
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
                          "/v1/{resource=projects/*/locations/*/lakes/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/lakes/*/zones/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/lakes/*/zones/*/assets/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/lakes/*/tasks/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/lakes/*/environments/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/dataScans/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/dataTaxonomies/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/dataTaxonomies/*/attributes/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/dataAttributeBindings/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/entryTypes/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/entryLinkTypes/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/aspectTypes/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/entryGroups/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/governanceRules/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/glossaries/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/glossaries/*/categories/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/glossaries/*/terms/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/changeRequests/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/dataProducts/*}:getIamPolicy",
                          "/v1/{resource=organizations/*/locations/*/encryptionConfigs/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                          "/v1/{resource=projects/*/locations/*/lakes/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/lakes/*/zones/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/lakes/*/zones/*/assets/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/lakes/*/tasks/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/lakes/*/environments/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/dataScans/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/dataTaxonomies/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/dataTaxonomies/*/attributes/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/dataAttributeBindings/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/entryTypes/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/entryLinkTypes/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/aspectTypes/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/entryGroups/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/governanceRules/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/glossaries/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/glossaries/*/categories/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/glossaries/*/terms/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/changeRequests/*}:testIamPermissions",
                          "/v1/{resource=organizations/*/locations/*/encryptionConfigs/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/dataProducts/*}:testIamPermissions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateDataProductRequest, Operation> createDataProductCallable;
  private final OperationCallable<CreateDataProductRequest, DataProduct, OperationMetadata>
      createDataProductOperationCallable;
  private final UnaryCallable<DeleteDataProductRequest, Operation> deleteDataProductCallable;
  private final OperationCallable<DeleteDataProductRequest, Empty, OperationMetadata>
      deleteDataProductOperationCallable;
  private final UnaryCallable<GetDataProductRequest, DataProduct> getDataProductCallable;
  private final UnaryCallable<ListDataProductsRequest, ListDataProductsResponse>
      listDataProductsCallable;
  private final UnaryCallable<ListDataProductsRequest, ListDataProductsPagedResponse>
      listDataProductsPagedCallable;
  private final UnaryCallable<UpdateDataProductRequest, Operation> updateDataProductCallable;
  private final OperationCallable<UpdateDataProductRequest, DataProduct, OperationMetadata>
      updateDataProductOperationCallable;
  private final UnaryCallable<CreateDataAssetRequest, Operation> createDataAssetCallable;
  private final OperationCallable<CreateDataAssetRequest, DataAsset, OperationMetadata>
      createDataAssetOperationCallable;
  private final UnaryCallable<UpdateDataAssetRequest, Operation> updateDataAssetCallable;
  private final OperationCallable<UpdateDataAssetRequest, DataAsset, OperationMetadata>
      updateDataAssetOperationCallable;
  private final UnaryCallable<DeleteDataAssetRequest, Operation> deleteDataAssetCallable;
  private final OperationCallable<DeleteDataAssetRequest, Empty, OperationMetadata>
      deleteDataAssetOperationCallable;
  private final UnaryCallable<GetDataAssetRequest, DataAsset> getDataAssetCallable;
  private final UnaryCallable<ListDataAssetsRequest, ListDataAssetsResponse> listDataAssetsCallable;
  private final UnaryCallable<ListDataAssetsRequest, ListDataAssetsPagedResponse>
      listDataAssetsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataProductServiceStub create(DataProductServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDataProductServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataProductServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataProductServiceStub(
        DataProductServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataProductServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataProductServiceStub(
        DataProductServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataProductServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataProductServiceStub(
      DataProductServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDataProductServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataProductServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataProductServiceStub(
      DataProductServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1/{name=organizations/*/locations/*/operations/*}:cancel")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setDelete("/v1/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=organizations/*/locations/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<CreateDataProductRequest, Operation> createDataProductTransportSettings =
        HttpJsonCallSettings.<CreateDataProductRequest, Operation>newBuilder()
            .setMethodDescriptor(createDataProductMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<DeleteDataProductRequest, Operation> deleteDataProductTransportSettings =
        HttpJsonCallSettings.<DeleteDataProductRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDataProductMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetDataProductRequest, DataProduct> getDataProductTransportSettings =
        HttpJsonCallSettings.<GetDataProductRequest, DataProduct>newBuilder()
            .setMethodDescriptor(getDataProductMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListDataProductsRequest, ListDataProductsResponse>
        listDataProductsTransportSettings =
            HttpJsonCallSettings.<ListDataProductsRequest, ListDataProductsResponse>newBuilder()
                .setMethodDescriptor(listDataProductsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateDataProductRequest, Operation> updateDataProductTransportSettings =
        HttpJsonCallSettings.<UpdateDataProductRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDataProductMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_product.name", String.valueOf(request.getDataProduct().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateDataAssetRequest, Operation> createDataAssetTransportSettings =
        HttpJsonCallSettings.<CreateDataAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(createDataAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateDataAssetRequest, Operation> updateDataAssetTransportSettings =
        HttpJsonCallSettings.<UpdateDataAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDataAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("data_asset.name", String.valueOf(request.getDataAsset().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDataAssetRequest, Operation> deleteDataAssetTransportSettings =
        HttpJsonCallSettings.<DeleteDataAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDataAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetDataAssetRequest, DataAsset> getDataAssetTransportSettings =
        HttpJsonCallSettings.<GetDataAssetRequest, DataAsset>newBuilder()
            .setMethodDescriptor(getDataAssetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListDataAssetsRequest, ListDataAssetsResponse>
        listDataAssetsTransportSettings =
            HttpJsonCallSettings.<ListDataAssetsRequest, ListDataAssetsResponse>newBuilder()
                .setMethodDescriptor(listDataAssetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
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
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getResource())
                .build();

    this.createDataProductCallable =
        callableFactory.createUnaryCallable(
            createDataProductTransportSettings,
            settings.createDataProductSettings(),
            clientContext);
    this.createDataProductOperationCallable =
        callableFactory.createOperationCallable(
            createDataProductTransportSettings,
            settings.createDataProductOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDataProductCallable =
        callableFactory.createUnaryCallable(
            deleteDataProductTransportSettings,
            settings.deleteDataProductSettings(),
            clientContext);
    this.deleteDataProductOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataProductTransportSettings,
            settings.deleteDataProductOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getDataProductCallable =
        callableFactory.createUnaryCallable(
            getDataProductTransportSettings, settings.getDataProductSettings(), clientContext);
    this.listDataProductsCallable =
        callableFactory.createUnaryCallable(
            listDataProductsTransportSettings, settings.listDataProductsSettings(), clientContext);
    this.listDataProductsPagedCallable =
        callableFactory.createPagedCallable(
            listDataProductsTransportSettings, settings.listDataProductsSettings(), clientContext);
    this.updateDataProductCallable =
        callableFactory.createUnaryCallable(
            updateDataProductTransportSettings,
            settings.updateDataProductSettings(),
            clientContext);
    this.updateDataProductOperationCallable =
        callableFactory.createOperationCallable(
            updateDataProductTransportSettings,
            settings.updateDataProductOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createDataAssetCallable =
        callableFactory.createUnaryCallable(
            createDataAssetTransportSettings, settings.createDataAssetSettings(), clientContext);
    this.createDataAssetOperationCallable =
        callableFactory.createOperationCallable(
            createDataAssetTransportSettings,
            settings.createDataAssetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateDataAssetCallable =
        callableFactory.createUnaryCallable(
            updateDataAssetTransportSettings, settings.updateDataAssetSettings(), clientContext);
    this.updateDataAssetOperationCallable =
        callableFactory.createOperationCallable(
            updateDataAssetTransportSettings,
            settings.updateDataAssetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDataAssetCallable =
        callableFactory.createUnaryCallable(
            deleteDataAssetTransportSettings, settings.deleteDataAssetSettings(), clientContext);
    this.deleteDataAssetOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataAssetTransportSettings,
            settings.deleteDataAssetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getDataAssetCallable =
        callableFactory.createUnaryCallable(
            getDataAssetTransportSettings, settings.getDataAssetSettings(), clientContext);
    this.listDataAssetsCallable =
        callableFactory.createUnaryCallable(
            listDataAssetsTransportSettings, settings.listDataAssetsSettings(), clientContext);
    this.listDataAssetsPagedCallable =
        callableFactory.createPagedCallable(
            listDataAssetsTransportSettings, settings.listDataAssetsSettings(), clientContext);
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
    methodDescriptors.add(createDataProductMethodDescriptor);
    methodDescriptors.add(deleteDataProductMethodDescriptor);
    methodDescriptors.add(getDataProductMethodDescriptor);
    methodDescriptors.add(listDataProductsMethodDescriptor);
    methodDescriptors.add(updateDataProductMethodDescriptor);
    methodDescriptors.add(createDataAssetMethodDescriptor);
    methodDescriptors.add(updateDataAssetMethodDescriptor);
    methodDescriptors.add(deleteDataAssetMethodDescriptor);
    methodDescriptors.add(getDataAssetMethodDescriptor);
    methodDescriptors.add(listDataAssetsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateDataProductRequest, Operation> createDataProductCallable() {
    return createDataProductCallable;
  }

  @Override
  public OperationCallable<CreateDataProductRequest, DataProduct, OperationMetadata>
      createDataProductOperationCallable() {
    return createDataProductOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDataProductRequest, Operation> deleteDataProductCallable() {
    return deleteDataProductCallable;
  }

  @Override
  public OperationCallable<DeleteDataProductRequest, Empty, OperationMetadata>
      deleteDataProductOperationCallable() {
    return deleteDataProductOperationCallable;
  }

  @Override
  public UnaryCallable<GetDataProductRequest, DataProduct> getDataProductCallable() {
    return getDataProductCallable;
  }

  @Override
  public UnaryCallable<ListDataProductsRequest, ListDataProductsResponse>
      listDataProductsCallable() {
    return listDataProductsCallable;
  }

  @Override
  public UnaryCallable<ListDataProductsRequest, ListDataProductsPagedResponse>
      listDataProductsPagedCallable() {
    return listDataProductsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateDataProductRequest, Operation> updateDataProductCallable() {
    return updateDataProductCallable;
  }

  @Override
  public OperationCallable<UpdateDataProductRequest, DataProduct, OperationMetadata>
      updateDataProductOperationCallable() {
    return updateDataProductOperationCallable;
  }

  @Override
  public UnaryCallable<CreateDataAssetRequest, Operation> createDataAssetCallable() {
    return createDataAssetCallable;
  }

  @Override
  public OperationCallable<CreateDataAssetRequest, DataAsset, OperationMetadata>
      createDataAssetOperationCallable() {
    return createDataAssetOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataAssetRequest, Operation> updateDataAssetCallable() {
    return updateDataAssetCallable;
  }

  @Override
  public OperationCallable<UpdateDataAssetRequest, DataAsset, OperationMetadata>
      updateDataAssetOperationCallable() {
    return updateDataAssetOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDataAssetRequest, Operation> deleteDataAssetCallable() {
    return deleteDataAssetCallable;
  }

  @Override
  public OperationCallable<DeleteDataAssetRequest, Empty, OperationMetadata>
      deleteDataAssetOperationCallable() {
    return deleteDataAssetOperationCallable;
  }

  @Override
  public UnaryCallable<GetDataAssetRequest, DataAsset> getDataAssetCallable() {
    return getDataAssetCallable;
  }

  @Override
  public UnaryCallable<ListDataAssetsRequest, ListDataAssetsResponse> listDataAssetsCallable() {
    return listDataAssetsCallable;
  }

  @Override
  public UnaryCallable<ListDataAssetsRequest, ListDataAssetsPagedResponse>
      listDataAssetsPagedCallable() {
    return listDataAssetsPagedCallable;
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
