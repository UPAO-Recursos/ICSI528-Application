resource "aws_key_pair" "deployer" {
  key_name   = "deployer-key"
  public_key = var.ec2_ssh_public_key
}

resource "aws_instance" "example" {
  ami           = "ami-09040d770ffe2224f"
  instance_type = "t2.micro"
  key_name      = aws_key_pair.deployer.key_name
}

resource "aws_security_group" "instance" {
  name        = "instance-security-group"
  description = "Allow inbound traffic on ports 8001 and 8002"
  ingress {
    from_port   = 8001
    to_port     = 8002
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_network_interface_sg_attachment" "sg_attachment" {
  security_group_id    = aws_security_group.instance.id
  network_interface_id = aws_instance.example.primary_network_interface_id
}
