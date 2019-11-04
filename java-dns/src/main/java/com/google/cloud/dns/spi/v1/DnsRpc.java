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

import com.google.api.services.dns.model.Change;
import com.google.api.services.dns.model.ManagedZone;
import com.google.api.services.dns.model.Project;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.cloud.ServiceRpc;
import com.google.cloud.dns.DnsException;
import com.google.common.collect.ImmutableList;
import java.util.Map;

public interface DnsRpc extends ServiceRpc {

  enum Option {
    FIELDS("fields"),
    PAGE_SIZE("maxResults"),
    PAGE_TOKEN("pageToken"),
    DNS_NAME("dnsName"),
    NAME("name"),
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

  class ListResult<T> {

    private final Iterable<T> results;
    private final String pageToken;

    public ListResult(String pageToken, Iterable<T> results) {
      this.results = ImmutableList.copyOf(results);
      this.pageToken = pageToken;
    }

    public static <T> ListResult<T> of(String pageToken, Iterable<T> list) {
      return new ListResult<>(pageToken, list);
    }

    public Iterable<T> results() {
      return results;
    }

    public String pageToken() {
      return pageToken;
    }
  }

  /**
   * Creates a new zone.
   *
   * @param zone a zone to be created
   * @param options a map of options for the service call
   * @return Updated {@code ManagedZone} object
   * @throws DnsException upon failure
   */
  ManagedZone create(ManagedZone zone, Map<Option, ?> options) throws DnsException;

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
  ListResult<ManagedZone> listZones(Map<Option, ?> options) throws DnsException;

  /**
   * Deletes the zone identified by the name.
   *
   * @return {@code true} if the zone was deleted and {@code false} otherwise
   * @throws DnsException upon failure
   */
  boolean deleteZone(String zoneName) throws DnsException;

  /**
   * Lists record sets for a given zone.
   *
   * @param zoneName name of the zone to be listed
   * @param options a map of options for the service call
   * @throws DnsException upon failure or if zone was not found
   */
  ListResult<ResourceRecordSet> listRecordSets(String zoneName, Map<Option, ?> options)
      throws DnsException;

  /**
   * Returns information about the current project.
   *
   * @param options a map of options for the service call
   * @return up-to-date project information
   * @throws DnsException upon failure or if the project is not found
   */
  Project getProject(Map<Option, ?> options) throws DnsException;

  /**
   * Applies change request to a zone.
   *
   * @param zoneName the name of a zone to which the {@code Change} should be applied
   * @param changeRequest change to be applied
   * @param options a map of options for the service call
   * @return updated change object with server-assigned ID
   * @throws DnsException upon failure or if zone was not found
   */
  Change applyChangeRequest(String zoneName, Change changeRequest, Map<Option, ?> options)
      throws DnsException;

  /**
   * Returns an existing change request.
   *
   * @param zoneName the name of a zone to which the {@code Change} was be applied
   * @param changeRequestId the unique id assigned to the change by the server
   * @param options a map of options for the service call
   * @return up-to-date change object or {@code null} if change was not found
   * @throws DnsException upon failure or if zone was not found
   */
  Change getChangeRequest(String zoneName, String changeRequestId, Map<Option, ?> options)
      throws DnsException;

  /**
   * List existing change requests for a zone.
   *
   * @param zoneName the name of a zone to which the {@code Change}s were be applied
   * @param options a map of options for the service call
   * @throws DnsException upon failure or if zone was not found
   */
  ListResult<Change> listChangeRequests(String zoneName, Map<Option, ?> options)
      throws DnsException;

  /** Creates an empty batch. */
  RpcBatch createBatch();
}
