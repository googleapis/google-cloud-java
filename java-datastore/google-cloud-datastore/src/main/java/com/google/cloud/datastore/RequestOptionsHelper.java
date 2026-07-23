/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore;

import com.google.api.core.InternalApi;
import com.google.common.base.Preconditions;
import com.google.datastore.v1.RequestOptions;
import javax.annotation.Nonnull;

/** Helper class for building and merging Datastore request options. */
@InternalApi
public final class RequestOptionsHelper {

  private RequestOptionsHelper() {}

  /**
   * Creates a merged {@link RequestOptions} instance containing both the instance-level tags and
   * the request-level options from {@link DatastoreExecutionOptions}.
   *
   * @param datastoreOptions the global Datastore options containing instance-level tags
   * @param executionOptions the execution options containing request-level options
   * @return the merged RequestOptions proto message
   */
  public static RequestOptions createRequestOptions(
      DatastoreOptions datastoreOptions, @Nonnull DatastoreExecutionOptions executionOptions) {
    Preconditions.checkNotNull(executionOptions, "executionOptions cannot be null");
    return createRequestOptions(datastoreOptions, executionOptions.getRequestOptions());
  }

  /**
   * Creates a merged {@link RequestOptions} instance containing both the instance-level tags and
   * the request-level options.
   *
   * @param datastoreOptions the global Datastore options containing instance-level tags
   * @param requestOptions the individual request-level options, or {@code null}
   * @return the merged RequestOptions proto message
   */
  public static RequestOptions createRequestOptions(
      DatastoreOptions datastoreOptions, RequestOptions requestOptions) {
    RequestOptions.Builder builder = RequestOptions.newBuilder();
    if (requestOptions != null) {
      // copy existing options. This copies the request level tags as well.
      builder.mergeFrom(requestOptions);
    }

    // add instance-level tags.
    builder.addAllRequestTags(datastoreOptions.getRequestTags());
    return builder.build();
  }
}
