/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.datacatalog.v1beta1.stub;

import static com.google.cloud.datacatalog.v1beta1.DataCatalogClient.ListEntriesPagedResponse;
import static com.google.cloud.datacatalog.v1beta1.DataCatalogClient.ListEntryGroupsPagedResponse;
import static com.google.cloud.datacatalog.v1beta1.DataCatalogClient.ListTagsPagedResponse;
import static com.google.cloud.datacatalog.v1beta1.DataCatalogClient.SearchCatalogPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest;
import com.google.cloud.datacatalog.v1beta1.CreateEntryRequest;
import com.google.cloud.datacatalog.v1beta1.CreateTagRequest;
import com.google.cloud.datacatalog.v1beta1.CreateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1beta1.CreateTagTemplateRequest;
import com.google.cloud.datacatalog.v1beta1.DeleteEntryGroupRequest;
import com.google.cloud.datacatalog.v1beta1.DeleteEntryRequest;
import com.google.cloud.datacatalog.v1beta1.DeleteTagRequest;
import com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateRequest;
import com.google.cloud.datacatalog.v1beta1.Entry;
import com.google.cloud.datacatalog.v1beta1.EntryGroup;
import com.google.cloud.datacatalog.v1beta1.GetEntryGroupRequest;
import com.google.cloud.datacatalog.v1beta1.GetEntryRequest;
import com.google.cloud.datacatalog.v1beta1.GetTagTemplateRequest;
import com.google.cloud.datacatalog.v1beta1.ListEntriesRequest;
import com.google.cloud.datacatalog.v1beta1.ListEntriesResponse;
import com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest;
import com.google.cloud.datacatalog.v1beta1.ListEntryGroupsResponse;
import com.google.cloud.datacatalog.v1beta1.ListTagsRequest;
import com.google.cloud.datacatalog.v1beta1.ListTagsResponse;
import com.google.cloud.datacatalog.v1beta1.LookupEntryRequest;
import com.google.cloud.datacatalog.v1beta1.RenameTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest;
import com.google.cloud.datacatalog.v1beta1.SearchCatalogResponse;
import com.google.cloud.datacatalog.v1beta1.Tag;
import com.google.cloud.datacatalog.v1beta1.TagTemplate;
import com.google.cloud.datacatalog.v1beta1.TagTemplateField;
import com.google.cloud.datacatalog.v1beta1.UpdateEntryGroupRequest;
import com.google.cloud.datacatalog.v1beta1.UpdateEntryRequest;
import com.google.cloud.datacatalog.v1beta1.UpdateTagRequest;
import com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateRequest;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DataCatalog service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDataCatalogStub extends DataCatalogStub {
  private static final MethodDescriptor<SearchCatalogRequest, SearchCatalogResponse>
      searchCatalogMethodDescriptor =
          MethodDescriptor.<SearchCatalogRequest, SearchCatalogResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/SearchCatalog")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchCatalogResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateEntryGroupRequest, EntryGroup>
      createEntryGroupMethodDescriptor =
          MethodDescriptor.<CreateEntryGroupRequest, EntryGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/CreateEntryGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEntryGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EntryGroup.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateEntryGroupRequest, EntryGroup>
      updateEntryGroupMethodDescriptor =
          MethodDescriptor.<UpdateEntryGroupRequest, EntryGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/UpdateEntryGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEntryGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EntryGroup.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEntryGroupRequest, EntryGroup>
      getEntryGroupMethodDescriptor =
          MethodDescriptor.<GetEntryGroupRequest, EntryGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/GetEntryGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEntryGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EntryGroup.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEntryGroupRequest, Empty>
      deleteEntryGroupMethodDescriptor =
          MethodDescriptor.<DeleteEntryGroupRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/DeleteEntryGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEntryGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEntryGroupsRequest, ListEntryGroupsResponse>
      listEntryGroupsMethodDescriptor =
          MethodDescriptor.<ListEntryGroupsRequest, ListEntryGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/ListEntryGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEntryGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEntryGroupsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateEntryRequest, Entry> createEntryMethodDescriptor =
      MethodDescriptor.<CreateEntryRequest, Entry>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/CreateEntry")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateEntryRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Entry.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateEntryRequest, Entry> updateEntryMethodDescriptor =
      MethodDescriptor.<UpdateEntryRequest, Entry>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/UpdateEntry")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateEntryRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Entry.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteEntryRequest, Empty> deleteEntryMethodDescriptor =
      MethodDescriptor.<DeleteEntryRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/DeleteEntry")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteEntryRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetEntryRequest, Entry> getEntryMethodDescriptor =
      MethodDescriptor.<GetEntryRequest, Entry>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/GetEntry")
          .setRequestMarshaller(ProtoUtils.marshaller(GetEntryRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Entry.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<LookupEntryRequest, Entry> lookupEntryMethodDescriptor =
      MethodDescriptor.<LookupEntryRequest, Entry>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/LookupEntry")
          .setRequestMarshaller(ProtoUtils.marshaller(LookupEntryRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Entry.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListEntriesRequest, ListEntriesResponse>
      listEntriesMethodDescriptor =
          MethodDescriptor.<ListEntriesRequest, ListEntriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/ListEntries")
              .setRequestMarshaller(ProtoUtils.marshaller(ListEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEntriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTagTemplateRequest, TagTemplate>
      createTagTemplateMethodDescriptor =
          MethodDescriptor.<CreateTagTemplateRequest, TagTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/CreateTagTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTagTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TagTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTagTemplateRequest, TagTemplate>
      getTagTemplateMethodDescriptor =
          MethodDescriptor.<GetTagTemplateRequest, TagTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/GetTagTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTagTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TagTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTagTemplateRequest, TagTemplate>
      updateTagTemplateMethodDescriptor =
          MethodDescriptor.<UpdateTagTemplateRequest, TagTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/UpdateTagTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTagTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TagTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTagTemplateRequest, Empty>
      deleteTagTemplateMethodDescriptor =
          MethodDescriptor.<DeleteTagTemplateRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/DeleteTagTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTagTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldMethodDescriptor =
          MethodDescriptor.<CreateTagTemplateFieldRequest, TagTemplateField>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datacatalog.v1beta1.DataCatalog/CreateTagTemplateField")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTagTemplateFieldRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TagTemplateField.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldMethodDescriptor =
          MethodDescriptor.<UpdateTagTemplateFieldRequest, TagTemplateField>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datacatalog.v1beta1.DataCatalog/UpdateTagTemplateField")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTagTemplateFieldRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TagTemplateField.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldMethodDescriptor =
          MethodDescriptor.<RenameTagTemplateFieldRequest, TagTemplateField>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datacatalog.v1beta1.DataCatalog/RenameTagTemplateField")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RenameTagTemplateFieldRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TagTemplateField.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTagTemplateFieldRequest, Empty>
      deleteTagTemplateFieldMethodDescriptor =
          MethodDescriptor.<DeleteTagTemplateFieldRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datacatalog.v1beta1.DataCatalog/DeleteTagTemplateField")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTagTemplateFieldRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTagRequest, Tag> createTagMethodDescriptor =
      MethodDescriptor.<CreateTagRequest, Tag>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/CreateTag")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateTagRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tag.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateTagRequest, Tag> updateTagMethodDescriptor =
      MethodDescriptor.<UpdateTagRequest, Tag>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/UpdateTag")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateTagRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tag.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteTagRequest, Empty> deleteTagMethodDescriptor =
      MethodDescriptor.<DeleteTagRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/DeleteTag")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteTagRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListTagsRequest, ListTagsResponse>
      listTagsMethodDescriptor =
          MethodDescriptor.<ListTagsRequest, ListTagsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/ListTags")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTagsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTagsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1beta1.DataCatalog/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<SearchCatalogRequest, SearchCatalogResponse> searchCatalogCallable;
  private final UnaryCallable<SearchCatalogRequest, SearchCatalogPagedResponse>
      searchCatalogPagedCallable;
  private final UnaryCallable<CreateEntryGroupRequest, EntryGroup> createEntryGroupCallable;
  private final UnaryCallable<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupCallable;
  private final UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable;
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
  private final UnaryCallable<DeleteTagTemplateFieldRequest, Empty> deleteTagTemplateFieldCallable;
  private final UnaryCallable<CreateTagRequest, Tag> createTagCallable;
  private final UnaryCallable<UpdateTagRequest, Tag> updateTagCallable;
  private final UnaryCallable<DeleteTagRequest, Empty> deleteTagCallable;
  private final UnaryCallable<ListTagsRequest, ListTagsResponse> listTagsCallable;
  private final UnaryCallable<ListTagsRequest, ListTagsPagedResponse> listTagsPagedCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataCatalogStub create(DataCatalogStubSettings settings)
      throws IOException {
    return new GrpcDataCatalogStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataCatalogStub create(ClientContext clientContext) throws IOException {
    return new GrpcDataCatalogStub(DataCatalogStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataCatalogStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataCatalogStub(
        DataCatalogStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataCatalogStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataCatalogStub(DataCatalogStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDataCatalogCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataCatalogStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataCatalogStub(
      DataCatalogStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SearchCatalogRequest, SearchCatalogResponse> searchCatalogTransportSettings =
        GrpcCallSettings.<SearchCatalogRequest, SearchCatalogResponse>newBuilder()
            .setMethodDescriptor(searchCatalogMethodDescriptor)
            .build();
    GrpcCallSettings<CreateEntryGroupRequest, EntryGroup> createEntryGroupTransportSettings =
        GrpcCallSettings.<CreateEntryGroupRequest, EntryGroup>newBuilder()
            .setMethodDescriptor(createEntryGroupMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateEntryGroupRequest>() {
                  @Override
                  public Map<String, String> extract(CreateEntryGroupRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupTransportSettings =
        GrpcCallSettings.<UpdateEntryGroupRequest, EntryGroup>newBuilder()
            .setMethodDescriptor(updateEntryGroupMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateEntryGroupRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateEntryGroupRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "entry_group.name", String.valueOf(request.getEntryGroup().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetEntryGroupRequest, EntryGroup> getEntryGroupTransportSettings =
        GrpcCallSettings.<GetEntryGroupRequest, EntryGroup>newBuilder()
            .setMethodDescriptor(getEntryGroupMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetEntryGroupRequest>() {
                  @Override
                  public Map<String, String> extract(GetEntryGroupRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteEntryGroupRequest, Empty> deleteEntryGroupTransportSettings =
        GrpcCallSettings.<DeleteEntryGroupRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEntryGroupMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteEntryGroupRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteEntryGroupRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListEntryGroupsRequest, ListEntryGroupsResponse>
        listEntryGroupsTransportSettings =
            GrpcCallSettings.<ListEntryGroupsRequest, ListEntryGroupsResponse>newBuilder()
                .setMethodDescriptor(listEntryGroupsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListEntryGroupsRequest>() {
                      @Override
                      public Map<String, String> extract(ListEntryGroupsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateEntryRequest, Entry> createEntryTransportSettings =
        GrpcCallSettings.<CreateEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(createEntryMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateEntryRequest>() {
                  @Override
                  public Map<String, String> extract(CreateEntryRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateEntryRequest, Entry> updateEntryTransportSettings =
        GrpcCallSettings.<UpdateEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(updateEntryMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateEntryRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateEntryRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("entry.name", String.valueOf(request.getEntry().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteEntryRequest, Empty> deleteEntryTransportSettings =
        GrpcCallSettings.<DeleteEntryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEntryMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteEntryRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteEntryRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetEntryRequest, Entry> getEntryTransportSettings =
        GrpcCallSettings.<GetEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(getEntryMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetEntryRequest>() {
                  @Override
                  public Map<String, String> extract(GetEntryRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<LookupEntryRequest, Entry> lookupEntryTransportSettings =
        GrpcCallSettings.<LookupEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(lookupEntryMethodDescriptor)
            .build();
    GrpcCallSettings<ListEntriesRequest, ListEntriesResponse> listEntriesTransportSettings =
        GrpcCallSettings.<ListEntriesRequest, ListEntriesResponse>newBuilder()
            .setMethodDescriptor(listEntriesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListEntriesRequest>() {
                  @Override
                  public Map<String, String> extract(ListEntriesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateTagTemplateRequest, TagTemplate> createTagTemplateTransportSettings =
        GrpcCallSettings.<CreateTagTemplateRequest, TagTemplate>newBuilder()
            .setMethodDescriptor(createTagTemplateMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateTagTemplateRequest>() {
                  @Override
                  public Map<String, String> extract(CreateTagTemplateRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetTagTemplateRequest, TagTemplate> getTagTemplateTransportSettings =
        GrpcCallSettings.<GetTagTemplateRequest, TagTemplate>newBuilder()
            .setMethodDescriptor(getTagTemplateMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetTagTemplateRequest>() {
                  @Override
                  public Map<String, String> extract(GetTagTemplateRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateTransportSettings =
        GrpcCallSettings.<UpdateTagTemplateRequest, TagTemplate>newBuilder()
            .setMethodDescriptor(updateTagTemplateMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateTagTemplateRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateTagTemplateRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "tag_template.name", String.valueOf(request.getTagTemplate().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteTagTemplateRequest, Empty> deleteTagTemplateTransportSettings =
        GrpcCallSettings.<DeleteTagTemplateRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTagTemplateMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteTagTemplateRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteTagTemplateRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateTagTemplateFieldRequest, TagTemplateField>
        createTagTemplateFieldTransportSettings =
            GrpcCallSettings.<CreateTagTemplateFieldRequest, TagTemplateField>newBuilder()
                .setMethodDescriptor(createTagTemplateFieldMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateTagTemplateFieldRequest>() {
                      @Override
                      public Map<String, String> extract(CreateTagTemplateFieldRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateTagTemplateFieldRequest, TagTemplateField>
        updateTagTemplateFieldTransportSettings =
            GrpcCallSettings.<UpdateTagTemplateFieldRequest, TagTemplateField>newBuilder()
                .setMethodDescriptor(updateTagTemplateFieldMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<UpdateTagTemplateFieldRequest>() {
                      @Override
                      public Map<String, String> extract(UpdateTagTemplateFieldRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<RenameTagTemplateFieldRequest, TagTemplateField>
        renameTagTemplateFieldTransportSettings =
            GrpcCallSettings.<RenameTagTemplateFieldRequest, TagTemplateField>newBuilder()
                .setMethodDescriptor(renameTagTemplateFieldMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<RenameTagTemplateFieldRequest>() {
                      @Override
                      public Map<String, String> extract(RenameTagTemplateFieldRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteTagTemplateFieldRequest, Empty> deleteTagTemplateFieldTransportSettings =
        GrpcCallSettings.<DeleteTagTemplateFieldRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTagTemplateFieldMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteTagTemplateFieldRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteTagTemplateFieldRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateTagRequest, Tag> createTagTransportSettings =
        GrpcCallSettings.<CreateTagRequest, Tag>newBuilder()
            .setMethodDescriptor(createTagMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateTagRequest>() {
                  @Override
                  public Map<String, String> extract(CreateTagRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateTagRequest, Tag> updateTagTransportSettings =
        GrpcCallSettings.<UpdateTagRequest, Tag>newBuilder()
            .setMethodDescriptor(updateTagMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateTagRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateTagRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("tag.name", String.valueOf(request.getTag().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteTagRequest, Empty> deleteTagTransportSettings =
        GrpcCallSettings.<DeleteTagRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTagMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteTagRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteTagRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListTagsRequest, ListTagsResponse> listTagsTransportSettings =
        GrpcCallSettings.<ListTagsRequest, ListTagsResponse>newBuilder()
            .setMethodDescriptor(listTagsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListTagsRequest>() {
                  @Override
                  public Map<String, String> extract(ListTagsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(SetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(GetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<TestIamPermissionsRequest>() {
                      @Override
                      public Map<String, String> extract(TestIamPermissionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("resource", String.valueOf(request.getResource()));
                        return params.build();
                      }
                    })
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
    this.updateEntryGroupCallable =
        callableFactory.createUnaryCallable(
            updateEntryGroupTransportSettings, settings.updateEntryGroupSettings(), clientContext);
    this.getEntryGroupCallable =
        callableFactory.createUnaryCallable(
            getEntryGroupTransportSettings, settings.getEntryGroupSettings(), clientContext);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<SearchCatalogRequest, SearchCatalogResponse> searchCatalogCallable() {
    return searchCatalogCallable;
  }

  public UnaryCallable<SearchCatalogRequest, SearchCatalogPagedResponse>
      searchCatalogPagedCallable() {
    return searchCatalogPagedCallable;
  }

  public UnaryCallable<CreateEntryGroupRequest, EntryGroup> createEntryGroupCallable() {
    return createEntryGroupCallable;
  }

  public UnaryCallable<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupCallable() {
    return updateEntryGroupCallable;
  }

  public UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable() {
    return getEntryGroupCallable;
  }

  public UnaryCallable<DeleteEntryGroupRequest, Empty> deleteEntryGroupCallable() {
    return deleteEntryGroupCallable;
  }

  public UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse> listEntryGroupsCallable() {
    return listEntryGroupsCallable;
  }

  public UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsPagedResponse>
      listEntryGroupsPagedCallable() {
    return listEntryGroupsPagedCallable;
  }

  public UnaryCallable<CreateEntryRequest, Entry> createEntryCallable() {
    return createEntryCallable;
  }

  public UnaryCallable<UpdateEntryRequest, Entry> updateEntryCallable() {
    return updateEntryCallable;
  }

  public UnaryCallable<DeleteEntryRequest, Empty> deleteEntryCallable() {
    return deleteEntryCallable;
  }

  public UnaryCallable<GetEntryRequest, Entry> getEntryCallable() {
    return getEntryCallable;
  }

  public UnaryCallable<LookupEntryRequest, Entry> lookupEntryCallable() {
    return lookupEntryCallable;
  }

  public UnaryCallable<ListEntriesRequest, ListEntriesResponse> listEntriesCallable() {
    return listEntriesCallable;
  }

  public UnaryCallable<ListEntriesRequest, ListEntriesPagedResponse> listEntriesPagedCallable() {
    return listEntriesPagedCallable;
  }

  public UnaryCallable<CreateTagTemplateRequest, TagTemplate> createTagTemplateCallable() {
    return createTagTemplateCallable;
  }

  public UnaryCallable<GetTagTemplateRequest, TagTemplate> getTagTemplateCallable() {
    return getTagTemplateCallable;
  }

  public UnaryCallable<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateCallable() {
    return updateTagTemplateCallable;
  }

  public UnaryCallable<DeleteTagTemplateRequest, Empty> deleteTagTemplateCallable() {
    return deleteTagTemplateCallable;
  }

  public UnaryCallable<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldCallable() {
    return createTagTemplateFieldCallable;
  }

  public UnaryCallable<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldCallable() {
    return updateTagTemplateFieldCallable;
  }

  public UnaryCallable<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldCallable() {
    return renameTagTemplateFieldCallable;
  }

  public UnaryCallable<DeleteTagTemplateFieldRequest, Empty> deleteTagTemplateFieldCallable() {
    return deleteTagTemplateFieldCallable;
  }

  public UnaryCallable<CreateTagRequest, Tag> createTagCallable() {
    return createTagCallable;
  }

  public UnaryCallable<UpdateTagRequest, Tag> updateTagCallable() {
    return updateTagCallable;
  }

  public UnaryCallable<DeleteTagRequest, Empty> deleteTagCallable() {
    return deleteTagCallable;
  }

  public UnaryCallable<ListTagsRequest, ListTagsResponse> listTagsCallable() {
    return listTagsCallable;
  }

  public UnaryCallable<ListTagsRequest, ListTagsPagedResponse> listTagsPagedCallable() {
    return listTagsPagedCallable;
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
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
