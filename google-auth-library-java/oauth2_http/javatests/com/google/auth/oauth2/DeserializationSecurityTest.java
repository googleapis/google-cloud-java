/*
 * Copyright 2026, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.auth.http.HttpTransportFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class DeserializationSecurityTest {

  /** A class that does not implement HttpTransportFactory. */
  static class ArbitraryClass {}

  /** A custom implementation of HttpTransportFactory that should be allowed. */
  static class CustomTransportFactory implements HttpTransportFactory {
    @Override
    public HttpTransport create() {
      return new NetHttpTransport();
    }
  }

  /**
   * An implementation of HttpTransportFactory that can registered to the ServiceLoader. Used in
   * {@link #runWithTempServiceLoader} to load to `META_INF/services/*`.
   */
  public static class TestServiceLoaderFactory implements HttpTransportFactory {
    @Override
    public HttpTransport create() {
      return new NetHttpTransport();
    }
  }

  private ServiceAccountCredentials createCredentials() throws Exception {
    String json =
        "{"
            + "\"type\": \"service_account\","
            + "\"project_id\": \"project-id\","
            + "\"private_key_id\": \"private-key-id\","
            + "\"private_key\": \""
            + getSAPrivateKey()
            + "\","
            + "\"client_email\": \"client-email\","
            + "\"client_id\": \"client-id\","
            + "\"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\","
            + "\"token_uri\": \"https://accounts.google.com/o/oauth2/token\","
            + "\"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\","
            + "\"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/client-email\""
            + "}";
    return ServiceAccountCredentials.fromStream(new ByteArrayInputStream(json.getBytes()));
  }

  private static String getSAPrivateKey() {
    return ServiceAccountCredentialsTest.PRIVATE_KEY_PKCS8.replace("\n", "\\n");
  }

  /**
   * Helper method to run a task within a temporary ServiceLoader environment to prevent test
   * configuration changes impacting other tests.
   *
   * <p>It creates a temporary directory structure for META-INF/services, writes the service
   * provider configuration file to the temp directory, and creates a URLClassLoader that includes
   * this temp directory. It then sets the current thread's context class loader to this custom
   * class loader before executing the task. This ensures that ServiceLoader.load() calls within the
   * task will find the specific service provider defined for the test, without affecting other
   * tests or the global environment.
   *
   * @param task The task to execute within the isolated environment.
   * @param tempDir The temporary directory to use for ServiceLoader configuration.
   * @throws Exception If any error occurs during setup, execution, or cleanup.
   */
  private void runWithTempServiceLoader(Callable<Void> task, Path tempDir) throws Exception {
    ClassLoader originalClassLoader = Thread.currentThread().getContextClassLoader();
    try {
      Path servicesDir = tempDir.resolve("META-INF").resolve("services");
      Files.createDirectories(servicesDir);
      Path serviceFile = servicesDir.resolve(HttpTransportFactory.class.getName());
      Files.write(
          serviceFile, TestServiceLoaderFactory.class.getName().getBytes(StandardCharsets.UTF_8));

      URL[] urls = new URL[] {tempDir.toUri().toURL()};
      try (URLClassLoader testClassLoader = new URLClassLoader(urls, originalClassLoader)) {
        Thread.currentThread().setContextClassLoader(testClassLoader);
        task.call();
      }
    } finally {
      Thread.currentThread().setContextClassLoader(originalClassLoader);
    }
  }

  @Test
  void testArbitraryClassInstantiationPrevented() throws Exception {
    ServiceAccountCredentials credentials = createCredentials();

    // Use reflection to set `transportFactoryClassName` to ArbitraryClass.
    // Reflection is needed because ArbitraryClass does not implement
    // HttpTransportFactory. Setting the className simulates a malicious stream
    // which could not be created via the public Builder API.
    Field transportFactoryClassNameField =
        ServiceAccountCredentials.class.getDeclaredField("transportFactoryClassName");
    transportFactoryClassNameField.setAccessible(true);
    transportFactoryClassNameField.set(credentials, ArbitraryClass.class.getName());

    // Serialize this to a stream
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(credentials);

    // Deserialize from the stream
    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(bis);

    // Assert that an exception is thrown because ArbitraryClass is not a valid
    // HttpTransportFactory
    assertThrows(IOException.class, ois::readObject);

    bos.close();
    oos.close();
    bis.close();
    ois.close();
  }

  @Test
  void testValidTransportFactoryDeserialization() throws Exception {
    ServiceAccountCredentials credentials = createCredentials();

    // Use the builder to set a valid transport factory. This will set the
    // transportFactoryClassName field used during serialization.
    credentials =
        credentials.toBuilder()
            .setHttpTransportFactory(new OAuth2Utils.DefaultHttpTransportFactory())
            .build();

    // Serialize this to a stream
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(credentials);

    // Deserialize from the stream
    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(bis);

    ServiceAccountCredentials deserialized = (ServiceAccountCredentials) ois.readObject();
    assertNotNull(deserialized);

    // Use reflection to get the field as there is no getter for transportFactory.
    Field transportFactoryField =
        ServiceAccountCredentials.class.getDeclaredField("transportFactory");
    transportFactoryField.setAccessible(true);
    Object factory = transportFactoryField.get(deserialized);

    assertEquals(
        OAuth2Utils.DefaultHttpTransportFactory.class.getName(), factory.getClass().getName());

    bos.close();
    oos.close();
    bis.close();
    ois.close();
  }

  @Test
  void testNonExistentClassDeserialization() throws Exception {
    ServiceAccountCredentials credentials = createCredentials();

    // Use reflection to set `transportFactoryClassName` to a non-existent class.
    // Reflection is needed because the non-existent class does not exist. Setting
    // the className simulates a malicious stream which could not be created via the
    // public Builder API.
    Field transportFactoryClassNameField =
        ServiceAccountCredentials.class.getDeclaredField("transportFactoryClassName");
    transportFactoryClassNameField.setAccessible(true);
    transportFactoryClassNameField.set(credentials, "com.malicious.NonExistentClass");

    // Serialize this to a stream
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(credentials);

    // Deserialize from the stream
    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(bis);

    // Assert that ClassNotFoundException (for a non-existent class) is thrown
    assertThrows(ClassNotFoundException.class, ois::readObject);

    bos.close();
    oos.close();
    bis.close();
    ois.close();
  }

  @Test
  void testCustomTransportFactory() throws Exception {
    ServiceAccountCredentials credentials = createCredentials();

    // Use the builder to set our custom transport factory. This will set the
    // transportFactoryClassName field used during serialization.
    credentials =
        credentials.toBuilder().setHttpTransportFactory(new CustomTransportFactory()).build();

    // Serialize this to a stream
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(credentials);

    // Deserialize from the stream
    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(bis);

    ServiceAccountCredentials deserialized = (ServiceAccountCredentials) ois.readObject();
    assertNotNull(deserialized);

    // Use reflection to get the field as there is no getter for transportFactory.
    Field transportFactoryField =
        ServiceAccountCredentials.class.getDeclaredField("transportFactory");
    transportFactoryField.setAccessible(true);
    Object factory = transportFactoryField.get(deserialized);

    assertEquals(CustomTransportFactory.class.getName(), factory.getClass().getName());

    bos.close();
    oos.close();
    bis.close();
    ois.close();
  }

  @Test
  void testServiceLoaderPathDeserialization(@TempDir Path tempDir) throws Exception {
    runWithTempServiceLoader(
        () -> {
          // Create a ServiceAccountCredentials using the builder WITHOUT setting the
          // transport factory. The constructor should automatically look up the factory
          // via ServiceLoader.
          ServiceAccountCredentials credentials =
              ServiceAccountCredentials.newBuilder()
                  .setClientEmail("client-email")
                  .setPrivateKeyId("private-key-id")
                  .setPrivateKeyString(ServiceAccountCredentialsTest.PRIVATE_KEY_PKCS8)
                  .setProjectId("project-id")
                  .build();

          // 2Verify that the credentials were created with the TestServiceLoaderFactory.
          // This confirms that the ServiceLoader mechanism in the constructor is working.
          Field transportFactoryClassNameField =
              ServiceAccountCredentials.class.getDeclaredField("transportFactoryClassName");
          transportFactoryClassNameField.setAccessible(true);
          assertEquals(
              TestServiceLoaderFactory.class.getName(),
              transportFactoryClassNameField.get(credentials));

          // Serialize this to a stream
          ByteArrayOutputStream bos = new ByteArrayOutputStream();
          ObjectOutputStream oos = new ObjectOutputStream(bos);
          oos.writeObject(credentials);

          // Deserialize from the stream
          ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
          ObjectInputStream ois = new ObjectInputStream(bis);

          ServiceAccountCredentials deserialized = (ServiceAccountCredentials) ois.readObject();
          assertNotNull(deserialized);

          // Assert that it deserialized correctly and has the correct factory type.
          // This confirms that newInstance() found it via the ServiceLoader path.
          Field transportFactoryField =
              ServiceAccountCredentials.class.getDeclaredField("transportFactory");
          transportFactoryField.setAccessible(true);
          Object factory = transportFactoryField.get(deserialized);

          assertEquals(TestServiceLoaderFactory.class.getName(), factory.getClass().getName());

          bos.close();
          oos.close();
          bis.close();
          ois.close();

          return null;
        },
        tempDir);
  }
}
