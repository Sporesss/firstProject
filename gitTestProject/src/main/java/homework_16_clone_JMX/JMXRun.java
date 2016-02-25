package homework_16_clone_JMX;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import java.lang.management.ManagementFactory;

public class JMXRun {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        Sheep cLoneMXBean = new Sheep("JMX sheep", 13, null);
        StandardMBean mBean = new StandardMBean(cLoneMXBean, CLoneMXBean.class);
        ObjectName objectName = new ObjectName("CloneMXBean:name = sheep");
        mBeanServer.registerMBean(mBean, objectName);

        while (true);
    }
}
