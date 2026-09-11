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

package com.google.cloud.firestore;

import com.google.api.core.InternalApi;
import com.google.firestore.v1.RequestOptions;
import java.util.List;
import javax.annotation.Nullable;

/** Helper class for building and merging Firestore request options. */
@InternalApi
public final class RequestOptionsHelper {

  private RequestOptionsHelper() {}

  /**
   * Creates a merged {@link RequestOptions} proto instance combining request-level options from
   * {@link FirestoreExecutionOptions} with instance-level tags.
   */
  public static RequestOptions createRequestOptions(
      @Nullable FirestoreOptions firestoreOptions,
      @Nullable FirestoreExecutionOptions executionOptions) {
    return createRequestOptions(
        firestoreOptions, executionOptions != null ? executionOptions.getRequestOptions() : null);
  }

  /**
   * Creates a merged {@link RequestOptions} proto instance combining model {@link
   * com.google.cloud.firestore.models.RequestOptions} with instance-level tags.
   */
  public static RequestOptions createRequestOptions(
      @Nullable FirestoreOptions firestoreOptions,
      @Nullable com.google.cloud.firestore.models.RequestOptions requestOptions) {
    return createRequestOptions(
        firestoreOptions, requestOptions != null ? requestOptions.toPb() : null);
  }

  /**
   * Creates a merged {@link RequestOptions} proto instance combining request-level proto options
   * with instance-level tags.
   */
  public static RequestOptions createRequestOptions(
      @Nullable FirestoreOptions firestoreOptions, @Nullable RequestOptions requestOptions) {
    List<String> instanceTags = firestoreOptions != null ? firestoreOptions.getRequestTags() : null;
    boolean hasInstanceTags = instanceTags != null && !instanceTags.isEmpty();
    boolean hasRequestOptions = requestOptions != null && requestOptions.getRequestTagsCount() > 0;

    if (!hasInstanceTags && !hasRequestOptions) {
      return requestOptions != null ? requestOptions : RequestOptions.getDefaultInstance();
    }

    RequestOptions.Builder builder = RequestOptions.newBuilder();
    if (requestOptions != null) {
      builder.mergeFrom(requestOptions);
    }
    if (hasInstanceTags) {
      builder.addAllRequestTags(instanceTags);
    }
    return builder.build();
  }
}
