/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.firestore.it;

import static com.google.cloud.firestore.LocalFirestoreHelper.autoId;
import static com.google.cloud.firestore.it.ITQueryTest.map;

import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.FirestoreSpy;
import com.google.cloud.firestore.ListenerRegistration;
import com.google.common.base.Preconditions;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public abstract class ITBaseTest {

  /**
   * Firestore databases can be subject to a ~30s "cold start" delay if they have not been used
   * recently, so before any tests run we "prime" the backend.
   */
  private static final long PRIMING_TIMEOUT_MS = 45000;

  private static final Logger logger = Logger.getLogger(ITBaseTest.class.getName());

  protected Firestore firestore;
  protected FirestoreSpy firestoreSpy;
  private FirestoreOptions firestoreOptions;
  private boolean backendPrimed = false;

  protected enum FirestoreEdition {
    STANDARD,
    ENTERPRISE
  }

  static String getTargetBackend() {
    String targetPropertyName = "FIRESTORE_TARGET_BACKEND";
    String targetBackend = System.getProperty(targetPropertyName);
    if (targetBackend == null) {
      targetBackend = System.getenv(targetPropertyName);
    }

    return targetBackend;
  }

  static FirestoreEdition getFirestoreEdition() {
    String editionPropertyName = "FIRESTORE_EDITION";
    String firestoreEdition = System.getProperty(editionPropertyName);
    if (firestoreEdition == null) {
      firestoreEdition = System.getenv(editionPropertyName);
    }

    if (firestoreEdition == null) {
      return FirestoreEdition.STANDARD;
    }
    return FirestoreEdition.valueOf(firestoreEdition.toUpperCase());
  }

  @Before
  public void before() throws Exception {
    FirestoreOptions.Builder optionsBuilder = FirestoreOptions.newBuilder();

    String dbPropertyName = "FIRESTORE_NAMED_DATABASE";
    String namedDb = System.getProperty(dbPropertyName);
    if (namedDb == null) {
      namedDb = System.getenv(dbPropertyName);
    }
    if (namedDb != null) {
      logger.log(Level.INFO, "Integration test using named database " + namedDb);
      optionsBuilder = optionsBuilder.setDatabaseId(namedDb);
    } else {
      logger.log(Level.INFO, "Integration test using default database.");
    }

    String targetBackend = getTargetBackend();
    TransportChannelProvider defaultProvider = optionsBuilder.build().getTransportChannelProvider();
    if (targetBackend != null) {
      if (targetBackend.equals("PROD")) {
        // do nothing to use the default
      } else if (targetBackend.equals("QA")) {
        optionsBuilder.setChannelProvider(
            defaultProvider.withEndpoint("staging-firestore.sandbox.googleapis.com:443"));
      } else if (targetBackend.equals("NIGHTLY")) {
        optionsBuilder.setChannelProvider(
            defaultProvider.withEndpoint("test-firestore.sandbox.googleapis.com:443"));
      } else if (targetBackend.equals("EMULATOR")) {
        optionsBuilder.setEmulatorHost("localhost:8080");
      }
    }

    firestoreOptions = optionsBuilder.build();
    logger.log(
        Level.INFO,
        "Integration test against " + firestoreOptions.getTransportChannelProvider().getEndpoint());
    firestore = firestoreOptions.getService();
    primeBackend();
  }

  public void primeBackend() throws Exception {
    if (backendPrimed) return;

    backendPrimed = true;
    CompletableFuture<Void> watchInitialized = new CompletableFuture<>();
    CompletableFuture<Void> watchUpdateReceived = new CompletableFuture<>();
    DocumentReference docRef = firestore.collection(autoId()).document();
    ListenerRegistration listenerRegistration =
        docRef.addSnapshotListener(
            (snapshot, error) -> {
              if (error != null) {
                logger.log(
                    Level.SEVERE, "Prime backend received error in snapshot listener.", error);
                if (!watchInitialized.isDone()) {
                  watchInitialized.completeExceptionally(error);
                } else if (!watchUpdateReceived.isDone()) {
                  watchUpdateReceived.completeExceptionally(error);
                }
              }
              if (snapshot != null) {
                if ("done".equals(snapshot.get("value"))) {
                  watchUpdateReceived.complete(null);
                } else {
                  watchInitialized.complete(null);
                }
              }
            });

    // Wait for watch to initialize and deliver first event.
    watchInitialized.get(PRIMING_TIMEOUT_MS, TimeUnit.MILLISECONDS);

    // Use a transaction to perform a write without triggering any local events.
    docRef
        .getFirestore()
        .runTransaction(
            transaction -> {
              transaction.set(docRef, map("value", "done"));
              return null;
            });

    // Wait to see the write on the watch stream.
    watchUpdateReceived.get(PRIMING_TIMEOUT_MS, TimeUnit.MILLISECONDS);

    listenerRegistration.remove();
  }

  @After
  public void after() throws Exception {
    Preconditions.checkNotNull(
        firestore,
        "Error instantiating Firestore. Check that the service account credentials were properly"
            + " set.");
    firestore.close();
    firestore = null;
    firestoreOptions = null;
    firestoreSpy = null;
  }

  public FirestoreSpy useFirestoreSpy() {
    if (firestoreSpy == null) {
      firestoreSpy = new FirestoreSpy(firestoreOptions);
      firestore = firestoreSpy.spy;
    }
    return firestoreSpy;
  }
}
