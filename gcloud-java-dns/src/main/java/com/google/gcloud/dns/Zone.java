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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.gcloud.Page;

import java.io.Serializable;

/**
 * A Google Cloud DNS Zone object.
 *
 * <p>A zone is the container for all of your DNS records that share the same DNS name prefix, for
 * example, example.com. Zones are automatically assigned a set of name servers when they are
 * created to handle responding to DNS queries for that zone. A zone has quotas for the number of
 * resource records that it can include.
 *
 * @see <a href="https://cloud.google.com/dns/zones/">Google Cloud DNS managed zone
 * documentation</a>
 */
public class Zone implements Serializable {

  // TODO(mderka) Zone and zoneInfo to be merged. Opened issue #605.

  private static final long serialVersionUID = 6847890192129375500L;
  private final ZoneInfo zoneInfo;
  private final Dns dns;

  /**
   * Constructs a {@code Zone} object that contains the given {@code zoneInfo}.
   */
  public Zone(Dns dns, ZoneInfo zoneInfo) {
    this.zoneInfo = checkNotNull(zoneInfo);
    this.dns = checkNotNull(dns);
  }

  /**
   * Constructs a {@code Zone} object that contains meta information received from the Google Cloud
   * DNS service for the provided {@code zoneName}.
   *
   * @param zoneName name of the zone to be searched for
   * @param options optional restriction on what fields should be returned by the service
   * @return zone object containing metadata or {@code null} if not not found
   * @throws DnsException upon failure
   */
  public static Zone get(Dns dnsService, String zoneName, Dns.ZoneOption... options) {
    checkNotNull(zoneName);
    checkNotNull(dnsService);
    ZoneInfo zoneInfo = dnsService.getZone(zoneName, options);
    return zoneInfo == null ? null : new Zone(dnsService, zoneInfo);
  }

  /**
   * Retrieves the latest information about the zone. The method retrieves the zone by name.
   *
   * @param options optional restriction on what fields should be fetched
   * @return zone object containing updated information or {@code null} if not not found
   * @throws DnsException upon failure
   */
  public Zone reload(Dns.ZoneOption... options) {
    return Zone.get(dns, zoneInfo.name(), options);
  }

  /**
   * Deletes the zone. The method deletes the zone by name.
   *
   * @return {@code true} is zone was found and deleted and {@code false} otherwise
   * @throws DnsException upon failure
   */
  public boolean delete() {
    return dns.delete(zoneInfo.name());
  }

  /**
   * Lists all {@link DnsRecord}s associated with this zone. The method searches for zone by name.
   *
   * @param options optional restriction on listing and fields of {@link DnsRecord}s returned
   * @return a page of DNS records
   * @throws DnsException upon failure or if the zone is not found
   */
  public Page<DnsRecord> listDnsRecords(Dns.DnsRecordListOption... options) {
    return dns.listDnsRecords(zoneInfo.name(), options);
  }

  /**
   * Submits {@link ChangeRequest} to the service for it to applied to this zone. The method
   * searches for zone by name.
   *
   * @param options optional restriction on what fields of {@link ChangeRequest} should be returned
   * @return ChangeRequest with server-assigned ID
   * @throws DnsException upon failure or if the zone is not found
   */
  public ChangeRequest applyChangeRequest(ChangeRequest changeRequest,
      Dns.ChangeRequestOption... options) {
    checkNotNull(changeRequest);
    return dns.applyChangeRequest(zoneInfo.name(), changeRequest, options);
  }

  /**
   * Retrieves an updated information about a change request previously submitted to be applied to
   * this zone. Returns a {@link ChangeRequest} or {@code null} if the change request was not found.
   * Throws {@link DnsException} if the zone is not found.
   *
   * @param options optional restriction on what fields of {@link ChangeRequest} should be returned
   * @return updated ChangeRequest
   * @throws DnsException upon failure or if the zone is not found
   * @throws NullPointerException if {@code changeRequestId} is null
   */
  public ChangeRequest getChangeRequest(String changeRequestId,
      Dns.ChangeRequestOption... options) {
    checkNotNull(changeRequestId);
    return dns.getChangeRequest(zoneInfo.name(), changeRequestId, options);
  }

  /**
   * Retrieves all change requests for this zone. The method searches for zone by name. Returns a
   * page of {@link ChangeRequest}s.
   *
   * @param options optional restriction on listing and fields to be returned
   * @return a page of change requests
   * @throws DnsException upon failure or if the zone is not found
   */
  public Page<ChangeRequest> listChangeRequests(Dns.ChangeRequestListOption... options) {
    return dns.listChangeRequests(zoneInfo.name(), options);
  }

  /**
   * Returns the {@link ZoneInfo} object containing information about this zone.
   */
  public ZoneInfo info() {
    return zoneInfo;
  }

  /**
   * Returns the {@link Dns} service object associated with this zone.
   */
  public Dns dns() {
    return this.dns;
  }
}
