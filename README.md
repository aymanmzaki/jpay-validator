# jpay-validator

#How to RUN
To run this project you can simply run the following command:

`docker run --name jpay-validator-dep -p 8080:8080 -d jpay-validator`

#BUILD

To build source code : 
 `mvn clean install`

Build docker image and tag it  : 
`docker build . -t TAGNAME`

Docker image contain a copy from sample.db

#Technology Stack

#Backend 
Spring boot , sqllite

#Frontend 
Thyemleaf Templating Engine  
