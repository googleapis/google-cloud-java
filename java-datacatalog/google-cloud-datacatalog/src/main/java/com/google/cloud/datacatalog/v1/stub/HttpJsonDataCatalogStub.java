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

package com.google.cloud.datacatalog.v1.stub;

import static com.google.cloud.datacatalog.v1.DataCatalogClient.ListEntriesPagedResponse;
import static com.google.cloud.datacatalog.v1.DataCatalogClient.ListEntryGroupsPagedResponse;
import static com.google.cloud.datacatalog.v1.DataCatalogClient.ListTagsPagedResponse;
import static com.google.cloud.datacatalog.v1.DataCatalogClient.SearchCatalogPagedResponse;

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
import com.google.cloud.datacatalog.v1.Contacts;
import com.google.cloud.datacatalog.v1.CreateEntryGroupRequest;
import com.google.cloud.datacatalog.v1.CreateEntryRequest;
import com.google.cloud.datacatalog.v1.CreateTagRequest;
import com.google.cloud.datacatalog.v1.CreateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1.CreateTagTemplateRequest;
import com.google.cloud.datacatalog.v1.DeleteEntryGroupRequest;
import com.google.cloud.datacatalog.v1.DeleteEntryRequest;
import com.google.cloud.datacatalog.v1.DeleteTagRequest;
import com.google.cloud.datacatalog.v1.DeleteTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1.DeleteTagTemplateRequest;
import com.google.cloud.datacatalog.v1.Entry;
import com.google.cloud.datacatalog.v1.EntryGroup;
import com.google.cloud.datacatalog.v1.EntryOverview;
import com.google.cloud.datacatalog.v1.GetEntryGroupRequest;
import com.google.cloud.datacatalog.v1.GetEntryRequest;
import com.google.cloud.datacatalog.v1.GetTagTemplateRequest;
import com.google.cloud.datacatalog.v1.ListEntriesRequest;
import com.google.cloud.datacatalog.v1.ListEntriesResponse;
import com.google.cloud.datacatalog.v1.ListEntryGroupsRequest;
import com.google.cloud.datacatalog.v1.ListEntryGroupsResponse;
import com.google.cloud.datacatalog.v1.ListTagsRequest;
import com.google.cloud.datacatalog.v1.ListTagsResponse;
import com.google.cloud.datacatalog.v1.LookupEntryRequest;
import com.google.cloud.datacatalog.v1.ModifyEntryContactsRequest;
import com.google.cloud.datacatalog.v1.ModifyEntryOverviewRequest;
import com.google.cloud.datacatalog.v1.RenameTagTemplateFieldEnumValueRequest;
import com.google.cloud.datacatalog.v1.RenameTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1.SearchCatalogRequest;
import com.google.cloud.datacatalog.v1.SearchCatalogResponse;
import com.google.cloud.datacatalog.v1.StarEntryRequest;
import com.google.cloud.datacatalog.v1.StarEntryResponse;
import com.google.cloud.datacatalog.v1.Tag;
import com.google.cloud.datacatalog.v1.TagTemplate;
import com.google.cloud.datacatalog.v1.TagTemplateField;
import com.google.cloud.datacatalog.v1.UnstarEntryRequest;
import com.google.cloud.datacatalog.v1.UnstarEntryResponse;
import com.google.cloud.datacatalog.v1.UpdateEntryGroupRequest;
import com.google.cloud.datacatalog.v1.UpdateEntryRequest;
import com.google.cloud.datacatalog.v1.UpdateTagRequest;
import com.google.cloud.datacatalog.v1.UpdateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1.UpdateTagTemplateRequest;
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
 * REST stub implementation for the DataCatalog service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonDataCatalogStub extends DataCatalogStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<SearchCatalogRequest, SearchCatalogResponse>
      searchCatalogMethodDescriptor =
          ApiMethodDescriptor.<SearchCatalogRequest, SearchCatalogResponse>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/SearchCatalog")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchCatalogRequest>newBuilder()
                      .setPath(
                          "/v1/catalog:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchCatalogRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchCatalogResponse>newBuilder()
                      .setDefaultInstance(SearchCatalogResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEntryGroupRequest, EntryGroup>
      createEntryGroupMethodDescriptor =
          ApiMethodDescriptor.<CreateEntryGroupRequest, EntryGroup>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/CreateEntryGroup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEntryGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/entryGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "entryGroupId", request.getEntryGroupId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("entryGroup", request.getEntryGroup(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EntryGroup>newBuilder()
                      .setDefaultInstance(EntryGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEntryGroupRequest, EntryGroup>
      getEntryGroupMethodDescriptor =
          ApiMethodDescriptor.<GetEntryGroupRequest, EntryGroup>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/GetEntryGroup")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEntryGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entryGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "readMask", request.getReadMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EntryGroup>newBuilder()
                      .setDefaultInstance(EntryGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateEntryGroupRequest, EntryGroup>
      updateEntryGroupMethodDescriptor =
          ApiMethodDescriptor.<UpdateEntryGroupRequest, EntryGroup>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/UpdateEntryGroup")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEntryGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{entryGroup.name=projects/*/locations/*/entryGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "entryGroup.name", request.getEntryGroup().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("entryGroup", request.getEntryGroup(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EntryGroup>newBuilder()
                      .setDefaultInstance(EntryGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteEntryGroupRequest, Empty>
      deleteEntryGroupMethodDescriptor =
          ApiMethodDescriptor.<DeleteEntryGroupRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/DeleteEntryGroup")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEntryGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entryGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEntryGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEntryGroupRequest> serializer =
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

  private static final ApiMethodDescriptor<ListEntryGroupsRequest, ListEntryGroupsResponse>
      listEntryGroupsMethodDescriptor =
          ApiMethodDescriptor.<ListEntryGroupsRequest, ListEntryGroupsResponse>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/ListEntryGroups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEntryGroupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/entryGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntryGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntryGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEntryGroupsResponse>newBuilder()
                      .setDefaultInstance(ListEntryGroupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEntryRequest, Entry> createEntryMethodDescriptor =
      ApiMethodDescriptor.<CreateEntryRequest, Entry>newBuilder()
          .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/CreateEntry")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateEntryRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*/entryGroups/*}/entries",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "entryId", request.getEntryId());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("entry", request.getEntry(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Entry>newBuilder()
                  .setDefaultInstance(Entry.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateEntryRequest, Entry> updateEntryMethodDescriptor =
      ApiMethodDescriptor.<UpdateEntryRequest, Entry>newBuilder()
          .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/UpdateEntry")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateEntryRequest>newBuilder()
                  .setPath(
                      "/v1/{entry.name=projects/*/locations/*/entryGroups/*/entries/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "entry.name", request.getEntry().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("entry", request.getEntry(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Entry>newBuilder()
                  .setDefaultInstance(Entry.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteEntryRequest, Empty> deleteEntryMethodDescriptor =
      ApiMethodDescriptor.<DeleteEntryRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/DeleteEntry")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteEntryRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/entryGroups/*/entries/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteEntryRequest> serializer =
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

  private static final ApiMethodDescriptor<GetEntryRequest, Entry> getEntryMethodDescriptor =
      ApiMethodDescriptor.<GetEntryRequest, Entry>newBuilder()
          .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/GetEntry")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetEntryRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/entryGroups/*/entries/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Entry>newBuilder()
                  .setDefaultInstance(Entry.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<LookupEntryRequest, Entry> lookupEntryMethodDescriptor =
      ApiMethodDescriptor.<LookupEntryRequest, Entry>newBuilder()
          .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/LookupEntry")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<LookupEntryRequest>newBuilder()
                  .setPath(
                      "/v1/entries:lookup",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<LookupEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<LookupEntryRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(
                            fields, "fullyQualifiedName", request.getFullyQualifiedName());
                        serializer.putQueryParam(
                            fields, "linkedResource", request.getLinkedResource());
                        serializer.putQueryParam(fields, "sqlResource", request.getSqlResource());
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Entry>newBuilder()
                  .setDefaultInstance(Entry.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListEntriesRequest, ListEntriesResponse>
      listEntriesMethodDescriptor =
          ApiMethodDescriptor.<ListEntriesRequest, ListEntriesResponse>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/ListEntries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEntriesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/entryGroups/*}/entries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "readMask", request.getReadMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEntriesResponse>newBuilder()
                      .setDefaultInstance(ListEntriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ModifyEntryOverviewRequest, EntryOverview>
      modifyEntryOverviewMethodDescriptor =
          ApiMethodDescriptor.<ModifyEntryOverviewRequest, EntryOverview>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/ModifyEntryOverview")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ModifyEntryOverviewRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entryGroups/*/entries/*}:modifyEntryOverview",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ModifyEntryOverviewRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ModifyEntryOverviewRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EntryOverview>newBuilder()
                      .setDefaultInstance(EntryOverview.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ModifyEntryContactsRequest, Contacts>
      modifyEntryContactsMethodDescriptor =
          ApiMethodDescriptor.<ModifyEntryContactsRequest, Contacts>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/ModifyEntryContacts")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ModifyEntryContactsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entryGroups/*/entries/*}:modifyEntryContacts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ModifyEntryContactsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ModifyEntryContactsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Contacts>newBuilder()
                      .setDefaultInstance(Contacts.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTagTemplateRequest, TagTemplate>
      createTagTemplateMethodDescriptor =
          ApiMethodDescriptor.<CreateTagTemplateRequest, TagTemplate>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/CreateTagTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTagTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/tagTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTagTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTagTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "tagTemplateId", request.getTagTemplateId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tagTemplate", request.getTagTemplate(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TagTemplate>newBuilder()
                      .setDefaultInstance(TagTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTagTemplateRequest, TagTemplate>
      getTagTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetTagTemplateRequest, TagTemplate>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/GetTagTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTagTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/tagTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTagTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTagTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TagTemplate>newBuilder()
                      .setDefaultInstance(TagTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateTagTemplateRequest, TagTemplate>
      updateTagTemplateMethodDescriptor =
          ApiMethodDescriptor.<UpdateTagTemplateRequest, TagTemplate>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/UpdateTagTemplate")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTagTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{tagTemplate.name=projects/*/locations/*/tagTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTagTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "tagTemplate.name", request.getTagTemplate().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTagTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tagTemplate", request.getTagTemplate(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TagTemplate>newBuilder()
                      .setDefaultInstance(TagTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTagTemplateRequest, Empty>
      deleteTagTemplateMethodDescriptor =
          ApiMethodDescriptor.<DeleteTagTemplateRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/DeleteTagTemplate")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTagTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/tagTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTagTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTagTemplateRequest> serializer =
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

  private static final ApiMethodDescriptor<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldMethodDescriptor =
          ApiMethodDescriptor.<CreateTagTemplateFieldRequest, TagTemplateField>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/CreateTagTemplateField")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTagTemplateFieldRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/tagTemplates/*}/fields",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTagTemplateFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTagTemplateFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "tagTemplateFieldId", request.getTagTemplateFieldId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tagTemplateField", request.getTagTemplateField(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TagTemplateField>newBuilder()
                      .setDefaultInstance(TagTemplateField.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldMethodDescriptor =
          ApiMethodDescriptor.<UpdateTagTemplateFieldRequest, TagTemplateField>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/UpdateTagTemplateField")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTagTemplateFieldRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/tagTemplates/*/fields/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTagTemplateFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTagTemplateFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tagTemplateField", request.getTagTemplateField(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TagTemplateField>newBuilder()
                      .setDefaultInstance(TagTemplateField.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldMethodDescriptor =
          ApiMethodDescriptor.<RenameTagTemplateFieldRequest, TagTemplateField>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/RenameTagTemplateField")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RenameTagTemplateFieldRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/tagTemplates/*/fields/*}:rename",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RenameTagTemplateFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RenameTagTemplateFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TagTemplateField>newBuilder()
                      .setDefaultInstance(TagTemplateField.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RenameTagTemplateFieldEnumValueRequest, TagTemplateField>
      renameTagTemplateFieldEnumValueMethodDescriptor =
          ApiMethodDescriptor.<RenameTagTemplateFieldEnumValueRequest, TagTemplateField>newBuilder()
              .setFullMethodName(
                  "google.cloud.datacatalog.v1.DataCatalog/RenameTagTemplateFieldEnumValue")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RenameTagTemplateFieldEnumValueRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/tagTemplates/*/fields/*/enumValues/*}:rename",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RenameTagTemplateFieldEnumValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RenameTagTemplateFieldEnumValueRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TagTemplateField>newBuilder()
                      .setDefaultInstance(TagTemplateField.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTagTemplateFieldRequest, Empty>
      deleteTagTemplateFieldMethodDescriptor =
          ApiMethodDescriptor.<DeleteTagTemplateFieldRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/DeleteTagTemplateField")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTagTemplateFieldRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/tagTemplates/*/fields/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTagTemplateFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTagTemplateFieldRequest> serializer =
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

  private static final ApiMethodDescriptor<CreateTagRequest, Tag> createTagMethodDescriptor =
      ApiMethodDescriptor.<CreateTagRequest, Tag>newBuilder()
          .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/CreateTag")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateTagRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*/entryGroups/*/entries/*}/tags",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateTagRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setAdditionalPaths("/v1/{parent=projects/*/locations/*/entryGroups/*}/tags")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateTagRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("tag", request.getTag(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Tag>newBuilder()
                  .setDefaultInstance(Tag.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateTagRequest, Tag> updateTagMethodDescriptor =
      ApiMethodDescriptor.<UpdateTagRequest, Tag>newBuilder()
          .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/UpdateTag")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateTagRequest>newBuilder()
                  .setPath(
                      "/v1/{tag.name=projects/*/locations/*/entryGroups/*/entries/*/tags/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateTagRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "tag.name", request.getTag().getName());
                        return fields;
                      })
                  .setAdditionalPaths("/v1/{tag.name=projects/*/locations/*/entryGroups/*/tags/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateTagRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("tag", request.getTag(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Tag>newBuilder()
                  .setDefaultInstance(Tag.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteTagRequest, Empty> deleteTagMethodDescriptor =
      ApiMethodDescriptor.<DeleteTagRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/DeleteTag")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteTagRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/entryGroups/*/entries/*/tags/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteTagRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths("/v1/{name=projects/*/locations/*/entryGroups/*/tags/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteTagRequest> serializer =
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

  private static final ApiMethodDescriptor<ListTagsRequest, ListTagsResponse>
      listTagsMethodDescriptor =
          ApiMethodDescriptor.<ListTagsRequest, ListTagsResponse>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/ListTags")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTagsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/entryGroups/*/entries/*}/tags",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTagsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*/locations/*/entryGroups/*}/tags")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTagsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTagsResponse>newBuilder()
                      .setDefaultInstance(ListTagsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<StarEntryRequest, StarEntryResponse>
      starEntryMethodDescriptor =
          ApiMethodDescriptor.<StarEntryRequest, StarEntryResponse>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/StarEntry")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StarEntryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entryGroups/*/entries/*}:star",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StarEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StarEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StarEntryResponse>newBuilder()
                      .setDefaultInstance(StarEntryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UnstarEntryRequest, UnstarEntryResponse>
      unstarEntryMethodDescriptor =
          ApiMethodDescriptor.<UnstarEntryRequest, UnstarEntryResponse>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/UnstarEntry")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UnstarEntryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/entryGroups/*/entries/*}:unstar",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UnstarEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UnstarEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UnstarEntryResponse>newBuilder()
                      .setDefaultInstance(UnstarEntryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/tagTemplates/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/entryGroups/*}:setIamPolicy")
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
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/tagTemplates/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/entryGroups/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/entryGroups/*/entries/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
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

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.v1.DataCatalog/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/tagTemplates/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/entryGroups/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/entryGroups/*/entries/*}:testIamPermissions")
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

  private final UnaryCallable<SearchCatalogRequest, SearchCatalogResponse> searchCatalogCallable;
  private final UnaryCallable<SearchCatalogRequest, SearchCatalogPagedResponse>
      searchCatalogPagedCallable;
  private final UnaryCallable<CreateEntryGroupRequest, EntryGroup> createEntryGroupCallable;
  private final UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable;
  private final UnaryCallable<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupCallable;
  private final UnaryCallable<DeleteEntryGroupRequest, Empty> deleteEntryGroupCallable;
  private final UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse>
      listEntryGroupsCallable;
  private final UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsPagedResponse>
      listEntryGroupsPagedCallable;
  private final UnaryCallable<CreateEntryRequest, Entry> createEntryCallable;
  private final UnaryCallable<UpdateEntryRequest, Entry> updateEntryCallable;
  private final UnaryCallable<DeleteEntryRequest, Empty> deleteEntryCallable;
  private final UnaryCallable<GetEntryRequest, Entry> getEntryCallable;
  private final UnaryCallable<LookupEntryRequest, Entry> lookupEntryCallable;
  private final UnaryCallable<ListEntriesRequest, ListEntriesResponse> listEntriesCallable;
  private final UnaryCallable<ListEntriesRequest, ListEntriesPagedResponse>
      listEntriesPagedCallable;
  private final UnaryCallable<ModifyEntryOverviewRequest, EntryOverview>
      modifyEntryOverviewCallable;
  private final UnaryCallable<ModifyEntryContactsRequest, Contacts> modifyEntryContactsCallable;
  private final UnaryCallable<CreateTagTemplateRequest, TagTemplate> createTagTemplateCallable;
  private final UnaryCallable<GetTagTemplateRequest, TagTemplate> getTagTemplateCallable;
  private final UnaryCallable<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateCallable;
  private final UnaryCallable<DeleteTagTemplateRequest, Empty> deleteTagTemplateCallable;
  private final UnaryCallable<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldCallable;
  private final UnaryCallable<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldCallable;
  private final UnaryCallable<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldCallable;
  private final UnaryCallable<RenameTagTemplateFieldEnumValueRequest, TagTemplateField>
      renameTagTemplateFieldEnumValueCallable;
  private final UnaryCallable<DeleteTagTemplateFieldRequest, Empty> deleteTagTemplateFieldCallable;
  private final UnaryCallable<CreateTagRequest, Tag> createTagCallable;
  private final UnaryCallable<UpdateTagRequest, Tag> updateTagCallable;
  private final UnaryCallable<DeleteTagRequest, Empty> deleteTagCallable;
  private final UnaryCallable<ListTagsRequest, ListTagsResponse> listTagsCallable;
  private final UnaryCallable<ListTagsRequest, ListTagsPagedResponse> listTagsPagedCallable;
  private final UnaryCallable<StarEntryRequest, StarEntryResponse> starEntryCallable;
  private final UnaryCallable<UnstarEntryRequest, UnstarEntryResponse> unstarEntryCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataCatalogStub create(DataCatalogStubSettings settings)
      throws IOException {
    return new HttpJsonDataCatalogStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataCatalogStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataCatalogStub(
        DataCatalogStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataCatalogStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataCatalogStub(
        DataCatalogStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataCatalogStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDataCatalogStub(DataCatalogStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDataCatalogCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataCatalogStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDataCatalogStub(
      DataCatalogStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<SearchCatalogRequest, SearchCatalogResponse>
        searchCatalogTransportSettings =
            HttpJsonCallSettings.<SearchCatalogRequest, SearchCatalogResponse>newBuilder()
                .setMethodDescriptor(searchCatalogMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateEntryGroupRequest, EntryGroup> createEntryGroupTransportSettings =
        HttpJsonCallSettings.<CreateEntryGroupRequest, EntryGroup>newBuilder()
            .setMethodDescriptor(createEntryGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetEntryGroupRequest, EntryGroup> getEntryGroupTransportSettings =
        HttpJsonCallSettings.<GetEntryGroupRequest, EntryGroup>newBuilder()
            .setMethodDescriptor(getEntryGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupTransportSettings =
        HttpJsonCallSettings.<UpdateEntryGroupRequest, EntryGroup>newBuilder()
            .setMethodDescriptor(updateEntryGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteEntryGroupRequest, Empty> deleteEntryGroupTransportSettings =
        HttpJsonCallSettings.<DeleteEntryGroupRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEntryGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListEntryGroupsRequest, ListEntryGroupsResponse>
        listEntryGroupsTransportSettings =
            HttpJsonCallSettings.<ListEntryGroupsRequest, ListEntryGroupsResponse>newBuilder()
                .setMethodDescriptor(listEntryGroupsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateEntryRequest, Entry> createEntryTransportSettings =
        HttpJsonCallSettings.<CreateEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(createEntryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateEntryRequest, Entry> updateEntryTransportSettings =
        HttpJsonCallSettings.<UpdateEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(updateEntryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteEntryRequest, Empty> deleteEntryTransportSettings =
        HttpJsonCallSettings.<DeleteEntryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEntryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetEntryRequest, Entry> getEntryTransportSettings =
        HttpJsonCallSettings.<GetEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(getEntryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<LookupEntryRequest, Entry> lookupEntryTransportSettings =
        HttpJsonCallSettings.<LookupEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(lookupEntryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListEntriesRequest, ListEntriesResponse> listEntriesTransportSettings =
        HttpJsonCallSettings.<ListEntriesRequest, ListEntriesResponse>newBuilder()
            .setMethodDescriptor(listEntriesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ModifyEntryOverviewRequest, EntryOverview>
        modifyEntryOverviewTransportSettings =
            HttpJsonCallSettings.<ModifyEntryOverviewRequest, EntryOverview>newBuilder()
                .setMethodDescriptor(modifyEntryOverviewMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ModifyEntryContactsRequest, Contacts>
        modifyEntryContactsTransportSettings =
            HttpJsonCallSettings.<ModifyEntryContactsRequest, Contacts>newBuilder()
                .setMethodDescriptor(modifyEntryContactsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateTagTemplateRequest, TagTemplate> createTagTemplateTransportSettings =
        HttpJsonCallSettings.<CreateTagTemplateRequest, TagTemplate>newBuilder()
            .setMethodDescriptor(createTagTemplateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetTagTemplateRequest, TagTemplate> getTagTemplateTransportSettings =
        HttpJsonCallSettings.<GetTagTemplateRequest, TagTemplate>newBuilder()
            .setMethodDescriptor(getTagTemplateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateTransportSettings =
        HttpJsonCallSettings.<UpdateTagTemplateRequest, TagTemplate>newBuilder()
            .setMethodDescriptor(updateTagTemplateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteTagTemplateRequest, Empty> deleteTagTemplateTransportSettings =
        HttpJsonCallSettings.<DeleteTagTemplateRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTagTemplateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateTagTemplateFieldRequest, TagTemplateField>
        createTagTemplateFieldTransportSettings =
            HttpJsonCallSettings.<CreateTagTemplateFieldRequest, TagTemplateField>newBuilder()
                .setMethodDescriptor(createTagTemplateFieldMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateTagTemplateFieldRequest, TagTemplateField>
        updateTagTemplateFieldTransportSettings =
            HttpJsonCallSettings.<UpdateTagTemplateFieldRequest, TagTemplateField>newBuilder()
                .setMethodDescriptor(updateTagTemplateFieldMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RenameTagTemplateFieldRequest, TagTemplateField>
        renameTagTemplateFieldTransportSettings =
            HttpJsonCallSettings.<RenameTagTemplateFieldRequest, TagTemplateField>newBuilder()
                .setMethodDescriptor(renameTagTemplateFieldMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RenameTagTemplateFieldEnumValueRequest, TagTemplateField>
        renameTagTemplateFieldEnumValueTransportSettings =
            HttpJsonCallSettings
                .<RenameTagTemplateFieldEnumValueRequest, TagTemplateField>newBuilder()
                .setMethodDescriptor(renameTagTemplateFieldEnumValueMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteTagTemplateFieldRequest, Empty>
        deleteTagTemplateFieldTransportSettings =
            HttpJsonCallSettings.<DeleteTagTemplateFieldRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteTagTemplateFieldMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateTagRequest, Tag> createTagTransportSettings =
        HttpJsonCallSettings.<CreateTagRequest, Tag>newBuilder()
            .setMethodDescriptor(createTagMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateTagRequest, Tag> updateTagTransportSettings =
        HttpJsonCallSettings.<UpdateTagRequest, Tag>newBuilder()
            .setMethodDescriptor(updateTagMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteTagRequest, Empty> deleteTagTransportSettings =
        HttpJsonCallSettings.<DeleteTagRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTagMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListTagsRequest, ListTagsResponse> listTagsTransportSettings =
        HttpJsonCallSettings.<ListTagsRequest, ListTagsResponse>newBuilder()
            .setMethodDescriptor(listTagsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StarEntryRequest, StarEntryResponse> starEntryTransportSettings =
        HttpJsonCallSettings.<StarEntryRequest, StarEntryResponse>newBuilder()
            .setMethodDescriptor(starEntryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UnstarEntryRequest, UnstarEntryResponse> unstarEntryTransportSettings =
        HttpJsonCallSettings.<UnstarEntryRequest, UnstarEntryResponse>newBuilder()
            .setMethodDescriptor(unstarEntryMethodDescriptor)
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

    this.searchCatalogCallable =
        callableFactory.createUnaryCallable(
            searchCatalogTransportSettings, settings.searchCatalogSettings(), clientContext);
    this.searchCatalogPagedCallable =
        callableFactory.createPagedCallable(
            searchCatalogTransportSettings, settings.searchCatalogSettings(), clientContext);
    this.createEntryGroupCallable =
        callableFactory.createUnaryCallable(
            createEntryGroupTransportSettings, settings.createEntryGroupSettings(), clientContext);
    this.getEntryGroupCallable =
        callableFactory.createUnaryCallable(
            getEntryGroupTransportSettings, settings.getEntryGroupSettings(), clientContext);
    this.updateEntryGroupCallable =
        callableFactory.createUnaryCallable(
            updateEntryGroupTransportSettings, settings.updateEntryGroupSettings(), clientContext);
    this.deleteEntryGroupCallable =
        callableFactory.createUnaryCallable(
            deleteEntryGroupTransportSettings, settings.deleteEntryGroupSettings(), clientContext);
    this.listEntryGroupsCallable =
        callableFactory.createUnaryCallable(
            listEntryGroupsTransportSettings, settings.listEntryGroupsSettings(), clientContext);
    this.listEntryGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listEntryGroupsTransportSettings, settings.listEntryGroupsSettings(), clientContext);
    this.createEntryCallable =
        callableFactory.createUnaryCallable(
            createEntryTransportSettings, settings.createEntrySettings(), clientContext);
    this.updateEntryCallable =
        callableFactory.createUnaryCallable(
            updateEntryTransportSettings, settings.updateEntrySettings(), clientContext);
    this.deleteEntryCallable =
        callableFactory.createUnaryCallable(
            deleteEntryTransportSettings, settings.deleteEntrySettings(), clientContext);
    this.getEntryCallable =
        callableFactory.createUnaryCallable(
            getEntryTransportSettings, settings.getEntrySettings(), clientContext);
    this.lookupEntryCallable =
        callableFactory.createUnaryCallable(
            lookupEntryTransportSettings, settings.lookupEntrySettings(), clientContext);
    this.listEntriesCallable =
        callableFactory.createUnaryCallable(
            listEntriesTransportSettings, settings.listEntriesSettings(), clientContext);
    this.listEntriesPagedCallable =
        callableFactory.createPagedCallable(
            listEntriesTransportSettings, settings.listEntriesSettings(), clientContext);
    this.modifyEntryOverviewCallable =
        callableFactory.createUnaryCallable(
            modifyEntryOverviewTransportSettings,
            settings.modifyEntryOverviewSettings(),
            clientContext);
    this.modifyEntryContactsCallable =
        callableFactory.createUnaryCallable(
            modifyEntryContactsTransportSettings,
            settings.modifyEntryContactsSettings(),
            clientContext);
    this.createTagTemplateCallable =
        callableFactory.createUnaryCallable(
            createTagTemplateTransportSettings,
            settings.createTagTemplateSettings(),
            clientContext);
    this.getTagTemplateCallable =
        callableFactory.createUnaryCallable(
            getTagTemplateTransportSettings, settings.getTagTemplateSettings(), clientContext);
    this.updateTagTemplateCallable =
        callableFactory.createUnaryCallable(
            updateTagTemplateTransportSettings,
            settings.updateTagTemplateSettings(),
            clientContext);
    this.deleteTagTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteTagTemplateTransportSettings,
            settings.deleteTagTemplateSettings(),
            clientContext);
    this.createTagTemplateFieldCallable =
        callableFactory.createUnaryCallable(
            createTagTemplateFieldTransportSettings,
            settings.createTagTemplateFieldSettings(),
            clientContext);
    this.updateTagTemplateFieldCallable =
        callableFactory.createUnaryCallable(
            updateTagTemplateFieldTransportSettings,
            settings.updateTagTemplateFieldSettings(),
            clientContext);
    this.renameTagTemplateFieldCallable =
        callableFactory.createUnaryCallable(
            renameTagTemplateFieldTransportSettings,
            settings.renameTagTemplateFieldSettings(),
            clientContext);
    this.renameTagTemplateFieldEnumValueCallable =
        callableFactory.createUnaryCallable(
            renameTagTemplateFieldEnumValueTransportSettings,
            settings.renameTagTemplateFieldEnumValueSettings(),
            clientContext);
    this.deleteTagTemplateFieldCallable =
        callableFactory.createUnaryCallable(
            deleteTagTemplateFieldTransportSettings,
            settings.deleteTagTemplateFieldSettings(),
            clientContext);
    this.createTagCallable =
        callableFactory.createUnaryCallable(
            createTagTransportSettings, settings.createTagSettings(), clientContext);
    this.updateTagCallable =
        callableFactory.createUnaryCallable(
            updateTagTransportSettings, settings.updateTagSettings(), clientContext);
    this.deleteTagCallable =
        callableFactory.createUnaryCallable(
            deleteTagTransportSettings, settings.deleteTagSettings(), clientContext);
    this.listTagsCallable =
        callableFactory.createUnaryCallable(
            listTagsTransportSettings, settings.listTagsSettings(), clientContext);
    this.listTagsPagedCallable =
        callableFactory.createPagedCallable(
            listTagsTransportSettings, settings.listTagsSettings(), clientContext);
    this.starEntryCallable =
        callableFactory.createUnaryCallable(
            starEntryTransportSettings, settings.starEntrySettings(), clientContext);
    this.unstarEntryCallable =
        callableFactory.createUnaryCallable(
            unstarEntryTransportSettings, settings.unstarEntrySettings(), clientContext);
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
    methodDescriptors.add(searchCatalogMethodDescriptor);
    methodDescriptors.add(createEntryGroupMethodDescriptor);
    methodDescriptors.add(getEntryGroupMethodDescriptor);
    methodDescriptors.add(updateEntryGroupMethodDescriptor);
    methodDescriptors.add(deleteEntryGroupMethodDescriptor);
    methodDescriptors.add(listEntryGroupsMethodDescriptor);
    methodDescriptors.add(createEntryMethodDescriptor);
    methodDescriptors.add(updateEntryMethodDescriptor);
    methodDescriptors.add(deleteEntryMethodDescriptor);
    methodDescriptors.add(getEntryMethodDescriptor);
    methodDescriptors.add(lookupEntryMethodDescriptor);
    methodDescriptors.add(listEntriesMethodDescriptor);
    methodDescriptors.add(modifyEntryOverviewMethodDescriptor);
    methodDescriptors.add(modifyEntryContactsMethodDescriptor);
    methodDescriptors.add(createTagTemplateMethodDescriptor);
    methodDescriptors.add(getTagTemplateMethodDescriptor);
    methodDescriptors.add(updateTagTemplateMethodDescriptor);
    methodDescriptors.add(deleteTagTemplateMethodDescriptor);
    methodDescriptors.add(createTagTemplateFieldMethodDescriptor);
    methodDescriptors.add(updateTagTemplateFieldMethodDescriptor);
    methodDescriptors.add(renameTagTemplateFieldMethodDescriptor);
    methodDescriptors.add(renameTagTemplateFieldEnumValueMethodDescriptor);
    methodDescriptors.add(deleteTagTemplateFieldMethodDescriptor);
    methodDescriptors.add(createTagMethodDescriptor);
    methodDescriptors.add(updateTagMethodDescriptor);
    methodDescriptors.add(deleteTagMethodDescriptor);
    methodDescriptors.add(listTagsMethodDescriptor);
    methodDescriptors.add(starEntryMethodDescriptor);
    methodDescriptors.add(unstarEntryMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<SearchCatalogRequest, SearchCatalogResponse> searchCatalogCallable() {
    return searchCatalogCallable;
  }

  @Override
  public UnaryCallable<SearchCatalogRequest, SearchCatalogPagedResponse>
      searchCatalogPagedCallable() {
    return searchCatalogPagedCallable;
  }

  @Override
  public UnaryCallable<CreateEntryGroupRequest, EntryGroup> createEntryGroupCallable() {
    return createEntryGroupCallable;
  }

  @Override
  public UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable() {
    return getEntryGroupCallable;
  }

  @Override
  public UnaryCallable<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupCallable() {
    return updateEntryGroupCallable;
  }

  @Override
  public UnaryCallable<DeleteEntryGroupRequest, Empty> deleteEntryGroupCallable() {
    return deleteEntryGroupCallable;
  }

  @Override
  public UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse> listEntryGroupsCallable() {
    return listEntryGroupsCallable;
  }

  @Override
  public UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsPagedResponse>
      listEntryGroupsPagedCallable() {
    return listEntryGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateEntryRequest, Entry> createEntryCallable() {
    return createEntryCallable;
  }

  @Override
  public UnaryCallable<UpdateEntryRequest, Entry> updateEntryCallable() {
    return updateEntryCallable;
  }

  @Override
  public UnaryCallable<DeleteEntryRequest, Empty> deleteEntryCallable() {
    return deleteEntryCallable;
  }

  @Override
  public UnaryCallable<GetEntryRequest, Entry> getEntryCallable() {
    return getEntryCallable;
  }

  @Override
  public UnaryCallable<LookupEntryRequest, Entry> lookupEntryCallable() {
    return lookupEntryCallable;
  }

  @Override
  public UnaryCallable<ListEntriesRequest, ListEntriesResponse> listEntriesCallable() {
    return listEntriesCallable;
  }

  @Override
  public UnaryCallable<ListEntriesRequest, ListEntriesPagedResponse> listEntriesPagedCallable() {
    return listEntriesPagedCallable;
  }

  @Override
  public UnaryCallable<ModifyEntryOverviewRequest, EntryOverview> modifyEntryOverviewCallable() {
    return modifyEntryOverviewCallable;
  }

  @Override
  public UnaryCallable<ModifyEntryContactsRequest, Contacts> modifyEntryContactsCallable() {
    return modifyEntryContactsCallable;
  }

  @Override
  public UnaryCallable<CreateTagTemplateRequest, TagTemplate> createTagTemplateCallable() {
    return createTagTemplateCallable;
  }

  @Override
  public UnaryCallable<GetTagTemplateRequest, TagTemplate> getTagTemplateCallable() {
    return getTagTemplateCallable;
  }

  @Override
  public UnaryCallable<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateCallable() {
    return updateTagTemplateCallable;
  }

  @Override
  public UnaryCallable<DeleteTagTemplateRequest, Empty> deleteTagTemplateCallable() {
    return deleteTagTemplateCallable;
  }

  @Override
  public UnaryCallable<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldCallable() {
    return createTagTemplateFieldCallable;
  }

  @Override
  public UnaryCallable<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldCallable() {
    return updateTagTemplateFieldCallable;
  }

  @Override
  public UnaryCallable<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldCallable() {
    return renameTagTemplateFieldCallable;
  }

  @Override
  public UnaryCallable<RenameTagTemplateFieldEnumValueRequest, TagTemplateField>
      renameTagTemplateFieldEnumValueCallable() {
    return renameTagTemplateFieldEnumValueCallable;
  }

  @Override
  public UnaryCallable<DeleteTagTemplateFieldRequest, Empty> deleteTagTemplateFieldCallable() {
    return deleteTagTemplateFieldCallable;
  }

  @Override
  public UnaryCallable<CreateTagRequest, Tag> createTagCallable() {
    return createTagCallable;
  }

  @Override
  public UnaryCallable<UpdateTagRequest, Tag> updateTagCallable() {
    return updateTagCallable;
  }

  @Override
  public UnaryCallable<DeleteTagRequest, Empty> deleteTagCallable() {
    return deleteTagCallable;
  }

  @Override
  public UnaryCallable<ListTagsRequest, ListTagsResponse> listTagsCallable() {
    return listTagsCallable;
  }

  @Override
  public UnaryCallable<ListTagsRequest, ListTagsPagedResponse> listTagsPagedCallable() {
    return listTagsPagedCallable;
  }

  @Override
  public UnaryCallable<StarEntryRequest, StarEntryResponse> starEntryCallable() {
    return starEntryCallable;
  }

  @Override
  public UnaryCallable<UnstarEntryRequest, UnstarEntryResponse> unstarEntryCallable() {
    return unstarEntryCallable;
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
