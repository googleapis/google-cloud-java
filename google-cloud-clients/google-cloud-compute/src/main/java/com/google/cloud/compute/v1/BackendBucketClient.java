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
import com.google.cloud.compute.v1.stub.BackendBucketStub;
import com.google.cloud.compute.v1.stub.BackendBucketStubSettings;
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
 * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
 *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
 *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
 *   Operation response = backendBucketClient.addSignedUrlKeyBackendBucket(backendBucket, signedUrlKeyResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the backendBucketClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of BackendBucketSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * BackendBucketSettings backendBucketSettings =
 *     BackendBucketSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BackendBucketClient backendBucketClient =
 *     BackendBucketClient.create(backendBucketSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * BackendBucketSettings backendBucketSettings =
 *     BackendBucketSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BackendBucketClient backendBucketClient =
 *     BackendBucketClient.create(backendBucketSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class BackendBucketClient implements BackgroundResource {
  private final BackendBucketSettings settings;
  private final BackendBucketStub stub;

  /** Constructs an instance of BackendBucketClient with default settings. */
  public static final BackendBucketClient create() throws IOException {
    return create(BackendBucketSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BackendBucketClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BackendBucketClient create(BackendBucketSettings settings)
      throws IOException {
    return new BackendBucketClient(settings);
  }

  /**
   * Constructs an instance of BackendBucketClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use BackendBucketSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final BackendBucketClient create(BackendBucketStub stub) {
    return new BackendBucketClient(stub);
  }

  /**
   * Constructs an instance of BackendBucketClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BackendBucketClient(BackendBucketSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BackendBucketStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected BackendBucketClient(BackendBucketStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BackendBucketSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BackendBucketStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
   *   Operation response = backendBucketClient.addSignedUrlKeyBackendBucket(backendBucket, signedUrlKeyResource);
   * }
   * </code></pre>
   *
   * @param backendBucket Name of the BackendBucket resource to which the Signed URL Key should be
   *     added. The name should conform to RFC1035.
   * @param signedUrlKeyResource Represents a customer-supplied Signing Key used by Cloud CDN Signed
   *     URLs
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addSignedUrlKeyBackendBucket(
      ProjectGlobalBackendBucketName backendBucket, SignedUrlKey signedUrlKeyResource) {

    AddSignedUrlKeyBackendBucketHttpRequest request =
        AddSignedUrlKeyBackendBucketHttpRequest.newBuilder()
            .setBackendBucket(backendBucket == null ? null : backendBucket.toString())
            .setSignedUrlKeyResource(signedUrlKeyResource)
            .build();
    return addSignedUrlKeyBackendBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
   *   Operation response = backendBucketClient.addSignedUrlKeyBackendBucket(backendBucket.toString(), signedUrlKeyResource);
   * }
   * </code></pre>
   *
   * @param backendBucket Name of the BackendBucket resource to which the Signed URL Key should be
   *     added. The name should conform to RFC1035.
   * @param signedUrlKeyResource Represents a customer-supplied Signing Key used by Cloud CDN Signed
   *     URLs
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addSignedUrlKeyBackendBucket(
      String backendBucket, SignedUrlKey signedUrlKeyResource) {

    AddSignedUrlKeyBackendBucketHttpRequest request =
        AddSignedUrlKeyBackendBucketHttpRequest.newBuilder()
            .setBackendBucket(backendBucket)
            .setSignedUrlKeyResource(signedUrlKeyResource)
            .build();
    return addSignedUrlKeyBackendBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
   *   AddSignedUrlKeyBackendBucketHttpRequest request = AddSignedUrlKeyBackendBucketHttpRequest.newBuilder()
   *     .setBackendBucket(backendBucket.toString())
   *     .setSignedUrlKeyResource(signedUrlKeyResource)
   *     .build();
   *   Operation response = backendBucketClient.addSignedUrlKeyBackendBucket(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addSignedUrlKeyBackendBucket(
      AddSignedUrlKeyBackendBucketHttpRequest request) {
    return addSignedUrlKeyBackendBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
   *   AddSignedUrlKeyBackendBucketHttpRequest request = AddSignedUrlKeyBackendBucketHttpRequest.newBuilder()
   *     .setBackendBucket(backendBucket.toString())
   *     .setSignedUrlKeyResource(signedUrlKeyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = backendBucketClient.addSignedUrlKeyBackendBucketCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AddSignedUrlKeyBackendBucketHttpRequest, Operation>
      addSignedUrlKeyBackendBucketCallable() {
    return stub.addSignedUrlKeyBackendBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified BackendBucket resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   Operation response = backendBucketClient.deleteBackendBucket(backendBucket);
   * }
   * </code></pre>
   *
   * @param backendBucket Name of the BackendBucket resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteBackendBucket(ProjectGlobalBackendBucketName backendBucket) {

    DeleteBackendBucketHttpRequest request =
        DeleteBackendBucketHttpRequest.newBuilder()
            .setBackendBucket(backendBucket == null ? null : backendBucket.toString())
            .build();
    return deleteBackendBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified BackendBucket resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   Operation response = backendBucketClient.deleteBackendBucket(backendBucket.toString());
   * }
   * </code></pre>
   *
   * @param backendBucket Name of the BackendBucket resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteBackendBucket(String backendBucket) {

    DeleteBackendBucketHttpRequest request =
        DeleteBackendBucketHttpRequest.newBuilder().setBackendBucket(backendBucket).build();
    return deleteBackendBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified BackendBucket resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   DeleteBackendBucketHttpRequest request = DeleteBackendBucketHttpRequest.newBuilder()
   *     .setBackendBucket(backendBucket.toString())
   *     .build();
   *   Operation response = backendBucketClient.deleteBackendBucket(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteBackendBucket(DeleteBackendBucketHttpRequest request) {
    return deleteBackendBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified BackendBucket resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   DeleteBackendBucketHttpRequest request = DeleteBackendBucketHttpRequest.newBuilder()
   *     .setBackendBucket(backendBucket.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = backendBucketClient.deleteBackendBucketCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteBackendBucketHttpRequest, Operation>
      deleteBackendBucketCallable() {
    return stub.deleteBackendBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   String keyName = "";
   *   Operation response = backendBucketClient.deleteSignedUrlKeyBackendBucket(backendBucket, keyName);
   * }
   * </code></pre>
   *
   * @param backendBucket Name of the BackendBucket resource to which the Signed URL Key should be
   *     added. The name should conform to RFC1035.
   * @param keyName The name of the Signed URL Key to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteSignedUrlKeyBackendBucket(
      ProjectGlobalBackendBucketName backendBucket, String keyName) {

    DeleteSignedUrlKeyBackendBucketHttpRequest request =
        DeleteSignedUrlKeyBackendBucketHttpRequest.newBuilder()
            .setBackendBucket(backendBucket == null ? null : backendBucket.toString())
            .setKeyName(keyName)
            .build();
    return deleteSignedUrlKeyBackendBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   String keyName = "";
   *   Operation response = backendBucketClient.deleteSignedUrlKeyBackendBucket(backendBucket.toString(), keyName);
   * }
   * </code></pre>
   *
   * @param backendBucket Name of the BackendBucket resource to which the Signed URL Key should be
   *     added. The name should conform to RFC1035.
   * @param keyName The name of the Signed URL Key to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteSignedUrlKeyBackendBucket(String backendBucket, String keyName) {

    DeleteSignedUrlKeyBackendBucketHttpRequest request =
        DeleteSignedUrlKeyBackendBucketHttpRequest.newBuilder()
            .setBackendBucket(backendBucket)
            .setKeyName(keyName)
            .build();
    return deleteSignedUrlKeyBackendBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   String keyName = "";
   *   DeleteSignedUrlKeyBackendBucketHttpRequest request = DeleteSignedUrlKeyBackendBucketHttpRequest.newBuilder()
   *     .setBackendBucket(backendBucket.toString())
   *     .setKeyName(keyName)
   *     .build();
   *   Operation response = backendBucketClient.deleteSignedUrlKeyBackendBucket(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteSignedUrlKeyBackendBucket(
      DeleteSignedUrlKeyBackendBucketHttpRequest request) {
    return deleteSignedUrlKeyBackendBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   String keyName = "";
   *   DeleteSignedUrlKeyBackendBucketHttpRequest request = DeleteSignedUrlKeyBackendBucketHttpRequest.newBuilder()
   *     .setBackendBucket(backendBucket.toString())
   *     .setKeyName(keyName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = backendBucketClient.deleteSignedUrlKeyBackendBucketCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteSignedUrlKeyBackendBucketHttpRequest, Operation>
      deleteSignedUrlKeyBackendBucketCallable() {
    return stub.deleteSignedUrlKeyBackendBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified BackendBucket resource. Gets a list of available backend buckets by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   BackendBucket response = backendBucketClient.getBackendBucket(backendBucket);
   * }
   * </code></pre>
   *
   * @param backendBucket Name of the BackendBucket resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final BackendBucket getBackendBucket(ProjectGlobalBackendBucketName backendBucket) {

    GetBackendBucketHttpRequest request =
        GetBackendBucketHttpRequest.newBuilder()
            .setBackendBucket(backendBucket == null ? null : backendBucket.toString())
            .build();
    return getBackendBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified BackendBucket resource. Gets a list of available backend buckets by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   BackendBucket response = backendBucketClient.getBackendBucket(backendBucket.toString());
   * }
   * </code></pre>
   *
   * @param backendBucket Name of the BackendBucket resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final BackendBucket getBackendBucket(String backendBucket) {

    GetBackendBucketHttpRequest request =
        GetBackendBucketHttpRequest.newBuilder().setBackendBucket(backendBucket).build();
    return getBackendBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified BackendBucket resource. Gets a list of available backend buckets by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   GetBackendBucketHttpRequest request = GetBackendBucketHttpRequest.newBuilder()
   *     .setBackendBucket(backendBucket.toString())
   *     .build();
   *   BackendBucket response = backendBucketClient.getBackendBucket(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final BackendBucket getBackendBucket(GetBackendBucketHttpRequest request) {
    return getBackendBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified BackendBucket resource. Gets a list of available backend buckets by
   * making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   GetBackendBucketHttpRequest request = GetBackendBucketHttpRequest.newBuilder()
   *     .setBackendBucket(backendBucket.toString())
   *     .build();
   *   ApiFuture&lt;BackendBucket&gt; future = backendBucketClient.getBackendBucketCallable().futureCall(request);
   *   // Do something
   *   BackendBucket response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetBackendBucketHttpRequest, BackendBucket>
      getBackendBucketCallable() {
    return stub.getBackendBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a BackendBucket resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   Operation response = backendBucketClient.insertBackendBucket(project, backendBucketResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param backendBucketResource A BackendBucket resource. This resource defines a Cloud Storage
   *     bucket.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertBackendBucket(
      ProjectName project, BackendBucket backendBucketResource) {

    InsertBackendBucketHttpRequest request =
        InsertBackendBucketHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setBackendBucketResource(backendBucketResource)
            .build();
    return insertBackendBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a BackendBucket resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   Operation response = backendBucketClient.insertBackendBucket(project.toString(), backendBucketResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param backendBucketResource A BackendBucket resource. This resource defines a Cloud Storage
   *     bucket.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertBackendBucket(String project, BackendBucket backendBucketResource) {

    InsertBackendBucketHttpRequest request =
        InsertBackendBucketHttpRequest.newBuilder()
            .setProject(project)
            .setBackendBucketResource(backendBucketResource)
            .build();
    return insertBackendBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a BackendBucket resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   InsertBackendBucketHttpRequest request = InsertBackendBucketHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setBackendBucketResource(backendBucketResource)
   *     .build();
   *   Operation response = backendBucketClient.insertBackendBucket(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertBackendBucket(InsertBackendBucketHttpRequest request) {
    return insertBackendBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a BackendBucket resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   InsertBackendBucketHttpRequest request = InsertBackendBucketHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setBackendBucketResource(backendBucketResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = backendBucketClient.insertBackendBucketCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertBackendBucketHttpRequest, Operation>
      insertBackendBucketCallable() {
    return stub.insertBackendBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of BackendBucket resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (BackendBucket element : backendBucketClient.listBackendBuckets(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListBackendBucketsPagedResponse listBackendBuckets(ProjectName project) {
    ListBackendBucketsHttpRequest request =
        ListBackendBucketsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listBackendBuckets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of BackendBucket resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (BackendBucket element : backendBucketClient.listBackendBuckets(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListBackendBucketsPagedResponse listBackendBuckets(String project) {
    ListBackendBucketsHttpRequest request =
        ListBackendBucketsHttpRequest.newBuilder().setProject(project).build();
    return listBackendBuckets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of BackendBucket resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListBackendBucketsHttpRequest request = ListBackendBucketsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (BackendBucket element : backendBucketClient.listBackendBuckets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListBackendBucketsPagedResponse listBackendBuckets(
      ListBackendBucketsHttpRequest request) {
    return listBackendBucketsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of BackendBucket resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListBackendBucketsHttpRequest request = ListBackendBucketsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;ListBackendBucketsPagedResponse&gt; future = backendBucketClient.listBackendBucketsPagedCallable().futureCall(request);
   *   // Do something
   *   for (BackendBucket element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListBackendBucketsHttpRequest, ListBackendBucketsPagedResponse>
      listBackendBucketsPagedCallable() {
    return stub.listBackendBucketsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of BackendBucket resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListBackendBucketsHttpRequest request = ListBackendBucketsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     BackendBucketList response = backendBucketClient.listBackendBucketsCallable().call(request);
   *     for (BackendBucket element : response.getItemsList()) {
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
  public final UnaryCallable<ListBackendBucketsHttpRequest, BackendBucketList>
      listBackendBucketsCallable() {
    return stub.listBackendBucketsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified BackendBucket resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = backendBucketClient.patchBackendBucket(backendBucket, backendBucketResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param backendBucket Name of the BackendBucket resource to patch.
   * @param backendBucketResource A BackendBucket resource. This resource defines a Cloud Storage
   *     bucket.
   * @param fieldMask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchBackendBucket(
      ProjectGlobalBackendBucketName backendBucket,
      BackendBucket backendBucketResource,
      List<String> fieldMask) {

    PatchBackendBucketHttpRequest request =
        PatchBackendBucketHttpRequest.newBuilder()
            .setBackendBucket(backendBucket == null ? null : backendBucket.toString())
            .setBackendBucketResource(backendBucketResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchBackendBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified BackendBucket resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = backendBucketClient.patchBackendBucket(backendBucket.toString(), backendBucketResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param backendBucket Name of the BackendBucket resource to patch.
   * @param backendBucketResource A BackendBucket resource. This resource defines a Cloud Storage
   *     bucket.
   * @param fieldMask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchBackendBucket(
      String backendBucket, BackendBucket backendBucketResource, List<String> fieldMask) {

    PatchBackendBucketHttpRequest request =
        PatchBackendBucketHttpRequest.newBuilder()
            .setBackendBucket(backendBucket)
            .setBackendBucketResource(backendBucketResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchBackendBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified BackendBucket resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchBackendBucketHttpRequest request = PatchBackendBucketHttpRequest.newBuilder()
   *     .setBackendBucket(backendBucket.toString())
   *     .setBackendBucketResource(backendBucketResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = backendBucketClient.patchBackendBucket(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchBackendBucket(PatchBackendBucketHttpRequest request) {
    return patchBackendBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified BackendBucket resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchBackendBucketHttpRequest request = PatchBackendBucketHttpRequest.newBuilder()
   *     .setBackendBucket(backendBucket.toString())
   *     .setBackendBucketResource(backendBucketResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = backendBucketClient.patchBackendBucketCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchBackendBucketHttpRequest, Operation>
      patchBackendBucketCallable() {
    return stub.patchBackendBucketCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified BackendBucket resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = backendBucketClient.updateBackendBucket(backendBucket, backendBucketResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param backendBucket Name of the BackendBucket resource to update.
   * @param backendBucketResource A BackendBucket resource. This resource defines a Cloud Storage
   *     bucket.
   * @param fieldMask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateBackendBucket(
      ProjectGlobalBackendBucketName backendBucket,
      BackendBucket backendBucketResource,
      List<String> fieldMask) {

    UpdateBackendBucketHttpRequest request =
        UpdateBackendBucketHttpRequest.newBuilder()
            .setBackendBucket(backendBucket == null ? null : backendBucket.toString())
            .setBackendBucketResource(backendBucketResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateBackendBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified BackendBucket resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = backendBucketClient.updateBackendBucket(backendBucket.toString(), backendBucketResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param backendBucket Name of the BackendBucket resource to update.
   * @param backendBucketResource A BackendBucket resource. This resource defines a Cloud Storage
   *     bucket.
   * @param fieldMask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateBackendBucket(
      String backendBucket, BackendBucket backendBucketResource, List<String> fieldMask) {

    UpdateBackendBucketHttpRequest request =
        UpdateBackendBucketHttpRequest.newBuilder()
            .setBackendBucket(backendBucket)
            .setBackendBucketResource(backendBucketResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateBackendBucket(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified BackendBucket resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateBackendBucketHttpRequest request = UpdateBackendBucketHttpRequest.newBuilder()
   *     .setBackendBucket(backendBucket.toString())
   *     .setBackendBucketResource(backendBucketResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = backendBucketClient.updateBackendBucket(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateBackendBucket(UpdateBackendBucketHttpRequest request) {
    return updateBackendBucketCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified BackendBucket resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BackendBucketClient backendBucketClient = BackendBucketClient.create()) {
   *   ProjectGlobalBackendBucketName backendBucket = ProjectGlobalBackendBucketName.of("[PROJECT]", "[BACKEND_BUCKET]");
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateBackendBucketHttpRequest request = UpdateBackendBucketHttpRequest.newBuilder()
   *     .setBackendBucket(backendBucket.toString())
   *     .setBackendBucketResource(backendBucketResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = backendBucketClient.updateBackendBucketCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<UpdateBackendBucketHttpRequest, Operation>
      updateBackendBucketCallable() {
    return stub.updateBackendBucketCallable();
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

  public static class ListBackendBucketsPagedResponse
      extends AbstractPagedListResponse<
          ListBackendBucketsHttpRequest,
          BackendBucketList,
          BackendBucket,
          ListBackendBucketsPage,
          ListBackendBucketsFixedSizeCollection> {

    public static ApiFuture<ListBackendBucketsPagedResponse> createAsync(
        PageContext<ListBackendBucketsHttpRequest, BackendBucketList, BackendBucket> context,
        ApiFuture<BackendBucketList> futureResponse) {
      ApiFuture<ListBackendBucketsPage> futurePage =
          ListBackendBucketsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListBackendBucketsPage, ListBackendBucketsPagedResponse>() {
            @Override
            public ListBackendBucketsPagedResponse apply(ListBackendBucketsPage input) {
              return new ListBackendBucketsPagedResponse(input);
            }
          });
    }

    private ListBackendBucketsPagedResponse(ListBackendBucketsPage page) {
      super(page, ListBackendBucketsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackendBucketsPage
      extends AbstractPage<
          ListBackendBucketsHttpRequest, BackendBucketList, BackendBucket, ListBackendBucketsPage> {

    private ListBackendBucketsPage(
        PageContext<ListBackendBucketsHttpRequest, BackendBucketList, BackendBucket> context,
        BackendBucketList response) {
      super(context, response);
    }

    private static ListBackendBucketsPage createEmptyPage() {
      return new ListBackendBucketsPage(null, null);
    }

    @Override
    protected ListBackendBucketsPage createPage(
        PageContext<ListBackendBucketsHttpRequest, BackendBucketList, BackendBucket> context,
        BackendBucketList response) {
      return new ListBackendBucketsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackendBucketsPage> createPageAsync(
        PageContext<ListBackendBucketsHttpRequest, BackendBucketList, BackendBucket> context,
        ApiFuture<BackendBucketList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackendBucketsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackendBucketsHttpRequest,
          BackendBucketList,
          BackendBucket,
          ListBackendBucketsPage,
          ListBackendBucketsFixedSizeCollection> {

    private ListBackendBucketsFixedSizeCollection(
        List<ListBackendBucketsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackendBucketsFixedSizeCollection createEmptyCollection() {
      return new ListBackendBucketsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackendBucketsFixedSizeCollection createCollection(
        List<ListBackendBucketsPage> pages, int collectionSize) {
      return new ListBackendBucketsFixedSizeCollection(pages, collectionSize);
    }
  }
}
