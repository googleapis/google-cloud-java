import os
import re

file_path = "/usr/local/google/home/mcastelaz/google-cloud-java/google-auth-library-java/oauth2_http/java/com/google/auth/oauth2/AgentIdentityUtils.java"
with open(file_path, 'r') as f:
    content = f.read()

replacements = [
    ("    /** Javadoc. */\n    private static final Logger LOGGER", "    /** Logger for this utility class. */\n    private static final Logger LOGGER"),
    ("    /** Javadoc. */\n    static final String GOOGLE_API_CERTIFICATE_CONFIG", "    /** Environment variable for overriding the certificate configuration path. */\n    static final String GOOGLE_API_CERTIFICATE_CONFIG"),
    ("    /** Javadoc. */\n    static final String GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES", "    /** Environment variable for disabling token binding. */\n    static final String GOOGLE_API_PREVENT_TOKEN_SHARING_FOR_GCP_SERVICES"),
    ("    /** Javadoc. */\n    private static final List<Pattern> AGENT_IDENTITY_SPIFFE_PATTERNS", "    /** Allowed SPIFFE trust domain patterns for agent identity. */\n    private static final List<Pattern> AGENT_IDENTITY_SPIFFE_PATTERNS"),
    ("    /** Javadoc. */\n    private static final int SAN_URI_TYPE", "    /** Subject Alternative Name (SAN) type for URIs. */\n    private static final int SAN_URI_TYPE"),
    ("    /** Javadoc. */\n    private static final String SPIFFE_SCHEME_PREFIX", "    /** Prefix for SPIFFE URIs. */\n    private static final String SPIFFE_SCHEME_PREFIX"),
    ("    /** Javadoc. */\n    private static String wellKnownDir", "    /** Default well-known directory for spiffe credentials. */\n    private static String wellKnownDir"),
    ("    /** Javadoc. */\n    private static final int CERT_KEY_MATCH_RETRIES", "    /** Number of retries when checking for matching certificate and key. */\n    private static final int CERT_KEY_MATCH_RETRIES"),
    ("    /** Javadoc. */\n    private static final long CERT_KEY_MATCH_RETRY_INTERVAL_MS", "    /** Backoff interval for certificate matching retries. */\n    private static final long CERT_KEY_MATCH_RETRY_INTERVAL_MS"),
    ("    /** Javadoc. */\n    private static final int FAST_POLL_CYCLES", "    /** Number of fast polling cycles to use when fetching certs. */\n    private static final int FAST_POLL_CYCLES"),
    ("    /** Javadoc. */\n    private static final long FAST_POLL_INTERVAL_MS", "    /** Interval for fast polling cycles. */\n    private static final long FAST_POLL_INTERVAL_MS"),
    ("    /** Javadoc. */\n    private static final long SLOW_POLL_INTERVAL_MS", "    /** Interval for slow polling cycles. */\n    private static final long SLOW_POLL_INTERVAL_MS"),
    ("    /** Javadoc. */\n    private static final long TOTAL_TIMEOUT_MS", "    /** Total timeout across polling routines. */\n    private static final long TOTAL_TIMEOUT_MS"),
    ("        /** Javadoc. */\n        String getEnv(String name);", "        /**\n         * Gets an environment variable by name.\n         *\n         * @param name the environment variable name\n         * @return the value of the environment variable\n         */\n        String getEnv(String name);"),
    ("    /** Javadoc. */\n    private static EnvReader envReader", "    /** Reader for environment variables. */\n    private static EnvReader envReader"),
    ("        /** Javadoc. */\n        void sleep(final long millis)", "        /**\n         * Suspends execution for the specified duration.\n         *\n         * @param millis the duration in milliseconds\n         * @throws InterruptedException if any thread has interrupted the current thread\n         */\n        void sleep(final long millis)"),
    ("    /** Javadoc. */\n    private static TimeService timeService", "    /** Service providing standard time and sleep operations. */\n    private static TimeService timeService"),
    ("        /** Javadoc. */\n        private final X509Certificate certificate;", "        /** The parsed X.509 certificate. */\n        private final X509Certificate certificate;"),
    ("        /** Javadoc. */\n        private final String certContent;", "        /** The raw content of the certificate. */\n        private final String certContent;"),
    ("        /** Javadoc. */\n        public X509Certificate getCertificate()", "        /**\n         * Returns the certificate.\n         *\n         * @return the parsed X.509 certificate\n         */\n        public X509Certificate getCertificate()"),
    ("        /** Javadoc. */\n        public String getCertContent()", "        /**\n         * Returns the internal certificate content string.\n         *\n         * @return the raw content of the certificate\n         */\n        public String getCertContent()"),
    ("        /** Javadoc. */\n        private final String certPath;", "        /** The resolved path to the certificate. */\n        private final String certPath;"),
    ("        /** Javadoc. */\n        private final String keyPath;", "        /** The resolved path to the private key. */\n        private final String keyPath;"),
    ("        /** Javadoc. */\n        public String getCertPath()", "        /**\n         * Returns the resolved path to the certificate.\n         *\n         * @return the actual path for the certificate on disk\n         */\n        public String getCertPath()"),
    ("        /** Javadoc. */\n        public String getKeyPath()", "        /**\n         * Returns the resolved path to the private key.\n         *\n         * @return the actual path for the private key on disk\n         */\n        public String getKeyPath()"),
    
    # Method Javadocs repairs for `@param` and `@return` requirements
    ("     * Resolves the paths for the certificate and private key based on the config path or well-known\n     * locations.\n     */\n    static ResolvedCertAndKeyPaths resolveCertAndKeyPaths(String certConfigPath)",
     "     * Resolves the paths for the certificate and private key based on the config path or well-known\n     * locations.\n     *\n     * @param certConfigPath the custom configuration path, if specified\n     * @return the resolved certificate and key paths\n     * @throws IOException if extracting from the configuration file encounters an error\n     */\n    static ResolvedCertAndKeyPaths resolveCertAndKeyPaths(String certConfigPath)"),
     
    ("     * Loads the certificate and private key, and verifies that they match if they are separate\n     * files.\n     */\n    static CertInfo loadAndVerifyCredentials(String certPath, String keyPath)",
     "     * Loads the certificate and private key, and verifies that they match if they are separate\n     * files.\n     *\n     * @param certPath the path to the certificate\n     * @param keyPath the path to the private key file\n     * @return parsed CertInfo containing the certificate and plaintext content, or null if unbound\n     * @throws IOException in case of a read or parse error\n     */\n    static CertInfo loadAndVerifyCredentials(String certPath, String keyPath)"),
     
    ("    /** Checks if a file exists, throwing AccessDeniedException if permission is denied. */\n    private static boolean checkExistsOrAccessDenied(java.nio.file.Path path)",
     "    /**\n     * Checks if a file exists, throwing AccessDeniedException if permission is denied.\n     *\n     * @param path the file path to verify\n     * @return true if the file exists and is accessible, false otherwise\n     * @throws java.nio.file.AccessDeniedException if permission is denied when accessing the file\n     */\n    private static boolean checkExistsOrAccessDenied(java.nio.file.Path path)"),
     
    ("    /**\n     * Checks if the user has disabled token binding by setting the environment variable to false.\n     */\n    private static boolean isTokenBindingEnabled()",
     "    /**\n     * Checks if the user has disabled token binding by setting the environment variable to false.\n     *\n     * @return true unless binding was explicitly disabled via environment configuration\n     */\n    private static boolean isTokenBindingEnabled()"),
     
    ("     * Reads the certificate path from the config file with retry logic to handle rotation race\n     * conditions.\n     */\n    private static ResolvedCertAndKeyPaths getPathsFromConfigWithRetry(String certConfigPath)",
     "     * Reads the certificate path from the config file with retry logic to handle rotation race\n     * conditions.\n     *\n     * @param certConfigPath the path to the certificate configuration file to read from\n     * @return the paths loaded and found from the config\n     * @throws IOException if config cannot be parsed or certificate files remain missing after retries\n     */\n    private static ResolvedCertAndKeyPaths getPathsFromConfigWithRetry(String certConfigPath)"),
     
    ("    /** Searches for certificates at well-known locations with retry logic. */\n    private static String getWellKnownCertificatePathWithRetry()",
     "    /**\n     * Searches for certificates at well-known locations with retry logic.\n     *\n     * @return the well-known certificate path resolving to a file\n     * @throws IOException if certificate files cannot be found after multiple retries\n     */\n    private static String getWellKnownCertificatePathWithRetry()"),

    ("    /** Reads the full certificate chain from the specified path as a string. */\n    static String readCertificateChain(String certPath)",
     "    /**\n     * Reads the full certificate chain from the specified path as a string.\n     *\n     * @param certPath the path to read\n     * @return the complete file contents as a UTF-8 string\n     * @throws IOException if the file encounters a read error\n     */\n    static String readCertificateChain(String certPath)"),
     
    ("     * Verifies that the private key corresponds to the public key in the certificate by performing\n     * a test signature and verification.\n     */\n    static boolean verifyKeyPair(X509Certificate cert, PrivateKey privateKey)",
     "     * Verifies that the private key corresponds to the public key in the certificate by performing\n     * a test signature and verification.\n     *\n     * @param cert the loaded certificate with the public key\n     * @param privateKey the private key to test against the public component\n     * @return true if the private key properly belongs to the presented public certificate\n     */\n    static boolean verifyKeyPair(X509Certificate cert, PrivateKey privateKey)"),
     
    ("    /** Reads the private key from the specified path using PKCS8 format. */\n    static PrivateKey readPrivateKey(String keyPath, String algorithm)",
     "    /**\n     * Reads the private key from the specified path using PKCS8 format.\n     *\n     * @param keyPath the path location to fetch the key\n     * @param algorithm the key's algorithm such as RSA or EC\n     * @return the parsed PrivateKey object\n     * @throws IOException if parsing PKCS8 encounters a formatting or reading issue\n     */\n    static PrivateKey readPrivateKey(String keyPath, String algorithm)"),
     
    ("     * Determines if mTLS should be enabled based on environment variables and certificate presence.\n     */\n    static boolean shouldEnableMtls(boolean certsPresent, boolean configExists)",
     "     * Determines if mTLS should be enabled based on environment variables and certificate presence.\n     *\n     * @param certsPresent indicates if certificates were already materialized on disk\n     * @param configExists indicates if a configuration path pointer was available\n     * @return true if token bound operations are approved via environment configuration\n     * @throws IOException if intents mismatch (explicit approval but missing files)\n     */\n    static boolean shouldEnableMtls(boolean certsPresent, boolean configExists)"),
     
    ("    /** Retrieves the bound token payload (certificate chain) if applicable. */\n    static String getBoundTokenPayload()",
     "    /**\n     * Retrieves the bound token payload (certificate chain) if applicable.\n     *\n     * @return the retrieved certificate and bounds string, or null if binding conditions are unmet\n     * @throws IOException if loading Agent Identity constraints fails\n     */\n    static String getBoundTokenPayload()"),
     
    ("    /** Extracts the certificate and private key paths from the JSON configuration file. */\n    private static ResolvedCertAndKeyPaths extractPathsFromConfig(String certConfigPath)",
     "    /**\n     * Extracts the certificate and private key paths from the JSON configuration file.\n     *\n     * @param certConfigPath the configuration file path intended to be parsed\n     * @return an object encapsulating resolved paths mapped from the definition\n     * @throws IOException if parsing JSON mapping encounters structural errors\n     */\n    private static ResolvedCertAndKeyPaths extractPathsFromConfig(String certConfigPath)"),
     
    ("    /** Parses the X509 certificate from the specified content string. */\n    private static X509Certificate parseCertificateContent(String certContent)",
     "    /**\n     * Parses the X509 certificate from the specified content string.\n     *\n     * @param certContent raw certificate string representing the X509 stream\n     * @return parsed resulting X509Certificate equivalent\n     * @throws IOException if certificate generation from the standard factory fails\n     */\n    private static X509Certificate parseCertificateContent(String certContent)"),
     
    ("     * Determines if a bound token should be requested by checking if any of the certificate's\n     * Subject Alternative Names (SANs) match allowed SPIFFE patterns.\n     */\n    static boolean shouldRequestBoundToken(X509Certificate cert)",
     "     * Determines if a bound token should be requested by checking if any of the certificate's\n     * Subject Alternative Names (SANs) match allowed SPIFFE patterns.\n     *\n     * @param cert the loaded leaf certificate referencing SAN details\n     * @return true if bindings dictate compliance with a verified SPIFFE pattern\n     */\n    static boolean shouldRequestBoundToken(X509Certificate cert)")

]

for old, new in replacements:
    if old not in content:
        print(f"Warning: could not find {repr(old)}")
    content = content.replace(old, new)

with open(file_path, 'w') as f:
    f.write(content)
print("Replacements done.")
