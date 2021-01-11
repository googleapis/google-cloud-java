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

package com.google.cloud.websecurityscanner.v1beta;

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
import com.google.cloud.websecurityscanner.v1beta.stub.WebSecurityScannerStub;
import com.google.cloud.websecurityscanner.v1beta.stub.WebSecurityScannerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Cloud Web Security Scanner Service identifies security vulnerabilities in
 * web applications hosted on Google Cloud Platform. It crawls your application, and attempts to
 * exercise as many user inputs and event handlers as possible.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the WebSecurityScannerClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of WebSecurityScannerSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * WebSecurityScannerSettings webSecurityScannerSettings =
 *     WebSecurityScannerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * WebSecurityScannerClient webSecurityScannerClient =
 *     WebSecurityScannerClient.create(webSecurityScannerSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * WebSecurityScannerSettings webSecurityScannerSettings =
 *     WebSecurityScannerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * WebSecurityScannerClient webSecurityScannerClient =
 *     WebSecurityScannerClient.create(webSecurityScannerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class WebSecurityScannerClient implements BackgroundResource {
  private final WebSecurityScannerSettings settings;
  private final WebSecurityScannerStub stub;

  /** Constructs an instance of WebSecurityScannerClient with default settings. */
  public static final WebSecurityScannerClient create() throws IOException {
    return create(WebSecurityScannerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of WebSecurityScannerClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final WebSecurityScannerClient create(WebSecurityScannerSettings settings)
      throws IOException {
    return new WebSecurityScannerClient(settings);
  }

  /**
   * Constructs an instance of WebSecurityScannerClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(WebSecurityScannerSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final WebSecurityScannerClient create(WebSecurityScannerStub stub) {
    return new WebSecurityScannerClient(stub);
  }

  /**
   * Constructs an instance of WebSecurityScannerClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected WebSecurityScannerClient(WebSecurityScannerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((WebSecurityScannerStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected WebSecurityScannerClient(WebSecurityScannerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final WebSecurityScannerSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public WebSecurityScannerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ScanConfig.
   *
   * @param parent Required. The parent resource name where the scan is created, which should be a
   *     project resource name in the format 'projects/{projectId}'.
   * @param scanConfig Required. The ScanConfig to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanConfig createScanConfig(ProjectName parent, ScanConfig scanConfig) {
    CreateScanConfigRequest request =
        CreateScanConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setScanConfig(scanConfig)
            .build();
    return createScanConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ScanConfig.
   *
   * @param parent Required. The parent resource name where the scan is created, which should be a
   *     project resource name in the format 'projects/{projectId}'.
   * @param scanConfig Required. The ScanConfig to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanConfig createScanConfig(String parent, ScanConfig scanConfig) {
    CreateScanConfigRequest request =
        CreateScanConfigRequest.newBuilder().setParent(parent).setScanConfig(scanConfig).build();
    return createScanConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ScanConfig.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanConfig createScanConfig(CreateScanConfigRequest request) {
    return createScanConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ScanConfig.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateScanConfigRequest, ScanConfig> createScanConfigCallable() {
    return stub.createScanConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing ScanConfig and its child resources.
   *
   * @param name Required. The resource name of the ScanConfig to be deleted. The name follows the
   *     format of 'projects/{projectId}/scanConfigs/{scanConfigId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteScanConfig(ScanConfigName name) {
    DeleteScanConfigRequest request =
        DeleteScanConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteScanConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing ScanConfig and its child resources.
   *
   * @param name Required. The resource name of the ScanConfig to be deleted. The name follows the
   *     format of 'projects/{projectId}/scanConfigs/{scanConfigId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteScanConfig(String name) {
    DeleteScanConfigRequest request = DeleteScanConfigRequest.newBuilder().setName(name).build();
    deleteScanConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing ScanConfig and its child resources.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteScanConfig(DeleteScanConfigRequest request) {
    deleteScanConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing ScanConfig and its child resources.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteScanConfigRequest, Empty> deleteScanConfigCallable() {
    return stub.deleteScanConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ScanConfig.
   *
   * @param name Required. The resource name of the ScanConfig to be returned. The name follows the
   *     format of 'projects/{projectId}/scanConfigs/{scanConfigId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanConfig getScanConfig(ScanConfigName name) {
    GetScanConfigRequest request =
        GetScanConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getScanConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ScanConfig.
   *
   * @param name Required. The resource name of the ScanConfig to be returned. The name follows the
   *     format of 'projects/{projectId}/scanConfigs/{scanConfigId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanConfig getScanConfig(String name) {
    GetScanConfigRequest request = GetScanConfigRequest.newBuilder().setName(name).build();
    return getScanConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ScanConfig.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanConfig getScanConfig(GetScanConfigRequest request) {
    return getScanConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ScanConfig.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetScanConfigRequest, ScanConfig> getScanConfigCallable() {
    return stub.getScanConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ScanConfigs under a given project.
   *
   * @param parent Required. The parent resource name, which should be a project resource name in
   *     the format 'projects/{projectId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScanConfigsPagedResponse listScanConfigs(ProjectName parent) {
    ListScanConfigsRequest request =
        ListScanConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listScanConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ScanConfigs under a given project.
   *
   * @param parent Required. The parent resource name, which should be a project resource name in
   *     the format 'projects/{projectId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScanConfigsPagedResponse listScanConfigs(String parent) {
    ListScanConfigsRequest request = ListScanConfigsRequest.newBuilder().setParent(parent).build();
    return listScanConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ScanConfigs under a given project.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScanConfigsPagedResponse listScanConfigs(ListScanConfigsRequest request) {
    return listScanConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ScanConfigs under a given project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListScanConfigsRequest, ListScanConfigsPagedResponse>
      listScanConfigsPagedCallable() {
    return stub.listScanConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ScanConfigs under a given project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListScanConfigsRequest, ListScanConfigsResponse>
      listScanConfigsCallable() {
    return stub.listScanConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ScanConfig. This method support partial update of a ScanConfig.
   *
   * @param scanConfig Required. The ScanConfig to be updated. The name field must be set to
   *     identify the resource to be updated. The values of fields not covered by the mask will be
   *     ignored.
   * @param updateMask Required. The update mask applies to the resource. For the `FieldMask`
   *     definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanConfig updateScanConfig(ScanConfig scanConfig, FieldMask updateMask) {
    UpdateScanConfigRequest request =
        UpdateScanConfigRequest.newBuilder()
            .setScanConfig(scanConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateScanConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ScanConfig. This method support partial update of a ScanConfig.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanConfig updateScanConfig(UpdateScanConfigRequest request) {
    return updateScanConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a ScanConfig. This method support partial update of a ScanConfig.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateScanConfigRequest, ScanConfig> updateScanConfigCallable() {
    return stub.updateScanConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Start a ScanRun according to the given ScanConfig.
   *
   * @param name Required. The resource name of the ScanConfig to be used. The name follows the
   *     format of 'projects/{projectId}/scanConfigs/{scanConfigId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanRun startScanRun(ScanConfigName name) {
    StartScanRunRequest request =
        StartScanRunRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return startScanRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Start a ScanRun according to the given ScanConfig.
   *
   * @param name Required. The resource name of the ScanConfig to be used. The name follows the
   *     format of 'projects/{projectId}/scanConfigs/{scanConfigId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanRun startScanRun(String name) {
    StartScanRunRequest request = StartScanRunRequest.newBuilder().setName(name).build();
    return startScanRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Start a ScanRun according to the given ScanConfig.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanRun startScanRun(StartScanRunRequest request) {
    return startScanRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Start a ScanRun according to the given ScanConfig.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<StartScanRunRequest, ScanRun> startScanRunCallable() {
    return stub.startScanRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ScanRun.
   *
   * @param name Required. The resource name of the ScanRun to be returned. The name follows the
   *     format of 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanRun getScanRun(ScanRunName name) {
    GetScanRunRequest request =
        GetScanRunRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getScanRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ScanRun.
   *
   * @param name Required. The resource name of the ScanRun to be returned. The name follows the
   *     format of 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanRun getScanRun(String name) {
    GetScanRunRequest request = GetScanRunRequest.newBuilder().setName(name).build();
    return getScanRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ScanRun.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanRun getScanRun(GetScanRunRequest request) {
    return getScanRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a ScanRun.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetScanRunRequest, ScanRun> getScanRunCallable() {
    return stub.getScanRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ScanRuns under a given ScanConfig, in descending order of ScanRun stop time.
   *
   * @param parent Required. The parent resource name, which should be a scan resource name in the
   *     format 'projects/{projectId}/scanConfigs/{scanConfigId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScanRunsPagedResponse listScanRuns(ScanConfigName parent) {
    ListScanRunsRequest request =
        ListScanRunsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listScanRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ScanRuns under a given ScanConfig, in descending order of ScanRun stop time.
   *
   * @param parent Required. The parent resource name, which should be a scan resource name in the
   *     format 'projects/{projectId}/scanConfigs/{scanConfigId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScanRunsPagedResponse listScanRuns(String parent) {
    ListScanRunsRequest request = ListScanRunsRequest.newBuilder().setParent(parent).build();
    return listScanRuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ScanRuns under a given ScanConfig, in descending order of ScanRun stop time.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScanRunsPagedResponse listScanRuns(ListScanRunsRequest request) {
    return listScanRunsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ScanRuns under a given ScanConfig, in descending order of ScanRun stop time.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListScanRunsRequest, ListScanRunsPagedResponse>
      listScanRunsPagedCallable() {
    return stub.listScanRunsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ScanRuns under a given ScanConfig, in descending order of ScanRun stop time.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListScanRunsRequest, ListScanRunsResponse> listScanRunsCallable() {
    return stub.listScanRunsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a ScanRun. The stopped ScanRun is returned.
   *
   * @param name Required. The resource name of the ScanRun to be stopped. The name follows the
   *     format of 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanRun stopScanRun(ScanRunName name) {
    StopScanRunRequest request =
        StopScanRunRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return stopScanRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a ScanRun. The stopped ScanRun is returned.
   *
   * @param name Required. The resource name of the ScanRun to be stopped. The name follows the
   *     format of 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanRun stopScanRun(String name) {
    StopScanRunRequest request = StopScanRunRequest.newBuilder().setName(name).build();
    return stopScanRun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a ScanRun. The stopped ScanRun is returned.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanRun stopScanRun(StopScanRunRequest request) {
    return stopScanRunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops a ScanRun. The stopped ScanRun is returned.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<StopScanRunRequest, ScanRun> stopScanRunCallable() {
    return stub.stopScanRunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List CrawledUrls under a given ScanRun.
   *
   * @param parent Required. The parent resource name, which should be a scan run resource name in
   *     the format 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCrawledUrlsPagedResponse listCrawledUrls(ScanRunName parent) {
    ListCrawledUrlsRequest request =
        ListCrawledUrlsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCrawledUrls(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List CrawledUrls under a given ScanRun.
   *
   * @param parent Required. The parent resource name, which should be a scan run resource name in
   *     the format 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCrawledUrlsPagedResponse listCrawledUrls(String parent) {
    ListCrawledUrlsRequest request = ListCrawledUrlsRequest.newBuilder().setParent(parent).build();
    return listCrawledUrls(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List CrawledUrls under a given ScanRun.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCrawledUrlsPagedResponse listCrawledUrls(ListCrawledUrlsRequest request) {
    return listCrawledUrlsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List CrawledUrls under a given ScanRun.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListCrawledUrlsRequest, ListCrawledUrlsPagedResponse>
      listCrawledUrlsPagedCallable() {
    return stub.listCrawledUrlsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List CrawledUrls under a given ScanRun.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListCrawledUrlsRequest, ListCrawledUrlsResponse>
      listCrawledUrlsCallable() {
    return stub.listCrawledUrlsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Finding.
   *
   * @param name Required. The resource name of the Finding to be returned. The name follows the
   *     format of
   *     'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}/findings/{findingId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding getFinding(FindingName name) {
    GetFindingRequest request =
        GetFindingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Finding.
   *
   * @param name Required. The resource name of the Finding to be returned. The name follows the
   *     format of
   *     'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}/findings/{findingId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding getFinding(String name) {
    GetFindingRequest request = GetFindingRequest.newBuilder().setName(name).build();
    return getFinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Finding.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding getFinding(GetFindingRequest request) {
    return getFindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Finding.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetFindingRequest, Finding> getFindingCallable() {
    return stub.getFindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Findings under a given ScanRun.
   *
   * @param parent Required. The parent resource name, which should be a scan run resource name in
   *     the format 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'.
   * @param filter Required. The filter expression. The expression must be in the format:
   *     &lt;field&gt; &lt;operator&gt; &lt;value&gt;. Supported field: 'finding_type'. Supported
   *     operator: '='.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingsPagedResponse listFindings(ScanRunName parent, String filter) {
    ListFindingsRequest request =
        ListFindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listFindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Findings under a given ScanRun.
   *
   * @param parent Required. The parent resource name, which should be a scan run resource name in
   *     the format 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'.
   * @param filter Required. The filter expression. The expression must be in the format:
   *     &lt;field&gt; &lt;operator&gt; &lt;value&gt;. Supported field: 'finding_type'. Supported
   *     operator: '='.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingsPagedResponse listFindings(String parent, String filter) {
    ListFindingsRequest request =
        ListFindingsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listFindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Findings under a given ScanRun.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingsPagedResponse listFindings(ListFindingsRequest request) {
    return listFindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Findings under a given ScanRun.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse>
      listFindingsPagedCallable() {
    return stub.listFindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Findings under a given ScanRun.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable() {
    return stub.listFindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all FindingTypeStats under a given ScanRun.
   *
   * @param parent Required. The parent resource name, which should be a scan run resource name in
   *     the format 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingTypeStatsResponse listFindingTypeStats(ScanRunName parent) {
    ListFindingTypeStatsRequest request =
        ListFindingTypeStatsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFindingTypeStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all FindingTypeStats under a given ScanRun.
   *
   * @param parent Required. The parent resource name, which should be a scan run resource name in
   *     the format 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingTypeStatsResponse listFindingTypeStats(String parent) {
    ListFindingTypeStatsRequest request =
        ListFindingTypeStatsRequest.newBuilder().setParent(parent).build();
    return listFindingTypeStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all FindingTypeStats under a given ScanRun.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingTypeStatsResponse listFindingTypeStats(
      ListFindingTypeStatsRequest request) {
    return listFindingTypeStatsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all FindingTypeStats under a given ScanRun.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>
      listFindingTypeStatsCallable() {
    return stub.listFindingTypeStatsCallable();
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

  public static class ListScanConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListScanConfigsRequest,
          ListScanConfigsResponse,
          ScanConfig,
          ListScanConfigsPage,
          ListScanConfigsFixedSizeCollection> {

    public static ApiFuture<ListScanConfigsPagedResponse> createAsync(
        PageContext<ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig> context,
        ApiFuture<ListScanConfigsResponse> futureResponse) {
      ApiFuture<ListScanConfigsPage> futurePage =
          ListScanConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListScanConfigsPage, ListScanConfigsPagedResponse>() {
            @Override
            public ListScanConfigsPagedResponse apply(ListScanConfigsPage input) {
              return new ListScanConfigsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListScanConfigsPagedResponse(ListScanConfigsPage page) {
      super(page, ListScanConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListScanConfigsPage
      extends AbstractPage<
          ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig, ListScanConfigsPage> {

    private ListScanConfigsPage(
        PageContext<ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig> context,
        ListScanConfigsResponse response) {
      super(context, response);
    }

    private static ListScanConfigsPage createEmptyPage() {
      return new ListScanConfigsPage(null, null);
    }

    @Override
    protected ListScanConfigsPage createPage(
        PageContext<ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig> context,
        ListScanConfigsResponse response) {
      return new ListScanConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListScanConfigsPage> createPageAsync(
        PageContext<ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig> context,
        ApiFuture<ListScanConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListScanConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListScanConfigsRequest,
          ListScanConfigsResponse,
          ScanConfig,
          ListScanConfigsPage,
          ListScanConfigsFixedSizeCollection> {

    private ListScanConfigsFixedSizeCollection(
        List<ListScanConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListScanConfigsFixedSizeCollection createEmptyCollection() {
      return new ListScanConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListScanConfigsFixedSizeCollection createCollection(
        List<ListScanConfigsPage> pages, int collectionSize) {
      return new ListScanConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListScanRunsPagedResponse
      extends AbstractPagedListResponse<
          ListScanRunsRequest,
          ListScanRunsResponse,
          ScanRun,
          ListScanRunsPage,
          ListScanRunsFixedSizeCollection> {

    public static ApiFuture<ListScanRunsPagedResponse> createAsync(
        PageContext<ListScanRunsRequest, ListScanRunsResponse, ScanRun> context,
        ApiFuture<ListScanRunsResponse> futureResponse) {
      ApiFuture<ListScanRunsPage> futurePage =
          ListScanRunsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListScanRunsPage, ListScanRunsPagedResponse>() {
            @Override
            public ListScanRunsPagedResponse apply(ListScanRunsPage input) {
              return new ListScanRunsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListScanRunsPagedResponse(ListScanRunsPage page) {
      super(page, ListScanRunsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListScanRunsPage
      extends AbstractPage<ListScanRunsRequest, ListScanRunsResponse, ScanRun, ListScanRunsPage> {

    private ListScanRunsPage(
        PageContext<ListScanRunsRequest, ListScanRunsResponse, ScanRun> context,
        ListScanRunsResponse response) {
      super(context, response);
    }

    private static ListScanRunsPage createEmptyPage() {
      return new ListScanRunsPage(null, null);
    }

    @Override
    protected ListScanRunsPage createPage(
        PageContext<ListScanRunsRequest, ListScanRunsResponse, ScanRun> context,
        ListScanRunsResponse response) {
      return new ListScanRunsPage(context, response);
    }

    @Override
    public ApiFuture<ListScanRunsPage> createPageAsync(
        PageContext<ListScanRunsRequest, ListScanRunsResponse, ScanRun> context,
        ApiFuture<ListScanRunsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListScanRunsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListScanRunsRequest,
          ListScanRunsResponse,
          ScanRun,
          ListScanRunsPage,
          ListScanRunsFixedSizeCollection> {

    private ListScanRunsFixedSizeCollection(List<ListScanRunsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListScanRunsFixedSizeCollection createEmptyCollection() {
      return new ListScanRunsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListScanRunsFixedSizeCollection createCollection(
        List<ListScanRunsPage> pages, int collectionSize) {
      return new ListScanRunsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCrawledUrlsPagedResponse
      extends AbstractPagedListResponse<
          ListCrawledUrlsRequest,
          ListCrawledUrlsResponse,
          CrawledUrl,
          ListCrawledUrlsPage,
          ListCrawledUrlsFixedSizeCollection> {

    public static ApiFuture<ListCrawledUrlsPagedResponse> createAsync(
        PageContext<ListCrawledUrlsRequest, ListCrawledUrlsResponse, CrawledUrl> context,
        ApiFuture<ListCrawledUrlsResponse> futureResponse) {
      ApiFuture<ListCrawledUrlsPage> futurePage =
          ListCrawledUrlsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListCrawledUrlsPage, ListCrawledUrlsPagedResponse>() {
            @Override
            public ListCrawledUrlsPagedResponse apply(ListCrawledUrlsPage input) {
              return new ListCrawledUrlsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListCrawledUrlsPagedResponse(ListCrawledUrlsPage page) {
      super(page, ListCrawledUrlsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCrawledUrlsPage
      extends AbstractPage<
          ListCrawledUrlsRequest, ListCrawledUrlsResponse, CrawledUrl, ListCrawledUrlsPage> {

    private ListCrawledUrlsPage(
        PageContext<ListCrawledUrlsRequest, ListCrawledUrlsResponse, CrawledUrl> context,
        ListCrawledUrlsResponse response) {
      super(context, response);
    }

    private static ListCrawledUrlsPage createEmptyPage() {
      return new ListCrawledUrlsPage(null, null);
    }

    @Override
    protected ListCrawledUrlsPage createPage(
        PageContext<ListCrawledUrlsRequest, ListCrawledUrlsResponse, CrawledUrl> context,
        ListCrawledUrlsResponse response) {
      return new ListCrawledUrlsPage(context, response);
    }

    @Override
    public ApiFuture<ListCrawledUrlsPage> createPageAsync(
        PageContext<ListCrawledUrlsRequest, ListCrawledUrlsResponse, CrawledUrl> context,
        ApiFuture<ListCrawledUrlsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCrawledUrlsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCrawledUrlsRequest,
          ListCrawledUrlsResponse,
          CrawledUrl,
          ListCrawledUrlsPage,
          ListCrawledUrlsFixedSizeCollection> {

    private ListCrawledUrlsFixedSizeCollection(
        List<ListCrawledUrlsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCrawledUrlsFixedSizeCollection createEmptyCollection() {
      return new ListCrawledUrlsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCrawledUrlsFixedSizeCollection createCollection(
        List<ListCrawledUrlsPage> pages, int collectionSize) {
      return new ListCrawledUrlsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFindingsPagedResponse
      extends AbstractPagedListResponse<
          ListFindingsRequest,
          ListFindingsResponse,
          Finding,
          ListFindingsPage,
          ListFindingsFixedSizeCollection> {

    public static ApiFuture<ListFindingsPagedResponse> createAsync(
        PageContext<ListFindingsRequest, ListFindingsResponse, Finding> context,
        ApiFuture<ListFindingsResponse> futureResponse) {
      ApiFuture<ListFindingsPage> futurePage =
          ListFindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListFindingsPage, ListFindingsPagedResponse>() {
            @Override
            public ListFindingsPagedResponse apply(ListFindingsPage input) {
              return new ListFindingsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListFindingsPagedResponse(ListFindingsPage page) {
      super(page, ListFindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFindingsPage
      extends AbstractPage<ListFindingsRequest, ListFindingsResponse, Finding, ListFindingsPage> {

    private ListFindingsPage(
        PageContext<ListFindingsRequest, ListFindingsResponse, Finding> context,
        ListFindingsResponse response) {
      super(context, response);
    }

    private static ListFindingsPage createEmptyPage() {
      return new ListFindingsPage(null, null);
    }

    @Override
    protected ListFindingsPage createPage(
        PageContext<ListFindingsRequest, ListFindingsResponse, Finding> context,
        ListFindingsResponse response) {
      return new ListFindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListFindingsPage> createPageAsync(
        PageContext<ListFindingsRequest, ListFindingsResponse, Finding> context,
        ApiFuture<ListFindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFindingsRequest,
          ListFindingsResponse,
          Finding,
          ListFindingsPage,
          ListFindingsFixedSizeCollection> {

    private ListFindingsFixedSizeCollection(List<ListFindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFindingsFixedSizeCollection createEmptyCollection() {
      return new ListFindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFindingsFixedSizeCollection createCollection(
        List<ListFindingsPage> pages, int collectionSize) {
      return new ListFindingsFixedSizeCollection(pages, collectionSize);
    }
  }
}
