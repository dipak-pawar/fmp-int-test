package io.openshift.booster;

import org.junit.Test;
import org.junit.Assert;

public class ClassLoaderTest {
    
    @Test
    public void should_not_load_maven() throws ClassNotFoundException {
         getClass().getClassLoader().loadClass("org.apache.maven.surefire.booter.ForkedBooter");
         Assert.assertFalse(isRunningFromMaven());
    }

    private boolean isRunningFromMaven() {
        try {
            getClass().getClassLoader().loadClass("org.apache.maven.surefire.booter.ForkedBooter");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

}
