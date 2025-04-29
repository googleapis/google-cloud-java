/*
 * Copyright 2024 Google LLC
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
package com.google.datastore.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Test for {@link DatastoreFactory}. */
@RunWith(JUnit4.class)
public class DatastoreFactoryTest {
  private static final String PROJECT_ID = "project-id";

  private DatastoreFactory factory = DatastoreFactory.get();

  /**
   * Without specifying a credential or transport, the factory will create a default transport on
   * its own.
   */
  @Test
  public void makeClient_Default() {
    DatastoreOptions options = new DatastoreOptions.Builder().projectId(PROJECT_ID).build();
    HttpRequestFactory f = factory.makeClient(options);
    assertNotNull(f.getTransport());
    assertTrue(f.getTransport() instanceof NetHttpTransport);
  }

  /**
   * Specifying a credential, but not a transport, the factory will use the transport from the
   * credential.
   */
  @Test
  public void makeClient_WithCredential() {
    NetHttpTransport transport = new NetHttpTransport();
    GoogleCredential credential = new GoogleCredential.Builder().setTransport(transport).build();
    DatastoreOptions options =
        new DatastoreOptions.Builder().projectId(PROJECT_ID).credential(credential).build();
    HttpRequestFactory f = factory.makeClient(options);
    assertEquals(transport, f.getTransport());
  }

  /** Specifying a transport, but not a credential, the factory will use the transport specified. */
  @Test
  public void makeClient_WithTransport() {
    NetHttpTransport transport = new NetHttpTransport();
    DatastoreOptions options =
        new DatastoreOptions.Builder().projectId(PROJECT_ID).transport(transport).build();
    HttpRequestFactory f = factory.makeClient(options);
    assertEquals(transport, f.getTransport());
  }

  /**
   * Specifying both credential and transport, the factory will use the transport specified and not
   * the one in the credential.
   */
  @Test
  public void makeClient_WithCredentialTransport() {
    NetHttpTransport credTransport = new NetHttpTransport();
    NetHttpTransport transport = new NetHttpTransport();
    GoogleCredential credential =
        new GoogleCredential.Builder().setTransport(credTransport).build();
    DatastoreOptions options =
        new DatastoreOptions.Builder()
            .projectId(PROJECT_ID)
            .credential(credential)
            .transport(transport)
            .build();
    HttpRequestFactory f = factory.makeClient(options);
    assertNotSame(credTransport, f.getTransport());
    assertEquals(transport, f.getTransport());
  }
}
