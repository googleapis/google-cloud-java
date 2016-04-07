/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.dns.spi;

import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.ManagedZonesListResponse;
import com.google.api.services.dns.model.Project;

import java.util.Map;

/**
 * An interface for the collection of batch operations.
 */
public interface RpcBatch {

  /**
   * Adds a call to "list zones" to the batch with the provided {@code callback} and {@code
   * options}.
   */
  void addListZones(DnsRpc.Callback<ManagedZonesListResponse> callback,
      Map<DnsRpc.Option, ?> options);

  /**
   * Adds a call to "create zone" to the batch with the provided {@code callback} and {@code
   * options}.
   */
  void addCreateZone(ManagedZone zone, DnsRpc.Callback<ManagedZone> callback,
      Map<DnsRpc.Option, ?> options);

  /**
   * Adds a call to "get zone" to the batch with the provided {@code callback} and {@code options}.
   */
  void addGetZone(String zoneName, DnsRpc.Callback<ManagedZone> callback,
      Map<DnsRpc.Option, ?> options);

  /**
   * Adds a call to "delete zone" to the batch with the provided {@code callback} and {@code
   * options}.
   */
  void addGetProject(DnsRpc.Callback<Project> callback,
      Map<DnsRpc.Option, ?> options);

  /**
   * Adds a call to "get project" to the batch with the provided {@code callback} and {@code
   * options}.
   */
  void addDeleteZone(String zoneName, DnsRpc.Callback<Void> callback);

  /**
   * Submits a batch of requests for processing using a single HTTP request to Cloud DNS.
   */
  void submit();
}

