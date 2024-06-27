output "aws_iam_role" {
  value = aws_instance.example.public_ip
}

output "security_group" {
  value = aws_instance.example.vpc_security_group_ids
}

output "instance_ip" {
  value = aws_instance.example.public_ip
}