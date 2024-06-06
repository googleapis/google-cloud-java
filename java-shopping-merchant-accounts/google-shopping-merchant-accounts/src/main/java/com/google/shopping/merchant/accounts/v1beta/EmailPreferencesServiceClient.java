/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.accounts.v1beta;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.accounts.v1beta.stub.EmailPreferencesServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.EmailPreferencesServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to support the `EmailPreferences` API.
 *
 * <p>This service only permits retrieving and updating email preferences for the authenticated
 * user.
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
 * try (EmailPreferencesServiceClient emailPreferencesServiceClient =
 *     EmailPreferencesServiceClient.create()) {
 *   EmailPreferencesName name = EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]");
 *   EmailPreferences response = emailPreferencesServiceClient.getEmailPreferences(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EmailPreferencesServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetEmailPreferences</td>
 *      <td><p> Returns the email preferences for a Merchant Center account user.
 * <p>  Use the name=accounts/&#42;/users/me/emailPreferences alias to get preferences for the authenticated user.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEmailPreferences(GetEmailPreferencesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEmailPreferences(EmailPreferencesName name)
 *           <li><p> getEmailPreferences(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEmailPreferencesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEmailPreferences</td>
 *      <td><p> Updates the email preferences for a Merchant Center account user. MCA users should specify the MCA account rather than a sub-account of the MCA.
 * <p>  Preferences which are not explicitly selected in the update mask will not be updated.
 * <p>  It is invalid for updates to specify an UNCONFIRMED opt-in status value.
 * <p>  Use the name=accounts/&#42;/users/me/emailPreferences alias to update preferences for the authenticated user.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEmailPreferences(UpdateEmailPreferencesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateEmailPreferences(EmailPreferences emailPreferences, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEmailPreferencesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of
 * EmailPreferencesServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EmailPreferencesServiceSettings emailPreferencesServiceSettings =
 *     EmailPreferencesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EmailPreferencesServiceClient emailPreferencesServiceClient =
 *     EmailPreferencesServiceClient.create(emailPreferencesServiceSettings);
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
 * EmailPreferencesServiceSettings emailPreferencesServiceSettings =
 *     EmailPreferencesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EmailPreferencesServiceClient emailPreferencesServiceClient =
 *     EmailPreferencesServiceClient.create(emailPreferencesServiceSettings);
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
 * EmailPreferencesServiceSettings emailPreferencesServiceSettings =
 *     EmailPreferencesServiceSettings.newHttpJsonBuilder().build();
 * EmailPreferencesServiceClient emailPreferencesServiceClient =
 *     EmailPreferencesServiceClient.create(emailPreferencesServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EmailPreferencesServiceClient implements BackgroundResource {
  private final EmailPreferencesServiceSettings settings;
  private final EmailPreferencesServiceStub stub;

  /** Constructs an instance of EmailPreferencesServiceClient with default settings. */
  public static final EmailPreferencesServiceClient create() throws IOException {
    return create(EmailPreferencesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EmailPreferencesServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EmailPreferencesServiceClient create(EmailPreferencesServiceSettings settings)
      throws IOException {
    return new EmailPreferencesServiceClient(settings);
  }

  /**
   * Constructs an instance of EmailPreferencesServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(EmailPreferencesServiceSettings).
   */
  public static final EmailPreferencesServiceClient create(EmailPreferencesServiceStub stub) {
    return new EmailPreferencesServiceClient(stub);
  }

  /**
   * Constructs an instance of EmailPreferencesServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected EmailPreferencesServiceClient(EmailPreferencesServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((EmailPreferencesServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected EmailPreferencesServiceClient(EmailPreferencesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final EmailPreferencesServiceSettings getSettings() {
    return settings;
  }

  public EmailPreferencesServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the email preferences for a Merchant Center account user.
   *
   * <p>Use the name=accounts/&#42;/users/me/emailPreferences alias to get preferences for the
   * authenticated user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EmailPreferencesServiceClient emailPreferencesServiceClient =
   *     EmailPreferencesServiceClient.create()) {
   *   EmailPreferencesName name = EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]");
   *   EmailPreferences response = emailPreferencesServiceClient.getEmailPreferences(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `EmailPreferences` resource. Format:
   *     `accounts/{account}/users/{email}/emailPreferences`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EmailPreferences getEmailPreferences(EmailPreferencesName name) {
    GetEmailPreferencesRequest request =
        GetEmailPreferencesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEmailPreferences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the email preferences for a Merchant Center account user.
   *
   * <p>Use the name=accounts/&#42;/users/me/emailPreferences alias to get preferences for the
   * authenticated user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EmailPreferencesServiceClient emailPreferencesServiceClient =
   *     EmailPreferencesServiceClient.create()) {
   *   String name = EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]").toString();
   *   EmailPreferences response = emailPreferencesServiceClient.getEmailPreferences(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the `EmailPreferences` resource. Format:
   *     `accounts/{account}/users/{email}/emailPreferences`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EmailPreferences getEmailPreferences(String name) {
    GetEmailPreferencesRequest request =
        GetEmailPreferencesRequest.newBuilder().setName(name).build();
    return getEmailPreferences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the email preferences for a Merchant Center account user.
   *
   * <p>Use the name=accounts/&#42;/users/me/emailPreferences alias to get preferences for the
   * authenticated user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EmailPreferencesServiceClient emailPreferencesServiceClient =
   *     EmailPreferencesServiceClient.create()) {
   *   GetEmailPreferencesRequest request =
   *       GetEmailPreferencesRequest.newBuilder()
   *           .setName(EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]").toString())
   *           .build();
   *   EmailPreferences response = emailPreferencesServiceClient.getEmailPreferences(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EmailPreferences getEmailPreferences(GetEmailPreferencesRequest request) {
    return getEmailPreferencesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the email preferences for a Merchant Center account user.
   *
   * <p>Use the name=accounts/&#42;/users/me/emailPreferences alias to get preferences for the
   * authenticated user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EmailPreferencesServiceClient emailPreferencesServiceClient =
   *     EmailPreferencesServiceClient.create()) {
   *   GetEmailPreferencesRequest request =
   *       GetEmailPreferencesRequest.newBuilder()
   *           .setName(EmailPreferencesName.of("[ACCOUNT]", "[EMAIL]").toString())
   *           .build();
   *   ApiFuture<EmailPreferences> future =
   *       emailPreferencesServiceClient.getEmailPreferencesCallable().futureCall(request);
   *   // Do something.
   *   EmailPreferences response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEmailPreferencesRequest, EmailPreferences>
      getEmailPreferencesCallable() {
    return stub.getEmailPreferencesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the email preferences for a Merchant Center account user. MCA users should specify the
   * MCA account rather than a sub-account of the MCA.
   *
   * <p>Preferences which are not explicitly selected in the update mask will not be updated.
   *
   * <p>It is invalid for updates to specify an UNCONFIRMED opt-in status value.
   *
   * <p>Use the name=accounts/&#42;/users/me/emailPreferences alias to update preferences for the
   * authenticated user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EmailPreferencesServiceClient emailPreferencesServiceClient =
   *     EmailPreferencesServiceClient.create()) {
   *   EmailPreferences emailPreferences = EmailPreferences.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EmailPreferences response =
   *       emailPreferencesServiceClient.updateEmailPreferences(emailPreferences, updateMask);
   * }
   * }</pre>
   *
   * @param emailPreferences Required. Email Preferences to be updated.
   * @param updateMask Required. List of fields being updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EmailPreferences updateEmailPreferences(
      EmailPreferences emailPreferences, FieldMask updateMask) {
    UpdateEmailPreferencesRequest request =
        UpdateEmailPreferencesRequest.newBuilder()
            .setEmailPreferences(emailPreferences)
            .setUpdateMask(updateMask)
            .build();
    return updateEmailPreferences(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the email preferences for a Merchant Center account user. MCA users should specify the
   * MCA account rather than a sub-account of the MCA.
   *
   * <p>Preferences which are not explicitly selected in the update mask will not be updated.
   *
   * <p>It is invalid for updates to specify an UNCONFIRMED opt-in status value.
   *
   * <p>Use the name=accounts/&#42;/users/me/emailPreferences alias to update preferences for the
   * authenticated user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EmailPreferencesServiceClient emailPreferencesServiceClient =
   *     EmailPreferencesServiceClient.create()) {
   *   UpdateEmailPreferencesRequest request =
   *       UpdateEmailPreferencesRequest.newBuilder()
   *           .setEmailPreferences(EmailPreferences.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   EmailPreferences response = emailPreferencesServiceClient.updateEmailPreferences(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EmailPreferences updateEmailPreferences(UpdateEmailPreferencesRequest request) {
    return updateEmailPreferencesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the email preferences for a Merchant Center account user. MCA users should specify the
   * MCA account rather than a sub-account of the MCA.
   *
   * <p>Preferences which are not explicitly selected in the update mask will not be updated.
   *
   * <p>It is invalid for updates to specify an UNCONFIRMED opt-in status value.
   *
   * <p>Use the name=accounts/&#42;/users/me/emailPreferences alias to update preferences for the
   * authenticated user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EmailPreferencesServiceClient emailPreferencesServiceClient =
   *     EmailPreferencesServiceClient.create()) {
   *   UpdateEmailPreferencesRequest request =
   *       UpdateEmailPreferencesRequest.newBuilder()
   *           .setEmailPreferences(EmailPreferences.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<EmailPreferences> future =
   *       emailPreferencesServiceClient.updateEmailPreferencesCallable().futureCall(request);
   *   // Do something.
   *   EmailPreferences response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEmailPreferencesRequest, EmailPreferences>
      updateEmailPreferencesCallable() {
    return stub.updateEmailPreferencesCallable();
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
