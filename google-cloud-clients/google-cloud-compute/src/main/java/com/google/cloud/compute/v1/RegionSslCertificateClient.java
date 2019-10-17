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
import com.google.cloud.compute.v1.stub.RegionSslCertificateStub;
import com.google.cloud.compute.v1.stub.RegionSslCertificateStubSettings;
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
 * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
 *   ProjectRegionSslCertificateName sslCertificate = ProjectRegionSslCertificateName.of("[PROJECT]", "[REGION]", "[SSL_CERTIFICATE]");
 *   Operation response = regionSslCertificateClient.deleteRegionSslCertificate(sslCertificate);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the regionSslCertificateClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of RegionSslCertificateSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * RegionSslCertificateSettings regionSslCertificateSettings =
 *     RegionSslCertificateSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionSslCertificateClient regionSslCertificateClient =
 *     RegionSslCertificateClient.create(regionSslCertificateSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * RegionSslCertificateSettings regionSslCertificateSettings =
 *     RegionSslCertificateSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionSslCertificateClient regionSslCertificateClient =
 *     RegionSslCertificateClient.create(regionSslCertificateSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionSslCertificateClient implements BackgroundResource {
  private final RegionSslCertificateSettings settings;
  private final RegionSslCertificateStub stub;

  /** Constructs an instance of RegionSslCertificateClient with default settings. */
  public static final RegionSslCertificateClient create() throws IOException {
    return create(RegionSslCertificateSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionSslCertificateClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionSslCertificateClient create(RegionSslCertificateSettings settings)
      throws IOException {
    return new RegionSslCertificateClient(settings);
  }

  /**
   * Constructs an instance of RegionSslCertificateClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use RegionSslCertificateSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final RegionSslCertificateClient create(RegionSslCertificateStub stub) {
    return new RegionSslCertificateClient(stub);
  }

  /**
   * Constructs an instance of RegionSslCertificateClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionSslCertificateClient(RegionSslCertificateSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((RegionSslCertificateStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected RegionSslCertificateClient(RegionSslCertificateStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionSslCertificateSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionSslCertificateStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified SslCertificate resource in the region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   ProjectRegionSslCertificateName sslCertificate = ProjectRegionSslCertificateName.of("[PROJECT]", "[REGION]", "[SSL_CERTIFICATE]");
   *   Operation response = regionSslCertificateClient.deleteRegionSslCertificate(sslCertificate);
   * }
   * </code></pre>
   *
   * @param sslCertificate Name of the SslCertificate resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionSslCertificate(
      ProjectRegionSslCertificateName sslCertificate) {

    DeleteRegionSslCertificateHttpRequest request =
        DeleteRegionSslCertificateHttpRequest.newBuilder()
            .setSslCertificate(sslCertificate == null ? null : sslCertificate.toString())
            .build();
    return deleteRegionSslCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified SslCertificate resource in the region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   ProjectRegionSslCertificateName sslCertificate = ProjectRegionSslCertificateName.of("[PROJECT]", "[REGION]", "[SSL_CERTIFICATE]");
   *   Operation response = regionSslCertificateClient.deleteRegionSslCertificate(sslCertificate.toString());
   * }
   * </code></pre>
   *
   * @param sslCertificate Name of the SslCertificate resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionSslCertificate(String sslCertificate) {

    DeleteRegionSslCertificateHttpRequest request =
        DeleteRegionSslCertificateHttpRequest.newBuilder()
            .setSslCertificate(sslCertificate)
            .build();
    return deleteRegionSslCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified SslCertificate resource in the region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   String formattedSslCertificate = ProjectRegionSslCertificateName.format("[PROJECT]", "[REGION]", "[SSL_CERTIFICATE]");
   *   DeleteRegionSslCertificateHttpRequest request = DeleteRegionSslCertificateHttpRequest.newBuilder()
   *     .setSslCertificate(formattedSslCertificate)
   *     .build();
   *   Operation response = regionSslCertificateClient.deleteRegionSslCertificate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteRegionSslCertificate(DeleteRegionSslCertificateHttpRequest request) {
    return deleteRegionSslCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified SslCertificate resource in the region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   String formattedSslCertificate = ProjectRegionSslCertificateName.format("[PROJECT]", "[REGION]", "[SSL_CERTIFICATE]");
   *   DeleteRegionSslCertificateHttpRequest request = DeleteRegionSslCertificateHttpRequest.newBuilder()
   *     .setSslCertificate(formattedSslCertificate)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionSslCertificateClient.deleteRegionSslCertificateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteRegionSslCertificateHttpRequest, Operation>
      deleteRegionSslCertificateCallable() {
    return stub.deleteRegionSslCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified SslCertificate resource in the specified region. Get a list of available
   * SSL certificates by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   ProjectRegionSslCertificateName sslCertificate = ProjectRegionSslCertificateName.of("[PROJECT]", "[REGION]", "[SSL_CERTIFICATE]");
   *   SslCertificate response = regionSslCertificateClient.getRegionSslCertificate(sslCertificate);
   * }
   * </code></pre>
   *
   * @param sslCertificate Name of the SslCertificate resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final SslCertificate getRegionSslCertificate(
      ProjectRegionSslCertificateName sslCertificate) {

    GetRegionSslCertificateHttpRequest request =
        GetRegionSslCertificateHttpRequest.newBuilder()
            .setSslCertificate(sslCertificate == null ? null : sslCertificate.toString())
            .build();
    return getRegionSslCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified SslCertificate resource in the specified region. Get a list of available
   * SSL certificates by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   ProjectRegionSslCertificateName sslCertificate = ProjectRegionSslCertificateName.of("[PROJECT]", "[REGION]", "[SSL_CERTIFICATE]");
   *   SslCertificate response = regionSslCertificateClient.getRegionSslCertificate(sslCertificate.toString());
   * }
   * </code></pre>
   *
   * @param sslCertificate Name of the SslCertificate resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final SslCertificate getRegionSslCertificate(String sslCertificate) {

    GetRegionSslCertificateHttpRequest request =
        GetRegionSslCertificateHttpRequest.newBuilder().setSslCertificate(sslCertificate).build();
    return getRegionSslCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified SslCertificate resource in the specified region. Get a list of available
   * SSL certificates by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   String formattedSslCertificate = ProjectRegionSslCertificateName.format("[PROJECT]", "[REGION]", "[SSL_CERTIFICATE]");
   *   GetRegionSslCertificateHttpRequest request = GetRegionSslCertificateHttpRequest.newBuilder()
   *     .setSslCertificate(formattedSslCertificate)
   *     .build();
   *   SslCertificate response = regionSslCertificateClient.getRegionSslCertificate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final SslCertificate getRegionSslCertificate(GetRegionSslCertificateHttpRequest request) {
    return getRegionSslCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified SslCertificate resource in the specified region. Get a list of available
   * SSL certificates by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   String formattedSslCertificate = ProjectRegionSslCertificateName.format("[PROJECT]", "[REGION]", "[SSL_CERTIFICATE]");
   *   GetRegionSslCertificateHttpRequest request = GetRegionSslCertificateHttpRequest.newBuilder()
   *     .setSslCertificate(formattedSslCertificate)
   *     .build();
   *   ApiFuture&lt;SslCertificate&gt; future = regionSslCertificateClient.getRegionSslCertificateCallable().futureCall(request);
   *   // Do something
   *   SslCertificate response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetRegionSslCertificateHttpRequest, SslCertificate>
      getRegionSslCertificateCallable() {
    return stub.getRegionSslCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a SslCertificate resource in the specified project and region using the data included
   * in the request
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   SslCertificate sslCertificateResource = SslCertificate.newBuilder().build();
   *   Operation response = regionSslCertificateClient.insertRegionSslCertificate(region, sslCertificateResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param sslCertificateResource Represents an SSL Certificate resource.
   *     <p>This SSL certificate resource also contains a private key. You can use SSL keys and
   *     certificates to secure connections to a load balancer. For more information, read Creating
   *     and Using SSL Certificates. (== resource_for beta.sslCertificates ==) (== resource_for
   *     v1.sslCertificates ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionSslCertificate(
      ProjectRegionName region, SslCertificate sslCertificateResource) {

    InsertRegionSslCertificateHttpRequest request =
        InsertRegionSslCertificateHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .setSslCertificateResource(sslCertificateResource)
            .build();
    return insertRegionSslCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a SslCertificate resource in the specified project and region using the data included
   * in the request
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   SslCertificate sslCertificateResource = SslCertificate.newBuilder().build();
   *   Operation response = regionSslCertificateClient.insertRegionSslCertificate(region.toString(), sslCertificateResource);
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @param sslCertificateResource Represents an SSL Certificate resource.
   *     <p>This SSL certificate resource also contains a private key. You can use SSL keys and
   *     certificates to secure connections to a load balancer. For more information, read Creating
   *     and Using SSL Certificates. (== resource_for beta.sslCertificates ==) (== resource_for
   *     v1.sslCertificates ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionSslCertificate(
      String region, SslCertificate sslCertificateResource) {

    InsertRegionSslCertificateHttpRequest request =
        InsertRegionSslCertificateHttpRequest.newBuilder()
            .setRegion(region)
            .setSslCertificateResource(sslCertificateResource)
            .build();
    return insertRegionSslCertificate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a SslCertificate resource in the specified project and region using the data included
   * in the request
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   SslCertificate sslCertificateResource = SslCertificate.newBuilder().build();
   *   InsertRegionSslCertificateHttpRequest request = InsertRegionSslCertificateHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setSslCertificateResource(sslCertificateResource)
   *     .build();
   *   Operation response = regionSslCertificateClient.insertRegionSslCertificate(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertRegionSslCertificate(InsertRegionSslCertificateHttpRequest request) {
    return insertRegionSslCertificateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a SslCertificate resource in the specified project and region using the data included
   * in the request
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   SslCertificate sslCertificateResource = SslCertificate.newBuilder().build();
   *   InsertRegionSslCertificateHttpRequest request = InsertRegionSslCertificateHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .setSslCertificateResource(sslCertificateResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = regionSslCertificateClient.insertRegionSslCertificateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertRegionSslCertificateHttpRequest, Operation>
      insertRegionSslCertificateCallable() {
    return stub.insertRegionSslCertificateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of SslCertificate resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (SslCertificate element : regionSslCertificateClient.listRegionSslCertificates(region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionSslCertificatesPagedResponse listRegionSslCertificates(
      ProjectRegionName region) {
    ListRegionSslCertificatesHttpRequest request =
        ListRegionSslCertificatesHttpRequest.newBuilder()
            .setRegion(region == null ? null : region.toString())
            .build();
    return listRegionSslCertificates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of SslCertificate resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   ProjectRegionName region = ProjectRegionName.of("[PROJECT]", "[REGION]");
   *   for (SslCertificate element : regionSslCertificateClient.listRegionSslCertificates(region.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param region Name of the region scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionSslCertificatesPagedResponse listRegionSslCertificates(String region) {
    ListRegionSslCertificatesHttpRequest request =
        ListRegionSslCertificatesHttpRequest.newBuilder().setRegion(region).build();
    return listRegionSslCertificates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of SslCertificate resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionSslCertificatesHttpRequest request = ListRegionSslCertificatesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   for (SslCertificate element : regionSslCertificateClient.listRegionSslCertificates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListRegionSslCertificatesPagedResponse listRegionSslCertificates(
      ListRegionSslCertificatesHttpRequest request) {
    return listRegionSslCertificatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of SslCertificate resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionSslCertificatesHttpRequest request = ListRegionSslCertificatesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   ApiFuture&lt;ListRegionSslCertificatesPagedResponse&gt; future = regionSslCertificateClient.listRegionSslCertificatesPagedCallable().futureCall(request);
   *   // Do something
   *   for (SslCertificate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListRegionSslCertificatesHttpRequest, ListRegionSslCertificatesPagedResponse>
      listRegionSslCertificatesPagedCallable() {
    return stub.listRegionSslCertificatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of SslCertificate resources available to the specified project in the
   * specified region.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (RegionSslCertificateClient regionSslCertificateClient = RegionSslCertificateClient.create()) {
   *   String formattedRegion = ProjectRegionName.format("[PROJECT]", "[REGION]");
   *   ListRegionSslCertificatesHttpRequest request = ListRegionSslCertificatesHttpRequest.newBuilder()
   *     .setRegion(formattedRegion)
   *     .build();
   *   while (true) {
   *     SslCertificateList response = regionSslCertificateClient.listRegionSslCertificatesCallable().call(request);
   *     for (SslCertificate element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionSslCertificatesHttpRequest, SslCertificateList>
      listRegionSslCertificatesCallable() {
    return stub.listRegionSslCertificatesCallable();
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

  public static class ListRegionSslCertificatesPagedResponse
      extends AbstractPagedListResponse<
          ListRegionSslCertificatesHttpRequest,
          SslCertificateList,
          SslCertificate,
          ListRegionSslCertificatesPage,
          ListRegionSslCertificatesFixedSizeCollection> {

    public static ApiFuture<ListRegionSslCertificatesPagedResponse> createAsync(
        PageContext<ListRegionSslCertificatesHttpRequest, SslCertificateList, SslCertificate>
            context,
        ApiFuture<SslCertificateList> futureResponse) {
      ApiFuture<ListRegionSslCertificatesPage> futurePage =
          ListRegionSslCertificatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListRegionSslCertificatesPage, ListRegionSslCertificatesPagedResponse>() {
            @Override
            public ListRegionSslCertificatesPagedResponse apply(
                ListRegionSslCertificatesPage input) {
              return new ListRegionSslCertificatesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRegionSslCertificatesPagedResponse(ListRegionSslCertificatesPage page) {
      super(page, ListRegionSslCertificatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRegionSslCertificatesPage
      extends AbstractPage<
          ListRegionSslCertificatesHttpRequest,
          SslCertificateList,
          SslCertificate,
          ListRegionSslCertificatesPage> {

    private ListRegionSslCertificatesPage(
        PageContext<ListRegionSslCertificatesHttpRequest, SslCertificateList, SslCertificate>
            context,
        SslCertificateList response) {
      super(context, response);
    }

    private static ListRegionSslCertificatesPage createEmptyPage() {
      return new ListRegionSslCertificatesPage(null, null);
    }

    @Override
    protected ListRegionSslCertificatesPage createPage(
        PageContext<ListRegionSslCertificatesHttpRequest, SslCertificateList, SslCertificate>
            context,
        SslCertificateList response) {
      return new ListRegionSslCertificatesPage(context, response);
    }

    @Override
    public ApiFuture<ListRegionSslCertificatesPage> createPageAsync(
        PageContext<ListRegionSslCertificatesHttpRequest, SslCertificateList, SslCertificate>
            context,
        ApiFuture<SslCertificateList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRegionSslCertificatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionSslCertificatesHttpRequest,
          SslCertificateList,
          SslCertificate,
          ListRegionSslCertificatesPage,
          ListRegionSslCertificatesFixedSizeCollection> {

    private ListRegionSslCertificatesFixedSizeCollection(
        List<ListRegionSslCertificatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRegionSslCertificatesFixedSizeCollection createEmptyCollection() {
      return new ListRegionSslCertificatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRegionSslCertificatesFixedSizeCollection createCollection(
        List<ListRegionSslCertificatesPage> pages, int collectionSize) {
      return new ListRegionSslCertificatesFixedSizeCollection(pages, collectionSize);
    }
  }
}
