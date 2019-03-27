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
import com.google.cloud.talent.v4beta1.stub.ApplicationServiceStub;
import com.google.cloud.talent.v4beta1.stub.ApplicationServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: A service that handles application management, including CRUD and
 * enumeration.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
 *   ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
 *   Application application = Application.newBuilder().build();
 *   Application response = applicationServiceClient.createApplication(parent, application);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the applicationServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of ApplicationServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ApplicationServiceSettings applicationServiceSettings =
 *     ApplicationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ApplicationServiceClient applicationServiceClient =
 *     ApplicationServiceClient.create(applicationServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ApplicationServiceSettings applicationServiceSettings =
 *     ApplicationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ApplicationServiceClient applicationServiceClient =
 *     ApplicationServiceClient.create(applicationServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ApplicationServiceClient implements BackgroundResource {
  private final ApplicationServiceSettings settings;
  private final ApplicationServiceStub stub;

  /** Constructs an instance of ApplicationServiceClient with default settings. */
  public static final ApplicationServiceClient create() throws IOException {
    return create(ApplicationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ApplicationServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ApplicationServiceClient create(ApplicationServiceSettings settings)
      throws IOException {
    return new ApplicationServiceClient(settings);
  }

  /**
   * Constructs an instance of ApplicationServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use ApplicationServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ApplicationServiceClient create(ApplicationServiceStub stub) {
    return new ApplicationServiceClient(stub);
  }

  /**
   * Constructs an instance of ApplicationServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ApplicationServiceClient(ApplicationServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ApplicationServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ApplicationServiceClient(ApplicationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ApplicationServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ApplicationServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new application entity.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
   *   Application application = Application.newBuilder().build();
   *   Application response = applicationServiceClient.createApplication(parent, application);
   * }
   * </code></pre>
   *
   * @param parent Required.
   *     <p>Resource name of the profile under which the application is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}/profiles/{profile_id}", for
   *     example, "projects/test-project/tenants/test-tenant/profiles/test-profile".
   * @param application Required.
   *     <p>The application to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application createApplication(ProfileName parent, Application application) {

    CreateApplicationRequest request =
        CreateApplicationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApplication(application)
            .build();
    return createApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new application entity.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
   *   Application application = Application.newBuilder().build();
   *   Application response = applicationServiceClient.createApplication(parent.toString(), application);
   * }
   * </code></pre>
   *
   * @param parent Required.
   *     <p>Resource name of the profile under which the application is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}/profiles/{profile_id}", for
   *     example, "projects/test-project/tenants/test-tenant/profiles/test-profile".
   * @param application Required.
   *     <p>The application to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application createApplication(String parent, Application application) {

    CreateApplicationRequest request =
        CreateApplicationRequest.newBuilder().setParent(parent).setApplication(application).build();
    return createApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new application entity.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
   *   Application application = Application.newBuilder().build();
   *   CreateApplicationRequest request = CreateApplicationRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setApplication(application)
   *     .build();
   *   Application response = applicationServiceClient.createApplication(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application createApplication(CreateApplicationRequest request) {
    return createApplicationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new application entity.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
   *   Application application = Application.newBuilder().build();
   *   CreateApplicationRequest request = CreateApplicationRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setApplication(application)
   *     .build();
   *   ApiFuture&lt;Application&gt; future = applicationServiceClient.createApplicationCallable().futureCall(request);
   *   // Do something
   *   Application response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateApplicationRequest, Application> createApplicationCallable() {
    return stub.createApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves specified application.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");
   *   Application response = applicationServiceClient.getApplication(name);
   * }
   * </code></pre>
   *
   * @param name Required.
   *     <p>The resource name of the application to be retrieved.
   *     <p>The format is
   *     "projects/{project_id}/tenants/{tenant_id}/profiles/{profile_id}/applications/{application_id}",
   *     for example,
   *     "projects/test-project/tenants/test-tenant/profiles/test-profile/applications/test-application".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application getApplication(ApplicationName name) {

    GetApplicationRequest request =
        GetApplicationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves specified application.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");
   *   Application response = applicationServiceClient.getApplication(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required.
   *     <p>The resource name of the application to be retrieved.
   *     <p>The format is
   *     "projects/{project_id}/tenants/{tenant_id}/profiles/{profile_id}/applications/{application_id}",
   *     for example,
   *     "projects/test-project/tenants/test-tenant/profiles/test-profile/applications/test-application".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application getApplication(String name) {

    GetApplicationRequest request = GetApplicationRequest.newBuilder().setName(name).build();
    return getApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves specified application.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");
   *   GetApplicationRequest request = GetApplicationRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Application response = applicationServiceClient.getApplication(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application getApplication(GetApplicationRequest request) {
    return getApplicationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves specified application.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");
   *   GetApplicationRequest request = GetApplicationRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Application&gt; future = applicationServiceClient.getApplicationCallable().futureCall(request);
   *   // Do something
   *   Application response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    return stub.getApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates specified application.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   Application application = Application.newBuilder().build();
   *   Application response = applicationServiceClient.updateApplication(application);
   * }
   * </code></pre>
   *
   * @param application Required.
   *     <p>The application resource to replace the current resource in the system.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application updateApplication(Application application) {

    UpdateApplicationRequest request =
        UpdateApplicationRequest.newBuilder().setApplication(application).build();
    return updateApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates specified application.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   Application application = Application.newBuilder().build();
   *   UpdateApplicationRequest request = UpdateApplicationRequest.newBuilder()
   *     .setApplication(application)
   *     .build();
   *   Application response = applicationServiceClient.updateApplication(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Application updateApplication(UpdateApplicationRequest request) {
    return updateApplicationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates specified application.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   Application application = Application.newBuilder().build();
   *   UpdateApplicationRequest request = UpdateApplicationRequest.newBuilder()
   *     .setApplication(application)
   *     .build();
   *   ApiFuture&lt;Application&gt; future = applicationServiceClient.updateApplicationCallable().futureCall(request);
   *   // Do something
   *   Application response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateApplicationRequest, Application> updateApplicationCallable() {
    return stub.updateApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes specified application.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");
   *   applicationServiceClient.deleteApplication(name);
   * }
   * </code></pre>
   *
   * @param name Required.
   *     <p>The resource name of the application to be deleted.
   *     <p>The format is
   *     "projects/{project_id}/tenants/{tenant_id}/profiles/{profile_id}/applications/{application_id}",
   *     for example,
   *     "projects/test-project/tenants/test-tenant/profiles/test-profile/applications/test-application".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApplication(ApplicationName name) {

    DeleteApplicationRequest request =
        DeleteApplicationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes specified application.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");
   *   applicationServiceClient.deleteApplication(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required.
   *     <p>The resource name of the application to be deleted.
   *     <p>The format is
   *     "projects/{project_id}/tenants/{tenant_id}/profiles/{profile_id}/applications/{application_id}",
   *     for example,
   *     "projects/test-project/tenants/test-tenant/profiles/test-profile/applications/test-application".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApplication(String name) {

    DeleteApplicationRequest request = DeleteApplicationRequest.newBuilder().setName(name).build();
    deleteApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes specified application.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");
   *   DeleteApplicationRequest request = DeleteApplicationRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   applicationServiceClient.deleteApplication(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteApplication(DeleteApplicationRequest request) {
    deleteApplicationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes specified application.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ApplicationName name = ApplicationName.of("[PROJECT]", "[TENANT]", "[PROFILE]", "[APPLICATION]");
   *   DeleteApplicationRequest request = DeleteApplicationRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = applicationServiceClient.deleteApplicationCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteApplicationRequest, Empty> deleteApplicationCallable() {
    return stub.deleteApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all applications associated with the profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
   *   for (Application element : applicationServiceClient.listApplications(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required.
   *     <p>Resource name of the profile under which the application is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}/profiles/{profile_id}", for
   *     example, "projects/test-project/tenants/test-tenant/profiles/test-profile".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationsPagedResponse listApplications(ProfileName parent) {
    ListApplicationsRequest request =
        ListApplicationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listApplications(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all applications associated with the profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
   *   for (Application element : applicationServiceClient.listApplications(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required.
   *     <p>Resource name of the profile under which the application is created.
   *     <p>The format is "projects/{project_id}/tenants/{tenant_id}/profiles/{profile_id}", for
   *     example, "projects/test-project/tenants/test-tenant/profiles/test-profile".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationsPagedResponse listApplications(String parent) {
    ListApplicationsRequest request =
        ListApplicationsRequest.newBuilder().setParent(parent).build();
    return listApplications(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all applications associated with the profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
   *   ListApplicationsRequest request = ListApplicationsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Application element : applicationServiceClient.listApplications(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListApplicationsPagedResponse listApplications(ListApplicationsRequest request) {
    return listApplicationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all applications associated with the profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
   *   ListApplicationsRequest request = ListApplicationsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListApplicationsPagedResponse&gt; future = applicationServiceClient.listApplicationsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Application element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable() {
    return stub.listApplicationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all applications associated with the profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ApplicationServiceClient applicationServiceClient = ApplicationServiceClient.create()) {
   *   ProfileName parent = ProfileName.of("[PROJECT]", "[TENANT]", "[PROFILE]");
   *   ListApplicationsRequest request = ListApplicationsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListApplicationsResponse response = applicationServiceClient.listApplicationsCallable().call(request);
   *     for (Application element : response.getApplicationsList()) {
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
  public final UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable() {
    return stub.listApplicationsCallable();
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

  public static class ListApplicationsPagedResponse
      extends AbstractPagedListResponse<
          ListApplicationsRequest,
          ListApplicationsResponse,
          Application,
          ListApplicationsPage,
          ListApplicationsFixedSizeCollection> {

    public static ApiFuture<ListApplicationsPagedResponse> createAsync(
        PageContext<ListApplicationsRequest, ListApplicationsResponse, Application> context,
        ApiFuture<ListApplicationsResponse> futureResponse) {
      ApiFuture<ListApplicationsPage> futurePage =
          ListApplicationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListApplicationsPage, ListApplicationsPagedResponse>() {
            @Override
            public ListApplicationsPagedResponse apply(ListApplicationsPage input) {
              return new ListApplicationsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListApplicationsPagedResponse(ListApplicationsPage page) {
      super(page, ListApplicationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListApplicationsPage
      extends AbstractPage<
          ListApplicationsRequest, ListApplicationsResponse, Application, ListApplicationsPage> {

    private ListApplicationsPage(
        PageContext<ListApplicationsRequest, ListApplicationsResponse, Application> context,
        ListApplicationsResponse response) {
      super(context, response);
    }

    private static ListApplicationsPage createEmptyPage() {
      return new ListApplicationsPage(null, null);
    }

    @Override
    protected ListApplicationsPage createPage(
        PageContext<ListApplicationsRequest, ListApplicationsResponse, Application> context,
        ListApplicationsResponse response) {
      return new ListApplicationsPage(context, response);
    }

    @Override
    public ApiFuture<ListApplicationsPage> createPageAsync(
        PageContext<ListApplicationsRequest, ListApplicationsResponse, Application> context,
        ApiFuture<ListApplicationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListApplicationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListApplicationsRequest,
          ListApplicationsResponse,
          Application,
          ListApplicationsPage,
          ListApplicationsFixedSizeCollection> {

    private ListApplicationsFixedSizeCollection(
        List<ListApplicationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListApplicationsFixedSizeCollection createEmptyCollection() {
      return new ListApplicationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListApplicationsFixedSizeCollection createCollection(
        List<ListApplicationsPage> pages, int collectionSize) {
      return new ListApplicationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
