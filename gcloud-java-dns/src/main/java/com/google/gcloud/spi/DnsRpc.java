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

package com.google.gcloud.spi;

import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.Project;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.gcloud.dns.DnsException;

import java.util.Map;

public interface DnsRpc {

  enum Option {
    FIELDS("fields"),
    PAGE_SIZE("maxSize"),
    PAGE_TOKEN("pageToken"),
    DNS_NAME("dnsName"),
    DNS_TYPE("type"),
    SORTING_ORDER("sortOrder");

    private final String value;

    Option(String value) {
      this.value = value;
    }

    public String value() {
      return value;
    }

    @SuppressWarnings("unchecked")
    <T> T get(Map<Option, ?> options) {
      return (T) options.get(this);
    }

    String getString(Map<Option, ?> options) {
      return get(options);
    }

    Integer getInt(Map<Option, ?> options) {
      return get(options);
    }
  }

  class Tuple<X, Y> {

    private final X x;
    private final Y y;

    private Tuple(X x, Y y) {
      this.x = x;
      this.y = y;
    }

    public static <X, Y> Tuple<X, Y> of(X x, Y y) {
      return new Tuple<>(x, y);
    }

    public X x() {
      return x;
    }

    public Y y() {
      return y;
    }
  }

  /**
   * Creates a new zone.
   *
   * @param zone a zone to be created
   * @return Updated {@link ManagedZone} object
   * @throws DnsException upon failure
   */
  ManagedZone create(ManagedZone zone) throws DnsException;

  /**
   * Retrieves and returns an existing zone.
   *
   * @param zoneName name of the zone to be returned
   * @param options a map of options for the service call
   * @return a zone or {@code null} if not found
   * @throws DnsException upon failure
   */
  ManagedZone getZone(String zoneName, Map<Option, ?> options) throws DnsException;

  /**
   * Lists the zones that exist within the project.
   *
   * @param options a map of options for the service call
   * @throws DnsException upon failure
   */
  Tuple<String, Iterable<ManagedZone>> listZones(Map<Option, ?> options) throws DnsException;

  /**
   * Deletes the zone identified by the name.
   *
   * @return {@code true} if the zone was deleted and {@code false} otherwise
   * @throws DnsException upon failure
   */
  boolean deleteZone(String zoneName) throws DnsException;

  /**
   * Lists DNS records for a given zone.
   *
   * @param zoneName name of the zone to be listed
   * @param options a map of options for the service call
   * @throws DnsException upon failure or if zone not found
   */
  Tuple<String, Iterable<ResourceRecordSet>> listDnsRecords(String zoneName,
      Map<Option, ?> options) throws DnsException;

  /**
   * Returns information about the current project.
   * 
   * @param options a map of options for the service call
   * @return up-to-date project information
   * @throws DnsException upon failure
   */
  Project getProject(Map<Option, ?> options) throws DnsException;

  /**
   * Applies change request to a zone. 
   *
   * @param zoneName the name of a zone to which the {@link Change} should be applied
   * @param changeRequest change to be applied
   * @param options a map of options for the service call
   * @return updated change object with server-assigned ID
   * @throws DnsException upon failure or if zone not found
   */
  Change applyChangeRequest(String zoneName, Change changeRequest, Map<Option, ?> options) 
      throws DnsException;

  /**
   * Returns an existing change request.
   *
   * @param zoneName the name of a zone to which the {@link Change} was be applied
   * @param changeRequestId the unique id assigned to the change by the server
   * @param options a map of options for the service call
   * @return up-to-date change object
   * @throws DnsException upon failure or if zone not found
   */
  Change getChangeRequest(String zoneName, String changeRequestId, Map<Option, ?> options) 
      throws DnsException;

  /**
   * List an existing change requests for a zone.
   *
   * @param zoneName the name of a zone to which the {@link Change}s were be applied
   * @param options a map of options for the service call
   * @throws DnsException upon failure or if zone not found
   */
  Tuple<String, Iterable<Change>> listChangeRequests(String zoneName, Map<Option, ?> options) 
      throws DnsException;
}
