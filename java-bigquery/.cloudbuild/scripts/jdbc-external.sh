ROOT_FOLDER=$(git rev-parse --show-toplevel)

cd ${ROOT_FOLDER}
source .kokoro/common.sh
install_modules java-bigquery

cd ${ROOT_FOLDER}/java-bigquery/google-cloud-bigquery-jdbc/bigquery-external-jdbc-tests
make integration-test