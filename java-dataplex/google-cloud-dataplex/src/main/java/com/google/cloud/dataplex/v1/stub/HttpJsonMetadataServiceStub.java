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

import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListEntitiesPagedResponse;
import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListPartitionsPagedResponse;

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
import com.google.cloud.dataplex.v1.CreateEntityRequest;
import com.google.cloud.dataplex.v1.CreatePartitionRequest;
import com.google.cloud.dataplex.v1.DeleteEntityRequest;
import com.google.cloud.dataplex.v1.DeletePartitionRequest;
import com.google.cloud.dataplex.v1.Entity;
import com.google.cloud.dataplex.v1.GetEntityRequest;
import com.google.cloud.dataplex.v1.GetPartitionRequest;
import com.google.cloud.dataplex.v1.ListEntitiesRequest;
import com.google.cloud.dataplex.v1.ListEntitiesResponse;
import com.google.cloud.dataplex.v1.ListPartitionsRequest;
import com.google.cloud.dataplex.v1.ListPartitionsResponse;
import com.google.cloud.dataplex.v1.Partition;
import com.google.cloud.dataplex.v1.UpdateEntityRequest;
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
 * REST stub implementation for the MetadataService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonMetadataServiceStub extends MetadataServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateEntityRequest, Entity>
      createEntityMethodDescriptor =
          ApiMethodDescriptor.<CreateEntityRequest, Entity>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.MetadataService/CreateEntity")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEntityRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/lakes/*/zones/*}/entities",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("entity", request.getEntity(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Entity>newBuilder()
                      .setDefaultInstance(Entity.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateEntityRequest, Entity>
      updateEntityMethodDescriptor =
          ApiMethodDescriptor.<UpdateEntityRequest, Entity>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.MetadataService/UpdateEntity")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEntityRequest>newBuilder()
                      .setPath(
                          "/v1/{entity.name=projects/*/locations/*/lakes/*/zones/*/entities/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEntityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "entity.name", request.getEntity().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEntityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("entity", request.getEntity(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Entity>newBuilder()
                      .setDefaultInstance(Entity.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteEntityRequest, Empty>
      deleteEntityMethodDescriptor =
          ApiMethodDescriptor.<DeleteEntityRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.MetadataService/DeleteEntity")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEntityRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/lakes/*/zones/*/entities/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEntityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEntityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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

  private static final ApiMethodDescriptor<GetEntityRequest, Entity> getEntityMethodDescriptor =
      ApiMethodDescriptor.<GetEntityRequest, Entity>newBuilder()
          .setFullMethodName("google.cloud.dataplex.v1.MetadataService/GetEntity")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetEntityRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/lakes/*/zones/*/entities/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetEntityRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetEntityRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "view", request.getViewValue());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Entity>newBuilder()
                  .setDefaultInstance(Entity.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListEntitiesRequest, ListEntitiesResponse>
      listEntitiesMethodDescriptor =
          ApiMethodDescriptor.<ListEntitiesRequest, ListEntitiesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.MetadataService/ListEntities")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEntitiesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/lakes/*/zones/*}/entities",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntitiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntitiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEntitiesResponse>newBuilder()
                      .setDefaultInstance(ListEntitiesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePartitionRequest, Partition>
      createPartitionMethodDescriptor =
          ApiMethodDescriptor.<CreatePartitionRequest, Partition>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.MetadataService/CreatePartition")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePartitionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/lakes/*/zones/*/entities/*}/partitions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePartitionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePartitionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("partition", request.getPartition(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Partition>newBuilder()
                      .setDefaultInstance(Partition.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePartitionRequest, Empty>
      deletePartitionMethodDescriptor =
          ApiMethodDescriptor.<DeletePartitionRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.MetadataService/DeletePartition")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePartitionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/lakes/*/zones/*/entities/*/partitions/**}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePartitionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePartitionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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

  private static final ApiMethodDescriptor<GetPartitionRequest, Partition>
      getPartitionMethodDescriptor =
          ApiMethodDescriptor.<GetPartitionRequest, Partition>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.MetadataService/GetPartition")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPartitionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/lakes/*/zones/*/entities/*/partitions/**}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPartitionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPartitionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Partition>newBuilder()
                      .setDefaultInstance(Partition.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPartitionsRequest, ListPartitionsResponse>
      listPartitionsMethodDescriptor =
          ApiMethodDescriptor.<ListPartitionsRequest, ListPartitionsResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.MetadataService/ListPartitions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPartitionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/lakes/*/zones/*/entities/*}/partitions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPartitionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPartitionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListPartitionsResponse>newBuilder()
                      .setDefaultInstance(ListPartitionsResponse.getDefaultInstance())
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

  private final UnaryCallable<CreateEntityRequest, Entity> createEntityCallable;
  private final UnaryCallable<UpdateEntityRequest, Entity> updateEntityCallable;
  private final UnaryCallable<DeleteEntityRequest, Empty> deleteEntityCallable;
  private final UnaryCallable<GetEntityRequest, Entity> getEntityCallable;
  private final UnaryCallable<ListEntitiesRequest, ListEntitiesResponse> listEntitiesCallable;
  private final UnaryCallable<ListEntitiesRequest, ListEntitiesPagedResponse>
      listEntitiesPagedCallable;
  private final UnaryCallable<CreatePartitionRequest, Partition> createPartitionCallable;
  private final UnaryCallable<DeletePartitionRequest, Empty> deletePartitionCallable;
  private final UnaryCallable<GetPartitionRequest, Partition> getPartitionCallable;
  private final UnaryCallable<ListPartitionsRequest, ListPartitionsResponse> listPartitionsCallable;
  private final UnaryCallable<ListPartitionsRequest, ListPartitionsPagedResponse>
      listPartitionsPagedCallable;
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

  public static final HttpJsonMetadataServiceStub create(MetadataServiceStubSettings settings)
      throws IOException {
    return new HttpJsonMetadataServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMetadataServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMetadataServiceStub(
        MetadataServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonMetadataServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMetadataServiceStub(
        MetadataServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMetadataServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMetadataServiceStub(
      MetadataServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonMetadataServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMetadataServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMetadataServiceStub(
      MetadataServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateEntityRequest, Entity> createEntityTransportSettings =
        HttpJsonCallSettings.<CreateEntityRequest, Entity>newBuilder()
            .setMethodDescriptor(createEntityMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateEntityRequest, Entity> updateEntityTransportSettings =
        HttpJsonCallSettings.<UpdateEntityRequest, Entity>newBuilder()
            .setMethodDescriptor(updateEntityMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("entity.name", String.valueOf(request.getEntity().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteEntityRequest, Empty> deleteEntityTransportSettings =
        HttpJsonCallSettings.<DeleteEntityRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEntityMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetEntityRequest, Entity> getEntityTransportSettings =
        HttpJsonCallSettings.<GetEntityRequest, Entity>newBuilder()
            .setMethodDescriptor(getEntityMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListEntitiesRequest, ListEntitiesResponse> listEntitiesTransportSettings =
        HttpJsonCallSettings.<ListEntitiesRequest, ListEntitiesResponse>newBuilder()
            .setMethodDescriptor(listEntitiesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<CreatePartitionRequest, Partition> createPartitionTransportSettings =
        HttpJsonCallSettings.<CreatePartitionRequest, Partition>newBuilder()
            .setMethodDescriptor(createPartitionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<DeletePartitionRequest, Empty> deletePartitionTransportSettings =
        HttpJsonCallSettings.<DeletePartitionRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePartitionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetPartitionRequest, Partition> getPartitionTransportSettings =
        HttpJsonCallSettings.<GetPartitionRequest, Partition>newBuilder()
            .setMethodDescriptor(getPartitionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListPartitionsRequest, ListPartitionsResponse>
        listPartitionsTransportSettings =
            HttpJsonCallSettings.<ListPartitionsRequest, ListPartitionsResponse>newBuilder()
                .setMethodDescriptor(listPartitionsMethodDescriptor)
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

    this.createEntityCallable =
        callableFactory.createUnaryCallable(
            createEntityTransportSettings, settings.createEntitySettings(), clientContext);
    this.updateEntityCallable =
        callableFactory.createUnaryCallable(
            updateEntityTransportSettings, settings.updateEntitySettings(), clientContext);
    this.deleteEntityCallable =
        callableFactory.createUnaryCallable(
            deleteEntityTransportSettings, settings.deleteEntitySettings(), clientContext);
    this.getEntityCallable =
        callableFactory.createUnaryCallable(
            getEntityTransportSettings, settings.getEntitySettings(), clientContext);
    this.listEntitiesCallable =
        callableFactory.createUnaryCallable(
            listEntitiesTransportSettings, settings.listEntitiesSettings(), clientContext);
    this.listEntitiesPagedCallable =
        callableFactory.createPagedCallable(
            listEntitiesTransportSettings, settings.listEntitiesSettings(), clientContext);
    this.createPartitionCallable =
        callableFactory.createUnaryCallable(
            createPartitionTransportSettings, settings.createPartitionSettings(), clientContext);
    this.deletePartitionCallable =
        callableFactory.createUnaryCallable(
            deletePartitionTransportSettings, settings.deletePartitionSettings(), clientContext);
    this.getPartitionCallable =
        callableFactory.createUnaryCallable(
            getPartitionTransportSettings, settings.getPartitionSettings(), clientContext);
    this.listPartitionsCallable =
        callableFactory.createUnaryCallable(
            listPartitionsTransportSettings, settings.listPartitionsSettings(), clientContext);
    this.listPartitionsPagedCallable =
        callableFactory.createPagedCallable(
            listPartitionsTransportSettings, settings.listPartitionsSettings(), clientContext);
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
    methodDescriptors.add(createEntityMethodDescriptor);
    methodDescriptors.add(updateEntityMethodDescriptor);
    methodDescriptors.add(deleteEntityMethodDescriptor);
    methodDescriptors.add(getEntityMethodDescriptor);
    methodDescriptors.add(listEntitiesMethodDescriptor);
    methodDescriptors.add(createPartitionMethodDescriptor);
    methodDescriptors.add(deletePartitionMethodDescriptor);
    methodDescriptors.add(getPartitionMethodDescriptor);
    methodDescriptors.add(listPartitionsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateEntityRequest, Entity> createEntityCallable() {
    return createEntityCallable;
  }

  @Override
  public UnaryCallable<UpdateEntityRequest, Entity> updateEntityCallable() {
    return updateEntityCallable;
  }

  @Override
  public UnaryCallable<DeleteEntityRequest, Empty> deleteEntityCallable() {
    return deleteEntityCallable;
  }

  @Override
  public UnaryCallable<GetEntityRequest, Entity> getEntityCallable() {
    return getEntityCallable;
  }

  @Override
  public UnaryCallable<ListEntitiesRequest, ListEntitiesResponse> listEntitiesCallable() {
    return listEntitiesCallable;
  }

  @Override
  public UnaryCallable<ListEntitiesRequest, ListEntitiesPagedResponse> listEntitiesPagedCallable() {
    return listEntitiesPagedCallable;
  }

  @Override
  public UnaryCallable<CreatePartitionRequest, Partition> createPartitionCallable() {
    return createPartitionCallable;
  }

  @Override
  public UnaryCallable<DeletePartitionRequest, Empty> deletePartitionCallable() {
    return deletePartitionCallable;
  }

  @Override
  public UnaryCallable<GetPartitionRequest, Partition> getPartitionCallable() {
    return getPartitionCallable;
  }

  @Override
  public UnaryCallable<ListPartitionsRequest, ListPartitionsResponse> listPartitionsCallable() {
    return listPartitionsCallable;
  }

  @Override
  public UnaryCallable<ListPartitionsRequest, ListPartitionsPagedResponse>
      listPartitionsPagedCallable() {
    return listPartitionsPagedCallable;
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
