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

package com.google.cloud.translate;

import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.http.BaseHttpServiceException;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.Set;

/** Google Translation service exception. */
public class TranslateException extends BaseHttpServiceException {

  private static final Set<Error> RETRYABLE_ERRORS = ImmutableSet.of(new Error(500, null));
  private static final long serialVersionUID = 6811792902595193267L;

  TranslateException(int code, String message) {
    super(code, message, null, true, RETRYABLE_ERRORS, null);
  }

  TranslateException(int code, String message, Throwable cause) {
    super(code, message, null, true, RETRYABLE_ERRORS, cause);
  }

  public TranslateException(IOException exception) {
    super(exception, true, RETRYABLE_ERRORS);
  }

  /**
   * Translate RetryHelperException to the TranslateException that caused the error. This method
   * will always throw an exception.
   *
   * @throws TranslateException when {@code ex} was caused by a {@code TranslateException}
   */
  static BaseServiceException translateAndThrow(RetryHelperException ex) {
    BaseServiceException.translate(ex);
    throw new TranslateException(UNKNOWN_CODE, ex.getMessage(), ex.getCause());
  }
}
