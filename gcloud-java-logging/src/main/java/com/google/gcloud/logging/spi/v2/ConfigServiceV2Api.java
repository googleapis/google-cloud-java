/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

/*
 * EDITING INSTRUCTIONS
 * This file was generated from the file
 * https://github.com/google/googleapis/blob/master/google/logging/v2/logging_config.proto
 * and updates to that file get reflected here through a refresh process.
 * For the short term, the refresh process will only be runnable by Google engineers.
 * Manual additions are allowed because the refresh process performs
 * a 3-way merge in order to preserve those manual additions. In order to not
 * break the refresh process, only certain types of modifications are
 * allowed.
 *
 * Allowed modifications - currently these are the only types allowed:
 * 1. New methods (these should be added to the end of the class)
 * 2. New imports
 * 3. Additional documentation between "manual edit" demarcations
 *
 * Happy editing!
 */
package com.google.gcloud.logging.spi.v2;

import com.google.logging.v2.ConfigServiceV2Grpc;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.protobuf.Empty;
import io.gapi.gax.grpc.ApiCallable;
import io.gapi.gax.grpc.PageDescriptor;
import io.gapi.gax.grpc.ServiceApiSettings;
import io.gapi.gax.internal.ApiUtils;
import io.gapi.gax.protobuf.PathTemplate;
import io.grpc.ManagedChannel;
import java.io.IOException;

// Manually-added imports: add custom (non-generated) imports after this point.



// AUTO-GENERATED DOCUMENTATION AND SERVICE - see instructions at the top of the file for editing.
/**
 * See //google/logging/v2/logging.proto for documentation
 *
 * <!-- manual edit -->
 * <!-- end manual edit -->
 */
@javax.annotation.Generated("by API code generation")
public class ConfigServiceV2Api implements AutoCloseable {

  // =========
  // Constants
  // =========

  /**
   * The default address of the service.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String SERVICE_ADDRESS = "logging.googleapis.com";

  /**
   * The default port of the service.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final int DEFAULT_SERVICE_PORT = 443;


  private static final ApiCallable<ListSinksRequest, ListSinksResponse>
      LIST_SINKS = ApiCallable.create(ConfigServiceV2Grpc.METHOD_LIST_SINKS);
  private static final ApiCallable<GetSinkRequest, LogSink>
      GET_SINK = ApiCallable.create(ConfigServiceV2Grpc.METHOD_GET_SINK);
  private static final ApiCallable<CreateSinkRequest, LogSink>
      CREATE_SINK = ApiCallable.create(ConfigServiceV2Grpc.METHOD_CREATE_SINK);
  private static final ApiCallable<UpdateSinkRequest, LogSink>
      UPDATE_SINK = ApiCallable.create(ConfigServiceV2Grpc.METHOD_UPDATE_SINK);
  private static final ApiCallable<DeleteSinkRequest, Empty>
      DELETE_SINK = ApiCallable.create(ConfigServiceV2Grpc.METHOD_DELETE_SINK);

  private static PageDescriptor<ListSinksRequest, ListSinksResponse, LogSink> LIST_SINKS_PAGE_DESC =
      new PageDescriptor<ListSinksRequest, ListSinksResponse, LogSink>() {
        @Override
        public Object emptyToken() {
          return "";
        }
        @Override
        public ListSinksRequest injectToken(
            ListSinksRequest payload, Object token) {
          return ListSinksRequest
            .newBuilder(payload)
            .setPageToken((String) token)
            .build();
        }
        @Override
        public Object extractNextToken(ListSinksResponse payload) {
          return payload.getNextPageToken();
        }
        @Override
        public Iterable<LogSink> extractResources(ListSinksResponse payload) {
          return payload.getSinksList();
        }
      };

  private static String ALL_SCOPES[] = {
    "https://www.googleapis.com/auth/logging.read",
    "https://www.googleapis.com/auth/logging.write",
    "https://www.googleapis.com/auth/logging.admin"
  };

  /**
   * A PathTemplate representing the fully-qualified path to represent
   * a project_name resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  private static final PathTemplate PROJECT_NAME_PATH_TEMPLATE =
      PathTemplate.create("/projects/{project}");
  /**
   * A PathTemplate representing the fully-qualified path to represent
   * a sink_name resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  private static final PathTemplate SINK_NAME_PATH_TEMPLATE =
      PathTemplate.create("/projects/{project}/sinks/{sink}");

  // ========
  // Members
  // ========

  private final ManagedChannel channel;
  private final ServiceApiSettings settings;

  // ===============
  // Factory Methods
  // ===============

  /**
   * Constructs an instance of ConfigServiceV2Api with default settings.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static ConfigServiceV2Api create() throws IOException {
    return create(new ServiceApiSettings());
  }

  /**
   * Constructs an instance of ConfigServiceV2Api, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static ConfigServiceV2Api create(ServiceApiSettings settings) throws IOException {
    return new ConfigServiceV2Api(settings);
  }

  /**
   * Constructs an instance of ConfigServiceV2Api, using the given settings. This is protected so that it
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  protected ConfigServiceV2Api(ServiceApiSettings settings) throws IOException {
    ServiceApiSettings internalSettings = ApiUtils.populateSettings(settings,
        SERVICE_ADDRESS, DEFAULT_SERVICE_PORT, ALL_SCOPES);
    this.settings = internalSettings;
    this.channel = internalSettings.getChannel();
  }

  // ==============================
  // Resource Name Helper Functions
  // ==============================

  /**
   * Creates a string containing the fully-qualified path to represent
   * a project_name resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String createProjectNamePath(String project) {
    return PROJECT_NAME_PATH_TEMPLATE.instantiate(
        "project", project);
  }

  /**
   * Creates a string containing the fully-qualified path to represent
   * a sink_name resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String createSinkNamePath(String project, String sink) {
    return SINK_NAME_PATH_TEMPLATE.instantiate(
        "project", project,"sink", sink);
  }


  /**
   * Extracts the project from the given fully-qualified path which
   * represents a projectName resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String extractProjectFromProjectNamePath(String projectNamePath) {
    return PROJECT_NAME_PATH_TEMPLATE.parse(projectNamePath).get("project");
  }

  /**
   * Extracts the project from the given fully-qualified path which
   * represents a sinkName resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String extractProjectFromSinkNamePath(String sinkNamePath) {
    return SINK_NAME_PATH_TEMPLATE.parse(sinkNamePath).get("project");
  }

  /**
   * Extracts the sink from the given fully-qualified path which
   * represents a sinkName resource.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String extractSinkFromSinkNamePath(String sinkNamePath) {
    return SINK_NAME_PATH_TEMPLATE.parse(sinkNamePath).get("sink");
  }


  // =============
  // Service Calls
  // =============

  // ----- listSinks -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists sinks.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public Iterable<LogSink> listSinks(String projectName) {
    ListSinksRequest request =
        ListSinksRequest.newBuilder()
        .setProjectName(projectName)
        .build();
    return listSinks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists sinks.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public Iterable<LogSink> listSinks(ListSinksRequest request) {
    return listSinksStreamingCallable()
        .iterableResponseStreamCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists sinks.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<ListSinksRequest, LogSink> listSinksStreamingCallable() {
    return listSinksCallable().pageStreaming(LIST_SINKS_PAGE_DESC);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists sinks.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<ListSinksRequest, ListSinksResponse> listSinksCallable() {
    return ApiUtils.prepareIdempotentCallable(LIST_SINKS, settings).bind(channel);
  }

  // ----- getSink -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets a sink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param sinkName The resource name of the sink to return.
   * Example: `"projects/my-project-id/sinks/my-sink-id"`.
   */
  public LogSink getSink(String sinkName) {
    GetSinkRequest request =
        GetSinkRequest.newBuilder()
        .setSinkName(sinkName)
        .build();

    return getSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets a sink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public LogSink getSink(GetSinkRequest request) {
    return getSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Gets a sink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<GetSinkRequest, LogSink> getSinkCallable() {
    return ApiUtils.prepareIdempotentCallable(GET_SINK, settings).bind(channel);
  }

  // ----- createSink -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a sink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param projectName The resource name of the project in which to create the sink.
   * Example: `"projects/my-project-id"`.
   *
   * The new sink must be provided in the request.
   * @param sink The new sink, which must not have an identifier that already
   * exists.
   */
  public LogSink createSink(String projectName, LogSink sink) {
    CreateSinkRequest request =
        CreateSinkRequest.newBuilder()
        .setProjectName(projectName)
        .setSink(sink)
        .build();

    return createSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a sink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public LogSink createSink(CreateSinkRequest request) {
    return createSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates a sink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<CreateSinkRequest, LogSink> createSinkCallable() {
    return CREATE_SINK.bind(channel);
  }

  // ----- updateSink -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates or updates a sink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param sinkName The resource name of the sink to update.
   * Example: `"projects/my-project-id/sinks/my-sink-id"`.
   *
   * The updated sink must be provided in the request and have the
   * same name that is specified in `sinkName`.  If the sink does not
   * exist, it is created.
   * @param sink The updated sink, whose name must be the same as the sink
   * identifier in `sinkName`.  If `sinkName` does not exist, then
   * this method creates a new sink.
   */
  public LogSink updateSink(String sinkName, LogSink sink) {
    UpdateSinkRequest request =
        UpdateSinkRequest.newBuilder()
        .setSinkName(sinkName)
        .setSink(sink)
        .build();

    return updateSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates or updates a sink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public LogSink updateSink(UpdateSinkRequest request) {
    return updateSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Creates or updates a sink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<UpdateSinkRequest, LogSink> updateSinkCallable() {
    return ApiUtils.prepareIdempotentCallable(UPDATE_SINK, settings).bind(channel);
  }

  // ----- deleteSink -----

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes a sink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param sinkName The resource name of the sink to delete.
   * Example: `"projects/my-project-id/sinks/my-sink-id"`.
   */
  public void deleteSink(String sinkName) {
    DeleteSinkRequest request =
        DeleteSinkRequest.newBuilder()
        .setSinkName(sinkName)
        .build();

    deleteSink(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes a sink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   *
   * @param request The request object containing all of the parameters for the API call.
   */
  public void deleteSink(DeleteSinkRequest request) {
    deleteSinkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Deletes a sink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<DeleteSinkRequest, Empty> deleteSinkCallable() {
    return ApiUtils.prepareIdempotentCallable(DELETE_SINK, settings).bind(channel);
  }


  // ========
  // Cleanup
  // ========

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  @Override
  public void close() {
    // Manually-added shutdown code

    // Auto-generated shutdown code
    channel.shutdown();

    // Manually-added shutdown code
  }


  // ========
  // Manually-added methods: add custom (non-generated) methods after this point.
  // ========

}
