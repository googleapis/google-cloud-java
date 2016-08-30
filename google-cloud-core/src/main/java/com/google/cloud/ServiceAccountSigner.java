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

package com.google.cloud;

import java.util.Objects;

/**
 * Interface for a service account signer. A signer for a service account is capable of signing
 * bytes using the private key associated with its service account.
 */
public interface ServiceAccountSigner {

  class SigningException extends RuntimeException {

    private static final long serialVersionUID = 8962780757822799255L;

    SigningException(String message, Exception cause) {
      super(message, cause);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof SigningException)) {
        return false;
      }
      SigningException other = (SigningException) obj;
      return Objects.equals(getCause(), other.getCause())
          && Objects.equals(getMessage(), other.getMessage());
    }

    @Override
    public int hashCode() {
      return Objects.hash(getMessage(), getCause());
    }
  }

  /**
   * Returns the service account associated with the signer.
   */
  String account();

  /**
   * Signs the provided bytes using the private key associated with the service account.
   *
   * @param toSign bytes to sign
   * @return signed bytes
   * @throws SigningException if the attempt to sign the provided bytes failed
   */
  byte[] sign(byte[] toSign);
}
