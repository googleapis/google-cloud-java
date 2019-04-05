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
package com.google.cloud.compute.v1;

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
import com.google.cloud.compute.v1.stub.LicenseStub;
import com.google.cloud.compute.v1.stub.LicenseStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (LicenseClient licenseClient = LicenseClient.create()) {
 *   ProjectGlobalLicenseName license = ProjectGlobalLicenseName.of("[PROJECT]", "[LICENSE]");
 *   Operation response = licenseClient.deleteLicense(license);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the licenseClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of LicenseSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * LicenseSettings licenseSettings =
 *     LicenseSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LicenseClient licenseClient =
 *     LicenseClient.create(licenseSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * LicenseSettings licenseSettings =
 *     LicenseSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LicenseClient licenseClient =
 *     LicenseClient.create(licenseSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class LicenseClient implements BackgroundResource {
  private final LicenseSettings settings;
  private final LicenseStub stub;

  /** Constructs an instance of LicenseClient with default settings. */
  public static final LicenseClient create() throws IOException {
    return create(LicenseSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LicenseClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LicenseClient create(LicenseSettings settings) throws IOException {
    return new LicenseClient(settings);
  }

  /**
   * Constructs an instance of LicenseClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use LicenseSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final LicenseClient create(LicenseStub stub) {
    return new LicenseClient(stub);
  }

  /**
   * Constructs an instance of LicenseClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected LicenseClient(LicenseSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LicenseStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected LicenseClient(LicenseStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LicenseSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public LicenseStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified license.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   ProjectGlobalLicenseName license = ProjectGlobalLicenseName.of("[PROJECT]", "[LICENSE]");
   *   Operation response = licenseClient.deleteLicense(license);
   * }
   * </code></pre>
   *
   * @param license Name of the license resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteLicense(ProjectGlobalLicenseName license) {

    DeleteLicenseHttpRequest request =
        DeleteLicenseHttpRequest.newBuilder()
            .setLicense(license == null ? null : license.toString())
            .build();
    return deleteLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified license.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   ProjectGlobalLicenseName license = ProjectGlobalLicenseName.of("[PROJECT]", "[LICENSE]");
   *   Operation response = licenseClient.deleteLicense(license.toString());
   * }
   * </code></pre>
   *
   * @param license Name of the license resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteLicense(String license) {

    DeleteLicenseHttpRequest request =
        DeleteLicenseHttpRequest.newBuilder().setLicense(license).build();
    return deleteLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified license.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedLicense = ProjectGlobalLicenseName.format("[PROJECT]", "[LICENSE]");
   *   DeleteLicenseHttpRequest request = DeleteLicenseHttpRequest.newBuilder()
   *     .setLicense(formattedLicense)
   *     .build();
   *   Operation response = licenseClient.deleteLicense(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteLicense(DeleteLicenseHttpRequest request) {
    return deleteLicenseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified license.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedLicense = ProjectGlobalLicenseName.format("[PROJECT]", "[LICENSE]");
   *   DeleteLicenseHttpRequest request = DeleteLicenseHttpRequest.newBuilder()
   *     .setLicense(formattedLicense)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = licenseClient.deleteLicenseCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteLicenseHttpRequest, Operation> deleteLicenseCallable() {
    return stub.deleteLicenseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified License resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   ProjectGlobalLicenseName license = ProjectGlobalLicenseName.of("[PROJECT]", "[LICENSE]");
   *   License response = licenseClient.getLicense(license);
   * }
   * </code></pre>
   *
   * @param license Name of the License resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final License getLicense(ProjectGlobalLicenseName license) {

    GetLicenseHttpRequest request =
        GetLicenseHttpRequest.newBuilder()
            .setLicense(license == null ? null : license.toString())
            .build();
    return getLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified License resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   ProjectGlobalLicenseName license = ProjectGlobalLicenseName.of("[PROJECT]", "[LICENSE]");
   *   License response = licenseClient.getLicense(license.toString());
   * }
   * </code></pre>
   *
   * @param license Name of the License resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final License getLicense(String license) {

    GetLicenseHttpRequest request = GetLicenseHttpRequest.newBuilder().setLicense(license).build();
    return getLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified License resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedLicense = ProjectGlobalLicenseName.format("[PROJECT]", "[LICENSE]");
   *   GetLicenseHttpRequest request = GetLicenseHttpRequest.newBuilder()
   *     .setLicense(formattedLicense)
   *     .build();
   *   License response = licenseClient.getLicense(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final License getLicense(GetLicenseHttpRequest request) {
    return getLicenseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified License resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedLicense = ProjectGlobalLicenseName.format("[PROJECT]", "[LICENSE]");
   *   GetLicenseHttpRequest request = GetLicenseHttpRequest.newBuilder()
   *     .setLicense(formattedLicense)
   *     .build();
   *   ApiFuture&lt;License&gt; future = licenseClient.getLicenseCallable().futureCall(request);
   *   // Do something
   *   License response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetLicenseHttpRequest, License> getLicenseCallable() {
    return stub.getLicenseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   ProjectGlobalLicenseResourceName resource = ProjectGlobalLicenseResourceName.of("[PROJECT]", "[RESOURCE]");
   *   Policy response = licenseClient.getIamPolicyLicense(resource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyLicense(ProjectGlobalLicenseResourceName resource) {

    GetIamPolicyLicenseHttpRequest request =
        GetIamPolicyLicenseHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicyLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   ProjectGlobalLicenseResourceName resource = ProjectGlobalLicenseResourceName.of("[PROJECT]", "[RESOURCE]");
   *   Policy response = licenseClient.getIamPolicyLicense(resource.toString());
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyLicense(String resource) {

    GetIamPolicyLicenseHttpRequest request =
        GetIamPolicyLicenseHttpRequest.newBuilder().setResource(resource).build();
    return getIamPolicyLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedResource = ProjectGlobalLicenseResourceName.format("[PROJECT]", "[RESOURCE]");
   *   GetIamPolicyLicenseHttpRequest request = GetIamPolicyLicenseHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   Policy response = licenseClient.getIamPolicyLicense(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyLicense(GetIamPolicyLicenseHttpRequest request) {
    return getIamPolicyLicenseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedResource = ProjectGlobalLicenseResourceName.format("[PROJECT]", "[RESOURCE]");
   *   GetIamPolicyLicenseHttpRequest request = GetIamPolicyLicenseHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = licenseClient.getIamPolicyLicenseCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetIamPolicyLicenseHttpRequest, Policy> getIamPolicyLicenseCallable() {
    return stub.getIamPolicyLicenseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a License resource in the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   License licenseResource = License.newBuilder().build();
   *   Operation response = licenseClient.insertLicense(project, licenseResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param licenseResource A license resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertLicense(ProjectName project, License licenseResource) {

    InsertLicenseHttpRequest request =
        InsertLicenseHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setLicenseResource(licenseResource)
            .build();
    return insertLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a License resource in the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   License licenseResource = License.newBuilder().build();
   *   Operation response = licenseClient.insertLicense(project.toString(), licenseResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param licenseResource A license resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertLicense(String project, License licenseResource) {

    InsertLicenseHttpRequest request =
        InsertLicenseHttpRequest.newBuilder()
            .setProject(project)
            .setLicenseResource(licenseResource)
            .build();
    return insertLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a License resource in the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   License licenseResource = License.newBuilder().build();
   *   InsertLicenseHttpRequest request = InsertLicenseHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .setLicenseResource(licenseResource)
   *     .build();
   *   Operation response = licenseClient.insertLicense(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertLicense(InsertLicenseHttpRequest request) {
    return insertLicenseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Create a License resource in the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   License licenseResource = License.newBuilder().build();
   *   InsertLicenseHttpRequest request = InsertLicenseHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .setLicenseResource(licenseResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = licenseClient.insertLicenseCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertLicenseHttpRequest, Operation> insertLicenseCallable() {
    return stub.insertLicenseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of licenses available in the specified project. This method does not get any
   * licenses that belong to other projects, including licenses attached to publicly-available
   * images, like Debian 9. If you want to get a list of publicly-available licenses, use this
   * method to make a request to the respective image project, such as debian-cloud or
   * windows-cloud.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (License element : licenseClient.listLicenses(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListLicensesPagedResponse listLicenses(ProjectName project) {
    ListLicensesHttpRequest request =
        ListLicensesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listLicenses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of licenses available in the specified project. This method does not get any
   * licenses that belong to other projects, including licenses attached to publicly-available
   * images, like Debian 9. If you want to get a list of publicly-available licenses, use this
   * method to make a request to the respective image project, such as debian-cloud or
   * windows-cloud.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (License element : licenseClient.listLicenses(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListLicensesPagedResponse listLicenses(String project) {
    ListLicensesHttpRequest request =
        ListLicensesHttpRequest.newBuilder().setProject(project).build();
    return listLicenses(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of licenses available in the specified project. This method does not get any
   * licenses that belong to other projects, including licenses attached to publicly-available
   * images, like Debian 9. If you want to get a list of publicly-available licenses, use this
   * method to make a request to the respective image project, such as debian-cloud or
   * windows-cloud.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListLicensesHttpRequest request = ListLicensesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (License element : licenseClient.listLicenses(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListLicensesPagedResponse listLicenses(ListLicensesHttpRequest request) {
    return listLicensesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of licenses available in the specified project. This method does not get any
   * licenses that belong to other projects, including licenses attached to publicly-available
   * images, like Debian 9. If you want to get a list of publicly-available licenses, use this
   * method to make a request to the respective image project, such as debian-cloud or
   * windows-cloud.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListLicensesHttpRequest request = ListLicensesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;ListLicensesPagedResponse&gt; future = licenseClient.listLicensesPagedCallable().futureCall(request);
   *   // Do something
   *   for (License element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListLicensesHttpRequest, ListLicensesPagedResponse>
      listLicensesPagedCallable() {
    return stub.listLicensesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of licenses available in the specified project. This method does not get any
   * licenses that belong to other projects, including licenses attached to publicly-available
   * images, like Debian 9. If you want to get a list of publicly-available licenses, use this
   * method to make a request to the respective image project, such as debian-cloud or
   * windows-cloud.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListLicensesHttpRequest request = ListLicensesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     LicensesListResponse response = licenseClient.listLicensesCallable().call(request);
   *     for (License element : response.getItemsList()) {
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
  @BetaApi
  public final UnaryCallable<ListLicensesHttpRequest, LicensesListResponse> listLicensesCallable() {
    return stub.listLicensesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   ProjectGlobalLicenseResourceName resource = ProjectGlobalLicenseResourceName.of("[PROJECT]", "[RESOURCE]");
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource = GlobalSetPolicyRequest.newBuilder().build();
   *   Policy response = licenseClient.setIamPolicyLicense(resource, globalSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param globalSetPolicyRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyLicense(
      ProjectGlobalLicenseResourceName resource,
      GlobalSetPolicyRequest globalSetPolicyRequestResource) {

    SetIamPolicyLicenseHttpRequest request =
        SetIamPolicyLicenseHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
            .build();
    return setIamPolicyLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   ProjectGlobalLicenseResourceName resource = ProjectGlobalLicenseResourceName.of("[PROJECT]", "[RESOURCE]");
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource = GlobalSetPolicyRequest.newBuilder().build();
   *   Policy response = licenseClient.setIamPolicyLicense(resource.toString(), globalSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param globalSetPolicyRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyLicense(
      String resource, GlobalSetPolicyRequest globalSetPolicyRequestResource) {

    SetIamPolicyLicenseHttpRequest request =
        SetIamPolicyLicenseHttpRequest.newBuilder()
            .setResource(resource)
            .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
            .build();
    return setIamPolicyLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedResource = ProjectGlobalLicenseResourceName.format("[PROJECT]", "[RESOURCE]");
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource = GlobalSetPolicyRequest.newBuilder().build();
   *   SetIamPolicyLicenseHttpRequest request = SetIamPolicyLicenseHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
   *     .build();
   *   Policy response = licenseClient.setIamPolicyLicense(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyLicense(SetIamPolicyLicenseHttpRequest request) {
    return setIamPolicyLicenseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedResource = ProjectGlobalLicenseResourceName.format("[PROJECT]", "[RESOURCE]");
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource = GlobalSetPolicyRequest.newBuilder().build();
   *   SetIamPolicyLicenseHttpRequest request = SetIamPolicyLicenseHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = licenseClient.setIamPolicyLicenseCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetIamPolicyLicenseHttpRequest, Policy> setIamPolicyLicenseCallable() {
    return stub.setIamPolicyLicenseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   ProjectGlobalLicenseResourceName resource = ProjectGlobalLicenseResourceName.of("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = licenseClient.testIamPermissionsLicense(resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsLicense(
      ProjectGlobalLicenseResourceName resource,
      TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsLicenseHttpRequest request =
        TestIamPermissionsLicenseHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   ProjectGlobalLicenseResourceName resource = ProjectGlobalLicenseResourceName.of("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = licenseClient.testIamPermissionsLicense(resource.toString(), testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsLicense(
      String resource, TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsLicenseHttpRequest request =
        TestIamPermissionsLicenseHttpRequest.newBuilder()
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsLicense(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedResource = ProjectGlobalLicenseResourceName.format("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsLicenseHttpRequest request = TestIamPermissionsLicenseHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = licenseClient.testIamPermissionsLicense(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsLicense(
      TestIamPermissionsLicenseHttpRequest request) {
    return testIamPermissionsLicenseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LicenseClient licenseClient = LicenseClient.create()) {
   *   String formattedResource = ProjectGlobalLicenseResourceName.format("[PROJECT]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsLicenseHttpRequest request = TestIamPermissionsLicenseHttpRequest.newBuilder()
   *     .setResource(formattedResource)
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = licenseClient.testIamPermissionsLicenseCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<TestIamPermissionsLicenseHttpRequest, TestPermissionsResponse>
      testIamPermissionsLicenseCallable() {
    return stub.testIamPermissionsLicenseCallable();
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

  public static class ListLicensesPagedResponse
      extends AbstractPagedListResponse<
          ListLicensesHttpRequest,
          LicensesListResponse,
          License,
          ListLicensesPage,
          ListLicensesFixedSizeCollection> {

    public static ApiFuture<ListLicensesPagedResponse> createAsync(
        PageContext<ListLicensesHttpRequest, LicensesListResponse, License> context,
        ApiFuture<LicensesListResponse> futureResponse) {
      ApiFuture<ListLicensesPage> futurePage =
          ListLicensesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListLicensesPage, ListLicensesPagedResponse>() {
            @Override
            public ListLicensesPagedResponse apply(ListLicensesPage input) {
              return new ListLicensesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListLicensesPagedResponse(ListLicensesPage page) {
      super(page, ListLicensesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLicensesPage
      extends AbstractPage<
          ListLicensesHttpRequest, LicensesListResponse, License, ListLicensesPage> {

    private ListLicensesPage(
        PageContext<ListLicensesHttpRequest, LicensesListResponse, License> context,
        LicensesListResponse response) {
      super(context, response);
    }

    private static ListLicensesPage createEmptyPage() {
      return new ListLicensesPage(null, null);
    }

    @Override
    protected ListLicensesPage createPage(
        PageContext<ListLicensesHttpRequest, LicensesListResponse, License> context,
        LicensesListResponse response) {
      return new ListLicensesPage(context, response);
    }

    @Override
    public ApiFuture<ListLicensesPage> createPageAsync(
        PageContext<ListLicensesHttpRequest, LicensesListResponse, License> context,
        ApiFuture<LicensesListResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLicensesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLicensesHttpRequest,
          LicensesListResponse,
          License,
          ListLicensesPage,
          ListLicensesFixedSizeCollection> {

    private ListLicensesFixedSizeCollection(List<ListLicensesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLicensesFixedSizeCollection createEmptyCollection() {
      return new ListLicensesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLicensesFixedSizeCollection createCollection(
        List<ListLicensesPage> pages, int collectionSize) {
      return new ListLicensesFixedSizeCollection(pages, collectionSize);
    }
  }
}
