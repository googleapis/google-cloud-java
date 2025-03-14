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

package com.google.cloud.datacatalog.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.datacatalog.v1beta1.stub.DataCatalogStub;
import com.google.cloud.datacatalog.v1beta1.stub.DataCatalogStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Deprecated: Please use Dataplex Catalog instead.
 *
 * <p>Data Catalog API service allows clients to discover, understand, and manage their data.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   String entryGroupId = "entryGroupId1228924712";
 *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
 *   EntryGroup response = dataCatalogClient.createEntryGroup(parent, entryGroupId, entryGroup);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataCatalogClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> SearchCatalog</td>
 *      <td><p> Searches Data Catalog for multiple resources like entries, tags that match a query.
 * <p>  This is a custom method (https://cloud.google.com/apis/design/custom_methods) and does not return the complete resource, only the resource identifier and high level fields. Clients can subsequently call `Get` methods.
 * <p>  Note that Data Catalog search queries do not guarantee full recall. Query results that match your query may not be returned, even in subsequent result pages. Also note that results returned (and not returned) can vary across repeated search queries.
 * <p>  See [Data Catalog Search Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference) for more information.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchCatalog(SearchCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchCatalog(SearchCatalogRequest.Scope scope, String query)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchCatalogPagedCallable()
 *           <li><p> searchCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEntryGroup</td>
 *      <td><p> A maximum of 10,000 entry groups may be created per organization across all locations.
 * <p>  Users should enable the Data Catalog API in the project identified by the `parent` parameter (see [Data Catalog Resource Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEntryGroup(CreateEntryGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createEntryGroup(LocationName parent, String entryGroupId, EntryGroup entryGroup)
 *           <li><p> createEntryGroup(String parent, String entryGroupId, EntryGroup entryGroup)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEntryGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEntryGroup</td>
 *      <td><p> Updates an EntryGroup. The user should enable the Data Catalog API in the project identified by the `entry_group.name` parameter (see [Data Catalog Resource Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEntryGroup(UpdateEntryGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateEntryGroup(EntryGroup entryGroup)
 *           <li><p> updateEntryGroup(EntryGroup entryGroup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEntryGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEntryGroup</td>
 *      <td><p> Gets an EntryGroup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEntryGroup(GetEntryGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEntryGroup(EntryGroupName name)
 *           <li><p> getEntryGroup(String name)
 *           <li><p> getEntryGroup(EntryGroupName name, FieldMask readMask)
 *           <li><p> getEntryGroup(String name, FieldMask readMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEntryGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEntryGroup</td>
 *      <td><p> Deletes an EntryGroup. Only entry groups that do not contain entries can be deleted. Users should enable the Data Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEntryGroup(DeleteEntryGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteEntryGroup(EntryGroupName name)
 *           <li><p> deleteEntryGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEntryGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEntryGroups</td>
 *      <td><p> Lists entry groups.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEntryGroups(ListEntryGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEntryGroups(LocationName parent)
 *           <li><p> listEntryGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEntryGroupsPagedCallable()
 *           <li><p> listEntryGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEntry</td>
 *      <td><p> Creates an entry. Only entries of 'FILESET' type or user-specified type can be created.
 * <p>  Users should enable the Data Catalog API in the project identified by the `parent` parameter (see [Data Catalog Resource Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
 * <p>  A maximum of 100,000 entries may be created per entry group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEntry(CreateEntryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createEntry(EntryGroupName parent, String entryId, Entry entry)
 *           <li><p> createEntry(String parent, String entryId, Entry entry)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEntry</td>
 *      <td><p> Updates an existing entry. Users should enable the Data Catalog API in the project identified by the `entry.name` parameter (see [Data Catalog Resource Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEntry(UpdateEntryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateEntry(Entry entry)
 *           <li><p> updateEntry(Entry entry, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEntry</td>
 *      <td><p> Deletes an existing entry. Only entries created through [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry] method can be deleted. Users should enable the Data Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEntry(DeleteEntryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteEntry(EntryName name)
 *           <li><p> deleteEntry(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEntry</td>
 *      <td><p> Gets an entry.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEntry(GetEntryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEntry(EntryName name)
 *           <li><p> getEntry(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> LookupEntry</td>
 *      <td><p> Get an entry by target resource name. This method allows clients to use the resource name from the source Google Cloud Platform service to get the Data Catalog Entry.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> lookupEntry(LookupEntryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> lookupEntryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEntries</td>
 *      <td><p> Lists entries.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEntries(ListEntriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEntries(EntryGroupName parent)
 *           <li><p> listEntries(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEntriesPagedCallable()
 *           <li><p> listEntriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTagTemplate</td>
 *      <td><p> Creates a tag template. The user should enable the Data Catalog API in the project identified by the `parent` parameter (see [Data Catalog Resource Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTagTemplate(CreateTagTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTagTemplate(LocationName parent, String tagTemplateId, TagTemplate tagTemplate)
 *           <li><p> createTagTemplate(String parent, String tagTemplateId, TagTemplate tagTemplate)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTagTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTagTemplate</td>
 *      <td><p> Gets a tag template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTagTemplate(GetTagTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTagTemplate(TagTemplateName name)
 *           <li><p> getTagTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTagTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTagTemplate</td>
 *      <td><p> Updates a tag template. This method cannot be used to update the fields of a template. The tag template fields are represented as separate resources and should be updated using their own create/update/delete methods. Users should enable the Data Catalog API in the project identified by the `tag_template.name` parameter (see [Data Catalog Resource Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTagTemplate(UpdateTagTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTagTemplate(TagTemplate tagTemplate)
 *           <li><p> updateTagTemplate(TagTemplate tagTemplate, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTagTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTagTemplate</td>
 *      <td><p> Deletes a tag template and all tags using the template. Users should enable the Data Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTagTemplate(DeleteTagTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTagTemplate(TagTemplateName name, boolean force)
 *           <li><p> deleteTagTemplate(String name, boolean force)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTagTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTagTemplateField</td>
 *      <td><p> Creates a field in a tag template. The user should enable the Data Catalog API in the project identified by the `parent` parameter (see [Data Catalog Resource Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTagTemplateField(CreateTagTemplateFieldRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTagTemplateField(TagTemplateName parent, String tagTemplateFieldId, TagTemplateField tagTemplateField)
 *           <li><p> createTagTemplateField(String parent, String tagTemplateFieldId, TagTemplateField tagTemplateField)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTagTemplateFieldCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTagTemplateField</td>
 *      <td><p> Updates a field in a tag template. This method cannot be used to update the field type. Users should enable the Data Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTagTemplateField(UpdateTagTemplateFieldRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTagTemplateField(TagTemplateFieldName name, TagTemplateField tagTemplateField)
 *           <li><p> updateTagTemplateField(String name, TagTemplateField tagTemplateField)
 *           <li><p> updateTagTemplateField(TagTemplateFieldName name, TagTemplateField tagTemplateField, FieldMask updateMask)
 *           <li><p> updateTagTemplateField(String name, TagTemplateField tagTemplateField, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTagTemplateFieldCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RenameTagTemplateField</td>
 *      <td><p> Renames a field in a tag template. The user should enable the Data Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> renameTagTemplateField(RenameTagTemplateFieldRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> renameTagTemplateField(TagTemplateFieldName name, String newTagTemplateFieldId)
 *           <li><p> renameTagTemplateField(String name, String newTagTemplateFieldId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> renameTagTemplateFieldCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RenameTagTemplateFieldEnumValue</td>
 *      <td><p> Renames an enum value in a tag template. The enum values have to be unique within one enum field. Thus, an enum value cannot be renamed with a name used in any other enum value within the same enum field.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> renameTagTemplateFieldEnumValue(RenameTagTemplateFieldEnumValueRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> renameTagTemplateFieldEnumValue(TagTemplateFieldEnumValueName name, String newEnumValueDisplayName)
 *           <li><p> renameTagTemplateFieldEnumValue(String name, String newEnumValueDisplayName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> renameTagTemplateFieldEnumValueCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTagTemplateField</td>
 *      <td><p> Deletes a field in a tag template and all uses of that field. Users should enable the Data Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTagTemplateField(DeleteTagTemplateFieldRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTagTemplateField(TagTemplateFieldName name, boolean force)
 *           <li><p> deleteTagTemplateField(String name, boolean force)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTagTemplateFieldCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTag</td>
 *      <td><p> Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry]. Note: The project identified by the `parent` parameter for the [tag](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters) and the [tag template](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters) used to create the tag must be from the same organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTag(CreateTagRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTag(EntryName parent, Tag tag)
 *           <li><p> createTag(String parent, Tag tag)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTagCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTag</td>
 *      <td><p> Updates an existing tag.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTag(UpdateTagRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTag(Tag tag)
 *           <li><p> updateTag(Tag tag, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTagCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTag</td>
 *      <td><p> Deletes a tag.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTag(DeleteTagRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTag(EntryName name)
 *           <li><p> deleteTag(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTagCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTags</td>
 *      <td><p> Lists tags assigned to an [Entry][google.cloud.datacatalog.v1beta1.Entry]. The [columns][google.cloud.datacatalog.v1beta1.Tag.column] in the response are lowercased.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTags(ListTagsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTags(EntryName parent)
 *           <li><p> listTags(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTagsPagedCallable()
 *           <li><p> listTagsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy for a resource. Replaces any existing policy. Supported resources are:   - Tag templates.   - Entries.   - Entry groups. Note, this method cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform resources synced to Data Catalog.
 * <p>  Callers must have following Google IAM permission   - `datacatalog.tagTemplates.setIamPolicy` to set policies on tag     templates.   - `datacatalog.entries.setIamPolicy` to set policies on entries.   - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setIamPolicy(ResourceName resource, Policy policy)
 *           <li><p> setIamPolicy(String resource, Policy policy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. A `NOT_FOUND` error is returned if the resource does not exist. An empty policy is returned if the resource exists but does not have a policy set on it.
 * <p>  Supported resources are:   - Tag templates.   - Entries.   - Entry groups. Note, this method cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform resources synced to Data Catalog.
 * <p>  Callers must have following Google IAM permission   - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag     templates.   - `datacatalog.entries.getIamPolicy` to get policies on entries.   - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIamPolicy(ResourceName resource)
 *           <li><p> getIamPolicy(String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns the caller's permissions on a resource. If the resource does not exist, an empty set of permissions is returned (We don't return a `NOT_FOUND` error).
 * <p>  Supported resources are:   - Tag templates.   - Entries.   - Entry groups. Note, this method cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform resources synced to Data Catalog.
 * <p>  A caller is not required to have Google IAM permission to make this request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of DataCatalogSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataCatalogSettings dataCatalogSettings =
 *     DataCatalogSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataCatalogClient dataCatalogClient = DataCatalogClient.create(dataCatalogSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataCatalogSettings dataCatalogSettings =
 *     DataCatalogSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataCatalogClient dataCatalogClient = DataCatalogClient.create(dataCatalogSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataCatalogSettings dataCatalogSettings = DataCatalogSettings.newHttpJsonBuilder().build();
 * DataCatalogClient dataCatalogClient = DataCatalogClient.create(dataCatalogSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 *
 * @deprecated This class is deprecated and will be removed in the next major version update.
 */
@BetaApi
@Deprecated
@Generated("by gapic-generator-java")
public class DataCatalogClient implements BackgroundResource {
  private final DataCatalogSettings settings;
  private final DataCatalogStub stub;

  /** Constructs an instance of DataCatalogClient with default settings. */
  public static final DataCatalogClient create() throws IOException {
    return create(DataCatalogSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataCatalogClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataCatalogClient create(DataCatalogSettings settings) throws IOException {
    return new DataCatalogClient(settings);
  }

  /**
   * Constructs an instance of DataCatalogClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(DataCatalogSettings).
   */
  public static final DataCatalogClient create(DataCatalogStub stub) {
    return new DataCatalogClient(stub);
  }

  /**
   * Constructs an instance of DataCatalogClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DataCatalogClient(DataCatalogSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataCatalogStubSettings) settings.getStubSettings()).createStub();
  }

  protected DataCatalogClient(DataCatalogStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DataCatalogSettings getSettings() {
    return settings;
  }

  public DataCatalogStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Data Catalog for multiple resources like entries, tags that match a query.
   *
   * <p>This is a custom method (https://cloud.google.com/apis/design/custom_methods) and does not
   * return the complete resource, only the resource identifier and high level fields. Clients can
   * subsequently call `Get` methods.
   *
   * <p>Note that Data Catalog search queries do not guarantee full recall. Query results that match
   * your query may not be returned, even in subsequent result pages. Also note that results
   * returned (and not returned) can vary across repeated search queries.
   *
   * <p>See [Data Catalog Search
   * Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference) for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SearchCatalogRequest.Scope scope = SearchCatalogRequest.Scope.newBuilder().build();
   *   String query = "query107944136";
   *   for (SearchCatalogResult element :
   *       dataCatalogClient.searchCatalog(scope, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param scope Required. The scope of this search request. A `scope` that has empty
   *     `include_org_ids`, `include_project_ids` AND false `include_gcp_public_datasets` is
   *     considered invalid. Data Catalog will return an error in such a case.
   * @param query Optional. The query string in search query syntax. An empty query string will
   *     result in all data assets (in the specified scope) that the user has access to. Query
   *     strings can be simple as "x" or more qualified as:
   *     <ul>
   *       <li>name:x
   *       <li>column:x
   *       <li>description:y
   *     </ul>
   *     <p>Note: Query tokens need to have a minimum of 3 characters for substring matching to work
   *     correctly. See [Data Catalog Search
   *     Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference) for more
   *     information.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final SearchCatalogPagedResponse searchCatalog(
      SearchCatalogRequest.Scope scope, String query) {
    SearchCatalogRequest request =
        SearchCatalogRequest.newBuilder().setScope(scope).setQuery(query).build();
    return searchCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Data Catalog for multiple resources like entries, tags that match a query.
   *
   * <p>This is a custom method (https://cloud.google.com/apis/design/custom_methods) and does not
   * return the complete resource, only the resource identifier and high level fields. Clients can
   * subsequently call `Get` methods.
   *
   * <p>Note that Data Catalog search queries do not guarantee full recall. Query results that match
   * your query may not be returned, even in subsequent result pages. Also note that results
   * returned (and not returned) can vary across repeated search queries.
   *
   * <p>See [Data Catalog Search
   * Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference) for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SearchCatalogRequest request =
   *       SearchCatalogRequest.newBuilder()
   *           .setScope(SearchCatalogRequest.Scope.newBuilder().build())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (SearchCatalogResult element : dataCatalogClient.searchCatalog(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final SearchCatalogPagedResponse searchCatalog(SearchCatalogRequest request) {
    return searchCatalogPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Data Catalog for multiple resources like entries, tags that match a query.
   *
   * <p>This is a custom method (https://cloud.google.com/apis/design/custom_methods) and does not
   * return the complete resource, only the resource identifier and high level fields. Clients can
   * subsequently call `Get` methods.
   *
   * <p>Note that Data Catalog search queries do not guarantee full recall. Query results that match
   * your query may not be returned, even in subsequent result pages. Also note that results
   * returned (and not returned) can vary across repeated search queries.
   *
   * <p>See [Data Catalog Search
   * Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference) for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SearchCatalogRequest request =
   *       SearchCatalogRequest.newBuilder()
   *           .setScope(SearchCatalogRequest.Scope.newBuilder().build())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<SearchCatalogResult> future =
   *       dataCatalogClient.searchCatalogPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchCatalogResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<SearchCatalogRequest, SearchCatalogPagedResponse>
      searchCatalogPagedCallable() {
    return stub.searchCatalogPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Data Catalog for multiple resources like entries, tags that match a query.
   *
   * <p>This is a custom method (https://cloud.google.com/apis/design/custom_methods) and does not
   * return the complete resource, only the resource identifier and high level fields. Clients can
   * subsequently call `Get` methods.
   *
   * <p>Note that Data Catalog search queries do not guarantee full recall. Query results that match
   * your query may not be returned, even in subsequent result pages. Also note that results
   * returned (and not returned) can vary across repeated search queries.
   *
   * <p>See [Data Catalog Search
   * Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference) for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SearchCatalogRequest request =
   *       SearchCatalogRequest.newBuilder()
   *           .setScope(SearchCatalogRequest.Scope.newBuilder().build())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     SearchCatalogResponse response = dataCatalogClient.searchCatalogCallable().call(request);
   *     for (SearchCatalogResult element : response.getResultsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<SearchCatalogRequest, SearchCatalogResponse> searchCatalogCallable() {
    return stub.searchCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A maximum of 10,000 entry groups may be created per organization across all locations.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String entryGroupId = "entryGroupId1228924712";
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.createEntryGroup(parent, entryGroupId, entryGroup);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project this entry group is in. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}
   *     </ul>
   *     <p>Note that this EntryGroup and its child resources may not actually be stored in the
   *     location in this name.
   * @param entryGroupId Required. The id of the entry group to create. The id must begin with a
   *     letter or underscore, contain only English letters, numbers and underscores, and be at most
   *     64 characters.
   * @param entryGroup The entry group to create. Defaults to an empty entry group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final EntryGroup createEntryGroup(
      LocationName parent, String entryGroupId, EntryGroup entryGroup) {
    CreateEntryGroupRequest request =
        CreateEntryGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEntryGroupId(entryGroupId)
            .setEntryGroup(entryGroup)
            .build();
    return createEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A maximum of 10,000 entry groups may be created per organization across all locations.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String entryGroupId = "entryGroupId1228924712";
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.createEntryGroup(parent, entryGroupId, entryGroup);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project this entry group is in. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}
   *     </ul>
   *     <p>Note that this EntryGroup and its child resources may not actually be stored in the
   *     location in this name.
   * @param entryGroupId Required. The id of the entry group to create. The id must begin with a
   *     letter or underscore, contain only English letters, numbers and underscores, and be at most
   *     64 characters.
   * @param entryGroup The entry group to create. Defaults to an empty entry group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final EntryGroup createEntryGroup(
      String parent, String entryGroupId, EntryGroup entryGroup) {
    CreateEntryGroupRequest request =
        CreateEntryGroupRequest.newBuilder()
            .setParent(parent)
            .setEntryGroupId(entryGroupId)
            .setEntryGroup(entryGroup)
            .build();
    return createEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A maximum of 10,000 entry groups may be created per organization across all locations.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateEntryGroupRequest request =
   *       CreateEntryGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEntryGroupId("entryGroupId1228924712")
   *           .setEntryGroup(EntryGroup.newBuilder().build())
   *           .build();
   *   EntryGroup response = dataCatalogClient.createEntryGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final EntryGroup createEntryGroup(CreateEntryGroupRequest request) {
    return createEntryGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A maximum of 10,000 entry groups may be created per organization across all locations.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateEntryGroupRequest request =
   *       CreateEntryGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEntryGroupId("entryGroupId1228924712")
   *           .setEntryGroup(EntryGroup.newBuilder().build())
   *           .build();
   *   ApiFuture<EntryGroup> future =
   *       dataCatalogClient.createEntryGroupCallable().futureCall(request);
   *   // Do something.
   *   EntryGroup response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<CreateEntryGroupRequest, EntryGroup> createEntryGroupCallable() {
    return stub.createEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an EntryGroup. The user should enable the Data Catalog API in the project identified by
   * the `entry_group.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.updateEntryGroup(entryGroup);
   * }
   * }</pre>
   *
   * @param entryGroup Required. The updated entry group. "name" field must be set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final EntryGroup updateEntryGroup(EntryGroup entryGroup) {
    UpdateEntryGroupRequest request =
        UpdateEntryGroupRequest.newBuilder().setEntryGroup(entryGroup).build();
    return updateEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an EntryGroup. The user should enable the Data Catalog API in the project identified by
   * the `entry_group.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.updateEntryGroup(entryGroup, updateMask);
   * }
   * }</pre>
   *
   * @param entryGroup Required. The updated entry group. "name" field must be set.
   * @param updateMask Names of fields whose values to overwrite on an entry group.
   *     <p>If this parameter is absent or empty, all modifiable fields are overwritten. If such
   *     fields are non-required and omitted in the request body, their values are emptied.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final EntryGroup updateEntryGroup(EntryGroup entryGroup, FieldMask updateMask) {
    UpdateEntryGroupRequest request =
        UpdateEntryGroupRequest.newBuilder()
            .setEntryGroup(entryGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an EntryGroup. The user should enable the Data Catalog API in the project identified by
   * the `entry_group.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateEntryGroupRequest request =
   *       UpdateEntryGroupRequest.newBuilder()
   *           .setEntryGroup(EntryGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   EntryGroup response = dataCatalogClient.updateEntryGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final EntryGroup updateEntryGroup(UpdateEntryGroupRequest request) {
    return updateEntryGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an EntryGroup. The user should enable the Data Catalog API in the project identified by
   * the `entry_group.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateEntryGroupRequest request =
   *       UpdateEntryGroupRequest.newBuilder()
   *           .setEntryGroup(EntryGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<EntryGroup> future =
   *       dataCatalogClient.updateEntryGroupCallable().futureCall(request);
   *   // Do something.
   *   EntryGroup response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupCallable() {
    return stub.updateEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   EntryGroup response = dataCatalogClient.getEntryGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group. For example,
   *     `projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final EntryGroup getEntryGroup(EntryGroupName name) {
    GetEntryGroupRequest request =
        GetEntryGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   EntryGroup response = dataCatalogClient.getEntryGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group. For example,
   *     `projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final EntryGroup getEntryGroup(String name) {
    GetEntryGroupRequest request = GetEntryGroupRequest.newBuilder().setName(name).build();
    return getEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   FieldMask readMask = FieldMask.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.getEntryGroup(name, readMask);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group. For example,
   *     `projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}`.
   * @param readMask The fields to return. If not set or empty, all fields are returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final EntryGroup getEntryGroup(EntryGroupName name, FieldMask readMask) {
    GetEntryGroupRequest request =
        GetEntryGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setReadMask(readMask)
            .build();
    return getEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   FieldMask readMask = FieldMask.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.getEntryGroup(name, readMask);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group. For example,
   *     `projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}`.
   * @param readMask The fields to return. If not set or empty, all fields are returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final EntryGroup getEntryGroup(String name, FieldMask readMask) {
    GetEntryGroupRequest request =
        GetEntryGroupRequest.newBuilder().setName(name).setReadMask(readMask).build();
    return getEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetEntryGroupRequest request =
   *       GetEntryGroupRequest.newBuilder()
   *           .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   EntryGroup response = dataCatalogClient.getEntryGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final EntryGroup getEntryGroup(GetEntryGroupRequest request) {
    return getEntryGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetEntryGroupRequest request =
   *       GetEntryGroupRequest.newBuilder()
   *           .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<EntryGroup> future = dataCatalogClient.getEntryGroupCallable().futureCall(request);
   *   // Do something.
   *   EntryGroup response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable() {
    return stub.getEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an EntryGroup. Only entry groups that do not contain entries can be deleted. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   dataCatalogClient.deleteEntryGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group. For example,
   *     `projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteEntryGroup(EntryGroupName name) {
    DeleteEntryGroupRequest request =
        DeleteEntryGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an EntryGroup. Only entry groups that do not contain entries can be deleted. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   dataCatalogClient.deleteEntryGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group. For example,
   *     `projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteEntryGroup(String name) {
    DeleteEntryGroupRequest request = DeleteEntryGroupRequest.newBuilder().setName(name).build();
    deleteEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an EntryGroup. Only entry groups that do not contain entries can be deleted. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteEntryGroupRequest request =
   *       DeleteEntryGroupRequest.newBuilder()
   *           .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setForce(true)
   *           .build();
   *   dataCatalogClient.deleteEntryGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteEntryGroup(DeleteEntryGroupRequest request) {
    deleteEntryGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an EntryGroup. Only entry groups that do not contain entries can be deleted. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteEntryGroupRequest request =
   *       DeleteEntryGroupRequest.newBuilder()
   *           .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = dataCatalogClient.deleteEntryGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<DeleteEntryGroupRequest, Empty> deleteEntryGroupCallable() {
    return stub.deleteEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (EntryGroup element : dataCatalogClient.listEntryGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the location that contains the entry groups, which can be
   *     provided in URL format. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final ListEntryGroupsPagedResponse listEntryGroups(LocationName parent) {
    ListEntryGroupsRequest request =
        ListEntryGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEntryGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (EntryGroup element : dataCatalogClient.listEntryGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the location that contains the entry groups, which can be
   *     provided in URL format. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final ListEntryGroupsPagedResponse listEntryGroups(String parent) {
    ListEntryGroupsRequest request = ListEntryGroupsRequest.newBuilder().setParent(parent).build();
    return listEntryGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListEntryGroupsRequest request =
   *       ListEntryGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (EntryGroup element : dataCatalogClient.listEntryGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final ListEntryGroupsPagedResponse listEntryGroups(ListEntryGroupsRequest request) {
    return listEntryGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListEntryGroupsRequest request =
   *       ListEntryGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<EntryGroup> future =
   *       dataCatalogClient.listEntryGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EntryGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsPagedResponse>
      listEntryGroupsPagedCallable() {
    return stub.listEntryGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListEntryGroupsRequest request =
   *       ListEntryGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEntryGroupsResponse response =
   *         dataCatalogClient.listEntryGroupsCallable().call(request);
   *     for (EntryGroup element : response.getEntryGroupsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse>
      listEntryGroupsCallable() {
    return stub.listEntryGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entry. Only entries of 'FILESET' type or user-specified type can be created.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>A maximum of 100,000 entries may be created per entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   String entryId = "entryId-1591558867";
   *   Entry entry = Entry.newBuilder().build();
   *   Entry response = dataCatalogClient.createEntry(parent, entryId, entry);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the entry group this entry is in. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}
   *     </ul>
   *     <p>Note that this Entry and its child resources may not actually be stored in the location
   *     in this name.
   * @param entryId Required. The id of the entry to create.
   * @param entry Required. The entry to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Entry createEntry(EntryGroupName parent, String entryId, Entry entry) {
    CreateEntryRequest request =
        CreateEntryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEntryId(entryId)
            .setEntry(entry)
            .build();
    return createEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entry. Only entries of 'FILESET' type or user-specified type can be created.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>A maximum of 100,000 entries may be created per entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   String entryId = "entryId-1591558867";
   *   Entry entry = Entry.newBuilder().build();
   *   Entry response = dataCatalogClient.createEntry(parent, entryId, entry);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the entry group this entry is in. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}
   *     </ul>
   *     <p>Note that this Entry and its child resources may not actually be stored in the location
   *     in this name.
   * @param entryId Required. The id of the entry to create.
   * @param entry Required. The entry to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Entry createEntry(String parent, String entryId, Entry entry) {
    CreateEntryRequest request =
        CreateEntryRequest.newBuilder()
            .setParent(parent)
            .setEntryId(entryId)
            .setEntry(entry)
            .build();
    return createEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entry. Only entries of 'FILESET' type or user-specified type can be created.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>A maximum of 100,000 entries may be created per entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateEntryRequest request =
   *       CreateEntryRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setEntryId("entryId-1591558867")
   *           .setEntry(Entry.newBuilder().build())
   *           .build();
   *   Entry response = dataCatalogClient.createEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Entry createEntry(CreateEntryRequest request) {
    return createEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entry. Only entries of 'FILESET' type or user-specified type can be created.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>A maximum of 100,000 entries may be created per entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateEntryRequest request =
   *       CreateEntryRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setEntryId("entryId-1591558867")
   *           .setEntry(Entry.newBuilder().build())
   *           .build();
   *   ApiFuture<Entry> future = dataCatalogClient.createEntryCallable().futureCall(request);
   *   // Do something.
   *   Entry response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<CreateEntryRequest, Entry> createEntryCallable() {
    return stub.createEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing entry. Users should enable the Data Catalog API in the project identified
   * by the `entry.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Entry entry = Entry.newBuilder().build();
   *   Entry response = dataCatalogClient.updateEntry(entry);
   * }
   * }</pre>
   *
   * @param entry Required. The updated entry. The "name" field must be set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Entry updateEntry(Entry entry) {
    UpdateEntryRequest request = UpdateEntryRequest.newBuilder().setEntry(entry).build();
    return updateEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing entry. Users should enable the Data Catalog API in the project identified
   * by the `entry.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Entry entry = Entry.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Entry response = dataCatalogClient.updateEntry(entry, updateMask);
   * }
   * }</pre>
   *
   * @param entry Required. The updated entry. The "name" field must be set.
   * @param updateMask Names of fields whose values to overwrite on an entry.
   *     <p>If this parameter is absent or empty, all modifiable fields are overwritten. If such
   *     fields are non-required and omitted in the request body, their values are emptied.
   *     <p>The following fields are modifiable:
   *     <ul>
   *       <li>For entries with type `DATA_STREAM`: &#42; `schema`
   *       <li>For entries with type `FILESET`: &#42; `schema` &#42; `display_name` &#42;
   *           `description` &#42; `gcs_fileset_spec` &#42; `gcs_fileset_spec.file_patterns`
   *       <li>For entries with `user_specified_type`: &#42; `schema` &#42; `display_name` &#42;
   *           `description` &#42; `user_specified_type` &#42; `user_specified_system` &#42;
   *           `linked_resource` &#42; `source_system_timestamps`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Entry updateEntry(Entry entry, FieldMask updateMask) {
    UpdateEntryRequest request =
        UpdateEntryRequest.newBuilder().setEntry(entry).setUpdateMask(updateMask).build();
    return updateEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing entry. Users should enable the Data Catalog API in the project identified
   * by the `entry.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateEntryRequest request =
   *       UpdateEntryRequest.newBuilder()
   *           .setEntry(Entry.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Entry response = dataCatalogClient.updateEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Entry updateEntry(UpdateEntryRequest request) {
    return updateEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing entry. Users should enable the Data Catalog API in the project identified
   * by the `entry.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateEntryRequest request =
   *       UpdateEntryRequest.newBuilder()
   *           .setEntry(Entry.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Entry> future = dataCatalogClient.updateEntryCallable().futureCall(request);
   *   // Do something.
   *   Entry response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<UpdateEntryRequest, Entry> updateEntryCallable() {
    return stub.updateEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing entry. Only entries created through
   * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry] method can be deleted.
   * Users should enable the Data Catalog API in the project identified by the `name` parameter (see
   * [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   dataCatalogClient.deleteEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteEntry(EntryName name) {
    DeleteEntryRequest request =
        DeleteEntryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing entry. Only entries created through
   * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry] method can be deleted.
   * Users should enable the Data Catalog API in the project identified by the `name` parameter (see
   * [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   dataCatalogClient.deleteEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteEntry(String name) {
    DeleteEntryRequest request = DeleteEntryRequest.newBuilder().setName(name).build();
    deleteEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing entry. Only entries created through
   * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry] method can be deleted.
   * Users should enable the Data Catalog API in the project identified by the `name` parameter (see
   * [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteEntryRequest request =
   *       DeleteEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   dataCatalogClient.deleteEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteEntry(DeleteEntryRequest request) {
    deleteEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing entry. Only entries created through
   * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry] method can be deleted.
   * Users should enable the Data Catalog API in the project identified by the `name` parameter (see
   * [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteEntryRequest request =
   *       DeleteEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   ApiFuture<Empty> future = dataCatalogClient.deleteEntryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<DeleteEntryRequest, Empty> deleteEntryCallable() {
    return stub.deleteEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   Entry response = dataCatalogClient.getEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Entry getEntry(EntryName name) {
    GetEntryRequest request =
        GetEntryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   Entry response = dataCatalogClient.getEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Entry getEntry(String name) {
    GetEntryRequest request = GetEntryRequest.newBuilder().setName(name).build();
    return getEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetEntryRequest request =
   *       GetEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   Entry response = dataCatalogClient.getEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Entry getEntry(GetEntryRequest request) {
    return getEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetEntryRequest request =
   *       GetEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   ApiFuture<Entry> future = dataCatalogClient.getEntryCallable().futureCall(request);
   *   // Do something.
   *   Entry response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<GetEntryRequest, Entry> getEntryCallable() {
    return stub.getEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an entry by target resource name. This method allows clients to use the resource name from
   * the source Google Cloud Platform service to get the Data Catalog Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   LookupEntryRequest request = LookupEntryRequest.newBuilder().build();
   *   Entry response = dataCatalogClient.lookupEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Entry lookupEntry(LookupEntryRequest request) {
    return lookupEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an entry by target resource name. This method allows clients to use the resource name from
   * the source Google Cloud Platform service to get the Data Catalog Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   LookupEntryRequest request = LookupEntryRequest.newBuilder().build();
   *   ApiFuture<Entry> future = dataCatalogClient.lookupEntryCallable().futureCall(request);
   *   // Do something.
   *   Entry response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<LookupEntryRequest, Entry> lookupEntryCallable() {
    return stub.lookupEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   for (Entry element : dataCatalogClient.listEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the entry group that contains the entries, which can be
   *     provided in URL format. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final ListEntriesPagedResponse listEntries(EntryGroupName parent) {
    ListEntriesRequest request =
        ListEntriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   for (Entry element : dataCatalogClient.listEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the entry group that contains the entries, which can be
   *     provided in URL format. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final ListEntriesPagedResponse listEntries(String parent) {
    ListEntriesRequest request = ListEntriesRequest.newBuilder().setParent(parent).build();
    return listEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListEntriesRequest request =
   *       ListEntriesRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (Entry element : dataCatalogClient.listEntries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final ListEntriesPagedResponse listEntries(ListEntriesRequest request) {
    return listEntriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListEntriesRequest request =
   *       ListEntriesRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Entry> future = dataCatalogClient.listEntriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Entry element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<ListEntriesRequest, ListEntriesPagedResponse>
      listEntriesPagedCallable() {
    return stub.listEntriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListEntriesRequest request =
   *       ListEntriesRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListEntriesResponse response = dataCatalogClient.listEntriesCallable().call(request);
   *     for (Entry element : response.getEntriesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<ListEntriesRequest, ListEntriesResponse> listEntriesCallable() {
    return stub.listEntriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag template. The user should enable the Data Catalog API in the project identified
   * by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String tagTemplateId = "tagTemplateId-1438776721";
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   TagTemplate response =
   *       dataCatalogClient.createTagTemplate(parent, tagTemplateId, tagTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project and the template location
   *     [region](https://cloud.google.com/data-catalog/docs/concepts/regions.
   *     <p>Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/us-central1
   *     </ul>
   *
   * @param tagTemplateId Required. The id of the tag template to create.
   * @param tagTemplate Required. The tag template to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplate createTagTemplate(
      LocationName parent, String tagTemplateId, TagTemplate tagTemplate) {
    CreateTagTemplateRequest request =
        CreateTagTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTagTemplateId(tagTemplateId)
            .setTagTemplate(tagTemplate)
            .build();
    return createTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag template. The user should enable the Data Catalog API in the project identified
   * by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String tagTemplateId = "tagTemplateId-1438776721";
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   TagTemplate response =
   *       dataCatalogClient.createTagTemplate(parent, tagTemplateId, tagTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project and the template location
   *     [region](https://cloud.google.com/data-catalog/docs/concepts/regions.
   *     <p>Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/us-central1
   *     </ul>
   *
   * @param tagTemplateId Required. The id of the tag template to create.
   * @param tagTemplate Required. The tag template to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplate createTagTemplate(
      String parent, String tagTemplateId, TagTemplate tagTemplate) {
    CreateTagTemplateRequest request =
        CreateTagTemplateRequest.newBuilder()
            .setParent(parent)
            .setTagTemplateId(tagTemplateId)
            .setTagTemplate(tagTemplate)
            .build();
    return createTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag template. The user should enable the Data Catalog API in the project identified
   * by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagTemplateRequest request =
   *       CreateTagTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTagTemplateId("tagTemplateId-1438776721")
   *           .setTagTemplate(TagTemplate.newBuilder().build())
   *           .build();
   *   TagTemplate response = dataCatalogClient.createTagTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplate createTagTemplate(CreateTagTemplateRequest request) {
    return createTagTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag template. The user should enable the Data Catalog API in the project identified
   * by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagTemplateRequest request =
   *       CreateTagTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTagTemplateId("tagTemplateId-1438776721")
   *           .setTagTemplate(TagTemplate.newBuilder().build())
   *           .build();
   *   ApiFuture<TagTemplate> future =
   *       dataCatalogClient.createTagTemplateCallable().futureCall(request);
   *   // Do something.
   *   TagTemplate response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<CreateTagTemplateRequest, TagTemplate> createTagTemplateCallable() {
    return stub.createTagTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a tag template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateName name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   TagTemplate response = dataCatalogClient.getTagTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplate getTagTemplate(TagTemplateName name) {
    GetTagTemplateRequest request =
        GetTagTemplateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a tag template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString();
   *   TagTemplate response = dataCatalogClient.getTagTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplate getTagTemplate(String name) {
    GetTagTemplateRequest request = GetTagTemplateRequest.newBuilder().setName(name).build();
    return getTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a tag template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetTagTemplateRequest request =
   *       GetTagTemplateRequest.newBuilder()
   *           .setName(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
   *           .build();
   *   TagTemplate response = dataCatalogClient.getTagTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplate getTagTemplate(GetTagTemplateRequest request) {
    return getTagTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a tag template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetTagTemplateRequest request =
   *       GetTagTemplateRequest.newBuilder()
   *           .setName(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
   *           .build();
   *   ApiFuture<TagTemplate> future =
   *       dataCatalogClient.getTagTemplateCallable().futureCall(request);
   *   // Do something.
   *   TagTemplate response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<GetTagTemplateRequest, TagTemplate> getTagTemplateCallable() {
    return stub.getTagTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tag template. This method cannot be used to update the fields of a template. The tag
   * template fields are represented as separate resources and should be updated using their own
   * create/update/delete methods. Users should enable the Data Catalog API in the project
   * identified by the `tag_template.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   TagTemplate response = dataCatalogClient.updateTagTemplate(tagTemplate);
   * }
   * }</pre>
   *
   * @param tagTemplate Required. The template to update. The "name" field must be set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplate updateTagTemplate(TagTemplate tagTemplate) {
    UpdateTagTemplateRequest request =
        UpdateTagTemplateRequest.newBuilder().setTagTemplate(tagTemplate).build();
    return updateTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tag template. This method cannot be used to update the fields of a template. The tag
   * template fields are represented as separate resources and should be updated using their own
   * create/update/delete methods. Users should enable the Data Catalog API in the project
   * identified by the `tag_template.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TagTemplate response = dataCatalogClient.updateTagTemplate(tagTemplate, updateMask);
   * }
   * }</pre>
   *
   * @param tagTemplate Required. The template to update. The "name" field must be set.
   * @param updateMask Names of fields whose values to overwrite on a tag template. Currently, only
   *     `display_name` can be overwritten.
   *     <p>In general, if this parameter is absent or empty, all modifiable fields are overwritten.
   *     If such fields are non-required and omitted in the request body, their values are emptied.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplate updateTagTemplate(TagTemplate tagTemplate, FieldMask updateMask) {
    UpdateTagTemplateRequest request =
        UpdateTagTemplateRequest.newBuilder()
            .setTagTemplate(tagTemplate)
            .setUpdateMask(updateMask)
            .build();
    return updateTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tag template. This method cannot be used to update the fields of a template. The tag
   * template fields are represented as separate resources and should be updated using their own
   * create/update/delete methods. Users should enable the Data Catalog API in the project
   * identified by the `tag_template.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateTagTemplateRequest request =
   *       UpdateTagTemplateRequest.newBuilder()
   *           .setTagTemplate(TagTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   TagTemplate response = dataCatalogClient.updateTagTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplate updateTagTemplate(UpdateTagTemplateRequest request) {
    return updateTagTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tag template. This method cannot be used to update the fields of a template. The tag
   * template fields are represented as separate resources and should be updated using their own
   * create/update/delete methods. Users should enable the Data Catalog API in the project
   * identified by the `tag_template.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateTagTemplateRequest request =
   *       UpdateTagTemplateRequest.newBuilder()
   *           .setTagTemplate(TagTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TagTemplate> future =
   *       dataCatalogClient.updateTagTemplateCallable().futureCall(request);
   *   // Do something.
   *   TagTemplate response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateCallable() {
    return stub.updateTagTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag template and all tags using the template. Users should enable the Data Catalog
   * API in the project identified by the `name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateName name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   boolean force = true;
   *   dataCatalogClient.deleteTagTemplate(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template to delete. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}
   *     </ul>
   *
   * @param force Required. Currently, this field must always be set to `true`. This confirms the
   *     deletion of any possible tags using this template. `force = false` will be supported in the
   *     future.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteTagTemplate(TagTemplateName name, boolean force) {
    DeleteTagTemplateRequest request =
        DeleteTagTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setForce(force)
            .build();
    deleteTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag template and all tags using the template. Users should enable the Data Catalog
   * API in the project identified by the `name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString();
   *   boolean force = true;
   *   dataCatalogClient.deleteTagTemplate(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template to delete. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}
   *     </ul>
   *
   * @param force Required. Currently, this field must always be set to `true`. This confirms the
   *     deletion of any possible tags using this template. `force = false` will be supported in the
   *     future.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteTagTemplate(String name, boolean force) {
    DeleteTagTemplateRequest request =
        DeleteTagTemplateRequest.newBuilder().setName(name).setForce(force).build();
    deleteTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag template and all tags using the template. Users should enable the Data Catalog
   * API in the project identified by the `name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteTagTemplateRequest request =
   *       DeleteTagTemplateRequest.newBuilder()
   *           .setName(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
   *           .setForce(true)
   *           .build();
   *   dataCatalogClient.deleteTagTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteTagTemplate(DeleteTagTemplateRequest request) {
    deleteTagTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag template and all tags using the template. Users should enable the Data Catalog
   * API in the project identified by the `name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteTagTemplateRequest request =
   *       DeleteTagTemplateRequest.newBuilder()
   *           .setName(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = dataCatalogClient.deleteTagTemplateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<DeleteTagTemplateRequest, Empty> deleteTagTemplateCallable() {
    return stub.deleteTagTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateName parent = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   String tagTemplateFieldId = "tagTemplateFieldId-1556835615";
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   TagTemplateField response =
   *       dataCatalogClient.createTagTemplateField(parent, tagTemplateFieldId, tagTemplateField);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project and the template location
   *     [region](https://cloud.google.com/data-catalog/docs/concepts/regions).
   *     <p>Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/us-central1/tagTemplates/{tag_template_id}
   *     </ul>
   *
   * @param tagTemplateFieldId Required. The ID of the tag template field to create. Field ids can
   *     contain letters (both uppercase and lowercase), numbers (0-9), underscores (_) and dashes
   *     (-). Field IDs must be at least 1 character long and at most 128 characters long. Field IDs
   *     must also be unique within their template.
   * @param tagTemplateField Required. The tag template field to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplateField createTagTemplateField(
      TagTemplateName parent, String tagTemplateFieldId, TagTemplateField tagTemplateField) {
    CreateTagTemplateFieldRequest request =
        CreateTagTemplateFieldRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTagTemplateFieldId(tagTemplateFieldId)
            .setTagTemplateField(tagTemplateField)
            .build();
    return createTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString();
   *   String tagTemplateFieldId = "tagTemplateFieldId-1556835615";
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   TagTemplateField response =
   *       dataCatalogClient.createTagTemplateField(parent, tagTemplateFieldId, tagTemplateField);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project and the template location
   *     [region](https://cloud.google.com/data-catalog/docs/concepts/regions).
   *     <p>Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/us-central1/tagTemplates/{tag_template_id}
   *     </ul>
   *
   * @param tagTemplateFieldId Required. The ID of the tag template field to create. Field ids can
   *     contain letters (both uppercase and lowercase), numbers (0-9), underscores (_) and dashes
   *     (-). Field IDs must be at least 1 character long and at most 128 characters long. Field IDs
   *     must also be unique within their template.
   * @param tagTemplateField Required. The tag template field to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplateField createTagTemplateField(
      String parent, String tagTemplateFieldId, TagTemplateField tagTemplateField) {
    CreateTagTemplateFieldRequest request =
        CreateTagTemplateFieldRequest.newBuilder()
            .setParent(parent)
            .setTagTemplateFieldId(tagTemplateFieldId)
            .setTagTemplateField(tagTemplateField)
            .build();
    return createTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagTemplateFieldRequest request =
   *       CreateTagTemplateFieldRequest.newBuilder()
   *           .setParent(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
   *           .setTagTemplateFieldId("tagTemplateFieldId-1556835615")
   *           .setTagTemplateField(TagTemplateField.newBuilder().build())
   *           .build();
   *   TagTemplateField response = dataCatalogClient.createTagTemplateField(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplateField createTagTemplateField(CreateTagTemplateFieldRequest request) {
    return createTagTemplateFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagTemplateFieldRequest request =
   *       CreateTagTemplateFieldRequest.newBuilder()
   *           .setParent(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
   *           .setTagTemplateFieldId("tagTemplateFieldId-1556835615")
   *           .setTagTemplateField(TagTemplateField.newBuilder().build())
   *           .build();
   *   ApiFuture<TagTemplateField> future =
   *       dataCatalogClient.createTagTemplateFieldCallable().futureCall(request);
   *   // Do something.
   *   TagTemplateField response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldCallable() {
    return stub.createTagTemplateFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateFieldName name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   TagTemplateField response = dataCatalogClient.updateTagTemplateField(name, tagTemplateField);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param tagTemplateField Required. The template to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplateField updateTagTemplateField(
      TagTemplateFieldName name, TagTemplateField tagTemplateField) {
    UpdateTagTemplateFieldRequest request =
        UpdateTagTemplateFieldRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTagTemplateField(tagTemplateField)
            .build();
    return updateTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *           .toString();
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   TagTemplateField response = dataCatalogClient.updateTagTemplateField(name, tagTemplateField);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param tagTemplateField Required. The template to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplateField updateTagTemplateField(
      String name, TagTemplateField tagTemplateField) {
    UpdateTagTemplateFieldRequest request =
        UpdateTagTemplateFieldRequest.newBuilder()
            .setName(name)
            .setTagTemplateField(tagTemplateField)
            .build();
    return updateTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateFieldName name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TagTemplateField response =
   *       dataCatalogClient.updateTagTemplateField(name, tagTemplateField, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param tagTemplateField Required. The template to update.
   * @param updateMask Optional. Names of fields whose values to overwrite on an individual field of
   *     a tag template. The following fields are modifiable:
   *     <p>&#42; `display_name` &#42; `type.enum_type` &#42; `is_required`
   *     <p>If this parameter is absent or empty, all modifiable fields are overwritten. If such
   *     fields are non-required and omitted in the request body, their values are emptied with one
   *     exception: when updating an enum type, the provided values are merged with the existing
   *     values. Therefore, enum values can only be added, existing enum values cannot be deleted or
   *     renamed.
   *     <p>Additionally, updating a template field from optional to required is
   *     <ul>
   *       <li>not&#42; allowed.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplateField updateTagTemplateField(
      TagTemplateFieldName name, TagTemplateField tagTemplateField, FieldMask updateMask) {
    UpdateTagTemplateFieldRequest request =
        UpdateTagTemplateFieldRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTagTemplateField(tagTemplateField)
            .setUpdateMask(updateMask)
            .build();
    return updateTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *           .toString();
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TagTemplateField response =
   *       dataCatalogClient.updateTagTemplateField(name, tagTemplateField, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param tagTemplateField Required. The template to update.
   * @param updateMask Optional. Names of fields whose values to overwrite on an individual field of
   *     a tag template. The following fields are modifiable:
   *     <p>&#42; `display_name` &#42; `type.enum_type` &#42; `is_required`
   *     <p>If this parameter is absent or empty, all modifiable fields are overwritten. If such
   *     fields are non-required and omitted in the request body, their values are emptied with one
   *     exception: when updating an enum type, the provided values are merged with the existing
   *     values. Therefore, enum values can only be added, existing enum values cannot be deleted or
   *     renamed.
   *     <p>Additionally, updating a template field from optional to required is
   *     <ul>
   *       <li>not&#42; allowed.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplateField updateTagTemplateField(
      String name, TagTemplateField tagTemplateField, FieldMask updateMask) {
    UpdateTagTemplateFieldRequest request =
        UpdateTagTemplateFieldRequest.newBuilder()
            .setName(name)
            .setTagTemplateField(tagTemplateField)
            .setUpdateMask(updateMask)
            .build();
    return updateTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateTagTemplateFieldRequest request =
   *       UpdateTagTemplateFieldRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *                   .toString())
   *           .setTagTemplateField(TagTemplateField.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   TagTemplateField response = dataCatalogClient.updateTagTemplateField(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplateField updateTagTemplateField(UpdateTagTemplateFieldRequest request) {
    return updateTagTemplateFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateTagTemplateFieldRequest request =
   *       UpdateTagTemplateFieldRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *                   .toString())
   *           .setTagTemplateField(TagTemplateField.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TagTemplateField> future =
   *       dataCatalogClient.updateTagTemplateFieldCallable().futureCall(request);
   *   // Do something.
   *   TagTemplateField response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldCallable() {
    return stub.updateTagTemplateFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `name` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateFieldName name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   String newTagTemplateFieldId = "newTagTemplateFieldId2008993953";
   *   TagTemplateField response =
   *       dataCatalogClient.renameTagTemplateField(name, newTagTemplateFieldId);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param newTagTemplateFieldId Required. The new ID of this tag template field. For example,
   *     `my_new_field`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplateField renameTagTemplateField(
      TagTemplateFieldName name, String newTagTemplateFieldId) {
    RenameTagTemplateFieldRequest request =
        RenameTagTemplateFieldRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNewTagTemplateFieldId(newTagTemplateFieldId)
            .build();
    return renameTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `name` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *           .toString();
   *   String newTagTemplateFieldId = "newTagTemplateFieldId2008993953";
   *   TagTemplateField response =
   *       dataCatalogClient.renameTagTemplateField(name, newTagTemplateFieldId);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param newTagTemplateFieldId Required. The new ID of this tag template field. For example,
   *     `my_new_field`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplateField renameTagTemplateField(String name, String newTagTemplateFieldId) {
    RenameTagTemplateFieldRequest request =
        RenameTagTemplateFieldRequest.newBuilder()
            .setName(name)
            .setNewTagTemplateFieldId(newTagTemplateFieldId)
            .build();
    return renameTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `name` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   RenameTagTemplateFieldRequest request =
   *       RenameTagTemplateFieldRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *                   .toString())
   *           .setNewTagTemplateFieldId("newTagTemplateFieldId2008993953")
   *           .build();
   *   TagTemplateField response = dataCatalogClient.renameTagTemplateField(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplateField renameTagTemplateField(RenameTagTemplateFieldRequest request) {
    return renameTagTemplateFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `name` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   RenameTagTemplateFieldRequest request =
   *       RenameTagTemplateFieldRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *                   .toString())
   *           .setNewTagTemplateFieldId("newTagTemplateFieldId2008993953")
   *           .build();
   *   ApiFuture<TagTemplateField> future =
   *       dataCatalogClient.renameTagTemplateFieldCallable().futureCall(request);
   *   // Do something.
   *   TagTemplateField response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldCallable() {
    return stub.renameTagTemplateFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames an enum value in a tag template. The enum values have to be unique within one enum
   * field. Thus, an enum value cannot be renamed with a name used in any other enum value within
   * the same enum field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateFieldEnumValueName name =
   *       TagTemplateFieldEnumValueName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[TAG_TEMPLATE]",
   *           "[TAG_TEMPLATE_FIELD_ID]",
   *           "[ENUM_VALUE_DISPLAY_NAME]");
   *   String newEnumValueDisplayName = "newEnumValueDisplayName-1119629027";
   *   TagTemplateField response =
   *       dataCatalogClient.renameTagTemplateFieldEnumValue(name, newEnumValueDisplayName);
   * }
   * }</pre>
   *
   * @param name Required. The name of the enum field value. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}/enumValues/{enum_value_display_name}
   *     </ul>
   *
   * @param newEnumValueDisplayName Required. The new display name of the enum value. For example,
   *     `my_new_enum_value`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplateField renameTagTemplateFieldEnumValue(
      TagTemplateFieldEnumValueName name, String newEnumValueDisplayName) {
    RenameTagTemplateFieldEnumValueRequest request =
        RenameTagTemplateFieldEnumValueRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNewEnumValueDisplayName(newEnumValueDisplayName)
            .build();
    return renameTagTemplateFieldEnumValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames an enum value in a tag template. The enum values have to be unique within one enum
   * field. Thus, an enum value cannot be renamed with a name used in any other enum value within
   * the same enum field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name =
   *       TagTemplateFieldEnumValueName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[TAG_TEMPLATE]",
   *               "[TAG_TEMPLATE_FIELD_ID]",
   *               "[ENUM_VALUE_DISPLAY_NAME]")
   *           .toString();
   *   String newEnumValueDisplayName = "newEnumValueDisplayName-1119629027";
   *   TagTemplateField response =
   *       dataCatalogClient.renameTagTemplateFieldEnumValue(name, newEnumValueDisplayName);
   * }
   * }</pre>
   *
   * @param name Required. The name of the enum field value. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}/enumValues/{enum_value_display_name}
   *     </ul>
   *
   * @param newEnumValueDisplayName Required. The new display name of the enum value. For example,
   *     `my_new_enum_value`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplateField renameTagTemplateFieldEnumValue(
      String name, String newEnumValueDisplayName) {
    RenameTagTemplateFieldEnumValueRequest request =
        RenameTagTemplateFieldEnumValueRequest.newBuilder()
            .setName(name)
            .setNewEnumValueDisplayName(newEnumValueDisplayName)
            .build();
    return renameTagTemplateFieldEnumValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames an enum value in a tag template. The enum values have to be unique within one enum
   * field. Thus, an enum value cannot be renamed with a name used in any other enum value within
   * the same enum field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   RenameTagTemplateFieldEnumValueRequest request =
   *       RenameTagTemplateFieldEnumValueRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldEnumValueName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TAG_TEMPLATE]",
   *                       "[TAG_TEMPLATE_FIELD_ID]",
   *                       "[ENUM_VALUE_DISPLAY_NAME]")
   *                   .toString())
   *           .setNewEnumValueDisplayName("newEnumValueDisplayName-1119629027")
   *           .build();
   *   TagTemplateField response = dataCatalogClient.renameTagTemplateFieldEnumValue(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TagTemplateField renameTagTemplateFieldEnumValue(
      RenameTagTemplateFieldEnumValueRequest request) {
    return renameTagTemplateFieldEnumValueCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames an enum value in a tag template. The enum values have to be unique within one enum
   * field. Thus, an enum value cannot be renamed with a name used in any other enum value within
   * the same enum field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   RenameTagTemplateFieldEnumValueRequest request =
   *       RenameTagTemplateFieldEnumValueRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldEnumValueName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TAG_TEMPLATE]",
   *                       "[TAG_TEMPLATE_FIELD_ID]",
   *                       "[ENUM_VALUE_DISPLAY_NAME]")
   *                   .toString())
   *           .setNewEnumValueDisplayName("newEnumValueDisplayName-1119629027")
   *           .build();
   *   ApiFuture<TagTemplateField> future =
   *       dataCatalogClient.renameTagTemplateFieldEnumValueCallable().futureCall(request);
   *   // Do something.
   *   TagTemplateField response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<RenameTagTemplateFieldEnumValueRequest, TagTemplateField>
      renameTagTemplateFieldEnumValueCallable() {
    return stub.renameTagTemplateFieldEnumValueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a field in a tag template and all uses of that field. Users should enable the Data
   * Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource
   * Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateFieldName name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   boolean force = true;
   *   dataCatalogClient.deleteTagTemplateField(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field to delete. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param force Required. Currently, this field must always be set to `true`. This confirms the
   *     deletion of this field from any tags using this field. `force = false` will be supported in
   *     the future.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteTagTemplateField(TagTemplateFieldName name, boolean force) {
    DeleteTagTemplateFieldRequest request =
        DeleteTagTemplateFieldRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setForce(force)
            .build();
    deleteTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a field in a tag template and all uses of that field. Users should enable the Data
   * Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource
   * Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *           .toString();
   *   boolean force = true;
   *   dataCatalogClient.deleteTagTemplateField(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field to delete. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param force Required. Currently, this field must always be set to `true`. This confirms the
   *     deletion of this field from any tags using this field. `force = false` will be supported in
   *     the future.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteTagTemplateField(String name, boolean force) {
    DeleteTagTemplateFieldRequest request =
        DeleteTagTemplateFieldRequest.newBuilder().setName(name).setForce(force).build();
    deleteTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a field in a tag template and all uses of that field. Users should enable the Data
   * Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource
   * Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteTagTemplateFieldRequest request =
   *       DeleteTagTemplateFieldRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   dataCatalogClient.deleteTagTemplateField(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteTagTemplateField(DeleteTagTemplateFieldRequest request) {
    deleteTagTemplateFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a field in a tag template and all uses of that field. Users should enable the Data
   * Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource
   * Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteTagTemplateFieldRequest request =
   *       DeleteTagTemplateFieldRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataCatalogClient.deleteTagTemplateFieldCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<DeleteTagTemplateFieldRequest, Empty>
      deleteTagTemplateFieldCallable() {
    return stub.deleteTagTemplateFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry]. Note: The project
   * identified by the `parent` parameter for the
   * [tag](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag
   * template](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be from the same organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName parent = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   Tag tag = Tag.newBuilder().build();
   *   Tag response = dataCatalogClient.createTag(parent, tag);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the resource to attach this tag to. Tags can be attached to
   *     Entries. Example:
   *     <p>&#42;
   *     projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     <p>Note that this Tag and its child resources may not actually be stored in the location in
   *     this name.
   * @param tag Required. The tag to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Tag createTag(EntryName parent, Tag tag) {
    CreateTagRequest request =
        CreateTagRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTag(tag)
            .build();
    return createTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry]. Note: The project
   * identified by the `parent` parameter for the
   * [tag](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag
   * template](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be from the same organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent =
   *       EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   Tag tag = Tag.newBuilder().build();
   *   Tag response = dataCatalogClient.createTag(parent, tag);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the resource to attach this tag to. Tags can be attached to
   *     Entries. Example:
   *     <p>&#42;
   *     projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     <p>Note that this Tag and its child resources may not actually be stored in the location in
   *     this name.
   * @param tag Required. The tag to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Tag createTag(String parent, Tag tag) {
    CreateTagRequest request = CreateTagRequest.newBuilder().setParent(parent).setTag(tag).build();
    return createTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry]. Note: The project
   * identified by the `parent` parameter for the
   * [tag](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag
   * template](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be from the same organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagRequest request =
   *       CreateTagRequest.newBuilder()
   *           .setParent(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .setTag(Tag.newBuilder().build())
   *           .build();
   *   Tag response = dataCatalogClient.createTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Tag createTag(CreateTagRequest request) {
    return createTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry]. Note: The project
   * identified by the `parent` parameter for the
   * [tag](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag
   * template](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be from the same organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagRequest request =
   *       CreateTagRequest.newBuilder()
   *           .setParent(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .setTag(Tag.newBuilder().build())
   *           .build();
   *   ApiFuture<Tag> future = dataCatalogClient.createTagCallable().futureCall(request);
   *   // Do something.
   *   Tag response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<CreateTagRequest, Tag> createTagCallable() {
    return stub.createTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Tag tag = Tag.newBuilder().build();
   *   Tag response = dataCatalogClient.updateTag(tag);
   * }
   * }</pre>
   *
   * @param tag Required. The updated tag. The "name" field must be set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Tag updateTag(Tag tag) {
    UpdateTagRequest request = UpdateTagRequest.newBuilder().setTag(tag).build();
    return updateTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Tag tag = Tag.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Tag response = dataCatalogClient.updateTag(tag, updateMask);
   * }
   * }</pre>
   *
   * @param tag Required. The updated tag. The "name" field must be set.
   * @param updateMask Note: Currently, this parameter can only take `"fields"` as value.
   *     <p>Names of fields whose values to overwrite on a tag. Currently, a tag has the only
   *     modifiable field with the name `fields`.
   *     <p>In general, if this parameter is absent or empty, all modifiable fields are overwritten.
   *     If such fields are non-required and omitted in the request body, their values are emptied.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Tag updateTag(Tag tag, FieldMask updateMask) {
    UpdateTagRequest request =
        UpdateTagRequest.newBuilder().setTag(tag).setUpdateMask(updateMask).build();
    return updateTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateTagRequest request =
   *       UpdateTagRequest.newBuilder()
   *           .setTag(Tag.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Tag response = dataCatalogClient.updateTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Tag updateTag(UpdateTagRequest request) {
    return updateTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateTagRequest request =
   *       UpdateTagRequest.newBuilder()
   *           .setTag(Tag.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Tag> future = dataCatalogClient.updateTagCallable().futureCall(request);
   *   // Do something.
   *   Tag response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<UpdateTagRequest, Tag> updateTagCallable() {
    return stub.updateTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   dataCatalogClient.deleteTag(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag to delete. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}/tags/{tag_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteTag(EntryName name) {
    DeleteTagRequest request =
        DeleteTagRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   dataCatalogClient.deleteTag(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag to delete. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}/tags/{tag_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteTag(String name) {
    DeleteTagRequest request = DeleteTagRequest.newBuilder().setName(name).build();
    deleteTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteTagRequest request =
   *       DeleteTagRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   dataCatalogClient.deleteTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final void deleteTag(DeleteTagRequest request) {
    deleteTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteTagRequest request =
   *       DeleteTagRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   ApiFuture<Empty> future = dataCatalogClient.deleteTagCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<DeleteTagRequest, Empty> deleteTagCallable() {
    return stub.deleteTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tags assigned to an [Entry][google.cloud.datacatalog.v1beta1.Entry]. The
   * [columns][google.cloud.datacatalog.v1beta1.Tag.column] in the response are lowercased.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName parent = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   for (Tag element : dataCatalogClient.listTags(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Data Catalog resource to list the tags of. The resource
   *     could be an [Entry][google.cloud.datacatalog.v1beta1.Entry] or an
   *     [EntryGroup][google.cloud.datacatalog.v1beta1.EntryGroup].
   *     <p>Examples:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final ListTagsPagedResponse listTags(EntryName parent) {
    ListTagsRequest request =
        ListTagsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listTags(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tags assigned to an [Entry][google.cloud.datacatalog.v1beta1.Entry]. The
   * [columns][google.cloud.datacatalog.v1beta1.Tag.column] in the response are lowercased.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent =
   *       EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   for (Tag element : dataCatalogClient.listTags(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Data Catalog resource to list the tags of. The resource
   *     could be an [Entry][google.cloud.datacatalog.v1beta1.Entry] or an
   *     [EntryGroup][google.cloud.datacatalog.v1beta1.EntryGroup].
   *     <p>Examples:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final ListTagsPagedResponse listTags(String parent) {
    ListTagsRequest request = ListTagsRequest.newBuilder().setParent(parent).build();
    return listTags(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tags assigned to an [Entry][google.cloud.datacatalog.v1beta1.Entry]. The
   * [columns][google.cloud.datacatalog.v1beta1.Tag.column] in the response are lowercased.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListTagsRequest request =
   *       ListTagsRequest.newBuilder()
   *           .setParent(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Tag element : dataCatalogClient.listTags(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final ListTagsPagedResponse listTags(ListTagsRequest request) {
    return listTagsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tags assigned to an [Entry][google.cloud.datacatalog.v1beta1.Entry]. The
   * [columns][google.cloud.datacatalog.v1beta1.Tag.column] in the response are lowercased.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListTagsRequest request =
   *       ListTagsRequest.newBuilder()
   *           .setParent(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Tag> future = dataCatalogClient.listTagsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Tag element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<ListTagsRequest, ListTagsPagedResponse> listTagsPagedCallable() {
    return stub.listTagsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tags assigned to an [Entry][google.cloud.datacatalog.v1beta1.Entry]. The
   * [columns][google.cloud.datacatalog.v1beta1.Tag.column] in the response are lowercased.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListTagsRequest request =
   *       ListTagsRequest.newBuilder()
   *           .setParent(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTagsResponse response = dataCatalogClient.listTagsCallable().call(request);
   *     for (Tag element : response.getTagsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<ListTagsRequest, ListTagsResponse> listTagsCallable() {
    return stub.listTagsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy for a resource. Replaces any existing policy. Supported
   * resources are: - Tag templates. - Entries. - Entry groups. Note, this method cannot be used to
   * manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform resources synced
   * to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.setIamPolicy`
   * to set policies on tag templates. - `datacatalog.entries.setIamPolicy` to set policies on
   * entries. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ResourceName resource = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = dataCatalogClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy for a resource. Replaces any existing policy. Supported
   * resources are: - Tag templates. - Entries. - Entry groups. Note, this method cannot be used to
   * manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform resources synced
   * to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.setIamPolicy`
   * to set policies on tag templates. - `datacatalog.entries.setIamPolicy` to set policies on
   * entries. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String resource =
   *       EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = dataCatalogClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy for a resource. Replaces any existing policy. Supported
   * resources are: - Tag templates. - Entries. - Entry groups. Note, this method cannot be used to
   * manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform resources synced
   * to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.setIamPolicy`
   * to set policies on tag templates. - `datacatalog.entries.setIamPolicy` to set policies on
   * entries. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = dataCatalogClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy for a resource. Replaces any existing policy. Supported
   * resources are: - Tag templates. - Entries. - Entry groups. Note, this method cannot be used to
   * manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform resources synced
   * to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.setIamPolicy`
   * to set policies on tag templates. - `datacatalog.entries.setIamPolicy` to set policies on
   * entries. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = dataCatalogClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. A `NOT_FOUND` error is returned if the resource
   * does not exist. An empty policy is returned if the resource exists but does not have a policy
   * set on it.
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform
   * resources synced to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.getIamPolicy`
   * to get policies on tag templates. - `datacatalog.entries.getIamPolicy` to get policies on
   * entries. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ResourceName resource = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   Policy response = dataCatalogClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. A `NOT_FOUND` error is returned if the resource
   * does not exist. An empty policy is returned if the resource exists but does not have a policy
   * set on it.
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform
   * resources synced to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.getIamPolicy`
   * to get policies on tag templates. - `datacatalog.entries.getIamPolicy` to get policies on
   * entries. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String resource =
   *       EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   Policy response = dataCatalogClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. A `NOT_FOUND` error is returned if the resource
   * does not exist. An empty policy is returned if the resource exists but does not have a policy
   * set on it.
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform
   * resources synced to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.getIamPolicy`
   * to get policies on tag templates. - `datacatalog.entries.getIamPolicy` to get policies on
   * entries. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = dataCatalogClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. A `NOT_FOUND` error is returned if the resource
   * does not exist. An empty policy is returned if the resource exists but does not have a policy
   * set on it.
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform
   * resources synced to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.getIamPolicy`
   * to get policies on tag templates. - `datacatalog.entries.getIamPolicy` to get policies on
   * entries. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = dataCatalogClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the caller's permissions on a resource. If the resource does not exist, an empty set of
   * permissions is returned (We don't return a `NOT_FOUND` error).
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform
   * resources synced to Data Catalog.
   *
   * <p>A caller is not required to have Google IAM permission to make this request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = dataCatalogClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the caller's permissions on a resource. If the resource does not exist, an empty set of
   * permissions is returned (We don't return a `NOT_FOUND` error).
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform
   * resources synced to Data Catalog.
   *
   * <p>A caller is not required to have Google IAM permission to make this request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       dataCatalogClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class SearchCatalogPagedResponse
      extends AbstractPagedListResponse<
          SearchCatalogRequest,
          SearchCatalogResponse,
          SearchCatalogResult,
          SearchCatalogPage,
          SearchCatalogFixedSizeCollection> {

    public static ApiFuture<SearchCatalogPagedResponse> createAsync(
        PageContext<SearchCatalogRequest, SearchCatalogResponse, SearchCatalogResult> context,
        ApiFuture<SearchCatalogResponse> futureResponse) {
      ApiFuture<SearchCatalogPage> futurePage =
          SearchCatalogPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchCatalogPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchCatalogPagedResponse(SearchCatalogPage page) {
      super(page, SearchCatalogFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchCatalogPage
      extends AbstractPage<
          SearchCatalogRequest, SearchCatalogResponse, SearchCatalogResult, SearchCatalogPage> {

    private SearchCatalogPage(
        PageContext<SearchCatalogRequest, SearchCatalogResponse, SearchCatalogResult> context,
        SearchCatalogResponse response) {
      super(context, response);
    }

    private static SearchCatalogPage createEmptyPage() {
      return new SearchCatalogPage(null, null);
    }

    @Override
    protected SearchCatalogPage createPage(
        PageContext<SearchCatalogRequest, SearchCatalogResponse, SearchCatalogResult> context,
        SearchCatalogResponse response) {
      return new SearchCatalogPage(context, response);
    }

    @Override
    public ApiFuture<SearchCatalogPage> createPageAsync(
        PageContext<SearchCatalogRequest, SearchCatalogResponse, SearchCatalogResult> context,
        ApiFuture<SearchCatalogResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchCatalogFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchCatalogRequest,
          SearchCatalogResponse,
          SearchCatalogResult,
          SearchCatalogPage,
          SearchCatalogFixedSizeCollection> {

    private SearchCatalogFixedSizeCollection(List<SearchCatalogPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchCatalogFixedSizeCollection createEmptyCollection() {
      return new SearchCatalogFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchCatalogFixedSizeCollection createCollection(
        List<SearchCatalogPage> pages, int collectionSize) {
      return new SearchCatalogFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEntryGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListEntryGroupsRequest,
          ListEntryGroupsResponse,
          EntryGroup,
          ListEntryGroupsPage,
          ListEntryGroupsFixedSizeCollection> {

    public static ApiFuture<ListEntryGroupsPagedResponse> createAsync(
        PageContext<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup> context,
        ApiFuture<ListEntryGroupsResponse> futureResponse) {
      ApiFuture<ListEntryGroupsPage> futurePage =
          ListEntryGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEntryGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEntryGroupsPagedResponse(ListEntryGroupsPage page) {
      super(page, ListEntryGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEntryGroupsPage
      extends AbstractPage<
          ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup, ListEntryGroupsPage> {

    private ListEntryGroupsPage(
        PageContext<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup> context,
        ListEntryGroupsResponse response) {
      super(context, response);
    }

    private static ListEntryGroupsPage createEmptyPage() {
      return new ListEntryGroupsPage(null, null);
    }

    @Override
    protected ListEntryGroupsPage createPage(
        PageContext<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup> context,
        ListEntryGroupsResponse response) {
      return new ListEntryGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListEntryGroupsPage> createPageAsync(
        PageContext<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup> context,
        ApiFuture<ListEntryGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEntryGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEntryGroupsRequest,
          ListEntryGroupsResponse,
          EntryGroup,
          ListEntryGroupsPage,
          ListEntryGroupsFixedSizeCollection> {

    private ListEntryGroupsFixedSizeCollection(
        List<ListEntryGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEntryGroupsFixedSizeCollection createEmptyCollection() {
      return new ListEntryGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEntryGroupsFixedSizeCollection createCollection(
        List<ListEntryGroupsPage> pages, int collectionSize) {
      return new ListEntryGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEntriesPagedResponse
      extends AbstractPagedListResponse<
          ListEntriesRequest,
          ListEntriesResponse,
          Entry,
          ListEntriesPage,
          ListEntriesFixedSizeCollection> {

    public static ApiFuture<ListEntriesPagedResponse> createAsync(
        PageContext<ListEntriesRequest, ListEntriesResponse, Entry> context,
        ApiFuture<ListEntriesResponse> futureResponse) {
      ApiFuture<ListEntriesPage> futurePage =
          ListEntriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListEntriesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListEntriesPagedResponse(ListEntriesPage page) {
      super(page, ListEntriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEntriesPage
      extends AbstractPage<ListEntriesRequest, ListEntriesResponse, Entry, ListEntriesPage> {

    private ListEntriesPage(
        PageContext<ListEntriesRequest, ListEntriesResponse, Entry> context,
        ListEntriesResponse response) {
      super(context, response);
    }

    private static ListEntriesPage createEmptyPage() {
      return new ListEntriesPage(null, null);
    }

    @Override
    protected ListEntriesPage createPage(
        PageContext<ListEntriesRequest, ListEntriesResponse, Entry> context,
        ListEntriesResponse response) {
      return new ListEntriesPage(context, response);
    }

    @Override
    public ApiFuture<ListEntriesPage> createPageAsync(
        PageContext<ListEntriesRequest, ListEntriesResponse, Entry> context,
        ApiFuture<ListEntriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEntriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEntriesRequest,
          ListEntriesResponse,
          Entry,
          ListEntriesPage,
          ListEntriesFixedSizeCollection> {

    private ListEntriesFixedSizeCollection(List<ListEntriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEntriesFixedSizeCollection createEmptyCollection() {
      return new ListEntriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEntriesFixedSizeCollection createCollection(
        List<ListEntriesPage> pages, int collectionSize) {
      return new ListEntriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTagsPagedResponse
      extends AbstractPagedListResponse<
          ListTagsRequest, ListTagsResponse, Tag, ListTagsPage, ListTagsFixedSizeCollection> {

    public static ApiFuture<ListTagsPagedResponse> createAsync(
        PageContext<ListTagsRequest, ListTagsResponse, Tag> context,
        ApiFuture<ListTagsResponse> futureResponse) {
      ApiFuture<ListTagsPage> futurePage =
          ListTagsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListTagsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListTagsPagedResponse(ListTagsPage page) {
      super(page, ListTagsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTagsPage
      extends AbstractPage<ListTagsRequest, ListTagsResponse, Tag, ListTagsPage> {

    private ListTagsPage(
        PageContext<ListTagsRequest, ListTagsResponse, Tag> context, ListTagsResponse response) {
      super(context, response);
    }

    private static ListTagsPage createEmptyPage() {
      return new ListTagsPage(null, null);
    }

    @Override
    protected ListTagsPage createPage(
        PageContext<ListTagsRequest, ListTagsResponse, Tag> context, ListTagsResponse response) {
      return new ListTagsPage(context, response);
    }

    @Override
    public ApiFuture<ListTagsPage> createPageAsync(
        PageContext<ListTagsRequest, ListTagsResponse, Tag> context,
        ApiFuture<ListTagsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTagsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTagsRequest, ListTagsResponse, Tag, ListTagsPage, ListTagsFixedSizeCollection> {

    private ListTagsFixedSizeCollection(List<ListTagsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTagsFixedSizeCollection createEmptyCollection() {
      return new ListTagsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTagsFixedSizeCollection createCollection(
        List<ListTagsPage> pages, int collectionSize) {
      return new ListTagsFixedSizeCollection(pages, collectionSize);
    }
  }
}
