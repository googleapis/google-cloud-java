/*
 * Copyright 2015, Google Inc. All rights reserved.
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

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Preconditions;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/** Handles an interactive 3-Legged-OAuth2 (3LO) user consent authorization. */
public class UserAuthorizer {

  /**
   * Represents the client authentication types as specified in RFC 7591.
   *
   * <p>For more details, see <a href="https://tools.ietf.org/html/rfc7591">RFC 7591</a>.
   */
  public enum ClientAuthenticationType {
    CLIENT_SECRET_POST,
    CLIENT_SECRET_BASIC,
    NONE
  }

  static final URI DEFAULT_CALLBACK_URI = URI.create("/oauth2callback");

  private final String TOKEN_STORE_ERROR = "Error parsing stored token data.";
  private final String FETCH_TOKEN_ERROR = "Error reading result of Token API:";

  private final ClientId clientId;
  private final Collection<String> scopes;
  private final TokenStore tokenStore;
  private final URI callbackUri;

  private final HttpTransportFactory transportFactory;
  private final URI tokenServerUri;
  private final URI userAuthUri;
  private final PKCEProvider pkce;
  private final ClientAuthenticationType clientAuthenticationType;

  /** Internal constructor. See {@link Builder}. */
  private UserAuthorizer(Builder builder) {
    this.clientId = Preconditions.checkNotNull(builder.clientId);
    this.scopes = ImmutableList.copyOf(Preconditions.checkNotNull(builder.scopes));
    this.callbackUri = (builder.callbackUri == null) ? DEFAULT_CALLBACK_URI : builder.callbackUri;
    this.transportFactory =
        (builder.transportFactory == null)
            ? OAuth2Utils.HTTP_TRANSPORT_FACTORY
            : builder.transportFactory;
    this.tokenServerUri =
        (builder.tokenServerUri == null) ? OAuth2Utils.TOKEN_SERVER_URI : builder.tokenServerUri;
    this.userAuthUri =
        (builder.userAuthUri == null) ? OAuth2Utils.USER_AUTH_URI : builder.userAuthUri;
    this.tokenStore = (builder.tokenStore == null) ? new MemoryTokensStorage() : builder.tokenStore;
    this.pkce = builder.pkce;
    this.clientAuthenticationType =
        (builder.clientAuthenticationType == null)
            ? ClientAuthenticationType.CLIENT_SECRET_POST
            : builder.clientAuthenticationType;
  }

  /**
   * Returns the Client ID user to identify the OAuth2 consent prompt.
   *
   * @return The Client ID.
   */
  public ClientId getClientId() {
    return clientId;
  }

  /**
   * Returns the scopes defining the user consent.
   *
   * @return The collection of scopes defining the user consent.
   */
  public Collection<String> getScopes() {
    return scopes;
  }

  /**
   * Returns the URI for implementation of the OAuth2 web callback.
   *
   * @return The URI for the OAuth2 web callback.
   */
  public URI getCallbackUri() {
    return callbackUri;
  }

  /**
   * Returns the URI for implementation of the OAuth2 web callback, optionally relative to the
   * specified URI.
   *
   * <p>The callback URI is often relative to enable an application to be tested from more than one
   * place so this can be used to resolve it relative to another URI.
   *
   * @param baseUri The URI to resolve the callback URI relative to.
   * @return The resolved URI.
   */
  public URI getCallbackUri(URI baseUri) {
    if (callbackUri.isAbsolute()) {
      return callbackUri;
    }
    if (baseUri == null || !baseUri.isAbsolute()) {
      throw new IllegalStateException(
          "If the callback URI is relative, the baseUri passed must" + " be an absolute URI");
    }
    return baseUri.resolve(callbackUri);
  }

  /**
   * Returns the implementation of a component for long term storage of tokens.
   *
   * @return The token storage implementation for long term storage of tokens.
   */
  public TokenStore getTokenStore() {
    return tokenStore;
  }

  /**
   * Returns the client authentication type as defined in RFC 7591.
   *
   * @return The {@link ClientAuthenticationType}
   */
  public ClientAuthenticationType getClientAuthenticationType() {
    return clientAuthenticationType;
  }

  /**
   * Return a URL that performs the authorization consent prompt web UI.
   *
   * @param userId Application's identifier for the end user.
   * @param state State that is passed on to the OAuth2 callback URI after the consent.
   * @param baseUri The URI to resolve the OAuth2 callback URI relative to.
   * @return The URL that can be navigated or redirected to.
   */
  public URL getAuthorizationUrl(String userId, String state, URI baseUri) {
    return this.getAuthorizationUrl(userId, state, baseUri, null);
  }

  /**
   * Return a URL that performs the authorization consent prompt web UI.
   *
   * @param userId Application's identifier for the end user.
   * @param state State that is passed on to the OAuth2 callback URI after the consent.
   * @param baseUri The URI to resolve the OAuth2 callback URI relative to.
   * @param additionalParameters Additional query parameters to be added to the authorization URL.
   * @return The URL that can be navigated or redirected to.
   */
  public URL getAuthorizationUrl(
      String userId, String state, URI baseUri, Map<String, String> additionalParameters) {
    URI resolvedCallbackUri = getCallbackUri(baseUri);
    String scopesString = Joiner.on(' ').join(scopes);

    GenericUrl url = new GenericUrl(userAuthUri);
    url.put("response_type", "code");
    url.put("client_id", clientId.getClientId());
    url.put("redirect_uri", resolvedCallbackUri);
    url.put("scope", scopesString);
    if (state != null) {
      url.put("state", state);
    }
    url.put("access_type", "offline");
    url.put("prompt", "consent");
    if (userId != null) {
      url.put("login_hint", userId);
    }
    url.put("include_granted_scopes", true);

    if (additionalParameters != null) {
      for (Map.Entry<String, String> entry : additionalParameters.entrySet()) {
        url.put(entry.getKey(), entry.getValue());
      }
    }

    if (pkce != null) {
      url.put("code_challenge", pkce.getCodeChallenge());
      url.put("code_challenge_method", pkce.getCodeChallengeMethod());
    }
    return url.toURL();
  }

  /**
   * Attempts to retrieve credentials for the approved end user consent.
   *
   * @param userId Application's identifier for the end user.
   * @return The loaded credentials or null if there are no valid approved credentials.
   * @throws IOException If there is error retrieving or loading the credentials.
   */
  public UserCredentials getCredentials(String userId) throws IOException {
    Preconditions.checkNotNull(userId);
    if (tokenStore == null) {
      throw new IllegalStateException("Method cannot be called if token store is not specified.");
    }
    String tokenData = tokenStore.load(userId);
    if (tokenData == null) {
      return null;
    }
    GenericJson tokenJson = OAuth2Utils.parseJson(tokenData);
    String accessTokenValue =
        OAuth2Utils.validateString(tokenJson, "access_token", TOKEN_STORE_ERROR);
    Long expirationMillis =
        OAuth2Utils.validateLong(tokenJson, "expiration_time_millis", TOKEN_STORE_ERROR);
    Date expirationTime = new Date(expirationMillis);
    List<String> scopes =
        OAuth2Utils.validateOptionalListString(
            tokenJson, OAuth2Utils.TOKEN_RESPONSE_SCOPE, FETCH_TOKEN_ERROR);
    AccessToken accessToken =
        AccessToken.newBuilder()
            .setExpirationTime(expirationTime)
            .setTokenValue(accessTokenValue)
            .setScopes(scopes)
            .build();
    String refreshToken =
        OAuth2Utils.validateOptionalString(tokenJson, "refresh_token", TOKEN_STORE_ERROR);
    UserCredentials credentials =
        UserCredentials.newBuilder()
            .setClientId(clientId.getClientId())
            .setClientSecret(clientId.getClientSecret())
            .setRefreshToken(refreshToken)
            .setAccessToken(accessToken)
            .setHttpTransportFactory(transportFactory)
            .setTokenServerUri(tokenServerUri)
            .build();
    monitorCredentials(userId, credentials);
    return credentials;
  }

  /**
   * Returns a UserCredentials instance by exchanging an OAuth2 authorization code for tokens.
   *
   * @param code Code returned from OAuth2 consent prompt.
   * @param baseUri The URI to resolve the OAuth2 callback URI relative to.
   * @return the UserCredentials instance created from the authorization code.
   * @throws IOException An error from the server API call to get the tokens.
   */
  public UserCredentials getCredentialsFromCode(String code, URI baseUri) throws IOException {
    return getCredentialsFromCode(code, baseUri, null);
  }

  /**
   * Returns a UserCredentials instance by exchanging an OAuth2 authorization code for tokens.
   *
   * @param code Code returned from OAuth2 consent prompt.
   * @param baseUri The URI to resolve the OAuth2 callback URI relative to.
   * @param additionalParameters Additional parameters to be added to the post body of token
   *     endpoint request.
   * @return the UserCredentials instance created from the authorization code.
   * @throws IOException An error from the server API call to get the tokens.
   */
  public UserCredentials getCredentialsFromCode(
      String code, URI baseUri, Map<String, String> additionalParameters) throws IOException {
    TokenResponseWithConfig tokenResponseWithConfig =
        getCredentialsFromCodeInternal(code, baseUri, additionalParameters);
    return UserCredentials.newBuilder()
        .setClientId(tokenResponseWithConfig.getClientId())
        .setClientSecret(tokenResponseWithConfig.getClientSecret())
        .setAccessToken(tokenResponseWithConfig.getAccessToken())
        .setRefreshToken(tokenResponseWithConfig.getRefreshToken())
        .setHttpTransportFactory(tokenResponseWithConfig.getHttpTransportFactory())
        .setTokenServerUri(tokenResponseWithConfig.getTokenServerUri())
        .build();
  }

  /**
   * Handles OAuth2 authorization code exchange and returns a {@link TokenResponseWithConfig} object
   * containing the tokens and configuration details.
   *
   * @param code The authorization code received from the OAuth2 authorization server.
   * @param callbackUri The URI to which the authorization server redirected the user after granting
   *     authorization.
   * @param additionalParameters Additional parameters to include in the token exchange request.
   * @return A {@link TokenResponseWithConfig} object containing the access token, refresh token (if
   *     granted), and configuration details used in the OAuth flow.
   * @throws IOException If an error occurs during the token exchange process.
   */
  public TokenResponseWithConfig getTokenResponseFromAuthCodeExchange(
      String code, URI callbackUri, Map<String, String> additionalParameters) throws IOException {
    return getCredentialsFromCodeInternal(code, callbackUri, additionalParameters);
  }

  /**
   * Exchanges an authorization code for tokens and stores them.
   *
   * @param userId Application's identifier for the end user.
   * @param code Code returned from OAuth2 consent prompt.
   * @param baseUri The URI to resolve the OAuth2 callback URI relative to.
   * @return UserCredentials instance created from the authorization code.
   * @throws IOException An error from the server API call to get the tokens or store the tokens.
   */
  public UserCredentials getAndStoreCredentialsFromCode(String userId, String code, URI baseUri)
      throws IOException {
    Preconditions.checkNotNull(userId);
    Preconditions.checkNotNull(code);
    UserCredentials credentials = getCredentialsFromCode(code, baseUri);
    storeCredentials(userId, credentials);
    monitorCredentials(userId, credentials);
    return credentials;
  }

  /**
   * Revokes the authorization for tokens stored for the user.
   *
   * @param userId Application's identifier for the end user.
   * @throws IOException An error calling the revoke API or deleting the state.
   */
  public void revokeAuthorization(String userId) throws IOException {
    Preconditions.checkNotNull(userId);
    if (tokenStore == null) {
      throw new IllegalStateException("Method cannot be called if token store is not specified.");
    }
    String tokenData = tokenStore.load(userId);
    if (tokenData == null) {
      return;
    }
    IOException deleteTokenException = null;
    try {
      // Delete the stored version first. If token reversion fails it is less harmful to have an
      // non revoked token to hold on to a potentially revoked token.
      tokenStore.delete(userId);
    } catch (IOException e) {
      deleteTokenException = e;
    }

    GenericJson tokenJson = OAuth2Utils.parseJson(tokenData);
    String accessTokenValue =
        OAuth2Utils.validateOptionalString(tokenJson, "access_token", TOKEN_STORE_ERROR);
    String refreshToken =
        OAuth2Utils.validateOptionalString(tokenJson, "refresh_token", TOKEN_STORE_ERROR);
    // If both tokens are present, either can be used
    String revokeToken = (refreshToken != null) ? refreshToken : accessTokenValue;

    GenericUrl revokeUrl = new GenericUrl(OAuth2Utils.TOKEN_REVOKE_URI);
    GenericData genericData = new GenericData();
    genericData.put("token", revokeToken);
    UrlEncodedContent content = new UrlEncodedContent(genericData);

    HttpRequestFactory requestFactory = transportFactory.create().createRequestFactory();
    HttpRequest tokenRequest = requestFactory.buildPostRequest(revokeUrl, content);
    tokenRequest.execute();

    if (deleteTokenException != null) {
      throw deleteTokenException;
    }
  }

  /**
   * Puts the end user credentials in long term storage.
   *
   * @param userId Application's identifier for the end user.
   * @param credentials UserCredentials instance for the authorized consent.
   * @throws IOException An error storing the credentials.
   */
  public void storeCredentials(String userId, UserCredentials credentials) throws IOException {
    if (tokenStore == null) {
      throw new IllegalStateException("Cannot store tokens if tokenStore is not specified.");
    }
    AccessToken accessToken = credentials.getAccessToken();
    String acessTokenValue = null;
    Date expiresBy = null;
    List<String> grantedScopes = new ArrayList<>();

    if (accessToken != null) {
      acessTokenValue = accessToken.getTokenValue();
      expiresBy = accessToken.getExpirationTime();
      grantedScopes = accessToken.getScopes();
    }
    String refreshToken = credentials.getRefreshToken();
    GenericJson tokenStateJson = new GenericJson();
    tokenStateJson.setFactory(OAuth2Utils.JSON_FACTORY);
    tokenStateJson.put("access_token", acessTokenValue);
    tokenStateJson.put(OAuth2Utils.TOKEN_RESPONSE_SCOPE, grantedScopes);
    tokenStateJson.put("expiration_time_millis", expiresBy.getTime());
    if (refreshToken != null) {
      tokenStateJson.put("refresh_token", refreshToken);
    }
    String tokenState = tokenStateJson.toString();
    tokenStore.store(userId, tokenState);
  }

  /**
   * Adds a listen to rewrite the credentials when the tokens are refreshed.
   *
   * @param userId Application's identifier for the end user.
   * @param credentials UserCredentials instance to listen to.
   */
  protected void monitorCredentials(String userId, UserCredentials credentials) {
    credentials.addChangeListener(new UserCredentialsListener(userId));
  }

  private TokenResponseWithConfig getCredentialsFromCodeInternal(
      String code, URI baseUri, Map<String, String> additionalParameters) throws IOException {
    Preconditions.checkNotNull(code);
    URI resolvedCallbackUri = getCallbackUri(baseUri);

    GenericData tokenData = new GenericData();
    tokenData.put("code", code);
    tokenData.put("client_id", clientId.getClientId());
    tokenData.put("redirect_uri", resolvedCallbackUri);
    tokenData.put("grant_type", "authorization_code");

    if (additionalParameters != null) {
      for (Map.Entry<String, String> entry : additionalParameters.entrySet()) {
        tokenData.put(entry.getKey(), entry.getValue());
      }
    }

    if (pkce != null) {
      tokenData.put("code_verifier", pkce.getCodeVerifier());
    }

    if (this.clientAuthenticationType == ClientAuthenticationType.CLIENT_SECRET_POST) {
      tokenData.put("client_secret", clientId.getClientSecret());
    }

    HttpRequestFactory requestFactory = transportFactory.create().createRequestFactory();
    UrlEncodedContent tokenContent = new UrlEncodedContent(tokenData);
    HttpRequest tokenRequest =
        requestFactory.buildPostRequest(new GenericUrl(tokenServerUri), tokenContent);
    tokenRequest.setParser(new JsonObjectParser(OAuth2Utils.JSON_FACTORY));

    if (this.clientAuthenticationType == ClientAuthenticationType.CLIENT_SECRET_BASIC) {
      tokenRequest
          .getHeaders()
          .setAuthorization(
              OAuth2Utils.generateBasicAuthHeader(
                  clientId.getClientId(), clientId.getClientSecret()));
    }

    HttpResponse tokenResponse = tokenRequest.execute();

    GenericJson parsedTokens = tokenResponse.parseAs(GenericJson.class);
    String accessTokenValue =
        OAuth2Utils.validateString(parsedTokens, "access_token", FETCH_TOKEN_ERROR);
    int expiresInSecs = OAuth2Utils.validateInt32(parsedTokens, "expires_in", FETCH_TOKEN_ERROR);
    Date expirationTime = new Date(new Date().getTime() + expiresInSecs * 1000);
    String scopes =
        OAuth2Utils.validateOptionalString(
            parsedTokens, OAuth2Utils.TOKEN_RESPONSE_SCOPE, FETCH_TOKEN_ERROR);
    AccessToken accessToken =
        AccessToken.newBuilder()
            .setExpirationTime(expirationTime)
            .setTokenValue(accessTokenValue)
            .setScopes(scopes)
            .build();
    String refreshToken =
        OAuth2Utils.validateOptionalString(parsedTokens, "refresh_token", FETCH_TOKEN_ERROR);

    return TokenResponseWithConfig.newBuilder()
        .setClientId(clientId.getClientId())
        .setClientSecret(clientId.getClientSecret())
        .setAccessToken(accessToken)
        .setRefreshToken(refreshToken)
        .setHttpTransportFactory(transportFactory)
        .setTokenServerUri(tokenServerUri)
        .build();
  }

  /**
   * Implementation of listener used by monitorCredentials to rewrite the credentials when the
   * tokens are refreshed.
   */
  private class UserCredentialsListener implements OAuth2Credentials.CredentialsChangedListener {
    private final String userId;

    /** Construct new listener. */
    public UserCredentialsListener(String userId) {
      this.userId = userId;
    }

    /** Handle change event by rewriting to token store. */
    @Override
    public void onChanged(OAuth2Credentials credentials) throws IOException {
      UserCredentials userCredentials = (UserCredentials) credentials;
      storeCredentials(userId, userCredentials);
    }
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static class Builder {

    private ClientId clientId;
    private TokenStore tokenStore;
    private URI callbackUri;
    private URI tokenServerUri;
    private URI userAuthUri;
    private Collection<String> scopes;
    private HttpTransportFactory transportFactory;
    private PKCEProvider pkce;
    private ClientAuthenticationType clientAuthenticationType;

    protected Builder() {}

    protected Builder(UserAuthorizer authorizer) {
      this.clientId = authorizer.clientId;
      this.scopes = authorizer.scopes;
      this.transportFactory = authorizer.transportFactory;
      this.tokenServerUri = authorizer.tokenServerUri;
      this.tokenStore = authorizer.tokenStore;
      this.callbackUri = authorizer.callbackUri;
      this.userAuthUri = authorizer.userAuthUri;
      this.pkce = new DefaultPKCEProvider();
      this.clientAuthenticationType = authorizer.clientAuthenticationType;
    }

    /**
     * Sets the OAuth 2.0 client ID.
     *
     * @param clientId the client ID
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setClientId(ClientId clientId) {
      this.clientId = clientId;
      return this;
    }

    /**
     * Sets the {@link TokenStore} to use for long term token storage.
     *
     * @param tokenStore the token store
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setTokenStore(TokenStore tokenStore) {
      this.tokenStore = tokenStore;
      return this;
    }

    /**
     * Sets the OAuth 2.0 scopes to request.
     *
     * @param scopes the scopes to request
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setScopes(Collection<String> scopes) {
      this.scopes = scopes;
      return this;
    }

    /**
     * Sets the token exchange endpoint.
     *
     * @param tokenServerUri the token exchange endpoint to use
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setTokenServerUri(URI tokenServerUri) {
      this.tokenServerUri = tokenServerUri;
      return this;
    }

    /**
     * Sets the redirect URI registered with your OAuth provider. This is where the user's browser
     * will be redirected after granting or denying authorization.
     *
     * @param callbackUri the redirect URI
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setCallbackUri(URI callbackUri) {
      this.callbackUri = callbackUri;
      return this;
    }

    /**
     * Sets the authorization URI where the user is directed to log in and grant authorization.
     *
     * @param userAuthUri the authorization URI
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setUserAuthUri(URI userAuthUri) {
      this.userAuthUri = userAuthUri;
      return this;
    }

    /**
     * Sets the HTTP transport factory.
     *
     * @param transportFactory the {@code HttpTransportFactory} to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setHttpTransportFactory(HttpTransportFactory transportFactory) {
      this.transportFactory = transportFactory;
      return this;
    }

    /**
     * Sets the optional {@link PKCEProvider} to enable Proof Key for Code Exchange to be used. This
     * enhances security by using a code challenge and verifier to prevent authorization code
     * interception attacks.
     *
     * @param pkce the {@code PKCEProvider} to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setPKCEProvider(PKCEProvider pkce) {
      if (pkce != null) {
        if (pkce.getCodeChallenge() == null
            || pkce.getCodeVerifier() == null
            || pkce.getCodeChallengeMethod() == null) {

          throw new IllegalArgumentException(
              "PKCE provider contained null implementations. PKCE object must implement all PKCEProvider methods.");
        }
      }
      this.pkce = pkce;
      return this;
    }

    /**
     * Sets the optional {@link ClientAuthenticationType}, one of the client authentication methods
     * defined in RFC 7591. This specifies how your application authenticates itself to the
     * authorization server.
     *
     * @param clientAuthentication the {@code ClientAuthenticationType} to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setClientAuthenticationType(ClientAuthenticationType clientAuthentication) {
      this.clientAuthenticationType = clientAuthentication;
      return this;
    }

    public ClientId getClientId() {
      return clientId;
    }

    public TokenStore getTokenStore() {
      return tokenStore;
    }

    public Collection<String> getScopes() {
      return scopes;
    }

    public URI getTokenServerUri() {
      return tokenServerUri;
    }

    public URI getCallbackUri() {
      return callbackUri;
    }

    public URI getUserAuthUri() {
      return userAuthUri;
    }

    public HttpTransportFactory getHttpTransportFactory() {
      return transportFactory;
    }

    public PKCEProvider getPKCEProvider() {
      return pkce;
    }

    public ClientAuthenticationType getClientAuthenticationType() {
      return clientAuthenticationType;
    }

    public UserAuthorizer build() {
      return new UserAuthorizer(this);
    }
  }

  /**
   * Represents the response from an OAuth token exchange, including configuration details used to
   * initiate the flow.
   *
   * <p>This response can be used to initialize the following credentials types:
   *
   * <pre>{@code
   * // UserCredentials when Google is the identity provider:
   * UserCredentials userCredentials = UserCredentials.newBuilder()
   *     .setHttpTransportFactory(tokenResponseWithConfig.getHttpTransportFactory())
   *     .setClientId(tokenResponseWithConfig.getClientId())
   *     .setClientSecret(tokenResponseWithConfig.getClientSecret())
   *     .setAccessToken(tokenResponseWithConfig.getAccessToken())
   *     .setRefreshToken(tokenResponseWithConfig.getRefreshToken())
   *     .setTokenServerUri(tokenResponseWithConfig.getTokenServerUri())
   *     .build();
   *
   * // ExternalAccountAuthorizedUserCredentials when using Workforce Identity Federation:
   * ExternalAccountAuthorizedUserCredentials externalAccountAuthorizedUserCredentials =
   *     ExternalAccountAuthorizedUserCredentials.newBuilder()
   *         .setHttpTransportFactory(tokenResponseWithConfig.getHttpTransportFactory())
   *         .setClientId(tokenResponseWithConfig.getClientId())
   *         .setClientSecret(tokenResponseWithConfig.getClientSecret())
   *         .setAccessToken(tokenResponseWithConfig.getAccessToken())
   *         .setRefreshToken(tokenResponseWithConfig.getRefreshToken())
   *         .setTokenUrl(tokenResponseWithConfig.getTokenServerUri().toURL().toString())
   *         .build();
   * }</pre>
   */
  public static class TokenResponseWithConfig {

    private final String clientId;
    private final String clientSecret;
    private final String refreshToken;
    private final AccessToken accessToken;
    private URI tokenServerUri;
    private final HttpTransportFactory httpTransportFactory;

    private TokenResponseWithConfig(Builder builder) {
      this.clientId = builder.clientId;
      this.clientSecret = builder.clientSecret;
      this.accessToken = builder.accessToken;
      this.httpTransportFactory = builder.httpTransportFactory;
      this.tokenServerUri = builder.tokenServerUri;
      this.refreshToken = builder.refreshToken;
    }

    /**
     * Returns the OAuth 2.0 client ID used.
     *
     * @return The client ID.
     */
    public String getClientId() {
      return clientId;
    }

    /**
     * Returns the OAuth 2.0 client secret used.
     *
     * @return The client secret.
     */
    public String getClientSecret() {
      return clientSecret;
    }

    /**
     * Returns the access token obtained from the token exchange.
     *
     * @return The access token.
     */
    public AccessToken getAccessToken() {
      return accessToken;
    }

    /**
     * Returns the HTTP transport factory used.
     *
     * @return The HTTP transport factory.
     */
    public HttpTransportFactory getHttpTransportFactory() {
      return httpTransportFactory;
    }

    /**
     * Returns the URI of the token server used.
     *
     * @return The token server URI.
     */
    public URI getTokenServerUri() {
      return tokenServerUri;
    }

    /**
     * Returns the refresh token obtained from the token exchange, if available.
     *
     * @return The refresh token, or null if not granted.
     */
    @Nullable
    public String getRefreshToken() {
      return refreshToken;
    }

    static Builder newBuilder() {
      return new Builder();
    }

    static class Builder {
      private String clientId;
      private String clientSecret;
      private String refreshToken;
      private AccessToken accessToken;
      private URI tokenServerUri;
      private HttpTransportFactory httpTransportFactory;

      @CanIgnoreReturnValue
      Builder setClientId(String clientId) {
        this.clientId = clientId;
        return this;
      }

      @CanIgnoreReturnValue
      Builder setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
      }

      @CanIgnoreReturnValue
      Builder setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
      }

      @CanIgnoreReturnValue
      Builder setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
      }

      @CanIgnoreReturnValue
      Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
        this.httpTransportFactory = httpTransportFactory;
        return this;
      }

      @CanIgnoreReturnValue
      Builder setTokenServerUri(URI tokenServerUri) {
        this.tokenServerUri = tokenServerUri;
        return this;
      }

      TokenResponseWithConfig build() {
        return new TokenResponseWithConfig(this);
      }
    }
  }
}
