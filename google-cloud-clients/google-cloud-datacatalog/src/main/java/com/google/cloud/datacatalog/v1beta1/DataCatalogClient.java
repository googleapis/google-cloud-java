/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.datacatalog.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.datacatalog.CreateEntryGroupRequest;
import com.google.cloud.datacatalog.CreateEntryRequest;
import com.google.cloud.datacatalog.CreateTagRequest;
import com.google.cloud.datacatalog.CreateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.CreateTagTemplateRequest;
import com.google.cloud.datacatalog.DeleteEntryGroupRequest;
import com.google.cloud.datacatalog.DeleteEntryRequest;
import com.google.cloud.datacatalog.DeleteTagRequest;
import com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest;
import com.google.cloud.datacatalog.DeleteTagTemplateRequest;
import com.google.cloud.datacatalog.Entry;
import com.google.cloud.datacatalog.EntryGroup;
import com.google.cloud.datacatalog.GetEntryGroupRequest;
import com.google.cloud.datacatalog.GetEntryRequest;
import com.google.cloud.datacatalog.GetTagTemplateRequest;
import com.google.cloud.datacatalog.ListTagsRequest;
import com.google.cloud.datacatalog.ListTagsResponse;
import com.google.cloud.datacatalog.LookupEntryRequest;
import com.google.cloud.datacatalog.RenameTagTemplateFieldRequest;
import com.google.cloud.datacatalog.SearchCatalogRequest;
import com.google.cloud.datacatalog.SearchCatalogResponse;
import com.google.cloud.datacatalog.SearchCatalogResult;
import com.google.cloud.datacatalog.Tag;
import com.google.cloud.datacatalog.TagTemplate;
import com.google.cloud.datacatalog.TagTemplateField;
import com.google.cloud.datacatalog.UpdateEntryRequest;
import com.google.cloud.datacatalog.UpdateTagRequest;
import com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.UpdateTagTemplateRequest;
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

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Data Catalog API service allows clients to discover, understand, and manage
 * their data.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
 *   String formattedParent = DataCatalogClient.formatLocationName("[PROJECT]", "[LOCATION]");
 *   String entryGroupId = "";
 *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
 *   EntryGroup response = dataCatalogClient.createEntryGroup(formattedParent, entryGroupId, entryGroup);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the dataCatalogClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
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
 * <pre>
 * <code>
 * DataCatalogSettings dataCatalogSettings =
 *     DataCatalogSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataCatalogClient dataCatalogClient =
 *     DataCatalogClient.create(dataCatalogSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * DataCatalogSettings dataCatalogSettings =
 *     DataCatalogSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataCatalogClient dataCatalogClient =
 *     DataCatalogClient.create(dataCatalogSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class DataCatalogClient implements BackgroundResource {
  private final DataCatalogSettings settings;
  private final DataCatalogStub stub;

  private static final PathTemplate ENTRY_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/entryGroups/{entry_group}/entries/{entry}");

  private static final PathTemplate ENTRY_GROUP_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/entryGroups/{entry_group}");

  private static final PathTemplate FIELD_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/tagTemplates/{tag_template}/fields/{field}");

  private static final PathTemplate LOCATION_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}");

  private static final PathTemplate TAG_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/entryGroups/{entry_group}/entries/{entry}/tags/{tag}");

  private static final PathTemplate TAG_TEMPLATE_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/tagTemplates/{tag_template}");

  /**
   * Formats a string containing the fully-qualified path to represent a entry resource.
   *
   * @deprecated Use the {@link EntryName} class instead.
   */
  @Deprecated
  public static final String formatEntryName(
      String project, String location, String entryGroup, String entry) {
    return ENTRY_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "entry_group", entryGroup,
        "entry", entry);
  }

  /**
   * Formats a string containing the fully-qualified path to represent a entry_group resource.
   *
   * @deprecated Use the {@link EntryGroupName} class instead.
   */
  @Deprecated
  public static final String formatEntryGroupName(
      String project, String location, String entryGroup) {
    return ENTRY_GROUP_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "entry_group", entryGroup);
  }

  /**
   * Formats a string containing the fully-qualified path to represent a field resource.
   *
   * @deprecated Use the {@link FieldName} class instead.
   */
  @Deprecated
  public static final String formatFieldName(
      String project, String location, String tagTemplate, String field) {
    return FIELD_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "tag_template", tagTemplate,
        "field", field);
  }

  /**
   * Formats a string containing the fully-qualified path to represent a location resource.
   *
   * @deprecated Use the {@link LocationName} class instead.
   */
  @Deprecated
  public static final String formatLocationName(String project, String location) {
    return LOCATION_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location);
  }

  /**
   * Formats a string containing the fully-qualified path to represent a tag resource.
   *
   * @deprecated Use the {@link TagName} class instead.
   */
  @Deprecated
  public static final String formatTagName(
      String project, String location, String entryGroup, String entry, String tag) {
    return TAG_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "entry_group", entryGroup,
        "entry", entry,
        "tag", tag);
  }

  /**
   * Formats a string containing the fully-qualified path to represent a tag_template resource.
   *
   * @deprecated Use the {@link TagTemplateName} class instead.
   */
  @Deprecated
  public static final String formatTagTemplateName(
      String project, String location, String tagTemplate) {
    return TAG_TEMPLATE_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "tag_template", tagTemplate);
  }

  /**
   * Parses the project from the given fully-qualified path which represents a entry resource.
   *
   * @deprecated Use the {@link EntryName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromEntryName(String entryName) {
    return ENTRY_PATH_TEMPLATE.parse(entryName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a entry resource.
   *
   * @deprecated Use the {@link EntryName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromEntryName(String entryName) {
    return ENTRY_PATH_TEMPLATE.parse(entryName).get("location");
  }

  /**
   * Parses the entry_group from the given fully-qualified path which represents a entry resource.
   *
   * @deprecated Use the {@link EntryName} class instead.
   */
  @Deprecated
  public static final String parseEntryGroupFromEntryName(String entryName) {
    return ENTRY_PATH_TEMPLATE.parse(entryName).get("entry_group");
  }

  /**
   * Parses the entry from the given fully-qualified path which represents a entry resource.
   *
   * @deprecated Use the {@link EntryName} class instead.
   */
  @Deprecated
  public static final String parseEntryFromEntryName(String entryName) {
    return ENTRY_PATH_TEMPLATE.parse(entryName).get("entry");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a entry_group resource.
   *
   * @deprecated Use the {@link EntryGroupName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromEntryGroupName(String entryGroupName) {
    return ENTRY_GROUP_PATH_TEMPLATE.parse(entryGroupName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a entry_group
   * resource.
   *
   * @deprecated Use the {@link EntryGroupName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromEntryGroupName(String entryGroupName) {
    return ENTRY_GROUP_PATH_TEMPLATE.parse(entryGroupName).get("location");
  }

  /**
   * Parses the entry_group from the given fully-qualified path which represents a entry_group
   * resource.
   *
   * @deprecated Use the {@link EntryGroupName} class instead.
   */
  @Deprecated
  public static final String parseEntryGroupFromEntryGroupName(String entryGroupName) {
    return ENTRY_GROUP_PATH_TEMPLATE.parse(entryGroupName).get("entry_group");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a field resource.
   *
   * @deprecated Use the {@link FieldName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromFieldName(String fieldName) {
    return FIELD_PATH_TEMPLATE.parse(fieldName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a field resource.
   *
   * @deprecated Use the {@link FieldName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromFieldName(String fieldName) {
    return FIELD_PATH_TEMPLATE.parse(fieldName).get("location");
  }

  /**
   * Parses the tag_template from the given fully-qualified path which represents a field resource.
   *
   * @deprecated Use the {@link FieldName} class instead.
   */
  @Deprecated
  public static final String parseTagTemplateFromFieldName(String fieldName) {
    return FIELD_PATH_TEMPLATE.parse(fieldName).get("tag_template");
  }

  /**
   * Parses the field from the given fully-qualified path which represents a field resource.
   *
   * @deprecated Use the {@link FieldName} class instead.
   */
  @Deprecated
  public static final String parseFieldFromFieldName(String fieldName) {
    return FIELD_PATH_TEMPLATE.parse(fieldName).get("field");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a location resource.
   *
   * @deprecated Use the {@link LocationName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromLocationName(String locationName) {
    return LOCATION_PATH_TEMPLATE.parse(locationName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a location resource.
   *
   * @deprecated Use the {@link LocationName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromLocationName(String locationName) {
    return LOCATION_PATH_TEMPLATE.parse(locationName).get("location");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a tag resource.
   *
   * @deprecated Use the {@link TagName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromTagName(String tagName) {
    return TAG_PATH_TEMPLATE.parse(tagName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a tag resource.
   *
   * @deprecated Use the {@link TagName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromTagName(String tagName) {
    return TAG_PATH_TEMPLATE.parse(tagName).get("location");
  }

  /**
   * Parses the entry_group from the given fully-qualified path which represents a tag resource.
   *
   * @deprecated Use the {@link TagName} class instead.
   */
  @Deprecated
  public static final String parseEntryGroupFromTagName(String tagName) {
    return TAG_PATH_TEMPLATE.parse(tagName).get("entry_group");
  }

  /**
   * Parses the entry from the given fully-qualified path which represents a tag resource.
   *
   * @deprecated Use the {@link TagName} class instead.
   */
  @Deprecated
  public static final String parseEntryFromTagName(String tagName) {
    return TAG_PATH_TEMPLATE.parse(tagName).get("entry");
  }

  /**
   * Parses the tag from the given fully-qualified path which represents a tag resource.
   *
   * @deprecated Use the {@link TagName} class instead.
   */
  @Deprecated
  public static final String parseTagFromTagName(String tagName) {
    return TAG_PATH_TEMPLATE.parse(tagName).get("tag");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a tag_template
   * resource.
   *
   * @deprecated Use the {@link TagTemplateName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromTagTemplateName(String tagTemplateName) {
    return TAG_TEMPLATE_PATH_TEMPLATE.parse(tagTemplateName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a tag_template
   * resource.
   *
   * @deprecated Use the {@link TagTemplateName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromTagTemplateName(String tagTemplateName) {
    return TAG_TEMPLATE_PATH_TEMPLATE.parse(tagTemplateName).get("location");
  }

  /**
   * Parses the tag_template from the given fully-qualified path which represents a tag_template
   * resource.
   *
   * @deprecated Use the {@link TagTemplateName} class instead.
   */
  @Deprecated
  public static final String parseTagTemplateFromTagTemplateName(String tagTemplateName) {
    return TAG_TEMPLATE_PATH_TEMPLATE.parse(tagTemplateName).get("tag_template");
  }

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
   * advanced usage - prefer to use DataCatalogSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DataCatalogClient(DataCatalogStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DataCatalogSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DataCatalogStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches Data Catalog for multiple resources like entries, tags that match a query.
   *
   * <p>This is a custom method (https://cloud.google.com/apis/design/custom_methods) and does not
   * return the complete resource, only the resource identifier and high level fields. Clients can
   * subsequentally call `Get` methods.
   *
   * <p>Note that searches do not have full recall. There may be results that match your query but
   * are not returned, even in subsequent pages of results. These missing results may vary across
   * repeated calls to search. Do not rely on this method if you need to guarantee full recall.
   *
   * <p>See [Data Catalog Search Syntax](/data-catalog/docs/how-to/search-reference) for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SearchCatalogRequest.Scope scope = SearchCatalogRequest.Scope.newBuilder().build();
   *   String query = "";
   *   String orderBy = "";
   *   for (SearchCatalogResult element : dataCatalogClient.searchCatalog(scope, query, orderBy).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param scope Required. The scope of this search request.
   * @param query Required. The query string in search query syntax. The query must be non-empty.
   *     <p>Query strings can be simple as "x" or more qualified as:
   *     <p>&#42; name:x &#42; column:x &#42; description:y
   *     <p>Note: Query tokens need to have a minimum of 3 characters for substring matching to work
   *     correctly. See [Data Catalog Search Syntax](/data-catalog/docs/how-to/search-reference) for
   *     more information.
   * @param orderBy Specifies the ordering of results, currently supported case-sensitive choices
   *     are:
   *     <p>&#42; `relevance`, only supports desecending &#42; `last_access_timestamp [asc|desc]`,
   *     defaults to descending if not specified &#42; `last_modified_timestamp [asc|desc]`,
   *     defaults to descending if not specified
   *     <p>If not specified, defaults to `relevance` descending.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchCatalogPagedResponse searchCatalog(
      SearchCatalogRequest.Scope scope, String query, String orderBy) {
    SearchCatalogRequest request =
        SearchCatalogRequest.newBuilder()
            .setScope(scope)
            .setQuery(query)
            .setOrderBy(orderBy)
            .build();
    return searchCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches Data Catalog for multiple resources like entries, tags that match a query.
   *
   * <p>This is a custom method (https://cloud.google.com/apis/design/custom_methods) and does not
   * return the complete resource, only the resource identifier and high level fields. Clients can
   * subsequentally call `Get` methods.
   *
   * <p>Note that searches do not have full recall. There may be results that match your query but
   * are not returned, even in subsequent pages of results. These missing results may vary across
   * repeated calls to search. Do not rely on this method if you need to guarantee full recall.
   *
   * <p>See [Data Catalog Search Syntax](/data-catalog/docs/how-to/search-reference) for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SearchCatalogRequest.Scope scope = SearchCatalogRequest.Scope.newBuilder().build();
   *   String query = "";
   *   String orderBy = "";
   *   SearchCatalogRequest request = SearchCatalogRequest.newBuilder()
   *     .setScope(scope)
   *     .setQuery(query)
   *     .setOrderBy(orderBy)
   *     .build();
   *   for (SearchCatalogResult element : dataCatalogClient.searchCatalog(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchCatalogPagedResponse searchCatalog(SearchCatalogRequest request) {
    return searchCatalogPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches Data Catalog for multiple resources like entries, tags that match a query.
   *
   * <p>This is a custom method (https://cloud.google.com/apis/design/custom_methods) and does not
   * return the complete resource, only the resource identifier and high level fields. Clients can
   * subsequentally call `Get` methods.
   *
   * <p>Note that searches do not have full recall. There may be results that match your query but
   * are not returned, even in subsequent pages of results. These missing results may vary across
   * repeated calls to search. Do not rely on this method if you need to guarantee full recall.
   *
   * <p>See [Data Catalog Search Syntax](/data-catalog/docs/how-to/search-reference) for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SearchCatalogRequest.Scope scope = SearchCatalogRequest.Scope.newBuilder().build();
   *   String query = "";
   *   String orderBy = "";
   *   SearchCatalogRequest request = SearchCatalogRequest.newBuilder()
   *     .setScope(scope)
   *     .setQuery(query)
   *     .setOrderBy(orderBy)
   *     .build();
   *   ApiFuture&lt;SearchCatalogPagedResponse&gt; future = dataCatalogClient.searchCatalogPagedCallable().futureCall(request);
   *   // Do something
   *   for (SearchCatalogResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<SearchCatalogRequest, SearchCatalogPagedResponse>
      searchCatalogPagedCallable() {
    return stub.searchCatalogPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches Data Catalog for multiple resources like entries, tags that match a query.
   *
   * <p>This is a custom method (https://cloud.google.com/apis/design/custom_methods) and does not
   * return the complete resource, only the resource identifier and high level fields. Clients can
   * subsequentally call `Get` methods.
   *
   * <p>Note that searches do not have full recall. There may be results that match your query but
   * are not returned, even in subsequent pages of results. These missing results may vary across
   * repeated calls to search. Do not rely on this method if you need to guarantee full recall.
   *
   * <p>See [Data Catalog Search Syntax](/data-catalog/docs/how-to/search-reference) for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SearchCatalogRequest.Scope scope = SearchCatalogRequest.Scope.newBuilder().build();
   *   String query = "";
   *   String orderBy = "";
   *   SearchCatalogRequest request = SearchCatalogRequest.newBuilder()
   *     .setScope(scope)
   *     .setQuery(query)
   *     .setOrderBy(orderBy)
   *     .build();
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
   * </code></pre>
   */
  public final UnaryCallable<SearchCatalogRequest, SearchCatalogResponse> searchCatalogCallable() {
    return stub.searchCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Creates an EntryGroup. The user should enable the Data Catalog API in the
   * project identified by the `parent` parameter (see [Data Catalog Resource Project]
   * (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String entryGroupId = "";
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.createEntryGroup(formattedParent, entryGroupId, entryGroup);
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the project this entry group is in. Example:
   *     <p>&#42; projects/{project_id}/locations/{location}
   *     <p>Note that this EntryGroup and its child resources may not actually be stored in the
   *     location in this name.
   * @param entryGroupId Required. The id of the entry group to create.
   * @param entryGroup Optional. The entry group to create. Defaults to an empty entry group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup createEntryGroup(
      String parent, String entryGroupId, EntryGroup entryGroup) {
    LOCATION_PATH_TEMPLATE.validate(parent, "createEntryGroup");
    CreateEntryGroupRequest request =
        CreateEntryGroupRequest.newBuilder()
            .setParent(parent)
            .setEntryGroupId(entryGroupId)
            .setEntryGroup(entryGroup)
            .build();
    return createEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Creates an EntryGroup. The user should enable the Data Catalog API in the
   * project identified by the `parent` parameter (see [Data Catalog Resource Project]
   * (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String entryGroupId = "";
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   CreateEntryGroupRequest request = CreateEntryGroupRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setEntryGroupId(entryGroupId)
   *     .setEntryGroup(entryGroup)
   *     .build();
   *   EntryGroup response = dataCatalogClient.createEntryGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup createEntryGroup(CreateEntryGroupRequest request) {
    return createEntryGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Creates an EntryGroup. The user should enable the Data Catalog API in the
   * project identified by the `parent` parameter (see [Data Catalog Resource Project]
   * (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String entryGroupId = "";
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   CreateEntryGroupRequest request = CreateEntryGroupRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setEntryGroupId(entryGroupId)
   *     .setEntryGroup(entryGroup)
   *     .build();
   *   ApiFuture&lt;EntryGroup&gt; future = dataCatalogClient.createEntryGroupCallable().futureCall(request);
   *   // Do something
   *   EntryGroup response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateEntryGroupRequest, EntryGroup> createEntryGroupCallable() {
    return stub.createEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatEntryGroupName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   FieldMask readMask = FieldMask.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.getEntryGroup(formattedName, readMask);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the entry group. For example,
   *     `projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}`.
   * @param readMask Optional. The fields to return. If not set or empty, all fields are returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup getEntryGroup(String name, FieldMask readMask) {
    ENTRY_GROUP_PATH_TEMPLATE.validate(name, "getEntryGroup");
    GetEntryGroupRequest request =
        GetEntryGroupRequest.newBuilder().setName(name).setReadMask(readMask).build();
    return getEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatEntryGroupName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   GetEntryGroupRequest request = GetEntryGroupRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   EntryGroup response = dataCatalogClient.getEntryGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup getEntryGroup(GetEntryGroupRequest request) {
    return getEntryGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatEntryGroupName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   GetEntryGroupRequest request = GetEntryGroupRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;EntryGroup&gt; future = dataCatalogClient.getEntryGroupCallable().futureCall(request);
   *   // Do something
   *   EntryGroup response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable() {
    return stub.getEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Deletes an EntryGroup. Only entry groups that do not contain entries can be
   * deleted. The user should enable the Data Catalog API in the project identified by the `name`
   * parameter (see [Data Catalog Resource Project] (/data-catalog/docs/concepts/resource-project)
   * for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatEntryGroupName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   dataCatalogClient.deleteEntryGroup(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the entry group. For example,
   *     `projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntryGroup(String name) {
    ENTRY_GROUP_PATH_TEMPLATE.validate(name, "deleteEntryGroup");
    DeleteEntryGroupRequest request = DeleteEntryGroupRequest.newBuilder().setName(name).build();
    deleteEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Deletes an EntryGroup. Only entry groups that do not contain entries can be
   * deleted. The user should enable the Data Catalog API in the project identified by the `name`
   * parameter (see [Data Catalog Resource Project] (/data-catalog/docs/concepts/resource-project)
   * for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatEntryGroupName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   DeleteEntryGroupRequest request = DeleteEntryGroupRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   dataCatalogClient.deleteEntryGroup(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntryGroup(DeleteEntryGroupRequest request) {
    deleteEntryGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Deletes an EntryGroup. Only entry groups that do not contain entries can be
   * deleted. The user should enable the Data Catalog API in the project identified by the `name`
   * parameter (see [Data Catalog Resource Project] (/data-catalog/docs/concepts/resource-project)
   * for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatEntryGroupName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   DeleteEntryGroupRequest request = DeleteEntryGroupRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = dataCatalogClient.deleteEntryGroupCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteEntryGroupRequest, Empty> deleteEntryGroupCallable() {
    return stub.deleteEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Creates an entry. Currently only entries of 'FILESET' type can be created. The
   * user should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project] (/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatEntryGroupName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   String entryId = "";
   *   Entry entry = Entry.newBuilder().build();
   *   Entry response = dataCatalogClient.createEntry(formattedParent, entryId, entry);
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the entry group this entry is in. Example:
   *     <p>&#42; projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}
   *     <p>Note that this Entry and its child resources may not actually be stored in the location
   *     in this name.
   * @param entryId Required. The id of the entry to create.
   * @param entry Required. The entry to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry createEntry(String parent, String entryId, Entry entry) {
    ENTRY_GROUP_PATH_TEMPLATE.validate(parent, "createEntry");
    CreateEntryRequest request =
        CreateEntryRequest.newBuilder()
            .setParent(parent)
            .setEntryId(entryId)
            .setEntry(entry)
            .build();
    return createEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Creates an entry. Currently only entries of 'FILESET' type can be created. The
   * user should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project] (/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatEntryGroupName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   String entryId = "";
   *   Entry entry = Entry.newBuilder().build();
   *   CreateEntryRequest request = CreateEntryRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setEntryId(entryId)
   *     .setEntry(entry)
   *     .build();
   *   Entry response = dataCatalogClient.createEntry(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry createEntry(CreateEntryRequest request) {
    return createEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Creates an entry. Currently only entries of 'FILESET' type can be created. The
   * user should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project] (/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatEntryGroupName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   String entryId = "";
   *   Entry entry = Entry.newBuilder().build();
   *   CreateEntryRequest request = CreateEntryRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setEntryId(entryId)
   *     .setEntry(entry)
   *     .build();
   *   ApiFuture&lt;Entry&gt; future = dataCatalogClient.createEntryCallable().futureCall(request);
   *   // Do something
   *   Entry response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateEntryRequest, Entry> createEntryCallable() {
    return stub.createEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing entry. The user should enable the Data Catalog API in the project
   * identified by the `entry.name` parameter (see [Data Catalog Resource Project]
   * (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Entry entry = Entry.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Entry response = dataCatalogClient.updateEntry(entry, updateMask);
   * }
   * </code></pre>
   *
   * @param entry Required. The updated entry.
   * @param updateMask Optional. The fields to update on the entry. If absent or empty, all
   *     modifiable fields are updated.
   *     <p>Currently only `schema` field in Cloud Pub/Sub topic entries is modifiable.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry updateEntry(Entry entry, FieldMask updateMask) {

    UpdateEntryRequest request =
        UpdateEntryRequest.newBuilder().setEntry(entry).setUpdateMask(updateMask).build();
    return updateEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing entry. The user should enable the Data Catalog API in the project
   * identified by the `entry.name` parameter (see [Data Catalog Resource Project]
   * (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Entry entry = Entry.newBuilder().build();
   *   UpdateEntryRequest request = UpdateEntryRequest.newBuilder()
   *     .setEntry(entry)
   *     .build();
   *   Entry response = dataCatalogClient.updateEntry(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry updateEntry(UpdateEntryRequest request) {
    return updateEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing entry. The user should enable the Data Catalog API in the project
   * identified by the `entry.name` parameter (see [Data Catalog Resource Project]
   * (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Entry entry = Entry.newBuilder().build();
   *   UpdateEntryRequest request = UpdateEntryRequest.newBuilder()
   *     .setEntry(entry)
   *     .build();
   *   ApiFuture&lt;Entry&gt; future = dataCatalogClient.updateEntryCallable().futureCall(request);
   *   // Do something
   *   Entry response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateEntryRequest, Entry> updateEntryCallable() {
    return stub.updateEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Deletes an existing entry. Only entries created through
   * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry] method can be deleted.
   * The user should enable the Data Catalog API in the project identified by the `name` parameter
   * (see [Data Catalog Resource Project] (/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   dataCatalogClient.deleteEntry(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the entry. Example:
   *     <p>&#42;
   *     projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntry(String name) {
    ENTRY_PATH_TEMPLATE.validate(name, "deleteEntry");
    DeleteEntryRequest request = DeleteEntryRequest.newBuilder().setName(name).build();
    deleteEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Deletes an existing entry. Only entries created through
   * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry] method can be deleted.
   * The user should enable the Data Catalog API in the project identified by the `name` parameter
   * (see [Data Catalog Resource Project] (/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   DeleteEntryRequest request = DeleteEntryRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   dataCatalogClient.deleteEntry(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntry(DeleteEntryRequest request) {
    deleteEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Alpha feature. Deletes an existing entry. Only entries created through
   * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry] method can be deleted.
   * The user should enable the Data Catalog API in the project identified by the `name` parameter
   * (see [Data Catalog Resource Project] (/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   DeleteEntryRequest request = DeleteEntryRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = dataCatalogClient.deleteEntryCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteEntryRequest, Empty> deleteEntryCallable() {
    return stub.deleteEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets an entry.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   Entry response = dataCatalogClient.getEntry(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the entry. Example:
   *     <p>&#42;
   *     projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     <p>Entry groups are logical groupings of entries. Currently, users cannot create/modify
   *     entry groups. They are created by Data Catalog; they include `{@literal @}bigquery` for all
   *     BigQuery entries, and `{@literal @}pubsub` for all Cloud Pub/Sub entries.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry getEntry(String name) {
    ENTRY_PATH_TEMPLATE.validate(name, "getEntry");
    GetEntryRequest request = GetEntryRequest.newBuilder().setName(name).build();
    return getEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets an entry.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   GetEntryRequest request = GetEntryRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Entry response = dataCatalogClient.getEntry(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry getEntry(GetEntryRequest request) {
    return getEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets an entry.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   GetEntryRequest request = GetEntryRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Entry&gt; future = dataCatalogClient.getEntryCallable().futureCall(request);
   *   // Do something
   *   Entry response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetEntryRequest, Entry> getEntryCallable() {
    return stub.getEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get an entry by target resource name. This method allows clients to use the resource name from
   * the source Google Cloud Platform service to get the Data Catalog Entry.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   LookupEntryRequest request = LookupEntryRequest.newBuilder().build();
   *   Entry response = dataCatalogClient.lookupEntry(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry lookupEntry(LookupEntryRequest request) {
    return lookupEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Get an entry by target resource name. This method allows clients to use the resource name from
   * the source Google Cloud Platform service to get the Data Catalog Entry.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   LookupEntryRequest request = LookupEntryRequest.newBuilder().build();
   *   ApiFuture&lt;Entry&gt; future = dataCatalogClient.lookupEntryCallable().futureCall(request);
   *   // Do something
   *   Entry response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<LookupEntryRequest, Entry> lookupEntryCallable() {
    return stub.lookupEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a tag template. The user should enable the Data Catalog API in the project identified
   * by the `parent` parameter (see [Data Catalog Resource
   * Project](/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String tagTemplateId = "";
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   TagTemplate response = dataCatalogClient.createTagTemplate(formattedParent, tagTemplateId, tagTemplate);
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the project and the location this template is in. Example:
   *     <p>&#42; projects/{project_id}/locations/{location}
   *     <p>TagTemplate and its child resources may not actually be stored in the location in this
   *     name.
   * @param tagTemplateId Required. The id of the tag template to create.
   * @param tagTemplate Required. The tag template to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate createTagTemplate(
      String parent, String tagTemplateId, TagTemplate tagTemplate) {
    LOCATION_PATH_TEMPLATE.validate(parent, "createTagTemplate");
    CreateTagTemplateRequest request =
        CreateTagTemplateRequest.newBuilder()
            .setParent(parent)
            .setTagTemplateId(tagTemplateId)
            .setTagTemplate(tagTemplate)
            .build();
    return createTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a tag template. The user should enable the Data Catalog API in the project identified
   * by the `parent` parameter (see [Data Catalog Resource
   * Project](/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String tagTemplateId = "";
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   CreateTagTemplateRequest request = CreateTagTemplateRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setTagTemplateId(tagTemplateId)
   *     .setTagTemplate(tagTemplate)
   *     .build();
   *   TagTemplate response = dataCatalogClient.createTagTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate createTagTemplate(CreateTagTemplateRequest request) {
    return createTagTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a tag template. The user should enable the Data Catalog API in the project identified
   * by the `parent` parameter (see [Data Catalog Resource
   * Project](/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatLocationName("[PROJECT]", "[LOCATION]");
   *   String tagTemplateId = "";
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   CreateTagTemplateRequest request = CreateTagTemplateRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setTagTemplateId(tagTemplateId)
   *     .setTagTemplate(tagTemplate)
   *     .build();
   *   ApiFuture&lt;TagTemplate&gt; future = dataCatalogClient.createTagTemplateCallable().futureCall(request);
   *   // Do something
   *   TagTemplate response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateTagTemplateRequest, TagTemplate> createTagTemplateCallable() {
    return stub.createTagTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a tag template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   TagTemplate response = dataCatalogClient.getTagTemplate(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the tag template. Example:
   *     <p>&#42; projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate getTagTemplate(String name) {
    TAG_TEMPLATE_PATH_TEMPLATE.validate(name, "getTagTemplate");
    GetTagTemplateRequest request = GetTagTemplateRequest.newBuilder().setName(name).build();
    return getTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a tag template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   GetTagTemplateRequest request = GetTagTemplateRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   TagTemplate response = dataCatalogClient.getTagTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate getTagTemplate(GetTagTemplateRequest request) {
    return getTagTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a tag template.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   GetTagTemplateRequest request = GetTagTemplateRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;TagTemplate&gt; future = dataCatalogClient.getTagTemplateCallable().futureCall(request);
   *   // Do something
   *   TagTemplate response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetTagTemplateRequest, TagTemplate> getTagTemplateCallable() {
    return stub.getTagTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a tag template. This method cannot be used to update the fields of a template. The tag
   * template fields are represented as separate resources and should be updated using their own
   * create/update/delete methods. The user should enable the Data Catalog API in the project
   * identified by the `tag_template.name` parameter (see [Data Catalog Resource Project]
   * (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TagTemplate response = dataCatalogClient.updateTagTemplate(tagTemplate, updateMask);
   * }
   * </code></pre>
   *
   * @param tagTemplate Required. The template to update.
   * @param updateMask Optional. The field mask specifies the parts of the template to overwrite.
   *     <p>Allowed fields:
   *     <p>&#42; `display_name`
   *     <p>If absent or empty, all of the allowed fields above will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate updateTagTemplate(TagTemplate tagTemplate, FieldMask updateMask) {

    UpdateTagTemplateRequest request =
        UpdateTagTemplateRequest.newBuilder()
            .setTagTemplate(tagTemplate)
            .setUpdateMask(updateMask)
            .build();
    return updateTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a tag template. This method cannot be used to update the fields of a template. The tag
   * template fields are represented as separate resources and should be updated using their own
   * create/update/delete methods. The user should enable the Data Catalog API in the project
   * identified by the `tag_template.name` parameter (see [Data Catalog Resource Project]
   * (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   UpdateTagTemplateRequest request = UpdateTagTemplateRequest.newBuilder()
   *     .setTagTemplate(tagTemplate)
   *     .build();
   *   TagTemplate response = dataCatalogClient.updateTagTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate updateTagTemplate(UpdateTagTemplateRequest request) {
    return updateTagTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a tag template. This method cannot be used to update the fields of a template. The tag
   * template fields are represented as separate resources and should be updated using their own
   * create/update/delete methods. The user should enable the Data Catalog API in the project
   * identified by the `tag_template.name` parameter (see [Data Catalog Resource Project]
   * (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   UpdateTagTemplateRequest request = UpdateTagTemplateRequest.newBuilder()
   *     .setTagTemplate(tagTemplate)
   *     .build();
   *   ApiFuture&lt;TagTemplate&gt; future = dataCatalogClient.updateTagTemplateCallable().futureCall(request);
   *   // Do something
   *   TagTemplate response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateCallable() {
    return stub.updateTagTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a tag template and all tags using the template. The user should enable the Data Catalog
   * API in the project identified by the `name` parameter (see [Data Catalog Resource Project]
   * (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   boolean force = false;
   *   dataCatalogClient.deleteTagTemplate(formattedName, force);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the tag template to delete. Example:
   *     <p>&#42; projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}
   * @param force Required. Currently, this field must always be set to `true`. This confirms the
   *     deletion of any possible tags using this template. `force = false` will be supported in the
   *     future.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTagTemplate(String name, boolean force) {
    TAG_TEMPLATE_PATH_TEMPLATE.validate(name, "deleteTagTemplate");
    DeleteTagTemplateRequest request =
        DeleteTagTemplateRequest.newBuilder().setName(name).setForce(force).build();
    deleteTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a tag template and all tags using the template. The user should enable the Data Catalog
   * API in the project identified by the `name` parameter (see [Data Catalog Resource Project]
   * (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   boolean force = false;
   *   DeleteTagTemplateRequest request = DeleteTagTemplateRequest.newBuilder()
   *     .setName(formattedName)
   *     .setForce(force)
   *     .build();
   *   dataCatalogClient.deleteTagTemplate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTagTemplate(DeleteTagTemplateRequest request) {
    deleteTagTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a tag template and all tags using the template. The user should enable the Data Catalog
   * API in the project identified by the `name` parameter (see [Data Catalog Resource Project]
   * (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   boolean force = false;
   *   DeleteTagTemplateRequest request = DeleteTagTemplateRequest.newBuilder()
   *     .setName(formattedName)
   *     .setForce(force)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = dataCatalogClient.deleteTagTemplateCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteTagTemplateRequest, Empty> deleteTagTemplateCallable() {
    return stub.deleteTagTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `parent` parameter (see [Data Catalog Resource
   * Project](/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   String tagTemplateFieldId = "";
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   TagTemplateField response = dataCatalogClient.createTagTemplateField(formattedParent, tagTemplateFieldId, tagTemplateField);
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the project this template is in. Example:
   *     <p>&#42; projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}
   *     <p>Note that this TagTemplateField may not actually be stored in the location in this name.
   * @param tagTemplateFieldId Required. The ID of the tag template field to create. Field ids can
   *     contain letters (both uppercase and lowercase), numbers (0-9), underscores (_) and dashes
   *     (-). Field IDs must be at least 1 character long and at most 128 characters long. Field IDs
   *     must also be unique within their template.
   * @param tagTemplateField Required. The tag template field to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField createTagTemplateField(
      String parent, String tagTemplateFieldId, TagTemplateField tagTemplateField) {
    TAG_TEMPLATE_PATH_TEMPLATE.validate(parent, "createTagTemplateField");
    CreateTagTemplateFieldRequest request =
        CreateTagTemplateFieldRequest.newBuilder()
            .setParent(parent)
            .setTagTemplateFieldId(tagTemplateFieldId)
            .setTagTemplateField(tagTemplateField)
            .build();
    return createTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `parent` parameter (see [Data Catalog Resource
   * Project](/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   String tagTemplateFieldId = "";
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   CreateTagTemplateFieldRequest request = CreateTagTemplateFieldRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setTagTemplateFieldId(tagTemplateFieldId)
   *     .setTagTemplateField(tagTemplateField)
   *     .build();
   *   TagTemplateField response = dataCatalogClient.createTagTemplateField(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField createTagTemplateField(CreateTagTemplateFieldRequest request) {
    return createTagTemplateFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `parent` parameter (see [Data Catalog Resource
   * Project](/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   String tagTemplateFieldId = "";
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   CreateTagTemplateFieldRequest request = CreateTagTemplateFieldRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setTagTemplateFieldId(tagTemplateFieldId)
   *     .setTagTemplateField(tagTemplateField)
   *     .build();
   *   ApiFuture&lt;TagTemplateField&gt; future = dataCatalogClient.createTagTemplateFieldCallable().futureCall(request);
   *   // Do something
   *   TagTemplateField response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldCallable() {
    return stub.createTagTemplateFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. The
   * user should enable the Data Catalog API in the project identified by the `name` parameter (see
   * [Data Catalog Resource Project] (/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TagTemplateField response = dataCatalogClient.updateTagTemplateField(formattedName, tagTemplateField, updateMask);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the tag template field. Example:
   *     <p>&#42;
   *     projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   * @param tagTemplateField Required. The template to update.
   * @param updateMask Optional. The field mask specifies the parts of the template to be updated.
   *     Allowed fields:
   *     <p>&#42; `display_name` &#42; `type.enum_type`
   *     <p>If `update_mask` is not set or empty, all of the allowed fields above will be updated.
   *     <p>When updating an enum type, the provided values will be merged with the existing values.
   *     Therefore, enum values can only be added, existing enum values cannot be deleted nor
   *     renamed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField updateTagTemplateField(
      String name, TagTemplateField tagTemplateField, FieldMask updateMask) {
    FIELD_PATH_TEMPLATE.validate(name, "updateTagTemplateField");
    UpdateTagTemplateFieldRequest request =
        UpdateTagTemplateFieldRequest.newBuilder()
            .setName(name)
            .setTagTemplateField(tagTemplateField)
            .setUpdateMask(updateMask)
            .build();
    return updateTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. The
   * user should enable the Data Catalog API in the project identified by the `name` parameter (see
   * [Data Catalog Resource Project] (/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   UpdateTagTemplateFieldRequest request = UpdateTagTemplateFieldRequest.newBuilder()
   *     .setName(formattedName)
   *     .setTagTemplateField(tagTemplateField)
   *     .build();
   *   TagTemplateField response = dataCatalogClient.updateTagTemplateField(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField updateTagTemplateField(UpdateTagTemplateFieldRequest request) {
    return updateTagTemplateFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. The
   * user should enable the Data Catalog API in the project identified by the `name` parameter (see
   * [Data Catalog Resource Project] (/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   UpdateTagTemplateFieldRequest request = UpdateTagTemplateFieldRequest.newBuilder()
   *     .setName(formattedName)
   *     .setTagTemplateField(tagTemplateField)
   *     .build();
   *   ApiFuture&lt;TagTemplateField&gt; future = dataCatalogClient.updateTagTemplateFieldCallable().futureCall(request);
   *   // Do something
   *   TagTemplateField response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldCallable() {
    return stub.updateTagTemplateFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Renames a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `name` parameter (see [Data Catalog Resource
   * Project](/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   String newTagTemplateFieldId = "";
   *   TagTemplateField response = dataCatalogClient.renameTagTemplateField(formattedName, newTagTemplateFieldId);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the tag template. Example:
   *     <p>&#42;
   *     projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   * @param newTagTemplateFieldId Required. The new ID of this tag template field. For example,
   *     `my_new_field`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField renameTagTemplateField(String name, String newTagTemplateFieldId) {
    FIELD_PATH_TEMPLATE.validate(name, "renameTagTemplateField");
    RenameTagTemplateFieldRequest request =
        RenameTagTemplateFieldRequest.newBuilder()
            .setName(name)
            .setNewTagTemplateFieldId(newTagTemplateFieldId)
            .build();
    return renameTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Renames a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `name` parameter (see [Data Catalog Resource
   * Project](/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   String newTagTemplateFieldId = "";
   *   RenameTagTemplateFieldRequest request = RenameTagTemplateFieldRequest.newBuilder()
   *     .setName(formattedName)
   *     .setNewTagTemplateFieldId(newTagTemplateFieldId)
   *     .build();
   *   TagTemplateField response = dataCatalogClient.renameTagTemplateField(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField renameTagTemplateField(RenameTagTemplateFieldRequest request) {
    return renameTagTemplateFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Renames a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `name` parameter (see [Data Catalog Resource
   * Project](/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   String newTagTemplateFieldId = "";
   *   RenameTagTemplateFieldRequest request = RenameTagTemplateFieldRequest.newBuilder()
   *     .setName(formattedName)
   *     .setNewTagTemplateFieldId(newTagTemplateFieldId)
   *     .build();
   *   ApiFuture&lt;TagTemplateField&gt; future = dataCatalogClient.renameTagTemplateFieldCallable().futureCall(request);
   *   // Do something
   *   TagTemplateField response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldCallable() {
    return stub.renameTagTemplateFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a field in a tag template and all uses of that field. The user should enable the Data
   * Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource
   * Project] (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   boolean force = false;
   *   dataCatalogClient.deleteTagTemplateField(formattedName, force);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the tag template field to delete. Example:
   *     <p>&#42;
   *     projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   * @param force Required. Currently, this field must always be set to `true`. This confirms the
   *     deletion of this field from any tags using this field. `force = false` will be supported in
   *     the future.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTagTemplateField(String name, boolean force) {
    FIELD_PATH_TEMPLATE.validate(name, "deleteTagTemplateField");
    DeleteTagTemplateFieldRequest request =
        DeleteTagTemplateFieldRequest.newBuilder().setName(name).setForce(force).build();
    deleteTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a field in a tag template and all uses of that field. The user should enable the Data
   * Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource
   * Project] (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   boolean force = false;
   *   DeleteTagTemplateFieldRequest request = DeleteTagTemplateFieldRequest.newBuilder()
   *     .setName(formattedName)
   *     .setForce(force)
   *     .build();
   *   dataCatalogClient.deleteTagTemplateField(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTagTemplateField(DeleteTagTemplateFieldRequest request) {
    deleteTagTemplateFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a field in a tag template and all uses of that field. The user should enable the Data
   * Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource
   * Project] (/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   boolean force = false;
   *   DeleteTagTemplateFieldRequest request = DeleteTagTemplateFieldRequest.newBuilder()
   *     .setName(formattedName)
   *     .setForce(force)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = dataCatalogClient.deleteTagTemplateFieldCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteTagTemplateFieldRequest, Empty>
      deleteTagTemplateFieldCallable() {
    return stub.deleteTagTemplateFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry]. Note: The project
   * identified by the `parent` parameter for the
   * [tag](/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag
   * template](/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be from the same organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   Tag tag = Tag.newBuilder().build();
   *   Tag response = dataCatalogClient.createTag(formattedParent, tag);
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the resource to attach this tag to. Tags can be attached to
   *     Entries. Example:
   *     <p>&#42;
   *     projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     <p>Note that this Tag and its child resources may not actually be stored in the location in
   *     this name.
   * @param tag Required. The tag to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag createTag(String parent, Tag tag) {
    ENTRY_PATH_TEMPLATE.validate(parent, "createTag");
    CreateTagRequest request = CreateTagRequest.newBuilder().setParent(parent).setTag(tag).build();
    return createTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry]. Note: The project
   * identified by the `parent` parameter for the
   * [tag](/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag
   * template](/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be from the same organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   Tag tag = Tag.newBuilder().build();
   *   CreateTagRequest request = CreateTagRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setTag(tag)
   *     .build();
   *   Tag response = dataCatalogClient.createTag(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag createTag(CreateTagRequest request) {
    return createTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry]. Note: The project
   * identified by the `parent` parameter for the
   * [tag](/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag
   * template](/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be from the same organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   Tag tag = Tag.newBuilder().build();
   *   CreateTagRequest request = CreateTagRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setTag(tag)
   *     .build();
   *   ApiFuture&lt;Tag&gt; future = dataCatalogClient.createTagCallable().futureCall(request);
   *   // Do something
   *   Tag response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateTagRequest, Tag> createTagCallable() {
    return stub.createTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Tag tag = Tag.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Tag response = dataCatalogClient.updateTag(tag, updateMask);
   * }
   * </code></pre>
   *
   * @param tag Required. The updated tag.
   * @param updateMask Optional. The fields to update on the Tag. If absent or empty, all modifiable
   *     fields are updated. Currently the only modifiable field is the field `fields`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag updateTag(Tag tag, FieldMask updateMask) {

    UpdateTagRequest request =
        UpdateTagRequest.newBuilder().setTag(tag).setUpdateMask(updateMask).build();
    return updateTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Tag tag = Tag.newBuilder().build();
   *   UpdateTagRequest request = UpdateTagRequest.newBuilder()
   *     .setTag(tag)
   *     .build();
   *   Tag response = dataCatalogClient.updateTag(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag updateTag(UpdateTagRequest request) {
    return updateTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an existing tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Tag tag = Tag.newBuilder().build();
   *   UpdateTagRequest request = UpdateTagRequest.newBuilder()
   *     .setTag(tag)
   *     .build();
   *   ApiFuture&lt;Tag&gt; future = dataCatalogClient.updateTagCallable().futureCall(request);
   *   // Do something
   *   Tag response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateTagRequest, Tag> updateTagCallable() {
    return stub.updateTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatTagName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]");
   *   dataCatalogClient.deleteTag(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the tag to delete. Example:
   *     <p>&#42;
   *     projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}/tags/{tag_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTag(String name) {
    TAG_PATH_TEMPLATE.validate(name, "deleteTag");
    DeleteTagRequest request = DeleteTagRequest.newBuilder().setName(name).build();
    deleteTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatTagName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]");
   *   DeleteTagRequest request = DeleteTagRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   dataCatalogClient.deleteTag(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTag(DeleteTagRequest request) {
    deleteTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a tag.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedName = DataCatalogClient.formatTagName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]");
   *   DeleteTagRequest request = DeleteTagRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = dataCatalogClient.deleteTagCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteTagRequest, Empty> deleteTagCallable() {
    return stub.deleteTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   for (Tag element : dataCatalogClient.listTags(formattedParent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the Data Catalog resource to list the tags of. The resource
   *     could be an [Entry][google.cloud.datacatalog.v1beta1.Entry].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagsPagedResponse listTags(String parent) {
    ENTRY_PATH_TEMPLATE.validate(parent, "listTags");
    ListTagsRequest request = ListTagsRequest.newBuilder().setParent(parent).build();
    return listTags(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   ListTagsRequest request = ListTagsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (Tag element : dataCatalogClient.listTags(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagsPagedResponse listTags(ListTagsRequest request) {
    return listTagsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   ListTagsRequest request = ListTagsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListTagsPagedResponse&gt; future = dataCatalogClient.listTagsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Tag element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTagsRequest, ListTagsPagedResponse> listTagsPagedCallable() {
    return stub.listTagsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedParent = DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   ListTagsRequest request = ListTagsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
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
   * </code></pre>
   */
  public final UnaryCallable<ListTagsRequest, ListTagsResponse> listTagsCallable() {
    return stub.listTagsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy for a resource. Replaces any existing policy. Supported
   * resources are: - Tag templates. - Entries. - Entry groups. Note, this method cannot be used to
   * manage policies for BigQuery, Cloud Pub/Sub and any external Google Cloud Platform resources
   * synced to Cloud Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.setIamPolicy`
   * to set policies on tag templates. - `datacatalog.entries.setIamPolicy` to set policies on
   * entries. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedResource = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = dataCatalogClient.setIamPolicy(formattedResource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    TAG_TEMPLATE_PATH_TEMPLATE.validate(resource, "setIamPolicy");
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy for a resource. Replaces any existing policy. Supported
   * resources are: - Tag templates. - Entries. - Entry groups. Note, this method cannot be used to
   * manage policies for BigQuery, Cloud Pub/Sub and any external Google Cloud Platform resources
   * synced to Cloud Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.setIamPolicy`
   * to set policies on tag templates. - `datacatalog.entries.setIamPolicy` to set policies on
   * entries. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedResource = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   Policy response = dataCatalogClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy for a resource. Replaces any existing policy. Supported
   * resources are: - Tag templates. - Entries. - Entry groups. Note, this method cannot be used to
   * manage policies for BigQuery, Cloud Pub/Sub and any external Google Cloud Platform resources
   * synced to Cloud Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.setIamPolicy`
   * to set policies on tag templates. - `datacatalog.entries.setIamPolicy` to set policies on
   * entries. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedResource = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setPolicy(policy)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = dataCatalogClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. A `NOT_FOUND` error is returned if the resource
   * does not exist. An empty policy is returned if the resource exists but does not have a policy
   * set on it.
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Cloud Pub/Sub and any external Google Cloud
   * Platform resources synced to Cloud Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.getIamPolicy`
   * to get policies on tag templates. - `datacatalog.entries.getIamPolicy` to get policies on
   * entries. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedResource = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   Policy response = dataCatalogClient.getIamPolicy(formattedResource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    TAG_TEMPLATE_PATH_TEMPLATE.validate(resource, "getIamPolicy");
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. A `NOT_FOUND` error is returned if the resource
   * does not exist. An empty policy is returned if the resource exists but does not have a policy
   * set on it.
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Cloud Pub/Sub and any external Google Cloud
   * Platform resources synced to Cloud Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.getIamPolicy`
   * to get policies on tag templates. - `datacatalog.entries.getIamPolicy` to get policies on
   * entries. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedResource = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   Policy response = dataCatalogClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. A `NOT_FOUND` error is returned if the resource
   * does not exist. An empty policy is returned if the resource exists but does not have a policy
   * set on it.
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Cloud Pub/Sub and any external Google Cloud
   * Platform resources synced to Cloud Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.getIamPolicy`
   * to get policies on tag templates. - `datacatalog.entries.getIamPolicy` to get policies on
   * entries. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedResource = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = dataCatalogClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the caller's permissions on a resource. If the resource does not exist, an empty set of
   * permissions is returned (We don't return a `NOT_FOUND` error).
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Cloud Pub/Sub and any external Google Cloud
   * Platform resources synced to Cloud Data Catalog.
   *
   * <p>A caller is not required to have Google IAM permission to make this request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedResource = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = dataCatalogClient.testIamPermissions(formattedResource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TAG_TEMPLATE_PATH_TEMPLATE.validate(resource, "testIamPermissions");
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the caller's permissions on a resource. If the resource does not exist, an empty set of
   * permissions is returned (We don't return a `NOT_FOUND` error).
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Cloud Pub/Sub and any external Google Cloud
   * Platform resources synced to Cloud Data Catalog.
   *
   * <p>A caller is not required to have Google IAM permission to make this request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedResource = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   TestIamPermissionsResponse response = dataCatalogClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the caller's permissions on a resource. If the resource does not exist, an empty set of
   * permissions is returned (We don't return a `NOT_FOUND` error).
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Cloud Pub/Sub and any external Google Cloud
   * Platform resources synced to Cloud Data Catalog.
   *
   * <p>A caller is not required to have Google IAM permission to make this request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String formattedResource = DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .addAllPermissions(permissions)
   *     .build();
   *   ApiFuture&lt;TestIamPermissionsResponse&gt; future = dataCatalogClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestIamPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
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
          new ApiFunction<SearchCatalogPage, SearchCatalogPagedResponse>() {
            @Override
            public SearchCatalogPagedResponse apply(SearchCatalogPage input) {
              return new SearchCatalogPagedResponse(input);
            }
          },
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

  public static class ListTagsPagedResponse
      extends AbstractPagedListResponse<
          ListTagsRequest, ListTagsResponse, Tag, ListTagsPage, ListTagsFixedSizeCollection> {

    public static ApiFuture<ListTagsPagedResponse> createAsync(
        PageContext<ListTagsRequest, ListTagsResponse, Tag> context,
        ApiFuture<ListTagsResponse> futureResponse) {
      ApiFuture<ListTagsPage> futurePage =
          ListTagsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTagsPage, ListTagsPagedResponse>() {
            @Override
            public ListTagsPagedResponse apply(ListTagsPage input) {
              return new ListTagsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
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
