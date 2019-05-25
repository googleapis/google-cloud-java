/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.storage.spi.v1;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.services.storage.model.StorageObject;
import java.util.Map;

/** An interface for the collection of batch operations. */
public interface RpcBatch {

  /** An interface for batch callbacks. */
  interface Callback<T> {

    /** This method will be called upon success of the batch operation. */
    void onSuccess(T response);

    /** This method will be called upon failure of the batch operation. */
    void onFailure(GoogleJsonError googleJsonError);
  }

  /**
   * Adds a call to "delete storage object" to the batch, with the provided {@code callback} and
   * {@code options}.
   */
  void addDelete(
      StorageObject storageObject, Callback<Void> callback, Map<StorageRpc.Option, ?> options);

  /**
   * Adds a call to "patch storage object" to the batch, with the provided {@code callback} and
   * {@code options}.
   */
  void addPatch(
      StorageObject storageObject,
      Callback<StorageObject> callback,
      Map<StorageRpc.Option, ?> options);

  /**
   * Adds a call to "get storage object" to the batch, with the provided {@code callback} and {@code
   * options}.
   */
  void addGet(
      StorageObject storageObject,
      Callback<StorageObject> callback,
      Map<StorageRpc.Option, ?> options);

  /** Submits a batch of requests for processing using a single RPC request to Cloud Storage. */
  void submit();
}
