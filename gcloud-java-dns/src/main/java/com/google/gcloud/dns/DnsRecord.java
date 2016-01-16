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

import com.google.common.collect.ImmutableList;

import java.util.LinkedList;
import java.util.List;

/**
 * A class that represents Google Cloud DNS record set.
 *
 * <p>
 * A unit of data that will be returned by the DNS servers.
 *
 * @see <a href="https://cloud.google.com/dns/api/v1/resourceRecordSets">Google
 * Cloud DNS documentation</a>
 */
public class DnsRecord {

  private String name;
  private List<String> rrdatas = new LinkedList<>();
  private Integer ttl = 86400; // the default ttl of 24 hours
  private DnsRecordType type;
  private String parentName;
  private Long parentId;

  /**
   * A private constructor. Obtain an instance using {@link DnsRecord#Builder}.
   */
  private DnsRecord() {
  }

  DnsRecord(Builder builder) {
    this.name = builder.name;
    this.rrdatas = ImmutableList.copyOf(builder.rrdatas);
    this.ttl = builder.ttl;
    this.type = builder.type;
    this.parentName = builder.parentName;
    this.parentId = builder.parentId;
  }

  /**
   * Enum for the DNS record types supported by Cloud DNS.
   *
   * <p>
   * Google Cloud DNS currently supports records of type A, AAAA, CNAME, MX
   * NAPTR, NS, PTR, SOA, SPF, SRV, TXT.
   *
   * @see
   * <a href="https://cloud.google.com/dns/what-is-cloud-dns#supported_record_types">Cloud
   * DNS supported record types</a>
   */
  public enum DnsRecordType {
    A("A"),
    AAAA("AAAA"),
    CNAME("CNAME"),
    MX("MX"),
    NAPTR("NAPTR"),
    NS("NS"),
    PTR("PTR"),
    SOA("SOA"),
    SPF("SPF"),
    SRV("SRV"),
    TXT("TXT");

    private final String type;

    private DnsRecordType(String type) {
      this.type = type;
    }
  }

  public static class Builder {

    private List<String> rrdatas = new LinkedList<>();
    private String name;
    private Integer ttl = 86400; // default ttl of 24 hours
    private DnsRecordType type;
    private String parentName;
    private Long parentId;

    private Builder() {
    }

    /**
     * Creates a builder and pre-populates attributes with the values from the
     * provided DnsRecord instance.
     */
    public Builder(DnsRecord record) {
      this.name = record.name;
      this.ttl = record.ttl;
      this.type = record.type;
      this.parentId = record.parentId;
      this.parentName = record.parentName;
      this.rrdatas.addAll(record.rrdatas);
    }

    /**
     * Adds a record to the record set.
     *
     * <p>
     * The records should be as defined in RFC 1035 (section 5) and RFC 1034
     * (section 3.6.1). Examples of records are available in
     * <a href="https://cloud.google.com/dns/what-is-cloud-dns#supported_record_types">Cloud
     * DNS documentation</a>.
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
     * Sets the number of seconds that this record can be cached by resolvers.
     * This number must be non-negative.
     *
     * @param ttl A non-negative number of seconds
     */
    public Builder ttl(int ttl) {
      // change only if 
      if (ttl < 0) {
        throw new IllegalArgumentException(
                "TTL cannot be negative. The supplied value was " + ttl + "."
        );
      }
      this.ttl = ttl;
      return this;
    }

    /**
     * The identifier of a supported record type, for example, A, AAAA, MX, TXT,
     * and so on.
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
     */
    public Builder managedZone(ManagedZoneInfo parent) {
      checkNotNull(parent);
      this.parentId = parent.id();
      this.parentName = parent.name();
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
   * Get user assigned name of this DNS record.
   *
   * TODO: is this field mandatory?
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
   * Returns the number of seconds that this ResourceRecordSet can be cached by
   * resolvers.
   *
   * <p>
   * This number is provided by the user. If this values is not set, we use
   * default of 86400.
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
   * Returns name of the managed zone that this record belongs to.
   *
   * <p>
   * The name of the managed zone is provided by the user when the managed zone
   * is created. It is unique within a project. If this DNS record is not
   * associated with a managed zone, this returns null.
   */
  public String parentName() {
    return parentName;
  }

  /**
   * Returns name of the managed zone that this record belongs to.
   *
   * <p>
   * The id of the managed zone is determined by the server when the managed
   * zone is created. It is a read only value. If this DNS record is not
   * associated with a managed zone, or if the id of the managed zone was not
   * loaded from the cloud service, this returns null.
   */
  public Long parentId() {
    return parentId;
  }

}
