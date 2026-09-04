/*
 * Copyright 2026 Google LLC
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

package com.google.devicesandservices.health.v4;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.devicesandservices.health.v4.stub.HealthProfileServiceStub;
import com.google.devicesandservices.health.v4.stub.HealthProfileServiceStubSettings;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Health Profile Service
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
 * try (HealthProfileServiceClient healthProfileServiceClient =
 *     HealthProfileServiceClient.create()) {
 *   ProfileName name = ProfileName.of("[USER]");
 *   Profile response = healthProfileServiceClient.getProfile(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the HealthProfileServiceClient object to clean up
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
 *      <td><p> GetProfile</td>
 *      <td><p> Returns user Profile details.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProfile(GetProfileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProfile(ProfileName name)
 *           <li><p> getProfile(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProfileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateProfile</td>
 *      <td><p> Updates the user's profile details.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateProfile(UpdateProfileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateProfile(Profile profile, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateProfileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSettings</td>
 *      <td><p> Returns user settings details.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSettings(GetSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSettings(SettingsName name)
 *           <li><p> getSettings(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSettings</td>
 *      <td><p> Updates the user's settings details.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSettings(UpdateSettingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateSettings(Settings settings, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIdentity</td>
 *      <td><p> Gets the user's identity.
 * <p>  It includes the legacy Fitbit user ID and the Google user ID and it can be used by migrating clients to map identifiers between the two systems.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIdentity(GetIdentityRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIdentity(IdentityName name)
 *           <li><p> getIdentity(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIdentityCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIrnProfile</td>
 *      <td><p> Returns user's IRN Profile details.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIrnProfile(GetIrnProfileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIrnProfile(IrnProfileName name)
 *           <li><p> getIrnProfile(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIrnProfileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPairedDevice</td>
 *      <td><p> Returns user's Device.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPairedDevice(GetPairedDeviceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPairedDevice(PairedDeviceName name)
 *           <li><p> getPairedDevice(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPairedDeviceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPairedDevices</td>
 *      <td><p> Returns the user's list of paired 1P trackers and smartwatches.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPairedDevices(ListPairedDevicesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPairedDevices(UserName parent)
 *           <li><p> listPairedDevices(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPairedDevicesPagedCallable()
 *           <li><p> listPairedDevicesCallable()
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
 * <p>This class can be customized by passing in a custom instance of HealthProfileServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * HealthProfileServiceSettings healthProfileServiceSettings =
 *     HealthProfileServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * HealthProfileServiceClient healthProfileServiceClient =
 *     HealthProfileServiceClient.create(healthProfileServiceSettings);
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
 * HealthProfileServiceSettings healthProfileServiceSettings =
 *     HealthProfileServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * HealthProfileServiceClient healthProfileServiceClient =
 *     HealthProfileServiceClient.create(healthProfileServiceSettings);
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
 * HealthProfileServiceSettings healthProfileServiceSettings =
 *     HealthProfileServiceSettings.newHttpJsonBuilder().build();
 * HealthProfileServiceClient healthProfileServiceClient =
 *     HealthProfileServiceClient.create(healthProfileServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HealthProfileServiceClient implements BackgroundResource {
  private final @Nullable HealthProfileServiceSettings settings;
  private final HealthProfileServiceStub stub;

  /** Constructs an instance of HealthProfileServiceClient with default settings. */
  public static final HealthProfileServiceClient create() throws IOException {
    return create(HealthProfileServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HealthProfileServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final HealthProfileServiceClient create(HealthProfileServiceSettings settings)
      throws IOException {
    return new HealthProfileServiceClient(settings);
  }

  /**
   * Constructs an instance of HealthProfileServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(HealthProfileServiceSettings).
   */
  public static final HealthProfileServiceClient create(HealthProfileServiceStub stub) {
    return new HealthProfileServiceClient(stub);
  }

  /**
   * Constructs an instance of HealthProfileServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HealthProfileServiceClient(HealthProfileServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((HealthProfileServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected HealthProfileServiceClient(HealthProfileServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable HealthProfileServiceSettings getSettings() {
    return settings;
  }

  public HealthProfileServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user Profile details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   ProfileName name = ProfileName.of("[USER]");
   *   Profile response = healthProfileServiceClient.getProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Profile. Format: `users/me/profile`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Profile getProfile(@Nullable ProfileName name) {
    GetProfileRequest request =
        GetProfileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user Profile details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   String name = ProfileName.of("[USER]").toString();
   *   Profile response = healthProfileServiceClient.getProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Profile. Format: `users/me/profile`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Profile getProfile(String name) {
    GetProfileRequest request = GetProfileRequest.newBuilder().setName(name).build();
    return getProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user Profile details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   GetProfileRequest request =
   *       GetProfileRequest.newBuilder().setName(ProfileName.of("[USER]").toString()).build();
   *   Profile response = healthProfileServiceClient.getProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Profile getProfile(GetProfileRequest request) {
    return getProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user Profile details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   GetProfileRequest request =
   *       GetProfileRequest.newBuilder().setName(ProfileName.of("[USER]").toString()).build();
   *   ApiFuture<Profile> future =
   *       healthProfileServiceClient.getProfileCallable().futureCall(request);
   *   // Do something.
   *   Profile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProfileRequest, Profile> getProfileCallable() {
    return stub.getProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the user's profile details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   Profile profile = Profile.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Profile response = healthProfileServiceClient.updateProfile(profile, updateMask);
   * }
   * }</pre>
   *
   * @param profile Required. Profile details.
   * @param updateMask Optional. The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Profile updateProfile(Profile profile, FieldMask updateMask) {
    UpdateProfileRequest request =
        UpdateProfileRequest.newBuilder().setProfile(profile).setUpdateMask(updateMask).build();
    return updateProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the user's profile details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   UpdateProfileRequest request =
   *       UpdateProfileRequest.newBuilder()
   *           .setProfile(Profile.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Profile response = healthProfileServiceClient.updateProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Profile updateProfile(UpdateProfileRequest request) {
    return updateProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the user's profile details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   UpdateProfileRequest request =
   *       UpdateProfileRequest.newBuilder()
   *           .setProfile(Profile.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Profile> future =
   *       healthProfileServiceClient.updateProfileCallable().futureCall(request);
   *   // Do something.
   *   Profile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateProfileRequest, Profile> updateProfileCallable() {
    return stub.updateProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user settings details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   SettingsName name = SettingsName.of("[USER]");
   *   Settings response = healthProfileServiceClient.getSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Settings. Format: `users/me/settings`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(@Nullable SettingsName name) {
    GetSettingsRequest request =
        GetSettingsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user settings details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   String name = SettingsName.of("[USER]").toString();
   *   Settings response = healthProfileServiceClient.getSettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Settings. Format: `users/me/settings`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(String name) {
    GetSettingsRequest request = GetSettingsRequest.newBuilder().setName(name).build();
    return getSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user settings details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   GetSettingsRequest request =
   *       GetSettingsRequest.newBuilder().setName(SettingsName.of("[USER]").toString()).build();
   *   Settings response = healthProfileServiceClient.getSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(GetSettingsRequest request) {
    return getSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user settings details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   GetSettingsRequest request =
   *       GetSettingsRequest.newBuilder().setName(SettingsName.of("[USER]").toString()).build();
   *   ApiFuture<Settings> future =
   *       healthProfileServiceClient.getSettingsCallable().futureCall(request);
   *   // Do something.
   *   Settings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    return stub.getSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the user's settings details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   Settings settings = Settings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Settings response = healthProfileServiceClient.updateSettings(settings, updateMask);
   * }
   * }</pre>
   *
   * @param settings Required. Settings details
   * @param updateMask Optional. The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings updateSettings(Settings settings, FieldMask updateMask) {
    UpdateSettingsRequest request =
        UpdateSettingsRequest.newBuilder().setSettings(settings).setUpdateMask(updateMask).build();
    return updateSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the user's settings details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   UpdateSettingsRequest request =
   *       UpdateSettingsRequest.newBuilder()
   *           .setSettings(Settings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Settings response = healthProfileServiceClient.updateSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings updateSettings(UpdateSettingsRequest request) {
    return updateSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the user's settings details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   UpdateSettingsRequest request =
   *       UpdateSettingsRequest.newBuilder()
   *           .setSettings(Settings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Settings> future =
   *       healthProfileServiceClient.updateSettingsCallable().futureCall(request);
   *   // Do something.
   *   Settings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    return stub.updateSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the user's identity.
   *
   * <p>It includes the legacy Fitbit user ID and the Google user ID and it can be used by migrating
   * clients to map identifiers between the two systems.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   IdentityName name = IdentityName.of("[USER]");
   *   Identity response = healthProfileServiceClient.getIdentity(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Identity. Format: `users/me/identity`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Identity getIdentity(@Nullable IdentityName name) {
    GetIdentityRequest request =
        GetIdentityRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIdentity(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the user's identity.
   *
   * <p>It includes the legacy Fitbit user ID and the Google user ID and it can be used by migrating
   * clients to map identifiers between the two systems.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   String name = IdentityName.of("[USER]").toString();
   *   Identity response = healthProfileServiceClient.getIdentity(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Identity. Format: `users/me/identity`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Identity getIdentity(String name) {
    GetIdentityRequest request = GetIdentityRequest.newBuilder().setName(name).build();
    return getIdentity(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the user's identity.
   *
   * <p>It includes the legacy Fitbit user ID and the Google user ID and it can be used by migrating
   * clients to map identifiers between the two systems.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   GetIdentityRequest request =
   *       GetIdentityRequest.newBuilder().setName(IdentityName.of("[USER]").toString()).build();
   *   Identity response = healthProfileServiceClient.getIdentity(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Identity getIdentity(GetIdentityRequest request) {
    return getIdentityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the user's identity.
   *
   * <p>It includes the legacy Fitbit user ID and the Google user ID and it can be used by migrating
   * clients to map identifiers between the two systems.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   GetIdentityRequest request =
   *       GetIdentityRequest.newBuilder().setName(IdentityName.of("[USER]").toString()).build();
   *   ApiFuture<Identity> future =
   *       healthProfileServiceClient.getIdentityCallable().futureCall(request);
   *   // Do something.
   *   Identity response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIdentityRequest, Identity> getIdentityCallable() {
    return stub.getIdentityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user's IRN Profile details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   IrnProfileName name = IrnProfileName.of("[USER]");
   *   IrnProfile response = healthProfileServiceClient.getIrnProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the IRN Profile. Format: `users/{user}/irnProfile`
   *     Example: `users/1234567890/irnProfile` or `users/me/irnProfile` The {user} ID is a
   *     system-generated Google Health API user ID, a string of 1-63 characters consisting of
   *     lowercase and uppercase letters, numbers, and hyphens. The literal `me` can also be used to
   *     refer to the authenticated user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IrnProfile getIrnProfile(@Nullable IrnProfileName name) {
    GetIrnProfileRequest request =
        GetIrnProfileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIrnProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user's IRN Profile details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   String name = IrnProfileName.of("[USER]").toString();
   *   IrnProfile response = healthProfileServiceClient.getIrnProfile(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the IRN Profile. Format: `users/{user}/irnProfile`
   *     Example: `users/1234567890/irnProfile` or `users/me/irnProfile` The {user} ID is a
   *     system-generated Google Health API user ID, a string of 1-63 characters consisting of
   *     lowercase and uppercase letters, numbers, and hyphens. The literal `me` can also be used to
   *     refer to the authenticated user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IrnProfile getIrnProfile(String name) {
    GetIrnProfileRequest request = GetIrnProfileRequest.newBuilder().setName(name).build();
    return getIrnProfile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user's IRN Profile details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   GetIrnProfileRequest request =
   *       GetIrnProfileRequest.newBuilder().setName(IrnProfileName.of("[USER]").toString()).build();
   *   IrnProfile response = healthProfileServiceClient.getIrnProfile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IrnProfile getIrnProfile(GetIrnProfileRequest request) {
    return getIrnProfileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user's IRN Profile details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   GetIrnProfileRequest request =
   *       GetIrnProfileRequest.newBuilder().setName(IrnProfileName.of("[USER]").toString()).build();
   *   ApiFuture<IrnProfile> future =
   *       healthProfileServiceClient.getIrnProfileCallable().futureCall(request);
   *   // Do something.
   *   IrnProfile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIrnProfileRequest, IrnProfile> getIrnProfileCallable() {
    return stub.getIrnProfileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user's Device.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   PairedDeviceName name = PairedDeviceName.of("[USER]", "[PAIRED_DEVICE]");
   *   PairedDevice response = healthProfileServiceClient.getPairedDevice(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the device to retrieve. Format: users/{user}/devices/{device}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PairedDevice getPairedDevice(@Nullable PairedDeviceName name) {
    GetPairedDeviceRequest request =
        GetPairedDeviceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPairedDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user's Device.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   String name = PairedDeviceName.of("[USER]", "[PAIRED_DEVICE]").toString();
   *   PairedDevice response = healthProfileServiceClient.getPairedDevice(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the device to retrieve. Format: users/{user}/devices/{device}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PairedDevice getPairedDevice(String name) {
    GetPairedDeviceRequest request = GetPairedDeviceRequest.newBuilder().setName(name).build();
    return getPairedDevice(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user's Device.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   GetPairedDeviceRequest request =
   *       GetPairedDeviceRequest.newBuilder()
   *           .setName(PairedDeviceName.of("[USER]", "[PAIRED_DEVICE]").toString())
   *           .build();
   *   PairedDevice response = healthProfileServiceClient.getPairedDevice(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PairedDevice getPairedDevice(GetPairedDeviceRequest request) {
    return getPairedDeviceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns user's Device.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   GetPairedDeviceRequest request =
   *       GetPairedDeviceRequest.newBuilder()
   *           .setName(PairedDeviceName.of("[USER]", "[PAIRED_DEVICE]").toString())
   *           .build();
   *   ApiFuture<PairedDevice> future =
   *       healthProfileServiceClient.getPairedDeviceCallable().futureCall(request);
   *   // Do something.
   *   PairedDevice response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPairedDeviceRequest, PairedDevice> getPairedDeviceCallable() {
    return stub.getPairedDeviceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the user's list of paired 1P trackers and smartwatches.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   UserName parent = UserName.of("[USER]");
   *   for (PairedDevice element :
   *       healthProfileServiceClient.listPairedDevices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of devices. Format: users/{user}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPairedDevicesPagedResponse listPairedDevices(@Nullable UserName parent) {
    ListPairedDevicesRequest request =
        ListPairedDevicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPairedDevices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the user's list of paired 1P trackers and smartwatches.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   String parent = UserName.of("[USER]").toString();
   *   for (PairedDevice element :
   *       healthProfileServiceClient.listPairedDevices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of devices. Format: users/{user}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPairedDevicesPagedResponse listPairedDevices(String parent) {
    ListPairedDevicesRequest request =
        ListPairedDevicesRequest.newBuilder().setParent(parent).build();
    return listPairedDevices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the user's list of paired 1P trackers and smartwatches.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   ListPairedDevicesRequest request =
   *       ListPairedDevicesRequest.newBuilder()
   *           .setParent(UserName.of("[USER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (PairedDevice element :
   *       healthProfileServiceClient.listPairedDevices(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPairedDevicesPagedResponse listPairedDevices(ListPairedDevicesRequest request) {
    return listPairedDevicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the user's list of paired 1P trackers and smartwatches.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   ListPairedDevicesRequest request =
   *       ListPairedDevicesRequest.newBuilder()
   *           .setParent(UserName.of("[USER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<PairedDevice> future =
   *       healthProfileServiceClient.listPairedDevicesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PairedDevice element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPairedDevicesRequest, ListPairedDevicesPagedResponse>
      listPairedDevicesPagedCallable() {
    return stub.listPairedDevicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the user's list of paired 1P trackers and smartwatches.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HealthProfileServiceClient healthProfileServiceClient =
   *     HealthProfileServiceClient.create()) {
   *   ListPairedDevicesRequest request =
   *       ListPairedDevicesRequest.newBuilder()
   *           .setParent(UserName.of("[USER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPairedDevicesResponse response =
   *         healthProfileServiceClient.listPairedDevicesCallable().call(request);
   *     for (PairedDevice element : response.getPairedDevicesList()) {
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
   * }</pre>
   */
  public final UnaryCallable<ListPairedDevicesRequest, ListPairedDevicesResponse>
      listPairedDevicesCallable() {
    return stub.listPairedDevicesCallable();
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

  public static class ListPairedDevicesPagedResponse
      extends AbstractPagedListResponse<
          ListPairedDevicesRequest,
          ListPairedDevicesResponse,
          PairedDevice,
          ListPairedDevicesPage,
          ListPairedDevicesFixedSizeCollection> {

    public static ApiFuture<ListPairedDevicesPagedResponse> createAsync(
        PageContext<ListPairedDevicesRequest, ListPairedDevicesResponse, PairedDevice> context,
        ApiFuture<ListPairedDevicesResponse> futureResponse) {
      ApiFuture<ListPairedDevicesPage> futurePage =
          ListPairedDevicesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPairedDevicesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPairedDevicesPagedResponse(ListPairedDevicesPage page) {
      super(page, ListPairedDevicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPairedDevicesPage
      extends AbstractPage<
          ListPairedDevicesRequest,
          ListPairedDevicesResponse,
          PairedDevice,
          ListPairedDevicesPage> {

    private ListPairedDevicesPage(
        @Nullable PageContext<ListPairedDevicesRequest, ListPairedDevicesResponse, PairedDevice>
            context,
        @Nullable ListPairedDevicesResponse response) {
      super(context, response);
    }

    private static ListPairedDevicesPage createEmptyPage() {
      return new ListPairedDevicesPage(null, null);
    }

    @Override
    protected ListPairedDevicesPage createPage(
        @Nullable PageContext<ListPairedDevicesRequest, ListPairedDevicesResponse, PairedDevice>
            context,
        @Nullable ListPairedDevicesResponse response) {
      return new ListPairedDevicesPage(context, response);
    }

    @Override
    public ApiFuture<ListPairedDevicesPage> createPageAsync(
        @Nullable PageContext<ListPairedDevicesRequest, ListPairedDevicesResponse, PairedDevice>
            context,
        ApiFuture<ListPairedDevicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPairedDevicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPairedDevicesRequest,
          ListPairedDevicesResponse,
          PairedDevice,
          ListPairedDevicesPage,
          ListPairedDevicesFixedSizeCollection> {

    private ListPairedDevicesFixedSizeCollection(
        @Nullable List<ListPairedDevicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPairedDevicesFixedSizeCollection createEmptyCollection() {
      return new ListPairedDevicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPairedDevicesFixedSizeCollection createCollection(
        @Nullable List<ListPairedDevicesPage> pages, int collectionSize) {
      return new ListPairedDevicesFixedSizeCollection(pages, collectionSize);
    }
  }
}
