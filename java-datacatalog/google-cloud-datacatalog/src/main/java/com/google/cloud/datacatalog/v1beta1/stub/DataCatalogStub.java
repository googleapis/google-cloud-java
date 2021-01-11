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

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
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
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataCatalog service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DataCatalogStub implements BackgroundResource {

  public UnaryCallable<SearchCatalogRequest, SearchCatalogPagedResponse>
      searchCatalogPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchCatalogPagedCallable()");
  }

  public UnaryCallable<SearchCatalogRequest, SearchCatalogResponse> searchCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: searchCatalogCallable()");
  }

  public UnaryCallable<CreateEntryGroupRequest, EntryGroup> createEntryGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntryGroupCallable()");
  }

  public UnaryCallable<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEntryGroupCallable()");
  }

  public UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getEntryGroupCallable()");
  }

  public UnaryCallable<DeleteEntryGroupRequest, Empty> deleteEntryGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEntryGroupCallable()");
  }

  public UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsPagedResponse>
      listEntryGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntryGroupsPagedCallable()");
  }

  public UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse> listEntryGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntryGroupsCallable()");
  }

  public UnaryCallable<CreateEntryRequest, Entry> createEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntryCallable()");
  }

  public UnaryCallable<UpdateEntryRequest, Entry> updateEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEntryCallable()");
  }

  public UnaryCallable<DeleteEntryRequest, Empty> deleteEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEntryCallable()");
  }

  public UnaryCallable<GetEntryRequest, Entry> getEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: getEntryCallable()");
  }

  public UnaryCallable<LookupEntryRequest, Entry> lookupEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: lookupEntryCallable()");
  }

  public UnaryCallable<ListEntriesRequest, ListEntriesPagedResponse> listEntriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntriesPagedCallable()");
  }

  public UnaryCallable<ListEntriesRequest, ListEntriesResponse> listEntriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntriesCallable()");
  }

  public UnaryCallable<CreateTagTemplateRequest, TagTemplate> createTagTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: createTagTemplateCallable()");
  }

  public UnaryCallable<GetTagTemplateRequest, TagTemplate> getTagTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getTagTemplateCallable()");
  }

  public UnaryCallable<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTagTemplateCallable()");
  }

  public UnaryCallable<DeleteTagTemplateRequest, Empty> deleteTagTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTagTemplateCallable()");
  }

  public UnaryCallable<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: createTagTemplateFieldCallable()");
  }

  public UnaryCallable<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTagTemplateFieldCallable()");
  }

  public UnaryCallable<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: renameTagTemplateFieldCallable()");
  }

  public UnaryCallable<DeleteTagTemplateFieldRequest, Empty> deleteTagTemplateFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTagTemplateFieldCallable()");
  }

  public UnaryCallable<CreateTagRequest, Tag> createTagCallable() {
    throw new UnsupportedOperationException("Not implemented: createTagCallable()");
  }

  public UnaryCallable<UpdateTagRequest, Tag> updateTagCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTagCallable()");
  }

  public UnaryCallable<DeleteTagRequest, Empty> deleteTagCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTagCallable()");
  }

  public UnaryCallable<ListTagsRequest, ListTagsPagedResponse> listTagsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTagsPagedCallable()");
  }

  public UnaryCallable<ListTagsRequest, ListTagsResponse> listTagsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTagsCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
