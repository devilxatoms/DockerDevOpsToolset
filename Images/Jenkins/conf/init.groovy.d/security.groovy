#!groovy
import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()
def user = new File("/run/secrets/jenkins_user").text.trim()
def pass = new File("/run/secrets/jenkins_pass").text.trim()

println "--> creating local user 'admin'"

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount(user, pass)
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
instance.setAuthorizationStrategy(strategy)
instance.save()