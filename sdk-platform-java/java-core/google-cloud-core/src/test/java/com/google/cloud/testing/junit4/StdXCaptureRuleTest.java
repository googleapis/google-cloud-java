/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.testing.junit4;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintStream;
import org.junit.Test;

public final class StdXCaptureRuleTest {

  @Test(expected = IllegalStateException.class)
  public void returnedByteArrayOutputStreamIsReadOnly_writeByte() {
    getStdXCaptureRule().getCapturedOutput().write(0);
  }

  @Test(expected = IllegalStateException.class)
  public void returnedByteArrayOutputStreamIsReadOnly_writeByteArray() throws IOException {
    getStdXCaptureRule().getCapturedOutput().write(new byte[] {0});
  }

  @Test(expected = IllegalStateException.class)
  public void returnedByteArrayOutputStreamIsReadOnly_writeByteArrayRange() {
    getStdXCaptureRule().getCapturedOutput().write(new byte[] {0}, 0, 1);
  }

  @Test(expected = IllegalStateException.class)
  public void returnedByteArrayOutputStreamIsReadOnly_writeTo() throws IOException {
    getStdXCaptureRule().getCapturedOutput().writeTo(System.out);
  }

  @Test(expected = IllegalStateException.class)
  public void returnedByteArrayOutputStreamIsReadOnly_reset() {
    getStdXCaptureRule().getCapturedOutput().reset();
  }

  @Test
  public void returnedByteArrayOutputStreamIsReadOnly_close() throws IOException {
    getStdXCaptureRule().getCapturedOutput().close();
  }

  @Test
  public void returnedByteArrayOutputStreamIsReadOnly_flush() throws IOException {
    getStdXCaptureRule().getCapturedOutput().flush();
  }

  private static StdXCaptureRule getStdXCaptureRule() {
    return new StdXCaptureRule() {
      @Override
      protected PrintStream getOriginal() {
        fail("unexpected call");
        return null;
      }

      @Override
      protected void set(PrintStream ps) {
        fail("unexpected call");
      }
    };
  }
}
