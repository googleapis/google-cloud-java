/*
 * Copyright 2018 Google LLC
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
import com.google.cloud.compute.v1.stub.FirewallStub;
import com.google.cloud.compute.v1.stub.FirewallStubSettings;
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
 * try (FirewallClient firewallClient = FirewallClient.create()) {
 *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
 *   Operation response = firewallClient.deleteFirewall(firewall);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the firewallClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of FirewallSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * FirewallSettings firewallSettings =
 *     FirewallSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FirewallClient firewallClient =
 *     FirewallClient.create(firewallSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * FirewallSettings firewallSettings =
 *     FirewallSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FirewallClient firewallClient =
 *     FirewallClient.create(firewallSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class FirewallClient implements BackgroundResource {
  private final FirewallSettings settings;
  private final FirewallStub stub;

  /** Constructs an instance of FirewallClient with default settings. */
  public static final FirewallClient create() throws IOException {
    return create(FirewallSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FirewallClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FirewallClient create(FirewallSettings settings) throws IOException {
    return new FirewallClient(settings);
  }

  /**
   * Constructs an instance of FirewallClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use FirewallSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final FirewallClient create(FirewallStub stub) {
    return new FirewallClient(stub);
  }

  /**
   * Constructs an instance of FirewallClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected FirewallClient(FirewallSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FirewallStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected FirewallClient(FirewallStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FirewallSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public FirewallStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified firewall.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   Operation response = firewallClient.deleteFirewall(firewall);
   * }
   * </code></pre>
   *
   * @param firewall Name of the firewall rule to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteFirewall(ProjectGlobalFirewallName firewall) {

    DeleteFirewallHttpRequest request =
        DeleteFirewallHttpRequest.newBuilder()
            .setFirewall(firewall == null ? null : firewall.toString())
            .build();
    return deleteFirewall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified firewall.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   Operation response = firewallClient.deleteFirewall(firewall.toString());
   * }
   * </code></pre>
   *
   * @param firewall Name of the firewall rule to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteFirewall(String firewall) {

    DeleteFirewallHttpRequest request =
        DeleteFirewallHttpRequest.newBuilder().setFirewall(firewall).build();
    return deleteFirewall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified firewall.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   DeleteFirewallHttpRequest request = DeleteFirewallHttpRequest.newBuilder()
   *     .setFirewall(firewall.toString())
   *     .build();
   *   Operation response = firewallClient.deleteFirewall(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteFirewall(DeleteFirewallHttpRequest request) {
    return deleteFirewallCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified firewall.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   DeleteFirewallHttpRequest request = DeleteFirewallHttpRequest.newBuilder()
   *     .setFirewall(firewall.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = firewallClient.deleteFirewallCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteFirewallHttpRequest, Operation> deleteFirewallCallable() {
    return stub.deleteFirewallCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified firewall.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   Firewall response = firewallClient.getFirewall(firewall);
   * }
   * </code></pre>
   *
   * @param firewall Name of the firewall rule to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Firewall getFirewall(ProjectGlobalFirewallName firewall) {

    GetFirewallHttpRequest request =
        GetFirewallHttpRequest.newBuilder()
            .setFirewall(firewall == null ? null : firewall.toString())
            .build();
    return getFirewall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified firewall.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   Firewall response = firewallClient.getFirewall(firewall.toString());
   * }
   * </code></pre>
   *
   * @param firewall Name of the firewall rule to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Firewall getFirewall(String firewall) {

    GetFirewallHttpRequest request =
        GetFirewallHttpRequest.newBuilder().setFirewall(firewall).build();
    return getFirewall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified firewall.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   GetFirewallHttpRequest request = GetFirewallHttpRequest.newBuilder()
   *     .setFirewall(firewall.toString())
   *     .build();
   *   Firewall response = firewallClient.getFirewall(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Firewall getFirewall(GetFirewallHttpRequest request) {
    return getFirewallCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified firewall.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   GetFirewallHttpRequest request = GetFirewallHttpRequest.newBuilder()
   *     .setFirewall(firewall.toString())
   *     .build();
   *   ApiFuture&lt;Firewall&gt; future = firewallClient.getFirewallCallable().futureCall(request);
   *   // Do something
   *   Firewall response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetFirewallHttpRequest, Firewall> getFirewallCallable() {
    return stub.getFirewallCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a firewall rule in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   Operation response = firewallClient.insertFirewall(project, firewallResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param firewallResource Represents a Firewall resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertFirewall(ProjectName project, Firewall firewallResource) {

    InsertFirewallHttpRequest request =
        InsertFirewallHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setFirewallResource(firewallResource)
            .build();
    return insertFirewall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a firewall rule in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   Operation response = firewallClient.insertFirewall(project.toString(), firewallResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param firewallResource Represents a Firewall resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertFirewall(String project, Firewall firewallResource) {

    InsertFirewallHttpRequest request =
        InsertFirewallHttpRequest.newBuilder()
            .setProject(project)
            .setFirewallResource(firewallResource)
            .build();
    return insertFirewall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a firewall rule in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   InsertFirewallHttpRequest request = InsertFirewallHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setFirewallResource(firewallResource)
   *     .build();
   *   Operation response = firewallClient.insertFirewall(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertFirewall(InsertFirewallHttpRequest request) {
    return insertFirewallCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a firewall rule in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   InsertFirewallHttpRequest request = InsertFirewallHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .setFirewallResource(firewallResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = firewallClient.insertFirewallCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertFirewallHttpRequest, Operation> insertFirewallCallable() {
    return stub.insertFirewallCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of firewall rules available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Firewall element : firewallClient.listFirewalls(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListFirewallsPagedResponse listFirewalls(ProjectName project) {
    ListFirewallsHttpRequest request =
        ListFirewallsHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listFirewalls(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of firewall rules available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (Firewall element : firewallClient.listFirewalls(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListFirewallsPagedResponse listFirewalls(String project) {
    ListFirewallsHttpRequest request =
        ListFirewallsHttpRequest.newBuilder().setProject(project).build();
    return listFirewalls(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of firewall rules available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListFirewallsHttpRequest request = ListFirewallsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   for (Firewall element : firewallClient.listFirewalls(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListFirewallsPagedResponse listFirewalls(ListFirewallsHttpRequest request) {
    return listFirewallsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of firewall rules available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListFirewallsHttpRequest request = ListFirewallsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   ApiFuture&lt;ListFirewallsPagedResponse&gt; future = firewallClient.listFirewallsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Firewall element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListFirewallsHttpRequest, ListFirewallsPagedResponse>
      listFirewallsPagedCallable() {
    return stub.listFirewallsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of firewall rules available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   ListFirewallsHttpRequest request = ListFirewallsHttpRequest.newBuilder()
   *     .setProject(project.toString())
   *     .build();
   *   while (true) {
   *     FirewallList response = firewallClient.listFirewallsCallable().call(request);
   *     for (Firewall element : response.getItemsList()) {
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
  public final UnaryCallable<ListFirewallsHttpRequest, FirewallList> listFirewallsCallable() {
    return stub.listFirewallsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified firewall rule with the data included in the request. This method supports
   * PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = firewallClient.patchFirewall(firewall, firewallResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param firewall Name of the firewall rule to patch.
   * @param firewallResource Represents a Firewall resource.
   * @param fieldMask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchFirewall(
      ProjectGlobalFirewallName firewall, Firewall firewallResource, List<String> fieldMask) {

    PatchFirewallHttpRequest request =
        PatchFirewallHttpRequest.newBuilder()
            .setFirewall(firewall == null ? null : firewall.toString())
            .setFirewallResource(firewallResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchFirewall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified firewall rule with the data included in the request. This method supports
   * PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = firewallClient.patchFirewall(firewall.toString(), firewallResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param firewall Name of the firewall rule to patch.
   * @param firewallResource Represents a Firewall resource.
   * @param fieldMask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchFirewall(
      String firewall, Firewall firewallResource, List<String> fieldMask) {

    PatchFirewallHttpRequest request =
        PatchFirewallHttpRequest.newBuilder()
            .setFirewall(firewall)
            .setFirewallResource(firewallResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchFirewall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified firewall rule with the data included in the request. This method supports
   * PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchFirewallHttpRequest request = PatchFirewallHttpRequest.newBuilder()
   *     .setFirewall(firewall.toString())
   *     .setFirewallResource(firewallResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = firewallClient.patchFirewall(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchFirewall(PatchFirewallHttpRequest request) {
    return patchFirewallCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified firewall rule with the data included in the request. This method supports
   * PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchFirewallHttpRequest request = PatchFirewallHttpRequest.newBuilder()
   *     .setFirewall(firewall.toString())
   *     .setFirewallResource(firewallResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = firewallClient.patchFirewallCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchFirewallHttpRequest, Operation> patchFirewallCallable() {
    return stub.patchFirewallCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified firewall rule with the data included in the request. The PUT method can
   * only update the following fields of firewall rule: allowed, description, sourceRanges,
   * sourceTags, targetTags.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = firewallClient.updateFirewall(firewall, firewallResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param firewall Name of the firewall rule to update.
   * @param firewallResource Represents a Firewall resource.
   * @param fieldMask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateFirewall(
      ProjectGlobalFirewallName firewall, Firewall firewallResource, List<String> fieldMask) {

    UpdateFirewallHttpRequest request =
        UpdateFirewallHttpRequest.newBuilder()
            .setFirewall(firewall == null ? null : firewall.toString())
            .setFirewallResource(firewallResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateFirewall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified firewall rule with the data included in the request. The PUT method can
   * only update the following fields of firewall rule: allowed, description, sourceRanges,
   * sourceTags, targetTags.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = firewallClient.updateFirewall(firewall.toString(), firewallResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param firewall Name of the firewall rule to update.
   * @param firewallResource Represents a Firewall resource.
   * @param fieldMask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateFirewall(
      String firewall, Firewall firewallResource, List<String> fieldMask) {

    UpdateFirewallHttpRequest request =
        UpdateFirewallHttpRequest.newBuilder()
            .setFirewall(firewall)
            .setFirewallResource(firewallResource)
            .addAllFieldMask(fieldMask)
            .build();
    return updateFirewall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified firewall rule with the data included in the request. The PUT method can
   * only update the following fields of firewall rule: allowed, description, sourceRanges,
   * sourceTags, targetTags.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateFirewallHttpRequest request = UpdateFirewallHttpRequest.newBuilder()
   *     .setFirewall(firewall.toString())
   *     .setFirewallResource(firewallResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = firewallClient.updateFirewall(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updateFirewall(UpdateFirewallHttpRequest request) {
    return updateFirewallCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified firewall rule with the data included in the request. The PUT method can
   * only update the following fields of firewall rule: allowed, description, sourceRanges,
   * sourceTags, targetTags.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallClient firewallClient = FirewallClient.create()) {
   *   ProjectGlobalFirewallName firewall = ProjectGlobalFirewallName.of("[PROJECT]", "[FIREWALL]");
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   UpdateFirewallHttpRequest request = UpdateFirewallHttpRequest.newBuilder()
   *     .setFirewall(firewall.toString())
   *     .setFirewallResource(firewallResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = firewallClient.updateFirewallCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<UpdateFirewallHttpRequest, Operation> updateFirewallCallable() {
    return stub.updateFirewallCallable();
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

  public static class ListFirewallsPagedResponse
      extends AbstractPagedListResponse<
          ListFirewallsHttpRequest, FirewallList, Firewall, ListFirewallsPage,
          ListFirewallsFixedSizeCollection> {

    public static ApiFuture<ListFirewallsPagedResponse> createAsync(
        PageContext<ListFirewallsHttpRequest, FirewallList, Firewall> context,
        ApiFuture<FirewallList> futureResponse) {
      ApiFuture<ListFirewallsPage> futurePage =
          ListFirewallsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListFirewallsPage, ListFirewallsPagedResponse>() {
            @Override
            public ListFirewallsPagedResponse apply(ListFirewallsPage input) {
              return new ListFirewallsPagedResponse(input);
            }
          });
    }

    private ListFirewallsPagedResponse(ListFirewallsPage page) {
      super(page, ListFirewallsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFirewallsPage
      extends AbstractPage<ListFirewallsHttpRequest, FirewallList, Firewall, ListFirewallsPage> {

    private ListFirewallsPage(
        PageContext<ListFirewallsHttpRequest, FirewallList, Firewall> context,
        FirewallList response) {
      super(context, response);
    }

    private static ListFirewallsPage createEmptyPage() {
      return new ListFirewallsPage(null, null);
    }

    @Override
    protected ListFirewallsPage createPage(
        PageContext<ListFirewallsHttpRequest, FirewallList, Firewall> context,
        FirewallList response) {
      return new ListFirewallsPage(context, response);
    }

    @Override
    public ApiFuture<ListFirewallsPage> createPageAsync(
        PageContext<ListFirewallsHttpRequest, FirewallList, Firewall> context,
        ApiFuture<FirewallList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFirewallsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFirewallsHttpRequest, FirewallList, Firewall, ListFirewallsPage,
          ListFirewallsFixedSizeCollection> {

    private ListFirewallsFixedSizeCollection(List<ListFirewallsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFirewallsFixedSizeCollection createEmptyCollection() {
      return new ListFirewallsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFirewallsFixedSizeCollection createCollection(
        List<ListFirewallsPage> pages, int collectionSize) {
      return new ListFirewallsFixedSizeCollection(pages, collectionSize);
    }
  }
}
