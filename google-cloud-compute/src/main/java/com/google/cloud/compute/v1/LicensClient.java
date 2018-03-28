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
import com.google.api.gax.paging.FixedSizeCollection;
import com.google.api.gax.paging.Page;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.compute.v1.stub.LicensStub;
import com.google.cloud.compute.v1.stub.LicensStubSettings;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
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
 * try (LicensClient licensClient = LicensClient.create()) {
 *   LicenseName license = LicenseName.of("[PROJECT]", "[LICENSE]");
 *   License response = licensClient.getLicens(license);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the licensClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * API callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of LicensSettings to
 * create(). For example:
 *
 * To customize credentials:
 *
 * <pre>
 * <code>
 * LicensSettings licensSettings =
 *     LicensSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LicensClient licensClient =
 *     LicensClient.create(licensSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * LicensSettings licensSettings =
 *     LicensSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LicensClient licensClient =
 *     LicensClient.create(licensSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class LicensClient implements BackgroundResource {
  private final LicensSettings settings;
  private final LicensStub stub;



  /**
   * Constructs an instance of LicensClient with default settings.
   */
  public static final LicensClient create() throws IOException {
    return create(LicensSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LicensClient, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final LicensClient create(LicensSettings settings) throws IOException {
    return new LicensClient(settings);
  }

  /**
   * Constructs an instance of LicensClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use LicensSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final LicensClient create(LicensStub stub) {
    return new LicensClient(stub);
  }

  /**
   * Constructs an instance of LicensClient, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected LicensClient(LicensSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LicensStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected LicensClient(LicensStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LicensSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public LicensStub getStub() {
    return stub;
  }


  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified License resource. Get a list of available licenses by making a list() request.
   *
   * Sample code:
   * <pre><code>
   * try (LicensClient licensClient = LicensClient.create()) {
   *   LicenseName license = LicenseName.of("[PROJECT]", "[LICENSE]");
   *   License response = licensClient.getLicens(license);
   * }
   * </code></pre>
   *
   * @param license Name of the License resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final License getLicens(LicenseName license) {

    GetLicensHttpRequest request =
        GetLicensHttpRequest.newBuilder()
        .setLicense(license == null ? null : license.toString())
        .build();
    return getLicens(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified License resource. Get a list of available licenses by making a list() request.
   *
   * Sample code:
   * <pre><code>
   * try (LicensClient licensClient = LicensClient.create()) {
   *   LicenseName license = LicenseName.of("[PROJECT]", "[LICENSE]");
   *   License response = licensClient.getLicens(license.toString());
   * }
   * </code></pre>
   *
   * @param license Name of the License resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final License getLicens(String license) {

    GetLicensHttpRequest request =
        GetLicensHttpRequest.newBuilder()
        .setLicense(license)
        .build();
    return getLicens(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified License resource. Get a list of available licenses by making a list() request.
   *
   * Sample code:
   * <pre><code>
   * try (LicensClient licensClient = LicensClient.create()) {
   *   LicenseName license = LicenseName.of("[PROJECT]", "[LICENSE]");
   *   GetLicensHttpRequest request = GetLicensHttpRequest.newBuilder()
   *     .setLicense(license.toString())
   *     .build();
   *   License response = licensClient.getLicens(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final License getLicens(GetLicensHttpRequest request) {
    return getLicensCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified License resource. Get a list of available licenses by making a list() request.
   *
   * Sample code:
   * <pre><code>
   * try (LicensClient licensClient = LicensClient.create()) {
   *   LicenseName license = LicenseName.of("[PROJECT]", "[LICENSE]");
   *   GetLicensHttpRequest request = GetLicensHttpRequest.newBuilder()
   *     .setLicense(license.toString())
   *     .build();
   *   ApiFuture&lt;License&gt; future = licensClient.getLicensCallable().futureCall(request);
   *   // Do something
   *   License response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetLicensHttpRequest, License> getLicensCallable() {
    return stub.getLicensCallable();
  }

  @Override
  public final void close() throws Exception {
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


}