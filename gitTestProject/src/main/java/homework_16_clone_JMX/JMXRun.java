package homework_16_clone_JMX;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class JMXRun {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        CLoneMXBean cLoneMXBean = new Sheep("JMX sheep", 13, null);
        ObjectName objectName = new ObjectName("CloneMBean:name = sheep");
        mBeanServer.registerMBean(cLoneMXBean, objectName);

        while (true);
    }
}
