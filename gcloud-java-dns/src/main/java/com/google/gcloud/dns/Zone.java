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

import com.google.api.services.dns.model.ManagedZone;
import com.google.gcloud.Page;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;

/**
 * A Google Cloud DNS Zone object.
 *
 * <p>A zone is the container for all of your record sets that share the same DNS name prefix, for
 * example, example.com. Zones are automatically assigned a set of name servers when they are
 * created to handle responding to DNS queries for that zone. A zone has quotas for the number of
 * record sets that it can include.
 *
 * @see <a href="https://cloud.google.com/dns/zones/">Google Cloud DNS managed zone
 * documentation</a>
 */
public class Zone extends ZoneInfo {

  private static final long serialVersionUID = -5817771337847861598L;
  private final DnsOptions options;
  private transient Dns dns;

  /**
   * Builder for {@code Zone}.
   */
  public static class Builder extends ZoneInfo.Builder {
    private final Dns dns;
    private final ZoneInfo.BuilderImpl infoBuilder;

    private Builder(Zone zone) {
      this.dns = zone.dns;
      this.infoBuilder = new ZoneInfo.BuilderImpl(zone);
    }

    @Override
    public Builder name(String name) {
      infoBuilder.name(name);
      return this;
    }

    @Override
    Builder generatedId(String generatedId) {
      infoBuilder.generatedId(generatedId);
      return this;
    }

    @Override
    Builder creationTimeMillis(long creationTimeMillis) {
      infoBuilder.creationTimeMillis(creationTimeMillis);
      return this;
    }

    @Override
    public Builder dnsName(String dnsName) {
      infoBuilder.dnsName(dnsName);
      return this;
    }

    @Override
    public Builder description(String description) {
      infoBuilder.description(description);
      return this;
    }

    @Override
    Builder nameServerSet(String nameServerSet) {
      infoBuilder.nameServerSet(nameServerSet);
      return this;
    }

    @Override
    Builder nameServers(List<String> nameServers) {
      infoBuilder.nameServers(nameServers); // infoBuilder makes a copy
      return this;
    }

    @Override
    public Zone build() {
      return new Zone(dns, infoBuilder);
    }
  }

  Zone(Dns dns, ZoneInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.dns = dns;
    this.options = dns.options();
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  /**
   * Retrieves the latest information about the zone. The method retrieves the zone by name.
   *
   * @param options optional restriction on what fields should be fetched
   * @return zone object containing updated information or {@code null} if not not found
   * @throws DnsException upon failure
   */
  public Zone reload(Dns.ZoneOption... options) {
    return dns.getZone(name(), options);
  }

  /**
   * Deletes the zone. The method deletes the zone by name.
   *
   * @return {@code true} is zone was found and deleted and {@code false} otherwise
   * @throws DnsException upon failure
   */
  public boolean delete() {
    return dns.delete(name());
  }

  /**
   * Lists all {@link RecordSet}s associated with this zone. The method searches for zone by name.
   *
   * @param options optional restriction on listing and fields of {@link RecordSet}s returned
   * @return a page of record sets
   * @throws DnsException upon failure or if the zone is not found
   */
  public Page<RecordSet> listRecordSets(Dns.RecordSetListOption... options) {
    return dns.listRecordSets(name(), options);
  }

  /**
   * Submits {@link ChangeRequestInfo} to the service for it to applied to this zone. The method
   * searches for zone by name.
   *
   * @param options optional restriction on what fields of {@link ChangeRequest} should be returned
   * @return ChangeRequest with server-assigned ID
   * @throws DnsException upon failure or if the zone is not found
   */
  public ChangeRequest applyChangeRequest(ChangeRequestInfo changeRequest,
      Dns.ChangeRequestOption... options) {
    checkNotNull(changeRequest);
    return dns.applyChangeRequest(name(), changeRequest, options);
  }

  /**
   * Retrieves an updated information about a change request previously submitted to be applied to
   * this zone. Returns a {@link ChangeRequest} or {@code null} if the change request was not found.
   * Throws {@link DnsException} if the zone is not found.
   *
   * @param options optional restriction on what fields of {@link ChangeRequest} should be returned
   * @return updated ChangeRequest
   * @throws DnsException upon failure or if the zone is not found
   * @throws NullPointerException if {@code changeRequestId} is null
   */
  public ChangeRequest getChangeRequest(String changeRequestId,
      Dns.ChangeRequestOption... options) {
    checkNotNull(changeRequestId);
    return dns.getChangeRequest(name(), changeRequestId, options);
  }

  /**
   * Retrieves all change requests for this zone. The method searches for zone by name. Returns a
   * page of {@link ChangeRequest}s.
   *
   * @param options optional restriction on listing and fields to be returned
   * @return a page of change requests
   * @throws DnsException upon failure or if the zone is not found
   */
  public Page<ChangeRequest> listChangeRequests(Dns.ChangeRequestListOption... options) {
    return dns.listChangeRequests(name(), options);
  }

  /**
   * Returns the {@link Dns} service object associated with this zone.
   */
  public Dns dns() {
    return this.dns;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Zone && Objects.equals(toPb(), ((Zone) obj).toPb())
        && Objects.equals(options, ((Zone) obj).options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
    stream.defaultReadObject();
    this.dns = options.service();
  }

  static Zone fromPb(Dns dns, ManagedZone zone) {
    ZoneInfo info = ZoneInfo.fromPb(zone);
    return new Zone(dns, new ZoneInfo.BuilderImpl(info));
  }
}
