def pipelines = [
    [name: 'DSL Jobs/DSL Job 1', scriptPath: 'm4/demo2/2.1/Jenkinsfile'],
    [name: 'DSL Jobs/DSL Job 2', scriptPath: 'm4/demo2/2.2/Jenkinsfile']
]

for(p in pipelines) {
	pipelineJob("${p.name}") {
	    definition {
	        cpsScm {
	            scm {
	                git {
	                  remote {
	                    name('github')
	                    url('https://github.com/ljupcokostic/jenkins-pipeline.git')
	                  }
	                  branch('master')
	                  extensions {
	                  	cloneOptions {
	                  	  shallow(true)
	                  	  depth(1)
						  noTags(true)
	                  	}
	                  }
	                }
	            }
	            scriptPath("${p.scriptPath}")
	        }
	    }
	    triggers {
	        cron('H H(1-8) * * *')
	    }
	}
}
