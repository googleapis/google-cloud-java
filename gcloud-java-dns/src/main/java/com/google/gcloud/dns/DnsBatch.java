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

package com.google.gcloud.dns;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.HttpHeaders;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.ManagedZonesListResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.gcloud.Page;
import com.google.gcloud.PageImpl;
import com.google.gcloud.dns.spi.DnsRpc;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * A batch of operations to be submitted to Google Cloud DNS using a single HTTP request.
 */
public class DnsBatch {

  private final BatchRequest batch;
  private transient DnsRpc dnsRpc;
  private final DnsOptions options;

  DnsBatch(DnsOptions options) {
    this.options = options;
    this.dnsRpc = options.rpc();
    this.batch = dnsRpc.createBatch();
  }

  /**
   * Adds a request representing the list zones operation to this batch. The
   * request will not have initialized any fields except for the operation type and options (if
   * provided). The {@code options} can be used to restrict the fields returned or provide page size
   * limits in the same way as for {@link Dns#listZones(Dns.ZoneListOption...)}.
   */
  public DnsBatchResult<Page<Zone>> listZones(Dns.ZoneListOption... options) {
    DnsBatchResult<Page<Zone>> result = new DnsBatchResult<>();
    final Map<DnsRpc.Option, ?> optionMap = optionMap(options);
    JsonBatchCallback callback = listZonesCallback(this.options, result, optionMap);
    dnsRpc.prepareListZones(this.batch, callback, optionMap);
    return result;
  }

  /**
   * Submits this batch for processing using a single HTTP request.
   */
  public void submit() {
    dnsRpc.submitBatch(batch);
  }

  // todo(mderka) make methods to prepare other callbacks
  private JsonBatchCallback listZonesCallback(final DnsOptions serviceOptions,
      final DnsBatchResult result, final Map<DnsRpc.Option, ?> optionMap) {
    JsonBatchCallback callback = new JsonBatchCallback<ManagedZonesListResponse>() {
      @Override
      public void onSuccess(ManagedZonesListResponse response, HttpHeaders httpHeaders)
          throws IOException {
        List<ManagedZone> zones = response.getManagedZones();
        Page<Zone> zonePage = new PageImpl<>(
            new DnsImpl.ZonePageFetcher(options, response.getNextPageToken(), optionMap),
            response.getNextPageToken(), zones == null ? ImmutableList.<Zone>of()
            : Iterables.transform(zones, DnsImpl.pbToZoneFunction(serviceOptions)));
        result.success(zonePage);
      }

      @Override
      public void onFailure(GoogleJsonError googleJsonError, HttpHeaders httpHeaders)
          throws IOException {
        result.error(new DnsException(googleJsonError));
      }
    };
    return callback;
  }

  private Map<DnsRpc.Option, ?> optionMap(AbstractOption... options) {
    Map<DnsRpc.Option, Object> temp = Maps.newEnumMap(DnsRpc.Option.class);
    for (AbstractOption option : options) {
      Object prev = temp.put(option.rpcOption(), option.value());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return ImmutableMap.copyOf(temp);
  }
}
