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

import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.cloud.AuthCredentials;
import com.google.cloud.HttpServiceOptions;
import com.google.cloud.translate.spi.DefaultTranslateRpc;
import com.google.cloud.translate.spi.TranslateRpc;
import com.google.cloud.translate.spi.TranslateRpcFactory;
import com.google.common.collect.ImmutableSet;

import java.util.Locale;
import java.util.Set;

public class TranslateOptions extends
    HttpServiceOptions<Translate, TranslateRpc, TranslateOptions> {

  private static final long serialVersionUID = 5997441123713672886L;
  private static final Set<String> SCOPES = ImmutableSet.of();

  private final String apiKey;
  private final String targetLanguage;

  public static class DefaultTranslateFactory implements TranslateFactory {

    private static final TranslateFactory INSTANCE = new DefaultTranslateFactory();

    @Override
    public Translate create(TranslateOptions options) {
      return null;
      //return new TranslateImpl(options);
    }
  }

  public static class DefaultTranslateRpcFactory implements TranslateRpcFactory {

    private static final TranslateRpcFactory INSTANCE = new DefaultTranslateRpcFactory();

    @Override
    public TranslateRpc create(TranslateOptions options) {
      return new DefaultTranslateRpc(options);
    }
  }

  public static class Builder extends
      HttpServiceOptions.Builder<Translate, TranslateRpc, TranslateOptions, Builder> {

    private final String apiKey;
    private String targetLanguage;

    private Builder(String apiKey) {
      this.apiKey = apiKey;
    }

    private Builder(TranslateOptions options) {
      super(options);
      this.apiKey = options.apiKey;
    }

    /**
     * Sets project id. Setting a project id has no impact on the {@link Translate} service.
     *
     * @return the builder
     */
    @Override
    public Builder projectId(String projectId) {
      super.projectId(projectId);
      return self();
    }

    /**
     * Sets the service authentication credentials. Setting credentials has no impact on the
     * {@link Translate} service.
     *
     * @return the builder
     */
    public Builder authCredentials(AuthCredentials authCredentials) {
      super.authCredentials(authCredentials);
      return self();
    }

    /**
     * Sets the code for the default target language. If not set, english ({@code en}) is used.
     *
     * @return the builder
     */
    public Builder targetLanguage(String targetLanguage) {
      this.targetLanguage = targetLanguage;
      return self();
    }

    @Override
    public TranslateOptions build() {
      return new TranslateOptions(this);
    }
  }

  private TranslateOptions(Builder builder) {
    super(TranslateFactory.class, TranslateRpcFactory.class, builder);
    this.apiKey = builder.apiKey;
    this.targetLanguage = firstNonNull(builder.targetLanguage, Locale.ENGLISH.getLanguage());
  }

  @Override
  protected TranslateFactory defaultServiceFactory() {
    return DefaultTranslateFactory.INSTANCE;
  }

  @Override
  protected TranslateRpcFactory defaultRpcFactory() {
    return DefaultTranslateRpcFactory.INSTANCE;
  }

  @Override
  protected boolean projectIdRequired() {
    return false;
  }

  @Override
  protected Set<String> scopes() {
    return SCOPES;
  }

  /**
   * Returns the API key, to be used used to send requests.
   */
  public String apiKey() {
    return apiKey;
  }

  /**
   * Returns the code for the default target language.
   */
  public String targetLanguage() {
    return targetLanguage;
  }

  /**
   * Returns a default {@code TranslateOptions} instance given an API key. For instructions on
   * how to get an API key see <a href="https://cloud.google.com/translate/v2/quickstart">Translate
   * quickstart</a>.
   */
  public static TranslateOptions defaultInstance(String apiKey) {
    return builder(apiKey).build();
  }

  @SuppressWarnings("unchecked")
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public int hashCode() {
    return baseHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof TranslateOptions && baseEquals((TranslateOptions) obj);
  }

  /**
   * Creates a builder for {@code TranslateOptions} objects given an api key. For instructions on
   * how to get an API key see <a href="https://cloud.google.com/translate/v2/quickstart">Translate
   * quickstart</a>.
   */
  public static Builder builder(String apiKey) {
    return new Builder(apiKey);
  }
}
