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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.io.Serializable;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * A class that represents Google Cloud DNS record set.
 *
 * <p>A DnsRecord is the unit of data that will be returned by the DNS servers upon a DNS request
 * for a specific domain. The DnsRecord holds the current state of the DNS records that make up a
 * managed zone. You can read the records but you do not modify them directly. Rather, you edit
 * the records in a managed zone by creating a {@link ChangeRequest}.
 *
 * @see <a href="https://cloud.google.com/dns/api/v1/resourceRecordSets">Google Cloud DNS
 * documentation</a>
 */
public class DnsRecord implements Serializable {

  private static final long serialVersionUID = 2016011914302204L;
  private final String name;
  private final List<String> rrdatas;
  private final Integer ttl;
  private final DnsRecordType type;

  /**
   * Enum for the DNS record types supported by Cloud DNS.
   *
   * <p>Google Cloud DNS currently supports records of type A, AAAA, CNAME, MX NAPTR, NS, PTR, SOA,
   * SPF, SRV, TXT.
   *
   * @see <a href="https://cloud.google.com/dns/what-is-cloud-dns#supported_record_types">Cloud DNS
   * supported record types</a>
   */
  public enum DnsRecordType {
    /**
     * Address record, which is used to map host names to their IPv4 address.
     */
    A,
    /**
     * IPv6 Address record, which is used to map host names to their IPv6 address.
     */
    AAAA,
    /**
     * Canonical name record, which is used to alias names.
     */
    CNAME,
    /**
     * Mail exchange record, which is used in routing requests to mail servers.
     */
    MX,
    /**
     * Naming authority pointer record, defined by RFC3403.
     */
    NAPTR,
    /**
     * Name server record, which delegates a DNS zone to an authoritative server.
     */
    NS,
    /**
     * Pointer record, which is often used for reverse DNS lookups.
     */
    PTR,
    /**
     * Start of authority record, which specifies authoritative information about a DNS zone.
     */
    SOA,
    /**
     * Sender policy framework record, which is used in email validation systems.
     */
    SPF,
    /**
     * Service locator record, which is used by some voice over IP, instant messaging protocols and
     * other applications.
     */
    SRV,
    /**
     * Text record, which can contain arbitrary text and can also be used to define machine readable
     * data such as security or abuse prevention information.
     */
    TXT
  }

  public static class Builder {

    private List<String> rrdatas = new LinkedList<>();
    private String name;
    private Integer ttl;
    private DnsRecordType type;

    private Builder() {
    }

    /**
     * Creates a builder and pre-populates attributes with the values from the provided DnsRecord
     * instance.
     */
    private Builder(DnsRecord record) {
      this.name = record.name;
      this.ttl = record.ttl;
      this.type = record.type;
      this.rrdatas.addAll(record.rrdatas);
    }

    /**
     * Adds a record to the record set. The records should be as defined in RFC 1035 (section 5) and
     * RFC 1034 (section 3.6.1). Examples of records are available in Google DNS documentation.
     *
     * @see <a href="https://cloud.google.com/dns/what-is-cloud-dns#supported_record_types">Google
     * DNS documentation </a>.
     */
    public Builder addRecord(String record) {
      this.rrdatas.add(checkNotNull(record));
      return this;
    }

    /**
     * Removes a record from the set. An exact match is required.
     */
    public Builder removerRecord(String record) {
      this.rrdatas.remove(checkNotNull(record));
      return this;
    }

    /**
     * Removes a record on the given index from the set.
     */
    public Builder removerRecord(int index) {
      checkArgument(index >= 0 && index < this.rrdatas.size(), "The index is out of bounds. An " +
              "integer between 0 and " + (this.rrdatas.size() - 1) + " is required. The provided " +
              "value was " + index + ".");
      this.rrdatas.remove(index);
      return this;
    }

    /**
     * Removes all the records.
     */
    public Builder clearRecords() {
      this.rrdatas.clear();
      return this;
    }

    /**
     * Replaces the current records with the provided list of records.
     */
    public Builder records(List<String> records) {
      this.rrdatas = Lists.newLinkedList(checkNotNull(records));
      return this;
    }

    /**
     * Sets name for this DNS record set. For example, www.example.com.
     */
    public Builder name(String name) {
      this.name = checkNotNull(name);
      return this;
    }

    /**
     * Sets the number of seconds that this record can be cached by resolvers. This number must be
     * non-negative.
     *
     * @param ttl A non-negative number of seconds
     */
    public Builder ttl(int ttl) {
      checkArgument(ttl >= 0, "TTL cannot be negative. The supplied value was " + ttl + ".");
      this.ttl = ttl;
      return this;
    }

    /**
     * The identifier of a supported record type, for example, A, AAAA, MX, TXT, and so on.
     */
    public Builder type(DnsRecordType type) {
      this.type = checkNotNull(type);
      return this;
    }

    /**
     * Builds the DNS record.
     */
    public DnsRecord build() {
      return new DnsRecord(this);
    }
  }

  DnsRecord(Builder builder) {
    this.name = builder.name;
    this.rrdatas = ImmutableList.copyOf(builder.rrdatas);
    this.ttl = builder.ttl;
    this.type = builder.type;
  }

  /**
   * Creates a builder pre-populated with the attribute values of this instance.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /**
   * Creates an empty builder.
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Get the mandatory user assigned name of this DNS record.
   */
  public String name() {
    return name;
  }

  /**
   * Returns a list of DNS record stored in this record set.
   */
  public List<String> records() {
    return rrdatas;
  }

  /**
   * Returns the number of seconds that this DnsResource can be cached by resolvers.
   */
  public Integer ttl() {
    return ttl;
  }

  /**
   * Returns the type of this DNS record.
   */
  public DnsRecordType type() {
    return type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, rrdatas, ttl, type);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof DnsRecord) && Objects.equals(this.toPb(), ((DnsRecord) obj).toPb());
  }

  com.google.api.services.dns.model.ResourceRecordSet toPb() {
    com.google.api.services.dns.model.ResourceRecordSet pb =
            new com.google.api.services.dns.model.ResourceRecordSet();
    pb.setName(this.name());
    pb.setRrdatas(this.records());
    pb.setTtl(this.ttl());
    pb.setType(this.type() == null ? null : this.type().name());
    return pb;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
            .add("name", name())
            .add("rrdatas", records())
            .add("ttl", ttl())
            .add("type", type())
            .toString();
  }

}
