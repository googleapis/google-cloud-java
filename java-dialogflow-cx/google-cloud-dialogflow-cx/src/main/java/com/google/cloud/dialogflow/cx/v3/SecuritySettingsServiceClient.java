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

package com.google.cloud.dialogflow.cx.v3;

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
import com.google.cloud.dialogflow.cx.v3.stub.SecuritySettingsServiceStub;
import com.google.cloud.dialogflow.cx.v3.stub.SecuritySettingsServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing security settings for Dialogflow.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (SecuritySettingsServiceClient securitySettingsServiceClient =
 *     SecuritySettingsServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   SecuritySettings securitySettings = SecuritySettings.newBuilder().build();
 *   SecuritySettings response =
 *       securitySettingsServiceClient.createSecuritySettings(parent, securitySettings);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SecuritySettingsServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of
 * SecuritySettingsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * SecuritySettingsServiceSettings securitySettingsServiceSettings =
 *     SecuritySettingsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SecuritySettingsServiceClient securitySettingsServiceClient =
 *     SecuritySettingsServiceClient.create(securitySettingsServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * SecuritySettingsServiceSettings securitySettingsServiceSettings =
 *     SecuritySettingsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SecuritySettingsServiceClient securitySettingsServiceClient =
 *     SecuritySettingsServiceClient.create(securitySettingsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SecuritySettingsServiceClient implements BackgroundResource {
  private final SecuritySettingsServiceSettings settings;
  private final SecuritySettingsServiceStub stub;

  /** Constructs an instance of SecuritySettingsServiceClient with default settings. */
  public static final SecuritySettingsServiceClient create() throws IOException {
    return create(SecuritySettingsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SecuritySettingsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SecuritySettingsServiceClient create(SecuritySettingsServiceSettings settings)
      throws IOException {
    return new SecuritySettingsServiceClient(settings);
  }

  /**
   * Constructs an instance of SecuritySettingsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(SecuritySettingsServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final SecuritySettingsServiceClient create(SecuritySettingsServiceStub stub) {
    return new SecuritySettingsServiceClient(stub);
  }

  /**
   * Constructs an instance of SecuritySettingsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SecuritySettingsServiceClient(SecuritySettingsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((SecuritySettingsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected SecuritySettingsServiceClient(SecuritySettingsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SecuritySettingsServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SecuritySettingsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create security settings in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   SecuritySettings securitySettings = SecuritySettings.newBuilder().build();
   *   SecuritySettings response =
   *       securitySettingsServiceClient.createSecuritySettings(parent, securitySettings);
   * }
   * }</pre>
   *
   * @param parent Required. The location to create an
   *     [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings] for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @param securitySettings Required. The security settings to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecuritySettings createSecuritySettings(
      LocationName parent, SecuritySettings securitySettings) {
    CreateSecuritySettingsRequest request =
        CreateSecuritySettingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSecuritySettings(securitySettings)
            .build();
    return createSecuritySettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create security settings in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   String parent =
   *       SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]").toString();
   *   SecuritySettings securitySettings = SecuritySettings.newBuilder().build();
   *   SecuritySettings response =
   *       securitySettingsServiceClient.createSecuritySettings(parent, securitySettings);
   * }
   * }</pre>
   *
   * @param parent Required. The location to create an
   *     [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings] for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @param securitySettings Required. The security settings to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecuritySettings createSecuritySettings(
      String parent, SecuritySettings securitySettings) {
    CreateSecuritySettingsRequest request =
        CreateSecuritySettingsRequest.newBuilder()
            .setParent(parent)
            .setSecuritySettings(securitySettings)
            .build();
    return createSecuritySettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create security settings in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   CreateSecuritySettingsRequest request =
   *       CreateSecuritySettingsRequest.newBuilder()
   *           .setParent(
   *               SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
   *                   .toString())
   *           .setSecuritySettings(SecuritySettings.newBuilder().build())
   *           .build();
   *   SecuritySettings response = securitySettingsServiceClient.createSecuritySettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecuritySettings createSecuritySettings(CreateSecuritySettingsRequest request) {
    return createSecuritySettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create security settings in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   CreateSecuritySettingsRequest request =
   *       CreateSecuritySettingsRequest.newBuilder()
   *           .setParent(
   *               SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
   *                   .toString())
   *           .setSecuritySettings(SecuritySettings.newBuilder().build())
   *           .build();
   *   ApiFuture<SecuritySettings> future =
   *       securitySettingsServiceClient.createSecuritySettingsCallable().futureCall(request);
   *   // Do something.
   *   SecuritySettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSecuritySettingsRequest, SecuritySettings>
      createSecuritySettingsCallable() {
    return stub.createSecuritySettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings]. The
   * returned settings may be stale by up to 1 minute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   SecuritySettingsName name =
   *       SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]");
   *   SecuritySettings response = securitySettingsServiceClient.getSecuritySettings(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the settings. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/securitySettings/&lt;security settings ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecuritySettings getSecuritySettings(SecuritySettingsName name) {
    GetSecuritySettingsRequest request =
        GetSecuritySettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSecuritySettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings]. The
   * returned settings may be stale by up to 1 minute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   String name =
   *       SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]").toString();
   *   SecuritySettings response = securitySettingsServiceClient.getSecuritySettings(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the settings. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/securitySettings/&lt;security settings ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecuritySettings getSecuritySettings(String name) {
    GetSecuritySettingsRequest request =
        GetSecuritySettingsRequest.newBuilder().setName(name).build();
    return getSecuritySettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings]. The
   * returned settings may be stale by up to 1 minute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   GetSecuritySettingsRequest request =
   *       GetSecuritySettingsRequest.newBuilder()
   *           .setName(
   *               SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
   *                   .toString())
   *           .build();
   *   SecuritySettings response = securitySettingsServiceClient.getSecuritySettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecuritySettings getSecuritySettings(GetSecuritySettingsRequest request) {
    return getSecuritySettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings]. The
   * returned settings may be stale by up to 1 minute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   GetSecuritySettingsRequest request =
   *       GetSecuritySettingsRequest.newBuilder()
   *           .setName(
   *               SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SecuritySettings> future =
   *       securitySettingsServiceClient.getSecuritySettingsCallable().futureCall(request);
   *   // Do something.
   *   SecuritySettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSecuritySettingsRequest, SecuritySettings>
      getSecuritySettingsCallable() {
    return stub.getSecuritySettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   SecuritySettings securitySettings = SecuritySettings.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SecuritySettings response =
   *       securitySettingsServiceClient.updateSecuritySettings(securitySettings, updateMask);
   * }
   * }</pre>
   *
   * @param securitySettings Required. [SecuritySettings] object that contains values for each of
   *     the fields to update.
   * @param updateMask Required. The mask to control which fields get updated. If the mask is not
   *     present, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecuritySettings updateSecuritySettings(
      SecuritySettings securitySettings, FieldMask updateMask) {
    UpdateSecuritySettingsRequest request =
        UpdateSecuritySettingsRequest.newBuilder()
            .setSecuritySettings(securitySettings)
            .setUpdateMask(updateMask)
            .build();
    return updateSecuritySettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   UpdateSecuritySettingsRequest request =
   *       UpdateSecuritySettingsRequest.newBuilder()
   *           .setSecuritySettings(SecuritySettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SecuritySettings response = securitySettingsServiceClient.updateSecuritySettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecuritySettings updateSecuritySettings(UpdateSecuritySettingsRequest request) {
    return updateSecuritySettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   UpdateSecuritySettingsRequest request =
   *       UpdateSecuritySettingsRequest.newBuilder()
   *           .setSecuritySettings(SecuritySettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<SecuritySettings> future =
   *       securitySettingsServiceClient.updateSecuritySettingsCallable().futureCall(request);
   *   // Do something.
   *   SecuritySettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSecuritySettingsRequest, SecuritySettings>
      updateSecuritySettingsCallable() {
    return stub.updateSecuritySettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all security settings in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SecuritySettings element :
   *       securitySettingsServiceClient.listSecuritySettings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location to list all security settings for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecuritySettingsPagedResponse listSecuritySettings(LocationName parent) {
    ListSecuritySettingsRequest request =
        ListSecuritySettingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSecuritySettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all security settings in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   String parent =
   *       SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]").toString();
   *   for (SecuritySettings element :
   *       securitySettingsServiceClient.listSecuritySettings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location to list all security settings for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecuritySettingsPagedResponse listSecuritySettings(String parent) {
    ListSecuritySettingsRequest request =
        ListSecuritySettingsRequest.newBuilder().setParent(parent).build();
    return listSecuritySettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all security settings in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   ListSecuritySettingsRequest request =
   *       ListSecuritySettingsRequest.newBuilder()
   *           .setParent(
   *               SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SecuritySettings element :
   *       securitySettingsServiceClient.listSecuritySettings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecuritySettingsPagedResponse listSecuritySettings(
      ListSecuritySettingsRequest request) {
    return listSecuritySettingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all security settings in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   ListSecuritySettingsRequest request =
   *       ListSecuritySettingsRequest.newBuilder()
   *           .setParent(
   *               SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SecuritySettings> future =
   *       securitySettingsServiceClient.listSecuritySettingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SecuritySettings element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSecuritySettingsRequest, ListSecuritySettingsPagedResponse>
      listSecuritySettingsPagedCallable() {
    return stub.listSecuritySettingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all security settings in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   while (true) {
   *     ListSecuritySettingsResponse response =
   *         securitySettingsServiceClient.listSecuritySettingsCallable().call(request);
   *     for (SecuritySettings element : response.getResponsesList()) {
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
  public final UnaryCallable<ListSecuritySettingsRequest, ListSecuritySettingsResponse>
      listSecuritySettingsCallable() {
    return stub.listSecuritySettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   SecuritySettingsName name =
   *       SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]");
   *   securitySettingsServiceClient.deleteSecuritySettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings] to delete. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/securitySettings/&lt;Security
   *     Settings ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSecuritySettings(SecuritySettingsName name) {
    DeleteSecuritySettingsRequest request =
        DeleteSecuritySettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSecuritySettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   String name =
   *       SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]").toString();
   *   securitySettingsServiceClient.deleteSecuritySettings(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the
   *     [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings] to delete. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;/securitySettings/&lt;Security
   *     Settings ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSecuritySettings(String name) {
    DeleteSecuritySettingsRequest request =
        DeleteSecuritySettingsRequest.newBuilder().setName(name).build();
    deleteSecuritySettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   DeleteSecuritySettingsRequest request =
   *       DeleteSecuritySettingsRequest.newBuilder()
   *           .setName(
   *               SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
   *                   .toString())
   *           .build();
   *   securitySettingsServiceClient.deleteSecuritySettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSecuritySettings(DeleteSecuritySettingsRequest request) {
    deleteSecuritySettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified [SecuritySettings][google.cloud.dialogflow.cx.v3.SecuritySettings].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (SecuritySettingsServiceClient securitySettingsServiceClient =
   *     SecuritySettingsServiceClient.create()) {
   *   DeleteSecuritySettingsRequest request =
   *       DeleteSecuritySettingsRequest.newBuilder()
   *           .setName(
   *               SecuritySettingsName.of("[PROJECT]", "[LOCATION]", "[SECURITY_SETTINGS]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       securitySettingsServiceClient.deleteSecuritySettingsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSecuritySettingsRequest, Empty>
      deleteSecuritySettingsCallable() {
    return stub.deleteSecuritySettingsCallable();
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

  public static class ListSecuritySettingsPagedResponse
      extends AbstractPagedListResponse<
          ListSecuritySettingsRequest,
          ListSecuritySettingsResponse,
          SecuritySettings,
          ListSecuritySettingsPage,
          ListSecuritySettingsFixedSizeCollection> {

    public static ApiFuture<ListSecuritySettingsPagedResponse> createAsync(
        PageContext<ListSecuritySettingsRequest, ListSecuritySettingsResponse, SecuritySettings>
            context,
        ApiFuture<ListSecuritySettingsResponse> futureResponse) {
      ApiFuture<ListSecuritySettingsPage> futurePage =
          ListSecuritySettingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListSecuritySettingsPage, ListSecuritySettingsPagedResponse>() {
            @Override
            public ListSecuritySettingsPagedResponse apply(ListSecuritySettingsPage input) {
              return new ListSecuritySettingsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListSecuritySettingsPagedResponse(ListSecuritySettingsPage page) {
      super(page, ListSecuritySettingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSecuritySettingsPage
      extends AbstractPage<
          ListSecuritySettingsRequest,
          ListSecuritySettingsResponse,
          SecuritySettings,
          ListSecuritySettingsPage> {

    private ListSecuritySettingsPage(
        PageContext<ListSecuritySettingsRequest, ListSecuritySettingsResponse, SecuritySettings>
            context,
        ListSecuritySettingsResponse response) {
      super(context, response);
    }

    private static ListSecuritySettingsPage createEmptyPage() {
      return new ListSecuritySettingsPage(null, null);
    }

    @Override
    protected ListSecuritySettingsPage createPage(
        PageContext<ListSecuritySettingsRequest, ListSecuritySettingsResponse, SecuritySettings>
            context,
        ListSecuritySettingsResponse response) {
      return new ListSecuritySettingsPage(context, response);
    }

    @Override
    public ApiFuture<ListSecuritySettingsPage> createPageAsync(
        PageContext<ListSecuritySettingsRequest, ListSecuritySettingsResponse, SecuritySettings>
            context,
        ApiFuture<ListSecuritySettingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSecuritySettingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSecuritySettingsRequest,
          ListSecuritySettingsResponse,
          SecuritySettings,
          ListSecuritySettingsPage,
          ListSecuritySettingsFixedSizeCollection> {

    private ListSecuritySettingsFixedSizeCollection(
        List<ListSecuritySettingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSecuritySettingsFixedSizeCollection createEmptyCollection() {
      return new ListSecuritySettingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSecuritySettingsFixedSizeCollection createCollection(
        List<ListSecuritySettingsPage> pages, int collectionSize) {
      return new ListSecuritySettingsFixedSizeCollection(pages, collectionSize);
    }
  }
}
