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

package com.google.cloud.dns.spi.v1;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ChangesListResponse;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.ManagedZonesListResponse;
import com.google.api.services.dns.model.Project;
import com.google.api.services.dns.model.ResourceRecordSetsListResponse;
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
   * Adds a call to "list zones" to the batch with the provided {@code callback} and {@code
   * options}.
   */
  void addListZones(Callback<ManagedZonesListResponse> callback, Map<DnsRpc.Option, ?> options);

  /**
   * Adds a call to "create zone" to the batch with the provided {@code callback} and {@code
   * options}.
   */
  void addCreateZone(
      ManagedZone zone, Callback<ManagedZone> callback, Map<DnsRpc.Option, ?> options);

  /**
   * Adds a call to "get zone" to the batch with the provided {@code callback} and {@code options}.
   * The zone to be retrieved is identified by {@code zoneName}.
   */
  void addGetZone(String zoneName, Callback<ManagedZone> callback, Map<DnsRpc.Option, ?> options);

  /**
   * Adds a call to "get project" to the batch with the provided {@code callback} and {@code
   * options}.
   */
  void addGetProject(Callback<Project> callback, Map<DnsRpc.Option, ?> options);

  /**
   * Adds a call to "delete zone" to the batch with the provided {@code callback}. The zone to be
   * deleted is identified by {@code zoneName}.
   */
  void addDeleteZone(String zoneName, Callback<Void> callback);

  /**
   * Adds a call to "list record sets" to the batch with the provided {@code callback} and {@code
   * options}. The zone whose record sets are to be listed is identified by {@code zoneName}.
   */
  void addListRecordSets(
      String zoneName,
      Callback<ResourceRecordSetsListResponse> callback,
      Map<DnsRpc.Option, ?> options);

  /**
   * Adds a call to "list change requests" to the batch with the provided {@code callback} and
   * {@code options}. The zone whose change requests are to be listed is identified by {@code
   * zoneName}.
   */
  void addListChangeRequests(
      String zoneName, Callback<ChangesListResponse> callback, Map<DnsRpc.Option, ?> options);

  /**
   * Adds a call to "get change request" to the batch with the provided {@code callback} and {@code
   * options}. The change request to be retrieved is identified by {@code changeRequestId}. The zone
   * to which the change request was applied is identified by {@code zoneName}.
   */
  void addGetChangeRequest(
      String zoneName,
      String changeRequestId,
      Callback<Change> callback,
      Map<DnsRpc.Option, ?> options);

  /**
   * Adds a call to "apply change request" to the batch with the provided {@code callback} and
   * {@code options}. The parameter {@code change} is the change request to be applied. The zone to
   * which the change request should be applied is identified by {@code zoneName}.
   */
  void addApplyChangeRequest(
      String zoneName, Change change, Callback<Change> callback, Map<DnsRpc.Option, ?> options);

  /** Submits a batch of requests for processing using a single RPC request to Cloud DNS. */
  void submit();
}
