/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.utils.testing;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpRequest;
import java.io.IOException;

/** Fake credential used for testing purpose. */
public class MockCredential extends Credential {
  public MockCredential() {
    super(
        new AccessMethod() {
          @Override
          public void intercept(HttpRequest request, String accessToken) throws IOException {}

          @Override
          public String getAccessTokenFromRequest(HttpRequest request) {
            return "MockAccessToken";
          }
        });
  }
}
