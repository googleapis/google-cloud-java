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

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import com.google.gcloud.Service;
import com.google.gcloud.spi.DnsServiceRpc;

import java.io.Serializable;
import java.util.Set;

/**
 * An interface for the Google Cloud DNS service.
 *
 * @see <a href="https://cloud.google.com/dns/docs">Google Cloud DNS</a>
 */
public interface DnsService extends Service<DnsServiceOptions> {

  /**
   * The fields of a project.
   *
   * <p>These values can be used to specify the fields to include in a partial response when calling
   * {@code DnsService#getProjectInfo(ProjectOptions...)}. Project ID is always returned, even if
   * not specified.
   */
  enum ProjectField {
    PROJECT_ID("id"),
    PROJECT_NUMBER("number"),
    QUOTA("quota");

    private final String selector;

    ProjectField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(ProjectField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(PROJECT_ID.selector());
      for (ProjectField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * The fields of a zone.
   *
   * <p>These values can be used to specify the fields to include in a partial response when calling
   * {@code DnsService#getZone(BigInteger, ZoneFieldOptions...)} or {@code
   * DnsService#getZone(String, ZoneFieldOptions...)}. The ID is always returned, even if not
   * specified.
   */
  enum ZoneField {
    CREATION_TIME("creationTime"),
    DESCRIPTION("description"),
    DNS_NAME("dnsName"),
    ZONE_ID("id"),
    NAME("name"),
    NAME_SERVER_SET("nameServerSet"),
    NAME_SERVERS("nameServers");

    private final String selector;

    ZoneField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(ZoneField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(ZONE_ID.selector());
      for (ZoneField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * The fields of a DNS record.
   *
   * <p>These values can be used to specify the fields to include in a partial response when calling
   * {@code DnsService#listDnsRecords(BigInteger, DnsRecordOptions...)} or {@code
   * DnsService#listDnsRecords(String, DnsRecordOptions...)}. The name is always returned even if
   * not selected.
   */
  enum DnsRecordField {
    DNS_RECORDS("rrdatas"),
    NAME("name"),
    TTL("ttl"),
    TYPE("type");

    private final String selector;

    DnsRecordField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(DnsRecordField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(NAME.selector());
      for (DnsRecordField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * The fields of a change request.
   *
   * <p>These values can be used to specify the fields to include in a partial response when calling
   * {@code DnsService#applyChangeRequest(ChangeRequest, BigInteger, ChangeRequestFieldOptions...)}
   * or {@code DnsService#applyChangeRequest(ChangeRequest, String, ChangeRequestFieldOptions...)}
   * The ID is always returned even if not selected.
   */
  enum ChangeRequestField {
    ID("id"),
    START_TIME("startTime"),
    STATUS("status"),
    ADDITIONS("additions"),
    DELETIONS("deletions");

    private final String selector;

    ChangeRequestField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(ChangeRequestField... fields) {
      Set<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(ID.selector());
      for (ChangeRequestField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  /**
   * The sorting keys for listing change requests. The only currently supported sorting key is the
   * change sequence.
   */
  enum ChangeRequestSortingKey {
    CHANGE_SEQUENCE("changeSequence");

    private final String selector;

    ChangeRequestSortingKey(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }
  }

  /**
   * The sorting order for listing change requests.
   */
  enum ChangeRequestSortingOrder {
    DESCENDING, ASCENDING;

    public String selector() {
      return this.name().toLowerCase();
    }
  }

  /**
   * Class that for specifying DNS record options.
   */
  class DnsRecordOptions extends AbstractOption implements Serializable {

    private static final long serialVersionUID = 201601261646L;

    DnsRecordOptions(DnsServiceRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the DNS record's fields to be returned by the RPC call.
     *
     * <p>If this option is not provided all record fields are returned. {@code
     * DnsRecordField.fields} can be used to specify only the fields of interest. The name of the
     * DNS record always returned, even if not specified. {@link DnsRecordField} provides a list of
     * fields that can be used.
     */
    public static DnsRecordOptions fields(DnsRecordField... fields) {
      StringBuilder builder = new StringBuilder();
      builder.append("rrsets(").append(DnsRecordField.selector(fields)).append(")");
      return new DnsRecordOptions(DnsServiceRpc.Option.FIELDS, builder.toString());
    }

    /**
     * Returns an option to specify a page token.
     *
     * <p>The page token (returned from a previous call to list) indicates from where listing should
     * continue.
     */
    public static DnsRecordOptions pageToken(String pageToken) {
      return new DnsRecordOptions(DnsServiceRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * The maximum number of DNS records to return per RPC.
     *
     * <p>The server can return fewer records than requested. When there are more results than the
     * page size, the server will return a page token that can be used to fetch other results.
     */
    public static DnsRecordOptions pageSize(int pageSize) {
      return new DnsRecordOptions(DnsServiceRpc.Option.PAGE_SIZE, pageSize);
    }

    /**
     * Restricts the list to return only zones with this fully qualified domain name.
     */
    public static DnsRecordOptions dnsName(String dnsName) {
      return new DnsRecordOptions(DnsServiceRpc.Option.DNS_NAME, dnsName);
    }
  }

  /**
   * Class for specifying zone field options.
   */
  class ZoneFieldOptions extends AbstractOption implements Serializable {

    private static final long serialVersionUID = -7294186261285469986L;

    ZoneFieldOptions(DnsServiceRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the zones's fields to be returned by the RPC call.
     *
     * <p>If this option is not provided all zone fields are returned. {@code
     * ZoneFieldOptions.fields} can be used to specify only the fields of interest. Zone ID is
     * always returned, even if not specified. {@link ZoneField} provides a list of fields that can
     * be used.
     */
    public static ZoneFieldOptions fields(ZoneField... fields) {
      return new ZoneFieldOptions(DnsServiceRpc.Option.FIELDS, ZoneField.selector(fields));
    }
  }

  /**
   * Class for specifying zone listing options.
   */
  class ZoneListOptions extends AbstractOption implements Serializable {

    private static final long serialVersionUID = -7922038132321229290L;

    ZoneListOptions(DnsServiceRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the zones's fields to be returned by the RPC call.
     *
     * <p>If this option is not provided all zone fields are returned. {@code
     * ZoneFieldOptions.fields} can be used to specify only the fields of interest. Zone ID is
     * always returned, even if not specified. {@link ZoneField} provides a list of fields that can
     * be used.
     */
    public static ZoneListOptions fields(ZoneField... fields) {
      return new ZoneListOptions(DnsServiceRpc.Option.FIELDS, ZoneField.selector(fields));
    }

    /**
     * Returns an option to specify a page token.
     *
     * <p>The page token (returned from a previous call to list) indicates from where listing should
     * continue.
     */
    public static ZoneListOptions pageToken(String pageToken) {
      return new ZoneListOptions(DnsServiceRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * The maximum number of zones to return per RPC.
     *
     * <p>The server can return fewer zones than requested. When there are more results than the
     * page size, the server will return a page token that can be used to fetch other results.
     */
    public static ZoneListOptions pageSize(int pageSize) {
      return new ZoneListOptions(DnsServiceRpc.Option.PAGE_SIZE, pageSize);
    }

    /**
     * Restricts the list to return only zones with this fully qualified domain name.
     */
    public static ZoneListOptions dnsName(String dnsName) {
      return new ZoneListOptions(DnsServiceRpc.Option.DNS_NAME, dnsName);
    }
  }

  /**
   * Class for specifying project options.
   */
  class ProjectOptions extends AbstractOption implements Serializable {

    private static final long serialVersionUID = 6817937338218847748L;

    ProjectOptions(DnsServiceRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the project's fields to be returned by the RPC call.
     *
     * <p>If this option is not provided all project fields are returned. {@code
     * ProjectOptions.fields} can be used to specify only the fields of interest. Project ID is
     * always returned, even if not specified. {@link ProjectField} provides a list of fields that
     * can be used.
     */
    public static ProjectOptions fields(ProjectField... fields) {
      return new ProjectOptions(DnsServiceRpc.Option.FIELDS, ProjectField.selector(fields));
    }
  }

  /**
   * Class for specifying change request field options.
   */
  class ChangeRequestFieldOptions extends AbstractOption implements Serializable {

    private static final long serialVersionUID = 1067273695061077782L;

    ChangeRequestFieldOptions(DnsServiceRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify which fields of DNS records to be added by the {@link
     * ChangeRequest} should be returned by the service.
     *
     * <p>If this option is not provided, all record fields are returned. {@code
     * ChangeRequestFieldOptions.additionsFields} can be used to specify only the fields of
     * interest. The name of the DNS record always returned, even if not specified. {@link
     * DnsRecordField} provides a list of fields that can be used.
     */
    public static ChangeRequestFieldOptions additionsFields(DnsRecordField... fields) {
      StringBuilder builder = new StringBuilder();
      builder.append("additions(").append(DnsRecordField.selector(fields)).append(")");
      return new ChangeRequestFieldOptions(DnsServiceRpc.Option.FIELDS, builder.toString());
    }

    /**
     * Returns an option to specify which fields of DNS records to be deleted by the {@link
     * ChangeRequest} should be returned by the service.
     *
     * <p>If this option is not provided, all record fields are returned. {@code
     * ChangeRequestFieldOptions.deletionsFields} can be used to specify only the fields of
     * interest. The name of the DNS record always returned, even if not specified. {@link
     * DnsRecordField} provides a list of fields that can be used.
     */
    public static ChangeRequestFieldOptions deletionsFields(DnsRecordField... fields) {
      StringBuilder builder = new StringBuilder();
      builder.append("deletions(").append(DnsRecordField.selector(fields)).append(")");
      return new ChangeRequestFieldOptions(DnsServiceRpc.Option.FIELDS, builder.toString());

    }

    /**
     * Returns an option to specify which fields of {@link ChangeRequest} should be returned by the
     * service.
     *
     * <p>If this option is not provided all change request fields are returned. {@code
     * ChangeRequestFieldOptions.fields} can be used to specify only the fields of interest. The ID
     * of the change request is always returned, even if not specified. {@link ChangeRequestField}
     * provides a list of fields that can be used.
     */
    public static ChangeRequestFieldOptions fields(ChangeRequestField... fields) {
      return new ChangeRequestFieldOptions(
          DnsServiceRpc.Option.FIELDS,
          ChangeRequestField.selector(fields)
      );
    }
  }

  /**
   * Class for specifying change request listing options.
   */
  class ChangeRequestListOptions extends AbstractOption implements Serializable {

    private static final long serialVersionUID = -900209143895376089L;

    ChangeRequestListOptions(DnsServiceRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify which fields of DNS records to be added by the {@link
     * ChangeRequest} should be returned by the service.
     *
     * <p>If this option is not provided, all record fields are returned. {@code
     * ChangeRequestFieldOptions.additionsFields} can be used to specify only the fields of
     * interest. The name of the DNS record always returned, even if not specified. {@link
     * DnsRecordField} provides a list of fields that can be used.
     */
    public static ChangeRequestListOptions additionsFields(DnsRecordField... fields) {
      StringBuilder builder = new StringBuilder();
      builder.append("changes(additions(").append(DnsRecordField.selector(fields)).append("))");
      return new ChangeRequestListOptions(DnsServiceRpc.Option.FIELDS, builder.toString());
    }

    /**
     * Returns an option to specify which fields of DNS records to be deleted by the {@link
     * ChangeRequest} should be returned by the service.
     *
     * <p>If this option is not provided, all record fields are returned. {@code
     * ChangeRequestFieldOptions.deletionsFields} can be used to specify only the fields of
     * interest. The name of the DNS record always returned, even if not specified. {@link
     * DnsRecordField} provides a list of fields that can be used.
     */
    public static ChangeRequestListOptions deletionsFields(DnsRecordField... fields) {
      StringBuilder builder = new StringBuilder();
      builder.append("changes(deletions(").append(DnsRecordField.selector(fields)).append("))");
      return new ChangeRequestListOptions(DnsServiceRpc.Option.FIELDS, builder.toString());
    }

    /**
     * Returns an option to specify which fields of{@link ChangeRequest} should be returned by the
     * service.
     *
     * <p>If this option is not provided all change request fields are returned. {@code
     * ChangeRequestFieldOptions.fields} can be used to specify only the fields of interest. The ID
     * of the change request is always returned, even if not specified. {@link ChangeRequestField}
     * provides a list of fields that can be used.
     */
    public static ChangeRequestListOptions fields(ChangeRequestField... fields) {
      return new ChangeRequestListOptions(
          DnsServiceRpc.Option.FIELDS,
          ChangeRequestField.selector(fields)
      );
    }

    /**
     * Returns an option to specify a page token.
     *
     * <p>The page token (returned from a previous call to list) indicates from where listing should
     * continue.
     */
    public static ChangeRequestListOptions pageToken(String pageToken) {
      return new ChangeRequestListOptions(DnsServiceRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * The maximum number of change requests to return per RPC.
     *
     * <p>The server can return fewer change requests than requested. When there are more results
     * than the page size, the server will return a page token that can be used to fetch other
     * results.
     */
    public static ChangeRequestListOptions pageSize(int pageSize) {
      return new ChangeRequestListOptions(DnsServiceRpc.Option.PAGE_SIZE, pageSize);
    }

    /**
     * Returns an option for specifying the sorting criterion of change requests. Note the the only
     * currently supported criterion is the change sequence.
     */
    public static ChangeRequestListOptions sortBy(ChangeRequestSortingKey key) {
      return new ChangeRequestListOptions(DnsServiceRpc.Option.SORTING_KEY, key.selector());
    }

    /**
     * Returns an option to specify whether the the change requests should be listed in ascending or
     * descending order.
     */
    public static ChangeRequestListOptions sortOrder(ChangeRequestSortingOrder order) {
      return new ChangeRequestListOptions(DnsServiceRpc.Option.SORTING_ORDER, order.selector());
    }
  }

  // TODO(mderka) Add methods. Created issue #596.
}
