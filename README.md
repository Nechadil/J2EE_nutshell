Toy project which includes all the basic JEE techniques involved in the objectives of course JB183(EJB, JPA, JAX-RS, CDI, JMS, JAAS)

Local dev environment: eclispe + Tomcat9

Tomcat installation:

1. Create server in eclipse and import the server binary folder
2. Go to server properties and click switch location (change from metadata to where tomcat is installed)
3. Double click server and set server location to tomcat location
(2 and 3 are mandatory for the tomcat maven plugin to work. That's because the maven plugin needs the manager application inside the tomcat server, however this app does not exist in metadata repository)
4. In order to make the tomcat plugin work, a tomcat user needs to be created [link](http://tomcat.apache.org/tomcat-7.0-doc/manager-howto.html) with role `manager-script` granted. Then the credential should be input to the file pom.xml(what i used is *admin/admin*)

Application deployment
Once the server is started, execute `mvn tomcat7:deploy` for deployment or `mvn tomcat7:redeploy` for update