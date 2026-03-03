/*
 * Copyright 2025 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
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

package com.google.api.gax.logging;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.spi.MDCAdapter;

/**
 * this adapter is for unit test only. It is set up via TestServiceProvider to test behavior when
 * LogWithMDC
 */
public class TestMDCAdapter implements MDCAdapter {
  Map<String, String> mdcValues = new HashMap<>();

  @Override
  public void put(String key, String val) {
    mdcValues.put(key, val);
  }

  @Override
  public String get(String key) {
    return "";
  }

  @Override
  public void remove(String key) {}

  @Override
  public void clear() {
    mdcValues.clear();
  }

  @Override
  public Map<String, String> getCopyOfContextMap() {
    return mdcValues;
  }

  @Override
  public void setContextMap(Map<String, String> contextMap) {}

  @Override
  public void pushByKey(String key, String value) {}

  @Override
  public String popByKey(String key) {
    return "";
  }

  @Override
  public Deque<String> getCopyOfDequeByKey(String key) {
    return null;
  }

  @Override
  public void clearDequeByKey(String key) {}
}
