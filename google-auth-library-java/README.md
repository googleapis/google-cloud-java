# Google Auth Library

Open source authentication client library for Java.

[![stable](http://badges.github.io/stability-badges/dist/stable.svg)](http://github.com/badges/stability-badges)
[![Maven](https://img.shields.io/maven-central/v/com.google.auth/google-auth-library-credentials.svg)](https://img.shields.io/maven-central/v/com.google.auth/google-auth-library-credentials.svg)

## Documentation

See the [official guide](https://cloud.google.com/java/getting-started/getting-started-with-google-auth-library) for ways
to authenticate to Google Cloud and for more information about the Google Auth Library.

See the [API Documentation](https://cloud.google.com/java/docs/reference/google-auth-library/latest/overview.html) to see
the Javadocs for Google Auth Library.

## Certificate-bound tokens for agent identities

When your application runs with an agent identity (for example, a Cloud Run service or job deployed
with `--identity-type=agent-identity`), `ComputeEngineCredentials` requests **certificate-bound**
access tokens and ID tokens from the metadata server by default. A bound token is tied to the
workload's X.509 certificate, so a leaked token can't be used from anywhere else.

A bound token is only accepted when the request that carries it is sent over mutual TLS (mTLS)
with the same certificate. Google Cloud client libraries for Java that are built on GAX do this
automatically when a workload certificate is available. If you call Google APIs with your own HTTP
client, you must configure mTLS with the workload certificate yourself; otherwise the API rejects
the token with `401 UNAUTHENTICATED`.

The library requests a bound token only when all of the following are true:

* A workload certificate is found, either through the file named by the `GOOGLE_API_CERTIFICATE_CONFIG`
  environment variable or in the default location
  (`/var/run/secrets/workload-spiffe-credentials/`).
* The certificate's SPIFFE ID belongs to an agent identity trust domain.
* Token binding and mTLS haven't been turned off (see the next section).

In all other environments, `ComputeEngineCredentials` behaves as before and returns unbound tokens.

### Turning off token binding

We strongly discourage turning off token binding, because bound tokens protect your agent against
credential theft. If you need to (see [Known limitations](#known-limitations)), set the following
environment variable:

```sh
GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN=false
```

| Environment variable | Effect |
|---|---|
| `GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN` | Set to `false` to request unbound tokens. Takes precedence over the legacy variable. |
| `GOOGLE_API_PREVENT_AGENT_TOKEN_SHARING_FOR_GCP_SERVICES` | Legacy variable, also read by Google Auth Library for Python. Only used when `GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN` is unset or empty. Set to `false` to request unbound tokens. |
| `GOOGLE_API_USE_CLIENT_CERTIFICATE` | Setting this to `false` turns off mTLS entirely, which also turns off token binding. Prefer `GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN=false` if you only need unbound tokens. |

Values are case-insensitive and surrounding whitespace is ignored. Only `false` turns a feature
off; any other value leaves the default in place.

Environment variables apply to the whole process, so turning off token binding affects every
library in your application that uses Application Default Credentials, not only the one that needs
it. If you only need unbound ID tokens for some targets, use the per-target option described in
[Requesting unbound ID tokens for specific targets](#requesting-unbound-id-tokens-for-specific-targets)
instead.

### Requesting unbound ID tokens for specific targets

A bound ID token is only accepted by a target that authenticates the caller over mTLS with the
same certificate, such as a Cloud Run service called through its `*.mtls.run.app` URL. Targets
reached over standard HTTPS, such as a Cloud Run service's `*.run.app` URL or a custom domain,
reject bound ID tokens with `401 Unauthorized`. For those targets, pass
`IdTokenProvider.Option.BIND_ID_TOKEN_FALSE` to request an unbound ID token for that target only:

```java
GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
IdTokenCredentials idTokenCredentials =
    IdTokenCredentials.newBuilder()
        .setIdTokenProvider((IdTokenProvider) credentials)
        .setTargetAudience("https://my-service-12345.us-central1.run.app")
        .setOptions(Arrays.asList(IdTokenProvider.Option.BIND_ID_TOKEN_FALSE))
        .build();
```

Access tokens and ID tokens for other targets are still bound. Credential types that don't request
bound ID tokens ignore this option, so the same code also works outside agent identity
environments.

### Known limitations

* **Agent Development Kit (ADK) for Java** doesn't yet use mTLS when it calls Google APIs, such as
  Gemini on Vertex AI. With bound tokens (the default), those calls fail with
  `com.google.genai.errors.ClientException: 401 . Request had invalid authentication credentials`.
  Until ADK for Java supports mTLS, set `GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN=false` for agents
  that use ADK for Java. For details, see
  [Authenticate agents on Cloud Run](https://cloud.google.com/run/docs/ai/authenticate-agents).

## Versioning

This library follows [Semantic Versioning](http://semver.org/), but with some
additional qualifications:

1. Components marked with `@ObsoleteApi` are stable for usage in the current major version,
   but will be marked with `@Deprecated` in a future major version.
   **NOTE**: We reserve the right to mark anything as `@Deprecated` and introduce breaking
   changes in a minor version to fix any ***critical bugs and
   vulnerabilities***.

2. Components marked with `@InternalApi` are technically public, but are only
   public for technical reasons, because of the limitations of Java's access
   modifiers. For the purposes of semver, they should be considered private.

3. Components marked with `@InternalExtensionOnly` are stable for usage, but
   not for extension. Thus, methods will not be removed from interfaces marked
   with this annotation, but methods can be added, thus breaking any
   code implementing the interface. See the javadocs for more details on other
   consequences of this annotation.

4. Components marked with `@BetaApi` are considered to be "0.x" features inside
   a "1.x" library. This means they can change between minor and patch releases
   in incompatible ways. These features should not be used by any library "B"
   that itself has consumers, unless the components of library B that use
   `@BetaApi` features are also marked with `@BetaApi`. Features marked as
   `@BetaApi` are on a path to eventually become "1.x" features with the marker
   removed.

## Contributing

Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING](CONTRIBUTING.md) documentation for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in
this project you agree to abide by its terms. See [Code of Conduct](CODE_OF_CONDUCT.md) for more
information.

## Running the Tests

To run the tests you will need:

* Maven 3+

```bash
$ mvn test
```
   
## License

BSD 3-Clause - See [LICENSE](LICENSE) for more information.

[appengine-sdk-versions]: https://search.maven.org/search?q=g:com.google.appengine%20AND%20a:appengine-api-1.0-sdk&core=gav
[appengine-sdk-install]: https://github.com/googleapis/google-auth-library-java/blob/main/README.md#google-auth-library-appengine
[appengine-app-identity-service]: https://cloud.google.com/appengine/docs/java/javadoc/com/google/appengine/api/appidentity/AppIdentityService
[apiary-clients]: https://search.maven.org/search?q=g:com.google.apis
[http-credentials-adapter]: https://googleapis.dev/java/google-auth-library/latest/index.html?com/google/auth/http/HttpCredentialsAdapter.html
[http-request-initializer]: https://googleapis.dev/java/google-http-client/latest/index.html?com/google/api/client/http/HttpRequestInitializer.html
[token-verifier]: https://googleapis.dev/java/google-auth-library/latest/index.html?com/google/auth/oauth2/TokenVerifier.html
[token-verifier-builder]: https://googleapis.dev/java/google-auth-library/latest/index.html?com/google/auth/oauth2/TokenVerifier.Builder.html
[http-transport-factory]: https://googleapis.dev/java/google-auth-library/latest/index.html?com/google/auth/http/HttpTransportFactory.html
[google-credentials]: https://googleapis.dev/java/google-auth-library/latest/index.html?com/google/auth/oauth2/GoogleCredentials.html
