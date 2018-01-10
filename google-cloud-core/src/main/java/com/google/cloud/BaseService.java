/*
 * Copyright 2015 Google LLC
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

package com.google.cloud;

import com.google.api.core.InternalApi;
import com.google.cloud.ExceptionHandler.Interceptor;

/**
 * Base class for service objects.
 *
 * @param <OptionsT> the {@code ServiceOptions} subclass corresponding to the service
 */
public abstract class BaseService<OptionsT extends ServiceOptions<?, OptionsT>>
    implements Service<OptionsT> {

  public static final Interceptor EXCEPTION_HANDLER_INTERCEPTOR = new Interceptor() {

    private static final long serialVersionUID = -8429573486870467828L;

    @Override
    public RetryResult afterEval(Exception exception, RetryResult retryResult) {
      return Interceptor.RetryResult.CONTINUE_EVALUATION;
    }

    @Override
    public RetryResult beforeEval(Exception exception) {
      if (exception instanceof BaseServiceException) {
        boolean retriable = ((BaseServiceException) exception).isRetryable();
        return retriable ? Interceptor.RetryResult.RETRY : Interceptor.RetryResult.CONTINUE_EVALUATION;
      }
      return Interceptor.RetryResult.CONTINUE_EVALUATION;
    }
  };
  public static final ExceptionHandler EXCEPTION_HANDLER = ExceptionHandler.newBuilder()
      .abortOn(RuntimeException.class)
      .addInterceptors(EXCEPTION_HANDLER_INTERCEPTOR)
      .build();

  private final OptionsT options;

  @InternalApi("This class should only be extended within google-cloud-java")
  protected BaseService(OptionsT options) {
    this.options = options;
  }


  @Override
  public OptionsT getOptions() {
    return options;
  }
}
