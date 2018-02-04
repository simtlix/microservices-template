node {
    stage("scm") {
        git([url: 'https://github.com/simtlix/microservices-template.git', branch: 'master'])
    }
    stage("build") {
        docker.build("maven-build", "-f docker/maven/Dockerfile .").inside {
            sh("mvn -f template/pom.xml clean install")
        }
        def templateBuild = docker.build("template", "-f docker/template/Dockerfile .")
    }
}