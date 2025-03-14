/*
 * Copyright 2025 Google LLC
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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.cloud.datacatalog.v1.ImportEntriesMetadata;
import com.google.cloud.datacatalog.v1.ImportEntriesRequest;
import com.google.cloud.datacatalog.v1.ImportEntriesResponse;
import com.google.cloud.datacatalog.v1.ListEntriesRequest;
import com.google.cloud.datacatalog.v1.ListEntriesResponse;
import com.google.cloud.datacatalog.v1.ListEntryGroupsRequest;
import com.google.cloud.datacatalog.v1.ListEntryGroupsResponse;
import com.google.cloud.datacatalog.v1.ListTagsRequest;
import com.google.cloud.datacatalog.v1.ListTagsResponse;
import com.google.cloud.datacatalog.v1.LookupEntryRequest;
import com.google.cloud.datacatalog.v1.MigrationConfig;
import com.google.cloud.datacatalog.v1.ModifyEntryContactsRequest;
import com.google.cloud.datacatalog.v1.ModifyEntryOverviewRequest;
import com.google.cloud.datacatalog.v1.OrganizationConfig;
import com.google.cloud.datacatalog.v1.ReconcileTagsMetadata;
import com.google.cloud.datacatalog.v1.ReconcileTagsRequest;
import com.google.cloud.datacatalog.v1.ReconcileTagsResponse;
import com.google.cloud.datacatalog.v1.RenameTagTemplateFieldEnumValueRequest;
import com.google.cloud.datacatalog.v1.RenameTagTemplateFieldRequest;
import com.google.cloud.datacatalog.v1.RetrieveConfigRequest;
import com.google.cloud.datacatalog.v1.RetrieveEffectiveConfigRequest;
import com.google.cloud.datacatalog.v1.SearchCatalogRequest;
import com.google.cloud.datacatalog.v1.SearchCatalogResponse;
import com.google.cloud.datacatalog.v1.SetConfigRequest;
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
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataCatalog service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 *
 * @deprecated This class is deprecated and will be removed in the next major version update.
 */
@Deprecated
@Generated("by gapic-generator-java")
public abstract class DataCatalogStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  @Deprecated
  public UnaryCallable<SearchCatalogRequest, SearchCatalogPagedResponse>
      searchCatalogPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchCatalogPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<SearchCatalogRequest, SearchCatalogResponse> searchCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: searchCatalogCallable()");
  }

  @Deprecated
  public UnaryCallable<CreateEntryGroupRequest, EntryGroup> createEntryGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntryGroupCallable()");
  }

  @Deprecated
  public UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getEntryGroupCallable()");
  }

  @Deprecated
  public UnaryCallable<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEntryGroupCallable()");
  }

  @Deprecated
  public UnaryCallable<DeleteEntryGroupRequest, Empty> deleteEntryGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEntryGroupCallable()");
  }

  @Deprecated
  public UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsPagedResponse>
      listEntryGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntryGroupsPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse> listEntryGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntryGroupsCallable()");
  }

  @Deprecated
  public UnaryCallable<CreateEntryRequest, Entry> createEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntryCallable()");
  }

  @Deprecated
  public UnaryCallable<UpdateEntryRequest, Entry> updateEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEntryCallable()");
  }

  @Deprecated
  public UnaryCallable<DeleteEntryRequest, Empty> deleteEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEntryCallable()");
  }

  @Deprecated
  public UnaryCallable<GetEntryRequest, Entry> getEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: getEntryCallable()");
  }

  @Deprecated
  public UnaryCallable<LookupEntryRequest, Entry> lookupEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: lookupEntryCallable()");
  }

  @Deprecated
  public UnaryCallable<ListEntriesRequest, ListEntriesPagedResponse> listEntriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntriesPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<ListEntriesRequest, ListEntriesResponse> listEntriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntriesCallable()");
  }

  @Deprecated
  public UnaryCallable<ModifyEntryOverviewRequest, EntryOverview> modifyEntryOverviewCallable() {
    throw new UnsupportedOperationException("Not implemented: modifyEntryOverviewCallable()");
  }

  @Deprecated
  public UnaryCallable<ModifyEntryContactsRequest, Contacts> modifyEntryContactsCallable() {
    throw new UnsupportedOperationException("Not implemented: modifyEntryContactsCallable()");
  }

  @Deprecated
  public UnaryCallable<CreateTagTemplateRequest, TagTemplate> createTagTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: createTagTemplateCallable()");
  }

  @Deprecated
  public UnaryCallable<GetTagTemplateRequest, TagTemplate> getTagTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getTagTemplateCallable()");
  }

  @Deprecated
  public UnaryCallable<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTagTemplateCallable()");
  }

  @Deprecated
  public UnaryCallable<DeleteTagTemplateRequest, Empty> deleteTagTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTagTemplateCallable()");
  }

  @Deprecated
  public UnaryCallable<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: createTagTemplateFieldCallable()");
  }

  @Deprecated
  public UnaryCallable<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTagTemplateFieldCallable()");
  }

  @Deprecated
  public UnaryCallable<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: renameTagTemplateFieldCallable()");
  }

  @Deprecated
  public UnaryCallable<RenameTagTemplateFieldEnumValueRequest, TagTemplateField>
      renameTagTemplateFieldEnumValueCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: renameTagTemplateFieldEnumValueCallable()");
  }

  @Deprecated
  public UnaryCallable<DeleteTagTemplateFieldRequest, Empty> deleteTagTemplateFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTagTemplateFieldCallable()");
  }

  @Deprecated
  public UnaryCallable<CreateTagRequest, Tag> createTagCallable() {
    throw new UnsupportedOperationException("Not implemented: createTagCallable()");
  }

  @Deprecated
  public UnaryCallable<UpdateTagRequest, Tag> updateTagCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTagCallable()");
  }

  @Deprecated
  public UnaryCallable<DeleteTagRequest, Empty> deleteTagCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTagCallable()");
  }

  @Deprecated
  public UnaryCallable<ListTagsRequest, ListTagsPagedResponse> listTagsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTagsPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<ListTagsRequest, ListTagsResponse> listTagsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTagsCallable()");
  }

  @Deprecated
  public OperationCallable<ReconcileTagsRequest, ReconcileTagsResponse, ReconcileTagsMetadata>
      reconcileTagsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: reconcileTagsOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<ReconcileTagsRequest, Operation> reconcileTagsCallable() {
    throw new UnsupportedOperationException("Not implemented: reconcileTagsCallable()");
  }

  @Deprecated
  public UnaryCallable<StarEntryRequest, StarEntryResponse> starEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: starEntryCallable()");
  }

  @Deprecated
  public UnaryCallable<UnstarEntryRequest, UnstarEntryResponse> unstarEntryCallable() {
    throw new UnsupportedOperationException("Not implemented: unstarEntryCallable()");
  }

  @Deprecated
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  @Deprecated
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  @Deprecated
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Deprecated
  public OperationCallable<ImportEntriesRequest, ImportEntriesResponse, ImportEntriesMetadata>
      importEntriesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importEntriesOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<ImportEntriesRequest, Operation> importEntriesCallable() {
    throw new UnsupportedOperationException("Not implemented: importEntriesCallable()");
  }

  @Deprecated
  public UnaryCallable<SetConfigRequest, MigrationConfig> setConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: setConfigCallable()");
  }

  @Deprecated
  public UnaryCallable<RetrieveConfigRequest, OrganizationConfig> retrieveConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: retrieveConfigCallable()");
  }

  @Deprecated
  public UnaryCallable<RetrieveEffectiveConfigRequest, MigrationConfig>
      retrieveEffectiveConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: retrieveEffectiveConfigCallable()");
  }

  @Override
  public abstract void close();
}
