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

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A batch of operations to be submitted to Google Cloud DNS using a single HTTP request.
 */
public class DnsBatch {

  private Map<Request, Callback> requests = new LinkedHashMap<>();
  private Dns dns;

  /**
   * An interface for the callback which will be invoked when the operation has been executed. The
   * parameter {@code <T>} represents the type of the result of the operation and thus depends on
   * the {@link DnsBatch.Request} that this call back belongs to and it should be as follows:
   *
   * <ul>
   *   <li>{@link Zone} for creating and getting a zone</li>
   *   <li>{@link Boolean} for deleting a zone</li>
   *   <li>{@link ChangeRequest} for creating and getting a change request</li>
   *   <li>{@link ProjectInfo} for getting a project</li>
   *   <li>{@code Page<Zone>} for listing zones</li>
   *   <li>{@code Page<DnsRecord>} for listing {@link DnsRecord}s inside a zone</li>
   *   <li>{@code Page<ChangeRequest>} for listing {@link ChangeRequest}s for a zone</li>
   * </ul>
   */
  public interface Callback<T> {
    /**
     * A method which will be called if the {@link DnsBatch.Request} succeeds. See the {@link
     * Callback} documentation for details on type {@code T}.
     *
     * @param output the result of the operation
     * @param request the request which succeeded
     */
    void success(T output, DnsBatch.Request request);

    /**
     * A method which will be called if the {@link DnsBatch.Request} fails.
     *
     * @param ex the error
     * @param request the request which failed
     */
    void error(DnsException ex, DnsBatch.Request request);
  }

  /**
   * An operation to be submitted to Google Cloud DNS within this batch. Only an subset of the class
   * attributes appropriate for the represented operation is initialized. Refer to the class method
   * and attribute documentation for the specific fields.
   */
  public static class Request {

    private final String zoneName;
    private final String changeId;
    private final ChangeRequest changeRequest;
    private final ZoneInfo zoneInfo;
    private final Operation operation;
    private final AbstractOption[] options;

    private Request(RequestBuilder builder) {
      this.zoneName = builder.zoneName;
      this.changeId = builder.changeId;
      this.changeRequest = builder.changeRequest;
      this.zoneInfo = builder.zoneInfo;
      this.operation = builder.operation;
      this.options = builder.options;
    }

    private static RequestBuilder builder(Operation operation, AbstractOption... options) {
      return new RequestBuilder(operation, options);
    }

    /**
     * Returns the name of the zone to which the operation is applied. This field is initialized for
     * zone create, get and delete operation, and listing DNS records and changes within a zone.
     * Returns {@code null} in other cases.
     */
    public String zoneName() {
      return zoneName;
    }

    /**
     * Returns the id of the change request which is being retrieved. Getting a change request is
     * the only operation when this attribute is initialized. The method returns {@code null} in the
     * remaining cases.
     */
    public String changeId() {
      return changeId;
    }

    /**
     * Returns the change request which is being created. Creating a change request is the only
     * operation when this attribute is initialized. The method returns {@code null} in the
     * remaining cases.
     */
    public ChangeRequest changeRequest() {
      return changeRequest;
    }

    /**
     * Returns the zone which is being created. Creating a zone is the only operation when this
     * attribute is initialized. The method returns {@code null} in the remaining cases.
     */
    public ZoneInfo zoneInfo() {
      return zoneInfo;
    }

    /**
     * Returns the type of the operation represented by this {@link DnsBatch.Request}. This field is
     * always initialized.
     */
    public Operation operation() {
      return operation;
    }

    /**
     * Returns options provided to the operation. Returns an empty array if no options were
     * provided.
     */
    public AbstractOption[] options() {
      return options == null ? new AbstractOption[0] : options;
    }
  }

  static class RequestBuilder {
    private final AbstractOption[] options;
    private String zoneName;
    private String changeId;
    private ChangeRequest changeRequest;
    private ZoneInfo zoneInfo;
    private final Operation operation;

    RequestBuilder(Operation operation, AbstractOption... options) {
      this.operation = operation;
      this.options = options;
    }

    RequestBuilder zoneName(String zoneName) {
      this.zoneName = zoneName;
      return this;
    }

    RequestBuilder changeId(String changeId) {
      this.changeId = changeId;
      return this;
    }

    RequestBuilder changeRequest(ChangeRequest changeRequest) {
      this.changeRequest = changeRequest;
      return this;
    }

    RequestBuilder zoneInfo(ZoneInfo zoneInfo) {
      this.zoneInfo = zoneInfo;
      return this;
    }

    Request build() {
      return new Request(this);
    }
  }

  /**
   * Represents the type of the batch operation.
   */
  public enum Operation {
    CREATE_ZONE,
    DELETE_ZONE,
    GET_ZONE,
    LIST_ZONES,
    APPLY_CHANGE_REQUEST,
    GET_CHANGE_REQUEST,
    LIST_CHANGES_REQUESTS,
    LIST_DNS_RECORDS
  }

  DnsBatch(Dns dns) {
    this.dns = dns;
  }

  public Dns service() {
    return dns;
  }

  Map<Request, Callback> requests() {
    return requests;
  }

  /**
   * Adds a {@code DnsBatch.Request} represeting the list zones operation to this batch. The request
   * will not have initialized any fields except for the operation type and options (if provided).
   * The {@code callback} will receive a page of {@link Zone}s upon success of the request. The
   * {@code options} can be used to restrict the fields returned or provide page size limits in the
   * same way as for {@link Dns#listZones(Dns.ZoneListOption...)}.
   */
  public DnsBatch listZones(Callback<Page<Zone>> callback, Dns.ZoneListOption... options) {
    Request request = Request.builder(Operation.LIST_ZONES, options).build();
    requests.put(request, callback);
    return this;
  }

  // todo(mderka) add the rest of the operations

  /**
   * Submits this batch for processing using a single HTTP request. This will invoke all callbacks
   * for the invidual {@link DnsBatch.Request}s contained in this batch.
   */
  public void submit() {
    dns.submitBatch(this);
  }
}
