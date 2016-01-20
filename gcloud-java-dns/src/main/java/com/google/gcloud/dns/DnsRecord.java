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

import java.io.Serializable;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * A class that represents Google Cloud DNS record set.
 *
 * <p>A unit of data that will be returned by the DNS servers.
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
  private final String zoneName;
  private final Long zoneId;

  private DnsRecord() {
    this.name = null;
    this.rrdatas = null;
    this.ttl = null;
    this.type = null;
    this.zoneName = null;
    this.zoneId = null;
  }

  DnsRecord(Builder builder) {
    this.name = builder.name;
    this.rrdatas = ImmutableList.copyOf(builder.rrdatas);
    this.ttl = builder.ttl;
    this.type = builder.type;
    this.zoneName = builder.zoneName;
    this.zoneId = builder.zoneId;
  }

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
    A,
    AAAA,
    CNAME,
    MX,
    NAPTR,
    NS,
    PTR,
    SOA,
    SPF,
    SRV,
    TXT
  }

  public static class Builder {

    private List<String> rrdatas = new LinkedList<>();
    private String name;
    private Integer ttl;
    private DnsRecordType type;
    private String zoneName;
    private Long zoneId;

    private Builder() {
    }

    /**
     * Creates a builder and pre-populates attributes with the values from the provided DnsRecord
     * instance.
     */
    public Builder(DnsRecord record) {
      this.name = record.name;
      this.ttl = record.ttl;
      this.type = record.type;
      this.zoneId = record.zoneId;
      this.zoneName = record.zoneName;
      this.rrdatas.addAll(record.rrdatas);
    }

    /**
     * Adds a record to the record set. The records should be as defined in RFC 1035 (section 5) and
     * RFC 1034 (section 3.6.1). Examples of records are available in Google DNS documentation.
     *
     * @see <a href="https://cloud.google.com/dns/what-is-cloud-dns#supported_record_types">Google
     * DNS documentation </a>.
     */
    public Builder add(String record) {
      this.rrdatas.add(checkNotNull(record));
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

    /**
     * Sets references to the managed zone that this DNS record belongs to.
     *
     * todo(mderka): consider if this method is needed; may not be possible when listing records
     */
    Builder managedZone(ManagedZoneInfo parent) {
      checkNotNull(parent);
      this.zoneId = parent.id();
      this.zoneName = parent.name();
      return this;
    }

    /**
     * Sets name reference to the managed zone that this DNS record belongs to.
     */
    Builder managedZone(String managedZoneName) {
      this.zoneName = checkNotNull(managedZoneName);
      return this;
    }
  }

  /**
   * Creates a builder pre-populated with the attribute values of this instance.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /**
   * Creates an empty builder
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
  public List<String> rrdatas() {
    return rrdatas;
  }

  /**
   * Returns the number of seconds that this DnsResource can be cached by resolvers. This number is
   * provided by the user.
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

  /**
   * Returns name of the managed zone that this record belongs to. The name of the managed zone is
   * provided by the user when the managed zone is created. It is unique within a project. If this
   * DNS record is not associated with a managed zone, this returns null.
   */
  public String zoneName() {
    return zoneName;
  }

  /**
   * Returns id of the managed zone that this record belongs to.
   *
   * <p>The id of the managed zone is determined by the server when the managed zone is created. It
   * is a read only value. If this DNS record is not associated with a managed zone, or if the id of
   * the managed zone was not loaded from the cloud service, this returns null.
   */
  public Long zoneId() {
    return zoneId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, rrdatas, ttl, type, zoneName, zoneId);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof DnsRecord) && Objects.equals(this.toPb(), ((DnsRecord) obj).toPb())
            && this.zoneId().equals(((DnsRecord) obj).zoneId())
            && this.zoneName().equals(((DnsRecord) obj).zoneName());

  }

  com.google.api.services.dns.model.ResourceRecordSet toPb() {
    com.google.api.services.dns.model.ResourceRecordSet pb =
            new com.google.api.services.dns.model.ResourceRecordSet();
    pb.setName(this.name());
    pb.setRrdatas(this.rrdatas());
    pb.setTtl(this.ttl());
    pb.setType(this.type() == null ? null : this.type().name());
    return pb;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
            .add("name", name())
            .add("rrdatas", rrdatas())
            .add("ttl", ttl())
            .add("type", type())
            .add("zoneName", zoneName())
            .add("zoneId", zoneId())
            .toString();
  }

}
