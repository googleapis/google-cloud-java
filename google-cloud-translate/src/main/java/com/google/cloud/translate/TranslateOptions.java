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
import static com.google.common.base.Preconditions.checkArgument;

import com.google.cloud.HttpTransportOptions;
import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.spi.v2.HttpTranslateRpc;
import com.google.cloud.translate.spi.v2.TranslateRpc;
import com.google.cloud.translate.spi.TranslateRpcFactory;
import com.google.common.collect.ImmutableSet;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

public class TranslateOptions extends
    ServiceOptions<Translate, TranslateOptions> {

  private static final long serialVersionUID = -572597134540398216L;
  private static final String API_SHORT_NAME = "Translate";
  private static final String DEFAULT_HOST = "https://translation.googleapis.com";
  private static final String API_KEY_ENV_NAME = "GOOGLE_API_KEY";
  private static final Set<String> SCOPES =
      ImmutableSet.of("https://www.googleapis.com/auth/cloud-platform");

  private final String apiKey;
  private final String targetLanguage;

  public static class DefaultTranslateFactory implements TranslateFactory {

    private static final TranslateFactory INSTANCE = new DefaultTranslateFactory();

    @Override
    public Translate create(TranslateOptions options) {
      return new TranslateImpl(options);
    }
  }

  public static class DefaultTranslateRpcFactory implements TranslateRpcFactory {

    private static final TranslateRpcFactory INSTANCE = new DefaultTranslateRpcFactory();

    @Override
    public ServiceRpc create(TranslateOptions options) {
      return new HttpTranslateRpc(options);
    }
  }

  public static class Builder extends
      ServiceOptions.Builder<Translate, TranslateOptions, Builder> {

    private String apiKey;
    private String targetLanguage;

    private Builder() {}

    private Builder(TranslateOptions options) {
      super(options);
      this.apiKey = options.apiKey;
    }


    @Override
    public Builder setTransportOptions(TransportOptions transportOptions) {
      if (!(transportOptions instanceof HttpTransportOptions)) {
        throw new IllegalArgumentException(
            "Only http transport is allowed for " + API_SHORT_NAME + ".");
      }
      return super.setTransportOptions(transportOptions);
    }

    /**
     * Sets project id. Setting a project id has no impact on the {@link Translate} service.
     *
     * @return the builder
     */
    @Override
    public Builder setProjectId(String projectId) {
      super.setProjectId(projectId);
      return self();
    }


    /**
     * Sets the API key used to issue requets. If not set, the API key is looked for in the
     * {@code GOOGLE_API_KEY} environment variable. For instructions on how to get an API key see
     * <a href="https://cloud.google.com/translate/v2/quickstart">Translate quickstart</a>.
     */
    public Builder setApiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }


    /**
     * Sets the code for the default target language. If not set, english ({@code en}) is used.
     * {@link Translate#translate(List, TranslateOption...)} and
     * {@link Translate#translate(String, TranslateOption...)} calls will use this
     * value unless a {@link TranslateOption#targetLanguage(String)} option is explicitly
     * provided.
     *
     * @return the builder
     */
    public Builder setTargetLanguage(String targetLanguage) {
      this.targetLanguage = targetLanguage;
      return self();
    }

    @Override
    public TranslateOptions build() {
      return new TranslateOptions(this);
    }
  }

  private TranslateOptions(Builder builder) {
    super(TranslateFactory.class, TranslateRpcFactory.class, builder, new TranslateDefaults());
    this.apiKey = builder.apiKey != null ? builder.apiKey : getDefaultApiKey();
    this.targetLanguage = firstNonNull(builder.targetLanguage, Locale.ENGLISH.getLanguage());
  }

  private static class TranslateDefaults implements
      ServiceDefaults<Translate, TranslateOptions> {

    @Override
    public TranslateFactory getDefaultServiceFactory() {
      return DefaultTranslateFactory.INSTANCE;
    }

    @Override
    public TranslateRpcFactory getDefaultRpcFactory() {
      return DefaultTranslateRpcFactory.INSTANCE;
    }

    @Override
    public TransportOptions getDefaultTransportOptions() {
      return getDefaultHttpTransportOptions();
    }
  }

  public static HttpTransportOptions getDefaultHttpTransportOptions() {
    return HttpTransportOptions.newBuilder().build();
  }

  @Override
  protected boolean projectIdRequired() {
    return false;
  }

  @Override
  protected Set<String> getScopes() {
    return SCOPES;
  }

  protected TranslateRpc getTranslateRpcV2() {
    return (TranslateRpc) getRpc();
  }

  @Override
  protected String getDefaultHost() {
    return DEFAULT_HOST;
  }


  protected String getDefaultApiKey() {
    return System.getProperty(API_KEY_ENV_NAME, System.getenv(API_KEY_ENV_NAME));
  }


  /**
   * Returns the API key, to be used used to send requests.
   */
  public String getApiKey() {
    return apiKey;
  }


  /**
   * Returns the code for the default target language.
   */
  public String getTargetLanguage() {
    return targetLanguage;
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
    if (!(obj instanceof TranslateOptions)) {
      return false;
    }
    TranslateOptions options = (TranslateOptions) obj;
    return baseEquals(options)
        && Objects.equals(apiKey, options.apiKey)
        && Objects.equals(targetLanguage, options.targetLanguage);
  }


  /**
   * Returns a default {@code TranslateOptions} instance.
   */
  public static TranslateOptions getDefaultInstance() {
    return newBuilder().build();
  }


  /**
   * Returns a builder for {@code TranslateOptions} objects.
   */
  public static Builder newBuilder() {
    return new Builder();
  }
}
