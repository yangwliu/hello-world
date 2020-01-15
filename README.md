# hello-world
just for study

# Jenkins
install Jenkins in local env

# Docker
install Docker in local env

# Run Pipeline
We should configure the Jenkins first, then we can create new item to run the pipeline.

## configure the Jenkins
### install Gradle
Manage Jenkins -> Global Tool Configuration ->Gradle

just use your local Gradle directory
    
### install Docker
Manage Jenkins -> Global Tool Configuration ->Docker

just use your local Docker directory

## create new item
https://jenkins.io/zh/doc/book/pipeline/getting-started/

参考上述文章使用本项目中的Jenkinsfile来构建流水线
