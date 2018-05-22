/*
 * Copyright 2018 Google LLC
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
import com.google.cloud.compute.v1.stub.SslPolicyStub;
import com.google.cloud.compute.v1.stub.SslPolicyStubSettings;
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
 * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
 *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
 *   Operation response = sslPolicyClient.deleteSslPolicy(sslPolicy);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the sslPolicyClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of SslPolicySettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * SslPolicySettings sslPolicySettings =
 *     SslPolicySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SslPolicyClient sslPolicyClient =
 *     SslPolicyClient.create(sslPolicySettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * SslPolicySettings sslPolicySettings =
 *     SslPolicySettings.newBuilder().setEndpoint(myEndpoint).build();
 * SslPolicyClient sslPolicyClient =
 *     SslPolicyClient.create(sslPolicySettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class SslPolicyClient implements BackgroundResource {
  private final SslPolicySettings settings;
  private final SslPolicyStub stub;

  /** Constructs an instance of SslPolicyClient with default settings. */
  public static final SslPolicyClient create() throws IOException {
    return create(SslPolicySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SslPolicyClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SslPolicyClient create(SslPolicySettings settings) throws IOException {
    return new SslPolicyClient(settings);
  }

  /**
   * Constructs an instance of SslPolicyClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use SslPolicySettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final SslPolicyClient create(SslPolicyStub stub) {
    return new SslPolicyClient(stub);
  }

  /**
   * Constructs an instance of SslPolicyClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected SslPolicyClient(SslPolicySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SslPolicyStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected SslPolicyClient(SslPolicyStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SslPolicySettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SslPolicyStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified SSL policy. The SSL policy resource can be deleted only if it is not in
   * use by any TargetHttpsProxy or TargetSslProxy resources.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
   *   Operation response = sslPolicyClient.deleteSslPolicy(sslPolicy);
   * }
   * </code></pre>
   *
   * @param sslPolicy Name of the SSL policy to delete. The name must be 1-63 characters long, and
   *     comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteSslPolicy(ProjectGlobalSslPolicyName sslPolicy) {

    DeleteSslPolicyHttpRequest request =
        DeleteSslPolicyHttpRequest.newBuilder()
            .setSslPolicy(sslPolicy == null ? null : sslPolicy.toString())
            .build();
    return deleteSslPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified SSL policy. The SSL policy resource can be deleted only if it is not in
   * use by any TargetHttpsProxy or TargetSslProxy resources.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
   *   Operation response = sslPolicyClient.deleteSslPolicy(sslPolicy.toString());
   * }
   * </code></pre>
   *
   * @param sslPolicy Name of the SSL policy to delete. The name must be 1-63 characters long, and
   *     comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteSslPolicy(String sslPolicy) {

    DeleteSslPolicyHttpRequest request =
        DeleteSslPolicyHttpRequest.newBuilder().setSslPolicy(sslPolicy).build();
    return deleteSslPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified SSL policy. The SSL policy resource can be deleted only if it is not in
   * use by any TargetHttpsProxy or TargetSslProxy resources.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
   *   DeleteSslPolicyHttpRequest request = DeleteSslPolicyHttpRequest.newBuilder()
   *     .setSslPolicy(sslPolicy.toString())
   *     .build();
   *   Operation response = sslPolicyClient.deleteSslPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteSslPolicy(DeleteSslPolicyHttpRequest request) {
    return deleteSslPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified SSL policy. The SSL policy resource can be deleted only if it is not in
   * use by any TargetHttpsProxy or TargetSslProxy resources.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
   *   DeleteSslPolicyHttpRequest request = DeleteSslPolicyHttpRequest.newBuilder()
   *     .setSslPolicy(sslPolicy.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = sslPolicyClient.deleteSslPolicyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteSslPolicyHttpRequest, Operation> deleteSslPolicyCallable() {
    return stub.deleteSslPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the ordered rules present in a single specified policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
   *   SslPolicy response = sslPolicyClient.getSslPolicy(sslPolicy);
   * }
   * </code></pre>
   *
   * @param sslPolicy Name of the SSL policy to update. The name must be 1-63 characters long, and
   *     comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final SslPolicy getSslPolicy(ProjectGlobalSslPolicyName sslPolicy) {

    GetSslPolicyHttpRequest request =
        GetSslPolicyHttpRequest.newBuilder()
            .setSslPolicy(sslPolicy == null ? null : sslPolicy.toString())
            .build();
    return getSslPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the ordered rules present in a single specified policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
   *   SslPolicy response = sslPolicyClient.getSslPolicy(sslPolicy.toString());
   * }
   * </code></pre>
   *
   * @param sslPolicy Name of the SSL policy to update. The name must be 1-63 characters long, and
   *     comply with RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final SslPolicy getSslPolicy(String sslPolicy) {

    GetSslPolicyHttpRequest request =
        GetSslPolicyHttpRequest.newBuilder().setSslPolicy(sslPolicy).build();
    return getSslPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the ordered rules present in a single specified policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
   *   GetSslPolicyHttpRequest request = GetSslPolicyHttpRequest.newBuilder()
   *     .setSslPolicy(sslPolicy.toString())
   *     .build();
   *   SslPolicy response = sslPolicyClient.getSslPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final SslPolicy getSslPolicy(GetSslPolicyHttpRequest request) {
    return getSslPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the ordered rules present in a single specified policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
   *   GetSslPolicyHttpRequest request = GetSslPolicyHttpRequest.newBuilder()
   *     .setSslPolicy(sslPolicy.toString())
   *     .build();
   *   ApiFuture&lt;SslPolicy&gt; future = sslPolicyClient.getSslPolicyCallable().futureCall(request);
   *   // Do something
   *   SslPolicy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetSslPolicyHttpRequest, SslPolicy> getSslPolicyCallable() {
    return stub.getSslPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified SSL policy resource. Gets a list of available SSL policies by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   SslPolicy sslPolicyResource = SslPolicy.newBuilder().build();
   *   Operation response = sslPolicyClient.insertSslPolicy(project, sslPolicyResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param sslPolicyResource A SSL policy specifies the server-side support for SSL features. This
   *     can be attached to a TargetHttpsProxy or a TargetSslProxy. This affects connections between
   *     clients and the HTTPS or SSL proxy load balancer. They do not affect the connection between
   *     the load balancers and the backends.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertSslPolicy(ProjectName project, SslPolicy sslPolicyResource) {

    InsertSslPolicyHttpRequest request =
        InsertSslPolicyHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setSslPolicyResource(sslPolicyResource)
            .build();
    return insertSslPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified SSL policy resource. Gets a list of available SSL policies by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   SslPolicy sslPolicyResource = SslPolicy.newBuilder().build();
   *   Operation response = sslPolicyClient.insertSslPolicy(project.toString(), sslPolicyResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param sslPolicyResource A SSL policy specifies the server-side support for SSL features. This
   *     can be attached to a TargetHttpsProxy or a TargetSslProxy. This affects connections between
   *     clients and the HTTPS or SSL proxy load balancer. They do not affect the connection between
   *     the load balancers and the backends.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertSslPolicy(String project, SslPolicy sslPolicyResource) {

    InsertSslPolicyHttpRequest request =
        InsertSslPolicyHttpRequest.newBuilder()
            .setProject(project)
            .setSslPolicyResource(sslPolicyResource)
            .build();
    return insertSslPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified SSL policy resource. Gets a list of available SSL policies by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   SslPolicy sslPolicyResource = SslPolicy.newBuilder().build();
   *   InsertSslPolicyHttpRequest request = InsertSslPolicyHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setSslPolicyResource(sslPolicyResource)
   *     .build();
   *   Operation response = sslPolicyClient.insertSslPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertSslPolicy(InsertSslPolicyHttpRequest request) {
    return insertSslPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified SSL policy resource. Gets a list of available SSL policies by making a
   * list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   SslPolicy sslPolicyResource = SslPolicy.newBuilder().build();
   *   InsertSslPolicyHttpRequest request = InsertSslPolicyHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setSslPolicyResource(sslPolicyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = sslPolicyClient.insertSslPolicyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertSslPolicyHttpRequest, Operation> insertSslPolicyCallable() {
    return stub.insertSslPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the SSL policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (SslPolicy element : sslPolicyClient.listSslPolicies(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListSslPoliciesPagedResponse listSslPolicies(ProjectName project) {
    ListSslPoliciesHttpRequest request =
        ListSslPoliciesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listSslPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the SSL policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (SslPolicy element : sslPolicyClient.listSslPolicies(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListSslPoliciesPagedResponse listSslPolicies(String project) {
    ListSslPoliciesHttpRequest request =
        ListSslPoliciesHttpRequest.newBuilder().setProject(project).build();
    return listSslPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the SSL policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListSslPoliciesHttpRequest request = ListSslPoliciesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (SslPolicy element : sslPolicyClient.listSslPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListSslPoliciesPagedResponse listSslPolicies(ListSslPoliciesHttpRequest request) {
    return listSslPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the SSL policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListSslPoliciesHttpRequest request = ListSslPoliciesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;ListSslPoliciesPagedResponse&gt; future = sslPolicyClient.listSslPoliciesPagedCallable().futureCall(request);
   *   // Do something
   *   for (SslPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListSslPoliciesHttpRequest, ListSslPoliciesPagedResponse>
      listSslPoliciesPagedCallable() {
    return stub.listSslPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all the SSL policies that have been configured for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListSslPoliciesHttpRequest request = ListSslPoliciesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     SslPoliciesList response = sslPolicyClient.listSslPoliciesCallable().call(request);
   *     for (SslPolicy element : response.getItemsList()) {
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
  public final UnaryCallable<ListSslPoliciesHttpRequest, SslPoliciesList>
      listSslPoliciesCallable() {
    return stub.listSslPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all features that can be specified in the SSL policy when using custom profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   SslPoliciesListAvailableFeaturesResponse response = sslPolicyClient.listAvailableFeaturesSslPolicies(project);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final SslPoliciesListAvailableFeaturesResponse listAvailableFeaturesSslPolicies(
      ProjectName project) {

    ListAvailableFeaturesSslPoliciesHttpRequest request =
        ListAvailableFeaturesSslPoliciesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listAvailableFeaturesSslPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all features that can be specified in the SSL policy when using custom profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   SslPoliciesListAvailableFeaturesResponse response = sslPolicyClient.listAvailableFeaturesSslPolicies(project.toString());
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final SslPoliciesListAvailableFeaturesResponse listAvailableFeaturesSslPolicies(
      String project) {

    ListAvailableFeaturesSslPoliciesHttpRequest request =
        ListAvailableFeaturesSslPoliciesHttpRequest.newBuilder().setProject(project).build();
    return listAvailableFeaturesSslPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all features that can be specified in the SSL policy when using custom profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListAvailableFeaturesSslPoliciesHttpRequest request = ListAvailableFeaturesSslPoliciesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   SslPoliciesListAvailableFeaturesResponse response = sslPolicyClient.listAvailableFeaturesSslPolicies(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final SslPoliciesListAvailableFeaturesResponse listAvailableFeaturesSslPolicies(
      ListAvailableFeaturesSslPoliciesHttpRequest request) {
    return listAvailableFeaturesSslPoliciesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all features that can be specified in the SSL policy when using custom profile.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListAvailableFeaturesSslPoliciesHttpRequest request = ListAvailableFeaturesSslPoliciesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;SslPoliciesListAvailableFeaturesResponse&gt; future = sslPolicyClient.listAvailableFeaturesSslPoliciesCallable().futureCall(request);
   *   // Do something
   *   SslPoliciesListAvailableFeaturesResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListAvailableFeaturesSslPoliciesHttpRequest, SslPoliciesListAvailableFeaturesResponse>
      listAvailableFeaturesSslPoliciesCallable() {
    return stub.listAvailableFeaturesSslPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified SSL policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
   *   SslPolicy sslPolicyResource = SslPolicy.newBuilder().build();
   *   Operation response = sslPolicyClient.patchSslPolicy(sslPolicy, sslPolicyResource);
   * }
   * </code></pre>
   *
   * @param sslPolicy Name of the SSL policy to update. The name must be 1-63 characters long, and
   *     comply with RFC1035.
   * @param sslPolicyResource A SSL policy specifies the server-side support for SSL features. This
   *     can be attached to a TargetHttpsProxy or a TargetSslProxy. This affects connections between
   *     clients and the HTTPS or SSL proxy load balancer. They do not affect the connection between
   *     the load balancers and the backends.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchSslPolicy(
      ProjectGlobalSslPolicyName sslPolicy, SslPolicy sslPolicyResource) {

    PatchSslPolicyHttpRequest request =
        PatchSslPolicyHttpRequest.newBuilder()
            .setSslPolicy(sslPolicy == null ? null : sslPolicy.toString())
            .setSslPolicyResource(sslPolicyResource)
            .build();
    return patchSslPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified SSL policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
   *   SslPolicy sslPolicyResource = SslPolicy.newBuilder().build();
   *   Operation response = sslPolicyClient.patchSslPolicy(sslPolicy.toString(), sslPolicyResource);
   * }
   * </code></pre>
   *
   * @param sslPolicy Name of the SSL policy to update. The name must be 1-63 characters long, and
   *     comply with RFC1035.
   * @param sslPolicyResource A SSL policy specifies the server-side support for SSL features. This
   *     can be attached to a TargetHttpsProxy or a TargetSslProxy. This affects connections between
   *     clients and the HTTPS or SSL proxy load balancer. They do not affect the connection between
   *     the load balancers and the backends.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchSslPolicy(String sslPolicy, SslPolicy sslPolicyResource) {

    PatchSslPolicyHttpRequest request =
        PatchSslPolicyHttpRequest.newBuilder()
            .setSslPolicy(sslPolicy)
            .setSslPolicyResource(sslPolicyResource)
            .build();
    return patchSslPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified SSL policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
   *   SslPolicy sslPolicyResource = SslPolicy.newBuilder().build();
   *   PatchSslPolicyHttpRequest request = PatchSslPolicyHttpRequest.newBuilder()
   *     .setSslPolicy(sslPolicy.toString())
   *     .setSslPolicyResource(sslPolicyResource)
   *     .build();
   *   Operation response = sslPolicyClient.patchSslPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchSslPolicy(PatchSslPolicyHttpRequest request) {
    return patchSslPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified SSL policy with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SslPolicyClient sslPolicyClient = SslPolicyClient.create()) {
   *   ProjectGlobalSslPolicyName sslPolicy = ProjectGlobalSslPolicyName.of("[PROJECT]", "[SSL_POLICY]");
   *   SslPolicy sslPolicyResource = SslPolicy.newBuilder().build();
   *   PatchSslPolicyHttpRequest request = PatchSslPolicyHttpRequest.newBuilder()
   *     .setSslPolicy(sslPolicy.toString())
   *     .setSslPolicyResource(sslPolicyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = sslPolicyClient.patchSslPolicyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchSslPolicyHttpRequest, Operation> patchSslPolicyCallable() {
    return stub.patchSslPolicyCallable();
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

  public static class ListSslPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListSslPoliciesHttpRequest, SslPoliciesList, SslPolicy, ListSslPoliciesPage,
          ListSslPoliciesFixedSizeCollection> {

    public static ApiFuture<ListSslPoliciesPagedResponse> createAsync(
        PageContext<ListSslPoliciesHttpRequest, SslPoliciesList, SslPolicy> context,
        ApiFuture<SslPoliciesList> futureResponse) {
      ApiFuture<ListSslPoliciesPage> futurePage =
          ListSslPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListSslPoliciesPage, ListSslPoliciesPagedResponse>() {
            @Override
            public ListSslPoliciesPagedResponse apply(ListSslPoliciesPage input) {
              return new ListSslPoliciesPagedResponse(input);
            }
          });
    }

    private ListSslPoliciesPagedResponse(ListSslPoliciesPage page) {
      super(page, ListSslPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSslPoliciesPage
      extends AbstractPage<
          ListSslPoliciesHttpRequest, SslPoliciesList, SslPolicy, ListSslPoliciesPage> {

    private ListSslPoliciesPage(
        PageContext<ListSslPoliciesHttpRequest, SslPoliciesList, SslPolicy> context,
        SslPoliciesList response) {
      super(context, response);
    }

    private static ListSslPoliciesPage createEmptyPage() {
      return new ListSslPoliciesPage(null, null);
    }

    @Override
    protected ListSslPoliciesPage createPage(
        PageContext<ListSslPoliciesHttpRequest, SslPoliciesList, SslPolicy> context,
        SslPoliciesList response) {
      return new ListSslPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListSslPoliciesPage> createPageAsync(
        PageContext<ListSslPoliciesHttpRequest, SslPoliciesList, SslPolicy> context,
        ApiFuture<SslPoliciesList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSslPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSslPoliciesHttpRequest, SslPoliciesList, SslPolicy, ListSslPoliciesPage,
          ListSslPoliciesFixedSizeCollection> {

    private ListSslPoliciesFixedSizeCollection(
        List<ListSslPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSslPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListSslPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSslPoliciesFixedSizeCollection createCollection(
        List<ListSslPoliciesPage> pages, int collectionSize) {
      return new ListSslPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }
}
