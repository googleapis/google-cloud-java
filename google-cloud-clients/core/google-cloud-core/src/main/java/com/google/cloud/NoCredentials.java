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

package com.google.cloud;

import com.google.auth.oauth2.OAuth2Credentials;
import java.io.ObjectStreamException;

/**
 * A placeholder for credentials to signify that requests sent to the server should not be
 * authenticated. This is typically useful when using local service emulators.
 */
public class NoCredentials extends OAuth2Credentials {

  private static final long serialVersionUID = -6263971603971044288L;
  private static final NoCredentials INSTANCE = new NoCredentials();

  private NoCredentials() {}

  private Object readResolve() throws ObjectStreamException {
    return INSTANCE;
  }

  public static NoCredentials getInstance() {
    return INSTANCE;
  }

  @Override
  public boolean equals(Object obj) {
    return this == obj;
  }

  @Override
  public int hashCode() {
    return System.identityHashCode(this);
  }
}
