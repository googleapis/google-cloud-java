/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.storage;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;

/**
 * A service account, with its specified scopes, authorized for this instance.
 *
 * @see <a href="https://cloud.google.com/storage/docs/authentication">Authenticating from Google
 *     Cloud Storage</a>
 */
public final class ServiceAccount implements Serializable {

  static final Function<com.google.api.services.storage.model.ServiceAccount, ServiceAccount>
      FROM_PB_FUNCTION =
          new Function<com.google.api.services.storage.model.ServiceAccount, ServiceAccount>() {
            @Override
            public ServiceAccount apply(com.google.api.services.storage.model.ServiceAccount pb) {
              return ServiceAccount.fromPb(pb);
            }
          };
  static final Function<ServiceAccount, com.google.api.services.storage.model.ServiceAccount>
      TO_PB_FUNCTION =
          new Function<ServiceAccount, com.google.api.services.storage.model.ServiceAccount>() {
            @Override
            public com.google.api.services.storage.model.ServiceAccount apply(
                ServiceAccount metadata) {
              return metadata.toPb();
            }
          };

  private static final long serialVersionUID = 4199610694227857331L;

  private final String email;

  private ServiceAccount(String email) {
    this.email = email;
  }

  /** Returns the email address of the service account. */
  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("email", email).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof ServiceAccount && Objects.equals(toPb(), ((ServiceAccount) obj).toPb());
  }

  com.google.api.services.storage.model.ServiceAccount toPb() {
    com.google.api.services.storage.model.ServiceAccount serviceAccountPb =
        new com.google.api.services.storage.model.ServiceAccount();
    serviceAccountPb.setEmailAddress(email);
    return serviceAccountPb;
  }

  /** Returns a {@code ServiceAccount} object for the provided email. */
  public static ServiceAccount of(String email) {
    return new ServiceAccount(email);
  }

  static ServiceAccount fromPb(com.google.api.services.storage.model.ServiceAccount accountPb) {
    return new ServiceAccount(accountPb.getEmailAddress());
  }
}
