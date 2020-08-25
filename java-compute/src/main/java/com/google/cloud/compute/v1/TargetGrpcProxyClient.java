/*
 * Copyright 2020 Google LLC
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
import com.google.cloud.compute.v1.stub.TargetGrpcProxyStub;
import com.google.cloud.compute.v1.stub.TargetGrpcProxyStubSettings;
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
 * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
 *   ProjectGlobalTargetGrpcProxyName targetGrpcProxy = ProjectGlobalTargetGrpcProxyName.of("[PROJECT]", "[TARGET_GRPC_PROXY]");
 *   Operation response = targetGrpcProxyClient.deleteTargetGrpcProxy(targetGrpcProxy);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the targetGrpcProxyClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of TargetGrpcProxySettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * TargetGrpcProxySettings targetGrpcProxySettings =
 *     TargetGrpcProxySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TargetGrpcProxyClient targetGrpcProxyClient =
 *     TargetGrpcProxyClient.create(targetGrpcProxySettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * TargetGrpcProxySettings targetGrpcProxySettings =
 *     TargetGrpcProxySettings.newBuilder().setEndpoint(myEndpoint).build();
 * TargetGrpcProxyClient targetGrpcProxyClient =
 *     TargetGrpcProxyClient.create(targetGrpcProxySettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class TargetGrpcProxyClient implements BackgroundResource {
  private final TargetGrpcProxySettings settings;
  private final TargetGrpcProxyStub stub;

  /** Constructs an instance of TargetGrpcProxyClient with default settings. */
  public static final TargetGrpcProxyClient create() throws IOException {
    return create(TargetGrpcProxySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TargetGrpcProxyClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TargetGrpcProxyClient create(TargetGrpcProxySettings settings)
      throws IOException {
    return new TargetGrpcProxyClient(settings);
  }

  /**
   * Constructs an instance of TargetGrpcProxyClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use TargetGrpcProxySettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final TargetGrpcProxyClient create(TargetGrpcProxyStub stub) {
    return new TargetGrpcProxyClient(stub);
  }

  /**
   * Constructs an instance of TargetGrpcProxyClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TargetGrpcProxyClient(TargetGrpcProxySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TargetGrpcProxyStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TargetGrpcProxyClient(TargetGrpcProxyStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TargetGrpcProxySettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TargetGrpcProxyStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetGrpcProxy in the given scope
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   ProjectGlobalTargetGrpcProxyName targetGrpcProxy = ProjectGlobalTargetGrpcProxyName.of("[PROJECT]", "[TARGET_GRPC_PROXY]");
   *   Operation response = targetGrpcProxyClient.deleteTargetGrpcProxy(targetGrpcProxy);
   * }
   * </code></pre>
   *
   * @param targetGrpcProxy Name of the TargetGrpcProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteTargetGrpcProxy(ProjectGlobalTargetGrpcProxyName targetGrpcProxy) {
    DeleteTargetGrpcProxyHttpRequest request =
        DeleteTargetGrpcProxyHttpRequest.newBuilder()
            .setTargetGrpcProxy(targetGrpcProxy == null ? null : targetGrpcProxy.toString())
            .build();
    return deleteTargetGrpcProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetGrpcProxy in the given scope
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   ProjectGlobalTargetGrpcProxyName targetGrpcProxy = ProjectGlobalTargetGrpcProxyName.of("[PROJECT]", "[TARGET_GRPC_PROXY]");
   *   Operation response = targetGrpcProxyClient.deleteTargetGrpcProxy(targetGrpcProxy.toString());
   * }
   * </code></pre>
   *
   * @param targetGrpcProxy Name of the TargetGrpcProxy resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteTargetGrpcProxy(String targetGrpcProxy) {
    DeleteTargetGrpcProxyHttpRequest request =
        DeleteTargetGrpcProxyHttpRequest.newBuilder().setTargetGrpcProxy(targetGrpcProxy).build();
    return deleteTargetGrpcProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetGrpcProxy in the given scope
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   String formattedTargetGrpcProxy = ProjectGlobalTargetGrpcProxyName.format("[PROJECT]", "[TARGET_GRPC_PROXY]");
   *   DeleteTargetGrpcProxyHttpRequest request = DeleteTargetGrpcProxyHttpRequest.newBuilder()
   *     .setTargetGrpcProxy(formattedTargetGrpcProxy)
   *     .build();
   *   Operation response = targetGrpcProxyClient.deleteTargetGrpcProxy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteTargetGrpcProxy(DeleteTargetGrpcProxyHttpRequest request) {
    return deleteTargetGrpcProxyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified TargetGrpcProxy in the given scope
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   String formattedTargetGrpcProxy = ProjectGlobalTargetGrpcProxyName.format("[PROJECT]", "[TARGET_GRPC_PROXY]");
   *   DeleteTargetGrpcProxyHttpRequest request = DeleteTargetGrpcProxyHttpRequest.newBuilder()
   *     .setTargetGrpcProxy(formattedTargetGrpcProxy)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetGrpcProxyClient.deleteTargetGrpcProxyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteTargetGrpcProxyHttpRequest, Operation>
      deleteTargetGrpcProxyCallable() {
    return stub.deleteTargetGrpcProxyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetGrpcProxy resource in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   ProjectGlobalTargetGrpcProxyName targetGrpcProxy = ProjectGlobalTargetGrpcProxyName.of("[PROJECT]", "[TARGET_GRPC_PROXY]");
   *   TargetGrpcProxy response = targetGrpcProxyClient.getTargetGrpcProxy(targetGrpcProxy);
   * }
   * </code></pre>
   *
   * @param targetGrpcProxy Name of the TargetGrpcProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetGrpcProxy getTargetGrpcProxy(
      ProjectGlobalTargetGrpcProxyName targetGrpcProxy) {
    GetTargetGrpcProxyHttpRequest request =
        GetTargetGrpcProxyHttpRequest.newBuilder()
            .setTargetGrpcProxy(targetGrpcProxy == null ? null : targetGrpcProxy.toString())
            .build();
    return getTargetGrpcProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetGrpcProxy resource in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   ProjectGlobalTargetGrpcProxyName targetGrpcProxy = ProjectGlobalTargetGrpcProxyName.of("[PROJECT]", "[TARGET_GRPC_PROXY]");
   *   TargetGrpcProxy response = targetGrpcProxyClient.getTargetGrpcProxy(targetGrpcProxy.toString());
   * }
   * </code></pre>
   *
   * @param targetGrpcProxy Name of the TargetGrpcProxy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetGrpcProxy getTargetGrpcProxy(String targetGrpcProxy) {
    GetTargetGrpcProxyHttpRequest request =
        GetTargetGrpcProxyHttpRequest.newBuilder().setTargetGrpcProxy(targetGrpcProxy).build();
    return getTargetGrpcProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetGrpcProxy resource in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   String formattedTargetGrpcProxy = ProjectGlobalTargetGrpcProxyName.format("[PROJECT]", "[TARGET_GRPC_PROXY]");
   *   GetTargetGrpcProxyHttpRequest request = GetTargetGrpcProxyHttpRequest.newBuilder()
   *     .setTargetGrpcProxy(formattedTargetGrpcProxy)
   *     .build();
   *   TargetGrpcProxy response = targetGrpcProxyClient.getTargetGrpcProxy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final TargetGrpcProxy getTargetGrpcProxy(GetTargetGrpcProxyHttpRequest request) {
    return getTargetGrpcProxyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified TargetGrpcProxy resource in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   String formattedTargetGrpcProxy = ProjectGlobalTargetGrpcProxyName.format("[PROJECT]", "[TARGET_GRPC_PROXY]");
   *   GetTargetGrpcProxyHttpRequest request = GetTargetGrpcProxyHttpRequest.newBuilder()
   *     .setTargetGrpcProxy(formattedTargetGrpcProxy)
   *     .build();
   *   ApiFuture&lt;TargetGrpcProxy&gt; future = targetGrpcProxyClient.getTargetGrpcProxyCallable().futureCall(request);
   *   // Do something
   *   TargetGrpcProxy response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetTargetGrpcProxyHttpRequest, TargetGrpcProxy>
      getTargetGrpcProxyCallable() {
    return stub.getTargetGrpcProxyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetGrpcProxy in the specified project in the given scope using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   Operation response = targetGrpcProxyClient.insertTargetGrpcProxy(project, targetGrpcProxyResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param targetGrpcProxyResource Represents a Target gRPC Proxy resource.
   *     <p>A target gRPC proxy is a component of load balancers intended for load balancing gRPC
   *     traffic. Global forwarding rules reference a target gRPC proxy. The Target gRPC Proxy
   *     references a URL map which specifies how traffic routes to gRPC backend services. (==
   *     resource_for {$api_version}.targetGrpcProxies ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertTargetGrpcProxy(
      ProjectName project, TargetGrpcProxy targetGrpcProxyResource) {
    InsertTargetGrpcProxyHttpRequest request =
        InsertTargetGrpcProxyHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .setTargetGrpcProxyResource(targetGrpcProxyResource)
            .build();
    return insertTargetGrpcProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetGrpcProxy in the specified project in the given scope using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   Operation response = targetGrpcProxyClient.insertTargetGrpcProxy(project.toString(), targetGrpcProxyResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param targetGrpcProxyResource Represents a Target gRPC Proxy resource.
   *     <p>A target gRPC proxy is a component of load balancers intended for load balancing gRPC
   *     traffic. Global forwarding rules reference a target gRPC proxy. The Target gRPC Proxy
   *     references a URL map which specifies how traffic routes to gRPC backend services. (==
   *     resource_for {$api_version}.targetGrpcProxies ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertTargetGrpcProxy(
      String project, TargetGrpcProxy targetGrpcProxyResource) {
    InsertTargetGrpcProxyHttpRequest request =
        InsertTargetGrpcProxyHttpRequest.newBuilder()
            .setProject(project)
            .setTargetGrpcProxyResource(targetGrpcProxyResource)
            .build();
    return insertTargetGrpcProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetGrpcProxy in the specified project in the given scope using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   InsertTargetGrpcProxyHttpRequest request = InsertTargetGrpcProxyHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .setTargetGrpcProxyResource(targetGrpcProxyResource)
   *     .build();
   *   Operation response = targetGrpcProxyClient.insertTargetGrpcProxy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertTargetGrpcProxy(InsertTargetGrpcProxyHttpRequest request) {
    return insertTargetGrpcProxyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a TargetGrpcProxy in the specified project in the given scope using the parameters that
   * are included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   InsertTargetGrpcProxyHttpRequest request = InsertTargetGrpcProxyHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .setTargetGrpcProxyResource(targetGrpcProxyResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetGrpcProxyClient.insertTargetGrpcProxyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertTargetGrpcProxyHttpRequest, Operation>
      insertTargetGrpcProxyCallable() {
    return stub.insertTargetGrpcProxyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the TargetGrpcProxies for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (TargetGrpcProxy element : targetGrpcProxyClient.listTargetGrpcProxies(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListTargetGrpcProxiesPagedResponse listTargetGrpcProxies(ProjectName project) {
    ListTargetGrpcProxiesHttpRequest request =
        ListTargetGrpcProxiesHttpRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return listTargetGrpcProxies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the TargetGrpcProxies for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (TargetGrpcProxy element : targetGrpcProxyClient.listTargetGrpcProxies(project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListTargetGrpcProxiesPagedResponse listTargetGrpcProxies(String project) {
    ListTargetGrpcProxiesHttpRequest request =
        ListTargetGrpcProxiesHttpRequest.newBuilder().setProject(project).build();
    return listTargetGrpcProxies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the TargetGrpcProxies for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListTargetGrpcProxiesHttpRequest request = ListTargetGrpcProxiesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   for (TargetGrpcProxy element : targetGrpcProxyClient.listTargetGrpcProxies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListTargetGrpcProxiesPagedResponse listTargetGrpcProxies(
      ListTargetGrpcProxiesHttpRequest request) {
    return listTargetGrpcProxiesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the TargetGrpcProxies for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListTargetGrpcProxiesHttpRequest request = ListTargetGrpcProxiesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;ListTargetGrpcProxiesPagedResponse&gt; future = targetGrpcProxyClient.listTargetGrpcProxiesPagedCallable().futureCall(request);
   *   // Do something
   *   for (TargetGrpcProxy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListTargetGrpcProxiesHttpRequest, ListTargetGrpcProxiesPagedResponse>
      listTargetGrpcProxiesPagedCallable() {
    return stub.listTargetGrpcProxiesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the TargetGrpcProxies for a project in the given scope.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   ListTargetGrpcProxiesHttpRequest request = ListTargetGrpcProxiesHttpRequest.newBuilder()
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     TargetGrpcProxyList response = targetGrpcProxyClient.listTargetGrpcProxiesCallable().call(request);
   *     for (TargetGrpcProxy element : response.getItemsList()) {
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
  public final UnaryCallable<ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList>
      listTargetGrpcProxiesCallable() {
    return stub.listTargetGrpcProxiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified TargetGrpcProxy resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   ProjectGlobalTargetGrpcProxyName targetGrpcProxy = ProjectGlobalTargetGrpcProxyName.of("[PROJECT]", "[TARGET_GRPC_PROXY]");
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = targetGrpcProxyClient.patchTargetGrpcProxy(targetGrpcProxy, targetGrpcProxyResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param targetGrpcProxy Name of the TargetGrpcProxy resource to patch.
   * @param targetGrpcProxyResource Represents a Target gRPC Proxy resource.
   *     <p>A target gRPC proxy is a component of load balancers intended for load balancing gRPC
   *     traffic. Global forwarding rules reference a target gRPC proxy. The Target gRPC Proxy
   *     references a URL map which specifies how traffic routes to gRPC backend services. (==
   *     resource_for {$api_version}.targetGrpcProxies ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchTargetGrpcProxy(
      ProjectGlobalTargetGrpcProxyName targetGrpcProxy,
      TargetGrpcProxy targetGrpcProxyResource,
      List<String> fieldMask) {
    PatchTargetGrpcProxyHttpRequest request =
        PatchTargetGrpcProxyHttpRequest.newBuilder()
            .setTargetGrpcProxy(targetGrpcProxy == null ? null : targetGrpcProxy.toString())
            .setTargetGrpcProxyResource(targetGrpcProxyResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchTargetGrpcProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified TargetGrpcProxy resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   ProjectGlobalTargetGrpcProxyName targetGrpcProxy = ProjectGlobalTargetGrpcProxyName.of("[PROJECT]", "[TARGET_GRPC_PROXY]");
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = targetGrpcProxyClient.patchTargetGrpcProxy(targetGrpcProxy.toString(), targetGrpcProxyResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param targetGrpcProxy Name of the TargetGrpcProxy resource to patch.
   * @param targetGrpcProxyResource Represents a Target gRPC Proxy resource.
   *     <p>A target gRPC proxy is a component of load balancers intended for load balancing gRPC
   *     traffic. Global forwarding rules reference a target gRPC proxy. The Target gRPC Proxy
   *     references a URL map which specifies how traffic routes to gRPC backend services. (==
   *     resource_for {$api_version}.targetGrpcProxies ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchTargetGrpcProxy(
      String targetGrpcProxy, TargetGrpcProxy targetGrpcProxyResource, List<String> fieldMask) {
    PatchTargetGrpcProxyHttpRequest request =
        PatchTargetGrpcProxyHttpRequest.newBuilder()
            .setTargetGrpcProxy(targetGrpcProxy)
            .setTargetGrpcProxyResource(targetGrpcProxyResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchTargetGrpcProxy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified TargetGrpcProxy resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   String formattedTargetGrpcProxy = ProjectGlobalTargetGrpcProxyName.format("[PROJECT]", "[TARGET_GRPC_PROXY]");
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchTargetGrpcProxyHttpRequest request = PatchTargetGrpcProxyHttpRequest.newBuilder()
   *     .setTargetGrpcProxy(formattedTargetGrpcProxy)
   *     .setTargetGrpcProxyResource(targetGrpcProxyResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = targetGrpcProxyClient.patchTargetGrpcProxy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchTargetGrpcProxy(PatchTargetGrpcProxyHttpRequest request) {
    return patchTargetGrpcProxyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Patches the specified TargetGrpcProxy resource with the data included in the request. This
   * method supports PATCH semantics and uses JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TargetGrpcProxyClient targetGrpcProxyClient = TargetGrpcProxyClient.create()) {
   *   String formattedTargetGrpcProxy = ProjectGlobalTargetGrpcProxyName.format("[PROJECT]", "[TARGET_GRPC_PROXY]");
   *   TargetGrpcProxy targetGrpcProxyResource = TargetGrpcProxy.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchTargetGrpcProxyHttpRequest request = PatchTargetGrpcProxyHttpRequest.newBuilder()
   *     .setTargetGrpcProxy(formattedTargetGrpcProxy)
   *     .setTargetGrpcProxyResource(targetGrpcProxyResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = targetGrpcProxyClient.patchTargetGrpcProxyCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchTargetGrpcProxyHttpRequest, Operation>
      patchTargetGrpcProxyCallable() {
    return stub.patchTargetGrpcProxyCallable();
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

  public static class ListTargetGrpcProxiesPagedResponse
      extends AbstractPagedListResponse<
          ListTargetGrpcProxiesHttpRequest,
          TargetGrpcProxyList,
          TargetGrpcProxy,
          ListTargetGrpcProxiesPage,
          ListTargetGrpcProxiesFixedSizeCollection> {

    public static ApiFuture<ListTargetGrpcProxiesPagedResponse> createAsync(
        PageContext<ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList, TargetGrpcProxy> context,
        ApiFuture<TargetGrpcProxyList> futureResponse) {
      ApiFuture<ListTargetGrpcProxiesPage> futurePage =
          ListTargetGrpcProxiesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTargetGrpcProxiesPage, ListTargetGrpcProxiesPagedResponse>() {
            @Override
            public ListTargetGrpcProxiesPagedResponse apply(ListTargetGrpcProxiesPage input) {
              return new ListTargetGrpcProxiesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListTargetGrpcProxiesPagedResponse(ListTargetGrpcProxiesPage page) {
      super(page, ListTargetGrpcProxiesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTargetGrpcProxiesPage
      extends AbstractPage<
          ListTargetGrpcProxiesHttpRequest,
          TargetGrpcProxyList,
          TargetGrpcProxy,
          ListTargetGrpcProxiesPage> {

    private ListTargetGrpcProxiesPage(
        PageContext<ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList, TargetGrpcProxy> context,
        TargetGrpcProxyList response) {
      super(context, response);
    }

    private static ListTargetGrpcProxiesPage createEmptyPage() {
      return new ListTargetGrpcProxiesPage(null, null);
    }

    @Override
    protected ListTargetGrpcProxiesPage createPage(
        PageContext<ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList, TargetGrpcProxy> context,
        TargetGrpcProxyList response) {
      return new ListTargetGrpcProxiesPage(context, response);
    }

    @Override
    public ApiFuture<ListTargetGrpcProxiesPage> createPageAsync(
        PageContext<ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList, TargetGrpcProxy> context,
        ApiFuture<TargetGrpcProxyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTargetGrpcProxiesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTargetGrpcProxiesHttpRequest,
          TargetGrpcProxyList,
          TargetGrpcProxy,
          ListTargetGrpcProxiesPage,
          ListTargetGrpcProxiesFixedSizeCollection> {

    private ListTargetGrpcProxiesFixedSizeCollection(
        List<ListTargetGrpcProxiesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTargetGrpcProxiesFixedSizeCollection createEmptyCollection() {
      return new ListTargetGrpcProxiesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTargetGrpcProxiesFixedSizeCollection createCollection(
        List<ListTargetGrpcProxiesPage> pages, int collectionSize) {
      return new ListTargetGrpcProxiesFixedSizeCollection(pages, collectionSize);
    }
  }
}
