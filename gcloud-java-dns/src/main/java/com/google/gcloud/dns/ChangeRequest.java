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

import com.google.api.services.dns.model.Change;
import com.google.common.base.Function;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;

/**
 * A class representing an atomic update to a collection of {@link RecordSet}s within a {@code
 * Zone}.
 *
 * @see <a href="https://cloud.google.com/dns/api/v1/changes">Google Cloud DNS documentation</a>
 */
public class ChangeRequest extends ChangeRequestInfo {

  private static final long serialVersionUID = -9027378042756366333L;
  private final DnsOptions options;
  private final String zoneName;
  private transient Dns dns;

  /**
   * This enumerates the possible states of a {@code ChangeRequest}.
   *
   * @see <a href="https://cloud.google.com/dns/api/v1/changes#resource">Google Cloud DNS
   * documentation</a>
   */
  public enum Status {
    PENDING,
    DONE
  }

  /**
   * A builder for {@code ChangeRequest}s.
   */
  public static class Builder extends ChangeRequestInfo.Builder {

    private final Dns dns;
    private final String zoneName;
    private final ChangeRequestInfo.BuilderImpl infoBuilder;

    private Builder(ChangeRequest cr) {
      this.dns = cr.dns;
      this.zoneName = cr.zoneName;
      this.infoBuilder = new ChangeRequestInfo.BuilderImpl(cr);
    }

    @Override
    public Builder additions(List<RecordSet> additions) {
      infoBuilder.additions(additions);
      return this;
    }

    @Override
    public Builder deletions(List<RecordSet> deletions) {
      infoBuilder.deletions(deletions);
      return this;
    }

    @Override
    public Builder add(RecordSet recordSet) {
      infoBuilder.add(recordSet);
      return this;
    }

    @Override
    public Builder delete(RecordSet recordSet) {
      infoBuilder.delete(recordSet);
      return this;
    }

    @Override
    public Builder clearAdditions() {
      infoBuilder.clearAdditions();
      return this;
    }

    @Override
    public Builder clearDeletions() {
      infoBuilder.clearDeletions();
      return this;
    }

    @Override
    public Builder removeAddition(RecordSet recordSet) {
      infoBuilder.removeAddition(recordSet);
      return this;
    }

    @Override
    public Builder removeDeletion(RecordSet recordSet) {
      infoBuilder.removeDeletion(recordSet);
      return this;
    }

    @Override
    Builder id(String id) {
      infoBuilder.id(id);
      return this;
    }

    @Override
    Builder startTimeMillis(long startTimeMillis) {
      infoBuilder.startTimeMillis(startTimeMillis);
      return this;
    }

    @Override
    Builder status(Status status) {
      infoBuilder.status(status);
      return this;
    }

    @Override
    public ChangeRequest build() {
      return new ChangeRequest(dns, zoneName, infoBuilder);
    }
  }

  ChangeRequest(Dns dns, String zoneName, ChangeRequest.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.zoneName = zoneName;
    this.dns = dns;
    this.options = dns.options();
  }

  static Function<Change, ChangeRequest> fromPbFunction(final Dns dns, final String zoneName) {
    return new Function<Change, ChangeRequest>() {
      @Override
      public ChangeRequest apply(com.google.api.services.dns.model.Change pb) {
        return ChangeRequest.fromPb(dns, zoneName, pb);
      }
    };
  }

  /**
   * Returns the name of the {@link Zone} associated with this change request.
   */
  public String zoneName() {
    return this.zoneName;
  }

  /**
   * Returns the {@link Dns} service object associated with this change request.
   */
  public Dns dns() {
    return dns;
  }

  /**
   * Applies this change request to a zone that it is associated with.
   */
  public ChangeRequest applyTo(Dns.ChangeRequestOption... options) {
    return dns.applyChangeRequest(zoneName, this, options);
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof ChangeRequest && Objects.equals(toPb(), ((ChangeRequest) obj).toPb())
        && Objects.equals(options, ((ChangeRequest) obj).options)
        && Objects.equals(zoneName, ((ChangeRequest) obj).zoneName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), options, zoneName);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.dns = options.service();
  }

  static ChangeRequest fromPb(Dns dns, String zoneName,
      com.google.api.services.dns.model.Change pb) {
    ChangeRequestInfo info = ChangeRequestInfo.fromPb(pb);
    return new ChangeRequest(dns, zoneName, new ChangeRequestInfo.BuilderImpl(info));
  }
}
