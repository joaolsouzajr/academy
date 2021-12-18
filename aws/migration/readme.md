
Migration and Modernization Guide: https://application-migration-with-aws.workshop.aws

Your website URL
http://schwerin.buymyunicorns.com

This is the URL that is used by your customers (and by us to verify if your migration succeeded). DNS is automatically updated when you provide URL in the proper input field.

Source Environment
Webserver IP: 18.206.201.248
Webserver Username: ubuntu
Webserver SSH key (.pem): download here

If you're using Microsoft Windows OS, please convert the SSH key .pem file to ppk using PuttyGen and then use Putty to connect (more details can be found here).

Database Server IP: 3.80.197.126
Database Server Username: ubuntu
Database SSH key (.pem): download here

If you're using Microsoft Windows OS, please convert the SSH key .pem file to ppk using PuttyGen and then use Putty to connect (more details can be found here).

Database Username: wordpress-user
Database Password: AWSRocksSince2006
Database Port: 3306
Database 'root' Password: AWSRocksSince2006 (this user is accessible only from the localhost)

CloudEndure Migration
Console URL: https://console.cloudendure.com
Username: mgd-110@amazon.com
Password: MgnWS-user@Amazon19

CloudEndure AWS Credentials
IAM Access Key: AKIA2T2IEINR6NCMPA5X
IAM Secret Access Key: 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

AWS Application Migration Service
IAM Access Key ID: AKIA2T2IEINR4RI3FPOA
IAM Secret Access Key: 795tWyHBVZ9nVzRJYvMB6WGlxmCMcK3sG6Sro/FS


ssh -l USERNAME_HERE -i .ssh/yourkey.pem public-ec2-host

ssh -l ubuntu -i get_ssm_param.1 3.80.197.126


sudo mysql -u root -pAWSRocksSince2006

GRANT REPLICATION CLIENT ON *.* to 'wordpress-user';
GRANT REPLICATION SLAVE ON *.* to 'wordpress-user';
GRANT SUPER ON *.* to 'wordpress-user';
exit


sudo su - 
mkdir /var/lib/mysql/binlogs
chown -R mysql:mysql /var/lib/mysql/binlogs
exit
