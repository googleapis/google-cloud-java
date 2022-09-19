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

package com.google.cloud.monitoring.v3;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.monitoring.v3.stub.UptimeCheckServiceStub;
import com.google.cloud.monitoring.v3.stub.UptimeCheckServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.monitoring.v3.CreateUptimeCheckConfigRequest;
import com.google.monitoring.v3.DeleteUptimeCheckConfigRequest;
import com.google.monitoring.v3.GetUptimeCheckConfigRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsResponse;
import com.google.monitoring.v3.ListUptimeCheckIpsRequest;
import com.google.monitoring.v3.ListUptimeCheckIpsResponse;
import com.google.monitoring.v3.OrganizationName;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.UpdateUptimeCheckConfigRequest;
import com.google.monitoring.v3.UptimeCheckConfig;
import com.google.monitoring.v3.UptimeCheckConfigName;
import com.google.monitoring.v3.UptimeCheckIp;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The UptimeCheckService API is used to manage (list, create, delete, edit)
 * Uptime check configurations in the Stackdriver Monitoring product. An Uptime check is a piece of
 * configuration that determines which resources and services to monitor for availability. These
 * configurations can also be configured interactively by navigating to the [Cloud Console]
 * (http://console.cloud.google.com), selecting the appropriate project, clicking on "Monitoring" on
 * the left-hand side to navigate to Stackdriver, and then clicking on "Uptime".
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
 * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
 *   UptimeCheckConfigName name =
 *       UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
 *           "[PROJECT]", "[UPTIME_CHECK_CONFIG]");
 *   UptimeCheckConfig response = uptimeCheckServiceClient.getUptimeCheckConfig(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the UptimeCheckServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of UptimeCheckServiceSettings to
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
 * UptimeCheckServiceSettings uptimeCheckServiceSettings =
 *     UptimeCheckServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * UptimeCheckServiceClient uptimeCheckServiceClient =
 *     UptimeCheckServiceClient.create(uptimeCheckServiceSettings);
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
 * UptimeCheckServiceSettings uptimeCheckServiceSettings =
 *     UptimeCheckServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * UptimeCheckServiceClient uptimeCheckServiceClient =
 *     UptimeCheckServiceClient.create(uptimeCheckServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class UptimeCheckServiceClient implements BackgroundResource {
  private final UptimeCheckServiceSettings settings;
  private final UptimeCheckServiceStub stub;

  /** Constructs an instance of UptimeCheckServiceClient with default settings. */
  public static final UptimeCheckServiceClient create() throws IOException {
    return create(UptimeCheckServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of UptimeCheckServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final UptimeCheckServiceClient create(UptimeCheckServiceSettings settings)
      throws IOException {
    return new UptimeCheckServiceClient(settings);
  }

  /**
   * Constructs an instance of UptimeCheckServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(UptimeCheckServiceSettings).
   */
  public static final UptimeCheckServiceClient create(UptimeCheckServiceStub stub) {
    return new UptimeCheckServiceClient(stub);
  }

  /**
   * Constructs an instance of UptimeCheckServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected UptimeCheckServiceClient(UptimeCheckServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((UptimeCheckServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected UptimeCheckServiceClient(UptimeCheckServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final UptimeCheckServiceSettings getSettings() {
    return settings;
  }

  public UptimeCheckServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing valid Uptime check configurations for the project (leaving out any invalid
   * configurations).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   ResourceName parent = ResourceName.of("[FOLDER]");
   *   for (UptimeCheckConfig element :
   *       uptimeCheckServiceClient.listUptimeCheckConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The [project](https://cloud.google.com/monitoring/api/v3#project_name)
   *     whose Uptime check configurations are listed. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUptimeCheckConfigsPagedResponse listUptimeCheckConfigs(ResourceName parent) {
    ListUptimeCheckConfigsRequest request =
        ListUptimeCheckConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUptimeCheckConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing valid Uptime check configurations for the project (leaving out any invalid
   * configurations).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (UptimeCheckConfig element :
   *       uptimeCheckServiceClient.listUptimeCheckConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The [project](https://cloud.google.com/monitoring/api/v3#project_name)
   *     whose Uptime check configurations are listed. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUptimeCheckConfigsPagedResponse listUptimeCheckConfigs(OrganizationName parent) {
    ListUptimeCheckConfigsRequest request =
        ListUptimeCheckConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUptimeCheckConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing valid Uptime check configurations for the project (leaving out any invalid
   * configurations).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (UptimeCheckConfig element :
   *       uptimeCheckServiceClient.listUptimeCheckConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The [project](https://cloud.google.com/monitoring/api/v3#project_name)
   *     whose Uptime check configurations are listed. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUptimeCheckConfigsPagedResponse listUptimeCheckConfigs(ProjectName parent) {
    ListUptimeCheckConfigsRequest request =
        ListUptimeCheckConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listUptimeCheckConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing valid Uptime check configurations for the project (leaving out any invalid
   * configurations).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (UptimeCheckConfig element :
   *       uptimeCheckServiceClient.listUptimeCheckConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The [project](https://cloud.google.com/monitoring/api/v3#project_name)
   *     whose Uptime check configurations are listed. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUptimeCheckConfigsPagedResponse listUptimeCheckConfigs(String parent) {
    ListUptimeCheckConfigsRequest request =
        ListUptimeCheckConfigsRequest.newBuilder().setParent(parent).build();
    return listUptimeCheckConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing valid Uptime check configurations for the project (leaving out any invalid
   * configurations).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   ListUptimeCheckConfigsRequest request =
   *       ListUptimeCheckConfigsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (UptimeCheckConfig element :
   *       uptimeCheckServiceClient.listUptimeCheckConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUptimeCheckConfigsPagedResponse listUptimeCheckConfigs(
      ListUptimeCheckConfigsRequest request) {
    return listUptimeCheckConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing valid Uptime check configurations for the project (leaving out any invalid
   * configurations).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   ListUptimeCheckConfigsRequest request =
   *       ListUptimeCheckConfigsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<UptimeCheckConfig> future =
   *       uptimeCheckServiceClient.listUptimeCheckConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (UptimeCheckConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsPagedResponse>
      listUptimeCheckConfigsPagedCallable() {
    return stub.listUptimeCheckConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing valid Uptime check configurations for the project (leaving out any invalid
   * configurations).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   ListUptimeCheckConfigsRequest request =
   *       ListUptimeCheckConfigsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListUptimeCheckConfigsResponse response =
   *         uptimeCheckServiceClient.listUptimeCheckConfigsCallable().call(request);
   *     for (UptimeCheckConfig element : response.getUptimeCheckConfigsList()) {
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
  public final UnaryCallable<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse>
      listUptimeCheckConfigsCallable() {
    return stub.listUptimeCheckConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single Uptime check configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   UptimeCheckConfigName name =
   *       UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
   *           "[PROJECT]", "[UPTIME_CHECK_CONFIG]");
   *   UptimeCheckConfig response = uptimeCheckServiceClient.getUptimeCheckConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The Uptime check configuration to retrieve. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/uptimeCheckConfigs/[UPTIME_CHECK_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UptimeCheckConfig getUptimeCheckConfig(UptimeCheckConfigName name) {
    GetUptimeCheckConfigRequest request =
        GetUptimeCheckConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getUptimeCheckConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single Uptime check configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   String name =
   *       UptimeCheckConfigName.ofProjectUptimeCheckConfigName("[PROJECT]", "[UPTIME_CHECK_CONFIG]")
   *           .toString();
   *   UptimeCheckConfig response = uptimeCheckServiceClient.getUptimeCheckConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The Uptime check configuration to retrieve. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/uptimeCheckConfigs/[UPTIME_CHECK_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UptimeCheckConfig getUptimeCheckConfig(String name) {
    GetUptimeCheckConfigRequest request =
        GetUptimeCheckConfigRequest.newBuilder().setName(name).build();
    return getUptimeCheckConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single Uptime check configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   GetUptimeCheckConfigRequest request =
   *       GetUptimeCheckConfigRequest.newBuilder()
   *           .setName(
   *               UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
   *                       "[PROJECT]", "[UPTIME_CHECK_CONFIG]")
   *                   .toString())
   *           .build();
   *   UptimeCheckConfig response = uptimeCheckServiceClient.getUptimeCheckConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UptimeCheckConfig getUptimeCheckConfig(GetUptimeCheckConfigRequest request) {
    return getUptimeCheckConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single Uptime check configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   GetUptimeCheckConfigRequest request =
   *       GetUptimeCheckConfigRequest.newBuilder()
   *           .setName(
   *               UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
   *                       "[PROJECT]", "[UPTIME_CHECK_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<UptimeCheckConfig> future =
   *       uptimeCheckServiceClient.getUptimeCheckConfigCallable().futureCall(request);
   *   // Do something.
   *   UptimeCheckConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetUptimeCheckConfigRequest, UptimeCheckConfig>
      getUptimeCheckConfigCallable() {
    return stub.getUptimeCheckConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Uptime check configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   ResourceName parent = ResourceName.of("[FOLDER]");
   *   UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();
   *   UptimeCheckConfig response =
   *       uptimeCheckServiceClient.createUptimeCheckConfig(parent, uptimeCheckConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The [project](https://cloud.google.com/monitoring/api/v3#project_name)
   *     in which to create the Uptime check. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @param uptimeCheckConfig Required. The new Uptime check configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UptimeCheckConfig createUptimeCheckConfig(
      ResourceName parent, UptimeCheckConfig uptimeCheckConfig) {
    CreateUptimeCheckConfigRequest request =
        CreateUptimeCheckConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUptimeCheckConfig(uptimeCheckConfig)
            .build();
    return createUptimeCheckConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Uptime check configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();
   *   UptimeCheckConfig response =
   *       uptimeCheckServiceClient.createUptimeCheckConfig(parent, uptimeCheckConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The [project](https://cloud.google.com/monitoring/api/v3#project_name)
   *     in which to create the Uptime check. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @param uptimeCheckConfig Required. The new Uptime check configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UptimeCheckConfig createUptimeCheckConfig(
      OrganizationName parent, UptimeCheckConfig uptimeCheckConfig) {
    CreateUptimeCheckConfigRequest request =
        CreateUptimeCheckConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUptimeCheckConfig(uptimeCheckConfig)
            .build();
    return createUptimeCheckConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Uptime check configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();
   *   UptimeCheckConfig response =
   *       uptimeCheckServiceClient.createUptimeCheckConfig(parent, uptimeCheckConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The [project](https://cloud.google.com/monitoring/api/v3#project_name)
   *     in which to create the Uptime check. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @param uptimeCheckConfig Required. The new Uptime check configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UptimeCheckConfig createUptimeCheckConfig(
      ProjectName parent, UptimeCheckConfig uptimeCheckConfig) {
    CreateUptimeCheckConfigRequest request =
        CreateUptimeCheckConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setUptimeCheckConfig(uptimeCheckConfig)
            .build();
    return createUptimeCheckConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Uptime check configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();
   *   UptimeCheckConfig response =
   *       uptimeCheckServiceClient.createUptimeCheckConfig(parent, uptimeCheckConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The [project](https://cloud.google.com/monitoring/api/v3#project_name)
   *     in which to create the Uptime check. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]
   * @param uptimeCheckConfig Required. The new Uptime check configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UptimeCheckConfig createUptimeCheckConfig(
      String parent, UptimeCheckConfig uptimeCheckConfig) {
    CreateUptimeCheckConfigRequest request =
        CreateUptimeCheckConfigRequest.newBuilder()
            .setParent(parent)
            .setUptimeCheckConfig(uptimeCheckConfig)
            .build();
    return createUptimeCheckConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Uptime check configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   CreateUptimeCheckConfigRequest request =
   *       CreateUptimeCheckConfigRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setUptimeCheckConfig(UptimeCheckConfig.newBuilder().build())
   *           .build();
   *   UptimeCheckConfig response = uptimeCheckServiceClient.createUptimeCheckConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UptimeCheckConfig createUptimeCheckConfig(CreateUptimeCheckConfigRequest request) {
    return createUptimeCheckConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Uptime check configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   CreateUptimeCheckConfigRequest request =
   *       CreateUptimeCheckConfigRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setUptimeCheckConfig(UptimeCheckConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<UptimeCheckConfig> future =
   *       uptimeCheckServiceClient.createUptimeCheckConfigCallable().futureCall(request);
   *   // Do something.
   *   UptimeCheckConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
      createUptimeCheckConfigCallable() {
    return stub.createUptimeCheckConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Uptime check configuration. You can either replace the entire configuration with a
   * new one or replace only certain fields in the current configuration by specifying the fields to
   * be updated via `updateMask`. Returns the updated configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   UptimeCheckConfig uptimeCheckConfig = UptimeCheckConfig.newBuilder().build();
   *   UptimeCheckConfig response =
   *       uptimeCheckServiceClient.updateUptimeCheckConfig(uptimeCheckConfig);
   * }
   * }</pre>
   *
   * @param uptimeCheckConfig Required. If an `updateMask` has been specified, this field gives the
   *     values for the set of fields mentioned in the `updateMask`. If an `updateMask` has not been
   *     given, this Uptime check configuration replaces the current configuration. If a field is
   *     mentioned in `updateMask` but the corresonding field is omitted in this partial Uptime
   *     check configuration, it has the effect of deleting/clearing the field from the
   *     configuration on the server.
   *     <p>The following fields can be updated: `display_name`, `http_check`, `tcp_check`,
   *     `timeout`, `content_matchers`, and `selected_regions`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UptimeCheckConfig updateUptimeCheckConfig(UptimeCheckConfig uptimeCheckConfig) {
    UpdateUptimeCheckConfigRequest request =
        UpdateUptimeCheckConfigRequest.newBuilder().setUptimeCheckConfig(uptimeCheckConfig).build();
    return updateUptimeCheckConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Uptime check configuration. You can either replace the entire configuration with a
   * new one or replace only certain fields in the current configuration by specifying the fields to
   * be updated via `updateMask`. Returns the updated configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   UpdateUptimeCheckConfigRequest request =
   *       UpdateUptimeCheckConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setUptimeCheckConfig(UptimeCheckConfig.newBuilder().build())
   *           .build();
   *   UptimeCheckConfig response = uptimeCheckServiceClient.updateUptimeCheckConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UptimeCheckConfig updateUptimeCheckConfig(UpdateUptimeCheckConfigRequest request) {
    return updateUptimeCheckConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an Uptime check configuration. You can either replace the entire configuration with a
   * new one or replace only certain fields in the current configuration by specifying the fields to
   * be updated via `updateMask`. Returns the updated configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   UpdateUptimeCheckConfigRequest request =
   *       UpdateUptimeCheckConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setUptimeCheckConfig(UptimeCheckConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<UptimeCheckConfig> future =
   *       uptimeCheckServiceClient.updateUptimeCheckConfigCallable().futureCall(request);
   *   // Do something.
   *   UptimeCheckConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
      updateUptimeCheckConfigCallable() {
    return stub.updateUptimeCheckConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Uptime check configuration. Note that this method will fail if the Uptime check
   * configuration is referenced by an alert policy or other dependent configs that would be
   * rendered invalid by the deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   UptimeCheckConfigName name =
   *       UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
   *           "[PROJECT]", "[UPTIME_CHECK_CONFIG]");
   *   uptimeCheckServiceClient.deleteUptimeCheckConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The Uptime check configuration to delete. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/uptimeCheckConfigs/[UPTIME_CHECK_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUptimeCheckConfig(UptimeCheckConfigName name) {
    DeleteUptimeCheckConfigRequest request =
        DeleteUptimeCheckConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteUptimeCheckConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Uptime check configuration. Note that this method will fail if the Uptime check
   * configuration is referenced by an alert policy or other dependent configs that would be
   * rendered invalid by the deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   String name =
   *       UptimeCheckConfigName.ofProjectUptimeCheckConfigName("[PROJECT]", "[UPTIME_CHECK_CONFIG]")
   *           .toString();
   *   uptimeCheckServiceClient.deleteUptimeCheckConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. The Uptime check configuration to delete. The format is:
   *     <p>projects/[PROJECT_ID_OR_NUMBER]/uptimeCheckConfigs/[UPTIME_CHECK_ID]
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUptimeCheckConfig(String name) {
    DeleteUptimeCheckConfigRequest request =
        DeleteUptimeCheckConfigRequest.newBuilder().setName(name).build();
    deleteUptimeCheckConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Uptime check configuration. Note that this method will fail if the Uptime check
   * configuration is referenced by an alert policy or other dependent configs that would be
   * rendered invalid by the deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   DeleteUptimeCheckConfigRequest request =
   *       DeleteUptimeCheckConfigRequest.newBuilder()
   *           .setName(
   *               UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
   *                       "[PROJECT]", "[UPTIME_CHECK_CONFIG]")
   *                   .toString())
   *           .build();
   *   uptimeCheckServiceClient.deleteUptimeCheckConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteUptimeCheckConfig(DeleteUptimeCheckConfigRequest request) {
    deleteUptimeCheckConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an Uptime check configuration. Note that this method will fail if the Uptime check
   * configuration is referenced by an alert policy or other dependent configs that would be
   * rendered invalid by the deletion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   DeleteUptimeCheckConfigRequest request =
   *       DeleteUptimeCheckConfigRequest.newBuilder()
   *           .setName(
   *               UptimeCheckConfigName.ofProjectUptimeCheckConfigName(
   *                       "[PROJECT]", "[UPTIME_CHECK_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       uptimeCheckServiceClient.deleteUptimeCheckConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteUptimeCheckConfigRequest, Empty>
      deleteUptimeCheckConfigCallable() {
    return stub.deleteUptimeCheckConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of IP addresses that checkers run from
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   ListUptimeCheckIpsRequest request =
   *       ListUptimeCheckIpsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (UptimeCheckIp element :
   *       uptimeCheckServiceClient.listUptimeCheckIps(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUptimeCheckIpsPagedResponse listUptimeCheckIps(
      ListUptimeCheckIpsRequest request) {
    return listUptimeCheckIpsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of IP addresses that checkers run from
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   ListUptimeCheckIpsRequest request =
   *       ListUptimeCheckIpsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<UptimeCheckIp> future =
   *       uptimeCheckServiceClient.listUptimeCheckIpsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (UptimeCheckIp element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListUptimeCheckIpsRequest, ListUptimeCheckIpsPagedResponse>
      listUptimeCheckIpsPagedCallable() {
    return stub.listUptimeCheckIpsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of IP addresses that checkers run from
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (UptimeCheckServiceClient uptimeCheckServiceClient = UptimeCheckServiceClient.create()) {
   *   ListUptimeCheckIpsRequest request =
   *       ListUptimeCheckIpsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListUptimeCheckIpsResponse response =
   *         uptimeCheckServiceClient.listUptimeCheckIpsCallable().call(request);
   *     for (UptimeCheckIp element : response.getUptimeCheckIpsList()) {
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
  public final UnaryCallable<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse>
      listUptimeCheckIpsCallable() {
    return stub.listUptimeCheckIpsCallable();
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

  public static class ListUptimeCheckConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListUptimeCheckConfigsRequest,
          ListUptimeCheckConfigsResponse,
          UptimeCheckConfig,
          ListUptimeCheckConfigsPage,
          ListUptimeCheckConfigsFixedSizeCollection> {

    public static ApiFuture<ListUptimeCheckConfigsPagedResponse> createAsync(
        PageContext<
                ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse, UptimeCheckConfig>
            context,
        ApiFuture<ListUptimeCheckConfigsResponse> futureResponse) {
      ApiFuture<ListUptimeCheckConfigsPage> futurePage =
          ListUptimeCheckConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUptimeCheckConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUptimeCheckConfigsPagedResponse(ListUptimeCheckConfigsPage page) {
      super(page, ListUptimeCheckConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUptimeCheckConfigsPage
      extends AbstractPage<
          ListUptimeCheckConfigsRequest,
          ListUptimeCheckConfigsResponse,
          UptimeCheckConfig,
          ListUptimeCheckConfigsPage> {

    private ListUptimeCheckConfigsPage(
        PageContext<
                ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse, UptimeCheckConfig>
            context,
        ListUptimeCheckConfigsResponse response) {
      super(context, response);
    }

    private static ListUptimeCheckConfigsPage createEmptyPage() {
      return new ListUptimeCheckConfigsPage(null, null);
    }

    @Override
    protected ListUptimeCheckConfigsPage createPage(
        PageContext<
                ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse, UptimeCheckConfig>
            context,
        ListUptimeCheckConfigsResponse response) {
      return new ListUptimeCheckConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListUptimeCheckConfigsPage> createPageAsync(
        PageContext<
                ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse, UptimeCheckConfig>
            context,
        ApiFuture<ListUptimeCheckConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUptimeCheckConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUptimeCheckConfigsRequest,
          ListUptimeCheckConfigsResponse,
          UptimeCheckConfig,
          ListUptimeCheckConfigsPage,
          ListUptimeCheckConfigsFixedSizeCollection> {

    private ListUptimeCheckConfigsFixedSizeCollection(
        List<ListUptimeCheckConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUptimeCheckConfigsFixedSizeCollection createEmptyCollection() {
      return new ListUptimeCheckConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUptimeCheckConfigsFixedSizeCollection createCollection(
        List<ListUptimeCheckConfigsPage> pages, int collectionSize) {
      return new ListUptimeCheckConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListUptimeCheckIpsPagedResponse
      extends AbstractPagedListResponse<
          ListUptimeCheckIpsRequest,
          ListUptimeCheckIpsResponse,
          UptimeCheckIp,
          ListUptimeCheckIpsPage,
          ListUptimeCheckIpsFixedSizeCollection> {

    public static ApiFuture<ListUptimeCheckIpsPagedResponse> createAsync(
        PageContext<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse, UptimeCheckIp> context,
        ApiFuture<ListUptimeCheckIpsResponse> futureResponse) {
      ApiFuture<ListUptimeCheckIpsPage> futurePage =
          ListUptimeCheckIpsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListUptimeCheckIpsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListUptimeCheckIpsPagedResponse(ListUptimeCheckIpsPage page) {
      super(page, ListUptimeCheckIpsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUptimeCheckIpsPage
      extends AbstractPage<
          ListUptimeCheckIpsRequest,
          ListUptimeCheckIpsResponse,
          UptimeCheckIp,
          ListUptimeCheckIpsPage> {

    private ListUptimeCheckIpsPage(
        PageContext<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse, UptimeCheckIp> context,
        ListUptimeCheckIpsResponse response) {
      super(context, response);
    }

    private static ListUptimeCheckIpsPage createEmptyPage() {
      return new ListUptimeCheckIpsPage(null, null);
    }

    @Override
    protected ListUptimeCheckIpsPage createPage(
        PageContext<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse, UptimeCheckIp> context,
        ListUptimeCheckIpsResponse response) {
      return new ListUptimeCheckIpsPage(context, response);
    }

    @Override
    public ApiFuture<ListUptimeCheckIpsPage> createPageAsync(
        PageContext<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse, UptimeCheckIp> context,
        ApiFuture<ListUptimeCheckIpsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUptimeCheckIpsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUptimeCheckIpsRequest,
          ListUptimeCheckIpsResponse,
          UptimeCheckIp,
          ListUptimeCheckIpsPage,
          ListUptimeCheckIpsFixedSizeCollection> {

    private ListUptimeCheckIpsFixedSizeCollection(
        List<ListUptimeCheckIpsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUptimeCheckIpsFixedSizeCollection createEmptyCollection() {
      return new ListUptimeCheckIpsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUptimeCheckIpsFixedSizeCollection createCollection(
        List<ListUptimeCheckIpsPage> pages, int collectionSize) {
      return new ListUptimeCheckIpsFixedSizeCollection(pages, collectionSize);
    }
  }
}
