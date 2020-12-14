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

package com.google.cloud.talent.v4beta1;

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
import com.google.cloud.talent.v4beta1.stub.ProfileServiceStub;
import com.google.cloud.talent.v4beta1.stub.ProfileServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service that handles profile management, including profile CRUD,
 * enumeration and search.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the ProfileServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of ProfileServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * ProfileServiceSettings profileServiceSettings =
 *     ProfileServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProfileServiceClient profileServiceClient = ProfileServiceClient.create(profileServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * ProfileServiceSettings profileServiceSettings =
 *     ProfileServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProfileServiceClient profileServiceClient = ProfileServiceClient.create(profileServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class ProfileServiceClient implements BackgroundResource {
  private final ProfileServiceSettings settings;
  private final ProfileServiceStub stub;

  /** Constructs an instance of ProfileServiceClient with default settings. */
  public static final ProfileServiceClient create() throws IOException {
    return create(ProfileServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProfileServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProfileServiceClient create(ProfileServiceSettings settings)
      throws IOException {
    return new ProfileServiceClient(settings);
  }

  /**
   * Constructs an instance of ProfileServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ProfileServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ProfileServiceClient create(ProfileServiceStub stub) {
    return new ProfileServiceClient(stub);
  }

  /**
   * Constructs an instance of ProfileServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ProfileServiceClient(ProfileServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProfileServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ProfileServiceClient(ProfileServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ProfileServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ProfileServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists profiles by filter. The order is unspecified.
   *
   * @param parent Required. The resource name of the tenant under which the profile is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenants/bar".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProfilesPagedResponse listProfiles(TenantName parent) {
    ListProfilesRequest request =
        ListProfilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists profiles by filter. The order is unspecified.
   *
   * @param parent Required. The resource name of the tenant under which the profile is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenants/bar".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProfilesPagedResponse listProfiles(String parent) {
    ListProfilesRequest request = ListProfilesRequest.newBuilder().setParent(parent).build();
    return listProfiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists profiles by filter. The order is unspecified.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProfilesPagedResponse listProfiles(ListProfilesRequest request) {
    return listProfilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists profiles by filter. The order is unspecified.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListProfilesRequest, ListProfilesPagedResponse>
      listProfilesPagedCallable() {
    return stub.listProfilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists profiles by filter. The order is unspecified.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListProfilesRequest, ListProfilesResponse> listProfilesCallable() {
    return stub.listProfilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new profile.
   *
   * @param parent Required. The name of the tenant this profile belongs to.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenants/bar".
   * @param profile Required. The profile to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Profile createProfile(TenantName parent, Profile profile) {
    CreateProfileRequest request =
        CreateProfileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setProfile(profile)
            .build();
    return createProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new profile.
   *
   * @param parent Required. The name of the tenant this profile belongs to.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}". For example,
   *     "projects/foo/tenants/bar".
   * @param profile Required. The profile to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Profile createProfile(String parent, Profile profile) {
    CreateProfileRequest request =
        CreateProfileRequest.newBuilder().setParent(parent).setProfile(profile).build();
    return createProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new profile.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Profile createProfile(CreateProfileRequest request) {
    return createProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates and returns a new profile.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateProfileRequest, Profile> createProfileCallable() {
    return stub.createProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified profile.
   *
   * @param name Required. Resource name of the profile to get.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}/profiles/{profile_id}". For
   *     example, "projects/foo/tenants/bar/profiles/baz".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Profile getProfile(ProfileName name) {
    GetProfileRequest request =
        GetProfileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified profile.
   *
   * @param name Required. Resource name of the profile to get.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}/profiles/{profile_id}". For
   *     example, "projects/foo/tenants/bar/profiles/baz".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Profile getProfile(String name) {
    GetProfileRequest request = GetProfileRequest.newBuilder().setName(name).build();
    return getProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified profile.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Profile getProfile(GetProfileRequest request) {
    return getProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified profile.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetProfileRequest, Profile> getProfileCallable() {
    return stub.getProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified profile and returns the updated result.
   *
   * @param profile Required. Profile to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Profile updateProfile(Profile profile) {
    UpdateProfileRequest request = UpdateProfileRequest.newBuilder().setProfile(profile).build();
    return updateProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified profile and returns the updated result.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Profile updateProfile(UpdateProfileRequest request) {
    return updateProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified profile and returns the updated result.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateProfileRequest, Profile> updateProfileCallable() {
    return stub.updateProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified profile. Prerequisite: The profile has no associated applications or
   * assignments associated.
   *
   * @param name Required. Resource name of the profile to be deleted.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}/profiles/{profile_id}". For
   *     example, "projects/foo/tenants/bar/profiles/baz".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProfile(ProfileName name) {
    DeleteProfileRequest request =
        DeleteProfileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified profile. Prerequisite: The profile has no associated applications or
   * assignments associated.
   *
   * @param name Required. Resource name of the profile to be deleted.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}/profiles/{profile_id}". For
   *     example, "projects/foo/tenants/bar/profiles/baz".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProfile(String name) {
    DeleteProfileRequest request = DeleteProfileRequest.newBuilder().setName(name).build();
    deleteProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified profile. Prerequisite: The profile has no associated applications or
   * assignments associated.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteProfile(DeleteProfileRequest request) {
    deleteProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified profile. Prerequisite: The profile has no associated applications or
   * assignments associated.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteProfileRequest, Empty> deleteProfileCallable() {
    return stub.deleteProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for profiles within a tenant.
   *
   * <p>For example, search by raw queries "software engineer in Mountain View" or search by
   * structured filters (location filter, education filter, etc.).
   *
   * <p>See [SearchProfilesRequest][google.cloud.talent.v4beta1.SearchProfilesRequest] for more
   * information.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchProfilesPagedResponse searchProfiles(SearchProfilesRequest request) {
    return searchProfilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for profiles within a tenant.
   *
   * <p>For example, search by raw queries "software engineer in Mountain View" or search by
   * structured filters (location filter, education filter, etc.).
   *
   * <p>See [SearchProfilesRequest][google.cloud.talent.v4beta1.SearchProfilesRequest] for more
   * information.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SearchProfilesRequest, SearchProfilesPagedResponse>
      searchProfilesPagedCallable() {
    return stub.searchProfilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for profiles within a tenant.
   *
   * <p>For example, search by raw queries "software engineer in Mountain View" or search by
   * structured filters (location filter, education filter, etc.).
   *
   * <p>See [SearchProfilesRequest][google.cloud.talent.v4beta1.SearchProfilesRequest] for more
   * information.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SearchProfilesRequest, SearchProfilesResponse>
      searchProfilesCallable() {
    return stub.searchProfilesCallable();
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

  public static class ListProfilesPagedResponse
      extends AbstractPagedListResponse<
          ListProfilesRequest,
          ListProfilesResponse,
          Profile,
          ListProfilesPage,
          ListProfilesFixedSizeCollection> {

    public static ApiFuture<ListProfilesPagedResponse> createAsync(
        PageContext<ListProfilesRequest, ListProfilesResponse, Profile> context,
        ApiFuture<ListProfilesResponse> futureResponse) {
      ApiFuture<ListProfilesPage> futurePage =
          ListProfilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListProfilesPage, ListProfilesPagedResponse>() {
            @Override
            public ListProfilesPagedResponse apply(ListProfilesPage input) {
              return new ListProfilesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListProfilesPagedResponse(ListProfilesPage page) {
      super(page, ListProfilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProfilesPage
      extends AbstractPage<ListProfilesRequest, ListProfilesResponse, Profile, ListProfilesPage> {

    private ListProfilesPage(
        PageContext<ListProfilesRequest, ListProfilesResponse, Profile> context,
        ListProfilesResponse response) {
      super(context, response);
    }

    private static ListProfilesPage createEmptyPage() {
      return new ListProfilesPage(null, null);
    }

    @Override
    protected ListProfilesPage createPage(
        PageContext<ListProfilesRequest, ListProfilesResponse, Profile> context,
        ListProfilesResponse response) {
      return new ListProfilesPage(context, response);
    }

    @Override
    public ApiFuture<ListProfilesPage> createPageAsync(
        PageContext<ListProfilesRequest, ListProfilesResponse, Profile> context,
        ApiFuture<ListProfilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProfilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProfilesRequest,
          ListProfilesResponse,
          Profile,
          ListProfilesPage,
          ListProfilesFixedSizeCollection> {

    private ListProfilesFixedSizeCollection(List<ListProfilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProfilesFixedSizeCollection createEmptyCollection() {
      return new ListProfilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProfilesFixedSizeCollection createCollection(
        List<ListProfilesPage> pages, int collectionSize) {
      return new ListProfilesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchProfilesPagedResponse
      extends AbstractPagedListResponse<
          SearchProfilesRequest,
          SearchProfilesResponse,
          HistogramQueryResult,
          SearchProfilesPage,
          SearchProfilesFixedSizeCollection> {

    public static ApiFuture<SearchProfilesPagedResponse> createAsync(
        PageContext<SearchProfilesRequest, SearchProfilesResponse, HistogramQueryResult> context,
        ApiFuture<SearchProfilesResponse> futureResponse) {
      ApiFuture<SearchProfilesPage> futurePage =
          SearchProfilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchProfilesPage, SearchProfilesPagedResponse>() {
            @Override
            public SearchProfilesPagedResponse apply(SearchProfilesPage input) {
              return new SearchProfilesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchProfilesPagedResponse(SearchProfilesPage page) {
      super(page, SearchProfilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchProfilesPage
      extends AbstractPage<
          SearchProfilesRequest, SearchProfilesResponse, HistogramQueryResult, SearchProfilesPage> {

    private SearchProfilesPage(
        PageContext<SearchProfilesRequest, SearchProfilesResponse, HistogramQueryResult> context,
        SearchProfilesResponse response) {
      super(context, response);
    }

    private static SearchProfilesPage createEmptyPage() {
      return new SearchProfilesPage(null, null);
    }

    @Override
    protected SearchProfilesPage createPage(
        PageContext<SearchProfilesRequest, SearchProfilesResponse, HistogramQueryResult> context,
        SearchProfilesResponse response) {
      return new SearchProfilesPage(context, response);
    }

    @Override
    public ApiFuture<SearchProfilesPage> createPageAsync(
        PageContext<SearchProfilesRequest, SearchProfilesResponse, HistogramQueryResult> context,
        ApiFuture<SearchProfilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchProfilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchProfilesRequest,
          SearchProfilesResponse,
          HistogramQueryResult,
          SearchProfilesPage,
          SearchProfilesFixedSizeCollection> {

    private SearchProfilesFixedSizeCollection(List<SearchProfilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchProfilesFixedSizeCollection createEmptyCollection() {
      return new SearchProfilesFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchProfilesFixedSizeCollection createCollection(
        List<SearchProfilesPage> pages, int collectionSize) {
      return new SearchProfilesFixedSizeCollection(pages, collectionSize);
    }
  }
}
