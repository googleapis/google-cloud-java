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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiFunction;
import com.google.api.services.dns.model.ResourceRecordSet;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * A class that represents a Google Cloud DNS record set.
 *
 * <p>A {@code RecordSet} is the unit of data that will be returned by the DNS servers upon a DNS
 * request for a specific domain. The {@code RecordSet} holds the current state of the DNS records
 * that make up a zone. You can read the records but you cannot modify them directly. Rather, you
 * edit the records in a zone by creating a {@link ChangeRequest}.
 *
 * @see <a href="https://cloud.google.com/dns/api/v1/resourceRecordSets">Google Cloud DNS
 *     documentation</a>
 */
public final class RecordSet implements Serializable {

  static final Function<ResourceRecordSet, RecordSet> FROM_PB_FUNCTION =
      new Function<ResourceRecordSet, RecordSet>() {
        @Override
        public RecordSet apply(ResourceRecordSet pb) {
          return RecordSet.fromPb(pb);
        }
      };
  static final Function<RecordSet, ResourceRecordSet> TO_PB_FUNCTION =
      new Function<RecordSet, ResourceRecordSet>() {
        @Override
        public ResourceRecordSet apply(RecordSet recordSet) {
          return recordSet.toPb();
        }
      };
  private static final long serialVersionUID = 8148009870800115261L;
  private final String name;
  private final List<String> rrdatas;
  private final Integer ttl; // this is in seconds
  private final Type type;

  /**
   * Enum for the DNS record types supported by Cloud DNS.
   *
   * <p>Google Cloud DNS currently supports records of type A, AAAA, CAA, CNAME, MX NAPTR, NS, PTR,
   * SOA, SPF, SRV, TXT.
   *
   * @see <a href="https://cloud.google.com/dns/what-is-cloud-dns#supported_record_types">Cloud DNS
   *     supported record types</a>
   */
  public static final class Type extends StringEnumValue {
    private static final long serialVersionUID = -2217433987664635241L;

    private static final ApiFunction<String, Type> CONSTRUCTOR =
        new ApiFunction<String, Type>() {
          @Override
          public Type apply(String constant) {
            return new Type(constant);
          }
        };

    private static final StringEnumType<Type> type = new StringEnumType(Type.class, CONSTRUCTOR);

    /** Address record, which is used to map host names to their IPv4 address. */
    public static final Type A = type.createAndRegister("A");
    /** IPv6 Address record, which is used to map host names to their IPv6 address. */
    public static final Type AAAA = type.createAndRegister("AAAA");
    /**
     * Certificate Authority (CA) Authorization, which specifies which CAs are allowed to create
     * certificates for a domain.
     */
    public static final Type CAA = type.createAndRegister("CAA");
    /** Canonical name record, which is used to alias names. */
    public static final Type CNAME = type.createAndRegister("CNAME");
    /** Mail exchange record, which is used in routing requests to mail servers. */
    public static final Type MX = type.createAndRegister("MX");
    /** Naming authority pointer record, defined by RFC3403. */
    public static final Type NAPTR = type.createAndRegister("NAPTR");
    /** Name server record, which delegates a DNS zone to an authoritative server. */
    public static final Type NS = type.createAndRegister("NS");
    /** Pointer record, which is often used for reverse DNS lookups. */
    public static final Type PTR = type.createAndRegister("PTR");
    /** Start of authority record, which specifies authoritative information about a DNS zone. */
    public static final Type SOA = type.createAndRegister("SOA");
    /** Sender policy framework record, which is used in email validation systems. */
    public static final Type SPF = type.createAndRegister("SPF");
    /**
     * Service locator record, which is used by some voice over IP, instant messaging protocols and
     * other applications.
     */
    public static final Type SRV = type.createAndRegister("SRV");
    /**
     * Text record, which can contain arbitrary text and can also be used to define machine readable
     * data such as security or abuse prevention information.
     */
    public static final Type TXT = type.createAndRegister("TXT");

    private Type(String constant) {
      super(constant);
    }

    /**
     * Get the Type for the given String constant, and throw an exception if the constant is not
     * recognized.
     */
    public static Type valueOfStrict(String constant) {
      return type.valueOfStrict(constant);
    }

    /** Get the Type for the given String constant, and allow unrecognized values. */
    public static Type valueOf(String constant) {
      return type.valueOf(constant);
    }

    /** Return the known values for Type. */
    public static Type[] values() {
      return type.values();
    }
  }

  /** A builder for {@link RecordSet}. */
  public static class Builder {

    private List<String> rrdatas = new LinkedList<>();
    private String name;
    private Integer ttl;
    private Type type;

    private Builder(String name, Type type) {
      this.name = checkNotNull(name);
      this.type = checkNotNull(type);
    }

    /**
     * Creates a builder and pre-populates attributes with the values from the provided {@code
     * RecordSet} instance.
     */
    private Builder(RecordSet record) {
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
     *     DNS documentation</a>
     */
    public Builder addRecord(String record) {
      this.rrdatas.add(checkNotNull(record));
      return this;
    }

    /** Removes a record from the set. An exact match is required. */
    public Builder removeRecord(String record) {
      this.rrdatas.remove(checkNotNull(record));
      return this;
    }

    /** Removes all the records. */
    public Builder clearRecords() {
      this.rrdatas.clear();
      return this;
    }

    /** Replaces the current records with the provided list of records. */
    public Builder setRecords(List<String> records) {
      this.rrdatas = Lists.newLinkedList(checkNotNull(records));
      return this;
    }

    /** Sets the name for this record set. For example, www.example.com. */
    public Builder setName(String name) {
      this.name = checkNotNull(name);
      return this;
    }

    /**
     * Sets the time that this record can be cached by resolvers. This number must be non-negative.
     * The maximum duration must be equivalent to at most {@link Integer#MAX_VALUE} seconds.
     *
     * @param duration A non-negative number of time units
     * @param unit The unit of the ttl parameter
     */
    public Builder setTtl(int duration, TimeUnit unit) {
      checkArgument(
          duration >= 0, "Duration cannot be negative. The supplied value was %s.", duration);
      checkNotNull(unit);
      // we cannot have long because pb does not support it
      long converted = unit.toSeconds(duration);
      ttl = Ints.checkedCast(converted);
      return this;
    }

    /** The identifier of a supported record type, for example, A, AAAA, MX, TXT, and so on. */
    public Builder setType(Type type) {
      this.type = checkNotNull(type);
      return this;
    }

    /** Builds the record set. */
    public RecordSet build() {
      return new RecordSet(this);
    }
  }

  private RecordSet(Builder builder) {
    this.name = builder.name;
    this.rrdatas = ImmutableList.copyOf(builder.rrdatas);
    this.ttl = builder.ttl;
    this.type = builder.type;
  }

  /** Creates a builder pre-populated with the attribute values of this instance. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /** Creates a {@code RecordSet} builder for the given {@code name} and {@code type}. */
  public static Builder newBuilder(String name, Type type) {
    return new Builder(name, type);
  }

  /** Returns the user-assigned name of this record set. */
  public String getName() {
    return name;
  }

  /** Returns a list of records stored in this record set. */
  public List<String> getRecords() {
    return rrdatas;
  }

  /** Returns the number of seconds that this record set can be cached by resolvers. */
  public Integer getTtl() {
    return ttl;
  }

  /** Returns the type of this record set. */
  public Type getType() {
    return type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, rrdatas, ttl, type);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof RecordSet && Objects.equals(this.toPb(), ((RecordSet) obj).toPb());
  }

  ResourceRecordSet toPb() {
    ResourceRecordSet pb = new ResourceRecordSet();
    pb.setName(this.getName());
    pb.setRrdatas(this.getRecords());
    pb.setTtl(this.getTtl());
    pb.setType(this.getType().name());
    return pb;
  }

  static RecordSet fromPb(ResourceRecordSet pb) {
    Builder builder = newBuilder(pb.getName(), Type.valueOf(pb.getType()));
    if (pb.getRrdatas() != null) {
      builder.setRecords(pb.getRrdatas());
    }
    if (pb.getTtl() != null) {
      builder.setTtl(pb.getTtl(), TimeUnit.SECONDS);
    }
    return builder.build();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", getName())
        .add("rrdatas", getRecords())
        .add("ttl", getTtl())
        .add("type", getType())
        .toString();
  }
}
