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

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A class representing a change. A change is an atomic update to a collection of {@link DnsRecord}s
 * within a {@code ManagedZone}.
 *
 * @see <a href="https://cloud.google.com/dns/api/v1/changes">Google Cloud DNS documentation</a>
 */
public class ChangeRequest implements Serializable {

  private static final long serialVersionUID = 201601251649L;
  private final List<DnsRecord> additions;
  private final List<DnsRecord> deletions;
  private final String id;
  private final Long startTimeMillis;
  private final Status status;

  /**
   * This enumerates the possible states of a {@code ChangeRequest}.
   *
   * @see <a href="https://cloud.google.com/dns/api/v1/changes#resource">Google Cloud DNS
   * documentation</a>
   */
  public enum Status {
    PENDING("pending"),
    DONE("done");

    private final String status;

    Status(String status) {
      this.status = status;
    }

    static Status translate(String status) {
      if ("pending".equals(status)) {
        return PENDING;
      } else if ("done".equals(status)) {
        return DONE;
      } else {
        throw new IllegalArgumentException("Such a status is unknown.");
      }
    }
  }

  /**
   * A builder for {@code ChangeRequest}s.
   */
  public static class Builder {

    private List<DnsRecord> additions = new LinkedList<>();
    private List<DnsRecord> deletions = new LinkedList<>();
    private String id;
    private Long startTimeMillis;
    private Status status;

    private Builder(ChangeRequest cr) {
      this.additions = Lists.newLinkedList(cr.additions());
      this.deletions = Lists.newLinkedList(cr.deletions());
      this.id = cr.id();
      this.startTimeMillis = cr.startTimeMillis();
      this.status = cr.status();
    }

    private Builder() {
    }

    /**
     * Sets a collection of {@link DnsRecord}s which are to be added to the zone upon executing this
     * {@code ChangeRequest}.
     */
    public Builder additions(List<DnsRecord> additions) {
      this.additions = Lists.newLinkedList(checkNotNull(additions));
      return this;
    }

    /**
     * Adds a {@link DnsRecord} which to be <strong>added</strong> to the zone upon executing this
     * {@code ChangeRequest}.
     */
    public Builder add(DnsRecord record) {
      this.additions.add(checkNotNull(record));
      return this;
    }

    /**
     * Adds a {@link DnsRecord} which to be <strong>deleted</strong> to the zone upon executing this
     * {@code ChangeRequest}.
     */
    public Builder delete(DnsRecord record) {
      this.deletions.add(checkNotNull(record));
      return this;
    }

    /**
     * Clears the collection of {@link DnsRecord}s which are to be added to the zone upon executing
     * this {@code ChangeRequest}.
     */
    public Builder clearAdditions() {
      this.additions.clear();
      return this;
    }

    /**
     * Clears the collection of {@link DnsRecord}s which are to be deleted from the zone upon
     * executing this {@code ChangeRequest}.
     */
    public Builder clearDeletions() {
      this.deletions.clear();
      return this;
    }

    /**
     * Removes a single {@link DnsRecord} from the collection of of records to be
     * <strong>added</strong> to the zone upon executing this {@code ChangeRequest}.
     */
    public Builder removeAddition(DnsRecord record) {
      this.additions.remove(record);
      return this;
    }

    /**
     * Removes a single {@link DnsRecord} from the collection of of records to be
     * <strong>deleted</strong> from the zone upon executing this {@code ChangeRequest}.
     */
    public Builder removeDeletion(DnsRecord record) {
      this.deletions.remove(record);
      return this;
    }

    /**
     * Sets a collection of {@link DnsRecord}s which are to be deleted from the zone upon executing
     * this {@code ChangeRequest}.
     */
    public Builder deletions(List<DnsRecord> deletions) {
      this.deletions = Lists.newLinkedList(checkNotNull(deletions));
      return this;
    }

    /**
     * Associates a server-assigned id to this {@code ChangeRequest}.
     */
    Builder id(String id) {
      this.id = checkNotNull(id);
      return this;
    }

    /**
     * Sets the time when this {@code ChangeRequest} was started by a server.
     */
    Builder startTimeMillis(long startTimeMillis) {
      this.startTimeMillis = startTimeMillis;
      return this;
    }

    /**
     * Sets the current status of this {@code ChangeRequest}.
     */
    Builder status(Status status) {
      this.status = checkNotNull(status);
      return this;
    }

    /**
     * Creates a {@code ChangeRequest} instance populated by the values associated with this
     * builder.
     */
    public ChangeRequest build() {
      return new ChangeRequest(this);
    }
  }

  private ChangeRequest(Builder builder) {
    this.additions = builder.additions;
    this.deletions = builder.deletions;
    this.id = builder.id;
    this.startTimeMillis = builder.startTimeMillis;
    this.status = builder.status;
  }

  /**
   * Returns an empty builder for the {@code ChangeRequest} class.
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Creates a builder populated with values of this {@code ChangeRequest}.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /**
   * Returns the list of {@link DnsRecord}s to be added to the zone upon executing this {@code
   * ChangeRequest}.
   */
  public List<DnsRecord> additions() {
    return additions;
  }

  /**
   * Returns the list of {@link DnsRecord}s to be deleted from the zone upon executing this {@code
   * ChangeRequest}.
   */
  public List<DnsRecord> deletions() {
    return deletions;
  }

  /**
   * Returns the id assigned to this {@code ChangeRequest} by the server.
   */
  public String id() {
    return id;
  }

  /**
   * Returns the time when this {@code ChangeRequest} was started by the server.
   */
  public Long startTimeMillis() {
    return startTimeMillis;
  }

  /**
   * Returns the status of this {@code ChangeRequest}.
   */
  public Status status() {
    return status;
  }

  com.google.api.services.dns.model.Change toPb() {
    com.google.api.services.dns.model.Change pb =
        new com.google.api.services.dns.model.Change();
    // set id
    if (id() != null) {
      pb.setId(id());
    }
    // set timestamp
    if (startTimeMillis() != null) {
      pb.setStartTime(ISODateTimeFormat.dateTime().withZoneUTC().print(startTimeMillis()));
    }
    // set status
    if (status() != null) {
      pb.setStatus(status().status);
    }
    // set a list of additions
    if (additions() != null) {
      LinkedList<com.google.api.services.dns.model.ResourceRecordSet> additionsPb =
          new LinkedList<>();
      for (DnsRecord addition : additions()) {
        additionsPb.add(addition.toPb());
      }
      pb.setAdditions(additionsPb);
    }
    // set a list of deletions
    if (deletions() != null) {
      LinkedList<com.google.api.services.dns.model.ResourceRecordSet> deletionsPb =
          new LinkedList<>();
      for (DnsRecord deletion : deletions()) {
        deletionsPb.add(deletion.toPb());
      }
      pb.setDeletions(deletionsPb);
    }
    return pb;
  }

  static ChangeRequest fromPb(com.google.api.services.dns.model.Change pb) {
    Builder b = builder();
    if (pb.getId() != null) {
      b.id(pb.getId());
    }
    if (pb.getStartTime() != null) {
      b.startTimeMillis(DateTime.parse(pb.getStartTime()).getMillis());
    }
    if (pb.getStatus() != null) {
      b.status(ChangeRequest.Status.translate(pb.getStatus()));
    }
    if (pb.getDeletions() != null) {
      for (com.google.api.services.dns.model.ResourceRecordSet deletion : pb.getDeletions()) {
        b.delete(DnsRecord.fromPb(deletion));
      }
    }
    if (pb.getAdditions() != null) {
      for (com.google.api.services.dns.model.ResourceRecordSet addition : pb.getAdditions()) {
        b.add(DnsRecord.fromPb(addition));
      }
    }
    return b.build();
  }

  @Override
  public boolean equals(Object o) {
    return (o instanceof ChangeRequest) && this.toPb().equals(((ChangeRequest) o).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(additions, deletions, id, startTimeMillis, status);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("additions", additions)
        .add("deletions", deletions)
        .add("id", id)
        .add("startTimeMillis", startTimeMillis)
        .add("status", status)
        .toString();
  }
}
