/*
 * Copyright 2023, Google Inc. All rights reserved.
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

import java.io.File;
import org.junit.jupiter.api.Test;

class GoogleAuthUtilsTest {

  @Test
  void getWellKnownCredentialsPath_correct() {
    DefaultCredentialsProvider provider =
        new DefaultCredentialsProviderTest.TestDefaultCredentialsProvider();
    // since the TestDefaultCredentialsProvider properties and envs are not set,
    // the base folder will be an empty string using.
    File homeDir = new File("");
    File configDir = new File(homeDir, ".config");
    File cloudConfigDir = new File(configDir, DefaultCredentialsProvider.CLOUDSDK_CONFIG_DIRECTORY);
    File wellKnownFile =
        new File(cloudConfigDir, DefaultCredentialsProvider.WELL_KNOWN_CREDENTIALS_FILE);

    String obtainedPath = GoogleAuthUtils.getWellKnownCredentialsPath(provider);

    assertNotNull(obtainedPath);
    assertEquals(obtainedPath, wellKnownFile.getAbsolutePath());
  }
}
