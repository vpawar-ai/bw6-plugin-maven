package com.tibco.bw.plugin.tests;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import com.tibco.bw.maven.plugin.module.BWModulePackageMojo;
import com.tibco.bw.maven.plugin.test.stub.SampleProjectProperties;


public class TestBWAModuleMojo extends AbstractMojoTestCase {
	
	
	private File pom;
	
	SampleProjectProperties prop = new SampleProjectProperties();
	protected void setUp() throws Exception {		
		super.setUp();
		pom = new File( prop.getModulepath(),"pom.xml" );
	
	}
	public void testexecute() throws Exception {
		try {

			assertNotNull( pom );
	        assertTrue( pom.exists()); 	      
	        BWModulePackageMojo myMojo =(BWModulePackageMojo) lookupMojo( "bwmodule", pom );
	        assertNotNull( myMojo );
	        
	         myMojo.execute();
			
			System.out.println("BW Module Packager Mojo finished execution.");
		} catch (IOException e) {
			e.printStackTrace();
			throw new MojoExecutionException("Error assembling JAR", e);
		} 
	}

	protected void tearDown() throws Exception {
			super.tearDown();
			
	}

	
	
}