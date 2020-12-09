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
import java.util.Random;

public class GenerateEncryptionKey {
  /**
  * Generates a 256 bit (32 byte) AES encryption key and prints the base64 representation.
  * This is included for demonstration purposes only. You should generate your own key, and consult your security team
  * about best practices. Please remember that encryption keys should be handled with a comprehensive security policy.
  */
  public static void generateEncryptionKey() {
    byte[] key = new byte[32];
    new Random().nextBytes(key);
    String encryptionKey = BaseEncoding.base64().encode(key);

    System.out.println("Generated Base64-encoded AES-256 encryption key: " + encryptionKey);
  }
}
// [END storage_generate_encryption_key]
