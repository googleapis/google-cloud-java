/*
 * Copyright 2021 Google LLC
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
package com.google.datastore.v1.client;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Test for {@link ChecksumEnforcingInputStream}. */
@RunWith(JUnit4.class)
public class ChecksumEnforcingInputStreamTest {
  public void test(int payloadSize) throws Exception {
    // read 1000 bytes at a time
    // Since checksum should be correct, do not expect IOException
    try (ChecksumEnforcingInputStream testInstance = setUpData(payloadSize)) {
      byte[] buf = new byte[1000];
      while (testInstance.read(buf, 0, 1000) != -1) {
        // do nothing with the bytes read
      }
    } catch (IOException e) {
      fail("checksum verification failed! " + e.getMessage());
    }
  }

  @Test
  public void read_withValidChecksum_differentPayloadSizes() throws Exception {
    // test with various payload sizes (1, 2, 2**2, 2**3 etc upto 2**28 = 256MB)
    for (int i = 0, payloadSize = 1; i < 29; i++) {
      long start = System.currentTimeMillis();
      test(payloadSize);
      payloadSize *= 2;
      long duration = System.currentTimeMillis() - start;
      // log test duration times for bigger payloads
      if (i > 20) {
        System.out.println("Test duration for payloadsize = 2** " + i + " is: " + duration + "ms");
      }
    }
  }

  @Test
  public void read_withInvalidChecksum() {
    // build a test instance with invalidchecksum
    // read 1000 bytes at a time
    // Since checksum should be correct, do not expect IOException
    try (ChecksumEnforcingInputStream instance =
        new ChecksumEnforcingInputStream(
            new ByteArrayInputStream("hello there".getBytes(UTF_8)), "this checksum is invalid")) {
      byte[] buf = new byte[1000];
      while (instance.read(buf, 0, 1000) != -1) {
        // do nothing with the bytes read
      }
    } catch (IOException e) {
      // this is expected
      return;
    }
    fail("should have failed");
  }

  @Test
  public void markNotSupported() throws Exception {
    try (ChecksumEnforcingInputStream testInstance = setUpData(1)) {
      assertFalse(testInstance.markSupported());
    }
  }

  private ChecksumEnforcingInputStream setUpData(int payloadSize) throws Exception {
    // setup a String of size = input param: payloadSize
    String str = "This is a repeating string.";
    String payload;
    if (payloadSize > str.length()) {
      int num = payloadSize / str.length();
      StringBuilder buf = new StringBuilder();
      for (int i = 0; i < num; i++) {
        buf.append(str);
      }
      payload = buf.toString();
    } else {
      payload = str.substring(0, payloadSize);
    }
    byte[] bytes = payload.getBytes(UTF_8);
    String expectedChecksum = EndToEndChecksumHandler.computeChecksum(bytes);
    return new ChecksumEnforcingInputStream(new ByteArrayInputStream(bytes), expectedChecksum);
  }
}
