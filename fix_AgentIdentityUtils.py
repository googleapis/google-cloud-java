import re
with open('/usr/local/google/home/mcastelaz/google-cloud-java/google-auth-library-java/oauth2_http/java/com/google/auth/oauth2/AgentIdentityUtils.java', 'r') as f:
    text = f.read()

# Fix Javadoc positions
text = text.replace(
    '    @SuppressWarnings("unchecked")\n    /**\n     * Extracts the certificate and private key paths from the JSON configuration file.',
    '    /**\n     * Extracts the certificate and private key paths from the JSON configuration file.\n     *\n     * @param certConfigPath the configuration file path intended to be parsed\n     * @return an object encapsulating resolved paths mapped from the definition\n     * @throws IOException if parsing JSON mapping encounters structural errors\n     */\n    @SuppressWarnings("unchecked")'
)

# Fix MissingJavadocMethod on setters
text = text.replace(
    '    public static void setEnvReader(EnvReader reader)',
    '    /**\n     * Sets the env reader for testing.\n     *\n     * @param reader the environment reader\n     */\n    @VisibleForTesting\n    public static void setEnvReader(final EnvReader reader)'
)
text = text.replace(
    '    static void setTimeService(TimeService service)',
    '    /**\n     * Sets the time service for testing.\n     *\n     * @param service the time service\n     */\n    @VisibleForTesting\n    static void setTimeService(final TimeService service)'
)
text = text.replace(
    '    static void resetTimeService()',
    '    /**\n     * Resets the time service.\n     */\n    @VisibleForTesting\n    static void resetTimeService()'
)
text = text.replace(
    '    static void setWellKnownDir(final String dir)',
    '    /**\n     * Sets the well known directory for testing.\n     *\n     * @param dir the directory path\n     */\n    @VisibleForTesting\n    static void setWellKnownDir(final String dir)'
)

# Add finals to parameters
text = text.replace('String getEnv(String name)', 'String getEnv(final String name)')
text = text.replace('resolveCertAndKeyPaths(String certConfigPath)', 'resolveCertAndKeyPaths(final String certConfigPath)')
text = text.replace('loadAndVerifyCredentials(String certPath, String keyPath)', 'loadAndVerifyCredentials(final String certPath, final String keyPath)')
text = text.replace('checkExistsOrAccessDenied(java.nio.file.Path path)', 'checkExistsOrAccessDenied(final java.nio.file.Path path)')
text = text.replace('getPathsFromConfigWithRetry(String certConfigPath)', 'getPathsFromConfigWithRetry(final String certConfigPath)')
text = text.replace('readCertificateChain(String certPath)', 'readCertificateChain(final String certPath)')
text = text.replace('verifyKeyPair(X509Certificate cert, PrivateKey privateKey)', 'verifyKeyPair(final X509Certificate cert, final PrivateKey privateKey)')
text = text.replace('readPrivateKey(String keyPath, String algorithm)', 'readPrivateKey(final String keyPath, final String algorithm)')
text = text.replace('shouldEnableMtls(boolean certsPresent, boolean configExists)', 'shouldEnableMtls(final boolean certsPresent, final boolean configExists)')
text = text.replace('extractPathsFromConfig(String certConfigPath)', 'extractPathsFromConfig(final String certConfigPath)')
text = text.replace('parseCertificateContent(String certContent)', 'parseCertificateContent(final String certContent)')
text = text.replace('shouldRequestBoundToken(X509Certificate cert)', 'shouldRequestBoundToken(final X509Certificate cert)')

with open('/usr/local/google/home/mcastelaz/google-cloud-java/google-auth-library-java/oauth2_http/java/com/google/auth/oauth2/AgentIdentityUtils.java', 'w') as f:
    f.write(text)
