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

package com.google.cloud.dns;

import com.google.api.gax.paging.Page;
import com.google.cloud.FieldSelector;
import com.google.cloud.FieldSelector.Helper;
import com.google.cloud.Service;
import com.google.cloud.dns.spi.v1.DnsRpc;
import com.google.common.collect.ImmutableList;
import java.util.List;

/**
 * An interface for the Google Cloud DNS service.
 *
 * @see <a href="https://cloud.google.com/dns/docs">Google Cloud DNS</a>
 */
public interface Dns extends Service<DnsOptions> {

  /**
   * The fields of a project.
   *
   * <p>These values can be used to specify the fields to include in a partial response when calling
   * {@link Dns#getProject(ProjectOption...)}. Project ID is always returned, even if not specified.
   */
  enum ProjectField implements FieldSelector {
    PROJECT_ID("id"),
    PROJECT_NUMBER("number"),
    QUOTA("quota");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(PROJECT_ID);

    private final String selector;

    ProjectField(String selector) {
      this.selector = selector;
    }

    @Override
    public String getSelector() {
      return selector;
    }
  }

  /**
   * The fields of a zone.
   *
   * <p>These values can be used to specify the fields to include in a partial response when calling
   * {@link Dns#getZone(String, ZoneOption...)}. The name is always returned, even if not specified.
   */
  enum ZoneField implements FieldSelector {
    CREATION_TIME("creationTime"),
    DESCRIPTION("description"),
    DNS_NAME("dnsName"),
    ZONE_ID("id"),
    NAME("name"),
    NAME_SERVER_SET("nameServerSet"),
    NAME_SERVERS("nameServers"),
    DNSSEC("dnssecConfig");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(NAME);

    private final String selector;

    ZoneField(String selector) {
      this.selector = selector;
    }

    @Override
    public String getSelector() {
      return selector;
    }
  }

  /**
   * The fields of a record set.
   *
   * <p>These values can be used to specify the fields to include in a partial response when calling
   * {@link Dns#listRecordSets(String, RecordSetListOption...)}. The name and type are always
   * returned even if not selected.
   */
  enum RecordSetField implements FieldSelector {
    DNS_RECORDS("rrdatas"),
    NAME("name"),
    TTL("ttl"),
    TYPE("type");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(NAME, TYPE);

    private final String selector;

    RecordSetField(String selector) {
      this.selector = selector;
    }

    @Override
    public String getSelector() {
      return selector;
    }
  }

  /**
   * The fields of a change request.
   *
   * <p>These values can be used to specify the fields to include in a partial response when calling
   * {@link Dns#applyChangeRequest(String, ChangeRequestInfo, ChangeRequestOption...)} The ID is
   * always returned even if not selected.
   */
  enum ChangeRequestField implements FieldSelector {
    ID("id"),
    START_TIME("startTime"),
    STATUS("status"),
    ADDITIONS("additions"),
    DELETIONS("deletions");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(ID);

    private final String selector;

    ChangeRequestField(String selector) {
      this.selector = selector;
    }

    @Override
    public String getSelector() {
      return selector;
    }
  }

  /** The sorting order for listing. */
  enum SortingOrder {
    DESCENDING,
    ASCENDING;

    public String selector() {
      return name().toLowerCase();
    }
  }

  /** Class for specifying record set listing options. */
  class RecordSetListOption extends Option {

    private static final long serialVersionUID = 1009627025381096098L;

    RecordSetListOption(DnsRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the record set's fields to be returned by the RPC call.
     *
     * <p>If this option is not provided all record fields are returned. {@code
     * RecordSetField.fields} can be used to specify only the fields of interest. The name of the
     * record set in always returned, even if not specified. {@link RecordSetField} provides a list
     * of fields that can be used.
     */
    public static RecordSetListOption fields(RecordSetField... fields) {
      return new RecordSetListOption(
          DnsRpc.Option.FIELDS,
          Helper.listSelector("rrsets", RecordSetField.REQUIRED_FIELDS, fields));
    }

    /**
     * Returns an option to specify a page token.
     *
     * <p>The page token (returned from a previous call to list) indicates from where listing should
     * continue.
     */
    public static RecordSetListOption pageToken(String pageToken) {
      return new RecordSetListOption(DnsRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * The maximum number of record sets to return per RPC.
     *
     * <p>The server can return fewer record sets than requested. When there are more results than
     * the page size, the server will return a page token that can be used to fetch other results.
     */
    public static RecordSetListOption pageSize(int pageSize) {
      return new RecordSetListOption(DnsRpc.Option.PAGE_SIZE, pageSize);
    }

    /** Restricts the list to only record sets with this fully qualified domain name. */
    public static RecordSetListOption dnsName(String dnsName) {
      return new RecordSetListOption(DnsRpc.Option.NAME, dnsName);
    }

    /**
     * Restricts the list to return only record sets of this type. If present, {@link
     * RecordSetListOption#dnsName(String)} must also be present.
     */
    public static RecordSetListOption type(RecordSet.Type type) {
      return new RecordSetListOption(DnsRpc.Option.DNS_TYPE, type.name());
    }
  }

  /** Class for specifying zone field options. */
  class ZoneOption extends Option {

    private static final long serialVersionUID = -8065564464895945037L;

    ZoneOption(DnsRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the zones's fields to be returned by the RPC call.
     *
     * <p>If this option is not provided all zone fields are returned. {@code ZoneOption.fields} can
     * be used to specify only the fields of interest. Zone ID is always returned, even if not
     * specified. {@link ZoneField} provides a list of fields that can be used.
     */
    public static ZoneOption fields(ZoneField... fields) {
      return new ZoneOption(
          DnsRpc.Option.FIELDS, Helper.selector(ZoneField.REQUIRED_FIELDS, fields));
    }
  }

  /** Class for specifying zone listing options. */
  class ZoneListOption extends Option {

    private static final long serialVersionUID = -2830645032124504717L;

    ZoneListOption(DnsRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the zones's fields to be returned by the RPC call.
     *
     * <p>If this option is not provided all zone fields are returned. {@code ZoneOption.fields} can
     * be used to specify only the fields of interest. Zone ID is always returned, even if not
     * specified. {@link ZoneField} provides a list of fields that can be used.
     */
    public static ZoneListOption fields(ZoneField... fields) {
      return new ZoneListOption(
          DnsRpc.Option.FIELDS,
          Helper.listSelector("managedZones", ZoneField.REQUIRED_FIELDS, fields));
    }

    /**
     * Returns an option to specify a page token.
     *
     * <p>The page token (returned from a previous call to list) indicates from where listing should
     * continue.
     */
    public static ZoneListOption pageToken(String pageToken) {
      return new ZoneListOption(DnsRpc.Option.PAGE_TOKEN, pageToken);
    }

    /** Restricts the list to only zone with this fully qualified domain name. */
    public static ZoneListOption dnsName(String dnsName) {
      return new ZoneListOption(DnsRpc.Option.DNS_NAME, dnsName);
    }

    /**
     * The maximum number of zones to return per RPC.
     *
     * <p>The server can return fewer zones than requested. When there are more results than the
     * page size, the server will return a page token that can be used to fetch other results.
     */
    public static ZoneListOption pageSize(int pageSize) {
      return new ZoneListOption(DnsRpc.Option.PAGE_SIZE, pageSize);
    }
  }

  /** Class for specifying project options. */
  class ProjectOption extends Option {

    private static final long serialVersionUID = 6817937338218847748L;

    ProjectOption(DnsRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the project's fields to be returned by the RPC call.
     *
     * <p>If this option is not provided all project fields are returned. {@code
     * ProjectOption.fields} can be used to specify only the fields of interest. Project ID is
     * always returned, even if not specified. {@link ProjectField} provides a list of fields that
     * can be used.
     */
    public static ProjectOption fields(ProjectField... fields) {
      return new ProjectOption(
          DnsRpc.Option.FIELDS, Helper.selector(ProjectField.REQUIRED_FIELDS, fields));
    }
  }

  /** Class for specifying change request field options. */
  class ChangeRequestOption extends Option {

    private static final long serialVersionUID = 1067273695061077782L;

    ChangeRequestOption(DnsRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify which fields of {@link ChangeRequest} should be returned by the
     * service.
     *
     * <p>If this option is not provided all change request fields are returned. {@code
     * ChangeRequestOption.fields} can be used to specify only the fields of interest. The ID of the
     * change request is always returned, even if not specified. {@link ChangeRequestField} provides
     * a list of fields that can be used.
     */
    public static ChangeRequestOption fields(ChangeRequestField... fields) {
      return new ChangeRequestOption(
          DnsRpc.Option.FIELDS, Helper.selector(ChangeRequestField.REQUIRED_FIELDS, fields));
    }
  }

  /** Class for specifying change request listing options. */
  class ChangeRequestListOption extends Option {

    private static final long serialVersionUID = -900209143895376089L;

    ChangeRequestListOption(DnsRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify which fields of{@link ChangeRequest} should be returned by the
     * service.
     *
     * <p>If this option is not provided all change request fields are returned. {@code
     * ChangeRequestOption.fields} can be used to specify only the fields of interest. The ID of the
     * change request is always returned, even if not specified. {@link ChangeRequestField} provides
     * a list of fields that can be used.
     */
    public static ChangeRequestListOption fields(ChangeRequestField... fields) {
      return new ChangeRequestListOption(
          DnsRpc.Option.FIELDS,
          Helper.listSelector("changes", ChangeRequestField.REQUIRED_FIELDS, fields));
    }

    /**
     * Returns an option to specify a page token.
     *
     * <p>The page token (returned from a previous call to list) indicates from where listing should
     * continue.
     */
    public static ChangeRequestListOption pageToken(String pageToken) {
      return new ChangeRequestListOption(DnsRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * The maximum number of change requests to return per RPC.
     *
     * <p>The server can return fewer change requests than requested. When there are more results
     * than the page size, the server will return a page token that can be used to fetch other
     * results.
     */
    public static ChangeRequestListOption pageSize(int pageSize) {
      return new ChangeRequestListOption(DnsRpc.Option.PAGE_SIZE, pageSize);
    }

    /**
     * Returns an option to specify whether the the change requests should be listed in ascending
     * (most-recent last) or descending (most-recent first) order with respect to when the change
     * request was accepted by the server. If this option is not provided, the listing order is
     * undefined.
     */
    public static ChangeRequestListOption sortOrder(SortingOrder order) {
      return new ChangeRequestListOption(DnsRpc.Option.SORTING_ORDER, order.selector());
    }
  }

  /**
   * Creates a new zone.
   *
   * <p>Returns {@link Zone} object representing the new zone's information. In addition to the
   * name, dns name and description (supplied by the user within the {@code zoneInfo} parameter),
   * the returned object can include the following read-only fields supplied by the server: creation
   * time, id, and list of name servers. The returned fields can be optionally restricted by
   * specifying {@link ZoneOption}s.
   *
   * @throws DnsException upon failure
   * @see <a href="https://cloud.google.com/dns/api/v1/managedZones/create">Cloud DNS Managed Zones:
   *     create</a>
   */
  Zone create(ZoneInfo zoneInfo, ZoneOption... options);

  /**
   * Returns the zone by the specified zone name. Returns {@code null} if the zone is not found. The
   * returned fields can be optionally restricted by specifying {@link ZoneOption}s.
   *
   * @throws DnsException upon failure
   * @see <a href="https://cloud.google.com/dns/api/v1/managedZones/get">Cloud DNS Managed Zones:
   *     get</a>
   */
  Zone getZone(String zoneName, ZoneOption... options);

  /**
   * Lists the zones inside the project.
   *
   * <p>This method returns zones in an unspecified order. New zones do not necessarily appear at
   * the end of the list. Use {@link ZoneListOption} to restrict the listing to a domain name, set
   * page size, and set page token.
   *
   * @return a page of zones
   * @throws DnsException upon failure
   * @see <a href="https://cloud.google.com/dns/api/v1/managedZones/list">Cloud DNS Managed Zones:
   *     list</a>
   */
  Page<Zone> listZones(ZoneListOption... options);

  /**
   * Deletes an existing zone identified by name. Returns {@code true} if the zone was successfully
   * deleted and {@code false} otherwise.
   *
   * @return {@code true} if zone was found and deleted and {@code false} otherwise
   * @throws DnsException upon failure
   * @see <a href="https://cloud.google.com/dns/api/v1/managedZones/delete">Cloud DNS Managed Zones:
   *     delete</a>
   */
  boolean delete(String zoneName); // delete does not admit any options

  /**
   * Lists the record sets in the zone identified by name.
   *
   * <p>The fields to be returned, page size and page tokens can be specified using {@link
   * RecordSetListOption}s.
   *
   * @throws DnsException upon failure or if the zone cannot be found
   * @see <a href="https://cloud.google.com/dns/api/v1/resourceRecordSets/list">Cloud DNS
   *     ResourceRecordSets: list</a>
   */
  Page<RecordSet> listRecordSets(String zoneName, RecordSetListOption... options);

  /**
   * Retrieves the information about the current project. The returned fields can be optionally
   * restricted by specifying {@link ProjectOption}s.
   *
   * @throws DnsException upon failure
   * @see <a href="https://cloud.google.com/dns/api/v1/projects/get">Cloud DNS Projects: get</a>
   */
  ProjectInfo getProject(ProjectOption... fields);

  /**
   * Submits a change request for the specified zone. The returned object contains the following
   * read-only fields supplied by the server: id, start time and status. time, id, and list of name
   * servers. The fields to be returned can be selected by {@link ChangeRequestOption}s.
   *
   * @return the new {@link ChangeRequest}
   * @throws DnsException upon failure or if zone is not found
   * @see <a href="https://cloud.google.com/dns/api/v1/changes/create">Cloud DNS Changes: create</a>
   */
  ChangeRequest applyChangeRequest(
      String zoneName, ChangeRequestInfo changeRequest, ChangeRequestOption... options);

  /**
   * Retrieves updated information about a change request previously submitted for a zone identified
   * by ID. Returns {@code null} if the request cannot be found and throws an exception if the zone
   * does not exist. The fields to be returned using can be specified using {@link
   * ChangeRequestOption}s.
   *
   * @throws DnsException upon failure or if the zone cannot be found
   * @see <a href="https://cloud.google.com/dns/api/v1/changes/get">Cloud DNS Chages: get</a>
   */
  ChangeRequest getChangeRequest(
      String zoneName, String changeRequestId, ChangeRequestOption... options);

  /**
   * Lists the change requests for the zone identified by name that were submitted to the service.
   *
   * <p>The sorting order for changes (based on when they were received by the server), fields to be
   * returned, page size and page token can be specified using {@link ChangeRequestListOption}s.
   *
   * @return A page of change requests
   * @throws DnsException upon failure or if the zone cannot be found
   * @see <a href="https://cloud.google.com/dns/api/v1/changes/list">Cloud DNS Chages: list</a>
   */
  Page<ChangeRequest> listChangeRequests(String zoneName, ChangeRequestListOption... options);

  /** Creates a new empty batch for grouping multiple service calls in one underlying RPC call. */
  DnsBatch batch();
}
