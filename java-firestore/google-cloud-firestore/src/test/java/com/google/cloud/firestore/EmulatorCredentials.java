/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.firestore;

import static org.junit.Assert.assertEquals;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import java.io.IOException;
import org.junit.Test;

public class EmulatorCredentials {
  @Test
  public void implementsCredentials() throws IOException {
    CredentialsProvider emulatorCredentials =
        FixedCredentialsProvider.create(new FirestoreOptions.EmulatorCredentials());
    assertEquals("Unauthenticated", emulatorCredentials.getCredentials().getAuthenticationType());
    assertEquals(true, emulatorCredentials.getCredentials().hasRequestMetadata());
    assertEquals(true, emulatorCredentials.getCredentials().hasRequestMetadataOnly());
  }
}
