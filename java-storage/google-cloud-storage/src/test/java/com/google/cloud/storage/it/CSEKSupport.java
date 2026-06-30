/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage.it;

import com.google.common.hash.Hashing;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Objects;
import javax.crypto.SecretKey;

/** Supporting class for Customer Supplied Encryption Key related state */
final class CSEKSupport {

  private final byte[] keyBytes;
  private final EncryptionKeyTuple tuple;
  private final Key key;

  private CSEKSupport(byte[] keyBytes, EncryptionKeyTuple tuple) {
    this.keyBytes = keyBytes;
    this.tuple = tuple;
    this.key =
        new SecretKey() {
          @Override
          public String getAlgorithm() {
            return tuple.algorithm;
          }

          @Override
          public String getFormat() {
            return null;
          }

          @Override
          public byte[] getEncoded() {
            return keyBytes;
          }
        };
  }

  byte[] getKeyBytes() {
    return keyBytes;
  }

  EncryptionKeyTuple getTuple() {
    return tuple;
  }

  Key getKey() {
    return key;
  }

  static CSEKSupport create() {
    byte[] bytes = new byte[32];
    new SecureRandom().nextBytes(bytes);
    String encode = Base64.getEncoder().encodeToString(bytes);
    String sha256 = Base64.getEncoder().encodeToString(Hashing.sha256().hashBytes(bytes).asBytes());
    return new CSEKSupport(bytes, new EncryptionKeyTuple("AES256", encode, sha256));
  }

  static final class EncryptionKeyTuple {
    private final String algorithm;
    private final String key;
    private final String keySha256;

    EncryptionKeyTuple(String algorithm, String key, String keySha256) {
      this.algorithm = algorithm;
      this.key = key;
      this.keySha256 = keySha256;
    }

    String getAlgorithm() {
      return algorithm;
    }

    String getKey() {
      return key;
    }

    String getKeySha256() {
      return keySha256;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof EncryptionKeyTuple)) {
        return false;
      }
      EncryptionKeyTuple that = (EncryptionKeyTuple) o;
      return Objects.equals(algorithm, that.algorithm)
          && Objects.equals(key, that.key)
          && Objects.equals(keySha256, that.keySha256);
    }

    @Override
    public int hashCode() {
      return Objects.hash(algorithm, key, keySha256);
    }

    @Override
    public String toString() {
      return "EncryptionKeyTuple{"
          + "algorithm='"
          + algorithm
          + '\''
          + ", key='"
          + key
          + '\''
          + ", keySha256='"
          + keySha256
          + '\''
          + '}';
    }
  }
}
