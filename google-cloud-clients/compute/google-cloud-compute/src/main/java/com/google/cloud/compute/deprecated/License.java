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

package com.google.cloud.compute.deprecated;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Google Compute Engine License. A License represents a software license. Licenses are used to
 * track software usage in images, persistent disks, snapshots, and virtual machine instances.
 *
 * @see <a href="https://cloud.google.com/compute/docs/reference/latest/licenses">Licenses</a>
 */
public class License implements Serializable {

  private static final long serialVersionUID = 6907923910319640363L;

  private final LicenseId licenseId;
  private final Boolean chargesUseFee;

  License(LicenseId licenseId, Boolean chargesUseFee) {
    this.licenseId = checkNotNull(licenseId);
    this.chargesUseFee = chargesUseFee;
  }

  /** Returns the identity of the license. */
  public LicenseId getLicenseId() {
    return licenseId;
  }

  /**
   * Returns {@code true} if the customer will be charged a license fee for running software that
   * contains this license on an instance.
   */
  public Boolean chargesUseFee() {
    return chargesUseFee;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("licenseId", licenseId)
        .add("chargesUseFee", chargesUseFee)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(licenseId);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(License.class)
            && Objects.equals(toPb(), ((License) obj).toPb());
  }

  com.google.api.services.compute.model.License toPb() {
    com.google.api.services.compute.model.License licensePb =
        new com.google.api.services.compute.model.License();
    licensePb.setName(licenseId.getLicense());
    licensePb.setChargesUseFee(chargesUseFee);
    licensePb.setSelfLink(licenseId.getSelfLink());
    return licensePb;
  }

  static License fromPb(com.google.api.services.compute.model.License licensePb) {
    return new License(LicenseId.fromUrl(licensePb.getSelfLink()), licensePb.getChargesUseFee());
  }
}
