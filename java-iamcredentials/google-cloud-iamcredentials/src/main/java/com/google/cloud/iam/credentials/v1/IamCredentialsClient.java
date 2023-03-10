/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.iam.credentials.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.iam.credentials.v1.stub.IamCredentialsStub;
import com.google.cloud.iam.credentials.v1.stub.IamCredentialsStubSettings;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service account is a special type of Google account that belongs to your
 * application or a virtual machine (VM), instead of to an individual end user. Your application
 * assumes the identity of the service account to call Google APIs, so that the users aren't
 * directly involved.
 *
 * <p>Service account credentials are used to temporarily assume the identity of the service
 * account. Supported credential types include OAuth 2.0 access tokens, OpenID Connect ID tokens,
 * self-signed JSON Web Tokens (JWTs), and more.
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
 * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
 *   ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
 *   List<String> delegates = new ArrayList<>();
 *   List<String> scope = new ArrayList<>();
 *   Duration lifetime = Duration.newBuilder().build();
 *   GenerateAccessTokenResponse response =
 *       iamCredentialsClient.generateAccessToken(name, delegates, scope, lifetime);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IamCredentialsClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of IamCredentialsSettings to
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
 * IamCredentialsSettings iamCredentialsSettings =
 *     IamCredentialsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create(iamCredentialsSettings);
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
 * IamCredentialsSettings iamCredentialsSettings =
 *     IamCredentialsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create(iamCredentialsSettings);
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
 * IamCredentialsSettings iamCredentialsSettings =
 *     IamCredentialsSettings.newHttpJsonBuilder().build();
 * IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create(iamCredentialsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class IamCredentialsClient implements BackgroundResource {
  private final IamCredentialsSettings settings;
  private final IamCredentialsStub stub;

  /** Constructs an instance of IamCredentialsClient with default settings. */
  public static final IamCredentialsClient create() throws IOException {
    return create(IamCredentialsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IamCredentialsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final IamCredentialsClient create(IamCredentialsSettings settings)
      throws IOException {
    return new IamCredentialsClient(settings);
  }

  /**
   * Constructs an instance of IamCredentialsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(IamCredentialsSettings).
   */
  public static final IamCredentialsClient create(IamCredentialsStub stub) {
    return new IamCredentialsClient(stub);
  }

  /**
   * Constructs an instance of IamCredentialsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected IamCredentialsClient(IamCredentialsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((IamCredentialsStubSettings) settings.getStubSettings()).createStub();
  }

  protected IamCredentialsClient(IamCredentialsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final IamCredentialsSettings getSettings() {
    return settings;
  }

  public IamCredentialsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates an OAuth 2.0 access token for a service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
   *   List<String> delegates = new ArrayList<>();
   *   List<String> scope = new ArrayList<>();
   *   Duration lifetime = Duration.newBuilder().build();
   *   GenerateAccessTokenResponse response =
   *       iamCredentialsClient.generateAccessToken(name, delegates, scope, lifetime);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account for which the credentials are
   *     requested, in the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param delegates The sequence of service accounts in a delegation chain. Each service account
   *     must be granted the `roles/iam.serviceAccountTokenCreator` role on its next service account
   *     in the chain. The last service account in the chain must be granted the
   *     `roles/iam.serviceAccountTokenCreator` role on the service account that is specified in the
   *     `name` field of the request.
   *     <p>The delegates must have the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param scope Required. Code to identify the scopes to be included in the OAuth 2.0 access
   *     token. See https://developers.google.com/identity/protocols/googlescopes for more
   *     information. At least one value required.
   * @param lifetime The desired lifetime duration of the access token in seconds. Must be set to a
   *     value less than or equal to 3600 (1 hour). If a value is not specified, the token's
   *     lifetime will be set to a default value of one hour.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateAccessTokenResponse generateAccessToken(
      ServiceAccountName name, List<String> delegates, List<String> scope, Duration lifetime) {
    GenerateAccessTokenRequest request =
        GenerateAccessTokenRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllDelegates(delegates)
            .addAllScope(scope)
            .setLifetime(lifetime)
            .build();
    return generateAccessToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates an OAuth 2.0 access token for a service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   String name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString();
   *   List<String> delegates = new ArrayList<>();
   *   List<String> scope = new ArrayList<>();
   *   Duration lifetime = Duration.newBuilder().build();
   *   GenerateAccessTokenResponse response =
   *       iamCredentialsClient.generateAccessToken(name, delegates, scope, lifetime);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account for which the credentials are
   *     requested, in the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param delegates The sequence of service accounts in a delegation chain. Each service account
   *     must be granted the `roles/iam.serviceAccountTokenCreator` role on its next service account
   *     in the chain. The last service account in the chain must be granted the
   *     `roles/iam.serviceAccountTokenCreator` role on the service account that is specified in the
   *     `name` field of the request.
   *     <p>The delegates must have the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param scope Required. Code to identify the scopes to be included in the OAuth 2.0 access
   *     token. See https://developers.google.com/identity/protocols/googlescopes for more
   *     information. At least one value required.
   * @param lifetime The desired lifetime duration of the access token in seconds. Must be set to a
   *     value less than or equal to 3600 (1 hour). If a value is not specified, the token's
   *     lifetime will be set to a default value of one hour.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateAccessTokenResponse generateAccessToken(
      String name, List<String> delegates, List<String> scope, Duration lifetime) {
    GenerateAccessTokenRequest request =
        GenerateAccessTokenRequest.newBuilder()
            .setName(name)
            .addAllDelegates(delegates)
            .addAllScope(scope)
            .setLifetime(lifetime)
            .build();
    return generateAccessToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates an OAuth 2.0 access token for a service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   GenerateAccessTokenRequest request =
   *       GenerateAccessTokenRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .addAllDelegates(new ArrayList<String>())
   *           .addAllScope(new ArrayList<String>())
   *           .setLifetime(Duration.newBuilder().build())
   *           .build();
   *   GenerateAccessTokenResponse response = iamCredentialsClient.generateAccessToken(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateAccessTokenResponse generateAccessToken(GenerateAccessTokenRequest request) {
    return generateAccessTokenCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates an OAuth 2.0 access token for a service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   GenerateAccessTokenRequest request =
   *       GenerateAccessTokenRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .addAllDelegates(new ArrayList<String>())
   *           .addAllScope(new ArrayList<String>())
   *           .setLifetime(Duration.newBuilder().build())
   *           .build();
   *   ApiFuture<GenerateAccessTokenResponse> future =
   *       iamCredentialsClient.generateAccessTokenCallable().futureCall(request);
   *   // Do something.
   *   GenerateAccessTokenResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateAccessTokenRequest, GenerateAccessTokenResponse>
      generateAccessTokenCallable() {
    return stub.generateAccessTokenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates an OpenID Connect ID token for a service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
   *   List<String> delegates = new ArrayList<>();
   *   String audience = "audience975628804";
   *   boolean includeEmail = true;
   *   GenerateIdTokenResponse response =
   *       iamCredentialsClient.generateIdToken(name, delegates, audience, includeEmail);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account for which the credentials are
   *     requested, in the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param delegates The sequence of service accounts in a delegation chain. Each service account
   *     must be granted the `roles/iam.serviceAccountTokenCreator` role on its next service account
   *     in the chain. The last service account in the chain must be granted the
   *     `roles/iam.serviceAccountTokenCreator` role on the service account that is specified in the
   *     `name` field of the request.
   *     <p>The delegates must have the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param audience Required. The audience for the token, such as the API or account that this
   *     token grants access to.
   * @param includeEmail Include the service account email in the token. If set to `true`, the token
   *     will contain `email` and `email_verified` claims.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateIdTokenResponse generateIdToken(
      ServiceAccountName name, List<String> delegates, String audience, boolean includeEmail) {
    GenerateIdTokenRequest request =
        GenerateIdTokenRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllDelegates(delegates)
            .setAudience(audience)
            .setIncludeEmail(includeEmail)
            .build();
    return generateIdToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates an OpenID Connect ID token for a service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   String name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString();
   *   List<String> delegates = new ArrayList<>();
   *   String audience = "audience975628804";
   *   boolean includeEmail = true;
   *   GenerateIdTokenResponse response =
   *       iamCredentialsClient.generateIdToken(name, delegates, audience, includeEmail);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account for which the credentials are
   *     requested, in the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param delegates The sequence of service accounts in a delegation chain. Each service account
   *     must be granted the `roles/iam.serviceAccountTokenCreator` role on its next service account
   *     in the chain. The last service account in the chain must be granted the
   *     `roles/iam.serviceAccountTokenCreator` role on the service account that is specified in the
   *     `name` field of the request.
   *     <p>The delegates must have the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param audience Required. The audience for the token, such as the API or account that this
   *     token grants access to.
   * @param includeEmail Include the service account email in the token. If set to `true`, the token
   *     will contain `email` and `email_verified` claims.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateIdTokenResponse generateIdToken(
      String name, List<String> delegates, String audience, boolean includeEmail) {
    GenerateIdTokenRequest request =
        GenerateIdTokenRequest.newBuilder()
            .setName(name)
            .addAllDelegates(delegates)
            .setAudience(audience)
            .setIncludeEmail(includeEmail)
            .build();
    return generateIdToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates an OpenID Connect ID token for a service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   GenerateIdTokenRequest request =
   *       GenerateIdTokenRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .addAllDelegates(new ArrayList<String>())
   *           .setAudience("audience975628804")
   *           .setIncludeEmail(true)
   *           .build();
   *   GenerateIdTokenResponse response = iamCredentialsClient.generateIdToken(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateIdTokenResponse generateIdToken(GenerateIdTokenRequest request) {
    return generateIdTokenCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates an OpenID Connect ID token for a service account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   GenerateIdTokenRequest request =
   *       GenerateIdTokenRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .addAllDelegates(new ArrayList<String>())
   *           .setAudience("audience975628804")
   *           .setIncludeEmail(true)
   *           .build();
   *   ApiFuture<GenerateIdTokenResponse> future =
   *       iamCredentialsClient.generateIdTokenCallable().futureCall(request);
   *   // Do something.
   *   GenerateIdTokenResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateIdTokenRequest, GenerateIdTokenResponse>
      generateIdTokenCallable() {
    return stub.generateIdTokenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs a blob using a service account's system-managed private key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
   *   List<String> delegates = new ArrayList<>();
   *   ByteString payload = ByteString.EMPTY;
   *   SignBlobResponse response = iamCredentialsClient.signBlob(name, delegates, payload);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account for which the credentials are
   *     requested, in the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param delegates The sequence of service accounts in a delegation chain. Each service account
   *     must be granted the `roles/iam.serviceAccountTokenCreator` role on its next service account
   *     in the chain. The last service account in the chain must be granted the
   *     `roles/iam.serviceAccountTokenCreator` role on the service account that is specified in the
   *     `name` field of the request.
   *     <p>The delegates must have the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param payload Required. The bytes to sign.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SignBlobResponse signBlob(
      ServiceAccountName name, List<String> delegates, ByteString payload) {
    SignBlobRequest request =
        SignBlobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllDelegates(delegates)
            .setPayload(payload)
            .build();
    return signBlob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs a blob using a service account's system-managed private key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   String name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString();
   *   List<String> delegates = new ArrayList<>();
   *   ByteString payload = ByteString.EMPTY;
   *   SignBlobResponse response = iamCredentialsClient.signBlob(name, delegates, payload);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account for which the credentials are
   *     requested, in the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param delegates The sequence of service accounts in a delegation chain. Each service account
   *     must be granted the `roles/iam.serviceAccountTokenCreator` role on its next service account
   *     in the chain. The last service account in the chain must be granted the
   *     `roles/iam.serviceAccountTokenCreator` role on the service account that is specified in the
   *     `name` field of the request.
   *     <p>The delegates must have the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param payload Required. The bytes to sign.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SignBlobResponse signBlob(String name, List<String> delegates, ByteString payload) {
    SignBlobRequest request =
        SignBlobRequest.newBuilder()
            .setName(name)
            .addAllDelegates(delegates)
            .setPayload(payload)
            .build();
    return signBlob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs a blob using a service account's system-managed private key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   SignBlobRequest request =
   *       SignBlobRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .addAllDelegates(new ArrayList<String>())
   *           .setPayload(ByteString.EMPTY)
   *           .build();
   *   SignBlobResponse response = iamCredentialsClient.signBlob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SignBlobResponse signBlob(SignBlobRequest request) {
    return signBlobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs a blob using a service account's system-managed private key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   SignBlobRequest request =
   *       SignBlobRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .addAllDelegates(new ArrayList<String>())
   *           .setPayload(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<SignBlobResponse> future =
   *       iamCredentialsClient.signBlobCallable().futureCall(request);
   *   // Do something.
   *   SignBlobResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SignBlobRequest, SignBlobResponse> signBlobCallable() {
    return stub.signBlobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs a JWT using a service account's system-managed private key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   ServiceAccountName name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]");
   *   List<String> delegates = new ArrayList<>();
   *   String payload = "payload-786701938";
   *   SignJwtResponse response = iamCredentialsClient.signJwt(name, delegates, payload);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account for which the credentials are
   *     requested, in the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param delegates The sequence of service accounts in a delegation chain. Each service account
   *     must be granted the `roles/iam.serviceAccountTokenCreator` role on its next service account
   *     in the chain. The last service account in the chain must be granted the
   *     `roles/iam.serviceAccountTokenCreator` role on the service account that is specified in the
   *     `name` field of the request.
   *     <p>The delegates must have the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param payload Required. The JWT payload to sign: a JSON object that contains a JWT Claims Set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SignJwtResponse signJwt(
      ServiceAccountName name, List<String> delegates, String payload) {
    SignJwtRequest request =
        SignJwtRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllDelegates(delegates)
            .setPayload(payload)
            .build();
    return signJwt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs a JWT using a service account's system-managed private key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   String name = ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString();
   *   List<String> delegates = new ArrayList<>();
   *   String payload = "payload-786701938";
   *   SignJwtResponse response = iamCredentialsClient.signJwt(name, delegates, payload);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the service account for which the credentials are
   *     requested, in the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param delegates The sequence of service accounts in a delegation chain. Each service account
   *     must be granted the `roles/iam.serviceAccountTokenCreator` role on its next service account
   *     in the chain. The last service account in the chain must be granted the
   *     `roles/iam.serviceAccountTokenCreator` role on the service account that is specified in the
   *     `name` field of the request.
   *     <p>The delegates must have the following format:
   *     `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is
   *     required; replacing it with a project ID is invalid.
   * @param payload Required. The JWT payload to sign: a JSON object that contains a JWT Claims Set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SignJwtResponse signJwt(String name, List<String> delegates, String payload) {
    SignJwtRequest request =
        SignJwtRequest.newBuilder()
            .setName(name)
            .addAllDelegates(delegates)
            .setPayload(payload)
            .build();
    return signJwt(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs a JWT using a service account's system-managed private key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   SignJwtRequest request =
   *       SignJwtRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .addAllDelegates(new ArrayList<String>())
   *           .setPayload("payload-786701938")
   *           .build();
   *   SignJwtResponse response = iamCredentialsClient.signJwt(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SignJwtResponse signJwt(SignJwtRequest request) {
    return signJwtCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Signs a JWT using a service account's system-managed private key.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCredentialsClient iamCredentialsClient = IamCredentialsClient.create()) {
   *   SignJwtRequest request =
   *       SignJwtRequest.newBuilder()
   *           .setName(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
   *           .addAllDelegates(new ArrayList<String>())
   *           .setPayload("payload-786701938")
   *           .build();
   *   ApiFuture<SignJwtResponse> future =
   *       iamCredentialsClient.signJwtCallable().futureCall(request);
   *   // Do something.
   *   SignJwtResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SignJwtRequest, SignJwtResponse> signJwtCallable() {
    return stub.signJwtCallable();
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
