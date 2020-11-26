/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.examples.storage.objects;

// [START storage_generate_encryption_key]
import com.google.common.io.BaseEncoding;
import java.security.SecureRandom;

public class GenerateEncryptionKey {
  public static void generateEncryptionKey() {
    byte[] key = new byte[32];
    new SecureRandom().nextBytes(key);
    String encryptionKey = BaseEncoding.base64().encode(key);

    System.out.println("Generated Base64-encoded AES-256 encryption key: " + encryptionKey);
  }
}
// [END storage_generate_encryption_key]
