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
  enable_apis                 = true
  disable_services_on_destroy = false
  activate_apis               = [
    "sqladmin.googleapis.com",
    "bigqueryconnection.googleapis.com",
    "bigquery.googleapis.com",
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
  depends_on          = [module.project-services]
}
