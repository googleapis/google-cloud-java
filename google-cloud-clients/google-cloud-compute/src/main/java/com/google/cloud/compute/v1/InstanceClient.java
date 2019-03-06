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
import com.google.cloud.compute.v1.stub.InstanceStub;
import com.google.cloud.compute.v1.stub.InstanceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
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
 * try (InstanceClient instanceClient = InstanceClient.create()) {
 *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
 *   String networkInterface = "";
 *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
 *   Operation response = instanceClient.addAccessConfigInstance(instance, networkInterface, accessConfigResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the instanceClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of InstanceSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * InstanceSettings instanceSettings =
 *     InstanceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InstanceClient instanceClient =
 *     InstanceClient.create(instanceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * InstanceSettings instanceSettings =
 *     InstanceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InstanceClient instanceClient =
 *     InstanceClient.create(instanceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InstanceClient implements BackgroundResource {
  private final InstanceSettings settings;
  private final InstanceStub stub;

  /** Constructs an instance of InstanceClient with default settings. */
  public static final InstanceClient create() throws IOException {
    return create(InstanceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InstanceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InstanceClient create(InstanceSettings settings) throws IOException {
    return new InstanceClient(settings);
  }

  /**
   * Constructs an instance of InstanceClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use InstanceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final InstanceClient create(InstanceStub stub) {
    return new InstanceClient(stub);
  }

  /**
   * Constructs an instance of InstanceClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected InstanceClient(InstanceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InstanceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected InstanceClient(InstanceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InstanceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InstanceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an access config to an instance's network interface.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
   *   Operation response = instanceClient.addAccessConfigInstance(instance, networkInterface, accessConfigResource);
   * }
   * </code></pre>
   *
   * @param instance The instance name for this request.
   * @param networkInterface The name of the network interface to add to this instance.
   * @param accessConfigResource An access configuration attached to an instance's network
   *     interface. Only one access config per instance is supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addAccessConfigInstance(
      ProjectZoneInstanceName instance,
      String networkInterface,
      AccessConfig accessConfigResource) {

    AddAccessConfigInstanceHttpRequest request =
        AddAccessConfigInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setNetworkInterface(networkInterface)
            .setAccessConfigResource(accessConfigResource)
            .build();
    return addAccessConfigInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an access config to an instance's network interface.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
   *   Operation response = instanceClient.addAccessConfigInstance(instance.toString(), networkInterface, accessConfigResource);
   * }
   * </code></pre>
   *
   * @param instance The instance name for this request.
   * @param networkInterface The name of the network interface to add to this instance.
   * @param accessConfigResource An access configuration attached to an instance's network
   *     interface. Only one access config per instance is supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addAccessConfigInstance(
      String instance, String networkInterface, AccessConfig accessConfigResource) {

    AddAccessConfigInstanceHttpRequest request =
        AddAccessConfigInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setNetworkInterface(networkInterface)
            .setAccessConfigResource(accessConfigResource)
            .build();
    return addAccessConfigInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an access config to an instance's network interface.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
   *   AddAccessConfigInstanceHttpRequest request = AddAccessConfigInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setNetworkInterface(networkInterface)
   *     .setAccessConfigResource(accessConfigResource)
   *     .build();
   *   Operation response = instanceClient.addAccessConfigInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation addAccessConfigInstance(AddAccessConfigInstanceHttpRequest request) {
    return addAccessConfigInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an access config to an instance's network interface.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
   *   AddAccessConfigInstanceHttpRequest request = AddAccessConfigInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setNetworkInterface(networkInterface)
   *     .setAccessConfigResource(accessConfigResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.addAccessConfigInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AddAccessConfigInstanceHttpRequest, Operation>
      addAccessConfigInstanceCallable() {
    return stub.addAccessConfigInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves aggregated list of all of the instances in your project across all regions and zones.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (InstancesScopedList element : instanceClient.aggregatedListInstances(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInstancesPagedResponse aggregatedListInstances(ProjectName project) {
    AggregatedListInstancesHttpRequest request =
        AggregatedListInstancesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves aggregated list of all of the instances in your project across all regions and zones.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (InstancesScopedList element : instanceClient.aggregatedListInstances(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInstancesPagedResponse aggregatedListInstances(String project) {
    AggregatedListInstancesHttpRequest request =
        AggregatedListInstancesHttpRequest.newBuilder().setProject(project).build();
    return aggregatedListInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves aggregated list of all of the instances in your project across all regions and zones.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListInstancesHttpRequest request = AggregatedListInstancesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (InstancesScopedList element : instanceClient.aggregatedListInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInstancesPagedResponse aggregatedListInstances(
      AggregatedListInstancesHttpRequest request) {
    return aggregatedListInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves aggregated list of all of the instances in your project across all regions and zones.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListInstancesHttpRequest request = AggregatedListInstancesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;AggregatedListInstancesPagedResponse&gt; future = instanceClient.aggregatedListInstancesPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstancesScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListInstancesHttpRequest, AggregatedListInstancesPagedResponse>
      aggregatedListInstancesPagedCallable() {
    return stub.aggregatedListInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves aggregated list of all of the instances in your project across all regions and zones.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   AggregatedListInstancesHttpRequest request = AggregatedListInstancesHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     InstanceAggregatedList response = instanceClient.aggregatedListInstancesCallable().call(request);
   *     for (InstancesScopedList element : response.getItemsMap()) {
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
  public final UnaryCallable<AggregatedListInstancesHttpRequest, InstanceAggregatedList>
      aggregatedListInstancesCallable() {
    return stub.aggregatedListInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attaches an existing Disk resource to an instance. You must first create the disk before you
   * can attach it. It is not possible to create and attach a disk at the same time. For more
   * information, read Adding a persistent disk to your instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Boolean forceAttach = false;
   *   AttachedDisk attachedDiskResource = AttachedDisk.newBuilder().build();
   *   Operation response = instanceClient.attachDiskInstance(instance, forceAttach, attachedDiskResource);
   * }
   * </code></pre>
   *
   * @param instance The instance name for this request.
   * @param forceAttach Whether to force attach the disk even if it's currently attached to another
   *     instance.
   * @param attachedDiskResource An instance-attached disk resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation attachDiskInstance(
      ProjectZoneInstanceName instance, Boolean forceAttach, AttachedDisk attachedDiskResource) {

    AttachDiskInstanceHttpRequest request =
        AttachDiskInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setForceAttach(forceAttach)
            .setAttachedDiskResource(attachedDiskResource)
            .build();
    return attachDiskInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attaches an existing Disk resource to an instance. You must first create the disk before you
   * can attach it. It is not possible to create and attach a disk at the same time. For more
   * information, read Adding a persistent disk to your instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Boolean forceAttach = false;
   *   AttachedDisk attachedDiskResource = AttachedDisk.newBuilder().build();
   *   Operation response = instanceClient.attachDiskInstance(instance.toString(), forceAttach, attachedDiskResource);
   * }
   * </code></pre>
   *
   * @param instance The instance name for this request.
   * @param forceAttach Whether to force attach the disk even if it's currently attached to another
   *     instance.
   * @param attachedDiskResource An instance-attached disk resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation attachDiskInstance(
      String instance, Boolean forceAttach, AttachedDisk attachedDiskResource) {

    AttachDiskInstanceHttpRequest request =
        AttachDiskInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setForceAttach(forceAttach)
            .setAttachedDiskResource(attachedDiskResource)
            .build();
    return attachDiskInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attaches an existing Disk resource to an instance. You must first create the disk before you
   * can attach it. It is not possible to create and attach a disk at the same time. For more
   * information, read Adding a persistent disk to your instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Boolean forceAttach = false;
   *   AttachedDisk attachedDiskResource = AttachedDisk.newBuilder().build();
   *   AttachDiskInstanceHttpRequest request = AttachDiskInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setForceAttach(forceAttach)
   *     .setAttachedDiskResource(attachedDiskResource)
   *     .build();
   *   Operation response = instanceClient.attachDiskInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation attachDiskInstance(AttachDiskInstanceHttpRequest request) {
    return attachDiskInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Attaches an existing Disk resource to an instance. You must first create the disk before you
   * can attach it. It is not possible to create and attach a disk at the same time. For more
   * information, read Adding a persistent disk to your instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Boolean forceAttach = false;
   *   AttachedDisk attachedDiskResource = AttachedDisk.newBuilder().build();
   *   AttachDiskInstanceHttpRequest request = AttachDiskInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setForceAttach(forceAttach)
   *     .setAttachedDiskResource(attachedDiskResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.attachDiskInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AttachDiskInstanceHttpRequest, Operation>
      attachDiskInstanceCallable() {
    return stub.attachDiskInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Instance resource. For more information, see Stopping or Deleting an
   * Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Operation response = instanceClient.deleteInstance(instance);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstance(ProjectZoneInstanceName instance) {

    DeleteInstanceHttpRequest request =
        DeleteInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .build();
    return deleteInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Instance resource. For more information, see Stopping or Deleting an
   * Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Operation response = instanceClient.deleteInstance(instance.toString());
   * }
   * </code></pre>
   *
   * @param instance Name of the instance resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstance(String instance) {

    DeleteInstanceHttpRequest request =
        DeleteInstanceHttpRequest.newBuilder().setInstance(instance).build();
    return deleteInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Instance resource. For more information, see Stopping or Deleting an
   * Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   DeleteInstanceHttpRequest request = DeleteInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   Operation response = instanceClient.deleteInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstance(DeleteInstanceHttpRequest request) {
    return deleteInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified Instance resource. For more information, see Stopping or Deleting an
   * Instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   DeleteInstanceHttpRequest request = DeleteInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.deleteInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteInstanceHttpRequest, Operation> deleteInstanceCallable() {
    return stub.deleteInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an access config from an instance's network interface.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   String accessConfig = "";
   *   Operation response = instanceClient.deleteAccessConfigInstance(instance, networkInterface, accessConfig);
   * }
   * </code></pre>
   *
   * @param instance The instance name for this request.
   * @param networkInterface The name of the network interface.
   * @param accessConfig The name of the access config to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteAccessConfigInstance(
      ProjectZoneInstanceName instance, String networkInterface, String accessConfig) {

    DeleteAccessConfigInstanceHttpRequest request =
        DeleteAccessConfigInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setNetworkInterface(networkInterface)
            .setAccessConfig(accessConfig)
            .build();
    return deleteAccessConfigInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an access config from an instance's network interface.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   String accessConfig = "";
   *   Operation response = instanceClient.deleteAccessConfigInstance(instance.toString(), networkInterface, accessConfig);
   * }
   * </code></pre>
   *
   * @param instance The instance name for this request.
   * @param networkInterface The name of the network interface.
   * @param accessConfig The name of the access config to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteAccessConfigInstance(
      String instance, String networkInterface, String accessConfig) {

    DeleteAccessConfigInstanceHttpRequest request =
        DeleteAccessConfigInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setNetworkInterface(networkInterface)
            .setAccessConfig(accessConfig)
            .build();
    return deleteAccessConfigInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an access config from an instance's network interface.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   String accessConfig = "";
   *   DeleteAccessConfigInstanceHttpRequest request = DeleteAccessConfigInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setNetworkInterface(networkInterface)
   *     .setAccessConfig(accessConfig)
   *     .build();
   *   Operation response = instanceClient.deleteAccessConfigInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteAccessConfigInstance(DeleteAccessConfigInstanceHttpRequest request) {
    return deleteAccessConfigInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an access config from an instance's network interface.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   String accessConfig = "";
   *   DeleteAccessConfigInstanceHttpRequest request = DeleteAccessConfigInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setNetworkInterface(networkInterface)
   *     .setAccessConfig(accessConfig)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.deleteAccessConfigInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteAccessConfigInstanceHttpRequest, Operation>
      deleteAccessConfigInstanceCallable() {
    return stub.deleteAccessConfigInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detaches a disk from an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String deviceName = "";
   *   Operation response = instanceClient.detachDiskInstance(instance, deviceName);
   * }
   * </code></pre>
   *
   * @param instance Instance name for this request.
   * @param deviceName The device name of the disk to detach. Make a get() request on the instance
   *     to view currently attached disks and device names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation detachDiskInstance(ProjectZoneInstanceName instance, String deviceName) {

    DetachDiskInstanceHttpRequest request =
        DetachDiskInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setDeviceName(deviceName)
            .build();
    return detachDiskInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detaches a disk from an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String deviceName = "";
   *   Operation response = instanceClient.detachDiskInstance(instance.toString(), deviceName);
   * }
   * </code></pre>
   *
   * @param instance Instance name for this request.
   * @param deviceName The device name of the disk to detach. Make a get() request on the instance
   *     to view currently attached disks and device names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation detachDiskInstance(String instance, String deviceName) {

    DetachDiskInstanceHttpRequest request =
        DetachDiskInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setDeviceName(deviceName)
            .build();
    return detachDiskInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detaches a disk from an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String deviceName = "";
   *   DetachDiskInstanceHttpRequest request = DetachDiskInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setDeviceName(deviceName)
   *     .build();
   *   Operation response = instanceClient.detachDiskInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation detachDiskInstance(DetachDiskInstanceHttpRequest request) {
    return detachDiskInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Detaches a disk from an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String deviceName = "";
   *   DetachDiskInstanceHttpRequest request = DetachDiskInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setDeviceName(deviceName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.detachDiskInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DetachDiskInstanceHttpRequest, Operation>
      detachDiskInstanceCallable() {
    return stub.detachDiskInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Instance resource. Gets a list of available instances by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Instance response = instanceClient.getInstance(instance);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Instance getInstance(ProjectZoneInstanceName instance) {

    GetInstanceHttpRequest request =
        GetInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Instance resource. Gets a list of available instances by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Instance response = instanceClient.getInstance(instance.toString());
   * }
   * </code></pre>
   *
   * @param instance Name of the instance resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Instance getInstance(String instance) {

    GetInstanceHttpRequest request =
        GetInstanceHttpRequest.newBuilder().setInstance(instance).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Instance resource. Gets a list of available instances by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   GetInstanceHttpRequest request = GetInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   Instance response = instanceClient.getInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Instance getInstance(GetInstanceHttpRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified Instance resource. Gets a list of available instances by making a list()
   * request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   GetInstanceHttpRequest request = GetInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   ApiFuture&lt;Instance&gt; future = instanceClient.getInstanceCallable().futureCall(request);
   *   // Do something
   *   Instance response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetInstanceHttpRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   Policy response = instanceClient.getIamPolicyInstance(resource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyInstance(ProjectZoneInstanceResourceName resource) {

    GetIamPolicyInstanceHttpRequest request =
        GetIamPolicyInstanceHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicyInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   Policy response = instanceClient.getIamPolicyInstance(resource.toString());
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyInstance(String resource) {

    GetIamPolicyInstanceHttpRequest request =
        GetIamPolicyInstanceHttpRequest.newBuilder().setResource(resource).build();
    return getIamPolicyInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   GetIamPolicyInstanceHttpRequest request = GetIamPolicyInstanceHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .build();
   *   Policy response = instanceClient.getIamPolicyInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy getIamPolicyInstance(GetIamPolicyInstanceHttpRequest request) {
    return getIamPolicyInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   GetIamPolicyInstanceHttpRequest request = GetIamPolicyInstanceHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = instanceClient.getIamPolicyInstanceCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetIamPolicyInstanceHttpRequest, Policy>
      getIamPolicyInstanceCallable() {
    return stub.getIamPolicyInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the last 1 MB of serial port output from the specified instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Integer port = 0;
   *   String start = "";
   *   SerialPortOutput response = instanceClient.getSerialPortOutputInstance(instance, port, start);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @param port Specifies which COM or serial port to retrieve data from.
   * @param start Returns output starting from a specific byte position. Use this to page through
   *     output when the output is too large to return in a single request. For the initial request,
   *     leave this field unspecified. For subsequent calls, this field should be set to the next
   *     value returned in the previous call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final SerialPortOutput getSerialPortOutputInstance(
      ProjectZoneInstanceName instance, Integer port, String start) {

    GetSerialPortOutputInstanceHttpRequest request =
        GetSerialPortOutputInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setPort(port)
            .setStart(start)
            .build();
    return getSerialPortOutputInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the last 1 MB of serial port output from the specified instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Integer port = 0;
   *   String start = "";
   *   SerialPortOutput response = instanceClient.getSerialPortOutputInstance(instance.toString(), port, start);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @param port Specifies which COM or serial port to retrieve data from.
   * @param start Returns output starting from a specific byte position. Use this to page through
   *     output when the output is too large to return in a single request. For the initial request,
   *     leave this field unspecified. For subsequent calls, this field should be set to the next
   *     value returned in the previous call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final SerialPortOutput getSerialPortOutputInstance(
      String instance, Integer port, String start) {

    GetSerialPortOutputInstanceHttpRequest request =
        GetSerialPortOutputInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setPort(port)
            .setStart(start)
            .build();
    return getSerialPortOutputInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the last 1 MB of serial port output from the specified instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Integer port = 0;
   *   String start = "";
   *   GetSerialPortOutputInstanceHttpRequest request = GetSerialPortOutputInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setPort(port)
   *     .setStart(start)
   *     .build();
   *   SerialPortOutput response = instanceClient.getSerialPortOutputInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final SerialPortOutput getSerialPortOutputInstance(
      GetSerialPortOutputInstanceHttpRequest request) {
    return getSerialPortOutputInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the last 1 MB of serial port output from the specified instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Integer port = 0;
   *   String start = "";
   *   GetSerialPortOutputInstanceHttpRequest request = GetSerialPortOutputInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setPort(port)
   *     .setStart(start)
   *     .build();
   *   ApiFuture&lt;SerialPortOutput&gt; future = instanceClient.getSerialPortOutputInstanceCallable().futureCall(request);
   *   // Do something
   *   SerialPortOutput response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetSerialPortOutputInstanceHttpRequest, SerialPortOutput>
      getSerialPortOutputInstanceCallable() {
    return stub.getSerialPortOutputInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an instance resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   Instance instanceResource = Instance.newBuilder().build();
   *   Operation response = instanceClient.insertInstance(zone, instanceResource);
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @param instanceResource An Instance resource. (== resource_for beta.instances ==) (==
   *     resource_for v1.instances ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInstance(ProjectZoneName zone, Instance instanceResource) {

    InsertInstanceHttpRequest request =
        InsertInstanceHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .setInstanceResource(instanceResource)
            .build();
    return insertInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an instance resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   Instance instanceResource = Instance.newBuilder().build();
   *   Operation response = instanceClient.insertInstance(zone.toString(), instanceResource);
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @param instanceResource An Instance resource. (== resource_for beta.instances ==) (==
   *     resource_for v1.instances ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInstance(String zone, Instance instanceResource) {

    InsertInstanceHttpRequest request =
        InsertInstanceHttpRequest.newBuilder()
            .setZone(zone)
            .setInstanceResource(instanceResource)
            .build();
    return insertInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an instance resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   Instance instanceResource = Instance.newBuilder().build();
   *   InsertInstanceHttpRequest request = InsertInstanceHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .setInstanceResource(instanceResource)
   *     .build();
   *   Operation response = instanceClient.insertInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInstance(InsertInstanceHttpRequest request) {
    return insertInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an instance resource in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   Instance instanceResource = Instance.newBuilder().build();
   *   InsertInstanceHttpRequest request = InsertInstanceHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .setInstanceResource(instanceResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.insertInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertInstanceHttpRequest, Operation> insertInstanceCallable() {
    return stub.insertInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instances contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (Instance element : instanceClient.listInstances(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstancesPagedResponse listInstances(ProjectZoneName zone) {
    ListInstancesHttpRequest request =
        ListInstancesHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instances contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (Instance element : instanceClient.listInstances(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstancesPagedResponse listInstances(String zone) {
    ListInstancesHttpRequest request = ListInstancesHttpRequest.newBuilder().setZone(zone).build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instances contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListInstancesHttpRequest request = ListInstancesHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   for (Instance element : instanceClient.listInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstancesPagedResponse listInstances(ListInstancesHttpRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instances contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListInstancesHttpRequest request = ListInstancesHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   ApiFuture&lt;ListInstancesPagedResponse&gt; future = instanceClient.listInstancesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Instance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListInstancesHttpRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of instances contained within the specified zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   ListInstancesHttpRequest request = ListInstancesHttpRequest.newBuilder()
   *     .setZone(zone.toString())
   *     .build();
   *   while (true) {
   *     InstanceList response = instanceClient.listInstancesCallable().call(request);
   *     for (Instance element : response.getItemsList()) {
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
  public final UnaryCallable<ListInstancesHttpRequest, InstanceList> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of referrers to instances contained within the specified zone. For more
   * information, read Viewing Referrers to VM Instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   for (Reference element : instanceClient.listReferrersInstances(instance).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param instance Name of the target instance scoping this request, or '-' if the request should
   *     span over all instances in the container.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListReferrersInstancesPagedResponse listReferrersInstances(
      ProjectZoneInstanceName instance) {
    ListReferrersInstancesHttpRequest request =
        ListReferrersInstancesHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .build();
    return listReferrersInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of referrers to instances contained within the specified zone. For more
   * information, read Viewing Referrers to VM Instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   for (Reference element : instanceClient.listReferrersInstances(instance.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param instance Name of the target instance scoping this request, or '-' if the request should
   *     span over all instances in the container.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListReferrersInstancesPagedResponse listReferrersInstances(String instance) {
    ListReferrersInstancesHttpRequest request =
        ListReferrersInstancesHttpRequest.newBuilder().setInstance(instance).build();
    return listReferrersInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of referrers to instances contained within the specified zone. For more
   * information, read Viewing Referrers to VM Instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   ListReferrersInstancesHttpRequest request = ListReferrersInstancesHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   for (Reference element : instanceClient.listReferrersInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListReferrersInstancesPagedResponse listReferrersInstances(
      ListReferrersInstancesHttpRequest request) {
    return listReferrersInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of referrers to instances contained within the specified zone. For more
   * information, read Viewing Referrers to VM Instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   ListReferrersInstancesHttpRequest request = ListReferrersInstancesHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   ApiFuture&lt;ListReferrersInstancesPagedResponse&gt; future = instanceClient.listReferrersInstancesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Reference element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListReferrersInstancesHttpRequest, ListReferrersInstancesPagedResponse>
      listReferrersInstancesPagedCallable() {
    return stub.listReferrersInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of referrers to instances contained within the specified zone. For more
   * information, read Viewing Referrers to VM Instances.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   ListReferrersInstancesHttpRequest request = ListReferrersInstancesHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   while (true) {
   *     InstanceListReferrers response = instanceClient.listReferrersInstancesCallable().call(request);
   *     for (Reference element : response.getItemsList()) {
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
  public final UnaryCallable<ListReferrersInstancesHttpRequest, InstanceListReferrers>
      listReferrersInstancesCallable() {
    return stub.listReferrersInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs a reset on the instance. This is a hard reset the VM does not do a graceful shutdown.
   * For more information, see Resetting an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Operation response = instanceClient.resetInstance(instance);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resetInstance(ProjectZoneInstanceName instance) {

    ResetInstanceHttpRequest request =
        ResetInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .build();
    return resetInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs a reset on the instance. This is a hard reset the VM does not do a graceful shutdown.
   * For more information, see Resetting an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Operation response = instanceClient.resetInstance(instance.toString());
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resetInstance(String instance) {

    ResetInstanceHttpRequest request =
        ResetInstanceHttpRequest.newBuilder().setInstance(instance).build();
    return resetInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs a reset on the instance. This is a hard reset the VM does not do a graceful shutdown.
   * For more information, see Resetting an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   ResetInstanceHttpRequest request = ResetInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   Operation response = instanceClient.resetInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resetInstance(ResetInstanceHttpRequest request) {
    return resetInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Performs a reset on the instance. This is a hard reset the VM does not do a graceful shutdown.
   * For more information, see Resetting an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   ResetInstanceHttpRequest request = ResetInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.resetInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ResetInstanceHttpRequest, Operation> resetInstanceCallable() {
    return stub.resetInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets deletion protection on the instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   Boolean deletionProtection = false;
   *   Operation response = instanceClient.setDeletionProtectionInstance(resource, deletionProtection);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param deletionProtection Whether the resource should be protected against deletion.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setDeletionProtectionInstance(
      ProjectZoneInstanceResourceName resource, Boolean deletionProtection) {

    SetDeletionProtectionInstanceHttpRequest request =
        SetDeletionProtectionInstanceHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setDeletionProtection(deletionProtection)
            .build();
    return setDeletionProtectionInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets deletion protection on the instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   Boolean deletionProtection = false;
   *   Operation response = instanceClient.setDeletionProtectionInstance(resource.toString(), deletionProtection);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param deletionProtection Whether the resource should be protected against deletion.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setDeletionProtectionInstance(
      String resource, Boolean deletionProtection) {

    SetDeletionProtectionInstanceHttpRequest request =
        SetDeletionProtectionInstanceHttpRequest.newBuilder()
            .setResource(resource)
            .setDeletionProtection(deletionProtection)
            .build();
    return setDeletionProtectionInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets deletion protection on the instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   Boolean deletionProtection = false;
   *   SetDeletionProtectionInstanceHttpRequest request = SetDeletionProtectionInstanceHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setDeletionProtection(deletionProtection)
   *     .build();
   *   Operation response = instanceClient.setDeletionProtectionInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setDeletionProtectionInstance(
      SetDeletionProtectionInstanceHttpRequest request) {
    return setDeletionProtectionInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets deletion protection on the instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   Boolean deletionProtection = false;
   *   SetDeletionProtectionInstanceHttpRequest request = SetDeletionProtectionInstanceHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setDeletionProtection(deletionProtection)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.setDeletionProtectionInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetDeletionProtectionInstanceHttpRequest, Operation>
      setDeletionProtectionInstanceCallable() {
    return stub.setDeletionProtectionInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the auto-delete flag for a disk attached to an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Boolean autoDelete = false;
   *   String deviceName = "";
   *   Operation response = instanceClient.setDiskAutoDeleteInstance(instance, autoDelete, deviceName);
   * }
   * </code></pre>
   *
   * @param instance The instance name for this request.
   * @param autoDelete Whether to auto-delete the disk when the instance is deleted.
   * @param deviceName The device name of the disk to modify. Make a get() request on the instance
   *     to view currently attached disks and device names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setDiskAutoDeleteInstance(
      ProjectZoneInstanceName instance, Boolean autoDelete, String deviceName) {

    SetDiskAutoDeleteInstanceHttpRequest request =
        SetDiskAutoDeleteInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setAutoDelete(autoDelete)
            .setDeviceName(deviceName)
            .build();
    return setDiskAutoDeleteInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the auto-delete flag for a disk attached to an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Boolean autoDelete = false;
   *   String deviceName = "";
   *   Operation response = instanceClient.setDiskAutoDeleteInstance(instance.toString(), autoDelete, deviceName);
   * }
   * </code></pre>
   *
   * @param instance The instance name for this request.
   * @param autoDelete Whether to auto-delete the disk when the instance is deleted.
   * @param deviceName The device name of the disk to modify. Make a get() request on the instance
   *     to view currently attached disks and device names.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setDiskAutoDeleteInstance(
      String instance, Boolean autoDelete, String deviceName) {

    SetDiskAutoDeleteInstanceHttpRequest request =
        SetDiskAutoDeleteInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setAutoDelete(autoDelete)
            .setDeviceName(deviceName)
            .build();
    return setDiskAutoDeleteInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the auto-delete flag for a disk attached to an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Boolean autoDelete = false;
   *   String deviceName = "";
   *   SetDiskAutoDeleteInstanceHttpRequest request = SetDiskAutoDeleteInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setAutoDelete(autoDelete)
   *     .setDeviceName(deviceName)
   *     .build();
   *   Operation response = instanceClient.setDiskAutoDeleteInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setDiskAutoDeleteInstance(SetDiskAutoDeleteInstanceHttpRequest request) {
    return setDiskAutoDeleteInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the auto-delete flag for a disk attached to an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Boolean autoDelete = false;
   *   String deviceName = "";
   *   SetDiskAutoDeleteInstanceHttpRequest request = SetDiskAutoDeleteInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setAutoDelete(autoDelete)
   *     .setDeviceName(deviceName)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.setDiskAutoDeleteInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetDiskAutoDeleteInstanceHttpRequest, Operation>
      setDiskAutoDeleteInstanceCallable() {
    return stub.setDiskAutoDeleteInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();
   *   Policy response = instanceClient.setIamPolicyInstance(resource, zoneSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param zoneSetPolicyRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyInstance(
      ProjectZoneInstanceResourceName resource, ZoneSetPolicyRequest zoneSetPolicyRequestResource) {

    SetIamPolicyInstanceHttpRequest request =
        SetIamPolicyInstanceHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setZoneSetPolicyRequestResource(zoneSetPolicyRequestResource)
            .build();
    return setIamPolicyInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();
   *   Policy response = instanceClient.setIamPolicyInstance(resource.toString(), zoneSetPolicyRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param zoneSetPolicyRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyInstance(
      String resource, ZoneSetPolicyRequest zoneSetPolicyRequestResource) {

    SetIamPolicyInstanceHttpRequest request =
        SetIamPolicyInstanceHttpRequest.newBuilder()
            .setResource(resource)
            .setZoneSetPolicyRequestResource(zoneSetPolicyRequestResource)
            .build();
    return setIamPolicyInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();
   *   SetIamPolicyInstanceHttpRequest request = SetIamPolicyInstanceHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setZoneSetPolicyRequestResource(zoneSetPolicyRequestResource)
   *     .build();
   *   Policy response = instanceClient.setIamPolicyInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Policy setIamPolicyInstance(SetIamPolicyInstanceHttpRequest request) {
    return setIamPolicyInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   ZoneSetPolicyRequest zoneSetPolicyRequestResource = ZoneSetPolicyRequest.newBuilder().build();
   *   SetIamPolicyInstanceHttpRequest request = SetIamPolicyInstanceHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setZoneSetPolicyRequestResource(zoneSetPolicyRequestResource)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = instanceClient.setIamPolicyInstanceCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetIamPolicyInstanceHttpRequest, Policy>
      setIamPolicyInstanceCallable() {
    return stub.setIamPolicyInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets labels on an instance. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetLabelsRequest instancesSetLabelsRequestResource = InstancesSetLabelsRequest.newBuilder().build();
   *   Operation response = instanceClient.setLabelsInstance(instance, instancesSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @param instancesSetLabelsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsInstance(
      ProjectZoneInstanceName instance,
      InstancesSetLabelsRequest instancesSetLabelsRequestResource) {

    SetLabelsInstanceHttpRequest request =
        SetLabelsInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setInstancesSetLabelsRequestResource(instancesSetLabelsRequestResource)
            .build();
    return setLabelsInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets labels on an instance. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetLabelsRequest instancesSetLabelsRequestResource = InstancesSetLabelsRequest.newBuilder().build();
   *   Operation response = instanceClient.setLabelsInstance(instance.toString(), instancesSetLabelsRequestResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @param instancesSetLabelsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsInstance(
      String instance, InstancesSetLabelsRequest instancesSetLabelsRequestResource) {

    SetLabelsInstanceHttpRequest request =
        SetLabelsInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setInstancesSetLabelsRequestResource(instancesSetLabelsRequestResource)
            .build();
    return setLabelsInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets labels on an instance. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetLabelsRequest instancesSetLabelsRequestResource = InstancesSetLabelsRequest.newBuilder().build();
   *   SetLabelsInstanceHttpRequest request = SetLabelsInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setInstancesSetLabelsRequestResource(instancesSetLabelsRequestResource)
   *     .build();
   *   Operation response = instanceClient.setLabelsInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setLabelsInstance(SetLabelsInstanceHttpRequest request) {
    return setLabelsInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets labels on an instance. To learn more about labels, read the Labeling Resources
   * documentation.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetLabelsRequest instancesSetLabelsRequestResource = InstancesSetLabelsRequest.newBuilder().build();
   *   SetLabelsInstanceHttpRequest request = SetLabelsInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setInstancesSetLabelsRequestResource(instancesSetLabelsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.setLabelsInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetLabelsInstanceHttpRequest, Operation> setLabelsInstanceCallable() {
    return stub.setLabelsInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the number and/or type of accelerator for a stopped instance to the values specified in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetMachineResourcesRequest instancesSetMachineResourcesRequestResource = InstancesSetMachineResourcesRequest.newBuilder().build();
   *   Operation response = instanceClient.setMachineResourcesInstance(instance, instancesSetMachineResourcesRequestResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @param instancesSetMachineResourcesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setMachineResourcesInstance(
      ProjectZoneInstanceName instance,
      InstancesSetMachineResourcesRequest instancesSetMachineResourcesRequestResource) {

    SetMachineResourcesInstanceHttpRequest request =
        SetMachineResourcesInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setInstancesSetMachineResourcesRequestResource(
                instancesSetMachineResourcesRequestResource)
            .build();
    return setMachineResourcesInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the number and/or type of accelerator for a stopped instance to the values specified in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetMachineResourcesRequest instancesSetMachineResourcesRequestResource = InstancesSetMachineResourcesRequest.newBuilder().build();
   *   Operation response = instanceClient.setMachineResourcesInstance(instance.toString(), instancesSetMachineResourcesRequestResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @param instancesSetMachineResourcesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setMachineResourcesInstance(
      String instance,
      InstancesSetMachineResourcesRequest instancesSetMachineResourcesRequestResource) {

    SetMachineResourcesInstanceHttpRequest request =
        SetMachineResourcesInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setInstancesSetMachineResourcesRequestResource(
                instancesSetMachineResourcesRequestResource)
            .build();
    return setMachineResourcesInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the number and/or type of accelerator for a stopped instance to the values specified in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetMachineResourcesRequest instancesSetMachineResourcesRequestResource = InstancesSetMachineResourcesRequest.newBuilder().build();
   *   SetMachineResourcesInstanceHttpRequest request = SetMachineResourcesInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setInstancesSetMachineResourcesRequestResource(instancesSetMachineResourcesRequestResource)
   *     .build();
   *   Operation response = instanceClient.setMachineResourcesInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setMachineResourcesInstance(
      SetMachineResourcesInstanceHttpRequest request) {
    return setMachineResourcesInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the number and/or type of accelerator for a stopped instance to the values specified in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetMachineResourcesRequest instancesSetMachineResourcesRequestResource = InstancesSetMachineResourcesRequest.newBuilder().build();
   *   SetMachineResourcesInstanceHttpRequest request = SetMachineResourcesInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setInstancesSetMachineResourcesRequestResource(instancesSetMachineResourcesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.setMachineResourcesInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetMachineResourcesInstanceHttpRequest, Operation>
      setMachineResourcesInstanceCallable() {
    return stub.setMachineResourcesInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the machine type for a stopped instance to the machine type specified in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetMachineTypeRequest instancesSetMachineTypeRequestResource = InstancesSetMachineTypeRequest.newBuilder().build();
   *   Operation response = instanceClient.setMachineTypeInstance(instance, instancesSetMachineTypeRequestResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @param instancesSetMachineTypeRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setMachineTypeInstance(
      ProjectZoneInstanceName instance,
      InstancesSetMachineTypeRequest instancesSetMachineTypeRequestResource) {

    SetMachineTypeInstanceHttpRequest request =
        SetMachineTypeInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setInstancesSetMachineTypeRequestResource(instancesSetMachineTypeRequestResource)
            .build();
    return setMachineTypeInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the machine type for a stopped instance to the machine type specified in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetMachineTypeRequest instancesSetMachineTypeRequestResource = InstancesSetMachineTypeRequest.newBuilder().build();
   *   Operation response = instanceClient.setMachineTypeInstance(instance.toString(), instancesSetMachineTypeRequestResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @param instancesSetMachineTypeRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setMachineTypeInstance(
      String instance, InstancesSetMachineTypeRequest instancesSetMachineTypeRequestResource) {

    SetMachineTypeInstanceHttpRequest request =
        SetMachineTypeInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setInstancesSetMachineTypeRequestResource(instancesSetMachineTypeRequestResource)
            .build();
    return setMachineTypeInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the machine type for a stopped instance to the machine type specified in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetMachineTypeRequest instancesSetMachineTypeRequestResource = InstancesSetMachineTypeRequest.newBuilder().build();
   *   SetMachineTypeInstanceHttpRequest request = SetMachineTypeInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setInstancesSetMachineTypeRequestResource(instancesSetMachineTypeRequestResource)
   *     .build();
   *   Operation response = instanceClient.setMachineTypeInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setMachineTypeInstance(SetMachineTypeInstanceHttpRequest request) {
    return setMachineTypeInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the machine type for a stopped instance to the machine type specified in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetMachineTypeRequest instancesSetMachineTypeRequestResource = InstancesSetMachineTypeRequest.newBuilder().build();
   *   SetMachineTypeInstanceHttpRequest request = SetMachineTypeInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setInstancesSetMachineTypeRequestResource(instancesSetMachineTypeRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.setMachineTypeInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetMachineTypeInstanceHttpRequest, Operation>
      setMachineTypeInstanceCallable() {
    return stub.setMachineTypeInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets metadata for the specified instance to the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Metadata metadataResource = Metadata.newBuilder().build();
   *   Operation response = instanceClient.setMetadataInstance(instance, metadataResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @param metadataResource A metadata key/value entry.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setMetadataInstance(
      ProjectZoneInstanceName instance, Metadata metadataResource) {

    SetMetadataInstanceHttpRequest request =
        SetMetadataInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setMetadataResource(metadataResource)
            .build();
    return setMetadataInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets metadata for the specified instance to the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Metadata metadataResource = Metadata.newBuilder().build();
   *   Operation response = instanceClient.setMetadataInstance(instance.toString(), metadataResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @param metadataResource A metadata key/value entry.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setMetadataInstance(String instance, Metadata metadataResource) {

    SetMetadataInstanceHttpRequest request =
        SetMetadataInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setMetadataResource(metadataResource)
            .build();
    return setMetadataInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets metadata for the specified instance to the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Metadata metadataResource = Metadata.newBuilder().build();
   *   SetMetadataInstanceHttpRequest request = SetMetadataInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setMetadataResource(metadataResource)
   *     .build();
   *   Operation response = instanceClient.setMetadataInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setMetadataInstance(SetMetadataInstanceHttpRequest request) {
    return setMetadataInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets metadata for the specified instance to the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Metadata metadataResource = Metadata.newBuilder().build();
   *   SetMetadataInstanceHttpRequest request = SetMetadataInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setMetadataResource(metadataResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.setMetadataInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetMetadataInstanceHttpRequest, Operation>
      setMetadataInstanceCallable() {
    return stub.setMetadataInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the minimum CPU platform that this instance should use. This method can only be called
   * on a stopped instance. For more information, read Specifying a Minimum CPU Platform.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetMinCpuPlatformRequest instancesSetMinCpuPlatformRequestResource = InstancesSetMinCpuPlatformRequest.newBuilder().build();
   *   Operation response = instanceClient.setMinCpuPlatformInstance(instance, instancesSetMinCpuPlatformRequestResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @param instancesSetMinCpuPlatformRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setMinCpuPlatformInstance(
      ProjectZoneInstanceName instance,
      InstancesSetMinCpuPlatformRequest instancesSetMinCpuPlatformRequestResource) {

    SetMinCpuPlatformInstanceHttpRequest request =
        SetMinCpuPlatformInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setInstancesSetMinCpuPlatformRequestResource(instancesSetMinCpuPlatformRequestResource)
            .build();
    return setMinCpuPlatformInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the minimum CPU platform that this instance should use. This method can only be called
   * on a stopped instance. For more information, read Specifying a Minimum CPU Platform.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetMinCpuPlatformRequest instancesSetMinCpuPlatformRequestResource = InstancesSetMinCpuPlatformRequest.newBuilder().build();
   *   Operation response = instanceClient.setMinCpuPlatformInstance(instance.toString(), instancesSetMinCpuPlatformRequestResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @param instancesSetMinCpuPlatformRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setMinCpuPlatformInstance(
      String instance,
      InstancesSetMinCpuPlatformRequest instancesSetMinCpuPlatformRequestResource) {

    SetMinCpuPlatformInstanceHttpRequest request =
        SetMinCpuPlatformInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setInstancesSetMinCpuPlatformRequestResource(instancesSetMinCpuPlatformRequestResource)
            .build();
    return setMinCpuPlatformInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the minimum CPU platform that this instance should use. This method can only be called
   * on a stopped instance. For more information, read Specifying a Minimum CPU Platform.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetMinCpuPlatformRequest instancesSetMinCpuPlatformRequestResource = InstancesSetMinCpuPlatformRequest.newBuilder().build();
   *   SetMinCpuPlatformInstanceHttpRequest request = SetMinCpuPlatformInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setInstancesSetMinCpuPlatformRequestResource(instancesSetMinCpuPlatformRequestResource)
   *     .build();
   *   Operation response = instanceClient.setMinCpuPlatformInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setMinCpuPlatformInstance(SetMinCpuPlatformInstanceHttpRequest request) {
    return setMinCpuPlatformInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Changes the minimum CPU platform that this instance should use. This method can only be called
   * on a stopped instance. For more information, read Specifying a Minimum CPU Platform.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetMinCpuPlatformRequest instancesSetMinCpuPlatformRequestResource = InstancesSetMinCpuPlatformRequest.newBuilder().build();
   *   SetMinCpuPlatformInstanceHttpRequest request = SetMinCpuPlatformInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setInstancesSetMinCpuPlatformRequestResource(instancesSetMinCpuPlatformRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.setMinCpuPlatformInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetMinCpuPlatformInstanceHttpRequest, Operation>
      setMinCpuPlatformInstanceCallable() {
    return stub.setMinCpuPlatformInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets an instance's scheduling options.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Scheduling schedulingResource = Scheduling.newBuilder().build();
   *   Operation response = instanceClient.setSchedulingInstance(instance, schedulingResource);
   * }
   * </code></pre>
   *
   * @param instance Instance name for this request.
   * @param schedulingResource Sets the scheduling options for an Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setSchedulingInstance(
      ProjectZoneInstanceName instance, Scheduling schedulingResource) {

    SetSchedulingInstanceHttpRequest request =
        SetSchedulingInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setSchedulingResource(schedulingResource)
            .build();
    return setSchedulingInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets an instance's scheduling options.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Scheduling schedulingResource = Scheduling.newBuilder().build();
   *   Operation response = instanceClient.setSchedulingInstance(instance.toString(), schedulingResource);
   * }
   * </code></pre>
   *
   * @param instance Instance name for this request.
   * @param schedulingResource Sets the scheduling options for an Instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setSchedulingInstance(String instance, Scheduling schedulingResource) {

    SetSchedulingInstanceHttpRequest request =
        SetSchedulingInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setSchedulingResource(schedulingResource)
            .build();
    return setSchedulingInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets an instance's scheduling options.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Scheduling schedulingResource = Scheduling.newBuilder().build();
   *   SetSchedulingInstanceHttpRequest request = SetSchedulingInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setSchedulingResource(schedulingResource)
   *     .build();
   *   Operation response = instanceClient.setSchedulingInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setSchedulingInstance(SetSchedulingInstanceHttpRequest request) {
    return setSchedulingInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets an instance's scheduling options.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Scheduling schedulingResource = Scheduling.newBuilder().build();
   *   SetSchedulingInstanceHttpRequest request = SetSchedulingInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setSchedulingResource(schedulingResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.setSchedulingInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetSchedulingInstanceHttpRequest, Operation>
      setSchedulingInstanceCallable() {
    return stub.setSchedulingInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the service account on the instance. For more information, read Changing the service
   * account and access scopes for an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetServiceAccountRequest instancesSetServiceAccountRequestResource = InstancesSetServiceAccountRequest.newBuilder().build();
   *   Operation response = instanceClient.setServiceAccountInstance(instance, instancesSetServiceAccountRequestResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance resource to start.
   * @param instancesSetServiceAccountRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setServiceAccountInstance(
      ProjectZoneInstanceName instance,
      InstancesSetServiceAccountRequest instancesSetServiceAccountRequestResource) {

    SetServiceAccountInstanceHttpRequest request =
        SetServiceAccountInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setInstancesSetServiceAccountRequestResource(instancesSetServiceAccountRequestResource)
            .build();
    return setServiceAccountInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the service account on the instance. For more information, read Changing the service
   * account and access scopes for an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetServiceAccountRequest instancesSetServiceAccountRequestResource = InstancesSetServiceAccountRequest.newBuilder().build();
   *   Operation response = instanceClient.setServiceAccountInstance(instance.toString(), instancesSetServiceAccountRequestResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance resource to start.
   * @param instancesSetServiceAccountRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setServiceAccountInstance(
      String instance,
      InstancesSetServiceAccountRequest instancesSetServiceAccountRequestResource) {

    SetServiceAccountInstanceHttpRequest request =
        SetServiceAccountInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setInstancesSetServiceAccountRequestResource(instancesSetServiceAccountRequestResource)
            .build();
    return setServiceAccountInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the service account on the instance. For more information, read Changing the service
   * account and access scopes for an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetServiceAccountRequest instancesSetServiceAccountRequestResource = InstancesSetServiceAccountRequest.newBuilder().build();
   *   SetServiceAccountInstanceHttpRequest request = SetServiceAccountInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setInstancesSetServiceAccountRequestResource(instancesSetServiceAccountRequestResource)
   *     .build();
   *   Operation response = instanceClient.setServiceAccountInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setServiceAccountInstance(SetServiceAccountInstanceHttpRequest request) {
    return setServiceAccountInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the service account on the instance. For more information, read Changing the service
   * account and access scopes for an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesSetServiceAccountRequest instancesSetServiceAccountRequestResource = InstancesSetServiceAccountRequest.newBuilder().build();
   *   SetServiceAccountInstanceHttpRequest request = SetServiceAccountInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setInstancesSetServiceAccountRequestResource(instancesSetServiceAccountRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.setServiceAccountInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetServiceAccountInstanceHttpRequest, Operation>
      setServiceAccountInstanceCallable() {
    return stub.setServiceAccountInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets network tags for the specified instance to the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Tags tagsResource = Tags.newBuilder().build();
   *   Operation response = instanceClient.setTagsInstance(instance, tagsResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @param tagsResource A set of instance tags.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTagsInstance(ProjectZoneInstanceName instance, Tags tagsResource) {

    SetTagsInstanceHttpRequest request =
        SetTagsInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setTagsResource(tagsResource)
            .build();
    return setTagsInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets network tags for the specified instance to the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Tags tagsResource = Tags.newBuilder().build();
   *   Operation response = instanceClient.setTagsInstance(instance.toString(), tagsResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @param tagsResource A set of instance tags.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTagsInstance(String instance, Tags tagsResource) {

    SetTagsInstanceHttpRequest request =
        SetTagsInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setTagsResource(tagsResource)
            .build();
    return setTagsInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets network tags for the specified instance to the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Tags tagsResource = Tags.newBuilder().build();
   *   SetTagsInstanceHttpRequest request = SetTagsInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setTagsResource(tagsResource)
   *     .build();
   *   Operation response = instanceClient.setTagsInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTagsInstance(SetTagsInstanceHttpRequest request) {
    return setTagsInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets network tags for the specified instance to the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Tags tagsResource = Tags.newBuilder().build();
   *   SetTagsInstanceHttpRequest request = SetTagsInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setTagsResource(tagsResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.setTagsInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetTagsInstanceHttpRequest, Operation> setTagsInstanceCallable() {
    return stub.setTagsInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Simulates a maintenance event on the instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Operation response = instanceClient.simulateMaintenanceEventInstance(instance);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation simulateMaintenanceEventInstance(ProjectZoneInstanceName instance) {

    SimulateMaintenanceEventInstanceHttpRequest request =
        SimulateMaintenanceEventInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .build();
    return simulateMaintenanceEventInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Simulates a maintenance event on the instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Operation response = instanceClient.simulateMaintenanceEventInstance(instance.toString());
   * }
   * </code></pre>
   *
   * @param instance Name of the instance scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation simulateMaintenanceEventInstance(String instance) {

    SimulateMaintenanceEventInstanceHttpRequest request =
        SimulateMaintenanceEventInstanceHttpRequest.newBuilder().setInstance(instance).build();
    return simulateMaintenanceEventInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Simulates a maintenance event on the instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   SimulateMaintenanceEventInstanceHttpRequest request = SimulateMaintenanceEventInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   Operation response = instanceClient.simulateMaintenanceEventInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation simulateMaintenanceEventInstance(
      SimulateMaintenanceEventInstanceHttpRequest request) {
    return simulateMaintenanceEventInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Simulates a maintenance event on the instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   SimulateMaintenanceEventInstanceHttpRequest request = SimulateMaintenanceEventInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.simulateMaintenanceEventInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SimulateMaintenanceEventInstanceHttpRequest, Operation>
      simulateMaintenanceEventInstanceCallable() {
    return stub.simulateMaintenanceEventInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   * see Restart an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Operation response = instanceClient.startInstance(instance);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance resource to start.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation startInstance(ProjectZoneInstanceName instance) {

    StartInstanceHttpRequest request =
        StartInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .build();
    return startInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   * see Restart an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Operation response = instanceClient.startInstance(instance.toString());
   * }
   * </code></pre>
   *
   * @param instance Name of the instance resource to start.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation startInstance(String instance) {

    StartInstanceHttpRequest request =
        StartInstanceHttpRequest.newBuilder().setInstance(instance).build();
    return startInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   * see Restart an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   StartInstanceHttpRequest request = StartInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   Operation response = instanceClient.startInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation startInstance(StartInstanceHttpRequest request) {
    return startInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   * see Restart an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   StartInstanceHttpRequest request = StartInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.startInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<StartInstanceHttpRequest, Operation> startInstanceCallable() {
    return stub.startInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   * see Restart an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesStartWithEncryptionKeyRequest instancesStartWithEncryptionKeyRequestResource = InstancesStartWithEncryptionKeyRequest.newBuilder().build();
   *   Operation response = instanceClient.startWithEncryptionKeyInstance(instance, instancesStartWithEncryptionKeyRequestResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance resource to start.
   * @param instancesStartWithEncryptionKeyRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation startWithEncryptionKeyInstance(
      ProjectZoneInstanceName instance,
      InstancesStartWithEncryptionKeyRequest instancesStartWithEncryptionKeyRequestResource) {

    StartWithEncryptionKeyInstanceHttpRequest request =
        StartWithEncryptionKeyInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setInstancesStartWithEncryptionKeyRequestResource(
                instancesStartWithEncryptionKeyRequestResource)
            .build();
    return startWithEncryptionKeyInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   * see Restart an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesStartWithEncryptionKeyRequest instancesStartWithEncryptionKeyRequestResource = InstancesStartWithEncryptionKeyRequest.newBuilder().build();
   *   Operation response = instanceClient.startWithEncryptionKeyInstance(instance.toString(), instancesStartWithEncryptionKeyRequestResource);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance resource to start.
   * @param instancesStartWithEncryptionKeyRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation startWithEncryptionKeyInstance(
      String instance,
      InstancesStartWithEncryptionKeyRequest instancesStartWithEncryptionKeyRequestResource) {

    StartWithEncryptionKeyInstanceHttpRequest request =
        StartWithEncryptionKeyInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setInstancesStartWithEncryptionKeyRequestResource(
                instancesStartWithEncryptionKeyRequestResource)
            .build();
    return startWithEncryptionKeyInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   * see Restart an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesStartWithEncryptionKeyRequest instancesStartWithEncryptionKeyRequestResource = InstancesStartWithEncryptionKeyRequest.newBuilder().build();
   *   StartWithEncryptionKeyInstanceHttpRequest request = StartWithEncryptionKeyInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setInstancesStartWithEncryptionKeyRequestResource(instancesStartWithEncryptionKeyRequestResource)
   *     .build();
   *   Operation response = instanceClient.startWithEncryptionKeyInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation startWithEncryptionKeyInstance(
      StartWithEncryptionKeyInstanceHttpRequest request) {
    return startWithEncryptionKeyInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   * see Restart an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   InstancesStartWithEncryptionKeyRequest instancesStartWithEncryptionKeyRequestResource = InstancesStartWithEncryptionKeyRequest.newBuilder().build();
   *   StartWithEncryptionKeyInstanceHttpRequest request = StartWithEncryptionKeyInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setInstancesStartWithEncryptionKeyRequestResource(instancesStartWithEncryptionKeyRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.startWithEncryptionKeyInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<StartWithEncryptionKeyInstanceHttpRequest, Operation>
      startWithEncryptionKeyInstanceCallable() {
    return stub.startWithEncryptionKeyInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Stops a running instance, shutting it down cleanly, and allows you to restart the instance at a
   * later time. Stopped instances do not incur VM usage charges while they are stopped. However,
   * resources that the VM is using, such as persistent disks and static IP addresses, will continue
   * to be charged until they are deleted. For more information, see Stopping an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Operation response = instanceClient.stopInstance(instance);
   * }
   * </code></pre>
   *
   * @param instance Name of the instance resource to stop.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation stopInstance(ProjectZoneInstanceName instance) {

    StopInstanceHttpRequest request =
        StopInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .build();
    return stopInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Stops a running instance, shutting it down cleanly, and allows you to restart the instance at a
   * later time. Stopped instances do not incur VM usage charges while they are stopped. However,
   * resources that the VM is using, such as persistent disks and static IP addresses, will continue
   * to be charged until they are deleted. For more information, see Stopping an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   Operation response = instanceClient.stopInstance(instance.toString());
   * }
   * </code></pre>
   *
   * @param instance Name of the instance resource to stop.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation stopInstance(String instance) {

    StopInstanceHttpRequest request =
        StopInstanceHttpRequest.newBuilder().setInstance(instance).build();
    return stopInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Stops a running instance, shutting it down cleanly, and allows you to restart the instance at a
   * later time. Stopped instances do not incur VM usage charges while they are stopped. However,
   * resources that the VM is using, such as persistent disks and static IP addresses, will continue
   * to be charged until they are deleted. For more information, see Stopping an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   StopInstanceHttpRequest request = StopInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   Operation response = instanceClient.stopInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation stopInstance(StopInstanceHttpRequest request) {
    return stopInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Stops a running instance, shutting it down cleanly, and allows you to restart the instance at a
   * later time. Stopped instances do not incur VM usage charges while they are stopped. However,
   * resources that the VM is using, such as persistent disks and static IP addresses, will continue
   * to be charged until they are deleted. For more information, see Stopping an instance.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   StopInstanceHttpRequest request = StopInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.stopInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<StopInstanceHttpRequest, Operation> stopInstanceCallable() {
    return stub.stopInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = instanceClient.testIamPermissionsInstance(resource, testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsInstance(
      ProjectZoneInstanceResourceName resource,
      TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsInstanceHttpRequest request =
        TestIamPermissionsInstanceHttpRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response = instanceClient.testIamPermissionsInstance(resource.toString(), testPermissionsRequestResource);
   * }
   * </code></pre>
   *
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsInstance(
      String resource, TestPermissionsRequest testPermissionsRequestResource) {

    TestIamPermissionsInstanceHttpRequest request =
        TestIamPermissionsInstanceHttpRequest.newBuilder()
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissionsInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsInstanceHttpRequest request = TestIamPermissionsInstanceHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   TestPermissionsResponse response = instanceClient.testIamPermissionsInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TestPermissionsResponse testIamPermissionsInstance(
      TestIamPermissionsInstanceHttpRequest request) {
    return testIamPermissionsInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceResourceName resource = ProjectZoneInstanceResourceName.of("[PROJECT]", "[ZONE]", "[RESOURCE]");
   *   TestPermissionsRequest testPermissionsRequestResource = TestPermissionsRequest.newBuilder().build();
   *   TestIamPermissionsInstanceHttpRequest request = TestIamPermissionsInstanceHttpRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setTestPermissionsRequestResource(testPermissionsRequestResource)
   *     .build();
   *   ApiFuture&lt;TestPermissionsResponse&gt; future = instanceClient.testIamPermissionsInstanceCallable().futureCall(request);
   *   // Do something
   *   TestPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<TestIamPermissionsInstanceHttpRequest, TestPermissionsResponse>
      testIamPermissionsInstanceCallable() {
    return stub.testIamPermissionsInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified access config from an instance's network interface with the data included
   * in the request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
   *   Operation response = instanceClient.updateAccessConfigInstance(instance, networkInterface, accessConfigResource);
   * }
   * </code></pre>
   *
   * @param instance The instance name for this request.
   * @param networkInterface The name of the network interface where the access config is attached.
   * @param accessConfigResource An access configuration attached to an instance's network
   *     interface. Only one access config per instance is supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateAccessConfigInstance(
      ProjectZoneInstanceName instance,
      String networkInterface,
      AccessConfig accessConfigResource) {

    UpdateAccessConfigInstanceHttpRequest request =
        UpdateAccessConfigInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setNetworkInterface(networkInterface)
            .setAccessConfigResource(accessConfigResource)
            .build();
    return updateAccessConfigInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified access config from an instance's network interface with the data included
   * in the request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
   *   Operation response = instanceClient.updateAccessConfigInstance(instance.toString(), networkInterface, accessConfigResource);
   * }
   * </code></pre>
   *
   * @param instance The instance name for this request.
   * @param networkInterface The name of the network interface where the access config is attached.
   * @param accessConfigResource An access configuration attached to an instance's network
   *     interface. Only one access config per instance is supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateAccessConfigInstance(
      String instance, String networkInterface, AccessConfig accessConfigResource) {

    UpdateAccessConfigInstanceHttpRequest request =
        UpdateAccessConfigInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setNetworkInterface(networkInterface)
            .setAccessConfigResource(accessConfigResource)
            .build();
    return updateAccessConfigInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified access config from an instance's network interface with the data included
   * in the request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
   *   UpdateAccessConfigInstanceHttpRequest request = UpdateAccessConfigInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setNetworkInterface(networkInterface)
   *     .setAccessConfigResource(accessConfigResource)
   *     .build();
   *   Operation response = instanceClient.updateAccessConfigInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateAccessConfigInstance(UpdateAccessConfigInstanceHttpRequest request) {
    return updateAccessConfigInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified access config from an instance's network interface with the data included
   * in the request. This method supports PATCH semantics and uses the JSON merge patch format and
   * processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   AccessConfig accessConfigResource = AccessConfig.newBuilder().build();
   *   UpdateAccessConfigInstanceHttpRequest request = UpdateAccessConfigInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setNetworkInterface(networkInterface)
   *     .setAccessConfigResource(accessConfigResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.updateAccessConfigInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<UpdateAccessConfigInstanceHttpRequest, Operation>
      updateAccessConfigInstanceCallable() {
    return stub.updateAccessConfigInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an instance's network interface. This method follows PATCH semantics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   NetworkInterface networkInterfaceResource = NetworkInterface.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = instanceClient.updateNetworkInterfaceInstance(instance, networkInterface, networkInterfaceResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param instance The instance name for this request.
   * @param networkInterface The name of the network interface to update.
   * @param networkInterfaceResource A network interface resource attached to an instance.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateNetworkInterfaceInstance(
      ProjectZoneInstanceName instance,
      String networkInterface,
      NetworkInterface networkInterfaceResource,
      List<String> fieldMask) {

    UpdateNetworkInterfaceInstanceHttpRequest request =
        UpdateNetworkInterfaceInstanceHttpRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setNetworkInterface(networkInterface)
            .setNetworkInterfaceResource(networkInterfaceResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateNetworkInterfaceInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an instance's network interface. This method follows PATCH semantics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   NetworkInterface networkInterfaceResource = NetworkInterface.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = instanceClient.updateNetworkInterfaceInstance(instance.toString(), networkInterface, networkInterfaceResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param instance The instance name for this request.
   * @param networkInterface The name of the network interface to update.
   * @param networkInterfaceResource A network interface resource attached to an instance.
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateNetworkInterfaceInstance(
      String instance,
      String networkInterface,
      NetworkInterface networkInterfaceResource,
      List<String> fieldMask) {

    UpdateNetworkInterfaceInstanceHttpRequest request =
        UpdateNetworkInterfaceInstanceHttpRequest.newBuilder()
            .setInstance(instance)
            .setNetworkInterface(networkInterface)
            .setNetworkInterfaceResource(networkInterfaceResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateNetworkInterfaceInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an instance's network interface. This method follows PATCH semantics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   NetworkInterface networkInterfaceResource = NetworkInterface.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateNetworkInterfaceInstanceHttpRequest request = UpdateNetworkInterfaceInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setNetworkInterface(networkInterface)
   *     .setNetworkInterfaceResource(networkInterfaceResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = instanceClient.updateNetworkInterfaceInstance(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateNetworkInterfaceInstance(
      UpdateNetworkInterfaceInstanceHttpRequest request) {
    return updateNetworkInterfaceInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an instance's network interface. This method follows PATCH semantics.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceClient instanceClient = InstanceClient.create()) {
   *   ProjectZoneInstanceName instance = ProjectZoneInstanceName.of("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   String networkInterface = "";
   *   NetworkInterface networkInterfaceResource = NetworkInterface.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateNetworkInterfaceInstanceHttpRequest request = UpdateNetworkInterfaceInstanceHttpRequest.newBuilder()
   *     .setInstance(instance.toString())
   *     .setNetworkInterface(networkInterface)
   *     .setNetworkInterfaceResource(networkInterfaceResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceClient.updateNetworkInterfaceInstanceCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<UpdateNetworkInterfaceInstanceHttpRequest, Operation>
      updateNetworkInterfaceInstanceCallable() {
    return stub.updateNetworkInterfaceInstanceCallable();
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

  public static class AggregatedListInstancesPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListInstancesHttpRequest,
          InstanceAggregatedList,
          InstancesScopedList,
          AggregatedListInstancesPage,
          AggregatedListInstancesFixedSizeCollection> {

    public static ApiFuture<AggregatedListInstancesPagedResponse> createAsync(
        PageContext<AggregatedListInstancesHttpRequest, InstanceAggregatedList, InstancesScopedList>
            context,
        ApiFuture<InstanceAggregatedList> futureResponse) {
      ApiFuture<AggregatedListInstancesPage> futurePage =
          AggregatedListInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<AggregatedListInstancesPage, AggregatedListInstancesPagedResponse>() {
            @Override
            public AggregatedListInstancesPagedResponse apply(AggregatedListInstancesPage input) {
              return new AggregatedListInstancesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListInstancesPagedResponse(AggregatedListInstancesPage page) {
      super(page, AggregatedListInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListInstancesPage
      extends AbstractPage<
          AggregatedListInstancesHttpRequest,
          InstanceAggregatedList,
          InstancesScopedList,
          AggregatedListInstancesPage> {

    private AggregatedListInstancesPage(
        PageContext<AggregatedListInstancesHttpRequest, InstanceAggregatedList, InstancesScopedList>
            context,
        InstanceAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListInstancesPage createEmptyPage() {
      return new AggregatedListInstancesPage(null, null);
    }

    @Override
    protected AggregatedListInstancesPage createPage(
        PageContext<AggregatedListInstancesHttpRequest, InstanceAggregatedList, InstancesScopedList>
            context,
        InstanceAggregatedList response) {
      return new AggregatedListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListInstancesPage> createPageAsync(
        PageContext<AggregatedListInstancesHttpRequest, InstanceAggregatedList, InstancesScopedList>
            context,
        ApiFuture<InstanceAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListInstancesHttpRequest,
          InstanceAggregatedList,
          InstancesScopedList,
          AggregatedListInstancesPage,
          AggregatedListInstancesFixedSizeCollection> {

    private AggregatedListInstancesFixedSizeCollection(
        List<AggregatedListInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListInstancesFixedSizeCollection createEmptyCollection() {
      return new AggregatedListInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListInstancesFixedSizeCollection createCollection(
        List<AggregatedListInstancesPage> pages, int collectionSize) {
      return new AggregatedListInstancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListInstancesHttpRequest,
          InstanceList,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    public static ApiFuture<ListInstancesPagedResponse> createAsync(
        PageContext<ListInstancesHttpRequest, InstanceList, Instance> context,
        ApiFuture<InstanceList> futureResponse) {
      ApiFuture<ListInstancesPage> futurePage =
          ListInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListInstancesPage, ListInstancesPagedResponse>() {
            @Override
            public ListInstancesPagedResponse apply(ListInstancesPage input) {
              return new ListInstancesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListInstancesPagedResponse(ListInstancesPage page) {
      super(page, ListInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesPage
      extends AbstractPage<ListInstancesHttpRequest, InstanceList, Instance, ListInstancesPage> {

    private ListInstancesPage(
        PageContext<ListInstancesHttpRequest, InstanceList, Instance> context,
        InstanceList response) {
      super(context, response);
    }

    private static ListInstancesPage createEmptyPage() {
      return new ListInstancesPage(null, null);
    }

    @Override
    protected ListInstancesPage createPage(
        PageContext<ListInstancesHttpRequest, InstanceList, Instance> context,
        InstanceList response) {
      return new ListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesPage> createPageAsync(
        PageContext<ListInstancesHttpRequest, InstanceList, Instance> context,
        ApiFuture<InstanceList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesHttpRequest,
          InstanceList,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    private ListInstancesFixedSizeCollection(List<ListInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesFixedSizeCollection createEmptyCollection() {
      return new ListInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesFixedSizeCollection createCollection(
        List<ListInstancesPage> pages, int collectionSize) {
      return new ListInstancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReferrersInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListReferrersInstancesHttpRequest,
          InstanceListReferrers,
          Reference,
          ListReferrersInstancesPage,
          ListReferrersInstancesFixedSizeCollection> {

    public static ApiFuture<ListReferrersInstancesPagedResponse> createAsync(
        PageContext<ListReferrersInstancesHttpRequest, InstanceListReferrers, Reference> context,
        ApiFuture<InstanceListReferrers> futureResponse) {
      ApiFuture<ListReferrersInstancesPage> futurePage =
          ListReferrersInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListReferrersInstancesPage, ListReferrersInstancesPagedResponse>() {
            @Override
            public ListReferrersInstancesPagedResponse apply(ListReferrersInstancesPage input) {
              return new ListReferrersInstancesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListReferrersInstancesPagedResponse(ListReferrersInstancesPage page) {
      super(page, ListReferrersInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReferrersInstancesPage
      extends AbstractPage<
          ListReferrersInstancesHttpRequest,
          InstanceListReferrers,
          Reference,
          ListReferrersInstancesPage> {

    private ListReferrersInstancesPage(
        PageContext<ListReferrersInstancesHttpRequest, InstanceListReferrers, Reference> context,
        InstanceListReferrers response) {
      super(context, response);
    }

    private static ListReferrersInstancesPage createEmptyPage() {
      return new ListReferrersInstancesPage(null, null);
    }

    @Override
    protected ListReferrersInstancesPage createPage(
        PageContext<ListReferrersInstancesHttpRequest, InstanceListReferrers, Reference> context,
        InstanceListReferrers response) {
      return new ListReferrersInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListReferrersInstancesPage> createPageAsync(
        PageContext<ListReferrersInstancesHttpRequest, InstanceListReferrers, Reference> context,
        ApiFuture<InstanceListReferrers> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReferrersInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReferrersInstancesHttpRequest,
          InstanceListReferrers,
          Reference,
          ListReferrersInstancesPage,
          ListReferrersInstancesFixedSizeCollection> {

    private ListReferrersInstancesFixedSizeCollection(
        List<ListReferrersInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReferrersInstancesFixedSizeCollection createEmptyCollection() {
      return new ListReferrersInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReferrersInstancesFixedSizeCollection createCollection(
        List<ListReferrersInstancesPage> pages, int collectionSize) {
      return new ListReferrersInstancesFixedSizeCollection(pages, collectionSize);
    }
  }
}
