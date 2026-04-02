ROOT_FOLDER=$(git rev-parse --show-toplevel)

cd ${ROOT_FOLDER}
source .kokoro/common.sh
install_modules java-bigquery

cd ${ROOT_FOLDER}/java-bigquery/google-cloud-bigquery-jdbc/bigquery-external-jdbc-tests

# This pom.xml is using export vars for install
export JDBC_VERSION=$1;
JDBC_FOLDER=jdbc-driver
JDBC_ZIP_NAME="SimbaJDBCDriverforGoogleBigQuery42_${JDBC_VERSION}.zip"
JDBC_JAR_NAME=GoogleBigQueryJDBC42.jar
export JDBC_JAR_PATH="$(pwd)/${JDBC_FOLDER}/${JDBC_JAR_NAME}"

mkdir -p ${JDBC_FOLDER}
gsutil -m cp gs://bq-dev-tools-simba-drivers-testing/simba-jdbc/${JDBC_ZIP_NAME} ${JDBC_FOLDER}
unzip -p ./${JDBC_FOLDER}/${JDBC_ZIP_NAME} ${JDBC_JAR_NAME} > ${JDBC_JAR_PATH}

mvn -B -V -fae -q install
