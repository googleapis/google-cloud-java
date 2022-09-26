/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigquery;

import com.google.auto.value.AutoValue;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

/** Represents Remote Function Options. Options for a remote user-defined function. */
@AutoValue
public abstract class RemoteFunctionOptions implements Serializable {

  private static final long serialVersionUID = -7334249450657429792L;

  @AutoValue.Builder
  public abstract static class Builder {

    /**
     * Sets Endpoint argument Endpoint of the user-provided remote service, e.g.
     * ```https://us-east1-my_gcf_project.cloudfunctions.net/remote_add```
     */
    public abstract Builder setEndpoint(String endpoint);

    /**
     * Fully qualified name of the user-provided connection object which holds the authentication
     * information to send requests to the remote service. Format:
     * ```\"projects/{projectId}/locations/{locationId}/connections/{connectionId}\"```
     */
    public abstract Builder setConnection(String connection);

    /**
     * User-defined context as a set of key/value pairs, which will be sent as function invocation
     * context together with batched arguments in the requests to the remote service. The total
     * number of bytes of keys and values must be less than 8KB.
     */
    public abstract Builder setUserDefinedContext(Map<String, String> userDefinedContext);

    /**
     * Max number of rows in each batch sent to the remote service. If absent or if 0, BigQuery
     * dynamically decides the number of rows in a batch.
     */
    public abstract Builder setMaxBatchingRows(Long maxBatchingRows);

    /** Creates a {@code RemoteFunctionOptions} object. */
    public abstract RemoteFunctionOptions build();
  }

  /**
   * Returns the endpoint of the user-provided service.
   *
   * @return String
   */
  @Nullable
  public abstract String getEndpoint();

  /**
   * Returns the fully qualified name of the user-provided connection object.
   *
   * @return String
   */
  @Nullable
  public abstract String getConnection();

  /**
   * Returns the user-defined context as a set of key/value pairs.
   *
   * @return Map<String, String>
   */
  @Nullable
  public abstract Map<String, String> getUserDefinedContext();

  /**
   * Returns max number of rows in each batch sent to the remote service.
   *
   * @return Long
   */
  @Nullable
  public abstract Long getMaxBatchingRows();

  /**
   * Returns a builder pre-populated using the current values of this {@code RemoteFunctionOptions}.
   */
  public abstract RemoteFunctionOptions.Builder toBuilder();

  /** Returns a builder for a {@Code RemoteFunctionOptions} object. */
  public static RemoteFunctionOptions.Builder newBuilder() {
    return new AutoValue_RemoteFunctionOptions.Builder();
  }

  public com.google.api.services.bigquery.model.RemoteFunctionOptions toPb() {
    com.google.api.services.bigquery.model.RemoteFunctionOptions remoteFunctionOptions =
        new com.google.api.services.bigquery.model.RemoteFunctionOptions();
    if (getEndpoint() != null) {
      remoteFunctionOptions.setEndpoint(getEndpoint());
    }
    if (getConnection() != null) {
      remoteFunctionOptions.setConnection(getConnection());
    }
    if (getUserDefinedContext() != null) {
      remoteFunctionOptions.setUserDefinedContext(getUserDefinedContext());
    }
    if (getMaxBatchingRows() != null) {
      remoteFunctionOptions.setMaxBatchingRows(getMaxBatchingRows());
    }
    return remoteFunctionOptions;
  }

  static RemoteFunctionOptions fromPb(
      com.google.api.services.bigquery.model.RemoteFunctionOptions remoteFunctionOptionsPb) {
    RemoteFunctionOptions.Builder builder = newBuilder();
    if (remoteFunctionOptionsPb.getEndpoint() != null) {
      builder.setEndpoint(remoteFunctionOptionsPb.getEndpoint());
    }
    if (remoteFunctionOptionsPb.getConnection() != null) {
      builder.setConnection(remoteFunctionOptionsPb.getConnection());
    }
    if (remoteFunctionOptionsPb.getUserDefinedContext() != null) {
      builder.setUserDefinedContext(remoteFunctionOptionsPb.getUserDefinedContext());
    }
    if (remoteFunctionOptionsPb.getMaxBatchingRows() != null) {
      builder.setMaxBatchingRows(remoteFunctionOptionsPb.getMaxBatchingRows());
    }
    return builder.build();
  }
}
