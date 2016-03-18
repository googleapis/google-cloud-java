/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.protobuf.Empty;

import io.grpc.ManagedChannel;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Manually-added imports: add custom (non-generated) imports after this point.

// AUTO-GENERATED DOCUMENTATION AND SERVICE - see instructions at the top of the file for editing.
/**
 * Service Description: See src/api/google/logging/v2/logging.proto for documentation
 *
 * <!-- manual edit -->
 * <!-- end manual edit -->
 */
@javax.annotation.Generated("by GAPIC")
public class ConfigServiceV2Api implements AutoCloseable {

  public static class ResourceNames {
    private ResourceNames() {}

    // =======================
    // ResourceNames Constants
    // =======================

    /**
     * A PathTemplate representing the fully-qualified path to represent
     * a project resource.
     *
     * <!-- manual edit -->
     * <!-- end manual edit -->
     */
    private static final PathTemplate PROJECT_PATH_TEMPLATE =
        PathTemplate.create("projects/{project}");

    /**
     * A PathTemplate representing the fully-qualified path to represent
     * a sink resource.
     *
     * <!-- manual edit -->
     * <!-- end manual edit -->
     */
    private static final PathTemplate SINK_PATH_TEMPLATE =
        PathTemplate.create("projects/{project}/sinks/{sink}");

    // ==============================
    // Resource Name Helper Functions
    // ==============================

    /**
     * Formats a string containing the fully-qualified path to represent
     * a project resource.
     *
     * <!-- manual edit -->
     * <!-- end manual edit -->
     */
    public static final String formatProjectPath(String project) {
      return PROJECT_PATH_TEMPLATE.instantiate("project", project);
    }

    /**
     * Formats a string containing the fully-qualified path to represent
     * a sink resource.
     *
     * <!-- manual edit -->
     * <!-- end manual edit -->
     */
    public static final String formatSinkPath(String project, String sink) {
      return SINK_PATH_TEMPLATE.instantiate("project", project, "sink", sink);
    }

    /**
     * Parses the project from the given fully-qualified path which
     * represents a project resource.
     *
     * <!-- manual edit -->
     * <!-- end manual edit -->
     */
    public static final String parseProjectFromProjectPath(String projectPath) {
      return PROJECT_PATH_TEMPLATE.parse(projectPath).get("project");
    }

    /**
     * Parses the project from the given fully-qualified path which
     * represents a sink resource.
     *
     * <!-- manual edit -->
     * <!-- end manual edit -->
     */
    public static final String parseProjectFromSinkPath(String sinkPath) {
      return SINK_PATH_TEMPLATE.parse(sinkPath).get("project");
    }

    /**
     * Parses the sink from the given fully-qualified path which
     * represents a sink resource.
     *
     * <!-- manual edit -->
     * <!-- end manual edit -->
     */
    public static final String parseSinkFromSinkPath(String sinkPath) {
      return SINK_PATH_TEMPLATE.parse(sinkPath).get("sink");
    }
  }

  // ========
  // Members
  // ========

  private final ManagedChannel channel;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<ListSinksRequest, ListSinksResponse> listSinksCallable;
  private final ApiCallable<ListSinksRequest, Iterable<LogSink>> listSinksIterableCallable;
  private final ApiCallable<GetSinkRequest, LogSink> getSinkCallable;
  private final ApiCallable<CreateSinkRequest, LogSink> createSinkCallable;
  private final ApiCallable<UpdateSinkRequest, LogSink> updateSinkCallable;
  private final ApiCallable<DeleteSinkRequest, Empty> deleteSinkCallable;

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
    return create(ConfigServiceV2Settings.create());
  }

  /**
   * Constructs an instance of ConfigServiceV2Api, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static ConfigServiceV2Api create(ConfigServiceV2Settings settings) throws IOException {
    return new ConfigServiceV2Api(settings);
  }

  /**
   * Constructs an instance of ConfigServiceV2Api, using the given settings. This is protected so
   * that it easy to make a subclass, but otherwise, the static factory methods should be preferred.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  protected ConfigServiceV2Api(ConfigServiceV2Settings settings) throws IOException {
    this.channel = settings.getChannel();

    this.listSinksCallable = settings.listSinksMethod().build(settings);
    this.listSinksIterableCallable = settings.listSinksMethod().buildPageStreaming(settings);
    this.getSinkCallable = settings.getSinkMethod().build(settings);
    this.createSinkCallable = settings.createSinkMethod().build(settings);
    this.updateSinkCallable = settings.updateSinkMethod().build(settings);
    this.deleteSinkCallable = settings.deleteSinkMethod().build(settings);

    closeables.add(
        new Closeable() {
          @Override
          public void close() throws IOException {
            channel.shutdown();
          }
        });
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
    ListSinksRequest request = ListSinksRequest.newBuilder().setProjectName(projectName).build();
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
    return listSinksIterableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists sinks.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<ListSinksRequest, Iterable<LogSink>> listSinksIterableCallable() {
    return listSinksIterableCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD - see instructions at the top of the file for editing.
  /**
   * Lists sinks.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallable<ListSinksRequest, ListSinksResponse> listSinksCallable() {
    return listSinksCallable;
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
    GetSinkRequest request = GetSinkRequest.newBuilder().setSinkName(sinkName).build();

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
  private LogSink getSink(GetSinkRequest request) {
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
    return getSinkCallable;
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
        CreateSinkRequest.newBuilder().setProjectName(projectName).setSink(sink).build();

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
    return createSinkCallable;
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
        UpdateSinkRequest.newBuilder().setSinkName(sinkName).setSink(sink).build();

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
    return updateSinkCallable;
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
    DeleteSinkRequest request = DeleteSinkRequest.newBuilder().setSinkName(sinkName).build();

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
  private void deleteSink(DeleteSinkRequest request) {
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
    return deleteSinkCallable;
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
  public void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }

  // ========
  // Manually-added methods: add custom (non-generated) methods after this point.
  // ========

}
