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

import com.google.api.gax.core.BackoffParams;
import com.google.api.gax.core.ConnectionSettings;
import com.google.api.gax.core.RetryParams;
import com.google.api.gax.grpc.ApiCallSettings;
import com.google.api.gax.grpc.ApiCallable.ApiCallableBuilder;
import com.google.api.gax.grpc.ApiCallable.PageStreamingApiCallableBuilder;
import com.google.api.gax.grpc.PageDescriptor;
import com.google.api.gax.grpc.ServiceApiSettings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.logging.v2.ConfigServiceV2Grpc;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.protobuf.Empty;

import io.grpc.Status;

// Manually-added imports: add custom (non-generated) imports after this point.

// AUTO-GENERATED DOCUMENTATION AND CLASS - see instructions at the top of the file for editing.
@javax.annotation.Generated("by GAPIC")
public class ConfigServiceV2Settings extends ServiceApiSettings {

  // =========
  // Constants
  // =========

  /**
   * The default address of the service.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String DEFAULT_SERVICE_ADDRESS = "logging.googleapis.com";

  /**
   * The default port of the service.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final int DEFAULT_SERVICE_PORT = 443;

  /**
   * The default scopes of the service.
   */
  public static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/logging.write")
          .add("https://www.googleapis.com/auth/logging.admin")
          .add("https://www.googleapis.com/auth/logging.read")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private static final ImmutableMap<String, ImmutableSet<Status.Code>> RETRYABLE_CODE_DEFINITIONS;

  static {
    ImmutableMap.Builder<String, ImmutableSet<Status.Code>> definitions = ImmutableMap.builder();
    definitions.put(
        "idempotent",
        Sets.immutableEnumSet(
            Lists.<Status.Code>newArrayList(
                Status.Code.DEADLINE_EXCEEDED, Status.Code.UNAVAILABLE)));
    definitions.put("non_idempotent", Sets.immutableEnumSet(Lists.<Status.Code>newArrayList()));
    RETRYABLE_CODE_DEFINITIONS = definitions.build();
  }

  private static final ImmutableMap<String, RetryParams> RETRY_PARAM_DEFINITIONS;

  static {
    ImmutableMap.Builder<String, RetryParams> definitions = ImmutableMap.builder();
    RetryParams params = null;
    params =
        RetryParams.newBuilder()
            .setRetryBackoff(
                BackoffParams.newBuilder()
                    .setInitialDelayMillis(100L)
                    .setDelayMultiplier(1.2)
                    .setMaxDelayMillis(1000L)
                    .build())
            .setTimeoutBackoff(
                BackoffParams.newBuilder()
                    .setInitialDelayMillis(300L)
                    .setDelayMultiplier(1.3)
                    .setMaxDelayMillis(3000L)
                    .build())
            .setTotalTimeout(30000L)
            .build();
    definitions.put("default", params);
    RETRY_PARAM_DEFINITIONS = definitions.build();
  }

  private static class MethodBuilders {
    private final PageStreamingApiCallableBuilder<ListSinksRequest, ListSinksResponse, LogSink>
        listSinksMethod;
    private final ApiCallableBuilder<GetSinkRequest, LogSink> getSinkMethod;
    private final ApiCallableBuilder<CreateSinkRequest, LogSink> createSinkMethod;
    private final ApiCallableBuilder<UpdateSinkRequest, LogSink> updateSinkMethod;
    private final ApiCallableBuilder<DeleteSinkRequest, Empty> deleteSinkMethod;
    private final ImmutableList<? extends ApiCallSettings> allMethods;

    public MethodBuilders() {
      listSinksMethod =
          new PageStreamingApiCallableBuilder<>(
              ConfigServiceV2Grpc.METHOD_LIST_SINKS, LIST_SINKS_PAGE_STR_DESC);
      listSinksMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      listSinksMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      getSinkMethod = new ApiCallableBuilder<>(ConfigServiceV2Grpc.METHOD_GET_SINK);
      getSinkMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      getSinkMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      createSinkMethod = new ApiCallableBuilder<>(ConfigServiceV2Grpc.METHOD_CREATE_SINK);
      createSinkMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"));
      createSinkMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      updateSinkMethod = new ApiCallableBuilder<>(ConfigServiceV2Grpc.METHOD_UPDATE_SINK);
      updateSinkMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"));
      updateSinkMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      deleteSinkMethod = new ApiCallableBuilder<>(ConfigServiceV2Grpc.METHOD_DELETE_SINK);
      deleteSinkMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      deleteSinkMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      allMethods =
          ImmutableList.<ApiCallSettings>builder()
              .add(
                  listSinksMethod,
                  getSinkMethod,
                  createSinkMethod,
                  updateSinkMethod,
                  deleteSinkMethod)
              .build();
    }
  }

  private final MethodBuilders methods;

  // ===============
  // Factory Methods
  // ===============

  /**
   * Constructs an instance of ConfigServiceV2Settings with default settings.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static ConfigServiceV2Settings create() {
    ConfigServiceV2Settings settings = new ConfigServiceV2Settings(new MethodBuilders());
    settings.provideChannelWith(
        ConnectionSettings.builder()
            .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
            .setPort(DEFAULT_SERVICE_PORT)
            .provideCredentialsWith(DEFAULT_SERVICE_SCOPES)
            .build());
    return settings;
  }

  /**
   * Constructs an instance of ConfigServiceV2Settings with default settings. This is protected so
   * that it easy to make a subclass, but otherwise, the static factory methods should be preferred.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  protected ConfigServiceV2Settings(MethodBuilders methods) {
    super(methods.allMethods);
    this.methods = methods;
  }

  /**
   * Returns the PageStreamingApiCallableBuilder for the API method listSinks.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public PageStreamingApiCallableBuilder<ListSinksRequest, ListSinksResponse, LogSink>
      listSinksMethod() {
    return methods.listSinksMethod;
  }

  /**
   * Returns the ApiCallableBuilder for the API method getSink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<GetSinkRequest, LogSink> getSinkMethod() {
    return methods.getSinkMethod;
  }

  /**
   * Returns the ApiCallableBuilder for the API method createSink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<CreateSinkRequest, LogSink> createSinkMethod() {
    return methods.createSinkMethod;
  }

  /**
   * Returns the ApiCallableBuilder for the API method updateSink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<UpdateSinkRequest, LogSink> updateSinkMethod() {
    return methods.updateSinkMethod;
  }

  /**
   * Returns the ApiCallableBuilder for the API method deleteSink.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<DeleteSinkRequest, Empty> deleteSinkMethod() {
    return methods.deleteSinkMethod;
  }

  private static PageDescriptor<ListSinksRequest, ListSinksResponse, LogSink>
      LIST_SINKS_PAGE_STR_DESC =
          new PageDescriptor<ListSinksRequest, ListSinksResponse, LogSink>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListSinksRequest injectToken(ListSinksRequest payload, Object token) {
              return ListSinksRequest.newBuilder(payload).setPageToken((String) token).build();
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
}
