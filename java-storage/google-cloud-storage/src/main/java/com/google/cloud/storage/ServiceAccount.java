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

  private static final long serialVersionUID = -6492243440372543799L;

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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ServiceAccount)) {
      return false;
    }
    ServiceAccount that = (ServiceAccount) o;
    return Objects.equals(email, that.email);
  }

  /** Returns a {@code ServiceAccount} object for the provided email. */
  public static ServiceAccount of(String email) {
    return new ServiceAccount(email);
  }
}
