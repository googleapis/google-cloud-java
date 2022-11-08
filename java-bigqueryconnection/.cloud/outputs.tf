output "db_name" {
  value = local.db_name
}

output "db_instance" {
  value = module.mysql-db.instance_name
}

output "db_password" {
  value     = module.mysql-db.generated_user_password
  sensitive = true
}
