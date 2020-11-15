provider "aws" {
  region = "us-east-1"
}

data "aws_ami" "amazon-linux-2" {
  most_recent = true
  owners = ["amazon"]
  filter {
    name   = "name"
    values = ["amzn2-ami-hvm-*-x86_64-ebs"]
  }
}

resource "aws_security_group" "ssh-ec2" {
  name        = "ssh-ec2"
  description = "Allow SSH traffice to EC2"

  ingress {
    description = "SSH Access"
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = var.ssh-ingress
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "ssh-ec2"
    service = "equatorial"
  }
}

resource "aws_instance" "equatorial" {
  ami           = data.aws_ami.amazon-linux-2.id
  vpc_security_group_ids = [aws_security_group.ssh-ec2.id]
  instance_type = "c5.2xlarge"
  key_name = "personal"
  tags = {
    Name = "equatorial"
    service = "equatorial"
  }
}

output "public_ip" {
  value = aws_instance.equatorial.public_ip
}