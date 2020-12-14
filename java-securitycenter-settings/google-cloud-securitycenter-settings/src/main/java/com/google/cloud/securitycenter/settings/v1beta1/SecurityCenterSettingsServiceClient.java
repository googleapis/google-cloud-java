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

package com.google.cloud.securitycenter.settings.v1beta1;

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
import com.google.cloud.securitycenter.settings.v1beta1.stub.SecurityCenterSettingsServiceStub;
import com.google.cloud.securitycenter.settings.v1beta1.stub.SecurityCenterSettingsServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: ## API Overview
 *
 * <p>The SecurityCenterSettingsService is a sub-api of `securitycenter.googleapis.com`. The service
 * provides methods to manage Security Center Settings, and Component Settings for GCP
 * organizations, folders, projects, and clusters.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the SecurityCenterSettingsServiceClient object to clean up
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
 * SecurityCenterSettingsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * SecurityCenterSettingsServiceSettings securityCenterSettingsServiceSettings =
 *     SecurityCenterSettingsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SecurityCenterSettingsServiceClient securityCenterSettingsServiceClient =
 *     SecurityCenterSettingsServiceClient.create(securityCenterSettingsServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * SecurityCenterSettingsServiceSettings securityCenterSettingsServiceSettings =
 *     SecurityCenterSettingsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SecurityCenterSettingsServiceClient securityCenterSettingsServiceClient =
 *     SecurityCenterSettingsServiceClient.create(securityCenterSettingsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class SecurityCenterSettingsServiceClient implements BackgroundResource {
  private final SecurityCenterSettingsServiceSettings settings;
  private final SecurityCenterSettingsServiceStub stub;

  /** Constructs an instance of SecurityCenterSettingsServiceClient with default settings. */
  public static final SecurityCenterSettingsServiceClient create() throws IOException {
    return create(SecurityCenterSettingsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SecurityCenterSettingsServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final SecurityCenterSettingsServiceClient create(
      SecurityCenterSettingsServiceSettings settings) throws IOException {
    return new SecurityCenterSettingsServiceClient(settings);
  }

  /**
   * Constructs an instance of SecurityCenterSettingsServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(SecurityCenterSettingsServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final SecurityCenterSettingsServiceClient create(
      SecurityCenterSettingsServiceStub stub) {
    return new SecurityCenterSettingsServiceClient(stub);
  }

  /**
   * Constructs an instance of SecurityCenterSettingsServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SecurityCenterSettingsServiceClient(SecurityCenterSettingsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((SecurityCenterSettingsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected SecurityCenterSettingsServiceClient(SecurityCenterSettingsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SecurityCenterSettingsServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SecurityCenterSettingsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the organizations service account, if it exists, otherwise it creates the
   * organization service account. This API is idempotent and will only create a service account
   * once. On subsequent calls it will return the previously created service account. SHA, SCC and
   * CTD Infra Automation will use this SA. This SA will not have any permissions when created. The
   * UI will provision this via IAM or the user will using their own internal process. This API only
   * creates SAs on the organization. Folders are not supported and projects will use per-project
   * SAs associated with APIs enabled on a project. This API will be called by the UX onboarding
   * workflow.
   *
   * @param name Required. The relative resource name of the service account resource. Format: &#42;
   *     `organizations/{organization}/serviceAccount`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccount getServiceAccount(ServiceAccountName name) {
    GetServiceAccountRequest request =
        GetServiceAccountRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getServiceAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the organizations service account, if it exists, otherwise it creates the
   * organization service account. This API is idempotent and will only create a service account
   * once. On subsequent calls it will return the previously created service account. SHA, SCC and
   * CTD Infra Automation will use this SA. This SA will not have any permissions when created. The
   * UI will provision this via IAM or the user will using their own internal process. This API only
   * creates SAs on the organization. Folders are not supported and projects will use per-project
   * SAs associated with APIs enabled on a project. This API will be called by the UX onboarding
   * workflow.
   *
   * @param name Required. The relative resource name of the service account resource. Format: &#42;
   *     `organizations/{organization}/serviceAccount`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccount getServiceAccount(String name) {
    GetServiceAccountRequest request = GetServiceAccountRequest.newBuilder().setName(name).build();
    return getServiceAccount(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the organizations service account, if it exists, otherwise it creates the
   * organization service account. This API is idempotent and will only create a service account
   * once. On subsequent calls it will return the previously created service account. SHA, SCC and
   * CTD Infra Automation will use this SA. This SA will not have any permissions when created. The
   * UI will provision this via IAM or the user will using their own internal process. This API only
   * creates SAs on the organization. Folders are not supported and projects will use per-project
   * SAs associated with APIs enabled on a project. This API will be called by the UX onboarding
   * workflow.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceAccount getServiceAccount(GetServiceAccountRequest request) {
    return getServiceAccountCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the organizations service account, if it exists, otherwise it creates the
   * organization service account. This API is idempotent and will only create a service account
   * once. On subsequent calls it will return the previously created service account. SHA, SCC and
   * CTD Infra Automation will use this SA. This SA will not have any permissions when created. The
   * UI will provision this via IAM or the user will using their own internal process. This API only
   * creates SAs on the organization. Folders are not supported and projects will use per-project
   * SAs associated with APIs enabled on a project. This API will be called by the UX onboarding
   * workflow.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetServiceAccountRequest, ServiceAccount> getServiceAccountCallable() {
    return stub.getServiceAccountCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Settings.
   *
   * @param name Required. The name of the settings to retrieve. Formats: &#42;
   *     `organizations/{organization}/settings` &#42; `folders/{folder}/settings` &#42;
   *     `projects/{project}/settings` &#42;
   *     `projects/{project}/locations/{location}/clusters/{cluster}/settings` &#42;
   *     `projects/{project}/regions/{region}/clusters/{cluster}/settings` &#42;
   *     `projects/{project}/zones/{zone}/clusters/{cluster}/settings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(SettingsName name) {
    GetSettingsRequest request =
        GetSettingsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Settings.
   *
   * @param name Required. The name of the settings to retrieve. Formats: &#42;
   *     `organizations/{organization}/settings` &#42; `folders/{folder}/settings` &#42;
   *     `projects/{project}/settings` &#42;
   *     `projects/{project}/locations/{location}/clusters/{cluster}/settings` &#42;
   *     `projects/{project}/regions/{region}/clusters/{cluster}/settings` &#42;
   *     `projects/{project}/zones/{zone}/clusters/{cluster}/settings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(String name) {
    GetSettingsRequest request = GetSettingsRequest.newBuilder().setName(name).build();
    return getSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Settings.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings getSettings(GetSettingsRequest request) {
    return getSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Settings.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    return stub.getSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Settings.
   *
   * @param settings Required. The settings to update.
   *     <p>The settings' `name` field is used to identify the settings to be updated. Formats:
   *     &#42; `organizations/{organization}/settings` &#42; `folders/{folder}/settings` &#42;
   *     `projects/{project}/settings` &#42;
   *     `projects/{project}/locations/{location}/clusters/{cluster}/settings` &#42;
   *     `projects/{project}/regions/{region}/clusters/{cluster}/settings` &#42;
   *     `projects/{project}/zones/{zone}/clusters/{cluster}/settings`
   * @param updateMask The list of fields to be updated on the settings.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings updateSettings(Settings settings, FieldMask updateMask) {
    UpdateSettingsRequest request =
        UpdateSettingsRequest.newBuilder().setSettings(settings).setUpdateMask(updateMask).build();
    return updateSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Settings.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings updateSettings(UpdateSettingsRequest request) {
    return updateSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Settings.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    return stub.updateSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reset the organization, folder or project's settings and return the settings of just that
   * resource to the default.
   *
   * <p>Settings are present at the organization, folder, project, and cluster levels. Using Reset
   * on a sub-organization level will remove that resource's override and result in the parent's
   * settings being used (eg: if Reset on a cluster, project settings will be used).
   *
   * <p>Using Reset on organization will remove the override that was set and result in default
   * settings being used.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void resetSettings(ResetSettingsRequest request) {
    resetSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reset the organization, folder or project's settings and return the settings of just that
   * resource to the default.
   *
   * <p>Settings are present at the organization, folder, project, and cluster levels. Using Reset
   * on a sub-organization level will remove that resource's override and result in the parent's
   * settings being used (eg: if Reset on a cluster, project settings will be used).
   *
   * <p>Using Reset on organization will remove the override that was set and result in default
   * settings being used.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ResetSettingsRequest, Empty> resetSettingsCallable() {
    return stub.resetSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of settings.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetSettingsResponse batchGetSettings(BatchGetSettingsRequest request) {
    return batchGetSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of settings.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<BatchGetSettingsRequest, BatchGetSettingsResponse>
      batchGetSettingsCallable() {
    return stub.batchGetSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CalculateEffectiveSettings looks up all of the Security Center Settings resources in the GCP
   * resource hierarchy, and calculates the effective settings on that resource by applying the
   * following rules: &#42; Settings provided closer to the target resource take precedence over
   * those further away (e.g. folder will override organization level settings). &#42; Product
   * defaults can be overridden at org, folder, project, and cluster levels. &#42; Detectors will be
   * filtered out if they belong to a billing tier the customer has not configured.
   *
   * @param name Required. The name of the effective settings to retrieve. Formats: &#42;
   *     `organizations/{organization}/effectiveSettings` &#42; `folders/{folder}/effectiveSettings`
   *     &#42; `projects/{project}/effectiveSettings` &#42;
   *     `projects/{project}/locations/{location}/clusters/{cluster}/effectiveSettings` &#42;
   *     `projects/{project}/regions/{region}/clusters/{cluster}/effectiveSettings` &#42;
   *     `projects/{project}/zones/{zone}/clusters/{cluster}/effectiveSettings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings calculateEffectiveSettings(SettingsName name) {
    CalculateEffectiveSettingsRequest request =
        CalculateEffectiveSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return calculateEffectiveSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CalculateEffectiveSettings looks up all of the Security Center Settings resources in the GCP
   * resource hierarchy, and calculates the effective settings on that resource by applying the
   * following rules: &#42; Settings provided closer to the target resource take precedence over
   * those further away (e.g. folder will override organization level settings). &#42; Product
   * defaults can be overridden at org, folder, project, and cluster levels. &#42; Detectors will be
   * filtered out if they belong to a billing tier the customer has not configured.
   *
   * @param name Required. The name of the effective settings to retrieve. Formats: &#42;
   *     `organizations/{organization}/effectiveSettings` &#42; `folders/{folder}/effectiveSettings`
   *     &#42; `projects/{project}/effectiveSettings` &#42;
   *     `projects/{project}/locations/{location}/clusters/{cluster}/effectiveSettings` &#42;
   *     `projects/{project}/regions/{region}/clusters/{cluster}/effectiveSettings` &#42;
   *     `projects/{project}/zones/{zone}/clusters/{cluster}/effectiveSettings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings calculateEffectiveSettings(String name) {
    CalculateEffectiveSettingsRequest request =
        CalculateEffectiveSettingsRequest.newBuilder().setName(name).build();
    return calculateEffectiveSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CalculateEffectiveSettings looks up all of the Security Center Settings resources in the GCP
   * resource hierarchy, and calculates the effective settings on that resource by applying the
   * following rules: &#42; Settings provided closer to the target resource take precedence over
   * those further away (e.g. folder will override organization level settings). &#42; Product
   * defaults can be overridden at org, folder, project, and cluster levels. &#42; Detectors will be
   * filtered out if they belong to a billing tier the customer has not configured.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Settings calculateEffectiveSettings(CalculateEffectiveSettingsRequest request) {
    return calculateEffectiveSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CalculateEffectiveSettings looks up all of the Security Center Settings resources in the GCP
   * resource hierarchy, and calculates the effective settings on that resource by applying the
   * following rules: &#42; Settings provided closer to the target resource take precedence over
   * those further away (e.g. folder will override organization level settings). &#42; Product
   * defaults can be overridden at org, folder, project, and cluster levels. &#42; Detectors will be
   * filtered out if they belong to a billing tier the customer has not configured.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CalculateEffectiveSettingsRequest, Settings>
      calculateEffectiveSettingsCallable() {
    return stub.calculateEffectiveSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of effective settings.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCalculateEffectiveSettingsResponse batchCalculateEffectiveSettings(
      BatchCalculateEffectiveSettingsRequest request) {
    return batchCalculateEffectiveSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of effective settings.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<
          BatchCalculateEffectiveSettingsRequest, BatchCalculateEffectiveSettingsResponse>
      batchCalculateEffectiveSettingsCallable() {
    return stub.batchCalculateEffectiveSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Component Settings.
   *
   * @param name Required. The component settings to retrieve.
   *     <p>Formats: &#42; `organizations/{organization}/components/{component}/settings` &#42;
   *     `folders/{folder}/components/{component}/settings` &#42;
   *     `projects/{project}/components/{component}/settings` &#42;
   *     `projects/{project}/locations/{location}/clusters/{cluster}/components/{component}/settings`
   *     &#42;
   *     `projects/{project}/regions/{region}/clusters/{cluster}/components/{component}/settings`
   *     &#42; `projects/{project}/zones/{zone}/clusters/{cluster}/components/{component}/settings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComponentSettings getComponentSettings(ComponentSettingsName name) {
    GetComponentSettingsRequest request =
        GetComponentSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getComponentSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Component Settings.
   *
   * @param name Required. The component settings to retrieve.
   *     <p>Formats: &#42; `organizations/{organization}/components/{component}/settings` &#42;
   *     `folders/{folder}/components/{component}/settings` &#42;
   *     `projects/{project}/components/{component}/settings` &#42;
   *     `projects/{project}/locations/{location}/clusters/{cluster}/components/{component}/settings`
   *     &#42;
   *     `projects/{project}/regions/{region}/clusters/{cluster}/components/{component}/settings`
   *     &#42; `projects/{project}/zones/{zone}/clusters/{cluster}/components/{component}/settings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComponentSettings getComponentSettings(String name) {
    GetComponentSettingsRequest request =
        GetComponentSettingsRequest.newBuilder().setName(name).build();
    return getComponentSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Component Settings.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComponentSettings getComponentSettings(GetComponentSettingsRequest request) {
    return getComponentSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Component Settings.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetComponentSettingsRequest, ComponentSettings>
      getComponentSettingsCallable() {
    return stub.getComponentSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Component Settings.
   *
   * @param componentSettings Required. The component settings to update.
   *     <p>The component settings' `name` field is used to identify the component settings to be
   *     updated. Formats: &#42; `organizations/{organization}/components/{component}/settings`
   *     &#42; `folders/{folder}/components/{component}/settings` &#42;
   *     `projects/{project}/components/{component}/settings` &#42;
   *     `projects/{project}/locations/{location}/clusters/{cluster}/components/{component}/settings`
   *     &#42;
   *     `projects/{project}/regions/{region}/clusters/{cluster}/components/{component}/settings`
   *     &#42; `projects/{project}/zones/{zone}/clusters/{cluster}/components/{component}/settings`
   * @param updateMask The list of fields to be updated on the component settings resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComponentSettings updateComponentSettings(
      ComponentSettings componentSettings, FieldMask updateMask) {
    UpdateComponentSettingsRequest request =
        UpdateComponentSettingsRequest.newBuilder()
            .setComponentSettings(componentSettings)
            .setUpdateMask(updateMask)
            .build();
    return updateComponentSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Component Settings.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComponentSettings updateComponentSettings(UpdateComponentSettingsRequest request) {
    return updateComponentSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Component Settings.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateComponentSettingsRequest, ComponentSettings>
      updateComponentSettingsCallable() {
    return stub.updateComponentSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reset the organization, folder or project's component settings and return the settings to the
   * default. Settings are present at the organization, folder and project levels. Using Reset for a
   * folder or project will remove the override that was set and result in the organization-level
   * settings being used.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void resetComponentSettings(ResetComponentSettingsRequest request) {
    resetComponentSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reset the organization, folder or project's component settings and return the settings to the
   * default. Settings are present at the organization, folder and project levels. Using Reset for a
   * folder or project will remove the override that was set and result in the organization-level
   * settings being used.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ResetComponentSettingsRequest, Empty>
      resetComponentSettingsCallable() {
    return stub.resetComponentSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Effective Component Settings.
   *
   * @param name Required. The effective component settings to retrieve.
   *     <p>Formats: &#42; `organizations/{organization}/components/{component}/settings` &#42;
   *     `folders/{folder}/components/{component}/settings` &#42;
   *     `projects/{project}/components/{component}/settings` &#42;
   *     `projects/{project}/locations/{location}/clusters/{cluster}/components/{component}/settings`
   *     &#42;
   *     `projects/{project}/regions/{region}/clusters/{cluster}/components/{component}/settings`
   *     &#42; `projects/{project}/zones/{zone}/clusters/{cluster}/components/{component}/settings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComponentSettings calculateEffectiveComponentSettings(ComponentSettingsName name) {
    CalculateEffectiveComponentSettingsRequest request =
        CalculateEffectiveComponentSettingsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return calculateEffectiveComponentSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Effective Component Settings.
   *
   * @param name Required. The effective component settings to retrieve.
   *     <p>Formats: &#42; `organizations/{organization}/components/{component}/settings` &#42;
   *     `folders/{folder}/components/{component}/settings` &#42;
   *     `projects/{project}/components/{component}/settings` &#42;
   *     `projects/{project}/locations/{location}/clusters/{cluster}/components/{component}/settings`
   *     &#42;
   *     `projects/{project}/regions/{region}/clusters/{cluster}/components/{component}/settings`
   *     &#42; `projects/{project}/zones/{zone}/clusters/{cluster}/components/{component}/settings`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComponentSettings calculateEffectiveComponentSettings(String name) {
    CalculateEffectiveComponentSettingsRequest request =
        CalculateEffectiveComponentSettingsRequest.newBuilder().setName(name).build();
    return calculateEffectiveComponentSettings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Effective Component Settings.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ComponentSettings calculateEffectiveComponentSettings(
      CalculateEffectiveComponentSettingsRequest request) {
    return calculateEffectiveComponentSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the Effective Component Settings.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CalculateEffectiveComponentSettingsRequest, ComponentSettings>
      calculateEffectiveComponentSettingsCallable() {
    return stub.calculateEffectiveComponentSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an unordered list of available detectors.
   *
   * @param parent Required. The parent, which owns this collection of detectors. Format: &#42;
   *     `organizations/{organization}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDetectorsPagedResponse listDetectors(OrganizationName parent) {
    ListDetectorsRequest request =
        ListDetectorsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDetectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an unordered list of available detectors.
   *
   * @param parent Required. The parent, which owns this collection of detectors. Format: &#42;
   *     `organizations/{organization}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDetectorsPagedResponse listDetectors(String parent) {
    ListDetectorsRequest request = ListDetectorsRequest.newBuilder().setParent(parent).build();
    return listDetectors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an unordered list of available detectors.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDetectorsPagedResponse listDetectors(ListDetectorsRequest request) {
    return listDetectorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an unordered list of available detectors.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDetectorsRequest, ListDetectorsPagedResponse>
      listDetectorsPagedCallable() {
    return stub.listDetectorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an unordered list of available detectors.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListDetectorsRequest, ListDetectorsResponse> listDetectorsCallable() {
    return stub.listDetectorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an unordered list of available SCC components.
   *
   * @param parent Required. The parent, which owns this collection of components. Format: &#42;
   *     `organizations/{organization}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListComponentsPagedResponse listComponents(OrganizationName parent) {
    ListComponentsRequest request =
        ListComponentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listComponents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an unordered list of available SCC components.
   *
   * @param parent Required. The parent, which owns this collection of components. Format: &#42;
   *     `organizations/{organization}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListComponentsPagedResponse listComponents(String parent) {
    ListComponentsRequest request = ListComponentsRequest.newBuilder().setParent(parent).build();
    return listComponents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an unordered list of available SCC components.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListComponentsPagedResponse listComponents(ListComponentsRequest request) {
    return listComponentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an unordered list of available SCC components.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListComponentsRequest, ListComponentsPagedResponse>
      listComponentsPagedCallable() {
    return stub.listComponentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an unordered list of available SCC components.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListComponentsRequest, ListComponentsResponse>
      listComponentsCallable() {
    return stub.listComponentsCallable();
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

  public static class ListDetectorsPagedResponse
      extends AbstractPagedListResponse<
          ListDetectorsRequest,
          ListDetectorsResponse,
          Detector,
          ListDetectorsPage,
          ListDetectorsFixedSizeCollection> {

    public static ApiFuture<ListDetectorsPagedResponse> createAsync(
        PageContext<ListDetectorsRequest, ListDetectorsResponse, Detector> context,
        ApiFuture<ListDetectorsResponse> futureResponse) {
      ApiFuture<ListDetectorsPage> futurePage =
          ListDetectorsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListDetectorsPage, ListDetectorsPagedResponse>() {
            @Override
            public ListDetectorsPagedResponse apply(ListDetectorsPage input) {
              return new ListDetectorsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListDetectorsPagedResponse(ListDetectorsPage page) {
      super(page, ListDetectorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDetectorsPage
      extends AbstractPage<
          ListDetectorsRequest, ListDetectorsResponse, Detector, ListDetectorsPage> {

    private ListDetectorsPage(
        PageContext<ListDetectorsRequest, ListDetectorsResponse, Detector> context,
        ListDetectorsResponse response) {
      super(context, response);
    }

    private static ListDetectorsPage createEmptyPage() {
      return new ListDetectorsPage(null, null);
    }

    @Override
    protected ListDetectorsPage createPage(
        PageContext<ListDetectorsRequest, ListDetectorsResponse, Detector> context,
        ListDetectorsResponse response) {
      return new ListDetectorsPage(context, response);
    }

    @Override
    public ApiFuture<ListDetectorsPage> createPageAsync(
        PageContext<ListDetectorsRequest, ListDetectorsResponse, Detector> context,
        ApiFuture<ListDetectorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDetectorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDetectorsRequest,
          ListDetectorsResponse,
          Detector,
          ListDetectorsPage,
          ListDetectorsFixedSizeCollection> {

    private ListDetectorsFixedSizeCollection(List<ListDetectorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDetectorsFixedSizeCollection createEmptyCollection() {
      return new ListDetectorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDetectorsFixedSizeCollection createCollection(
        List<ListDetectorsPage> pages, int collectionSize) {
      return new ListDetectorsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListComponentsPagedResponse
      extends AbstractPagedListResponse<
          ListComponentsRequest,
          ListComponentsResponse,
          String,
          ListComponentsPage,
          ListComponentsFixedSizeCollection> {

    public static ApiFuture<ListComponentsPagedResponse> createAsync(
        PageContext<ListComponentsRequest, ListComponentsResponse, String> context,
        ApiFuture<ListComponentsResponse> futureResponse) {
      ApiFuture<ListComponentsPage> futurePage =
          ListComponentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListComponentsPage, ListComponentsPagedResponse>() {
            @Override
            public ListComponentsPagedResponse apply(ListComponentsPage input) {
              return new ListComponentsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListComponentsPagedResponse(ListComponentsPage page) {
      super(page, ListComponentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListComponentsPage
      extends AbstractPage<
          ListComponentsRequest, ListComponentsResponse, String, ListComponentsPage> {

    private ListComponentsPage(
        PageContext<ListComponentsRequest, ListComponentsResponse, String> context,
        ListComponentsResponse response) {
      super(context, response);
    }

    private static ListComponentsPage createEmptyPage() {
      return new ListComponentsPage(null, null);
    }

    @Override
    protected ListComponentsPage createPage(
        PageContext<ListComponentsRequest, ListComponentsResponse, String> context,
        ListComponentsResponse response) {
      return new ListComponentsPage(context, response);
    }

    @Override
    public ApiFuture<ListComponentsPage> createPageAsync(
        PageContext<ListComponentsRequest, ListComponentsResponse, String> context,
        ApiFuture<ListComponentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListComponentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListComponentsRequest,
          ListComponentsResponse,
          String,
          ListComponentsPage,
          ListComponentsFixedSizeCollection> {

    private ListComponentsFixedSizeCollection(List<ListComponentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListComponentsFixedSizeCollection createEmptyCollection() {
      return new ListComponentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListComponentsFixedSizeCollection createCollection(
        List<ListComponentsPage> pages, int collectionSize) {
      return new ListComponentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
