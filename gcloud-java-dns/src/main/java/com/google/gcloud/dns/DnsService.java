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

import com.google.gcloud.Page;

import java.math.BigInteger;

/**
 * An interface for the Google Cloud DNS.
 *
 * @see <a href="https://cloud.google.com/dns/docs">Google Cloud DNS</a>
 */
public interface DnsService {
  // todo(mderka) make this extend Service
  // todo(mderka) add options where applicable when implemented
  // todo(mderka) contains only what relates to DnsRecord, ManagedZone and ManagedZoneInfo; add rest

  ManagedZoneInfo create(ManagedZoneInfo managedZoneInfo);

  ManagedZoneInfo getManagedZone(String managedZoneName);

  ManagedZoneInfo getManagedZone(BigInteger managedZoneId);

  Page<ManagedZone> listManagedZones();

  boolean delete(String managedZoneName);

  boolean delete(BigInteger managedZoneId);

  Page<DnsRecord> listDnsRecords(String managedZoneName);

  Page<DnsRecord> listDnsRecords(BigInteger managedZoneId);
}
