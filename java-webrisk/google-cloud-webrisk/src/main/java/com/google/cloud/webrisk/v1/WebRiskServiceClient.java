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

package com.google.cloud.webrisk.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.webrisk.v1.stub.WebRiskServiceStub;
import com.google.cloud.webrisk.v1.stub.WebRiskServiceStubSettings;
import com.google.protobuf.ByteString;
import com.google.webrisk.v1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1.CreateSubmissionRequest;
import com.google.webrisk.v1.ProjectName;
import com.google.webrisk.v1.SearchHashesRequest;
import com.google.webrisk.v1.SearchHashesResponse;
import com.google.webrisk.v1.SearchUrisRequest;
import com.google.webrisk.v1.SearchUrisResponse;
import com.google.webrisk.v1.Submission;
import com.google.webrisk.v1.ThreatType;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Web Risk API defines an interface to detect malicious URLs on your website
 * and in client applications.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
 *   ThreatType threatType = ThreatType.forNumber(0);
 *   ByteString versionToken = ByteString.EMPTY;
 *   ComputeThreatListDiffRequest.Constraints constraints =
 *       ComputeThreatListDiffRequest.Constraints.newBuilder().build();
 *   ComputeThreatListDiffResponse response =
 *       webRiskServiceClient.computeThreatListDiff(threatType, versionToken, constraints);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the WebRiskServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of WebRiskServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * WebRiskServiceSettings webRiskServiceSettings =
 *     WebRiskServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create(webRiskServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * WebRiskServiceSettings webRiskServiceSettings =
 *     WebRiskServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create(webRiskServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class WebRiskServiceClient implements BackgroundResource {
  private final WebRiskServiceSettings settings;
  private final WebRiskServiceStub stub;

  /** Constructs an instance of WebRiskServiceClient with default settings. */
  public static final WebRiskServiceClient create() throws IOException {
    return create(WebRiskServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of WebRiskServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final WebRiskServiceClient create(WebRiskServiceSettings settings)
      throws IOException {
    return new WebRiskServiceClient(settings);
  }

  /**
   * Constructs an instance of WebRiskServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(WebRiskServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final WebRiskServiceClient create(WebRiskServiceStub stub) {
    return new WebRiskServiceClient(stub);
  }

  /**
   * Constructs an instance of WebRiskServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected WebRiskServiceClient(WebRiskServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((WebRiskServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected WebRiskServiceClient(WebRiskServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final WebRiskServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public WebRiskServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent threat list diffs. These diffs should be applied to a local database of
   * hashes to keep it up-to-date. If the local database is empty or excessively out-of-date, a
   * complete snapshot of the database will be returned. This Method only updates a single
   * ThreatList at a time. To update multiple ThreatList databases, this method needs to be called
   * once for each list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
   *   ThreatType threatType = ThreatType.forNumber(0);
   *   ByteString versionToken = ByteString.EMPTY;
   *   ComputeThreatListDiffRequest.Constraints constraints =
   *       ComputeThreatListDiffRequest.Constraints.newBuilder().build();
   *   ComputeThreatListDiffResponse response =
   *       webRiskServiceClient.computeThreatListDiff(threatType, versionToken, constraints);
   * }
   * }</pre>
   *
   * @param threatType Required. The threat list to update. Only a single ThreatType should be
   *     specified.
   * @param versionToken The current version token of the client for the requested list (the client
   *     version that was received from the last successful diff). If the client does not have a
   *     version token (this is the first time calling ComputeThreatListDiff), this may be left
   *     empty and a full database snapshot will be returned.
   * @param constraints Required. The constraints associated with this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeThreatListDiffResponse computeThreatListDiff(
      ThreatType threatType,
      ByteString versionToken,
      ComputeThreatListDiffRequest.Constraints constraints) {
    ComputeThreatListDiffRequest request =
        ComputeThreatListDiffRequest.newBuilder()
            .setThreatType(threatType)
            .setVersionToken(versionToken)
            .setConstraints(constraints)
            .build();
    return computeThreatListDiff(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent threat list diffs. These diffs should be applied to a local database of
   * hashes to keep it up-to-date. If the local database is empty or excessively out-of-date, a
   * complete snapshot of the database will be returned. This Method only updates a single
   * ThreatList at a time. To update multiple ThreatList databases, this method needs to be called
   * once for each list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
   *   ComputeThreatListDiffRequest request =
   *       ComputeThreatListDiffRequest.newBuilder()
   *           .setThreatType(ThreatType.forNumber(0))
   *           .setVersionToken(ByteString.EMPTY)
   *           .setConstraints(ComputeThreatListDiffRequest.Constraints.newBuilder().build())
   *           .build();
   *   ComputeThreatListDiffResponse response = webRiskServiceClient.computeThreatListDiff(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComputeThreatListDiffResponse computeThreatListDiff(
      ComputeThreatListDiffRequest request) {
    return computeThreatListDiffCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the most recent threat list diffs. These diffs should be applied to a local database of
   * hashes to keep it up-to-date. If the local database is empty or excessively out-of-date, a
   * complete snapshot of the database will be returned. This Method only updates a single
   * ThreatList at a time. To update multiple ThreatList databases, this method needs to be called
   * once for each list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
   *   ComputeThreatListDiffRequest request =
   *       ComputeThreatListDiffRequest.newBuilder()
   *           .setThreatType(ThreatType.forNumber(0))
   *           .setVersionToken(ByteString.EMPTY)
   *           .setConstraints(ComputeThreatListDiffRequest.Constraints.newBuilder().build())
   *           .build();
   *   ApiFuture<ComputeThreatListDiffResponse> future =
   *       webRiskServiceClient.computeThreatListDiffCallable().futureCall(request);
   *   // Do something.
   *   ComputeThreatListDiffResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
      computeThreatListDiffCallable() {
    return stub.computeThreatListDiffCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method is used to check whether a URI is on a given threatList. Multiple threatLists may
   * be searched in a single query. The response will list all requested threatLists the URI was
   * found to match. If the URI is not found on any of the requested ThreatList an empty response
   * will be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
   *   String uri = "uri116076";
   *   List<ThreatType> threatTypes = new ArrayList<>();
   *   SearchUrisResponse response = webRiskServiceClient.searchUris(uri, threatTypes);
   * }
   * }</pre>
   *
   * @param uri Required. The URI to be checked for matches.
   * @param threatTypes Required. The ThreatLists to search in. Multiple ThreatLists may be
   *     specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchUrisResponse searchUris(String uri, List<ThreatType> threatTypes) {
    SearchUrisRequest request =
        SearchUrisRequest.newBuilder().setUri(uri).addAllThreatTypes(threatTypes).build();
    return searchUris(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method is used to check whether a URI is on a given threatList. Multiple threatLists may
   * be searched in a single query. The response will list all requested threatLists the URI was
   * found to match. If the URI is not found on any of the requested ThreatList an empty response
   * will be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
   *   SearchUrisRequest request =
   *       SearchUrisRequest.newBuilder()
   *           .setUri("uri116076")
   *           .addAllThreatTypes(new ArrayList<ThreatType>())
   *           .build();
   *   SearchUrisResponse response = webRiskServiceClient.searchUris(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchUrisResponse searchUris(SearchUrisRequest request) {
    return searchUrisCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This method is used to check whether a URI is on a given threatList. Multiple threatLists may
   * be searched in a single query. The response will list all requested threatLists the URI was
   * found to match. If the URI is not found on any of the requested ThreatList an empty response
   * will be returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
   *   SearchUrisRequest request =
   *       SearchUrisRequest.newBuilder()
   *           .setUri("uri116076")
   *           .addAllThreatTypes(new ArrayList<ThreatType>())
   *           .build();
   *   ApiFuture<SearchUrisResponse> future =
   *       webRiskServiceClient.searchUrisCallable().futureCall(request);
   *   // Do something.
   *   SearchUrisResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchUrisRequest, SearchUrisResponse> searchUrisCallable() {
    return stub.searchUrisCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the full hashes that match the requested hash prefix. This is used after a hash prefix is
   * looked up in a threatList and there is a match. The client side threatList only holds partial
   * hashes so the client must query this method to determine if there is a full hash match of a
   * threat.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
   *   ByteString hashPrefix = ByteString.EMPTY;
   *   List<ThreatType> threatTypes = new ArrayList<>();
   *   SearchHashesResponse response = webRiskServiceClient.searchHashes(hashPrefix, threatTypes);
   * }
   * }</pre>
   *
   * @param hashPrefix A hash prefix, consisting of the most significant 4-32 bytes of a SHA256
   *     hash. For JSON requests, this field is base64-encoded.
   * @param threatTypes Required. The ThreatLists to search in. Multiple ThreatLists may be
   *     specified.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchHashesResponse searchHashes(
      ByteString hashPrefix, List<ThreatType> threatTypes) {
    SearchHashesRequest request =
        SearchHashesRequest.newBuilder()
            .setHashPrefix(hashPrefix)
            .addAllThreatTypes(threatTypes)
            .build();
    return searchHashes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the full hashes that match the requested hash prefix. This is used after a hash prefix is
   * looked up in a threatList and there is a match. The client side threatList only holds partial
   * hashes so the client must query this method to determine if there is a full hash match of a
   * threat.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
   *   SearchHashesRequest request =
   *       SearchHashesRequest.newBuilder()
   *           .setHashPrefix(ByteString.EMPTY)
   *           .addAllThreatTypes(new ArrayList<ThreatType>())
   *           .build();
   *   SearchHashesResponse response = webRiskServiceClient.searchHashes(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchHashesResponse searchHashes(SearchHashesRequest request) {
    return searchHashesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the full hashes that match the requested hash prefix. This is used after a hash prefix is
   * looked up in a threatList and there is a match. The client side threatList only holds partial
   * hashes so the client must query this method to determine if there is a full hash match of a
   * threat.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
   *   SearchHashesRequest request =
   *       SearchHashesRequest.newBuilder()
   *           .setHashPrefix(ByteString.EMPTY)
   *           .addAllThreatTypes(new ArrayList<ThreatType>())
   *           .build();
   *   ApiFuture<SearchHashesResponse> future =
   *       webRiskServiceClient.searchHashesCallable().futureCall(request);
   *   // Do something.
   *   SearchHashesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchHashesRequest, SearchHashesResponse> searchHashesCallable() {
    return stub.searchHashesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Submission of a URI suspected of containing phishing content to be reviewed. If the
   * result verifies the existence of malicious phishing content, the site will be added to the
   * [Google's Social Engineering lists](https://support.google.com/webmasters/answer/6350487/) in
   * order to protect users that could get exposed to this threat in the future. Only projects with
   * CREATE_SUBMISSION_USERS visibility can use this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Submission submission = Submission.newBuilder().build();
   *   Submission response = webRiskServiceClient.createSubmission(parent, submission);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project that is making the submission. This string is
   *     in the format "projects/{project_number}".
   * @param submission Required. The submission that contains the content of the phishing report.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Submission createSubmission(ProjectName parent, Submission submission) {
    CreateSubmissionRequest request =
        CreateSubmissionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSubmission(submission)
            .build();
    return createSubmission(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Submission of a URI suspected of containing phishing content to be reviewed. If the
   * result verifies the existence of malicious phishing content, the site will be added to the
   * [Google's Social Engineering lists](https://support.google.com/webmasters/answer/6350487/) in
   * order to protect users that could get exposed to this threat in the future. Only projects with
   * CREATE_SUBMISSION_USERS visibility can use this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Submission submission = Submission.newBuilder().build();
   *   Submission response = webRiskServiceClient.createSubmission(parent, submission);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project that is making the submission. This string is
   *     in the format "projects/{project_number}".
   * @param submission Required. The submission that contains the content of the phishing report.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Submission createSubmission(String parent, Submission submission) {
    CreateSubmissionRequest request =
        CreateSubmissionRequest.newBuilder().setParent(parent).setSubmission(submission).build();
    return createSubmission(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Submission of a URI suspected of containing phishing content to be reviewed. If the
   * result verifies the existence of malicious phishing content, the site will be added to the
   * [Google's Social Engineering lists](https://support.google.com/webmasters/answer/6350487/) in
   * order to protect users that could get exposed to this threat in the future. Only projects with
   * CREATE_SUBMISSION_USERS visibility can use this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
   *   CreateSubmissionRequest request =
   *       CreateSubmissionRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSubmission(Submission.newBuilder().build())
   *           .build();
   *   Submission response = webRiskServiceClient.createSubmission(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Submission createSubmission(CreateSubmissionRequest request) {
    return createSubmissionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Submission of a URI suspected of containing phishing content to be reviewed. If the
   * result verifies the existence of malicious phishing content, the site will be added to the
   * [Google's Social Engineering lists](https://support.google.com/webmasters/answer/6350487/) in
   * order to protect users that could get exposed to this threat in the future. Only projects with
   * CREATE_SUBMISSION_USERS visibility can use this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (WebRiskServiceClient webRiskServiceClient = WebRiskServiceClient.create()) {
   *   CreateSubmissionRequest request =
   *       CreateSubmissionRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSubmission(Submission.newBuilder().build())
   *           .build();
   *   ApiFuture<Submission> future =
   *       webRiskServiceClient.createSubmissionCallable().futureCall(request);
   *   // Do something.
   *   Submission response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSubmissionRequest, Submission> createSubmissionCallable() {
    return stub.createSubmissionCallable();
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
}
