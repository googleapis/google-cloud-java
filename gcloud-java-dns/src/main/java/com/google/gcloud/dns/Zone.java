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
import java.math.BigInteger;

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

  private static final long serialVersionUID = -4012581571095484813L;
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
   * DNS service for the provided zoneName.
   *
   * @param zoneName Name of the zone to be searched for
   * @param options Optional restriction on what fields should be returned by the service
   * @return Zone object containing metadata or null if not not found
   * @throws DnsException upon failure
   */
  public static Zone get(Dns dnsService, String zoneName,
                         Dns.ZoneOption... options) {
    checkNotNull(zoneName);
    checkNotNull(dnsService);
    ZoneInfo zoneInfo = dnsService.getZone(zoneName, options);
    return zoneInfo == null ? null : new Zone(dnsService, zoneInfo);
  }

  /**
   * Constructs a {@code Zone} object that contains meta information received from the Google Cloud
   * DNS service for the provided zoneName.
   *
   * @param zoneId ID of the zone to be searched for
   * @param options Optional restriction on what fields should be returned by the service
   * @return Zone object containing metadata or null if not not found
   * @throws DnsException upon failure
   */
  public static Zone get(Dns dnsService, BigInteger zoneId,
                         Dns.ZoneOption... options) {
    checkNotNull(zoneId);
    checkNotNull(dnsService);
    ZoneInfo zoneInfo = dnsService.getZone(zoneId, options);
    return zoneInfo == null ? null : new Zone(dnsService, zoneInfo);
  }

  /**
   * Retrieves the latest information about the zone. The method first attempts to retrieve the zone
   * by ID and if not set or zone is not found, it searches by name.
   *
   * @param options Optional restriction on what fields should be fetched
   * @return Zone object containing updated metadata or null if not not found
   * @throws DnsException upon failure
   * @throws NullPointerException if both zone ID and name are not initialized
   */
  public Zone reload(Dns.ZoneOption... options) {
    checkNameOrIdNotNull();
    Zone zone = null;
    if (zoneInfo.id() != null) {
      zone = Zone.get(dns, zoneInfo.id(), options);
    }
    if (zone == null && zoneInfo.name() != null) {
      // zone was not found by id or id is not set at all
      zone = Zone.get(dns, zoneInfo.name(), options);
    }
    return zone;
  }

  /**
   * Deletes the zone. The method first attempts to delete the zone by ID. If the zone is not found
   * or id is not set, it attempts to delete by name.
   *
   * @return true is zone was found and deleted and false otherwise
   * @throws DnsException upon failure
   * @throws NullPointerException if both zone ID and name are not initialized
   */
  public boolean delete() {
    checkNameOrIdNotNull();
    boolean deleted = false;
    if (zoneInfo.id() != null) {
      deleted = dns.delete(zoneInfo.id());
    }
    if (!deleted && zoneInfo.name() != null) {
      // zone was not found by id or id is not set at all
      deleted = dns.delete(zoneInfo.name());
    }
    return deleted;
  }

  /**
   * Lists all {@link DnsRecord}s associated with this zone. First searches for zone by ID and if
   * not found then by name.
   *
   * @param options Optional restriction on listing and on what fields of {@link DnsRecord} should
   * be returned by the service
   * @return {@code Page<DnsRecord>}, a page of DNS records, or null if the zone is not found
   * @throws DnsException upon failure
   * @throws NullPointerException if both zone ID and name are not initialized
   */
  public Page<DnsRecord> listDnsRecords(Dns.DnsRecordListOption... options) {
    checkNameOrIdNotNull();
    Page<DnsRecord> page = null;
    if (zoneInfo.id() != null) {
      page = dns.listDnsRecords(zoneInfo.id(), options);
    }
    if (page == null && zoneInfo.name() != null) {
      // zone was not found by id or id is not set at all
      page = dns.listDnsRecords(zoneInfo.name(), options);
    }
    return page;
  }

  /**
   * Submits {@link ChangeRequest} to the service for it to applied to this zone. First searches for
   * the zone by ID and if not found then by name. Returns a {@link ChangeRequest} with
   * server-assigned ID or null if the zone was not found.
   *
   * @param options Optional restriction on what fields of {@link ChangeRequest} should be returned
   * by the service
   * @return ChangeRequest with server-assigned ID or null if the zone was not found.
   * @throws DnsException upon failure
   * @throws NullPointerException if both zone ID and name are not initialized
   */
  public ChangeRequest applyChangeRequest(ChangeRequest changeRequest,
                                          Dns.ChangeRequestOption... options) {
    checkNameOrIdNotNull();
    checkNotNull(changeRequest);
    ChangeRequest updated = null;
    if (zoneInfo.id() != null) {
      updated = dns.applyChangeRequest(changeRequest, zoneInfo.id(), options);
    }
    if (updated == null && zoneInfo.name() != null) {
      // zone was not found by id or id is not set at all
      updated = dns.applyChangeRequest(changeRequest, zoneInfo.name(), options);
    }
    return updated;
  }

  /**
   * Retrieves an updated information about a change request previously submitted to be applied to
   * this zone. First searches for the zone by ID and if not found then by name. Returns a {@link
   * ChangeRequest} if found and null is the zone or the change request was not found.
   *
   * @param options Optional restriction on what fields of {@link ChangeRequest} should be returned
   * by the service
   * @return ChangeRequest with updated information of null if the change request or zone was not
   * found.
   * @throws DnsException upon failure
   * @throws NullPointerException if both zone ID and name are not initialized
   * @throws NullPointerException if the change request does not have initialized id
   */
  public ChangeRequest getChangeRequest(ChangeRequest changeRequest,
                                        Dns.ChangeRequestOption... options) {
    checkNameOrIdNotNull();
    checkNotNull(changeRequest);
    checkNotNull(changeRequest.id());
    ChangeRequest updated = null;
    if (zoneInfo.id() != null) {
      updated = dns.getChangeRequest(changeRequest, zoneInfo.id(), options);
    }
    if (updated == null && zoneInfo.name() != null) {
      // zone was not found by id or id is not set at all
      updated = dns.getChangeRequest(changeRequest, zoneInfo.name(), options);
    }
    return updated;
  }

  /**
   * Retrieves all change requests for this zone. First searches for the zone by ID and if not found
   * then by name. Returns a page of {@link ChangeRequest}s or null if the zone is not found.
   *
   * @param options Optional restriction on listing and on what fields of {@link ChangeRequest}s
   * should be returned by the service
   * @return {@code Page<ChangeRequest>}, a page of change requests, or null if the zone is not
   * found
   * @throws DnsException upon failure
   * @throws NullPointerException if both zone ID and name are not initialized
   */
  public Page<ChangeRequest> listChangeRequests(Dns.ChangeRequestListOption... options) {
    checkNameOrIdNotNull();
    Page<ChangeRequest> changeRequests = null;
    if (zoneInfo.id() != null) {
      changeRequests = dns.listChangeRequests(zoneInfo.id(), options);
    }
    if (changeRequests == null && zoneInfo.name() != null) {
      // zone was not found by id or id is not set at all
      changeRequests = dns.listChangeRequests(zoneInfo.name(), options);
    }
    return changeRequests;
  }

  /**
   * Check that at least one of name and ID are initialized and throw and exception if not.
   */
  private void checkNameOrIdNotNull() {
    if (zoneInfo != null && zoneInfo.id() == null && zoneInfo.name() == null) {
      throw new NullPointerException("Both zoneInfo.id and zoneInfo.name are null. "
          + "This is an inconsistent state which should never happen.");
    }
  }

  /**
   * Returns the {@link ZoneInfo} object containing meta information about this managed zone.
   */
  public ZoneInfo info() {
    return this.zoneInfo;
  }

  /**
   * Returns the {@link Dns} service object associated with this managed zone.
   */
  public Dns dns() {
    return this.dns;
  }

}
