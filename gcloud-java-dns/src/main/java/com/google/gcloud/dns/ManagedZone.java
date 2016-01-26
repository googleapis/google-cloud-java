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
 * A Google Cloud DNS Managed zone object.
 *
 * <p>A managed zone is the container for all of your DNS records that share the same DNS name
 * prefix, for example, example.com. Managed zones are automatically assigned a set of name servers
 * when they are created to handle responding to DNS queries for that zone. A managed zone has
 * quotas for the number of resource records that it can include.
 *
 * @see <a href="https://cloud.google.com/dns/zones/">Google Cloud DNS managed zone
 * documentation</a>
 */
public class ManagedZone implements Serializable {

  private static final long serialVersionUID = 201601221308L;
  private final ManagedZoneInfo managedZoneInfo;
  private final DnsService dnsService;

  /**
   * Constructs a {@code ManagedZone} object that contains the given {@code ManagedZoneInfo}.
   */
  public ManagedZone(DnsService dnsService, ManagedZoneInfo managedZoneInfo) {
    this.managedZoneInfo = checkNotNull(managedZoneInfo);
    this.dnsService = checkNotNull(dnsService);
  }

  /**
   * Constructs a {@code ManagedZone} object that contains meta information received from the Google
   * Cloud DNS service.
   *
   * @param managedZoneName Name of the managed zone to be searched for
   * @return ManagedZone object containing metadata or null if not not found
   */
  public static ManagedZone get(DnsService dnsService, String managedZoneName) {
    ManagedZoneInfo managedZoneInfo = dnsService.getManagedZone(managedZoneName);
    return managedZoneInfo == null ? null : new ManagedZone(dnsService, managedZoneInfo);
  }

  /**
   * Constructs a {@code ManagedZone} object that contains meta information received from the Google
   * Cloud DNS service.
   *
   * @param managedZoneId ID of the managed zone to be searched for
   * @return ManagedZone object containing metadata or null if not not found
   */
  public static ManagedZone get(DnsService dnsService, BigInteger managedZoneId) {
    ManagedZoneInfo managedZoneInfo = dnsService.getManagedZone(managedZoneId);
    return managedZoneInfo == null ? null : new ManagedZone(dnsService, managedZoneInfo);
  }

  /**
   * Retrieves the latest information about the managed zone. The method first attempts to retrieve
   * the managed zone by ID and if not set or managed zone is not found, it searches by name.
   *
   * @return ManagedZone object containing metadata or null if not not found.
   */
  public ManagedZone reload() {
    checkNameOrIdNotNull();
    ManagedZone managedZone = null;
    if (managedZoneInfo.id() != null) {
      managedZone = ManagedZone.get(dnsService, managedZoneInfo.id());
    }
    if (managedZone == null && managedZoneInfo.name() != null) {
      // managed zone was not found by id or id is not set
      managedZone = ManagedZone.get(dnsService, managedZoneInfo.name());
    }
    return managedZone;
  }

  /**
   * Deletes the managed zone. The method first attempts to delete the managed zone by ID and if not
   * found or id is not set, it attempts to delete by name.
   */
  public boolean delete() {
    checkNameOrIdNotNull();
    boolean deleted = false;
    if (managedZoneInfo.id() != null) {
      deleted = dnsService.delete(managedZoneInfo.id());
    }
    if (!deleted && managedZoneInfo.name() != null) {
      // managed zone was not found by id or id is not set
      deleted = dnsService.delete(managedZoneInfo.name());
    }
    return deleted;
  }

  /**
   * Returns the {@link ManagedZoneInfo} object containing meta information about this managed
   * zone.
   */
  public ManagedZoneInfo info() {
    return this.managedZoneInfo;
  }

  /**
   * Returns the {@link DnsService} service object associated with this managed zone.
   */
  public DnsService dnsService() {
    return this.dnsService;
  }

  /**
   * Lists all {@link DnsRecord}s associated with this managed zone.
   *
   * @return Page of {DnsRecord}s or null if managed zone is not found
   */
  public Page<DnsRecord> listDnsRecords() {
    // todo(mderka) allow for options
    checkNameOrIdNotNull();
    Page<DnsRecord> page = null;
    if (managedZoneInfo.id() != null) {
      page = dnsService.listDnsRecords(managedZoneInfo.id());
    }
    if (page == null && managedZoneInfo.name() != null) {
      // managed zone was not found by id or id is not set
      page = dnsService.listDnsRecords(managedZoneInfo.name());
    }
    return page;
  }

  private void checkNameOrIdNotNull() {
    if (managedZoneInfo != null && managedZoneInfo.id() == null && managedZoneInfo.name() == null) {
      throw new NullPointerException("Both managedZoneInfo.id and managedZoneInfo.name are null. " +
          "This is an inconsistent state which should never happen.");
    }
  }

  // todo(mderka) add part that relates to change requests

}
