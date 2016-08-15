/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import static com.google.cloud.RetryHelper.runWithRetries;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.services.translate.model.LanguagesResource;
import com.google.cloud.BaseService;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.translate.spi.TranslateRpc;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

final class TranslateImpl extends BaseService<TranslateOptions> implements Translate {

  private final TranslateRpc translateRpc;

  TranslateImpl(TranslateOptions options) {
    super(options);
    translateRpc = options.rpc();
  }

  @Override
  public List<Language> listSupportedLanguages(final LanguageListOption... options) {
    try {
      return Lists.transform(runWithRetries(new Callable<List<LanguagesResource>>() {
        @Override
        public List<LanguagesResource> call() {
          return translateRpc.listSupportedLanguages(optionMap(options));
        }
      }, options().retryParams(), EXCEPTION_HANDLER, options().clock()), Language.FROM_PB_FUNCTION);
    } catch (RetryHelperException e) {
      throw TranslateException.translateAndThrow(e);
    }
  }

  private Map<TranslateRpc.Option, ?> optionMap(Option... options) {
    Map<TranslateRpc.Option, Object> optionMap = Maps.newEnumMap(TranslateRpc.Option.class);
    for (Option option : options) {
      Object prev = optionMap.put(option.rpcOption(), option.value());
      checkArgument(prev == null, "Duplicate option %s", option);
    }
    return optionMap;
  }
}
