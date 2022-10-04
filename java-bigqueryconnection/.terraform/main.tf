terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

module "project-services" {
  source = "terraform-google-modules/project-factory/google//modules/project_services"

  project_id                  = var.inputs.project_id
  enable_apis                 = var.inputs.should_enable_apis_on_apply
  disable_services_on_destroy = var.inputs.should_disable_apis_on_destroy
  activate_apis               = [
    "bigquery.googleapis.com",
    "bigqueryconnection.googleapis.com",
    "sqladmin.googleapis.com",
  ]
}

resource "random_id" "id" {
  byte_length = 3
}
locals {
  db_name = lower("mysql-db-${random_id.id.hex}")
}

module "mysql-db" {
  source              = "GoogleCloudPlatform/sql-db/google//modules/mysql"
  version             = "12.0.0"
  name                = local.db_name
  database_version    = "MYSQL_8_0"
  deletion_protection = false
  project_id          = var.inputs.project_id
  zone                = var.inputs.zone
  region              = var.inputs.region
  depends_on          = [module.project-services]
}
