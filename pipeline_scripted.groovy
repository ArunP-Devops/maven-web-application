node {

///var/lib/jenkins/hudson.tasks.Maven.xml
def mvn_home = tool name: "maven 3.8.5"
    stage ('checkoutscm'){
    //git branch: 'master',credentialsId: '0305b74e-bc5b-4fb3-a1a4-76b65fd27e62', url: 'https://github.com/MithunTechnologiesDevOps/maven-web-application.git'
    //git credentialsId: '0305b74e-bc5b-4fb3-a1a4-76b65fd27e62', url: 'https://github.com/ArunP-Devops/maven-web-application.git'
        checkout scm
    }//end of checkoutscm stage

    stage ('build'){
    sh "$mvn_home/bin/mvn clean package " 
    }//end of build stage

    stage ('SonarQube Report'){
    sh "$mvn_home/bin/mvn sonar:sonar " 
    }//end of sq

    stage ('Upload to Artifacts'){
    sh "$mvn_home/bin/mvn deploy " 
    }//end of Artifacts

    stage ('Deploy-to tomcat'){
    sshagent(['1a8d7d29-39c6-4e07-91ea-3b94e40ce74d']) {
    sh "scp -o StrictHostKeyChecking=no target/maven-web-application.war ec2-user@13.233.72.44:/home/apache-tomcat-9.0.59/webapps/"
    }
    }//end of Artifacts


}//end of node

 // mavne howe localteion "/var/lib/jenkins/tools/hudson.tasks.Maven_MavenInstallation/maneb_3.8.5/bin"
