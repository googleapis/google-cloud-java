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

import com.google.common.base.Charsets;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

abstract class StdXCaptureRule implements TestRule {

  private final ByteArrayOutputStream byteArrayOutputStream;

  public StdXCaptureRule() {
    byteArrayOutputStream = new ByteArrayOutputStream();
  }

  protected abstract PrintStream getOriginal();

  protected abstract void set(PrintStream ps);

  /**
   * Get a handle to the raw bytes written during the running test so far.
   *
   * @return A read-only {@link ByteArrayOutputStream} representing the raw bytes written so far.
   *     <p><i>Note the following behavior of the return value:</i>
   *     <ol>
   *       <li>Calling any "write" method call will result in an {@link IllegalStateException}
   *       <li>Calls to {@link ByteArrayOutputStream#toByteArray()} will result in a new copy of the
   *           underlying array up to that point
   *       <li>Calls to {@link ByteArrayOutputStream#flush()} will be silently ignored
   *       <li>Calls to {@link ByteArrayOutputStream#close()} will be silently ignored
   *     </ol>
   */
  public ByteArrayOutputStream getCapturedOutput() {
    return new ReadOnlyByteArrayOutputStream(byteArrayOutputStream);
  }

  /**
   * Return a UTF-8 {@link String} of all bytes written during the running test so far.
   *
   * @return UTF-8 {@link String} of all bytes written
   */
  public String getCapturedOutputAsUtf8String() {
    return new String(byteArrayOutputStream.toByteArray(), Charsets.UTF_8);
  }

  @Override
  public Statement apply(final Statement base, Description description) {
    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        PrintStream originalOut = getOriginal();
        TeeOutputStream tee = new TeeOutputStream(System.out, byteArrayOutputStream);
        boolean outReplaced = false;
        try {
          set(new PrintStream(tee));
          outReplaced = true;
          base.evaluate();
        } finally {
          if (outReplaced) {
            set(originalOut);
          }
        }
      }
    };
  }

  private static final class TeeOutputStream extends OutputStream {
    private final OutputStream left;
    private final OutputStream right;

    public TeeOutputStream(OutputStream left, OutputStream right) {
      this.left = left;
      this.right = right;
    }

    @Override
    public void write(int b) throws IOException {
      try {
        left.write(b);
      } finally {
        right.write(b);
      }
    }

    @Override
    public void flush() throws IOException {
      try {
        left.flush();
      } finally {
        right.flush();
      }
    }
  }

  private static final class ReadOnlyByteArrayOutputStream extends ByteArrayOutputStream {
    private final ByteArrayOutputStream delegate;

    public ReadOnlyByteArrayOutputStream(ByteArrayOutputStream delegate) {
      this.delegate = delegate;
    }

    @Override
    public synchronized void write(int b) {
      throw getIllegalStateException("write(b)");
    }

    @Override
    public synchronized void write(byte[] b, int off, int len) {
      throw getIllegalStateException("write(byte[], off, len)");
    }

    @Override
    public synchronized void writeTo(OutputStream out) {
      throw getIllegalStateException("writeOt(out)");
    }

    @Override
    public synchronized void reset() {
      throw getIllegalStateException("reset()");
    }

    @Override
    public synchronized byte[] toByteArray() {
      return delegate.toByteArray();
    }

    @Override
    public void close() {
      // ignore
    }

    @Override
    public synchronized int size() {
      return delegate.size();
    }

    @Override
    public synchronized String toString() {
      return delegate.toString();
    }

    @Override
    public synchronized String toString(String charsetName) throws UnsupportedEncodingException {
      return delegate.toString(charsetName);
    }

    @SuppressWarnings("deprecation")
    @Override
    public synchronized String toString(int hibyte) {
      return delegate.toString(hibyte);
    }

    @Override
    public void flush() {
      // ignore
    }

    @Override
    public void write(byte[] b) {
      throw getIllegalStateException("write(byte[])");
    }

    private IllegalStateException getIllegalStateException(String desc) {
      return new IllegalStateException(desc + " is forbidden");
    }
  }
}
